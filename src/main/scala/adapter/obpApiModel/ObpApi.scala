package adapter.obpApiModel

import java.time.{Instant, LocalDateTime}
import java.util.Date

import adapter.{ObpAccountNotFoundException, ObpBankNotFoundException}
import akka.actor.ActorContext
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.{Authorization, GenericHttpCredentials}
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import akka.util.ByteString
import com.openbankproject.commons.model._
import com.typesafe.config.ConfigFactory
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.{Decoder, Json, JsonObject, parser}
import model.types.Bic

import scala.collection.immutable.Seq
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * This object is used to make calls to the OBP-API
 */

// TODO : refactor endpoints with extract method like in `getCounterpartyByIban`
object ObpApi {

  val hostName: String = ConfigFactory.load.getString("obp-api.hostname")
  val versionRoute = "/obp/v4.0.0"
  val endpointPrefix: String = hostName + versionRoute

  implicit val decodeDate: Decoder[Date] = Decoder.decodeString.map(dateString =>
    Date.from(Instant.parse(dateString))
  )

  def saveHistoricalTransaction(debtor: HistoricalTransactionAccountJsonV310, creditor: HistoricalTransactionAccountJsonV310, amount: BigDecimal, description: String)(implicit context: ActorContext): Future[PostHistoricalTransactionResponseJson] = {
    val dateTimeNow = LocalDateTime.now().format(PostHistoricalTransactionJson.jsonDateTimeFormatter)
    val historicalTransaction = PostHistoricalTransactionJson(
      from = debtor,
      to = creditor,
      value = AmountOfMoneyJsonV121(
        currency = "EUR",
        amount = amount.toString()
      ),
      description = description,
      posted = dateTimeNow,
      completed = dateTimeNow,
      `type` = "SEPA",
      charge_policy = "SHARED"
    )
    
    callObpApi(s"$endpointPrefix/management/historical/transactions", HttpMethods.POST, historicalTransaction.asJson.toString())
      .flatMap(json => Future.fromTry(json.as[PostHistoricalTransactionResponseJson].toTry))
  }

  // Maybe the bankId and the viewId should be returned by this function
  def getAccountIdByIban(bankId: BankId, viewId: ViewId, iban: Iban)(implicit context: ActorContext): Future[AccountId] = {
    val body = JsonObject.fromMap(Map(("iban", iban.iban.asJson))).asJson.toString()
    val callResult = callObpApi(s"$endpointPrefix/banks/${bankId.value}/accounts/${viewId.value}/account", HttpMethods.POST, body)

    callResult.flatMap {
      case jsonResult if (jsonResult \\ "id").headOption.flatMap(_.asString).isDefined =>
        Future.successful(AccountId((jsonResult \\ "id").headOption.flatMap(_.asString).get))
      case jsonResult if (jsonResult \\ "code").nonEmpty && (jsonResult \\ "message").nonEmpty =>
        val errorCode = (jsonResult \\ "code").headOption.flatMap(_.asNumber.flatMap(_.toInt))
        val errorMessage = (jsonResult \\ "message").headOption.flatMap(_.asString)
        (errorCode, errorMessage.flatMap(_.split(":").headOption)) match {
          case (Some(404), Some("OBP-30018")) =>
            Future.failed(new ObpAccountNotFoundException(errorMessage.getOrElse("")))
          case _ => Future.failed(new Exception(s"Unknow error in getObpAccountIdByIban: ${errorMessage.getOrElse("")}"))
        }
      case jsonResult => Future.failed(new Exception(s"Unknow error in getAccountIdByIban: $jsonResult"))
    }
  }

  def getBicByBankId(bankId: BankId)(implicit context: ActorContext): Future[Bic] = {
    val callResult = callObpApi(s"$endpointPrefix/banks/${bankId.value}", HttpMethods.GET)
    callResult.flatMap {
      case jsonResult if (jsonResult \\ "bank_routings").headOption.flatMap(_.asArray)
        .flatMap(_.find(bankRouting => (bankRouting \\ "scheme").headOption.flatMap(_.asString).contains("BIC"))).nonEmpty =>
        Future.successful((jsonResult \\ "bank_routings").headOption.flatMap(_.asArray)
          .flatMap(_.find(bankRouting => (bankRouting \\ "scheme").headOption.flatMap(_.asString).contains("BIC"))
            .flatMap(bankBicRouting => (bankBicRouting \\ "address").headOption.flatMap(_.asString))).map(Bic).get)
      case jsonResult if (jsonResult \\ "code").nonEmpty && (jsonResult \\ "message").nonEmpty =>
        val errorCode = (jsonResult \\ "code").headOption.flatMap(_.asNumber.flatMap(_.toInt))
        val errorMessage = (jsonResult \\ "message").headOption.flatMap(_.asString)
        (errorCode, errorMessage.flatMap(_.split(":").headOption)) match {
          case (Some(404), Some("OBP-30001")) =>
            Future.failed(new ObpBankNotFoundException(errorMessage.getOrElse("")))
          case _ => Future.failed(new Exception(s"Unknow error in getBicByBankId: ${errorMessage.getOrElse("")}"))
        }
      case jsonResult => Future.failed(new Exception(s"Unknow error in getBicByBankId: $jsonResult"))
    }
  }

  def getCounterpartyByIban(bankId: BankId, accountId: AccountId, iban: Iban)(implicit context: ActorContext): Future[Option[CounterpartyJson400]] =
    callObpApi(s"$endpointPrefix/banks/${bankId.value}/accounts/${accountId.value}/owner/counterparties", HttpMethods.GET)
      .flatMap(json => Future.fromTry(json.as[CounterpartiesJson400].toTry))
      .map(counterparties =>
        counterparties.counterparties.find(counterparty =>
          counterparty.other_account_secondary_routing_scheme == "IBAN" && counterparty.other_account_secondary_routing_address == iban.iban)
      )

  def createCounterparty(bankId: BankId, accountId: AccountId, name: String, iban: Iban, bic: Bic)(implicit context: ActorContext): Future[CounterpartyWithMetadataJson400] = {
    val counterparty = PostCounterpartyJson400(
      name = name,
      description = "Counterparty added automatically by SEPA Adapter",
      currency = "EUR",
      other_account_routing_scheme = "",
      other_account_routing_address = "",
      other_account_secondary_routing_scheme = "IBAN",
      other_account_secondary_routing_address = iban.iban,
      other_bank_routing_scheme = "BIC",
      other_bank_routing_address = bic.bic,
      other_branch_routing_scheme = "",
      other_branch_routing_address = "",
      is_beneficiary = true,
      bespoke = Nil
    )
    
    callObpApi(s"$endpointPrefix/banks/${bankId.value}/accounts/${accountId.value}/owner/counterparties",
      HttpMethods.POST, counterparty.asJson.toString())
      .flatMap(json => Future.fromTry(json.as[CounterpartyWithMetadataJson400].toTry))
  }

  def getOrCreateCounterparty(bankId: BankId, accountId: AccountId, name: String, iban: Iban, bic: Bic)(implicit context: ActorContext): Future[CounterpartyJson400] =
    for {
      maybeCounterparty <- getCounterpartyByIban(bankId, accountId, iban)
      counterparty <- maybeCounterparty match {
        case Some(counterparty) => Future.successful(counterparty)
        case None => createCounterparty(bankId, accountId, name, iban, bic).map(CounterpartyJson400.fromCounterpartyWithMetadataJson400)
      }
    } yield counterparty

  def createRefundTransactionRequest(bankId: BankId, accountId: AccountId, viewId: ViewId, refundTransactionRequest: RefundTransactionRequest)(implicit context: ActorContext): Future[TransactionRequestId] = {
    val body = refundTransactionRequest.asJson.toString()
    val callResult = callObpApi(s"$endpointPrefix/banks/${bankId.value}/accounts/${accountId.value}/${viewId.value}/transaction-request-types/REFUND/transaction-requests", HttpMethods.POST, body)
    callResult.map(println)
    callResult.flatMap {
      case jsonResult if (jsonResult \\ "id").headOption.flatMap(_.asString).isDefined =>
        Future.successful(TransactionRequestId((jsonResult \\ "id").headOption.flatMap(_.asString).get))
      case jsonResult if (jsonResult \\ "code").nonEmpty && (jsonResult \\ "message").nonEmpty =>
        val errorCode = (jsonResult \\ "code").headOption.flatMap(_.asNumber.flatMap(_.toInt))
        val errorMessage = (jsonResult \\ "message").headOption.flatMap(_.asString)
        (errorCode, errorMessage.flatMap(_.split(":").headOption)) match {
          case _ => Future.failed(new Exception(s"Unknow error in createRefundTransactionRequest: ${errorMessage.getOrElse("")}"))
        }
      case jsonResult => Future.failed(new Exception(s"Unknow error in createRefundTransactionRequest: $jsonResult"))
    }
  }

  def getTransactionRequestChallengeId(bankId: BankId, accountId: AccountId, viewId: ViewId, transactionRequestId: TransactionRequestId)(implicit context: ActorContext): Future[String] = {
    val callResult = callObpApi(s"$endpointPrefix/banks/${bankId.value}/accounts/${accountId.value}/${viewId.value}/transaction-requests/${transactionRequestId.value}", HttpMethods.GET)
    callResult.map(println)
    callResult.flatMap {
      case jsonResult if (jsonResult \\ "challenge").headOption.flatMap(challenge => (challenge \\ "id").headOption.flatMap(_.asString)).isDefined =>
        Future.successful((jsonResult \\ "challenge").headOption.flatMap(challenge => (challenge \\ "id").headOption.flatMap(_.asString)).get)
      case jsonResult if (jsonResult \\ "code").nonEmpty && (jsonResult \\ "message").nonEmpty =>
        val errorCode = (jsonResult \\ "code").headOption.flatMap(_.asNumber.flatMap(_.toInt))
        val errorMessage = (jsonResult \\ "message").headOption.flatMap(_.asString)
        (errorCode, errorMessage.flatMap(_.split(":").headOption)) match {
          case _ => Future.failed(new Exception(s"Unknow error in getTransactionRequestChallengeId: ${errorMessage.getOrElse("")}"))
        }
      case jsonResult => Future.failed(new Exception(s"No challenge Id in this transaction request : $jsonResult"))
    }
  }

  def answerTransactionRequestChallenge(bankId: BankId, accountId: AccountId, viewId: ViewId, transactionRequestId: TransactionRequestId, transactionRequestChallengeAnswer: TransactionRequestChallengeAnswer)(implicit context: ActorContext): Future[Option[TransactionId]] = {
    val body = transactionRequestChallengeAnswer.asJson.toString()
    val callResult = callObpApi(s"$endpointPrefix/banks/${bankId.value}/accounts/${accountId.value}/${viewId.value}/transaction-request-types/REFUND/transaction-requests/${transactionRequestId.value}/challenge", HttpMethods.POST, body)
    callResult.map(println)
    callResult.flatMap {
      case jsonResult if (jsonResult \\ "id").headOption.flatMap(_.asString).isDefined =>
        Future.successful((jsonResult \\ "transaction_ids").headOption
          .flatMap(_.asArray).flatMap(_.headOption).flatMap(_.asString).map(TransactionId(_)))
      case jsonResult if (jsonResult \\ "code").nonEmpty && (jsonResult \\ "message").nonEmpty =>
        val errorCode = (jsonResult \\ "code").headOption.flatMap(_.asNumber.flatMap(_.toInt))
        val errorMessage = (jsonResult \\ "message").headOption.flatMap(_.asString)
        (errorCode, errorMessage.flatMap(_.split(":").headOption)) match {
          case _ => Future.failed(new Exception(s"Unknow error in answerTransactionRequestChallenge: ${errorMessage.getOrElse("")}"))
        }
      case jsonResult => Future.failed(new Exception(s"Unknow error in answerTransactionRequestChallenge: $jsonResult"))
    }
  }

  private def callObpApi(uri: String, httpMethod: HttpMethod, body: String = "")(implicit context: ActorContext): Future[Json] = {
    implicit val materializer: ActorMaterializer = ActorMaterializer(ActorMaterializerSettings(context.system))

    Http(context.system).singleRequest(HttpRequest(
      method = httpMethod,
      uri = uri,
      headers = Seq(
        Authorization(GenericHttpCredentials("DirectLogin", s"token=${ConfigFactory.load().getString("obp-api.authorization.direct-login-token")}"))
      ),
      entity = HttpEntity(
        contentType = ContentTypes.`application/json`,
        body
      ))
    ).flatMap(_.entity.dataBytes.runFold(ByteString(""))(_ ++ _).map(body => body.utf8String).flatMap(response =>
      Future.fromTry(parser.parse(response).toTry)))
  }
}
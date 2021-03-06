// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package sepa.sct.generated.paymentReject

/** Account Identification 4ChoiceSpecifies the unique identification of an account as assigned by the account servicer.
*/
trait AccountIdentification4Choicable {
  def accountidentification4choicableoption: scalaxb.DataRecord[Any]
}


/** Account Identification 4ChoiceSpecifies the unique identification of an account as assigned by the account servicer.
*/
case class AccountIdentification4Choice(accountidentification4choicableoption: scalaxb.DataRecord[Any]) extends AccountIdentification4Choicable
      

trait AccountIdentification4ChoicableOption

case class AccountIdentification4Choice_EPC115u4506_SCT_IB_2019_V1u460(accountidentification4choicableoption: scalaxb.DataRecord[Any]) extends AccountIdentification4Choicable
      

trait AccountIdentification4Choice_EPC115u4506_SCT_IB_2019_V1u460Option

/** Account Scheme Name 1ChoiceSets of elements to identify a name of the identification scheme
*/
case class AccountSchemeName1Choice(accountschemename1choiceoption: scalaxb.DataRecord[Any])
      

trait AccountSchemeName1ChoiceOption

/** Active Or Historic Currency And AmountA number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
*/
trait ActiveOrHistoricCurrencyAndAmountable {
  def value: BigDecimal
  def Ccy: String
}


/** Active Or Historic Currency And AmountA number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
*/
case class ActiveOrHistoricCurrencyAndAmount(value: BigDecimal,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map.empty) extends ActiveOrHistoricCurrencyAndAmountable {
  lazy val Ccy = attributes("@Ccy").as[String]
}

      


case class ActiveOrHistoricCurrencyAndAmount_EPC115u4506_SCT_IB_2019_V1u460(value: BigDecimal,
  attributes: Map[String, scalaxb.DataRecord[Any]] = Map.empty) extends ActiveOrHistoricCurrencyAndAmountable {
  lazy val Ccy = attributes("@Ccy").as[String]
}

      

sealed trait ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460

object ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460 {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[sepa.sct.generated.paymentReject.ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460]): ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460 = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
  lazy val values: Seq[ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460] = Seq(EUR)
}

case object EUR extends ActiveOrHistoricCurrencyCode_EPC115u4506_SCT_IB_2019_V1u460 { override def toString = "EUR" }

/** Branch And Financial Institution Identification 4Set of elements used to uniquely and unambiguously identify a financial institution or a branch of a financial institution.
*/
trait BranchAndFinancialInstitutionIdentification4able {
  def FinInstnId: sepa.sct.generated.paymentReject.FinancialInstitutionIdentification7able
}


/** Branch And Financial Institution Identification 4Set of elements used to uniquely and unambiguously identify a financial institution or a branch of a financial institution.
*/
case class BranchAndFinancialInstitutionIdentification4(FinInstnId: sepa.sct.generated.paymentReject.FinancialInstitutionIdentification7able) extends BranchAndFinancialInstitutionIdentification4able
      


case class BranchAndFinancialInstitutionIdentification4_EPC115u4506_SCT_IB_2019_V1u460(FinInstnId: sepa.sct.generated.paymentReject.FinancialInstitutionIdentification7able) extends BranchAndFinancialInstitutionIdentification4able
      


/** Cash Account 16Set of elements used to identify an account.
*/
trait CashAccount16able {
  def Id: sepa.sct.generated.paymentReject.AccountIdentification4Choicable
}


/** Cash Account 16Set of elements used to identify an account.
*/
case class CashAccount16(Id: sepa.sct.generated.paymentReject.AccountIdentification4Choicable) extends CashAccount16able
      


case class CashAccount16_EPC115u4506_SCT_IB_2019_V1u460(Id: sepa.sct.generated.paymentReject.AccountIdentification4Choicable) extends CashAccount16able
      


/** Category Purpose 1Choice
Specifies the high level purpose of the instruction based on a set of pre-defined categories.
Usage: This is used by the initiating party to provide information concerning the processing of the payment. It is likely to trigger special processing by any of the agents involved in the payment chain.
      
*/
case class CategoryPurpose1Choice(categorypurpose1choiceoption: scalaxb.DataRecord[Any])
      

trait CategoryPurpose1ChoiceOption

/** Clearing System Identification 3ChoiceSpecifies the clearing system identification.
*/
case class ClearingSystemIdentification3Choice(clearingsystemidentification3choiceoption: scalaxb.DataRecord[Any])
      

trait ClearingSystemIdentification3ChoiceOption

/** Creditor Reference Information 2Reference information provided by the creditor to allow the identification of the underlying documents.
*/
trait CreditorReferenceInformation2able {
  def Tp: Option[sepa.sct.generated.paymentReject.CreditorReferenceType2]
  def Ref: Option[String]
}


/** Creditor Reference Information 2Reference information provided by the creditor to allow the identification of the underlying documents.
*/
case class CreditorReferenceInformation2(Tp: Option[sepa.sct.generated.paymentReject.CreditorReferenceType2] = None,
  Ref: Option[String] = None) extends CreditorReferenceInformation2able
      


case class CreditorReferenceInformation2_EPC115u4506_SCT_IB_2019_V1u460(Tp: Option[sepa.sct.generated.paymentReject.CreditorReferenceType2] = None,
  Ref: Option[String] = None) extends CreditorReferenceInformation2able
      


/** Creditor Reference Type 1ChoiceSpecifies the type of document referred by the creditor.
*/
case class CreditorReferenceType1Choice(creditorreferencetype1choiceoption: scalaxb.DataRecord[sepa.sct.generated.paymentReject.DocumentType3Code])
      

trait CreditorReferenceType1ChoiceOption

/** Creditor Reference Type 2Specifies the type of creditor reference.
*/
case class CreditorReferenceType2(CdOrPrtry: sepa.sct.generated.paymentReject.CreditorReferenceType1Choice,
  Issr: Option[String] = None)
      


/** Date And Place Of BirthDate and place of birth of a person.
*/
case class DateAndPlaceOfBirth(BirthDt: javax.xml.datatype.XMLGregorianCalendar,
  PrvcOfBirth: Option[String] = None,
  CityOfBirth: String,
  CtryOfBirth: String)
      


trait Documentable {
  def FIToFIPmtStsRpt: sepa.sct.generated.paymentReject.FIToFIPaymentStatusReportV03able
}


case class Document(FIToFIPmtStsRpt: sepa.sct.generated.paymentReject.FIToFIPaymentStatusReportV03able) extends Documentable
      

sealed trait DocumentType3Code

object DocumentType3Code {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[sepa.sct.generated.paymentReject.DocumentType3Code]): DocumentType3Code = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: DocumentType3Code) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
  lazy val values: Seq[DocumentType3Code] = Seq(SCOR)
}

case object SCOR extends DocumentType3Code { override def toString = "SCOR" }

case class Document_EPC115u4506_SCT_IB_2019_V1u460(FIToFIPmtStsRpt: sepa.sct.generated.paymentReject.FIToFIPaymentStatusReportV03able) extends Documentable
      

sealed trait ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460

object ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460 {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[sepa.sct.generated.paymentReject.ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460]): ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460 = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
  lazy val values: Seq[ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460] = Seq(SEPA)
}

case object SEPA extends ExternalServiceLevel1Code_EPC115u4506_SCT_IB_2019_V1u460 { override def toString = "SEPA" }

/** Financial Institution Identification 7Set of elements used to identify a financial institution.
*/
trait FinancialInstitutionIdentification7able {
  def BIC: Option[String]
}


/** Financial Institution Identification 7Set of elements used to identify a financial institution.
*/
case class FinancialInstitutionIdentification7(BIC: Option[String] = None) extends FinancialInstitutionIdentification7able
      


case class FinancialInstitutionIdentification7_EPC115u4506_SCT_IB_2019_V1u460(BIC: Option[String] = None) extends FinancialInstitutionIdentification7able
      


/** FITo FIPayment Status Report V03The PaymentInitiationStatusReport message is sent by an instructed agent to the payment initiator. It is used to inform this party about the positive or negative status of an instruction (either single, group or file). It is also used to report on a pending instruction.
*/
trait FIToFIPaymentStatusReportV03able {
  def GrpHdr: sepa.sct.generated.paymentReject.GroupHeader37able
  def OrgnlGrpInfAndSts: sepa.sct.generated.paymentReject.OriginalGroupInformation20able
  def TxInfAndSts: Seq[sepa.sct.generated.paymentReject.PaymentTransactionInformation26able]
}


/** FITo FIPayment Status Report V03The PaymentInitiationStatusReport message is sent by an instructed agent to the payment initiator. It is used to inform this party about the positive or negative status of an instruction (either single, group or file). It is also used to report on a pending instruction.
*/
case class FIToFIPaymentStatusReportV03(GrpHdr: sepa.sct.generated.paymentReject.GroupHeader37able,
  OrgnlGrpInfAndSts: sepa.sct.generated.paymentReject.OriginalGroupInformation20able,
  TxInfAndSts: Seq[sepa.sct.generated.paymentReject.PaymentTransactionInformation26able] = Nil) extends FIToFIPaymentStatusReportV03able
      


case class FIToFIPaymentStatusReportV03_EPC115u4506_SCT_IB_2019_V1u460(GrpHdr: sepa.sct.generated.paymentReject.GroupHeader37able,
  OrgnlGrpInfAndSts: sepa.sct.generated.paymentReject.OriginalGroupInformation20able,
  TxInfAndSts: Seq[sepa.sct.generated.paymentReject.PaymentTransactionInformation26able] = Nil) extends FIToFIPaymentStatusReportV03able
      


/** Generic Account Identification 1Information related to a generic account identification.
*/
case class GenericAccountIdentification1(Id: String,
  SchmeNm: Option[sepa.sct.generated.paymentReject.AccountSchemeName1Choice] = None,
  Issr: Option[String] = None) extends AccountIdentification4ChoicableOption
      


/** Generic Organisation Identification 1Information related to an identification, eg, party identification or account identification.
*/
case class GenericOrganisationIdentification1(Id: String,
  SchmeNm: Option[sepa.sct.generated.paymentReject.OrganisationIdentificationSchemeName1Choice] = None,
  Issr: Option[String] = None)
      


/** Generic Person Identification 1Information related to an identification, eg, party identification or account identification.
*/
case class GenericPersonIdentification1(Id: String,
  SchmeNm: Option[sepa.sct.generated.paymentReject.PersonIdentificationSchemeName1Choice] = None,
  Issr: Option[String] = None)
      


/** Group Header 37Set of characteristics shared by all individual transactions included in the message.
*/
trait GroupHeader37able {
  def MsgId: String
  def CreDtTm: javax.xml.datatype.XMLGregorianCalendar
  def InstgAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able]
  def InstdAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able]
}


/** Group Header 37Set of characteristics shared by all individual transactions included in the message.
*/
case class GroupHeader37(MsgId: String,
  CreDtTm: javax.xml.datatype.XMLGregorianCalendar,
  InstgAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  InstdAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None) extends GroupHeader37able
      


case class GroupHeader37_EPC115u4506_SCT_IB_2019_V1u460(MsgId: String,
  CreDtTm: javax.xml.datatype.XMLGregorianCalendar,
  InstgAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  InstdAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None) extends GroupHeader37able
      


/** Local Instrument 2ChoiceSet of elements that further identifies the type of local instruments being requested by the initiating party.
*/
case class LocalInstrument2Choice(localinstrument2choiceoption: scalaxb.DataRecord[Any])
      

trait LocalInstrument2ChoiceOption

/** Organisation Identification 4Unique and unambiguous way to identify an organisation.
*/
trait OrganisationIdentification4able extends Party6ChoicableOption {
  def BICOrBEI: Option[String]
  def Othr: Seq[sepa.sct.generated.paymentReject.GenericOrganisationIdentification1]
}


/** Organisation Identification 4Unique and unambiguous way to identify an organisation.
*/
case class OrganisationIdentification4(BICOrBEI: Option[String] = None,
  Othr: Seq[sepa.sct.generated.paymentReject.GenericOrganisationIdentification1] = Nil) extends OrganisationIdentification4able
      


case class OrganisationIdentification4_EPC115u4506_SCT_IB_2019_V1u460(BICOrBEI: Option[String] = None,
  Othr: Seq[sepa.sct.generated.paymentReject.GenericOrganisationIdentification1] = Nil) extends OrganisationIdentification4able with Party6Choice_EPC115u4506_SCT_IB_2019_V1u460Option
      


case class OrganisationIdentification4_EPC115u4506_SCT_IB_2019_V1u460_2(BICOrBEI: Option[String] = None,
  Othr: Seq[sepa.sct.generated.paymentReject.GenericOrganisationIdentification1] = Nil) extends OrganisationIdentification4able with Party6Choice_EPC115u4506_SCT_IB_2019_V1u460_2Option
      


/** Organisation Identification Scheme Name 1ChoiceSets of elements to identify a name of the organisation identification scheme.
*/
case class OrganisationIdentificationSchemeName1Choice(organisationidentificationschemename1choiceoption: scalaxb.DataRecord[Any])
      

trait OrganisationIdentificationSchemeName1ChoiceOption

/** Original Group Information 20Set of elements used to provide information on the original group, to which the message refers.
*/
trait OriginalGroupInformation20able {
  def OrgnlMsgId: String
  def OrgnlMsgNmId: String
  def GrpSts: Option[sepa.sct.generated.paymentReject.TransactionGroupStatus3Code]
  def StsRsnInf: Seq[sepa.sct.generated.paymentReject.StatusReasonInformation8able]
}


/** Original Group Information 20Set of elements used to provide information on the original group, to which the message refers.
*/
case class OriginalGroupInformation20(OrgnlMsgId: String,
  OrgnlMsgNmId: String,
  GrpSts: Option[sepa.sct.generated.paymentReject.TransactionGroupStatus3Code] = None,
  StsRsnInf: Seq[sepa.sct.generated.paymentReject.StatusReasonInformation8able] = Nil) extends OriginalGroupInformation20able
      


case class OriginalGroupInformation20_EPC115u4506_SCT_IB_2019_V1u460(OrgnlMsgId: String,
  OrgnlMsgNmId: String,
  GrpSts: Option[sepa.sct.generated.paymentReject.TransactionGroupStatus3Code] = None,
  StsRsnInf: Seq[sepa.sct.generated.paymentReject.StatusReasonInformation8able] = Nil) extends OriginalGroupInformation20able
      


/** Original Transaction Reference 13Set of key elements used to refer the original transaction.
*/
trait OriginalTransactionReference13able {
  def IntrBkSttlmAmt: Option[sepa.sct.generated.paymentReject.ActiveOrHistoricCurrencyAndAmountable]
  def IntrBkSttlmDt: Option[javax.xml.datatype.XMLGregorianCalendar]
  def SttlmInf: Option[sepa.sct.generated.paymentReject.SettlementInformation13]
  def PmtTpInf: Option[sepa.sct.generated.paymentReject.PaymentTypeInformation22able]
  def RmtInf: Option[sepa.sct.generated.paymentReject.RemittanceInformation5able]
  def UltmtDbtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able]
  def Dbtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able]
  def DbtrAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able]
  def DbtrAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able]
  def CdtrAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able]
  def Cdtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able]
  def CdtrAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able]
  def UltmtCdtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able]
}


/** Original Transaction Reference 13Set of key elements used to refer the original transaction.
*/
case class OriginalTransactionReference13(IntrBkSttlmAmt: Option[sepa.sct.generated.paymentReject.ActiveOrHistoricCurrencyAndAmountable] = None,
  IntrBkSttlmDt: Option[javax.xml.datatype.XMLGregorianCalendar] = None,
  SttlmInf: Option[sepa.sct.generated.paymentReject.SettlementInformation13] = None,
  PmtTpInf: Option[sepa.sct.generated.paymentReject.PaymentTypeInformation22able] = None,
  RmtInf: Option[sepa.sct.generated.paymentReject.RemittanceInformation5able] = None,
  UltmtDbtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  Dbtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  DbtrAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able] = None,
  DbtrAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  CdtrAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  Cdtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  CdtrAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able] = None,
  UltmtCdtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None) extends OriginalTransactionReference13able
      


case class OriginalTransactionReference13_EPC115u4506_SCT_IB_2019_V1u460(IntrBkSttlmAmt: Option[sepa.sct.generated.paymentReject.ActiveOrHistoricCurrencyAndAmountable] = None,
  IntrBkSttlmDt: Option[javax.xml.datatype.XMLGregorianCalendar] = None,
  SttlmInf: Option[sepa.sct.generated.paymentReject.SettlementInformation13] = None,
  PmtTpInf: Option[sepa.sct.generated.paymentReject.PaymentTypeInformation22able] = None,
  RmtInf: Option[sepa.sct.generated.paymentReject.RemittanceInformation5able] = None,
  UltmtDbtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  Dbtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  DbtrAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able] = None,
  DbtrAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  CdtrAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  Cdtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  CdtrAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able] = None,
  UltmtCdtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None) extends OriginalTransactionReference13able
      


/** Party 6ChoiceNature or use of the account.
*/
trait Party6Choicable {
  def party6choicableoption: scalaxb.DataRecord[sepa.sct.generated.paymentReject.Party6ChoicableOption]
}


/** Party 6ChoiceNature or use of the account.
*/
case class Party6Choice(party6choicableoption: scalaxb.DataRecord[sepa.sct.generated.paymentReject.Party6ChoicableOption]) extends Party6Choicable
      

trait Party6ChoicableOption

case class Party6Choice_EPC115u4506_SCT_IB_2019_V1u460(party6choicableoption: scalaxb.DataRecord[sepa.sct.generated.paymentReject.Party6ChoicableOption]) extends Party6Choicable
      

trait Party6Choice_EPC115u4506_SCT_IB_2019_V1u460Option

case class Party6Choice_EPC115u4506_SCT_IB_2019_V1u460_2(party6choicableoption: scalaxb.DataRecord[sepa.sct.generated.paymentReject.Party6ChoicableOption]) extends Party6Choicable
      

trait Party6Choice_EPC115u4506_SCT_IB_2019_V1u460_2Option

/** Party Identification 32Set of elements used to identify a person or an organisation.
*/
trait PartyIdentification32able {
  def Nm: Option[String]
  def PstlAdr: Option[sepa.sct.generated.paymentReject.PostalAddress6able]
  def Id: Option[sepa.sct.generated.paymentReject.Party6Choicable]
}


/** Party Identification 32Set of elements used to identify a person or an organisation.
*/
case class PartyIdentification32(Nm: Option[String] = None,
  PstlAdr: Option[sepa.sct.generated.paymentReject.PostalAddress6able] = None,
  Id: Option[sepa.sct.generated.paymentReject.Party6Choicable] = None) extends PartyIdentification32able
      


case class PartyIdentification32_EPC115u4506_SCT_IB_2019_V1u460(Nm: Option[String] = None,
  PstlAdr: Option[sepa.sct.generated.paymentReject.PostalAddress6able] = None,
  Id: Option[sepa.sct.generated.paymentReject.Party6Choicable] = None) extends PartyIdentification32able
      


case class PartyIdentification32_EPC115u4506_SCT_IB_2019_V1u460_2(Nm: Option[String] = None,
  PstlAdr: Option[sepa.sct.generated.paymentReject.PostalAddress6able] = None,
  Id: Option[sepa.sct.generated.paymentReject.Party6Choicable] = None) extends PartyIdentification32able
      


case class PartyIdentification32_EPC115u4506_SCT_IB_2019_V1u460_3(Nm: Option[String] = None,
  PstlAdr: Option[sepa.sct.generated.paymentReject.PostalAddress6able] = None,
  Id: Option[sepa.sct.generated.paymentReject.Party6Choicable] = None) extends PartyIdentification32able
      


/** Payment Transaction Information 26Set of elements used to provide information on the original transactions, to which the status report message refers.
*/
trait PaymentTransactionInformation26able {
  def StsId: Option[String]
  def OrgnlInstrId: Option[String]
  def OrgnlEndToEndId: Option[String]
  def OrgnlTxId: Option[String]
  def TxSts: Option[sepa.sct.generated.paymentReject.TransactionIndividualStatus3Code]
  def StsRsnInf: Seq[sepa.sct.generated.paymentReject.StatusReasonInformation8able]
  def InstgAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able]
  def InstdAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able]
  def OrgnlTxRef: Option[sepa.sct.generated.paymentReject.OriginalTransactionReference13able]
}


/** Payment Transaction Information 26Set of elements used to provide information on the original transactions, to which the status report message refers.
*/
case class PaymentTransactionInformation26(StsId: Option[String] = None,
  OrgnlInstrId: Option[String] = None,
  OrgnlEndToEndId: Option[String] = None,
  OrgnlTxId: Option[String] = None,
  TxSts: Option[sepa.sct.generated.paymentReject.TransactionIndividualStatus3Code] = None,
  StsRsnInf: Seq[sepa.sct.generated.paymentReject.StatusReasonInformation8able] = Nil,
  InstgAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  InstdAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  OrgnlTxRef: Option[sepa.sct.generated.paymentReject.OriginalTransactionReference13able] = None) extends PaymentTransactionInformation26able
      


case class PaymentTransactionInformation26_EPC115u4506_SCT_IB_2019_V1u460(StsId: Option[String] = None,
  OrgnlInstrId: Option[String] = None,
  OrgnlEndToEndId: Option[String] = None,
  OrgnlTxId: Option[String] = None,
  TxSts: Option[sepa.sct.generated.paymentReject.TransactionIndividualStatus3Code] = None,
  StsRsnInf: Seq[sepa.sct.generated.paymentReject.StatusReasonInformation8able] = Nil,
  InstgAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  InstdAgt: Option[sepa.sct.generated.paymentReject.BranchAndFinancialInstitutionIdentification4able] = None,
  OrgnlTxRef: Option[sepa.sct.generated.paymentReject.OriginalTransactionReference13able] = None) extends PaymentTransactionInformation26able
      


/** Payment Type Information 22Set of elements used to provide further details of the type of payment.
*/
trait PaymentTypeInformation22able {
  def SvcLvl: Option[sepa.sct.generated.paymentReject.ServiceLevel8Choicable]
  def LclInstrm: Option[sepa.sct.generated.paymentReject.LocalInstrument2Choice]
  def CtgyPurp: Option[sepa.sct.generated.paymentReject.CategoryPurpose1Choice]
}


/** Payment Type Information 22Set of elements used to provide further details of the type of payment.
*/
case class PaymentTypeInformation22(SvcLvl: Option[sepa.sct.generated.paymentReject.ServiceLevel8Choicable] = None,
  LclInstrm: Option[sepa.sct.generated.paymentReject.LocalInstrument2Choice] = None,
  CtgyPurp: Option[sepa.sct.generated.paymentReject.CategoryPurpose1Choice] = None) extends PaymentTypeInformation22able
      


case class PaymentTypeInformation22_EPC115u4506_SCT_IB_2019_V1u460(SvcLvl: Option[sepa.sct.generated.paymentReject.ServiceLevel8Choicable] = None,
  LclInstrm: Option[sepa.sct.generated.paymentReject.LocalInstrument2Choice] = None,
  CtgyPurp: Option[sepa.sct.generated.paymentReject.CategoryPurpose1Choice] = None) extends PaymentTypeInformation22able
      


/** Person Identification 5Unique and unambiguous way to identify a person.
*/
trait PersonIdentification5able extends Party6ChoicableOption {
  def DtAndPlcOfBirth: Option[sepa.sct.generated.paymentReject.DateAndPlaceOfBirth]
  def Othr: Seq[sepa.sct.generated.paymentReject.GenericPersonIdentification1]
}


/** Person Identification 5Unique and unambiguous way to identify a person.
*/
case class PersonIdentification5(DtAndPlcOfBirth: Option[sepa.sct.generated.paymentReject.DateAndPlaceOfBirth] = None,
  Othr: Seq[sepa.sct.generated.paymentReject.GenericPersonIdentification1] = Nil) extends PersonIdentification5able
      


case class PersonIdentification5_EPC115u4506_SCT_IB_2019_V1u460(DtAndPlcOfBirth: Option[sepa.sct.generated.paymentReject.DateAndPlaceOfBirth] = None,
  Othr: Seq[sepa.sct.generated.paymentReject.GenericPersonIdentification1] = Nil) extends PersonIdentification5able with Party6Choice_EPC115u4506_SCT_IB_2019_V1u460_2Option
      


/** Person Identification Scheme Name 1ChoiceSets of elements to identify a name of the identification scheme.
*/
case class PersonIdentificationSchemeName1Choice(personidentificationschemename1choiceoption: scalaxb.DataRecord[Any])
      

trait PersonIdentificationSchemeName1ChoiceOption

/** Postal Address 6Information that locates and identifies a specific address, as defined by postal services.
*/
trait PostalAddress6able {
  def Ctry: Option[String]
  def AdrLine: Seq[String]
}


/** Postal Address 6Information that locates and identifies a specific address, as defined by postal services.
*/
case class PostalAddress6(Ctry: Option[String] = None,
  AdrLine: Seq[String] = Nil) extends PostalAddress6able
      


case class PostalAddress6_EPC115u4506_SCT_IB_2019_V1u460(Ctry: Option[String] = None,
  AdrLine: Seq[String] = Nil) extends PostalAddress6able
      


/** Remittance Information 5Information supplied to enable the matching/reconciliation of an entry with the items that the payment is intended to settle, such as commercial invoices in an accounts' receivable system.
*/
trait RemittanceInformation5able {
  def Ustrd: Seq[String]
  def Strd: Seq[sepa.sct.generated.paymentReject.StructuredRemittanceInformation7able]
}


/** Remittance Information 5Information supplied to enable the matching/reconciliation of an entry with the items that the payment is intended to settle, such as commercial invoices in an accounts' receivable system.
*/
case class RemittanceInformation5(Ustrd: Seq[String] = Nil,
  Strd: Seq[sepa.sct.generated.paymentReject.StructuredRemittanceInformation7able] = Nil) extends RemittanceInformation5able
      


case class RemittanceInformation5_EPC115u4506_SCT_IB_2019_V1u460(Ustrd: Seq[String] = Nil,
  Strd: Seq[sepa.sct.generated.paymentReject.StructuredRemittanceInformation7able] = Nil) extends RemittanceInformation5able
      


/** Service Level 8ChoiceSpecifies the service level of the transaction.
*/
trait ServiceLevel8Choicable {
  def servicelevel8choicableoption: scalaxb.DataRecord[String]
}


/** Service Level 8ChoiceSpecifies the service level of the transaction.
*/
case class ServiceLevel8Choice(servicelevel8choicableoption: scalaxb.DataRecord[String]) extends ServiceLevel8Choicable
      

trait ServiceLevel8ChoicableOption

case class ServiceLevel8Choice_EPC115u4506_SCT_IB_2019_V1u460(servicelevel8choicableoption: scalaxb.DataRecord[String]) extends ServiceLevel8Choicable
      

trait ServiceLevel8Choice_EPC115u4506_SCT_IB_2019_V1u460Option

/** Settlement Information 13Set of elements used to provide information on the settlement of the instruction.
*/
case class SettlementInformation13(SttlmMtd: sepa.sct.generated.paymentReject.SettlementMethod1Code,
  SttlmAcct: Option[sepa.sct.generated.paymentReject.CashAccount16able] = None,
  ClrSys: Option[sepa.sct.generated.paymentReject.ClearingSystemIdentification3Choice] = None)
      

sealed trait SettlementMethod1Code

object SettlementMethod1Code {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[sepa.sct.generated.paymentReject.SettlementMethod1Code]): SettlementMethod1Code = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: SettlementMethod1Code) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
  lazy val values: Seq[SettlementMethod1Code] = Seq(CLRG, INDA, INGA)
}

case object CLRG extends SettlementMethod1Code { override def toString = "CLRG" }
case object INDA extends SettlementMethod1Code { override def toString = "INDA" }
case object INGA extends SettlementMethod1Code { override def toString = "INGA" }


/** Status Reason 6ChoiceSpecifies the reason for the status of the transaction.
*/
trait StatusReason6Choicable {
  def statusreason6choicableoption: scalaxb.DataRecord[String]
}


/** Status Reason 6ChoiceSpecifies the reason for the status of the transaction.
*/
case class StatusReason6Choice(statusreason6choicableoption: scalaxb.DataRecord[String]) extends StatusReason6Choicable
      

trait StatusReason6ChoicableOption

case class StatusReason6Choice_EPC115u4506_SCT_IB_2019_V1u460(statusreason6choicableoption: scalaxb.DataRecord[String]) extends StatusReason6Choicable
      

trait StatusReason6Choice_EPC115u4506_SCT_IB_2019_V1u460Option

/** Status Reason Information 8Set of elements used to provide information on the status reason of the transaction.
*/
trait StatusReasonInformation8able {
  def Orgtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able]
  def Rsn: Option[sepa.sct.generated.paymentReject.StatusReason6Choicable]
}


/** Status Reason Information 8Set of elements used to provide information on the status reason of the transaction.
*/
case class StatusReasonInformation8(Orgtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  Rsn: Option[sepa.sct.generated.paymentReject.StatusReason6Choicable] = None) extends StatusReasonInformation8able
      


case class StatusReasonInformation8_EPC115u4506_SCT_IB_2019_V1u460(Orgtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  Rsn: Option[sepa.sct.generated.paymentReject.StatusReason6Choicable] = None) extends StatusReasonInformation8able
      


case class StatusReasonInformation8_EPC115u4506_SCT_IB_2019_V1u460_2(Orgtr: Option[sepa.sct.generated.paymentReject.PartyIdentification32able] = None,
  Rsn: Option[sepa.sct.generated.paymentReject.StatusReason6Choicable] = None) extends StatusReasonInformation8able
      


/** Structured Remittance Information 7Information supplied to enable the matching/reconciliation of an entry with the items that the payment is intended to settle, such as commercial invoices in an accounts' receivable system, in a structured form.
*/
trait StructuredRemittanceInformation7able {
  def CdtrRefInf: Option[sepa.sct.generated.paymentReject.CreditorReferenceInformation2able]
}


/** Structured Remittance Information 7Information supplied to enable the matching/reconciliation of an entry with the items that the payment is intended to settle, such as commercial invoices in an accounts' receivable system, in a structured form.
*/
case class StructuredRemittanceInformation7(CdtrRefInf: Option[sepa.sct.generated.paymentReject.CreditorReferenceInformation2able] = None) extends StructuredRemittanceInformation7able
      


case class StructuredRemittanceInformation7_EPC115u4506_SCT_IB_2019_V1u460(CdtrRefInf: Option[sepa.sct.generated.paymentReject.CreditorReferenceInformation2able] = None) extends StructuredRemittanceInformation7able
      

sealed trait TransactionGroupStatus3Code

object TransactionGroupStatus3Code {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[sepa.sct.generated.paymentReject.TransactionGroupStatus3Code]): TransactionGroupStatus3Code = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: TransactionGroupStatus3Code) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
  lazy val values: Seq[TransactionGroupStatus3Code] = Seq(PART, RJCTValue)
}

case object PART extends TransactionGroupStatus3Code { override def toString = "PART" }
case object RJCTValue extends TransactionGroupStatus3Code { override def toString = "RJCT" }

sealed trait TransactionIndividualStatus3Code

object TransactionIndividualStatus3Code {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[sepa.sct.generated.paymentReject.TransactionIndividualStatus3Code]): TransactionIndividualStatus3Code = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: TransactionIndividualStatus3Code) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
  lazy val values: Seq[TransactionIndividualStatus3Code] = Seq(RJCT)
}

case object RJCT extends TransactionIndividualStatus3Code { override def toString = "RJCT" }

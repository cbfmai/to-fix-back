package org.tomac.protocol.fix.messaging;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;

public class FixMessageParser implements FixMessageInfo
{
        private FixMessagePool<FixMessage> fixMessagePool;

        public FixMessageParser(FixMessagePool<FixMessage> fixMessagePool) {
		this.fixMessagePool = fixMessagePool;
        }

        public FixMessageParser() {
		fixMessagePool = new FixMessagePool<FixMessage>();
        }

	public void parse( ByteBuffer buf, FixValidationError err, FixMessageListener l )
	{

		int msgType = FixInMessage.crackMsgType( buf ,err );

		// garbled message
		if (err.hasError()) return; 

        switch( msgType )
        {

		case MessageTypes.HEARTBEAT_INT:
			FixHeartbeat fixHeartbeat = fixMessagePool.getFixHeartbeat(buf, err);
			l.onFixHeartbeat(fixHeartbeat);
			fixMessagePool.returnFixHeartbeat (fixHeartbeat);
			break;
		case MessageTypes.TESTREQUEST_INT:
			FixTestRequest fixTestRequest = fixMessagePool.getFixTestRequest(buf, err);
			l.onFixTestRequest(fixTestRequest);
			fixMessagePool.returnFixTestRequest (fixTestRequest);
			break;
		case MessageTypes.RESENDREQUEST_INT:
			FixResendRequest fixResendRequest = fixMessagePool.getFixResendRequest(buf, err);
			l.onFixResendRequest(fixResendRequest);
			fixMessagePool.returnFixResendRequest (fixResendRequest);
			break;
		case MessageTypes.REJECT_INT:
			FixReject fixReject = fixMessagePool.getFixReject(buf, err);
			l.onFixReject(fixReject);
			fixMessagePool.returnFixReject (fixReject);
			break;
		case MessageTypes.SEQUENCERESET_INT:
			FixSequenceReset fixSequenceReset = fixMessagePool.getFixSequenceReset(buf, err);
			l.onFixSequenceReset(fixSequenceReset);
			fixMessagePool.returnFixSequenceReset (fixSequenceReset);
			break;
		case MessageTypes.LOGOUT_INT:
			FixLogout fixLogout = fixMessagePool.getFixLogout(buf, err);
			l.onFixLogout(fixLogout);
			fixMessagePool.returnFixLogout (fixLogout);
			break;
		case MessageTypes.IOI_INT:
			FixIOI fixIOI = fixMessagePool.getFixIOI(buf, err);
			l.onFixIOI(fixIOI);
			fixMessagePool.returnFixIOI (fixIOI);
			break;
		case MessageTypes.ADVERTISEMENT_INT:
			FixAdvertisement fixAdvertisement = fixMessagePool.getFixAdvertisement(buf, err);
			l.onFixAdvertisement(fixAdvertisement);
			fixMessagePool.returnFixAdvertisement (fixAdvertisement);
			break;
		case MessageTypes.EXECUTIONREPORT_INT:
			FixExecutionReport fixExecutionReport = fixMessagePool.getFixExecutionReport(buf, err);
			l.onFixExecutionReport(fixExecutionReport);
			fixMessagePool.returnFixExecutionReport (fixExecutionReport);
			break;
		case MessageTypes.ORDERCANCELREJECT_INT:
			FixOrderCancelReject fixOrderCancelReject = fixMessagePool.getFixOrderCancelReject(buf, err);
			l.onFixOrderCancelReject(fixOrderCancelReject);
			fixMessagePool.returnFixOrderCancelReject (fixOrderCancelReject);
			break;
		case MessageTypes.LOGON_INT:
			FixLogon fixLogon = fixMessagePool.getFixLogon(buf, err);
			l.onFixLogon(fixLogon);
			fixMessagePool.returnFixLogon (fixLogon);
			break;
		case MessageTypes.NEWS_INT:
			FixNews fixNews = fixMessagePool.getFixNews(buf, err);
			l.onFixNews(fixNews);
			fixMessagePool.returnFixNews (fixNews);
			break;
		case MessageTypes.EMAIL_INT:
			FixEmail fixEmail = fixMessagePool.getFixEmail(buf, err);
			l.onFixEmail(fixEmail);
			fixMessagePool.returnFixEmail (fixEmail);
			break;
		case MessageTypes.NEWORDERSINGLE_INT:
			FixNewOrderSingle fixNewOrderSingle = fixMessagePool.getFixNewOrderSingle(buf, err);
			l.onFixNewOrderSingle(fixNewOrderSingle);
			fixMessagePool.returnFixNewOrderSingle (fixNewOrderSingle);
			break;
		case MessageTypes.NEWORDERLIST_INT:
			FixNewOrderList fixNewOrderList = fixMessagePool.getFixNewOrderList(buf, err);
			l.onFixNewOrderList(fixNewOrderList);
			fixMessagePool.returnFixNewOrderList (fixNewOrderList);
			break;
		case MessageTypes.ORDERCANCELREQUEST_INT:
			FixOrderCancelRequest fixOrderCancelRequest = fixMessagePool.getFixOrderCancelRequest(buf, err);
			l.onFixOrderCancelRequest(fixOrderCancelRequest);
			fixMessagePool.returnFixOrderCancelRequest (fixOrderCancelRequest);
			break;
		case MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
			FixOrderCancelReplaceRequest fixOrderCancelReplaceRequest = fixMessagePool.getFixOrderCancelReplaceRequest(buf, err);
			l.onFixOrderCancelReplaceRequest(fixOrderCancelReplaceRequest);
			fixMessagePool.returnFixOrderCancelReplaceRequest (fixOrderCancelReplaceRequest);
			break;
		case MessageTypes.ORDERSTATUSREQUEST_INT:
			FixOrderStatusRequest fixOrderStatusRequest = fixMessagePool.getFixOrderStatusRequest(buf, err);
			l.onFixOrderStatusRequest(fixOrderStatusRequest);
			fixMessagePool.returnFixOrderStatusRequest (fixOrderStatusRequest);
			break;
		case MessageTypes.ALLOCATIONINSTRUCTION_INT:
			FixAllocationInstruction fixAllocationInstruction = fixMessagePool.getFixAllocationInstruction(buf, err);
			l.onFixAllocationInstruction(fixAllocationInstruction);
			fixMessagePool.returnFixAllocationInstruction (fixAllocationInstruction);
			break;
		case MessageTypes.LISTCANCELREQUEST_INT:
			FixListCancelRequest fixListCancelRequest = fixMessagePool.getFixListCancelRequest(buf, err);
			l.onFixListCancelRequest(fixListCancelRequest);
			fixMessagePool.returnFixListCancelRequest (fixListCancelRequest);
			break;
		case MessageTypes.LISTEXECUTE_INT:
			FixListExecute fixListExecute = fixMessagePool.getFixListExecute(buf, err);
			l.onFixListExecute(fixListExecute);
			fixMessagePool.returnFixListExecute (fixListExecute);
			break;
		case MessageTypes.LISTSTATUSREQUEST_INT:
			FixListStatusRequest fixListStatusRequest = fixMessagePool.getFixListStatusRequest(buf, err);
			l.onFixListStatusRequest(fixListStatusRequest);
			fixMessagePool.returnFixListStatusRequest (fixListStatusRequest);
			break;
		case MessageTypes.LISTSTATUS_INT:
			FixListStatus fixListStatus = fixMessagePool.getFixListStatus(buf, err);
			l.onFixListStatus(fixListStatus);
			fixMessagePool.returnFixListStatus (fixListStatus);
			break;
		case MessageTypes.ALLOCATIONINSTRUCTIONACK_INT:
			FixAllocationInstructionAck fixAllocationInstructionAck = fixMessagePool.getFixAllocationInstructionAck(buf, err);
			l.onFixAllocationInstructionAck(fixAllocationInstructionAck);
			fixMessagePool.returnFixAllocationInstructionAck (fixAllocationInstructionAck);
			break;
		case MessageTypes.DONTKNOWTRADEDK_INT:
			FixDontKnowTradeDK fixDontKnowTradeDK = fixMessagePool.getFixDontKnowTradeDK(buf, err);
			l.onFixDontKnowTradeDK(fixDontKnowTradeDK);
			fixMessagePool.returnFixDontKnowTradeDK (fixDontKnowTradeDK);
			break;
		case MessageTypes.QUOTEREQUEST_INT:
			FixQuoteRequest fixQuoteRequest = fixMessagePool.getFixQuoteRequest(buf, err);
			l.onFixQuoteRequest(fixQuoteRequest);
			fixMessagePool.returnFixQuoteRequest (fixQuoteRequest);
			break;
		case MessageTypes.QUOTE_INT:
			FixQuote fixQuote = fixMessagePool.getFixQuote(buf, err);
			l.onFixQuote(fixQuote);
			fixMessagePool.returnFixQuote (fixQuote);
			break;
		case MessageTypes.SETTLEMENTINSTRUCTIONS_INT:
			FixSettlementInstructions fixSettlementInstructions = fixMessagePool.getFixSettlementInstructions(buf, err);
			l.onFixSettlementInstructions(fixSettlementInstructions);
			fixMessagePool.returnFixSettlementInstructions (fixSettlementInstructions);
			break;
		case MessageTypes.MARKETDATAREQUEST_INT:
			FixMarketDataRequest fixMarketDataRequest = fixMessagePool.getFixMarketDataRequest(buf, err);
			l.onFixMarketDataRequest(fixMarketDataRequest);
			fixMessagePool.returnFixMarketDataRequest (fixMarketDataRequest);
			break;
		case MessageTypes.MARKETDATASNAPSHOTFULLREFRESH_INT:
			FixMarketDataSnapshotFullRefresh fixMarketDataSnapshotFullRefresh = fixMessagePool.getFixMarketDataSnapshotFullRefresh(buf, err);
			l.onFixMarketDataSnapshotFullRefresh(fixMarketDataSnapshotFullRefresh);
			fixMessagePool.returnFixMarketDataSnapshotFullRefresh (fixMarketDataSnapshotFullRefresh);
			break;
		case MessageTypes.MARKETDATAINCREMENTALREFRESH_INT:
			FixMarketDataIncrementalRefresh fixMarketDataIncrementalRefresh = fixMessagePool.getFixMarketDataIncrementalRefresh(buf, err);
			l.onFixMarketDataIncrementalRefresh(fixMarketDataIncrementalRefresh);
			fixMessagePool.returnFixMarketDataIncrementalRefresh (fixMarketDataIncrementalRefresh);
			break;
		case MessageTypes.MARKETDATAREQUESTREJECT_INT:
			FixMarketDataRequestReject fixMarketDataRequestReject = fixMessagePool.getFixMarketDataRequestReject(buf, err);
			l.onFixMarketDataRequestReject(fixMarketDataRequestReject);
			fixMessagePool.returnFixMarketDataRequestReject (fixMarketDataRequestReject);
			break;
		case MessageTypes.QUOTECANCEL_INT:
			FixQuoteCancel fixQuoteCancel = fixMessagePool.getFixQuoteCancel(buf, err);
			l.onFixQuoteCancel(fixQuoteCancel);
			fixMessagePool.returnFixQuoteCancel (fixQuoteCancel);
			break;
		case MessageTypes.QUOTESTATUSREQUEST_INT:
			FixQuoteStatusRequest fixQuoteStatusRequest = fixMessagePool.getFixQuoteStatusRequest(buf, err);
			l.onFixQuoteStatusRequest(fixQuoteStatusRequest);
			fixMessagePool.returnFixQuoteStatusRequest (fixQuoteStatusRequest);
			break;
		case MessageTypes.MASSQUOTEACKNOWLEDGEMENT_INT:
			FixMassQuoteAcknowledgement fixMassQuoteAcknowledgement = fixMessagePool.getFixMassQuoteAcknowledgement(buf, err);
			l.onFixMassQuoteAcknowledgement(fixMassQuoteAcknowledgement);
			fixMessagePool.returnFixMassQuoteAcknowledgement (fixMassQuoteAcknowledgement);
			break;
		case MessageTypes.SECURITYDEFINITIONREQUEST_INT:
			FixSecurityDefinitionRequest fixSecurityDefinitionRequest = fixMessagePool.getFixSecurityDefinitionRequest(buf, err);
			l.onFixSecurityDefinitionRequest(fixSecurityDefinitionRequest);
			fixMessagePool.returnFixSecurityDefinitionRequest (fixSecurityDefinitionRequest);
			break;
		case MessageTypes.SECURITYDEFINITION_INT:
			FixSecurityDefinition fixSecurityDefinition = fixMessagePool.getFixSecurityDefinition(buf, err);
			l.onFixSecurityDefinition(fixSecurityDefinition);
			fixMessagePool.returnFixSecurityDefinition (fixSecurityDefinition);
			break;
		case MessageTypes.SECURITYSTATUSREQUEST_INT:
			FixSecurityStatusRequest fixSecurityStatusRequest = fixMessagePool.getFixSecurityStatusRequest(buf, err);
			l.onFixSecurityStatusRequest(fixSecurityStatusRequest);
			fixMessagePool.returnFixSecurityStatusRequest (fixSecurityStatusRequest);
			break;
		case MessageTypes.SECURITYSTATUS_INT:
			FixSecurityStatus fixSecurityStatus = fixMessagePool.getFixSecurityStatus(buf, err);
			l.onFixSecurityStatus(fixSecurityStatus);
			fixMessagePool.returnFixSecurityStatus (fixSecurityStatus);
			break;
		case MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT:
			FixTradingSessionStatusRequest fixTradingSessionStatusRequest = fixMessagePool.getFixTradingSessionStatusRequest(buf, err);
			l.onFixTradingSessionStatusRequest(fixTradingSessionStatusRequest);
			fixMessagePool.returnFixTradingSessionStatusRequest (fixTradingSessionStatusRequest);
			break;
		case MessageTypes.TRADINGSESSIONSTATUS_INT:
			FixTradingSessionStatus fixTradingSessionStatus = fixMessagePool.getFixTradingSessionStatus(buf, err);
			l.onFixTradingSessionStatus(fixTradingSessionStatus);
			fixMessagePool.returnFixTradingSessionStatus (fixTradingSessionStatus);
			break;
		case MessageTypes.MASSQUOTE_INT:
			FixMassQuote fixMassQuote = fixMessagePool.getFixMassQuote(buf, err);
			l.onFixMassQuote(fixMassQuote);
			fixMessagePool.returnFixMassQuote (fixMassQuote);
			break;
		case MessageTypes.BUSINESSMESSAGEREJECT_INT:
			FixBusinessMessageReject fixBusinessMessageReject = fixMessagePool.getFixBusinessMessageReject(buf, err);
			l.onFixBusinessMessageReject(fixBusinessMessageReject);
			fixMessagePool.returnFixBusinessMessageReject (fixBusinessMessageReject);
			break;
		case MessageTypes.BIDREQUEST_INT:
			FixBidRequest fixBidRequest = fixMessagePool.getFixBidRequest(buf, err);
			l.onFixBidRequest(fixBidRequest);
			fixMessagePool.returnFixBidRequest (fixBidRequest);
			break;
		case MessageTypes.BIDRESPONSE_INT:
			FixBidResponse fixBidResponse = fixMessagePool.getFixBidResponse(buf, err);
			l.onFixBidResponse(fixBidResponse);
			fixMessagePool.returnFixBidResponse (fixBidResponse);
			break;
		case MessageTypes.LISTSTRIKEPRICE_INT:
			FixListStrikePrice fixListStrikePrice = fixMessagePool.getFixListStrikePrice(buf, err);
			l.onFixListStrikePrice(fixListStrikePrice);
			fixMessagePool.returnFixListStrikePrice (fixListStrikePrice);
			break;
		case MessageTypes.REGISTRATIONINSTRUCTIONS_INT:
			FixRegistrationInstructions fixRegistrationInstructions = fixMessagePool.getFixRegistrationInstructions(buf, err);
			l.onFixRegistrationInstructions(fixRegistrationInstructions);
			fixMessagePool.returnFixRegistrationInstructions (fixRegistrationInstructions);
			break;
		case MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE_INT:
			FixRegistrationInstructionsResponse fixRegistrationInstructionsResponse = fixMessagePool.getFixRegistrationInstructionsResponse(buf, err);
			l.onFixRegistrationInstructionsResponse(fixRegistrationInstructionsResponse);
			fixMessagePool.returnFixRegistrationInstructionsResponse (fixRegistrationInstructionsResponse);
			break;
		case MessageTypes.ORDERMASSCANCELREQUEST_INT:
			FixOrderMassCancelRequest fixOrderMassCancelRequest = fixMessagePool.getFixOrderMassCancelRequest(buf, err);
			l.onFixOrderMassCancelRequest(fixOrderMassCancelRequest);
			fixMessagePool.returnFixOrderMassCancelRequest (fixOrderMassCancelRequest);
			break;
		case MessageTypes.ORDERMASSCANCELREPORT_INT:
			FixOrderMassCancelReport fixOrderMassCancelReport = fixMessagePool.getFixOrderMassCancelReport(buf, err);
			l.onFixOrderMassCancelReport(fixOrderMassCancelReport);
			fixMessagePool.returnFixOrderMassCancelReport (fixOrderMassCancelReport);
			break;
		case MessageTypes.NEWORDERCROSS_INT:
			FixNewOrderCross fixNewOrderCross = fixMessagePool.getFixNewOrderCross(buf, err);
			l.onFixNewOrderCross(fixNewOrderCross);
			fixMessagePool.returnFixNewOrderCross (fixNewOrderCross);
			break;
		case MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT:
			FixCrossOrderCancelReplaceRequest fixCrossOrderCancelReplaceRequest = fixMessagePool.getFixCrossOrderCancelReplaceRequest(buf, err);
			l.onFixCrossOrderCancelReplaceRequest(fixCrossOrderCancelReplaceRequest);
			fixMessagePool.returnFixCrossOrderCancelReplaceRequest (fixCrossOrderCancelReplaceRequest);
			break;
		case MessageTypes.CROSSORDERCANCELREQUEST_INT:
			FixCrossOrderCancelRequest fixCrossOrderCancelRequest = fixMessagePool.getFixCrossOrderCancelRequest(buf, err);
			l.onFixCrossOrderCancelRequest(fixCrossOrderCancelRequest);
			fixMessagePool.returnFixCrossOrderCancelRequest (fixCrossOrderCancelRequest);
			break;
		case MessageTypes.SECURITYTYPEREQUEST_INT:
			FixSecurityTypeRequest fixSecurityTypeRequest = fixMessagePool.getFixSecurityTypeRequest(buf, err);
			l.onFixSecurityTypeRequest(fixSecurityTypeRequest);
			fixMessagePool.returnFixSecurityTypeRequest (fixSecurityTypeRequest);
			break;
		case MessageTypes.SECURITYTYPES_INT:
			FixSecurityTypes fixSecurityTypes = fixMessagePool.getFixSecurityTypes(buf, err);
			l.onFixSecurityTypes(fixSecurityTypes);
			fixMessagePool.returnFixSecurityTypes (fixSecurityTypes);
			break;
		case MessageTypes.SECURITYLISTREQUEST_INT:
			FixSecurityListRequest fixSecurityListRequest = fixMessagePool.getFixSecurityListRequest(buf, err);
			l.onFixSecurityListRequest(fixSecurityListRequest);
			fixMessagePool.returnFixSecurityListRequest (fixSecurityListRequest);
			break;
		case MessageTypes.SECURITYLIST_INT:
			FixSecurityList fixSecurityList = fixMessagePool.getFixSecurityList(buf, err);
			l.onFixSecurityList(fixSecurityList);
			fixMessagePool.returnFixSecurityList (fixSecurityList);
			break;
		case MessageTypes.DERIVATIVESECURITYLISTREQUEST_INT:
			FixDerivativeSecurityListRequest fixDerivativeSecurityListRequest = fixMessagePool.getFixDerivativeSecurityListRequest(buf, err);
			l.onFixDerivativeSecurityListRequest(fixDerivativeSecurityListRequest);
			fixMessagePool.returnFixDerivativeSecurityListRequest (fixDerivativeSecurityListRequest);
			break;
		case MessageTypes.DERIVATIVESECURITYLIST_INT:
			FixDerivativeSecurityList fixDerivativeSecurityList = fixMessagePool.getFixDerivativeSecurityList(buf, err);
			l.onFixDerivativeSecurityList(fixDerivativeSecurityList);
			fixMessagePool.returnFixDerivativeSecurityList (fixDerivativeSecurityList);
			break;
		case MessageTypes.NEWORDERMULTILEG_INT:
			FixNewOrderMultileg fixNewOrderMultileg = fixMessagePool.getFixNewOrderMultileg(buf, err);
			l.onFixNewOrderMultileg(fixNewOrderMultileg);
			fixMessagePool.returnFixNewOrderMultileg (fixNewOrderMultileg);
			break;
		case MessageTypes.MULTILEGORDERCANCELREPLACE_INT:
			FixMultilegOrderCancelReplace fixMultilegOrderCancelReplace = fixMessagePool.getFixMultilegOrderCancelReplace(buf, err);
			l.onFixMultilegOrderCancelReplace(fixMultilegOrderCancelReplace);
			fixMessagePool.returnFixMultilegOrderCancelReplace (fixMultilegOrderCancelReplace);
			break;
		case MessageTypes.TRADECAPTUREREPORTREQUEST_INT:
			FixTradeCaptureReportRequest fixTradeCaptureReportRequest = fixMessagePool.getFixTradeCaptureReportRequest(buf, err);
			l.onFixTradeCaptureReportRequest(fixTradeCaptureReportRequest);
			fixMessagePool.returnFixTradeCaptureReportRequest (fixTradeCaptureReportRequest);
			break;
		case MessageTypes.TRADECAPTUREREPORT_INT:
			FixTradeCaptureReport fixTradeCaptureReport = fixMessagePool.getFixTradeCaptureReport(buf, err);
			l.onFixTradeCaptureReport(fixTradeCaptureReport);
			fixMessagePool.returnFixTradeCaptureReport (fixTradeCaptureReport);
			break;
		case MessageTypes.ORDERMASSSTATUSREQUEST_INT:
			FixOrderMassStatusRequest fixOrderMassStatusRequest = fixMessagePool.getFixOrderMassStatusRequest(buf, err);
			l.onFixOrderMassStatusRequest(fixOrderMassStatusRequest);
			fixMessagePool.returnFixOrderMassStatusRequest (fixOrderMassStatusRequest);
			break;
		case MessageTypes.QUOTEREQUESTREJECT_INT:
			FixQuoteRequestReject fixQuoteRequestReject = fixMessagePool.getFixQuoteRequestReject(buf, err);
			l.onFixQuoteRequestReject(fixQuoteRequestReject);
			fixMessagePool.returnFixQuoteRequestReject (fixQuoteRequestReject);
			break;
		case MessageTypes.RFQREQUEST_INT:
			FixRFQRequest fixRFQRequest = fixMessagePool.getFixRFQRequest(buf, err);
			l.onFixRFQRequest(fixRFQRequest);
			fixMessagePool.returnFixRFQRequest (fixRFQRequest);
			break;
		case MessageTypes.QUOTESTATUSREPORT_INT:
			FixQuoteStatusReport fixQuoteStatusReport = fixMessagePool.getFixQuoteStatusReport(buf, err);
			l.onFixQuoteStatusReport(fixQuoteStatusReport);
			fixMessagePool.returnFixQuoteStatusReport (fixQuoteStatusReport);
			break;
		case MessageTypes.QUOTERESPONSE_INT:
			FixQuoteResponse fixQuoteResponse = fixMessagePool.getFixQuoteResponse(buf, err);
			l.onFixQuoteResponse(fixQuoteResponse);
			fixMessagePool.returnFixQuoteResponse (fixQuoteResponse);
			break;
		case MessageTypes.CONFIRMATION_INT:
			FixConfirmation fixConfirmation = fixMessagePool.getFixConfirmation(buf, err);
			l.onFixConfirmation(fixConfirmation);
			fixMessagePool.returnFixConfirmation (fixConfirmation);
			break;
		case MessageTypes.POSITIONMAINTENANCEREQUEST_INT:
			FixPositionMaintenanceRequest fixPositionMaintenanceRequest = fixMessagePool.getFixPositionMaintenanceRequest(buf, err);
			l.onFixPositionMaintenanceRequest(fixPositionMaintenanceRequest);
			fixMessagePool.returnFixPositionMaintenanceRequest (fixPositionMaintenanceRequest);
			break;
		case MessageTypes.POSITIONMAINTENANCEREPORT_INT:
			FixPositionMaintenanceReport fixPositionMaintenanceReport = fixMessagePool.getFixPositionMaintenanceReport(buf, err);
			l.onFixPositionMaintenanceReport(fixPositionMaintenanceReport);
			fixMessagePool.returnFixPositionMaintenanceReport (fixPositionMaintenanceReport);
			break;
		case MessageTypes.REQUESTFORPOSITIONS_INT:
			FixRequestForPositions fixRequestForPositions = fixMessagePool.getFixRequestForPositions(buf, err);
			l.onFixRequestForPositions(fixRequestForPositions);
			fixMessagePool.returnFixRequestForPositions (fixRequestForPositions);
			break;
		case MessageTypes.REQUESTFORPOSITIONSACK_INT:
			FixRequestForPositionsAck fixRequestForPositionsAck = fixMessagePool.getFixRequestForPositionsAck(buf, err);
			l.onFixRequestForPositionsAck(fixRequestForPositionsAck);
			fixMessagePool.returnFixRequestForPositionsAck (fixRequestForPositionsAck);
			break;
		case MessageTypes.POSITIONREPORT_INT:
			FixPositionReport fixPositionReport = fixMessagePool.getFixPositionReport(buf, err);
			l.onFixPositionReport(fixPositionReport);
			fixMessagePool.returnFixPositionReport (fixPositionReport);
			break;
		case MessageTypes.TRADECAPTUREREPORTREQUESTACK_INT:
			FixTradeCaptureReportRequestAck fixTradeCaptureReportRequestAck = fixMessagePool.getFixTradeCaptureReportRequestAck(buf, err);
			l.onFixTradeCaptureReportRequestAck(fixTradeCaptureReportRequestAck);
			fixMessagePool.returnFixTradeCaptureReportRequestAck (fixTradeCaptureReportRequestAck);
			break;
		case MessageTypes.TRADECAPTUREREPORTACK_INT:
			FixTradeCaptureReportAck fixTradeCaptureReportAck = fixMessagePool.getFixTradeCaptureReportAck(buf, err);
			l.onFixTradeCaptureReportAck(fixTradeCaptureReportAck);
			fixMessagePool.returnFixTradeCaptureReportAck (fixTradeCaptureReportAck);
			break;
		case MessageTypes.ALLOCATIONREPORT_INT:
			FixAllocationReport fixAllocationReport = fixMessagePool.getFixAllocationReport(buf, err);
			l.onFixAllocationReport(fixAllocationReport);
			fixMessagePool.returnFixAllocationReport (fixAllocationReport);
			break;
		case MessageTypes.ALLOCATIONREPORTACK_INT:
			FixAllocationReportAck fixAllocationReportAck = fixMessagePool.getFixAllocationReportAck(buf, err);
			l.onFixAllocationReportAck(fixAllocationReportAck);
			fixMessagePool.returnFixAllocationReportAck (fixAllocationReportAck);
			break;
		case MessageTypes.CONFIRMATION_ACK_INT:
			FixConfirmation_Ack fixConfirmation_Ack = fixMessagePool.getFixConfirmation_Ack(buf, err);
			l.onFixConfirmation_Ack(fixConfirmation_Ack);
			fixMessagePool.returnFixConfirmation_Ack (fixConfirmation_Ack);
			break;
		case MessageTypes.SETTLEMENTINSTRUCTIONREQUEST_INT:
			FixSettlementInstructionRequest fixSettlementInstructionRequest = fixMessagePool.getFixSettlementInstructionRequest(buf, err);
			l.onFixSettlementInstructionRequest(fixSettlementInstructionRequest);
			fixMessagePool.returnFixSettlementInstructionRequest (fixSettlementInstructionRequest);
			break;
		case MessageTypes.ASSIGNMENTREPORT_INT:
			FixAssignmentReport fixAssignmentReport = fixMessagePool.getFixAssignmentReport(buf, err);
			l.onFixAssignmentReport(fixAssignmentReport);
			fixMessagePool.returnFixAssignmentReport (fixAssignmentReport);
			break;
		case MessageTypes.COLLATERALREQUEST_INT:
			FixCollateralRequest fixCollateralRequest = fixMessagePool.getFixCollateralRequest(buf, err);
			l.onFixCollateralRequest(fixCollateralRequest);
			fixMessagePool.returnFixCollateralRequest (fixCollateralRequest);
			break;
		case MessageTypes.COLLATERALASSIGNMENT_INT:
			FixCollateralAssignment fixCollateralAssignment = fixMessagePool.getFixCollateralAssignment(buf, err);
			l.onFixCollateralAssignment(fixCollateralAssignment);
			fixMessagePool.returnFixCollateralAssignment (fixCollateralAssignment);
			break;
		case MessageTypes.COLLATERALRESPONSE_INT:
			FixCollateralResponse fixCollateralResponse = fixMessagePool.getFixCollateralResponse(buf, err);
			l.onFixCollateralResponse(fixCollateralResponse);
			fixMessagePool.returnFixCollateralResponse (fixCollateralResponse);
			break;
		case MessageTypes.COLLATERALREPORT_INT:
			FixCollateralReport fixCollateralReport = fixMessagePool.getFixCollateralReport(buf, err);
			l.onFixCollateralReport(fixCollateralReport);
			fixMessagePool.returnFixCollateralReport (fixCollateralReport);
			break;
		case MessageTypes.COLLATERALINQUIRY_INT:
			FixCollateralInquiry fixCollateralInquiry = fixMessagePool.getFixCollateralInquiry(buf, err);
			l.onFixCollateralInquiry(fixCollateralInquiry);
			fixMessagePool.returnFixCollateralInquiry (fixCollateralInquiry);
			break;
		case MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT:
			FixNetworkCounterpartySystemStatusRequest fixNetworkCounterpartySystemStatusRequest = fixMessagePool.getFixNetworkCounterpartySystemStatusRequest(buf, err);
			l.onFixNetworkCounterpartySystemStatusRequest(fixNetworkCounterpartySystemStatusRequest);
			fixMessagePool.returnFixNetworkCounterpartySystemStatusRequest (fixNetworkCounterpartySystemStatusRequest);
			break;
		case MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE_INT:
			FixNetworkCounterpartySystemStatusResponse fixNetworkCounterpartySystemStatusResponse = fixMessagePool.getFixNetworkCounterpartySystemStatusResponse(buf, err);
			l.onFixNetworkCounterpartySystemStatusResponse(fixNetworkCounterpartySystemStatusResponse);
			fixMessagePool.returnFixNetworkCounterpartySystemStatusResponse (fixNetworkCounterpartySystemStatusResponse);
			break;
		case MessageTypes.USERREQUEST_INT:
			FixUserRequest fixUserRequest = fixMessagePool.getFixUserRequest(buf, err);
			l.onFixUserRequest(fixUserRequest);
			fixMessagePool.returnFixUserRequest (fixUserRequest);
			break;
		case MessageTypes.USERRESPONSE_INT:
			FixUserResponse fixUserResponse = fixMessagePool.getFixUserResponse(buf, err);
			l.onFixUserResponse(fixUserResponse);
			fixMessagePool.returnFixUserResponse (fixUserResponse);
			break;
		case MessageTypes.COLLATERALINQUIRYACK_INT:
			FixCollateralInquiryAck fixCollateralInquiryAck = fixMessagePool.getFixCollateralInquiryAck(buf, err);
			l.onFixCollateralInquiryAck(fixCollateralInquiryAck);
			fixMessagePool.returnFixCollateralInquiryAck (fixCollateralInquiryAck);
			break;
		case MessageTypes.CONFIRMATIONREQUEST_INT:
			FixConfirmationRequest fixConfirmationRequest = fixMessagePool.getFixConfirmationRequest(buf, err);
			l.onFixConfirmationRequest(fixConfirmationRequest);
			fixMessagePool.returnFixConfirmationRequest (fixConfirmationRequest);
			break;
		case MessageTypes.CONTRARYINTENTIONREPORT_INT:
			FixContraryIntentionReport fixContraryIntentionReport = fixMessagePool.getFixContraryIntentionReport(buf, err);
			l.onFixContraryIntentionReport(fixContraryIntentionReport);
			fixMessagePool.returnFixContraryIntentionReport (fixContraryIntentionReport);
			break;
		case MessageTypes.SECURITYDEFINITIONUPDATEREPORT_INT:
			FixSecurityDefinitionUpdateReport fixSecurityDefinitionUpdateReport = fixMessagePool.getFixSecurityDefinitionUpdateReport(buf, err);
			l.onFixSecurityDefinitionUpdateReport(fixSecurityDefinitionUpdateReport);
			fixMessagePool.returnFixSecurityDefinitionUpdateReport (fixSecurityDefinitionUpdateReport);
			break;
		case MessageTypes.SECURITYLISTUPDATEREPORT_INT:
			FixSecurityListUpdateReport fixSecurityListUpdateReport = fixMessagePool.getFixSecurityListUpdateReport(buf, err);
			l.onFixSecurityListUpdateReport(fixSecurityListUpdateReport);
			fixMessagePool.returnFixSecurityListUpdateReport (fixSecurityListUpdateReport);
			break;
		case MessageTypes.ADJUSTEDPOSITIONREPORT_INT:
			FixAdjustedPositionReport fixAdjustedPositionReport = fixMessagePool.getFixAdjustedPositionReport(buf, err);
			l.onFixAdjustedPositionReport(fixAdjustedPositionReport);
			fixMessagePool.returnFixAdjustedPositionReport (fixAdjustedPositionReport);
			break;
		case MessageTypes.ALLOCATIONINSTRUCTIONALERT_INT:
			FixAllocationInstructionAlert fixAllocationInstructionAlert = fixMessagePool.getFixAllocationInstructionAlert(buf, err);
			l.onFixAllocationInstructionAlert(fixAllocationInstructionAlert);
			fixMessagePool.returnFixAllocationInstructionAlert (fixAllocationInstructionAlert);
			break;
		case MessageTypes.EXECUTIONACKNOWLEDGEMENT_INT:
			FixExecutionAcknowledgement fixExecutionAcknowledgement = fixMessagePool.getFixExecutionAcknowledgement(buf, err);
			l.onFixExecutionAcknowledgement(fixExecutionAcknowledgement);
			fixMessagePool.returnFixExecutionAcknowledgement (fixExecutionAcknowledgement);
			break;
		case MessageTypes.TRADINGSESSIONLIST_INT:
			FixTradingSessionList fixTradingSessionList = fixMessagePool.getFixTradingSessionList(buf, err);
			l.onFixTradingSessionList(fixTradingSessionList);
			fixMessagePool.returnFixTradingSessionList (fixTradingSessionList);
			break;
		case MessageTypes.TRADINGSESSIONLISTREQUEST_INT:
			FixTradingSessionListRequest fixTradingSessionListRequest = fixMessagePool.getFixTradingSessionListRequest(buf, err);
			l.onFixTradingSessionListRequest(fixTradingSessionListRequest);
			fixMessagePool.returnFixTradingSessionListRequest (fixTradingSessionListRequest);
			break;
		case MessageTypes.SETTLEMENTOBLIGATIONREPORT_INT:
			FixSettlementObligationReport fixSettlementObligationReport = fixMessagePool.getFixSettlementObligationReport(buf, err);
			l.onFixSettlementObligationReport(fixSettlementObligationReport);
			fixMessagePool.returnFixSettlementObligationReport (fixSettlementObligationReport);
			break;
		case MessageTypes.DERIVATIVESECURITYLISTUPDATEREPORT_INT:
			FixDerivativeSecurityListUpdateReport fixDerivativeSecurityListUpdateReport = fixMessagePool.getFixDerivativeSecurityListUpdateReport(buf, err);
			l.onFixDerivativeSecurityListUpdateReport(fixDerivativeSecurityListUpdateReport);
			fixMessagePool.returnFixDerivativeSecurityListUpdateReport (fixDerivativeSecurityListUpdateReport);
			break;
		case MessageTypes.TRADINGSESSIONLISTUPDATEREPORT_INT:
			FixTradingSessionListUpdateReport fixTradingSessionListUpdateReport = fixMessagePool.getFixTradingSessionListUpdateReport(buf, err);
			l.onFixTradingSessionListUpdateReport(fixTradingSessionListUpdateReport);
			fixMessagePool.returnFixTradingSessionListUpdateReport (fixTradingSessionListUpdateReport);
			break;
		case MessageTypes.MARKETDEFINITIONREQUEST_INT:
			FixMarketDefinitionRequest fixMarketDefinitionRequest = fixMessagePool.getFixMarketDefinitionRequest(buf, err);
			l.onFixMarketDefinitionRequest(fixMarketDefinitionRequest);
			fixMessagePool.returnFixMarketDefinitionRequest (fixMarketDefinitionRequest);
			break;
		case MessageTypes.MARKETDEFINITION_INT:
			FixMarketDefinition fixMarketDefinition = fixMessagePool.getFixMarketDefinition(buf, err);
			l.onFixMarketDefinition(fixMarketDefinition);
			fixMessagePool.returnFixMarketDefinition (fixMarketDefinition);
			break;
		case MessageTypes.MARKETDEFINITIONUPDATEREPORT_INT:
			FixMarketDefinitionUpdateReport fixMarketDefinitionUpdateReport = fixMessagePool.getFixMarketDefinitionUpdateReport(buf, err);
			l.onFixMarketDefinitionUpdateReport(fixMarketDefinitionUpdateReport);
			fixMessagePool.returnFixMarketDefinitionUpdateReport (fixMarketDefinitionUpdateReport);
			break;
		case MessageTypes.USERNOTIFICATION_INT:
			FixUserNotification fixUserNotification = fixMessagePool.getFixUserNotification(buf, err);
			l.onFixUserNotification(fixUserNotification);
			fixMessagePool.returnFixUserNotification (fixUserNotification);
			break;
		case MessageTypes.ORDERMASSACTIONREPORT_INT:
			FixOrderMassActionReport fixOrderMassActionReport = fixMessagePool.getFixOrderMassActionReport(buf, err);
			l.onFixOrderMassActionReport(fixOrderMassActionReport);
			fixMessagePool.returnFixOrderMassActionReport (fixOrderMassActionReport);
			break;
		case MessageTypes.ORDERMASSACTIONREQUEST_INT:
			FixOrderMassActionRequest fixOrderMassActionRequest = fixMessagePool.getFixOrderMassActionRequest(buf, err);
			l.onFixOrderMassActionRequest(fixOrderMassActionRequest);
			fixMessagePool.returnFixOrderMassActionRequest (fixOrderMassActionRequest);
			break;
		case MessageTypes.APPLICATIONMESSAGEREQUEST_INT:
			FixApplicationMessageRequest fixApplicationMessageRequest = fixMessagePool.getFixApplicationMessageRequest(buf, err);
			l.onFixApplicationMessageRequest(fixApplicationMessageRequest);
			fixMessagePool.returnFixApplicationMessageRequest (fixApplicationMessageRequest);
			break;
		case MessageTypes.APPLICATIONMESSAGEREQUESTACK_INT:
			FixApplicationMessageRequestAck fixApplicationMessageRequestAck = fixMessagePool.getFixApplicationMessageRequestAck(buf, err);
			l.onFixApplicationMessageRequestAck(fixApplicationMessageRequestAck);
			fixMessagePool.returnFixApplicationMessageRequestAck (fixApplicationMessageRequestAck);
			break;
		case MessageTypes.APPLICATIONMESSAGEREPORT_INT:
			FixApplicationMessageReport fixApplicationMessageReport = fixMessagePool.getFixApplicationMessageReport(buf, err);
			l.onFixApplicationMessageReport(fixApplicationMessageReport);
			fixMessagePool.returnFixApplicationMessageReport (fixApplicationMessageReport);
			break;
		case MessageTypes.STREAMASSIGNMENTREQUEST_INT:
			FixStreamAssignmentRequest fixStreamAssignmentRequest = fixMessagePool.getFixStreamAssignmentRequest(buf, err);
			l.onFixStreamAssignmentRequest(fixStreamAssignmentRequest);
			fixMessagePool.returnFixStreamAssignmentRequest (fixStreamAssignmentRequest);
			break;
		case MessageTypes.STREAMASSIGNMENTREPORT_INT:
			FixStreamAssignmentReport fixStreamAssignmentReport = fixMessagePool.getFixStreamAssignmentReport(buf, err);
			l.onFixStreamAssignmentReport(fixStreamAssignmentReport);
			fixMessagePool.returnFixStreamAssignmentReport (fixStreamAssignmentReport);
			break;
		case MessageTypes.STREAMASSIGNMENTREPORTACK_INT:
			FixStreamAssignmentReportACK fixStreamAssignmentReportACK = fixMessagePool.getFixStreamAssignmentReportACK(buf, err);
			l.onFixStreamAssignmentReportACK(fixStreamAssignmentReportACK);
			fixMessagePool.returnFixStreamAssignmentReportACK (fixStreamAssignmentReportACK);
			break;
		case MessageTypes.PARTYDETAILSLISTREQUEST_INT:
			FixPartyDetailsListRequest fixPartyDetailsListRequest = fixMessagePool.getFixPartyDetailsListRequest(buf, err);
			l.onFixPartyDetailsListRequest(fixPartyDetailsListRequest);
			fixMessagePool.returnFixPartyDetailsListRequest (fixPartyDetailsListRequest);
			break;
		case MessageTypes.PARTYDETAILSLISTREPORT_INT:
			FixPartyDetailsListReport fixPartyDetailsListReport = fixMessagePool.getFixPartyDetailsListReport(buf, err);
			l.onFixPartyDetailsListReport(fixPartyDetailsListReport);
			fixMessagePool.returnFixPartyDetailsListReport (fixPartyDetailsListReport);
			break;
		default:
		l.onUnknownMessageType( buf, msgType );
		break;

	}
	}
}

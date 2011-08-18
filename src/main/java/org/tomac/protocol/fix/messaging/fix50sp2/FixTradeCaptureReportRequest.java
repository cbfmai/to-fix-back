package org.tomac.protocol.fix.messaging.fix50sp2;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.component.FixHopGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentExtension;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixFinancingDetails;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTrdCapDtGrp;

public class FixTradeCaptureReportRequest extends FixMessage
{

	public byte[] tradeRequestID;
	public byte[] tradeID;
	public byte[] secondaryTradeID;
	public byte[] firmTradeID;
	public byte[] secondaryFirmTradeID;
	public long tradeRequestType = 0;
	public byte subscriptionRequestType = (byte)' ';
	public byte[] tradeReportID;
	public byte[] secondaryTradeReportID;
	public byte[] execID;
	public byte execType = (byte)' ';
	public byte[] orderID;
	public byte[] clOrdID;
	public byte matchStatus = (byte)' ';
	public long trdType = 0;
	public long trdSubType = 0;
	public byte tradeHandlingInstr = (byte)' ';
	public byte[] transferReason;
	public long secondaryTrdType = 0;
	public byte[] tradeLinkID;
	public byte[] trdMatchID;
	public FixParties parties;
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp undInstrmtGrp;
	public FixInstrmtLegGrp instrmtLegGrp;
	public FixTrdCapDtGrp trdCapDtGrp;
	public byte[] clearingBusinessDate;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public byte[] timeBracket;
	public byte side = (byte)' ';
	public byte multiLegReportingType = (byte)' ';
	public byte[] tradeInputSource;
	public byte[] tradeInputDevice;
	public long responseTransportType = 0;
	public byte[] responseDestination;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;
	public byte[] messageEventSource;

	public FixTradeCaptureReportRequest() {
		super();

		tradeRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryFirmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		transferReason = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		parties = new FixParties();
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp();
		trdCapDtGrp = new FixTrdCapDtGrp();
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

		msgType = MsgTypes.TRADECAPTUREREPORTREQUEST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( tradeRequestID, (byte)0 );
		Utils.fill( tradeID, (byte)0 );
		Utils.fill( secondaryTradeID, (byte)0 );
		Utils.fill( firmTradeID, (byte)0 );
		Utils.fill( secondaryFirmTradeID, (byte)0 );
		tradeRequestType = Long.MAX_VALUE;		
		subscriptionRequestType = Byte.MAX_VALUE;		
		Utils.fill( tradeReportID, (byte)0 );
		Utils.fill( secondaryTradeReportID, (byte)0 );
		Utils.fill( execID, (byte)0 );
		execType = Byte.MAX_VALUE;		
		Utils.fill( orderID, (byte)0 );
		Utils.fill( clOrdID, (byte)0 );
		matchStatus = Byte.MAX_VALUE;		
		trdType = Long.MAX_VALUE;		
		trdSubType = Long.MAX_VALUE;		
		tradeHandlingInstr = Byte.MAX_VALUE;		
		Utils.fill( transferReason, (byte)0 );
		secondaryTrdType = Long.MAX_VALUE;		
		Utils.fill( tradeLinkID, (byte)0 );
		Utils.fill( trdMatchID, (byte)0 );
		Utils.fill( clearingBusinessDate, (byte)0 );
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		Utils.fill( timeBracket, (byte)0 );
		side = Byte.MAX_VALUE;		
		multiLegReportingType = Byte.MAX_VALUE;		
		Utils.fill( tradeInputSource, (byte)0 );
		Utils.fill( tradeInputDevice, (byte)0 );
		responseTransportType = Long.MAX_VALUE;		
		Utils.fill( responseDestination, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		Utils.fill( messageEventSource, (byte)0 );
		parties.clear();
		instrument.clear();
		instrumentExtension.clear();
		financingDetails.clear();
		undInstrmtGrp.clear();
		instrmtLegGrp.clear();
		trdCapDtGrp.clear();
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.TRADEREQUESTID_INT:
				tradeRequestID = FixUtils.getTagStringValue(value, tradeRequestID);
				break;

			case FixTags.TRADEID_INT:
				tradeID = FixUtils.getTagStringValue(value, tradeID);
				break;

			case FixTags.SECONDARYTRADEID_INT:
				secondaryTradeID = FixUtils.getTagStringValue(value, secondaryTradeID);
				break;

			case FixTags.FIRMTRADEID_INT:
				firmTradeID = FixUtils.getTagStringValue(value, firmTradeID);
				break;

			case FixTags.SECONDARYFIRMTRADEID_INT:
				secondaryFirmTradeID = FixUtils.getTagStringValue(value, secondaryFirmTradeID);
				break;

			case FixTags.TRADEREQUESTTYPE_INT:
				tradeRequestType = FixUtils.getTagIntValue( value );
				if (!TradeRequestType.isValid(tradeRequestType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradeRequestType + ") for tag: " + id );
				break;

			case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:
				subscriptionRequestType = FixUtils.getTagCharValue( value );
				if (!SubscriptionRequestType.isValid(subscriptionRequestType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + subscriptionRequestType + ") for tag: " + id );
				break;

			case FixTags.TRADEREPORTID_INT:
				tradeReportID = FixUtils.getTagStringValue(value, tradeReportID);
				break;

			case FixTags.SECONDARYTRADEREPORTID_INT:
				secondaryTradeReportID = FixUtils.getTagStringValue(value, secondaryTradeReportID);
				break;

			case FixTags.EXECID_INT:
				execID = FixUtils.getTagStringValue(value, execID);
				break;

			case FixTags.EXECTYPE_INT:
				execType = FixUtils.getTagCharValue( value );
				if (!ExecType.isValid(execType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + execType + ") for tag: " + id );
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(value, orderID);
				break;

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				break;

			case FixTags.MATCHSTATUS_INT:
				matchStatus = FixUtils.getTagCharValue( value );
				if (!MatchStatus.isValid(matchStatus) ) throw new FixSessionException(buf, "Invalid enumerated value(" + matchStatus + ") for tag: " + id );
				break;

			case FixTags.TRDTYPE_INT:
				trdType = FixUtils.getTagIntValue( value );
				if (!TrdType.isValid(trdType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + trdType + ") for tag: " + id );
				break;

			case FixTags.TRDSUBTYPE_INT:
				trdSubType = FixUtils.getTagIntValue( value );
				if (!TrdSubType.isValid(trdSubType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + trdSubType + ") for tag: " + id );
				break;

			case FixTags.TRADEHANDLINGINSTR_INT:
				tradeHandlingInstr = FixUtils.getTagCharValue( value );
				if (!TradeHandlingInstr.isValid(tradeHandlingInstr) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradeHandlingInstr + ") for tag: " + id );
				break;

			case FixTags.TRANSFERREASON_INT:
				transferReason = FixUtils.getTagStringValue(value, transferReason);
				break;

			case FixTags.SECONDARYTRDTYPE_INT:
				secondaryTrdType = FixUtils.getTagIntValue( value );
				break;

			case FixTags.TRADELINKID_INT:
				tradeLinkID = FixUtils.getTagStringValue(value, tradeLinkID);
				break;

			case FixTags.TRDMATCHID_INT:
				trdMatchID = FixUtils.getTagStringValue(value, trdMatchID);
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.SYMBOL_INT:
				instrument.getAll(FixTags.SYMBOL_INT, value );
				break;

			case FixTags.DELIVERYFORM_INT:
				instrumentExtension.getAll(FixTags.DELIVERYFORM_INT, value );
				break;

			case FixTags.AGREEMENTDESC_INT:
				financingDetails.getAll(FixTags.AGREEMENTDESC_INT, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtGrp.noUnderlyings = FixUtils.getTagIntValue( value );
				undInstrmtGrp.getAll(undInstrmtGrp.noUnderlyings, value );
				break;

			case FixTags.NOLEGS_INT:
				instrmtLegGrp.noLegs = FixUtils.getTagIntValue( value );
				instrmtLegGrp.getAll(instrmtLegGrp.noLegs, value );
				break;

			case FixTags.NODATES_INT:
				trdCapDtGrp.noDates = FixUtils.getTagIntValue( value );
				trdCapDtGrp.getAll(trdCapDtGrp.noDates, value );
				break;

			case FixTags.CLEARINGBUSINESSDATE_INT:
				clearingBusinessDate = FixUtils.getTagStringValue(value, clearingBusinessDate);
				break;

			case FixTags.TRADINGSESSIONID_INT:
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionID + ") for tag: " + id );
				break;

			case FixTags.TRADINGSESSIONSUBID_INT:
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionSubID + ") for tag: " + id );
				break;

			case FixTags.TIMEBRACKET_INT:
				timeBracket = FixUtils.getTagStringValue(value, timeBracket);
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue( value );
				if (!Side.isValid(side) ) throw new FixSessionException(buf, "Invalid enumerated value(" + side + ") for tag: " + id );
				break;

			case FixTags.MULTILEGREPORTINGTYPE_INT:
				multiLegReportingType = FixUtils.getTagCharValue( value );
				if (!MultiLegReportingType.isValid(multiLegReportingType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + multiLegReportingType + ") for tag: " + id );
				break;

			case FixTags.TRADEINPUTSOURCE_INT:
				tradeInputSource = FixUtils.getTagStringValue(value, tradeInputSource);
				break;

			case FixTags.TRADEINPUTDEVICE_INT:
				tradeInputDevice = FixUtils.getTagStringValue(value, tradeInputDevice);
				break;

			case FixTags.RESPONSETRANSPORTTYPE_INT:
				responseTransportType = FixUtils.getTagIntValue( value );
				if (!ResponseTransportType.isValid(responseTransportType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + responseTransportType + ") for tag: " + id );
				break;

			case FixTags.RESPONSEDESTINATION_INT:
				responseDestination = FixUtils.getTagStringValue(value, responseDestination);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(value, text);
				break;

			case FixTags.ENCODEDTEXTLEN_INT:
				encodedTextLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.ENCODEDTEXT_INT:
				encodedText = FixUtils.getTagStringValue(value, encodedText);
				break;

			case FixTags.MESSAGEEVENTSOURCE_INT:
				messageEventSource = FixUtils.getTagStringValue(value, messageEventSource);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

				return;

			default:
				throw new FixSessionException(buf, "Unknown tag: " + id );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(tradeRequestID) ) return FixTags.TRADEREQUESTID_INT;
		if (! FixUtils.isSet(tradeRequestType) ) return FixTags.TRADEREQUESTTYPE_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.TRADECAPTUREREPORTREQUEST);

		// encode all fields including the header

		if (FixUtils.isSet(applVerID)) FixUtils.putFixTag( out, FixTags.APPLVERID_INT, applVerID, 0, Utils.lastIndexTrim(applVerID, (byte)0) );
		if (FixUtils.isSet(cstmApplVerID)) FixUtils.putFixTag( out, FixTags.CSTMAPPLVERID_INT, cstmApplVerID, 0, Utils.lastIndexTrim(cstmApplVerID, (byte)0) );
		if (FixUtils.isSet(applExtID)) FixUtils.putFixTag( out, FixTags.APPLEXTID_INT, applExtID);
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(secureDataLen)) FixUtils.putFixTag( out, FixTags.SECUREDATALEN_INT, secureDataLen);
		if (FixUtils.isSet(secureData)) FixUtils.putFixTag( out, FixTags.SECUREDATA_INT, secureData, 0, Utils.lastIndexTrim(secureData, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		if (FixUtils.isSet(senderLocationID)) FixUtils.putFixTag( out, FixTags.SENDERLOCATIONID_INT, senderLocationID, 0, Utils.lastIndexTrim(senderLocationID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(targetLocationID)) FixUtils.putFixTag( out, FixTags.TARGETLOCATIONID_INT, targetLocationID, 0, Utils.lastIndexTrim(targetLocationID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfLocationID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFLOCATIONID_INT, onBehalfOfLocationID, 0, Utils.lastIndexTrim(onBehalfOfLocationID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );
		if (FixUtils.isSet(deliverToLocationID)) FixUtils.putFixTag( out, FixTags.DELIVERTOLOCATIONID_INT, deliverToLocationID, 0, Utils.lastIndexTrim(deliverToLocationID, (byte)0) );
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(xmlDataLen)) FixUtils.putFixTag( out, FixTags.XMLDATALEN_INT, xmlDataLen);
		if (FixUtils.isSet(xmlData)) FixUtils.putFixTag( out, FixTags.XMLDATA_INT, xmlData, 0, Utils.lastIndexTrim(xmlData, (byte)0) );
		if (FixUtils.isSet(messageEncoding)) FixUtils.putFixTag( out, FixTags.MESSAGEENCODING_INT, messageEncoding, 0, Utils.lastIndexTrim(messageEncoding, (byte)0) );
		if (FixUtils.isSet(lastMsgSeqNumProcessed)) FixUtils.putFixTag( out, FixTags.LASTMSGSEQNUMPROCESSED_INT, lastMsgSeqNumProcessed);
		if ( FixUtils.isSet(hopGrp.noHops) )hopGrp.encode( out );

		FixUtils.putFixTag( out, FixTags.TRADEREQUESTID_INT, tradeRequestID, 0, Utils.lastIndexTrim(tradeRequestID, (byte)0) );
		if (FixUtils.isSet(tradeID)) FixUtils.putFixTag( out, FixTags.TRADEID_INT, tradeID, 0, Utils.lastIndexTrim(tradeID, (byte)0) );
		if (FixUtils.isSet(secondaryTradeID)) FixUtils.putFixTag( out, FixTags.SECONDARYTRADEID_INT, secondaryTradeID, 0, Utils.lastIndexTrim(secondaryTradeID, (byte)0) );
		if (FixUtils.isSet(firmTradeID)) FixUtils.putFixTag( out, FixTags.FIRMTRADEID_INT, firmTradeID, 0, Utils.lastIndexTrim(firmTradeID, (byte)0) );
		if (FixUtils.isSet(secondaryFirmTradeID)) FixUtils.putFixTag( out, FixTags.SECONDARYFIRMTRADEID_INT, secondaryFirmTradeID, 0, Utils.lastIndexTrim(secondaryFirmTradeID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADEREQUESTTYPE_INT, tradeRequestType);
		if (FixUtils.isSet(subscriptionRequestType)) FixUtils.putFixTag( out, FixTags.SUBSCRIPTIONREQUESTTYPE_INT, subscriptionRequestType );
		if (FixUtils.isSet(tradeReportID)) FixUtils.putFixTag( out, FixTags.TRADEREPORTID_INT, tradeReportID, 0, Utils.lastIndexTrim(tradeReportID, (byte)0) );
		if (FixUtils.isSet(secondaryTradeReportID)) FixUtils.putFixTag( out, FixTags.SECONDARYTRADEREPORTID_INT, secondaryTradeReportID, 0, Utils.lastIndexTrim(secondaryTradeReportID, (byte)0) );
		if (FixUtils.isSet(execID)) FixUtils.putFixTag( out, FixTags.EXECID_INT, execID, 0, Utils.lastIndexTrim(execID, (byte)0) );
		if (FixUtils.isSet(execType)) FixUtils.putFixTag( out, FixTags.EXECTYPE_INT, execType );
		if (FixUtils.isSet(orderID)) FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(matchStatus)) FixUtils.putFixTag( out, FixTags.MATCHSTATUS_INT, matchStatus );
		if (FixUtils.isSet(trdType)) FixUtils.putFixTag( out, FixTags.TRDTYPE_INT, trdType);
		if (FixUtils.isSet(trdSubType)) FixUtils.putFixTag( out, FixTags.TRDSUBTYPE_INT, trdSubType);
		if (FixUtils.isSet(tradeHandlingInstr)) FixUtils.putFixTag( out, FixTags.TRADEHANDLINGINSTR_INT, tradeHandlingInstr );
		if (FixUtils.isSet(transferReason)) FixUtils.putFixTag( out, FixTags.TRANSFERREASON_INT, transferReason, 0, Utils.lastIndexTrim(transferReason, (byte)0) );
		if (FixUtils.isSet(secondaryTrdType)) FixUtils.putFixTag( out, FixTags.SECONDARYTRDTYPE_INT, secondaryTrdType);
		if (FixUtils.isSet(tradeLinkID)) FixUtils.putFixTag( out, FixTags.TRADELINKID_INT, tradeLinkID, 0, Utils.lastIndexTrim(tradeLinkID, (byte)0) );
		if (FixUtils.isSet(trdMatchID)) FixUtils.putFixTag( out, FixTags.TRDMATCHID_INT, trdMatchID, 0, Utils.lastIndexTrim(trdMatchID, (byte)0) );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(instrumentExtension.deliveryForm)) instrumentExtension.encode( out );
		if (FixUtils.isSet(financingDetails.agreementDesc)) financingDetails.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(trdCapDtGrp.noDates)) trdCapDtGrp.encode( out );
		if (FixUtils.isSet(clearingBusinessDate)) FixUtils.putFixTag( out, FixTags.CLEARINGBUSINESSDATE_INT, clearingBusinessDate);
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(timeBracket)) FixUtils.putFixTag( out, FixTags.TIMEBRACKET_INT, timeBracket, 0, Utils.lastIndexTrim(timeBracket, (byte)0) );
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(multiLegReportingType)) FixUtils.putFixTag( out, FixTags.MULTILEGREPORTINGTYPE_INT, multiLegReportingType );
		if (FixUtils.isSet(tradeInputSource)) FixUtils.putFixTag( out, FixTags.TRADEINPUTSOURCE_INT, tradeInputSource, 0, Utils.lastIndexTrim(tradeInputSource, (byte)0) );
		if (FixUtils.isSet(tradeInputDevice)) FixUtils.putFixTag( out, FixTags.TRADEINPUTDEVICE_INT, tradeInputDevice, 0, Utils.lastIndexTrim(tradeInputDevice, (byte)0) );
		if (FixUtils.isSet(responseTransportType)) FixUtils.putFixTag( out, FixTags.RESPONSETRANSPORTTYPE_INT, responseTransportType);
		if (FixUtils.isSet(responseDestination)) FixUtils.putFixTag( out, FixTags.RESPONSEDESTINATION_INT, responseDestination, 0, Utils.lastIndexTrim(responseDestination, (byte)0) );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
		if (FixUtils.isSet(messageEventSource)) FixUtils.putFixTag( out, FixTags.MESSAGEEVENTSOURCE_INT, messageEventSource, 0, Utils.lastIndexTrim(messageEventSource, (byte)0) );
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.TRADECAPTUREREPORTREQUEST) + sep;

		try {
			// print all fields including the header

			if (FixUtils.isSet(applVerID)) s += "ApplVerID(1128)=" + new String(applVerID) + sep;
			if (FixUtils.isSet(cstmApplVerID)) s += "CstmApplVerID(1129)=" + new String(cstmApplVerID) + sep;
			if (FixUtils.isSet(applExtID)) s += "ApplExtID(1156)=" + String.valueOf(applExtID) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(secureDataLen)) s += "SecureDataLen(90)=" + String.valueOf(secureDataLen) + sep;
			if (FixUtils.isSet(secureData)) s += "SecureData(91)=" + new String(secureData) + sep;
			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			if (FixUtils.isSet(senderLocationID)) s += "SenderLocationID(142)=" + new String(senderLocationID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(targetLocationID)) s += "TargetLocationID(143)=" + new String(targetLocationID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(onBehalfOfLocationID)) s += "OnBehalfOfLocationID(144)=" + new String(onBehalfOfLocationID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;
			if (FixUtils.isSet(deliverToLocationID)) s += "DeliverToLocationID(145)=" + new String(deliverToLocationID) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(xmlDataLen)) s += "XmlDataLen(212)=" + String.valueOf(xmlDataLen) + sep;
			if (FixUtils.isSet(xmlData)) s += "XmlData(213)=" + new String(xmlData) + sep;
			if (FixUtils.isSet(messageEncoding)) s += "MessageEncoding(347)=" + new String(messageEncoding) + sep;
			if (FixUtils.isSet(lastMsgSeqNumProcessed)) s += "LastMsgSeqNumProcessed(369)=" + String.valueOf(lastMsgSeqNumProcessed) + sep;
			if (FixUtils.isSet(hopGrp.noHops)) s += hopGrp.toString();

			 s += "TradeRequestID(568)=" + new String(tradeRequestID) + sep;
			if (FixUtils.isSet(tradeID)) s += "TradeID(1003)=" + new String(tradeID) + sep;
			if (FixUtils.isSet(secondaryTradeID)) s += "SecondaryTradeID(1040)=" + new String(secondaryTradeID) + sep;
			if (FixUtils.isSet(firmTradeID)) s += "FirmTradeID(1041)=" + new String(firmTradeID) + sep;
			if (FixUtils.isSet(secondaryFirmTradeID)) s += "SecondaryFirmTradeID(1042)=" + new String(secondaryFirmTradeID) + sep;
			 s += "TradeRequestType(569)=" + String.valueOf(tradeRequestType) + sep;
			if (FixUtils.isSet(subscriptionRequestType)) s += "SubscriptionRequestType(263)=" + String.valueOf(subscriptionRequestType) + sep;
			if (FixUtils.isSet(tradeReportID)) s += "TradeReportID(571)=" + new String(tradeReportID) + sep;
			if (FixUtils.isSet(secondaryTradeReportID)) s += "SecondaryTradeReportID(818)=" + new String(secondaryTradeReportID) + sep;
			if (FixUtils.isSet(execID)) s += "ExecID(17)=" + new String(execID) + sep;
			if (FixUtils.isSet(execType)) s += "ExecType(150)=" + String.valueOf(execType) + sep;
			if (FixUtils.isSet(orderID)) s += "OrderID(37)=" + new String(orderID) + sep;
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(matchStatus)) s += "MatchStatus(573)=" + String.valueOf(matchStatus) + sep;
			if (FixUtils.isSet(trdType)) s += "TrdType(828)=" + String.valueOf(trdType) + sep;
			if (FixUtils.isSet(trdSubType)) s += "TrdSubType(829)=" + String.valueOf(trdSubType) + sep;
			if (FixUtils.isSet(tradeHandlingInstr)) s += "TradeHandlingInstr(1123)=" + String.valueOf(tradeHandlingInstr) + sep;
			if (FixUtils.isSet(transferReason)) s += "TransferReason(830)=" + new String(transferReason) + sep;
			if (FixUtils.isSet(secondaryTrdType)) s += "SecondaryTrdType(855)=" + String.valueOf(secondaryTrdType) + sep;
			if (FixUtils.isSet(tradeLinkID)) s += "TradeLinkID(820)=" + new String(tradeLinkID) + sep;
			if (FixUtils.isSet(trdMatchID)) s += "TrdMatchID(880)=" + new String(trdMatchID) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(instrumentExtension.deliveryForm)) s += instrumentExtension.toString();
			if (FixUtils.isSet(financingDetails.agreementDesc)) s += financingDetails.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(trdCapDtGrp.noDates)) s += trdCapDtGrp.toString();
			if (FixUtils.isSet(clearingBusinessDate)) s += "ClearingBusinessDate(715)=" + new String(clearingBusinessDate) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(timeBracket)) s += "TimeBracket(943)=" + new String(timeBracket) + sep;
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(multiLegReportingType)) s += "MultiLegReportingType(442)=" + String.valueOf(multiLegReportingType) + sep;
			if (FixUtils.isSet(tradeInputSource)) s += "TradeInputSource(578)=" + new String(tradeInputSource) + sep;
			if (FixUtils.isSet(tradeInputDevice)) s += "TradeInputDevice(579)=" + new String(tradeInputDevice) + sep;
			if (FixUtils.isSet(responseTransportType)) s += "ResponseTransportType(725)=" + String.valueOf(responseTransportType) + sep;
			if (FixUtils.isSet(responseDestination)) s += "ResponseDestination(726)=" + new String(responseDestination) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
			if (FixUtils.isSet(messageEventSource)) s += "MessageEventSource(1011)=" + new String(messageEventSource) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradeCaptureReportRequest)) return false;

			FixTradeCaptureReportRequest msg = (FixTradeCaptureReportRequest) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( tradeRequestID, msg.tradeRequestID)) return false;

		if (!Utils.equals( tradeID, msg.tradeID)) return false;

		if (!Utils.equals( secondaryTradeID, msg.secondaryTradeID)) return false;

		if (!Utils.equals( firmTradeID, msg.firmTradeID)) return false;

		if (!Utils.equals( secondaryFirmTradeID, msg.secondaryFirmTradeID)) return false;

		if (!( tradeRequestType==msg.tradeRequestType)) return false;

		if (!( subscriptionRequestType==msg.subscriptionRequestType)) return false;

		if (!Utils.equals( tradeReportID, msg.tradeReportID)) return false;

		if (!Utils.equals( secondaryTradeReportID, msg.secondaryTradeReportID)) return false;

		if (!Utils.equals( execID, msg.execID)) return false;

		if (!( execType==msg.execType)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!( matchStatus==msg.matchStatus)) return false;

		if (!( trdType==msg.trdType)) return false;

		if (!( trdSubType==msg.trdSubType)) return false;

		if (!( tradeHandlingInstr==msg.tradeHandlingInstr)) return false;

		if (!Utils.equals( transferReason, msg.transferReason)) return false;

		if (!( secondaryTrdType==msg.secondaryTrdType)) return false;

		if (!Utils.equals( tradeLinkID, msg.tradeLinkID)) return false;

		if (!Utils.equals( trdMatchID, msg.trdMatchID)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!instrumentExtension.equals(msg.instrumentExtension)) return false;

		if (!financingDetails.equals(msg.financingDetails)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!trdCapDtGrp.equals(msg.trdCapDtGrp)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!Utils.equals( timeBracket, msg.timeBracket)) return false;

		if (!( side==msg.side)) return false;

		if (!( multiLegReportingType==msg.multiLegReportingType)) return false;

		if (!Utils.equals( tradeInputSource, msg.tradeInputSource)) return false;

		if (!Utils.equals( tradeInputDevice, msg.tradeInputDevice)) return false;

		if (!( responseTransportType==msg.responseTransportType)) return false;

		if (!Utils.equals( responseDestination, msg.responseDestination)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		if (!Utils.equals( messageEventSource, msg.messageEventSource)) return false;

		return true;
	}
}

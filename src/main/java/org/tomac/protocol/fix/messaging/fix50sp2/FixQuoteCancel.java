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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTargetParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixQuotCxlEntriesGrp;

public class FixQuoteCancel extends FixMessage
{

	public byte[] quoteReqID;
	public byte[] quoteID;
	public byte[] quoteMsgID;
	public long quoteCancelType = 0;
	public long quoteType = 0;
	public long quoteResponseLevel = 0;
	public FixParties parties;
	public FixTargetParties targetParties;
	public byte[] account;
	public long acctIDSource = 0;
	public long accountType = 0;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public FixQuotCxlEntriesGrp quotCxlEntriesGrp;

	public FixQuoteCancel() {
		super();

		quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		quoteMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		parties = new FixParties();
		targetParties = new FixTargetParties();
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		quotCxlEntriesGrp = new FixQuotCxlEntriesGrp();
		this.clear();

		msgType = MsgTypes.QUOTECANCEL_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( quoteReqID, (byte)0 );
		Utils.fill( quoteID, (byte)0 );
		Utils.fill( quoteMsgID, (byte)0 );
		quoteCancelType = Long.MAX_VALUE;		
		quoteType = Long.MAX_VALUE;		
		quoteResponseLevel = Long.MAX_VALUE;		
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
		accountType = Long.MAX_VALUE;		
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		parties.clear();
		targetParties.clear();
		quotCxlEntriesGrp.clear();
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

			case FixTags.QUOTEREQID_INT:
				quoteReqID = FixUtils.getTagStringValue(value, quoteReqID);
				break;

			case FixTags.QUOTEID_INT:
				quoteID = FixUtils.getTagStringValue(value, quoteID);
				break;

			case FixTags.QUOTEMSGID_INT:
				quoteMsgID = FixUtils.getTagStringValue(value, quoteMsgID);
				break;

			case FixTags.QUOTECANCELTYPE_INT:
				quoteCancelType = FixUtils.getTagIntValue( value );
				if (!QuoteCancelType.isValid(quoteCancelType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + quoteCancelType + ") for tag: " + id );
				break;

			case FixTags.QUOTETYPE_INT:
				quoteType = FixUtils.getTagIntValue( value );
				if (!QuoteType.isValid(quoteType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + quoteType + ") for tag: " + id );
				break;

			case FixTags.QUOTERESPONSELEVEL_INT:
				quoteResponseLevel = FixUtils.getTagIntValue( value );
				if (!QuoteResponseLevel.isValid(quoteResponseLevel) ) throw new FixSessionException(buf, "Invalid enumerated value(" + quoteResponseLevel + ") for tag: " + id );
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.NOTARGETPARTYIDS_INT:
				targetParties.noTargetPartyIDs = FixUtils.getTagIntValue( value );
				targetParties.getAll(targetParties.noTargetPartyIDs, value );
				break;

			case FixTags.ACCOUNT_INT:
				account = FixUtils.getTagStringValue(value, account);
				break;

			case FixTags.ACCTIDSOURCE_INT:
				acctIDSource = FixUtils.getTagIntValue( value );
				if (!AcctIDSource.isValid(acctIDSource) ) throw new FixSessionException(buf, "Invalid enumerated value(" + acctIDSource + ") for tag: " + id );
				break;

			case FixTags.ACCOUNTTYPE_INT:
				accountType = FixUtils.getTagIntValue( value );
				if (!AccountType.isValid(accountType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + accountType + ") for tag: " + id );
				break;

			case FixTags.TRADINGSESSIONID_INT:
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionID + ") for tag: " + id );
				break;

			case FixTags.TRADINGSESSIONSUBID_INT:
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionSubID + ") for tag: " + id );
				break;

			case FixTags.NOQUOTEENTRIES_INT:
				quotCxlEntriesGrp.noQuoteEntries = FixUtils.getTagIntValue( value );
				quotCxlEntriesGrp.getAll(quotCxlEntriesGrp.noQuoteEntries, value );
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
		if (! FixUtils.isSet(quoteCancelType) ) return FixTags.QUOTECANCELTYPE_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.QUOTECANCEL);

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

		if (FixUtils.isSet(quoteReqID)) FixUtils.putFixTag( out, FixTags.QUOTEREQID_INT, quoteReqID, 0, Utils.lastIndexTrim(quoteReqID, (byte)0) );
		if (FixUtils.isSet(quoteID)) FixUtils.putFixTag( out, FixTags.QUOTEID_INT, quoteID, 0, Utils.lastIndexTrim(quoteID, (byte)0) );
		if (FixUtils.isSet(quoteMsgID)) FixUtils.putFixTag( out, FixTags.QUOTEMSGID_INT, quoteMsgID, 0, Utils.lastIndexTrim(quoteMsgID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.QUOTECANCELTYPE_INT, quoteCancelType);
		if (FixUtils.isSet(quoteType)) FixUtils.putFixTag( out, FixTags.QUOTETYPE_INT, quoteType);
		if (FixUtils.isSet(quoteResponseLevel)) FixUtils.putFixTag( out, FixTags.QUOTERESPONSELEVEL_INT, quoteResponseLevel);
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(targetParties.noTargetPartyIDs)) targetParties.encode( out );
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
		if (FixUtils.isSet(accountType)) FixUtils.putFixTag( out, FixTags.ACCOUNTTYPE_INT, accountType);
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(quotCxlEntriesGrp.noQuoteEntries)) quotCxlEntriesGrp.encode( out );
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
		s += "MsgType(35)=" + new String(MsgTypes.QUOTECANCEL) + sep;

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

			if (FixUtils.isSet(quoteReqID)) s += "QuoteReqID(131)=" + new String(quoteReqID) + sep;
			if (FixUtils.isSet(quoteID)) s += "QuoteID(117)=" + new String(quoteID) + sep;
			if (FixUtils.isSet(quoteMsgID)) s += "QuoteMsgID(1166)=" + new String(quoteMsgID) + sep;
			 s += "QuoteCancelType(298)=" + String.valueOf(quoteCancelType) + sep;
			if (FixUtils.isSet(quoteType)) s += "QuoteType(537)=" + String.valueOf(quoteType) + sep;
			if (FixUtils.isSet(quoteResponseLevel)) s += "QuoteResponseLevel(301)=" + String.valueOf(quoteResponseLevel) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(targetParties.noTargetPartyIDs)) s += targetParties.toString();
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
			if (FixUtils.isSet(accountType)) s += "AccountType(581)=" + String.valueOf(accountType) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(quotCxlEntriesGrp.noQuoteEntries)) s += quotCxlEntriesGrp.toString();

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixQuoteCancel)) return false;

			FixQuoteCancel msg = (FixQuoteCancel) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( quoteReqID, msg.quoteReqID)) return false;

		if (!Utils.equals( quoteID, msg.quoteID)) return false;

		if (!Utils.equals( quoteMsgID, msg.quoteMsgID)) return false;

		if (!( quoteCancelType==msg.quoteCancelType)) return false;

		if (!( quoteType==msg.quoteType)) return false;

		if (!( quoteResponseLevel==msg.quoteResponseLevel)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!targetParties.equals(msg.targetParties)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		if (!( accountType==msg.accountType)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!quotCxlEntriesGrp.equals(msg.quotCxlEntriesGrp)) return false;

		return true;
	}
}

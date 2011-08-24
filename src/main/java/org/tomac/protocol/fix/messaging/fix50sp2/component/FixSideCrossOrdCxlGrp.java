package org.tomac.protocol.fix.messaging.fix50sp2.component;

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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixOrderQtyData;

public class FixSideCrossOrdCxlGrp
{

	public int noSides;
	public SideCrossOrdCxlGrp[] group;

	public void getAll(int noSides, ByteBuffer buf) throws FixSessionException {
		this.noSides = noSides;

		if (noSides < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noSides ).getBytes(), FixTags.NOSIDES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noSides) {
			group = new SideCrossOrdCxlGrp[noSides];

			for ( int i = 0; i < noSides; i++ ) group[i] = new SideCrossOrdCxlGrp();
	}

		for ( int i = 0; i < noSides; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noSides; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noSides; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noSides; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noSides; i++)
			s += group[i].toString();
		return s;
	}

public class SideCrossOrdCxlGrp implements FixComponent
{

	public byte side = (byte)' ';
	public byte[] origClOrdID;
	public byte[] clOrdID;
	public byte[] secondaryClOrdID;
	public byte[] clOrdLinkID;
	public byte[] origOrdModTime;
	public FixParties parties;
	public byte[] tradeOriginationDate;
	public byte[] tradeDate;
	public FixOrderQtyData orderQtyData;
	public byte[] complianceID;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public SideCrossOrdCxlGrp() {
		super();

		origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		origOrdModTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		parties = new FixParties();
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderQtyData = new FixOrderQtyData();
		complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		side = Byte.MAX_VALUE;		
		Utils.fill( origClOrdID, (byte)0 );
		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( secondaryClOrdID, (byte)0 );
		Utils.fill( clOrdLinkID, (byte)0 );
		Utils.fill( origOrdModTime, (byte)0 );
		Utils.fill( tradeOriginationDate, (byte)0 );
		Utils.fill( tradeDate, (byte)0 );
		Utils.fill( complianceID, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		parties.clear();
		orderQtyData.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SIDE_INT) {
				side = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORIGCLORDID_INT) {
				origClOrdID = FixUtils.getTagStringValue(value, origClOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CLORDID_INT) {
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYCLORDID_INT) {
				secondaryClOrdID = FixUtils.getTagStringValue(value, secondaryClOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CLORDLINKID_INT) {
				clOrdLinkID = FixUtils.getTagStringValue(value, clOrdLinkID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORIGORDMODTIME_INT) {
				origOrdModTime = FixUtils.getTagStringValue(value, origOrdModTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOPARTYIDS_INT) {
				parties.getAll(FixTags.NOPARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADEORIGINATIONDATE_INT) {
				tradeOriginationDate = FixUtils.getTagStringValue(value, tradeOriginationDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADEDATE_INT) {
				tradeDate = FixUtils.getTagStringValue(value, tradeDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERQTY_INT) {
				orderQtyData.getAll(FixTags.ORDERQTY_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.COMPLIANCEID_INT) {
				complianceID = FixUtils.getTagStringValue(value, complianceID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TEXT_INT) {
				text = FixUtils.getTagStringValue(value, text);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDTEXTLEN_INT) {
				encodedTextLen = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDTEXT_INT) {
				encodedText = FixUtils.getTagStringValue(value, encodedText);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(clOrdID) ) return FixTags.CLORDID_INT;
		if (! orderQtyData.isSet() ) return FixTags.ORDERQTY_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(origClOrdID)) return true;
		if (FixUtils.isSet(secondaryClOrdID)) return true;
		if (FixUtils.isSet(clOrdLinkID)) return true;
		if (FixUtils.isSet(origOrdModTime)) return true;
		if (FixUtils.isSet(parties.noPartyIDs)) return true;
		if (FixUtils.isSet(tradeOriginationDate)) return true;
		if (FixUtils.isSet(tradeDate)) return true;
		if (FixUtils.isSet(orderQtyData.orderQty)) return true;
		if (FixUtils.isSet(complianceID)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(origClOrdID)) FixUtils.putFixTag( out, FixTags.ORIGCLORDID_INT, origClOrdID, 0, Utils.lastIndexTrim(origClOrdID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(secondaryClOrdID)) FixUtils.putFixTag( out, FixTags.SECONDARYCLORDID_INT, secondaryClOrdID, 0, Utils.lastIndexTrim(secondaryClOrdID, (byte)0) );
		if (FixUtils.isSet(clOrdLinkID)) FixUtils.putFixTag( out, FixTags.CLORDLINKID_INT, clOrdLinkID, 0, Utils.lastIndexTrim(clOrdLinkID, (byte)0) );
		if (FixUtils.isSet(origOrdModTime)) FixUtils.putFixTag( out, FixTags.ORIGORDMODTIME_INT, origOrdModTime);
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(tradeOriginationDate)) FixUtils.putFixTag( out, FixTags.TRADEORIGINATIONDATE_INT, tradeOriginationDate);
		if (FixUtils.isSet(tradeDate)) FixUtils.putFixTag( out, FixTags.TRADEDATE_INT, tradeDate);
		if (FixUtils.isSet(orderQtyData.orderQty)) orderQtyData.encode( out );
		if (FixUtils.isSet(complianceID)) FixUtils.putFixTag( out, FixTags.COMPLIANCEID_INT, complianceID, 0, Utils.lastIndexTrim(complianceID, (byte)0) );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			 s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(origClOrdID)) s += "OrigClOrdID(41)=" + new String(origClOrdID) + sep;
			 s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(secondaryClOrdID)) s += "SecondaryClOrdID(526)=" + new String(secondaryClOrdID) + sep;
			if (FixUtils.isSet(clOrdLinkID)) s += "ClOrdLinkID(583)=" + new String(clOrdLinkID) + sep;
			if (FixUtils.isSet(origOrdModTime)) s += "OrigOrdModTime(586)=" + new String(origOrdModTime) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(tradeOriginationDate)) s += "TradeOriginationDate(229)=" + new String(tradeOriginationDate) + sep;
			if (FixUtils.isSet(tradeDate)) s += "TradeDate(75)=" + new String(tradeDate) + sep;
			if (FixUtils.isSet(orderQtyData.orderQty)) s += orderQtyData.toString();
			if (FixUtils.isSet(complianceID)) s += "ComplianceID(376)=" + new String(complianceID) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SideCrossOrdCxlGrp)) return false;

			SideCrossOrdCxlGrp msg = (SideCrossOrdCxlGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( origClOrdID, msg.origClOrdID)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( secondaryClOrdID, msg.secondaryClOrdID)) return false;

		if (!Utils.equals( clOrdLinkID, msg.clOrdLinkID)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!orderQtyData.equals(msg.orderQtyData)) return false;

		if (!Utils.equals( complianceID, msg.complianceID)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
}

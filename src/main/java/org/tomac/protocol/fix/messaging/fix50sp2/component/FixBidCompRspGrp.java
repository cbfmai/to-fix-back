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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixCommissionData;

public class FixBidCompRspGrp
{

	public int noBidComponents;
	public BidCompRspGrp[] group;

	public void getAll(int noBidComponents, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noBidComponents = noBidComponents;

		if (noBidComponents < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noBidComponents ).getBytes(), FixTags.NOBIDCOMPONENTS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noBidComponents) {
			group = new BidCompRspGrp[noBidComponents];

			for ( int i = 0; i < noBidComponents; i++ ) group[i] = new BidCompRspGrp();
	}

		for ( int i = 0; i < noBidComponents; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noBidComponents; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noBidComponents; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noBidComponents; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBidCompRspGrp)) return false;

		FixBidCompRspGrp msg = (FixBidCompRspGrp) o;

		for (int i = 0; i<noBidComponents; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noBidComponents; i++)
			s += group[i].toString();
		return s;
	}

public class BidCompRspGrp implements FixComponent
{

	public FixCommissionData commissionData;
	public byte[] listID;
	public byte[] country;
	public byte side = (byte)' ';
	public long price = 0;
	public long priceType = 0;
	public long fairValue = 0;
	public long netGrossInd = 0;
	public byte[] settlType;
	public byte[] settlDate;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public BidCompRspGrp() {
		super();

		commissionData = new FixCommissionData();
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		country = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( listID, (byte)0 );
		Utils.fill( country, (byte)0 );
		side = Byte.MAX_VALUE;		
		price = Long.MAX_VALUE;		
		priceType = Long.MAX_VALUE;		
		fairValue = Long.MAX_VALUE;		
		netGrossInd = Long.MAX_VALUE;		
		Utils.fill( settlType, (byte)0 );
		Utils.fill( settlDate, (byte)0 );
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		commissionData.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.COMMISSION_INT) {
				commissionData.getAll(FixTags.COMMISSION_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LISTID_INT) {
				listID = FixUtils.getTagStringValue(value, listID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.COUNTRY_INT) {
				country = FixUtils.getTagStringValue(value, country);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDE_INT) {
				side = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRICE_INT) {
				price = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRICETYPE_INT) {
				priceType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.PriceType.isValid(priceType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + priceType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.FAIRVALUE_INT) {
				fairValue = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NETGROSSIND_INT) {
				netGrossInd = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.NetGrossInd.isValid(netGrossInd) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + netGrossInd + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLTYPE_INT) {
				settlType = FixUtils.getTagStringValue(value, settlType);
				if (!FixMessageInfo.SettlType.isValid(settlType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + settlType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLDATE_INT) {
				settlDate = FixUtils.getTagStringValue(value, settlDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONID_INT) {
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!FixMessageInfo.TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionID + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONSUBID_INT) {
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!FixMessageInfo.TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionSubID + ") for tag").getBytes(), id, new byte[0] );
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

		if (! commissionData.isSet() ) return FixTags.COMMISSION_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(commissionData.commission)) return true;
		if (FixUtils.isSet(listID)) return true;
		if (FixUtils.isSet(country)) return true;
		if (FixUtils.isSet(side)) return true;
		if (FixUtils.isSet(price)) return true;
		if (FixUtils.isSet(priceType)) return true;
		if (FixUtils.isSet(fairValue)) return true;
		if (FixUtils.isSet(netGrossInd)) return true;
		if (FixUtils.isSet(settlType)) return true;
		if (FixUtils.isSet(settlDate)) return true;
		if (FixUtils.isSet(tradingSessionID)) return true;
		if (FixUtils.isSet(tradingSessionSubID)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(commissionData.commission)) commissionData.encode( out );
		if (FixUtils.isSet(listID)) FixUtils.putFixTag( out, FixTags.LISTID_INT, listID, 0, Utils.lastIndexTrim(listID, (byte)0) );
		if (FixUtils.isSet(country)) FixUtils.putFixTag( out, FixTags.COUNTRY_INT, country, 0, Utils.lastIndexTrim(country, (byte)0) );
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(price)) FixUtils.putFixFloatTag( out, FixTags.PRICE_INT, price);
		if (FixUtils.isSet(priceType)) FixUtils.putFixTag( out, FixTags.PRICETYPE_INT, priceType);
		if (FixUtils.isSet(fairValue)) FixUtils.putFixTag( out, FixTags.FAIRVALUE_INT, fairValue);
		if (FixUtils.isSet(netGrossInd)) FixUtils.putFixTag( out, FixTags.NETGROSSIND_INT, netGrossInd);
		if (FixUtils.isSet(settlType)) FixUtils.putFixTag( out, FixTags.SETTLTYPE_INT, settlType, 0, Utils.lastIndexTrim(settlType, (byte)0) );
		if (FixUtils.isSet(settlDate)) FixUtils.putFixTag( out, FixTags.SETTLDATE_INT, settlDate);
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
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

			if (FixUtils.isSet(commissionData.commission)) s += commissionData.toString();
			if (FixUtils.isSet(listID)) s += "ListID(66)=" + new String(listID) + sep;
			if (FixUtils.isSet(country)) s += "Country(421)=" + new String(country) + sep;
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(price)) s += "Price(44)=" + String.valueOf(price) + sep;
			if (FixUtils.isSet(priceType)) s += "PriceType(423)=" + String.valueOf(priceType) + sep;
			if (FixUtils.isSet(fairValue)) s += "FairValue(406)=" + String.valueOf(fairValue) + sep;
			if (FixUtils.isSet(netGrossInd)) s += "NetGrossInd(430)=" + String.valueOf(netGrossInd) + sep;
			if (FixUtils.isSet(settlType)) s += "SettlType(63)=" + new String(settlType) + sep;
			if (FixUtils.isSet(settlDate)) s += "SettlDate(64)=" + new String(settlDate) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof BidCompRspGrp)) return false;

			BidCompRspGrp msg = (BidCompRspGrp) o;

		if (!commissionData.equals(msg.commissionData)) return false;

		if (!Utils.equals( listID, msg.listID)) return false;

		if (!Utils.equals( country, msg.country)) return false;

		if (!( side==msg.side)) return false;

		if (!( price==msg.price)) return false;

		if (!( priceType==msg.priceType)) return false;

		if (!( fairValue==msg.fairValue)) return false;

		if (!( netGrossInd==msg.netGrossInd)) return false;

		if (!Utils.equals( settlType, msg.settlType)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
}

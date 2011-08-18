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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixBidCompReqGrp
{

	public int noBidComponents;
	public BidCompReqGrp[] group;

	public void getAll(int noBidComponents, ByteBuffer buf) throws FixSessionException {
		this.noBidComponents = noBidComponents;

		if (noBidComponents < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noBidComponents) 
			group = new BidCompReqGrp[noBidComponents];

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
	public String toString() {
		String s = "";
		for (int i = 0; i<noBidComponents; i++)
			s += group[i].toString();
		return s;
	}

public class BidCompReqGrp implements FixComponent
{

	public byte[] listID;
	public byte side = (byte)' ';
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public long netGrossInd = 0;
	public byte[] settlType;
	public byte[] settlDate;
	public byte[] account;
	public long acctIDSource = 0;

	public BidCompReqGrp() {
		super();

		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( listID, (byte)0 );
		side = Byte.MAX_VALUE;		
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		netGrossInd = Long.MAX_VALUE;		
		Utils.fill( settlType, (byte)0 );
		Utils.fill( settlDate, (byte)0 );
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LISTID_INT) {
				listID = FixUtils.getTagStringValue(value, listID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDE_INT) {
				side = FixUtils.getTagCharValue( value );
				if (!Side.isValid(side) ) throw new FixSessionException(buf, "Invalid enumerated value(" + side + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONID_INT) {
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionID + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONSUBID_INT) {
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionSubID + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NETGROSSIND_INT) {
				netGrossInd = FixUtils.getTagIntValue( value );
				if (!NetGrossInd.isValid(netGrossInd) ) throw new FixSessionException(buf, "Invalid enumerated value(" + netGrossInd + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLTYPE_INT) {
				settlType = FixUtils.getTagStringValue(value, settlType);
				if (!SettlType.isValid(settlType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + settlType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLDATE_INT) {
				settlDate = FixUtils.getTagStringValue(value, settlDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ACCOUNT_INT) {
				account = FixUtils.getTagStringValue(value, account);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ACCTIDSOURCE_INT) {
				acctIDSource = FixUtils.getTagIntValue( value );
				if (!AcctIDSource.isValid(acctIDSource) ) throw new FixSessionException(buf, "Invalid enumerated value(" + acctIDSource + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(listID)) return true;
		if (FixUtils.isSet(side)) return true;
		if (FixUtils.isSet(tradingSessionID)) return true;
		if (FixUtils.isSet(tradingSessionSubID)) return true;
		if (FixUtils.isSet(netGrossInd)) return true;
		if (FixUtils.isSet(settlType)) return true;
		if (FixUtils.isSet(settlDate)) return true;
		if (FixUtils.isSet(account)) return true;
		if (FixUtils.isSet(acctIDSource)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(listID)) FixUtils.putFixTag( out, FixTags.LISTID_INT, listID, 0, Utils.lastIndexTrim(listID, (byte)0) );
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(netGrossInd)) FixUtils.putFixTag( out, FixTags.NETGROSSIND_INT, netGrossInd);
		if (FixUtils.isSet(settlType)) FixUtils.putFixTag( out, FixTags.SETTLTYPE_INT, settlType, 0, Utils.lastIndexTrim(settlType, (byte)0) );
		if (FixUtils.isSet(settlDate)) FixUtils.putFixTag( out, FixTags.SETTLDATE_INT, settlDate);
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
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

			if (FixUtils.isSet(listID)) s += "ListID(66)=" + new String(listID) + sep;
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(netGrossInd)) s += "NetGrossInd(430)=" + String.valueOf(netGrossInd) + sep;
			if (FixUtils.isSet(settlType)) s += "SettlType(63)=" + new String(settlType) + sep;
			if (FixUtils.isSet(settlDate)) s += "SettlDate(64)=" + new String(settlDate) + sep;
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof BidCompReqGrp)) return false;

			BidCompReqGrp msg = (BidCompReqGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( listID, msg.listID)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!( netGrossInd==msg.netGrossInd)) return false;

		if (!Utils.equals( settlType, msg.settlType)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		return true;
	}
}
}

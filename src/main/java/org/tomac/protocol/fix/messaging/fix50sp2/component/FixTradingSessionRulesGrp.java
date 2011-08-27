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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTradingSessionRules;

public class FixTradingSessionRulesGrp
{

	public int noTradingSessionRules;
	public TradingSessionRulesGrp[] group;

	public void getAll(int noTradingSessionRules, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noTradingSessionRules = noTradingSessionRules;

		if (noTradingSessionRules < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noTradingSessionRules ).getBytes(), FixTags.NOTRADINGSESSIONRULES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noTradingSessionRules) {
			group = new TradingSessionRulesGrp[noTradingSessionRules];

			for ( int i = 0; i < noTradingSessionRules; i++ ) group[i] = new TradingSessionRulesGrp();
	}

		for ( int i = 0; i < noTradingSessionRules; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noTradingSessionRules; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noTradingSessionRules; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noTradingSessionRules; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradingSessionRulesGrp)) return false;

		FixTradingSessionRulesGrp msg = (FixTradingSessionRulesGrp) o;

		for (int i = 0; i<noTradingSessionRules; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noTradingSessionRules; i++)
			s += group[i].toString();
		return s;
	}

public class TradingSessionRulesGrp implements FixComponent
{

	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public FixTradingSessionRules tradingSessionRules;

	public TradingSessionRulesGrp() {
		super();

		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionRules = new FixTradingSessionRules();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		tradingSessionRules.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

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

			if(id == FixTags.NOORDTYPERULES_INT) {
				tradingSessionRules.getAll(FixTags.NOORDTYPERULES_INT, buf);
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

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(tradingSessionID)) return true;
		if (FixUtils.isSet(tradingSessionSubID)) return true;
		if (FixUtils.isSet(tradingSessionRules.ordTypeRules.noOrdTypeRules)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(tradingSessionRules.ordTypeRules.noOrdTypeRules)) tradingSessionRules.encode( out );
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

			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(tradingSessionRules.ordTypeRules.noOrdTypeRules)) s += tradingSessionRules.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TradingSessionRulesGrp)) return false;

			TradingSessionRulesGrp msg = (TradingSessionRulesGrp) o;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!tradingSessionRules.equals(msg.tradingSessionRules)) return false;

		return true;
	}
}
}

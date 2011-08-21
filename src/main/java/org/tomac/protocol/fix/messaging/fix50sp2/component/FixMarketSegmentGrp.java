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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSecurityTradingRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStrikeRules;

public class FixMarketSegmentGrp
{

	public int noMarketSegments;
	public MarketSegmentGrp[] group;

	public void getAll(int noMarketSegments, ByteBuffer buf) throws FixSessionException {
		this.noMarketSegments = noMarketSegments;

		if (noMarketSegments < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noMarketSegments) {
			group = new MarketSegmentGrp[noMarketSegments];

			for ( int i = 0; i < noMarketSegments; i++ ) group[i] = new MarketSegmentGrp();
	}

		for ( int i = 0; i < noMarketSegments; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noMarketSegments; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noMarketSegments; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noMarketSegments; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noMarketSegments; i++)
			s += group[i].toString();
		return s;
	}

public class MarketSegmentGrp implements FixComponent
{

	public byte[] marketID;
	public byte[] marketSegmentID;
	public FixSecurityTradingRules securityTradingRules;
	public FixStrikeRules strikeRules;

	public MarketSegmentGrp() {
		super();

		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		securityTradingRules = new FixSecurityTradingRules();
		strikeRules = new FixStrikeRules();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( marketID, (byte)0 );
		Utils.fill( marketSegmentID, (byte)0 );
		securityTradingRules.clear();
		strikeRules.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.MARKETID_INT) {
				marketID = FixUtils.getTagStringValue(value, marketID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MARKETSEGMENTID_INT) {
				marketSegmentID = FixUtils.getTagStringValue(value, marketSegmentID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.EXPIRATIONCYCLE_INT) {
				securityTradingRules.getAll(FixTags.EXPIRATIONCYCLE_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOSTRIKERULES_INT) {
				strikeRules.getAll(FixTags.NOSTRIKERULES_INT, buf);
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
		if (FixUtils.isSet(marketID)) return true;
		if (FixUtils.isSet(marketSegmentID)) return true;
		if (FixUtils.isSet(securityTradingRules.baseTradingRules.expirationCycle)) return true;
		if (FixUtils.isSet(strikeRules.noStrikeRules)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(marketID)) FixUtils.putFixTag( out, FixTags.MARKETID_INT, marketID, 0, Utils.lastIndexTrim(marketID, (byte)0) );
		if (FixUtils.isSet(marketSegmentID)) FixUtils.putFixTag( out, FixTags.MARKETSEGMENTID_INT, marketSegmentID, 0, Utils.lastIndexTrim(marketSegmentID, (byte)0) );
		if (FixUtils.isSet(securityTradingRules.baseTradingRules.expirationCycle)) securityTradingRules.encode( out );
		if (FixUtils.isSet(strikeRules.noStrikeRules)) strikeRules.encode( out );
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

			if (FixUtils.isSet(marketID)) s += "MarketID(1301)=" + new String(marketID) + sep;
			if (FixUtils.isSet(marketSegmentID)) s += "MarketSegmentID(1300)=" + new String(marketSegmentID) + sep;
			if (FixUtils.isSet(securityTradingRules.baseTradingRules.expirationCycle)) s += securityTradingRules.toString();
			if (FixUtils.isSet(strikeRules.noStrikeRules)) s += strikeRules.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof MarketSegmentGrp)) return false;

			MarketSegmentGrp msg = (MarketSegmentGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( marketID, msg.marketID)) return false;

		if (!Utils.equals( marketSegmentID, msg.marketSegmentID)) return false;

		if (!securityTradingRules.equals(msg.securityTradingRules)) return false;

		if (!strikeRules.equals(msg.strikeRules)) return false;

		return true;
	}
}
}
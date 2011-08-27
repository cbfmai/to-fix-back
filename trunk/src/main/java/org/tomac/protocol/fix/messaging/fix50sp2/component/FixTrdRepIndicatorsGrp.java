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

public class FixTrdRepIndicatorsGrp
{

	public int noTrdRepIndicators;
	public TrdRepIndicatorsGrp[] group;

	public void getAll(int noTrdRepIndicators, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noTrdRepIndicators = noTrdRepIndicators;

		if (noTrdRepIndicators < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noTrdRepIndicators ).getBytes(), FixTags.NOTRDREPINDICATORS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noTrdRepIndicators) {
			group = new TrdRepIndicatorsGrp[noTrdRepIndicators];

			for ( int i = 0; i < noTrdRepIndicators; i++ ) group[i] = new TrdRepIndicatorsGrp();
	}

		for ( int i = 0; i < noTrdRepIndicators; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noTrdRepIndicators; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noTrdRepIndicators; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noTrdRepIndicators; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdRepIndicatorsGrp)) return false;

		FixTrdRepIndicatorsGrp msg = (FixTrdRepIndicatorsGrp) o;

		for (int i = 0; i<noTrdRepIndicators; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noTrdRepIndicators; i++)
			s += group[i].toString();
		return s;
	}

public class TrdRepIndicatorsGrp implements FixComponent
{

	public long trdRepPartyRole = 0;
	public boolean trdRepIndicator = false;

	public TrdRepIndicatorsGrp() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		trdRepPartyRole = Long.MAX_VALUE;		
		trdRepIndicator = false;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.TRDREPPARTYROLE_INT) {
				trdRepPartyRole = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRDREPINDICATOR_INT) {
				trdRepIndicator = FixUtils.getTagBooleanValue( value );
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
		if (FixUtils.isSet(trdRepPartyRole)) return true;
		if (FixUtils.isSet(trdRepIndicator)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(trdRepPartyRole)) FixUtils.putFixTag( out, FixTags.TRDREPPARTYROLE_INT, trdRepPartyRole);
		if (FixUtils.isSet(trdRepIndicator)) FixUtils.putFixTag( out, FixTags.TRDREPINDICATOR_INT, trdRepIndicator?(byte)'Y':(byte)'N' );
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

			if (FixUtils.isSet(trdRepPartyRole)) s += "TrdRepPartyRole(1388)=" + String.valueOf(trdRepPartyRole) + sep;
			if (FixUtils.isSet(trdRepIndicator)) s += "TrdRepIndicator(1389)=" + String.valueOf(trdRepIndicator) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TrdRepIndicatorsGrp)) return false;

			TrdRepIndicatorsGrp msg = (TrdRepIndicatorsGrp) o;

		if (!( trdRepPartyRole==msg.trdRepPartyRole)) return false;

		if (!( trdRepIndicator==msg.trdRepIndicator)) return false;

		return true;
	}
}
}

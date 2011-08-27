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

public class FixLegStipulations
{

	public int noLegStipulations;
	public LegStipulations[] group;

	public void getAll(int noLegStipulations, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noLegStipulations = noLegStipulations;

		if (noLegStipulations < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noLegStipulations ).getBytes(), FixTags.NOLEGSTIPULATIONS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noLegStipulations) {
			group = new LegStipulations[noLegStipulations];

			for ( int i = 0; i < noLegStipulations; i++ ) group[i] = new LegStipulations();
	}

		for ( int i = 0; i < noLegStipulations; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noLegStipulations; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noLegStipulations; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noLegStipulations; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegStipulations)) return false;

		FixLegStipulations msg = (FixLegStipulations) o;

		for (int i = 0; i<noLegStipulations; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLegStipulations; i++)
			s += group[i].toString();
		return s;
	}

public class LegStipulations implements FixComponent
{

	public byte[] legStipulationType;
	public byte[] legStipulationValue;

	public LegStipulations() {
		super();

		legStipulationType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legStipulationValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( legStipulationType, (byte)0 );
		Utils.fill( legStipulationValue, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LEGSTIPULATIONTYPE_INT) {
				legStipulationType = FixUtils.getTagStringValue(value, legStipulationType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSTIPULATIONVALUE_INT) {
				legStipulationValue = FixUtils.getTagStringValue(value, legStipulationValue);
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
		if (FixUtils.isSet(legStipulationType)) return true;
		if (FixUtils.isSet(legStipulationValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(legStipulationType)) FixUtils.putFixTag( out, FixTags.LEGSTIPULATIONTYPE_INT, legStipulationType, 0, Utils.lastIndexTrim(legStipulationType, (byte)0) );
		if (FixUtils.isSet(legStipulationValue)) FixUtils.putFixTag( out, FixTags.LEGSTIPULATIONVALUE_INT, legStipulationValue, 0, Utils.lastIndexTrim(legStipulationValue, (byte)0) );
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

			if (FixUtils.isSet(legStipulationType)) s += "LegStipulationType(688)=" + new String(legStipulationType) + sep;
			if (FixUtils.isSet(legStipulationValue)) s += "LegStipulationValue(689)=" + new String(legStipulationValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof LegStipulations)) return false;

			LegStipulations msg = (LegStipulations) o;

		if (!Utils.equals( legStipulationType, msg.legStipulationType)) return false;

		if (!Utils.equals( legStipulationValue, msg.legStipulationValue)) return false;

		return true;
	}
}
}

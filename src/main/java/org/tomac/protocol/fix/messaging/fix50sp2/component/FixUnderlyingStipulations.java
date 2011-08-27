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

public class FixUnderlyingStipulations
{

	public int noUnderlyingStips;
	public UnderlyingStipulations[] group;

	public void getAll(int noUnderlyingStips, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noUnderlyingStips = noUnderlyingStips;

		if (noUnderlyingStips < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noUnderlyingStips ).getBytes(), FixTags.NOUNDERLYINGSTIPS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noUnderlyingStips) {
			group = new UnderlyingStipulations[noUnderlyingStips];

			for ( int i = 0; i < noUnderlyingStips; i++ ) group[i] = new UnderlyingStipulations();
	}

		for ( int i = 0; i < noUnderlyingStips; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noUnderlyingStips; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noUnderlyingStips; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noUnderlyingStips; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUnderlyingStipulations)) return false;

		FixUnderlyingStipulations msg = (FixUnderlyingStipulations) o;

		for (int i = 0; i<noUnderlyingStips; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noUnderlyingStips; i++)
			s += group[i].toString();
		return s;
	}

public class UnderlyingStipulations implements FixComponent
{

	public byte[] underlyingStipType;
	public byte[] underlyingStipValue;

	public UnderlyingStipulations() {
		super();

		underlyingStipType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		underlyingStipValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( underlyingStipType, (byte)0 );
		Utils.fill( underlyingStipValue, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.UNDERLYINGSTIPTYPE_INT) {
				underlyingStipType = FixUtils.getTagStringValue(value, underlyingStipType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.UNDERLYINGSTIPVALUE_INT) {
				underlyingStipValue = FixUtils.getTagStringValue(value, underlyingStipValue);
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
		if (FixUtils.isSet(underlyingStipType)) return true;
		if (FixUtils.isSet(underlyingStipValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(underlyingStipType)) FixUtils.putFixTag( out, FixTags.UNDERLYINGSTIPTYPE_INT, underlyingStipType, 0, Utils.lastIndexTrim(underlyingStipType, (byte)0) );
		if (FixUtils.isSet(underlyingStipValue)) FixUtils.putFixTag( out, FixTags.UNDERLYINGSTIPVALUE_INT, underlyingStipValue, 0, Utils.lastIndexTrim(underlyingStipValue, (byte)0) );
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

			if (FixUtils.isSet(underlyingStipType)) s += "UnderlyingStipType(888)=" + new String(underlyingStipType) + sep;
			if (FixUtils.isSet(underlyingStipValue)) s += "UnderlyingStipValue(889)=" + new String(underlyingStipValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof UnderlyingStipulations)) return false;

			UnderlyingStipulations msg = (UnderlyingStipulations) o;

		if (!Utils.equals( underlyingStipType, msg.underlyingStipType)) return false;

		if (!Utils.equals( underlyingStipValue, msg.underlyingStipValue)) return false;

		return true;
	}
}
}

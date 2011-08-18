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

public class FixHopGrp
{

	public int noHops;
	public HopGrp[] group;

	public void getAll(int noHops, ByteBuffer buf) throws FixSessionException {
		this.noHops = noHops;

		if (noHops < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noHops) 
			group = new HopGrp[noHops];

		for ( int i = 0; i < noHops; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noHops; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noHops; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noHops; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noHops; i++)
			s += group[i].toString();
		return s;
	}

public class HopGrp implements FixComponent
{

	public byte[] hopCompID;
	public byte[] hopSendingTime;
	public long hopRefID = 0;

	public HopGrp() {
		super();

		hopCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		hopSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( hopCompID, (byte)0 );
		Utils.fill( hopSendingTime, (byte)0 );
		hopRefID = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.HOPCOMPID_INT) {
				hopCompID = FixUtils.getTagStringValue(value, hopCompID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.HOPSENDINGTIME_INT) {
				hopSendingTime = FixUtils.getTagStringValue(value, hopSendingTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.HOPREFID_INT) {
				hopRefID = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(hopCompID)) return true;
		if (FixUtils.isSet(hopSendingTime)) return true;
		if (FixUtils.isSet(hopRefID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(hopCompID)) FixUtils.putFixTag( out, FixTags.HOPCOMPID_INT, hopCompID, 0, Utils.lastIndexTrim(hopCompID, (byte)0) );
		if (FixUtils.isSet(hopSendingTime)) FixUtils.putFixTag( out, FixTags.HOPSENDINGTIME_INT, hopSendingTime);
		if (FixUtils.isSet(hopRefID)) FixUtils.putFixTag( out, FixTags.HOPREFID_INT, hopRefID);
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

			if (FixUtils.isSet(hopCompID)) s += "HopCompID(628)=" + new String(hopCompID) + sep;
			if (FixUtils.isSet(hopSendingTime)) s += "HopSendingTime(629)=" + new String(hopSendingTime) + sep;
			if (FixUtils.isSet(hopRefID)) s += "HopRefID(630)=" + String.valueOf(hopRefID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof HopGrp)) return false;

			HopGrp msg = (HopGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( hopCompID, msg.hopCompID)) return false;

		if (!( hopRefID==msg.hopRefID)) return false;

		return true;
	}
}
}

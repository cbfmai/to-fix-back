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

public class FixLegSecAltIDGrp
{

	public int noLegSecurityAltID;
	public LegSecAltIDGrp[] group;

	public void getAll(int noLegSecurityAltID, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noLegSecurityAltID = noLegSecurityAltID;

		if (noLegSecurityAltID < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noLegSecurityAltID ).getBytes(), FixTags.NOLEGSECURITYALTID_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noLegSecurityAltID) {
			group = new LegSecAltIDGrp[noLegSecurityAltID];

			for ( int i = 0; i < noLegSecurityAltID; i++ ) group[i] = new LegSecAltIDGrp();
	}

		for ( int i = 0; i < noLegSecurityAltID; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noLegSecurityAltID; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noLegSecurityAltID; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noLegSecurityAltID; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegSecAltIDGrp)) return false;

		FixLegSecAltIDGrp msg = (FixLegSecAltIDGrp) o;

		for (int i = 0; i<noLegSecurityAltID; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLegSecurityAltID; i++)
			s += group[i].toString();
		return s;
	}

public class LegSecAltIDGrp implements FixComponent
{

	public byte[] noLegSecurityAltID;
	public byte[] legSecurityAltID;
	public byte[] legSecurityAltIDSource;

	public LegSecAltIDGrp() {
		super();

		noLegSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		legSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( noLegSecurityAltID, (byte)0 );
		Utils.fill( legSecurityAltID, (byte)0 );
		Utils.fill( legSecurityAltIDSource, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NOLEGSECURITYALTID_INT) {
				noLegSecurityAltID = FixUtils.getTagStringValue(value, noLegSecurityAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSECURITYALTID_INT) {
				legSecurityAltID = FixUtils.getTagStringValue(value, legSecurityAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSECURITYALTIDSOURCE_INT) {
				legSecurityAltIDSource = FixUtils.getTagStringValue(value, legSecurityAltIDSource);
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
		if (FixUtils.isSet(noLegSecurityAltID)) return true;
		if (FixUtils.isSet(legSecurityAltID)) return true;
		if (FixUtils.isSet(legSecurityAltIDSource)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(noLegSecurityAltID)) FixUtils.putFixTag( out, FixTags.NOLEGSECURITYALTID_INT, noLegSecurityAltID, 0, Utils.lastIndexTrim(noLegSecurityAltID, (byte)0) );
		if (FixUtils.isSet(legSecurityAltID)) FixUtils.putFixTag( out, FixTags.LEGSECURITYALTID_INT, legSecurityAltID, 0, Utils.lastIndexTrim(legSecurityAltID, (byte)0) );
		if (FixUtils.isSet(legSecurityAltIDSource)) FixUtils.putFixTag( out, FixTags.LEGSECURITYALTIDSOURCE_INT, legSecurityAltIDSource, 0, Utils.lastIndexTrim(legSecurityAltIDSource, (byte)0) );
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

			if (FixUtils.isSet(noLegSecurityAltID)) s += "NoLegSecurityAltID(604)=" + new String(noLegSecurityAltID) + sep;
			if (FixUtils.isSet(legSecurityAltID)) s += "LegSecurityAltID(605)=" + new String(legSecurityAltID) + sep;
			if (FixUtils.isSet(legSecurityAltIDSource)) s += "LegSecurityAltIDSource(606)=" + new String(legSecurityAltIDSource) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof LegSecAltIDGrp)) return false;

			LegSecAltIDGrp msg = (LegSecAltIDGrp) o;

		if (!Utils.equals( noLegSecurityAltID, msg.noLegSecurityAltID)) return false;

		if (!Utils.equals( legSecurityAltID, msg.legSecurityAltID)) return false;

		if (!Utils.equals( legSecurityAltIDSource, msg.legSecurityAltIDSource)) return false;

		return true;
	}
}
}

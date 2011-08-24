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

public class FixNstdPtys4SubGrp
{

	public int noNested4PartySubIDs;
	public NstdPtys4SubGrp[] group;

	public void getAll(int noNested4PartySubIDs, ByteBuffer buf) throws FixSessionException {
		this.noNested4PartySubIDs = noNested4PartySubIDs;

		if (noNested4PartySubIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noNested4PartySubIDs ).getBytes(), FixTags.NONESTED4PARTYSUBIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noNested4PartySubIDs) {
			group = new NstdPtys4SubGrp[noNested4PartySubIDs];

			for ( int i = 0; i < noNested4PartySubIDs; i++ ) group[i] = new NstdPtys4SubGrp();
	}

		for ( int i = 0; i < noNested4PartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNested4PartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNested4PartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNested4PartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNested4PartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class NstdPtys4SubGrp implements FixComponent
{

	public byte[] nested4PartySubID;
	public long nested4PartySubIDType = 0;

	public NstdPtys4SubGrp() {
		super();

		nested4PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( nested4PartySubID, (byte)0 );
		nested4PartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NESTED4PARTYSUBID_INT) {
				nested4PartySubID = FixUtils.getTagStringValue(value, nested4PartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTED4PARTYSUBIDTYPE_INT) {
				nested4PartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(nested4PartySubID)) return true;
		if (FixUtils.isSet(nested4PartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(nested4PartySubID)) FixUtils.putFixTag( out, FixTags.NESTED4PARTYSUBID_INT, nested4PartySubID, 0, Utils.lastIndexTrim(nested4PartySubID, (byte)0) );
		if (FixUtils.isSet(nested4PartySubIDType)) FixUtils.putFixTag( out, FixTags.NESTED4PARTYSUBIDTYPE_INT, nested4PartySubIDType);
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

			if (FixUtils.isSet(nested4PartySubID)) s += "Nested4PartySubID(1412)=" + new String(nested4PartySubID) + sep;
			if (FixUtils.isSet(nested4PartySubIDType)) s += "Nested4PartySubIDType(1411)=" + String.valueOf(nested4PartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NstdPtys4SubGrp)) return false;

			NstdPtys4SubGrp msg = (NstdPtys4SubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( nested4PartySubID, msg.nested4PartySubID)) return false;

		if (!( nested4PartySubIDType==msg.nested4PartySubIDType)) return false;

		return true;
	}
}
}

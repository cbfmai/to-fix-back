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

public class FixNstdPtysSubGrp
{

	public int noNestedPartySubIDs;
	public NstdPtysSubGrp[] group;

	public void getAll(int noNestedPartySubIDs, ByteBuffer buf) throws FixSessionException {
		this.noNestedPartySubIDs = noNestedPartySubIDs;

		if (noNestedPartySubIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noNestedPartySubIDs) 
			group = new NstdPtysSubGrp[noNestedPartySubIDs];

		for ( int i = 0; i < noNestedPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNestedPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNestedPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNestedPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNestedPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class NstdPtysSubGrp implements FixComponent
{

	public byte[] nestedPartySubID;
	public long nestedPartySubIDType = 0;

	public NstdPtysSubGrp() {
		super();

		nestedPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( nestedPartySubID, (byte)0 );
		nestedPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NESTEDPARTYSUBID_INT) {
				nestedPartySubID = FixUtils.getTagStringValue(value, nestedPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTEDPARTYSUBIDTYPE_INT) {
				nestedPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(nestedPartySubID)) return true;
		if (FixUtils.isSet(nestedPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(nestedPartySubID)) FixUtils.putFixTag( out, FixTags.NESTEDPARTYSUBID_INT, nestedPartySubID, 0, Utils.lastIndexTrim(nestedPartySubID, (byte)0) );
		if (FixUtils.isSet(nestedPartySubIDType)) FixUtils.putFixTag( out, FixTags.NESTEDPARTYSUBIDTYPE_INT, nestedPartySubIDType);
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

			if (FixUtils.isSet(nestedPartySubID)) s += "NestedPartySubID(545)=" + new String(nestedPartySubID) + sep;
			if (FixUtils.isSet(nestedPartySubIDType)) s += "NestedPartySubIDType(805)=" + String.valueOf(nestedPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NstdPtysSubGrp)) return false;

			NstdPtysSubGrp msg = (NstdPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( nestedPartySubID, msg.nestedPartySubID)) return false;

		if (!( nestedPartySubIDType==msg.nestedPartySubIDType)) return false;

		return true;
	}
}
}

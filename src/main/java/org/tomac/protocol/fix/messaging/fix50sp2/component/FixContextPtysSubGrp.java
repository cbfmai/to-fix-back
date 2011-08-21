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

public class FixContextPtysSubGrp
{

	public int noContextPartySubIDs;
	public ContextPtysSubGrp[] group;

	public void getAll(int noContextPartySubIDs, ByteBuffer buf) throws FixSessionException {
		this.noContextPartySubIDs = noContextPartySubIDs;

		if (noContextPartySubIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noContextPartySubIDs) {
			group = new ContextPtysSubGrp[noContextPartySubIDs];

			for ( int i = 0; i < noContextPartySubIDs; i++ ) group[i] = new ContextPtysSubGrp();
	}

		for ( int i = 0; i < noContextPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noContextPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noContextPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noContextPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noContextPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class ContextPtysSubGrp implements FixComponent
{

	public byte[] contextPartySubID;
	public long contextPartySubIDType = 0;

	public ContextPtysSubGrp() {
		super();

		contextPartySubID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( contextPartySubID, (byte)0 );
		contextPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.CONTEXTPARTYSUBID_INT) {
				contextPartySubID = FixUtils.getTagStringValue(value, contextPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CONTEXTPARTYSUBIDTYPE_INT) {
				contextPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(contextPartySubID)) return true;
		if (FixUtils.isSet(contextPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(contextPartySubID)) FixUtils.putFixTag( out, FixTags.CONTEXTPARTYSUBID_INT, contextPartySubID, 0, Utils.lastIndexTrim(contextPartySubID, (byte)0) );
		if (FixUtils.isSet(contextPartySubIDType)) FixUtils.putFixTag( out, FixTags.CONTEXTPARTYSUBIDTYPE_INT, contextPartySubIDType);
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

			if (FixUtils.isSet(contextPartySubID)) s += "ContextPartySubID(1527)=" + new String(contextPartySubID) + sep;
			if (FixUtils.isSet(contextPartySubIDType)) s += "ContextPartySubIDType(1528)=" + String.valueOf(contextPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ContextPtysSubGrp)) return false;

			ContextPtysSubGrp msg = (ContextPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( contextPartySubID, msg.contextPartySubID)) return false;

		if (!( contextPartySubIDType==msg.contextPartySubIDType)) return false;

		return true;
	}
}
}

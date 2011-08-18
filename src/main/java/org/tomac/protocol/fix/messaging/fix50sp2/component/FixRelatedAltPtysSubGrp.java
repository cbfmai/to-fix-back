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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixRelatedAltPtysSubGrp
{

	public int noRelatedPartyAltSubIDs;
	public RelatedAltPtysSubGrp[] group;

	public void getAll(int noRelatedPartyAltSubIDs, ByteBuffer buf) throws FixSessionException {
		this.noRelatedPartyAltSubIDs = noRelatedPartyAltSubIDs;

		if (noRelatedPartyAltSubIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRelatedPartyAltSubIDs) 
			group = new RelatedAltPtysSubGrp[noRelatedPartyAltSubIDs];

		for ( int i = 0; i < noRelatedPartyAltSubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedPartyAltSubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedPartyAltSubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedPartyAltSubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedPartyAltSubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RelatedAltPtysSubGrp implements FixComponent
{

	public byte[] relatedPartyAltSubID;
	public long relatedPartyAltSubIDType = 0;

	public RelatedAltPtysSubGrp() {
		super();

		relatedPartyAltSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( relatedPartyAltSubID, (byte)0 );
		relatedPartyAltSubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RELATEDPARTYALTSUBID_INT) {
				relatedPartyAltSubID = FixUtils.getTagStringValue(value, relatedPartyAltSubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATEDPARTYALTSUBIDTYPE_INT) {
				relatedPartyAltSubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(relatedPartyAltSubID)) return true;
		if (FixUtils.isSet(relatedPartyAltSubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(relatedPartyAltSubID)) FixUtils.putFixTag( out, FixTags.RELATEDPARTYALTSUBID_INT, relatedPartyAltSubID, 0, Utils.lastIndexTrim(relatedPartyAltSubID, (byte)0) );
		if (FixUtils.isSet(relatedPartyAltSubIDType)) FixUtils.putFixTag( out, FixTags.RELATEDPARTYALTSUBIDTYPE_INT, relatedPartyAltSubIDType);
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

			if (FixUtils.isSet(relatedPartyAltSubID)) s += "RelatedPartyAltSubID(1573)=" + new String(relatedPartyAltSubID) + sep;
			if (FixUtils.isSet(relatedPartyAltSubIDType)) s += "RelatedPartyAltSubIDType(1574)=" + String.valueOf(relatedPartyAltSubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelatedAltPtysSubGrp)) return false;

			RelatedAltPtysSubGrp msg = (RelatedAltPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( relatedPartyAltSubID, msg.relatedPartyAltSubID)) return false;

		if (!( relatedPartyAltSubIDType==msg.relatedPartyAltSubIDType)) return false;

		return true;
	}
}
}

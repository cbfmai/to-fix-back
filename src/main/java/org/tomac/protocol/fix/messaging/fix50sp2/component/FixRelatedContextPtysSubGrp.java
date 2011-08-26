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

public class FixRelatedContextPtysSubGrp
{

	public int noRelatedContextPartySubIDs;
	public RelatedContextPtysSubGrp[] group;

	public void getAll(int noRelatedContextPartySubIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRelatedContextPartySubIDs = noRelatedContextPartySubIDs;

		if (noRelatedContextPartySubIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRelatedContextPartySubIDs ).getBytes(), FixTags.NORELATEDCONTEXTPARTYSUBIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRelatedContextPartySubIDs) {
			group = new RelatedContextPtysSubGrp[noRelatedContextPartySubIDs];

			for ( int i = 0; i < noRelatedContextPartySubIDs; i++ ) group[i] = new RelatedContextPtysSubGrp();
	}

		for ( int i = 0; i < noRelatedContextPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedContextPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedContextPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedContextPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedContextPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RelatedContextPtysSubGrp implements FixComponent
{

	public byte[] relatedContextPartySubID;
	public long relatedContextPartySubIDType = 0;

	public RelatedContextPtysSubGrp() {
		super();

		relatedContextPartySubID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( relatedContextPartySubID, (byte)0 );
		relatedContextPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RELATEDCONTEXTPARTYSUBID_INT) {
				relatedContextPartySubID = FixUtils.getTagStringValue(value, relatedContextPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATEDCONTEXTPARTYSUBIDTYPE_INT) {
				relatedContextPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(relatedContextPartySubID)) return true;
		if (FixUtils.isSet(relatedContextPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(relatedContextPartySubID)) FixUtils.putFixTag( out, FixTags.RELATEDCONTEXTPARTYSUBID_INT, relatedContextPartySubID, 0, Utils.lastIndexTrim(relatedContextPartySubID, (byte)0) );
		if (FixUtils.isSet(relatedContextPartySubIDType)) FixUtils.putFixTag( out, FixTags.RELATEDCONTEXTPARTYSUBIDTYPE_INT, relatedContextPartySubIDType);
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

			if (FixUtils.isSet(relatedContextPartySubID)) s += "RelatedContextPartySubID(1580)=" + new String(relatedContextPartySubID) + sep;
			if (FixUtils.isSet(relatedContextPartySubIDType)) s += "RelatedContextPartySubIDType(1581)=" + String.valueOf(relatedContextPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelatedContextPtysSubGrp)) return false;

			RelatedContextPtysSubGrp msg = (RelatedContextPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( relatedContextPartySubID, msg.relatedContextPartySubID)) return false;

		if (!( relatedContextPartySubIDType==msg.relatedContextPartySubIDType)) return false;

		return true;
	}
}
}

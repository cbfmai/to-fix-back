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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRelatedContextPtysSubGrp;

public class FixRelatedContextParties
{

	public int noRelatedContextPartyIDs;
	public RelatedContextParties[] group;

	public void getAll(int noRelatedContextPartyIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRelatedContextPartyIDs = noRelatedContextPartyIDs;

		if (noRelatedContextPartyIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRelatedContextPartyIDs ).getBytes(), FixTags.NORELATEDCONTEXTPARTYIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRelatedContextPartyIDs) {
			group = new RelatedContextParties[noRelatedContextPartyIDs];

			for ( int i = 0; i < noRelatedContextPartyIDs; i++ ) group[i] = new RelatedContextParties();
	}

		for ( int i = 0; i < noRelatedContextPartyIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedContextPartyIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedContextPartyIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedContextPartyIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedContextPartyIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RelatedContextParties implements FixComponent
{

	public byte[] relatedContextPartyID;
	public byte relatedContextPartyIDSource = (byte)' ';
	public long relatedContextPartyRole = 0;
	public FixRelatedContextPtysSubGrp relatedContextPtysSubGrp;

	public RelatedContextParties() {
		super();

		relatedContextPartyID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		relatedContextPtysSubGrp = new FixRelatedContextPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( relatedContextPartyID, (byte)0 );
		relatedContextPartyIDSource = Byte.MAX_VALUE;		
		relatedContextPartyRole = Long.MAX_VALUE;		
		relatedContextPtysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RELATEDCONTEXTPARTYID_INT) {
				relatedContextPartyID = FixUtils.getTagStringValue(value, relatedContextPartyID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATEDCONTEXTPARTYIDSOURCE_INT) {
				relatedContextPartyIDSource = FixUtils.getTagCharValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATEDCONTEXTPARTYROLE_INT) {
				relatedContextPartyRole = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORELATEDCONTEXTPARTYSUBIDS_INT) {
				relatedContextPtysSubGrp.getAll(FixTags.NORELATEDCONTEXTPARTYSUBIDS_INT, buf);
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
		if (FixUtils.isSet(relatedContextPartyID)) return true;
		if (FixUtils.isSet(relatedContextPartyIDSource)) return true;
		if (FixUtils.isSet(relatedContextPartyRole)) return true;
		if (FixUtils.isSet(relatedContextPtysSubGrp.noRelatedContextPartySubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(relatedContextPartyID)) FixUtils.putFixTag( out, FixTags.RELATEDCONTEXTPARTYID_INT, relatedContextPartyID, 0, Utils.lastIndexTrim(relatedContextPartyID, (byte)0) );
		if (FixUtils.isSet(relatedContextPartyIDSource)) FixUtils.putFixTag( out, FixTags.RELATEDCONTEXTPARTYIDSOURCE_INT, relatedContextPartyIDSource );
		if (FixUtils.isSet(relatedContextPartyRole)) FixUtils.putFixTag( out, FixTags.RELATEDCONTEXTPARTYROLE_INT, relatedContextPartyRole);
		if (FixUtils.isSet(relatedContextPtysSubGrp.noRelatedContextPartySubIDs)) relatedContextPtysSubGrp.encode( out );
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

			if (FixUtils.isSet(relatedContextPartyID)) s += "RelatedContextPartyID(1576)=" + new String(relatedContextPartyID) + sep;
			if (FixUtils.isSet(relatedContextPartyIDSource)) s += "RelatedContextPartyIDSource(1577)=" + String.valueOf(relatedContextPartyIDSource) + sep;
			if (FixUtils.isSet(relatedContextPartyRole)) s += "RelatedContextPartyRole(1578)=" + String.valueOf(relatedContextPartyRole) + sep;
			if (FixUtils.isSet(relatedContextPtysSubGrp.noRelatedContextPartySubIDs)) s += relatedContextPtysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelatedContextParties)) return false;

			RelatedContextParties msg = (RelatedContextParties) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( relatedContextPartyID, msg.relatedContextPartyID)) return false;

		if (!( relatedContextPartyIDSource==msg.relatedContextPartyIDSource)) return false;

		if (!( relatedContextPartyRole==msg.relatedContextPartyRole)) return false;

		if (!relatedContextPtysSubGrp.equals(msg.relatedContextPtysSubGrp)) return false;

		return true;
	}
}
}

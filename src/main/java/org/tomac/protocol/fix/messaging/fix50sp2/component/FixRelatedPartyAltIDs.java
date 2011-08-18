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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRelatedAltPtysSubGrp;

public class FixRelatedPartyAltIDs
{

	public int noRelatedPartyAltIDs;
	public RelatedPartyAltIDs[] group;

	public void getAll(int noRelatedPartyAltIDs, ByteBuffer buf) throws FixSessionException {
		this.noRelatedPartyAltIDs = noRelatedPartyAltIDs;

		if (noRelatedPartyAltIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRelatedPartyAltIDs) 
			group = new RelatedPartyAltIDs[noRelatedPartyAltIDs];

		for ( int i = 0; i < noRelatedPartyAltIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedPartyAltIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedPartyAltIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedPartyAltIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedPartyAltIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RelatedPartyAltIDs implements FixComponent
{

	public byte[] relatedPartyAltID;
	public byte relatedPartyAltIDSource = (byte)' ';
	public FixRelatedAltPtysSubGrp relatedAltPtysSubGrp;

	public RelatedPartyAltIDs() {
		super();

		relatedPartyAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		relatedAltPtysSubGrp = new FixRelatedAltPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( relatedPartyAltID, (byte)0 );
		relatedPartyAltIDSource = Byte.MAX_VALUE;		
		relatedAltPtysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RELATEDPARTYALTID_INT) {
				relatedPartyAltID = FixUtils.getTagStringValue(value, relatedPartyAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATEDPARTYALTIDSOURCE_INT) {
				relatedPartyAltIDSource = FixUtils.getTagCharValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORELATEDPARTYALTSUBIDS_INT) {
				relatedAltPtysSubGrp.getAll(FixTags.NORELATEDPARTYALTSUBIDS_INT, buf);
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
		if (FixUtils.isSet(relatedPartyAltID)) return true;
		if (FixUtils.isSet(relatedPartyAltIDSource)) return true;
		if (FixUtils.isSet(relatedAltPtysSubGrp.noRelatedPartyAltSubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(relatedPartyAltID)) FixUtils.putFixTag( out, FixTags.RELATEDPARTYALTID_INT, relatedPartyAltID, 0, Utils.lastIndexTrim(relatedPartyAltID, (byte)0) );
		if (FixUtils.isSet(relatedPartyAltIDSource)) FixUtils.putFixTag( out, FixTags.RELATEDPARTYALTIDSOURCE_INT, relatedPartyAltIDSource );
		if (FixUtils.isSet(relatedAltPtysSubGrp.noRelatedPartyAltSubIDs)) relatedAltPtysSubGrp.encode( out );
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

			if (FixUtils.isSet(relatedPartyAltID)) s += "RelatedPartyAltID(1570)=" + new String(relatedPartyAltID) + sep;
			if (FixUtils.isSet(relatedPartyAltIDSource)) s += "RelatedPartyAltIDSource(1571)=" + String.valueOf(relatedPartyAltIDSource) + sep;
			if (FixUtils.isSet(relatedAltPtysSubGrp.noRelatedPartyAltSubIDs)) s += relatedAltPtysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelatedPartyAltIDs)) return false;

			RelatedPartyAltIDs msg = (RelatedPartyAltIDs) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( relatedPartyAltID, msg.relatedPartyAltID)) return false;

		if (!( relatedPartyAltIDSource==msg.relatedPartyAltIDSource)) return false;

		if (!relatedAltPtysSubGrp.equals(msg.relatedAltPtysSubGrp)) return false;

		return true;
	}
}
}

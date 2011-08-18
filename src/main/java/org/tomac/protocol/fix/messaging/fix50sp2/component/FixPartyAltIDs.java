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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixAltPtysSubGrp;

public class FixPartyAltIDs
{

	public int noPartyAltIDs;
	public PartyAltIDs[] group;

	public void getAll(int noPartyAltIDs, ByteBuffer buf) throws FixSessionException {
		this.noPartyAltIDs = noPartyAltIDs;

		if (noPartyAltIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noPartyAltIDs) 
			group = new PartyAltIDs[noPartyAltIDs];

		for ( int i = 0; i < noPartyAltIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noPartyAltIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noPartyAltIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noPartyAltIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noPartyAltIDs; i++)
			s += group[i].toString();
		return s;
	}

public class PartyAltIDs implements FixComponent
{

	public byte[] partyAltID;
	public byte partyAltIDSource = (byte)' ';
	public FixAltPtysSubGrp altPtysSubGrp;

	public PartyAltIDs() {
		super();

		partyAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		altPtysSubGrp = new FixAltPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( partyAltID, (byte)0 );
		partyAltIDSource = Byte.MAX_VALUE;		
		altPtysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.PARTYALTID_INT) {
				partyAltID = FixUtils.getTagStringValue(value, partyAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PARTYALTIDSOURCE_INT) {
				partyAltIDSource = FixUtils.getTagCharValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOPARTYALTSUBIDS_INT) {
				altPtysSubGrp.getAll(FixTags.NOPARTYALTSUBIDS_INT, buf);
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
		if (FixUtils.isSet(partyAltID)) return true;
		if (FixUtils.isSet(partyAltIDSource)) return true;
		if (FixUtils.isSet(altPtysSubGrp.noPartyAltSubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(partyAltID)) FixUtils.putFixTag( out, FixTags.PARTYALTID_INT, partyAltID, 0, Utils.lastIndexTrim(partyAltID, (byte)0) );
		if (FixUtils.isSet(partyAltIDSource)) FixUtils.putFixTag( out, FixTags.PARTYALTIDSOURCE_INT, partyAltIDSource );
		if (FixUtils.isSet(altPtysSubGrp.noPartyAltSubIDs)) altPtysSubGrp.encode( out );
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

			if (FixUtils.isSet(partyAltID)) s += "PartyAltID(1517)=" + new String(partyAltID) + sep;
			if (FixUtils.isSet(partyAltIDSource)) s += "PartyAltIDSource(1518)=" + String.valueOf(partyAltIDSource) + sep;
			if (FixUtils.isSet(altPtysSubGrp.noPartyAltSubIDs)) s += altPtysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof PartyAltIDs)) return false;

			PartyAltIDs msg = (PartyAltIDs) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( partyAltID, msg.partyAltID)) return false;

		if (!( partyAltIDSource==msg.partyAltIDSource)) return false;

		if (!altPtysSubGrp.equals(msg.altPtysSubGrp)) return false;

		return true;
	}
}
}

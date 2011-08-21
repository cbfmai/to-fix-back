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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPtysSubGrp;

public class FixParties
{

	public int noPartyIDs;
	public Parties[] group;

	public void getAll(int noPartyIDs, ByteBuffer buf) throws FixSessionException {
		this.noPartyIDs = noPartyIDs;

		if (noPartyIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noPartyIDs) {
			group = new Parties[noPartyIDs];

			for ( int i = 0; i < noPartyIDs; i++ ) group[i] = new Parties();
	}

		for ( int i = 0; i < noPartyIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noPartyIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noPartyIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noPartyIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noPartyIDs; i++)
			s += group[i].toString();
		return s;
	}

public class Parties implements FixComponent
{

	public byte[] partyID;
	public byte partyIDSource = (byte)' ';
	public long partyRole = 0;
	public FixPtysSubGrp ptysSubGrp;

	public Parties() {
		super();

		partyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		ptysSubGrp = new FixPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( partyID, (byte)0 );
		partyIDSource = Byte.MAX_VALUE;		
		partyRole = Long.MAX_VALUE;		
		ptysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.PARTYID_INT) {
				partyID = FixUtils.getTagStringValue(value, partyID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PARTYIDSOURCE_INT) {
				partyIDSource = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.PartyIDSource.isValid(partyIDSource) ) throw new FixSessionException(buf, "Invalid enumerated value(" + partyIDSource + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PARTYROLE_INT) {
				partyRole = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.PartyRole.isValid(partyRole) ) throw new FixSessionException(buf, "Invalid enumerated value(" + partyRole + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOPARTYSUBIDS_INT) {
				ptysSubGrp.getAll(FixTags.NOPARTYSUBIDS_INT, buf);
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
		if (FixUtils.isSet(partyID)) return true;
		if (FixUtils.isSet(partyIDSource)) return true;
		if (FixUtils.isSet(partyRole)) return true;
		if (FixUtils.isSet(ptysSubGrp.noPartySubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(partyID)) FixUtils.putFixTag( out, FixTags.PARTYID_INT, partyID, 0, Utils.lastIndexTrim(partyID, (byte)0) );
		if (FixUtils.isSet(partyIDSource)) FixUtils.putFixTag( out, FixTags.PARTYIDSOURCE_INT, partyIDSource );
		if (FixUtils.isSet(partyRole)) FixUtils.putFixTag( out, FixTags.PARTYROLE_INT, partyRole);
		if (FixUtils.isSet(ptysSubGrp.noPartySubIDs)) ptysSubGrp.encode( out );
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

			if (FixUtils.isSet(partyID)) s += "PartyID(448)=" + new String(partyID) + sep;
			if (FixUtils.isSet(partyIDSource)) s += "PartyIDSource(447)=" + String.valueOf(partyIDSource) + sep;
			if (FixUtils.isSet(partyRole)) s += "PartyRole(452)=" + String.valueOf(partyRole) + sep;
			if (FixUtils.isSet(ptysSubGrp.noPartySubIDs)) s += ptysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof Parties)) return false;

			Parties msg = (Parties) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( partyID, msg.partyID)) return false;

		if (!( partyIDSource==msg.partyIDSource)) return false;

		if (!( partyRole==msg.partyRole)) return false;

		if (!ptysSubGrp.equals(msg.ptysSubGrp)) return false;

		return true;
	}
}
}

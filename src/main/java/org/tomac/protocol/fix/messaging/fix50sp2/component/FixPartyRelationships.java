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

public class FixPartyRelationships
{

	public int noPartyRelationships;
	public PartyRelationships[] group;

	public void getAll(int noPartyRelationships, ByteBuffer buf) throws FixSessionException {
		this.noPartyRelationships = noPartyRelationships;

		if (noPartyRelationships < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noPartyRelationships) 
			group = new PartyRelationships[noPartyRelationships];

		for ( int i = 0; i < noPartyRelationships; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noPartyRelationships; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noPartyRelationships; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noPartyRelationships; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noPartyRelationships; i++)
			s += group[i].toString();
		return s;
	}

public class PartyRelationships implements FixComponent
{

	public long partyRelationship = 0;

	public PartyRelationships() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		partyRelationship = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.PARTYRELATIONSHIP_INT) {
				partyRelationship = FixUtils.getTagIntValue( value );
				if (!PartyRelationship.isValid(partyRelationship) ) throw new FixSessionException(buf, "Invalid enumerated value(" + partyRelationship + ") for tag: " + id );
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
		if (FixUtils.isSet(partyRelationship)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(partyRelationship)) FixUtils.putFixTag( out, FixTags.PARTYRELATIONSHIP_INT, partyRelationship);
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

			if (FixUtils.isSet(partyRelationship)) s += "PartyRelationship(1515)=" + String.valueOf(partyRelationship) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof PartyRelationships)) return false;

			PartyRelationships msg = (PartyRelationships) o;

		if ( ! super.equals(msg) ) return false;

		if (!( partyRelationship==msg.partyRelationship)) return false;

		return true;
	}
}
}

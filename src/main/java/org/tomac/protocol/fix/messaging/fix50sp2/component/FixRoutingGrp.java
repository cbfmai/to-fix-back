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

public class FixRoutingGrp
{

	public int noRoutingIDs;
	public RoutingGrp[] group;

	public void getAll(int noRoutingIDs, ByteBuffer buf) throws FixSessionException {
		this.noRoutingIDs = noRoutingIDs;

		if (noRoutingIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRoutingIDs) 
			group = new RoutingGrp[noRoutingIDs];

		for ( int i = 0; i < noRoutingIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRoutingIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRoutingIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRoutingIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRoutingIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RoutingGrp implements FixComponent
{

	public long routingType = 0;
	public byte[] routingID;

	public RoutingGrp() {
		super();

		routingID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		routingType = Long.MAX_VALUE;		
		Utils.fill( routingID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.ROUTINGTYPE_INT) {
				routingType = FixUtils.getTagIntValue( value );
				if (!RoutingType.isValid(routingType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + routingType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ROUTINGID_INT) {
				routingID = FixUtils.getTagStringValue(value, routingID);
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
		if (FixUtils.isSet(routingType)) return true;
		if (FixUtils.isSet(routingID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(routingType)) FixUtils.putFixTag( out, FixTags.ROUTINGTYPE_INT, routingType);
		if (FixUtils.isSet(routingID)) FixUtils.putFixTag( out, FixTags.ROUTINGID_INT, routingID, 0, Utils.lastIndexTrim(routingID, (byte)0) );
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

			if (FixUtils.isSet(routingType)) s += "RoutingType(216)=" + String.valueOf(routingType) + sep;
			if (FixUtils.isSet(routingID)) s += "RoutingID(217)=" + new String(routingID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RoutingGrp)) return false;

			RoutingGrp msg = (RoutingGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( routingType==msg.routingType)) return false;

		if (!Utils.equals( routingID, msg.routingID)) return false;

		return true;
	}
}
}

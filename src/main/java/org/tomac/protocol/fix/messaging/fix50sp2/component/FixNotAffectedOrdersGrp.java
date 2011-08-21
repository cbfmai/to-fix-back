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

public class FixNotAffectedOrdersGrp
{

	public int noNotAffectedOrders;
	public NotAffectedOrdersGrp[] group;

	public void getAll(int noNotAffectedOrders, ByteBuffer buf) throws FixSessionException {
		this.noNotAffectedOrders = noNotAffectedOrders;

		if (noNotAffectedOrders < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noNotAffectedOrders) {
			group = new NotAffectedOrdersGrp[noNotAffectedOrders];

			for ( int i = 0; i < noNotAffectedOrders; i++ ) group[i] = new NotAffectedOrdersGrp();
	}

		for ( int i = 0; i < noNotAffectedOrders; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNotAffectedOrders; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNotAffectedOrders; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNotAffectedOrders; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNotAffectedOrders; i++)
			s += group[i].toString();
		return s;
	}

public class NotAffectedOrdersGrp implements FixComponent
{

	public byte[] notAffOrigClOrdID;
	public byte[] notAffectedOrderID;

	public NotAffectedOrdersGrp() {
		super();

		notAffOrigClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		notAffectedOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( notAffOrigClOrdID, (byte)0 );
		Utils.fill( notAffectedOrderID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NOTAFFORIGCLORDID_INT) {
				notAffOrigClOrdID = FixUtils.getTagStringValue(value, notAffOrigClOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOTAFFECTEDORDERID_INT) {
				notAffectedOrderID = FixUtils.getTagStringValue(value, notAffectedOrderID);
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
		if (FixUtils.isSet(notAffOrigClOrdID)) return true;
		if (FixUtils.isSet(notAffectedOrderID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(notAffOrigClOrdID)) FixUtils.putFixTag( out, FixTags.NOTAFFORIGCLORDID_INT, notAffOrigClOrdID, 0, Utils.lastIndexTrim(notAffOrigClOrdID, (byte)0) );
		if (FixUtils.isSet(notAffectedOrderID)) FixUtils.putFixTag( out, FixTags.NOTAFFECTEDORDERID_INT, notAffectedOrderID, 0, Utils.lastIndexTrim(notAffectedOrderID, (byte)0) );
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

			if (FixUtils.isSet(notAffOrigClOrdID)) s += "NotAffOrigClOrdID(1372)=" + new String(notAffOrigClOrdID) + sep;
			if (FixUtils.isSet(notAffectedOrderID)) s += "NotAffectedOrderID(1371)=" + new String(notAffectedOrderID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NotAffectedOrdersGrp)) return false;

			NotAffectedOrdersGrp msg = (NotAffectedOrdersGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( notAffOrigClOrdID, msg.notAffOrigClOrdID)) return false;

		if (!Utils.equals( notAffectedOrderID, msg.notAffectedOrderID)) return false;

		return true;
	}
}
}
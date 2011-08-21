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

public class FixIOIQualGrp
{

	public int noIOIQualifiers;
	public IOIQualGrp[] group;

	public void getAll(int noIOIQualifiers, ByteBuffer buf) throws FixSessionException {
		this.noIOIQualifiers = noIOIQualifiers;

		if (noIOIQualifiers < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noIOIQualifiers) {
			group = new IOIQualGrp[noIOIQualifiers];

			for ( int i = 0; i < noIOIQualifiers; i++ ) group[i] = new IOIQualGrp();
	}

		for ( int i = 0; i < noIOIQualifiers; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noIOIQualifiers; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noIOIQualifiers; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noIOIQualifiers; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noIOIQualifiers; i++)
			s += group[i].toString();
		return s;
	}

public class IOIQualGrp implements FixComponent
{

	public byte iOIQualifier = (byte)' ';

	public IOIQualGrp() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		iOIQualifier = Byte.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.IOIQUALIFIER_INT) {
				iOIQualifier = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.IOIQualifier.isValid(iOIQualifier) ) throw new FixSessionException(buf, "Invalid enumerated value(" + iOIQualifier + ") for tag: " + id );
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
		if (FixUtils.isSet(iOIQualifier)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(iOIQualifier)) FixUtils.putFixTag( out, FixTags.IOIQUALIFIER_INT, iOIQualifier );
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

			if (FixUtils.isSet(iOIQualifier)) s += "IOIQualifier(104)=" + String.valueOf(iOIQualifier) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof IOIQualGrp)) return false;

			IOIQualGrp msg = (IOIQualGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( iOIQualifier==msg.iOIQualifier)) return false;

		return true;
	}
}
}

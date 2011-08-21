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

public class FixInstrumentPtysSubGrp
{

	public int noInstrumentPartySubIDs;
	public InstrumentPtysSubGrp[] group;

	public void getAll(int noInstrumentPartySubIDs, ByteBuffer buf) throws FixSessionException {
		this.noInstrumentPartySubIDs = noInstrumentPartySubIDs;

		if (noInstrumentPartySubIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noInstrumentPartySubIDs) {
			group = new InstrumentPtysSubGrp[noInstrumentPartySubIDs];

			for ( int i = 0; i < noInstrumentPartySubIDs; i++ ) group[i] = new InstrumentPtysSubGrp();
	}

		for ( int i = 0; i < noInstrumentPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noInstrumentPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noInstrumentPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noInstrumentPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noInstrumentPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class InstrumentPtysSubGrp implements FixComponent
{

	public byte[] instrumentPartySubID;
	public long instrumentPartySubIDType = 0;

	public InstrumentPtysSubGrp() {
		super();

		instrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( instrumentPartySubID, (byte)0 );
		instrumentPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.INSTRUMENTPARTYSUBID_INT) {
				instrumentPartySubID = FixUtils.getTagStringValue(value, instrumentPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INSTRUMENTPARTYSUBIDTYPE_INT) {
				instrumentPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(instrumentPartySubID)) return true;
		if (FixUtils.isSet(instrumentPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrumentPartySubID)) FixUtils.putFixTag( out, FixTags.INSTRUMENTPARTYSUBID_INT, instrumentPartySubID, 0, Utils.lastIndexTrim(instrumentPartySubID, (byte)0) );
		if (FixUtils.isSet(instrumentPartySubIDType)) FixUtils.putFixTag( out, FixTags.INSTRUMENTPARTYSUBIDTYPE_INT, instrumentPartySubIDType);
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

			if (FixUtils.isSet(instrumentPartySubID)) s += "InstrumentPartySubID(1053)=" + new String(instrumentPartySubID) + sep;
			if (FixUtils.isSet(instrumentPartySubIDType)) s += "InstrumentPartySubIDType(1054)=" + String.valueOf(instrumentPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof InstrumentPtysSubGrp)) return false;

			InstrumentPtysSubGrp msg = (InstrumentPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( instrumentPartySubID, msg.instrumentPartySubID)) return false;

		if (!( instrumentPartySubIDType==msg.instrumentPartySubIDType)) return false;

		return true;
	}
}
}

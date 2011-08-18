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

public class FixMiscFeesGrp
{

	public int noMiscFees;
	public MiscFeesGrp[] group;

	public void getAll(int noMiscFees, ByteBuffer buf) throws FixSessionException {
		this.noMiscFees = noMiscFees;

		if (noMiscFees < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noMiscFees) 
			group = new MiscFeesGrp[noMiscFees];

		for ( int i = 0; i < noMiscFees; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noMiscFees; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noMiscFees; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noMiscFees; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noMiscFees; i++)
			s += group[i].toString();
		return s;
	}

public class MiscFeesGrp implements FixComponent
{

	public long miscFeeAmt = 0;
	public byte[] miscFeeCurr;
	public byte[] miscFeeType;
	public long miscFeeBasis = 0;

	public MiscFeesGrp() {
		super();

		miscFeeCurr = new byte[FixUtils.CURRENCY_LENGTH];
		miscFeeType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		miscFeeAmt = Long.MAX_VALUE;		
		Utils.fill( miscFeeCurr, (byte)0 );
		Utils.fill( miscFeeType, (byte)0 );
		miscFeeBasis = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.MISCFEEAMT_INT) {
				miscFeeAmt = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MISCFEECURR_INT) {
				miscFeeCurr = FixUtils.getTagStringValue(value, miscFeeCurr);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MISCFEETYPE_INT) {
				miscFeeType = FixUtils.getTagStringValue(value, miscFeeType);
				if (!MiscFeeType.isValid(miscFeeType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + miscFeeType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MISCFEEBASIS_INT) {
				miscFeeBasis = FixUtils.getTagIntValue( value );
				if (!MiscFeeBasis.isValid(miscFeeBasis) ) throw new FixSessionException(buf, "Invalid enumerated value(" + miscFeeBasis + ") for tag: " + id );
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
		if (FixUtils.isSet(miscFeeAmt)) return true;
		if (FixUtils.isSet(miscFeeCurr)) return true;
		if (FixUtils.isSet(miscFeeType)) return true;
		if (FixUtils.isSet(miscFeeBasis)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(miscFeeAmt)) FixUtils.putFixTag( out, FixTags.MISCFEEAMT_INT, miscFeeAmt);
		if (FixUtils.isSet(miscFeeCurr)) FixUtils.putFixTag( out, FixTags.MISCFEECURR_INT, miscFeeCurr, 0, Utils.lastIndexTrim(miscFeeCurr, (byte)0) );
		if (FixUtils.isSet(miscFeeType)) FixUtils.putFixTag( out, FixTags.MISCFEETYPE_INT, miscFeeType, 0, Utils.lastIndexTrim(miscFeeType, (byte)0) );
		if (FixUtils.isSet(miscFeeBasis)) FixUtils.putFixTag( out, FixTags.MISCFEEBASIS_INT, miscFeeBasis);
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

			if (FixUtils.isSet(miscFeeAmt)) s += "MiscFeeAmt(137)=" + String.valueOf(miscFeeAmt) + sep;
			if (FixUtils.isSet(miscFeeCurr)) s += "MiscFeeCurr(138)=" + new String(miscFeeCurr) + sep;
			if (FixUtils.isSet(miscFeeType)) s += "MiscFeeType(139)=" + new String(miscFeeType) + sep;
			if (FixUtils.isSet(miscFeeBasis)) s += "MiscFeeBasis(891)=" + String.valueOf(miscFeeBasis) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof MiscFeesGrp)) return false;

			MiscFeesGrp msg = (MiscFeesGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( miscFeeAmt==msg.miscFeeAmt)) return false;

		if (!Utils.equals( miscFeeCurr, msg.miscFeeCurr)) return false;

		if (!Utils.equals( miscFeeType, msg.miscFeeType)) return false;

		if (!( miscFeeBasis==msg.miscFeeBasis)) return false;

		return true;
	}
}
}

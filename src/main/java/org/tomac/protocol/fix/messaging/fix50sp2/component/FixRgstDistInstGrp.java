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

public class FixRgstDistInstGrp
{

	public int noDistribInsts;
	public RgstDistInstGrp[] group;

	public void getAll(int noDistribInsts, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noDistribInsts = noDistribInsts;

		if (noDistribInsts < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noDistribInsts ).getBytes(), FixTags.NODISTRIBINSTS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noDistribInsts) {
			group = new RgstDistInstGrp[noDistribInsts];

			for ( int i = 0; i < noDistribInsts; i++ ) group[i] = new RgstDistInstGrp();
	}

		for ( int i = 0; i < noDistribInsts; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noDistribInsts; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noDistribInsts; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noDistribInsts; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRgstDistInstGrp)) return false;

		FixRgstDistInstGrp msg = (FixRgstDistInstGrp) o;

		for (int i = 0; i<noDistribInsts; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noDistribInsts; i++)
			s += group[i].toString();
		return s;
	}

public class RgstDistInstGrp implements FixComponent
{

	public long distribPaymentMethod = 0;
	public long distribPercentage = 0;
	public byte[] cashDistribCurr;
	public byte[] cashDistribAgentName;
	public byte[] cashDistribAgentCode;
	public byte[] cashDistribAgentAcctNumber;
	public byte[] cashDistribPayRef;
	public byte[] cashDistribAgentAcctName;

	public RgstDistInstGrp() {
		super();

		cashDistribCurr = new byte[FixUtils.CURRENCY_LENGTH];
		cashDistribAgentName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		cashDistribAgentCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		cashDistribAgentAcctNumber = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		cashDistribPayRef = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		cashDistribAgentAcctName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		distribPaymentMethod = Long.MAX_VALUE;		
		distribPercentage = Long.MAX_VALUE;		
		Utils.fill( cashDistribCurr, (byte)0 );
		Utils.fill( cashDistribAgentName, (byte)0 );
		Utils.fill( cashDistribAgentCode, (byte)0 );
		Utils.fill( cashDistribAgentAcctNumber, (byte)0 );
		Utils.fill( cashDistribPayRef, (byte)0 );
		Utils.fill( cashDistribAgentAcctName, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.DISTRIBPAYMENTMETHOD_INT) {
				distribPaymentMethod = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.DistribPaymentMethod.isValid(distribPaymentMethod) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + distribPaymentMethod + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DISTRIBPERCENTAGE_INT) {
				distribPercentage = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHDISTRIBCURR_INT) {
				cashDistribCurr = FixUtils.getTagStringValue(value, cashDistribCurr);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHDISTRIBAGENTNAME_INT) {
				cashDistribAgentName = FixUtils.getTagStringValue(value, cashDistribAgentName);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHDISTRIBAGENTCODE_INT) {
				cashDistribAgentCode = FixUtils.getTagStringValue(value, cashDistribAgentCode);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHDISTRIBAGENTACCTNUMBER_INT) {
				cashDistribAgentAcctNumber = FixUtils.getTagStringValue(value, cashDistribAgentAcctNumber);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHDISTRIBPAYREF_INT) {
				cashDistribPayRef = FixUtils.getTagStringValue(value, cashDistribPayRef);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHDISTRIBAGENTACCTNAME_INT) {
				cashDistribAgentAcctName = FixUtils.getTagStringValue(value, cashDistribAgentAcctName);
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
		if (FixUtils.isSet(distribPaymentMethod)) return true;
		if (FixUtils.isSet(distribPercentage)) return true;
		if (FixUtils.isSet(cashDistribCurr)) return true;
		if (FixUtils.isSet(cashDistribAgentName)) return true;
		if (FixUtils.isSet(cashDistribAgentCode)) return true;
		if (FixUtils.isSet(cashDistribAgentAcctNumber)) return true;
		if (FixUtils.isSet(cashDistribPayRef)) return true;
		if (FixUtils.isSet(cashDistribAgentAcctName)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(distribPaymentMethod)) FixUtils.putFixTag( out, FixTags.DISTRIBPAYMENTMETHOD_INT, distribPaymentMethod);
		if (FixUtils.isSet(distribPercentage)) FixUtils.putFixFloatTag( out, FixTags.DISTRIBPERCENTAGE_INT, distribPercentage);
		if (FixUtils.isSet(cashDistribCurr)) FixUtils.putFixTag( out, FixTags.CASHDISTRIBCURR_INT, cashDistribCurr, 0, Utils.lastIndexTrim(cashDistribCurr, (byte)0) );
		if (FixUtils.isSet(cashDistribAgentName)) FixUtils.putFixTag( out, FixTags.CASHDISTRIBAGENTNAME_INT, cashDistribAgentName, 0, Utils.lastIndexTrim(cashDistribAgentName, (byte)0) );
		if (FixUtils.isSet(cashDistribAgentCode)) FixUtils.putFixTag( out, FixTags.CASHDISTRIBAGENTCODE_INT, cashDistribAgentCode, 0, Utils.lastIndexTrim(cashDistribAgentCode, (byte)0) );
		if (FixUtils.isSet(cashDistribAgentAcctNumber)) FixUtils.putFixTag( out, FixTags.CASHDISTRIBAGENTACCTNUMBER_INT, cashDistribAgentAcctNumber, 0, Utils.lastIndexTrim(cashDistribAgentAcctNumber, (byte)0) );
		if (FixUtils.isSet(cashDistribPayRef)) FixUtils.putFixTag( out, FixTags.CASHDISTRIBPAYREF_INT, cashDistribPayRef, 0, Utils.lastIndexTrim(cashDistribPayRef, (byte)0) );
		if (FixUtils.isSet(cashDistribAgentAcctName)) FixUtils.putFixTag( out, FixTags.CASHDISTRIBAGENTACCTNAME_INT, cashDistribAgentAcctName, 0, Utils.lastIndexTrim(cashDistribAgentAcctName, (byte)0) );
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

			if (FixUtils.isSet(distribPaymentMethod)) s += "DistribPaymentMethod(477)=" + String.valueOf(distribPaymentMethod) + sep;
			if (FixUtils.isSet(distribPercentage)) s += "DistribPercentage(512)=" + String.valueOf(distribPercentage) + sep;
			if (FixUtils.isSet(cashDistribCurr)) s += "CashDistribCurr(478)=" + new String(cashDistribCurr) + sep;
			if (FixUtils.isSet(cashDistribAgentName)) s += "CashDistribAgentName(498)=" + new String(cashDistribAgentName) + sep;
			if (FixUtils.isSet(cashDistribAgentCode)) s += "CashDistribAgentCode(499)=" + new String(cashDistribAgentCode) + sep;
			if (FixUtils.isSet(cashDistribAgentAcctNumber)) s += "CashDistribAgentAcctNumber(500)=" + new String(cashDistribAgentAcctNumber) + sep;
			if (FixUtils.isSet(cashDistribPayRef)) s += "CashDistribPayRef(501)=" + new String(cashDistribPayRef) + sep;
			if (FixUtils.isSet(cashDistribAgentAcctName)) s += "CashDistribAgentAcctName(502)=" + new String(cashDistribAgentAcctName) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RgstDistInstGrp)) return false;

			RgstDistInstGrp msg = (RgstDistInstGrp) o;

		if (!( distribPaymentMethod==msg.distribPaymentMethod)) return false;

		if (!( distribPercentage==msg.distribPercentage)) return false;

		if (!Utils.equals( cashDistribCurr, msg.cashDistribCurr)) return false;

		if (!Utils.equals( cashDistribAgentName, msg.cashDistribAgentName)) return false;

		if (!Utils.equals( cashDistribAgentCode, msg.cashDistribAgentCode)) return false;

		if (!Utils.equals( cashDistribAgentAcctNumber, msg.cashDistribAgentAcctNumber)) return false;

		if (!Utils.equals( cashDistribPayRef, msg.cashDistribPayRef)) return false;

		if (!Utils.equals( cashDistribAgentAcctName, msg.cashDistribAgentAcctName)) return false;

		return true;
	}
}
}

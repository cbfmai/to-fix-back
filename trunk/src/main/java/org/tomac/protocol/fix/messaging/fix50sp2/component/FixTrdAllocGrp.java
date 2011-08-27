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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNestedParties2;

public class FixTrdAllocGrp
{

	public int noAllocs;
	public TrdAllocGrp[] group;

	public void getAll(int noAllocs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noAllocs = noAllocs;

		if (noAllocs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noAllocs ).getBytes(), FixTags.NOALLOCS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noAllocs) {
			group = new TrdAllocGrp[noAllocs];

			for ( int i = 0; i < noAllocs; i++ ) group[i] = new TrdAllocGrp();
	}

		for ( int i = 0; i < noAllocs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noAllocs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noAllocs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noAllocs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdAllocGrp)) return false;

		FixTrdAllocGrp msg = (FixTrdAllocGrp) o;

		for (int i = 0; i<noAllocs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noAllocs; i++)
			s += group[i].toString();
		return s;
	}

public class TrdAllocGrp implements FixComponent
{

	public byte[] allocAccount;
	public long allocAcctIDSource = 0;
	public byte[] allocSettlCurrency;
	public byte[] individualAllocID;
	public FixNestedParties2 nestedParties2;
	public long allocQty = 0;
	public byte[] allocCustomerCapacity;
	public long allocMethod = 0;
	public byte[] secondaryIndividualAllocID;
	public byte[] allocClearingFeeIndicator;

	public TrdAllocGrp() {
		super();

		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		allocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nestedParties2 = new FixNestedParties2();
		allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		allocClearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( allocAccount, (byte)0 );
		allocAcctIDSource = Long.MAX_VALUE;		
		Utils.fill( allocSettlCurrency, (byte)0 );
		Utils.fill( individualAllocID, (byte)0 );
		allocQty = Long.MAX_VALUE;		
		Utils.fill( allocCustomerCapacity, (byte)0 );
		allocMethod = Long.MAX_VALUE;		
		Utils.fill( secondaryIndividualAllocID, (byte)0 );
		Utils.fill( allocClearingFeeIndicator, (byte)0 );
		nestedParties2.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.ALLOCACCOUNT_INT) {
				allocAccount = FixUtils.getTagStringValue(value, allocAccount);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCACCTIDSOURCE_INT) {
				allocAcctIDSource = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCSETTLCURRENCY_INT) {
				allocSettlCurrency = FixUtils.getTagStringValue(value, allocSettlCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INDIVIDUALALLOCID_INT) {
				individualAllocID = FixUtils.getTagStringValue(value, individualAllocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTED2PARTYIDS_INT) {
				int noNested2PartyIDs;
				noNested2PartyIDs = FixUtils.getTagIntValue( value );
				nestedParties2.getAll(noNested2PartyIDs, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCQTY_INT) {
				allocQty = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCCUSTOMERCAPACITY_INT) {
				allocCustomerCapacity = FixUtils.getTagStringValue(value, allocCustomerCapacity);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCMETHOD_INT) {
				allocMethod = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.AllocMethod.isValid(allocMethod) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + allocMethod + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYINDIVIDUALALLOCID_INT) {
				secondaryIndividualAllocID = FixUtils.getTagStringValue(value, secondaryIndividualAllocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCCLEARINGFEEINDICATOR_INT) {
				allocClearingFeeIndicator = FixUtils.getTagStringValue(value, allocClearingFeeIndicator);
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
		if (FixUtils.isSet(allocAccount)) return true;
		if (FixUtils.isSet(allocAcctIDSource)) return true;
		if (FixUtils.isSet(allocSettlCurrency)) return true;
		if (FixUtils.isSet(individualAllocID)) return true;
		if (FixUtils.isSet(nestedParties2.noNested2PartyIDs)) return true;
		if (FixUtils.isSet(allocQty)) return true;
		if (FixUtils.isSet(allocCustomerCapacity)) return true;
		if (FixUtils.isSet(allocMethod)) return true;
		if (FixUtils.isSet(secondaryIndividualAllocID)) return true;
		if (FixUtils.isSet(allocClearingFeeIndicator)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(allocAccount)) FixUtils.putFixTag( out, FixTags.ALLOCACCOUNT_INT, allocAccount, 0, Utils.lastIndexTrim(allocAccount, (byte)0) );
		if (FixUtils.isSet(allocAcctIDSource)) FixUtils.putFixTag( out, FixTags.ALLOCACCTIDSOURCE_INT, allocAcctIDSource);
		if (FixUtils.isSet(allocSettlCurrency)) FixUtils.putFixTag( out, FixTags.ALLOCSETTLCURRENCY_INT, allocSettlCurrency, 0, Utils.lastIndexTrim(allocSettlCurrency, (byte)0) );
		if (FixUtils.isSet(individualAllocID)) FixUtils.putFixTag( out, FixTags.INDIVIDUALALLOCID_INT, individualAllocID, 0, Utils.lastIndexTrim(individualAllocID, (byte)0) );
		if (FixUtils.isSet(nestedParties2.noNested2PartyIDs)) nestedParties2.encode( out );
		if (FixUtils.isSet(allocQty)) FixUtils.putFixFloatTag( out, FixTags.ALLOCQTY_INT, allocQty);
		if (FixUtils.isSet(allocCustomerCapacity)) FixUtils.putFixTag( out, FixTags.ALLOCCUSTOMERCAPACITY_INT, allocCustomerCapacity, 0, Utils.lastIndexTrim(allocCustomerCapacity, (byte)0) );
		if (FixUtils.isSet(allocMethod)) FixUtils.putFixTag( out, FixTags.ALLOCMETHOD_INT, allocMethod);
		if (FixUtils.isSet(secondaryIndividualAllocID)) FixUtils.putFixTag( out, FixTags.SECONDARYINDIVIDUALALLOCID_INT, secondaryIndividualAllocID, 0, Utils.lastIndexTrim(secondaryIndividualAllocID, (byte)0) );
		if (FixUtils.isSet(allocClearingFeeIndicator)) FixUtils.putFixTag( out, FixTags.ALLOCCLEARINGFEEINDICATOR_INT, allocClearingFeeIndicator, 0, Utils.lastIndexTrim(allocClearingFeeIndicator, (byte)0) );
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

			if (FixUtils.isSet(allocAccount)) s += "AllocAccount(79)=" + new String(allocAccount) + sep;
			if (FixUtils.isSet(allocAcctIDSource)) s += "AllocAcctIDSource(661)=" + String.valueOf(allocAcctIDSource) + sep;
			if (FixUtils.isSet(allocSettlCurrency)) s += "AllocSettlCurrency(736)=" + new String(allocSettlCurrency) + sep;
			if (FixUtils.isSet(individualAllocID)) s += "IndividualAllocID(467)=" + new String(individualAllocID) + sep;
			if (FixUtils.isSet(nestedParties2.noNested2PartyIDs)) s += nestedParties2.toString();
			if (FixUtils.isSet(allocQty)) s += "AllocQty(80)=" + String.valueOf(allocQty) + sep;
			if (FixUtils.isSet(allocCustomerCapacity)) s += "AllocCustomerCapacity(993)=" + new String(allocCustomerCapacity) + sep;
			if (FixUtils.isSet(allocMethod)) s += "AllocMethod(1002)=" + String.valueOf(allocMethod) + sep;
			if (FixUtils.isSet(secondaryIndividualAllocID)) s += "SecondaryIndividualAllocID(989)=" + new String(secondaryIndividualAllocID) + sep;
			if (FixUtils.isSet(allocClearingFeeIndicator)) s += "AllocClearingFeeIndicator(1136)=" + new String(allocClearingFeeIndicator) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TrdAllocGrp)) return false;

			TrdAllocGrp msg = (TrdAllocGrp) o;

		if (!Utils.equals( allocAccount, msg.allocAccount)) return false;

		if (!( allocAcctIDSource==msg.allocAcctIDSource)) return false;

		if (!Utils.equals( allocSettlCurrency, msg.allocSettlCurrency)) return false;

		if (!Utils.equals( individualAllocID, msg.individualAllocID)) return false;

		if (!nestedParties2.equals(msg.nestedParties2)) return false;

		if (!( allocQty==msg.allocQty)) return false;

		if (!Utils.equals( allocCustomerCapacity, msg.allocCustomerCapacity)) return false;

		if (!( allocMethod==msg.allocMethod)) return false;

		if (!Utils.equals( secondaryIndividualAllocID, msg.secondaryIndividualAllocID)) return false;

		if (!Utils.equals( allocClearingFeeIndicator, msg.allocClearingFeeIndicator)) return false;

		return true;
	}
}
}

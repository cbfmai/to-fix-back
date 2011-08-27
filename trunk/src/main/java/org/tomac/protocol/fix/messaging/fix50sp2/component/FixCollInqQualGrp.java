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

public class FixCollInqQualGrp
{

	public int noCollInquiryQualifier;
	public CollInqQualGrp[] group;

	public void getAll(int noCollInquiryQualifier, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noCollInquiryQualifier = noCollInquiryQualifier;

		if (noCollInquiryQualifier < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noCollInquiryQualifier ).getBytes(), FixTags.NOCOLLINQUIRYQUALIFIER_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noCollInquiryQualifier) {
			group = new CollInqQualGrp[noCollInquiryQualifier];

			for ( int i = 0; i < noCollInquiryQualifier; i++ ) group[i] = new CollInqQualGrp();
	}

		for ( int i = 0; i < noCollInquiryQualifier; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noCollInquiryQualifier; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noCollInquiryQualifier; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noCollInquiryQualifier; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCollInqQualGrp)) return false;

		FixCollInqQualGrp msg = (FixCollInqQualGrp) o;

		for (int i = 0; i<noCollInquiryQualifier; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noCollInquiryQualifier; i++)
			s += group[i].toString();
		return s;
	}

public class CollInqQualGrp implements FixComponent
{

	public long collInquiryQualifier = 0;

	public CollInqQualGrp() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		collInquiryQualifier = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.COLLINQUIRYQUALIFIER_INT) {
				collInquiryQualifier = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.CollInquiryQualifier.isValid(collInquiryQualifier) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + collInquiryQualifier + ") for tag").getBytes(), id, new byte[0] );
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
		if (FixUtils.isSet(collInquiryQualifier)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(collInquiryQualifier)) FixUtils.putFixTag( out, FixTags.COLLINQUIRYQUALIFIER_INT, collInquiryQualifier);
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

			if (FixUtils.isSet(collInquiryQualifier)) s += "CollInquiryQualifier(896)=" + String.valueOf(collInquiryQualifier) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof CollInqQualGrp)) return false;

			CollInqQualGrp msg = (CollInqQualGrp) o;

		if (!( collInquiryQualifier==msg.collInquiryQualifier)) return false;

		return true;
	}
}
}

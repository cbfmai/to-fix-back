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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixFinancingDetails;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;

public class FixQuotCxlEntriesGrp
{

	public int noQuoteEntries;
	public QuotCxlEntriesGrp[] group;

	public void getAll(int noQuoteEntries, ByteBuffer buf) throws FixSessionException {
		this.noQuoteEntries = noQuoteEntries;

		if (noQuoteEntries < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noQuoteEntries) {
			group = new QuotCxlEntriesGrp[noQuoteEntries];

			for ( int i = 0; i < noQuoteEntries; i++ ) group[i] = new QuotCxlEntriesGrp();
	}

		for ( int i = 0; i < noQuoteEntries; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noQuoteEntries; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noQuoteEntries; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noQuoteEntries; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noQuoteEntries; i++)
			s += group[i].toString();
		return s;
	}

public class QuotCxlEntriesGrp implements FixComponent
{

	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp undInstrmtGrp;
	public FixInstrmtLegGrp instrmtLegGrp;

	public QuotCxlEntriesGrp() {
		super();

		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		instrument.clear();
		financingDetails.clear();
		undInstrmtGrp.clear();
		instrmtLegGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.AGREEMENTDESC_INT) {
				financingDetails.getAll(FixTags.AGREEMENTDESC_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOUNDERLYINGS_INT) {
				undInstrmtGrp.getAll(FixTags.NOUNDERLYINGS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGS_INT) {
				instrmtLegGrp.getAll(FixTags.NOLEGS_INT, buf);
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
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(financingDetails.agreementDesc)) return true;
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) return true;
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(financingDetails.agreementDesc)) financingDetails.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
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

			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(financingDetails.agreementDesc)) s += financingDetails.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof QuotCxlEntriesGrp)) return false;

			QuotCxlEntriesGrp msg = (QuotCxlEntriesGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!financingDetails.equals(msg.financingDetails)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		return true;
	}
}
}

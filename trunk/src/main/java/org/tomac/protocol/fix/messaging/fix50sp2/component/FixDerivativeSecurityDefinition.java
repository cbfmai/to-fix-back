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


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixDerivativeInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixDerivativeInstrumentAttribute;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixMarketSegmentGrp;

public class FixDerivativeSecurityDefinition implements FixComponent
{

	public FixDerivativeInstrument derivativeInstrument;
	public FixDerivativeInstrumentAttribute derivativeInstrumentAttribute;
	public FixMarketSegmentGrp marketSegmentGrp;

	public FixDerivativeSecurityDefinition() {
		super();

		derivativeInstrument = new FixDerivativeInstrument();
		derivativeInstrumentAttribute = new FixDerivativeInstrumentAttribute();
		marketSegmentGrp = new FixMarketSegmentGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		derivativeInstrument.clear();
		derivativeInstrumentAttribute.clear();
		marketSegmentGrp.clear();
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.DERIVATIVESYMBOL_INT:
				derivativeInstrument.getAll( FixTags.DERIVATIVESYMBOL_INT, value );
				break;

			case FixTags.NODERIVATIVEINSTRATTRIB_INT:
				derivativeInstrumentAttribute.noDerivativeInstrAttrib = FixUtils.getTagIntValue( value );
				derivativeInstrumentAttribute.getAll(derivativeInstrumentAttribute.noDerivativeInstrAttrib, value );
				break;

			case FixTags.NOMARKETSEGMENTS_INT:
				marketSegmentGrp.noMarketSegments = FixUtils.getTagIntValue( value );
				marketSegmentGrp.getAll(marketSegmentGrp.noMarketSegments, value );
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) > 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(derivativeInstrument.derivativeSymbol)) return true;
		if (FixUtils.isSet(derivativeInstrumentAttribute.noDerivativeInstrAttrib)) return true;
		if (FixUtils.isSet(marketSegmentGrp.noMarketSegments)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(derivativeInstrument.derivativeSymbol)) derivativeInstrument.encode( out );
		if (FixUtils.isSet(derivativeInstrumentAttribute.noDerivativeInstrAttrib)) derivativeInstrumentAttribute.encode( out );
		if (FixUtils.isSet(marketSegmentGrp.noMarketSegments)) marketSegmentGrp.encode( out );
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

			if (FixUtils.isSet(derivativeInstrument.derivativeSymbol)) s += derivativeInstrument.toString();
			if (FixUtils.isSet(derivativeInstrumentAttribute.noDerivativeInstrAttrib)) s += derivativeInstrumentAttribute.toString();
			if (FixUtils.isSet(marketSegmentGrp.noMarketSegments)) s += marketSegmentGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityDefinition)) return false;

			FixDerivativeSecurityDefinition msg = (FixDerivativeSecurityDefinition) o;

		if (!derivativeInstrument.equals(msg.derivativeInstrument)) return false;

		if (!derivativeInstrumentAttribute.equals(msg.derivativeInstrumentAttribute)) return false;

		if (!marketSegmentGrp.equals(msg.marketSegmentGrp)) return false;

		return true;
	}
}

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

public class FixRelationshipRiskWarningLevels
{

	public int noRelationshipRiskWarningLevels;
	public RelationshipRiskWarningLevels[] group;

	public void getAll(int noRelationshipRiskWarningLevels, ByteBuffer buf) throws FixSessionException {
		this.noRelationshipRiskWarningLevels = noRelationshipRiskWarningLevels;

		if (noRelationshipRiskWarningLevels < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRelationshipRiskWarningLevels ).getBytes(), FixTags.NORELATIONSHIPRISKWARNINGLEVELS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRelationshipRiskWarningLevels) {
			group = new RelationshipRiskWarningLevels[noRelationshipRiskWarningLevels];

			for ( int i = 0; i < noRelationshipRiskWarningLevels; i++ ) group[i] = new RelationshipRiskWarningLevels();
	}

		for ( int i = 0; i < noRelationshipRiskWarningLevels; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelationshipRiskWarningLevels; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelationshipRiskWarningLevels; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelationshipRiskWarningLevels; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelationshipRiskWarningLevels; i++)
			s += group[i].toString();
		return s;
	}

public class RelationshipRiskWarningLevels implements FixComponent
{

	public long relationshipRiskWarningLevelPercent = 0;
	public byte[] relationshipRiskWarningLevelName;

	public RelationshipRiskWarningLevels() {
		super();

		relationshipRiskWarningLevelName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		relationshipRiskWarningLevelPercent = Long.MAX_VALUE;		
		Utils.fill( relationshipRiskWarningLevelName, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RELATIONSHIPRISKWARNINGLEVELPERCENT_INT) {
				relationshipRiskWarningLevelPercent = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATIONSHIPRISKWARNINGLEVELNAME_INT) {
				relationshipRiskWarningLevelName = FixUtils.getTagStringValue(value, relationshipRiskWarningLevelName);
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
		if (FixUtils.isSet(relationshipRiskWarningLevelPercent)) return true;
		if (FixUtils.isSet(relationshipRiskWarningLevelName)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(relationshipRiskWarningLevelPercent)) FixUtils.putFixFloatTag( out, FixTags.RELATIONSHIPRISKWARNINGLEVELPERCENT_INT, relationshipRiskWarningLevelPercent);
		if (FixUtils.isSet(relationshipRiskWarningLevelName)) FixUtils.putFixTag( out, FixTags.RELATIONSHIPRISKWARNINGLEVELNAME_INT, relationshipRiskWarningLevelName, 0, Utils.lastIndexTrim(relationshipRiskWarningLevelName, (byte)0) );
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

			if (FixUtils.isSet(relationshipRiskWarningLevelPercent)) s += "RelationshipRiskWarningLevelPercent(1614)=" + String.valueOf(relationshipRiskWarningLevelPercent) + sep;
			if (FixUtils.isSet(relationshipRiskWarningLevelName)) s += "RelationshipRiskWarningLevelName(1615)=" + new String(relationshipRiskWarningLevelName) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelationshipRiskWarningLevels)) return false;

			RelationshipRiskWarningLevels msg = (RelationshipRiskWarningLevels) o;

		if ( ! super.equals(msg) ) return false;

		if (!( relationshipRiskWarningLevelPercent==msg.relationshipRiskWarningLevelPercent)) return false;

		if (!Utils.equals( relationshipRiskWarningLevelName, msg.relationshipRiskWarningLevelName)) return false;

		return true;
	}
}
}

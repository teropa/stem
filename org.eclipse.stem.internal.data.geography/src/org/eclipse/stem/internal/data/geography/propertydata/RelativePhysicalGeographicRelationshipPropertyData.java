// RelativePhysicalPropertyData.java
package org.eclipse.stem.internal.data.geography.propertydata;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.text.ParseException;
import java.util.StringTokenizer;

import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationship;
import org.eclipse.stem.definitions.nodes.GeographicFeature;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.data.geography.ISOKey;

/**
 * This class represents data extracted from a properties file with data about a
 * relative physical relationship between two {@link Region}s. Ultimately, the
 * relationship will be represented an an {@link Edge} in a {@link Graph}.
 */
public class RelativePhysicalGeographicRelationshipPropertyData extends
		GeographicRelationshipPropertyData {

	private RelativePhysicalRelationship relativePhysicalRelationship;

	/**
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1") read
	 *            from a properties file. The actual value isn't important, but
	 *            the it must be unique in the file.
	 * @param propertyValue
	 *            a {@link String} read from a relationship properties file. The
	 *            first two entries in the String are the {@link ISOKey}s of the
	 *            two {@link GeographicFeature}s that have a relationship.
	 * @throws ParseException
	 *             if there is a problem with parsing the data.
	 */
	public RelativePhysicalGeographicRelationshipPropertyData(
			final String propertyKey, final String propertyValue)
			throws ParseException {
		super(propertyKey, propertyValue);
	} // RelativePhysicalPropertyData

	/**
	 * @see org.eclipse.stem.internal.data.records.data.RelationshipGraphData#parseAndProcessProperty(java.lang.String,
	 *      java.util.StringTokenizer)
	 */
	@Override
	protected void parseAndProcessProperty(final String propertyKey,
			final StringTokenizer st) throws ParseException {
		// The super class will strip off the two ISO keys...
		super.parseAndProcessProperty(propertyKey, st);

		// ...we're looking for the relationship identifier
		// Is there something there for us to process?
		if (st.hasMoreTokens()) {
			// Yes
			final String relationshipName = st.nextToken();
			relativePhysicalRelationship = RelativePhysicalRelationship
					.getByName(relationshipName);
			directed = true;
			// Did we actually find the type?
			if (relativePhysicalRelationship == null) {
				// No
				System.err
						.println("Didn't find relative physical relationship type \"" //$NON-NLS-1$
								+ relationshipName + "\""); //$NON-NLS-1$
			}
		} // if more tokens
		else {
			throw new ParseException(propertyKey + " = " + st.toString(), 0); //$NON-NLS-1$
		}
	} // parseAndProcessProperty

	/**
	 * @return the relativePhysicalRelationship
	 */
	@Override
	public final RelativePhysicalRelationship getRelativePhysicalRelationship() {
		return relativePhysicalRelationship;
	} // getRelativePhysicalRelationship

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" "); //$NON-NLS-1$
		sb.append(relativePhysicalRelationship.toString());
		return sb.toString();
	} // toString

} // RelativePhysicalPropertyData

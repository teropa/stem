// GeographicRelationshipPropertyData.java
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

import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.internal.data.propertydata.RelationshipPropertyData;

/**
 * This class represents a single property extracted from a properties file with
 * data about a relationship between two {@link GeographicFeature}s. Ultimately,
 * the relationship will be represented an an {@link Edge} in a {@link Graph}.
 */
abstract public class GeographicRelationshipPropertyData extends
		RelationshipPropertyData {

	/**
	 * This is the key for the "A" node of the edge that will represent the
	 * relationship
	 */
	protected ISOKey keyA;

	/**
	 * This is the key for the "B" node of the edge that will represent the
	 * relationship
	 */
	protected ISOKey keyB;

	/**
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1")
	 * @param propertyValue
	 *            a string read from a relationship properties file.
	 */
	protected GeographicRelationshipPropertyData(final String propertyKey,
			final String propertyValue) throws ParseException {
		super(propertyKey, propertyValue);
//		parseAndProcessProperty(propertyKey, propertyValue);
	} // RelationshipGraphData

	/**
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1")
	 * @param propertyValue
	 *            the value of the key (format ISOKEY_A, ISOKEY_B, <string>)
	 */
//	private final void parseAndProcessProperty(final String propertyKey,
//			final String propertyValue) throws ParseException {
//		final StringTokenizer st = new StringTokenizer(propertyValue, ", "); //$NON-NLS-1$
//		parseAndProcessProperty(propertyKey, st);
//	} // parseAndProcessProperty

	/**
	 * This method is typically called by the subclass to process the string
	 * before it does so that the tokenizer is properly positioned when it gets
	 * its turn.
	 * 
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1")
	 * @param st
	 *            a tokenizer positioned (if all is correct) to extract the two
	 *            keys from the propertyValue
	 */
	@Override
	protected void parseAndProcessProperty(final String propertyKey,
			final StringTokenizer st) throws ParseException {
		super.parseAndProcessProperty(propertyKey, st);
		
		// Is there a token for node A?
		if (st.hasMoreTokens()) {
			// Yes
			keyA = new ISOKey(st.nextToken());
			// Is there a token for node B?
			if (st.hasMoreTokens()) {
				// Yes
				keyB = new ISOKey(st.nextToken());
			} else {
				throw new ParseException(propertyKey + " = " + st.toString(), 0); //$NON-NLS-1$
			}
		} else {
			throw new ParseException(propertyKey + " = " + st.toString(), 0); //$NON-NLS-1$
		}
	} // parseAndProcessProperty

	/**
	 * @return the A key
	 */
	public final ISOKey getKeyA() {
		return keyA;
	}

	/**
	 * @return the B key
	 */
	public final ISOKey getKeyB() {
		return keyB;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(keyA.toString());
		sb.append(" "); //$NON-NLS-1$
		sb.append(keyB.toString());
		return sb.toString();
	} // toString

} // RelationshipGraphData

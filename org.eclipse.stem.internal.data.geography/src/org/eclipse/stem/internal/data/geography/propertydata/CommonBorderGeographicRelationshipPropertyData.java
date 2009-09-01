// CommonBorderData.java
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

/**
 * This class represents the data from a single property that specifies the
 * relationship of sharing a common border between two {@link GeographicFeature}
 * s. Ultimately, the relationship will be represented an an {@link Edge} in a
 * {@link Graph}.
 */
public class CommonBorderGeographicRelationshipPropertyData extends
		GeographicRelationshipPropertyData {

	/**
	 * This is the length of the common border in kilometers, 0 (zero) if not
	 * known.
	 */
	private double length = 0;

	/**
	 * @param propertyKey
	 *            the key of the property (typically a number e.g., "1") that
	 *            was read from a properties file.
	 * @param propertyValue
	 *            the String that is the value of the propertyKey in the
	 *            properties file.
	 * @throws ParseException
	 *             if there the border length was not specified, or it was not a
	 *             number.
	 */
	public CommonBorderGeographicRelationshipPropertyData(
			final String propertyKey, final String propertyValue)
			throws ParseException {
		super(propertyKey, propertyValue);
	} // CommonBorderData

	/**
	 * @see org.eclipse.stem.internal.data.records.data.RelationshipGraphData#parseAndProcessProperty(java.lang.String,
	 *      java.util.StringTokenizer)
	 */
	@Override
	protected void parseAndProcessProperty(final String propertyKey,
			final StringTokenizer st) throws ParseException {
		// The super class will strip off the two ISO keys from the propertyKey
		// that specify the two GeographicFeatures that share a common border.
		super.parseAndProcessProperty(propertyKey, st);

		// ...now we're looking for the number which is the length in kilometers
		// of the common border.

		// Is there another token?
		if (st.hasMoreTokens()) {
			// Yes
			final String borderLengthString = st.nextToken();
			try {
				length = Double.parseDouble(borderLengthString);
				directed = false;
			} catch (final NumberFormatException e) {
				throw new ParseException(propertyKey + " = \"" //$NON-NLS-1$
						+ borderLengthString + "\" number format exception.", 0); //$NON-NLS-1$
			}
		} else {
			throw new ParseException(propertyKey + " = " + st.toString(), 0); //$NON-NLS-1$
		}
	} // parseAndProcessProperty

	/**
	 * @return the length of the common border in kilometers, 0 (zero) if not
	 *         known.
	 */
	public final double getLength() {
		return length;
	} // getLength

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" "); //$NON-NLS-1$
		sb.append(length);
		sb.append(" km's"); //$NON-NLS-1$
		return sb.toString();
	} // toString

} // CommonBorderData

// RoadTransportGeographicRelationshipPropertyData.java
package org.eclipse.stem.internal.data.geography.infrastructure.transportation.propertydata;

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

import org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData;

/**
 * This class represents 
 */
public class RoadTransportGeographicRelationshipPropertyData extends
		GeographicRelationshipPropertyData {

	String	roadName; 
	String	roadClass;
	int		numCrossings;
	
	/**
	 * @param propertyKey
	 * @param propertyValue
	 * @throws ParseException
	 */
	public RoadTransportGeographicRelationshipPropertyData(
			String propertyKey, String propertyValue) throws ParseException {
		super(propertyKey, propertyValue);
	} // RoadTransportGeographicRelationshipPropertyData

	/**
	 * @see org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData#parseAndProcessProperty(java.lang.String, java.util.StringTokenizer)
	 */
	@Override
	protected void parseAndProcessProperty(String propertyKey,
			StringTokenizer st) throws ParseException {
		// The super class will strip off the two ISO keys from the propertyKey
		// that specify the two GeographicFeatures that share a common border.
		super.parseAndProcessProperty(propertyKey, st);

		// ...now we're looking for the number which is the length in kilometers
		// of the common border.

		// Is there another token?
		if (st.hasMoreTokens()) {
			// Yes
			roadName = st.nextToken(",").trim(); //$NON-NLS-1$
			roadClass = st.nextToken(",").trim(); //$NON-NLS-1$
			final String crossingsString = st.nextToken(",").trim(); //$NON-NLS-1$
			try {
				numCrossings = Integer.parseInt(crossingsString);
				directed = false;
			} catch (final NumberFormatException e) {
				throw new ParseException(propertyKey + " = \"" //$NON-NLS-1$
						+ crossingsString + "\" number format exception.", 0); //$NON-NLS-1$
			}
		} else {
			throw new ParseException(propertyKey + " = " + st.toString(), 0); //$NON-NLS-1$
		}
	} // parseAndProcessProperty

	
	/**
	 * @return the roadName
	 */
	public final String getRoadName() {
		return roadName;
	}

	/**
	 * @return the roadClass
	 */
	public final String getRoadClass() {
		return roadClass;
	}

	/**
	 * @return the numCrossings
	 */
	public final int getNumCrossings() {
		return numCrossings;
	}

	/**
	 * @see org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		
		sb.append("road name ["); //$NON-NLS-1$
		sb.append(roadName);
		sb.append("] class["); //$NON-NLS-1$
		sb.append(roadClass);
		sb.append("] crossings["); //$NON-NLS-1$
		sb.append(numCrossings);
		sb.append("]"); //$NON-NLS-1$
		
		return sb.toString();
	} // toString

	
} // RoadTransportGeographicRelationshipPropertyData
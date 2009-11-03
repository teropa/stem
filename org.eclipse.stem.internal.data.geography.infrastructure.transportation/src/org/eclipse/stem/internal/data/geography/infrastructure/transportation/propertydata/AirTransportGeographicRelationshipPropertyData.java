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

import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData;

/**
 * This class represents 
 */
public class AirTransportGeographicRelationshipPropertyData extends
		GeographicRelationshipPropertyData {
	
	/** The rate of arrival */
	private double arrivalRate;

	/** The rate of departure */
	private double departureRate;

	/**
	 * @param propertyKey
	 * @param propertyValue
	 * @throws ParseException
	 */
	public AirTransportGeographicRelationshipPropertyData(
			String propertyKey, String propertyValue) throws ParseException {
		super(propertyKey, propertyValue);
	} // RoadTransportGeographicRelationshipPropertyData

	/**
	 * @see org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData#parseAndProcessProperty(java.lang.String, java.util.StringTokenizer)
	 */
	@Override
	protected void parseAndProcessProperty(String propertyKey,
			StringTokenizer st) throws ParseException {
		super.parseAndProcessProperty(propertyKey, st);
		// Anything left to process?
		if (st.hasMoreTokens()) {
			// Yes
			try {
				arrivalRate = Double.parseDouble(st.nextToken());
				departureRate = Double.parseDouble(st.nextToken());
				
			} catch (final NumberFormatException e) {
				throw new ParseException(propertyKey + ":" + e.getMessage(), 0); //$NON-NLS-1$
			} catch (final NullPointerException e) {
				throw new ParseException(propertyKey + ":" + e.getMessage(), 0); //$NON-NLS-1$
			}
		} // if
	} // parseAndProcessProperty

	/**
	 * @return the {@link ISOKey} of the {@link Node} that represents 
	 *         the transportation system 
	 */
	public final ISOKey getTransportationSystemISOKey() {
		return getKeyA();
	}

	/**
	 * @return the {@link ISOKey} of the {@link Region} that people are arriving
	 *         and departing from in this pipe transport relationship
	 */
	public final ISOKey getRegionISOKey() {
		return getKeyB();
	}

	/** @return the arrival rate, in people per time period, of this node */
	public final double getArrivalRate() {
		return arrivalRate;
	}

	/** @return the departure rate, in people per time period, of this node */
	public final double getDepartureRate() {
		return departureRate;
	}


	/**
	 * @see org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		
		sb.append("arrivalRate ["); //$NON-NLS-1$
		sb.append(arrivalRate);
		sb.append("] departureRate["); //$NON-NLS-1$
		sb.append(departureRate);
		sb.append("]"); //$NON-NLS-1$
		
		return sb.toString();
	} // toString

	
} // AirTransportGeographicRelationshipPropertyData

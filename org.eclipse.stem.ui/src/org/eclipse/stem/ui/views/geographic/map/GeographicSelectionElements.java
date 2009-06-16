package org.eclipse.stem.ui.views.geographic.map;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * Specify the information that is passed in the StructuredSelection event that
 * is created by MapView on a mouse click on the map.
 * 
 * <pre>
 * The instance of this class is passed as the 2nd element in the
 * StructuredSelection instance. 
 * 
 * The information passed is the following: 
 * - Identifiable that describes the map polygon (in the 1st element)
 * - GeographicSelectionElement (in the 2nd element)
 *   - Point (longitude/latitude) of the actual click 
 *   - Map of relative values at the instance of the click.
 * 
 * Note: One might think that the StructuredSelection should have been subclassed
 * but it is specificly forbidden.
 * 
 * </pre>
 */
public class GeographicSelectionElements {

	/**
	 * Longitude of selection point
	 */
	private double longitude = 0.0;
	/**
	 * latitude of selection point
	 */
	private double latitude = 0.0;

	/**
	 * default constructor
	 */
	public GeographicSelectionElements() {
		// default constructor
	}

	/**
	 * @return the point
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the point
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * set the longitude and latitude of the selected point
	 * 
	 * @param longitude
	 * @param latitude
	 */
	public void setPoint(final double longitude, final double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
}

// LatLongProvider.java
package org.eclipse.stem.definitions.adapters.spatial.geo;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.definitions.adapters.spatial.SpatialProvider;

/**
 * This interface is implemented by classes that provide Latitude and Longitude
 * data.
 */
public interface LatLongProvider extends SpatialProvider {

	/**
	 * @return latitude/longitude data.
	 */
	LatLong getLatLong();

	/**
	 * This is just like {@link #getLatLong()} except that it returns an empty
	 * instance of {@link LatLong} if the data has not been retrieved yet. As a
	 * side effect, it immediately schedules a
	 * {@link org.eclipse.core.runtime.jobs.Job} to retrieve the data. As such,
	 * a future call might produce a fully populated result.
	 * 
	 * @return latitude/longitude data.
	 */
	LatLong getLatLongNoWait();
	
	/**
	 * This method will return the Latitude and Longitude values for the adapted
	 * object, if such exists. 
	 * @return Latitude and Longitude values for the adapted object
	 */
	double[] getCenter();

} // LatLongProvider

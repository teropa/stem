// AreaPropertyData.java
package org.eclipse.stem.internal.data.geography.propertydata;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.data.geography.ISOKey;

/**
 * This class contains the data from a property that specifies earth science data in
 * for a specific {@link GeographicFeature}.
 */
public class EarthSciencePropertyData extends GeographicFeaturePropertyData {

	String earthsciencedata = ""; //$NON-NLS-1$
	
	/**
	 * @param data
	 *            the data of the {@link GeographicFeature} 
	 */
	public EarthSciencePropertyData(final ISOKey isoKey, final String data) {
		super(isoKey);
		this.earthsciencedata = data;
	} // EarthSciencePropertyData

	/**
	 * @return the earth science data of the {@link GeographicFeature}
	 */
	public final String getEarthScienceData() {
		return earthsciencedata;
	}

	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return isoKey.toString() + " = " + earthsciencedata; //$NON-NLS-1$
	} // toString

} // EarthSciencePropertyData

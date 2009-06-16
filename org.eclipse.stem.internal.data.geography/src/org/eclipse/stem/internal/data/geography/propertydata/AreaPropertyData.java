// AreaPropertyData.java
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

import org.eclipse.stem.definitions.nodes.GeographicFeature;
import org.eclipse.stem.data.geography.ISOKey;

/**
 * This class contains the data from a property that specifies the area in
 * square kilometers for a specific {@link GeographicFeature}.
 */
public class AreaPropertyData extends GeographicFeaturePropertyData {

	// Square Km's
	String area = ""; //$NON-NLS-1$

	/**
	 * @param isoKey
	 *            the unique ISO-3166 identifier for the
	 *            {@link GeographicFeature}.
	 * @param area
	 *            the area of the {@link GeographicFeature} in square
	 *            kilometers.
	 */
	public AreaPropertyData(final ISOKey isoKey, final String area) {
		super(isoKey);
		this.area = area;
	} // AreaData

	/**
	 * @return the area of the {@link GeographicFeature} in square kilometers.
	 */
	public final String getArea() {
		return area;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return isoKey.toString() + " = " + area; //$NON-NLS-1$
	} // toString

} // AreaPropertyData

// RegionPropertyData.java
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

import org.eclipse.stem.data.geography.ISOKey;

/**
 * This class contains the data from a property that specifies a single
 * {@link Region}.
 */
public class RegionPropertyData extends GeographicFeaturePropertyData {

	/**
	 * The name of the region.
	 */
	String regionName = null;

	/**
	 * @param isoKey
	 *            the unique ISO-3166 identifier for the {@link Region}.
	 * @param regionName
	 *            the name of the {@link Region}.
	 * 
	 */
	public RegionPropertyData(final ISOKey isoKey,
			final String regionName) {
		super(isoKey);
		this.regionName = regionName;
	} // NodeData

	/**
	 * @return the name of the {@link Region}.
	 */
	public final String getName() {
		return regionName;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(regionName);
		sb.append(" ("); //$NON-NLS-1$
		sb.append(isoKey.toString());
		sb.append(")"); //$NON-NLS-1$
		return sb.toString();
	}

} // RegionPropertyData

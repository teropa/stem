// GeographicFeaturePropertyData.java
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
import org.eclipse.stem.internal.data.propertydata.PropertyData;

/**
 * This class represents data extracted from a properties file with data about a
 * specific {@link GeographicFeature}.
 */
public class GeographicFeaturePropertyData extends PropertyData {

	protected ISOKey isoKey = null;

	/**
	 * @param isoKey
	 *            the unique ISO-3166 identifier for the
	 *            {@link GeographicFeature}. For instance,
	 *            <code>US-AK-02050</code> is the key for "Bethel" county in
	 *            Alaska in the United States.
	 */
	public GeographicFeaturePropertyData(final ISOKey isoKey) {
		super();
		this.isoKey = isoKey;
	}

	/**
	 * @return the unique ISO-3166 identifier for the {@link GeographicFeature}.
	 */
	public final ISOKey getISOKey() {
		return isoKey;
	}

	/**
	 * @param isoKey
	 *            the unique ISO-3166 identifier for the {@link GeographicFeature}.
	 */
	public final void setISOKey(final ISOKey isoKey) {
		this.isoKey = isoKey;
	}


//	/**
//	 * This class represents the number of population members of a particular
//	 * type who occupy a specific node. It also, includes an optional
//	 * specification of the area that the population lives in. This is intended
//	 * to provide better population density values when a population lives in a
//	 * small area (e.g., a city) compared to the total area of the node.
//	 */
//	public static class PopulationData extends GeographicFeaturePropertyData {
//
//		// Number of Individuals
//		String count = "";
//
//		// Optional area occupied by population
//		private String area = null;
//
//		/**
//		 * @param nodeKey
//		 *            the {@link ISOKey} nodeKey of the node
//		 * @param dataString
//		 *            the string that contains the population count and optional
//		 *            area extent
//		 */
//		public PopulationData(final ISOKey nodeKey, final String dataString) {
//			super(nodeKey);
//
//			// The data string contains the population count and an optional
//			// specification of the area in square kilometers that the
//			// population is distributed over. The optional area specification
//			// is used to facilitate more accurate computation of the population
//			// density for cases where the area of a region being labeled by the
//			// population is much larger than the area where most of the
//			// population exists. For instance, the case of a single city in an
//			// otherwise large unoccupied region. The format of the string is
//			// either a single integer for the population count, or an integer
//			// followed by a comma followed by an double for the area. e.g.
//			// "123" or "123, 45.6"
//
//			final StringTokenizer st = new StringTokenizer(dataString, ", ");
//			count = st.nextToken();
//			setArea(st.hasMoreTokens() ? st.nextToken() : null);
//		} // PopulationData
//
//		/**
//		 * @return the count
//		 */
//		public final String getCount() {
//			return count;
//		}
//
//		/**
//		 * @see java.lang.Object#toString()
//		 */
//		@Override
//		public String toString() {
//			final StringBuilder sb = new StringBuilder(isoKey.toString());
//			sb.append(" (");
//			sb.append(count);
//			sb.append(getArea() != null ? "/" + getArea() + "km^2" : "");
//			sb.append(")");
//			return sb.toString();
//		} // toString
//
//		/**
//		 * @param area
//		 *            the area to set
//		 */
//		public void setArea(final String area) {
//			this.area = area;
//		}
//
//		/**
//		 * @return the area
//		 */
//		public String getArea() {
//			return area;
//		}
//
//	} // PopulationData

} // GeographicFeaturePropertyData

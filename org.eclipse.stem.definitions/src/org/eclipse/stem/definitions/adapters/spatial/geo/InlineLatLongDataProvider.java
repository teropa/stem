// InlineLatLongDataProvider.java
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

import java.text.NumberFormat;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.definitions.Activator;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapter;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;

/**
 * This class interprets a URI that contains embedded (i.e., "inline") lat/long
 * data.
 * <p>
 * The format of the URI is a comma separated list of lat/long pairs as double
 * values. These can be separated into "segments" by slashes ("/") which will
 * create separate lat/long sequences (arrays) in the return value.
 * 
 * <pre>
 *   e.g., &quot;inline:Lat1,Long1,Lat2,Long2/Lat3,Long3,Lat4,Long4&quot;
 * </pre>
 * 
 * </p>
 * 
 * @see PlatformLatLongDataProvider
 * @see LatLongProviderAdapter
 */
public class InlineLatLongDataProvider implements LatLongDataProvider {

	/**
	 * This is the scheme for an "inline" data URI that specifies lat/long data
	 * in the URI
	 */
	public static final String INLINE_SCHEME = "inline";

	private static final int NUMBER_OF_FACTIONAL_DIGITS = 2;

	private static NumberFormat formatter = null;

	static {
		// The static initializer isn't being called in eclipse
		// Register this data provider with the adapter so it can find us when
		// it comes across an "inline" URI.
		// LatLongProviderAdapter.registerLatLongDataProvider(INLINE_SCHEME,
		// new InlineLatLongDataProvider());
	} // static

	/**
	 * @param dataURI
	 * @return a latitude/longitude value
	 */
	public LatLong getLatLong(final URI dataURI) {
		final LatLong retValue = new LatLong();

		final String[] segments = dataURI.segments();
		try {
			for (final String segmentString : segments) {
				final LatLong.SegmentBuilder sb = new LatLong.SegmentBuilder();

				final StringTokenizer st = new StringTokenizer(segmentString,
						",");
				while (st.hasMoreTokens()) {
					final String latitudeString = st.nextToken();
					// Is there a matching Longitude?
					if (st.hasMoreTokens()) {
						// Yes
						sb.add(latitudeString, st.nextToken());
					} else {
						// No
						// lat/long mismatch
						Activator
								.logError(
										"Inline lat/long data \""
												+ segmentString
												+ "\" is missing a longitude match for the latitude \""
												+ latitudeString + "\"", null);
						sb.clear();
						break;
					} // else
				} // while more tokens

				// Anything in the segment builder?
				if (sb.size() > 0) {
					// Yes
					retValue.add(sb.toSegment());
				}
			} // for each segment
		} // try
		catch (final NumberFormatException nfe) {
			Activator.logError(
					"Inline lat/long data is not properly formatted", nfe);
		} // catch
		return retValue;
	} // getLatLong

	/**
	 * @see org.eclipse.stem.definitions.adapters.spatial.geo.LatLongDataProvider#getLatLongNoWait(org.eclipse.emf.common.util.URI)
	 */
	public LatLong getLatLongNoWait(final URI dataURI) {
		return getLatLong(dataURI);
	} // getLatLongNoWait

	/**
	 * Encode a list of arrays of double values representing polygons/lines into
	 * an spatial inline URI string.
	 * 
	 * @param segmentArrays
	 *            a list of arrays each of which represents a polygon/line
	 * @return the list of values in the arrays encoded in a spatial inline URI
	 *         string
	 */
	public static String createSpatialInlineURIString(
			final LatLong segmentArrays) {
		final StringBuilder sb = new StringBuilder(
				SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX);
		sb.append(createInlineURIString(segmentArrays));
		return sb.toString();
	} // createSpatialInlineURIString

	/**
	 * Encode a list of arrays of double values representing polygons/lines into
	 * an inline URI string. This is the inverse operation of
	 * {@link #getLatLong(URI)}.
	 * 
	 * @param latLong
	 * 
	 * @return the list of values in the arrays encoded in an inline URI string
	 */
	public static String createInlineURIString(final LatLong latLong) {
		final StringBuilder sb = new StringBuilder(INLINE_SCHEME);
		sb.append("://");
		for (final Segment segment : latLong.getSegments()) {
			sb.append("/");
			sb.append(segment.toInlineURIString());
		} // for each segment

		return sb.toString();
	} // createInlineURIString

	/**
	 * @return a formatter
	 */
	private static NumberFormat getFormatter() {
		// Is there already a formatter?
		if (formatter == null) {
			// No
			formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(NUMBER_OF_FACTIONAL_DIGITS);
			formatter.setMinimumFractionDigits(NUMBER_OF_FACTIONAL_DIGITS);
		}
		return formatter;
	} // getFormatter

} // InlineLatLongDataProvider

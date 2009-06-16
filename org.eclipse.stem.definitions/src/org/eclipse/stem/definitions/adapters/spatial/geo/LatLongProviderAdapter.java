// LatLongProviderAdapter.java
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.definitions.Activator;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapter;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;

/**
 * This class adapts <code>Identifiable</code>'s to
 * <code>LatLongProvider</code>'s. It extracts the lat/long data by examining
 * the <em>spatial</em> attribute of an <code>Identifiable</code>'s dublin
 * core instance. Typically, the value of the attribute will be recognized by
 * the adapter and the values returned. If the attribute does not have a value
 * or the format of the value is not recognized, then an empty list will be
 * returned.
 * <p>
 * The format recognized by the adapter is a URI with the scheme defined by the
 * constant {@link #STEM_SPATIAL_SCHEME STEM_SPATIAL_SCHEME}
 * 
 * @see org.eclipse.stem.core.common.Identifiable
 */
public class LatLongProviderAdapter extends SpatialProviderAdapter implements
		LatLongProvider {

	private static Map<Identifiable, LatLong> identifiableLatLongCache = new ConcurrentHashMap<Identifiable, LatLong>();
	private static Map<Identifiable, double[]> identifiableCenterCache = new ConcurrentHashMap<Identifiable, double[]>();

	private static Map<String, LatLongDataProvider> latLongDataProviders = null;

	/**
	 * Add the latLongDataProvider to the collection of available to this
	 * adapter
	 * 
	 * @param scheme
	 *            the key of the URI's that the data provider processes
	 * @param latLongDataProvider
	 *            the data provider
	 */
	public static void registerLatLongDataProvider(final String scheme,
			final LatLongDataProvider latLongDataProvider) {
		getLatLongDataProviders().put(scheme, latLongDataProvider);
	} // registerLatLongDataProvider

	/**
	 * @return the map between scheme's and their lat/long data providers
	 */
	synchronized public static Map<String, LatLongDataProvider> getLatLongDataProviders() {
		// Has the has Map been allocated yet?
		if (latLongDataProviders == null) {
			// No
			latLongDataProviders = new HashMap<String, LatLongDataProvider>();

			// We're doing this here because the static initializer in
			// InlineLatLongDataProvider isn't being called.
			latLongDataProviders.put(InlineLatLongDataProvider.INLINE_SCHEME,
					new InlineLatLongDataProvider());
			latLongDataProviders.put(
					PlatformLatLongDataProvider.PLATFORM_SCHEME,
					new PlatformLatLongDataProvider());
		}
		return latLongDataProviders;
	} // getLatLongDataProviders

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(final Object type) {
		boolean retValue = type == LatLongProvider.class;
		// Try to the super class?
		if (!retValue) {
			// Yes
			retValue = super.isAdapterForType(type);
		} // if
		return retValue;
	} // isAdapterForType

	/**
	 * @return the lat/long value
	 */
	public LatLong getLatLong() {
		final Identifiable identifiable = (Identifiable) getTarget();
		LatLong retValue = identifiableLatLongCache.get(identifiable);

		// Do we have a value in the cache?
		if (retValue == null) {
			// No
			retValue = new LatLong();

			// First let's get the value of the spatial attribute of the
			// Identifiable, if there is one.
			final String spatialValue = identifiable.getDublinCore()
					.getSpatial();
			// Is there a spatial value for this Identifiable and does it start
			// with the correct prefix?
			if (spatialValue != null
					&& spatialValue
							.startsWith(SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX)) {
				// Yes
				// Try to interpret it by parsing it as a URI
				try {
					// This is where it might be possible to get fancy with
					// interpreting the URI. The format is
					// "stemspatial:dataURI".
					// Where "dataURI" is the real specification of the data.
					// For example we might have
					// "stempspatial:inline:///120.0,101.0,120.0,120.0" which
					// would directly (i.e., "inline") define the data for a
					// line between two points on the Earth's surface from
					// "120.0W,
					// 101.0N" to "120.0W, 120.0N". Or,
					// "stemspatial:platform:///foo/data/bar.gml" which would
					// specify a file containing the data.

					final URI dataURI = extractDataURI(spatialValue);

					// Were we successful in extracting a URI from the string?
					if (dataURI != null) {
						// Yes
						// This call will attempt to find something that can
						// understand the dataURI and come up with lat/long data
						// if it can, otherwise if it can be interpreted, a
						// message
						// is dropped into the log and an empty list will be
						// returned
						retValue = getLatLong(dataURI);
						if (retValue != null) {
							identifiableLatLongCache
									.put(identifiable, retValue);
						}
					}
					// else the problem was logged so just ignore and return an
					// empty list
				} catch (final IllegalArgumentException e) {
					// We get here when the value of the spatial attribute isn't
					// something we understand so we're done, we'll just return
					// an
					// empty collection.
				}

			} // if spatial value
		} // if value in cache

		return retValue;
	} // getLatLong

	/**
	 * @return the lat/long value
	 */
	public LatLong getLatLongNoWait() {

		final Identifiable identifiable = (Identifiable) getTarget();
		LatLong retValue = identifiableLatLongCache.get(identifiable);

		// Do we have a value in the cache?
		if (retValue == null) {
			// No
			retValue = new LatLong();

			final String spatialValue = identifiable.getDublinCore()
					.getSpatial();
			// Is there a spatial value for this Identifiable and does it start
			// with the correct prefix?
			if (spatialValue != null
					&& spatialValue
							.startsWith(SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX)) {
				// Yes
				// Try to interpret it by parsing it as a URI
				try {
					// This is where it might be possible to get fancy with
					// interpreting the URI. The format is
					// "stemspatial:dataURI". Where "dataURI" is the real
					// specification of the data. For example we might have
					// "stempspatial:inline:///120.0,101.0,120.0,120.0" which
					// would directly (i.e., "") define the data for a
					// line between two points on the Earth's surface from
					// "120.0W, 101.0N" to "120.0W, 120.0N". Or,
					// "stemspatial:platform:///foo/data/bar.gml" which would
					// specify a file containing the data.

					final URI dataURI = extractDataURI(spatialValue);

					// Were we successful in extracting a URI from the string?
					if (dataURI != null) {
						// Yes
						// This call will attempt to find something that can
						// understand the dataURI and come up with lat/long data
						// if it can, otherwise if it can be interpreted, a
						// message is dropped into the log and an empty list
						// will be returned
						retValue = getLatLongNoWait(dataURI);
						if (retValue != null) {
							// Is it empty?
							if (retValue.size() > 0) {
								// No
								// We don't cache empty values because that is
								// what is returned as a temporary value in
								// "NoWait" calls. A separate Job might be
								// reading in the values for the future so if we
								// cache empty values we'd return them instead
								// of getting the real value read in later.
								identifiableLatLongCache.put(identifiable,
										retValue);
							}
						}
					}
					// else the problem was logged so just ignore and return an
					// empty value
				} catch (final IllegalArgumentException e) {
					// We get here when the value of the spatial attribute isn't
					// something we understand so we're done, we'll just return
					// an empty collection.
				}

			} // if spatial value
		} // if value not in cache
		return retValue;
	} // getLatLongNoWait

	/**
	 * @param stemSpatialURI
	 *            a URI with a "stemspatial" scheme. The format of the URI is
	 *            "stempspatial:dataURI"
	 * @see SpatialProviderAdapter#STEM_SPATIAL_SCHEME
	 * @return the data URI extracted from the stemSpatialURI
	 */
	private URI extractDataURI(final String stemSpatialURIString) {
		URI retValue = null;

		try {
			final String dataURIString = stemSpatialURIString
					.substring(SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX
							.length());

			retValue = URI.createURI(dataURIString);
		} catch (final Exception e) {
			Activator.logError("Badly formated spatial URI \""
					+ stemSpatialURIString + "\"", null);
		}
		return retValue;
	} // extractDataURI

	/**
	 * @param dataURI
	 *            the URI extracted from a dublin core <em>spatial</em>
	 *            attribute that specifies the location of lat/long data
	 * @return a list of arrays of latitude/longitude pairs.
	 */
	private LatLong getLatLong(final URI dataURI) {
		LatLong retValue = new LatLong();

		final LatLongDataProvider latLongDataProvider = getLatLongDataProvider(dataURI
				.scheme());
		// Did we find a data provider?
		if (latLongDataProvider != null) {
			// Yes
			retValue = latLongDataProvider.getLatLong(dataURI);
		} else {
			Activator.logError(
					"Unable to find a lat/long data provider for scheme \""
							+ dataURI.scheme() + "\"", null);
		}

		return retValue;
	} // getLatLong

	/**
	 * @param dataURI
	 *            the URI extracted from a dublin core <em>spatial</em>
	 *            attribute that specifies the location of lat/long data
	 * @return a list of arrays of latitude/longitude pairs.
	 */
	private LatLong getLatLongNoWait(final URI dataURI) {
		LatLong retValue = new LatLong();

		final LatLongDataProvider latLongDataProvider = getLatLongDataProvider(dataURI
				.scheme());
		// Did we find a data provider?
		if (latLongDataProvider != null) {
			// Yes
			retValue = latLongDataProvider.getLatLongNoWait(dataURI);
		} else {
			Activator.logError(
					"Unable to find a lat/long data provider for scheme \""
							+ dataURI.scheme() + "\"", null);
		}

		return retValue;
	} // getLatLongNoWait
	
	/* (non-Javadoc)
	 * @see org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProvider#getCenter()
	 */
	public double[] getCenter() {		
		//First try to get the center of the identifiable from the cache
		double[] centerLatLong = identifiableCenterCache.get(getTarget());
		if (centerLatLong != null) {
			//Yes, it was already calculated so just return the value
			return centerLatLong;
		}
		
		//Calculate the center and put it in the cache
		centerLatLong = new double[2];
		double maxLat = Double.MAX_VALUE, maxLong = Double.MAX_VALUE, minLat = Double.MIN_VALUE, minLong = Double.MIN_VALUE;
		LatLong latLong = getLatLongNoWait();
		if (latLong.getSegments().isEmpty()) {
			return null;
		}
		Iterator<Segment> segmentsIter = latLong.getSegments().iterator();
		while(segmentsIter.hasNext()) {
			Segment segment = segmentsIter.next();
			if (maxLat == Double.MAX_VALUE && minLat == Double.MIN_VALUE) { //Arbitrary initialize values from segment
				maxLat = minLat = segment.latitude(0);
				maxLong = minLong = segment.longitude(0);
			}
			final int size = segment.size();
			for (int i=0; i<size; i++) {				
				double lon = segment.longitude(i);
				double lat = segment.latitude(i);
				if (maxLong < lon) maxLong = lon;
				if (maxLat < lat) maxLat = lat;
				if (minLong > lon) minLong = lon;
				if (minLat > lat) minLat = lat;
			}
		}
		centerLatLong[0] = (maxLat + minLat) / 2.0;
		centerLatLong[1] = (maxLong + minLong) / 2.0;
		identifiableCenterCache.put((Identifiable)getTarget(), centerLatLong);
		return centerLatLong;
	} // getCenter

	/**
	 * @param scheme
	 *            the scheme of the data URI that we're looking for a lat/long
	 *            data provider for
	 * @return a LatLongDataProvider that can interpret the URI and extract
	 *         lat/long data, or null
	 */
	protected LatLongDataProvider getLatLongDataProvider(final String scheme) {
		return getLatLongDataProviders().get(scheme);
	} // getLatLongDataProvider

} // LatLongProviderAdapter

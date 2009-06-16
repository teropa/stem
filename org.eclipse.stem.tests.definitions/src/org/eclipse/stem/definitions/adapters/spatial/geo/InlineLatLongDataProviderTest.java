// InlineLatLongDataProviderTest.java
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapter;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;

/**
 * This class is a JUnit test for InlineLatLongDataProvider.
 */
@SuppressWarnings("all")
public class InlineLatLongDataProviderTest extends LatLongDataProviderTest {

	private static final String TEST_INLINE_LAT_LONG_URI_STRING_MISMATCH_ERROR1 = InlineLatLongDataProvider.INLINE_SCHEME
			+ ":///0,0,90,90,0";

	private static final String TEST_INLINE_LAT_LONG_URI_STRING_MISMATCH_ERROR2 = InlineLatLongDataProvider.INLINE_SCHEME
			+ ":///0,0,90,90,0,";

	private static final String TEST_INLINE_LAT_LONG_URI_STRING_NUMBER_FORMAT_ERROR = InlineLatLongDataProvider.INLINE_SCHEME
			+ ":///0,abc,90,90,0,0";

	/**
	 * Test string
	 */
	public static String TEST_INLINE_LAT_LONG_URI_STRING1 = InlineLatLongDataProvider.INLINE_SCHEME
			+ ":///0.00,0.00,90.00,90.00,0.00,90.00/10.00,15.00,10.00,20.00,20.00,20.00,40.00,40.00";

	@SuppressWarnings("unqualified-field-access")
	private InlineLatLongDataProvider getFixture() {
		return (InlineLatLongDataProvider) fixture;
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		setFixture(new InlineLatLongDataProvider());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.InlineLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLong1() {
		final InlineLatLongDataProvider fixture = getFixture();
		LatLong result = fixture.getLatLong(URI
				.createURI(TEST_INLINE_LAT_LONG_URI_STRING1));
		assertTrue(result.size() == 2);
		verifyInlineLatLongResult(result);
	} // testGetLatLong1

	/**
	 * @param result
	 */
	public static void verifyInlineLatLongResult(LatLong result) {
		Segment latLong0 = null;
		Segment latLong1 = null;
		if (result.getSegments().get(0).size() == 3) {
			latLong0 = result.getSegments().get(0);
			latLong1 = result.getSegments().get(1);

		} else {
			latLong0 = result.getSegments().get(1);
			latLong1 = result.getSegments().get(0);
		}

		// --- latLong0
		assertTrue(latLong0.latitude(0) == 0.0);
		assertTrue(latLong0.longitude(0) == 0.0);

		assertTrue(latLong0.latitude(1) == 90.0);
		assertTrue(latLong0.longitude(1) == 90.0);

		assertTrue(latLong0.latitude(2) == 0.0);
		assertTrue(latLong0.longitude(2) == 90.0);

		// --- latLong1
		assertTrue(latLong1.latitude(0) == 10.0);
		assertTrue(latLong1.longitude(0) == 15.0);

		assertTrue(latLong1.latitude(1) == 10.0);
		assertTrue(latLong1.longitude(1) == 20.0);

		assertTrue(latLong1.latitude(2) == 20.0);
		assertTrue(latLong1.longitude(2) == 20.0);

		assertTrue(latLong1.latitude(3) == 40.0);
		assertTrue(latLong1.longitude(3) == 40.0);

	} // verifyInlineLatLongResult

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.InlineLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLongMismatchError() {
		InlineLatLongDataProvider fixture = getFixture();
		try {
			LatLong result1 = fixture
					.getLatLong(URI
							.createURI(TEST_INLINE_LAT_LONG_URI_STRING_MISMATCH_ERROR1));
			assertTrue(result1.size() == 0);
		} // try
		catch (NullPointerException npe) {
			// expected
		}
		try {
			LatLong result2 = fixture
					.getLatLong(URI
							.createURI(TEST_INLINE_LAT_LONG_URI_STRING_MISMATCH_ERROR2));
			assertTrue(result2.size() == 0);
		} // try
		catch (NullPointerException npe) {
			// expected
		}
	} // testGetLatLongMismatchError

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.InlineLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLongNumberFormatError() {
		InlineLatLongDataProvider fixture = getFixture();
		try {
			LatLong result1 = fixture
					.getLatLong(URI
							.createURI(TEST_INLINE_LAT_LONG_URI_STRING_NUMBER_FORMAT_ERROR));
			assertTrue(result1.size() == 0);
		} // try
		catch (NullPointerException npe) {
			// expected
		}

	} // testGetLatLongNumberFormatError

	/**
	 * Test that we can create the inline URI string from the segment arrays
	 */
	public void testCreateInlineURIString() {
		final InlineLatLongDataProvider fixture = getFixture();
		LatLong result = fixture.getLatLong(URI
				.createURI(TEST_INLINE_LAT_LONG_URI_STRING1));
		final String resultString = InlineLatLongDataProvider
				.createInlineURIString(result);
		assertTrue(resultString.equals(TEST_INLINE_LAT_LONG_URI_STRING1));
	} // testCreateInlineURIString

	/**
	 * Test that we can create the spatial inline URI string from the segment
	 * arrays
	 */
	public void testCreateSpatialInlineURIString() {
		final InlineLatLongDataProvider fixture = getFixture();
		LatLong result = fixture.getLatLong(URI
				.createURI(TEST_INLINE_LAT_LONG_URI_STRING1));
		final String resultString = InlineLatLongDataProvider
				.createSpatialInlineURIString(result);
		assertTrue(resultString
				.startsWith(SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX));
		assertTrue(resultString.endsWith(TEST_INLINE_LAT_LONG_URI_STRING1));
		assertTrue(resultString.length() == (TEST_INLINE_LAT_LONG_URI_STRING1
				.length() + SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX
				.length()));
	} // testCreateSpatialInlineURIString
} // InlineLatLongDataProviderTest

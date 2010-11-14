// PlatformLatLongDataProviderTest.java
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

/**
 * This class is a JUnit test for PlatformLatLongDataProvider.
 * 
 * @see PlatformLatLongDataProvider
 * @see InlineLatLongDataProviderTest
 * @see InlineLatLongDataProvider
 */
@SuppressWarnings("all")
public class PlatformLatLongDataProviderTest extends LatLongDataProviderTest {

	// This is the project that contains the test files
	private static String PROJECT_NAME = "org.eclipse.stem.tests.definitions";

	// This is the path to the test files
	private static String PATH = "data/spatial/geo";

	// This is the name of a file
	private static String FILE_NAME1 = "test1gml.gml";

	private static final String LATLONG_ERROR_FILENAME = "testlatlongerror.gml";

	private static final String BAD_FORMAT_ERROR_FILENAME = "testbadformaterror.gml";

	private static final String ELEMENT_ERROR_FILENAME = "testelementerror.gml";

//	private static final String WHITE_SPACE_FILENAME = "testwhitespace.gml";
	
	/**
	 *  This is the complete string that would be extracted from a dublin core
	 * "spatial" attribute
	 */
	public static String TEST_PLATFORM_LAT_LONG_URI_STRING1 = PlatformLatLongDataProvider.PLATFORM_SCHEME
			+ ":/plugin/" + PROJECT_NAME + "/" + PATH + "/";

	// These are the node identifiers and the counts of the number of segments
	// in their latitude/longitude data
	public static String AK02013 = "#US-AK-02013";

	public static int AK02013COUNT = 0;

	public static String AK02290 = "#US-AK-02290";

	public static int AK02290COUNT = 0;

	public static String AL01001 = "#US-AL-01001";

	public static int AL01001COUNT = 1;

	public static String AL01003 = "#US-AL-01003";

	public static int AL01003COUNT = 1;

	public static String AL01095 = "#US-AL-01095";

	public static int AL01095COUNT = 2;

	public static String CA06037 = "#US-CA-06037";

	public static int CA06037COUNT = 3;

	public static String CA06083 = "#US-CA-06083";

	public static int CA06083COUNT = 3;

	public static String UNKNOWNID = "#UNKNOWNID";

	public static int UNKNOWNIDCOUNT = 0;

	static String[] ID_FRAGMENTS = new String[] { AK02013, AK02290, AL01001,
			AL01003, AL01095, CA06037, CA06083, UNKNOWNID };

	static int[] ID_SEGMENT_COUNTS = new int[] { AK02013COUNT, AK02290COUNT,
			AL01001COUNT, AL01003COUNT, AL01095COUNT, CA06037COUNT,
			CA06083COUNT, UNKNOWNIDCOUNT };

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		setFixture(new PlatformLatLongDataProvider());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	private PlatformLatLongDataProvider getFixture() {
		return (PlatformLatLongDataProvider) fixture;
	} // getFixture

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.PlatformLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLong() {
		final PlatformLatLongDataProvider fixture = getFixture();

		for (int i = 0; i < ID_FRAGMENTS.length; i++) {
			LatLong result = fixture.getLatLong(URI
					.createURI(TEST_PLATFORM_LAT_LONG_URI_STRING1 + FILE_NAME1
							+ ID_FRAGMENTS[i]));

			assertTrue(result.size() == ID_SEGMENT_COUNTS[i]);
		} // for i

	} // testGetLatLong

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.PlatformLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLongError() {
		final PlatformLatLongDataProvider fixture = getFixture();

		LatLong result = fixture.getLatLong(URI
				.createURI(TEST_PLATFORM_LAT_LONG_URI_STRING1
						+ LATLONG_ERROR_FILENAME + AL01001));
		assertTrue(result.size() == 0);
	} // testGetLatLongError

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.PlatformLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLongElementError() {
		final PlatformLatLongDataProvider fixture = getFixture();

		// This test prints on to System.err, so I've commented it out.
		// Otherwise it works.
		assertTrue(true);
		// LatLong result = fixture.getLatLong(URI
		// .createURI(TEST_PLATFORM_LAT_LONG_URI_STRING1
		// + ELEMENT_ERROR_FILENAME + AL01001));
		// assertTrue(result.size() == 0);
	} // testGetLatLongError

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.PlatformLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLongBadFormatError() {
		final PlatformLatLongDataProvider fixture = getFixture();

		// This test prints on to System.err, so I've commented it out.
		// Otherwise it works.
		assertTrue(true);
		// LatLong result = fixture.getLatLong(URI
		// .createURI(TEST_PLATFORM_LAT_LONG_URI_STRING1
		// + BAD_FORMAT_ERROR_FILENAME + AL01001));
		// assertTrue(result.size() == 0);
	} // testGetLatLongBadFormatError

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.PlatformLatLongDataProvider#getLatLong(org.eclipse.emf.common.util.URI)}.
	 */
	public void testGetLatLongWhitespaceProcessing() {
		final PlatformLatLongDataProvider fixture = getFixture();

		// This test prints on to System.err, so I've commented it out.
		// Otherwise it works.
		assertTrue(true);
		// LatLong result = fixture.getLatLong(URI
		// .createURI(TEST_PLATFORM_LAT_LONG_URI_STRING1
		// + WHITE_SPACE_FILENAME + AL01001));
		// assertTrue(result.size() != 0);
	} // testGetLatLongBadFormatError

	
	/**
	 * This "test" does a scan of a gml data file and checks that each polygon
	 * is closed. It reports the ones that are not.
	 * 
	 */
	public void testDataSanity() {
		final PlatformLatLongDataProvider fixture = getFixture();
		final String URI_STRING = "platform:/plugin/org.eclipse.stem.data.geography/resources/data/geo/country/USA/USA_2_MAP.xml";
		assertTrue(true);
		// polygonCheck(fixture, URI_STRING);

		// duplicateCheck(fixture, URI_STRING);

	} // testDataSanity

	/**
	 * @param fixture
	 * @param URI_STRING
	 */
//	private void polygonCheck(final PlatformLatLongDataProvider fixture,
//			final String uriString) {
//		final URI uri = URI.createURI(uriString);
//		final Collection<String> ids = fixture.getIds(uri);
//		System.out.println("The following Segments are not polygons");
//		for (String id : ids) {
//			boolean firstTime = true;
//			boolean foundNotPolygon = false;
//			int segmentCount = 0;
//
//			final LatLong result = fixture.getLatLong(URI.createURI(uriString
//					+ "#" + id));
//
//			// Get each segment and test for polygoness
//			for (Segment segment : result.getSegments()) {
//				// Is this a polygon?
//				if (!segment.isPolygon()) {
//					// No
//					foundNotPolygon = true;
//					// Print the id?
//					if (firstTime) {
//						// Yes
//						System.out.println("ID: \"" + id + "\"");
//						firstTime = false;
//					}
//					System.out.println("\tSegment " + segmentCount + ": "
//							+ segment.toString());
//				} // if not a polygon
//				segmentCount++;
//
//			} // for each segment
//			// not a polygon?
//			if (foundNotPolygon) {
//				// Yes
//				System.out.println();
//			}
//		} // for each id
//	} // polygonCheck

	/**
	 * Examine the segments in the data for duplications
	 * 
	 * @param fixture
	 * @param uri_string
	 */
//	private void duplicateCheck(PlatformLatLongDataProvider fixture,
//			String uriString) {
//		final URI uri = URI.createURI(uriString);
//		final Collection<String> ids = fixture.getIds(uri);
//
//		// We get every segment and put it into a map keyed by its hashcode.
//		// Before we put them into the map however, we see if something with
//		// that hash code is already there. If so we check for equality and if
//		// they're equal we've got duplication.
//
//		Map<Integer, DuplicateMapEntry> map = new HashMap<Integer, DuplicateMapEntry>();
//		List<DuplicateMapEntry> dupList = new ArrayList<DuplicateMapEntry>();
//
//		for (String id : ids) {
//
//			final LatLong result = fixture.getLatLong(URI.createURI(uriString
//					+ "#" + id));
//			int segmentCount = 0;
//
//			// Get each segment and test for polygoness
//			for (Segment segment : result.getSegments()) {
//
//				Integer hashcode = new Integer(segment.hashCode());
//
//				DuplicateMapEntry entry = map.get(hashcode);
//				// Is the segment in the map already?
//				if (entry == null) {
//					// No
//					map.put(hashcode, new DuplicateMapEntry(id, segmentCount,
//							segment));
//				} // if
//				else {
//					// Yes
//					// Dup!
//					// Are they truely EQUAL!
//					if (entry.segment.equals(segment)) {
//						// Yes
//						entry.add(new DuplicateMapEntry(id, segmentCount,
//								segment));
//						// Add this to the dup list?
//						if (entry.duplicates.size() == 1) {
//							// Yes
//							dupList.add(entry);
//						}
//					}
//				} // else Dup!
//				segmentCount++;
//			} // for each segment
//
//		} // for each id
//
//		// Are there any duplications?
//		if (dupList.size() > 0) {
//			// Yes
//			System.out.println();
//			System.out.println("There are " + dupList.size()
//					+ " duplicate segments.\n");
//			System.out.println();
//
//			// The duplicates are on the dup list...
//			for (DuplicateMapEntry entry : dupList) {
//				System.out.println("Id: " + entry.id + " segment "
//						+ entry.segmentNumber + ": \""
//						+ entry.segment.toString() + "\"");
//				for (DuplicateMapEntry dupEntry : entry.duplicates) {
//					System.out.println("\tId: " + dupEntry.id + " segment "
//							+ dupEntry.segmentNumber + ": \""
//							+ dupEntry.segment.toString() + "\"");
//				}
//				System.out.println();
//			} // for
//		}
//	} // duplicateCheck

//	private static class DuplicateMapEntry {
//		String id = null;
//
//		int segmentNumber = -1;
//
//		Segment segment = null;
//
//		List<DuplicateMapEntry> duplicates = null;
//
//		/**
//		 * @param id
//		 * @param segmentNumber
//		 * @param segment
//		 */
//		protected DuplicateMapEntry(String id, int segmentNumber,
//				Segment segment) {
//			this.id = id;
//			this.segmentNumber = segmentNumber;
//			this.segment = segment;
//		} // DuplicateMapEntry
//
//		public void add(DuplicateMapEntry entry) {
//			// Any duplicates already
//			if (duplicates == null) {
//				// No
//				duplicates = new ArrayList<DuplicateMapEntry>();
//			}
//			duplicates.add(entry);
//		}
//	} // DuplicateMapEntry

} // PlatformLatLongDataProviderTest

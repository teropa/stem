// SegmentBuilderTest.java
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

import junit.framework.TestCase;

import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder;

/**
 * This class is a JUnit test for LatLong.SegmentBuilder
 */
@SuppressWarnings("all")
public class SegmentBuilderTest extends TestCase {

	protected SegmentBuilder fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private SegmentBuilder getFixture() {
		return fixture;
	}

	protected void setFixture(SegmentBuilder fixture) {
		this.fixture = fixture;
	}

	/**
	 * @return the fixture for testing
	 */
	public static SegmentBuilder createFixture() {
		return new SegmentBuilder();
	} // createFixture

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder#add(java.lang.String, java.lang.String)}.
	 */
	public void testAddStringString() {
		final SegmentBuilder sb = getFixture();
		sb.add("1.5", "2.5");
		final Segment segment = sb.toSegment();
		assertTrue(segment.size() == 1);
		assertTrue(segment.latitude(0) == 1.5);
		assertTrue(segment.longitude(0) == 2.5);
	} // testAddStringString

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder#add(double, double)}.
	 */
	public void testAddDoubleDouble() {
		final SegmentBuilder sb = getFixture();
		sb.add(1.5, 2.5);
		final Segment segment = sb.toSegment();
		assertTrue(segment.size() == 1);
		assertTrue(segment.latitude(0) == 1.5);
		assertTrue(segment.longitude(0) == 2.5);
	} // testAddDoubleDouble

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder#size()}.
	 */
	public void testSize() {
		final SegmentBuilder sb = getFixture();
		assertTrue(sb.size() == 0);
		sb.add(1.5, 2.5);
		assertTrue(sb.size() == 1);
		sb.add(3.5, 4.5);
		assertTrue(sb.size() == 2);
	} // testSize

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder#clear()}.
	 */
	public void testClear() {
		final SegmentBuilder sb = getFixture();
		assertTrue(sb.size() == 0);
		sb.add(1.5, 2.5);
		assertTrue(sb.size() == 1);
		sb.add(3.5, 4.5);
		assertTrue(sb.size() == 2);
		sb.clear();
		assertTrue(sb.size() == 0);
	} // testClear

	/**
	 * Test toSegment with filtering
	 */
	public void testToSegment() {
		final SegmentBuilder sb = getFixture();
		assertTrue(sb.size() == 0);
		sb.add(0, 0);
		sb.add(1, 1);
		sb.add(2, 2);
		sb.add(3, 3);
		sb.add(4, 4);
		sb.add(5, 5);
		sb.add(6, 6);
		sb.add(7, 7);
		assertTrue(sb.size() == 8);

		final Segment filteredSegment4 = sb.toSegment(4);
		assertTrue(filteredSegment4.size() == 3);
		assertTrue(filteredSegment4.latitude(0) == 0);
		assertTrue(filteredSegment4.longitude(0) == 0);
		assertTrue(filteredSegment4.latitude(1) == 4);
		assertTrue(filteredSegment4.longitude(1) == 4);
		assertTrue(filteredSegment4.latitude(2) == 7);
		assertTrue(filteredSegment4.longitude(2) == 7);

		final Segment filteredSegment1 = sb.toSegment(1);
		assertTrue(filteredSegment1.size() == sb.size());
		assertTrue(filteredSegment1.latitude(0) == 0);
		assertTrue(filteredSegment1.longitude(0) == 0);
		assertTrue(filteredSegment1.latitude(1) == 1);
		assertTrue(filteredSegment1.longitude(1) == 1);
		assertTrue(filteredSegment1.latitude(2) == 2);
		assertTrue(filteredSegment1.longitude(2) == 2);
		assertTrue(filteredSegment1.latitude(3) == 3);
		assertTrue(filteredSegment1.longitude(3) == 3);
		assertTrue(filteredSegment1.latitude(4) == 4);
		assertTrue(filteredSegment1.longitude(4) == 4);
		assertTrue(filteredSegment1.latitude(5) == 5);
		assertTrue(filteredSegment1.longitude(5) == 5);
		assertTrue(filteredSegment1.latitude(6) == 6);
		assertTrue(filteredSegment1.longitude(6) == 6);
		assertTrue(filteredSegment1.latitude(7) == 7);
		assertTrue(filteredSegment1.longitude(7) == 7);

		final Segment filteredSegmentTooBig = sb.toSegment(sb.size());
		assertTrue(filteredSegmentTooBig.size() == 3);
		assertTrue(filteredSegmentTooBig.latitude(0) == 0);
		assertTrue(filteredSegmentTooBig.longitude(0) == 0);
		assertTrue(filteredSegmentTooBig.latitude(1) == 4);
		assertTrue(filteredSegmentTooBig.longitude(1) == 4);
		assertTrue(filteredSegmentTooBig.latitude(2) == 7);
		assertTrue(filteredSegmentTooBig.longitude(2) == 7);

		final Segment filteredSegmentSameSize = sb.toSegment(sb.size() - 1);
		assertTrue(filteredSegmentSameSize.size() == 3);
		assertTrue(filteredSegmentSameSize.latitude(0) == 0);
		assertTrue(filteredSegmentSameSize.longitude(0) == 0);
		assertTrue(filteredSegmentSameSize.latitude(1) == 4);
		assertTrue(filteredSegmentSameSize.longitude(1) == 4);
		assertTrue(filteredSegmentSameSize.latitude(2) == 7);
		assertTrue(filteredSegmentSameSize.longitude(2) == 7);

		try {
			final Segment filteredSegmentTooSmall = sb.toSegment(0);
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// expected
		}

	} // testToSegment
} // SegmentBuilderTest

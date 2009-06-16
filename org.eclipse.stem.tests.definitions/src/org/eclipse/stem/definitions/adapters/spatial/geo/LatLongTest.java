// LatLongTest.java
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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder;

/**
 * This class is a JUnit test case for LatLong.
 */
@SuppressWarnings("all")
public class LatLongTest extends TestCase {

	protected LatLong fixture = null;

	private LatLong getFixture() {
		return fixture;
	}

	protected void setFixture(LatLong fixture) {
		this.fixture = fixture;
	}

	public static LatLong createFixture() {
		LatLong retValue = new LatLong();
		final Segment segment = SegmentTest.createFixture();
		retValue.add(segment);
		return retValue;
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
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong#add(org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment)}.
	 */
	public void testAddSegment() {
		final LatLong latLong = getFixture();
		assertTrue(latLong.size() == 1);
		final Segment segment = SegmentTest.createFixture();
		latLong.add(segment);
		assertTrue(latLong.size() == 2);
		assertTrue(latLong.getSegments().contains(segment));
	} // testAddSegment

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong#add(java.util.List)}.
	 */
	public void testAddListOfSegment() {
		final LatLong latLong = getFixture();
		assertTrue(latLong.size() == 1);

		final SegmentBuilder sb1 = new SegmentBuilder();
		sb1.add(1.0, 2.0);
		sb1.add(3.0, 4.0);
		final SegmentBuilder sb2 = new SegmentBuilder();
		sb2.add(10.0, 20.0);
		sb2.add(30.0, 40.0);

		final List<Segment> segmentList = new ArrayList<Segment>();
		segmentList.add(sb1.toSegment());
		segmentList.add(sb2.toSegment());
		latLong.add(segmentList);

		assertTrue(latLong.size() == 3);

	} // testAddListOfSegment

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong#add(org.eclipse.stem.definitions.adapters.spatial.geo.LatLong)}.
	 */
	public void testAddLatLong() {
		final LatLong latLong = getFixture();
		assertTrue(latLong.size() == 1);
		latLong.add(createFixture());
		assertTrue(latLong.size() == 2);
	} // testAddLatLong

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong#getSegments()}.
	 */
	public void testGetSegments() {
		final LatLong latLong = getFixture();
		assertTrue(latLong.size() == 1);
		assertTrue(latLong.getSegments().size() == 1);
	} // testGetSegments

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong#size()}.
	 * 
	 * Basically the same as {@link #testAddSegment()}
	 */
	public void testSize() {
		final LatLong latLong = getFixture();
		assertTrue(latLong.size() == 1);
		final Segment segment = SegmentTest.createFixture();
		latLong.add(segment);
		assertTrue(latLong.size() == 2);
		assertTrue(latLong.getSegments().contains(segment));
	} // testSize

} // LatLongTest

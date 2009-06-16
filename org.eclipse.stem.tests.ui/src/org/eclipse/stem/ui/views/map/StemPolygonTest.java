package org.eclipse.stem.ui.views.map;

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

import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.ui.views.geographic.map.StemPolygon;

/**
 * This class is a TestCase for the StemPolygon class.
 * 
 */
public class StemPolygonTest extends TestCase {

	protected StemPolygon fixture = null;

	protected double THRESHOLD = 0.000001;

//	/**
//	 * the default ForeGround Color Key
//	 */
//	private static final String DEFAULT_COLOR_KEY = VisualizationPreferencePage.FOREGROUND_ATTRIBUTE_NAME_DEFAULT_STRING;

	/**
	 * Constructs a test case with the given name.
	 * 
	 * @param name
	 */
	public StemPolygonTest(final String name) {
		super(name);
	}

	/**
	 * Creates an StemPolygon object.
	 * 
	 * @return StemPolygon
	 */
	public StemPolygon createFixture() {
		final StemPolygon poly = new StemPolygon();
		return poly;
	}

	/**
	 * Sets the object created to be the one held by the class.
	 * 
	 * @param fixture
	 */
	protected void setFixture(final StemPolygon fixture) {
		this.fixture = fixture;
	}

	@SuppressWarnings("unused")
	private StemPolygon getFixture() {
		return fixture;
	}

	@Override
	protected void setUp() throws Exception {
		TestUtil.resetCounters();
		setFixture(createFixture());
	}

	/**
	 * Checks that the polygon created is empty.
	 * 
	 */
	public void testStemPolygon() {
		final StemPolygon poly = createFixture();
		assertTrue(poly.getNumberOfPoints() == 0);
	}

//	/**
//	 * Tests the retrieval if a relative value of a polygon.
//	 * 
//	 */
//	public void testGetRelativeValue() {
//		final StemPolygon poly = createFixture();
//
//		poly.setRelativeValue(DEFAULT_COLOR_KEY, 0.5);
//
//		final Map<String, Double> relativeValueMap = poly.getRelativeValueMap();
//
//		final double retVal = relativeValueMap.get(DEFAULT_COLOR_KEY)
//				.doubleValue();
//
//		assertTrue(Math.abs(retVal - 0.5) < THRESHOLD);
//	}

}

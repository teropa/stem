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
import org.eclipse.stem.ui.views.geographic.map.StemPolygonsList;

/**
 * This class is a TestCase for the StemPolygonsList class.
 * 
 */
public class StemPolygonsListTest extends TestCase {

	protected StemPolygonsList fixture = null;

	protected double THRESHOLD = 0.000001;

	/**
	 * Constructs a test case with the given name.
	 * 
	 * @param name
	 */
	public StemPolygonsListTest(String name) {
		super(name);
	}

	/**
	 * Creates an StemPolygonsList object.
	 * 
	 * @return StemPolygonsList
	 */
	public StemPolygonsList createFixture() {
		final StemPolygonsList polyList = new StemPolygonsList();
		return polyList;
	}

	/**
	 * Sets the test object to be the one held by the class.
	 * 
	 * @param fixture
	 */
	protected void setFixture(StemPolygonsList fixture) {
		this.fixture = fixture;
	}

	@SuppressWarnings("unused")
	private StemPolygonsList getFixture() {
		return fixture;
	}

	@Override
	protected void setUp() throws Exception {
		TestUtil.resetCounters();
		setFixture(createFixture());
	}

	/**
	 * Checks that the created polygons list is empty.
	 * 
	 */
	public void testStemPolygonsList() {

		final StemPolygonsList polyList = createFixture();
		assertTrue(polyList.isEmpty());

	}

} // StemPolygonsListTest

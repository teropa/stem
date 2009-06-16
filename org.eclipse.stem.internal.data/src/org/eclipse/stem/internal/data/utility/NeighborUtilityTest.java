// NeighborUtilityTest.java
package org.eclipse.stem.internal.data.utility;

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
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongDataProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.PlatformLatLongDataProvider;

/**
 * This class is a utility that uses JUnit test to provide the execution
 * environment. This is easier then writing a view that that the user has to
 * open.
 * 
 * It will access the specified geography files and calculate Neighbors either
 * within a country or between countries.
 * 
 * See NeighborUtility for instructions of how to run this utility as a JUnit
 * plugin.
 * 
 * @see NeighborUtility
 * @see PlatformLatLongDataProvider
 * 
 */
public class NeighborUtilityTest extends TestCase {
	/**
	 * Passed to NeighborUtility
	 */
	protected LatLongDataProvider fixture;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() {
		setFixture(new PlatformLatLongDataProvider());
		System.out.println("NeighborUtilityTest: baseFolder="
				+ NeighborUtility.baseFolder);
		System.out.println("NeighborUtilityTest: outputFolder="
				+ NeighborUtility.getPropertyFolder());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() {
		setFixture(null);
	}

	private PlatformLatLongDataProvider getFixture() {
		return (PlatformLatLongDataProvider) fixture;
	} // getFixture

	protected final void setFixture(final LatLongDataProvider fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Run whatever tests are not commented out
	 * 
	 */
	public void testRun() {
		try {
			NeighborUtility.DEBUG = false;
			// System.out.println("tstInternalNeighbors");
			// tstInternalNeighbors("GRC"); // Greece
			// tstInternalNeighbors("BRA"); // Brazil
			// tstInternalNeighbors("USA");
			// System.out.println("tstNeighbors2");
			// tstNeighbors2("ALB","GRC");
			//       
			// DOAll true will cause the list generated
			// by DoWorld to be used to DoAllBorders
			// boolean doAll = true;
			// System.out.println("tstDoWorld doAll="+doAll);
			// tstDoWorld(doAll);
			//       
			System.out.println("tstDoAllInternal");
			tstDoAllInternal();

			// generate all bordering countries
			// using the previous generated ZZZ file
			// System.out.println("tstDoAllBorders");
			// tstDoAllBorders();

		} catch (final Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Run a test of the neightborCheck method with a single Map so that it
	 * generates a properties file for the internal neighbors.
	 * 
	 * @param admin0
	 *            3 char country to be processed
	 * 
	 */
	public void tstInternalNeighbors(final String admin0) {
		final PlatformLatLongDataProvider fixture = getFixture();
		// @SuppressWarnings("unused")
		// String admin0 = "MEX";
		final String admin = NeighborUtility.getAdmin(admin0);
		System.out.println(admin0 + ":" + admin);
		// String test =
		// "platform:/plugin/org.eclipse.stem.geography/resources/data/geo/country/USA/USA_2_MAP.xml";
		// System.out.println(test);
		final List<String[]> list = NeighborUtility.neighborCheck(fixture,
				admin0, admin);
		NeighborUtility.writeProperties(list, admin0, admin, admin0, admin);
		NeighborUtility.statistics();

	} // testNeighbors

	/**
	 * Run a test of the neightborCheck method with maps of 2 bordering
	 * countries so that it generates a properties file for the bordering
	 * neighbors.
	 * 
	 * @param admin0A
	 *            3 char country to be processed
	 * @param admin0B
	 *            3 char country to be processed
	 * 
	 * 
	 */
	public void tstNeighbors2(final String admin0A, final String admin0B) {
		final PlatformLatLongDataProvider fixture = getFixture();
		final String adminA = NeighborUtility.getAdmin(admin0A);

		final String adminB = NeighborUtility.getAdmin(admin0B);
		System.out.println(admin0A + ":" + adminA + " - " + admin0B + ":"
				+ adminB);

		final List<String[]> list = NeighborUtility.neighborCheck(fixture,
				admin0A, adminA, admin0B, adminB);
		NeighborUtility.writeProperties(list, admin0A, adminA, admin0B, adminB);
		NeighborUtility.statistics();
	}

	/**
	 * Run a test of building the ZZZ0_ZZZ0 map to select all the worlds
	 * neighbors (or some subset)
	 * 
	 * From ZZZ AFG CHN (Afghanistan and China)
	 * 
	 * create AFG2_CHN2
	 * 
	 * 
	 * 
	 * @param doAll
	 *            if true then also generate border property files for everyone
	 *            and her neighbor
	 */
	public void tstDoWorld(final boolean doAll) {
		final PlatformLatLongDataProvider fixture = getFixture();

		final List<String[]> list = NeighborUtility.doWorld(fixture, doAll);
		if (doAll) {
			NeighborUtility.doAllBorders(fixture, list);
		}
	} // testDoWorld

	/**
	 * Run a test of the neightborCheck method using the ZZZ0_ZZZ0 map to select
	 * all the worlds neighbors (or some subset)
	 * 
	 * From ZZZ AFG CHN (Afghanistan and China) create AFG2_AFG2 create
	 * CHN2_CHN2
	 * 
	 * 
	 * 
	 * 
	 */
	public void tstDoAllInternal() {
		final PlatformLatLongDataProvider fixture = getFixture();

		NeighborUtility.doAllInternal(fixture);

	} // testDoAllInternal

	/**
	 * Run a test of the neightborCheck method using the ZZZ0_ZZZ0 map to select
	 * all the worlds neighbors (or some subset)
	 * 
	 * From ZZZ AFG CHN (Afghanistan and China)
	 * 
	 * create AFG2_CHN2
	 * 
	 * 
	 * 
	 * 
	 */
	public void tstDoAllBorders() {
		final PlatformLatLongDataProvider fixture = getFixture();

		NeighborUtility.doAllBorders(fixture);

	} // testDoAllNeighbors
}

package org.eclipse.stem.ui.ge;
/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/ 

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;

/**
 * test
 *
 */
public class GEDataTest extends TestCase {

	String name = null;
	
	GEData gedata = null;
	
	/**
	 * @param name
	 */
	public GEDataTest(String name) {
		super(name);
		GELog.DEBUG = true;
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		name = "Test";
		double[][] d = {{0.0, 0,0},
				{10.0, 0,0},
				{10.0, 10,0},
				{0.0, 10,0},
				{0.0, 0,0} };
		Segment s = new Segment(d);
		LatLong polygon = new LatLong();
		polygon.add(s);
		double[][] d2 = {{20.0, 0,0},
				{20.0, 20,0},
				{40.0, 0,0},
				{20.0, 0,0} };
		Segment s2 = new Segment(d2);
		polygon.add(s2);
		gedata = new GEData(name,polygon);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * 
	 */
	public void testGEData() {
		Assert.assertNotNull("setup failed.",gedata);
		GEData gedatax = new GEData("TestGEData",null);
		if (gedatax == null) 
			fail("Failed to create a GEData instance");
	}

	/**
	 * 
	 */
	public void testGetCoordinatesAsString() {
		String coord = gedata.getCoordinatesAsString(0);
		if (coord == null || coord.length() <= 0)
			fail("failed to create a KML string of Coordinates.");
		GELog.debug(this," coord: "+coord);
	}

	/**
	 * 
	 */
	public void testGetNumAreas() {
		assertTrue(gedata.getNumAreas() == 2);
	}

	/**
	 * 
	 */
	public void testGetName() {
		assertTrue(gedata.getName().equals("Test"));
		gedata.setName("NewTest");
		assertTrue(gedata.getName().equals("NewTest"));
	}

	/**
	 * 
	 */
	public void testSetName() {
		gedata.setName("Test2");
		assertTrue(gedata.getName().equals("Test2"));
	}

	/**
	 * 
	 */
	public void testGetId() {
		assertTrue(gedata.getId().equals("Test"));
	}

	/**
	 * 
	 */
	public void testSetId() {
		gedata.setId("Test3");
		assertTrue(gedata.getId().equals("Test3"));
	}
	/** 
	 * 
	 */
	@SuppressWarnings("boxing")
	public void testSetValue() {
		Aspect testAspect = new Aspect("T","Test");
		gedata.setValue(testAspect, 0.5);
		double value = gedata.getValue(testAspect);
		assertEquals(value,0.5);
	}
}

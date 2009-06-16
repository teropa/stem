package org.eclipse.stem.ui.ge.views;

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

import junit.framework.TestCase;


import org.eclipse.stem.ui.ge.GELog;

/**
 * Test of the GEPreferenc Page
 * 
 * This testcase must run as a JUnit PluginTest.
 *
 */
public class GEPreferencePageTest extends TestCase {

	/**
	 * @param name
	 */
	public GEPreferencePageTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		GELog.DEBUG = true;
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#getFolder()}.
	 */
	public void testGetFolder() {
		String folder = GEPreferencePage.getFolder();
		if (folder == null)
		  fail("Returned null from getFolder()");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#setFolder(java.lang.String)}.
	 */
	public void testSetFolder() {
		GEPreferencePage.setFolder("c:/tmp");
		String folder = GEPreferencePage.getFolder();
		if (! "c:/tmp".equals(folder)) {
			fail("setFolder failed.");
		}
	}


	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#getAspect()}.
	 */
//	public void testGetAspect() {
//		Aspect aspect = GEPreferencePage.getAspect();
//      This can return null		
//		Assert.assertNotNull("Invalid Aspect",aspect);
//	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#getServerHost()}.
	 */
	
	public void testGetServerHost() {
		String expected = "localhost:8080";
		String host = GEPreferencePage.getServerHost();
		if (! expected.equals(host)) {
			fail("getServerHost failed.");
		}
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#isAutoLaunch()}.
	 */
	public void testgetMethod() {
		int expected = GEPreferencePage.M_MANUAL_DISPLAY;
		int test = GEPreferencePage.getMethod();
		if ( expected != test ) {
			fail("getMethod() failed.");
		}
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#isInternalServer()}.
	 */
	public void testIsInternalServer() {
		boolean expected = true;
		boolean test = GEPreferencePage.isInternalServer();
		if (expected != test) {
			fail("IsInternalServer() failed.");
		}
	}

	/**
	 * Test method.
	 */
	public void testIsAutoNetworkLink() {
		boolean expected = true;
		boolean test = GEPreferencePage.isAutoLaunch();
		if (expected != test) {
			fail("IsAutoLaunch() failed.");
		}
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.views.GEPreferencePage#getWhichCycle()}.
	 */
	public void testGetWhichCycle() {
		int expected = 1;
		int test = GEPreferencePage.getWhichCycle();
		if (expected != test) {
			fail("GetWhichCycle() failed.");
		}
	}

}

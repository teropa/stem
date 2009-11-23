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
//import java.io.File;

//import org.eclipse.stem.ui.ge.servlet.SlideShowInfo;
//import org.eclipse.stem.ui.ge.servlet.SlideShowServlet;


import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.stem.ui.ge.servlet.VerifyClient;

/**
 * test for the SlideShowServlet
 * 
 * Currently this requires that the external Tomcat webserver 
 * is available at localhost:8080  
 * 
 * It could be redone to use the embedded web server support 
 * to verify that the servlets work.
 *
 */
public class SlideShowServletTest extends TestCase {
	/**
	 * info 
	 */
//	public SlideShowInfo info = null;
	
	VerifyClient vc = null;
	/**
	 * @param name
	 */
	public SlideShowServletTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
//		info = new SlideShowInfo("key","e:\\tmp\\ge",false,null);
		vc = new VerifyClient();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method 
	 */
	public void testGetFiles() {
//		File[] files = null;
//		SlideShowServlet test = new SlideShowServlet();
//		files = test.getFiles(info);
//		if (files == null)
//		   fail("getFiles returned null");
//		for (int i=0; i<files.length; i++) {
//			System.out.println("file: "+i+" "+files[i].getName());
//		}
		
	}

	/**
	 * Verify that the webserver is active and 
	 * the verifyServlet is deployed 
	 */
	public void testVerify() {
		String url = "http://localhost:8080/SlideShow/verify";
		
		boolean result = vc.verify(url);
		Assert.assertTrue(vc.getError(),result);
	}

	/**
	 * Verify that when the webserver is active but the  
	 * the verifyServlet is not deployed we get an error 
	 * We will test for this by using an invalid servlet name
	 */
	public void testVerify1() {
		String url = "http://localhost:8080/SlideShow/verify1";
		boolean result = vc.verify(url);
		
		if (result || ! vc.getError().startsWith("EXCEPTION"))
		   Assert.fail(vc.getError());
	}
	/**
	 * Verify that when the webserver is not active we 
	 * get an error msg
	 * We will test this by specifing an invalid port
	 */
	public void testVerify2() {	
		String url = "http://localhost:5555/SlideShow/verify";		
		boolean result = vc.verify(url);
		if (result || ! vc.getError().startsWith("EXCEPTION"))
			   Assert.fail(vc.getError());
		
	}
	/**
	 * Verify that we get an error for an invalid URL
	 */
	public void testVerify3() {	
		String url = "localhost:5555/SlideShow/verify";		
		boolean result = vc.verify(url);
		if (result || ! vc.getError().startsWith("ERROR"))
			   Assert.fail(vc.getError());
		
	}
}

package org.eclipse.stem.ui.ge.kml;
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
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

import org.eclipse.stem.ui.ge.GELog;

/**
 *
 */
public class StemKmlTest extends TestCase {

	/**
	 * @param name
	 */
	public StemKmlTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * test startup of embedded web server
	 * Test must run as JUnit plugin test
	 * This will test both the code to start the 
	 * web server but also the deployment of the 
	 * servlets. 
	 * 
	 * The result of the test should be that a 
	 * small png image with text "Default" 
	 * will be displayed on your browser.
	 * 
	 */
   public void teststartWebServer() {
	  GELog.DEBUG = true;
	  
   	  try {
		String urlstr = StemKml.startWebServer();
		  if (urlstr == null || urlstr.length() <= 0)
				fail("failed to start the internal web server."); //$NON-NLS-1$
		  urlstr = urlstr+"/"+"SlideShow"+"/"+"image"; //$NON-NLS-4$
		  URL url = new URL(urlstr);
		  GELog.debug(this,"URL: "+url.toString());
		  StemKml.launch(urlstr);
		  try {
	            Thread.sleep(20*1000);
	      }  catch (InterruptedException e) {
	            // Ignored.
	      }
	  } catch (MalformedURLException e) {
		e.printStackTrace();
		fail("Exception starting embedded server");
	  }
   	  
   }
}

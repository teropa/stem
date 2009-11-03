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

/**
 * testcase for GELOG
 *
 */
public class GELogTest extends TestCase {

	/**
	 * @param name
	 */
	public GELogTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * 
	 */
	public void testLogOn() {
		GELog.DEBUG=true;
		GELog.debug(this.getClass(),"DEBUG option turned ON");//$NON-NLS-1$ 
		GELog.debug("test msg");//$NON-NLS-1$ 
		Assert.assertTrue(GELog.DEBUG);
	}
	/**
	 * 
	 */
	public void testLogDebug() {
		GELog.DEBUG=true;
		GELog.debug(this.getClass(),"Verify: GELogTest: ");//$NON-NLS-1$ 
		GELog.debug(this,"Verify: GELogTest: ");//$NON-NLS-1$ 
		GELog.debug("GELogTest.testLog","Verify: GELogTest.testLog: ");//$NON-NLS-1$//$NON-NLS-2$  
		Assert.assertTrue(GELog.DEBUG);
	
	}
	/**
	 * 
	 */
	public void testLogError() {
		GELog.DEBUG=true;
		GELog.error("GELogTest: error ",null);//$NON-NLS-1$ 
		
	}
	/**
	 * 
	 */
	public void testLogInfo() {
		GELog.DEBUG=true;
		GELog.info("GELogTest: info ");//$NON-NLS-1$ 
		
	}

	/**
	 * 
	 */
	public void testLogOFF() {	
		GELog.debug(this,"DEBUG option will be turned OFF");//$NON-NLS-1$ 
		GELog.DEBUG=false;
		GELog.debug(this,"DEBUG option turned OFF");//$NON-NLS-1$ 
		Assert.assertFalse(GELog.DEBUG);
	}
	
}


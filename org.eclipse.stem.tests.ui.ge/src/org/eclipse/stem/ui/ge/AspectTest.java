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

import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;


/**
 * Test the Aspect class 
 * 
 * This can run as a java junit class 
 * It does not have to run as a plugin
 *
 */
public class AspectTest extends TestCase {
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		// Should do just S E I R as default
		//Properties properties = new Properties();
		// call the setup() method for the Aspect class.
		Aspect.setup();		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setup()}.
	 */
	public void testSetup() {
		
		Aspect.setup();
	}

	
	/**
	 * Test method for org.eclipse.stem.ui.ge.Aspect#getAspects(Properties)
	 */
	public void testGetAspects() {
		// we did the getAspects in setup so just check results
		Map<String,Aspect> aspects = Aspect.getMap();
		
		Assert.assertEquals(4,aspects.size());
		for(Map.Entry<String,Aspect> entry: aspects.entrySet()) {
			Aspect aspect = entry.getValue();
			boolean sane = aspect.isSane();
			Assert.assertTrue(sane);
		}
		
	}
	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#Aspect(java.lang.String, java.lang.String)}.
	 */
	public void testAspect() {
		Aspect a = new Aspect("T","Test");
		Assert.assertNotNull("Constructor failed", a);	
	}
	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getAspect(java.lang.String)}.
	 */
	public void testGetAspect() {
		
		Aspect t = Aspect.getAspect("S");		
		Assert.assertEquals(t.getCode(),"S");
	}
	/**
	 * Test method for 
	 */
	public void testGetDefault() {
		Aspect defaultA = Aspect.getDefault();
		Assert.assertEquals("I",defaultA.getCode());
		
	}
	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#exists(java.lang.String)}.
	 */
	public void testExists() {
			
		Assert.assertTrue(Aspect.exists("E"));
		Assert.assertFalse(Aspect.exists("X"));
	}
	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getMap()}.
	 */
	public void testGetMap() {
		Map<String,Aspect> map = Aspect.getMap();
		Assert.assertNotNull("getMap failed", map);
	}

	

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getCode()}.
	 */
	public void testGetCode() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertEquals(test.getCode(),"R");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setCode(java.lang.String)}.
	 */
	public void testSetCode() {
		Aspect test = Aspect.getAspect("R");
		test.setCode("X");
		Assert.assertEquals(test.getCode(),"X");
		Assert.assertTrue(Aspect.exists("X"));
	}

	

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setName(java.lang.String)}.
	 */
	public void testSetName() {
		Aspect test = Aspect.getAspect("R");
		test.setName("NewName");
		Assert.assertEquals(test.getName(),"NewName");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#toString()}.
	 */
	public void testToString() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertEquals(test.toString(),test.getCode());
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getDescription()}.
	 */
	public void testGetDescription() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertNotNull(test.getDescription());
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setDescription(java.lang.String)}.
	 */
	public void testSetDescription() {
		Aspect test = Aspect.getAspect("R");
		test.setDescription("New description");
		Assert.assertEquals(test.getDescription(),"New description");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getRange()}.
	 */
	public void testGetRange() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertTrue(test.isSane());
		
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setRange(java.lang.String)}.
	 */
	@SuppressWarnings("boxing")
	public void testSetRangeString() {
		Aspect test = Aspect.getAspect("R");
		test.setRange("0.0,0.5,1.0");
		Assert.assertEquals(test.getRange(1),0.5);
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getOpacity()}.
	 */
	public void testGetOpacity() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertEquals(test.getOpacity(0), 0);
	}

	

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setOpacity(java.lang.String)}.
	 */
	public void testSetOpacity() {
		Aspect test = Aspect.getAspect("R");
		test.setOpacity("0");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setRed(java.lang.String)}.
	 */
	public void testSetRed() {
		Aspect test = Aspect.getAspect("R");
		test.setRed("0");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setGreen(java.lang.String)}.
	 */
	public void testSetGreen() {
		Aspect test = Aspect.getAspect("R");
		test.setGreen("0,128,255");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#setBlue(java.lang.String)}.
	 */
	public void testSetBlue() {
		Aspect test = Aspect.getAspect("R");
		test.setBlue("0,128,255");
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getRed(int)}.
	 */
	public void testGetRed() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertEquals(test.getRed(0), 0);
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getGreen(int)}.
	 */
	public void testGetGreen() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertEquals(test.getGreen(0), 240);
	}

	/**
	 * Test method for {@link org.eclipse.stem.ui.ge.Aspect#getBlue(int)}.
	 */
	public void testGetBlue() {
		Aspect test = Aspect.getAspect("R");
		Assert.assertEquals(test.getBlue(1), 0);
	}

}

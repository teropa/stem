package org.eclipse.stem.internal.data.generatedplugin.tests;

/******************************************************************************* 
 * Copyright (c) 2009 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Dublin Core</b></em>'. <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class DublinCoreTest extends TestCase {

	/**
	 * The fixture for this Dublin Core test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected DublinCore fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DublinCoreTest.class);
	}

	/**
	 * Constructs a new Dublin Core test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DublinCoreTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Dublin Core test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DublinCore fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Dublin Core test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DublinCore getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GeneratedpluginFactory.eINSTANCE.createDublinCore());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Keeps JUnit quiet about the lack of tests in this class.
	 */
	public void testFoo() {
		assertTrue(true);
	}

} // DublinCoreTest

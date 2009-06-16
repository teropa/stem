package org.eclipse.stem.definitions.labels.tests;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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

import org.eclipse.stem.definitions.labels.AreaLabelValue;
import org.eclipse.stem.definitions.labels.LabelsFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Area Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class AreaLabelValueTest extends TestCase {

	/**
	 * The test area value (km^2)
	 */
	public static final double TEST_AREA_VALUE = 1;

	/**
	 * The fixture for this Area Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AreaLabelValueTest.class);
	}

	/**
	 * Constructs a new Area Label Value test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Area Label Value test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AreaLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Area Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AreaLabelValue getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}

	/**
	 * @return create an initialized AreaLabelValue
	 * @see #TEST_AREA_VALUE
	 */
	public static AreaLabelValue createFixture() {
		final AreaLabelValue retValue = LabelsFactory.eINSTANCE
				.createAreaLabelValue();

		retValue.setArea(TEST_AREA_VALUE);

		return retValue;
	} // createFixture

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
	 * Test that the fixture is sane
	 */
	public void testFixtureSanity() {
		final AreaLabelValue areaLabelValue = getFixture();
		assertTrue(areaLabelValue.sane());
		assertTrue(areaLabelValue.getArea() == TEST_AREA_VALUE);
	} // testFixtureSanity
} // AreaLabelValueTest

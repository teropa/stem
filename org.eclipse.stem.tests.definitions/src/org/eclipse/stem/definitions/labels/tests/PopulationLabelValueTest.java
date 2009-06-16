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

import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelValueImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Population Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class PopulationLabelValueTest extends TestCase {
	/**
	 * The fixture for this Population Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PopulationLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PopulationLabelValueTest.class);
	}

	/**
	 * Constructs a new Population Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Population Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(PopulationLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Population Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PopulationLabelValue getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LabelsFactory.eINSTANCE.createPopulationLabelValue());
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
	 * Make sure the fixture makes sense.
	 */
	public void testFixture() {
		final PopulationLabelValue populationLabelValue = getFixture();
		assertNotNull(populationLabelValue);
		assertTrue(((PopulationLabelValueImpl) populationLabelValue).sane());
		
	} // testFixture
} // PopulationLabelValueTest

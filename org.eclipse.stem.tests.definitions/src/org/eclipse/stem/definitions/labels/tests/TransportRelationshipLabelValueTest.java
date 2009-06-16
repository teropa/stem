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
import org.eclipse.stem.definitions.labels.TransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Transport Relationship Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class TransportRelationshipLabelValueTest extends TestCase {
	/**
	 * The fixture for this Transport Relationship Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TransportRelationshipLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TransportRelationshipLabelValueTest.class);
	}

	/**
	 * Constructs a new Transport Relationship Label Value test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRelationshipLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Transport Relationship Label Value test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TransportRelationshipLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Transport Relationship Label Value test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TransportRelationshipLabelValue getFixture() {
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
	} // setUp

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	public static TransportRelationshipLabelValue createFixture() {
		final TransportRelationshipLabelValue retValue = LabelsFactory.eINSTANCE
				.createTransportRelationshipLabelValue();
		return retValue;
	} // createFixture

	/**
	 * Test that the fixture is sane.
	 */
	public void testFixtureSanity() {
		final TransportRelationshipLabelValue fixture = getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity
} // TransportRelationshipLabelValueTest

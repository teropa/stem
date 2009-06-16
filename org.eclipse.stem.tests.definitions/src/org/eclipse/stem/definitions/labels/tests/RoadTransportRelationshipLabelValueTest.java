package org.eclipse.stem.definitions.labels.tests;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.RoadTransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Road Transport Relationship Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class RoadTransportRelationshipLabelValueTest extends PhysicalRelationshipLabelValueTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RoadTransportRelationshipLabelValueTest.class);
	}

	/**
	 * Constructs a new Road Transport Relationship Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadTransportRelationshipLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Road Transport Relationship Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RoadTransportRelationshipLabelValue getFixture() {
		return (RoadTransportRelationshipLabelValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LabelsFactory.eINSTANCE.createRoadTransportRelationshipLabelValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Test the sanity of the fixture.
	 */
	@Override
	public void testFixtureSanity() {
		assertTrue(getFixture().sane());
	}
	
} //RoadTransportRelationshipLabelValueTest

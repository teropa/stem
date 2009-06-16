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


import junit.textui.TestRunner;

import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Relative Physical Relationship Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel#getCurrentRelationship() <em>Current Relationship</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class RelativePhysicalRelationshipLabelTest extends
		PhysicalRelationshipLabelTest {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RelativePhysicalRelationshipLabelTest.class);
	}

	/**
	 * Constructs a new Relative Physical Relationship Label test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RelativePhysicalRelationshipLabelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Relative Physical Relationship Label test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RelativePhysicalRelationshipLabel getFixture() {
		return (RelativePhysicalRelationshipLabel)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LabelsFactory.eINSTANCE.createRelativePhysicalRelationshipLabel());
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
	 * Tests the '{@link org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel#getCurrentRelationship() <em>Current Relationship</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel#getCurrentRelationship()
	 * @generated NOT
	 */
	public void testGetCurrentRelationship() {
		final RelativePhysicalRelationshipLabel fixture = getFixture();
		assertTrue(fixture.getCurrentRelationship() == fixture
				.getCurrentValue());
	} // testGetCurrentRelationship

	/**
	 * Test that the fixture is sane.
	 */
	public void testFixtureSanity() {
		final RelativePhysicalRelationshipLabel fixture = getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity

} // RelativePhysicalRelationshipLabelTest

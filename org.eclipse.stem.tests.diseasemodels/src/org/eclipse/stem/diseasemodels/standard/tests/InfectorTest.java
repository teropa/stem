package org.eclipse.stem.diseasemodels.standard.tests;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.framework.TestCase;

import org.eclipse.stem.diseasemodels.standard.Infector;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Infector</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class InfectorTest extends TestCase {
	/**
	 * The fixture for this Infector test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Infector fixture = null;

	/**
	 * Constructs a new Infector test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfectorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Infector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Infector fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Infector test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Infector getFixture() {
		return fixture;
	}

	/**
	 * test the sanity of the fixture
	 */
	public void testFixtureSanity() {
		final Infector fixture = getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity
} // InfectorTest

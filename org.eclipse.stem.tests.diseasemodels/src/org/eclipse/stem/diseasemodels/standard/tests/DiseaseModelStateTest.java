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

import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelStateImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Disease Model State</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class DiseaseModelStateTest extends TestCase {
	/**
	 * The fixture for this Disease Model State test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiseaseModelState fixture = null;

	/**
	 * Constructs a new Disease Model State test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiseaseModelStateTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Disease Model State test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(DiseaseModelState fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Disease Model State test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiseaseModelState getFixture() {
		return fixture;
	}

	/**
	 * test the sanity of the fixture
	 */
	public void testFixtureSanity() {
		final DiseaseModelStateImpl fixture = (DiseaseModelStateImpl) getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity
} // DiseaseModelStateTest

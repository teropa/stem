package org.eclipse.stem.diseasemodels.multipopulation.tests;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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

import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multi Population SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiPopulationSIDiseaseModelTest extends TestCase {

	/**
	 * The fixture for this Multi Population SI Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiPopulationSIDiseaseModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MultiPopulationSIDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Multi Population SI Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPopulationSIDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Multi Population SI Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MultiPopulationSIDiseaseModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Multi Population SI Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiPopulationSIDiseaseModel getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MultipopulationFactory.eINSTANCE.createMultiPopulationSIDiseaseModel());
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

} //MultiPopulationSIDiseaseModelTest

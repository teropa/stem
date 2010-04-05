package org.eclipse.stem.diseasemodels.forcing.tests;

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

import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.forcing.ForcingFactory;
import org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gaussian3 Forcing Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Gaussian3ForcingDiseaseModelTest extends Gaussian2ForcingDiseaseModelTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Gaussian3ForcingDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Gaussian3 Forcing Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gaussian3ForcingDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Gaussian3 Forcing Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Gaussian3ForcingDiseaseModel getFixture() {
		return (Gaussian3ForcingDiseaseModel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ForcingFactory.eINSTANCE.createGaussian3ForcingDiseaseModel());
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

} //Gaussian3ForcingDiseaseModelTest

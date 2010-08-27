package org.eclipse.stem.diseasemodels.standard.tests;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIRDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Stochastic Poisson SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StochasticPoissonSIRDiseaseModelTest extends SIRTest {

	public static final URI DISEASEMODEL_URI = STEMURI.createURI("diseaseModels/testStochasticPoissonDiseaseModel.decorator");
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StochasticPoissonSIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Stochastic Poisson SIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticPoissonSIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stochastic Poisson SIR Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StochasticPoissonSIRDiseaseModel getFixture() {
		return (StochasticPoissonSIRDiseaseModel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		DiseaseModel d= StandardFactory.eINSTANCE.createStochasticPoissonSIRDiseaseModel();
		d.setURI(DISEASEMODEL_URI);
		d.setDiseaseName("test");
		setFixture(d);
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

} //StochasticPoissonSIRDiseaseModelTest

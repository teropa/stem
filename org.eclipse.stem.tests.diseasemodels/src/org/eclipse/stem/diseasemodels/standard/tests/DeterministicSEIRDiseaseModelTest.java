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

import junit.textui.TestRunner;

import org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel;
//import org.eclipse.stem.diseasemodels.standard.StandardFactory;

import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.impl.DeterministicSEIRDiseaseModelImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Deterministic SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class DeterministicSEIRDiseaseModelTest extends SEIRTest {
	private static final String TEST_DETERMINISTIC_SEIR_DISEASE_NAME = "Deterministic SEIR Disease Model";

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeterministicSEIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Deterministic SEIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeterministicSEIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Deterministic SEIR Disease Model test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DeterministicSEIRDiseaseModel getFixture() {
		return (DeterministicSEIRDiseaseModel)fixture;
	}

	/**
	 * @return the label value fixture
	 */
	SEIRLabel getLabelFixture() {
		return (SEIRLabel) labelFixture;
	} // getLabelValueFixture

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
		StandardDiseaseModelLabel dml = createLabelFixture();
		DiseaseModelState dms = getFixture().createDiseaseModelState();
		dml.setDiseaseModelState(dms);
		setLabelFixture(dml);
		fixture.initializeDiseaseState(dms, dml);
	} // setUp

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	} // tearDown

	/**
	 * Create disease model instance
	 * 
	 * @return a disease model instance for test purposes
	 */
	public static DeterministicSEIRDiseaseModel createFixture() {
		return DeterministicSEIRDiseaseModelImpl
				.createDeterministicSEIRDiseaseModel(
						TEST_DETERMINISTIC_SEIR_DISEASE_NAME, MORTALITY_RATE,
						INFECTIOUS_MORTALITY_RATE,
						TRANSMISSION_RATE, RECOVERY_RATE, IMMUNITY_LOSS_RATE,
						INCUBATION_RATE, NON_LINEARITY_COEFFICIENT,
						TEST_TIME_PERIOD, TEST_POPULATION_IDENTIFIER);
	} // createFixture

} // DeterministicSEIRDiseaseModelTest

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIRDiseaseModelImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Deterministic SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class DeterministicSIRDiseaseModelTest extends SIRTest {
	private static final String TEST_DETERMINISTIC_SIR_DISEASE_NAME = "Deterministic SIR Disease Model";

	private static final String DISEASE_IDENTIFIER = "DeterministicSIRDiseaseModel";
	public static final URI DISEASE_URI = STEMURI.createURI("diseasemodel" + "/" + DISEASE_IDENTIFIER);
	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeterministicSIRDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Deterministic SIR Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeterministicSIRDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Deterministic SIR Disease Model test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DeterministicSIRDiseaseModel getFixture() {
		return (DeterministicSIRDiseaseModel)fixture;
	}

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
	public static DeterministicSIRDiseaseModel createFixture() {
		DeterministicSIRDiseaseModel diseaseModel = DeterministicSIRDiseaseModelImpl
				.createDeterministicSIRDiseaseModel(
						TEST_DETERMINISTIC_SIR_DISEASE_NAME, MORTALITY_RATE,
						INFECTIOUS_MORTALITY_RATE,
						TRANSMISSION_RATE, RECOVERY_RATE, IMMUNITY_LOSS_RATE,
						NON_LINEARITY_COEFFICIENT, TEST_TIME_PERIOD,
						TEST_POPULATION_IDENTIFIER);
		final DublinCore dc = diseaseModel.getDublinCore();
		diseaseModel.setURI(DISEASE_URI);
		dc.setIdentifier(diseaseModel.getURI().toString());
		return diseaseModel;
	} // createFixture

} // DeterministicSIRDiseaseModelTest

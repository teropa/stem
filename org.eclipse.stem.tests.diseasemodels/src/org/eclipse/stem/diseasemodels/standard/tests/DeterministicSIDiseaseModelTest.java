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
import org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.impl.DeterministicSIDiseaseModelImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Deterministic SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class DeterministicSIDiseaseModelTest extends SITest {
	private static final String TEST_DETERMINISTIC_SI_DISEASE_NAME = "Deterministic SI Disease Model";
	private static final String DISEASE_IDENTIFIER = "DeterministicSIDiseaseModel";
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
		TestRunner.run(DeterministicSIDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Deterministic SI Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeterministicSIDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Deterministic SI Disease Model test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DeterministicSIDiseaseModel getFixture() {
		return (DeterministicSIDiseaseModel)fixture;
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
	public static DeterministicSIDiseaseModel createFixture() {
		DeterministicSIDiseaseModel diseaseModel = DeterministicSIDiseaseModelImpl
				.createDeterministicSIDiseaseModel(
						TEST_DETERMINISTIC_SI_DISEASE_NAME, MORTALITY_RATE,
						INFECTIOUS_MORTALITY_RATE,
						TRANSMISSION_RATE, RECOVERY_RATE,
						NON_LINEARITY_COEFFICIENT, TEST_TIME_PERIOD,
						TEST_POPULATION_IDENTIFIER);
		final DublinCore dc = diseaseModel.getDublinCore();
		diseaseModel.setURI(DISEASE_URI);
		dc.setIdentifier(diseaseModel.getURI().toString());
		return diseaseModel;
	} // createFixture
	
} // DeterministicSIDiseaseModelTest

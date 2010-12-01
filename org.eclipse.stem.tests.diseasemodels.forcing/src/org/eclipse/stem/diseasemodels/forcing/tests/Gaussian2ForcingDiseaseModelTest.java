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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.diseasemodels.forcing.ForcingFactory;
import org.eclipse.stem.diseasemodels.forcing.Gaussian2ForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gaussian2 Forcing Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Gaussian2ForcingDiseaseModelTest extends TestCase {
	
	public static final String DISEASE_IDENTIFIER="Gaussian2Forcing3DiseaseModel";
	public static final URI DISEASE_URI = STEMURI.createURI("diseasemodel" + "/" + DISEASE_IDENTIFIER);

	/**
	 * The fixture for this Gaussian2 Forcing Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Gaussian2ForcingDiseaseModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Gaussian2ForcingDiseaseModelTest.class);
	}

	/**
	 * Constructs a new Gaussian2 Forcing Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gaussian2ForcingDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Gaussian2 Forcing Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Gaussian2ForcingDiseaseModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Gaussian2 Forcing Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Gaussian2ForcingDiseaseModel getFixture() {
		return fixture;
	}
	
	/**
	 * Create disease model instance
	 * 
	 * @return a disease model instance for test purposes
	 */
	public static Gaussian2ForcingDiseaseModel createFixture() {
		Gaussian2ForcingDiseaseModel diseaseModel = ForcingFactory.eINSTANCE.createGaussian2ForcingDiseaseModel();
		diseaseModel.setDiseaseName(DISEASE_IDENTIFIER);
		diseaseModel.setInfectiousMortalityRate(GaussianDiseaseModelTestUtil.MORTALITY_RATE);
		diseaseModel.setModulationFloor(GaussianDiseaseModelTestUtil.MODULATION_FLOUR);
		diseaseModel.setImmunityLossRate(GaussianDiseaseModelTestUtil.IMMUNITY_LOSS_RATE);
		diseaseModel.setTransmissionRate(GaussianDiseaseModelTestUtil.TRANSMISSION_RATE);
		diseaseModel.setRecoveryRate(GaussianDiseaseModelTestUtil.RECOVERY_RATE);
		diseaseModel.setTimePeriod(GaussianDiseaseModelTestUtil.TIME_PERIOD);
		diseaseModel.setPopulationIdentifier(GaussianDiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER);

		
		final DublinCore dc = diseaseModel.getDublinCore();
		diseaseModel.setURI(DISEASE_URI);
		dc.setIdentifier(diseaseModel.getURI().toString());
		return diseaseModel;
	} // createFixture

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
		StandardDiseaseModelLabel dml = GaussianDiseaseModelTestUtil.createLabel();
		DiseaseModelState dms = getFixture().createDiseaseModelState();
		dml.setDiseaseModelState(dms);
		fixture.initializeDiseaseState(dms, dml);
		assertTrue(getFixture().sane());
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
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#createDiseaseModelLabel() <em>Create Disease Model Label</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#createDiseaseModelLabel()
	 * @generated NOT
	 */
	public void testCreateDiseaseModelLabel() {
		final DiseaseModel diseaseModel = getFixture();
		if (!(diseaseModel instanceof AggregatingSIDiseaseModel)) {
		final DiseaseModelLabel dml = diseaseModel.createDiseaseModelLabel();
		
		assertTrue(dml.eClass().equals(StandardPackage.eINSTANCE.getSIRLabel()));
		}
	} // testCreateDiseaseModelLabel

	

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#createDiseaseModelState() <em>Create Disease Model State</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#createDiseaseModelState()
	 * @generated NOT
	 */
	public void testCreateDiseaseModelState() {
		final DiseaseModel diseaseModel = getFixture();
		if (!(diseaseModel instanceof AggregatingSIDiseaseModel)) {

			final DiseaseModelState dms = diseaseModel
					.createDiseaseModelState();
			assertTrue(dms.eClass().equals(StandardPackage.eINSTANCE.getSIDiseaseModelState()));
		}
	} // testCreateDiseaseModelState

	

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#createInfector() <em>Create Infector</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#createInfector()
	 * @generated NOT
	 */
	public void testCreateInfector() {
		final DiseaseModel diseaseModel = getFixture();
		if (!(diseaseModel instanceof AggregatingSIDiseaseModel)) {
			final Infector infector = diseaseModel.createInfector();
			assertNotNull(infector);
			assertTrue(infector.getDiseaseName().equals(
					fixture.getDiseaseName()));
			assertTrue(infector.getPopulationIdentifier().equalsIgnoreCase(
					fixture.getPopulationIdentifier()));
		}

	} // testCreateInfector

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel#getAdjustedBackgroundBirthRate(long) <em>Get Adjusted Background Birth Rate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel#getAdjustedBackgroundBirthRate(long)
	 * @generated NOT
	 */
	public void testGetAdjustedBackgroundBirthRate__long() {
		DiseaseModel dModel = getFixture();
		double oneDayRate     = dModel.getAdjustedBackgroundBirthRate(GaussianDiseaseModelTestUtil.TIME_ONE_DAY);
		double twoDayRate = dModel.getAdjustedBackgroundBirthRate(GaussianDiseaseModelTestUtil.TIME_TWO_DAY);
		long delta = Math.round(twoDayRate/oneDayRate);
		long expected = GaussianDiseaseModelTestUtil.TIME_TWO_DAY/GaussianDiseaseModelTestUtil.TIME_ONE_DAY;
		
		assertTrue(delta==expected);
	}


} //Gaussian2ForcingDiseaseModelTest

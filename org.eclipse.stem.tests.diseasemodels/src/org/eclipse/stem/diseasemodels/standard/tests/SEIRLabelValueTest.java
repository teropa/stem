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

import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
//import org.eclipse.stem.diseasemodels.standard.StandardFactory;

import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SEIR Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class SEIRLabelValueTest extends SIRLabelValueTest {
	/**
	 * Test value for exposed
	 */
	public static final double TEST_E = 4;

	/**
	 * Test value for exposed
	 */
	public static final double TEMP_TEST_E = TEST_E + 40;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SEIRLabelValueTest.class);
	}

	/**
	 * Constructs a new SEIR Label Value test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SEIR Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected SEIRLabelValue getFixture() {
		return (SEIRLabelValue)fixture;
	}

	@SuppressWarnings("unused")
	private SEIRLabelValue getTempFixture() {
		return (SEIRLabelValue) tempFixture;
	} // getTempFixture

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
		setTempFixture(createTempFixture());
	} // setup

	/**
	 * @return a value for testing
	 */
	public static SEIRLabelValue createFixture() {
		final SEIRLabelValueImpl retValue = new SEIRLabelValueImpl(TEST_S,
				TEST_E, TEST_I, TEST_R,
				TEST_DISEASE_DEATHS);
		return retValue;
	} // createSEIRLabelValue

	@Override
	protected DiseaseModelLabelValue createTempFixture() {
		final SEIRLabelValueImpl retValue = new SEIRLabelValueImpl(TEMP_TEST_S,
				TEMP_TEST_E, TEMP_TEST_I, TEMP_TEST_R,
				 TEMP_TEST_DISEASE_DEATHS);
		return retValue;
	} // createTempFixture

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
		setTempFixture(null);
	} // tearDown

	@Override
	protected StandardDiseaseModelLabelValue getExpectedConvertToSourceStates(
			StandardDiseaseModelLabelValue fixture) {
		final SEIRLabelValue seirLabel = (SEIRLabelValue) fixture;
		return new SEIRLabelValueImpl(seirLabel.getE(), seirLabel.getI(),
				 seirLabel.getR(), 0,seirLabel.getS(), fixture
						.getDiseaseDeaths());
	} // getExpectedConvertToSourceStates

	@Override
	protected DiseaseModelLabelValue getExpectedFixtureAdditionResult(
			DiseaseModelLabelValue fixture1, DiseaseModelLabelValue fixture2) {
		final SEIRLabelValue seirLabel1 = (SEIRLabelValue) fixture1;
		final SEIRLabelValue seirLabel2 = (SEIRLabelValue) fixture2;
		return new SEIRLabelValueImpl(seirLabel1.getS() + seirLabel2.getS(),
				seirLabel1.getE() + seirLabel2.getE(), seirLabel1.getI()
						+ seirLabel2.getI(), seirLabel1.getR()
						+ seirLabel2.getR(), seirLabel1.getDiseaseDeaths()
						+ seirLabel2.getDiseaseDeaths());
	} // getExpectedFixtureAdditionResult

	@Override
	protected DiseaseModelLabelValue getExpectedFixtureSubtractionResult(
			DiseaseModelLabelValue fixture1, DiseaseModelLabelValue fixture2) {
		final SEIRLabelValue seirLabel1 = (SEIRLabelValue) fixture1;
		final SEIRLabelValue seirLabel2 = (SEIRLabelValue) fixture2;
		return new SEIRLabelValueImpl(seirLabel1.getS() - seirLabel2.getS(),
				seirLabel1.getE() - seirLabel2.getE(), seirLabel1.getI()
						- seirLabel2.getI(), seirLabel1.getR()
						- seirLabel2.getR(), seirLabel1.getDiseaseDeaths()
						- seirLabel2.getDiseaseDeaths());
	} // getExpectedFixtureSubtractionResult

	@Override
	protected double getExpectedPopulationCount(DiseaseModelLabelValue fixture) {
		final SEIRLabelValue seirLabel = (SEIRLabelValue) fixture;
		return seirLabel.getS() + seirLabel.getE() + seirLabel.getI()
				+ seirLabel.getR();
	} // getExpectedPopulationCount

} // SEIRLabelValueTest

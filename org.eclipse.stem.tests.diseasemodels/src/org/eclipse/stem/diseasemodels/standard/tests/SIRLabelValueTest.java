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
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
//import org.eclipse.stem.diseasemodels.standard.StandardFactory;

import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SIR Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class SIRLabelValueTest extends SILabelValueTest {
	/**
	 * Test value for recovered
	 */
	public static final double TEST_R = 3;

	/**
	 * Test value for recovered
	 */
	public static final double TEMP_TEST_R = TEST_R + 30;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SIRLabelValueTest.class);
	}

	/**
	 * Constructs a new SIR Label Value test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SIR Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected SIRLabelValue getFixture() {
		return (SIRLabelValue)fixture;
	}

	@SuppressWarnings("unused")
	private SIRLabelValue getTempFixture() {
		return (SIRLabelValue) tempFixture;
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
	} // setUp

	/**
	 * @return a value for testing
	 */
	public static SIRLabelValue createFixture() {
		final SIRLabelValueImpl retValue = new SIRLabelValueImpl(TEST_S,
				TEST_I, TEST_R, TEST_BIRTHS, TEST_DEATHS,
				TEST_DISEASE_DEATHS);
		return retValue;
	} // createFixture

	@Override
	protected DiseaseModelLabelValue createTempFixture() {
		final SIRLabelValueImpl retValue = new SIRLabelValueImpl(TEMP_TEST_S,
				TEMP_TEST_I, TEMP_TEST_R, TEMP_TEST_BIRTHS,
				TEMP_TEST_DEATHS, TEMP_TEST_DISEASE_DEATHS);
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
		final SIRLabelValue siLabel = (SIRLabelValue) fixture;
		return new SIRLabelValueImpl(siLabel.getI(), siLabel.getR(), 0.0,
				siLabel.getS(), fixture.getBirths(), fixture.getDeaths(),
				fixture.getDiseaseDeaths());
	} // getExpectedConvertToSourceStates

	@Override
	protected DiseaseModelLabelValue getExpectedFixtureAdditionResult(
			DiseaseModelLabelValue fixture1, DiseaseModelLabelValue fixture2) {
		final SIRLabelValue sirLabel1 = (SIRLabelValue) fixture1;
		final SIRLabelValue sirLabel2 = (SIRLabelValue) fixture2;
		return new SIRLabelValueImpl(sirLabel1.getS() + sirLabel2.getS(),
				sirLabel1.getI() + sirLabel2.getI(), sirLabel1.getR()
						+ sirLabel2.getR(), sirLabel1.getBirths()
						+ sirLabel2.getBirths(), sirLabel1.getDeaths()
						+ sirLabel2.getDeaths(), sirLabel1.getDiseaseDeaths()
						+ sirLabel2.getDiseaseDeaths());
	} // DiseaseModelLabelValue

	@Override
	protected DiseaseModelLabelValue getExpectedFixtureSubtractionResult(
			DiseaseModelLabelValue fixture1, DiseaseModelLabelValue fixture2) {
		final SIRLabelValue sirLabel1 = (SIRLabelValue) fixture1;
		final SIRLabelValue sirLabel2 = (SIRLabelValue) fixture2;
		return new SIRLabelValueImpl(sirLabel1.getS() - sirLabel2.getS(),
				sirLabel1.getI() - sirLabel2.getI(), sirLabel1.getR()
						- sirLabel2.getR(), sirLabel1.getBirths()
						- sirLabel2.getBirths(), sirLabel1.getDeaths()
						- sirLabel2.getDeaths(), sirLabel1.getDiseaseDeaths()
						- sirLabel2.getDiseaseDeaths());
	} // getExpectedFixtureSubtractionResult

	@Override
	protected double getExpectedPopulationCount(DiseaseModelLabelValue fixture) {
		final SIRLabelValue sirValue = (SIRLabelValue) fixture;
		return sirValue.getS() + sirValue.getI() + sirValue.getR();
	} // getExpectedPopulationCount

} // SIRLabelValueTest

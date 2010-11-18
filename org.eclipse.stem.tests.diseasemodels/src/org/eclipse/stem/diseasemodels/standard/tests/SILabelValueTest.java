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
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SI Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class SILabelValueTest extends StandardDiseaseModelLabelValueTest {
	/**
	 * Test value for infectious
	 */
	public static final double TEST_I = 2;

	/**
	 * Test value for infectious
	 */
	public static final double TEMP_TEST_I = TEST_I + 20;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SILabelValueTest.class);
	}

	/**
	 * Constructs a new SI Label Value test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SI Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected SILabelValue getFixture() {
		return (SILabelValue)fixture;
	}

	@SuppressWarnings("unused")
	private SILabelValue getTempFixture() {
		return (SILabelValue) tempFixture;
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
	public static SILabelValue createFixture() {
		final SILabelValueImpl retValue = new SILabelValueImpl(TEST_S, TEST_I,
				TEST_DISEASE_DEATHS);
		return retValue;
	} // createFixture

	@Override
	protected DiseaseModelLabelValue createTempFixture() {
		final SILabelValueImpl retValue = new SILabelValueImpl(TEMP_TEST_S,
				TEMP_TEST_I,
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

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SILabelValue#getI() <em>I</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SILabelValue#getI()
	 * @generated NOT
	 */
	public void testGetI() {
		final SILabelValue siLabelValue = getFixture();
		assertTrue(siLabelValue.getI() == TEST_I);
	} // testGetI

	@Override
	protected StandardDiseaseModelLabelValue getExpectedConvertToSourceStates(
			StandardDiseaseModelLabelValue fixture) {
		final SILabelValue siLabel = (SILabelValue) fixture;
		return new SILabelValueImpl(siLabel.getI(), siLabel.getS(), 0.0,
				 fixture
						.getDiseaseDeaths());
	} // getExpectedConvertToSourceStates

	@Override
	protected DiseaseModelLabelValue getExpectedFixtureAdditionResult(
			DiseaseModelLabelValue fixture1, DiseaseModelLabelValue fixture2) {
		final SILabelValue siLabel1 = (SILabelValue) fixture1;
		final SILabelValue siLabel2 = (SILabelValue) fixture2;
		return new SILabelValueImpl(siLabel1.getS() + siLabel2.getS(), siLabel1
				.getI()
				+ siLabel2.getI(),
				 fixture1.getDiseaseDeaths()
						+ fixture2.getDiseaseDeaths());
	} // getExpectedFixtureAdditionResult

	@Override
	protected DiseaseModelLabelValue getExpectedFixtureSubtractionResult(
			DiseaseModelLabelValue fixture1, DiseaseModelLabelValue fixture2) {
		final SILabelValue siLabel1 = (SILabelValue) fixture1;
		final SILabelValue siLabel2 = (SILabelValue) fixture2;
		return new SILabelValueImpl(siLabel1.getS() - siLabel2.getS(), siLabel1
				.getI()
				- siLabel2.getI(), 
				 fixture1.getDiseaseDeaths()
						- fixture2.getDiseaseDeaths());
	} // getExpectedFixtureSubtractionResult

	@Override
	protected double getExpectedPopulationCount(DiseaseModelLabelValue fixture) {
		final SILabelValue siLabel = (SILabelValue) fixture;
		return siLabel.getS() + siLabel.getI();
	} // getExpectedPopulationCount

} // SILabelValueTest

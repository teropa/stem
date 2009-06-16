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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.diseasemodels.standard.SEIR;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SEIR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SEIR#getAdjustedIncubationRate(long) <em>Get Adjusted Incubation Rate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class SEIRTest extends SIRTest {

	/**
	 * This coefficient determines the number of population members in the
	 * <em>Exposed</em> state that become infected per population member in
	 * the <em>Exposed</em> state, per time period. Units: population members
	 * 
	 * @see SEIR#getIncubationRate()
	 */
	final public static double INCUBATION_RATE = 0.1;

	/**
	 * Constructs a new SEIR test case with the given name.
	 * <!-- begin-user-doc
	 * -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRTest(String name) {
		super(name);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SEIR#getAdjustedIncubationRate(long) <em>Get Adjusted Incubation Rate</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SEIR#getAdjustedIncubationRate(long)
	 * @generated NOT
	 */
	public void testGetAdjustedIncubationRate__long() {
		final SEIR fixture = getFixture();
		assertTrue(DiseaseModelTestUtil.closeEnough(fixture
				.getAdjustedIncubationRate(2 * fixture.getTimePeriod()),
				(2 * fixture.getIncubationRate())));
	} // testGetAdjustedIncubationRate__long

	/**
	 * Returns the fixture for this SEIR test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected SEIR getFixture() {
		return (SEIR)fixture;
	}

	/**
	 * @return a disease model label value to be used for testing
	 */
	@SuppressWarnings("unused")
	private SEIRLabel getLabelFixture() {
		return (SEIRLabel) labelFixture;
	} // getLabelFixture

	@Override
	protected EClass getDiseaseModelLabelClass() {
		return StandardPackage.eINSTANCE.getSEIRLabel();
	} // getDiseaseModelLabelClass

	/**
	 * @return a label value for testing
	 */
	public StandardDiseaseModelLabel createLabelFixture() {
		return SEIRLabelTest.createFixture();
	} // createLabelValueFixture

} // SEIRTest

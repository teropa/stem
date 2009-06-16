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
import org.eclipse.stem.diseasemodels.standard.SIR;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SIR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SIR#getAdjustedImmunityLossRate(long) <em>Get Adjusted Immunity Loss Rate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class SIRTest extends SITest {

	/**
	 * This coefficient determines the number of population members that lose
	 * their immunity to a disease and become Susceptible to the disease per
	 * population member in the <em>Recovered</em> state. A value of zero
	 * (0.0), the default, means the population members never lose their
	 * immunity. Units: population members
	 * 
	 * @see SIR#getImmunityLossRate()
	 */
	final public static double IMMUNITY_LOSS_RATE = 0.1;

	/**
	 * Constructs a new SIR test case with the given name.
	 * <!-- begin-user-doc
	 * -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SIR test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected SIR getFixture() {
		return (SIR)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SIR#getAdjustedImmunityLossRate <em>Get Adjusted Immunity Loss Rate</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SIR#getAdjustedImmunityLossRate
	 * @generated NOT
	 */
	public void testGetAdjustedImmunityLossRate__long() {
		final SIR fixture = getFixture();
		assertTrue(DiseaseModelTestUtil.closeEnough(fixture
				.getAdjustedImmunityLossRate(2 * fixture.getTimePeriod()),
				(2 * fixture.getImmunityLossRate())));
	} // testGetAdjustedImmunityLossRate__long

	@Override
	protected StandardDiseaseModelLabel createLabelFixture() {
		return SIRLabelTest.createFixture();
	} // createLabelValueFixture

	@Override
	protected EClass getDiseaseModelLabelClass() {
		return StandardPackage.eINSTANCE.getSIRLabel();
	} // getDiseaseModelLabelClass

} // SIRTest

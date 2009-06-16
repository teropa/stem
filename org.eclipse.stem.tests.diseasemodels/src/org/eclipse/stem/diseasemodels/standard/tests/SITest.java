package org.eclipse.stem.diseasemodels.standard.tests;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SI#getAdjustedInfectiousMortalityRate(long) <em>Get Adjusted Infectious Mortality Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SI#getAdjustedTransmissionRate(long) <em>Get Adjusted Transmission Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SI#getAdjustedRecoveryRate(long) <em>Get Adjusted Recovery Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SI#getEffectiveInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel, double) <em>Get Effective Infectious</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.SI#getNormalizedEffectiveInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel, double) <em>Get Normalized Effective Infectious</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class SITest extends StandardDiseaseModelTest {

	/**
	 * This coefficient determines the increased rate at which infectious population
	 * members die per time period due to the disease. This is
	 * <em>&mu;<sub>i</sub>.
	 */
	final public static double INFECTIOUS_MORTALITY_RATE = 0.1;

	/**
	 * This coefficient determines the number of population members that become
	 * infected/exposed per population member in the <em>Infectious</em>
	 * state, assuming the entire population is in the <em>Susceptible</em>
	 * state, per time period. This is <em>&beta;</em>
	 * 
	 * @see SI#getTransmissionRate()
	 */
	final public static double TRANSMISSION_RATE = 0.1;

	/**
	 * By default this exponent is one (1.0) and the rate of infection scales as
	 * the product of the Susceptible population and the Infectious population.
	 * In a nonlinear model (which captures saturation of the immune system for
	 * Susceptible population), the Infectious term is raise to this power (>=
	 * 0.0) This exponent should never be less than zero. The default value of 1.0 basically removes it from
	 * the computation.
	 * 
	 * @see SI#getNonLinearityCoefficient()
	 */
	final public static double NON_LINEARITY_COEFFICIENT = 1.0;

	/**
	 * This coefficient determines the number of population members that recover
	 * from the disease per population member in the <em>Infectious</em>
	 * state. This is <em>&sigma;</em>.
	 * 
	 * @see SI#getRecoveryRate()
	 */
	final public static double RECOVERY_RATE = 0.01;

	/**
	 * Constructs a new SI test case with the given name.
	 * <!-- begin-user-doc
	 * -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SITest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SI test case.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected SI getFixture() {
		return (SI)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getAdjustedInfectiousMortalityRate(long) <em>Get Adjusted Infectious Mortality Rate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getAdjustedInfectiousMortalityRate(long)
	 * @generated NOT
	 */
	public void testGetAdjustedInfectiousMortalityRate__long() {
		final SI fixture = getFixture();
		assertTrue(DiseaseModelTestUtil.closeEnough(fixture
				.getAdjustedInfectiousMortalityRate(2 * fixture.getTimePeriod()),
				(2 * fixture.getInfectiousMortalityRate())));
	} // testGetAdjustedInfectiousMortalityRate__long

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getAdjustedTransmissionRate <em>Get Adjusted Transmission Rate</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getAdjustedTransmissionRate
	 * @generated NOT
	 */
	public void testGetAdjustedTransmissionRate__long() {
		final SI fixture = getFixture();
		assertTrue(DiseaseModelTestUtil.closeEnough(fixture
				.getAdjustedTransmissionRate(2 * fixture.getTimePeriod()),
				(2 * fixture.getTransmissionRate())));
	} // testGetAdjustedTransmissionRate__long

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getAdjustedRecoveryRate <em>Get Adjusted Recovery Rate</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getAdjustedRecoveryRate
	 * @generated NOT
	 */
	public void testGetAdjustedRecoveryRate__long() {
		final SI fixture = getFixture();
		assertTrue(DiseaseModelTestUtil.closeEnough(fixture
				.getAdjustedRecoveryRate(2 * fixture.getTimePeriod()),
				(2 * fixture.getRecoveryRate())));
	} // testGetAdjustedRecoveryRate__long

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getEffectiveInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel, double) <em>Get Effective Infectious</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getEffectiveInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel, double)
	 * @generated NOT
	 */
	public void testGetEffectiveInfectious__Node_StandardDiseaseModelLabel_double() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getNormalizedEffectiveInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel, double) <em>Get Normalized Effective Infectious</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getNormalizedEffectiveInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel, double)
	 * @generated NOT
	 */
	public void testGetNormalizedEffectiveInfectious__Node_StandardDiseaseModelLabel_double() {
		// TODO: implement testGetNormalizedEffectiveInfectious__Node_StandardDiseaseModelLabel_double
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel) <em>Get Physically Adjacent Infectious</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectious(org.eclipse.stem.core.graph.Node, org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel)
	 * @generated NOT
	 */
	public void testGetPhysicallyAdjacentInfectious__Node_StandardDiseaseModelLabel() {
		assertTrue(true);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectious(org.eclipse.stem.core.graph.Node) <em>Get Physically Adjacent Infectious</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectious(org.eclipse.stem.core.graph.Node)
	 * @generated NOT
	 */
	public void testGetPhysicallyAdjacentInfectious__Node() {
		assertTrue(true);
	}

	@Override
	protected StandardDiseaseModelLabel createLabelFixture() {
		return SILabelTest.createFixture();
	} // createLabelValueFixture

	@Override
	protected EClass getDiseaseModelLabelClass() {
		return StandardPackage.eINSTANCE.getSILabel();
	} // getDiseaseModelLabelClass

	@Override
	protected EClass getDiseaseModelStateClass() {
		return StandardPackage.eINSTANCE.getSIDiseaseModelState();
	} // getDiseaseModelStateClass

} // SITest

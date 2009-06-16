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

import java.util.Random;

import org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.impl.StandardStochasticDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Stochastic Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#computeNoise() <em>Compute Noise</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class StandardStochasticDiseaseModelTest extends StochasticDiseaseModelTest {
	/**
	 * Constructs a new Stochastic Disease Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardStochasticDiseaseModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stochastic Disease Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StandardStochasticDiseaseModel getFixture() {
		return (StandardStochasticDiseaseModel)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#computeNoise() <em>Compute Noise</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel#computeNoise()
	 * @generated NOT
	 */
	public void testComputeNoise() {
		StandardStochasticDiseaseModelTest.staticComputeNoiseTest();
	}
	
	
	/**
	 * static test method. Class is abstract.
	 */
	public static void staticComputeNoiseTest() {
		Random rand = new Random(0);
		double rTest = rand.nextDouble();
		// for testing purposes we will test at a gain of 1.0
		StochasticDiseaseModelImpl.setMAX_GAIN(1.0);
		double noise = StandardStochasticDiseaseModelImpl.computeNoise(1.0,rand);
		assertTrue ((noise >= 0.0 )&&(noise <= 2.0));
	}
	

} //StandardStochasticDiseaseModelTest

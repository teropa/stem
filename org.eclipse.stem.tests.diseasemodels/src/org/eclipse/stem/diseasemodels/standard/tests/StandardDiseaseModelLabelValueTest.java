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

import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Disease Model Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class StandardDiseaseModelLabelValueTest extends
		DiseaseModelLabelValueTest {
	/**
	 * Test value for Susceptible
	 */
	public static final double TEST_S = 1;

	/**
	 * Test value for Susceptible
	 */
	public static final double TEMP_TEST_S = TEST_S + 10;

	/**
	 * Constructs a new Disease Model Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardDiseaseModelLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Disease Model Label Value test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected StandardDiseaseModelLabelValue getFixture() {
		return (StandardDiseaseModelLabelValue)fixture;
	}


	/**
	 * The disease model label value represents the additions to the states
	 * caused by the disease. The conversion creates a different value that
	 * represents the equivalent subtractions from the source states.
	 * 
	 * @param fixture
	 *            the disease model state label value under test
	 * @return the equivalent value of the source states
	 */
	protected abstract StandardDiseaseModelLabelValue getExpectedConvertToSourceStates(
			StandardDiseaseModelLabelValue fixture);

} // StandardDiseaseModelLabelValueTest

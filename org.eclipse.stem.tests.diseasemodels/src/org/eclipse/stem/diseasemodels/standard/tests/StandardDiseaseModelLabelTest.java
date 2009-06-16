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

import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Disease Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getCurrentStandardDiseaseModelLabelValue() <em>Current Standard Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getNextStandardDiseaseModelLabelValue() <em>Next Standard Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getDeltaStandardDiseaseModelLabelValue() <em>Delta Standard Disease Model Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getCurrentYStandardDiseaseModelLabelValue() <em>Current YStandard Disease Model Label Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class StandardDiseaseModelLabelTest extends
		DiseaseModelLabelTest {
	/**
	 * Constructs a new Disease Model Label test case with the given name. <!--
	 * begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardDiseaseModelLabelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Disease Model Label test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected StandardDiseaseModelLabel getFixture() {
		return (StandardDiseaseModelLabel)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getCurrentStandardDiseaseModelLabelValue() <em>Current Standard Disease Model Label Value</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getCurrentStandardDiseaseModelLabelValue()
	 * @generated NOT
	 */
	public void testGetCurrentStandardDiseaseModelLabelValue() {
		final StandardDiseaseModelLabel standardLabel = getFixture();
		final StandardDiseaseModelLabelValue value = standardLabel
				.getCurrentStandardDiseaseModelLabelValue();
		assertNotNull(value);
	} // testGetCurrentStandardDiseaseModelLabelValue

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getNextStandardDiseaseModelLabelValue() <em>Next Standard Disease Model Label Value</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getNextStandardDiseaseModelLabelValue()
	 * @generated NOT
	 */
	public void testGetNextStandardDiseaseModelLabelValue() {
		final StandardDiseaseModelLabel standardLabel = getFixture();
		final StandardDiseaseModelLabelValue value = standardLabel
				.getNextStandardDiseaseModelLabelValue();
		assertNotNull(value);
	} // testGetNextStandardDiseaseModelLabelValue

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getDeltaStandardDiseaseModelLabelValue() <em>Delta Standard Disease Model Label Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getDeltaStandardDiseaseModelLabelValue()
	 * @generated
	 */
	public void testGetDeltaStandardDiseaseModelLabelValue() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getCurrentYStandardDiseaseModelLabelValue() <em>Current YStandard Disease Model Label Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getCurrentYStandardDiseaseModelLabelValue()
	 * @generated
	 */
	public void testGetCurrentYStandardDiseaseModelLabelValue() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#setS(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getS()
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#setNextS(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel#getNextS()
	 */
	public void testSetGetCurrentNextStandardDiseaseModelLabelS() {
		final StandardDiseaseModelLabel standardLabel = getFixture();
		assertTrue(standardLabel.getS() == 0.0);
		assertTrue(standardLabel.getNextS() == 0.0);
		standardLabel.setS(StandardDiseaseModelLabelValueTest.TEST_S);
		standardLabel.setNextS(StandardDiseaseModelLabelValueTest.TEMP_TEST_S);
		assertTrue(standardLabel.getS() == StandardDiseaseModelLabelValueTest.TEST_S);
		assertTrue(standardLabel.getNextS() == StandardDiseaseModelLabelValueTest.TEMP_TEST_S);
		standardLabel.setNextValueValid(true);
		standardLabel.switchToNextValue();
		assertTrue(standardLabel.getS() == StandardDiseaseModelLabelValueTest.TEMP_TEST_S);
		assertTrue(standardLabel.getNextS() == StandardDiseaseModelLabelValueTest.TEST_S);
	} // testSetGetCurrentNextStandardDiseaseModelLabelS

} // StandardDiseaseModelLabelTest

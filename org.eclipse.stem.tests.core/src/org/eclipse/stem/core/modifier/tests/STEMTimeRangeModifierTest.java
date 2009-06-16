package org.eclipse.stem.core.modifier.tests;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>STEM Time Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class STEMTimeRangeModifierTest extends RangeModifierTest {

	public static final STEMTime STEM_TIME_START_VALUE = ModelFactory.eINSTANCE
			.createSTEMTime();
	public static final STEMTime STEM_TIME_END_VALUE = ModelFactory.eINSTANCE
			.createSTEMTime();
	public static final long STEM_TIME_INCREMENT_VALUE = STEMTime.Units.DAY
			.getMilliseconds();

	private static final STEMTime EXPECTED_VALUES[] = new STEMTime[] {
			STEM_TIME_START_VALUE, STEM_TIME_END_VALUE };
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STEMTimeRangeModifierTest.class);
	}

	/**
	 * Constructs a new STEM Time Range Modifier test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTimeRangeModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STEM Time Range Modifier test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected STEMTimeRangeModifier getFixture() {
		return (STEMTimeRangeModifier)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setFixture(createFixture());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * @return a {@link DoubleRangeModifier} ready for testing.
	 */
	public STEMTimeRangeModifier createFixture() {
		final STEMTimeRangeModifier retValue = ModifierFactory.eINSTANCE
				.createSTEMTimeRangeModifier();
		retValue.setStartValue(STEM_TIME_START_VALUE);
		retValue.setEndValue(STEM_TIME_END_VALUE);
		retValue.setIncrement(STEM_TIME_INCREMENT_VALUE);
		retValue.setEStructuralFeature(getTestObject().eClass()
				.getEStructuralFeatures().get(0));
		return retValue;
	} // createFixture

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getTestAttributeEType()
	 */
	@Override
	protected EClassifier getTestAttributeEType() {
		return ModelPackage.eINSTANCE.getSTEMTime();
	} // getTestAttributeEType

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getNumberOfModifications()
	 */
	@Override
	int getNumberOfModifications() {
		STEMTimeRangeModifier fixture = getFixture();
		//$ANALYSIS-IGNORE
		final int retValue = (int) ((fixture.getEndValue().getTime().getTime() - fixture
						.getStartValue().getTime().getTime()) / fixture.getIncrement()) + 1;
		return retValue;
	} // getNumberOfModifications

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		assertTrue(i < EXPECTED_VALUES.length);
		final STEMTimeRangeModifier fixture = getFixture();
		STEMTime currentValue = (STEMTime) getTestObject().eGet(
				fixture.getEStructuralFeature());
		return currentValue.equals( EXPECTED_VALUES[i]);
	}

} // STEMTimeRangeModifierTest

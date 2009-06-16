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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Double Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class DoubleRangeModifierTest extends RangeModifierTest {

	public static final double DRM_START_VALUE = 10.0;
	public static final double DRM_END_VALUE = 12.5;
	public static final double DRM_INCREMENT_VALUE = 1.0;

	// 10, 11, 12, 12.5
	private static final double EXPECTED_VALUES[] = new double[] {
			DRM_START_VALUE, DRM_START_VALUE + DRM_INCREMENT_VALUE,
			DRM_START_VALUE + 2 * DRM_INCREMENT_VALUE, DRM_END_VALUE };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleRangeModifierTest.class);
	}

	/**
	 * Constructs a new Double Range Modifier test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleRangeModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Double Range Modifier test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected DoubleRangeModifier getFixture() {
		return (DoubleRangeModifier)fixture;
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
	public DoubleRangeModifier createFixture() {
		final DoubleRangeModifier retValue = ModifierFactory.eINSTANCE
				.createDoubleRangeModifier();
		retValue.setStartValue(DRM_START_VALUE);
		retValue.setEndValue(DRM_END_VALUE);
		retValue.setIncrement(DRM_INCREMENT_VALUE);
		retValue.setEStructuralFeature(getTestObject().eClass()
				.getEStructuralFeatures().get(0));
		return retValue;
	} // createFixture

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getTestAttributeEType()
	 */
	@Override
	protected EClassifier getTestAttributeEType() {
		return EcorePackage.eINSTANCE.getEDouble();
	} // getTestAttributeEType

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getNumberOfModifications()
	 */
	@Override
	int getNumberOfModifications() {
		return EXPECTED_VALUES.length;
	} // getNumberOfModifications

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		assertTrue(i < EXPECTED_VALUES.length);
		final DoubleRangeModifier fixture = getFixture();
		Double currentValue = (Double) getTestObject().eGet(
				fixture.getEStructuralFeature());

		return currentValue.doubleValue() == EXPECTED_VALUES[i];
	} // validateFeatureValue

} // DoubleRangeModifierTest

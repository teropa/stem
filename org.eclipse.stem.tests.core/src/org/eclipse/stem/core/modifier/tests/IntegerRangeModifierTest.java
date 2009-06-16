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
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Integer Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class IntegerRangeModifierTest extends RangeModifierTest {

	public static final int IRM_START_VALUE = 20;
	public static final int IRM_END_VALUE = 22;
	public static final int IRM_INCREMENT_VALUE = 1;

	private static final int EXPECTED_VALUES[] = new int[] { IRM_START_VALUE,
			IRM_START_VALUE + IRM_INCREMENT_VALUE, IRM_END_VALUE };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerRangeModifierTest.class);
	}

	/**
	 * Constructs a new Integer Range Modifier test case with the given name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerRangeModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Range Modifier test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected IntegerRangeModifier getFixture() {
		return (IntegerRangeModifier)fixture;
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
	 * @return a {@link IntegerRangeModifier} ready for testing.
	 */
	public IntegerRangeModifier createFixture() {
		final IntegerRangeModifier retValue = ModifierFactory.eINSTANCE
				.createIntegerRangeModifier();
		retValue.setStartValue(IRM_START_VALUE);
		retValue.setEndValue(IRM_END_VALUE);
		retValue.setIncrement(IRM_INCREMENT_VALUE);
		retValue.setEStructuralFeature(getTestObject().eClass()
				.getEStructuralFeatures().get(0));
		return retValue;
	} // createFixture

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getTestAttributeEType()
	 */
	@Override
	protected EClassifier getTestAttributeEType() {
		return EcorePackage.eINSTANCE.getEInt();
	}

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
		final IntegerRangeModifier fixture = getFixture();
		Integer currentValue = (Integer) getTestObject().eGet(
				fixture.getEStructuralFeature());

		return currentValue.intValue() == EXPECTED_VALUES[i];
	} // validateFeatureValue

} // IntegerRangeModifierTest

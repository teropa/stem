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
import org.eclipse.stem.core.modifier.LongRangeModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Long Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class LongRangeModifierTest extends RangeModifierTest {

	public static final long LRM_START_VALUE = 20L;
	public static final long LRM_END_VALUE = 22L;
	public static final long LRM_INCREMENT_VALUE = 1L;

	private static final long EXPECTED_VALUES[] = new long[] { LRM_START_VALUE,
			LRM_START_VALUE + LRM_INCREMENT_VALUE, LRM_END_VALUE };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LongRangeModifierTest.class);
	}

	/**
	 * Constructs a new Long Range Modifier test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LongRangeModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Long Range Modifier test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected LongRangeModifier getFixture() {
		return (LongRangeModifier)fixture;
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
	public LongRangeModifier createFixture() {
		final LongRangeModifier retValue = ModifierFactory.eINSTANCE
				.createLongRangeModifier();
		retValue.setStartValue(LRM_START_VALUE);
		retValue.setEndValue(LRM_END_VALUE);
		retValue.setIncrement(LRM_INCREMENT_VALUE);
		retValue.setEStructuralFeature(getTestObject().eClass()
				.getEStructuralFeatures().get(0));
		return retValue;
	} // createFixture

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getTestAttributeEType()
	 */
	@Override
	protected EClassifier getTestAttributeEType() {
		return EcorePackage.eINSTANCE.getELong();
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
		final LongRangeModifier fixture = getFixture();
		Long currentValue = (Long) getTestObject().eGet(
				fixture.getEStructuralFeature());

		return currentValue.longValue() == EXPECTED_VALUES[i];
	} // validateFeatureValue

} // LongRangeModifierTest

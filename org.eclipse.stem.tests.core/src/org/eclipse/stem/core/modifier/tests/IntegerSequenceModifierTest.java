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
import org.eclipse.stem.core.modifier.IntegerSequenceModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.SequenceModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class IntegerSequenceModifierTest extends SequenceModifierTest {

	private static final int EXPECTED_VALUES[] = new int[] {
		IntegerRangeModifierTest.IRM_START_VALUE,
		IntegerRangeModifierTest.IRM_END_VALUE };

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerSequenceModifierTest.class);
	}

	/**
	 * Constructs a new Integer Sequence Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerSequenceModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Sequence Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IntegerSequenceModifier getFixture() {
		return (IntegerSequenceModifier)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setFixture(createFixture());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * @see org.eclipse.stem.core.modifier.tests.SequenceModifierTest#createFixture()
	 */
	@SuppressWarnings("boxing")
	@Override
	public SequenceModifier createFixture() {
		final IntegerSequenceModifier retValue = ModifierFactory.eINSTANCE
				.createIntegerSequenceModifier();
		for (int value : EXPECTED_VALUES) {
			 retValue.getSequence().add(value);
		} // for each double

		retValue.setEStructuralFeature(getTestObject().eClass()
				.getEStructuralFeatures().get(0));
		return retValue;
	} // createFixture

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getNumberOfModifications()
	 */
	@Override
	int getNumberOfModifications() {
		return EXPECTED_VALUES.length;
	}

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#getTestAttributeEType()
	 */
	@Override
	protected EClassifier getTestAttributeEType() {
		return EcorePackage.eINSTANCE.getEInt();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		assertTrue(i < EXPECTED_VALUES.length);
		final IntegerSequenceModifier fixture = getFixture();
		Integer currentValue = (Integer) getTestObject().eGet(
				fixture.getEStructuralFeature());
		return currentValue.intValue() == EXPECTED_VALUES[i];
	} // validateFeatureValue
	
} //IntegerSequenceModifierTest

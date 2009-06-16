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
import org.eclipse.stem.core.modifier.DoubleSequenceModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.SequenceModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class DoubleSequenceModifierTest extends SequenceModifierTest {

	private static final double EXPECTED_VALUES[] = new double[] {
			DoubleRangeModifierTest.DRM_START_VALUE,
			DoubleRangeModifierTest.DRM_END_VALUE };

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleSequenceModifierTest.class);
	}

	/**
	 * Constructs a new Double Sequence Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleSequenceModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Double Sequence Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DoubleSequenceModifier getFixture() {
		return (DoubleSequenceModifier)fixture;
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
		final DoubleSequenceModifier retValue = ModifierFactory.eINSTANCE
				.createDoubleSequenceModifier();
		for (double value : EXPECTED_VALUES) {
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
		return EcorePackage.eINSTANCE.getEDouble();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		assertTrue(i < EXPECTED_VALUES.length);
		final DoubleSequenceModifier fixture = getFixture();
		Double currentValue = (Double) getTestObject().eGet(
				fixture.getEStructuralFeature());
		return currentValue.doubleValue() == EXPECTED_VALUES[i];
	} // validateFeatureValue
	
} //DoubleSequenceModifierTest

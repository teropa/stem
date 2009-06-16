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
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.STEMTimeSequenceModifier;
import org.eclipse.stem.core.modifier.SequenceModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STEM Time Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class STEMTimeSequenceModifierTest extends SequenceModifierTest {

	private static final STEMTime EXPECTED_VALUES[] = new STEMTime[] {
		STEMTimeRangeModifierTest.STEM_TIME_START_VALUE,
		STEMTimeRangeModifierTest.STEM_TIME_END_VALUE };
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STEMTimeSequenceModifierTest.class);
	}

	/**
	 * Constructs a new STEM Time Sequence Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTimeSequenceModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STEM Time Sequence Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected STEMTimeSequenceModifier getFixture() {
		return (STEMTimeSequenceModifier)fixture;
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
	@Override
	public SequenceModifier createFixture() {
		final STEMTimeSequenceModifier retValue = ModifierFactory.eINSTANCE
				.createSTEMTimeSequenceModifier();
		for (STEMTime value : EXPECTED_VALUES) {
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
		return ModelPackage.eINSTANCE.getSTEMTime();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		assertTrue(i < EXPECTED_VALUES.length);
		final STEMTimeSequenceModifier fixture = getFixture();
		STEMTime currentValue = (STEMTime) getTestObject().eGet(
				fixture.getEStructuralFeature());
		return currentValue.equals( EXPECTED_VALUES[i]);
	} // validateFeatureValue
	

} //STEMTimeSequenceModifierTest

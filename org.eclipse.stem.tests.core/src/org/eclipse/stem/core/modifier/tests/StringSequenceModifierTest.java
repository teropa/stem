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
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.SequenceModifier;
import org.eclipse.stem.core.modifier.StringSequenceModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Sequence Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class StringSequenceModifierTest extends SequenceModifierTest {

public static final String STRING_START_VALUE = "start";
	public static final String STRING_END_VALUE = "end";

	private static final String EXPECTED_VALUES[] = new String[] {
			STRING_START_VALUE, STRING_END_VALUE };

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringSequenceModifierTest.class);
	}

	/**
	 * Constructs a new String Sequence Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSequenceModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this String Sequence Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StringSequenceModifier getFixture() {
		return (StringSequenceModifier)fixture;
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
		final StringSequenceModifier retValue = ModifierFactory.eINSTANCE
				.createStringSequenceModifier();
		for (String value : EXPECTED_VALUES) {
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
		return EcorePackage.eINSTANCE.getEString();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		assertTrue(i < EXPECTED_VALUES.length);
		final StringSequenceModifier fixture = getFixture();
		String currentValue = (String) getTestObject().eGet(
				fixture.getEStructuralFeature());
		return currentValue.equals( EXPECTED_VALUES[i]);
	} // validateFeatureValue
	

} //StringSequenceModifierTest

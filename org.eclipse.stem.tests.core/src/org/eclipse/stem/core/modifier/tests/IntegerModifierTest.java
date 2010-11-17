package org.eclipse.stem.core.modifier.tests;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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
import org.eclipse.stem.core.modifier.IntegerModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerModifierTest extends SingleValueModifierTest {
	
	private static final int ORIGINAL_VAUE = 1;
	private static final int NEW_VAUE = 2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerModifierTest.class);
	}

	/**
	 * Constructs a new Integer Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IntegerModifier getFixture() {
		return (IntegerModifier)fixture;
	}
	

	/**
	 * @return a {@link DoubleRangeModifier} ready for testing.
	 */
	public IntegerModifier createFixture() {
		final IntegerModifier retValue = ModifierFactory.eINSTANCE.createIntegerModifier();
		retValue.setOriginalValue(ORIGINAL_VAUE);
		retValue.setValue(NEW_VAUE);
		retValue.setFeatureName("IntegerModifier_singleTest");
		retValue.setEStructuralFeature(getTestObject().eClass()
				.getEStructuralFeatures().get(0));
		
		return retValue;
	} // createFixture

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	int getNumberOfModifications() {
		return 1;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	protected EClassifier getTestAttributeEType() {
		return EcorePackage.eINSTANCE.getEInt();
	} // getTestAttributeEType

	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		
		final IntegerModifier fixture = getFixture();
		Object currentValue = getTestObject().eGet(fixture.getEStructuralFeature());

		return (currentValue instanceof Integer);
	} // validateFeatureValue

} //IntegerModifierTest

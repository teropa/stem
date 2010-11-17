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
import org.eclipse.stem.core.modifier.DoubleModifier;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DoubleModifierTest extends SingleValueModifierTest {
	
	private static final double ORIGINAL_VAUE = 1.0;
	private static final double NEW_VAUE = 2.0;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleModifierTest.class);
	}

	/**
	 * Constructs a new Double Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Double Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DoubleModifier getFixture() {
		return (DoubleModifier)fixture;
	}
	
	/**
	 * @return a {@link DoubleRangeModifier} ready for testing.
	 */
	public DoubleModifier createFixture() {
		final DoubleModifier retValue = ModifierFactory.eINSTANCE.createDoubleModifier();
		retValue.setOriginalValue(ORIGINAL_VAUE);
		retValue.setValue(NEW_VAUE);
		retValue.setFeatureName("DoubleModifier_singleTest");
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
	@Override
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
		return EcorePackage.eINSTANCE.getEDouble();
	} // getTestAttributeEType

	
	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		
		final DoubleModifier fixture = getFixture();
		Object currentValue = getTestObject().eGet(fixture.getEStructuralFeature());

		return (currentValue instanceof Double);
	} // validateFeatureValue

} //DoubleModifierTest

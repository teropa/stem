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
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.STEMTimeModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STEM Time Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class STEMTimeModifierTest extends SingleValueModifierTest {
	
	private static STEMTime ORIGINAL_VALUE;
	private static STEMTime NEW_VALUE;
	// One day's worth of milliseconds
	private static final long TEST_INCREMENT = 24 * 60 * 60 * 1000;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STEMTimeModifierTest.class);
	}

	/**
	 * Constructs a new STEM Time Modifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTimeModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STEM Time Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected STEMTimeModifier getFixture() {
		return (STEMTimeModifier)fixture;
	}

	/**
	 * @return a {@link STEMTimeModifier} ready for testing.
	 */
	public STEMTimeModifier createFixture() {
		final STEMTimeModifier retValue = ModifierFactory.eINSTANCE.createSTEMTimeModifier();
		ORIGINAL_VALUE = ModelFactory.eINSTANCE.createSTEMTime();
		retValue.setOriginalValue(ORIGINAL_VALUE);
		NEW_VALUE = ORIGINAL_VALUE.addIncrement(TEST_INCREMENT);
		retValue.setValue(NEW_VALUE);
		retValue.setFeatureName("STEMTimeModifierTest");
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
	 * @see junit.framework.TestCase#getNumberOfModifications()
	 * @generated NOT
	 */
	@Override
	int getNumberOfModifications() {
		return 1;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#getTestAttributeEType()
	 * @generated NOT
	 */
	protected EClassifier getTestAttributeEType() {
		return EcorePackage.eINSTANCE.getEObject();
	} // getTestAttributeEType


	/**
	 * @see org.eclipse.stem.core.modifier.tests.FeatureModifierTest#validateFeatureValue(int)
	 */
	@Override
	protected boolean validateFeatureValue(int i) {
		assertTrue(i >= 0);
		
		final STEMTimeModifier fixture = getFixture();
		Object currentValue = getTestObject().eGet(fixture.getEStructuralFeature());

		return (currentValue instanceof STEMTime);
	} // validateFeatureValue

} //STEMTimeModifierTest

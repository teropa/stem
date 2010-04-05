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
import org.eclipse.stem.core.modifier.IntegerModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerModifierTest extends SingleValueModifierTest {

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModifierFactory.eINSTANCE.createIntegerModifier());
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

	@Override
	int getNumberOfModifications() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected EClassifier getTestAttributeEType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean validateFeatureValue(int i) {
		// TODO Auto-generated method stub
		return false;
	}

} //IntegerModifierTest

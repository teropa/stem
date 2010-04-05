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
import org.eclipse.stem.core.modifier.DoubleModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Modifier</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DoubleModifierTest extends SingleValueModifierTest {

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModifierFactory.eINSTANCE.createDoubleModifier());
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

} //DoubleModifierTest

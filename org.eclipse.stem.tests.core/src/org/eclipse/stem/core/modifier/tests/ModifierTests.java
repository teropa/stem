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

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>modifier</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifierTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ModifierTests("modifier Tests"); //$NON-NLS-1$
		suite.addTestSuite(DoubleNOPModifierTest.class);
		suite.addTestSuite(DoubleRangeModifierTest.class);
		suite.addTestSuite(DoubleSequenceModifierTest.class);
		suite.addTestSuite(IntegerNOPModifierTest.class);
		suite.addTestSuite(IntegerRangeModifierTest.class);
		suite.addTestSuite(IntegerSequenceModifierTest.class);
		suite.addTestSuite(LongNOPModifierTest.class);
		suite.addTestSuite(LongRangeModifierTest.class);
		suite.addTestSuite(LongSequenceModifierTest.class);
		suite.addTestSuite(ModifierTest.class);
		suite.addTestSuite(NOPModifierTest.class);
		suite.addTestSuite(STEMTimeNOPModifierTest.class);
		suite.addTestSuite(STEMTimeRangeModifierTest.class);
		suite.addTestSuite(STEMTimeSequenceModifierTest.class);
		suite.addTestSuite(StringNOPModifierTest.class);
		suite.addTestSuite(StringSequenceModifierTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierTests(String name) {
		super(name);
	}

} //ModifierTests

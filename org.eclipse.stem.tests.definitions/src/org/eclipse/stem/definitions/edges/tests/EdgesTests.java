package org.eclipse.stem.definitions.edges.tests;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
 * A test suite for the '<em><b>edges</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgesTests extends TestSuite {

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
		TestSuite suite = new EdgesTests("edges Tests"); //$NON-NLS-1$
		suite.addTestSuite(MigrationEdgeTest.class);
		suite.addTestSuite(MigrationEdgeLabelTest.class);
		suite.addTestSuite(MigrationEdgeLabelValueTest.class);
		suite.addTestSuite(MixingEdgeTest.class);
		suite.addTestSuite(MixingEdgeLabelTest.class);
		suite.addTestSuite(MixingEdgeLabelValueTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgesTests(String name) {
		super(name);
	}

} //EdgesTests

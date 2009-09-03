package org.eclipse.stem.diseasemodels.experimental.tests;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
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
 * A test suite for the '<em><b>experimental</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentalTests extends TestSuite {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param args 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return Test Suite
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ExperimentalTests("experimental Tests");
		suite.addTestSuite(PercolationDiseaseModelTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name 
	 * @generated
	 */
	public ExperimentalTests(String name) {
		super(name);
	}

} //ExperimentalTests

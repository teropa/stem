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

import org.eclipse.stem.definitions.labels.tests.LabelsTests;

import org.eclipse.stem.definitions.nodes.tests.NodesTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Definitions</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefinitionsAllTests extends TestSuite {

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
		TestSuite suite = new DefinitionsAllTests("Definitions Tests"); //$NON-NLS-1$
		suite.addTest(EdgesTests.suite());
		suite.addTest(LabelsTests.suite());
		suite.addTest(NodesTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionsAllTests(String name) {
		super(name);
	}

} //DefinitionsAllTests

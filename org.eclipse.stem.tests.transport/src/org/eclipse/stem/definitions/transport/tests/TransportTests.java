package org.eclipse.stem.definitions.transport.tests;

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
 * A test suite for the '<em><b>transport</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransportTests extends TestSuite {

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
		TestSuite suite = new TransportTests("transport Tests");
		suite.addTestSuite(LoadUnloadEdgeTest.class);
		suite.addTestSuite(LoadUnloadEdgeLabelTest.class);
		suite.addTestSuite(PacketStyleTransportSystemTest.class);
		suite.addTestSuite(PacketTransportLabelTest.class);
		suite.addTestSuite(PipeStyleTransportSystemTest.class);
		suite.addTestSuite(PacketTransportLabelValueTest.class);
		suite.addTestSuite(PacketStyleTransportSystemDecoratorTest.class);
		suite.addTestSuite(PipeTransportEdgeTest.class);
		suite.addTestSuite(PipeTransportEdgeLabelTest.class);
		suite.addTestSuite(PipeTransportEdgeLabelValueTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportTests(String name) {
		super(name);
	}

} //TransportTests

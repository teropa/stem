package org.eclipse.stem.core.common.tests;

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

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DoubleValue;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DoubleValueTest extends TestCase {

	/**
	 * The fixture for this Double Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleValueTest.class);
	}

	/**
	 * Constructs a new Double Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Double Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DoubleValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Double Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValue getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommonFactory.eINSTANCE.createDoubleValue());
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

} //DoubleValueTest

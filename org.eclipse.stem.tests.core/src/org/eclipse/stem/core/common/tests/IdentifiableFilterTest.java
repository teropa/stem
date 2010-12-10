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

import org.eclipse.stem.core.common.IdentifiableFilter;
import org.eclipse.stem.core.common.impl.IdentifiableFilterImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifiable Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdentifiableFilterTest extends TestCase {
	
	private static final String INITIAL_VALUE = "US";

	/**
	 * The fixture for this Identifiable Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifiableFilter fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifiableFilterTest.class);
	}

	/**
	 * Constructs a new Identifiable Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiableFilterTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Identifiable Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(IdentifiableFilter fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Identifiable Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifiableFilter getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		// use the Impl for testing, should accept the String argument
		IdentifiableFilterImpl testValue = new IdentifiableFilterImpl(INITIAL_VALUE);;
		setFixture(testValue);
	}
	
	/**
	 *
	 */
	public void testIsValid() {
		IdentifiableFilter filter = getFixture();
		//TODO what is there to test here?
		// Nothing to test. No Sane Method implemented yet
		assertTrue(true);
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

} //IdentifiableFilterTest

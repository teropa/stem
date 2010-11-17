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

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.StringValue;
import org.eclipse.stem.core.common.StringValueList;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Value List</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringValueListTest extends TestCase {
	
	private static final int NUM_VALUES = 2;
	private static final String INITIAL_VALUE = "First Test String";
	private static final String NEXT_VALUE = "Second $#% Test String";
	
	/**
	 * The fixture for this String Value List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringValueList fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringValueListTest.class);
	}

	/**
	 * Constructs a new String Value List test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValueListTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this String Value List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(StringValueList fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this String Value List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringValueList getFixture() {
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
		StringValueList svl = CommonFactory.eINSTANCE.createStringValueList();
		EList<StringValue> dList = svl.getValues();
		StringValue sv1 = CommonFactory.eINSTANCE.createStringValue();
		sv1.setValue(INITIAL_VALUE);
		StringValue sv2 = CommonFactory.eINSTANCE.createStringValue();
		sv2.setValue(NEXT_VALUE);
		dList.add(sv1);
		dList.add(sv2);
		setFixture(svl);
	}

	/**
	 * 
	 */
	public void testIsValid() {
		StringValueList fixture = getFixture();
		EList<StringValue> dList = fixture.getValues();
		assertTrue(dList.size()==NUM_VALUES);
		StringValue sv1 = dList.get(0);
		StringValue sv2 = dList.get(1);
		
		assertTrue(sv1.getValue().equals(INITIAL_VALUE));
		assertTrue(sv2.getValue().equals(NEXT_VALUE));
	} // testIsComplete
	
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

} //StringValueListTest

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
import org.eclipse.stem.core.common.DoubleValue;
import org.eclipse.stem.core.common.DoubleValueList;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Value List</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DoubleValueListTest extends TestCase {
	
	private static final String LIST_NAME = "DoubleValueListTestList";
	private static final int NUMVALUES = 2;
	private static final double firstDValue = 1.0;
	private static final double secondDValue = 17.0;

	/**
	 * The fixture for this Double Value List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueList fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleValueListTest.class);
	}

	/**
	 * Constructs a new Double Value List test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueListTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Double Value List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DoubleValueList fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Double Value List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueList getFixture() {
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
		DoubleValueList dvl = CommonFactory.eINSTANCE.createDoubleValueList();
		dvl.setIdentifier(LIST_NAME);
		EList<DoubleValue> dList = dvl.getValues();
		DoubleValue dv1 = CommonFactory.eINSTANCE.createDoubleValue();
		dv1.setValue(firstDValue);
		DoubleValue dv2 = CommonFactory.eINSTANCE.createDoubleValue();
		dv2.setValue(secondDValue);
		dList.add(dv1);
		dList.add(dv2);
		setFixture(dvl);
	}
	
	/**
	 * 
	 */
	public void testIsValid() {
		DoubleValueList fixture = getFixture();
		EList<DoubleValue> dList = fixture.getValues();
		assertTrue(dList.size()==NUMVALUES);
		DoubleValue dv1 = dList.get(0);
		DoubleValue dv2 = dList.get(1);
		
		assertTrue(dv1.getValue()==firstDValue);
		assertTrue(dv2.getValue()==secondDValue);
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

} //DoubleValueListTest

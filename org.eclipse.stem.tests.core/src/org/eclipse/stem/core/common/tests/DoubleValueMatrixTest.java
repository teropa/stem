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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.DoubleValueMatrix;
import org.eclipse.stem.core.common.impl.CommonFactoryImpl;
import org.eclipse.stem.core.common.impl.DoubleValueMatrixImpl;
import org.eclipse.stem.core.modifier.FeatureModifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Double Value Matrix</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DoubleValueMatrixTest extends TestCase {

	/**
	 * The fixture for this Double Value Matrix test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueMatrix fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DoubleValueMatrixTest.class);
	}

	/**
	 * Constructs a new Double Value Matrix test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueMatrixTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Double Value Matrix test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DoubleValueMatrix fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Double Value Matrix test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected DoubleValueMatrix getFixture() {
		CommonFactory factory = CommonFactoryImpl.init();
		fixture = factory.createDoubleValueMatrix();
		return fixture;
	}
	
	/**
	 *
	 * @generated NOT
	 */
	public void testDoubleValueMatrix() {
		DoubleValueMatrix dvm= getFixture();
		EList<DoubleValueList> dvList = dvm.getValueLists();
		assertTrue(dvList != null);
	} 

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommonFactory.eINSTANCE.createDoubleValueMatrix());
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

} //DoubleValueMatrixTest

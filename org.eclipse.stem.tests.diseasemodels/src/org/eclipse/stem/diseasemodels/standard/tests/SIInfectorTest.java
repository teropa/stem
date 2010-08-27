package org.eclipse.stem.diseasemodels.standard.tests;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>SI Infector</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class SIInfectorTest extends StandardInfectorTest {
	
	public static final URI INFECTOR_URI = STEMURI.createURI("infector/testInfector.decorator");
	
	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SIInfectorTest.class);
	}

	/**
	 * Constructs a new SI Infector test case with the given name.
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIInfectorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SI Infector test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SIInfector getFixture() {
		return (SIInfector)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		SIInfector temp = StandardFactory.eINSTANCE.createSIInfector();
		temp.setTargetISOKey("US");
		temp.setURI(INFECTOR_URI);
		setFixture(temp);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} // SIInfectorTest

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

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>standard</b></em>'
 * package. <!-- end-user-doc -->
 * @generated
 */
public class StandardTests extends TestSuite {
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param args
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new StandardTests("standard Tests"); //$NON-NLS-1$
		suite.addTestSuite(DeterministicSEIRDiseaseModelTest.class);
		suite.addTestSuite(DeterministicSIDiseaseModelTest.class);
		suite.addTestSuite(DeterministicSIRDiseaseModelTest.class);
		suite.addTestSuite(SEIRLabelTest.class);
		suite.addTestSuite(SEIRLabelValueTest.class);
		suite.addTestSuite(SIInfectorTest.class);
		suite.addTestSuite(SILabelTest.class);
		suite.addTestSuite(SILabelValueTest.class);
		suite.addTestSuite(SIRLabelTest.class);
		suite.addTestSuite(SIRLabelValueTest.class);
		suite.addTestSuite(StochasticSEIRDiseaseModelTest.class);
		suite.addTestSuite(StochasticSIDiseaseModelTest.class);
		suite.addTestSuite(StochasticSIRDiseaseModelTest.class);
		suite.addTestSuite(AggregatingSIDiseaseModelTest.class);
		suite.addTestSuite(AggregatingSEIRDiseaseModelTest.class);
		suite.addTestSuite(AggregatingSIRDiseaseModelTest.class);
		suite.addTestSuite(SIRInoculatorTest.class);
		suite.addTestSuite(StochasticPoissonSIDiseaseModelTest.class);
		suite.addTestSuite(StochasticPoissonSIRDiseaseModelTest.class);
		suite.addTestSuite(StochasticPoissonSEIRDiseaseModelTest.class);
		suite.addTestSuite(InfectorInoculatorCollectionTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param name
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardTests(String name) {
		super(name);
	}

} // StandardTests

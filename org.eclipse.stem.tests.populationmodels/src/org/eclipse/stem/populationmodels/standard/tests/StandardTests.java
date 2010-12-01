/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>standard</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardTests extends TestSuite {

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
		TestSuite suite = new StandardTests("standard Tests");
		suite.addTestSuite(StandardPopulationModelTest.class);
		suite.addTestSuite(PopulationModelLabelTest.class);
		suite.addTestSuite(StandardPopulationModelLabelTest.class);
		suite.addTestSuite(PopulationModelLabelValueTest.class);
		suite.addTestSuite(StandardPopulationModelLabelValueTest.class);
		suite.addTestSuite(StochasticStandardPopulationModelTest.class);
		suite.addTestSuite(DemographicPopulationModelTest.class);
		suite.addTestSuite(StandardPopulationInitializerTest.class);
		suite.addTestSuite(SeasonalPopulationModelTest.class);
		suite.addTestSuite(YetiPopulationInitializerTest.class);
		suite.addTestSuite(MosquitoPopulationModelTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardTests(String name) {
		super(name);
	}

} //StandardTests

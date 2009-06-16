/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.experimental.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Experimental</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentalAllTests extends TestSuite {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param args 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return  the test suite
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ExperimentalAllTests("Experimental Tests");
		suite.addTest(ExperimentalTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name 
	 * @generated
	 */
	public ExperimentalAllTests(String name) {
		super(name);
	}

} //ExperimentalAllTests

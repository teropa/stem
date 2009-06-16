/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForcingAllTests.java,v 1.1 2009/03/13 00:06:48 sedlund Exp $
 */
package org.eclipse.stem.diseasemodels.forcing.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Forcing</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForcingAllTests extends TestSuite {

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
		TestSuite suite = new ForcingAllTests("Forcing Tests"); //$NON-NLS-1$
		suite.addTest(ForcingTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingAllTests(String name) {
		super(name);
	}

} //ForcingAllTests

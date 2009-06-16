package org.eclipse.stem.definitions.labels.tests;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * <!-- begin-user-doc --> A test suite for the '<em><b>labels</b></em>'
 * package. <!-- end-user-doc -->
 * @generated
 */
public class LabelsTests extends TestSuite {
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
		TestSuite suite = new LabelsTests("labels Tests"); //$NON-NLS-1$
		suite.addTestSuite(AreaLabelTest.class);
		suite.addTestSuite(AreaLabelValueTest.class);
		suite.addTestSuite(CommonBorderRelationshipLabelTest.class);
		suite.addTestSuite(CommonBorderRelationshipLabelValueTest.class);
		suite.addTestSuite(PopulationLabelTest.class);
		suite.addTestSuite(PopulationLabelValueTest.class);
		suite.addTestSuite(RelativePhysicalRelationshipLabelTest.class);
		suite.addTestSuite(RelativePhysicalRelationshipLabelValueTest.class);
		suite.addTestSuite(TransportRelationshipLabelTest.class);
		suite.addTestSuite(TransportRelationshipLabelValueTest.class);
		suite.addTestSuite(PhysicalRelationshipLabelValueTest.class);
		suite.addTestSuite(RoadTransportRelationshipLabelTest.class);
		suite.addTestSuite(RoadTransportRelationshipLabelValueTest.class);
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
	public LabelsTests(String name) {
		super(name);
	}

} // LabelsTests

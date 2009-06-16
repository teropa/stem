package org.eclipse.stem.tests.util.labels;

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.tests.util.labels.LabelsPackage
 * @generated
 */
public interface LabelsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LabelsFactory eINSTANCE = org.eclipse.stem.tests.util.labels.impl.LabelsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Dynamic Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Dynamic Edge Label</em>'.
	 * @generated
	 */
	TestDynamicEdgeLabel createTestDynamicEdgeLabel();

	/**
	 * Returns a new object of class '<em>Test Dynamic Label1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Dynamic Label1</em>'.
	 * @generated
	 */
	TestDynamicLabel1 createTestDynamicLabel1();

	/**
	 * Returns a new object of class '<em>Test Dynamic Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Dynamic Node Label</em>'.
	 * @generated
	 */
	TestDynamicNodeLabel createTestDynamicNodeLabel();

	/**
	 * Returns a new object of class '<em>Test Integer Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Integer Label Value</em>'.
	 * @generated
	 */
	TestIntegerLabelValue createTestIntegerLabelValue();

	/**
	 * Returns a new object of class '<em>Test Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Label</em>'.
	 * @generated
	 */
	TestLabel createTestLabel();

	/**
	 * Returns a new object of class '<em>Test Static Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Static Edge Label</em>'.
	 * @generated
	 */
	TestStaticEdgeLabel createTestStaticEdgeLabel();

	/**
	 * Returns a new object of class '<em>Test Static Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Static Node Label</em>'.
	 * @generated
	 */
	TestStaticNodeLabel createTestStaticNodeLabel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LabelsPackage getLabelsPackage();

} //LabelsFactory

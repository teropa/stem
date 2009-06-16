package org.eclipse.stem.tests.util.decorators;

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
 * @see org.eclipse.stem.tests.util.decorators.DecoratorsPackage
 * @generated
 */
public interface DecoratorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DecoratorsFactory eINSTANCE = org.eclipse.stem.tests.util.decorators.impl.DecoratorsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Edge Decorator1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Edge Decorator1</em>'.
	 * @generated
	 */
	TestEdgeDecorator1 createTestEdgeDecorator1();

	/**
	 * Returns a new object of class '<em>Test Graph Decorator1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Graph Decorator1</em>'.
	 * @generated
	 */
	TestGraphDecorator1 createTestGraphDecorator1();

	/**
	 * Returns a new object of class '<em>Test Node Decorator1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Node Decorator1</em>'.
	 * @generated
	 */
	TestNodeDecorator1 createTestNodeDecorator1();

	/**
	 * Returns a new object of class '<em>Test Scenario Graph Decorator1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Scenario Graph Decorator1</em>'.
	 * @generated
	 */
	TestScenarioGraphDecorator1 createTestScenarioGraphDecorator1();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DecoratorsPackage getDecoratorsPackage();

} //DecoratorsFactory

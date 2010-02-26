package org.eclipse.stem.core.common;

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
 * @see org.eclipse.stem.core.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonFactory eINSTANCE = org.eclipse.stem.core.common.impl.CommonFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dublin Core</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dublin Core</em>'.
	 * @generated
	 */
	DublinCore createDublinCore();

	/**
	 * Returns a new object of class '<em>Identifiable Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifiable Filter</em>'.
	 * @generated
	 */
	IdentifiableFilter createIdentifiableFilter();

	/**
	 * Returns a new object of class '<em>Double Value List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Value List</em>'.
	 * @generated
	 */
	DoubleValueList createDoubleValueList();

	/**
	 * Returns a new object of class '<em>Double Value Matrix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Value Matrix</em>'.
	 * @generated
	 */
	DoubleValueMatrix createDoubleValueMatrix();

	/**
	 * Returns a new object of class '<em>Double Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Value</em>'.
	 * @generated
	 */
	DoubleValue createDoubleValue();

	/**
	 * Returns a new object of class '<em>String Value List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Value List</em>'.
	 * @generated
	 */
	StringValueList createStringValueList();

	/**
	 * Returns a new object of class '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Value</em>'.
	 * @generated
	 */
	StringValue createStringValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommonPackage getCommonPackage();

} //CommonFactory

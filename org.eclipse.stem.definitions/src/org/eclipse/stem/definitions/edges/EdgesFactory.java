package org.eclipse.stem.definitions.edges;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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
 * @see org.eclipse.stem.definitions.edges.EdgesPackage
 * @generated
 */
public interface EdgesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EdgesFactory eINSTANCE = org.eclipse.stem.definitions.edges.impl.EdgesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Migration Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration Edge</em>'.
	 * @generated
	 */
	MigrationEdge createMigrationEdge();

	/**
	 * Returns a new object of class '<em>Migration Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration Edge Label</em>'.
	 * @generated
	 */
	MigrationEdgeLabel createMigrationEdgeLabel();

	/**
	 * Returns a new object of class '<em>Migration Edge Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration Edge Label Value</em>'.
	 * @generated
	 */
	MigrationEdgeLabelValue createMigrationEdgeLabelValue();

	/**
	 * Returns a new object of class '<em>Mixing Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mixing Edge</em>'.
	 * @generated
	 */
	MixingEdge createMixingEdge();

	/**
	 * Returns a new object of class '<em>Mixing Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mixing Edge Label</em>'.
	 * @generated
	 */
	MixingEdgeLabel createMixingEdgeLabel();

	/**
	 * Returns a new object of class '<em>Mixing Edge Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mixing Edge Label Value</em>'.
	 * @generated
	 */
	MixingEdgeLabelValue createMixingEdgeLabelValue();

	/**
	 * Returns a new object of class '<em>Population Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Edge</em>'.
	 * @generated
	 */
	PopulationEdge createPopulationEdge();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EdgesPackage getEdgesPackage();

} //EdgesFactory

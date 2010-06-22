/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage
 * @generated
 */
public interface GraphgeneratorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphgeneratorsFactory eINSTANCE = org.eclipse.stem.graphgenerators.impl.GraphgeneratorsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Square Lattice Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Square Lattice Graph Generator</em>'.
	 * @generated
	 */
	SquareLatticeGraphGenerator createSquareLatticeGraphGenerator();

	/**
	 * Returns a new object of class '<em>Migration Edge Graph Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration Edge Graph Generator</em>'.
	 * @generated
	 */
	MigrationEdgeGraphGenerator createMigrationEdgeGraphGenerator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphgeneratorsPackage getGraphgeneratorsPackage();

} //GraphgeneratorsFactory

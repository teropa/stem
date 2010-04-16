/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage
 * @generated
 */
public interface GraphgeneratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphgeneratorFactory eINSTANCE = org.eclipse.stem.core.graphgenerator.impl.GraphgeneratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Square Graph Lattice Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Square Graph Lattice Generator</em>'.
	 * @generated
	 */
	SquareGraphLatticeGenerator createSquareGraphLatticeGenerator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphgeneratorPackage getGraphgeneratorPackage();

} //GraphgeneratorFactory

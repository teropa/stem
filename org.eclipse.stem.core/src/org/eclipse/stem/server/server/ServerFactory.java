/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.server.server;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.server.server.ServerPackage
 * @generated
 */
public interface ServerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServerFactory eINSTANCE = org.eclipse.stem.server.server.impl.ServerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simulations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulations</em>'.
	 * @generated
	 */
	Simulations createSimulations();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServerPackage getServerPackage();

} //ServerFactory

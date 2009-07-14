/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.solvers.fd;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.solvers.fd.FdPackage
 * @generated
 */
public interface FdFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FdFactory eINSTANCE = org.eclipse.stem.solvers.fd.impl.FdFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Finite Difference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finite Difference</em>'.
	 * @generated
	 */
	FiniteDifference createFiniteDifference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FdPackage getFdPackage();

} //FdFactory

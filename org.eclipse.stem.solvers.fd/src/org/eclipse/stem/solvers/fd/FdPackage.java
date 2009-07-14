/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.solvers.fd;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.stem.core.solver.SolverPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.solvers.fd.FdFactory
 * @model kind="package"
 * @generated
 */
public interface FdPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fd";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/solvers/fd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.solvers.fd";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FdPackage eINSTANCE = org.eclipse.stem.solvers.fd.impl.FdPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl <em>Finite Difference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl
	 * @see org.eclipse.stem.solvers.fd.impl.FdPackageImpl#getFiniteDifference()
	 * @generated
	 */
	int FINITE_DIFFERENCE = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_DIFFERENCE__URI = SolverPackage.SOLVER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_DIFFERENCE__TYPE_URI = SolverPackage.SOLVER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_DIFFERENCE__DUBLIN_CORE = SolverPackage.SOLVER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_DIFFERENCE__DECORATORS = SolverPackage.SOLVER__DECORATORS;

	/**
	 * The number of structural features of the '<em>Finite Difference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_DIFFERENCE_FEATURE_COUNT = SolverPackage.SOLVER_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.solvers.fd.FiniteDifference <em>Finite Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finite Difference</em>'.
	 * @see org.eclipse.stem.solvers.fd.FiniteDifference
	 * @generated
	 */
	EClass getFiniteDifference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FdFactory getFdFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl <em>Finite Difference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl
		 * @see org.eclipse.stem.solvers.fd.impl.FdPackageImpl#getFiniteDifference()
		 * @generated
		 */
		EClass FINITE_DIFFERENCE = eINSTANCE.getFiniteDifference();

	}

} //FdPackage

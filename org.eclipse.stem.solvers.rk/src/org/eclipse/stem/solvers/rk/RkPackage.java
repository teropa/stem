package org.eclipse.stem.solvers.rk;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.stem.solvers.rk.RkFactory
 * @model kind="package"
 * @generated
 */
public interface RkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rk";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/solvers/rk";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.solvers.rk";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RkPackage eINSTANCE = org.eclipse.stem.solvers.rk.impl.RkPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.solvers.rk.impl.RungeKuttaImpl <em>Runge Kutta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.solvers.rk.impl.RungeKuttaImpl
	 * @see org.eclipse.stem.solvers.rk.impl.RkPackageImpl#getRungeKutta()
	 * @generated
	 */
	int RUNGE_KUTTA = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA__URI = SolverPackage.SOLVER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA__TYPE_URI = SolverPackage.SOLVER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA__DUBLIN_CORE = SolverPackage.SOLVER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA__DECORATORS = SolverPackage.SOLVER__DECORATORS;

	/**
	 * The feature id for the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA__INITIALIZED = SolverPackage.SOLVER__INITIALIZED;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA__RELATIVE_TOLERANCE = SolverPackage.SOLVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Runge Kutta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNGE_KUTTA_FEATURE_COUNT = SolverPackage.SOLVER_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.solvers.rk.RungeKutta <em>Runge Kutta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runge Kutta</em>'.
	 * @see org.eclipse.stem.solvers.rk.RungeKutta
	 * @generated
	 */
	EClass getRungeKutta();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.solvers.rk.RungeKutta#getRelativeTolerance <em>Relative Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Tolerance</em>'.
	 * @see org.eclipse.stem.solvers.rk.RungeKutta#getRelativeTolerance()
	 * @see #getRungeKutta()
	 * @generated
	 */
	EAttribute getRungeKutta_RelativeTolerance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RkFactory getRkFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.solvers.rk.impl.RungeKuttaImpl <em>Runge Kutta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.solvers.rk.impl.RungeKuttaImpl
		 * @see org.eclipse.stem.solvers.rk.impl.RkPackageImpl#getRungeKutta()
		 * @generated
		 */
		EClass RUNGE_KUTTA = eINSTANCE.getRungeKutta();

		/**
		 * The meta object literal for the '<em><b>Relative Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNGE_KUTTA__RELATIVE_TOLERANCE = eINSTANCE.getRungeKutta_RelativeTolerance();

	}

} //RkPackage

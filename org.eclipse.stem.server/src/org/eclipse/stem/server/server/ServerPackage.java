/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.server.server;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.stem.server.server.ServerFactory
 * @model kind="package"
 * @generated
 */
public interface ServerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "server";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/server.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.server";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServerPackage eINSTANCE = org.eclipse.stem.server.server.impl.ServerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.server.server.impl.SimulationsImpl <em>Simulations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.server.server.impl.SimulationsImpl
	 * @see org.eclipse.stem.server.server.impl.ServerPackageImpl#getSimulations()
	 * @generated
	 */
	int SIMULATIONS = 0;

	/**
	 * The feature id for the '<em><b>Scenarios</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATIONS__SCENARIOS = 0;

	/**
	 * The number of structural features of the '<em>Simulations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATIONS_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.server.server.Simulations <em>Simulations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulations</em>'.
	 * @see org.eclipse.stem.server.server.Simulations
	 * @generated
	 */
	EClass getSimulations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.server.server.Simulations#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scenarios</em>'.
	 * @see org.eclipse.stem.server.server.Simulations#getScenarios()
	 * @see #getSimulations()
	 * @generated
	 */
	EReference getSimulations_Scenarios();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServerFactory getServerFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.server.server.impl.SimulationsImpl <em>Simulations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.server.server.impl.SimulationsImpl
		 * @see org.eclipse.stem.server.server.impl.ServerPackageImpl#getSimulations()
		 * @generated
		 */
		EClass SIMULATIONS = eINSTANCE.getSimulations();

		/**
		 * The meta object literal for the '<em><b>Scenarios</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATIONS__SCENARIOS = eINSTANCE.getSimulations_Scenarios();

	}

} //ServerPackage

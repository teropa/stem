/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.simulation;

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
 * @see org.eclipse.stem.core.simulation.SimulationFactory
 * @model kind="package"
 * @generated
 */
public interface SimulationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simulation"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/simulation.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.simulation"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulationPackage eINSTANCE = org.eclipse.stem.core.simulation.impl.SimulationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.simulation.impl.SimulationDataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.simulation.impl.SimulationDataImpl
	 * @see org.eclipse.stem.core.simulation.impl.SimulationPackageImpl#getSimulationData()
	 * @generated
	 */
	int SIMULATION_DATA = 0;

	/**
	 * The feature id for the '<em><b>Current Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DATA__CURRENT_TIME = 0;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_DATA_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.simulation.SimulationData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see org.eclipse.stem.core.simulation.SimulationData
	 * @generated
	 */
	EClass getSimulationData();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.simulation.SimulationData#getCurrentTime <em>Current Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Time</em>'.
	 * @see org.eclipse.stem.core.simulation.SimulationData#getCurrentTime()
	 * @see #getSimulationData()
	 * @generated
	 */
	EReference getSimulationData_CurrentTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulationFactory getSimulationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.simulation.impl.SimulationDataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.simulation.impl.SimulationDataImpl
		 * @see org.eclipse.stem.core.simulation.impl.SimulationPackageImpl#getSimulationData()
		 * @generated
		 */
		EClass SIMULATION_DATA = eINSTANCE.getSimulationData();

		/**
		 * The meta object literal for the '<em><b>Current Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_DATA__CURRENT_TIME = eINSTANCE.getSimulationData_CurrentTime();

	}

} //SimulationPackage

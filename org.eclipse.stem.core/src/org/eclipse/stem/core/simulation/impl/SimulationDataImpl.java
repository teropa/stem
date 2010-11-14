/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.simulation.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.core.simulation.SimulationData;
import org.eclipse.stem.core.simulation.SimulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.simulation.impl.SimulationDataImpl#getCurrentTime <em>Current Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationDataImpl extends CDOObjectImpl implements SimulationData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationPackage.Literals.SIMULATION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getCurrentTime() {
		return (STEMTime)eDynamicGet(SimulationPackage.SIMULATION_DATA__CURRENT_TIME, SimulationPackage.Literals.SIMULATION_DATA__CURRENT_TIME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetCurrentTime() {
		return (STEMTime)eDynamicGet(SimulationPackage.SIMULATION_DATA__CURRENT_TIME, SimulationPackage.Literals.SIMULATION_DATA__CURRENT_TIME, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTime(STEMTime newCurrentTime) {
		eDynamicSet(SimulationPackage.SIMULATION_DATA__CURRENT_TIME, SimulationPackage.Literals.SIMULATION_DATA__CURRENT_TIME, newCurrentTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationPackage.SIMULATION_DATA__CURRENT_TIME:
				if (resolve) return getCurrentTime();
				return basicGetCurrentTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulationPackage.SIMULATION_DATA__CURRENT_TIME:
				setCurrentTime((STEMTime)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimulationPackage.SIMULATION_DATA__CURRENT_TIME:
				setCurrentTime((STEMTime)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimulationPackage.SIMULATION_DATA__CURRENT_TIME:
				return basicGetCurrentTime() != null;
		}
		return super.eIsSet(featureID);
	}

} //SimulationDataImpl

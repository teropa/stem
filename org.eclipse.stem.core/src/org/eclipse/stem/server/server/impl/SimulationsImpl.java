/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.server.server.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.stem.core.scenario.Scenario;

import org.eclipse.stem.server.server.ServerPackage;
import org.eclipse.stem.server.server.Simulations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.server.server.impl.SimulationsImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationsImpl extends CDOObjectImpl implements Simulations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerPackage.Literals.SIMULATIONS;
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
	@SuppressWarnings("unchecked")
	public EList<Scenario> getScenarios() {
		return (EList<Scenario>)eDynamicGet(ServerPackage.SIMULATIONS__SCENARIOS, ServerPackage.Literals.SIMULATIONS__SCENARIOS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServerPackage.SIMULATIONS__SCENARIOS:
				return getScenarios();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServerPackage.SIMULATIONS__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends Scenario>)newValue);
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
			case ServerPackage.SIMULATIONS__SCENARIOS:
				getScenarios().clear();
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
			case ServerPackage.SIMULATIONS__SCENARIOS:
				return !getScenarios().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimulationsImpl

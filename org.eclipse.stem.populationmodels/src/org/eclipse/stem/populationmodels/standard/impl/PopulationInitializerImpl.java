/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;

import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl#getTargetISOKey <em>Target ISO Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopulationInitializerImpl extends NodeDecoratorImpl implements PopulationInitializer {
	/**
	 * The default value of the '{@link #getTargetISOKey() <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetISOKey()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ISO_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetISOKey() <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetISOKey()
	 * @generated
	 * @ordered
	 */
	protected String targetISOKey = TARGET_ISO_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationInitializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.POPULATION_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetISOKey() {
		return targetISOKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetISOKey(String newTargetISOKey) {
		String oldTargetISOKey = targetISOKey;
		targetISOKey = newTargetISOKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY, oldTargetISOKey, targetISOKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				return getTargetISOKey();
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
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				setTargetISOKey((String)newValue);
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
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				setTargetISOKey(TARGET_ISO_KEY_EDEFAULT);
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
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				return TARGET_ISO_KEY_EDEFAULT == null ? targetISOKey != null : !TARGET_ISO_KEY_EDEFAULT.equals(targetISOKey);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (targetISOKey: ");
		result.append(targetISOKey);
		result.append(')');
		return result.toString();
	}

} //PopulationInitializerImpl

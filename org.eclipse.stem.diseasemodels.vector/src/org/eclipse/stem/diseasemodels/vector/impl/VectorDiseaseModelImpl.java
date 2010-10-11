/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.vector.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl;

import org.eclipse.stem.diseasemodels.vector.VectorDiseaseModel;
import org.eclipse.stem.diseasemodels.vector.VectorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.vector.impl.VectorDiseaseModelImpl#getVectorPopulationIdentifier <em>Vector Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VectorDiseaseModelImpl extends StandardDiseaseModelImpl implements VectorDiseaseModel {
	/**
	 * The default value of the '{@link #getVectorPopulationIdentifier() <em>Vector Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVectorPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String VECTOR_POPULATION_IDENTIFIER_EDEFAULT = "anopheles";

	/**
	 * The cached value of the '{@link #getVectorPopulationIdentifier() <em>Vector Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVectorPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String vectorPopulationIdentifier = VECTOR_POPULATION_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VectorDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VectorPackage.Literals.VECTOR_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVectorPopulationIdentifier() {
		return vectorPopulationIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVectorPopulationIdentifier(String newVectorPopulationIdentifier) {
		String oldVectorPopulationIdentifier = vectorPopulationIdentifier;
		vectorPopulationIdentifier = newVectorPopulationIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VectorPackage.VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER, oldVectorPopulationIdentifier, vectorPopulationIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VectorPackage.VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER:
				return getVectorPopulationIdentifier();
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
			case VectorPackage.VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER:
				setVectorPopulationIdentifier((String)newValue);
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
			case VectorPackage.VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER:
				setVectorPopulationIdentifier(VECTOR_POPULATION_IDENTIFIER_EDEFAULT);
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
			case VectorPackage.VECTOR_DISEASE_MODEL__VECTOR_POPULATION_IDENTIFIER:
				return VECTOR_POPULATION_IDENTIFIER_EDEFAULT == null ? vectorPopulationIdentifier != null : !VECTOR_POPULATION_IDENTIFIER_EDEFAULT.equals(vectorPopulationIdentifier);
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
		result.append(" (vectorPopulationIdentifier: ");
		result.append(vectorPopulationIdentifier);
		result.append(')');
		return result.toString();
	}

} //VectorDiseaseModelImpl

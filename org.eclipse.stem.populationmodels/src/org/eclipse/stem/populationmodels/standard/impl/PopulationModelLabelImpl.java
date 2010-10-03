package org.eclipse.stem.populationmodels.standard.impl;

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


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl#getPopulationLabel <em>Population Label</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopulationModelLabelImpl extends DynamicNodeLabelImpl implements PopulationModelLabel {
	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationModelLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.POPULATION_MODEL_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabel getPopulationLabel() {
		return (PopulationLabel)eDynamicGet(StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL, StandardPackage.Literals.POPULATION_MODEL_LABEL__POPULATION_LABEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabel basicGetPopulationLabel() {
		return (PopulationLabel)eDynamicGet(StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL, StandardPackage.Literals.POPULATION_MODEL_LABEL__POPULATION_LABEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationLabel(PopulationLabel newPopulationLabel) {
		eDynamicSet(StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL, StandardPackage.Literals.POPULATION_MODEL_LABEL__POPULATION_LABEL, newPopulationLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return (String)eDynamicGet(StandardPackage.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER, StandardPackage.Literals.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		eDynamicSet(StandardPackage.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER, StandardPackage.Literals.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER, newPopulationIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL:
				if (resolve) return getPopulationLabel();
				return basicGetPopulationLabel();
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
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
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL:
				setPopulationLabel((PopulationLabel)newValue);
				return;
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
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
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL:
				setPopulationLabel((PopulationLabel)null);
				return;
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
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
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL:
				return basicGetPopulationLabel() != null;
			case StandardPackage.POPULATION_MODEL_LABEL__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? getPopulationIdentifier() != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(getPopulationIdentifier());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(
				getPopulationIdentifier() == null ? "null" : getPopulationIdentifier());
		result.append(" [");
		result.append(Math.floor(((StandardPopulationModelLabelValue)getCurrentValue()).getCount()));
		result.append("]");
		return result.toString();
	}

} //PopulationModelLabelImpl

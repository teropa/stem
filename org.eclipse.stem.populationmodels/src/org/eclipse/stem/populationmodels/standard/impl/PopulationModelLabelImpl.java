/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl;

import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelLabelImpl#getPopulationLabel <em>Population Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopulationModelLabelImpl extends DynamicNodeLabelImpl implements PopulationModelLabel {
	/**
	 * The cached value of the '{@link #getPopulationLabel() <em>Population Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationLabel()
	 * @generated
	 * @ordered
	 */
	protected PopulationLabel populationLabel;

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
		if (populationLabel != null && populationLabel.eIsProxy()) {
			InternalEObject oldPopulationLabel = (InternalEObject)populationLabel;
			populationLabel = (PopulationLabel)eResolveProxy(oldPopulationLabel);
			if (populationLabel != oldPopulationLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL, oldPopulationLabel, populationLabel));
			}
		}
		return populationLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabel basicGetPopulationLabel() {
		return populationLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationLabel(PopulationLabel newPopulationLabel) {
		PopulationLabel oldPopulationLabel = populationLabel;
		populationLabel = newPopulationLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_MODEL_LABEL__POPULATION_LABEL, oldPopulationLabel, populationLabel));
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
				return populationLabel != null;
		}
		return super.eIsSet(featureID);
	}

} //PopulationModelLabelImpl

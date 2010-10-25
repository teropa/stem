package org.eclipse.stem.diseasemodels.standard.impl;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl;
//import org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl#getPopulationLabel <em>Population Label</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl#getDiseaseModelState <em>Disease Model State</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelImpl#getPopulationModelLabel <em>Population Model Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DiseaseModelLabelImpl extends DynamicNodeLabelImpl
		implements DiseaseModelLabel {
	/**
	 * The cached value of the '{@link #getPopulationLabel() <em>Population Label</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPopulationLabel()
	 * @generated
	 * @ordered
	 */
	protected PopulationLabel populationLabel;

	/**
	 * The cached value of the '{@link #getDiseaseModelState() <em>Disease Model State</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDiseaseModelState()
	 * @generated
	 * @ordered
	 */
	protected DiseaseModelState diseaseModelState;

	/**
	 * The cached value of the '{@link #getPopulationModelLabel() <em>Population Model Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationModelLabel()
	 * @generated
	 * @ordered
	 */
	protected PopulationModelLabel populationModelLabel;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiseaseModelLabelImpl() {
		super();
	}

	public double getDiseaseDeaths() {
		return getCurrentDiseaseModelLabelValue().getDiseaseDeaths();
	} // getDiseaseDeaths

	public void setDiseaseDeaths(final double d) {
		getCurrentDiseaseModelLabelValue().setDiseaseDeaths(d);
	} // setDiseaseDeaths


	public double getNextDiseaseDeaths() {
		return getNextDiseaseModelLabelValue().getDiseaseDeaths();
	} // getNextDiseaseDeaths

	public void setNextDiseaseDeaths(final double d) {
		getNextDiseaseModelLabelValue().setDiseaseDeaths(d);
	} // setNextDiseaseDeaths

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.DISEASE_MODEL_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabel getPopulationLabel() {
		if (populationLabel != null && populationLabel.eIsProxy()) {
			InternalEObject oldPopulationLabel = (InternalEObject)populationLabel;
			populationLabel = (PopulationLabel)eResolveProxy(oldPopulationLabel);
			if (populationLabel != oldPopulationLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.DISEASE_MODEL_LABEL__POPULATION_LABEL, oldPopulationLabel, populationLabel));
			}
		}
		return populationLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabel basicGetPopulationLabel() {
		return populationLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newPopulationLabel
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationLabel(PopulationLabel newPopulationLabel) {
		PopulationLabel oldPopulationLabel = populationLabel;
		populationLabel = newPopulationLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL_LABEL__POPULATION_LABEL, oldPopulationLabel, populationLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiseaseModelState getDiseaseModelState() {
		return diseaseModelState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newDiseaseModelState
	 * @param msgs
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiseaseModelState(DiseaseModelState newDiseaseModelState, NotificationChain msgs) {
		DiseaseModelState oldDiseaseModelState = diseaseModelState;
		diseaseModelState = newDiseaseModelState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE, oldDiseaseModelState, newDiseaseModelState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newDiseaseModelState
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiseaseModelState(DiseaseModelState newDiseaseModelState) {
		if (newDiseaseModelState != diseaseModelState) {
			NotificationChain msgs = null;
			if (diseaseModelState != null)
				msgs = ((InternalEObject)diseaseModelState).eInverseRemove(this, StandardPackage.DISEASE_MODEL_STATE__LABEL, DiseaseModelState.class, msgs);
			if (newDiseaseModelState != null)
				msgs = ((InternalEObject)newDiseaseModelState).eInverseAdd(this, StandardPackage.DISEASE_MODEL_STATE__LABEL, DiseaseModelState.class, msgs);
			msgs = basicSetDiseaseModelState(newDiseaseModelState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE, newDiseaseModelState, newDiseaseModelState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabel getPopulationModelLabel() {
		if (populationModelLabel != null && populationModelLabel.eIsProxy()) {
			InternalEObject oldPopulationModelLabel = (InternalEObject)populationModelLabel;
			populationModelLabel = (PopulationModelLabel)eResolveProxy(oldPopulationModelLabel);
			if (populationModelLabel != oldPopulationModelLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL, oldPopulationModelLabel, populationModelLabel));
			}
		}
		return populationModelLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabel basicGetPopulationModelLabel() {
		return populationModelLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationModelLabel(PopulationModelLabel newPopulationModelLabel) {
		PopulationModelLabel oldPopulationModelLabel = populationModelLabel;
		populationModelLabel = newPopulationModelLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL, oldPopulationModelLabel, populationModelLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DiseaseModelLabelValue getCurrentDiseaseModelLabelValue() {
		return (DiseaseModelLabelValue)getCurrentValue(); 
	} // getCurrentDiseaseModelLabelValue

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DiseaseModelLabelValue getNextDiseaseModelLabelValue() {
		return (DiseaseModelLabelValue)getNextValue();
	} // getNextDiseaseModelLabelValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param otherEnd
	 * @param featureID
	 * @param msgs
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE:
				if (diseaseModelState != null)
					msgs = ((InternalEObject)diseaseModelState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE, null, msgs);
				return basicSetDiseaseModelState((DiseaseModelState)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param otherEnd
	 * @param featureID
	 * @param msgs
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE:
				return basicSetDiseaseModelState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * Label the node with the disease model label
	 * 
	 * @param dml
	 *            the disease model label
	 *            
	 * @param populationModelLabel
	 * 			  the dynamic population label affected by the disease (e.g. women)
	 * 
	 * @param node
	 *            the node that has the population being affected by the disease
	 */
	public static void labelNode(final DiseaseModelLabel dml,
			final PopulationModelLabel populationModelLabel, final Node node) {
		dml.setPopulationLabel(populationModelLabel.getPopulationLabel());
		dml.setPopulationModelLabel(populationModelLabel);
		node.getLabels().add(dml);
	} // labelNode

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_LABEL:
				if (resolve) return getPopulationLabel();
				return basicGetPopulationLabel();
			case StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE:
				return getDiseaseModelState();
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL:
				if (resolve) return getPopulationModelLabel();
				return basicGetPopulationModelLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param newValue
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_LABEL:
				setPopulationLabel((PopulationLabel)newValue);
				return;
			case StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE:
				setDiseaseModelState((DiseaseModelState)newValue);
				return;
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL:
				setPopulationModelLabel((PopulationModelLabel)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_LABEL:
				setPopulationLabel((PopulationLabel)null);
				return;
			case StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE:
				setDiseaseModelState((DiseaseModelState)null);
				return;
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL:
				setPopulationModelLabel((PopulationModelLabel)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_LABEL:
				return populationLabel != null;
			case StandardPackage.DISEASE_MODEL_LABEL__DISEASE_MODEL_STATE:
				return diseaseModelState != null;
			case StandardPackage.DISEASE_MODEL_LABEL__POPULATION_MODEL_LABEL:
				return populationModelLabel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.DynamicNodeLabelImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue && getDiseaseModelState() != null ? getDiseaseModelState()
				.sane() : true;
		assert retValue;

		return retValue;
	} // sane

} // DiseaseModelLabelImpl

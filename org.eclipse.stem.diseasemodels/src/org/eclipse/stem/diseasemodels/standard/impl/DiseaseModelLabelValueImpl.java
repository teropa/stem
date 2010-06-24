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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.impl.LabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#getDiseaseDeaths <em>Disease Deaths</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#getPopulationCount <em>Population Count</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#getIncidence <em>Incidence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DiseaseModelLabelValueImpl extends LabelValueImpl
		implements DiseaseModelLabelValue {
	/**
	 * The default value of the '{@link #getDiseaseDeaths() <em>Disease Deaths</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDiseaseDeaths()
	 * @generated
	 * @ordered
	 */
	protected static final double DISEASE_DEATHS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDiseaseDeaths() <em>Disease Deaths</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDiseaseDeaths()
	 * @generated
	 * @ordered
	 */
	protected double diseaseDeaths = DISEASE_DEATHS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPopulationCount() <em>Population Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPopulationCount()
	 * @generated
	 * @ordered
	 */
	protected static final double POPULATION_COUNT_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getIncidence() <em>Incidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncidence()
	 * @generated
	 * @ordered
	 */
	protected static final double INCIDENCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIncidence() <em>Incidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncidence()
	 * @generated
	 * @ordered
	 */
	protected double incidence = INCIDENCE_EDEFAULT;

	public static final double ABS_TOLERANCE = 1E-12; // fix hardcoded?
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiseaseModelLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * This is used to create instances for testing purposes.
	 * 
	 * @param births
	 *            the number of births that have occured in the population
	 * @param deaths
	 *            the total number of deaths that have occured in the population
	 * @param diseaseDeaths
	 *            the number of deaths due to the disease that have occured in
	 *            the population
	 * 
	 * <!-- end-user-doc -->
	 */
	protected DiseaseModelLabelValueImpl(final double diseaseDeaths) {
		this.diseaseDeaths = diseaseDeaths;
	} // DiseaseModelLabelValueImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.DISEASE_MODEL_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract double getPopulationCount();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIncidence() {
		return incidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncidence(double newIncidence) {
		double oldIncidence = incidence;
		incidence = newIncidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL_LABEL_VALUE__INCIDENCE, oldIncidence, incidence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public void zeroOutPopulationCount();

	private Map<Node, Double>arrivals;
	private Map<Node, Double>departures;
	/**
	 *
	 * @generated NOT
	 */
	public Map<Node, Double> getArrivals() {
		if(arrivals == null) arrivals = new HashMap<Node, Double>();
		return arrivals;
	}

	/**
	 *
	 * @generated NOT
	 */
	public Map<Node, Double> getDepartures() {
		if(departures == null) departures = new HashMap<Node, Double>();
		return departures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDiseaseDeaths() {
		return diseaseDeaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newDiseaseDeaths
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiseaseDeaths(double newDiseaseDeaths) {
		double oldDiseaseDeaths = diseaseDeaths;
		diseaseDeaths = newDiseaseDeaths;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS, oldDiseaseDeaths, diseaseDeaths));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param value
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DiseaseModelLabelValue set(DiseaseModelLabelValue value) {
		setDiseaseDeaths(value.getDiseaseDeaths());
		setIncidence(value.getIncidence());
		return this;
	} // set

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param value
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public DiseaseModelLabelValue add(DiseaseModelLabelValue value) {
		return this;
	} // add

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param value
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public DiseaseModelLabelValue sub(DiseaseModelLabelValue value) {
		return this;
	} // sub

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DiseaseModelLabelValue scale(double scaleFactor) {
		return this;
	} // scale
	
	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		setDiseaseDeaths(DISEASE_DEATHS_EDEFAULT);
		arrivals = null;
		departures = null;
	} // reset

	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
				
		// disease deaths
		retValue = retValue && diseaseDeaths >= DISEASE_DEATHS_EDEFAULT;
		assert retValue;

		retValue = retValue && diseaseDeaths <= MAX_POPULATION_VALUE;
		assert retValue;
		
		retValue = retValue && !Double.isInfinite(diseaseDeaths);
		assert retValue;
		
		retValue = retValue && !Double.isNaN(diseaseDeaths);
		assert retValue;
		
		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS:
				return getDiseaseDeaths();
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT:
				return getPopulationCount();
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__INCIDENCE:
				return getIncidence();
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
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS:
				setDiseaseDeaths((Double)newValue);
				return;
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__INCIDENCE:
				setIncidence((Double)newValue);
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
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS:
				setDiseaseDeaths(DISEASE_DEATHS_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__INCIDENCE:
				setIncidence(INCIDENCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__DISEASE_DEATHS:
				return diseaseDeaths != DISEASE_DEATHS_EDEFAULT;
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__POPULATION_COUNT:
				return getPopulationCount() != POPULATION_COUNT_EDEFAULT;
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE__INCIDENCE:
				return incidence != INCIDENCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append("(DD: "); //$NON-NLS-1$
		result.append(diseaseDeaths);
		result.append(')');
		return result.toString();
	} // toString

} // DiseaseModelLabelValueImpl

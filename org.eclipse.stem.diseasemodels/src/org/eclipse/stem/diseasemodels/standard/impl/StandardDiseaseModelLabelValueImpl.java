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

import java.text.NumberFormat;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
//import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl#getS <em>S</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StandardDiseaseModelLabelValueImpl extends
		DiseaseModelLabelValueImpl implements StandardDiseaseModelLabelValue {
	
	private static final int NUMBER_OF_FRACTIONAL_DIGITS = 2;

	private static NumberFormat formatter = null;

	/**
	 * @return a number formatter
	 */
	protected static NumberFormat getFormatter() {
		// Is there already a formatter?
		if (formatter == null) {
			// No
			formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(NUMBER_OF_FRACTIONAL_DIGITS);
			formatter.setMinimumFractionDigits(NUMBER_OF_FRACTIONAL_DIGITS);
		}
		return formatter;
	} // getFormatter
	
	
	/**
	 * The default value of the '{@link #getS() <em>S</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getS()
	 * @generated
	 * @ordered
	 */
	protected static final double S_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardDiseaseModelLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * This is used to create instances for testing purposes.
	 * 
	 * @param s
	 *            the number of susceptible population members
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
	public StandardDiseaseModelLabelValueImpl(final double s,
			final double diseaseDeaths) {
		super(diseaseDeaths);
		this.setS(s);
	} // StandardDiseaseModelLabelValueImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_DISEASE_MODEL_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getS() {
		return (Double)eDynamicGet(StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE__S, StandardPackage.Literals.STANDARD_DISEASE_MODEL_LABEL_VALUE__S, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newS
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setS(double newS) {
		eDynamicSet(StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE__S, StandardPackage.Literals.STANDARD_DISEASE_MODEL_LABEL_VALUE__S, newS);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#getPopulationCount()
	 */
	@Override
	public double getPopulationCount() {
		return getS();
	} // getPopulationCount

	@Override
	public void zeroOutPopulationCount() {
		setS(S_EDEFAULT);
	} // zeroOutPopulationCount
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#set(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue)
	 */

	public DiseaseModelLabelValue set(IntegrationLabelValue value) {
		super.set((DiseaseModelLabelValue)value);
		setS(((StandardDiseaseModelLabelValue) value).getS());
		return this;
	} // set

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#add(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue)
	 */

	public DiseaseModelLabelValue add(IntegrationLabelValue value) {
	
		super.add((DiseaseModelLabelValue)value);
		setS(getS() + ((StandardDiseaseModelLabelValue) value).getS());
		setDiseaseDeaths(getDiseaseDeaths() + ((StandardDiseaseModelLabelValue) value).getDiseaseDeaths());
		setIncidence(getIncidence()+((StandardDiseaseModelLabelValue) value).getIncidence());
		return this;
	} // add

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#sub(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue)
	 */

	public DiseaseModelLabelValue sub(IntegrationLabelValue value) {
		super.sub((DiseaseModelLabelValue)value);
		setS(getS() - ((StandardDiseaseModelLabelValue) value).getS());
		setDiseaseDeaths(getDiseaseDeaths() - ((StandardDiseaseModelLabelValue) value).getDiseaseDeaths());
		setIncidence(getIncidence()-((StandardDiseaseModelLabelValue) value).getIncidence());

		return this;
	} // sub
	
	@Override
	public DiseaseModelLabelValue scale(double scaleFactor) {
		super.scale(scaleFactor);
		setS(getS() *scaleFactor);
		setDiseaseDeaths(getDiseaseDeaths()*scaleFactor);
		setIncidence(getIncidence()*scaleFactor);
		return this;
	} // scale
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		setS(S_EDEFAULT);
	} // reset

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue && getS() >= S_EDEFAULT;
		assert retValue;

		retValue = retValue && getS() <= MAX_POPULATION_VALUE;
		assert retValue;		
		
		retValue = retValue && !Double.isInfinite(getS());
		assert retValue;
		
		retValue = retValue && !Double.isNaN(getS());
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
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE__S:
				return getS();
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
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE__S:
				setS((Double)newValue);
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
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE__S:
				setS(S_EDEFAULT);
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
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE__S:
				return getS() != S_EDEFAULT;
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

		StringBuffer result = new StringBuffer();
		result.append(" (s: "); //$NON-NLS-1$
		result.append(getFormatter().format(getS()));
		result.append(')');
		return result.toString();
	} // toString

} // StandardDiseaseModelLabelValueImpl

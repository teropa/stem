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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SI Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl#getI <em>I</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SILabelValueImpl extends StandardDiseaseModelLabelValueImpl
		implements SILabelValue {
	/**
	 * The default value of the '{@link #getI() <em>I</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected static final double I_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getI() <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected double i = I_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SILabelValueImpl() {
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
	 * @param iR
	 *            the number of recovering infectious population members
	 * 
	 * @param iF
	 *            the number of fatally infectious population members
	 * 
	 * @param incidence
	 *            the new incidence from the interaction term in the compartment model
	 * 
	 * @param births
	 *            the number of births that have occurred in the population
	 * @param deaths
	 *            the total number of deaths that have occurred in the population
	 * @param diseaseDeaths
	 *            the number of deaths due to the disease that have occurred in
	 *            the population
	 * 
	 * <!-- end-user-doc -->
	 */
	public SILabelValueImpl(final double s, final double i, final double incidence,
			final double diseaseDeaths) {
		super(s, diseaseDeaths);
		this.setI(i);
		this.setIncidence(incidence);
	} // SILabelValueImpl

	

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * This is used to create instances for testing purposes.
	 * 
	 * @param s
	 *            the number of susceptible population members
	 * 
	 * @param iR
	 *            the number of recovering infectious population members
	 * 
	 * @param iF
	 *            the number of fatally infectious population members
	 *            
	 * @param births
	 *            the number of births that have occurred in the population
	 * @param deaths
	 *            the total number of deaths that have occurred in the population
	 * @param diseaseDeaths
	 *            the number of deaths due to the disease that have occurred in
	 *            the population
	 * 
	 * <!-- end-user-doc -->
	 */
	public SILabelValueImpl(final double s, final double i, 
			final double diseaseDeaths) {
		super(s, diseaseDeaths);
		this.setIncidence(0.0);
		this.setI(i);
	} // SILabelValueImpl

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SI_LABEL_VALUE;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getI() {
		return i;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setI(double newI) {
		double oldI = i;
		i = newI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SI_LABEL_VALUE__I, oldI, i));
	}

	//	/**
//	 * <!-- begin-user-doc -->
//	 * 
//	 * @return
//	 * 
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public SILabelValue rotateLeft() {
//		final double tempS = getS();
//		setS(getI());
//		setI(tempS);
//		return this;
//	} // rotateLeft

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl#getPopulationCount()
	 */
	@Override
	public double getPopulationCount() {
		return super.getPopulationCount() + getI();
	} // getPopulationCount

	
	@Override
	public void zeroOutPopulationCount() {
		super.zeroOutPopulationCount();
		setI(I_EDEFAULT);
	} // zeroOutPopulationCount
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#set(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue)
	 */

	public DiseaseModelLabelValue set(IntegrationLabelValue value) {
		super.set(value);
		setI(((SILabelValue) value).getI());
		return this;
	} // set

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#add(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue)
	 */

	public DiseaseModelLabelValue add(IntegrationLabelValue value) {
		super.add(value);
		setI(getI() + ((SILabelValue) value).getI());
		return this;
	} // add

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelLabelValueImpl#sub(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue)
	 */

	public DiseaseModelLabelValue sub(IntegrationLabelValue value) {
		super.sub(value);
		setI(getI() - ((SILabelValue) value).getI());
		return this;
	} // sub

	

	public DiseaseModelLabelValue scale(double scaleFactor) {
		super.scale(scaleFactor);
		setI(getI() *scaleFactor);
		return this;
	} // scale
	
	public DiseaseModelLabelValue add(double addition) {
		setI(getI() +addition);
		setS(getS() +addition);
		setDiseaseDeaths(getDiseaseDeaths() + addition);
		return this;
	} // scale

	public DiseaseModelLabelValue abs() {
		setI(Math.abs(getI()));
		setS(Math.abs(getS()));
		setDiseaseDeaths(Math.abs(getDiseaseDeaths()));
		return this;
	} // scale

	public IntegrationLabelValue divide(IntegrationLabelValue d) {
		SILabelValue _scale = (SILabelValue)d;
		double sScaled = Math.abs(getS()) / Math.abs(_scale.getS());
		double iScaled = Math.abs(getI()) / Math.abs(_scale.getI());
		double ddScaled = Math.abs(getDiseaseDeaths()) / Math.abs(_scale.getDiseaseDeaths());

		setS(sScaled);
		setI(iScaled);
		setDiseaseDeaths(ddScaled);
		return this;
	}
	
	public double max() {
		if (getS() > getI() && getS() > getDiseaseDeaths()) return getS();
		else if(getI()> getDiseaseDeaths()) return getI();
		else return getDiseaseDeaths();
	}
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		setI(I_EDEFAULT);
	} // reset

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
			case StandardPackage.SI_LABEL_VALUE__I:
				return getI();
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
			case StandardPackage.SI_LABEL_VALUE__I:
				setI((Double)newValue);
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
			case StandardPackage.SI_LABEL_VALUE__I:
				setI(I_EDEFAULT);
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
			case StandardPackage.SI_LABEL_VALUE__I:
				return i != I_EDEFAULT;
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
		result.append("s:"); //$NON-NLS-1$
		result.append(getFormatter().format(getS()));
		result.append(", i:"); //$NON-NLS-1$
		result.append(getFormatter().format(getI()));
		result.append(", DD:"); //$NON-NLS-1$
		result.append(getFormatter().format(getDiseaseDeaths()));
		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelLabelValueImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
	
		retValue = retValue && getI() >= I_EDEFAULT;
		assert retValue;
	
		retValue = retValue && getI() <= MAX_POPULATION_VALUE;
		assert retValue;
	
		retValue = retValue && !Double.isInfinite(getI());
		assert retValue;
		
		retValue = retValue && !Double.isNaN(getI());
		assert retValue;
		
		return retValue;
	} // sane

	/**
	 * Adjust when a delta value is bad, e.g. forces the 
	 * target to go negative in any state.
	 * 
	 * @return boolean 
	 */
	public boolean adjustDelta(IntegrationLabelValue target) {
		SILabelValue siValue = (SILabelValue)target;
		boolean adjusted = false;
		double newS = this.getS() + siValue.getS();
		double newI = this.getI() + siValue.getI();
		double newDD = this.getDiseaseDeaths() + siValue.getDiseaseDeaths();
		
		double factor = 1.0;
		if(newS < newI && newS < newDD && newS < 0.0) {
			// Scale using S
			adjusted = true;
			factor = -siValue.getS()/this.getS();
		} else if(newI < newDD && newI < 0.0) {
			// Scale using R
			adjusted = true;
			factor = -siValue.getI()/this.getI();
		} else if (newDD < 0) {
			// Scale using R
			adjusted = true;
			factor = -siValue.getDiseaseDeaths()/this.getDiseaseDeaths();
		}
		if(adjusted) this.scale(factor);
		// Due to precision limitations it is still possible the number if tiny negative. Adjust if necessary
		newS = this.getS() + siValue.getS();
		newI = this.getI() + siValue.getI();
		newDD = this.getDiseaseDeaths() + siValue.getDiseaseDeaths();
		
		if(newS<0)
			this.setS(-siValue.getS());
		if(newI<0)
			this.setI(-siValue.getI());
		if(newDD<0)
			this.setDiseaseDeaths(-siValue.getDiseaseDeaths());
		
		return adjusted;
	}

} // SILabelValueImpl

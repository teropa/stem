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
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SI Infector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIInfectorImpl#getInfectiousCount <em>Infectious Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIInfectorImpl extends StandardInfectorImpl implements SIInfector {
	/**
	 * The default value of the '{@link #getInfectiousCount() <em>Infectious Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInfectiousCount()
	 * @generated
	 * @ordered
	 */
	protected static final double INFECTIOUS_COUNT_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getInfectiousCount() <em>Infectious Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInfectiousCount()
	 * @generated
	 * @ordered
	 */
	protected double infectiousCount = INFECTIOUS_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SIInfectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SI_INFECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInfectiousCount() {
		return infectiousCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newInfectiousCount
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfectiousCount(double newInfectiousCount) {
		double oldInfectiousCount = infectiousCount;
		infectiousCount = newInfectiousCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SI_INFECTOR__INFECTIOUS_COUNT, oldInfectiousCount, infectiousCount));
	}

	/**
	 * @param diseaseModelLabel
	 *            the disease model label to have its infectious value
	 *            initialized
	 */
	@Override
	protected void doInitialization(final DiseaseModelLabel diseaseModelLabel) {
		final IntegrationLabel siLabel = (IntegrationLabel) diseaseModelLabel;
		final SILabelValue siValue = (SILabelValue)siLabel.getCurrentValue();
		double newSValue = siValue.getS() - getInfectiousCount();
		// TODO log infectious count greater than Susceptible population
		final double additionalInfectious = newSValue < 0 ? siValue.getS()
				: getInfectiousCount();
		
		final double newIValue = siValue.getI() + additionalInfectious;
		
		newSValue = newSValue < 0 ? 0 : newSValue;
		((SILabelValue)siLabel.getCurrentValue()).setS(newSValue);
		((SILabelValue)siLabel.getNextValue()).setS(newSValue);
		(((SILabelValue)siLabel.getProbeValue())).setS(newSValue);
		// We could divide them between the two infectious states, 
		// but this should be okay
		((SILabelValue)siLabel.getCurrentValue()).setI(newIValue);
		((SILabelValue)siLabel.getNextValue()).setI(newIValue);
		((SILabelValue)siLabel.getProbeValue()).setI(newIValue);
	} // doInitialization

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
			case StandardPackage.SI_INFECTOR__INFECTIOUS_COUNT:
				return getInfectiousCount();
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
			case StandardPackage.SI_INFECTOR__INFECTIOUS_COUNT:
				setInfectiousCount((Double)newValue);
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
			case StandardPackage.SI_INFECTOR__INFECTIOUS_COUNT:
				setInfectiousCount(INFECTIOUS_COUNT_EDEFAULT);
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
			case StandardPackage.SI_INFECTOR__INFECTIOUS_COUNT:
				return infectiousCount != INFECTIOUS_COUNT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (infectiousCount: "); //$NON-NLS-1$
		result.append(infectiousCount);
		result.append(')');
		return result.toString();
	}

} // SIInfectorImpl

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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.SimpleDataExchangeLabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SEIR Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getDeltaValue <em>Delta Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getProbeValue <em>Probe Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getTempValue <em>Temp Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelImpl#getErrorScale <em>Error Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SEIRLabelImpl extends StandardDiseaseModelLabelImpl implements SEIRLabel {
	/**
	 * The cached value of the '{@link #getDeltaValue() <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltaValue()
	 * @generated
	 * @ordered
	 */
	protected SEIRLabelValue deltaValue;
	/**
	 * The cached value of the '{@link #getProbeValue() <em>Probe Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeValue()
	 * @generated
	 * @ordered
	 */
	protected SEIRLabelValue probeValue;
	/**
	 * The cached value of the '{@link #getTempValue() <em>Temp Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempValue()
	 * @generated
	 * @ordered
	 */
	protected SEIRLabelValue tempValue;
	/**
	 * The cached value of the '{@link #getOriginalValue() <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected SEIRLabelValue originalValue;
	/**
	 * The cached value of the '{@link #getErrorScale() <em>Error Scale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorScale()
	 * @generated
	 * @ordered
	 */
	protected SEIRLabelValue errorScale;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SEIRLabelImpl() {
		super();
		setTypeURI(URI_TYPE_SEIR_LABEL);
		setCurrentValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setNextValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setOriginalValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setTempValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setProbeValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setErrorScale(StandardFactory.eINSTANCE.createSEIRLabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createSEIRLabelValue());
	} // SEIRLabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SEIR_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getDeltaValue() {
		if (deltaValue != null && deltaValue.eIsProxy()) {
			InternalEObject oldDeltaValue = (InternalEObject)deltaValue;
			deltaValue = (SEIRLabelValue)eResolveProxy(oldDeltaValue);
			if (deltaValue != oldDeltaValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SEIR_LABEL__DELTA_VALUE, oldDeltaValue, deltaValue));
			}
		}
		return deltaValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetDeltaValue() {
		return deltaValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaValue(SEIRLabelValue newDeltaValue) {
		SEIRLabelValue oldDeltaValue = deltaValue;
		deltaValue = newDeltaValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEIR_LABEL__DELTA_VALUE, oldDeltaValue, deltaValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getProbeValue() {
		if (probeValue != null && probeValue.eIsProxy()) {
			InternalEObject oldProbeValue = (InternalEObject)probeValue;
			probeValue = (SEIRLabelValue)eResolveProxy(oldProbeValue);
			if (probeValue != oldProbeValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SEIR_LABEL__PROBE_VALUE, oldProbeValue, probeValue));
			}
		}
		return probeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetProbeValue() {
		return probeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeValue(SEIRLabelValue newProbeValue) {
		SEIRLabelValue oldProbeValue = probeValue;
		probeValue = newProbeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEIR_LABEL__PROBE_VALUE, oldProbeValue, probeValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getTempValue() {
		if (tempValue != null && tempValue.eIsProxy()) {
			InternalEObject oldTempValue = (InternalEObject)tempValue;
			tempValue = (SEIRLabelValue)eResolveProxy(oldTempValue);
			if (tempValue != oldTempValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SEIR_LABEL__TEMP_VALUE, oldTempValue, tempValue));
			}
		}
		return tempValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetTempValue() {
		return tempValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempValue(SEIRLabelValue newTempValue) {
		SEIRLabelValue oldTempValue = tempValue;
		tempValue = newTempValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEIR_LABEL__TEMP_VALUE, oldTempValue, tempValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getOriginalValue() {
		if (originalValue != null && originalValue.eIsProxy()) {
			InternalEObject oldOriginalValue = (InternalEObject)originalValue;
			originalValue = (SEIRLabelValue)eResolveProxy(oldOriginalValue);
			if (originalValue != oldOriginalValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SEIR_LABEL__ORIGINAL_VALUE, oldOriginalValue, originalValue));
			}
		}
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetOriginalValue() {
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(SEIRLabelValue newOriginalValue) {
		SEIRLabelValue oldOriginalValue = originalValue;
		originalValue = newOriginalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEIR_LABEL__ORIGINAL_VALUE, oldOriginalValue, originalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getErrorScale() {
		if (errorScale != null && errorScale.eIsProxy()) {
			InternalEObject oldErrorScale = (InternalEObject)errorScale;
			errorScale = (SEIRLabelValue)eResolveProxy(oldErrorScale);
			if (errorScale != oldErrorScale) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SEIR_LABEL__ERROR_SCALE, oldErrorScale, errorScale));
			}
		}
		return errorScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetErrorScale() {
		return errorScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorScale(SEIRLabelValue newErrorScale) {
		SEIRLabelValue oldErrorScale = errorScale;
		errorScale = newErrorScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEIR_LABEL__ERROR_SCALE, oldErrorScale, errorScale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SEIRLabelValue getCurrentSEIRValue() {
		return (SEIRLabelValue) getCurrentValue();
	} // getCurrentSEIRValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SEIRLabelValue getNextSEIRValue() {
		return (SEIRLabelValue) getNextValue();
	} // getNextSEIRValue

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#setE(double)
	 */
	public void setE(double e) {
		getCurrentSEIRValue().setE(e);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getE()
	 */
	public double getE() {
		return getCurrentSEIRValue().getE();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#getNextE()
	 */
	public double getNextE() {
		return getNextSEIRValue().getE();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel#setNextE(double)
	 */
	public void setNextE(double e) {
		getNextSEIRValue().setE(e);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getR()
	 */
	public double getR() {
		return getCurrentSEIRValue().getR();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setR(double)
	 */
	public void setR(double r) {
		getCurrentSEIRValue().setR(r);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextR()
	 */
	public double getNextR() {
		return getNextSEIRValue().getR();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setNextR(double)
	 */
	public void setNextR(double r) {
		getNextSEIRValue().setR(r);
	} // setNextR

	/**
	 * @return set the number number of infectious population members
	 */
	public void setNextI(double i) {
		((SILabelValue)getNextValue()).setI(i);
	}

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getI()
	 */
	public double getI() {
		return getCurrentSEIRValue().getI();
	} // getI

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#setI()
	 */
	public void setI(double i) {
		getCurrentSEIRValue().setI(i);
	} // getI

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getNextI()
	 */
	public double getNextI() {
		return getNextSEIRValue().getI();
	} // getNextI
	
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
			case StandardPackage.SEIR_LABEL__DELTA_VALUE:
				if (resolve) return getDeltaValue();
				return basicGetDeltaValue();
			case StandardPackage.SEIR_LABEL__PROBE_VALUE:
				if (resolve) return getProbeValue();
				return basicGetProbeValue();
			case StandardPackage.SEIR_LABEL__TEMP_VALUE:
				if (resolve) return getTempValue();
				return basicGetTempValue();
			case StandardPackage.SEIR_LABEL__ORIGINAL_VALUE:
				if (resolve) return getOriginalValue();
				return basicGetOriginalValue();
			case StandardPackage.SEIR_LABEL__ERROR_SCALE:
				if (resolve) return getErrorScale();
				return basicGetErrorScale();
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
			case StandardPackage.SEIR_LABEL__DELTA_VALUE:
				setDeltaValue((SEIRLabelValue)newValue);
				return;
			case StandardPackage.SEIR_LABEL__PROBE_VALUE:
				setProbeValue((SEIRLabelValue)newValue);
				return;
			case StandardPackage.SEIR_LABEL__TEMP_VALUE:
				setTempValue((SEIRLabelValue)newValue);
				return;
			case StandardPackage.SEIR_LABEL__ORIGINAL_VALUE:
				setOriginalValue((SEIRLabelValue)newValue);
				return;
			case StandardPackage.SEIR_LABEL__ERROR_SCALE:
				setErrorScale((SEIRLabelValue)newValue);
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
			case StandardPackage.SEIR_LABEL__DELTA_VALUE:
				setDeltaValue((SEIRLabelValue)null);
				return;
			case StandardPackage.SEIR_LABEL__PROBE_VALUE:
				setProbeValue((SEIRLabelValue)null);
				return;
			case StandardPackage.SEIR_LABEL__TEMP_VALUE:
				setTempValue((SEIRLabelValue)null);
				return;
			case StandardPackage.SEIR_LABEL__ORIGINAL_VALUE:
				setOriginalValue((SEIRLabelValue)null);
				return;
			case StandardPackage.SEIR_LABEL__ERROR_SCALE:
				setErrorScale((SEIRLabelValue)null);
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
			case StandardPackage.SEIR_LABEL__DELTA_VALUE:
				return deltaValue != null;
			case StandardPackage.SEIR_LABEL__PROBE_VALUE:
				return probeValue != null;
			case StandardPackage.SEIR_LABEL__TEMP_VALUE:
				return tempValue != null;
			case StandardPackage.SEIR_LABEL__ORIGINAL_VALUE:
				return originalValue != null;
			case StandardPackage.SEIR_LABEL__ERROR_SCALE:
				return errorScale != null;
		}
		return super.eIsSet(featureID);
	}

	public void reset(STEMTime time) {
		// Adjust current value by adding/substracting deltas by other models (population models).
		// We do this to set the right counts to match the population numbers at the beginning
		// of the simulation.
		
		for(Label l:this.getNode().getLabels()) {
			if(l instanceof IntegrationLabel) {
				IntegrationLabel il = (IntegrationLabel)l;
				if(l == this) continue;
				SimpleDataExchangeLabelValue delta = (SimpleDataExchangeLabelValue)il.getDeltaValue();
				((SILabelValue)this.getCurrentValue()).setS(
						((SILabelValue)this.getCurrentValue()).getS()+delta.getAdditions());
				((SILabelValue)this.getCurrentValue()).setS(
						((SILabelValue)this.getCurrentValue()).getS()-delta.getSubstractions());
					
			}
		}
	}

	
} // SEIRLabelImpl

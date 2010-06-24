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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.SimpleDataExchangeLabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SIR Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getDeltaValue <em>Delta Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getProbeValue <em>Probe Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getTempValue <em>Temp Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRLabelImpl#getErrorScale <em>Error Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIRLabelImpl extends StandardDiseaseModelLabelImpl implements SIRLabel {
	/**
	 * The cached value of the '{@link #getDeltaValue() <em>Delta Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltaValue()
	 * @generated
	 * @ordered
	 */
	protected SIRLabelValue deltaValue;
	/**
	 * The cached value of the '{@link #getProbeValue() <em>Probe Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeValue()
	 * @generated
	 * @ordered
	 */
	protected SIRLabelValue probeValue;
	/**
	 * The cached value of the '{@link #getTempValue() <em>Temp Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempValue()
	 * @generated
	 * @ordered
	 */
	protected SIRLabelValue tempValue;
	/**
	 * The cached value of the '{@link #getOriginalValue() <em>Original Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalValue()
	 * @generated
	 * @ordered
	 */
	protected SIRLabelValue originalValue;
	/**
	 * The cached value of the '{@link #getErrorScale() <em>Error Scale</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorScale()
	 * @generated
	 * @ordered
	 */
	protected SIRLabelValue errorScale;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SIRLabelImpl() {
		super();
		setCurrentValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setNextValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setOriginalValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setTempValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setProbeValue(StandardFactory.eINSTANCE.createSIRLabelValue());
		setErrorScale(StandardFactory.eINSTANCE.createSIRLabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createSIRLabelValue());
	} // SIRLabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SIR_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue getDeltaValue() {
		if (deltaValue != null && deltaValue.eIsProxy()) {
			InternalEObject oldDeltaValue = (InternalEObject)deltaValue;
			deltaValue = (SIRLabelValue)eResolveProxy(oldDeltaValue);
			if (deltaValue != oldDeltaValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SIR_LABEL__DELTA_VALUE, oldDeltaValue, deltaValue));
			}
		}
		return deltaValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue basicGetDeltaValue() {
		return deltaValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaValue(SIRLabelValue newDeltaValue) {
		SIRLabelValue oldDeltaValue = deltaValue;
		deltaValue = newDeltaValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SIR_LABEL__DELTA_VALUE, oldDeltaValue, deltaValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue getProbeValue() {
		if (probeValue != null && probeValue.eIsProxy()) {
			InternalEObject oldProbeValue = (InternalEObject)probeValue;
			probeValue = (SIRLabelValue)eResolveProxy(oldProbeValue);
			if (probeValue != oldProbeValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SIR_LABEL__PROBE_VALUE, oldProbeValue, probeValue));
			}
		}
		return probeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue basicGetProbeValue() {
		return probeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeValue(SIRLabelValue newProbeValue) {
		SIRLabelValue oldProbeValue = probeValue;
		probeValue = newProbeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SIR_LABEL__PROBE_VALUE, oldProbeValue, probeValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue getTempValue() {
		if (tempValue != null && tempValue.eIsProxy()) {
			InternalEObject oldTempValue = (InternalEObject)tempValue;
			tempValue = (SIRLabelValue)eResolveProxy(oldTempValue);
			if (tempValue != oldTempValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SIR_LABEL__TEMP_VALUE, oldTempValue, tempValue));
			}
		}
		return tempValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue basicGetTempValue() {
		return tempValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempValue(SIRLabelValue newTempValue) {
		SIRLabelValue oldTempValue = tempValue;
		tempValue = newTempValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SIR_LABEL__TEMP_VALUE, oldTempValue, tempValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue getOriginalValue() {
		if (originalValue != null && originalValue.eIsProxy()) {
			InternalEObject oldOriginalValue = (InternalEObject)originalValue;
			originalValue = (SIRLabelValue)eResolveProxy(oldOriginalValue);
			if (originalValue != oldOriginalValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SIR_LABEL__ORIGINAL_VALUE, oldOriginalValue, originalValue));
			}
		}
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue basicGetOriginalValue() {
		return originalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(SIRLabelValue newOriginalValue) {
		SIRLabelValue oldOriginalValue = originalValue;
		originalValue = newOriginalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SIR_LABEL__ORIGINAL_VALUE, oldOriginalValue, originalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue getErrorScale() {
		if (errorScale != null && errorScale.eIsProxy()) {
			InternalEObject oldErrorScale = (InternalEObject)errorScale;
			errorScale = (SIRLabelValue)eResolveProxy(oldErrorScale);
			if (errorScale != oldErrorScale) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StandardPackage.SIR_LABEL__ERROR_SCALE, oldErrorScale, errorScale));
			}
		}
		return errorScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue basicGetErrorScale() {
		return errorScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorScale(SIRLabelValue newErrorScale) {
		SIRLabelValue oldErrorScale = errorScale;
		errorScale = newErrorScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SIR_LABEL__ERROR_SCALE, oldErrorScale, errorScale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SIRLabelValue getNextSIRValue() {
		return (SIRLabelValue) getNextValue();
	} // getNextSIRValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SIRLabelValue getCurrentSIRValue() {
		return (SIRLabelValue) getCurrentValue();
	} // getCurrentSIRValue

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getR()
	 */
	public double getR() {
		return getCurrentSIRValue().getR();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setR(double)
	 */
	public void setR(double r) {
		getCurrentSIRValue().setR(r);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#getNextR()
	 */
	public double getNextR() {
		return getNextSIRValue().getR();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel#setNextR(double)
	 */
	public void setNextR(double r) {
		getNextSIRValue().setR(r);
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
		return getCurrentSIRValue().getI();
	} // getI

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#setI()
	 */
	public void setI(double i) {
		getCurrentSIRValue().setI(i);
	} // getI

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getNextI()
	 */
	public double getNextI() {
		return getNextSIRValue().getI();
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
			case StandardPackage.SIR_LABEL__DELTA_VALUE:
				if (resolve) return getDeltaValue();
				return basicGetDeltaValue();
			case StandardPackage.SIR_LABEL__PROBE_VALUE:
				if (resolve) return getProbeValue();
				return basicGetProbeValue();
			case StandardPackage.SIR_LABEL__TEMP_VALUE:
				if (resolve) return getTempValue();
				return basicGetTempValue();
			case StandardPackage.SIR_LABEL__ORIGINAL_VALUE:
				if (resolve) return getOriginalValue();
				return basicGetOriginalValue();
			case StandardPackage.SIR_LABEL__ERROR_SCALE:
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
			case StandardPackage.SIR_LABEL__DELTA_VALUE:
				setDeltaValue((SIRLabelValue)newValue);
				return;
			case StandardPackage.SIR_LABEL__PROBE_VALUE:
				setProbeValue((SIRLabelValue)newValue);
				return;
			case StandardPackage.SIR_LABEL__TEMP_VALUE:
				setTempValue((SIRLabelValue)newValue);
				return;
			case StandardPackage.SIR_LABEL__ORIGINAL_VALUE:
				setOriginalValue((SIRLabelValue)newValue);
				return;
			case StandardPackage.SIR_LABEL__ERROR_SCALE:
				setErrorScale((SIRLabelValue)newValue);
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
			case StandardPackage.SIR_LABEL__DELTA_VALUE:
				setDeltaValue((SIRLabelValue)null);
				return;
			case StandardPackage.SIR_LABEL__PROBE_VALUE:
				setProbeValue((SIRLabelValue)null);
				return;
			case StandardPackage.SIR_LABEL__TEMP_VALUE:
				setTempValue((SIRLabelValue)null);
				return;
			case StandardPackage.SIR_LABEL__ORIGINAL_VALUE:
				setOriginalValue((SIRLabelValue)null);
				return;
			case StandardPackage.SIR_LABEL__ERROR_SCALE:
				setErrorScale((SIRLabelValue)null);
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
			case StandardPackage.SIR_LABEL__DELTA_VALUE:
				return deltaValue != null;
			case StandardPackage.SIR_LABEL__PROBE_VALUE:
				return probeValue != null;
			case StandardPackage.SIR_LABEL__TEMP_VALUE:
				return tempValue != null;
			case StandardPackage.SIR_LABEL__ORIGINAL_VALUE:
				return originalValue != null;
			case StandardPackage.SIR_LABEL__ERROR_SCALE:
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
				
				Map<Node, Double> arrivals = delta.getArrivals();
				Map<Node, Double> departures = delta.getDepartures();
				
				// We scale the label values back since at this point the innoculators/infectors
				// have already been applied and we need to modify all states of the disease
				
				double popCount = ((SILabelValue)this.getCurrentValue()).getPopulationCount();
				if(arrivals != null && arrivals.size() == 1) {
					Node n = arrivals.keySet().iterator().next();
					assert(n.equals(getNode()));
					double factor = arrivals.get(n) / popCount;
					if(Double.isNaN(factor) || Double.isInfinite(factor)) factor = 0.0;// do nothing
					SILabelValue addV = (SILabelValue)EcoreUtil.copy(this.getCurrentValue());
					addV.scale(factor);
					((SILabelValue)this.getCurrentValue()).add((IntegrationLabelValue)addV);
				}
				if(departures != null && departures.size() == 1) {
					Node n = departures.keySet().iterator().next();
					assert(n.equals(getNode()));
					double factor = departures.get(n) / popCount;
					if(Double.isNaN(factor) || Double.isInfinite(factor)) factor = 0.0;// do nothing
					SILabelValue subV = (SILabelValue)EcoreUtil.copy(this.getCurrentValue());
					subV.scale(factor);
					((SILabelValue)this.getCurrentValue()).sub((IntegrationLabelValue)subV);
				}
				
					
			}
		}
	}

	
} // SIRLabelImpl

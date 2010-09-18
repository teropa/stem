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
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__DELTA_VALUE, StandardPackage.Literals.SEIR_LABEL__DELTA_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetDeltaValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__DELTA_VALUE, StandardPackage.Literals.SEIR_LABEL__DELTA_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaValue(SEIRLabelValue newDeltaValue) {
		eDynamicSet(StandardPackage.SEIR_LABEL__DELTA_VALUE, StandardPackage.Literals.SEIR_LABEL__DELTA_VALUE, newDeltaValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getProbeValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__PROBE_VALUE, StandardPackage.Literals.SEIR_LABEL__PROBE_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetProbeValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__PROBE_VALUE, StandardPackage.Literals.SEIR_LABEL__PROBE_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeValue(SEIRLabelValue newProbeValue) {
		eDynamicSet(StandardPackage.SEIR_LABEL__PROBE_VALUE, StandardPackage.Literals.SEIR_LABEL__PROBE_VALUE, newProbeValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getTempValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__TEMP_VALUE, StandardPackage.Literals.SEIR_LABEL__TEMP_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetTempValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__TEMP_VALUE, StandardPackage.Literals.SEIR_LABEL__TEMP_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempValue(SEIRLabelValue newTempValue) {
		eDynamicSet(StandardPackage.SEIR_LABEL__TEMP_VALUE, StandardPackage.Literals.SEIR_LABEL__TEMP_VALUE, newTempValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getOriginalValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.SEIR_LABEL__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetOriginalValue() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.SEIR_LABEL__ORIGINAL_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(SEIRLabelValue newOriginalValue) {
		eDynamicSet(StandardPackage.SEIR_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.SEIR_LABEL__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue getErrorScale() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__ERROR_SCALE, StandardPackage.Literals.SEIR_LABEL__ERROR_SCALE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue basicGetErrorScale() {
		return (SEIRLabelValue)eDynamicGet(StandardPackage.SEIR_LABEL__ERROR_SCALE, StandardPackage.Literals.SEIR_LABEL__ERROR_SCALE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorScale(SEIRLabelValue newErrorScale) {
		eDynamicSet(StandardPackage.SEIR_LABEL__ERROR_SCALE, StandardPackage.Literals.SEIR_LABEL__ERROR_SCALE, newErrorScale);
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
				return basicGetDeltaValue() != null;
			case StandardPackage.SEIR_LABEL__PROBE_VALUE:
				return basicGetProbeValue() != null;
			case StandardPackage.SEIR_LABEL__TEMP_VALUE:
				return basicGetTempValue() != null;
			case StandardPackage.SEIR_LABEL__ORIGINAL_VALUE:
				return basicGetOriginalValue() != null;
			case StandardPackage.SEIR_LABEL__ERROR_SCALE:
				return basicGetErrorScale() != null;
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

	
} // SEIRLabelImpl

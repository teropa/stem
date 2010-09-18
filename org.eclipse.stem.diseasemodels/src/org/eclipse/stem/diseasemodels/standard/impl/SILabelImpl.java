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
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SI Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getDeltaValue <em>Delta Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getProbeValue <em>Probe Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getTempValue <em>Temp Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SILabelImpl#getErrorScale <em>Error Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SILabelImpl extends StandardDiseaseModelLabelImpl implements
		SILabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SILabelImpl() {
		setCurrentValue(StandardFactory.eINSTANCE.createSILabelValue());
		setNextValue(StandardFactory.eINSTANCE.createSILabelValue());
		setOriginalValue(StandardFactory.eINSTANCE.createSILabelValue());
		setTempValue(StandardFactory.eINSTANCE.createSILabelValue());
		setProbeValue(StandardFactory.eINSTANCE.createSILabelValue());
		setErrorScale(StandardFactory.eINSTANCE.createSILabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createSILabelValue());
	} // SILabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SI_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue getDeltaValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__DELTA_VALUE, StandardPackage.Literals.SI_LABEL__DELTA_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue basicGetDeltaValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__DELTA_VALUE, StandardPackage.Literals.SI_LABEL__DELTA_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaValue(SILabelValue newDeltaValue) {
		eDynamicSet(StandardPackage.SI_LABEL__DELTA_VALUE, StandardPackage.Literals.SI_LABEL__DELTA_VALUE, newDeltaValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue getProbeValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__PROBE_VALUE, StandardPackage.Literals.SI_LABEL__PROBE_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue basicGetProbeValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__PROBE_VALUE, StandardPackage.Literals.SI_LABEL__PROBE_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeValue(SILabelValue newProbeValue) {
		eDynamicSet(StandardPackage.SI_LABEL__PROBE_VALUE, StandardPackage.Literals.SI_LABEL__PROBE_VALUE, newProbeValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue getTempValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__TEMP_VALUE, StandardPackage.Literals.SI_LABEL__TEMP_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue basicGetTempValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__TEMP_VALUE, StandardPackage.Literals.SI_LABEL__TEMP_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempValue(SILabelValue newTempValue) {
		eDynamicSet(StandardPackage.SI_LABEL__TEMP_VALUE, StandardPackage.Literals.SI_LABEL__TEMP_VALUE, newTempValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue getOriginalValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.SI_LABEL__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue basicGetOriginalValue() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.SI_LABEL__ORIGINAL_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(SILabelValue newOriginalValue) {
		eDynamicSet(StandardPackage.SI_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.SI_LABEL__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue getErrorScale() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__ERROR_SCALE, StandardPackage.Literals.SI_LABEL__ERROR_SCALE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue basicGetErrorScale() {
		return (SILabelValue)eDynamicGet(StandardPackage.SI_LABEL__ERROR_SCALE, StandardPackage.Literals.SI_LABEL__ERROR_SCALE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorScale(SILabelValue newErrorScale) {
		eDynamicSet(StandardPackage.SI_LABEL__ERROR_SCALE, StandardPackage.Literals.SI_LABEL__ERROR_SCALE, newErrorScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SILabelValue getCurrentSIValue() {
		return (SILabelValue) getCurrentValue();
	} // getCurrentSIValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SILabelValue getNextSIValue() {
		return (SILabelValue) getNextValue();
	} // getNextSIValue

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
		return getCurrentSIValue().getI();
	} // getI

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#setI()
	 */
	public void setI(double i) {
		getCurrentSIValue().setI(i);
	} // getI

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getNextI()
	 */
	public double getNextI() {
		return getNextSIValue().getI();
	} // getNextI

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
			case StandardPackage.SI_LABEL__DELTA_VALUE:
				if (resolve) return getDeltaValue();
				return basicGetDeltaValue();
			case StandardPackage.SI_LABEL__PROBE_VALUE:
				if (resolve) return getProbeValue();
				return basicGetProbeValue();
			case StandardPackage.SI_LABEL__TEMP_VALUE:
				if (resolve) return getTempValue();
				return basicGetTempValue();
			case StandardPackage.SI_LABEL__ORIGINAL_VALUE:
				if (resolve) return getOriginalValue();
				return basicGetOriginalValue();
			case StandardPackage.SI_LABEL__ERROR_SCALE:
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
			case StandardPackage.SI_LABEL__DELTA_VALUE:
				setDeltaValue((SILabelValue)newValue);
				return;
			case StandardPackage.SI_LABEL__PROBE_VALUE:
				setProbeValue((SILabelValue)newValue);
				return;
			case StandardPackage.SI_LABEL__TEMP_VALUE:
				setTempValue((SILabelValue)newValue);
				return;
			case StandardPackage.SI_LABEL__ORIGINAL_VALUE:
				setOriginalValue((SILabelValue)newValue);
				return;
			case StandardPackage.SI_LABEL__ERROR_SCALE:
				setErrorScale((SILabelValue)newValue);
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
			case StandardPackage.SI_LABEL__DELTA_VALUE:
				setDeltaValue((SILabelValue)null);
				return;
			case StandardPackage.SI_LABEL__PROBE_VALUE:
				setProbeValue((SILabelValue)null);
				return;
			case StandardPackage.SI_LABEL__TEMP_VALUE:
				setTempValue((SILabelValue)null);
				return;
			case StandardPackage.SI_LABEL__ORIGINAL_VALUE:
				setOriginalValue((SILabelValue)null);
				return;
			case StandardPackage.SI_LABEL__ERROR_SCALE:
				setErrorScale((SILabelValue)null);
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
			case StandardPackage.SI_LABEL__DELTA_VALUE:
				return basicGetDeltaValue() != null;
			case StandardPackage.SI_LABEL__PROBE_VALUE:
				return basicGetProbeValue() != null;
			case StandardPackage.SI_LABEL__TEMP_VALUE:
				return basicGetTempValue() != null;
			case StandardPackage.SI_LABEL__ORIGINAL_VALUE:
				return basicGetOriginalValue() != null;
			case StandardPackage.SI_LABEL__ERROR_SCALE:
				return basicGetErrorScale() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#getIncidence()
	 */
	public double getIncidence() {
		return this.getCurrentSIValue().getIncidence();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel#setIncidence(double)
	 */
	public void setIncidence(double incidence) {
		this.getCurrentSIValue().setIncidence(incidence);
	}

	public void reset(STEMTime time) {
		// Adjust current value by adding/substracting deltas by other models (population models).
		// We do this to set the right counts to match the population numbers at the beginning
		// of the simulation.
		
		for(Label l:this.getNode().getLabels()) {
			if(l instanceof IntegrationLabel) {
				if(!((IntegrationLabel)l).getIdentifier().equals(this.getPopulationModelLabel().getPopulationIdentifier()))
					continue;
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

} // SILabelImpl

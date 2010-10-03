package org.eclipse.stem.populationmodels.standard.impl;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/


import java.util.Calendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.SimpleDataExchangeLabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl#getDeltaValue <em>Delta Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl#getProbeValue <em>Probe Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl#getTempValue <em>Temp Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelImpl#getErrorScale <em>Error Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardPopulationModelLabelImpl extends PopulationModelLabelImpl implements StandardPopulationModelLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected StandardPopulationModelLabelImpl() {
		super();
		setCurrentValue(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
		setNextValue(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
		setOriginalValue(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
		setTempValue(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
		setProbeValue(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
		setErrorScale(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
		setDeltaValue(StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue());
	}
	
	/**
	 * Return the identifier for the label, i.e. the population identifier
	 * 
	 * @return String The identifier
	 */
	
	public String getIdentifier() {
		return this.getPopulationIdentifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue getDeltaValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue basicGetDeltaValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltaValue(StandardPopulationModelLabelValue newDeltaValue) {
		eDynamicSet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE, newDeltaValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue getProbeValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue basicGetProbeValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeValue(StandardPopulationModelLabelValue newProbeValue) {
		eDynamicSet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE, newProbeValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue getTempValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue basicGetTempValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempValue(StandardPopulationModelLabelValue newTempValue) {
		eDynamicSet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE, newTempValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue getOriginalValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue basicGetOriginalValue() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(StandardPopulationModelLabelValue newOriginalValue) {
		eDynamicSet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue getErrorScale() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue basicGetErrorScale() {
		return (StandardPopulationModelLabelValue)eDynamicGet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorScale(StandardPopulationModelLabelValue newErrorScale) {
		eDynamicSet(StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE, StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE, newErrorScale);
	}

	/**
	 * Reset the dynamic label. This sets the {@link LabelValue}s back to their
	 * initial states.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	@Override
	public void reset() {
		((StandardPopulationModelLabelValue)this.getCurrentValue()).reset();
		((StandardPopulationModelLabelValue)this.getNextValue()).reset();
		this.getDeltaValue().reset();
		this.getTempValue().reset();
		this.getProbeValue().reset();
		this.getErrorScale().reset();
		
		double originalCount = this.getPopulationLabel().getCurrentPopulationValue().getCount();
		((StandardPopulationModelLabelValue)this.getCurrentValue()).setCount(originalCount);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE:
				if (resolve) return getDeltaValue();
				return basicGetDeltaValue();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE:
				if (resolve) return getProbeValue();
				return basicGetProbeValue();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE:
				if (resolve) return getTempValue();
				return basicGetTempValue();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE:
				if (resolve) return getOriginalValue();
				return basicGetOriginalValue();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE:
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
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE:
				setDeltaValue((StandardPopulationModelLabelValue)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE:
				setProbeValue((StandardPopulationModelLabelValue)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE:
				setTempValue((StandardPopulationModelLabelValue)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE:
				setOriginalValue((StandardPopulationModelLabelValue)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE:
				setErrorScale((StandardPopulationModelLabelValue)newValue);
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
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE:
				setDeltaValue((StandardPopulationModelLabelValue)null);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE:
				setProbeValue((StandardPopulationModelLabelValue)null);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE:
				setTempValue((StandardPopulationModelLabelValue)null);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE:
				setOriginalValue((StandardPopulationModelLabelValue)null);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE:
				setErrorScale((StandardPopulationModelLabelValue)null);
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
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__DELTA_VALUE:
				return basicGetDeltaValue() != null;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__PROBE_VALUE:
				return basicGetProbeValue() != null;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__TEMP_VALUE:
				return basicGetTempValue() != null;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ORIGINAL_VALUE:
				return basicGetOriginalValue() != null;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL__ERROR_SCALE:
				return basicGetErrorScale() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Reset to the correct population value for the
	 * passed in time
	 * 
	 * @param time Reference time
	 */
	public void reset(STEMTime time) {
		// Only rewind population if it's a standard population model
		if(this.getDecorator() instanceof StandardPopulationModel) {
			StandardPopulationModel spm = (StandardPopulationModel)this.getDecorator();
			PopulationLabel plabel = this.getPopulationLabel();
			int year = plabel.getValidYear();
			Calendar c = Calendar.getInstance();
			c.setTime(time.getTime());
			int startYear = c.get(Calendar.YEAR);
			double growth = spm.getBirthRate() - spm.getDeathRate();
			double dailyGrowth = (spm.getTimePeriod() / 86400000.0)*growth;
			double diff = ((double)startYear - (double)year)*365.25; // approx
			double currentPopulation = ((StandardPopulationModelLabelValue)this.getCurrentValue()).getCount();
			dailyGrowth = 1.0 + dailyGrowth;
			double newPopulation = currentPopulation * Math.pow(dailyGrowth, diff);
			((StandardPopulationModelLabelValue)this.getCurrentValue()).setCount(newPopulation);	
			// Store the additions/substractions in the delta value so that disease models can
			// adjust their counts
			double popdiff = newPopulation - currentPopulation;
			if(popdiff > 0.0) {
				((SimpleDataExchangeLabelValue)this.getDeltaValue()).getArrivals().put(this.getNode(), popdiff);
				this.getDeltaValue().setBirths(popdiff);
			}
			else {
				((SimpleDataExchangeLabelValue)this.getDeltaValue()).getDepartures().put(this.getNode(), -popdiff);
				(this.getDeltaValue()).setDeaths(-popdiff);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(
				getPopulationIdentifier() == null ? "null" : getPopulationIdentifier());
		result.append(" [");
		result.append(Math.floor(((StandardPopulationModelLabelValue)getCurrentValue()).getCount()));
		result.append("]");
		return result.toString();
	}
} //StandardPopulationModelLabelImpl

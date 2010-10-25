/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.diseasemodels.multipopulation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.common.DoubleValue;
import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.StringValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Population SEIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSEIRDiseaseModelImpl#getIncubationRate <em>Incubation Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiPopulationSEIRDiseaseModelImpl extends MultiPopulationSIRDiseaseModelImpl implements MultiPopulationSEIRDiseaseModel {
	/**
	 * The cached value of the '{@link #getIncubationRate() <em>Incubation Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncubationRate()
	 * @generated
	 * @ordered
	 */
	protected DoubleValueList incubationRate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MultiPopulationSEIRDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipopulationPackage.Literals.MULTI_POPULATION_SEIR_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueList getIncubationRate() {
		return incubationRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncubationRate(DoubleValueList newIncubationRate, NotificationChain msgs) {
		DoubleValueList oldIncubationRate = incubationRate;
		incubationRate = newIncubationRate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE, oldIncubationRate, newIncubationRate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncubationRate(DoubleValueList newIncubationRate) {
		if (newIncubationRate != incubationRate) {
			NotificationChain msgs = null;
			if (incubationRate != null)
				msgs = ((InternalEObject)incubationRate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE, null, msgs);
			if (newIncubationRate != null)
				msgs = ((InternalEObject)newIncubationRate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE, null, msgs);
			msgs = basicSetIncubationRate(newIncubationRate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE, newIncubationRate, newIncubationRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE:
				return basicSetIncubationRate(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#computeDeaths(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue,
	 *      long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeathsDeltas(
			final STEMTime time, final StandardDiseaseModelLabel diseaseLabel, final StandardDiseaseModelLabelValue currentLabelValue, final long timeDelta, DiseaseModelLabelValue returnValue) {

		String thisPopulation = diseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
		final SEIRLabelValue currentSEIR = (SEIRLabelValue) currentLabelValue;
		
		final double adjustedInfectiousMortalityRate = getAdjustedInfectiousMortalityRate(timeDelta, thisPopulation);
		
		final double diseaseDeaths = adjustedInfectiousMortalityRate
				* currentSEIR.getI();

		SEIRLabelValueImpl ret = (SEIRLabelValueImpl)returnValue;
		ret.setS(0.0);
		ret.setI(-diseaseDeaths);
		ret.setE(0.0);
		ret.setR(0.0);
		ret.setIncidence(0.0);
		ret.setDiseaseDeaths(diseaseDeaths);
		
		return ret;
	} // computeBirthDeathsDeltas

	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(STEMTime time,
			StandardDiseaseModelLabelValue currentState,
			StandardDiseaseModelLabel diseaseLabel, long timeDelta,
			DiseaseModelLabelValue returnValue) {
		
		// THIS method gets called multiple times, once for each population identifier
		// in the population model.
		// which population is "this"....
		final SEIRLabelValue currentSEIR = (SEIRLabelValue) currentState;
		String thisPopulation = diseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
				
		// next get it's INDEX in the model
		int populationIndex = this.getPopulationIndex(thisPopulation);	
			
		// now we know the index of the current population being integrated.
		// Get the correct transmission rate list from the MATRIX
		EList<DoubleValue> transmissionVector = getTransmissionRate().getValueLists().get(populationIndex).getValues();
		
		// ALL the other disease parameters are also DoubleValueLists. We now iterate through all populations
		// get the specific rate parameters from EACH list based on this population index
		double thisRecoveryRate = 0.0;
		if(getRecoveryRate() != null) thisRecoveryRate = getRecoveryRate().getValues().get(populationIndex).getValue();
		double thisImmunityLossRate = 0.0;
		if(getImmunityLossRate() != null)
			thisImmunityLossRate = getImmunityLossRate().getValues().get(populationIndex).getValue();
		double thisIncubationRate = 0.0;
		if(getIncubationRate() != null) 
			thisIncubationRate = getIncubationRate().getValues().get(populationIndex).getValue();
		
		//  NOW iterate over every population (including this one) to compute new infections
		//  this includes infections within a population group
		//  and all the cross terms
		double numberOfSusceptibleToExposed = 0.0;
		double numberSusceptible = currentSEIR.getS();
		Node thisNode = diseaseLabel.getNode();
		
		EList<StringValue> groupList = getPopulationGroups().getValues();
		
		for(int i = 0; i< transmissionVector.size(); i ++) {
			// We need to get the identifier of the ith population model
			String nextPop = groupList.get(i).getValue();
			
            //////////////////
			// 1. compute BETA for transmission from the ith population to this population
			 double specificTransmission = transmissionVector.get(i).getValue();
			 double adjustedTransmission = getAdjustedTransmissionRate(specificTransmission, timeDelta);
			 if(!this.isFrequencyDependent()) adjustedTransmission *= getTransmissionRateScaleFactor(diseaseLabel);
			 
			
			// we need to get the disease label for the ith population as well.
			// to get the on site number of infectios individuals of type i
			EList<NodeLabel> nodeLabels = thisNode.getLabels();
			for(int j = 0; j < nodeLabels.size(); j ++) {
				NodeLabel label = nodeLabels.get(j);
				if(label instanceof SEIRLabel) {
					if (this == ((SEIRLabel)label).getDecorator()) {
						StandardDiseaseModelLabel otherDiseaseLabel = (StandardDiseaseModelLabel) label;
						// now check the popualtion type
						String otherPopulation = otherDiseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
						if(otherPopulation.equals(nextPop)) {
							// Yes?
							// then we found the label for the correct next population
							
			
							// for this population we need to get the EFFECTIVE Infectious including
							// ALL neighboring nodes
							double onsiteInfectious = ((SEIRLabel) otherDiseaseLabel).getTempValue().getI();
							final double effectiveInfectious = getNormalizedEffectiveInfectious(otherPopulation, thisNode, otherDiseaseLabel, onsiteInfectious);
							
						    // ADD up the new incidence
							numberOfSusceptibleToExposed += adjustedTransmission * numberSusceptible * effectiveInfectious;
						}
					}
				}// if it's an SI label
			}//for all labels in THIS node
		}// For all population in the model
		
		double numberOfInfectedToRecovered = getAdjustedRecoveryRate(thisRecoveryRate, timeDelta) * currentSEIR.getI();
		double numberOfRecoveredToSusceptible = getAdjustedImmunityLossRate(thisImmunityLossRate, timeDelta) * currentSEIR.getR();
		double numberOfExposedToInfected = getAdjustedIncubationRate(thisIncubationRate, timeDelta) * currentSEIR.getE();
		
		// Determine delta S
		final double deltaS = - numberOfSusceptibleToExposed + numberOfRecoveredToSusceptible;
		// Delta E
		final double deltaE = numberOfSusceptibleToExposed - numberOfExposedToInfected;
		// Determine delta I
		final double deltaI = numberOfExposedToInfected - numberOfInfectedToRecovered;
		// Determine delta R	
		final double deltaR = numberOfInfectedToRecovered - numberOfRecoveredToSusceptible;
		
		SEIRLabelValueImpl ret = (SEIRLabelValueImpl)returnValue;
		ret.setS(deltaS);
		ret.setE(deltaE);
		ret.setI(deltaI);
		ret.setR(deltaR);
		ret.setIncidence(numberOfSusceptibleToExposed);
		ret.setDiseaseDeaths(0.0);
		return ret;
		
	}
	
	public double getAdjustedIncubationRate(double specificIncRate, long timeDelta) {
		return (specificIncRate * ((double) timeDelta / (double) getTimePeriod()) );
	} // getAdjustedIncubationRate
	
	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSEIRLabel();
	}

	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSEIRLabelValue();
	}


	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE:
				return getIncubationRate();
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
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE:
				setIncubationRate((DoubleValueList)newValue);
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
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE:
				setIncubationRate((DoubleValueList)null);
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
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL__INCUBATION_RATE:
				return incubationRate != null;
		}
		return super.eIsSet(featureID);
	}

} //MultiPopulationSEIRDiseaseModelImpl

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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.SimpleDataExchangeLabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;
import org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
//import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
//import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIR;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SIR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SIRImpl#getImmunityLossRate <em>Immunity Loss Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SIRImpl extends SIImpl implements SIR {
	/**
	 * The default value of the '{@link #getImmunityLossRate() <em>Immunity Loss Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImmunityLossRate()
	 * @generated
	 * @ordered
	 */
	protected static final double IMMUNITY_LOSS_RATE_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SIRImpl() {
		super();
	}

	/**
	 * @param sirDiseaseModel
	 *            the SIR disease model to be initialized
	 * @param diseaseModelName
	 * @param backgroundMortalityRate
	 * @param infectiousMortality
	 * @param infectiousMortalityRate
	 *            the rate at which fatally infectious population members die
	 * @param transmissionRate
	 * @param recoveryRate
	 * @param immunityLossRate
	 * @param incubationRate
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 * @param populationIdentifier
	 */
	protected static SIR initializeSIRDiseaseModel(final SIR sirDiseaseModel,
			final String diseaseModelName,
			final double backgroundMortalityRate,
			final double infectiousMortalityRate,
			final double transmissionRate, final double recoveryRate,
			final double immunityLossRate,
			final double nonLinearityCoefficient, final long timePeriod,
			final String populationIdentifier) {
		SIImpl.initializeSIDiseaseModel(sirDiseaseModel, diseaseModelName,
				backgroundMortalityRate,
				infectiousMortalityRate, transmissionRate, recoveryRate,
				nonLinearityCoefficient, timePeriod, populationIdentifier);
		sirDiseaseModel.setImmunityLossRate(immunityLossRate);
		return sirDiseaseModel;
	} // initializeSIRDiseaseModel

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#createDiseaseModelLabel()
	 */
	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSIRLabel();
	} // createDiseaseModelLabel
	
	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSIRLabelValue();
	} // createDiseaseModelLabelValue
	

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#computeDeaths(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue,
	 *      long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeathsDeltas(
			final STEMTime time, final StandardDiseaseModelLabel diseaseLabel, final StandardDiseaseModelLabelValue currentLabelValue, final long timeDelta, DiseaseModelLabelValue returnValue) {
		
		final SIRLabelValue currentSIR = (SIRLabelValue) currentLabelValue;
		
		final double adjustedInfectiousMortalityRate = getAdjustedInfectiousMortalityRate(timeDelta);
		final double diseaseDeaths = adjustedInfectiousMortalityRate
				* currentSIR.getI();

		SIRLabelValueImpl ret = (SIRLabelValueImpl)returnValue;
		ret.setS(0.0);
		ret.setI(-diseaseDeaths);
		ret.setIncidence(0.0);
		ret.setR(0.0);
		ret.setDiseaseDeaths(diseaseDeaths);
		return ret;
	} // computeDeaths

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#computeTransitions(StandardDiseaseModelLabelValue,
	 *      StandardDiseaseModelLabel, long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time, 
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, final long timeDelta, DiseaseModelLabelValue returnValue) {
		final SIRLabelValue currentSIR = (SIRLabelValue) currentState;
		
		// This is beta*
		double transmissionRate = getAdjustedTransmissionRate(timeDelta);
				
		if(!this.isFrequencyDependent()) transmissionRate *= getTransmissionRateScaleFactor(diseaseLabel);

		// The effective Infectious population  is a dimensionles number normalize by total
		// population used in teh computation of bets*S*i where i = Ieffective/Pop.
		// This includes a correction to the current
		// infectious population (Ieffective) based on the conserved exchange of people (circulation)
		// between regions. Note that this is no the "arrivals" and "departures" which are
		// a different process.
		final double effectiveInfectious = getNormalizedEffectiveInfectious(diseaseLabel.getNode(), diseaseLabel, currentSIR.getI());

		/*
		 * Compute state transitions
		 * 
		 * Regarding computing the number of transitions from Susceptible to Exposed:
		 * In a linear model the "effective" number of infectious people is just
		 * the number of infectious people In a nonlinear model we have a
		 * nonLinearity exponent that is > 1 this models the effect of immune
		 * system saturation when Susceptible people are exposed to large
		 * numbers of infectious people. then the "effective" number of
		 * infectious people is I^nonLinearity exponent to allow for either
		 * linear or nonlinear models we always calculate I^nonLinearity
		 * exponent and allow nonLinearity exponent >= 1.0
		 */
		double numberOfInfectedToRecovered = getAdjustedRecoveryRate(timeDelta)
		* currentSIR.getI();
		double numberOfRecoveredToSusceptible = getAdjustedImmunityLossRate(timeDelta)
		* currentSIR.getR();
		// Need to checked what do do here. If non linear coefficient is not 1 and
		// the effective infectious is negative (which is possible), what do do? 
		// Let's fall back on the linear method for now.
		double numberOfSusceptibleToInfected = 0.0;
		if(getNonLinearityCoefficient() != 1.0 && effectiveInfectious >= 0.0)
			numberOfSusceptibleToInfected = transmissionRate
			* currentSIR.getS()* Math.pow(effectiveInfectious, getNonLinearityCoefficient());
		else
			numberOfSusceptibleToInfected = transmissionRate
			* currentSIR.getS()* effectiveInfectious;
		
		
		// Determine delta S
		final double deltaS = numberOfRecoveredToSusceptible - numberOfSusceptibleToInfected;
			// Determine delta I
		final double deltaI = numberOfSusceptibleToInfected- numberOfInfectedToRecovered;
		// Determine delta R
		final double deltaR = numberOfInfectedToRecovered - numberOfRecoveredToSusceptible;
		
		SIRLabelValueImpl ret = (SIRLabelValueImpl)returnValue;
		ret.setS(deltaS);
		ret.setI(deltaI);
		ret.setIncidence(numberOfInfectedToRecovered);
		ret.setR(deltaR);
		ret.setDiseaseDeaths(0);
		return ret;
		
	} // computeTransitions

		
	/**
	 * @param fractionToDepart
	 * @param nextState
	 * @return
	 */
	@Override
	protected StandardDiseaseModelLabelValue computeDepartures(
			final 	double fractionToDepart,final  StandardDiseaseModelLabelValue nextState) {
		final SIRLabelValue departees = StandardFactory.eINSTANCE
				.createSIRLabelValue();
		final SIRLabelValue siState = (SIRLabelValue) nextState;
		departees.setS(fractionToDepart * siState.getS());
		departees.setI(fractionToDepart * siState.getI());
		departees.setR(fractionToDepart * siState.getR());
		return departees;
	} // computeDepartures

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SIR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getImmunityLossRate() {
		return (Double)eDynamicGet(StandardPackage.SIR__IMMUNITY_LOSS_RATE, StandardPackage.Literals.SIR__IMMUNITY_LOSS_RATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newImmunityLossRate
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmunityLossRate(double newImmunityLossRate) {
		eDynamicSet(StandardPackage.SIR__IMMUNITY_LOSS_RATE, StandardPackage.Literals.SIR__IMMUNITY_LOSS_RATE, newImmunityLossRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param timeDelta
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAdjustedImmunityLossRate(long timeDelta) {
		return getImmunityLossRate()
				* ((double) timeDelta / (double) getTimePeriod());
	} // getAdjustedImmunityRate

	
	
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
			case StandardPackage.SIR__IMMUNITY_LOSS_RATE:
				return getImmunityLossRate();
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
			case StandardPackage.SIR__IMMUNITY_LOSS_RATE:
				setImmunityLossRate((Double)newValue);
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
			case StandardPackage.SIR__IMMUNITY_LOSS_RATE:
				setImmunityLossRate(IMMUNITY_LOSS_RATE_EDEFAULT);
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
			case StandardPackage.SIR__IMMUNITY_LOSS_RATE:
				return getImmunityLossRate() != IMMUNITY_LOSS_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue && getImmunityLossRate() >= IMMUNITY_LOSS_RATE_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(getImmunityLossRate());
		assert retValue;
		
		retValue = retValue && !Double.isNaN(getImmunityLossRate());
		assert retValue;
		
		return retValue;
	} // sane

} // SIRImpl

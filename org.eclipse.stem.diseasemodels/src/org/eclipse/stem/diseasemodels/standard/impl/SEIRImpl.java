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
import org.eclipse.stem.diseasemodels.standard.SEIR;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
//import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SEIR</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.SEIRImpl#getIncubationRate <em>Incubation Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SEIRImpl extends SIRImpl implements SEIR {

	/**
	 * The default value of the '{@link #getIncubationRate() <em>Incubation Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncubationRate()
	 * @generated
	 * @ordered
	 */
	protected static final double INCUBATION_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIncubationRate() <em>Incubation Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncubationRate()
	 * @generated
	 * @ordered
	 */
	protected double incubationRate = INCUBATION_RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SEIRImpl() {
		super();
	}

	/**
	 * @param seirDiseaseModel
	 *            the SEIR disease model to be initialized
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
	protected static SEIR initializeSEIRDiseaseModel(
			final SEIR seirDiseaseModel, final String diseaseModelName,
			final double backgroundMortalityRate,
			final double infectiousMortalityRate,
			final double transmissionRate, final double recoveryRate,
			final double immunityLossRate, final double incubationRate,
			final double nonLinearityCoefficient, final long timePeriod,
			final String populationIdentifier) {
		SIRImpl.initializeSIRDiseaseModel(seirDiseaseModel, diseaseModelName,
				backgroundMortalityRate,
				infectiousMortalityRate, transmissionRate, recoveryRate,
				immunityLossRate, nonLinearityCoefficient, timePeriod,
				populationIdentifier);
		seirDiseaseModel.setIncubationRate(incubationRate);
		return seirDiseaseModel;
	} // initializeStandardDiseaseModel

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#computeBirthsDeathsDeltas(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue,
	 *      long)
	 */
	@Override
	public SEIRLabelValue computeDiseaseDeathsDeltas(
			final STEMTime time, final StandardDiseaseModelLabel diseaseLabel, final StandardDiseaseModelLabelValue currentLabelValue, final long timeDelta, DiseaseModelLabelValue returnValue) {

		final SEIRLabelValue currentSEIR = (SEIRLabelValue) currentLabelValue;
		
		final double adjustedInfectiousMortalityRate = getAdjustedInfectiousMortalityRate(timeDelta);
		final double diseaseDeaths = adjustedInfectiousMortalityRate
				* currentSEIR.getI();

		SEIRLabelValueImpl ret = (SEIRLabelValueImpl)returnValue;
		ret.setS(0.0);
		ret.setE(0.0);
		ret.setI(-diseaseDeaths);
		ret.setIncidence(0);
		ret.setR(0.0);
		ret.setDiseaseDeaths(diseaseDeaths);
		return ret;
	} // computeBirthsDeaths


	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#computeDiseaseDeltas(StandardDiseaseModelLabelValue,
	 *      StandardDiseaseModelLabel, long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time, 
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, final long timeDelta, DiseaseModelLabelValue returnValue) {
		final SEIRLabelValue currentSEIR = (SEIRLabelValue) currentState;
	
		// This is beta*
		double transmissionRate = getAdjustedTransmissionRate(timeDelta);
		
		if(!this.isFrequencyDependent()) transmissionRate *= getTransmissionRateScaleFactor(diseaseLabel);
		
			
		// The effective Infectious population  is a dimensionles number normalize by total
		// population used in teh computation of bets*S*i where i = Ieffective/Pop.
		// This includes a correction to the current
		// infectious population (Ieffective) based on the conserved exchange of people (circulation)
		// between regions. Note that this is no the "arrivals" and "departures" which are
		// a different process.
		final double effectiveInfectious = getNormalizedEffectiveInfectious(diseaseLabel.getNode(), diseaseLabel, currentSEIR.getI());

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
		* currentSEIR.getI();
		double numberOfRecoveredToSusceptible = getAdjustedImmunityLossRate(timeDelta)
		* currentSEIR.getR();
		// Need to checked what do do here. If non linear coefficient is not 1 and
		// the effective infectious is negative (which is possible), what do do? 
		// Let's fall back on the linear method for now.
		double numberOfSusceptibleToExposed = 0.0;
		if(getNonLinearityCoefficient() != 1.0 && effectiveInfectious >=0.0)
			numberOfSusceptibleToExposed = transmissionRate
			* currentSEIR.getS()* Math.pow(effectiveInfectious, getNonLinearityCoefficient());
		else 
			numberOfSusceptibleToExposed = transmissionRate
			* currentSEIR.getS()* effectiveInfectious;
		double numberOfExposedToInfectious = getAdjustedIncubationRate(timeDelta)
		* currentSEIR.getE();
			
		
		// Determine delta S
		final double deltaS = numberOfRecoveredToSusceptible - numberOfSusceptibleToExposed;
		// Determine delta E
		final double deltaE = numberOfSusceptibleToExposed - numberOfExposedToInfectious;		
		// Determine delta I
		final double deltaI = numberOfExposedToInfectious - numberOfInfectedToRecovered;
		// Determine delta R
		final double deltaR = numberOfInfectedToRecovered - numberOfRecoveredToSusceptible;
		
		SEIRLabelValueImpl ret = (SEIRLabelValueImpl)returnValue;
		ret.setS(deltaS);
		ret.setE(deltaE);
		ret.setI(deltaI);
		ret.setIncidence(numberOfSusceptibleToExposed);
		ret.setR(deltaR);
		ret.setDiseaseDeaths(0);
		return ret;
	
	} // computeDiseaseDeltas
	

	/**
	 * @param fractionToDepart
	 * @param nextState
	 * @return
	 */
	@Override
	protected StandardDiseaseModelLabelValue computeDepartures(
			final double fractionToDepart,
			final StandardDiseaseModelLabelValue nextState) {
		final SEIRLabelValue departees = StandardFactory.eINSTANCE
				.createSEIRLabelValue();
		final SEIRLabelValue siState = (SEIRLabelValue) nextState;
		departees.setS(fractionToDepart * siState.getS());
		departees.setE(fractionToDepart * siState.getE());
		departees.setI(fractionToDepart * siState.getI());
		departees.setR(fractionToDepart * siState.getR());
		return departees;
	} // computeDepartures

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#createDiseaseModelLabel()
	 */
	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSEIRLabel();
	} // createDiseaseModelLabel
	
	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSEIRLabelValue();
	} // createDiseaseModelLabelValue
	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SEIR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIncubationRate() {
		return incubationRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newIncubationRate
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncubationRate(double newIncubationRate) {
		double oldIncubationRate = incubationRate;
		incubationRate = newIncubationRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEIR__INCUBATION_RATE, oldIncubationRate, incubationRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param timeDelta
	 *            the time period to adjust the rate to
	 * @return the adjusted rate
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAdjustedIncubationRate(long timeDelta) {
		return getIncubationRate()
				* ((double) timeDelta / (double) getTimePeriod());
	} // getAdjustedIncubationRate

	
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
			case StandardPackage.SEIR__INCUBATION_RATE:
				return getIncubationRate();
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
			case StandardPackage.SEIR__INCUBATION_RATE:
				setIncubationRate((Double)newValue);
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
			case StandardPackage.SEIR__INCUBATION_RATE:
				setIncubationRate(INCUBATION_RATE_EDEFAULT);
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
			case StandardPackage.SEIR__INCUBATION_RATE:
				return incubationRate != INCUBATION_RATE_EDEFAULT;
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
		result.append(" (incubationRate: "); //$NON-NLS-1$
		result.append(incubationRate);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.NodeDecoratorImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue && incubationRate >= INCUBATION_RATE_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(incubationRate);
		assert retValue;
		
		retValue = retValue && !Double.isNaN(incubationRate);
		assert retValue;
		
		return retValue;
	} // sane

} // SEIRImpl

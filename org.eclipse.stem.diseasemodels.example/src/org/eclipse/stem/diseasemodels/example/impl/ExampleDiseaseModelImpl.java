package org.eclipse.stem.diseasemodels.example.impl;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.diseasemodels.example.ExampleDiseaseModel;
import org.eclipse.stem.diseasemodels.example.ExamplePackage;
import org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StochasticSIRDiseaseModelImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.example.impl.ExampleDiseaseModelImpl#getSeasonalModulationExponent <em>Seasonal Modulation Exponent</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.example.impl.ExampleDiseaseModelImpl#getModulationPeriod <em>Modulation Period</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.example.impl.ExampleDiseaseModelImpl#getModulationPhaseShift <em>Modulation Phase Shift</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.example.impl.ExampleDiseaseModelImpl#getSeasonalModulationFloor <em>Seasonal Modulation Floor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExampleDiseaseModelImpl extends StochasticSIRDiseaseModelImpl implements ExampleDiseaseModel {
	
	/**
	 * The default value of the '{@link #getSeasonalModulationExponent() <em>Seasonal Modulation Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeasonalModulationExponent()
	 * @generated
	 * @ordered
	 */
	protected static final double SEASONAL_MODULATION_EXPONENT_EDEFAULT = 2.0;
	/**
	 * The cached value of the '{@link #getSeasonalModulationExponent() <em>Seasonal Modulation Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeasonalModulationExponent()
	 * @generated
	 * @ordered
	 */
	protected double seasonalModulationExponent = SEASONAL_MODULATION_EXPONENT_EDEFAULT;
	/**
	 * The default value of the '{@link #getModulationPeriod() <em>Modulation Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModulationPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final double MODULATION_PERIOD_EDEFAULT = 365.256363051;
	/**
	 * The cached value of the '{@link #getModulationPeriod() <em>Modulation Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModulationPeriod()
	 * @generated
	 * @ordered
	 */
	protected double modulationPeriod = MODULATION_PERIOD_EDEFAULT;
	/**
	 * The default value of the '{@link #getModulationPhaseShift() <em>Modulation Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModulationPhaseShift()
	 * @generated
	 * @ordered
	 */
	protected static final double MODULATION_PHASE_SHIFT_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getModulationPhaseShift() <em>Modulation Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModulationPhaseShift()
	 * @generated
	 * @ordered
	 */
	protected double modulationPhaseShift = MODULATION_PHASE_SHIFT_EDEFAULT;
	/**
	 * The default value of the '{@link #getSeasonalModulationFloor() <em>Seasonal Modulation Floor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeasonalModulationFloor()
	 * @generated
	 * @ordered
	 */
	protected static final double SEASONAL_MODULATION_FLOOR_EDEFAULT = 0.6;
	/**
	 * The cached value of the '{@link #getSeasonalModulationFloor() <em>Seasonal Modulation Floor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeasonalModulationFloor()
	 * @generated
	 * @ordered
	 */
	protected double seasonalModulationFloor = SEASONAL_MODULATION_FLOOR_EDEFAULT;
	/**
	 * a false (Hidden) time counter used for this toy example
	 */
	//private double falseHiddenTimeExample = 0.0;
	
	private static final double MILLIS_PER_DAY = 1000.0*60.0*60.0*24.0;
	private static final double MILLIS_PER_YEAR = MILLIS_PER_DAY*365.256363051;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExampleDiseaseModelImpl() {
		super();
	}
	
	
	/**
	 * To create a user defined (experimental) disease mode, the user may wish 
	 * to extend the existing models but simply override two methods.
	 * computeDiseaseDeltas() sets the work flow for the model. The following example
	 * is derived from the standard code for all build in models but in the line below
	 * where we define final "double transmisionRate" we show and example modification
	 * where a periodic forcing factor { sin(freq*t) } is added to the code as an example
	 * modification.
	 * 
	 * @param time
	 * 			  current time
	 * @param currentState
	 *            the current state of the population
	 * @param diseaseLabel
	 *            the disease label for which the state transitions are being
	 *            computed.
	 * @param timeDelta
	 *            the time period (milliseconds) over which the population
	 *            members transition to new states          
	 * @return a disease state label value that contains the number of
	 *         delta changes in each disease state
	 * 
	 * Users can modify the method below to create their own model.
	 * 
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#computeDiseaseDeltas(StandardDiseaseModelLabelValue,
	 *      StandardDiseaseModelLabel, long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, final long timeDelta, DiseaseModelLabelValue returnValue) {
final SIRLabelValue currentSIR = (SIRLabelValue) currentState;
		
		double currentMillis = time.getTime().getTime();
		double seasonalModulationExponent = getSeasonalModulationExponent();
		double seasonalModulationFloor = getSeasonalModulationFloor();
		double phase = getModulationPhaseShift();	
		double modulation = seasonalModulationFloor + (1-seasonalModulationFloor)*Math.pow(Math.abs(Math.sin(phase + Math.PI*currentMillis/(getModulationPeriod()*MILLIS_PER_DAY))), seasonalModulationExponent);
		
		// This is beta*
		double transmissionRate = modulation * (getAdjustedTransmissionRate(timeDelta));

		if(!this.isFrequencyDependent())  transmissionRate *= getTransmissionRateScaleFactor(diseaseLabel);
		
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
	 * ModelSpecificAdjustments for a Stochastic model adds noise to or adjusts 
	 * the disease state transition values by multiplying
	 * the additions by a random variable r ~ (1+/-x) with x small.
	 * The requirements that no more individuals can be moved from a state than are
	 * already in that state is still enforced.
	 * 
	 */
	public void doModelSpecificAdjustments(
			final StandardDiseaseModelLabelValue state) {
			final SILabelValue currentSI = (SILabelValue) state;
			double oldI = currentSI.getI();
			double Inoisy = currentSI.getI()* computeNoise();
			double change = oldI-Inoisy;
			currentSI.setI(Inoisy);
			double newS = currentSI.getS() + change;
			if(newS < 0.0) {
				// Need to rescale
				double scale = (currentSI.getS() + newS) / currentSI.getS();
				currentSI.setI(Inoisy*scale);
			} else  currentSI.setS(newS);
			return;
	} // doModelSpecificAdjustments
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExamplePackage.Literals.EXAMPLE_DISEASE_MODEL;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSeasonalModulationExponent() {
		return seasonalModulationExponent;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeasonalModulationExponent(double newSeasonalModulationExponent) {
		double oldSeasonalModulationExponent = seasonalModulationExponent;
		seasonalModulationExponent = newSeasonalModulationExponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT, oldSeasonalModulationExponent, seasonalModulationExponent));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getModulationPeriod() {
		return modulationPeriod;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModulationPeriod(double newModulationPeriod) {
		double oldModulationPeriod = modulationPeriod;
		modulationPeriod = newModulationPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PERIOD, oldModulationPeriod, modulationPeriod));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getModulationPhaseShift() {
		return modulationPhaseShift;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModulationPhaseShift(double newModulationPhaseShift) {
		double oldModulationPhaseShift = modulationPhaseShift;
		modulationPhaseShift = newModulationPhaseShift;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PHASE_SHIFT, oldModulationPhaseShift, modulationPhaseShift));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSeasonalModulationFloor() {
		return seasonalModulationFloor;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeasonalModulationFloor(double newSeasonalModulationFloor) {
		double oldSeasonalModulationFloor = seasonalModulationFloor;
		seasonalModulationFloor = newSeasonalModulationFloor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR, oldSeasonalModulationFloor, seasonalModulationFloor));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT:
				return new Double(getSeasonalModulationExponent());
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PERIOD:
				return new Double(getModulationPeriod());
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PHASE_SHIFT:
				return new Double(getModulationPhaseShift());
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR:
				return new Double(getSeasonalModulationFloor());
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
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT:
				setSeasonalModulationExponent(((Double)newValue).doubleValue());
				return;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PERIOD:
				setModulationPeriod(((Double)newValue).doubleValue());
				return;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PHASE_SHIFT:
				setModulationPhaseShift(((Double)newValue).doubleValue());
				return;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR:
				setSeasonalModulationFloor(((Double)newValue).doubleValue());
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
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT:
				setSeasonalModulationExponent(SEASONAL_MODULATION_EXPONENT_EDEFAULT);
				return;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PERIOD:
				setModulationPeriod(MODULATION_PERIOD_EDEFAULT);
				return;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PHASE_SHIFT:
				setModulationPhaseShift(MODULATION_PHASE_SHIFT_EDEFAULT);
				return;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR:
				setSeasonalModulationFloor(SEASONAL_MODULATION_FLOOR_EDEFAULT);
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
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_EXPONENT:
				return seasonalModulationExponent != SEASONAL_MODULATION_EXPONENT_EDEFAULT;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PERIOD:
				return modulationPeriod != MODULATION_PERIOD_EDEFAULT;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__MODULATION_PHASE_SHIFT:
				return modulationPhaseShift != MODULATION_PHASE_SHIFT_EDEFAULT;
			case ExamplePackage.EXAMPLE_DISEASE_MODEL__SEASONAL_MODULATION_FLOOR:
				return seasonalModulationFloor != SEASONAL_MODULATION_FLOOR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (seasonalModulationExponent: "); //$NON-NLS-1$
		result.append(seasonalModulationExponent);
		result.append(", modulationPeriod: "); //$NON-NLS-1$
		result.append(modulationPeriod);
		result.append(", modulationPhaseShift: "); //$NON-NLS-1$
		result.append(modulationPhaseShift);
		result.append(", seasonalModulationFloor: "); //$NON-NLS-1$
		result.append(seasonalModulationFloor);
		result.append(')');
		return result.toString();
	}

} //ExampleDiseaseModelImpl

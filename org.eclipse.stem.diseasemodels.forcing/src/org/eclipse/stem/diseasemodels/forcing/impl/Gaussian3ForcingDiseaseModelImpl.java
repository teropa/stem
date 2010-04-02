/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.forcing.impl;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.forcing.ForcingPackage;
import org.eclipse.stem.diseasemodels.forcing.Gaussian3ForcingDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gaussian3 Forcing Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.impl.Gaussian3ForcingDiseaseModelImpl#getSigma2_3 <em>Sigma2 3</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.impl.Gaussian3ForcingDiseaseModelImpl#getTransmissionRate2 <em>Transmission Rate2</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.forcing.impl.Gaussian3ForcingDiseaseModelImpl#getTransmissionRate3 <em>Transmission Rate3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Gaussian3ForcingDiseaseModelImpl extends Gaussian2ForcingDiseaseModelImpl implements Gaussian3ForcingDiseaseModel {
	/**
	 * The default value of the '{@link #getSigma2_3() <em>Sigma2 3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSigma2_3()
	 * @generated
	 * @ordered
	 */
	protected static final double SIGMA2_3_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSigma2_3() <em>Sigma2 3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSigma2_3()
	 * @generated
	 * @ordered
	 */
	protected double sigma2_3 = SIGMA2_3_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransmissionRate2() <em>Transmission Rate2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionRate2()
	 * @generated
	 * @ordered
	 */
	protected static final double TRANSMISSION_RATE2_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTransmissionRate2() <em>Transmission Rate2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionRate2()
	 * @generated
	 * @ordered
	 */
	protected double transmissionRate2 = TRANSMISSION_RATE2_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransmissionRate3() <em>Transmission Rate3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionRate3()
	 * @generated
	 * @ordered
	 */
	protected static final double TRANSMISSION_RATE3_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTransmissionRate3() <em>Transmission Rate3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionRate3()
	 * @generated
	 * @ordered
	 */
	protected double transmissionRate3 = TRANSMISSION_RATE3_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Gaussian3ForcingDiseaseModelImpl() {
		super();
	}

	private Long firstTime = new Long(Long.MAX_VALUE);
	private Calendar calendar = Calendar.getInstance();
	private Calendar calendar2 = Calendar.getInstance();
	private static final double MILLIS_PER_DAY = 1000.0*60.0*60.0*24.0;

	private ArrayList<Long> writtedTimes = new ArrayList<Long>();
	private FileWriter fw;
	
	private int [] whichGaussian = {0, 0, 0, 1, 0, 2, 0, 0, 2, 0, 1};
	
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, final long timeDelta, DiseaseModelLabelValue returnValue) {
		final SIRLabelValue currentSIR = (SIRLabelValue) currentState;
		
		long currentMillis = time.getTime().getTime();
		double seasonalModulationFloor = getModulationFloor();
		double modulationPeriod = getModulationPeriod();
		double phase = getModulationPhaseShift();	
		double sigma2 = getSigma2();		
		double sigma2_2 = getSigma2_2();
		double sigma2_3 = getSigma2_3();
		
		synchronized(firstTime) {
			if(firstTime.longValue() == Long.MAX_VALUE)
				firstTime = new Long(time.getTime().getTime());
		}
		
		// Get the day from time and adjust for the phase	
		double day=0;
		// Shared calendar object not thread safe
		synchronized(calendar) {
			calendar.setTimeInMillis(currentMillis+(long)(phase*MILLIS_PER_DAY));
			calendar2.setTimeInMillis(firstTime.longValue());
			day = (calendar.getTimeInMillis() - calendar2.getTimeInMillis())/MILLIS_PER_DAY;
		}
		int year = (int)(day / modulationPeriod);
		double iday = day;
		
		int gaussian = whichGaussian[year];
		
		
		double modulation = 0;

		// Smoothing
		if(day % modulationPeriod < 30 || day % modulationPeriod > modulationPeriod-30) {
			double avg=0;
			double denom = 0;
			for(double d=day-30;d<day+30;++d) {
				int _y = (int)(d / modulationPeriod);
				if(_y < 0) _y =0;
				if(_y >= whichGaussian.length) _y = whichGaussian.length-1;
				int _g = whichGaussian[_y];
				double _d = ((d % modulationPeriod)-modulationPeriod/2.0)/modulationPeriod;
				double mo = 0;						
				if(_g == 0)
					mo = (1/Math.sqrt(2*Math.PI*sigma2))*Math.exp(-(Math.pow(_d,2))/(2*sigma2))*getTransmissionRate()* ((double) timeDelta / (double) getTimePeriod());						
				else if(_g == 1)
					mo = (1/Math.sqrt(2*Math.PI*sigma2_2))*Math.exp(-(Math.pow(_d,2))/(2*sigma2_2))*getTransmissionRate2()* ((double) timeDelta / (double) getTimePeriod());
				else if(_g == 2)
					mo = (1/Math.sqrt(2*Math.PI*sigma2_3))*Math.exp(-(Math.pow(_d,2))/(2*sigma2_3))*getTransmissionRate3()* ((double) timeDelta / (double) getTimePeriod());
			
				avg = avg+mo;
				++denom;
			}
			modulation = avg/denom;
		} else {
			day = ((day % modulationPeriod)-modulationPeriod/2.0)/modulationPeriod;
			
			if(gaussian == 0)
				modulation = (1/Math.sqrt(2*Math.PI*sigma2))*Math.exp(-(Math.pow(day,2))/(2*sigma2))*getTransmissionRate()* ((double) timeDelta / (double) getTimePeriod());						
			else if(gaussian == 1)
				modulation = (1/Math.sqrt(2*Math.PI*sigma2_2))*Math.exp(-(Math.pow(day,2))/(2*sigma2_2)) * getTransmissionRate2()* ((double) timeDelta / (double) getTimePeriod());
			else if(gaussian == 2)
				modulation = (1/Math.sqrt(2*Math.PI*sigma2_3))*Math.exp(-(Math.pow(day,2))/(2*sigma2_3)) * getTransmissionRate3()* ((double) timeDelta / (double) getTimePeriod());
		}
		
		// This is beta*
		double transmissionRate = seasonalModulationFloor + modulation;


		synchronized(writtedTimes) {
			if(!writtedTimes.contains(time.getTime().getTime())) {
				try {
				if(fw == null) fw = new FileWriter("beta.csv");
				fw.write(time.getTime().getTime()+","+transmissionRate+"\n");
				fw.flush();
				} catch(Exception e) {
					e.printStackTrace();
				}
				writtedTimes.add(time.getTime().getTime());
			}
		}
		
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ForcingPackage.Literals.GAUSSIAN3_FORCING_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSigma2_3() {
		return sigma2_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSigma2_3(double newSigma2_3) {
		double oldSigma2_3 = sigma2_3;
		sigma2_3 = newSigma2_3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__SIGMA2_3, oldSigma2_3, sigma2_3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransmissionRate2() {
		return transmissionRate2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransmissionRate2(double newTransmissionRate2) {
		double oldTransmissionRate2 = transmissionRate2;
		transmissionRate2 = newTransmissionRate2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE2, oldTransmissionRate2, transmissionRate2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransmissionRate3() {
		return transmissionRate3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransmissionRate3(double newTransmissionRate3) {
		double oldTransmissionRate3 = transmissionRate3;
		transmissionRate3 = newTransmissionRate3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE3, oldTransmissionRate3, transmissionRate3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__SIGMA2_3:
				return getSigma2_3();
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE2:
				return getTransmissionRate2();
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE3:
				return getTransmissionRate3();
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
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__SIGMA2_3:
				setSigma2_3((Double)newValue);
				return;
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE2:
				setTransmissionRate2((Double)newValue);
				return;
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE3:
				setTransmissionRate3((Double)newValue);
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
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__SIGMA2_3:
				setSigma2_3(SIGMA2_3_EDEFAULT);
				return;
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE2:
				setTransmissionRate2(TRANSMISSION_RATE2_EDEFAULT);
				return;
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE3:
				setTransmissionRate3(TRANSMISSION_RATE3_EDEFAULT);
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
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__SIGMA2_3:
				return sigma2_3 != SIGMA2_3_EDEFAULT;
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE2:
				return transmissionRate2 != TRANSMISSION_RATE2_EDEFAULT;
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL__TRANSMISSION_RATE3:
				return transmissionRate3 != TRANSMISSION_RATE3_EDEFAULT;
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
		result.append(" (sigma2_3: "); //$NON-NLS-1$
		result.append(sigma2_3);
		result.append(", transmissionRate2: "); //$NON-NLS-1$
		result.append(transmissionRate2);
		result.append(", transmissionRate3: "); //$NON-NLS-1$
		result.append(transmissionRate3);
		result.append(')');
		return result.toString();
	}

} //Gaussian3ForcingDiseaseModelImpl
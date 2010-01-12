/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.diseasemodels.standard.impl;

import java.util.Random;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.math.BinomialDistributionUtil;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIRDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stochastic Poisson SIR Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StochasticPoissonSIRDiseaseModelImpl extends SIRImpl implements StochasticPoissonSIRDiseaseModel {
	private Random rand = new Random();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StochasticPoissonSIRDiseaseModelImpl() {
		super();
	}

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
		
		int S = (int)currentSIR.getS();
		double prob = 0.0;
		if(getNonLinearityCoefficient() != 1.0 && effectiveInfectious >= 0.0)
			prob = transmissionRate * Math.pow(effectiveInfectious, getNonLinearityCoefficient());
		else
			prob = transmissionRate * effectiveInfectious;
	    double rndVar = rand.nextDouble();
	    int pickN = 0;
	    pickN = BinomialDistributionUtil.fastPickFromBinomialDist(prob, S, rndVar);
	    	  
		// Move pickK from S to I;
		
		double numberOfSusceptibleToInfected = pickN;
		
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
		return StandardPackage.Literals.STOCHASTIC_POISSON_SIR_DISEASE_MODEL;
	}

	public void doModelSpecificAdjustments(LabelValue label) {
		// TODO Auto-generated method stub
		
	}

} //StochasticPoissonSIRDiseaseModelImpl

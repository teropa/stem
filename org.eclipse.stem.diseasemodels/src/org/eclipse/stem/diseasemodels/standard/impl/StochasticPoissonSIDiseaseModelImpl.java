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
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StochasticPoissonSIDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stochastic Poisson SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StochasticPoissonSIDiseaseModelImpl extends SIImpl implements StochasticPoissonSIDiseaseModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StochasticPoissonSIDiseaseModelImpl() {
		super();
	}

	private Random rand = new Random();
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#computeTransitions(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue,
	 *      long, double, long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, final long timeDelta, DiseaseModelLabelValue returnValue) {
		 
		final SILabelValue currentSI = (SILabelValue) currentState;
		
		// This is beta*
		double transmissionRate = getAdjustedTransmissionRate(timeDelta);
				
		if(!this.isFrequencyDependent()) transmissionRate *= getTransmissionRateScaleFactor(diseaseLabel);

		// The effective Infectious population  is a dimensionles number normalize by total
		// population used in teh computation of bets*S*i where i = Ieffective/Pop.
		// This includes a correction to the current
		// infectious population (Ieffective) based on the conserved exchange of people (circulation)
		// between regions. Note that this is no the "arrivals" and "departures" which are
		// a different process.
		final double effectiveInfectious = getNormalizedEffectiveInfectious(diseaseLabel.getNode(), diseaseLabel, currentSI.getI());

		int S = (int)currentSI.getS();
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
		
		double numberOfInfectedToSusceptible = getAdjustedRecoveryRate(timeDelta)
				* currentSI.getI();
		
	
		// Determine delta S
		final double deltaS = - numberOfSusceptibleToInfected + numberOfInfectedToSusceptible;
		// Determine delta I
		final double deltaI = numberOfSusceptibleToInfected - numberOfInfectedToSusceptible;	
	
		SILabelValueImpl ret = (SILabelValueImpl)returnValue;
		ret.setS(deltaS);
		ret.setI(deltaI);
		ret.setIncidence(numberOfSusceptibleToInfected);
		ret.setDiseaseDeaths(0.0);
		return ret;
	} // computeDiseaseDeltas
	
		 
		 public void doModelSpecificAdjustments(LabelValue label) {
				// TODO Auto-generated method stub
				
			}
		 
	 @Override
		public boolean isDeterministic() {
			return false;
		}
	 
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STOCHASTIC_POISSON_SI_DISEASE_MODEL;
	}

} //StochasticPoissonSIDiseaseModelImpl

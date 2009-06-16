
package org.eclipse.stem.util.analysis;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.eclipse.stem.analysis.States;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;

/**
 * Estimate parameters for an SI, SIR or SEIR model
 * 
 *
 */
public class NonLinearSEIRParameterEstimator extends SEIRparameterEstimator {

	// Unique states for this estimator
	double [] e;
	double [] r;
	
	/**
	 * @param data
	 */
	public NonLinearSEIRParameterEstimator(ReferenceScenarioDataInstance data) {
		super(data);
		List<Double> sToFit = new ArrayList<Double>();
		List<Double> eToFit = new ArrayList<Double>();
		List<Double> iToFit = new ArrayList<Double>();
		List<Double> rToFit = new ArrayList<Double>();
		
		List<Double> iList = data.getData().get(States.statesToFit[States.INFECTIOUS]);
		List<Double> sList = data.getData().get(States.statesToFit[States.SUSCEPTIBLE]);
		List<Double> rList = data.getData().get(States.statesToFit[States.RECOVERED]);
		List<Double> eList = data.getData().get(States.statesToFit[States.EXPOSED]);
		
		// ToDo: Why are we skipping the first value?
		for (int icount = 1; icount < iList.size(); icount ++) {
				iToFit.add(iList.get(icount));
				eToFit.add(eList.get(icount));
				sToFit.add(sList.get(icount));
				rToFit.add(rList.get(icount));
		}
		
		this.numDataPoints = iToFit.size();
		if(numDataPoints < MINSIZE) return;
		dataValid = true;
		this.s = new double[this.numDataPoints];
		this.e = new double[this.numDataPoints];
		this.i = new double[this.numDataPoints];
		this.r = new double[this.numDataPoints];
		this.t = new double[this.numDataPoints];
		int npts = this.numDataPoints;
		double[][] dataS = new double[2][npts - 1];
		double[][] dataE = new double[2][npts - 1];
		double[][] dataI = new double[2][npts - 1];
		double[][] dataR = new double[2][npts - 1];
		
		for (int icount = 0; icount < this.numDataPoints; icount ++) {
			s[icount] = sToFit.get(icount).doubleValue();
			e[icount] = eToFit.get(icount).doubleValue();
			i[icount] = iToFit.get(icount).doubleValue();
			r[icount] = rToFit.get(icount).doubleValue();
			t[icount] = icount;

			// init the raw data for plotting
			// *****************************************************************************************
			// TODO need to fill the selected array in the code for this class *************************
			// *****************************************************************************************
			if(icount < this.numDataPoints-1) {
				dataS[0][icount] = (s[icount]+s[icount+1])/2.0;
				dataE[0][icount] = (e[icount]+e[icount+1])/2.0;
				dataI[0][icount] = (i[icount]+i[icount+1])/2.0;
				dataR[0][icount] = (r[icount]+r[icount+1])/2.0;
				dataS[1][icount] = (s[icount]+s[icount+1])/2.0;
				dataE[1][icount] = (e[icount]+e[icount+1])/2.0;
				dataI[1][icount] = (i[icount]+i[icount+1])/2.0;
				dataR[1][icount] = (r[icount]+r[icount+1])/2.0;
				// init the selected data array
				for (int chartIndex = 0; chartIndex < 4; chartIndex ++ ) {
					// THIS IS WRONG
					dataS[1][icount] = 0.0;
					dataE[1][icount] = 0.0;
					dataI[1][icount] = 0.0;
					dataR[1][icount] = 0.0;
				}// init selected
			}// init the date

		}// for icount
	}// constructor

	/**
	 * Estimate the parameters
	 * @param localDensity 
	 * @param localPopulation 
	 * @param locationID 
	 * @return the ModelParameters estimate
	 */
	public ModelParameters estimate(double localDensity, double localPopulation, String locationID) {
		
		ModelParameters fittedParms = null;
		final double CRITICAL_SUSCEPTIBLE = 0.3;
		
		int npts = s.length;
		assert(npts == e.length);
		assert(npts==i.length);
		assert(npts==r.length);
		
		/*
		 * Begin SEIR fitting to find parameters including beta function
		 */
		
		//first find alpha and epsilon
		double[] dS = new double[npts];
		double[] lnE = new double[npts];
		double[] dlnE = new double[npts];
		
		for(int j = 0; j < npts; j++){
			lnE[j] = Math.log(e[j]);
		}
		
		
		//derivatives of endpoints
		dS[0] = s[1] - s[0];
		dS[npts-1] = s[npts-1] - s[npts-2];
		dlnE[0] = lnE[1] - lnE[0]; 
		dlnE[npts-1] = lnE[npts-1] - lnE[npts-2];

		//derivatives of all other points
		for(int j = 1;j < npts-1;j++)
		{
			dS[j] = (s[j+1] - s[j-1])/2;
			dlnE[j] = (lnE[j+1] - lnE[j-1])/2;
		}
		
	
		//x and y for least squares fitting
		double[] x = new double[npts];
		double[] y = new double[npts];
		
		for(int j = 0; j < npts; j++){
			x[j] = r[j]/e[j];
			y[j] = (1/e[j])*dS[j]+dlnE[j];
		}
		
		//sums for least squares fitting
		double sumx  = 0;
		double sumy = 0;
		double sumxy = 0;
		double sumx2 = 0;
		double sumy2 = 0;
		double sum = 0;
		
		for(int j = 0; j < npts; j++){
			sumx += x[j];
			sumy += y[j];
			sumxy += x[j] * y[j];
			sumx2 += x[j] * x[j];
			sumy2 += y[j] * y[j];
			sum += 1;
		}
		
		//delta for Cramer's Rule
		double delta = -(sum*sumx2 - sumx*sumx);
		double alpha = -(sum*sumxy - sumx*sumy)/delta;
		double epsilon = (sumx2*sumy - sumx*sumxy)/delta;
		
		//variance and std
		double variance = (sumy2 + sum*epsilon*epsilon + alpha*alpha*sumx2
				-2*(alpha*sumxy - epsilon*sumy + epsilon*alpha*sumx))/(npts-2);
		
		double varAlpha = -(variance/delta)*sum;
		double varEpsilon = -(variance/delta)*sumx2;
		
		double stdAlpha = Math.sqrt(varAlpha);
		double stdEpsilon = Math.sqrt(varEpsilon);
		
		//now find beta and lambda
		
		//x and y for least squares fitting
		
		// TODO Question for Barbara Jone
		// PROBLEM: what does it mean when 
		// (alpha*r - dS) is negative  ??
		//  this gives NaN for log
		for(int j = 0; j < npts; j++){
			x[j] = Math.log(((s[j]+e[j]+i[j])-CRITICAL_SUSCEPTIBLE)/(1-CRITICAL_SUSCEPTIBLE));
			y[j] = Math.log((alpha*r[j] - dS[j])/(s[j]*i[j]));
		}
		
		//sums for least squares fitting, set back to zero
	    sumx  = 0;
	    sumy = 0;
		sumxy = 0;
		sumx2 = 0;
		sumy2 = 0;
		sum = 0;
		
		for(int j = 0; j < npts; j++){
			sumx += x[j];
			sumy += y[j];
			sumxy += x[j] * y[j];
			sumx2 += x[j] * x[j];
			sumy2 += y[j] * y[j];
			sum += 1;
		}
		
		delta = sum*sumx2 - sumx*sumx;
		double lnBeta = (sumy*sumx2 - sumx*sumxy)/delta;
		double lambda = (sum*sumxy - sumx*sumy)/delta;
		
		double beta = Math.exp(lnBeta);
		
		//variance and std
		variance = (sumy2 + lnBeta*lnBeta*sum + lambda*lambda*sumx2
				-2*(lnBeta*sumy + lambda*sumxy + lnBeta*lambda*sumx))/(npts-2);
		
		double varLnBeta = (variance/delta)*sumx2;
		double varLambda = (variance/delta)*sum;
		
		double stdLnBeta = Math.sqrt(varLnBeta);
		double stdLambda = Math.sqrt(varLambda);
		
		//TODO How to find std and variance of Beta rather than lnBeta
		
		fittedParms = new ModelParameters();
		double newbeta = beta;
		if(!useFreqDependantBeta) newbeta *= ((ModelParameters.REFERENCE_POPULATION_DENSITY)/localDensity);
		fittedParms.addParameter(Parameter.BETA, new Parameter(Parameter.BETA, newbeta));
		fittedParms.addParameter(Parameter.LNBETA, new Parameter(Parameter.LNBETA, lnBeta, stdLnBeta, varLnBeta));
		fittedParms.addParameter(Parameter.ALPHA, new Parameter(Parameter.ALPHA, alpha, stdAlpha, varAlpha));
		fittedParms.addParameter(Parameter.EPSILON, new Parameter(Parameter.EPSILON, epsilon, stdEpsilon, varEpsilon));
		fittedParms.addParameter(Parameter.LAMBDA, new Parameter(Parameter.LAMBDA, lambda, stdLambda, varLambda));
	       
		return fittedParms;
	} // estimate
	
	
}

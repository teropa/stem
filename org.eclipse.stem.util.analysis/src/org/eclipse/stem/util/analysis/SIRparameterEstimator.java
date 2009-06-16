
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
 * Estimate parameters for an SIR model
 * 
 *
 */
public class SIRparameterEstimator extends ParameterEstimator{

	// Unique state for this estimator
	double [] r;
	
	static final double MINCUTOFF = 0.005;
	
	/**
	 * @param data
	 */
	public SIRparameterEstimator(ReferenceScenarioDataInstance data) {
		
		super(data);
		
		List<Double> sToFit = new ArrayList<Double>();
		List<Double> iToFit = new ArrayList<Double>();
		List<Double> rToFit = new ArrayList<Double>();
		
		List<Double> iList = data.getData().get(States.statesToFit[States.INFECTIOUS]);
		List<Double> sList = data.getData().get(States.statesToFit[States.SUSCEPTIBLE]);
		List<Double> rList = data.getData().get(States.statesToFit[States.RECOVERED]);
		
		// ToDo: Why are we skipping the first value?
		for (int icount = 1; icount < iList.size(); icount ++) {
				iToFit.add(iList.get(icount));
				sToFit.add(sList.get(icount));
				rToFit.add(rList.get(icount));
		}
		
		this.numDataPoints = iToFit.size();
		if(numDataPoints < MINSIZE) return;
		dataValid = true;
		this.p = new double[this.numDataPoints];
		this.s = new double[this.numDataPoints];
		this.i = new double[this.numDataPoints];
		this.r = new double[this.numDataPoints];
		this.t = new double[this.numDataPoints];
		 
		for (int icount = 0; icount < this.numDataPoints; icount ++) {
			s[icount] = sToFit.get(icount).doubleValue();
			i[icount] = iToFit.get(icount).doubleValue();
			r[icount] = rToFit.get(icount).doubleValue();
			p[icount] = s[icount]+i[icount]+r[icount];
			t[icount] = icount;
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

		ModelParameters fittedParms = new ModelParameters();
		
		//double reportBeta1 = 0;
		//double reportBeta2 = 0;
		
				
		int npts = s.length;
		assert(npts==i.length);
		assert(npts==r.length);
		
			double[] lnS = new double[npts];
			double[] dlnS = new double[npts-1];
			double[] lnI = new double[npts];
			double[] dlnI = new double[npts-1];
			double[] lnR = new double[npts];
			double[] dlnR = new double[npts-1];
			                           
			
			
			// average values about derivative
			double[] sAvg = new double[npts-1];
			double[] iAvg = new double[npts-1];
			double[] rAvg = new double[npts-1];
			double[] pAvg = new double[npts-1];
			double[][] dataS = new double[2][npts - 1];
			double[][] dataI = new double[2][npts - 1];
			double[][] dataR = new double[2][npts - 1];
			        
			// get the logarithms
			double cutoff = 0.0000000005;

			for(int j = 0; j < npts; j++){
				if(s[j] >= cutoff) {
					lnS[j] = Math.log(s[j]);
				} else {
					lnS[j] = Math.log(cutoff);  // TODO fix this
				}
				if(i[j] >= cutoff) {
					lnI[j] = Math.log(i[j]);
				} else {
					lnI[j] = Math.log(cutoff);  // TODO fix this
				}
				if(r[j] >= cutoff) {
					lnR[j] = Math.log(r[j]);
				} else {
					lnR[j] = Math.log(cutoff);  // TODO fix this
				}
			}
			
			//derivatives of logarithms and averages of other points
			double sMax = 0.0;
			double iMax = 0.0;
			double rMax = 0.0;
			for(int j = 1;j < npts-1;j++)
			{
				dlnS[j-1] = (lnS[j]-lnS[j-1]); // dt = 1
				
				dlnI[j-1] = (lnI[j]-lnI[j-1]); // dt = 1
				dlnR[j-1] = (lnR[j]-lnR[j-1]); // dt = 1
				
				sAvg[j-1] = (s[j] + s[j-1])/2.0;
				iAvg[j-1] = (i[j] + i[j-1])/2.0;
				rAvg[j-1] = (r[j] + r[j-1])/2.0;
								
				if(sAvg[j-1] >= sMax) sMax = sAvg[j-1];
				if(iAvg[j-1] >= iMax) iMax = iAvg[j-1];
				if(rAvg[j-1] >= rMax) rMax = rAvg[j-1];
				
				pAvg[j-1] = (p[j] + p[j-1])/2.0;
			}
			
			///////////////////////////////////////////////////////////////			
			// dS/dt-> equation 1.
			//x, y for least squares fitting to line y = alpha*x - beta
			///////////////////////////////////////////////////////////////
			//
			List<Double> xList1 = new ArrayList<Double>();
			List<Double> yList1 = new ArrayList<Double>();
			List<Double> fitList1 = new ArrayList<Double>();
			for(int j = 0; j < npts-1; j++){
				double sNorm = sAvg[j]/sMax;
				double iNorm = iAvg[j]/iMax;
				double rNorm = rAvg[j]/rMax;
				
				dataS[0][j] = sNorm;
				dataI[0][j] = iNorm;
				dataR[0][j] = rNorm;
				// by default, selected data is the SAME
				dataS[1][j] = sNorm;
				dataI[1][j] = iNorm;
				dataR[1][j] = rNorm;
				
				if((sNorm<=maxSthreshold)&&(sNorm>=minSthreshold)&&(iNorm>=minIthreshold)&&(rNorm<=maxRthreshold)) {
					double numer = (pAvg[j]*rAvg[j]) / sAvg[j];
					xList1.add(new Double( numer/ iAvg[j] ) );
					yList1.add(new Double( dlnS[j] * (pAvg[j]/iAvg[j])  ));
					
				}else {
					// **** for plotting ******
					// here we define S*, I*, R*
					// NOT Selected = 0.0
					dataS[1][j] = 0.0;
					dataI[1][j] = 0.0;
					dataR[1][j] = 0.0;
					////******************/////
				}
			}
			LinearLeastSquaresFit lineFit1 = null;
			if(xList1.size() >2) {
				lineFit1 = new LinearLeastSquaresFit(xList1,yList1);
				// incpt
				double beta 	= -1.0*lineFit1.getIntercept();
				double varBeta 	= lineFit1.getInterceptVariance();
				double stdBeta 	= lineFit1.getInterceptStdDev();
				// slope
				double alpha 	= lineFit1.getSlope();
				double varAlpha = lineFit1.getSlopeVariance();
				double stdAlpha = lineFit1.getSlopeStdDev();
				double newbeta = beta;
				//reportBeta1 = beta;
				if(!useFreqDependantBeta) newbeta *= ((ModelParameters.REFERENCE_POPULATION_DENSITY)/localDensity);
				fittedParms.addParameter(Parameter.BETA, new Parameter(Parameter.BETA, newbeta, stdBeta, varBeta));
				fittedParms.addParameter(Parameter.ALPHA, new Parameter(Parameter.ALPHA, alpha, stdAlpha, varAlpha));
				//System.out.println("beta1 = "+newbeta+", alpha1 = "+alpha);
				
				// fit 1
				for (int i = 0; i< xList1.size(); i ++) {
					double val = (-lineFit1.getSlope()*xList1.get(i).doubleValue()) + lineFit1.getIntercept(); 
					fitList1.add(new Double(val));
				}
			}// if fit valid
			else {
				rejectCount += 1.0;
			}
			
			//////////////////////////////////////////////////////
			//Equation 2 +> dI/dt second fit for beta and epsilon
			List<Double> xList2 = new ArrayList<Double>();
			List<Double> yList2 = new ArrayList<Double>();
			List<Double> fitList2 = new ArrayList<Double>();
			//x, y for least squares fitting to line y = beta*x - epsilon
			for(int j = 0; j < npts-1; j++){
				double sNorm = sAvg[j]/sMax;
				double iNorm = iAvg[j]/iMax;
				if((sNorm<=maxSthreshold)&&(sNorm>=minSthreshold)&&(iNorm>=minIthreshold) ) {
					double ratio = pAvg[j] / sAvg[j];
					xList2.add(new Double( ratio ));
					yList2.add(new Double(ratio*dlnI[j]));
				}// if data in range
			}
			// TODO:  Plot restricted data
			LinearLeastSquaresFit lineFit2 = null;
			if(xList2.size() > 2) {
				lineFit2 = new LinearLeastSquaresFit(xList2,yList2);
				// slope
				double gamma		= -1.0* lineFit2.getSlope(); 
				double varGamma 	= lineFit2.getSlopeVariance();
				double stdGamma 	= lineFit2.getSlopeStdDev();
				// incpt
				double beta2 		= lineFit2.getIntercept();
				double varBeta2		= lineFit2.getInterceptVariance();
				double stdBeta2 	= lineFit2.getInterceptStdDev();
				double newbeta2 = beta2;
				//reportBeta2 = beta2;
				if(!useFreqDependantBeta) newbeta2 *= ((ModelParameters.REFERENCE_POPULATION_DENSITY)/localDensity);
				fittedParms.addParameter(Parameter.BETA2, new Parameter(Parameter.BETA2, newbeta2, stdBeta2, varBeta2));
				fittedParms.addParameter(Parameter.GAMMA, new Parameter(Parameter.GAMMA, gamma, stdGamma, varGamma));
				
				// fit 2
				for (int i = 0; i< xList2.size(); i ++) {
					double val = (lineFit2.getSlope()*xList2.get(i).doubleValue()) + lineFit2.getIntercept(); 
					fitList2.add(new Double(val));
				}
				
				//System.out.println("beta2 = "+newbeta2+", gamma1 = "+gamma);
			}// if fit valid
			else {
				rejectCount += 1.0;
			}
			
			
			///////////////////////////////////////////////////////
			///////////////////////////////////////////////////////
			// Equation 3.  find gamma and alpha
			// least squares fitting to line y = gamma*x - alpha
			List<Double> xList3 = new ArrayList<Double>();
			List<Double> yList3 = new ArrayList<Double>();
			List<Double> fitList3 = new ArrayList<Double>();
			//derivatives of all other points
			for(int j = 0;j < npts-1;j++) {
				double iNorm = iAvg[j]/iMax;
				double rNorm = rAvg[j]/rMax;
				if((iNorm>=minIthreshold)&&(rNorm>=minRthreshold)&&(rNorm<=maxRthreshold) ) {
					xList3.add(new Double(iAvg[j] / rAvg[j] ) );
					yList3.add(new Double(dlnR[j]));
				}
			}
			// TODO:  Plot restricted data
			LinearLeastSquaresFit lineFit3 = null;
			if(xList3.size() > 2) {
				lineFit3 = new LinearLeastSquaresFit(xList3,yList3);
				// incpt
				// TODO why is this coming out negative sometimes?
				double alpha2 		= Math.abs(-1.0*lineFit3.getIntercept()); 
				double varAlpha2	= lineFit3.getInterceptVariance();
				double stdAlpha2	= lineFit3.getInterceptStdDev();
				// slope
				double gamma2			= lineFit3.getSlope();
				double varGamma2		= lineFit3.getSlopeVariance();
				double stdGamma2 		= lineFit3.getSlopeStdDev();
				fittedParms.addParameter(Parameter.ALPHA2, new Parameter(Parameter.ALPHA2, alpha2, stdAlpha2, varAlpha2));
				fittedParms.addParameter(Parameter.GAMMA2, new Parameter(Parameter.GAMMA2, gamma2, stdGamma2, varGamma2));
				//System.out.println("alpha2 = "+alpha2+", gamma2 = "+gamma2);
				
				// fit 3
				for (int i = 0; i< xList3.size(); i ++) {
					double val = (lineFit3.getSlope()*xList3.get(i).doubleValue()) + lineFit3.getIntercept(); 
					fitList3.add(new Double(val));
				}
			} else {
				rejectCount += 1.0;
			}
			
			fittedParms.addParameter(Parameter.REJECT, new Parameter(Parameter.REJECT, rejectCount));	
			////////////////////////////////////////////////////////////////////////////////////////////////////
			// DONE
			////////////////////////////////////////////////////////////////////////////////////////////////////
			dataToPlot.add(dataS);
			dataToPlot.add(dataI);
			dataToPlot.add(dataR);
			fittedParms.addSelectedData(locationID, dataToPlot);
			
			double[][] regression1 = getSortedRegression(xList1, yList1); 
			double[][] regression2 = getSortedRegression(xList2, yList2); 
			double[][] regression3 = getSortedRegression(xList3, yList3);
			
			double[][] fit1 = getSortedRegression(xList1, fitList1); 
			double[][] fit2 = getSortedRegression(xList2, fitList2); 
			double[][] fit3 = getSortedRegression(xList3, fitList3); 
			
			regressionValues.add(regression1);
			regressionValues.add(regression2);
			regressionValues.add(regression3);
			
			fittedValues.add(fit1);
			fittedValues.add(fit2);
			fittedValues.add(fit3);
	
			fittedParms.addRegressionData(locationID, regressionValues);
			fittedParms.addFittedData(locationID, fittedValues);
			//System.out.println(""+localPopulation+", "+reportBeta1+", "+reportBeta2);
			
		return fittedParms;
	} // estimate
	
	/**
	 * The control needs this information but must get it through the analyzer from the Estimator
	 * created by the factory
	 * SIR models have 3 properties
	 * @see org.eclipse.stem.util.analysis.ParameterEstimator#getNumProperties()
	 */
	public int getNumProperties() {
		return 3;
	}
	
	
	
}

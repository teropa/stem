
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
public class SIparameterEstimator extends ParameterEstimator{

	/**
	 * @param data 
	 */
	public SIparameterEstimator(ReferenceScenarioDataInstance data) {
		super(data);
		
		List<Double> sToFit = new ArrayList<Double>();
		List<Double> iToFit = new ArrayList<Double>();
		
		List<Double> iList = data.getData().get(States.statesToFit[States.INFECTIOUS]);
		List<Double> sList = data.getData().get(States.statesToFit[States.SUSCEPTIBLE]);
		
		// ToDo: Why are we skipping the first value?
		for (int icount = 1; icount < iList.size(); icount ++) {
				iToFit.add(iList.get(icount));
				sToFit.add(sList.get(icount));
		}
		
		this.numDataPoints = iToFit.size();
		if(numDataPoints < MINSIZE) return;
		dataValid = true;
		this.s = new double[this.numDataPoints];
		this.i = new double[this.numDataPoints];
		this.t = new double[this.numDataPoints];

		for (int icount = 0; icount < this.numDataPoints; icount ++) {
			s[icount] = sToFit.get(icount).doubleValue();
			i[icount] = iToFit.get(icount).doubleValue();
			t[icount] = icount;
		}// for icount
	}

	/**
	 * Estimate the parameters
	 * @param localDensity 
	 * @param localPopulation 
	 * @param locationID 
	 * @return the ModelParameters estimate
	 */
	public ModelParameters estimate(double localDensity, double localPopulation, String locationID) {
		
		ModelParameters fittedParms = new ModelParameters();
		
		int npts = s.length;
		assert(npts==i.length);
		
			double[] lnS = new double[npts];
			double[] dlnS = new double[npts-1];
			double[] lnI = new double[npts];
			double[] dlnI = new double[npts-1];
			
			// average values about derivative
			double[] sAvg = new double[npts-1];
			double[] iAvg = new double[npts-1];
			double[] pAvg = new double[npts-1];
			double[][] dataS = new double[2][npts - 1];
			double[][] dataI = new double[2][npts - 1];
			
			// get the logarithms
			for(int j = 0; j < npts; j++){
				if(s[j] >= 0.0) {
					lnS[j] = Math.log(s[j]);
				} else {
					lnS[j] = -1.0;  // TODO fix this
				}
				if(i[j] >= 0.0) {
					lnI[j] = Math.log(i[j]);
				} else {
					lnI[j] = -1.0;  // TODO fix this
				}
			}
			
			//derivatives of logarithms and averages of other points
			for(int j = 1;j < npts-1;j++)
			{
				dlnS[j-1] = (lnS[j]-lnS[j-1]); // dt = 1
				dlnI[j-1] = (lnI[j]-lnI[j-1]); // dt = 1
				
				sAvg[j-1] = (s[j] + s[j-1])/2.0;
				iAvg[j-1] = (i[j] + i[j-1])/2.0;
				pAvg[j-1] = (p[j] + p[j-1])/2.0;
			}
			
			double sMax = data.getMaxS();
			double iMax = data.getMaxI();
			
			
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
				dataS[0][j] = sNorm;
				dataI[0][j] = iNorm;
				// by default, selected data is the SAME
				dataS[1][j] = sNorm;
				dataI[1][j] = iNorm;
				
				if((sNorm<=maxSthreshold)&&(sNorm>=minSthreshold)&&(iNorm>=minIthreshold) ) {
					double numer = (pAvg[j] / sAvg[j]);
					xList1.add(new Double( numer ) );
					yList1.add(new Double( (pAvg[j]/iAvg[j]) * dlnS[j]  ));
				}else {
					// **** for plotting ******
					// here we define S*, I*, R*
					// NOT Selected = 0.0
					dataS[1][j] = 0.0;
					dataI[1][j] = 0.0;
					////******************/////
				}
			}
			LinearLeastSquaresFit lineFit1 = null;
			if(xList1.size() > 2) {
				lineFit1 = new LinearLeastSquaresFit(xList1,yList1);
				// incpt
				double beta 	= lineFit1.getIntercept(); 
				double varBeta 	= lineFit1.getInterceptVariance();
				double stdBeta 	= lineFit1.getInterceptStdDev();
				// slope
				double alpha 	= lineFit1.getSlope();
				double varAlpha = lineFit1.getSlopeVariance();
				double stdAlpha = lineFit1.getSlopeStdDev();
				double newbeta = beta;
				if(!useFreqDependantBeta) newbeta *= ((ModelParameters.REFERENCE_POPULATION_DENSITY)/localDensity);
				fittedParms.addParameter(Parameter.BETA, new Parameter(Parameter.BETA, newbeta, stdBeta, varBeta));
				fittedParms.addParameter(Parameter.ALPHA, new Parameter(Parameter.ALPHA, alpha, stdAlpha, varAlpha));
				// fit
				for (int i = 0; i< xList1.size(); i ++) {
					double val = (lineFit1.getSlope()*xList1.get(i).doubleValue()) + lineFit1.getIntercept(); 
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
					xList2.add(new Double( ( pAvg[j] / sAvg[j]) ));
					yList2.add(new Double((pAvg[j]/sAvg[j]) *dlnI[j]));
				}// if data in range
			}
			// TODO:  Plot restricted data
			LinearLeastSquaresFit lineFit2 = null;
			if(xList2.size() > 2) {
				lineFit2 = new LinearLeastSquaresFit(xList2,yList2);
				// incpt
				double beta2		= lineFit2.getIntercept(); 
				double varBeta2 	= lineFit2.getInterceptVariance();
				double stdBeta2 	= lineFit2.getInterceptStdDev();
				// slope
				double alpha2 		= lineFit2.getSlope();
				double varAlpha2	= lineFit2.getSlopeVariance();
				double stdAlpha2 	= lineFit2.getSlopeStdDev();
				double newbeta2 = beta2 * ((ModelParameters.REFERENCE_POPULATION_DENSITY)/localDensity);
				fittedParms.addParameter(Parameter.BETA2, new Parameter(Parameter.BETA2, newbeta2, stdBeta2, varBeta2));
				fittedParms.addParameter(Parameter.ALPHA2, new Parameter(Parameter.ALPHA2, alpha2, stdAlpha2, varAlpha2));
		
				// fit
				for (int i = 0; i< xList2.size(); i ++) {
					double val = (lineFit2.getSlope()*xList2.get(i).doubleValue()) + lineFit2.getIntercept(); 
					fitList2.add(new Double(val));
				}		
			} // if fit valid
			else {
				rejectCount += 1.0;
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			// DONE
			////////////////////////////////////////////////////////////////////////////////////////////////////
			fittedParms.addParameter(Parameter.REJECT, new Parameter(Parameter.REJECT, rejectCount));
			
			dataToPlot.add(dataS);
			dataToPlot.add(dataI);
			fittedParms.addSelectedData(locationID, dataToPlot);
			
			double[][] regression1 = getSortedRegression(xList1, yList1); 
			double[][] regression2 = getSortedRegression(xList2, yList2);
			
			double[][] fit1 = getSortedRegression(xList1, fitList1); 
			double[][] fit2 = getSortedRegression(xList2, fitList2); 
			
			regressionValues.add(regression1);
			regressionValues.add(regression2);

			fittedValues.add(fit1);
			fittedValues.add(fit2);
			
			fittedParms.addRegressionData(locationID, regressionValues);
			fittedParms.addFittedData(locationID, fittedValues);
			
			
			
		return fittedParms;
	} // estimate
	
	/**
	 * SI models have 2 properties
	 * @see org.eclipse.stem.util.analysis.ParameterEstimator#getNumProperties()
	 */
	public int getNumProperties() {
		return 2;
	}
	
	
}

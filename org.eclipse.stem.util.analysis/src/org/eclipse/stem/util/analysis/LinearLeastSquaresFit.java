
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

import java.util.List;

/**
 * Do a least squared fit for a set of x,y data 
 * Data is passed as separate lists in the constructor
 *
 */
public class LinearLeastSquaresFit {
	
	/**
	 * best fit slope
	 */
	private double slope = 0;
	/**
	 * best fit intercept
	 */
	private double intercept = 0;
	/**
	 * variance of slope fit
	 */
	private double slopeVariance = 0;
	


	/**
	 * variance of intercept fit
	 */
	private double interceptVariance = 0;
	/**
	 * standard deviation of slope fit
	 */
	private double slopeStdDev = 0;
	/**
	 * standard deviation of intercept fit
	 */
	private double interceptStdDev = 0;
	
	
	/**
	 * constructor
	 * @param xList
	 * @param yList
	 */
	public LinearLeastSquaresFit(List<Double> xList, List<Double> yList) {
		
		int npts = xList.size();
		assert(npts == yList.size());
		
		//x, y for least squares fitting to line y = alpha*x - beta
		double[] x = new double[npts];
		double[] y = new double[npts];
		
		for(int j = 0; j < npts; j++){
			x[j] = xList.get(j).doubleValue();
			y[j] = yList.get(j).doubleValue();
		}
	
		// do the fit
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
		
		double delta = -(sum * sumx2 - sumx * sumx);
		// get the intercept
		intercept = (sumx * sumxy - sumy * sumx2)/delta;
		
		// get the slope
		slope = (sumx * sumy - sum * sumxy )/delta;
		
		//variance and std
		double variance = (sumy2+intercept*intercept*sum+slope*slope*sumx2
				-2*(-intercept*sumy+slope*sumxy+intercept*slope*sumx))/(npts-2);
		
		interceptVariance = Math.abs((variance/delta)*sumx2);
		slopeVariance = Math.abs((variance/delta)*sum);
		
		interceptStdDev = Math.sqrt(interceptVariance);
		slopeStdDev = Math.sqrt(slopeVariance);
		
	}
	
	/**
	 * constructor using simple arrays
	 * @param xList
	 * @param yList
	 */
	public LinearLeastSquaresFit(double[] xList, double[] yList) {
		
		int npts = xList.length;
		assert(npts == yList.length);
		
		//x, y for least squares fitting to line y = alpha*x - beta
		double[] x = xList;
		double[] y = yList;
		
	
		// do the fit
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
		
		double delta = -(sum * sumx2 - sumx * sumx);
		// get the intercept
		intercept = (sumx * sumxy - sumy * sumx2)/delta;
		
		// get the slope
		slope = (sumx * sumy - sum * sumxy )/delta;
		
		//variance and std
		double variance = (sumy2+intercept*intercept*sum+slope*slope*sumx2
				-2*(-intercept*sumy+slope*sumxy+intercept*slope*sumx))/(npts-2);
		
		interceptVariance = Math.abs((variance/delta)*sumx2);
		slopeVariance = Math.abs((variance/delta)*sum);
		
		interceptStdDev = Math.sqrt(interceptVariance);
		slopeStdDev = Math.sqrt(slopeVariance);
		
	}
	
	/**
	 * 
	 * @return the slope
	 */
	public double getSlope() {
		return slope;
	}


	/**
	 * 
	 * @return the intercept
	 */
	public double getIntercept() {
		return intercept;
	}


	/**
	 * 
	 * @return slopeVariance
	 */
	public double getSlopeVariance() {
		return slopeVariance;
	}


	/**
	 * 
	 * @return interceptVariance
	 */
	public double getInterceptVariance() {
		return interceptVariance;
	}


	/**
	 * 
	 * @return slopeStdDev
	 */
	public double getSlopeStdDev() {
		return slopeStdDev;
	}


	/**
	 * 
	 * @return interceptStdDev
	 */
	public double getInterceptStdDev() {
		return interceptStdDev;
	}

}


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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;
import org.eclipse.stem.util.analysis.views.EstimatorControl;

/**
 * Estimate parameters for an SI, SIR or SEIR model
 * 
 */

public abstract class ParameterEstimator {
	
	protected static final String keyS = "S";
	protected static final String keyE = "E";
	protected static final String keyI = "I";
	protected static final String keyR = "R";
	protected static final String keySelectedS = "S*";
	protected static final String keySelectedE = "E*";
	protected static final String keySelectedI = "I*";
	protected static final String keySelectedR = "R*";
	
	protected static final String keyXY1 = "X1vsY1";
	protected static final String keyXY2 = "X2vsY2";
	protected static final String keyXY3 = "X3vsY3";
	protected static final String keyXY4 = "X4vsY4";
	
	protected static final String keyFit1 = "Fit XY1";
	protected static final String keyFit2 = "Fit XY2";
	protected static final String keyFit3 = "Fit XY3";
	protected static final String keyFit4 = "Fit XY4";
	
	
	protected static double minSthreshold = 0.01;
	protected static double minEthreshold = 0.01;
	protected static double minIthreshold = 0.01;
	protected static double minRthreshold = 0.01;
	
	protected static double maxSthreshold = 0.99;
	protected static double maxEthreshold = 0.99;
	protected static double maxIthreshold = 0.99;
	protected static double maxRthreshold = 0.99;
	
	protected static boolean useFreqDependantBeta = true;
	

	/**
	 * rejected data where fit failed
	 */
	protected double rejectCount = 0.0;
	
	/*
	 * the SELECTED data to plot
	 */
	List<double[][]>  dataToPlot = new ArrayList<double[][]>();
	
	
	List<double[][]> regressionValues = new ArrayList<double[][]>();
	

	List<double[][]> fittedValues = new ArrayList<double[][]>();
	
	
	protected ReferenceScenarioDataInstance data;
	
	/**
	 * Sets the minimum number of points needed to do a reasonable fit
	 * TODO should not be hard coded
	 */
	protected static final int MINSIZE = 7;
	
	/**
	 * If derivativeMethod = LINEAR_DERIVATIVE  then a linear algorithm
	 * is used to compute derivatives
	 */
	public static final int LINEAR_DERIVATIVE = 1;
	
	
	/**
	 * If derivativeMethod = POLYNOMIAL_DERIVATIVE  then a polynomial algorithm
	 * is used to compute derivatives
	 */
	public static final int POLYNOMIAL_DERIVATIVE = 2;
	
	// All models have these vectors
	double[] p;
	double[] s;
	double[] i;
	double[] t;
		
	/**
	 * set to true only if there are enough points to do a reasonable fit
	 */
	public boolean dataValid = false;
	
	int numDataPoints;
	

	/**
	 * construct a new estimator for the input data[] SIR
	 * @param data
	 */
	public ParameterEstimator(ReferenceScenarioDataInstance data) {
		this.data = data;
		// Always Prepare the data for analysis
		this.data.findMaxValues();
	}
	
	/**
	 * The control needs this information but must get it through the analyzer from the Estimator
	 * created by the factory
	 * the number of differential equations in the solution
	 * @return number of equations determines the number of graphs
	 */
	public abstract int getNumProperties();
	
	/**
	 * The control needs this information but must get it through the analyzer from the Estimator
	 * created by the factory
	 * @param equationIndex , one chart per state S, E, I, and R.
	 * @param state 0 or 1 representing S and Sselected, I and I selected,etc.
	 * @return property name
	 */
	public String getProperty(int equationIndex, int state) {
		 switch (equationIndex) {
         case 0:  
        	 if(state==0) {
        		 return keyS;
        	 } else if (state==1) {
        		 return keySelectedS;
        	 } else if ((state==2)||(state==3)) {
        		 return keyXY1;
        	 }else  {
        		 return keyFit1;
        	 }
        	 
         case 1:  
        	 if(state==0) {
        		 return keyI;
        	 } else if (state==1) {
        		 return keySelectedI;
        	 } else if ((state==2)||(state==3)) {
        		 return keyXY2;
        	 }else  {
        		 return keyFit2;
        	 }
        	 
         case 2:  
        	 if(state==0) {
        		 return keyR;
        	 } else if (state==1) {
        		 return keySelectedR;
        	 } else if ((state==2)||(state==3)) {
        		 return keyXY3;
        	 }else  {
        		 return keyFit3;
        	 }
        	 
         case 3:   
        	 if(state==0) {
        		 return keyE;
        	 } else if (state==1) {
        		 return keySelectedE;
        	 } else if ((state==2)||(state==3)) {
        		 return keyXY4;
        	 }else  {
        		 return keyFit4;
        	 }
        	 
         default: return null;
		 }// switch	
	}// getProperty
	
	/**
	 * update the min and max thresholds from the
	 * EstimatorControl UI spinners
	 * @param controlParametersMap 
	 */
	public void setAllParameters(Map<String,Object> controlParametersMap) {
		if(controlParametersMap  !=null) {
			maxSthreshold = ((Double)controlParametersMap.get(EstimatorControl.MAX_S_KEY)).doubleValue();
			minSthreshold = ((Double)controlParametersMap.get(EstimatorControl.MIN_S_KEY)).doubleValue();
		
			maxEthreshold = ((Double)controlParametersMap.get(EstimatorControl.MAX_E_KEY)).doubleValue();
			minEthreshold = ((Double)controlParametersMap.get(EstimatorControl.MIN_E_KEY)).doubleValue();
			
			maxIthreshold = ((Double)controlParametersMap.get(EstimatorControl.MAX_I_KEY)).doubleValue();
			minIthreshold = ((Double)controlParametersMap.get(EstimatorControl.MIN_I_KEY)).doubleValue();
		
			maxRthreshold = ((Double)controlParametersMap.get(EstimatorControl.MAX_R_KEY)).doubleValue();
			minRthreshold = ((Double)controlParametersMap.get(EstimatorControl.MIN_R_KEY)).doubleValue();
			
			useFreqDependantBeta = ((Boolean) controlParametersMap.get(EstimatorControl.FREQ_MODE_KEY) ).booleanValue();
			
		}
		return;
	}// update Thresholds
	
	
	
	/**
	 * Estimate the parameters
	 * @param localDensity 
	 * @param localPopulation  
	 * @param locationID 
	 * @return the ModelParameters estimate
	 */
	public abstract ModelParameters estimate(double localDensity, double localPopulation, String locationID) ;
	
	
	/**
	 * Returns the raw data (state 0) and the selected data (state 1) 
	 * for each of the state variables S,E,I,R (chartIndex 0-3)
	 * @param chartIndex 
	 * @param state
	 * @return the data to plot
	 */
	public double[] getValues(int chartIndex, int state) {
		// pick the right data for the right chart
		if(state <= 1) {
			double[][] data = dataToPlot.get(chartIndex);
			return data[state];
		} 
		// regression data
		double[][] regression = regressionValues.get(chartIndex);
		return regression[state-2];
	}// getValues
	
	
	/**
	 * create a sorted regression (ordered by the x coordinate)
	 * @param xList
	 * @param yList
	 * @return the regression
	 */
	public double[][] getSortedRegression(List<Double> xList, List<Double> yList) {
		double[][] regression = new double[2][xList.size()];
		if(yList.size() != xList.size()) return regression;
		List<PhaseSpaceCoordinate> coords = new ArrayList<PhaseSpaceCoordinate>();
		for (int i = 0; i < xList.size(); i ++) {
			double x = xList.get(i).doubleValue();
			double y = yList.get(i).doubleValue();
			PhaseSpaceCoordinate coord = new PhaseSpaceCoordinate(x,y);
			coords.add(coord);
		}
		Object[] coordArray = coords.toArray();
		Arrays.sort(coordArray);
		for (int i = 0; i < xList.size(); i ++) {
			PhaseSpaceCoordinate coord = (PhaseSpaceCoordinate)coordArray[i];
			regression[0][i] = coord.xValue;
			regression[1][i] = coord.yValue;
		}
		return regression;
	}//getSortedRegression
	
}

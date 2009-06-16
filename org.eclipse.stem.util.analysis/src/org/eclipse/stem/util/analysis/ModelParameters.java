/**
 * 
 */
package org.eclipse.stem.util.analysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
   

/**
 * This class holds all the parameters that we might want to estimate
 * and their standard deviations and variances.
 */
public class ModelParameters {
	
	/**
	 * All model parameters are stored in this map
	 */
	private final HashMap<String, Parameter> parameters = new HashMap<String, Parameter>();
			
	
	/**
	 * All selected data as a List<double[][]> keyed by location
	 * for display. The double indices are data[state][chartIndex][time]
	 * where state indicates either raw data (state=0) or the selected time region of the data (state=1) 
	 * chart index selected for each of the state variables S,E,I,R (chartIndex 0-3)
	 */
	private final HashMap<String, List<double[][]> > selectedData = new HashMap<String, List<double[][]>>();
	
	/**
	 * All selected regression as a List<double[][]> keyed by location
	 * for display. The double indices are data[state][time]
	 * where state indicates either x axis (state=0) or y axis (state=1) 
	 * chart index selected for each of the state equations (chartIndex 0-3)
	 */
	private final HashMap<String, List<double[][]> > regressionData = new HashMap<String, List<double[][]>>();
			

	/**
	 * All selected fits to the regression as a List<double[][]> keyed by location
	 * for display. The double indices are data[state][time]
	 * where state indicates either x axis (state=0) or y axis (state=1) 
	 * chart index selected for each of the state equations (chartIndex 0-3)
	 */
	private final HashMap<String, List<double[][]> > fittedData = new HashMap<String, List<double[][]>>();
			

	
	
	/**
	 * the reference population density
	 * required to do an average across locations with varying density
	 */
	public static final double REFERENCE_POPULATION_DENSITY = 100.0;
	
	
	/**
	 * empty constructor
	 */
	public ModelParameters() {
		// Nothing here
	}

	
	/**
	 * average the data in a map of model parameters
	 * @param parameterIdMap
	 * @return the averaged modelParameters
	 */
	public ModelParameters average(Map<String,ModelParameters> parameterIdMap) {
		
		
		Iterator<String> iter = parameterIdMap.keySet().iterator();
		
		while((iter!=null)&&(iter.hasNext())) {
			String key = iter.next();
			ModelParameters parms = parameterIdMap.get(key);
			this.accumulateNumerator(parms);
			this.accumulateDenominator(parms);
			
			// and for display purposes save the data, by location, that went into the fit
			Iterator<String> iter2 = parms.selectedData.keySet().iterator();
			while((iter2!=null)&&(iter2.hasNext())) {
				String id = iter2.next();
				List<double[][]> data = parms.selectedData.get(id);
				this.selectedData.put(id, data);
			}	
			// and for display purposes save the regression, by location, that went into the fit
			Iterator<String> iter3 = parms.regressionData.keySet().iterator();
			while((iter3!=null)&&(iter3.hasNext())) {
				String id = iter3.next();
				List<double[][]> data = parms.regressionData.get(id);
				this.regressionData.put(id, data);
			}	
			
			// and for display purposes save the fitted data, by location, that went into the fit
			Iterator<String> iter4 = parms.fittedData.keySet().iterator();
			while((iter4!=null)&&(iter4.hasNext())) {
				String id = iter4.next();
				List<double[][]> data = parms.fittedData.get(id);
				this.fittedData.put(id, data);
			}	
		}// all locations
		this.average();
		this.calculateStdAvg();
		return this;
	}
	

	HashMap <String, Double> numerators = new HashMap<String, Double>();
	
	/**
	 * accumulate numerator values from another ModelParameters instance for calculating average
	 * @param other
	 */
	@SuppressWarnings("boxing")
	private void accumulateNumerator(ModelParameters other) {
		
		for(Parameter parm : other.getParameters().values()) {
			if(numerators.containsKey(parm.name))
				numerators.put(parm.name, 
						numerators.get(parm.name) + (parm.value / parm.variance));
			else
				numerators.put(parm.name, 
						parm.value / parm.variance);
		}
	}
	
	HashMap <String, Double> denominators = new HashMap<String, Double>();
	
	/**
	 * accumulate denominator values from another ModelParameters instance for calculating average
	 * @param other
	 */
	@SuppressWarnings("boxing")
	private void accumulateDenominator(ModelParameters other) {
		
		for(Parameter parm : other.getParameters().values()) {
			if(denominators.containsKey(parm.name))
				denominators.put(parm.name, 
						denominators.get(parm.name) + (1.0 / parm.variance));
			else
				denominators.put(parm.name, 
						(1.0 / parm.variance));
		}
	}
	
	/**
	 * divide to get average
	 */
	private void average() {
		for(String parm : this.numerators.keySet()) {
			double num = numerators.get(parm).doubleValue();
			double denom = denominators.get(parm).doubleValue();
			this.addParameter(parm, new Parameter(parm, num / denom  ));
		}// for
	}// average
	
	/**
	 * find std of each parameter average
	 */
	@SuppressWarnings("boxing")
	private void calculateStdAvg() {
		for(String parm : this.numerators.keySet()) {
			Parameter p = this.getParameter(parm);
			p.stddev = Math.sqrt(1.0 / denominators.get(parm));
		}
		
		// I assume the += below was a bug? - SED
/*		stdBeta += Math.sqrt(1/denominatorBeta);
		stdAlpha += Math.sqrt(1/denominatorAlpha);
		stdGamma += Math.sqrt(1/denominatorGamma);
		stdEpsilon += Math.sqrt(1/denominatorEpsilon);
		stdBeta2 += Math.sqrt(1/denominatorBeta2);
		stdAlpha2 += Math.sqrt(1/denominatorAlpha2);
		stdGamma2 += Math.sqrt(1/denominatorGamma2);
		stdEpsilon2 += Math.sqrt(1/denominatorEpsilon2);
		stdLambda += Math.sqrt(1/denominatorLambda);
	*/
	}

	
	/**
	 * add a new parameter to the map
	 * @param name Parameter name
	 * @param parm Parameter instance
	 */
	public void addParameter(String name, Parameter parm) {
		this.parameters.put(name, parm);
	}
	
	/**
	 * add selected data for display
	 * @param name location name
	 * @param data the selected data
	 */
	public void addSelectedData(String name, List<double[][]> data) {
		this.selectedData.put(name, data);
	}
	
	/**
	 * add selected regression for display
	 * @param name location name
	 * @param data the selected data
	 */
	public void addRegressionData(String name, List<double[][]> data) {
		this.regressionData.put(name, data);
	}
	
	
	/**
	 * add fitted data for display
	 * @param name location name
	 * @param data the selected data
	 */
	public void addFittedData(String name, List<double[][]> data) {
		this.fittedData.put(name, data);
	}
	

	/**
	 * Returns the raw data (state 0) and the selected data (state 1) 
	 * for each of the state variables S,E,I,R (chartIndex 0-3)
	 * @param id 
	 * @param chartIndex 
	 * @param state
	 * @return the data to plot
	 */
	public double[] getDataValues(String id, int chartIndex, int state) {
		List<double[][]> dataList = selectedData.get(id);
		double[][] data = dataList.get(chartIndex);
		// pick the right data for the right chart
		return data[state];
	}
	
	/**
	 * Returns the regression data (x = state 0, y = state 1) 
	 * for each of the state equations (chartIndex 0-3)
	 * @param id 
	 * @param chartIndex 
	 * @param state
	 * @return the data to plot
	 */
	public double[] getRegressionValues(String id, int chartIndex, int state) {
		List<double[][]> dataList = regressionData.get(id);
		double[][] data = dataList.get(chartIndex);
		// pick the right data for the right chart
		return data[state];
	}
	
	/**
	 * Returns the fitted data (x = state 0, y = state 1) 
	 * for each of the state equations (chartIndex 0-3)
	 * @param id 
	 * @param chartIndex 
	 * @param state
	 * @return the data to plot
	 */
	public double[] getFittedValues(String id, int chartIndex, int state) {
		List<double[][]> dataList = fittedData.get(id);
		double[][] data = dataList.get(chartIndex);
		// pick the right data for the right chart
		return data[state];
	}
	
	/**
	 * validate the key
	 * @param id
	 * @return true if valid
	 */
	public boolean validDataID(String id) {
		boolean retVal = false;
		if ((id != null)&&(selectedData.containsKey(id))) retVal = true;
		return retVal;
	}
	
	/**
	 * Returns the location IDs for which we analyzed data and
	 * stored the lists of selected data
	 * @return the location keys
	 */
	public String[] getDataLocations() {
		Set<String> keys = selectedData.keySet();
		// pick the right data for the right chart
		String[] ids = new String[keys.size()];
		Iterator<String> iter = keys.iterator();
		int i = 0;
		while(iter!=null&&iter.hasNext()) {
			ids[i] = iter.next();
			i++;
		}
		Arrays.sort(ids);
		return ids;
	}
	
	
	
	/**
	 * Return the parameters
	 * @return Map<String, Parameter> The parameters
	 */
	
	public Map<String, Parameter> getParameters() {
		return this.parameters;
	}
	
	/**
	 * Returns the specified parameter
	 * @param p The parameter name
	 * @return Parameter 
	 */
	
	public Parameter getParameter(String p) {
		return this.parameters.get(p);
	}
	/**
	 * containsParameter Check if the given parameter is in this model
	 * 
	 * @param p The parameter
	 * @return boolean True if p is in the model
	 */
	
	public boolean containsParameter(String p) {
		return this.parameters.containsKey(p);
	}
	/**
	 * return values as a string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		for(Parameter parm:this.parameters.values()) {
			buffer.append(parm.name).append("=").append(parm.value).append("\n");
			buffer.append("deviation(").append(parm.name).append(")").append("=").append(parm.stddev).append("\n");
			buffer.append("variance(").append(parm.name).append(")").append("=").append(parm.variance).append("\n");	
		}		
		return buffer.toString();
	} 

}

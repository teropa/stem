/**
 * 
 */
package org.eclipse.stem.util.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;


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
  * This class is designed to take a pair of time series each involving multiple epidemic waves. It uses one 
  * series as a reference an then phase shifts the peaks within the second data series so that the epidemics
  * are "synchronized". This is necessary in order to accurately fit model parameters of many locations without imposing a
  * transportation model. As the epidemic "moves", peaks occur at different times. Synchronizing allows us to estimate the epidemic
  * parameters without a transportation model. This class is used when the fitting is done by adding synchronized data over all locations.
  * This is not necessary if we can fit each location independantly, but is necessary when the amount of data is scarce (eg for real
  * epidemic incidence data).
 */
public class PhaseSynchronizer {
	
	ReferenceScenarioDataInstance reference;
	ReferenceScenarioDataInstance data;
	
	/**
	 * this phase shift maximizes the correlation between the two vectors
	 */
	int phaseShift;
	
	/**
	 * by default we will try to find max correlation for a shift of +/- 30 days
	 * if the vectors are shorter than this we reduce the window
	 */
	int defaultShiftWindow = 30;
	
	/**
	 * This class is designed to take a pair of ReferenceScenarioDataInstance(s) each involving multiple epidemic waves. It uses one 
	 * series as a reference an then phase shifts the peaks within the second incidence data series so that the epidemics
	 * are "synchronized". This is necessary in order to accurately fit model parameters of many locations without imposing a
	 * transportation model. As the epidemic "moves", peaks occur at different times. Synchronizing allows us to estimate the epidemic
	 * parameters without a transportation model. This class is used when the fitting is done by adding synchronized data over all locations.
	 * This is not necessary if we can fit each location independently, but is necessary when the amount of data is scarce (eg for real
	 * epidemic incidence data).
	 * @param refInstance
	 * 
	 */
	public PhaseSynchronizer(ReferenceScenarioDataInstance refInstance) {
		reference = refInstance;
		this.getPeakPositions(reference, "Incidence");
	}
	
	/**
	 * Finds index of peaks, returns as list
	 * @param instance
	 * @param key 
	 * @parameter key (must be I, E, or incidence - they have peaks)
	 * @return list of peak positions
	 */
	public List<Integer> getPeakPositions(ReferenceScenarioDataInstance instance, String key) {
		List<Double> vector = instance.getData().get(key);
		List<Integer> peaks = new ArrayList<Integer>();
		for (int i = 0; i < vector.size(); i ++) {
			double value = vector.get(i).doubleValue();
			double next = 0.0;
			double last = 0.0;
			if (i<(vector.size()-1)) next = vector.get(i+1).doubleValue();
			if (i>0) last = vector.get(i-1).doubleValue();
			if((value > next)&&(value>last)) {
				peaks.add(new Integer(i));
				// DEBUG
				//System.out.println("found peak at i="+i+", value="+value);
			}
		}
		return peaks;
	}
	
	/**
	 * Rotates the vector (List) by Shift - wrapping values from beginning to end or vice versa as necessary
	 * This should work for quasi periodic time series
	 * @param shift
	 * @param vector
	 * @return shifted vector
	 */
	public List<Double> getShiftedVector(int shift, List<Double> vector){
		List shifted = new ArrayList<Double>();
		int max = vector.size();
		for (int i = 0; i < max; i ++) {
			int j = i - shift;
			if (j >= max) {
				j = j - max;
			}
			if (j < 0) {
				j = max+j;
			}
			shifted.add(i,vector.get(j));
		}
		
		return shifted;
	}
 
}

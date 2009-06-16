/**
 * 
 */
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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.stem.analysis.States;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;

/** 
 * this class computes the mean square difference between two scenarios as a function of time
 * 1. It only looks at locations which are COMMON to both scenarios
 * 2. The time series should be the same length. If they are not this will compare of a period equal to
 *    the SHORTEST of all the time series. 
 * 3. It only considers locations where infectious count is nonzero in one or the other - not interested in weighting regions with no disease.
 * @author james
 *
 */
public class MeanSquareDifference {
	
	/**
	 * input
	 */
	Map<String,List<Double>> commonInfectiousLocationsA = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonInfectiousLocationsB = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonSusceptibleLocationsA = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonSusceptibleLocationsB = new HashMap<String,List<Double>>();
	Map<String,List<Double>> totalPopulation = new HashMap<String,List<Double>>();
	
	
	/**
	 * number common locations with nonzero Inf count at time t
	 */
	public double[] locationCount;
	/**
	 * The Result
	 */
	public double[] meanSqDiff;
	/**
	 * time
	 */
	public double[] time;
	
	/**
	 * Determines the MeanSquare difference between two scenario data sets over time each stored in a map
	 * @param scenarioMapA 
	 * @param scenarioMapB 
	 * @param runnableContext Runnable context for progress indicator
	 */
	public MeanSquareDifference(ReferenceScenarioDataMapImpl scenarioMapA, ReferenceScenarioDataMapImpl scenarioMapB, IRunnableContext runnableContext) {
		final ReferenceScenarioDataMapImpl mapA = scenarioMapA;
		final ReferenceScenarioDataMapImpl mapB = scenarioMapB;
		IRunnableWithProgress task = new IRunnableWithProgress() {
            public void run(IProgressMonitor progress) {
            	progress.beginTask("Calculating common locations...", mapA.getNumLocations());
     
				Iterator<String> iteratorA = mapA.getLocations().iterator();
				int maxTime = -1;
				while(iteratorA.hasNext()) {
					progress.worked(1);
					if(progress.isCanceled()) throw new OperationCanceledException();
					String id = iteratorA.next();
					
					if(mapB.containsLocation(id)) {
						
						// get the lists of data only for those locations that are common to both maps
						ReferenceScenarioDataInstance dataMapA = mapA.getLocation(id);
						List<Double> dataAI = getNormalizedInfectious(dataMapA);
						commonInfectiousLocationsA.put(id,dataAI);
						
						List<Double> dataAS = getNormalizedSusceptible(dataMapA);
						commonSusceptibleLocationsA.put(id,dataAS);
						
						
						// get the total population from Map A (same as map B for now
						totalPopulation.put(id, getTotalPopulation(dataMapA));
						
						// Map B
						ReferenceScenarioDataInstance dataMapB = mapB.getLocation(id);
						List<Double> dataBI = getNormalizedInfectious(dataMapB);
						commonInfectiousLocationsB.put(id,dataBI);
						
						List<Double> dataBS = getNormalizedSusceptible(dataMapB);
						commonSusceptibleLocationsB.put(id,dataBS);
						
						// init the array size
						if (maxTime == -1) maxTime = dataAI.size();
						
						// dimension the arrays to the length of the SMALLEST array for which we have data
						if(maxTime >= dataBI.size() ) maxTime = dataBI.size();
						if(maxTime >= dataAI.size() ) maxTime = dataAI.size();
					}// if
				}// while
				progress.done();
				if(maxTime<=0) maxTime = 0;
				if(time==null) {
					time = new double[maxTime];
					meanSqDiff = new double[maxTime];
					locationCount = new double[maxTime];
					for(int i = 0; i < maxTime; i ++) {
						time[i] = i;
						meanSqDiff[i] = 0.0;
						locationCount[i] = 0.0;
					}
				}
            }
		};
		try {
			runnableContext.run(true, false, task);
		} catch(InterruptedException ie) {
			// Task is not interruptable
		} catch(InvocationTargetException ite) {
			// Task is not interruptable
		}
	}// constructor MeanSquareDifference
	
	
	/**
	 * From the dataMap extract a list of normalize infectious (fraction of total population)
	 * @param dataMap
	 * @return normalize list of infectious people
	 */
	public List<Double> getNormalizedInfectious(ReferenceScenarioDataInstance dataMap) {
		final String SUSCEPTIBLE = States.statesToFit[States.SUSCEPTIBLE];
		final String EXPOSED = States.statesToFit[States.EXPOSED];
		final String INFECTIOUS = States.statesToFit[States.INFECTIOUS];
		final String RECOVERED = States.statesToFit[States.RECOVERED];
		
		// may or may not exist
		List<String> exposedList = null;
		List<String> recoveredList = null;
		 
		// MUST exist
		List<String> infectiousList = dataMap.getData(INFECTIOUS);
		List<String> susceptibleList = dataMap.getData(SUSCEPTIBLE);	
		assert(infectiousList!=null);
		assert(susceptibleList!=null);
		if(dataMap.containsParameter(EXPOSED)) {
			exposedList = dataMap.getData(EXPOSED);	
		}
		if(dataMap.containsParameter(RECOVERED)) {
			recoveredList = dataMap.getData(RECOVERED);	
		}
		
		List<Double> normalizedInfectious = new ArrayList<Double>();
		double[] totalPop = new double[infectiousList.size()];
		for (int i = 0; i < infectiousList.size(); i ++) {
			
			double inf = (new Double(infectiousList.get(i))).doubleValue();
			double susc = (new Double(susceptibleList.get(i))).doubleValue();
			double exposed = 0.0;
			double recovered = 0.0;
			if(exposedList!=null) {
				exposed = (new Double(exposedList.get(i))).doubleValue();
			}
			if(recoveredList!=null) {
				recovered = (new Double(recoveredList.get(i))).doubleValue();
			}
			totalPop[i] = inf+susc+exposed+recovered;
			inf /= totalPop[i];
			normalizedInfectious.add(new Double(inf));
		}
		return normalizedInfectious;
	}
	
	
	/**
	 * From the dataMap extract a list of normalize infectious (fraction of total population)
	 * @param dataMap
	 * @return normalize list of infectious people
	 */
	public List<Double> getNormalizedSusceptible(ReferenceScenarioDataInstance dataMap) {
		final String SUSCEPTIBLE = States.statesToFit[States.SUSCEPTIBLE];
		final String EXPOSED = States.statesToFit[States.EXPOSED];
		final String INFECTIOUS = States.statesToFit[States.INFECTIOUS];
		final String RECOVERED = States.statesToFit[States.RECOVERED];
		
		// may or may not exist
		List<String> exposedList = null;
		List<String> recoveredList = null;
		 
		// MUST exist
		List<String> infectiousList = dataMap.getData(INFECTIOUS);
		List<String> susceptibleList = dataMap.getData(SUSCEPTIBLE);	
		assert(infectiousList!=null);
		assert(susceptibleList!=null);
		if(dataMap.containsParameter(EXPOSED)) {
			exposedList = dataMap.getData(EXPOSED);	
		}
		if(dataMap.containsParameter(RECOVERED)) {
			recoveredList = dataMap.getData(RECOVERED);	
		}
		
		List<Double> normalizedSusceptible = new ArrayList<Double>();
		double[] totalPop = new double[susceptibleList.size()];
		for (int i = 0; i < susceptibleList.size(); i ++) {
			
			double inf = (new Double(infectiousList.get(i))).doubleValue();
			double susc = (new Double(susceptibleList.get(i))).doubleValue();
			double exposed = 0.0;
			double recovered = 0.0;
			if(exposedList!=null) {
				exposed = (new Double(exposedList.get(i))).doubleValue();
			}
			if(recoveredList!=null) {
				recovered = (new Double(recoveredList.get(i))).doubleValue();
			}
			totalPop[i] = inf+susc+exposed+recovered;
			if(totalPop[i] != 0.0) susc /= totalPop[i];
			else susc = 0; // some problem for air transporation nodes so added this fix
			normalizedSusceptible.add(new Double(susc));
		}
		return normalizedSusceptible;
	}
	
	/**
	 * From the dataMap extract a list of the total population)
	 * @param dataMap
	 * @return total population
	 */
	public List<Double> getTotalPopulation(ReferenceScenarioDataInstance dataMap) {
		final String SUSCEPTIBLE = States.statesToFit[States.SUSCEPTIBLE];
		final String EXPOSED = States.statesToFit[States.EXPOSED];
		final String INFECTIOUS = States.statesToFit[States.INFECTIOUS];
		final String RECOVERED = States.statesToFit[States.RECOVERED];
		
		// may or may not exist
		List<String> exposedList = null;
		List<String> recoveredList = null;
		 
		// MUST exist
		List<String> infectiousList = dataMap.getData(INFECTIOUS);
		List<String> susceptibleList = dataMap.getData(SUSCEPTIBLE);	
		assert(infectiousList!=null);
		assert(susceptibleList!=null);
		if(dataMap.containsParameter(EXPOSED)) {
			exposedList = dataMap.getData(EXPOSED);	
		}
		if(dataMap.containsParameter(RECOVERED)) {
			recoveredList = dataMap.getData(RECOVERED);	
		}
		
		List<Double> population = new ArrayList<Double>();
	
		for (int i = 0; i < infectiousList.size(); i ++) {
			double totalPop = 0.0;
			double inf = (new Double(infectiousList.get(i))).doubleValue();
			double susc = (new Double(susceptibleList.get(i))).doubleValue();
			double exposed = 0.0;
			double recovered = 0.0;
			if(exposedList!=null) {
				exposed = (new Double(exposedList.get(i))).doubleValue();
			}
			if(recoveredList!=null) {
				recovered = (new Double(recoveredList.get(i))).doubleValue();
			}
			totalPop = inf+susc+exposed+recovered;
			population.add(new Double(totalPop));
		}
		return population;
	}
	
	/**
	 * solves for the Root MeanSquareDifference vs time
	 * using infectious data only for now
	 * 
	 * @param runnableContext Runnable context for progress indicator
	 * @return comparison time series as double[]
	 */
	public double[] solve(IRunnableContext runnableContext) {
		IRunnableWithProgress task = new IRunnableWithProgress() {
            public void run(IProgressMonitor progress) {
            	progress.beginTask("Solving...", time.length);
				double[] maxPopulation = new double[time.length];
				for(int icount =0; icount < time.length; icount ++) {
					progress.worked(1);
					if(progress.isCanceled()) throw new OperationCanceledException();
					maxPopulation[icount] = 0.0;
					Iterator<String> iter = commonInfectiousLocationsA.keySet().iterator();
					////////////////////////
					// all locations
					while(iter.hasNext()) {
						String id = iter.next();
						List<Double> dataAI = commonInfectiousLocationsA.get(id);
						List<Double> dataBI = commonInfectiousLocationsB.get(id);
						
						List<Double> population = totalPopulation.get(id);
						
						double iA = dataAI.get(icount).doubleValue();
						double iB = dataBI.get(icount).doubleValue();
						double pop = population.get(icount).doubleValue();
		
						// double denom = (iA+iB)/2.0;
						// square of the average fraction of infectious people
						// denom *= denom;
						if ((iA > 0.0) || (iB > 0.0)) {
							// we have a location with nonzero data
							locationCount[icount] += 1.0;
							maxPopulation[icount] += pop;
							// square of the DIFFERENCE
							
							// Changed 2/4/09. Drop the S data comparison
							//double term = ((iA - iB) * (iA - iB))
							//		+ ((sA - sB) * (sA - sB));
							
							double term = ((iA - iB) * (iA - iB));
					
							double numer = pop * Math.sqrt(term);
							// normalize
							meanSqDiff[icount] += numer;
						}
						
					
					}// all locations
					
            ////////////////////////
			
					// normalize 
					if(locationCount[icount] >= 1.0) {
						meanSqDiff[icount] /= maxPopulation[icount];
					}
				}// for all time
				progress.done();
            } // run
		};
		
		try {
			runnableContext.run(true, true, task);
		} catch(InterruptedException ie) {
			return null;
		} catch(InvocationTargetException ive) {
			return null;
		}
		return meanSqDiff;	
	}// solve()

	
	
} // class MeanSquareDifference

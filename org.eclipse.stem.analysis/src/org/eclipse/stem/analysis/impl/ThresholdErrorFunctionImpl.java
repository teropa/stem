/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.stem.analysis.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.analysis.AnalysisFactory;
import org.eclipse.stem.analysis.AnalysisPackage;
import org.eclipse.stem.analysis.ErrorResult;
import org.eclipse.stem.analysis.ReferenceScenarioDataMap;
import org.eclipse.stem.analysis.ThresholdErrorFunction;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Threshold Error Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ThresholdErrorFunctionImpl extends ErrorFunctionImpl implements ThresholdErrorFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThresholdErrorFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.THRESHOLD_ERROR_FUNCTION;
	}

	/**
	 * Timeseries data for both data sets with common locations
	 */
	Map<String,List<Double>> commonInfectiousLocationsA = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonInfectiousLocationsB = new HashMap<String,List<Double>>();

	/**
	 * Max infectious per location
	 */
	Map<String,Double> maxInfA = new HashMap<String,Double>();
	Map<String,Double> maxInfB = new HashMap<String,Double>();
	
	/**
	 * The Result
	 */
	public double[] meanSqDiff;
	
	/*
	 * time
	 */
	public double[] time;
	
	protected AnalysisFactory aFactory = new AnalysisFactoryImpl();

	// This is the threshold of the maximum peak for both data sets
	// where we consider the error
	
	protected static double THRESHOLD = 0.1;
	
	/**
	 * calculate delta for a threshold error function
	 * 
	 * 
	 * @override
	 */
	
	public ErrorResult calculateError(ReferenceScenarioDataMap reference, ReferenceScenarioDataMap data) {
		final ReferenceScenarioDataMapImpl _ref = (ReferenceScenarioDataMapImpl)reference;
		final ReferenceScenarioDataMapImpl _data = (ReferenceScenarioDataMapImpl)data;

		double denominator = 0.0;
		// Clear
		time = null;
		
		Iterator<String> iteratorA = _ref.getLocations().iterator();
		int maxTime = -1;
		while(iteratorA.hasNext()) {
			String id = iteratorA.next();
					
			if(_data.containsLocation(id)) {
				// get the lists of data only for those locations that are common to both maps						ReferenceScenarioDataInstance dataMapA = mapA.getLocation(id);
				ReferenceScenarioDataInstance dataMapA = _ref.getLocation(id);
				List<Double> dataAI = getInfectious(dataMapA);
			
				commonInfectiousLocationsA.put(id,dataAI);
												
				// Map B
				ReferenceScenarioDataInstance dataMapB = _data.getLocation(id);
				List<Double> dataBI = getInfectious(dataMapB);
				commonInfectiousLocationsB.put(id,dataBI);
												
				// Find the peak in both data sets and remember. It will be used
				// to determine the threshold
				
				double maxA = -1;
				for(double d : dataAI) if(d > maxA) maxA = d;
				
				double maxB = -1;
				for(double d : dataBI) if(d > maxB) maxB = d;
	
				maxInfA.put(id, maxA);
				maxInfB.put(id, maxB);
				
				// init the array size
				if (maxTime == -1) maxTime = dataAI.size();
						
				// dimension the arrays to the length of the SMALLEST array for which we have data
				if(maxTime >= dataBI.size() ) maxTime = dataBI.size();
				if(maxTime >= dataAI.size() ) maxTime = dataAI.size();
			}// if
		}// while
		if(maxTime<=0) maxTime = 0;
		if(time==null) {
			time = new double[maxTime];
			meanSqDiff = new double[maxTime];
			for(int i = 0; i < maxTime; i ++) {
				time[i] = i;
				meanSqDiff[i] = 0.0;
			}
		}
		
		// Now figure out the actual error
		
		double[] maxPopulation = new double[time.length];

		for(int icount =0; icount < time.length; icount ++) {
			maxPopulation[icount] = 0.0;
			Iterator<String> iter = commonInfectiousLocationsA.keySet().iterator();
			////////////////////////
			// all locations
			while(iter.hasNext()) {
				String id = iter.next();
				List<Double> dataAI = commonInfectiousLocationsA.get(id);
				List<Double> dataBI = commonInfectiousLocationsB.get(id);
												
				double iA = dataAI.get(icount).doubleValue();
				double iB = dataBI.get(icount).doubleValue();
		
				// double denom = (iA+iB)/2.0;
				// square of the average fraction of infectious people
				// denom *= denom;
				double maxA = maxInfA.get(id);
				double maxB = maxInfB.get(id);

				if ((iA > maxA*THRESHOLD) || (iB > maxB*THRESHOLD)) {
					// we have a location with nonzero data
					// square of the DIFFERENCE
							
					// Changed 2/4/09. Drop the S data comparison
					//double term = ((iA - iB) * (iA - iB))
					//		+ ((sA - sB) * (sA - sB));
							
					double term = Math.abs(iA - iB);
					meanSqDiff[icount] += term;
					if(iA > iB) denominator+= iA; else denominator+= iB; 
				}					
			}// all locations
				
            ////////////////////////
	
		}// for all time
		
		
		// Sum all errors and divide by time
		
		double result = 0.0;
		BasicEList<Double> list = new BasicEList<Double>();
		for(int i=0;i<time.length;++i) {
			meanSqDiff[i] = meanSqDiff[i] / denominator;
			result += meanSqDiff[i];
			list.add(meanSqDiff[i]);
		}
		
		ErrorResult resultobj = aFactory.createErrorResult();
		resultobj.setErrorByTimeStep(list);
		resultobj.setError(result);
		return resultobj;	
	}
	
} //ThresholdErrorFunctionImpl

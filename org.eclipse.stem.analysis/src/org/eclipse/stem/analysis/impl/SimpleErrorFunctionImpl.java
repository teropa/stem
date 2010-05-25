package org.eclipse.stem.analysis.impl;

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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.analysis.AnalysisFactory;
import org.eclipse.stem.analysis.AnalysisPackage;
import org.eclipse.stem.analysis.ErrorResult;
import org.eclipse.stem.analysis.ReferenceScenarioDataMap;
import org.eclipse.stem.analysis.SimpleErrorFunction;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Error Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SimpleErrorFunctionImpl extends ErrorFunctionImpl implements SimpleErrorFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleErrorFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.SIMPLE_ERROR_FUNCTION;
	}

	/**
	 * input
	 */
	Map<String,List<Double>> commonInfectiousLocationsA = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonInfectiousLocationsB = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonPopulationLocationsA = new HashMap<String,List<Double>>();
	Map<String,List<Double>> commonPopulationLocationsB = new HashMap<String,List<Double>>();

	Map<String,Double> commonAvgPopulationLocationsA = new HashMap<String,Double>();
	Map<String,Double> commonAvgPopulationLocationsB = new HashMap<String,Double>();
	Map<String, Double> commonMaxLocationsA = new HashMap<String, Double>();
	
	/**
	 * number common locations with nonzero Inf count at time t
	 */
	public double[] locationCount;
	/**
	 * The Result
	 */
	public double[] meanSqDiff;
	/*
	 * time
	 */
	public double[] time;
	
	protected AnalysisFactory aFactory = new AnalysisFactoryImpl();

	// Set to true to weight the average by population size
	private static boolean AGGREGATE_NRMSE = true; // True if aggregate signal for locations first, then calculate NRMSE. False if use NRMSE per location then average.
	private static boolean WEIGHTED_AVERAGE = true; // Only used if AGGREGATE_NRMSE = false;
	private static boolean FIT_INCIDENCE = true;
	private static boolean USE_THRESHOLD = false;
	private static double THRESHOLD = 0.05;
	
	// The year to use to validate and hence exclude from the error calculation(for cross-validation methods)
	// The first year is year 0. If no year should be excluded, set to -1
	
	int validationYear = -1;
	
	
	/**
	 * calculate delta for a simple error function
	 * 
	 * 
	 * @override
	 */
	
	@Override
	public ErrorResult calculateError(ReferenceScenarioDataMap reference, ReferenceScenarioDataMap data) {
		final ReferenceScenarioDataMapImpl _ref = (ReferenceScenarioDataMapImpl)reference;
		final ReferenceScenarioDataMapImpl _data = (ReferenceScenarioDataMapImpl)data;

		// clear
		time = null;
		
		Iterator<String> iteratorA = _ref.getLocations().iterator();
		int maxTime = -1;
		while(iteratorA.hasNext()) {
			String id = iteratorA.next();
					
			if(_data.containsLocation(id)) {
				// get the lists of data only for those locations that are common to both maps						ReferenceScenarioDataInstance dataMapA = mapA.getLocation(id);
				ReferenceScenarioDataInstance dataMapA = _ref.getLocation(id);
				List<Double> dataAI = null;
				if(FIT_INCIDENCE) dataAI = getIncidence(dataMapA); 
				else dataAI = getInfectious(dataMapA);
				List<Double> dataAP = getPopulation(dataMapA);
				commonInfectiousLocationsA.put(id,dataAI);
				commonPopulationLocationsA.put(id, dataAP);							
							
				// Map B
				ReferenceScenarioDataInstance dataMapB = _data.getLocation(id);
				List<Double> dataBI = null;
				if(FIT_INCIDENCE) dataBI = getIncidence(dataMapB); 
				else dataBI = getInfectious(dataMapB);
				List<Double> dataBP = getPopulation(dataMapB);
				commonInfectiousLocationsB.put(id,dataBI);
				commonPopulationLocationsB.put(id, dataBP);
				
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
			locationCount = new double[maxTime];
			for(int i = 0; i < maxTime; i ++) {
				time[i] = i;
				meanSqDiff[i] = 0.0;
				locationCount[i] = 0.0;
			}
		}
		
		// Now figure out the actual error
		
		double [] Xref = new double[time.length];
		double [] Xdata = new double[time.length];
		
		double finalerror = 0.0;
	    double verror = 0.0;
		
		BasicEList<Double> list = new BasicEList<Double>();
		for(int i=0;i<time.length;++i)list.add(0.0);
		
		// Get the average population for each location
		for(String loc:commonPopulationLocationsA.keySet()) {
			List<Double>ld = commonPopulationLocationsA.get(loc);
			double sum = 0;for(double d:ld)sum+=d;
			sum /= (double)ld.size();
			commonAvgPopulationLocationsA.put(loc, sum);
		}		

		// Get the average population for each location
		for(String loc:commonPopulationLocationsB.keySet()) {
			List<Double>ld = commonPopulationLocationsB.get(loc);
			double sum = 0;for(double d:ld)sum+=d;
			sum /= (double)ld.size();
			commonAvgPopulationLocationsB.put(loc, sum);
		}		

		// Get the maximum value for the A series (reference)
		for(String loc:commonPopulationLocationsA.keySet()) {
			List<Double>ld = commonInfectiousLocationsA.get(loc);
			double max = Double.MIN_VALUE;
			for(double d:ld)if(d >max)max=d;
			commonMaxLocationsA.put(loc, max);
		}
		
		// Calculate the normalized root mean square error for each location, then
		// divide by the number of locatins
		
		double weighted_denom = 0.0;
		
		if(!AGGREGATE_NRMSE) { // Use NRMSE per location first
			for(String loc:commonInfectiousLocationsA.keySet()) {
				double maxRef = 0.0;
				double minRef = Double.MAX_VALUE;
				// Get the numbers at each time step for the location
				for(int icount =0; icount < time.length; icount ++) {
					List<Double> dataAI = commonInfectiousLocationsA.get(loc);
					List<Double> dataBI = commonInfectiousLocationsB.get(loc);
													
					double iA = dataAI.get(icount).doubleValue();
					double iB = dataBI.get(icount).doubleValue();
				
					Xref[icount]=iA;
					Xdata[icount]=iB;
				}
			
				double nominator = 0.0; 
				double timesteps = 0;
				for(int icount =0; icount < time.length; icount ++) {
					if(Xref[icount]>maxRef)maxRef = Xref[icount];
					if(Xref[icount]<minRef)minRef = Xref[icount];
					
					// If we use the threshold and both the reference and the model is less than
					// the THRESHOLD*MAXref(loc) we don't measure the data point
					
					if(USE_THRESHOLD && (Xref[icount]<=THRESHOLD*commonMaxLocationsA.get(loc) &&
							Xdata[icount]<=THRESHOLD*commonMaxLocationsA.get(loc))) continue;
					
					nominator = nominator + Math.pow(Xref[icount]-Xdata[icount], 2);
					list.set(icount, list.get(icount)+Math.abs(Xref[icount]-Xdata[icount]));
					++timesteps;
				}
				double error = Double.MAX_VALUE;
			    if(timesteps > 0 && maxRef-minRef > 0.0) {
			    	error = Math.sqrt(nominator/timesteps);
			    	error = error / (maxRef-minRef);
			    	if(WEIGHTED_AVERAGE) finalerror += commonAvgPopulationLocationsA.get(loc) * error;
			    	else finalerror += error;
			    	if(WEIGHTED_AVERAGE) weighted_denom += commonAvgPopulationLocationsA.get(loc);
			    	else weighted_denom += 1.0;
			    }
			
			}
		
			// Divide the error by the number of locations
			finalerror /= weighted_denom; 
		} else { // Aggregate signal, then calculate NRMSE 
			for(int icount =0; icount < time.length; icount ++) {
				for(String loc:commonInfectiousLocationsA.keySet()) {
					List<Double> dataAI = commonInfectiousLocationsA.get(loc);
					List<Double> dataBI = commonInfectiousLocationsB.get(loc);
													
					double iA = dataAI.get(icount).doubleValue();
					double iB = dataBI.get(icount).doubleValue();
				
					Xref[icount]+=iA;
					Xdata[icount]+=iB;
				}
			}
			
			double maxRef = Double.MIN_VALUE;
			double minRef = Double.MAX_VALUE;
			double maxValidationRef = Double.MIN_VALUE;
			double minValidationRef = Double.MAX_VALUE;
			
			for(int icount =0; icount < time.length; icount ++) {
				if(icount >= validationYear*365.25 && icount <= (validationYear+1)*365.25) {
					if(Xref[icount]>maxValidationRef)maxValidationRef = Xref[icount];
					if(Xref[icount]<minValidationRef)minValidationRef = Xref[icount];
					continue;
				}
				if(Xref[icount]>maxRef)maxRef = Xref[icount];
				if(Xref[icount]<minRef)minRef = Xref[icount];
			}
			double nominator = 0.0, vnominator = 0.0;
			double timesteps = 0.0, vtimesteps = 0.0;
			for(int icount =0; icount < time.length; icount ++) {
				
				// Calculate validation error then skip
				if(icount >= validationYear*365.25 && icount <= (validationYear+1)*365.25) {
					if(USE_THRESHOLD && (Xref[icount]<=THRESHOLD*maxValidationRef &&
							Xdata[icount]<=THRESHOLD*maxValidationRef)) continue;
					
					vnominator = vnominator + Math.pow(Xref[icount]-Xdata[icount], 2);
					list.set(icount, new Double(0)); // Set to 0 for validation data points
					++vtimesteps;
					continue;
				}
				// If we use the threshold and both the reference and the model is less than
				// the THRESHOLD*MAXref(loc) we don't measure the data point
				
				if(USE_THRESHOLD && (Xref[icount]<=THRESHOLD*maxRef &&
						Xdata[icount]<=THRESHOLD*maxRef)) continue;
				
				nominator = nominator + Math.pow(Xref[icount]-Xdata[icount], 2);
				list.set(icount, Math.abs(Xref[icount]-Xdata[icount]));
				++timesteps;
			}
			
			double error = Double.MAX_VALUE;
		    if(timesteps > 0 && maxRef-minRef > 0.0) {
		    	error = Math.sqrt(nominator/timesteps);
		    	finalerror = error / (maxRef-minRef);
		    }
		    // Validation
		    error = Double.MAX_VALUE;
		    if(vtimesteps > 0 && maxValidationRef-minValidationRef > 0.0) {
		    	error = Math.sqrt(vnominator/vtimesteps);
		    	verror = error / (maxValidationRef-minValidationRef);
		    }
		} // else
		ErrorResult resultobj = aFactory.createErrorResult();
		resultobj.setErrorByTimeStep(list);
		resultobj.setError(finalerror);
		resultobj.setValidationError(verror);
		
		EList<Double>refByTime = new BasicEList<Double>();
		EList<Double>dataByTime = new BasicEList<Double>();
		
		// Set the reference and model by time
		for(int icount=0;icount<time.length;++icount) {
			refByTime.add(0.0);dataByTime.add(0.0);}
		for(String loc:commonInfectiousLocationsA.keySet()) {
		 	for(int icount =0; icount < time.length; icount ++) {
				List<Double> dataAI = commonInfectiousLocationsA.get(loc);
				List<Double> dataBI = commonInfectiousLocationsB.get(loc);
												
				double iA = dataAI.get(icount).doubleValue();
				double iB = dataBI.get(icount).doubleValue();
			
				refByTime.set(icount, refByTime.get(icount)+iA);
				dataByTime.set(icount, dataByTime.get(icount)+iB);
			}
		}
		resultobj.setReferenceByTime(refByTime);
		resultobj.setModelByTime(dataByTime);
		return resultobj;	
	}
} //SimpleErrorFunctionImpl

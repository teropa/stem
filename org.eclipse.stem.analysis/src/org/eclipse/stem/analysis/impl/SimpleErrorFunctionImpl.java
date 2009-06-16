/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleErrorFunctionImpl.java,v 1.3 2009/04/11 11:08:28 sedlund Exp $
 */
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
	
	/**
	 * calculate delta for a simple error function
	 * 
	 * 
	 * @override
	 */
	
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
				List<Double> dataAI = getInfectious(dataMapA);
			
				commonInfectiousLocationsA.put(id,dataAI);
												
							
				// Map B
				ReferenceScenarioDataInstance dataMapB = _data.getLocation(id);
				List<Double> dataBI = getInfectious(dataMapB);
				commonInfectiousLocationsB.put(id,dataBI);
												
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
				if ((iA > 0.0) || (iB > 0.0)) {
					// we have a location with nonzero data
					locationCount[icount] += 1.0;
					// square of the DIFFERENCE
							
					// Changed 2/4/09. Drop the S data comparison
					//double term = ((iA - iB) * (iA - iB))
					//		+ ((sA - sB) * (sA - sB));
							
					double term = ((iA - iB) * (iA - iB));
					
					double numer = term;
					// normalize
					meanSqDiff[icount] += numer;
				}
						
					
			}// all locations
					
            ////////////////////////
			
			// normalize 
			if(locationCount[icount] >= 1.0) {
				meanSqDiff[icount] = Math.sqrt(meanSqDiff[icount] / locationCount[icount]);
			}
		}// for all time
		
		// Sum all errors and divide by time
		
		double result = 0.0;
		BasicEList<Double> list = new BasicEList<Double>();
		for(int i=0;i<time.length;++i) {
			result += meanSqDiff[i];
			list.add(meanSqDiff[i]);
		}
		
		ErrorResult resultobj = aFactory.createErrorResult();
		resultobj.setErrorByTimeStep(list);
		result = result/(double)time.length;
		resultobj.setError(result);
		
		return resultobj;	
	}
} //SimpleErrorFunctionImpl

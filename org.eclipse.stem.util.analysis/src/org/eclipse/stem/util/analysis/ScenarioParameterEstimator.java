/**
 * 
 */
package org.eclipse.stem.util.analysis;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.stem.analysis.States;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.ui.Utility;
import org.eclipse.stem.util.analysis.views.EstimatorControl;
import org.eclipse.stem.util.analysis.views.Messages;

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
 * Estimates rate constants for a scenario
 */
public class ScenarioParameterEstimator {
	
	/**
	 * The scenario data used for estimation
	 */
	
	ReferenceScenarioDataMapImpl referenceScenarioDataMap = null;
	
	/**
	 * The Parameter Estimator method we use
	 */
	
	ParameterEstimatorMethod parameterEstimatorMethod = null;
	
	/**
	 * This Set will contain locations with "good" data. Good data implies that at least
	 * the "I" state is defined and that maximum number of poeple in the "I" state at some time
	 * is large enough for the estimator to return an approximate beta coefficient 
	 */
	Set<String> referenceLocations;
	
	/**
	 * areas of the reference locations
	 * loaded from the scenario graph by ID
	 */
	Map<String,Double> referenceAreaDataMap;
	
	/**
	 * populations of the reference locations
	 * loaded from the scenario graph by ID
	 */
	Map<String,Double> referencePopulationDataMap;
	
	/**
	 * remember the max Infectious at each location
	 */
	Map<String,Double> maxInfectiousMap = new HashMap<String,Double>();
	
	ParameterEstimator estimator;
	
	/**
	 * Prefix for area. Format is
	 *   stem://org.eclipse.stem/label/area/USA/2/US-GA-13307
	 */
	private static final String AREA_URI_PREFIX = org.eclipse.stem.definitions.labels.AreaLabel.URI_TYPE_AREA_LABEL_SEGMENT;
	
	/**
	 * prefix for population. Format is
	 * stem://org.eclipse.stem/label/population/USA/2/US-GA-13307/human
	 *    
	 */
	private static final String POPULATION_URI_PREFIX = org.eclipse.stem.definitions.labels.PopulationLabel.URI_TYPE_POPULATION_LABEL_SEGMENT;
	
	/**
	 * TODO make gui item
	 * syntax is  
	 * stem://org.eclipse.stem/label/population/ISR/2/human/2006/IL-05-623
	 * Human only for now
	 */
	private static final String SPECIES = "human";
	
		
	/**
	 * analysis mode using ALL data including zeros
	 */
	public static final int ALL_MODE = 0;
	
	/**
	 * analysis mode analyzing data only when S,E,I,R are all > 0.0;
	 */
	public static final int NON_ZERO_DATA_MODE = 1;
	
	
	/**
	 * constant
	 */
	public static final String LEVEL_STRING = "level"; 	
	
	// fit all locations with max infectious populations >= FITTING_FRACTION * LARGEST Infectious Population
	private static final double FITTING_FRACTION = 0.05;
	
	/**
	 * The parent control
	 */
	protected EstimatorControl control = null;
	
	/**
	 * 
	 * @param scenarioDataMap
	 * @param parameterEstimatorMethod 
	 */
	public ScenarioParameterEstimator(ReferenceScenarioDataMapImpl scenarioDataMap, ParameterEstimatorMethod parameterEstimatorMethod) {
		referenceScenarioDataMap = scenarioDataMap;
		this.parameterEstimatorMethod = parameterEstimatorMethod;
		referenceLocations = getReferenceLocations();
		getAreaDataMap();
		getPopulationDataMap();
	}
	
	/**
	 * Estimate the rate parameters from the existing scenario data
	 * @param controlParamtersMap 
     * @param runnableContext Context for long running tasks
	 * @return map of parameters
	 */
	public Map<String,ModelParameters> estimateParameters(Map<String,Object> controlParamtersMap, IRunnableContext runnableContext) { 		
		final Map<String,Object> finalParameterMap = controlParamtersMap;
		
		final ParameterEstimatorMethod method = this.parameterEstimatorMethod;
		
		IScenarioParameterEstimatorRunnableWithProgress analysisTask = new IScenarioParameterEstimatorRunnableWithProgress() {
			public Map<String,ModelParameters> fittedParameters = new HashMap<String,ModelParameters>();
            public void run(IProgressMonitor progress) {
            	Iterator<String> iter = referenceLocations.iterator();
            	int icount = 0;
                progress.beginTask("Estimating parameters", referenceLocations.size());
                // TODO START this code exists only to TEST the CycleCompressor class
        		// TODO START this code exists only to TEST the CycleCompressor class
                // TODO SHOULD EVENTUALLY BE PART OF RONI's new VIEW
        		//List<String> allIDs = new ArrayList<String>();
        		//List<double[]> allCompressedIncidence = new ArrayList<double[]>();
        		// TODO END this code exists only to TEST the CycleCompressor class
        		// TODO END this code exists only to TEST the CycleCompressor class
                
                
                while(iter.hasNext()) {	
                	icount ++;
            		//if (icount%100==0) System.out.println(".");
            			
            		String id = iter.next();
            			
            		ReferenceScenarioDataInstance locationDataMap = referenceScenarioDataMap.getLocation(id);
            	
            		// TODO START this code exists only to TEST the CycleCompressor class
            		// TODO START this code exists only to TEST the CycleCompressor class
            		// TODO SHOULD EVENTUALLY BE PART OF RONI's new VIEW
            		//allIDs.add(id);
            		//CycleCompressor compressor = new CycleCompressor(locationDataMap);
            		//double[] result = compressor.getCompressedData();
            		//allCompressedIncidence.add(result);
            		// TODO END this code exists only to TEST the CycleCompressor class
            		// TODO END this code exists only to TEST the CycleCompressor class
            		
            		
           			estimator = ParameterEstimatorFactory.createEstimator(method, locationDataMap);
           			estimator.setAllParameters(finalParameterMap);
           			
           			double localArea = getArea(id).doubleValue();
           			assert(localArea > 0.0);
           			if(localArea == 0) localArea = 1.0; // should never happen
           			final double localPopulation = getPopulation(id).doubleValue();
           			final double localDensity = localPopulation/localArea;
           			ModelParameters parameters = estimator.estimate(localDensity, localPopulation,id);
           			//System.out.println("got parameters "+parameters.toString());
           			fittedParameters.put(id, parameters);
            		if (progress.isCanceled())
                        throw new OperationCanceledException();
            		progress.worked(1);
            	} // while
                
                // TODO START this code exists only to TEST the CycleCompressor class
        		// TODO START this code exists only to TEST the CycleCompressor class
                // TODO SHOULD EVENTUALLY BE PART OF RONI's new VIEW
                //CSVAnalysisWriter writer = new CSVAnalysisWriter("C:/runtime-stem.product/Mecids/recordedsimulations/Influenza/cycleCompressed/","Incidence");
        		//writer.logData(allIDs, allCompressedIncidence);
        		// TODO END this code exists only to TEST the CycleCompressor class
        		// TODO END this code exists only to TEST the CycleCompressor class
        		
                
                
                
                progress.done();
            }
            
            /**
             * Return the fitted parameters
             * @return Map<String, ModelParameters> result
             */
            public Map<String, ModelParameters> getFittedParameters() {
            	return this.fittedParameters;
            }
         };
         try {
        	 runnableContext.run(true, true, analysisTask);
         } catch(InterruptedException ie) {
        	 Activator.logError("", ie);
        	 return null;
         } catch(InvocationTargetException ite) {
        	 Activator.logError("", ite);
        	 return null;
         }
         return analysisTask.getFittedParameters();
	}//estimateParameters() 
	
	/**
	 * Average All data THEN Estimate the rate parameters from the averaged scenario data
	 * @param controlParamtersMap 
	 * @param runnableContext Context for long running tasks
	 * @return map of parameters
	 */
	public ModelParameters averageThenEstimateParameters(Map<String,Object> controlParamtersMap, IRunnableContext runnableContext) { 		 		
		final Map<String,Object> finalParameterMap = controlParamtersMap;
		final ParameterEstimatorMethod method = this.parameterEstimatorMethod;
		
		IAveragedParameterEstimatorRunnableWithProgress analysisTask = new IAveragedParameterEstimatorRunnableWithProgress() {
			ModelParameters modelParameters = null;
            public void run(IProgressMonitor progress) {
            	Iterator<String> iter = referenceLocations.iterator();
    
                progress.beginTask("Averaging data", referenceLocations.size());
                ReferenceScenarioDataInstance averagedDataMap = null;
                double localArea = 0.0;
                double localPopulation = 0.0;
                referenceScenarioDataMap.findMaxIncidence();
                String idMax = referenceScenarioDataMap.getMaxIncidenceLocation();
                //double max = referenceScenarioDataMap.getMaxIncidence();
                //System.out.println(" max incidence is "+max+" at "+idMax);
              	localArea += getArea(idMax).doubleValue();
                localPopulation += getPopulation(idMax).doubleValue();
                ReferenceScenarioDataInstance maxlocationDataMap = referenceScenarioDataMap.getLocation(idMax);
                averagedDataMap = maxlocationDataMap.clone();
               // PhaseSynchronizer synchronizer = new PhaseSynchronizer(averagedDataMap);
                	
                while(iter.hasNext()) {	
            		String id = iter.next();
            		if(!id.equalsIgnoreCase(idMax)) {
            			localArea += getArea(id).doubleValue();
                		localPopulation += getPopulation(id).doubleValue();
                		ReferenceScenarioDataInstance locationDataMap = referenceScenarioDataMap.getLocation(id);
                		averagedDataMap.integrateData(locationDataMap.instance);
            		}
                }
                
       			estimator = ParameterEstimatorFactory.createEstimator(method, averagedDataMap);
       			estimator.setAllParameters(finalParameterMap);
       			assert(localArea > 0.0);
       			if(localArea == 0) localArea = 1.0; // should never happen
       			final double localDensity = localPopulation/localArea;
        					
       			modelParameters = estimator.estimate(localDensity, localPopulation, Messages.getString("EST.AVERAGE"));
       			
        		if (progress.isCanceled())
                    throw new OperationCanceledException();
            		progress.worked(1);
            
                progress.done();
            }
            
            /**
             * Return the fitted parameters
             * @return Map<String, ModelParameters> result
             */
            public ModelParameters getModelParameters() {
            	return this.modelParameters;
            }
         };
         try {
        	 runnableContext.run(true, true, analysisTask);
         } catch(InterruptedException ie) {
        	 Activator.logError("", ie);
        	 return null;
         } catch(InvocationTargetException ite) {
        	 Activator.logError("", ite);
        	 return null;
         }
         return analysisTask.getModelParameters();
	}//averageThenEstimateParameters() 
	
	/**
	 * Returns a set of locations where the max Infectious population satisfies the criterion:
	 * localMaxI >= FITTING_FRACTION*globalMaxI
	 * There is not point in analyzing locations where no-one gets sick
	 * @return set of referenceLocations
	 */
	private Set<String> getReferenceLocations() {
		Set<String> locationsToFit = new HashSet<String>();
		Set<String> allLocations = referenceScenarioDataMap.getLocations();
		
		double globalMaxI = 0.0;
		
		// 1. get the local max infectious count by region id for all regions
		Iterator<String> iter = allLocations.iterator();
		while((iter!=null)&&(iter.hasNext()))  {
			String id = iter.next();
			ReferenceScenarioDataInstance locationDataMap = referenceScenarioDataMap.getLocation(id);
			
			if(locationDataMap.containsParameter(States.statesToFit[States.INFECTIOUS])) {
				List<String> data = locationDataMap.getData(States.statesToFit[States.INFECTIOUS]);
				double localMax = 0.0;
				
				for(int i = 0; i < data.size(); i ++) {
					double infectious = (new Double(data.get(i))).doubleValue();
					if (localMax < infectious) localMax = infectious;
					if (globalMaxI < localMax) globalMaxI = localMax;
					
				}
				maxInfectiousMap.put(id,new Double(localMax));
			}
		}
		
		// 2. Select those regions with  max infectious count  >= FITTING_FRACTION * LARGEST Infectious Population
		Iterator<String> iter2 = maxInfectiousMap.keySet().iterator();
		while((iter2!=null)&&(iter2.hasNext()))  {
			String id = iter2.next();
			double localMaxI = 	maxInfectiousMap.get(id).doubleValue();
			if (localMaxI >= FITTING_FRACTION*globalMaxI) {
				locationsToFit.add(id);
			}
			
		}
		
	  	return locationsToFit;
	}
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	Double getArea(String id) {
		double area = 0.0;
		URI uri = getAreaURI(id); 
		// New utility method
		AreaLabel areaLabel = (AreaLabel)org.eclipse.stem.ui.Utility.getLabel(uri);
		if(areaLabel==null) Activator.logError("area label is null", new NumberFormatException("null area"));
		area = areaLabel.getCurrentAreaValue().getArea();
		return new Double(area);
	}
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	Double getPopulation(String id) {
		double pop = 0.0;
		URI uri = getPopulationURI(id); 
		// New utility method
		PopulationLabel popLabel = (PopulationLabel)org.eclipse.stem.ui.Utility.getLabel(uri);
		if(popLabel==null) Activator.logError("Population label is null", new NumberFormatException("null population"));
		pop = popLabel.getCurrentPopulationValue().getCount();
		return new Double(pop);
	}
	
	/**
	 * 
	 * @return the area map
	 */
	Map<String,Double> getAreaDataMap() {
		Map<String,Double> areaMap = new HashMap<String,Double>();
		Iterator<String> iter = referenceLocations.iterator();
		while(iter.hasNext()) {
			String id = iter.next();
			Double area = getArea(id);
			areaMap.put(id, area);
		}
		return areaMap;
	}
	
	/**
	 * 
	 * @return the population map
	 */
	Map<String,Double> getPopulationDataMap() {
		Map<String,Double> popMap = new HashMap<String,Double>();
		Iterator<String> iter = referenceLocations.iterator();
		while(iter.hasNext()) {
			String id = iter.next();
			Double population = getPopulation(id);
			popMap.put(id, population);
		}	
		return popMap;
	}
	
	/**
	 * convert a List of String into and array of double
	 * @param dataList
	 * @return double[] of values
	 */
	public static double[] getDoubleValues(List<String> dataList) {
		double[] retValue = new double[dataList.size()];
		try {
			for (int i = 0; i < dataList.size(); i ++) {
				Double dbleObj = new Double(dataList.get(i));
				retValue[i] = dbleObj.doubleValue();
			}
		} catch(Exception e) {
			Activator.logError("String Data not valid. Expecting Double values", e);
		}
		
		return retValue;
	}
	


    /**
     * @return the Estimator
     */
    public ParameterEstimator getEstimator() {
		return estimator;
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	URI getAreaURI(String id) {
		int level = getLevel(id);
		String countryCode;
		// need uri of form:   stem://org.eclipse.stem/label/area/USA/2/US-GA-13307
		if (level == 0)  {
			countryCode = id;
		} else {
			String twoLetterCode = id.substring(0,2);
			countryCode = org.eclipse.stem.data.geography.GeographicMapper.getAlpha3(twoLetterCode);
		}
		String composite = "stem://org.eclipse.stem/"+AREA_URI_PREFIX + "/" + countryCode +"/"+getLevel(id)+"/"+id;
		URI uri = URI.createURI(composite);	
		return uri;
	}// getAreaURI
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	URI getPopulationURI(String id) {
		int level = getLevel(id);
		String countryCode;
		// compose the input string
		if (level == 0)  {
			countryCode = id;
		} else {
			String twoLetterCode = id.substring(0,2);
			countryCode = org.eclipse.stem.data.geography.GeographicMapper.getAlpha3(twoLetterCode);
		}
		// syntax is
		// stem://org.eclipse.stem/label/population/ISR/2/human/2006/IL-05-623
		
		// Hack to fix year problem. We don't know the year, try until we guess right
		String composite = null;
		for(int year=2000;year<2020;++year) {
			composite = "stem://org.eclipse.stem/"+POPULATION_URI_PREFIX + "/" + countryCode +"/"+getLevel(id)+"/"+SPECIES+"/"+year+"/"+id;
			
			try {
				final URI populationGraphURI = Utility.createPopulationGraphURI(URI.createURI(composite));
				
				// need to catch any exception here...we take the data for any year for this estimate
				final ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put("platform", new XMIResourceFactoryImpl());
				final Resource resource = resourceSet.getResource(populationGraphURI,true);
				Identifiable ident = (Identifiable) resource.getContents().get(0);
				final Graph populationGraph = (Graph) ident;
				
				// did we get the data
				if(populationGraph != null) break;
			} catch (Exception e) {
				//do nothing. not an errorSystem.out.println("No Error looking for data: "+composite);
			}
			
		}
		URI uri = URI.createURI(composite);	
		return uri;
	}// getPopulationURI
	
	/**
	 * finds the admin level of the id by counting '-' characters
	 * @param id
	 * @return
	 */
	private int getLevel(String id) {
		
		if(id.indexOf("-") ==-1) return 0;
		
		int idx1 = id.indexOf("-");
		String firstPart = id.substring(idx1+1,id.length());
		if(firstPart.indexOf("-") ==-1) return 1;
		
		int idx2 = firstPart.indexOf("-");
		String secondPart = firstPart.substring(idx2+1,firstPart.length());
		if(secondPart.indexOf("-") ==-1) return 2;
		

		int idx3 = secondPart.indexOf("-");
		String thirdPart = secondPart.substring(idx3+1,secondPart.length());
		if(thirdPart.indexOf("-") ==-1) {
			return 3;
		} 
		// TODO should generalize this.
		return 4; // two levels past where we now have data....
		
	}
	
	
	/**
	 * 
	 * @return an array of the states to fit by name
	 */
	public static String[] getStatesToFit() {
		return States.statesToFit;
	}
	
	
	
	/**
	 * Internal interface for long running task
	 */
	private interface IScenarioParameterEstimatorRunnableWithProgress extends IRunnableWithProgress {
		 /**
         * Return the fitted parameters
         * @return Map<String, ModelParameters> result
         */
        public Map<String, ModelParameters> getFittedParameters();
	}
	

	
	/**
	 * Internal interface for long running task
	 */
	private interface IAveragedParameterEstimatorRunnableWithProgress extends IRunnableWithProgress {
		 /**
         * Return the fitted parameters
         * @return ModelParameters  result
         */
        public ModelParameters getModelParameters();
	}
	
	/**
	 * Get the values to plot from the estimator
	 * @param chartIndex
	 * @param state
	 * @return the array of data to plot
	 */
	public double[] getValues(int chartIndex, int state) {
		return estimator.getValues(chartIndex, state);
	}
	
}// getLevel

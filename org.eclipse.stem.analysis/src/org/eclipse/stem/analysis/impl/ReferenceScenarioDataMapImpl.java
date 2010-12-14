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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.stem.analysis.Activator;
import org.eclipse.stem.analysis.AnalysisPackage;
import org.eclipse.stem.analysis.DiseaseType;
import org.eclipse.stem.analysis.ReferenceScenarioDataMap;
import org.eclipse.stem.analysis.States;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Scenario Data Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ReferenceScenarioDataMapImpl extends EObjectImpl implements ReferenceScenarioDataMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ReferenceScenarioDataMapImpl() {
		super();
		referenceScenarioDataMap = new HashMap<String, ReferenceScenarioDataInstance>();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.REFERENCE_SCENARIO_DATA_MAP;
	}

	public static final String ITERATION_KEY = "iteration";
	/**
	 * key for incidence data
	 */
	public static final String INCIDENCE_KEY = "Incidence";
	public static final String TIME_KEY = "time";
	private double maxIncidence = 0.0;
	private String maxIncidenceLocation;
	private static final double PPM = 1.0/1000000.0;
	
	
	/**
	 * A single Reference Scenario is stored in a map
	 * for each  key<String> = Region id
	 */
	Map<String, ReferenceScenarioDataInstance> referenceScenarioDataMap = null;
	
	/**
	 * Directory used
	 */
	
	private String refDir;
	
	/**
	 * Type of data (e.g. SIR)
	 */
	
	DiseaseType type;
	
	/**
	 * addInstance Add a new data instance (e.g. data from .csv file) to the map
	 * 
	 * @param key The key, e.g. city id
	 * @param data ReferenceScenarioDataInstance 
	 */
	public void addInstance(String key, ReferenceScenarioDataInstance data) {
		referenceScenarioDataMap.put(key, data);
	}
	
	/**
	 * 
	 */
	public void findMaxIncidence() {
		Iterator<String> iter = referenceScenarioDataMap.keySet().iterator();
		while((iter!=null)&&(iter.hasNext()) ) {
			String key = iter.next();
			ReferenceScenarioDataInstance data = referenceScenarioDataMap.get(key);
			double count = getTotalIncidence(data);
			if(count >= maxIncidence) {
				maxIncidence = count;
				maxIncidenceLocation = key;
			}
		}
	}
	
	/**
	 * Return the type of the data. Used to determine which parameter estimator(s)
	 * can be used.
	 * 
	 * @return ParameterEstimator.Type The type, e.g. SEIR 
	 */
	
	public DiseaseType getType() {
		if(referenceScenarioDataMap == null || referenceScenarioDataMap.size() == 0) {
			return null;
		}
		return this.type;
	}
	
	/**
	 * Set the type of the data
	 * 
	 * @param t New type 
	 */
	
	public void setType(DiseaseType t) {
		this.type = t;
	}
	
	/**
	 * getNumLocations. Return the number of locations analyzed
	 * 
	 * @return int Number of locations
	 */
	
	public int getNumLocations() {
		return referenceScenarioDataMap.size();
	}
	
	/**
	 * getLocations. Return the locations
	 * 
	 * @return Set<String> Set of all locations
	 */
	
	public Set<String> getLocations() {
		return referenceScenarioDataMap.keySet();
	}
	
	
	/**
	 * The the total incidence (summing over all time for some location instance 
	 * @param instance
	 * @return the total Incidence count
	 */
	public double getTotalIncidence(ReferenceScenarioDataInstance instance) {
		double retValue = 0.0;
		if(instance.getData().containsKey(INCIDENCE_KEY)) {
			List<Double> incidence = instance.getData().get(INCIDENCE_KEY);
			for (int i = 0; i < incidence.size(); i ++) {
				retValue += incidence.get(i).doubleValue();
			}
		}
		return retValue;
	}
	
	/**
	 * containsLocation Return true if the map contains the specified location
	 * 
	 * @param loc
	 * @return boolean True if the location is found in the map
	 */
	public boolean containsLocation(String loc) {
		return referenceScenarioDataMap.containsKey(loc);
	}
	
	/**
	 * getLocation. Return the data for the given location
	 * @param loc 
	 * @return ReferenceScenarioDataInstance Location instance, or null if not found
	 */
	
	public ReferenceScenarioDataInstance getLocation(String loc) {
		return referenceScenarioDataMap.get(loc);
	}
	
	/**
	 * Aggregate or integrate all data for all locations in a scenario.
	 * 
	 * @param runnableContext Runnable context for progress indicator
	 * @return ReferenceScenarioDataInstance aggregated data instance, or null if not found
	 */
	
	public ReferenceScenarioDataInstance aggregateScenarioData(IRunnableContext runnableContext) {
		final ReferenceScenarioDataInstance aggregatedData = new ReferenceScenarioDataInstance(this);
		
		IRunnableWithProgress aggregateTask = new IRunnableWithProgress() {
            public void run(IProgressMonitor progress) {
            	progress.beginTask("Aggregating data...", referenceScenarioDataMap.size());   	
            	Iterator<String> iter = referenceScenarioDataMap.keySet().iterator();
            	while((iter!=null)&&(iter.hasNext())) {
            		progress.worked(1);
            		if(progress.isCanceled()) throw new OperationCanceledException();
            		String loc = iter.next();
			
            		ReferenceScenarioDataInstance locationData = referenceScenarioDataMap.get(loc);
            		aggregatedData.integrateData(locationData.instance);
            	}// all locations
            	progress.done();
            }
		};
		
		try {
			runnableContext.run(true, true, aggregateTask);
		} catch(InterruptedException ie) {
			// ToDo
			return null;
		} catch(InvocationTargetException ite) {
			// ToDo
			return null;
		}
		return aggregatedData;
	}
	
	/**
	 * getReferenceDirectory. Return the reference directory used
	 * 
	 * @return String Reference directory
	 */
	
	public String getReferenceDirectory() {
		return this.refDir;
	}
	
	/**
	 * setReferenceDirectoy. Set the reference directory
	 * 
	 * @param dir The directory
	 */
	
	public void setReferenceDirectory(String d) {
		this.refDir = d;
	}
	
	/**
	 * 
	 * @return the max incidence at the most effected location 
	 */
	public double getMaxIncidence() {
		return maxIncidence;
	}

	/**
	 * 
	 * @return the location with the max incidence
	 */
	public String getMaxIncidenceLocation() {
		return maxIncidenceLocation;
	}
	
	
	/**
	 * ReferenceScenarioDataInstance. Contains data for one location  
	
	 */
	public class ReferenceScenarioDataInstance implements Cloneable {
		
		private double maxS = 0.0;
		private double maxE = 0.0;
		private double maxI = 0.0;
		private double maxR = 0.0;
			
		

		/**
		 * The region data map is keyed by property (S,E, I, R, incidence, etc) and contains Data (mostly Doubles but
		 * STEMTime is stored as a String) so all data is stored as String.
		 */
		
		public Map<String,List<String>> instance;
		
		

		protected ReferenceScenarioDataMapImpl dataMap;
		
		/**
		 * Create a new instance
		 *  
		 * @param data Map of parameter (e.g. a state) and its values
		 * @param map DataMap the instance belongs to
		 */
		public ReferenceScenarioDataInstance(Map<String, List<String>> data, ReferenceScenarioDataMapImpl map) {
			this.instance = data;
			this.dataMap = map;
		}
		
		/**
		 * Create an empty instance of some type
		 *  
		 * @param dataMap map
		 */
		public ReferenceScenarioDataInstance(ReferenceScenarioDataMapImpl dataMap) {
			this.instance = new HashMap<String, List<String>>();
			this.dataMap = dataMap;
		}
		
		/**
		 * deep clone
		 * @see java.lang.Object#clone()
		 */
		@Override
		public  ReferenceScenarioDataInstance clone() {
			this.getData();
			ReferenceScenarioDataInstance newInstance = new ReferenceScenarioDataInstance(this.dataMap);
			Iterator<String> iter = this.instance.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				List<String> dataList = instance.get(key);
				List<String> newList = new ArrayList<String>();
			
				for (int i = 0; i < dataList.size(); i ++) {
					String val = dataList.get(i);
					newList.add(val);
				}
				newInstance.instance.put(key,newList);
			}
			newInstance.getData();
			return newInstance;
		}
		
		/**
		 * integrates data from another instance
		 * @param data
		 */
		public void integrateData(Map<String, List<String>> data) {
			// get the state variables SEIR... as keys
			for (Entry<String,List<String>> entry : data.entrySet()) {
				// get the key
				String state = entry.getKey();
				List<String> valueList = entry.getValue();
				if(valueList.size()>=1) {
					// get the current list
					List<String> aggregatedList = new ArrayList<String>();
					if(this.instance.containsKey(state)) {
						aggregatedList = this.instance.get(state);
					} else {
						// create it if it doesn't exist
						for(int i = 0; i < valueList.size(); i ++) {
							aggregatedList.add("0.0");
						}
						this.instance.put(state,aggregatedList);
					}
					
					
					
					String first = valueList.get(0);
					// check if this is numeric data - it might just be a date
					boolean isData = true;
					try {
						@SuppressWarnings("unused")
						double val = (new Double(first)).doubleValue();
					} catch (NumberFormatException nfe) {
						isData = false;
					}
					for (int i = 0; i < valueList.size(); i ++) {
						String value = valueList.get(i);
						if(isData) {
							double val = (new Double(value)).doubleValue();
							double oldVal = (new Double(aggregatedList.get(i))).doubleValue();
							if(state.indexOf(ITERATION_KEY)==-1) {
								// add them up except for the iteration counter column
								oldVal += val;
							} else {
								oldVal = val;
							}
							aggregatedList.set(i,""+oldVal);
							this.instance.put(state,aggregatedList);
						} else {
							// just copy the strings
							aggregatedList.set(i,value);
							this.instance.put(state,aggregatedList);
						}
					}
					
					
				}
				
				
			}
			
			
		}
		
		
		/**
		 * getData. Return data for the given parameter (e.g. state)
		 * 
		 * @param parm Parameter
		 * @return List<String> data
		 */
		
		public List<String> getData(String parm) {
			return instance.get(parm);
		}
		
		/**
		 * containsParameter. Return true if the data contains the given parameter (e.g. a state)
		 * 
		 * @param p Parameter to check
		 * @return boolean true if found, false otherwise
		 */
		
		public boolean containsParameter(String p) {
			return this.instance.containsKey(p);
		}
		
		/**
		 * get the all the data
		 * @return this instance map
		 */
		public Map<String, List<String>> getInstance() {
			return instance;
		}
		
		/**
		 * find the maximum values for every state
		 */
		public void findMaxValues() {
			
					// Get the data. Always have at least S and I
					List<String>sData = this.getData(States.statesToFit[States.SUSCEPTIBLE]);
					List<String>eData = null;
					List<String>iData = this.getData(States.statesToFit[States.INFECTIOUS]);
					List<String>rData = null;
					
					// If E state
        			if(this.dataMap.getType()== DiseaseType.SEIR)  {
        				eData = this.getData(States.statesToFit[States.EXPOSED]);
        			}
        			// If have R state (i.e., not an SI model
        			if(this.dataMap.getType()!= DiseaseType.SI)  {
        				rData = this.getData(States.statesToFit[States.RECOVERED]);
        			}
					
					   
        			
        			// if we have an S state
        			if(sData != null) {
        				maxS = new Double(sData.get(0)).doubleValue();
            			for(int i = 0; i < sData.size(); i ++) {
            				double val = new Double(sData.get(i)).doubleValue();
            				if (val > maxS) {
            					maxS = val;
            				}
            			}
        			}// if have S state
        			
        			// if we have an E state
        			if(eData != null) {
        				maxE = new Double(eData.get(0)).doubleValue();
            			for(int i = 0; i < eData.size(); i ++) {
            				double val = new Double(eData.get(i)).doubleValue();
            				if (val > maxE) {
            					maxE = val;
            				}
            			}
        			}// if have E state
        			
        			// if we have an I state
        			if(iData != null) {
        				maxI = new Double(iData.get(0)).doubleValue();
            			for(int i = 0; i < iData.size(); i ++) {
            				double val = new Double(iData.get(i)).doubleValue();
            				if (val > maxI) {
            					maxI = val;
            				}
            			}
        			}// if have I state
        			
        			// if we have an R state
        			if(rData != null) {
        				maxR = new Double(rData.get(0)).doubleValue();
            			for(int i = 0; i < rData.size(); i ++) {
            				double val = new Double(rData.get(i)).doubleValue();
            				if (val > maxR) {
            					maxR = val;
            				}
            			}
        			}// if have R state
        			
		} // findMaxValues
		
		
		
		/**
		 * getData. Return the map that of raw data (not filtered)
		 * @return  Map<String, List<Double>> Map with state, value list
		 */
		@SuppressWarnings("boxing")
		public Map<String, List<Double>> getData() {
			
			HashMap<String, List<Double>> data = new HashMap<String, List<Double>>();
			
			for(String state : instance.keySet()) {
				ArrayList<Double> list = new ArrayList<Double>();
				if(state.equalsIgnoreCase("time"))continue;
				for(String sd : instance.get(state)) 
					list.add(Double.parseDouble(sd));
				data.put(state, list);
			}
			return data;
		}
		
		
		
		/**
		 * 
		 * @return maxS
		 */
		public double getMaxS() {
			return maxS;
		}

		/**
		 * 
		 * @return maxE
		 */
		public double getMaxE() {
			return maxE;
		}

		/**
		 * 
		 * @return maxI
		 */
		public double getMaxI() {
			return maxI;
		}

		/**
		 * 
		 * @return maxR
		 */
		public double getMaxR() {
			return maxR;
		}
		
		/**
		 * getSize. Return the number of data rows in the instance. Each array (value) is assumed same size
		 * 
		 * @return int The size of the 
		 */
		
		public int getSize() {
			if(this.instance.size() == 0) return 0;
			return this.instance.values().iterator().next().size();
		}
	}


	/**
	 * TODO implement this method
	 * This method insures that the output of a disease model (or the output of a population model) is sane!
	 * @return
	 */
	@Override
	public boolean sane() {
		System.out.println("TODO   ReferenceScenarioDataMapImpl.sane() must be fully implemented !!!"); //$NON-NLS-1$
		
		Iterator<String> locationIter = getLocations().iterator();
		while(locationIter!=null && locationIter.hasNext()) {
			String locationID = locationIter.next();
			ReferenceScenarioDataInstance instance = getLocation(locationID);
			// Get the data. Always have at least S and I
			List<String>popData = instance.getData(States.statesToFit[States.POPULATION]);
			if(popData == null) popData =  instance.getData("Population Count");
			
			List<String>sData = instance.getData(States.statesToFit[States.SUSCEPTIBLE]);
			List<String>eData = null;
			List<String>iData = instance.getData(States.statesToFit[States.INFECTIOUS]);
			List<String>rData = null;
			
			// If E state
			if(instance.dataMap.getType()== DiseaseType.SEIR)  {
				eData = instance.getData(States.statesToFit[States.EXPOSED]);
			}
			// If have R state (i.e., not an SI model
			if(instance.dataMap.getType()!= DiseaseType.SI)  {
				rData = instance.getData(States.statesToFit[States.RECOVERED]);
			}
			
			// check that three things are true at every time step.
			// 0. All existing lists have the same length
			// 1. No data label should ever go negative
			// 2. The sum of the disease states = the total population at that time.
			int length = popData.size();
			if((sData.size() != length)||(iData.size() != length)) return false;
			if((eData != null)&&(eData.size() != length)) return false;
			if((rData != null)&&(rData.size() != length)) return false;
			
			for (int t = 0; t < length; t ++) {
				double sum = 0.0;
				double s = new Double(sData.get(t)).doubleValue();
				double i = new Double(iData.get(t)).doubleValue();
				double r = 0.0;
				double e = 0.0;
				if(eData != null) e = new Double(eData.get(t)).doubleValue();
				if(rData != null) r = new Double(rData.get(t)).doubleValue();
				if((s < 0)||(i<0)||(e<0)||(r<0)) return false; //1
				sum = s+e+i+r;
				if(!closeEnough(sum,new Double(popData.get(t)).doubleValue())) return false; // 2
			}
			
		}
		return true;
	}
	
	/**
	 * Are two values within 1ppm ?
	 * @param dbl1
	 * @param dbl2
	 * @return
	 */
	boolean closeEnough(double d1, double d2) {
		boolean retVal = true;
		double diff = (Math.abs(2.0*(d1-d2)/(d1+d2)));
		if(diff > PPM) retVal = false;
		return retVal;
	}
	
	/**
	 * Is this map consistent with another map?
	 * This is like "equal" but allows for small differences when comparing double(s)
	 * @param other
	 * @return
	 */
	@Override
	public boolean consistentWith(ReferenceScenarioDataMap other) {
		System.out.println("TODO   ReferenceScenarioDataMapImpl.consistentWith(ReferenceScenarioDataMap other) must be fully implemented !!!");//$NON-NLS-1$
		return true;
	}
	

} //ReferenceScenarioDataMapImpl

// AggregateDataWriter
package org.eclipse.stem.util.analysis;

/*******************************************************************************
 * Copyright (c) 2007,2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;
import org.eclipse.stem.diseasemodels.Activator;

/**
 * writes CSV Files
 * 
 */
public class AggregateDataWriter {

	// private static final DateFormat df =
	// DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.MEDIUM);

	/**
	 * 
	 */
	private final String aggregateFileName;
	private final String incidenceFileName;
	
	private static final String keyS = "S";
	private static final String keyE = "E";
	
	


	private static final String keyI = "I";
	private static final String keyR = "R";
	private static final String keyBirths = "Births";
	private static final String keyDeaths = "Deaths";
	private static final String keyDeltaBirths = "deltaBirths";
	private static final String keyDeltaDeaths = "deltaDeaths";
	private static final String keyIncidence = "Incidence";
	private static List<String> birthsList=null;
	private static List<String> deathsList=null;
	private static List<String> deltaBirthsList=new ArrayList<String>();
	private static List<String> deltaDeathsList=new ArrayList<String>();
	
	/**
	 * indicates if birth counts exist in data set
	 */
	private boolean haveBirths = false;
	/**
	 * indicates if death counts exist in data set
	 */
	private boolean haveDeaths = false;
	/** 
	 * Births are stored cumulatively but we want to log the derivative
	 * so we will store the previous value and subtract it to get the instantaneous value
	 */
	private static double pastBirths = 0.0;
	/** 
	 * Deaths are stored cumulatively but we want to log the derivative
	 * so we will store the previous value and subtract it to get the instantaneous value
	 */
	private static double pastDeaths = 0.0;
	
	String[] preferredKeyOrder = {
									ReferenceScenarioDataMapImpl.ITERATION_KEY, 
									ReferenceScenarioDataMapImpl.TIME_KEY, 
									keyS, 
									keyE, 
									keyI, 
									keyR,
									keyBirths,
									keyDeaths
									};
	
	
	private static final IPath PATH = ResourcesPlugin.getWorkspace().getRoot().getLocation();
	private static final String sep = File.separator;
	
	/**
	 * Directory containing scenario folders
	 */
	public static final String ANALYSISFOLDER = PATH.toOSString();

	/**
	 * Folder name for files containing aggregate data
	 */
	public static final String AGGREGATE_FOLDERNAME = "aggregate";
	private static final String aggregatePathSuffix = AGGREGATE_FOLDERNAME+sep;
	// TODO for now all aggregate data will be in one folder called csv/aggregate
	private String aggregateDirectoryName = PATH.append(sep + aggregatePathSuffix).toOSString();
	
	/**
	 * Folder name for files containing incidence data
	 */
	public static final String INCIDENCE_FOLDERNAME = "incidence";
	private static final String incidencePathSuffix = INCIDENCE_FOLDERNAME+sep;
	// TODO for now all aggregate data will be in one folder called csv/aggregate
	private String incidenceDirectoryName = PATH.append(sep + incidencePathSuffix).toOSString();
	
	private FileWriter fw1;
	private FileWriter fw2;

	/**
	 * 
	 * @param dataFolder
	 * @param aggregateDataFileName
	 */
	public AggregateDataWriter(final String dataFolder, final String aggregateDataFileName) {
		// Determine the aggregate folder name from the data folder
		IPath p = new Path(dataFolder);
		p = p.removeLastSegments(1); // get rid of disease folder
		p = p.append(AGGREGATE_FOLDERNAME);
		this.aggregateDirectoryName = p.toOSString();
		// check that the directory exists	
		final File dir = new File(this.aggregateDirectoryName);
		if ((!dir.exists()) || (!dir.isDirectory())) {
			// create it.
			boolean success = dir.mkdirs();
			if (!success) {
				Activator.logError(
						"Failed to Create Directory" + aggregateDirectoryName,
						new IOException("Failed to Create Driectory"
								+ aggregateDirectoryName));
			}
		}
		
		p = new Path(dataFolder);
		p = p.removeLastSegments(1); // get rid of disease folder
		p = p.append(INCIDENCE_FOLDERNAME);
		this.incidenceDirectoryName = p.toOSString();
		final File dir2 = new File(this.incidenceDirectoryName);
		if ((!dir2.exists()) || (!dir2.isDirectory())) {
			// create it.
			boolean success = dir2.mkdirs();
			if (!success) {
				Activator.logError(
						"Failed to Create Indicence Directory" + incidenceDirectoryName,
						new IOException("Failed to Create Directory"
								+ incidenceDirectoryName));
			}
		}
		
		
		aggregateFileName = aggregateDirectoryName+sep+aggregateDataFileName;
		try {
			fw1 = new FileWriter(aggregateFileName);
		} catch (final IOException e) {
			Activator.logError("Error opening data file"  + aggregateDirectoryName + " "+ aggregateFileName, e);
		}
		
		incidenceFileName = incidenceDirectoryName+sep+aggregateDataFileName;
		try {
			fw2 = new FileWriter(incidenceFileName);
		} catch (final IOException e) {
			Activator.logError("Error opening data file"  + incidenceDirectoryName + " "+ incidenceFileName, e);
		}
		
	} // AggregateDataWriter

	

	
	

	/**
	 * log the data for an instance
	 * @param data
	 * @param alpha the immunity Loss Rate
	 * @return Filename (including path) of log file
	 */
	public String[] logDataInstance(final ReferenceScenarioDataInstance data, double alpha) {
		    
		    String[] retVal = new String[2];
			Map<String,List<String>> instance = data.getInstance();	
			Set<String> keySet = instance.keySet();
			String[] keys = sortKeys(keySet);
			
			List<String> dataList = instance.get(keys[0]);
			
			String str = keys[0]+""; // this is the ITERATION_KEY = "iteration"; column
			for (int i = 1; i < keys.length; i ++) {
				// log the header
				str += "," + keys[i].toString().trim();
			}
			str += "\n";
			try {
				fw1.append(str);
			} catch (final IOException e) {
				Activator.logError("Error writing aggregate data file"  + aggregateDirectoryName + " "+ aggregateFileName, e);
			}
			
			// get the births 
			birthsList = data.getInstance().get(keyBirths);
			data.getInstance().put(keyBirths, birthsList);
			
			// get the deaths list
			deathsList = data.getInstance().get(keyDeaths);
			data.getInstance().put(keyDeaths, deathsList);
			
			
			int dataSize = dataList.size();
			// write the data
			for(int i = 0; i < dataSize; i ++) {
				// get the first column ("iterations")
				String key = keys[0].toString();
				List<String> valueList = data.getInstance().get(key);
				str = valueList.get(i) + " ";
				
				for (int j = 1; j < keys.length; j++) {
					key = keys[j].toString();
					valueList = data.getInstance().get(key);	
					str += ", "+valueList.get(i);
				}// for all keys
				str += "\n";
				try {
					fw1.append(str);
				} catch (final IOException e) {
					Activator.logError("Error writing aggregate data file"  + aggregateDirectoryName + aggregateFileName, e);
				}
			}// for all points
			
			str = "";
			try {
				if (fw1 != null) {
					fw1.flush();
					fw1.close();
				}
			} catch (final IOException e) {
				// do nothing
			}
			
			haveBirths = false;
			if(birthsList!=null) {
				haveBirths = true;
				// get the derivative for the births list
				for (int i = 0;i < birthsList.size(); i ++) {
					deltaBirthsList.add(i,birthsList.get(i));
				}
				if (deltaBirthsList != null) {
					pastBirths = 0;
					for (int ii = 0; ii < deltaBirthsList.size(); ii++) {
						final double births = (new Double(deltaBirthsList.get(ii))).doubleValue();
						deltaBirthsList.set(ii, "" + (births - pastBirths));
						pastBirths = births;
					}
				}
			}
			
			haveDeaths = false;
			if(deathsList!=null) {
				haveDeaths = true;
				// get the derivative for the deaths list
				for (int i = 0;i < deathsList.size(); i ++) {
					deltaDeathsList.add(i,deathsList.get(i));
				}
				if (deltaDeathsList != null) {
					pastDeaths = 0;
					for (int ii = 0; ii < deltaDeathsList.size(); ii++) {
						final double deaths = (new Double(deltaDeathsList.get(ii))).doubleValue();
						deltaDeathsList.set(ii, "" + (deaths - pastDeaths));
						pastDeaths = deaths;
					}
				}
			}
			
			data.getInstance().put(keyDeltaBirths, deltaBirthsList);
			data.getInstance().put(keyDeltaDeaths, deltaDeathsList);
			
			
			retVal[0] = this.aggregateFileName;
			
			// next compute the incidence and log it too...
			retVal[1] = logIncidence(data, alpha);
			
			return retVal;
	}// log the data

	

	/**
	 * log the data for an instance
	 * @param data
	 * @param alpha the immunity loss rate
	 * @return the incidence data file name
	 */
	public String logIncidence(final ReferenceScenarioDataInstance data, double alpha) {
		    
			Map<String,List<String>> instance = data.getInstance();	
			Set<String> keySet = instance.keySet();
			
			
			String[] keys = sortKeys(keySet);
			List<String> dataList = instance.get(keys[0]);
			int size = dataList.size();
			
			// get the total population as a function of time
			List<Double> popList = new ArrayList<Double>();
			for (int j = 0; j < size; j ++) {
				double pop = 0.0;
		
				if(keySet.contains(keyS)) {
					dataList = instance.get(keyS);
					Double dObj = new Double(dataList.get(j));
					pop+= dObj.doubleValue();
				}
				if(keySet.contains(keyE)) {
					dataList = instance.get(keyE);
					Double dObj = new Double(dataList.get(j));
					pop+= dObj.doubleValue();
				}
				if(keySet.contains(keyI)) {
					dataList = instance.get(keyI);
					Double dObj = new Double(dataList.get(j));
					pop+= dObj.doubleValue();
				}
				if(keySet.contains(keyR)) {
					dataList = instance.get(keyR);
					Double dObj = new Double(dataList.get(j));
					pop+= dObj.doubleValue();
				}
				
				popList.add(new Double(pop));
			}
			
			//incidence = deltaI - deltaR + muI - muR  (deaths in infectious and recovered)
			List<Double> incidenceList = new ArrayList<Double>();
			List<String> sList = instance.get(keyS);
			List<String> iList = instance.get(keyI);
			List<String> rList = instance.get(keyR); // ok if this is null
			
			/////////////////////////////////////////////////////////
			//   get the Incidence
			//
			List<String> exactIncidence = instance.get(keyIncidence);
			if(exactIncidence != null) {
				// read the incidence
				for(int i = 0; i < exactIncidence.size(); i ++) {
					incidenceList.add(i,new Double(exactIncidence.get(i)));
				}
			} else {
				
				// compute the incidence
				incidenceList = computeIncidence(iList, rList, alpha, size) ;
			}// find the incidence from file else compute it
			//	
            /////////////////////////////////////////////////////////
			
			
			// header info
			String str = keys[0]+","+keys[1]+","+"Incidence,S,P";
			if(haveBirths) str +=","+keyDeltaBirths;
			if(haveDeaths) str +=","+keyDeltaDeaths;
			
			str += "\n";
			try {
				fw2.append(str);
			} catch (final IOException e) {
				Activator.logError("Error writing aggregate data file"  + aggregateDirectoryName + " "+ aggregateFileName, e);
			}
			
			// write the data
			str = "";
			for(int i = 0; i < size; i ++) {
				str = "";
				// get the first column ("iterations")
				String key = keys[0].toString();
				List<String> valueList = data.getInstance().get(key);
				str = valueList.get(i) + " ";
				// time
				key = keys[1].toString();
				valueList = data.getInstance().get(key);
				str += ", "+valueList.get(i);
				// incidence
				str += ", "+incidenceList.get(i).doubleValue();
				// S
				str += ", "+sList.get(i);
				// P
				str += ", "+popList.get(i).doubleValue();
				
				if(haveBirths) {
					// deltaBirths
					key = keyDeltaBirths;
					valueList = data.getInstance().get(key);
					if(valueList!= null && valueList.size() > 0 ) {
						str += ", "+valueList.get(i);
					} else {
						str += ", "+0;
					}
				}
				
				if(haveDeaths) {
					// deltaDeaths
					key = keyDeltaDeaths;
					valueList = data.getInstance().get(key);
					if(valueList!= null && valueList.size() > 0 ) {
						str += ", "+valueList.get(i);
					} else {
						str += ", "+0;
					}
				}
			
				
				str += " \n";
				try {
					fw2.append(str);
				} catch (final IOException e) {
					Activator.logError("Error writing aggregate data file"  + incidenceDirectoryName + incidenceFileName, e);
				}
			}// for all points
			
			str = "";
			try {
				if (fw2 != null) {
					fw2.flush();
					fw2.close();
				}
			} catch (final IOException e) {
				// do nothing
			}
			
			return incidenceFileName;
			
			
	}// log the data
	
	/**
	 * 
	 * compute the incidence - return as list of Double
	 * 
	 * @param iList
	 * @param rList
	 * @param alpha
	 * @param size
	 * @return
	 */
	private List<Double> computeIncidence(List<String> iList, List<String> rList, double alpha, int size) {
		List<Double> incidenceList = new ArrayList<Double>();
		// time zero point
		double deltaI = (new Double(iList.get(0))).doubleValue();
		double deltaR = (new Double(rList.get(0))).doubleValue();
		double births = 0.0;
		double deaths = 0.0;
		if((birthsList!=null)&&(birthsList.size()>=1)) births = (new Double(birthsList.get(0))).doubleValue();
		if((deathsList!=null)&&(deathsList.size()>=1)) deaths = (new Double(deathsList.get(0))).doubleValue();
		// 1. First compute the incidence from the difference in deltaI - deltaR
		// ignoring the rate of immunity loss.
		Double incidence = new Double((deltaI + deltaR) + (deaths-births) );
	    // we can't use this one point correct for alpha because it depends on R
		// at t-1 (where we have no data for t= -1 )			
	 
		incidenceList.add(incidence);

		for (int j = 1; j < size; j ++) {
			
			// get deltaI and deltaR from previous value
			deltaI = (new Double(iList.get(j))).doubleValue();
			deltaI -= (new Double(iList.get(j-1))).doubleValue();
			
			if(rList!=null) {
				deltaR = (new Double(rList.get(j))).doubleValue();
				deltaR -= (new Double(rList.get(j-1))).doubleValue();
			}
			births = 0.0;
			deaths = 0.0;
			if((birthsList!=null)&&(birthsList.size()>=j)) births = (new Double(birthsList.get(j))).doubleValue();
			if((deathsList!=null)&&(deathsList.size()>=j)) deaths = (new Double(deathsList.get(j))).doubleValue();
			
			// Compute the incidence from the difference in deltaI - deltaR
			// correcting for the rate of immunity loss.
			double rValue = (new Double(rList.get(j-1))).doubleValue();
			double incValue = (deltaI + deltaR) + (deaths-births) +(alpha*rValue);
			incidence = new Double(incValue);
			incidenceList.add(incidence);
		}	
		return incidenceList;
	}


	/**
	 * If the keySet contains the preferred keys, return the preferred ones in the preferred order,
	 * otherwise just returns them.
	 * @param keySet
	 * @return the sorted keys
	 */
	private String[] sortKeys(Set<String> keySet) {
		String[] keys = new String[keySet.size()];
		int icount = 0;
		// first add the preferred keys (if they exist) in the correct order
	    Set<String> doneSet = new HashSet<String>();
		for (int i = 0; i < preferredKeyOrder.length; i ++) {
			if(keySet.contains(preferredKeyOrder[i])) {
				keys[icount] = preferredKeyOrder[i].trim();
				icount ++;
				doneSet.add(preferredKeyOrder[i]);
			}
		}
  
		// then add any other keys
		Iterator<String> iter = keySet.iterator();
		while((iter!=null)&&(iter.hasNext())){
			String nextKey = iter.next();
			if(!doneSet.contains(nextKey)) {
				keys[icount] = nextKey;
			    icount ++;
			}
		}
		
		return keys;
	}
	
	/**
	 * get the key use for Susceptible data
	 * @return 'S'
	 */
	public static String getKeyS() {
		return keyS;
	}

	/**
	 * 
	 * @return E
	 */
	public static String getKeyE() {
		return keyE;
	}

	/**
	 * 
	 * @return I
	 */
	public static String getKeyI() {
		return keyI;
	}

	/**
	 * 
	 * @return R
	 */
	public static String getKeyR() {
		return keyR;
	}

	/**
	 * get the key use for Incidence data
	 * @return 'Incidence'
	 */
	public static String getKeyIncidence() {
		return keyIncidence;
	}


}// AggregateDataWriter

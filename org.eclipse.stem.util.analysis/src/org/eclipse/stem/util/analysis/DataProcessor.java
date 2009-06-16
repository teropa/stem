// DataProcessor.java
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.stem.analysis.ScenarioInitializationException;
import org.eclipse.stem.definitions.Activator;

/**
 * This class reads incidence data from files (file names keyed by location) and 
 * creates the new format CSV files for STEM.
 * It rewrites the incidence.
 * It computes and writes the SIR approximations from the incidence and the 
 * population data.
 */
public class DataProcessor {

	/** 
	 * Name of the result files
	 */
	private static final String INCIDENCE_FILE_NAME = "Incidence_2.csv";
	private static final String SUSCEPTIBLE_FILE_NAME = "S_2.csv";
	private static final String INFECTIOUS_FILE_NAME = "I_2.csv";
	private static final String RECOVERED_FILE_NAME = "R_2.csv";
	private static final String POPULATION_FILE_NAME = "P_2.csv";
	private static final String REPORTING_FRACTION_FILE_NAME = "reportingFraction.csv";

	/**
	 * Incidences per location id
	 */
	private Map<String,List<Data>> incidenceMap = new HashMap<String,List<Data>>();
	
	/**
	 * Population size per location id
	 */
	private Map<String,Double> populationMap = new HashMap<String,Double>();

	/**
	 * Maximum number of iterations (days) for a specific location 
	 */
	private int maxIteration = 0;
	
	/**
	 * Reference population day (day of population data versus the start date 
	 * of the data)
	 */
	private long referencePopulationDay;
	
	/**
	 * Population change per day (population size at the start date of the data 
	 * versus the size at the end date of the data)
	 */
	private double fractChangePopulationPerDay;
	
	/**
	 * Computes and writes the SIR approximations from the incidence and the 
	 * population data.
	 * 
	 * @param sourceFolder The folder of the source data
	 * @param targetFolder The target folder of the results
	 * @param startDate The date in which the data starts
	 * @param endDate The date in which the data ends
	 * @param populationDataFile The population data file
	 * @param populationSizeStartYear Population size in the first year of the data
	 * @param populationSizeEndYear Population size in the last year of the data
	 * @param recoveryRate Average time it takes an infectious person to recover
	 * @param susceptibleRate Rate of initial susceptible to disease
	 * @param immunityLossRate Immunity loss rate to disease
	 * 
	 * @throws ScenarioInitializationException Thrown when the process fails
	 */
	public void process(
			String sourceFolder,
			String targetFolder,
			Date startDate,
			Date endDate,
			String populationDataFile,
			long populationSizeStartYear,
			long populationSizeEndYear,
			double recoveryRate,
			double susceptibleRate,
			double immunityLossRate) throws ScenarioInitializationException {

		readPopulationData(
				populationDataFile, 
				startDate, 
				endDate, 
				populationSizeStartYear, 
				populationSizeEndYear);
		
		readSourceData(sourceFolder);
		
		modelDiseaseState(recoveryRate, susceptibleRate, immunityLossRate);
		
		writeResults(targetFolder);
		
	} // process

	/**
	 * Read the population data.
	 * 
	 * @param populationDataFile The population data files
	 * @param startDate The date in which the data starts
	 * @param endDate The date in which the data ends
	 * @param populationSizeStartYear Population size in the first year of the data
	 * @param populationSizeEndYear Population size in the last year of the data
	 * 
	 * @exception ScenarioInitializationException 
	 * 			  Thrown when failed to load the population data
	 */
	private void readPopulationData(
			String populationDataFile,
			Date startDate,
			Date endDate,
			long populationSizeStartYear,
			long populationSizeEndYear) throws ScenarioInitializationException {

		final String POPULATION_YEAR = "YEAR";

		File file = new File(populationDataFile);
		
		BufferedReader fileReader = openReader(file);
		if (fileReader == null) {
			throw new ScenarioInitializationException(
					"Failed to open population data file " + populationDataFile);
		}
		
		// initialize the population data year to the first year of the data  
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		int populationDataYear = cal.get(Calendar.YEAR);
		
		try {
			String buffer = null;
			while (EOF(buffer = fileReader.readLine()) != true) {
				int idx = buffer.indexOf("=");
				if(idx >= 0) {
					String id = (buffer.substring(0,idx)).trim();
					String value = (buffer.substring(idx+1,buffer.length())).trim();
					if(id.equals(POPULATION_YEAR)) {
						// extracts the population data year from the file
						try {
							populationDataYear = Integer.parseInt(value);
						} catch (NumberFormatException ex) {
							// ignore
							Activator.logInformation("Failed to read population year", ex);
						}
					} else if(id.indexOf("-") >= 0){
						try {
							populationMap.put(id,new Double(value));
						} catch (NumberFormatException ex) {
							// ignore
							Activator.logInformation("Failed to read population for " + id, ex);
						}
					}
				}
			}

			if(populationMap.isEmpty()) {
				throw new ScenarioInitializationException("Failed to read population data from " + file.getName());
			}

			// computation of reference population day
			cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_YEAR, 1);
			cal.set(Calendar.YEAR, populationDataYear); // population data year
			long offset = cal.getTimeInMillis()-startDate.getTime(); // in milliseconds
			referencePopulationDay = offset/(1000*60*60*24);
			
			// computation of population change per day
			offset = endDate.getTime()-startDate.getTime(); // in milliseconds
			long offsetDays = offset/(1000*60*60*24);
			double changePopulationPerDay = 
				((double)populationSizeEndYear - (double)populationSizeStartYear)/(offsetDays+1);
			
			fractChangePopulationPerDay = changePopulationPerDay/populationSizeStartYear;

		} catch(IOException ex) {
			throw new ScenarioInitializationException(ex);
		}
		
	} // readPopulationData
	
	/**
	 * Read the source data.
	 * 
	 * @param sourceFolder The folder of the source data
	 * 
	 * @exception ScenarioInitializationException 
	 * 			  Thrown when failed to load the source data files
	 */
	private void readSourceData(
			String sourceFolder) throws ScenarioInitializationException {
		
		File file = new File(sourceFolder);
			
		int numFiles = 0;
		File[] allFiles = file.listFiles();
		for (int i = 0; i < allFiles.length; i++) {
			try {
				readDataFromSourceFile(allFiles[i]);
				numFiles ++;
			} catch(ScenarioInitializationException ex) {
				Activator.logInformation("Failed to read data from " + allFiles[i].getName(), ex);
			}
		}
		
		if(numFiles == 0) {
			throw new ScenarioInitializationException("Failed to read source data from " + sourceFolder);
		}
		
	} // readSourceData
	
	/**
	 * Read data from a source file.
	 * 
	 * @param file A source file
	 * 
	 * @exception ScenarioInitializationException 
	 * 			  Thrown when failed to load a source file
	 */
	private void readDataFromSourceFile(
			File file) throws ScenarioInitializationException {
		
		String fileName = file.getName();
		if (fileName.indexOf(".txt") < 0) {
			return; // ignore
		}

		BufferedReader fileReader = openReader(file);
		if (fileReader == null) {
			throw new ScenarioInitializationException("Failed to open file " + fileName);
		}
		
		int idx = fileName.indexOf(".txt");
		String idInput = fileName.substring(0,idx);
		String id = convertID(idInput);
		if (id == null) {
			throw new ScenarioInitializationException("Failed to convert " + idInput + " to STEM ID");
		}
		
		Double population = populationMap.get(id);
		if (population == null) {
			throw new ScenarioInitializationException("No population found for " + id + " from " + idInput);
		}

		if(!incidenceMap.containsKey(id)) {
			List<Data> incList = new ArrayList<Data>();
			incidenceMap.put(id, incList);
		}
		List<Data> incList = incidenceMap.get(id);

		try {
			String buffer = null;
			fileReader.readLine(); // skip the header
			while (EOF(buffer = fileReader.readLine()) != true) {

				StringTokenizer tokenizer = new StringTokenizer(buffer, ","); //$NON-NLS-1$
		        String iteration = tokenizer.nextToken(",");
		        String time = tokenizer.nextToken(",");
		        String inc = tokenizer.nextToken(",");
			    
		        Integer count = new Integer(iteration.trim());
			    double reports = (new Double(inc)).doubleValue();
			    double pop = getPopulation(count.intValue(), population.doubleValue());
			    Data data = new Data(count, time, reports, pop);
			    incList.add(data);
			    if(incList.size() > maxIteration) {
			    	maxIteration = incList.size();
			    }
			}
		} catch(IOException ex) {
			throw new ScenarioInitializationException(ex);
		}
		
	} // readDataFromSourceFile

	/**
	 * Model the S,I,R disease parameters from incidence data, population, and 
	 * modeled parameters for reporting fraction and recovery rate.
	 * 
	 * @param recoveryRate Average time it takes an infectious person to recover
	 * @param susceptibleRate Rate of initial susceptible to disease
	 * @param immunityLossRate Immunity loss rate to disease
	 */
	private void modelDiseaseState(
			double recoveryRate,
			double susceptibleRate,
			double immunityLossRate) {
		
		// for all locations
		Iterator<String> iter = populationMap.keySet().iterator();
		while(iter.hasNext()) {
			String id = iter.next();
			
			if(!incidenceMap.containsKey(id)) {
				// ignore - no incidences for this location id
				continue;
			}

			List<Data> dataList = incidenceMap.get(id);
				
			double minFraction = 10.0;
			double bestFraction = 1.0;
			double minSlope = Double.MAX_VALUE;
			
			// drop the reporting fraction until we hit negative S 
			// this sets the MIN reporting fraction
			boolean valid = true;
			boolean pointOK = true;
			final int maxdelta = 1000;
			int idelta = maxdelta;
		    double scale = 100000;
			for (int ifraction = (int)scale; ((ifraction > 1)&&valid); ifraction -= idelta) {
				pointOK = true;
				if((ifraction<= idelta)&&(idelta >=10)){
					idelta /= 10;
				}
				double fraction = ifraction/scale;
				
				// for all iterations
				// re-scale the incidence and integrate it over time
				// and subtracting from the susceptible at each time step
				double integratedInfectious = 0.0;
				double integratedRecoveries = 0.0;
				double[] ydataS = new double[maxIteration];
				double[] ydataR = new double[maxIteration];
				double[] xdata = new double[maxIteration];
				for(int i=0; i<maxIteration; i++) {
					ydataS[i] = 0.0;
					ydataR[i] = 0.0;
					xdata[i] = 0.0;
				}
				
				for (int i = 0; ((i < dataList.size())&&valid); i ++) {
					Data data = dataList.get(i);
					double incidence = data.reports/fraction;
					double population = data.population;
					integratedInfectious += incidence;
					double recoveries = integratedInfectious * recoveryRate; 
					integratedRecoveries += recoveries;
					// set the initial recovered
					if(i==0){ 
						integratedRecoveries += (1.0-susceptibleRate) * population;
					}
					integratedInfectious -= recoveries;
					double infectious = integratedInfectious;
					integratedRecoveries *= (1.0 - immunityLossRate);
					double recovered = integratedRecoveries;
					double susceptible = population - (infectious + recovered);
					ydataS[i] = susceptible/population;
					ydataR[i] = recovered/population;
					xdata[i] = i;
					if((susceptible >= 0.0) &&(recovered>=0.0)&&(infectious>= 0.0)){
						minFraction = fraction;
						data.reportingFraction = minFraction;
					} else {
						pointOK = false;
						if(idelta > 1) {
							// back up and take smaller steps
							ifraction += idelta;
							idelta /= 10;
						} else {
							valid = false;
							idelta = maxdelta;
						}
						break;
					}
					if(!(valid&&pointOK)) break;
				} // for i time steps
				
				if(valid&&pointOK) {
					double slope = getSlopeLinear(xdata,ydataS);
					if (Math.abs(slope) <= minSlope) {
						minSlope = Math.abs(slope);
						bestFraction = fraction;
					}
				}
				
			} // for all reporting fractions

			// set the fractions
			for (int i = 0; ((i < dataList.size())&&valid); i ++) {
				Data data = dataList.get(i);
				if((bestFraction< 0.9)&&(bestFraction >= data.reportingFraction)){
					data.reportingFraction = bestFraction;
				}
			} // for all times
		} // for all locations
		
		// for all locations
		iter = populationMap.keySet().iterator();
		while(iter.hasNext()) {
			String id = iter.next();
			if(!incidenceMap.containsKey(id)) {
				// ignore - no incidences for this location id
				continue;
			}
			List<Data> dataList = incidenceMap.get(id);

			// for all iterations
			// re-scale the incidence and integrate it over time
			// and subtracting from the susceptible at each time step
			double integratedInfectious = 0.0;
			double integratedRecoveries = 0.0;

			// set the data
			for (int i = 0; (i < dataList.size()); i ++) {
				Data data = dataList.get(i);
				double fraction = data.reportingFraction;
				double incidence = data.reports/fraction;
				double population = data.population;
				integratedInfectious += incidence;
				double recoveries = integratedInfectious * recoveryRate;
				integratedRecoveries += recoveries;
				// set the initial recovered
				if(i==0){
					integratedRecoveries += (1.0-susceptibleRate) * population;
				}
				integratedInfectious -= recoveries;
				data.infectious = integratedInfectious;
				integratedRecoveries *= (1.0 - immunityLossRate);
				data.recovered = integratedRecoveries;
				data.susceptible = population - (data.infectious + data.recovered);
				
			} // for i time steps
			
		} // for all locations
		
	} // modelDiseaseState

	/**
	 * Write the results to the target folder.
	 * 
	 * @param targetFolder The target folder of the results
	 * 
	 * @exception ScenarioInitializationException 
	 * 			  Thrown when failed to write results
	 */
	private void writeResults(
			String targetFolder) throws ScenarioInitializationException {

		try {
			if(!targetFolder.endsWith(File.separator)) {
				targetFolder += File.separator;
			}
			
			Writer fw1 = new FileWriter(targetFolder + INCIDENCE_FILE_NAME);
			Writer fw2 = new FileWriter(targetFolder + SUSCEPTIBLE_FILE_NAME);
			Writer fw3 = new FileWriter(targetFolder + INFECTIOUS_FILE_NAME);
			Writer fw4 = new FileWriter(targetFolder + RECOVERED_FILE_NAME);
			Writer fw5 = new FileWriter(targetFolder + POPULATION_FILE_NAME);
			Writer fw6 = new FileWriter(targetFolder + REPORTING_FRACTION_FILE_NAME);
			
			String[] keys = new String[populationMap.keySet().size()];
			Iterator<String> iter = populationMap.keySet().iterator();
			int counter=0;
			while(iter.hasNext()) {
				keys[counter++] = iter.next();
			}
			
			Arrays.sort(keys);
			String header = "iteration,time";
			for (int i = 0; i < keys.length; i ++) {
				if (incidenceMap.containsKey(keys[i])) {
					header += ","+keys[i];
				}
				
			}
			header += "\n";
			fw1.write(header);
			fw2.write(header);
			fw3.write(header);
			fw4.write(header);
			fw5.write(header);
			fw6.write(header);
			
			// for all iterations
			for (int i = 0; i < maxIteration; i ++) {
				// for all id (columns)
				String line1 = "";
				String line2 = "";
				String line3 = "";
				String line4 = "";
				String line5 = "";
				String line6 = "0,0";
				
				for (int j = 0; j < keys.length; j ++) {
					String id = keys[j];
					if (incidenceMap.containsKey(id)) {
						List<Data> dataList = incidenceMap.get(id);
						if(i >= dataList.size()) {
							break;
						}
						Data data = dataList.get(i);
						if(i==0) {
							line6 += ","+data.reportingFraction;
						}
						if(j == 0) {
							line1 += data.iteration.intValue()+","+data.time;
							line2 += data.iteration.intValue()+","+data.time;
							line3 += data.iteration.intValue()+","+data.time;
							line4 += data.iteration.intValue()+","+data.time;
							line5 += data.iteration.intValue()+","+data.time;
						}
						line1 += ","+data.reports;
						line2 += ","+data.susceptible;
						line3 += ","+data.infectious;
						line4 += ","+data.recovered;
						line5 += ","+data.population;
					}
				}
				line1 += "\n";
				line2 += "\n";
				line3 += "\n";
				line4 += "\n";
				line5 += "\n";
				if (i==0) line6 += "\n";
				fw1.write(line1);
				fw2.write(line2);
				fw3.write(line3);
				fw4.write(line4);
				fw5.write(line5);
				if (i==0) fw6.write(line6);
			}
			fw1.flush();
			fw1.close();
			fw2.flush();
			fw2.close();
			fw3.flush();
			fw3.close();
			fw4.flush();
			fw4.close();
			fw5.flush();
			fw5.close();
			fw6.flush();
			fw6.close();
		} catch (IOException ex) {
			throw new ScenarioInitializationException(ex);
		}
		
	} // writeResults
	
	/**
	 * Returns the STEM ID corresponding to the input ID
	 * 
	 * @param inputID The location id as extracted from the file name
	 * 
	 * @return The STEM ID as extracted from the population file
	 */
	public String convertID(String inputID) {
		
		String inputCode2 = getAdmin2Code(inputID);
		Iterator<String> iter = populationMap.keySet().iterator();
		while(iter.hasNext()) {
			String id = iter.next();
			if(getAdmin2Code(id).equalsIgnoreCase(inputCode2)) return id;
		}
		return null;
		
	} // convertID
	
	/**
	 * Find the STEM ID by matching region2 code part
	 * 
	 * @param id The location id as extracted from the file name
	 * 
	 * @return The STEM ID as extracted from the population file
	 */
	public static String getAdmin2Code(String id) {
		
		int idx = id.lastIndexOf("-");
		return id.substring(idx+1,id.length());
		
	} // getAdmin2Code
	
	/**
	 * Do the linear fitting.
	 * 
	 * @param xData
	 * @param yData
	 * 
	 * @return slope
	 */
	private double getSlopeLinear(double[] xData, double[] yData) {
		
		LinearLeastSquaresFit linFit = new LinearLeastSquaresFit(xData, yData);
		
		return linFit.getSlope();
		
	} // getSlopeLinear
	
	/**
	 * Returns the population size for a given iteration.
	 * computation is based on
	 * pj(t) = pj0 + fractChangePopulationPerDay*(iteration-referencePopulationDay)
     * 
	 * @param iteration The iteration count (day number)
	 * @param refPop The size of the population as extracted from the file
	 * 
	 * @return The population size for a given iteration
	 */
	private double getPopulation(int iteration, double refPop) {
		
		double increase = (iteration-referencePopulationDay) * fractChangePopulationPerDay;
		return refPop*(1 + increase);
		
	} // getPopulation
	
	/**
	 * Create a new BufferedReader
	 * 
	 * @param f The file we want to open for reading
	 * 
	 * @return a reader to a given file
	 */
	public static BufferedReader openReader(File f) {

		try {
			if (f.exists() == false) {
				return null;
			}
			return new BufferedReader(new FileReader(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	} // openReader
	
	/**
	 * Indicate End-Of-File
	 * 
	 * @param buffer A buffer of data
	 * 
	 * @return True if we have reached End-Of-File
	 */
	public static boolean EOF(String buffer) {
		
		if (buffer == null || buffer.length() == 0)
			return true;
		return false;
		
	} // EOF
	
	/**
	 * Class for each row in the input files
	 */
	public class Data {
		
		/**
		 * Reported incidence
		 */
		public double reports; 
		
		/**
		 * Reporting fraction
		 */
		public double reportingFraction = -1.0;
		
		/**
		 * S
		 */
		public double susceptible = 0.0;
		
		/**
		 * I
		 */
		public double infectious = 0.0;
		
		/**
		 * R
		 */
		public double recovered = 0.0;
		
		/**
		 * Population size
		 */
		public double population = 0.0;
		
		/**
		 * Iteration count (day number)
		 */
		public Integer iteration;

		/**
		 * Time associated with this row
		 */
		public String time;
		
		/**
		 * @param iter Iteration count (day number)
		 * @param time The date of the report
		 * @param reported Number of reported incidence
		 * @param pop Population size
		 */
		public Data(Integer iter, String time, double reported, double pop) {
			this.iteration = iter;
			this.time = time;
			this.reports = reported;
			this.population = pop;
		}
		
		/**
		 * @return The reference population size
		 */
		public double getReferencePopulation() {
			return population;
		}

		/**
		 * Set the reference population size
		 * 
		 * @param localPopulation The reference population size
		 */
		public void setLocalPopulation(double localPopulation) {
			this.population = localPopulation;
			this.susceptible = localPopulation; // initially
		}

	} // Data

} // DataProcessor

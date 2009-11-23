package org.eclipse.stem.utility.generators;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * The utility takes as input a .properties file containing arrival/departure/base population information
 * for airports at a given level (e.g. counties) and generates a new file containing
 * arrival/departure information for the pipe air transportation hub at the level above (e.g .state).
 * 
 * The arrival/departure information in the input file includes all passengers, domestic and international
 */
public class AirTransportGenerator {
	
	static String LS = System.getProperty("line.separator"); //$NON-NLS-1$
	
	private static Map<String, ArrayList<TransportationRecord>> records = new HashMap<String, ArrayList<TransportationRecord>>();
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "nls", "synthetic-access" })
	public static void main(String [] args) {
		if(args.length < 2) {
			System.err.println("Usage: AirTransportGenerator <input .properties file> <Top Transporation System");
			System.exit(-1);
		}
		
		try {
		String inputFile = args[0];
		String topSystem = args[1];
		
		File propfile = new File(inputFile);
		if(!propfile.exists()) {
			System.err.println("Error, "+inputFile+" doesn't exist");
			System.exit(-1);
		}
		
		
		BufferedReader ireader = new BufferedReader(new InputStreamReader(new FileInputStream(propfile)));
		   
		FileWriter fw = new FileWriter(inputFile+".new");
			
		String line;
		while((line=ireader.readLine()) != null) {
		  	if(!line.startsWith("#") &&
		  			!line.startsWith("RECORD_CLASSNAME") &&
		  			!line.startsWith("TITLE") &&
		  			!line.startsWith("VALID") &&
		  			!line.startsWith("TRANSPORT_MODE ") &&
		  			!line.startsWith("ISOKEY_0") &&
		  			!line.startsWith("ISOKEY_0_LEVEL") &&
		   			!line.startsWith("ISOKEY_1") &&
		  			!line.startsWith("ISOKEY_1_LEVEL") &&
		  			!line.startsWith("POPULATION_IDENTIFIER") &&
		  			!line.startsWith("RATE_TIME_PERIOD") &&
		  			!line.startsWith("AVG_TIME_IN_SYSTEM") &&
		  			!line.startsWith("START_POPULATION_IN_NETWORK") &&
		  			!(line.trim().length() == 0)
				) {
		  		// Find the transportation record
		    		
		  		int eqindex = line.indexOf("=");
		  		String trans = line.substring(eqindex+1);
		  		StringTokenizer st = new StringTokenizer(trans,",");
		  		TransportationRecord record = new TransportationRecord();
		  		record.hub_top = st.nextToken().trim();
		  		record.hub_bottom = st.nextToken().trim();
		  		record.arrivals = Integer.parseInt(st.nextToken().trim());
		  		record.departures = Integer.parseInt(st.nextToken().trim());
		  		record.base_population = Integer.parseInt(st.nextToken().trim());
		
		  		if(records.containsKey(record.hub_top))
		  			records.get(record.hub_top).add(record);
		  		else {
		  			ArrayList<TransportationRecord> list = new ArrayList<TransportationRecord>();
		  			records.put(record.hub_top, list);
		  			list.add(record);
		  		}
		  		line = "";
		  	}
		    if(line!=null&&line.trim().length() != 0)	fw.write(line+LS);
		    fw.flush();
		}  // For each line
		
		// Now figure out the arrival/departure for the top transportation systems
		
		// The denominator
		double denom = getDenominator();
	
		int linenr = 1;
		for(String hub:records.keySet()) {
			List<TransportationRecord> list = records.get(hub);
			int arr_sum=0, dep_sum=0;
			for(TransportationRecord record:list) {
				arr_sum+=record.arrivals;
				dep_sum+=record.departures;
			}
			// The population is sum of all arrivals and departures / 2
			int base_population = (arr_sum+dep_sum)/2;
			// Figure put the arrival/departure rate 
			
			
			double prob = 0.0; // probability of an in-state-travel 
			
			// The probability of an in-state travel is the sum if the probability
			// of travel within the state
			for(TransportationRecord source:list) {
				for(TransportationRecord dest:list) {
					if(source == dest) continue;
					double p = getProbability(source, dest, denom);
					prob += p;
				}
			}
						
			// These are the out-of-state travellers
			int arrivals = base_population - (int)(base_population*prob);
			int departures = base_population - (int)(base_population*prob);
			
			fw.write(""+linenr++);
			fw.write(" = ");
			fw.write(topSystem);
			fw.write(",");
			fw.write(hub);
			fw.write(",");
			fw.write(arrivals+"");
			fw.write(",");
			fw.write(departures+"");
			fw.write(",");
			fw.write(base_population+"");
			fw.write(LS);
		}
		
		// 
		fw.flush();
		fw.close();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	} // main
	
	private static double getDenominator() {
		double result = 0.0;
		for(String key1:records.keySet()) {
			List<TransportationRecord> records1 = records.get(key1);
			for(TransportationRecord record1:records1) {
				// average arrivals/departures, should be the same anyway
				double nom1 = (record1.arrivals + record1.departures)/2.0;
				double den1 = record1.base_population;
				double phi1 = nom1/den1;
				for(String key2:records.keySet()) {
					List<TransportationRecord> records2 = records.get(key2);
					for(TransportationRecord record2:records2) {
						if(record1 == record2) continue; // skip travel to/from same destination
						// average arrivals/departures, should be the same anyway
						double nom2 = (record2.arrivals + record2.departures)/2.0;
						double den2 = record2.base_population;
						double phi2 = nom2/den2;
						result += phi1*phi2;
					}
				}
			}
		}
		return result;
	}
	
	private static double getProbability(TransportationRecord source, TransportationRecord dest, double denominator) {
		double nom1 = (source.arrivals + source.departures)/2.0;
		double den1 = source.base_population;
		double phi1 = nom1/den1;
		double nom2 = (dest.arrivals + dest.departures)/2.0;
		double den2 = dest.base_population;
		double phi2 = nom2/den2;
		return phi1*phi2/denominator;
	}
	private static class TransportationRecord {
		public int arrivals;
		public int departures;
		public int base_population;
		public String hub_top;
		public String hub_bottom;
	}
}

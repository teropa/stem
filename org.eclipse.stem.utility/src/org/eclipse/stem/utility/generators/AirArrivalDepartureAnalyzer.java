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
import java.util.StringTokenizer;

/**
 *
 */
public class AirArrivalDepartureAnalyzer {
	
	static String LS = System.getProperty("line.separator"); //$NON-NLS-1$
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "nls" })
	public static void main(String [] args) {
		if(args.length < 1) {
			System.err.println("Usage: AirTransportGenerator <input .csv file>");
			System.exit(-1);
		}
		
		try {
		String inputFile = args[0];
		
		File csvfile = new File(inputFile);
		if(!csvfile.exists()) {
			System.err.println("Error, "+inputFile+" doesn't exist");
			System.exit(-1);
		}
		
		
		BufferedReader ireader = new BufferedReader(new InputStreamReader(new FileInputStream(csvfile)));
		   
		FileWriter fw = new FileWriter(inputFile+".out.csv");
			
		HashMap<String, Integer> nationalArrivals = new HashMap<String, Integer>();
		HashMap<String, Integer> nationalDepartures = new HashMap<String, Integer>();
		HashMap<String, Integer> stateTrips = new HashMap<String, Integer>();
		
		String line;
		line = ireader.readLine(); //skip first header row
		while((line=ireader.readLine()) != null) {    		
		  		StringTokenizer st = new StringTokenizer(line,",");
		  		String departureId  = st.nextToken().trim();
		  		String arrivalId = st.nextToken().trim();
		  		int population1 = Integer.parseInt(st.nextToken().trim());
		  		int population2 = Integer.parseInt(st.nextToken().trim());
		  		double flighttime = Double.parseDouble(st.nextToken().trim());
		  		double distance = Double.parseDouble(st.nextToken().trim());
		  		int travellers = Integer.parseInt(st.nextToken().trim());
		  		
		  		String departureState = departureId.substring(0, 5);
		  		String arrivalState = arrivalId.substring(0, 5);
		  		
		  		if(departureState.equals(arrivalState)) {
		  			// Travel within a state
		  			if(stateTrips.containsKey(departureState)) 
		  				stateTrips.put(departureState, stateTrips.get(departureState) + travellers);
		  			else
		  				stateTrips.put(departureState, travellers);
		  		} else {
		  			// Travel state to another state
		  			if(nationalDepartures.containsKey(departureState)) 
		  				nationalDepartures.put(departureState, nationalDepartures.get(departureState) + travellers);
		  			else
		  				nationalDepartures.put(departureState, travellers);
		  			if(nationalArrivals.containsKey(arrivalState)) 
		  				nationalArrivals.put(arrivalState, nationalArrivals.get(arrivalState) + travellers);
		  			else
		  				nationalArrivals.put(arrivalState, travellers);
		  		}	
		} // for each line
		
		ArrayList<String> allStates = new ArrayList<String>();
		for(String state:nationalArrivals.keySet()) if(!allStates.contains(state)) allStates.add(state);
		for(String state:nationalDepartures.keySet()) if(!allStates.contains(state)) allStates.add(state);
		for(String state:stateTrips.keySet()) if(!allStates.contains(state)) allStates.add(state);
		
		fw.write("State, Local state trips, National Arrivals, NationalDepartures, % leaving state");
		fw.write(LS);
		for(String state:allStates) {
			int st = (stateTrips.containsKey(state))? stateTrips.get(state) : 0;
			int na = (nationalArrivals.containsKey(state))? nationalArrivals.get(state) : 0;
			int nd = (nationalDepartures.containsKey(state))? nationalDepartures.get(state) : 0;
			
			fw.write(state+",");
			fw.write(st+"");
			fw.write(",");
			fw.write(na+"");
			fw.write(",");
			fw.write(nd+"");
			fw.write(",");
			
			double perc = ((double)na+(double)nd) / ((double)na+(double)nd+st);
			fw.write(""+perc);
			fw.write(LS);
		}
		fw.flush();
		fw.close();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}

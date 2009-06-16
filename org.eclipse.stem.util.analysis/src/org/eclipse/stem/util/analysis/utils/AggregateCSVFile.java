package org.eclipse.stem.util.analysis.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


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
 * Utility that reads a STEM CSV file and generates another csv file containing 
 * an aggregate column for all locations in the original file
 */
public class AggregateCSVFile {

	/**
	 * @param args
	 */
	@SuppressWarnings("boxing")
	public static void main(String[] args) {
		if(args.length == 0) {
			System.err.println("Usage: AggregateCSVFile <csv file> <output file>\nOutput file is optional and if not specified the name will be generated from the input file.");
			System.exit(-1);
		}
		
		String cvsfilename = args[0];
		String outfilename = null;
		if(args.length == 1) outfilename = args[0]+"_aggregate.csv";
		else outfilename= args[1];
		
		Map<Integer, Double>aggregate = new HashMap<Integer, Double>();
		List<Integer> iteration = new ArrayList<Integer>();
		List<String> time = new ArrayList<String>();
		try {
			 FileInputStream fis = new FileInputStream(cvsfilename); 
		     BufferedReader d = new BufferedReader(new InputStreamReader(fis));
		     String header = null;
		     header=d.readLine();
		     if(header == null) {
		    	 System.err.println("Error, file is empty!");
		    	 System.exit(-2);
		     }
		    String data = null; 
		    while ( (data=d.readLine()) != null ) { 
		    	StringTokenizer st = new StringTokenizer(data, ",");
		    	int column = 0;
		    	int it=0;
				while (st.hasMoreTokens()) {
					String val = st.nextToken().trim();
					if(column == 0) {
						it = Integer.parseInt(val);
						iteration.add(it);
					}
					else if(column == 1) time.add(val);
					else { // column > 1, location column
						if(aggregate.containsKey(it)) 
							aggregate.put(it, aggregate.get(it)+Double.parseDouble(val));
						else aggregate.put(it, Double.parseDouble(val));
					}
				    ++ column;
			     } // read tokens
		    } //read iteration line
		    
		    d.close();
		    // Write
		    FileWriter fw = new FileWriter(outfilename);
		    fw.write("iteration,time,aggregate\n"); // header
		    int row = 0;
		    for(int it:iteration) {
		    	fw.write(it+",");
		    	fw.write(time.get(row)+",");
		    	fw.write(aggregate.get(it)+"\n");
		    	++row;
		    }
		    fw.flush();
		    fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

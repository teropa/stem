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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Given a data reference date (when was population values taken), a desired target date and
 * a daily growth rate, reverse population values back (or forward) to the target date in
 * all population properties file found in the target directory
 */
public class PopulationModifier {
	
	static String LS = System.getProperty("line.separator"); //$NON-NLS-1$
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String [] args) {
		if(args.length < 4) {
			System.err.println("Usage: PopulationModifier <target dir> <reference date> <target date> <daily growth rate>");
			System.exit(-1);
		}
		
		try {
		String dir = args[0];
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/y");
		Date ref = sdf.parse(args[1]);
		Date target = sdf.parse(args[2]);
		double daysbackward = (ref.getTime() - target.getTime()) / (3600*24*1000);
		double growth = Double.parseDouble(args[3]);
		
		
		File f = new File(dir);
		if(!f.exists() || !f.isDirectory()) {
			System.err.println("Error, "+dir+" is not a directory or doesn't exist");
			System.exit(-1);
		}
		
		
		String [] files = f.list();
		for(String file : files) {
			if(!file.contains("_population.properties")) continue;
			File propfile = new File(dir+File.separator+file);
		
			BufferedReader ireader = new BufferedReader(new InputStreamReader(new FileInputStream(propfile)));
		   
			FileWriter fw = new FileWriter(dir+File.separator+file+".new");
			
			String line;
		    while((line=ireader.readLine()) != null) {
		    	if(!line.startsWith("#") &&
		    			!line.startsWith("RECORD_CLASSNAME") &&
		    			!line.startsWith("ISOKEY") &&
		    			!line.startsWith("ADMIN_LEVEL") &&
		    			!line.startsWith("VALID") &&
		    			!line.startsWith("SOURCE") &&
		    			!line.startsWith("POPULATION") &&
		    			!line.startsWith("YEAR") &&
		    			!(line.trim().length() == 0)
		    			) {
		    		// Find the population number
		    		
		    		int eqindex = line.indexOf("=");
		    		String pops = line.substring(eqindex+1);
		    		double ref_pop = Double.parseDouble(pops);
		    		double g = 1.0+growth;
		    		double fact = Math.pow(g, daysbackward);
		    		long target_pop = (long)(ref_pop / fact);
		    		line = line.substring(0, eqindex)+" = "+target_pop;
		    	}
		    	fw.write(line+LS);
		    }
		    fw.flush();
		    fw.close();
		    
		}  // For each file
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}

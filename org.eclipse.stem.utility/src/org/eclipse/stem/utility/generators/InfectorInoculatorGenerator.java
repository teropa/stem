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
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The file imports an infectious log file (param1), a population log file (param 2)
 * and using the specified disease name (param3) it generates infector and inoculator XML file
 * that can be imported into a scenario to initialize it to the initial log file
 * state
 */
public class InfectorInoculatorGenerator {

	/**
	 * NLS Prefix for Infector name
	 */
	public static String infectorPrefix = Messages.getString("Inoculator.1"); //$NON-NLS-1$
	
	/**
	 * NLS Prefix for Inoculator name
	 */
	public static String inoculatorPrefix = Messages.getString("Inoculator.2"); //$NON-NLS-1$
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String [] args) {
		if(args.length < 6) {
			System.err.println("Usage: InfectorInoculatorGenerator <I file> <R file> <P file> <disease name> <project name> <default I% (optional)> <scale R fraction (optional)>"); //$NON-NLS-1$
			System.exit(-1);
		}
		
		String diseaseName = args[3];
		String projectName = args[4];
	
		boolean useDefault = false;
		double iperc = 0.0;
		double rscale = 1.0;
		
		if(args.length >5) {
			useDefault = true;
			iperc = Double.parseDouble(args[5]);
		}
		if(args.length > 6) {
			useDefault = true;
			rscale = Double.parseDouble(args[6]);
		}
			
		ArrayList<String>locations = new ArrayList<String>();
		ArrayList<Double>infectious = new ArrayList<Double>();
		ArrayList<Double>recovered = new ArrayList<Double>();
		ArrayList<Double>population = new ArrayList<Double>();
		
		try {
			 // Read infectious file
			 FileInputStream ifile = new FileInputStream(args[0]); 
		     BufferedReader ireader = new BufferedReader(new InputStreamReader(ifile));
		     String header = null;
		     header=ireader.readLine();
		     if(header == null) {
		    	 System.err.println("Error, "+args[0]+" file is empty!");  //$NON-NLS-1$//$NON-NLS-2$
		    	 System.exit(-2);
		     }
		     StringTokenizer st = new StringTokenizer(header, ","); //$NON-NLS-1$
		     int column = 0;
		     while(st.hasMoreTokens()) {
		    	 String val = st.nextToken();
		    	 if(column < 2) {++column;continue;}
		    	 locations.add(val.trim());
		    	 ++column;
		     }
		    
		    String data = null; 
		    data=ireader.readLine();
		    if(data == null) {
		    	 System.err.println("Error, "+args[0]+" file has no data!");  //$NON-NLS-1$//$NON-NLS-2$
		    	 System.exit(-2);
		     }
		    
		    st = new StringTokenizer(data, ","); //$NON-NLS-1$
		    column = 0;
			while (st.hasMoreTokens()) {
				String val = st.nextToken().trim();
				if(column < 2) {++column;continue;} // skip iteration, time
				infectious.add(Double.parseDouble(val));
			    ++ column;
		    } // read tokens
		    
		    ireader.close();
		    
		    // Read recovered file
		    ifile = new FileInputStream(args[1]); 
		    ireader = new BufferedReader(new InputStreamReader(ifile));
		    header = null;
		    header=ireader.readLine();
		    if(header == null) {
		     System.err.println("Error, "+args[1]+" file is empty!"); //$NON-NLS-1$//$NON-NLS-2$
		     System.exit(-2);
		    }
		    
		    data = null; 
		    data=ireader.readLine();
		    if(data == null) {
		    	 System.err.println("Error, "+args[1]+" file has no data!"); //$NON-NLS-1$//$NON-NLS-2$
		    	 System.exit(-2);
		     }
		    
		    st = new StringTokenizer(data, ","); //$NON-NLS-1$
		    column = 0;
			while (st.hasMoreTokens()) {
				String val = st.nextToken().trim();
				if(column < 2) {++column;continue;} // skip iteration, time
				recovered.add(Double.parseDouble(val));
			    ++ column;
		    } // read tokens
		    
		    ireader.close();
		    
		    // Read population file
		    ifile = new FileInputStream(args[2]); 
		    ireader = new BufferedReader(new InputStreamReader(ifile));
		    header = null;
		    header=ireader.readLine();
		    if(header == null) {
		     System.err.println("Error, "+args[2]+" file is empty!"); //$NON-NLS-1$//$NON-NLS-2$
		     System.exit(-2);
		    }
		    
		    data = null; 
		    data=ireader.readLine();
		    if(data == null) {
		    	 System.err.println("Error, "+args[2]+" file has no data!"); //$NON-NLS-1$//$NON-NLS-2$
		    	 System.exit(-2);
		     }
		    
		    st = new StringTokenizer(data, ","); //$NON-NLS-1$
		    column = 0;
			while (st.hasMoreTokens()) {
				String val = st.nextToken().trim();
				if(column < 2) {++column;continue;} // skip iteration, time
				population.add(Double.parseDouble(val));
			    ++ column;
		    } // read tokens
		    
		    ireader.close();
		    
		    
		    int index = 0;
		    // Write
		    for(String location:locations) {
		    	String infectorfilename = infectorPrefix+index;
		    	String inoculatorfilename = inoculatorPrefix+index;
		    	FileWriter infectorfw = new FileWriter(infectorfilename+".standard");
		    	FileWriter inoculatorfw = new FileWriter(inoculatorfilename+".standard");
		    	
		    	double infd = infectious.get(index);
		    	if(infd == 0.0 && useDefault) {
		    		infd = population.get(index)*iperc/100.0;
		    	}
		    	
		    	infectorfw.write("<?xml version=\"1.0\" encoding=\"ASCII\"?>\n");
		    	infectorfw.write("<org.eclipse.stem.diseasemodels.standard:SIInfector xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:org.eclipse.stem.diseasemodels.standard=\"http:///org/eclipse/stem/diseasemodels/standard.ecore\" ");
		    	infectorfw.write(" uRI=\"platform:/resource/"+projectName+"/decorators/"+infectorfilename+".standard\" typeURI=\"stemtype://org.eclipse.stem/identifiable83\" ");
		    	infectorfw.write(" diseaseName=\""+diseaseName+"\" targetISOKey=\""+location+"\" populationIdentifier=\"human\" infectiousCount=\""+infd+"\">\n");
		    	infectorfw.write(" <dublinCore title=\"Infect "+infd+" &quot;human&quot; population members with the disease &quot;"+diseaseName+"&quot; at the location &quot;"+location+"&quot;.\" identifier=\"platform:/resource/"+projectName+"/decorators/"+infectorfilename+".standard\" description=\"Infect "+infd+" &quot;human&quot; population members with the disease &quot;"+diseaseName+"&quot; at the location &quot;"+location+"&quot; (CH-GN).\" creator=\"generated\" format=\"http:///org/eclipse/stem/diseasemodels/standard.ecore\" type=\"stemtype://org.eclipse.stem/identifiable83\" created=\"2008-12-17\"/>\n");
		    	infectorfw.write("</org.eclipse.stem.diseasemodels.standard:SIInfector>\n");
		    	infectorfw.flush();
		    	infectorfw.close();
		    	
		    	double inoculatedPercentage = 100.0*recovered.get(index)/population.get(index);
		    	inoculatedPercentage = inoculatedPercentage * rscale;
		    	System.out.println("r_scale:"+rscale);
		    	
		    	inoculatorfw.write("<?xml version=\"1.0\" encoding=\"ASCII\"?>\n");
		    	inoculatorfw.write("<org.eclipse.stem.diseasemodels.standard:SIRInoculator xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:org.eclipse.stem.diseasemodels.standard=\"http:///org/eclipse/stem/diseasemodels/standard.ecore\" ");
		    	inoculatorfw.write(" uRI=\"platform:/resource/"+projectName+"/decorators/"+inoculatorfilename+".standard\" typeURI=\"stemtype://org.eclipse.stem/identifiable9\" ");
		    	inoculatorfw.write(" diseaseName=\""+diseaseName+"\" targetISOKey=\""+location+"\" populationIdentifier=\"human\" infectiousCount=\"0\" inoculatedPercentage=\""+inoculatedPercentage+"\">\n");
		    	inoculatorfw.write(" <dublinCore title=\"Inoculate "+inoculatedPercentage+" &quot;human&quot; percent of population against the disease &quot;"+diseaseName+"&quot; at the location &quot;"+location+"&quot;.\" identifier=\"platform:/resource/"+projectName+"/decorators/"+inoculatorfilename+".standard\" description=\"Inoculate "+inoculatedPercentage+" &quot;human&quot; percent of population against the disease &quot;"+diseaseName+"&quot; at the location &quot;"+location+"&quot; .\" creator=\"generated\" format=\"http:///org/eclipse/stem/diseasemodels/standard.ecore\" type=\"stemtype://org.eclipse.stem/identifiable9\" created=\"2008-12-17\"/>\n");
		    	inoculatorfw.write("</org.eclipse.stem.diseasemodels.standard:SIRInoculator>\n");
		    	inoculatorfw.flush();
		    	inoculatorfw.close();
		    	
		    	
		    	++index;
		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

// CSVAnalysisWriter
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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.analysis.ErrorResult;


/**
 * writes CSV Files
 * 
 */
public class CSVAnalysisWriter  {

	// private static final DateFormat df =
	// DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.MEDIUM);

	/**
	 * 
	 */
	private String outputFileName = "";


	/**
	 * TODO need to get disease parameters for the scenario and write them to a
	 * file
	 */
	protected String paramFileName;

	//private static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE d MMM yy", Locale.getDefault());

	private static final IPath PATH = org.eclipse.stem.util.analysis.Activator.getDefault().getStateLocation();

	private static final String sep = File.separator;

	protected static final String CSV = "csv";

	private static final String PATH_SUFFIX = CSV+sep;

	private  static String adir = PATH.append(sep + PATH_SUFFIX).toOSString();

	private FileWriter fw;

	/**
	 * decimal format
	 */
	// private static final DecimalFormat df1 = new DecimalFormat( "0.0" );
	// private static final DecimalFormat df2 = new DecimalFormat( "0.00" );
	// private static final DecimalFormat df3 = new DecimalFormat( "0.000" );
	// private static final DecimalFormat df4 = new DecimalFormat( "0.0000" );
	// private static final DecimalFormat df5 = new DecimalFormat( "0.00000" );




	/**
	 * 
	 * @param fileName
	 */
	public CSVAnalysisWriter(final String fileName) {

		outputFileName = adir+fileName+"."+CSV;
		final File dir = new File(adir);
		if ((!dir.exists()) || (!dir.isDirectory())) {
			// create it.
			boolean success = dir.mkdirs();
			if (!success) {
				Activator.logError(
						"Failed to Create Driectory" + outputFileName,
						new IOException("Failed to Create Driectory"
								+ outputFileName));
			}

		}

		try {
			fw = new FileWriter(outputFileName);
		} catch (final IOException e) {
			Activator.logError(
					"Error closing CSV analysis file"
					+ outputFileName + outputFileName, e);
		}

	} // CSVAnalysisWriter

	/**
	 * 
	 * @param directory
	 * @param fileName
	 */
	public CSVAnalysisWriter(final String directory, final String fileName) {


		adir = directory;
		outputFileName = adir+fileName+"."+CSV;

		final File dir = new File(adir);
		if ((!dir.exists()) || (!dir.isDirectory())) {
			// create it.
			boolean success = dir.mkdirs();
			if (!success) {
				Activator.logError(
						"Failed to Create Driectory" + outputFileName,
						new IOException("Failed to Create Driectory"
								+ outputFileName));
			}

		}

		try {
			fw = new FileWriter(outputFileName);
		} catch (final IOException e) {
			Activator.logError(
					"Error closing CSV analysis file"
					+ outputFileName + outputFileName, e);
		}

	} // CSVAnalysisWriter



	/**
	 * Log the data from a simple list
	 * @param dataList 
	 */
	public void logData(List<EList<Double>> dataList) {


		// get the size of the longest array
		int maxRows = 0;
		int numArrays = dataList.size();
		for(int i = 0; i < numArrays; i ++) {
			EList<Double> data = dataList.get(i);
			if(data.size() >= maxRows) maxRows = data.size();
		}


		// rows
		for(int y = 0; y < maxRows; y ++) {
			//String str = "";
			StringBuilder strBldr = new StringBuilder();
			// columns
			for(int x = 0; x < numArrays; x ++) {
				EList<Double> data = dataList.get(x);
				if(data.size()>= maxRows) {
					strBldr.append(data.get(y));
					if(x < numArrays-1) {
						strBldr.append(", ");
					}
				}
			}

			strBldr.append("\n");
			try {
				fw.write(strBldr.toString());
			} catch (final IOException e) {
				Activator.logError("Error writing data to CSV Analysis file"
						+ outputFileName + outputFileName, e);
			}
		}

		try {
			fw.flush();
			fw.close();
		} catch (final IOException e) {
			Activator.logError(
					"Error closing CSV analysis file"
					+ outputFileName + outputFileName, e);
		}
	}// log data

	/**
	 * Log the data from a simple list
	 * @param header 
	 * @param dataList 
	 */
	public void logData(List<String> header, List<double[]> dataList) {

		String strHeader = "iteration";
		StringBuilder strBldr = new StringBuilder(strHeader);
		// header columns
		for(int x = 0; x < header.size(); x ++) {
			strBldr.append(", ");
			strBldr.append(header.get(x));
		}
		strBldr.append("\n");
		try {
			fw.write(strBldr.toString());
		} catch (final IOException e) {
			Activator.logError("Error writing HEADER to CSV Analysis file"
					+ outputFileName + outputFileName, e);
		}

		// get the size of the longest array
		int maxRows = 0;
		int numArrays = dataList.size();
		for(int i = 0; i < numArrays; i ++) {
			double[] data = dataList.get(i);
			if(data.length >= maxRows) maxRows = data.length;
		}


		// rows
		for(int y = 0; y < maxRows; y ++) {
			//String str = y+" ";
			// columns
			
			strBldr = new StringBuilder();
			strBldr.append(y);
			strBldr.append(" ");
			
			for(int x = 0; x < numArrays; x ++) {
				double[] data = dataList.get(x);
				if(data.length>= maxRows) {
					strBldr.append(", ");
					strBldr.append(data[y]);
				}
			}

			strBldr.append("\n");
			try {
				fw.write(strBldr.toString());
			} catch (final IOException e) {
				Activator.logError("Error writing data to CSV Analysis file"
						+ outputFileName + outputFileName, e);
			}
		}

		try {
			fw.flush();
			fw.close();
		} catch (final IOException e) {
			Activator.logError(
					"Error closing CSV analysis file"
					+ outputFileName + outputFileName, e);
		}
	}// log data


	/**
	 * Log the data for a list of trajectories
	 * @param dimension of the space (always 2 for now)
	 * @param dataList 
	 */
	public void logData(int dimension, List<PhaseSpaceCoordinate[]> dataList) {


		// get the size of the longest array
		int maxRows = 0;
		int numArrays = dataList.size();
		for(int i = 0; i < numArrays; i ++) {
			PhaseSpaceCoordinate[] data = dataList.get(i);
			if(data.length >= maxRows) maxRows = data.length;
		}


		// rows
		for(int y = 0; y < maxRows; y ++) {
			// columns
			//String str = "";

			StringBuilder strBldr = new StringBuilder();

			for(int x = 0; x < numArrays; x ++) {
				PhaseSpaceCoordinate[] data = dataList.get(x);
				if(data.length>= maxRows) {
					strBldr.append(data[y].xValue);
					strBldr.append(", ");
					strBldr.append(data[y].yValue);
					strBldr.append("  ");
					if(x < numArrays-1) {
						strBldr.append(", ");
					}
				}
			}
			strBldr.append("\n");
			try {
				fw.write(strBldr.toString());
			} catch (final IOException e) {
				Activator.logError("Error writing data to CSV Analysis file"
						+ outputFileName + outputFileName, e);
			}
		}

		try {
			fw.flush();
			fw.close();
		} catch (final IOException e) {
			Activator.logError(
					"Error closing CSV analysis file"
					+ outputFileName + outputFileName, e);
		}




	}// log data


	/**
	 * Log the data for a comparison of multiple scenarios versus a reference
	 * scenario
	 * @param data 
	 */
	public void logData(Map<Map<String, String>, ErrorResult> data) {
		// write the header param names plus the header for the RMS difference
		// Just get the first key and use the param names from it
		try {
			Map<String, String> firstResult = data.keySet().iterator().next();
			Set<String> parms = firstResult.keySet();
			for(String p : parms) {
				fw.write(p);
				fw.write(",");
			}
			fw.write("RMS");
			fw.write("\n");

			// Now write the result

			for(Map<String, String> entry : data.keySet()) {
				ErrorResult res = data.get(entry);
				// Compute average
				Collection<String> pvalues = entry.values();
				for(String pval : pvalues) {fw.write(pval);fw.write(",");}
				double error = 0;
				if(res!=null){
					error = res.getError();
				}
				fw.write(error+"");
				fw.write("\n");

			}
		} catch(IOException ioe) {
			Activator.logError(
					"Error closing CSV analysis file"
					+ outputFileName + outputFileName, ioe);
		}	

	}


	/*
	 * private Graph getGraph(final Node node) { return (Graph)
	 * node.eContainer().eContainer(); } // getGraph
	 */

	/**
	 * Flush and Close the file
	 */
	public void flushLoggerData() {
		try {
			if (fw != null) fw.flush();
		} catch (final IOException e) {
			// do nothing
		}

	} // flush All Data

	/**
	 * Flush and Close the file
	 */
	public void closeLoggerData() {
		flushLoggerData();

		if (fw == null) {
			return;
		}

		try {
			fw.close();
		} catch (final IOException e) {
			Activator.logError("Error CLOSING CSV Logger file" + outputFileName
					+ outputFileName, e);
		}
		// for testing
	} // logAll Data

}

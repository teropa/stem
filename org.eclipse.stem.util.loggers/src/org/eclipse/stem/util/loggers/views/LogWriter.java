// LogWriter 
package org.eclipse.stem.util.loggers.views;

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
import java.util.Calendar;
import java.util.Map;

import org.eclipse.stem.adapters.time.TimeProvider;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.jobs.simulation.ISimulation;

/**
 * Abstract LogWriter class
 * 
 */
public abstract class LogWriter {
	
	protected static Calendar now = Calendar.getInstance();
	
	/**
	 * This prefix precedes the node id and must be removed in the 
	 * filterFilename method to auto-generate the output file name.
	 */
	public static final String LOCATIONID_PREFIX = "/node/geo/region/";
	
	protected static final String sep = File.separator;
	
	/**
	 * flag to indicate Header has been successfully written
	 */
	public boolean needsHeader = true;
	
	protected boolean done = false;
	

	
	/**
	 * 
	 * @param rvp
	 */
	public abstract void logHeader(RelativeValueProviderAdapter rvp);
	
	/**
	 * New method
	 * @param simulation
	 * @param dm DiseaseModel
	 * @param nodeLevels
	 * @param timeProvider Time Provider
	 */
	
	public abstract void logHeader(ISimulation simulation, IntegrationDecorator dm, Map<Node, Integer> nodeLevels, TimeProvider timeProvider);
	
	
	/**
	 * Must Flush and close the file
	 */
	public abstract void flushLoggerData();
	
	
	/**
	 * Must Flush and close the file
	 */
	public abstract void closeLoggerData();
	
	
	
	/**
	 * Must implement this method to log data in run thread
	 * @param rvp 
	 * @param timeProvider 
	 * 
	 */
	public abstract void logData(RelativeValueProviderAdapter rvp, TimeProvider timeProvider);
	
	/**
	 * Implement this one for the new logging method
	 * 
	 * @param sim Simulation
	 * @param dm Disease model to log
	 * @param nodeLevels 
	 * @param timeProvider timeProvider
	 * @param beforeStart
	 */
	public abstract void logData(ISimulation sim, IntegrationDecorator dm, Map<Node, Integer>nodeLevels, TimeProvider timeProvider, boolean beforeStart);
	
	/**
	 * resets the output directory for a new set of runs
	 * by resetting the calendars
	 */
	public static void reset() {
		// reset the calendar in case we start again
		now = Calendar.getInstance();
	}
	
	/**
	 * get the current date/time in numeric format
	 * for log directory name
	 * @return date time string
	 */
	public static String getDateTimeNumeric() {
		
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int year = now.get(Calendar.YEAR);
		int hrs = now.get(Calendar.HOUR_OF_DAY)+1;
		int mins = now.get(Calendar.MINUTE);
		//int sec = now.get(Calendar.SECOND);
		
				
		String smonth = ""+month;
		if (month < 10) smonth = "0"+smonth;
		String sday = ""+day;
		if (day < 10) sday = "0"+sday;
		String shrs = ""+hrs;
		if (hrs < 10) shrs = "0"+shrs;
		String smin = ""+mins;
		if (mins < 10) smin = "0"+smin;
		//String ssec = ""+sec;
		//if (sec < 10) ssec = "0"+ssec;
		String time = ""+year+smonth+sday+"_"+shrs+smin;
		return time;
	}//getDateTimeNumeric
	
	/**
	 * filters the location id prefix from the beginning of
	 *  a nodes ID for generation of a file name
	 * @param unfiltered
	 * @return the filtered file name using location id.
	 */
	public static String filterFilename(String unfiltered) {
		int last = unfiltered.indexOf(LOCATIONID_PREFIX);
		if (last >=0) {
			last += LOCATIONID_PREFIX.length();
			return unfiltered.substring(last, unfiltered.length());
		} 
		return unfiltered;

	
	}

}



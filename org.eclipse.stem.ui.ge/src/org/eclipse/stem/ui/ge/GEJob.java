package org.eclipse.stem.ui.ge;
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/ 

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Preferences;
//import org.eclipse.stem.jobs.Activator;
import org.eclipse.stem.jobs.preferences.PreferenceConstants;
import org.eclipse.stem.ui.ge.kml.StemKml;



/**
 * Do some of the work in the background
 * 
 * This is called by GEInterface to take 
 * the collected information about the Simulation 
 * and write it as a KML file. 
 */
public class GEJob extends Thread {

	private String  fn = null;
	private StemKml stemKml = null;
	/**
	 * this is a copy of the map passed to me
	 */
	private Map<String,GEData> stemMap = null;
	
	private Aspect aspect = null; 
	private long cycle = 0;
	private boolean launch = false;
	private boolean rename = false;
		
	private static Thread work = null;
	
	/**
	 * Construct a subclass of Job that will do 
	 * the longrunning part of the interface in
	 * the background.
	 * 
	 * @param name Name associated with job
	 */
	public GEJob(String name) {
		super(name);
		
	}

	/** 
	 * run method for the new Thread
	 * It will write the KML file for GoogleEarth 
	 * and perhaps launch it to GE. 
	 * 
	 *  Although it has no parameters in the call
	 *  the following are assumed to be set by 
	 *  previous call to this.generateKML()
	 *  
	 *  fn - File name that contains the kml
	 *  stemMap
	 *  aspect
	 *  cycle
	 */
	@Override
	public void run() {
		
		GELog.debug(this,fn+" "+aspect+" "
				+cycle+" "+launch+" "+rename);
		try {
			if (rename) {
				File f = new File(fn);
				String parent = f.getParent()+File.separator;
				fn = f.getName();
				String newFile = parent+ fn.replace(".","_New.");
				String currentFile = parent+ fn.replace(".","_Current.");
				String oldFile = parent+fn.replace(".","._Old");
				try {
					
					File fileN = new File(newFile);					
					File fileO = new File(oldFile);
					File fileC = new File(currentFile);
					stemKml.generatePolygons(newFile, stemMap, aspect, cycle);
					
					if (fileO.exists()) {
						fileO.delete();
					} 
					if (fileC.exists())
					  fileC.renameTo(fileO);
					fileN.renameTo(fileC);
					
					//GELog.debug(this,"Current file: "+fileC+" "+fileC.exists());
				} catch (RuntimeException e) {
					
					GELog.error("Failure creating KML files. "+
							    " newFile: "+ newFile	,e);
				}
				
			} else {
				stemKml.generatePolygons(fn, stemMap, aspect, cycle);		
			                  
				if (launch) {
					//	 launch the file for GoogleEarth			  
					StemKml.launch(fn);
					GELog.debug(this,"GoogleEarth Map  submitted");
				}
			}
		} catch (Throwable e) {
			
			GELog.error("Failure in interface to GoogleEarth. ",e);
		}
		
		return;
	}
	/**
	 * Build the .kml file than will be sent to GoogleEarth 
	 * We will recieve the information from GEInterface and then 
	 * schedule the job to be run.
	 * 
	 * @param fn File where we write the kml
	 * @param stemKml  Object containing info about where and
	 *                 how to generate the KML.
	 * @param stemMap  Map of Polygons
	 * 
	 * @param aspect   SEIR Type to be displayed
	 * @param cycle    current cycle number
	 * @param launch   true if file should be sent to GoogleEarth
	 * @param rename   true if file should be written then renamed
	 */	
	
	public void generateKML(String fn, StemKml stemKml, Map<String,GEData> stemMap,
			Aspect aspect,long cycle, boolean launch,boolean rename) {
		
		this.fn = fn;
		this.stemKml = stemKml;
		this.aspect = aspect;
		this.cycle = cycle;
		this.launch = launch;
		this.rename = rename;
		
		if (cycle == 0)
		    checkPreferences();
		
		// copy stemMap 
		// TODO are there ways to avoid this copy 
		// maybe we could synchronize on it...
		int n = stemMap.size();
		this.stemMap = new HashMap<String,GEData>(n);
		this.stemMap.putAll(stemMap);		
				
		//GELog.debug(this,"Scheduling generation of KML file "+fn);
		try {
			// if processing backlog
			if (work != null && 
				work.getState() != Thread.State.TERMINATED) {			
				// TODO skip processing if backlogged ?
				GELog.debug(this,"Skip KML generation for cycle "+cycle);
				return;								
			}
			work = new Thread(this,"Job_"+cycle);
			work.start();
		} catch (Exception e) {
			
			GELog.error("Failure scheduling KML File generation",e);
		}
	}
		/**
		 * Check the STEM system delay and warn if not set.
		 * 	
		 */
		protected void checkPreferences() {
			final Preferences preferences = 
				org.eclipse.stem.jobs.Activator.getDefault()
					.getPluginPreferences();
			boolean simulationSleep = preferences
					.getBoolean(PreferenceConstants.SIMULATION_SLEEP_BOOLEAN);
		       
			int sleepMilliseconds = preferences
					.getInt(PreferenceConstants.SIMULATION_SLEEP_MILLISECONDS_INTEGER);

			if (! simulationSleep || sleepMilliseconds <= 1) {
				GELog.info("GEJob: Specified Sleep interval not specified \n"+        
				           "or may be too short for GoogleEarth operation.\n"+
				           "Check preferences.");
			}
		} // setPerferences	
		
	
}

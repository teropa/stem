/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.analysis.automaticexperiment;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import automaticexperiment.AutomaticExperiment;

public class AutomaticExperimentManager {
	private static final AutomaticExperimentManager instance = new AutomaticExperimentManager();
	protected static boolean QUIT_NOW = false;
	protected static boolean PAUSE_NOW = false;
	protected static CountDownLatch stopLatch = null;
	protected static ErrorAnalysisAlgorithm currentRunningAlgorithm = null;
	protected static AutomaticExperiment currentRunningExperient;
	
	public void quitNow() {
		stopLatch = new CountDownLatch(1);
		QUIT_NOW = true;
		try {
			stopLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void pause() {
		PAUSE_NOW = true;
		// TODO  Please pause now if we want pause
	}
	public static void continueRun() {
		PAUSE_NOW = false;
		// TODO  Please continue now if we want Continue
	}
	
	public void restartNow(double[] restartParamValues) {
		// TODO   Restart with the valued provided
		QUIT_NOW = false;
		currentRunningAlgorithm.reinitStartParams(currentRunningExperient, restartParamValues);
		currentRunningAlgorithm.clearListeners();
		// Stefan fix, we can't hold up the UI thread, it causes memory leaks
		Job j = new Job("Minimizer algorith") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				currentRunningAlgorithm.execute();
				return Status.OK_STATUS;
			}
		};
		
		AutomaticExperimentManagerEvent newEvent = new AutomaticExperimentManagerEvent(currentRunningExperient, currentRunningAlgorithm, MANAGER_STATUS.SCHEDULED);
		fireEvent(newEvent);
		j.schedule();
	}

	private ArrayList<AutomaticExperimentManagerListener> listeners = new ArrayList<AutomaticExperimentManagerListener>();
	
	private AutomaticExperimentManager() {
	}
	public static AutomaticExperimentManager getInstance() 
	{
		return instance;
	}
	
	public ErrorAnalysisAlgorithm createAlgorithm(String name) {
		QUIT_NOW = false; // in case RESTARTING
		PAUSE_NOW = false;
		ErrorAnalysisAlgorithm result = ErrorAnalysisAlgorithmFactory.INSTANCE.createErrorAnalysisAlgorithm(name);
		return result;
	}
	
	public void executeAlgorithm(final ErrorAnalysisAlgorithm algorithm, final AutomaticExperiment automaticExperiment) {
		QUIT_NOW = false; // in case RESTARTING
		PAUSE_NOW = false;
		currentRunningAlgorithm = algorithm;
		currentRunningExperient = automaticExperiment;
		
		algorithm.init(automaticExperiment, algorithm);
		// Stefan fix, we can't hold up the UI thread, it causes memory leaks
		Job j = new Job("Minimizer algorith") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				algorithm.execute();
				return Status.OK_STATUS;
			}
		};
		
		AutomaticExperimentManagerEvent newEvent = new AutomaticExperimentManagerEvent(automaticExperiment, algorithm, MANAGER_STATUS.SCHEDULED);
		fireEvent(newEvent);
		j.schedule();
	}
	
	private  void fireEvent(AutomaticExperimentManagerEvent evt) {
		for(AutomaticExperimentManagerListener l:listeners) l.eventReceived(evt);
	}
	
	public void addListener(AutomaticExperimentManagerListener l) {
		this.listeners.add(l);
	}
	
	public void clearListeners() {
		this.listeners.clear();
	}
	public static void main() {
		QUIT_NOW = false; // in case RESTARTING
		PAUSE_NOW = false;
		AutomaticExperimentManager manager = AutomaticExperimentManager.getInstance();
		manager.addListener(new AutomaticExperimentManagerListener() {
			
			public void eventReceived(AutomaticExperimentManagerEvent evt) {
				if(evt.status == MANAGER_STATUS.SCHEDULED) {
					ErrorAnalysisAlgorithm alg = evt.algorithm;
					
					alg.addListener(new ErrorAnalysisAlgorithmListener() {
						
						public void eventReceived(ErrorAnalysisAlgorithmEvent evt) {
							if(evt.status == ALGORITHM_STATUS.FINISHED_ALGORITHM) {
								// The algorithm has finished. Smallest value in 
								//evt.result
							} else if(evt.status == ALGORITHM_STATUS.FINISHED_SIMULATION) {
								// One simulation is done. The result is in evt.result
							} else if(evt.status == ALGORITHM_STATUS.RESTARTED_ALGORITHM) {
								// The algorithm has restarted. Smallest value in 
								// evt.result
							}
						}
					});
				}
			}
		});
	}
}

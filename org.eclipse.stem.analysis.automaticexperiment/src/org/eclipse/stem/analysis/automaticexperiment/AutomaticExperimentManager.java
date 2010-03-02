package org.eclipse.stem.analysis.automaticexperiment;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import automaticexperiment.AutomaticExperiment;

public class AutomaticExperimentManager {
	private static AutomaticExperimentManager instance = null;
	protected static boolean QUIT_NOW = false;
	protected static boolean PAUSE_NOW = false;
	protected static CountDownLatch stopLatch = null;
	
	public static void quitNow() {
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
		System.out.println("Stefan: Please pause now");
	}
	public static void continueRun() {
		PAUSE_NOW = false;
		System.out.println("Stefan: Please continue now");
	}
	
	public static void restartNow(double[] restartParamValues) {
		System.out.println("Stefan: Restart with the valued provided");
	}

	private ArrayList<AutomaticExperimentManagerListener> listeners = new ArrayList<AutomaticExperimentManagerListener>();
	
	private AutomaticExperimentManager() {
	}
	public static AutomaticExperimentManager getInstance() {
		if(instance == null)instance = new AutomaticExperimentManager();
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
		algorithm.init(automaticExperiment, algorithm);
		// Stefan fix, we can't hold up the UI thread, it causes memory leaks
		Job j = new Job("Minimizer algorith") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				algorithm.execute();
				return Status.OK_STATUS;
			}
		};
		j.schedule();
		
		AutomaticExperimentManagerEvent newEvent = new AutomaticExperimentManagerEvent(automaticExperiment, algorithm, MANAGER_STATUS.SCHEDULED);
		fireEvent(newEvent);
	}
	
	private void fireEvent(AutomaticExperimentManagerEvent evt) {
		for(AutomaticExperimentManagerListener l:listeners) l.eventReceived(evt);
	}
	
	public void addListener(AutomaticExperimentManagerListener l) {
		this.listeners.add(l);
	}
	
	public static void main() {
		QUIT_NOW = false; // in case RESTARTING
		PAUSE_NOW = false;
		AutomaticExperimentManager manager = AutomaticExperimentManager.getInstance();
		manager.addListener(new AutomaticExperimentManagerListener() {
			
			@Override
			public void eventReceived(AutomaticExperimentManagerEvent evt) {
				if(evt.status == MANAGER_STATUS.SCHEDULED) {
					ErrorAnalysisAlgorithm alg = evt.algorithm;
					
					alg.addListener(new ErrorAnalysisAlgorithmListener() {
						
						@Override
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

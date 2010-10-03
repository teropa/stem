package org.eclipse.stem.jobs.simulation.remote;

import org.eclipse.stem.jobs.execution.IExecutable;



public class RemoteSimulationManager {

	/**
	 * Singleton instance of the manager
	 */
	private static volatile RemoteSimulationManager INSTANCE = null;
	
	/**
	 * @return the singleton instance of the manager
	 */
	public static final RemoteSimulationManager getManager() {
		if (INSTANCE == null) {
			synchronized (RemoteSimulationManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new RemoteSimulationManager();
				}
			}
		}
		return INSTANCE;
	} // getManager

	public void run(IExecutable executable) {
		System.out.println("Would now run remotely: "+executable);
	}


}

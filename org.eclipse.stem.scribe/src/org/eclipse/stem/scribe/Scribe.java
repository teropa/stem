package org.eclipse.stem.scribe;

import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListener;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;

public class Scribe implements ISimulationManagerListener {

	private final ConcurrentHashMap<ISimulation, SimulationScribe> scribes = new ConcurrentHashMap<ISimulation, SimulationScribe>();
	
	public void start() {
		System.out.println("scribe starting");
		SimulationManager.getManager().addSimulationManagerListener(this);
	}

	public void stop() {
		System.out.println("scribe stopping");
		SimulationManager.getManager().removeListener(this);
	}
	
	@Override
	public void simulationsChanged(SimulationManagerEvent event) {
		for (ISimulation added : event.getSimulationsAdded()) {
			System.out.println("sim added: "+added);
			SimulationScribe simScribe = new SimulationScribe(added);
			if (scribes.putIfAbsent(added, simScribe) == null) {
				simScribe.start();
			}
		}
		for (ISimulation removed : event.getSimulationsRemoved()) {
			System.out.println("sim removed: "+removed);			
			SimulationScribe simScribe = scribes.remove(removed);
			if (simScribe != null) {
				simScribe.stop();
			}
		}
	}

}

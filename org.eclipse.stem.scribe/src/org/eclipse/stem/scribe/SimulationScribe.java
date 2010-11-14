package org.eclipse.stem.scribe;

import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.SimulationEvent;

public class SimulationScribe implements ISimulationListener {

	private final ISimulation simulation;
	
	public SimulationScribe(ISimulation simulation) {
		this.simulation = simulation;
	}

	public void start() {
		System.out.println("Starting sim scribe");
		simulation.addSimulationListener(this);
	}

	public void stop() {
		System.out.println("Stopping sim scribe");
		simulation.removeSimulationListener(this);
	}
	
	@Override
	public void simulationChanged(SimulationEvent event) {
		System.out.println("sim changed: "+event);
	}

}

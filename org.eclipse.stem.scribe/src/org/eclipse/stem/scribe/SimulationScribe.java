package org.eclipse.stem.scribe;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.simulation.SimulationData;
import org.eclipse.stem.core.simulation.SimulationFactory;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationState;

public class SimulationScribe implements ISimulationListener {

	private final ISimulation simulation;
	private final CDOSession cdoSession;
	
	private CDOTransaction cdoTx;
	private CDOResource cdoResource;
	private SimulationData simData;
	
	public SimulationScribe(ISimulation simulation, CDOSession cdoSession) {
		this.simulation = simulation;
		this.cdoSession = cdoSession;
	}

	public void start() {
		System.out.println("Starting sim scribe");
		cdoTx = cdoSession.openTransaction();
		cdoResource = cdoTx.getOrCreateResource("/stem");
		simData = SimulationFactory.eINSTANCE.createSimulationData();
		simData.setCurrentTime(simulation.getScenario().getSequencer().getCurrentTime());
		cdoResource.getContents().add(simData);
		cdoResource.getContents().add(simData.getCurrentTime());
		simulation.addSimulationListener(this);
	}

	public void stop() {
		System.out.println("Stopping sim scribe");
		simulation.removeSimulationListener(this);
		cdoTx.close();
	}
	
	@Override
	public void simulationChanged(SimulationEvent event) {
		if (SimulationState.COMPLETED_CYCLE.equals(event.getSimulationState())) {
			STEMTime currentTime = simulation.getScenario().getSequencer().getCurrentTime();
			System.out.println("Completed cycle at "+currentTime);
			simData.setCurrentTime(currentTime);
			cdoResource.getContents().add(currentTime);
			try {
				cdoTx.commit();
			} catch (CommitException ce) {
				ce.printStackTrace();
			}
		}
	}

}

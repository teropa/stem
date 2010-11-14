package org.eclipse.stem.scribe;

import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListener;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;

public class Scribe implements ISimulationManagerListener {

	private final ConcurrentHashMap<ISimulation, SimulationScribe> scribes = new ConcurrentHashMap<ISimulation, SimulationScribe>();
	
	private CDOSession cdoSession;
	
	public void start() {
		System.out.println("scribe starting");
		openCDOSession();
		SimulationManager.getManager().addSimulationManagerListener(this);
	}

	public void stop() {
		System.out.println("scribe stopping");
		SimulationManager.getManager().removeListener(this);
		closeCDOSession();
	}

	private void openCDOSession() {
		CDOSessionConfiguration config = CDONet4jUtil.createSessionConfiguration();
		config.setConnector(createCDOConnector());
		config.setRepositoryName("repo1");
		cdoSession = config.openSession();
	}

	private IConnector createCDOConnector() {
		IManagedContainer container = IPluginContainer.INSTANCE;
		JVMUtil.prepareContainer(container);
		Net4jUtil.prepareContainer(container);
		LifecycleUtil.activate(container);
		return JVMUtil.getConnector(container, "default");
	}

	private void closeCDOSession() {
		cdoSession.close();
	}

	@Override
	public void simulationsChanged(SimulationManagerEvent event) {
		for (ISimulation added : event.getSimulationsAdded()) {
			System.out.println("sim added: "+added);
			SimulationScribe simScribe = new SimulationScribe(added, cdoSession);
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

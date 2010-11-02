package org.eclipse.stem.jobs.simulation.remote;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.tcp.ITCPConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.core.scenario.Scenario;



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

	private final CDOSession session = createSession("localhost:2036", "repo1");

	private CDOSession createSession(String url, String repo) {
		CDOSessionConfiguration config = CDONet4jUtil.createSessionConfiguration();
		config.setConnector(createConnector(url));
		config.setRepositoryName(repo);
		CDOSession session = config.openSession();
		session.options().setGeneratedPackageEmulationEnabled(true);
		return session;
	}

	private ITCPConnector createConnector(String url) {
		IManagedContainer container = ContainerUtil.createContainer();
		TCPUtil.prepareContainer(container);
		Net4jUtil.prepareContainer(container);
		LifecycleUtil.activate(container);
		ITCPConnector connector = TCPUtil.getConnector(container, url);
		return connector;
	}

	public void createAndRunSimulation(final Scenario target) {
		System.out.println("Starting remote simulation");
		new Job("Starting remote simulation") {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				try {
					RemoteSimulation sim = new RemoteSimulation(target, target.produceTitle(), 1, session);
					monitor.subTask("Running remote simulation");
					sim.run();
				} catch (final Exception e) {
					// The error was logged in createSimulation
					monitor.done();
				} // catch Exception
				return Status.OK_STATUS;
			} // run
		}.schedule();
	}

	public void createAndStepSimulation(Scenario target) {
		throw new UnsupportedOperationException("Cannot step remotely yet");
	}
}

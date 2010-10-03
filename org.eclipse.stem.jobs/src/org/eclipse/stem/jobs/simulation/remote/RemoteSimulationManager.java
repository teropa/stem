package org.eclipse.stem.jobs.simulation.remote;


import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.tcp.ITCPConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
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
		System.out.println("Running remotely: "+executable);
		CDOSession session = createSession("localhost:2036", "repo1");
		try {
			System.out.println("last upd: "+session.getLastUpdateTime());
		} finally {
			session.close();
		}
	}

	private CDOSession createSession(String url, String repo) {
		CDOSessionConfiguration config = CDONet4jUtil.createSessionConfiguration();
		config.setConnector(createConnector(url));
		config.setRepositoryName(repo);
		return config.openSession();
	}

	private ITCPConnector createConnector(String url) {
		IManagedContainer container = ContainerUtil.createContainer();
		TCPUtil.prepareContainer(container);
		Net4jUtil.prepareContainer(container);
		LifecycleUtil.activate(container);
		ITCPConnector connector = TCPUtil.getConnector(container, url);
		return connector;
	}
}

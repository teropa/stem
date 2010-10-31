package org.eclipse.stem.server;

import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.jvm.IJVMConnector;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

public class SimulationRunner {

	private CDOSession session;
	private CDOView view;
	
	public void start() {
		System.out.println("simulation runner starting");
		session = createSession("repo1");
		view = session.openView();
		view.addListener(new IListener() {
			public void notifyEvent(IEvent event) {
				System.out.println("Notified: "+event);
			}
		});
	}
	
	public void stop() {
		view.close();
		session.close();
	}
	
	private CDOSession createSession(String repo) {
		CDOSessionConfiguration config = CDONet4jUtil.createSessionConfiguration();
		config.setConnector(createConnector());
		config.setRepositoryName(repo);
		return config.openSession();
	}

	private IJVMConnector createConnector() {
		IManagedContainer container = IPluginContainer.INSTANCE;
		JVMUtil.prepareContainer(container);
		Net4jUtil.prepareContainer(container);
		LifecycleUtil.activate(container);
		IJVMConnector connector = JVMUtil.getConnector(container, "default");
		return connector;	
	}

}

package org.eclipse.stem.server;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.jvm.IJVMConnector;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.server.server.ServerFactory;
import org.eclipse.stem.server.server.Simulations;

public class SimulationRunner {

	private CDOSession session;
	private CDOView view;
	private CDOResource resource;
	private Simulations simulations;
	
	public void start() throws Exception {
		System.out.println("simulation runner starting");
		session = createSession("repo1");
		session.options().setGeneratedPackageEmulationEnabled(true);
		ensureSimulations();
		
		view = session.openView();
		resource = view.getResource("/stem/simulations");
		simulations = findSimulations(resource);
		simulations.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				System.out.println("Simulations changed "+msg);
			}
		});
	}
	
	private void ensureSimulations() throws CommitException {
		CDOTransaction tx = session.openTransaction();
		CDOResource res = tx.getOrCreateResource("/stem/simulations");
		if (findSimulations(res) == null) {
			Simulations sims = ServerFactory.eINSTANCE.createSimulations();
			res.getContents().add(sims);
			tx.commit();
		}
		tx.close();
	}

	private Simulations findSimulations(CDOResource res) {
		if (!res.getContents().isEmpty()) {
			return (Simulations)res.getContents().get(0);
		}
		return null;
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

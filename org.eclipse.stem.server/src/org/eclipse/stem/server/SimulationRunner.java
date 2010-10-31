package org.eclipse.stem.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.cdo.CDOInvalidationNotification;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.jvm.IJVMConnector;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.server.server.ServerFactory;
import org.eclipse.stem.server.server.Simulations;

public class SimulationRunner {

	private final ExecutorService runPool = Executors.newCachedThreadPool(new ExceptionLoggingThreadFactory());
	
	private CDOSession session;
	private CDOTransaction view;
	private CDOResource resource;
	private Simulations simulations;
	
	public void start() throws Exception {
		System.out.println("simulation runner starting");
		session = createSession("repo1");
		session.options().setGeneratedPackageEmulationEnabled(true);
		ensureSimulations();
		
		view = session.openTransaction();
		view.options().setInvalidationNotificationEnabled(true);
		resource = view.getResource("/stem/simulations");
		simulations = findSimulations(resource);
		simulations.eAdapters().add(new AdapterImpl() {
			@Override public void notifyChanged(Notification msg) {
				if (msg instanceof CDOInvalidationNotification) {
//					simulations.cdoReadLock().lock();
					try {
						for (Scenario scenario : simulations.getScenarios()) {
//							final CDOID id = scenario.cdoID();
//							runPool.submit(new Runnable() {
//								public void run() {
//									CDOTransaction runnerTx = session.openTransaction();
//									Scenario scenario = (Scenario)runnerTx.getObject(id);
									final Sequencer sequencer = scenario.getSequencer();
									
									System.out.println("running simulation");
									System.out.println("seq start "+sequencer.getStartTime());
									System.out.println("seq end "+sequencer.getEndTime());
									
									while (!sequencer.isTimeToStop()) {
										assert scenario.sane();
										
										final STEMTime currentTime = sequencer.getCurrentTime();
										System.out.println("running at "+currentTime);
										
										if(scenario.getSolver().getDecorators() == null) scenario.getSolver().setDecorators(scenario.getCanonicalGraph().getDecorators());
										if(!scenario.getSolver().isInitialized()) {
											scenario.getSolver().initialize(sequencer.getNextTime());
										}
										
										scenario.step();
										
										try {
											view.commit();
										} catch (CommitException ce) {
											throw new IllegalStateException("Failed to commit scenario step", ce);
										}
									}
									System.out.println("ran simulation");
//								}
//							});
						}
					} finally {
//						simulations.cdoReadLock().unlock();
					}
				}
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

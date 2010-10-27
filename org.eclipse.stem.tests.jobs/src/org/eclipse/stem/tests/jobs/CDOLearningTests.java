package org.eclipse.stem.tests.jobs;

import java.util.Date;

import junit.framework.TestCase;

import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.tcp.ITCPConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;

public class CDOLearningTests extends TestCase {
	
	CDOSession session;
	
	public void setUp() {
		session = createSession("localhost:2036", "repo1");
		session.options().setGeneratedPackageEmulationEnabled(true);
	}
	
	public void testSingleScenarioSaveLoadDelete() {
		try {
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);			
					Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
					r.getContents().add(scen);					
				}
			});
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);
					assertEquals(1, r.getContents().size());
					r.getContents().clear();
				}
			});
		} catch (CommitException ce) {
			ce.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void testWithDublinCoreSaveLoadInView() {
		try {
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);			
					Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
					DublinCore dc = CommonFactory.eINSTANCE.createDublinCore();
					dc.setCreated(new Date());
					dc.setDescription("just testing");
					scen.setDublinCore(dc);
					r.getContents().add(scen);					
				}
			});
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);
					Scenario scen = (Scenario)r.getContents().get(0);
					assertNotNull(scen.getDublinCore());
					assertNotNull(scen.getDublinCore().getCreated());
					assertNotNull(scen.getDublinCore().getDescription());
					r.getContents().clear();
				}
			});
		} catch (CommitException ce) {
			ce.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void testExistingScenarioModification() {
		try {
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);			
					Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
					scen.setProgress(0);
					r.getContents().add(scen);					
				}
			});
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);
					Scenario s = (Scenario)r.getContents().get(0);
					assertEquals(0.0, s.getProgress(), 1e-6);
					s.setProgress(1);
				}
			});
			inTransaction(new Action() {
				public void run(CDOTransaction tx) {
					Resource r = getResource(tx);
					Scenario s = (Scenario)r.getContents().get(0);
					assertEquals(1.0, s.getProgress(), 1e-6);
					r.getContents().clear();
				}
			});
			
		} catch (CommitException ce) {
			ce.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static interface Action {
		public void run(CDOTransaction tx);
	}
	
	private void inTransaction(Action a) throws CommitException {
		CDOTransaction tx = session.openTransaction();
		a.run(tx);
		tx.commit();
		tx.close();
	}

	private Resource getResource(CDOTransaction tx) {
		if (tx.hasResource("/stem/simulation")) {
			Resource r = tx.getResource("/stem/simulation");
			System.out.println("resource did exist, had "+r.getContents().size()+ " items");
			return r;
		} else {
			System.out.println("resource did not exist");
			return tx.createResource("/stem/simulation");
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

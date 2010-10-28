package org.eclipse.stem.tests.jobs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.tcp.ITCPConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CDOLearningTests  {
	
	CDOSession session;
	
	@Before
	public void setUp() throws Exception {
		session = openSession();
		clear();
	}

	private CDOSession openSession() {
		CDOSession session = createSession("localhost:2036", "repo1");
		session.options().setGeneratedPackageEmulationEnabled(true);
		return session;
	}
	
	@After
	public void tearDown() {
		session.close();
	}
	
	@Test
	public void singleScenarioSaveLoadDelete() throws Exception {
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
			}
		});
	}

	@Test
	public void transactionIsolation() throws Exception {
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);			
				Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
				r.getContents().add(scen);	
				inTransaction(new Action() {
					public void run(CDOTransaction tx2) {
						Resource r2 = getResource(tx2);
						assertTrue(r2.getContents().isEmpty());
					}
				});
			}
		});
	}

	@Test
	public void multipleCommitsInTx() throws Exception {	
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);			
				Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
				r.getContents().add(scen);	
			}
		});
		
		final CDOView listeningView = session.openView();
		final Scenario listeningScenario = (Scenario)listeningView.getResource("/stem/simulation").getContents().get(0);
		
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Scenario scen = (Scenario)getResource(tx).getContents().get(0);
				
				scen.setProgress(1.0);
				tx.commit();
				
				Thread.sleep(500);
				assertEquals(1.0, listeningScenario.getProgress(), 1e-6);
				
				scen.setProgress(2.0);
				tx.commit();
				
				Thread.sleep(500);
				assertEquals(2.0, listeningScenario.getProgress(), 1e-6);
				
				scen.setProgress(3.0);
				tx.commit();
				
				Thread.sleep(500);
				assertEquals(3.0, listeningScenario.getProgress(), 1e-6);
			}
		});
	}

	@Test
	public void withDublinCoreSaveLoadInView() throws Exception {
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
			}
		});
	}

	@Test
	public void existingScenarioModification() throws Exception {
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
			}
		});
	}
	
	@Test
	public void savingWithSTEMBuiltinModel() throws Exception {
		final Model model = (Model)Utility.getIdentifiable(URI.createURI("platform:/plugin/org.eclipse.stem.data.geography.models/resources/data/country/AIA/AIA_0.model"));
		assertNotNull(model);
		inTransaction(new Action() {
			public void run(CDOTransaction tx) {
				Resource r = getResource(tx);			
				Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
				scen.setModel(model);
				r.getContents().add(scen);					
			}
		});			
		inTransaction(new Action() {
			public void run(CDOTransaction tx) {
				Resource r = getResource(tx);			
				Scenario scen = (Scenario)r.getContents().get(0);
				assertNotNull(scen.getModel());
			}
		});			
	}
	
	@Test
	public void savingCopyOfSTEMBuiltinModel() throws Exception {
		final Model model = (Model)Utility.getIdentifiable(URI.createURI("platform:/plugin/org.eclipse.stem.data.geography.models/resources/data/country/AIA/AIA_0.model"));
		assertNotNull(model);
		assertNotNull(model.getDublinCore());
		inTransaction(new Action() {
			public void run(CDOTransaction tx) {
				Resource r = getResource(tx);			
				r.getContents().add(EcoreUtil.copy(model));					
			}
		});			
		inTransaction(new Action() {
			public void run(CDOTransaction tx) {
				Resource r = getResource(tx);			
				Model m = (Model)r.getContents().get(0);
				assertNotNull(m);
				assertEquals(model.getURI(), m.getURI());
				assertNotNull(model.getDublinCore());
			}
		});	
	}
	
	@Test
	public void revisioning() throws Exception {
		final List<Long> commitTimes = new ArrayList<Long>();
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);			
				Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
				scen.setProgress(0);
				r.getContents().add(scen);
				commitTimes.add(tx.commit().getTimeStamp());
			}
		});
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);
				Scenario s = (Scenario)r.getContents().get(0);
				s.setProgress(1);
				commitTimes.add(tx.commit().getTimeStamp());
			}
		});
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);
				Scenario s = (Scenario)r.getContents().get(0);
				s.setProgress(2);
				commitTimes.add(tx.commit().getTimeStamp());
			}
		});

		CDOView view = session.openView(commitTimes.get(0));
		CDOResource res = view.getResource("/stem/simulation");
		Scenario s = (Scenario)res.getContents().get(0);
		assertEquals(0.0, s.getProgress(), 1e-6);
		view.close();

		view = session.openView(commitTimes.get(1));
		res = view.getResource("/stem/simulation");
		s = (Scenario)res.getContents().get(0);
		assertEquals(1.0, s.getProgress(), 1e-6);
		view.close();

		view = session.openView(commitTimes.get(2));
		res = view.getResource("/stem/simulation");
		s = (Scenario)res.getContents().get(0);
		assertEquals(2.0, s.getProgress(), 1e-6);
		view.close();
	}
	
	
	@Test
	public void accessingRevisionsWithoutKnowingTimestamps() throws Exception {
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);			
				Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
				scen.setProgress(0);
				r.getContents().add(scen);
				tx.commit();
			}
		});
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);
				Scenario s = (Scenario)r.getContents().get(0);
				s.setProgress(1);
				tx.commit();
			}
		});
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);
				Scenario s = (Scenario)r.getContents().get(0);
				s.setProgress(2);
				tx.commit();
			}
		});

		CDOView view = session.openTransaction();
		final List<Long> commitTimes = new ArrayList<Long>();
		session.getCommitInfoManager().getCommitInfos(view.getBranch(), new CDOCommitInfoHandler() {
			public void handleCommitInfo(CDOCommitInfo commitInfo) {
				commitTimes.add(commitInfo.getTimeStamp());
			}
		});
		view.close();
		assertTrue(commitTimes.size() > 3);

		view = session.openView(commitTimes.get(commitTimes.size() - 3));
		CDOResource res = view.getResource("/stem/simulation");
		Scenario s = (Scenario)res.getContents().get(0);
		assertEquals(0.0, s.getProgress(), 1e-6);
		view.close();

		view = session.openView(commitTimes.get(commitTimes.size() - 2));
		res = view.getResource("/stem/simulation");
		s = (Scenario)res.getContents().get(0);
		assertEquals(1.0, s.getProgress(), 1e-6);
		view.close();

		view = session.openView(commitTimes.get(commitTimes.size() - 1));
		res = view.getResource("/stem/simulation");
		s = (Scenario)res.getContents().get(0);
		assertEquals(2.0, s.getProgress(), 1e-6);
		view.close();
	}	

	@Test
	public void passiveUpdates() throws Exception {
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Resource r = getResource(tx);			
				Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
				r.getContents().add(scen);
				tx.commit();
			}
		});
		
		CDOSession secondSession = openSession();
		try {
			CDOView listeningView = secondSession.openView();
			CDOTransaction changingTx = session.openTransaction();
			
			CDOResource listeningResource = listeningView.getResource("/stem/simulation");
			Scenario listeningScenario = (Scenario)listeningResource.getContents().get(0);
			
			CDOResource changingResource = changingTx.getResource("/stem/simulation");
			Scenario changingScenario = (Scenario)changingResource.getContents().get(0);
			
			assertNotSame(listeningScenario, changingScenario);
			
			changingScenario.setProgress(100.0);
			
			assertEquals(0.0, listeningScenario.getProgress(), 1e-6);
			
			changingTx.commit();
			changingTx.close();
			
			Thread.sleep(500);
			
			assertEquals(100.0, listeningScenario.getProgress(), 1e-6);
		} finally {
			secondSession.close();
		}
	}

	@Test
	public void beingNotified() throws Exception {
		CDOSession secondSession = openSession();
		try {
			final AtomicBoolean isNotified = new AtomicBoolean(false);
			CDOView listeningView = secondSession.openView();
			listeningView.addListener(new IListener() {
				public void notifyEvent(IEvent event) {
					System.out.println("Notified: "+event);
					isNotified.set(true);					
				}
			});
			inTransaction(new Action() {
				public void run(CDOTransaction tx) throws Exception {
					Resource r = getResource(tx);			
					Scenario scen = ScenarioFactory.eINSTANCE.createScenario();
					r.getContents().add(scen);
					tx.commit();
				}
			});
			Thread.sleep(500);
			assertTrue(isNotified.get());
		} finally {
			secondSession.close();
		}
	}

	private static interface Action {
		public void run(CDOTransaction tx) throws Exception;
	}
	
	private void inTransaction(Action a) throws Exception {
		CDOTransaction tx = session.openTransaction();
		a.run(tx);
		tx.commit();
		tx.close();
	}
	
	private void clear() throws Exception {
		inTransaction(new Action() {
			public void run(CDOTransaction tx) {
				Resource r = getResource(tx);			
				r.getContents().clear();					
			}
		});		
	}

	private CDOResource getResource(CDOTransaction tx) {
		if (tx.hasResource("/stem/simulation")) {
			CDOResource r = tx.getResource("/stem/simulation");
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

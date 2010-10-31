package org.eclipse.stem.tests.jobs;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.cdo.CDOInvalidationNotification;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.tcp.ITCPConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.SequentialSequencer;
import org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.ISimulationListenerSync;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.server.server.Simulations;
import org.eclipse.stem.solvers.fd.FiniteDifference;
import org.eclipse.stem.solvers.fd.impl.FdFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CDOSimulationLearningTests  {
	
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
	public void testSimulationRun() throws Exception {
		inTransaction(new Action() {
			public void run(CDOTransaction tx) throws Exception {
				Scenario scenario = ScenarioFactory.eINSTANCE.createScenario();

				Model rootModel = ModelFactory.eINSTANCE.createModel();
				scenario.setModel(rootModel);
				
				StandardPopulationModel popModel = StandardFactory.eINSTANCE.createStandardPopulationModel();
				popModel.setURI(STEMURI.createURI("standardPopulationModel" + "/" + STEMURI.generateUniquePart()));
				rootModel.getNodeDecorators().add(popModel);
			
				DeterministicSEIRDiseaseModel disease = org.eclipse.stem.diseasemodels.standard.StandardFactory.eINSTANCE.createDeterministicSEIRDiseaseModel();
				disease.setURI(STEMURI.createURI("deterministicSEIRDiseaseModel" + "/" + STEMURI.generateUniquePart()));
				disease.setDiseaseName("ExampleDisease");
				disease.setTransmissionRate(0.4);
				disease.setImmunityLossRate(0.0010);
				disease.setIncubationRate(0.5);
				rootModel.getNodeDecorators().add(disease);
				
				Model europe = ModelFactory.eINSTANCE.createModel();
				Model finland = (Model)Utility.getIdentifiable(URI.createURI("platform:/plugin/org.eclipse.stem.data.geography.population.human.models/resources/data/country/FIN/FIN_0_1_population.model"));
				europe.getModels().add(finland);
				rootModel.getModels().add(europe);
				
				FiniteDifference fd = FdFactoryImpl.eINSTANCE.createFiniteDifference();
				scenario.setSolver(fd);
				
				SIInfector infector = org.eclipse.stem.diseasemodels.standard.StandardFactory.eINSTANCE.createSIInfector();
				infector.setURI(STEMURI.createURI("sIInfector" + "/" + STEMURI.generateUniquePart()));
				infector.setDiseaseName("ExampleDisease");
				infector.setTargetISOKey("FI-UU");
				infector.setPopulationIdentifier("human");
				infector.setInfectiousCount(117.0);
				scenario.getScenarioDecorators().add(infector);
				
				SequentialSequencer seq = SequencerFactory.eINSTANCE.createSequentialSequencer();
				seq.setURI(STEMURI.createURI("sequentialSequencer" + "/" + STEMURI.generateUniquePart()));
				seq.setCycle(2);
				seq.setDuration(95990399000L);
				seq.setStartTime(getSTEMTime("20091115220000"));
				seq.setCurrentTime(getSTEMTime("20091115220000"));
				seq.setEndTime(getSTEMTime("20121130215959"));
				seq.setTimeIncrement(86400000);
				seq.setTimeDelta(86400000);
				seq.setWorkComplete(0.0);
				scenario.setSequencer(seq);
				
				scenario.initialize();
				
				Resource r = tx.getResource("/stem/simulations");
				Simulations sims = (Simulations)r.getContents().get(0);
//				sims.cdoWriteLock().lock();
				sims.getScenarios().add(scenario);
				
				Resource content = tx.getOrCreateResource("/stem/simulation1");
				content.getContents().add(scenario);
				content.getContents().addAll(getNonContainedNonPlatformObjects(scenario, new HashSet<EObject>()));
			}

			private List<EObject> getNonContainedNonPlatformObjects(EObject object, Set<EObject> visited) {
				final List<EObject> result = new ArrayList<EObject>();
				if (visited.contains(object)) {
					return result;
				} else {
					visited.add(object);
				}
				for (EObject e : object.eCrossReferences()) {
					Resource resource = e.eResource();
					if (resource == null || !isPlatformResource(resource)) {
						if (e.eContainer() == null) {
							System.out.println(e.getClass().getName() + " " + e.toString());
							result.add(e);
						}
						result.addAll(getNonContainedNonPlatformObjects(e, visited));
					}
				}
				return result;
			}

			private boolean isPlatformResource(Resource resource) {
				return resource.getURI() != null && (resource.getURI().isPlatform() || resource.getURI().isPlatformPlugin());
			}

		});
		
		CDOView listeningView = session.openView();
		listeningView.options().setInvalidationNotificationEnabled(true);
		CDOResource listeningRes = listeningView.getResource("/stem/simulations");
		final Scenario listeningScenario = ((Simulations)listeningRes.getContents().get(0)).getScenarios().get(0);
		listeningScenario.getSequencer().eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg instanceof CDOInvalidationNotification) {
					System.out.println("sequencer invalidated");
					System.out.println("currentTime: "+listeningScenario.getSequencer().getCurrentTime());
					Iterator<EObject> graphContents = listeningScenario.getCanonicalGraph().eAllContents();
					while (graphContents.hasNext()) {
						EObject cnt = graphContents.next();
						System.out.println("\t" + cnt);
					}
				}
			}
		});
		Thread.sleep(5 * 60 * 1000);
	}

	private STEMTime getSTEMTime(String string) throws Exception {
		STEMTime theTime = ModelFactory.eINSTANCE.createSTEMTime();
		theTime.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(string));
		return theTime;
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
				Resource r = tx.getResource("/stem/simulations");
				Simulations sims = (Simulations)r.getContents().get(0);
				sims.getScenarios().clear();
				
				Resource content = tx.getOrCreateResource("/stem/simulation1");
				content.getContents().clear();
			}
		});		
	}

//	private CDOResource getResource(CDOTransaction tx) {
//		if (tx.hasResource("/stem/simulation")) {
//			CDOResource r = tx.getResource("/stem/simulation");
//			System.out.println("resource did exist, had "+r.getContents().size()+ " items");
//			return r;
//		} else {
//			System.out.println("resource did not exist");
//			return tx.createResource("/stem/simulation");
//		}
//	}
	
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

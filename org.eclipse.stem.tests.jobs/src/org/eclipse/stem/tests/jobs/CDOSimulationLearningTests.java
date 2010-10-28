package org.eclipse.stem.tests.jobs;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DublinCore;
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
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.solvers.fd.FiniteDifference;
import org.eclipse.stem.solvers.fd.impl.FdFactoryImpl;
import org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl;
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
				
				CDOResource res = getResource(tx);
				res.getContents().add(scenario);
				res.getContents().addAll(getNonContainedNonPlatformObjects(scenario, new HashSet<EObject>()));
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
						System.out.println(e.getClass().getName());
						if (e.eContainer() == null) {
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
		
		CDOSession runnerSession = openSession();
		CDOTransaction runnerTx = runnerSession.openTransaction();
		CDOResource res = runnerTx.getResource("/stem/simulation");
		
		Scenario scenario = (Scenario)res.getContents().get(0);
		final Sequencer sequencer = scenario.getSequencer();
		
		System.out.println("seq start "+sequencer.getStartTime());
		System.out.println("seq end "+sequencer.getEndTime());
		
		while (!sequencer.isTimeToStop()) {
			assertTrue(scenario.sane());
			
			final STEMTime currentTime = sequencer.getCurrentTime();
			System.out.println("running at "+currentTime);
			
			if(scenario.getSolver().getDecorators() == null) scenario.getSolver().setDecorators(scenario.getCanonicalGraph().getDecorators());
			if(!scenario.getSolver().isInitialized()) {
				scenario.getSolver().initialize(sequencer.getNextTime());
			}
			
			boolean success = scenario.step();
			if(!success) {
				throw new IllegalStateException("Scenario failed to step");
			}
			
			runnerTx.commit();
		}
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

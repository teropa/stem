package org.eclipse.stem.core.scenario.tests;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import junit.textui.TestRunner;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.stem.analysis.ScenarioInitializationException;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.util.CSVscenarioLoader;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.STEMXMIResourceFactoryImpl;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.impl.IdentifiableFilterImpl;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.tests.ModelTest;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.core.sequencer.impl.SequencerImpl;
import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.core.tests.Activator;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.solvers.fd.FdFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;
import org.eclipse.stem.util.loggers.views.CSVLoggerFactory;
import org.eclipse.stem.util.loggers.views.CustomCSVLogger;
import org.eclipse.stem.util.loggers.views.LoggerControlFactory;
import org.eclipse.stem.util.loggers.views.NewCSVLogWriter;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.scenario.Scenario#step() <em>Step</em>}</li>
 *   <li>{@link org.eclipse.stem.core.scenario.Scenario#reset() <em>Reset</em>}</li>
 *   <li>{@link org.eclipse.stem.core.scenario.Scenario#initialize() <em>Initialize</em>}</li>
 *   <li>{@link org.eclipse.stem.core.scenario.Scenario#produceTitle() <em>Produce Title</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class ScenarioTest extends IdentifiableTest {

	/**
	 * This is the title of the test scenario.
	 */
	public static final String TEST_SCENARIO_TITLE = "Test Scenario #1";

	@SuppressWarnings("unused")
	private static final URI SCENARIO_SERIALZATION_TEST_URI = URI
			.createURI("temp/testscenario1.scenario");

	private static final URI CANONICAL_GRAPH_SERIALZATION_TEST_URI = URI
			.createURI("temp/testcanonicalgraph1.graph");

	// private static final String SCENARIO = "scenario";

	/**
	 * This is the URI that will be the Identifier of the scenario
	 */
	private static final URI SCENARIO_URI = URI.createURI("platform:/plugin/"
			+ org.eclipse.stem.core.tests.Activator.PLUGIN_ID
			+ "/data/scenarios/basic/testscenario1.scenario");
	
	/**
	 * URI for the Sequencer in the Scenario
	 */
	private static final URI SEQUENCER_URI = URI.createURI("SEQUENCER/sequencer1.sequencer");

	/**
	 * URI for the Decorator in the test scenario
	 */
	private static final URI DECORATOR_URI = URI.createURI("decorator/decorator1.decorator");
		
	
	private static final URI CANONICAL_GRAPH__URI = STEMURI
			.createURI("GRAPH/testcanonicalgraph");
	

	/**
	 * for testing scenarios from files
	 */
	protected final static String sep = File.separator;
	protected final static String SCENARIO_FOLDER = sep+"scenarios";//$NON-NLS-1$
	protected final static String REFERENCE_SUFFIX="_Reference";
	static List<String> scenarioNameList = null;
	private List<File> allProjects = null;

	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ScenarioTest.class);
	}

	/**
	 * Constructs a new Scenario test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ScenarioTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Scenario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Scenario getFixture() {
		return (Scenario)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		
		// set up for the unit tests
		setFixture(createFixture());
	} // setUp

	/**
	 * runs all the integration tests
	 */
	public void testAllScenarioIntegrationTests() {
		// set up the workspace for all the integration tests
		allProjects = this.setUpWorkspace();
		scenarioNameList = this.readScenarios(allProjects);
		String integrationTestLogDir;
		String scenarioName;
		List<String> dataObjectNameList = new ArrayList<String>(); // e.g. list of things being logged the Disease Name or population model name
		List<String>  logDirList = new ArrayList<String>(); // List of the log directories (generated with time stamp)
		for (int i = 0; i < scenarioNameList.size(); i ++) {
			String scenarioToTest = scenarioNameList.get(i);
			Activator.logInformation("now loading "+scenarioToTest);
			
			scenarioName = getScenarioName(scenarioToTest);
			integrationTestLogDir = getLogDir(scenarioToTest);
			
			Scenario scenario = loadScenario(scenarioToTest);
			fixture = scenario;
			scenario.initialize(); // This step can be slow
			assertTrue(scenario.sane());
			
			// Next we have to create a simulation and logger(s) for the scenario
			// and compute the output to prestored outputs
			ISimulation sim = new Simulation(scenario,0);
			LoggerControlFactory lcf = CSVLoggerFactory.INSTANCE;
			EList<Decorator> decorators = sim.getScenario().getCanonicalGraph().getDecorators();
			for(Decorator dec:decorators) {
				if(dec instanceof IntegrationDecorator && !(dec instanceof AggregatingSIDiseaseModel)) {
					
					// TODO  For now we only log and test the DiseaseModel Data
					// TODO the CSVscenario loader does not yet parse the PopulationModel Log Files
					if(dec instanceof DiseaseModel) {
						IntegrationDecorator dm = (IntegrationDecorator)dec;
						//String diseaseName = dm.getDiseaseName();
						CustomCSVLogger logWriter = new CustomCSVLogger(integrationTestLogDir,sim,dm);
						dataObjectNameList.add(logWriter.getLogDataObjectName());
						logDirList.add(logWriter.getDirectoryName());
					}
					
				} // DiseaseModel
			} // For each decorator
			
			// run the simulation and log the data
			Activator.logInformation("Starting simulation....");			
			sim.run();
			try {
				Activator.logInformation("Waiting for simulation to finish...");
				sim.join();
				Activator.logInformation("Simulation finished.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sim.stop();			
			
			
			// Simulation is done. 
			// REFRESH the workspace so we see the new log files
			refreshWorkspace(allProjects);
			
			
			// READ all logs for each scenario we ran
			for (int j = 0; j < logDirList.size(); j ++) {
				//Now read in the log file(s) we just created 
				String logDir = logDirList.get(j);
				// this directory is a disease or PopulationModel but we need to look for every leaf folder in it.
				// The leaf folders are populationIdentifiers like 'human'.
				File topDir = new File(logDir);
				File[] allSubFolders = topDir.listFiles();
				for(int k = 0; k < allSubFolders.length; k ++) {
					File leafSubFolder = allSubFolders[k];
					if(leafSubFolder.isDirectory()) {
						String populationIdentifier = leafSubFolder.getName();
						String firstSTR = populationIdentifier.substring(0,1);
						// ignore system folders
						if(!firstSTR.equals(".")) {
							
							int maxResolution = 0;
							ReferenceScenarioDataMapImpl scenarioDataMap = null;
							try {
								Activator.logInformation("Loading post simulation data from Directory "+logDir+populationIdentifier);
								CSVscenarioLoader loaderRUN = new CSVscenarioLoader(logDir+populationIdentifier);
								maxResolution = loaderRUN.getMaxResolution();
								scenarioDataMap = loaderRUN.parseAllFiles(maxResolution);
							} catch (ScenarioInitializationException e) {
								Activator.logError("Error loading run log for  "+logDir+" error= "+e.getMessage(),e);
							}
							
							//Now read in the REFERENCE log file(s) copied in with the projects. We look for the SAME populationIdentifier being tested above
							String dataObjectName = dataObjectNameList.get(j);
							String referenceDataDirectory = integrationTestLogDir+sep+scenarioName+REFERENCE_SUFFIX+sep+dataObjectName+sep+populationIdentifier;
							ReferenceScenarioDataMapImpl referenceDataMap=null;
							try {
								Activator.logInformation("Loading reference data for "+dataObjectName+sep+populationIdentifier);
								CSVscenarioLoader loaderREF = new CSVscenarioLoader(referenceDataDirectory);
								referenceDataMap = loaderREF.parseAllFiles(maxResolution);
							} catch (ScenarioInitializationException e) {
								Activator.logInformation("Warning, No REFERENCE log found or loaded for  "+dataObjectName+" referenceDataDirectory should be:["+referenceDataDirectory+"] error= "+e.getMessage());
							}
							
							// Was the test run Sane??
							assertTrue(scenarioDataMap.sane());
							if(referenceDataMap!=null) {
								assertTrue(referenceDataMap.sane());
								boolean consistent = scenarioDataMap.consistentWith(referenceDataMap);
								assertTrue(consistent);								
							}
							
							
						}// if not system folder
					}// if directory
				}// for all subFolders and Files
				
			}// for all logged directories
				
		}// for all scenarios to test
		
	}// TestAllIntegrationTest
		
	
	/**
	 * 
	 * @param scenarioFolder
	 * @return
	 */
	public static String getLogDir(String scenarioFolder)  {
		int idx = scenarioFolder.indexOf("scenarios");
		String path = scenarioFolder.substring(0,idx);
		String retVal = path+"Recorded Simulations"+sep+"IntegrationTest";
		return retVal;	
	}
	
	/**
	 * 
	 * @param scenarioFolder
	 * @return
	 */
	public static String getScenarioName(String scenarioFolder)  {
		int idx1 = scenarioFolder.indexOf("scenarios");
		int idx2 = scenarioFolder.indexOf(".scenario");
		idx1+=10;
		String name = scenarioFolder.substring(idx1,idx2);
		return name;	
	}
	
	
	/**
	 * @return a scenario
	 * @generated NOT
	 */
	public static Scenario createFixture() {
		final Scenario scenario = ScenarioFactory.eINSTANCE.createScenario();
		scenario.setModel(ModelTest.createFixture());
		scenario.setSequencer(getTestSequencer());
		scenario.setURI(SCENARIO_URI);
		final Decorator decorator = DecoratorsFactory.eINSTANCE.createTestScenarioGraphDecorator1();
		decorator.setURI(DECORATOR_URI);
		scenario.getScenarioDecorators().add(decorator);
		scenario.getDublinCore().populate();
		scenario.getDublinCore().setTitle(TEST_SCENARIO_TITLE);
		
		//scenario.initialize();
		
		Solver solver = FdFactory.eINSTANCE.createFiniteDifference();
		solver.setDecorators(scenario.getScenarioDecorators());
		scenario.setSolver(solver);
		
		return scenario;
	} // createFixture

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
		//// clean up ////
		if(allProjects != null) {
			try {
				for(int i = 0; i < allProjects.size(); i ++){
					File project = allProjects.get(i);
					assertTrue(IntegrationTestUtil.removeDirectory(project));
				}
			} catch(CoreException ce) {
				ce.printStackTrace();
				fail();
			}	
		}
		/////////////////////
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.scenario.Scenario#getCanonicalGraph() <em>Canonical Graph</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.scenario.Scenario#getCanonicalGraph()
	 * @generated NOT
	 */
	public void testGetCanonicalGraph() {
		// Nothing to test
		assertTrue(true);
	} // testGetCanonicalGraph

	/**
	 * Tests the '{@link org.eclipse.stem.core.scenario.Scenario#step() <em>Step</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.scenario.Scenario#step()
	 * @generated NOT
	 */
	public void testStep() {
		final Scenario scenario = getFixture();

		scenario.initialize();
		
		// Here we should test that the initial values of the dynamic labels are
		// correct
		Graph canonicalGraph = scenario.getCanonicalGraph();

		for (final Iterator dynamicLabelIter = canonicalGraph
				.getDynamicLabels().iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(((TestIntegerLabelValue) dynamicLabel.getCurrentValue())
					.getI() == TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		} // for

		scenario.step();

		// Here we should test that the values of the dynamic labels have
		// changed
		canonicalGraph = scenario.getCanonicalGraph();

		for (final Iterator dynamicLabelIter = canonicalGraph
				.getDynamicLabels().iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(((TestIntegerLabelValue) dynamicLabel.getCurrentValue())
					.getI() == TestIntegerLabelValue.NEXT_LABEL_INTEGER_VALUE);
		} // for
//
//		int count = 1;
//		for (; scenario.step() && count < 11; count++) {
//			// nothing
//		} // for
//
//		// step() should stop before count makes it to 11
//		assertTrue(count == 10);
	} // testStep

	/**
	 * Tests the '{@link org.eclipse.stem.core.scenario.Scenario#reset() <em>Reset</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.scenario.Scenario#reset()
	 * @generated NOT
	 */
	public void testReset() {
		final Scenario scenario = getFixture();

		scenario.initialize();

		// Here we should test that the initial values of the dynamic labels are
		// correct
		Graph canonicalGraph = scenario.getCanonicalGraph();

		for (final Iterator dynamicLabelIter = canonicalGraph
				.getDynamicLabels().iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(((TestIntegerLabelValue) dynamicLabel.getCurrentValue())
					.getI() == TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		} // for

		scenario.step();

		// Here we should test that the values of the dynamic labels have
		// changed
		canonicalGraph = scenario.getCanonicalGraph();

		for (final Iterator dynamicLabelIter = canonicalGraph
				.getDynamicLabels().iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(((TestIntegerLabelValue) dynamicLabel.getCurrentValue())
					.getI() == TestIntegerLabelValue.NEXT_LABEL_INTEGER_VALUE);
		} // for

		scenario.reset();

		// Here we should test that the values of the dynamic labels are back to
		// their initial values.
		canonicalGraph = scenario.getCanonicalGraph();

		for (final Iterator dynamicLabelIter = canonicalGraph
				.getDynamicLabels().iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(((TestIntegerLabelValue) dynamicLabel.getCurrentValue())
					.getI() == TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		} // for

		assertFalse(scenario.getSequencer().isTimeToStop());
	} // testReset

	/**
	 * Tests the '{@link org.eclipse.stem.core.scenario.Scenario#initialize() <em>Initialize</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.scenario.Scenario#initialize()
	 * @generated NOT
	 */
	public void testInitialize() {
		final Scenario scenario = getFixture();
		scenario.initialize();
		// Here we should test that the initial values of the dynamic labels are
		// correct
		Graph canonicalGraph = scenario.getCanonicalGraph();

		for (final Iterator dynamicLabelIter = canonicalGraph
				.getDynamicLabels().iterator(); dynamicLabelIter.hasNext();) {
			final DynamicLabel dynamicLabel = (DynamicLabel) dynamicLabelIter
					.next();
			assertTrue(((TestIntegerLabelValue) dynamicLabel.getCurrentValue())
					.getI() == TestIntegerLabelValue.CURRENT_LABEL_INTEGER_VALUE);
		} // for

		assertFalse(scenario.getSequencer().isTimeToStop());

		// Look for the graph label added by the Scenario decorator
		int count = 0;
		for (Iterator graphLabelIter = canonicalGraph.getGraphLabels().values()
				.iterator(); graphLabelIter.hasNext();) {
			Label graphLabel = (Label) graphLabelIter.next();
			if (wasAddedByScenarioDecorator(graphLabel)) {
				count++;
			}
		}
		assertTrue(count == 1);

	} // testInitialize

	/**
	 * Tests the '{@link org.eclipse.stem.core.scenario.Scenario#produceTitle() <em>Produce Title</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.scenario.Scenario#produceTitle()
	 * @generated NOT
	 */
	public void testProduceTitle() {
		final Scenario scenario = getFixture();
		final String title = scenario.produceTitle();

		assertTrue(scenario.getDublinCore().getTitle() != null);
		assertNotNull(title);
		assertFalse(title.equals(""));
	} // testProduceTitle

	/**
	 * @param graphLabel
	 * @return true if the graphLabel was added by a scenario decorator
	 */
	private boolean wasAddedByScenarioDecorator(Label graphLabel) {
		boolean retValue = false;
		if (graphLabel instanceof DynamicLabel) {
			DynamicLabel dynamicLabel = (DynamicLabel) graphLabel;
			retValue = dynamicLabel.getURI() == TestScenarioGraphDecorator1.LABEL_URI;
		}
		return retValue;
	} // wasAddedByScenarioDecorator

	/**
	 * Test the Scenario has the right type URI.
	 * 
	 * @generated NOT
	 */
	public void testGetTypeURI() {
		final Scenario scenario = getFixture();
		assertTrue(scenario.getTypeURI().equals(STEMURI.SCENARIO_TYPE_URI));
	} // testGetTypeURI

	/**
	 * Test the ability to serialize a scenario and then de-serialize it.
	 */
	// public void testSerializeDeserializeScenario() {
	// final Scenario scenario = getFixture();
	// serializeDeserializeScenario(scenario, SCENARIO_SERIALZATION_TEST_URI);
	// } // testSerializeDeserializeScenario
	/**
	 * Test the ability to serialize a scenario and then de-serialize it.
	 */
	public void testSerializeDeserializeCanonicalGraph() {
		final Scenario scenario = getFixture();
		STEMTime now = ModelFactory.eINSTANCE.createSTEMTime();
		final Graph canonicalGraph = scenario.getModel().getCanonicalGraph(
				CANONICAL_GRAPH__URI, new IdentifiableFilterImpl(scenario.getModel().getDublinCore().getCoverage()), now);
		try {
			Utility.serializeIdentifiable(canonicalGraph,
					CANONICAL_GRAPH_SERIALZATION_TEST_URI);

			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(
					CANONICAL_GRAPH_SERIALZATION_TEST_URI, true);

			resource.load(null);
			final Graph deserializedGraph = (Graph) resource.getContents().get(
					0);
			assertNotNull(deserializedGraph);
			assertTrue(canonicalGraph.getNumEdges() == deserializedGraph
					.getNumEdges());
			assertTrue(canonicalGraph.getNumNodes() == deserializedGraph
					.getNumNodes());
			assertTrue(canonicalGraph.getNumDynamicLabels() == deserializedGraph
					.getNumDynamicLabels());
			assertTrue(canonicalGraph.getNumGraphLabels() == deserializedGraph
					.getNumGraphLabels());
			assertTrue(canonicalGraph.getNumNodeLabels() == deserializedGraph
					.getNumNodeLabels());

		} catch (IOException e) {
			fail(e.getMessage());
		} // catch
		catch (NullPointerException npe) {
			npe.printStackTrace();
			fail(npe.getMessage());
		} // null pointer exception
		catch (Exception e) {
			fail(e.getMessage());
		} finally {
			// Remove the serialized file
			// IFile seralizeFile =
		}
	} // testSerializeDeserializeCanonicalGraph

	/**
	 * Test the process of serializing and de-serializing a scenario
	 * 
	 * @param scenario
	 *            the scenario to test
	 * @param uri
	 *            where to do the test
	 */
	public static void serializeDeserializeScenario(final Scenario scenario,
			final URI uri) {
		try {
			Utility.serializeIdentifiable(scenario, uri);

			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(uri, true);

			resource.load(null);
			final Scenario deserializedScenario = (Scenario) resource
					.getContents().get(0);
			assertNotNull(deserializedScenario);
		} catch (IOException e) {
			fail(e.getMessage());
		} // catch
		catch (NullPointerException npe) {
			fail(npe.getMessage());
		} // null pointer exception
		catch (Exception e) {
			fail(e.getMessage());
		}
	} // serializeDeserializeScenario

	/**
	 * @return a <code>Sequencer</code> for testing.
	 */
	private static Sequencer getTestSequencer() {
		final Sequencer retValue = new SequencerImpl() { 

			protected long timeIncrement = STEMTime.Units.DAY.getMilliseconds();

			/**
			 * This is an accumulator of the work increment that keeps account of 
			 * the fraction of the work increments until they exceed 1.0
			 */
			private double workIncrementRunningTotal = 0.0;


			public long getTimeIncrement() {
				return timeIncrement;
			}
			
			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#getNextTime()
			 */
			@Override
			public STEMTime getNextTime() {
				setCurrentTime(getCurrentTime().addIncrement(getTimeIncrement()));
				setWorkComplete(Math.min(getWorkComplete() + getWorkIncrement(), 100));
				return getCurrentTime();
			}

			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#getTimeDelta()
			 */
			@Override
			public long getTimeDelta() {
				return super.getTimeDelta();
			}

			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#getWorkIncrement()
			 */
			@Override
			public int getWorkIncrement() {
				int retValue = 0;
				// Is there a work increment?
				if (getDuration() != UNKNOWN_DURATION) {
					// Yes
					// The work increment could be fractional (<1.0). If so then it will
					// not accumulate in the progress monitor. So, we keep a running sum
					// of the work increment and when it exceeds 1.0 we return the value less
					// the fractional part and keep that for the future.
					workIncrementRunningTotal += 100.0 * getTimeIncrement()
							/ getDuration();
					
					// Do we have more than 1.0?
					if (workIncrementRunningTotal >= 1.0) {
						// Yes
						//$ANALYSIS-IGNORE
						retValue = (int)workIncrementRunningTotal;
						workIncrementRunningTotal -= retValue;
					}
				}

				return retValue;
			}

			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#isTimeToStop()
			 */
			@Override
			public boolean isTimeToStop() {
				boolean retValue = false;
				// Is there an end time?
				if (getEndTime() != null) {
					// Yes
					retValue = getCurrentTime().getTime().after(getEndTime().getTime());
				}
				return retValue;
			}

			@Override
			public int getCycle() {
				return 0;
			}

			
		};
		retValue.setStartTime(createSTEMTime(2000, 01, 01));
		retValue.getCurrentTime();
		retValue.setEndTime(createSTEMTime(2000, 01, 10));
		retValue.setURI(SEQUENCER_URI);
		return retValue;
	} // getTestSequencer
	
	/**
	 * Create an instance of STEMTime
	 * 
	 * @return the instance
	 */
	private static STEMTime createSTEMTime(final int year, final int month,
			final int day) {
		final STEMTime retValue = ModelFactory.eINSTANCE.createSTEMTime();

		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		retValue.setTime(calendar.getTime());
		return retValue;
	} // createSTEMTime
	
	/**
	 * @return an {@link Scenario} for testing.
	 */
	public static List<File> setUpWorkspace() {
		
		List<File> projectDirectories = new ArrayList<File>();
		// 1. copy the project folders for the experiment to run 
		//    FROM the source directory TO the runtime workspace where ever that is
		File refDirectory = new File(IntegrationTestUtil.REFERENCE_DIR);
		if (refDirectory.isDirectory()) {
			// should always be true
			File[] projects = refDirectory.listFiles();
			if(projects==null) {
				Activator.logInformation("Error:AutomatedExperiment projects not found !!");//$NON-NLS-1$
				System.exit(1);
			}
			for (int i = 0; i < projects.length; i ++) {
				if(projects[i].isDirectory()) {
					// check that this is not a system directory with name beginning with "."
					String nameStr = projects[i].getName();
					
					if(!nameStr.substring(0,1).equals(".")) {//$NON-NLS-1$
						// this is a good directory
						String runProjectName = IntegrationTestUtil.RUNTIME_WORKSPACE_PATH+sep+nameStr;
						File targetDirectory = new File(runProjectName);
							try {
								// 1. create the project and folder
								IntegrationTestUtil.importProject(projects[i], targetDirectory);
								// 2. remember it
								projectDirectories.add(targetDirectory);
								Activator.logInformation("found "+targetDirectory.getAbsolutePath());
								
							} catch (Exception e) {
								Activator.logInformation("Project Copy failed "+e.getMessage());//$NON-NLS-1$
								e.printStackTrace();
								
							}
						}
						
						
					}// if good dir name
					
				}// for all projects
		}//if
		return projectDirectories;
	}// setUpWorkspace
	
	/**
	 * @return an {@link Scenario} for testing.
	 */
	public static void refreshWorkspace(List<File> projects) {
		
		
		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).isDirectory()) {
				// check that this is not a system directory with name beginning
				// with "."
				String nameStr = projects.get(i).getName();

				if (!nameStr.substring(0, 1).equals(".")) {//$NON-NLS-1$
					// this is a good directory
					String runProjectName = IntegrationTestUtil.RUNTIME_WORKSPACE_PATH + sep + nameStr;
					File targetDirectory = new File(runProjectName);
					try {
						// 1. create the project and folder
						IntegrationTestUtil.refreshProject(targetDirectory);
						Activator.logInformation("found "+ targetDirectory.getAbsolutePath());
					} catch (Exception e) {
						Activator.logInformation("Project Copy failed " + e.getMessage());//$NON-NLS-1$
						e.printStackTrace();
					}
				}

			}// if good dir name

		}// for all projects
		
		
	}// setUpWorkspace
	
	/**
	 * 
	 * @param projects
	 * @return
	 */
	public static List<String> readScenarios(List<File> projects) {
			List<String> scenarioList = new ArrayList<String>();
			for (int i=0; i < projects.size(); i ++ ) {
				File project = projects.get(i);
				String path = project.getAbsolutePath();
				File scenarioFolder = new File(path+SCENARIO_FOLDER);
				if(scenarioFolder.exists()&&scenarioFolder.isDirectory()) {
					File[] scenariosToRun = scenarioFolder.listFiles();
					if(scenariosToRun != null) {
						for (int j = 0; j <scenariosToRun.length; j++) {
							File scenario = scenariosToRun[j];
							if(scenario.getName().indexOf(".scenario")>=1) {
								// this really is a scenario file
								scenarioList.add(scenario.getAbsolutePath());
							}//if scenario
						}// for all
					}//  list not null
					
				}// if scenario folder
			}// for all projects
			
			return scenarioList;
	}//readScenarios

	
	/**
	 * 
	 * @param filename
	 * @return
	 */
	static Scenario loadScenario(final String filename) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", //$NON-NLS-1$
				STEMXMIResourceFactoryImpl.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put("platform", //$NON-NLS-1$
				STEMXMIResourceFactoryImpl.INSTANCE);
		final Resource resource = resourceSet.getResource(URI.createFileURI(filename), true);
		try 
		{			
			resource.load(null);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		Scenario toReturn = (Scenario)resource.getContents().get(0);
		return toReturn;
	}


} // ScenarioTest

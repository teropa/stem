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

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.stem.core.IdentifiableFilter;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.tests.ModelTest;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.core.sequencer.impl.SequencerImpl;
import org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

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

	private static final URI CANONICAL_GRAPH__URI = STEMURI
			.createURI("GRAPH/testcanonicalgraph");

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
		setFixture(createFixture());
	} // setUp

	/**
	 * @return a scenario
	 */
	public static Scenario createFixture() {
		final Scenario scenario = ScenarioFactory.eINSTANCE.createScenario();
		scenario.setModel(ModelTest.createFixture());
		scenario.setSequencer(getTestSequencer());
		scenario.setURI(SCENARIO_URI);
		scenario.getScenarioDecorators()
				.add(
						DecoratorsFactory.eINSTANCE
								.createTestScenarioGraphDecorator1());
		scenario.getDublinCore().populate();
		scenario.getDublinCore().setTitle(TEST_SCENARIO_TITLE);
		scenario.setSolver(new FiniteDifferenceImpl());
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
		final Graph canonicalGraph = scenario.getModel().getCanonicalGraph(
				CANONICAL_GRAPH__URI, new IdentifiableFilter(scenario.getModel().getDublinCore().getCoverage()));
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

} // ScenarioTest

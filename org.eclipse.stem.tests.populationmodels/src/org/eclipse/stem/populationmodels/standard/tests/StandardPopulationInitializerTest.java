/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.tests;

import java.util.Map;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.SequentialSequencer;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardPopulationInitializerTest extends PopulationInitializerTest {

	private int individuals = 10;
	private String populationIdentifier = "human";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StandardPopulationInitializerTest.class);
	}

	/**
	 * Constructs a new Population Initializer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationInitializerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Population Initializer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StandardPopulationInitializer getFixture() {
		return (StandardPopulationInitializer)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(StandardFactory.eINSTANCE.createStandardPopulationInitializer());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	public void testInitializeRegion() {
		
		Scenario scenario = ScenarioFactory.eINSTANCE.createScenario();
		Model model = ModelFactory.eINSTANCE.createModel();
		scenario.setModel(model);
		Graph graph = GraphFactory.eINSTANCE.createGraph();
		
		Region region = NodesFactory.eINSTANCE.createRegion();
		region.setURI(STEMURI.createURI(Region.URI_TYPE_REGION_NODE_SEGMENT));
		graph.getNodes().put(region.getURI(), region);
		
		model.getGraphs().add(graph);
		
		StandardPopulationInitializer initializer = getFixture();
		initializer.setIndividuals(individuals);
		initializer.setPopulationIdentifier(populationIdentifier);
		model.getNodeDecorators().add(initializer);
		
		SequentialSequencer seq = SequencerFactory.eINSTANCE.createSequentialSequencer();
		seq.setStartTime(ModelFactory.eINSTANCE.createSTEMTime());
		seq.setEndTime(ModelFactory.eINSTANCE.createSTEMTime());
		seq.setTimeIncrement(86400000);
		scenario.setSequencer(seq);
		scenario.initialize();

		// Make sure the region has a population label
		
		assertTrue(scenario.getCanonicalGraph().getNodeLabels().size() == 1);
		
		for(Map.Entry<URI, NodeLabel> entry:scenario.getCanonicalGraph().getNodeLabels().entrySet()) {		
			PopulationLabel pl = (PopulationLabel)entry.getValue();
	
			assertTrue(pl.getPopulationIdentifier().equals(populationIdentifier));
			assertTrue(pl.getCurrentPopulationValue().getCount() == individuals);
		}
	}
} //StandardPopulationInitializerTest

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.tests;

import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.SequentialSequencer;
import org.eclipse.stem.core.solver.SolverFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;
import org.eclipse.stem.solvers.fd.FdFactory;
import org.eclipse.stem.solvers.fd.FiniteDifference;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Population Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class PopulationModelTest extends TestCase {

	public final int individuals = 10;
	public final String populationIdentifier = "human";
	
	/**
	 * The fixture for this Population Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationModel fixture = null;

	/**
	 * Constructs a new Population Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Population Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PopulationModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Population Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationModel getFixture() {
		return fixture;
	}

	protected Scenario createScenario() {
		Scenario scenario = ScenarioFactory.eINSTANCE.createScenario();
		Model model = ModelFactory.eINSTANCE.createModel();
		scenario.setModel(model);
		Model model2 = ModelFactory.eINSTANCE.createModel();
		model.getModels().add(model2);
		
		Graph graph = GraphFactory.eINSTANCE.createGraph();
		
		Region region = NodesFactory.eINSTANCE.createRegion();
		region.setURI(STEMURI.createURI(Region.URI_TYPE_REGION_NODE_SEGMENT));
		graph.getNodes().put(region.getURI(), region);
		
		model2.getGraphs().add(graph);
		
		StandardPopulationInitializer initializer = StandardFactory.eINSTANCE.createStandardPopulationInitializer();
		initializer.setIndividuals(individuals);
		initializer.setPopulationIdentifier(populationIdentifier);
		model2.getNodeDecorators().add(initializer);
		
		SequentialSequencer seq = SequencerFactory.eINSTANCE.createSequentialSequencer();
		seq.setStartTime(ModelFactory.eINSTANCE.createSTEMTime());
		seq.setEndTime(ModelFactory.eINSTANCE.createSTEMTime());
		seq.setTimeIncrement(86400000);
		scenario.setSequencer(seq);
		
		FiniteDifference fd = FdFactory.eINSTANCE.createFiniteDifference();
		scenario.setSolver(fd);
		
		return scenario;
	}
} //PopulationModelTest

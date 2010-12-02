/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.definitions.transport.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.tests.PopulationLabelTest;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.transport.PipeTransportEdge;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue;
import org.eclipse.stem.definitions.transport.TransportFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pipe Transport Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipeTransportEdgeTest extends TestCase {
	
	public static final URI EDGE_URI = STEMURI.createURI("PipeStyleEdgeTestURI");
	public static final URI NODE_A_URI = STEMURI.createURI("RegionNodeA");
	public static final URI NODE_B_URI = STEMURI.createURI("RegionNodeB");
	public static double MAX_FLOW = 1.0;
	public static final long TIME_PERIOD = STEMTime.Units.DAY.getMilliseconds();

	/**
	 * The fixture for this Pipe Transport Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PipeTransportEdgeTest.class);
	}

	/**
	 * Constructs a new Pipe Transport Edge test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pipe Transport Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PipeTransportEdge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pipe Transport Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdge getFixture() {
		return fixture;
	}
	
	/**
	 * create the fixture
	 **/
	protected static PipeTransportEdge createFixture() {
		PipeTransportEdge edge = TransportFactory.eINSTANCE.createPipeTransportEdge();
		edge.setURI(EDGE_URI);
		
		// the nodes to connect to
		Node nodeA = NodesFactory.eINSTANCE.createRegion();
		Node nodeB = NodesFactory.eINSTANCE.createRegion();
		nodeA.setURI(NODE_A_URI);
		nodeB.setURI(NODE_B_URI);
		final PopulationLabel populationLabel = PopulationLabelTest.createFixture();
		nodeA.getLabels().add(populationLabel);
		nodeB.getLabels().add(populationLabel);
	
		// set up the pipe
		PipeTransportEdgeLabel  edgeLabel = (PipeTransportEdgeLabel)edge.getLabel();
		PipeTransportEdgeLabelValue  edgeLabelValue = TransportFactory.eINSTANCE.createPipeTransportEdgeLabelValue();
		edgeLabelValue.setMaxFlow(MAX_FLOW);
		edgeLabelValue.setTimePeriod(TIME_PERIOD);
		edgeLabel.setCurrentValue(edgeLabelValue);
		edge.setA(nodeA);
		edge.setNodeAURI(nodeA.getURI());
		edge.setB(nodeB);
		edge.setNodeBURI(nodeB.getURI());
		edge.setPopulationIdentifier(populationLabel.getPopulationIdentifier());
		
		nodeA.getEdges().add(edge);
		nodeB.getEdges().add(edge);
						
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}
	
	/**
	 * @generated NOT
	 */
	public void testPipeTransportEdge() {
		assertTrue(getFixture().sane());
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

} //PipeTransportEdgeTest

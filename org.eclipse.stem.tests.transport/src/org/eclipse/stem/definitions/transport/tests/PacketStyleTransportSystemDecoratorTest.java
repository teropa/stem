package org.eclipse.stem.definitions.transport.tests;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.Calendar;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.definitions.transport.LoadUnloadEdge;
import org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystem;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystemDecorator;
import org.eclipse.stem.definitions.transport.PacketTransportLabel;
import org.eclipse.stem.definitions.transport.TransportFactory;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.tests.EdgeDecoratorTest;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.SequentialSequencer;
import org.eclipse.stem.diseasemodels.standard.tests.DiseaseModelTestUtil;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Packet Style Transport System Decorator</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class PacketStyleTransportSystemDecoratorTest extends EdgeDecoratorTest {
	
	/*Constants for use in the tests*/
	public static final double TRANSPORT_CAPACITY = 100.0;
	public static final double LOAD_UNLOAD_RATE  = 0.5;
	public static final double PORT_POPULATION = 100000.0;
	
	/*Time Stuff*/
	private static final int START_DAY = 20;
	private static final int END_DAY = 29;	
	//private static final int NUMBER_OF_DAYS =  END_DAY - START_DAY + 1;
	
	private static final int ACTIVATION_DAY = 25;
	private static final int DEACTIVATION_DAY = 27;
	
	// The fixture sequencer sequences through 10 days
	public static final STEMTime START_TIME = createSTEMTime(2006,
			Calendar.NOVEMBER, START_DAY);

	public static final STEMTime END_TIME =  createSTEMTime(2006,
			Calendar.NOVEMBER, END_DAY);

	public static final long TIME_INCREMENT = STEMTime.Units.DAY.getMilliseconds()/4;
	
	public static final STEMTime ACTIVATION_TIME = 	createSTEMTime(2006,
			Calendar.NOVEMBER, ACTIVATION_DAY);
	public static final STEMTime DEACTIVATION_TIME = createSTEMTime(2006,
			Calendar.NOVEMBER, DEACTIVATION_DAY);	
	
	/**
	 * The fixture for this Packet Style Transport System Decorator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PacketStyleTransportSystemDecorator fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PacketStyleTransportSystemDecoratorTest.class);
	}
	
	/**
	 * Creates the underlying model with a decorator and load/unload edges 
	 * 
	 * @param loading should we set up the model for a loading edge or for an unloading edge.
	 */
	public Scenario createDecoratorScenario  (boolean loading) {
		//The scenario to return
		Scenario retValue = ScenarioFactory.eINSTANCE.createScenario();
		DublinCore dc = retValue.getDublinCore();
		dc.populate();
		dc.setTitle("LoadUnloadScenario");
		
		//We need to make a model for the scenario.
		Model scnModel = ModelFactory.eINSTANCE.createModel();
		dc = scnModel.getDublinCore();
		dc.populate();
		dc.setTitle("LoadUnloadMode");
		
		
		//We need to make a graph for the model.
		Graph mdlGraph = GraphFactory.eINSTANCE.createGraph();
		dc = mdlGraph.getDublinCore();
		dc.populate();
		dc.setTitle("LoadUnloadGraph");
		
		//Put in a packet style transport system and a random node to 
		//unload to.
		
		//Create the PSTransportSystem node
		PacketStyleTransportSystem transport = TransportFactory.eINSTANCE.createPacketStyleTransportSystem();	
		PacketTransportLabel ptLabel = TransportFactory.eINSTANCE.createPacketTransportLabel();
		transport.setPacketTransportLabel(ptLabel);
		transport.getPacketTransportLabel().getCurrentValue().setCapacity(TRANSPORT_CAPACITY);
		
		PopulationLabel popLabel = LabelsFactory.eINSTANCE.createPopulationLabel();
		popLabel.getCurrentPopulationValue().setCount(TRANSPORT_CAPACITY);
		transport.getLabels().add(popLabel);
		
		mdlGraph.getNodeLabels().put(ptLabel.getURI(),ptLabel);
		mdlGraph.getNodeLabels().put(popLabel.getURI(), popLabel);
		
		//Create the source/destination node.
		Region region = DiseaseModelTestUtil.createPopulationRegionNode(
				DiseaseModelTestUtil.TEST_POPULATION_IDENTIFIER,
				PORT_POPULATION, DiseaseModelTestUtil.TEST_AREA);
		
		

		//Create the LoadUnload edge between these and set up the 
		//appropriate parameters
		LoadUnloadEdge luEdge = TransportFactory.eINSTANCE.createLoadUnloadEdge();
		LoadUnloadEdgeLabel lueLabel =TransportFactory.eINSTANCE.createLoadUnloadEdgeLabel();
		luEdge.setLabel(lueLabel);
		lueLabel.setURIOfIdentifiableToBeLabeled(luEdge.getURI());
		
		if (loading) {
			luEdge.setLoadingEdge(true);
			luEdge.setNodeAURI(region.getURI());
			luEdge.setNodeBURI(transport.getURI());
			luEdge.setA(region);
			luEdge.setB(transport);	
			
		} else {
			luEdge.setLoadingEdge(false);
			luEdge.setNodeBURI(region.getURI());
			luEdge.setNodeAURI(transport.getURI());
			luEdge.setB(region);
			luEdge.setA(transport);	
			
		}
		
		region.getEdges().add(luEdge);
		transport.getEdges().add(luEdge);
		
		luEdge.getLabel().setActivatedRate(LOAD_UNLOAD_RATE);
		luEdge.getLabel().setActivationTime(ACTIVATION_TIME);
		luEdge.getLabel().setDeactivationTime(DEACTIVATION_TIME);
		
		//add the nodes and the edges to the graph
		mdlGraph.putEdge(luEdge);
		mdlGraph.getDynamicLabels().add(luEdge.getLabel());
		mdlGraph.putNode(region);
		mdlGraph.putNode(transport);
		
		//add the graph to the mdl.
		scnModel.getGraphs().add(mdlGraph);
		
		//add the mdl to the scenario and give it a sequencer
		retValue.setModel(scnModel);
		
		SequentialSequencer sequencer = SequencerFactory.eINSTANCE.createSequentialSequencer();
		sequencer.setStartTime((STEMTime)EcoreUtil.copy(START_TIME));
		sequencer.setCurrentTime((STEMTime)EcoreUtil.copy(START_TIME));
		sequencer.setEndTime((STEMTime)EcoreUtil.copy(END_TIME));
		sequencer.setTimeIncrement(TIME_INCREMENT);
		retValue.setSequencer(sequencer);
		
		//create the decorator and add it to the scenario
		PacketStyleTransportSystemDecorator decorator = this.getFixture();
		retValue.getScenarioDecorators().add(decorator);
		
		//make sure everything we are returning is sane
		assert luEdge.sane();
		assert region.sane();
		assert transport.sane();
		assert mdlGraph.sane();
		assert scnModel.sane();
		assert retValue.sane();
		
		
		
		return retValue;
	}
	
	/**Test the decorator for unloading*/
	public void testUnload () {
		Scenario scn = createDecoratorScenario(false);
						
		scn.initialize();
		//scn.getCanonicalGraph()
		LoadUnloadEdge luEdge = (LoadUnloadEdge)scn.getCanonicalGraph().getEdgesMap().values().toArray()[0];	
		assertTrue(luEdge.getLabel().getCurrentValue().getMigrationRate()==0);
		
		while (scn.step()) {
			//System.out.println("step:"+scn.getSequencer().getCurrentTime());
			//System.out.println("curr:"+luEdge.getLabel().getCurrentValue().getMigrationRate());
			//System.out.println("next:"+((MigrationEdgeLabelValue)luEdge.getLabel().getNextValue()).getMigrationRate());
			//System.out.println("checking:"+luEdge.getLabel().hashCode());			
			
			if (scn.getSequencer().getCurrentTime().getTime().after(ACTIVATION_TIME.getTime()) &&
					scn.getSequencer().getCurrentTime().getTime().before(DEACTIVATION_TIME.getTime())) {
				assertTrue(luEdge.getLabel().getCurrentValue().getMigrationRate()==LOAD_UNLOAD_RATE);
			} else {
				assertTrue(luEdge.getLabel().getCurrentValue().getMigrationRate()==0);	
			}
		}
		
	
	}
	
	public void testLoad() {
		Scenario scn = createDecoratorScenario(true);
		
		scn.initialize();
		//scn.getCanonicalGraph()
		LoadUnloadEdge luEdge = (LoadUnloadEdge)scn.getCanonicalGraph().getEdgesMap().values().toArray()[0];	
		assertTrue(luEdge.getLabel().getCurrentValue().getMigrationRate()==0);
		
		while (scn.step()) {
			//System.out.println("step:"+scn.getSequencer().getCurrentTime());
			//System.out.println("curr:"+luEdge.getLabel().getCurrentValue().getMigrationRate());
			//System.out.println("next:"+((MigrationEdgeLabelValue)luEdge.getLabel().getNextValue()).getMigrationRate());
			//System.out.println("checking:"+luEdge.getLabel().hashCode() +"va.");			
			
			if (scn.getSequencer().getCurrentTime().getTime().after(ACTIVATION_TIME.getTime()) &&
					scn.getSequencer().getCurrentTime().getTime().before(DEACTIVATION_TIME.getTime())) {
				assertTrue(luEdge.getLabel().getCurrentValue().getMigrationRate()==
					LOAD_UNLOAD_RATE*TRANSPORT_CAPACITY/PORT_POPULATION);
			} else {
				assertTrue(luEdge.getLabel().getCurrentValue().getMigrationRate()==0);	
			}
		}
	}

	/**
	 * Constructs a new Packet Style Transport System Decorator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketStyleTransportSystemDecoratorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Packet Style Transport System Decorator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PacketStyleTransportSystemDecorator fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Packet Style Transport System Decorator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PacketStyleTransportSystemDecorator getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TransportFactory.eINSTANCE.createPacketStyleTransportSystemDecorator());
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


} //PacketStyleTransportSystemDecoratorTest

package org.eclipse.stem.ui.ge;
/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/ 
import junit.framework.TestCase;

/**
 *
 */
public class GEInterfaceTest extends TestCase      {

	/**
	 * @param name
	 */
	public GEInterfaceTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	
//	private Scenario scenario = null;
	
	/**
	 * this has the key part commented out.
	 * To reestablish this test we need to be able to create a test scenario.
	 * We need to know how to do this.
	 * 
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		 This creates a scenario that's ready to be "stepped" (i.e.,
		// simulated). The world is a lattice (grid) that 2x2 where each node
		// has a population of 100 humans and has an area of 100 square
		// kilometers. There is one disease that is modeled with a
		// "deterministic SEIR disease model". One person in the node at
		// position [0][0], in the upper left of the grid, is infected.
//		scenario = DeterministicSEIRScenarioTest.createScenario(2, 2);

		// This will initialize the scenario and make it ready to step through
		// the simulation sequence. In particular, it will create the cannonical
		// graph from the scenario's model.
//		scenario.initialize();

	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	/**
	 * Test method for
	 * {@link org.eclipse.stem.ui.ge.GEInterface#simulationsChanged(org.eclipse.stem.jobs.simulation.SimulationManagerEvent)}.
	 *
	 * This will test the method that gets control when a 
	 * Simulation starts. 
	 * 
	 */
	
	public void testSimulationsChanged() {
		// The scenario was created in the setup method.
		 
		// create a simulation
//		ISimulation simulation = new Simulation(scenario);
		// create an instance of GEInterface to test		
//		GEInterface gei = new GEInterface(null);
        // invoke the simulationsChanged method to		
		// tell gei that a Simulation has been added.
//		SimulationManager source = SimulationManager.getManager();
//		ISimulation[] add = {simulation};
//		ISimulation[] remove = {};
//		SimulationManagerEvent smevent = 
//			new SimulationManagerEvent(source,add,remove);
//		gei.simulationsChanged(smevent);
	}

/**
 * 
 */
//	public void testStartServer() {
//		GEInterface gei = new GEInterface();
//		boolean started = gei.startServer();
//		assertTrue("Failed to start web server.",started);
//	}
	
	public void testSetActive() {
       //		 create a simulation
//		ISimulation simulation = new Simulation(scenario);
		// create an instance of GEInterface to test		
//		GEInterface gei = new GEInterface(null);
//		boolean ok = gei.setActive(simulation, true);
//		assertFalse(ok);
	}
	
	/**
	 * 
	 */
	public void testDisplayMap() {
		GELog.DEBUG = true;
//		 create a simulation
//		ISimulation simulation = new Simulation(scenario);
		// create an instance of GEInterface to test		
//		GEInterface gei = new GEInterface(null);
//		boolean ok = gei.displayMap(simulation);
//		assertTrue(ok);
	}
	
	/**
	 * Test method for
	 * {@link org.eclipse.stem.ui.ge.GEInterface#simulationsChanged(org.eclipse.stem.jobs.simulation.SimulationManagerEvent)}.
	 *
	 * This will test the method that gets control when a 
	 * Simulation signals a change. In our case we are interested in
	 * the  SimulationState.COMPLETED_CYCLE event.
	 * 
	 */
//	
//	public void testSimulationChanged() {
//		
//		// create a simulation
//		ISimulation simulation = new Simulation(scenario);
//		// create an instance of GEInterface to test		
//		GEInterface gei = new GEInterface(null);
//        
//		// tell gei that a Simulation has been added.
//		
//		gei.setActive(simulation,true);
//		
//		// send a simulation event.
//		SimulationState state = SimulationState.COMPLETED_CYCLE;
//		SimulationEvent event = new SimulationEvent(simulation,state);
//		
//		gei.simulationChanged(event);
//		
//		// how should I check for sucess???
//		
//	}

}

// old stuff to save
///**
//* provide methods for StemMapContentProvider implmentation
//*/
//public int getAspect() {
//	return 3;
//}
//
//public Map<String,GEData> getSTEMMap() {
//	String name = "US-AL-01001";
//	ArrayList<Coordinates> coord = new ArrayList<Coordinates>();
//	double[] points = new double[] {
//			-86.916956,32.664158, -86.817344,32.660151,
//			-86.713495,32.667382, -86.620663,32.70626,
//			-86.524593,32.707057, -86.524593,32.707057,
//			-86.468202,32.707856, -86.416159,32.70748,
//			-86.415647,32.707464, -86.413116,32.707386,
//			-86.413116,32.707386, -86.412567,32.607347,
//			-86.412378,32.557071, -86.412342,32.503636,
//			-86.412073,32.492934, -86.412073,32.492934,
//			-86.411973,32.491634, -86.411973,32.491634,
//			-86.411973,32.489355, -86.411973,32.485835,
//			-86.411773,32.465735, -86.411172,32.409937,
//			-86.411172,32.409937, -86.416472,32.407037,
//			-86.444785,32.39986, -86.463564,32.377288,
//			-86.496774,32.344438, -86.496774,32.344438,
//			-86.535668,32.34044, -86.54216,32.361417,
//			-86.709716,32.3604, -86.782377,32.373375,
//			-86.784355,32.324408, -86.814912,32.340803,
//			-86.814912,32.340803, -86.843096,32.432814,
//			-86.866607,32.440114, -86.900519,32.556054,
//			-86.916956,32.664158 };
//	
//	for (int i=0; i<points.length;i++) {
//	    Coordinates c = new Coordinates(points[i],points[i+1]);
//	    i++;
//	    coord.add(c);
//	}
//	
//	
//	
//	GEData loc =new GEData(name,coord);
//	Map<String,GEData> map = new HashMap<String,GEData>(1024);
//	map.put(name,loc);
//	return map;
//}
//
//public Map<String,Color> getColors() {
//	String name = "US-AL-01001";
//	Map<String,Color> colorMap = new HashMap<String,Color>(1024);
//	Color c = Color.blue;
//	colorMap.put(name,c);
//	return colorMap;
//}
//
//private long cycle = -1;
//public long getCycle() {
//	cycle++;
//	return cycle; 
//}

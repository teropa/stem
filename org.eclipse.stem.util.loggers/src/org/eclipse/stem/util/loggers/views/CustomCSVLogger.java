package org.eclipse.stem.util.loggers.views;

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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.adapters.time.TimeProvider;
import org.eclipse.stem.adapters.time.TimeProviderAdapterFactory;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListenerSync;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.swt.widgets.Display;

/**
 * DataHistoryLogger
 */
public class CustomCSVLogger 
	implements ISimulationListenerSync {
	/**
	 * The {@link Simulation} for the 
	 */
	protected ISimulation simulation = null;
	/**
	 * The {@link DiseaseModel} for the logged data 
	 */
	protected IntegrationDecorator diseaseModel = null;
	/**
	 * abstract log writer
	 */
	LogWriter logWriter;
	/**
	 * this simulations graph
	 */
	Graph graph = null;
	/**
	 * the time provider tells simulation time
	 */
	TimeProvider timeProvider = null;
	
	protected Map<Node, Integer> nodeLevels;

	/**
	 * @param outputDir
	 * @param simulation 
	 * @param dm
	 */
	public CustomCSVLogger(final String outputDir, ISimulation simulation, IntegrationDecorator dm) {
		this.logWriter = new NewCSVLogWriter(outputDir, simulation, dm);
		setSimulation(simulation);
		this.diseaseModel = dm;
	}
	
	/**
	 * Setting the {@link Simulation} has the side-effect of causing the control
	 * to remove itself as a listener from any previously set {@link Simulation}
	 * and adding itself as a listener to the new one. It will also cause the
	 * image to be initialized from the contents of the new {@link Simulation}
	 * as appropriate.
	 * 
	 * @param simulation
	 *            the simulation whose Lat/Long data will be rendered.
	 */
	public final void setSimulation(final ISimulation simulation) {
		// Any need to switch?
		if (this.simulation == simulation) {
			// No
			return;
		} // if no need to switch?

		// Should we remove ourselves as listeners from the current simulation?
		if (this.simulation != null) {
			// Yes
			this.simulation.removeSimulationListenerSync(this);
		}

		this.nodeLevels = this.getNodeLevels(simulation);
		
		this.simulation = simulation;
		// Was there a new simulation to switch to?
		if (this.simulation != null) {
			// Yes
			this.simulation.addSimulationListenerSync(this);
			initializeFromSimulation(this.simulation);
		} else {
			// No
			// Just display a blank screen
			//initializeFromSimulation(null);
		}

		flushLoggerData();
	} // setSimulation
	
	/**
	 * Initialize the control from a {@link Simulation} instance.
	 * 
	 * @param simulation
	 *            the {@link Simulation} whose state will be visualized in the
	 *            control.
	 */
	protected void initializeFromSimulation(final ISimulation simulation) {
		graph = simulation.getScenario().getCanonicalGraph();

		timeProvider = (TimeProvider) TimeProviderAdapterFactory.INSTANCE
				.adapt(graph, TimeProvider.class);
	} // initializeFromSimulation

	/**
	 * 
	 */
	public void flushLoggerData() {
		if (logWriter != null) {
			logWriter.flushLoggerData();
		}
	}

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListenerSync#simulationChangedSync(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	public void simulationChangedSync(final SimulationEvent event) {
		// Data to log ?
		if (event.getSimulationState() == SimulationState.RUNNING) {
			if ((logWriter != null) && (logWriter.needsHeader)) {
				// This will write the headers and the first line of data before first cycle
				logWriter.logHeader(this.simulation, this.diseaseModel, this.nodeLevels, timeProvider);
				//logWriter.logData(this.simulation, this.diseaseModel, this.nodeLevels, timeProvider, true);
			}
		} else if(event.getSimulationState() == SimulationState.COMPLETED_CYCLE) {
			// Write data after each cycle of simulation
			final Display display = Display.getDefault();
			if ((logWriter != null) && (!display.isDisposed())) {
				if (logWriter != null) {
					logWriter.logData(this.simulation, this.diseaseModel, this.nodeLevels, timeProvider, false);
				}
			} // if
		} else 
		// Is the Simulation stopping (i.e. being deleted?)
		if (event.getSimulationState() == SimulationState.STOPPED) {
			close();
		} // if

	} // simulationChanged
	
	/**
	 * Return all nodes and their corresponding level. We use this to log data using 
	 * different resolutions.
	 * 
	 * @param simulation
	 * @return Map with node and level
	 */
	@SuppressWarnings("boxing")
	private Map<Node, Integer> getNodeLevels(ISimulation simulation) {
		Map<Node, Integer> result = new HashMap<Node, Integer>();
		final Graph graph = simulation.getScenario().getCanonicalGraph();
		if (graph != null) {
			final EMap<URI,Node> allNodes = graph.getNodes();
			final Set<URI> allGraphURIs = allNodes.keySet();
		    Iterator<URI> graphIter2 = allGraphURIs.iterator();
		  
		    while((graphIter2!=null)&&(graphIter2.hasNext())) {
		    	URI uri = graphIter2.next();
		    	Node node = allNodes.get(uri);
		    	// Bug fix. Make sure the node has labels
		    	if(node.getLabels().size() == 0) continue;
		    	String id =  node.getURI().toString();
		    	int level = getAdminLevel(id);
		    	result.put(node, level);
		    }
		} // graph not null
		return result;
	}
	
	private int getAdminLevel(String uriKey) {
		int retVal = 0;
		String test = uriKey;
		while(test.contains("-")) {
			retVal ++;
			int idx1 = test.indexOf("-");
			String test2 = test.substring(idx1+1, test.length());
			test = test2;
		}
		return retVal;
	}

	/**
	 *
	 */
	public void close() {
		if (logWriter != null) {
			logWriter.flushLoggerData();
		}
		if (logWriter != null) {
			logWriter.closeLoggerData();
		}
		this.logWriter = null;

		if (simulation != null) {
			// Yes
			simulation.removeSimulationListenerSync(this);
		} // if
	}
}

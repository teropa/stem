// LoggerControl
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListenerSync;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * LoggerControl is a subclass of Canvas suitable for chart drawings.
 */
abstract public class LoggerControl extends Composite implements
		ISimulationListenerSync, ISelectionProvider {

	protected RelativeValueProviderAdapter rvp;
	protected Label simulationNameLabel;
	
	/**
	 * The {@link Simulation} for the 
	 */
	protected ISimulation simulation = null;
	
	/**
	 * The {@link DiseaseModel} for the logged data 
	 */
	
	protected DiseaseModel diseaseModel = null;
	
	protected Map<Node, Integer> nodeLevels;
	
	

	/**
	 * The collection of ISelectionChangedListener waiting to be told about
	 * selections.
	 */
	protected final List<ISelectionChangedListener> listeners = new CopyOnWriteArrayList<ISelectionChangedListener>();

	/**
	 * The collection of ISelectionChangedListener waiting to be told about
	 * selections.
	 */
	protected final List<IRemoveListener> removeListeners = new CopyOnWriteArrayList<IRemoveListener>();

	/**
	 * The <code>Identifiable</code> that was most recently selected, or
	 * <code>null</code> if none has been selected.
	 */
	ISelection selection = null;

	/**
	 * The width of the layout margin.
	 */
	protected static final int MARGIN_WIDTH = 5;

	/**
	 * The height of the layout margin.
	 */
	protected static final int MARGIN_HEIGHT = 5;

	/**
	 * @param parent
	 * @param style
	 */
	public LoggerControl(final Composite parent, final int style) {
		super(parent, style);

		this.addDisposeListener(new DisposeListener() {
			/**
			 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
			 */
			public void widgetDisposed(@SuppressWarnings("unused")
			final DisposeEvent e) {
				dispose();
			}
		});

		final FormLayout layout = new FormLayout();
		layout.marginHeight = MARGIN_HEIGHT;
		layout.marginWidth = MARGIN_WIDTH;
		setLayout(layout);

	} // LoggerControl

	/**
	 * @param parent
	 *            the parent SWT control that this composite will be a child of
	 * @return the SWT Composite to be displayed above the MapCanvas in the
	 *         control
	 */
	protected Composite createTopComposite(final Composite parent) {
		//final Composite topComposite = new Composite(parent, SWT.NONE);

		
		
		return parent;
	} // createTopComposite

	
	
	/**
	 * All controllers must implement this 
	 * to remove the control e.g. by a remove button event
	 */
	public abstract void remove() ;
	
	/**
	 * 
	 * @param listener
	 */
	public void addIRemoveListener(IRemoveListener listener) {
		removeListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public void removeIRemoveListener(IRemoveListener listener) {
		removeListeners.remove(listener);
	}
	
	/**
	 * 
	 * @param ident
	 */
	public void fireRemoveEvent(Identifiable ident) {
		for (final IRemoveListener listener : removeListeners) {
			listener.identifiableRemoved(ident);
		} // for each ISelectionChangedListener
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
		selection = null;
		// Was there a new simulation to switch to?
		if (this.simulation != null) {
			// Yes
			this.simulation.addSimulationListenerSync(this);
			initializeFromSimulation(this.simulation);
		} else {
			// No
			// Just display a blank screen
			initializeFromSimulation(null);
		}

		refresh2();
	} // setSimulation

	/**
	 * setDiseaseModel Set the disease model for the logger
	 *
	 *@param dm The disease model
	 */
	
	public void setDiseaseModel(DiseaseModel dm) {
		this.diseaseModel = dm;
	}
	/**
	 * 
	 * @param simulation
	 */
	protected abstract void initializeFromSimulation(
			final ISimulation simulation);

	/**
	 * 
	 */
	protected abstract void refresh2();

	/**
	 * @return the selection
	 */
	public final ISelection getSelection() {
		return selection;
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(final ISelection selection) {
		this.selection = selection;
		fireSelection(selection);
	}

	/**
	 * 
	 * @param identifiable
	 * @param sim 
	 */
	//public abstract void setIdentifiable(Identifiable identifiable, ISimulation sim);
	
	/**
	 * Returns the Identifiable being displayed
	 * 
	 * @return The identifiable to be monitored
	 * 
	 */
	//public abstract Identifiable getIdentifiable();

	/**
	 * Pass a {@link SelectionChangedEvent} along to listeners.
	 * 
	 * @param selection
	 *            the {@link ISelection} to be giving to the listeners.
	 */
	public void fireSelection(final ISelection selection) {

		final SelectionChangedEvent event = new SelectionChangedEvent(this,
				selection);
		for (final ISelectionChangedListener listener : listeners) {
			listener.selectionChanged(event);
		} // for each ISelectionChangedListener

	} // fireSelection

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void addSelectionChangedListener(
			final ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(
			final ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Return all nodes and their corresponding level. We use this to log data using 
	 * different resolutions.
	 * 
	 * @param simulation
	 * @return Map with node and level
	 */
	
	@SuppressWarnings("boxing")
	public Map<Node, Integer> getNodeLevels(ISimulation simulation) {
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
} // LoggerControl

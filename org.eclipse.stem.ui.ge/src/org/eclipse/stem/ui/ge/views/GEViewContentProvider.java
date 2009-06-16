package org.eclipse.stem.ui.ge.views;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListener;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;
import org.eclipse.stem.ui.ge.GEInterface;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.stem.ui.views.geographic.map.GeographicSelectionElements;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

/************ GEViewContentProvider ***********/
/*
 * The content provider class is responsible for
 * providing objects to the view. It can wrap
 * existing objects in adapters or simply return
 * objects as-is. These objects may be sensitive
 * to the current input of the view, or ignore
 * it and always show the same content 
 * (like Task List, for example).
 */
 
public class GEViewContentProvider 
      implements IStructuredContentProvider, 
      ISimulationManagerListener, ISelectionChangedListener,
      ISelectionListener {
	
	/**
	 * A ListViewer that will list simulations that we 
	 * can watch. 
	 */
	private ListViewer viewer;
	/**
	 * This is the selected Simulation which will be used 
	 * for actions in the context menu.
	 */
	private ISimulation currentSimulation = null;
	private SimulationManager simulationManager = null;
	/**
	 * the interface to the rest of GE interface code
	 */
	private GEInterface gei = null;
	/** 
	 *  constructor
	 *
	 * @param gei  Reference to the GE Interface object.
	 */
	public GEViewContentProvider(GEInterface gei) {
		this.gei = gei;
	}
	
	/**
	 * This is given control when the input parent changes.
	 * In our case, SimulationManager is the parent(Model) 
	 * and it never changes after the initial startup. 
	 * @param v  Viewer reporting change
	 * @param oldInput  old SimulationManager or null
	 * @param newInput  new input source(new SimulationManager)
	 */
	
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		GELog.debug(this,"inputChanged: old="+oldInput+" new="+newInput);
        this.viewer = (ListViewer)v;
		if (oldInput != null) {
			// Yes
			((SimulationManager)oldInput).removeListener(this);
		}
		simulationManager = (SimulationManager) newInput;

		// Do we have a new simulation manager to listen to?
		if (simulationManager != null) {
			// Yes
			simulationManager.addSimulationManagerListener(this);
		}
		viewer.addSelectionChangedListener(this);
		
		//  register new input model
	}
	
	/**
	 * Cleanup when user wants to terminate the view
	 */
	public void dispose() {
		GELog.debug(this.getClass(),"dispose(): ");
		if (simulationManager != null)
		  simulationManager.removeListener(this);
		if (viewer != null)
		  viewer.removeSelectionChangedListener(this);
	}
	/**
	 * Provide the data that will be displayed in a list
	 * 
	 * @param parent  Set to refer to the SimulationManager singleton
	 */
	public Object[] getElements(Object parent) {
		//GELog.debug(this,"parent="+parent);
		SimulationManager sm = (SimulationManager)parent;
		List<ISimulation> simulations = sm.getActiveSimulations();
		int n = simulations.size();
		Object[] returnArray = new Object[n];
		for (int i=0;i<n;i++) {
			ISimulation simulation = simulations.get(i);
			//String name =simulation.getName();
			//Scenario scenario = simulation.getScenario();
			
			//GELog.debug(this,""+i+" "+name);
			returnArray[i] = simulation;				
		}
		// if only one simulation - assume selected
		if (n==1 && currentSimulation == null)
			currentSimulation = simulations.get(0);
		
		return returnArray;
	}
	
	/**
	 * We get here because we are listening for SimulationChanged 
	 * events and one occured. 
	 * 
	 * @see org.eclipse.stem.jobs.simulation.ISimulationManagerListener#simulationsChanged(org.eclipse.stem.jobs.simulation.SimulationManagerEvent)
	 */
	public void simulationsChanged(SimulationManagerEvent event) {
		GELog.debug(this.getClass(),"simulationsChange: ");


		viewer.remove(event.getSimulationsRemoved());
		viewer.add(event.getSimulationsAdded());
		if (this.currentSimulation == null && 
				event.getSimulationsAdded().length > 0)  {
			currentSimulation = event.getSimulationsAdded()[0];
			GELog.debug(this,"currentSimulation: "+
					currentSimulation.getName());
		} 
		if (this.currentSimulation != null &&  
				event.getSimulationsRemoved().length > 0)  {
			for(ISimulation sim:event.getSimulationsRemoved()) {
			    if (currentSimulation == sim) {
			    	currentSimulation = null;
			        GELog.debug(this,"currentSimulation is now null ");
			    }
	    	}			
		} 
	}	 // simulationsChanged
	/**
	 * This method is called whenever ANYTHING is selected in the Eclipse
	 * workbench. It's job is to filter out selections of ISimulation
	 * instances see if it is one we are waiting for
	 * 
     * required method for ISelectionListener  
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection select) {
		if (! (select instanceof StructuredSelection) ) 
			return;	
		// Verify if we are interested in this selection event
		Object[] elements = ((StructuredSelection)select).toArray();
		if ( (elements.length != 2) || 
		   (! (elements[1] instanceof GeographicSelectionElements))) {  
				return;
		}
		RegionImpl region = (RegionImpl)elements[0];
		GeographicSelectionElements gse = 
			(GeographicSelectionElements)elements[1];		
		
		// if we get here it is a map selection by somebody
		GELog.debug(this,"MapView Selection: "+region);
		gei.displaySelection(region,gse);
	}
	
	/**
	 * This method is called whenever ANYTHING is selected in the viewer.
	 * It's job is to filter out selections of ISimulation
	 * instances and mark the Simulation that we want to interface to.
	 * 
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		GELog.debug(this,"selectionChange: "+event);
		// Is this selection changed event coming from our view?
		if (event.getSource() == viewer) {
			ISelection selection = event.getSelection();
			// This will hold the new simulations that have been selected
			final List<ISimulation> temp = new ArrayList<ISimulation>();

			// Is it a structured selection?
			if (event.getSelection() instanceof IStructuredSelection) {
				// Yes
				final List list = ((IStructuredSelection) selection)
						.toList();

				// Go through everything in the list of things that were
				// selected and pick out the ones that are ISimulations.
				for (final Iterator selectionIter = list.iterator(); selectionIter
						.hasNext();) {
					final Object obj = selectionIter.next();
					if (obj instanceof ISimulation) {
						temp.add((ISimulation) obj);
						//GEView.log(this.getClass(),obj.toString());
					}
				} // for each selected item
			} // if structured selection

			// Did we find any new simulations that were selected?
			if (temp.size() > 0) {
				// Yes Use the 1st one 
				//ISimulation old = currentSimulation;
				currentSimulation = temp.get(0);
				//GELog.debug(this.getClass(),"Selected="+currentSimulation.toString());
				GEViewLabelProvider lp =(GEViewLabelProvider)viewer.getLabelProvider();
				
				lp.setSelected(currentSimulation);
			} // if any new simulations selected
		} // if selection changed event coming from our view?
	} // selectionChanged

	/**
	 * supply the currently selected simulation  (if any)
	 * GEView does not save the current Simulation that 
	 * was selected by the user.  This method is used to get it.
	 * 
	 * @return the currentSimulation
	 */
	public ISimulation getCurrentSimulation() {
		return currentSimulation;
	}

	

}

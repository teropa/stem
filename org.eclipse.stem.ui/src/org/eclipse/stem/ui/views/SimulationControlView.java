package org.eclipse.stem.ui.views;

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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListener;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.ISharedImages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

/**
 * This class implements an eclipse view that displays the state of the
 * currently active simulations and GUI controls that allow the simulations to
 * be managed.
 * 
 */
public class SimulationControlView extends ViewPart implements
		ISimulationManagerListener {

	/**
	 * Our reference to the simulation manager
	 */
	private SimulationManager simulationManager = null;

	/**
	 * The collection of simulation controls
	 */
	private List<SimulationControl> controlList = new ArrayList<SimulationControl>();

	/**
	 * The identifier of the Simulation Control View
	 */
	public static final String ID_SIMULATION_CONTROL_VIEW = "org.eclipse.stem.ui.views.simulationcontrolview"; //$NON-NLS-1$

	// The scrolled composite -- allows control composite to scroll
	private ScrolledComposite scrollComposite = null;

	// The control composite -- holds the controls
	private Composite controlComposite = null;

	// Actions for master simulation control
	Action runAction, resetAction, pauseAction, stepAction, stopAction;

	// Used by a part to access its menu, tool bar, and status line managers.
	IActionBars actionBars = null;

	// Menu manager for this view
	IMenuManager dropDownMenu = null;

	// Tool bar manager for this view
	IToolBarManager toolBar = null;

	// Some constants we need to set preferred sizes of SWT controls
	private static final int SCROLL_MIN_LENGTH = 100;

	private static final int SCROLL_MIN_HEIGTH = 1600;

	/**
	 * Constructor
	 * 
	 */
	public SimulationControlView() {
		super();
		// Set our reference to the simulation manager
		simulationManager = SimulationManager.getManager();
		simulationManager.addSimulationManagerListener(this);
	}

	/**
	 * This is the method where the view is put together piece by piece
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		final int COLUMNS = 1;

		scrollComposite = new ScrolledComposite(parent, SWT.V_SCROLL
				| SWT.BORDER);
		scrollComposite.setExpandHorizontal(true);
		scrollComposite.setExpandVertical(true);
		scrollComposite.setMinSize(SCROLL_MIN_LENGTH, SCROLL_MIN_HEIGTH);
		scrollComposite.setLayout(new GridLayout());
		controlComposite = new Composite(scrollComposite, SWT.NONE);
		scrollComposite.setContent(controlComposite);
		// setup the layout
		GridData data = new GridData(GridData.FILL_BOTH);
		controlComposite.setLayoutData(data);
		GridLayout layout = new GridLayout();
		layout.numColumns = COLUMNS;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		controlComposite.setLayout(layout);
		

		// Create the actions for master simulation control
		runAction = new Action(
				Messages.getString("SCView.Run"), ImageDescriptor.createFromImage(Activator //$NON-NLS-1$
								.getDefault().getImageRegistry().get(
										ISharedImages.RUN_ICON))) {
			public void run() {
				masterRunAction();
			}
		};

		pauseAction = new Action(
				Messages.getString("SCView.Pause"), ImageDescriptor //$NON-NLS-1$
						.createFromImage(Activator.getDefault()
								.getImageRegistry().get(
										ISharedImages.PAUSE_ICON))) {
			public void run() {
				masterPauseAction();
			}
		};

		resetAction = new Action(
				Messages.getString("SCView.Reset"), ImageDescriptor //$NON-NLS-1$
						.createFromImage(Activator.getDefault()
								.getImageRegistry().get(
										ISharedImages.RESET_ICON))) {
			public void run() {
				masterResetAction();
			}
		};

		stepAction = new Action(
				Messages.getString("SCView.Step"), ImageDescriptor //$NON-NLS-1$
						.createFromImage(Activator.getDefault()
								.getImageRegistry()
								.get(ISharedImages.STEP_ICON))) {
			public void run() {
				masterStepAction();
			}
		};

		stopAction = new Action(
				Messages.getString("SCView.Stop"), ImageDescriptor //$NON-NLS-1$
						.createFromImage(Activator.getDefault()
								.getImageRegistry()
								.get(ISharedImages.STOP_ICON))) {
			public void run() {
				masterStopAction();
			}
		};

		// Set disabled icons for our master control

		runAction.setDisabledImageDescriptor(ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(
						ISharedImages.DISABLED_RUN_ICON)));

		pauseAction.setDisabledImageDescriptor(ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(
						ISharedImages.DISABLED_PAUSE_ICON)));

		resetAction.setDisabledImageDescriptor(ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(
						ISharedImages.DISABLED_RESET_ICON)));

		stepAction.setDisabledImageDescriptor(ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(
						ISharedImages.DISABLED_STEP_ICON)));

		stopAction.setDisabledImageDescriptor(ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(
						ISharedImages.DISABLED_STOP_ICON)));

		// Initial state if master control should be DISABLED
		runAction.setEnabled(false);
		pauseAction.setEnabled(false);
		resetAction.setEnabled(false);
		stepAction.setEnabled(false);
		stopAction.setEnabled(false);

		// get the action manager for this view
		actionBars = getViewSite().getActionBars();

		// get the drop down menu manager for this view
		dropDownMenu = actionBars.getMenuManager();

		// get the tool bar manager for this view
		toolBar = actionBars.getToolBarManager();

		// Add all actions to drop down menu on the right corner of this view
		dropDownMenu.add(runAction);
		dropDownMenu.add(pauseAction);
		dropDownMenu.add(resetAction);
		dropDownMenu.add(stepAction);
		dropDownMenu.add(stopAction);

		// Add all actions to the tool bar of this view
		toolBar.add(runAction);
		toolBar.add(pauseAction);
		toolBar.add(resetAction);
		toolBar.add(stepAction);
		toolBar.add(stopAction);

		// if any active Simulations, use them
		List<ISimulation>list = simulationManager.getActiveSimulations();
		
		for (ISimulation sim: list) {
			addSimulation(sim);		
		}
	}

	/**
	 * Enable use of master control for active simulations
	 * 
	 * @param enabled
	 */
	protected void enableMasterControl(boolean enabled) {
		// Initial state if master control should be DISABLED
		runAction.setEnabled(enabled);
		pauseAction.setEnabled(enabled);
		resetAction.setEnabled(enabled);
		stepAction.setEnabled(enabled);
		stopAction.setEnabled(enabled);
	}

	// Run all simulations -- set state of all simulations to RUNNING
	protected void masterRunAction() {
		Iterator iter = controlList.iterator();
		while (iter.hasNext()) {
			SimulationControl simulationControl = (SimulationControl) iter
					.next();
			simulationControl.run();
		}
	}

	// Pause all simulations -- set state of all simulations to PAUSED
	protected void masterPauseAction() {
		Iterator iter = controlList.iterator();
		while (iter.hasNext()) {
			SimulationControl simulationControl = (SimulationControl) iter
					.next();
			simulationControl.pause();
		}
	}

	// Reset all simulations -- set state of all simulations to RESET
	protected void masterResetAction() {
		Iterator iter = controlList.iterator();
		while (iter.hasNext()) {
			SimulationControl simulationControl = (SimulationControl) iter
					.next();
			simulationControl.reset();
		}
	}

	// Step all simulations -- step in all simulations
	protected void masterStepAction() {
		Iterator iter = controlList.iterator();
		while (iter.hasNext()) {
			SimulationControl simulationControl = (SimulationControl) iter
					.next();
			simulationControl.step();
		}
	}

	// Stop all simulations
	protected void masterStopAction() {
		Iterator iter = controlList.iterator();
		while (iter.hasNext()) {
			SimulationControl simulationControl = (SimulationControl) iter
					.next();
			simulationControl.stop();
		}
	}

	/**
	 * 
	 * @return the list of simulation controls
	 */
	public List<SimulationControl> getSimulationControlList() {
		return controlList;
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// Nothing
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {

		// Are we listening to the simulation manager?
		if (simulationManager != null) {
			// Yes
			// Not any more
			simulationManager.removeListener(this);
		}

		if (controlList.isEmpty() == false) {
			Iterator iter = controlList.listIterator();
			while (iter.hasNext()) {
				SimulationControl sctrl = (SimulationControl)iter.next();
				sctrl.dispose();
				iter.remove();
			}
		}

	} // dispose

	/**
	 * A simulation has been started or stopped.
	 * We have registered for SimulationManager.addListener() and 
	 * so we are informed when a simulation is started and when
	 * one is stopped. 
	 * 
	 * @see org.eclipse.stem.jobs.simulation.ISimulationManagerListener#simulationsChanged(org.eclipse.stem.jobs.simulation.SimulationManagerEvent)
	 */
	public void simulationsChanged(SimulationManagerEvent event) {

		ISimulation[] simulations = null;

		// add a simulation control for each new simulation...
		simulations = event.getSimulationsAdded();
		for (int i = 0; i < simulations.length; i++) {
			addSimulation(simulations[i]);		
		}

		// remove the corresponding simulation control for all stopped
		// simulations...
		simulations = event.getSimulationsRemoved();
		for (int i = 0; i < simulations.length; i++) {
			removeSimulation(simulations[i]);			
		}

		
		scrollComposite.setContent(controlComposite);
		controlComposite.layout(true);
		scrollComposite.layout(true);

		
		//controlComposite.redraw();
		scrollComposite.redraw();
		
		// Refresh our reference to the simulation manager
//		simulationManager = SimulationManager.getManager();
//		simulationManager.addSimulationManagerListener(this);

	}

	/**
	 * add a simulation control panel 
	 * for an added or existing ISimulation 
	 * 
	 * @param sim  Instance of ISimulation
	 */
	private void addSimulation(ISimulation sim) {
		controlComposite.setRedraw(true);
		scrollComposite.setRedraw(true);
		SimulationControl simulationControl = 
			new SimulationControl(controlComposite, sim);
		controlComposite.addControlListener(simulationControl);
		controlList.add(simulationControl);
		if (controlList.size() > 0) {
			enableMasterControl(true);
		} 
		
		controlComposite.layout(true);
		scrollComposite.layout(true);
		
		scrollComposite.redraw();		
	}
	
	/**
	 * remove a simulation control panel 
	 * for an added or existing ISimulation 
	 * 
	 * @param sim  Instance of ISimulation
	 */
	private void removeSimulation(ISimulation simulation) {
		controlComposite.setRedraw(true);
		scrollComposite.setRedraw(true);
				
		Control[] ctrls = controlComposite.getChildren();

		for (int j = 0; j < ctrls.length; j++) {
			SimulationControl simulationControl = (SimulationControl) ctrls[j];
			if (simulation.equals(simulationControl.getSimulation())) {
				controlComposite.removeControlListener(simulationControl);
				controlList.remove(simulationControl);
				// Create a temporary composite
				Composite tempComposite = new Composite(scrollComposite,
						SWT.NONE);
				// Set the temporary composite to be the parent of the
				// control we want to remove :
				simulationControl.setParent(tempComposite);
				// Now get rid of the temporary composite and its children
				tempComposite.dispose();
				simulationControl.dispose();
				break;
			}
		}

		if (controlList.size() == 0) {			
			enableMasterControl(false);
		}
		
		controlComposite.layout(true);
		scrollComposite.layout(true);
		
		scrollComposite.redraw();		
	}
}

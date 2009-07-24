// LoggerViewer.java
package org.eclipse.stem.util.loggers.views;

/*******************************************************************************
 * Copyright (c) 2007,2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListenerSync;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;
import org.eclipse.stem.ui.views.geographic.map.MapControl;
import org.eclipse.stem.util.loggers.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * This class presents "views" of the running simulations.
 */
public class LoggerViewer extends Viewer implements ISelectionChangedListener,
		ISimulationManagerListenerSync {

	/**
	 * This is the collection of Identifiables to display (nodes for now)
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s that should be
	 * displayed.
	 */
	//private final Set<Identifiable> identifiablesToDisplay = new LinkedHashSet<Identifiable>();
    private static final Map<ISimulation,Set<Identifiable>> identifiablesToDisplayMap = new HashMap<ISimulation,Set<Identifiable>>();
    
    private static final Collection<ISimulation> simulationsToLog = new ArrayList<ISimulation>();
    
    
	/**
	 * This is the {@link SimulationManager} that is the input to the viewer. It
	 * maintains a collection of active
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s in the system.
	 * This viewer listens to it to discover when new
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s are created and
	 * old ones disappear.
	 * 
	 * @see #simulationsChanged(SimulationManagerEvent)
	 */
	SimulationManager simulationManager;

	/**
	 * The <code>Identifiable</code> that was most recently selected by a user
	 * clicking on one of the {@link MapControl}s, or <code>null</code> if
	 * none has been selected.
	 */
	private ISelection selection = null;

	/**
	 * This is the top-level control of the viewer. It contains the
	 * {@link MapControl}s that display the current state of the
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s.
	 */
	final Composite composite;
	
	/**
	 * This is a top-level scrolled container for the control of the viewer. It contains the
	 */
	ScrolledComposite scrolledComposite;
	
	/**
	 * the outermost container.
	 */
	Composite outerComposite;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT_MIN = 250;
	private static final int BUTTON_HEIGHT = 25;
	
	/**
	 * button to add All locations in a running simulation
	 */
	protected Button loggerOnButton = null;
	/**
	 * button to remove All locations in a running simulation
	 */
	protected Button loggerOffButton = null;
	
	protected static Color onColor = null;
	protected static Color offColor = null;
	
	
	
	/**
	 * 
	 */
	protected static Label statusLabel = null;
	
	/**
	 * remember the state of the logger
	 */
	protected static boolean loggingOn = false;
	
	/**
	 * button text
	 */
	protected static final String ON_TEXT = "ON";
	
	/**
	 * button text
	 */
	protected static final String OFF_TEXT = "OFF";
	
	/**
	 * status text
	 */
	protected static final String MONITOR_ON_TEXT = "MONITOR ON";
	
	/**
	 * status text
	 */
	protected static final String MONITOR_OFF_TEXT = "MONITOR OFF";


	/**
	 * the users preferences are stored in DialogSettings
	 */
	private DialogSettings masterSettings = null;

	/**
	 * Set of Preferred Locations to monitor read from the DialogSettings
	 */
	private final Set monitorSet = new HashSet();

	/**
	 * root key element for the DialogSettings xml file
	 */
	private static final String ROOT_KEY = "root";

	/**
	 * Constants for saving ReportViewPreferences
	 */
	public static final String REPORTVIEWPREFERENCES_FILENAME = "Preferences.txt";
	
	/**
	 * divides the experiments summary from the specific  modificatoin list in the header
	 */
	public static final String MODIFICATIONS_TEXT = "@ ==  Modifications ==";

	/**
	 * Constants node note found error
	 */
	public static final String NODE_NOT_FOUND = "NODENOTFOUND";

	/**
	 * TODO JFK
	 */
	public static final String LOCATION_PREFERENCE_KEY = "location.ids";

	private static final IPath PATH = Activator.getDefault().getStateLocation();
	
	/**
	 * The logger headers
	 */
	static Label loggerModeHeader;
	static Label loggerScenarioHeader;
	static Label loggerDiseaseHeader;
	
	

	/**
	 * This factory is used to create instances of {@link LoggerControl} in the
	 * method {@link #populateView()}
	 */
	private final LoggerControlFactory lcf;

	/**
	 * @param parent
	 *            the SWT parent of the control that makes up the viewer
	 * @param lcf
	 *            the factory that creates instance of {@link LoggerControl}
	 */
	public LoggerViewer(final Composite parent, final LoggerControlFactory lcf) {
        
       
		outerComposite = new Composite(parent, SWT.BORDER);
		final FormData outerFormData = new FormData();
		FormLayout outerLayout = new FormLayout();
		outerLayout.marginHeight = 5;
		outerLayout.marginWidth = 5;
		outerComposite.setLayout(outerLayout);
		outerComposite.setLayoutData(outerFormData);
		
		// top composite holds the buttons
		//
		Composite top = addAllActionButtons(outerComposite);	
		//
		final FormData topFormData = new FormData();
		top.setLayoutData(topFormData);
		top.setSize(SWT.DEFAULT, BUTTON_HEIGHT);
		topFormData.left   = new FormAttachment(0, 0);
		topFormData.right  = new FormAttachment(100, 0);
		//topFormData.top   = new FormAttachment(0, 0);
		//don't set the bottom - it's fixed
		
		// bottom composite holds the scroller
		Composite bottom = new Composite(outerComposite, SWT.NONE);
		bottom.setLayout(new FillLayout(SWT.VERTICAL));
		final FormData bottomFormData = new FormData();
		bottom.setLayoutData(bottomFormData);
		bottomFormData.left   = new FormAttachment(0, 0);
		bottomFormData.right  = new FormAttachment(100, 0);
		bottomFormData.top   = new FormAttachment(top, 0, SWT.BOTTOM);
		bottomFormData.bottom  = new FormAttachment(100, 0);
		
		Color color = parent.getDisplay().getSystemColor(SWT.COLOR_RED);
		bottom.setBackground(color);
		
	    // scroller
		scrolledComposite = new ScrolledComposite(bottom, (SWT.BORDER | SWT.H_SCROLL| SWT.V_SCROLL));
		final FillLayout scrolledLayout = new FillLayout(SWT.VERTICAL);
		scrolledComposite.setLayout(scrolledLayout);
		scrolledComposite.setExpandHorizontal(true);
	
		scrolledComposite.setExpandVertical(false);
	
		scrolledComposite.setMinSize(SWT.DEFAULT,HEIGHT_MIN);
		scrolledComposite.setSize(SWT.DEFAULT,HEIGHT_MIN);
		
		// composite holds all the monitor objects stacked vertically
		composite = new Composite(scrolledComposite, SWT.NONE);
		final FillLayout compositeLayout = new FillLayout(SWT.VERTICAL);
		composite.setLayout(compositeLayout);
		// add to the scroller
		scrolledComposite.setContent(composite);
		
		// Remember the factory that we'll use to create instances of
		// LoggerControl
		this.lcf = lcf;
		refresh();
		composite.pack();
		LogWriter.reset();
	
	} // LoggerViewer

	/**
	 *  add the removeAll and addAll ActionButtons
	 */
	private Composite addAllActionButtons(Composite parent) {
	
		Composite top = new Composite(parent, SWT.NONE);
		//FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);
		
		FormLayout topLayout = new FormLayout();
		//FillLayout topLayout = new FillLayout(SWT.HORIZONTAL);
		topLayout.marginHeight = 5;
		topLayout.marginWidth = 5;
	    top.setLayout(topLayout);
	    top.setSize(SWT.DEFAULT, BUTTON_HEIGHT);
	    //Color color = parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);
	    final Color bgColor = new Color(parent.getDisplay(), new RGB(170, 170, 190));
		onColor = parent.getDisplay().getSystemColor(SWT.COLOR_GREEN);
		offColor = parent.getDisplay().getSystemColor(SWT.COLOR_DARK_RED);
	    top.setBackground(bgColor);
	    
	    int buttonWidth = (int)(0.3 * WIDTH);
	    int titleWidth = (int)(0.4 * WIDTH);
	    
	    // TITLE
	    statusLabel = new Label(top,  SWT.BORDER);//	do a statusLabel
		statusLabel.setText(MONITOR_OFF_TEXT);
		statusLabel.setAlignment(SWT.CENTER);
		statusLabel.setSize(titleWidth,BUTTON_HEIGHT);
		statusLabel.setText(MONITOR_OFF_TEXT);
		statusLabel.setBackground(offColor);
		
		// BUTTONS
	    loggerOnButton    = new Button(top, SWT.TOGGLE);
	    loggerOffButton = new Button(top, SWT.TOGGLE);
		loggerOnButton.setText(ON_TEXT);
		loggerOffButton.setText(OFF_TEXT);
		loggerOnButton.setSize(buttonWidth,BUTTON_HEIGHT);
		loggerOffButton.setSize(buttonWidth,BUTTON_HEIGHT);
		// init the toggle position - off at start
		loggerOnButton.setSelection(false);
		loggerOffButton.setSelection(true);// off at start
		///////
		
		
		// remove everything
		// TODO probably want a dialog to confirm this action...
		loggerOffButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			final SelectionEvent e) {
				disableLogging();
			}
		});
		
		// add everything
		// TODO probably want a dialog to confirm this action...
		loggerOnButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			final SelectionEvent e) {
				ISimulation [] simulations = null;
				List<ISimulation> activesims = simulationManager.getActiveSimulations();
				if(activesims != null) {
					simulations = new ISimulation [activesims.size()];
					for(int i=0;i<activesims.size();++i) simulations[i] = activesims.get(i);
				}
				enableLogging(simulations);
			}
		});
		
		
		// statusLabel Form
		final FormData statusLabelFormData = new FormData();
		statusLabel.setLayoutData(statusLabelFormData);
		statusLabelFormData.left  = new FormAttachment(0, 0);
		statusLabelFormData.right = new FormAttachment(40, 0);
		statusLabelFormData.top   = new FormAttachment(0, 0);
		statusLabelFormData.bottom   = new FormAttachment(0, 25);
		top.setLayoutData(statusLabelFormData);
		
		// Button Form
	    final FormData addButtonFormData = new FormData();
	    addButtonFormData.left  = new FormAttachment(40, 0);
	    addButtonFormData.right = new FormAttachment(70, 0);
	    addButtonFormData.top   = new FormAttachment(0, 0);
	    addButtonFormData.bottom   = new FormAttachment(0, 25);
	    loggerOnButton.setLayoutData(addButtonFormData);
	    // Button Form
		final FormData removeButtonFormData = new FormData();
	    removeButtonFormData.left = new FormAttachment(70, 0);
	    removeButtonFormData.right = new FormAttachment(100, 0);
	    removeButtonFormData.top = new FormAttachment(0, 0);
	    removeButtonFormData.bottom   = new FormAttachment(0, 25);
	    loggerOffButton.setLayoutData(removeButtonFormData);
	    
	    // HEADER LABELS
	    
	    if(loggerModeHeader==null) {
			loggerModeHeader = new Label(top, SWT.BORDER);
			//loggerModeHeader.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
			loggerModeHeader.setText("Mode");
			loggerModeHeader.setAlignment(SWT.CENTER);
			
			loggerScenarioHeader = new Label(top, SWT.BORDER);
			//loggerScenarioHeader.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
			loggerScenarioHeader.setText("Scenario");
			loggerScenarioHeader.setAlignment(SWT.CENTER);
			
			loggerDiseaseHeader = new Label(top, SWT.BORDER);
			//loggerDiseaseHeader.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
			loggerDiseaseHeader.setText("Disease");
			loggerDiseaseHeader.setAlignment(SWT.CENTER);
			
			// Logger Name Label
			final FormData loggerModeFormData = new FormData();
			loggerModeFormData.top = new FormAttachment(0, 30);
			loggerModeFormData.bottom = new FormAttachment(0, 50);
			loggerModeFormData.left = new FormAttachment(0, 0);
			loggerModeFormData.right = new FormAttachment(25, 0);	
			loggerModeHeader.setLayoutData(loggerModeFormData);
			
			final FormData loggerScenarioFormData = new FormData();
			loggerScenarioFormData.top = new FormAttachment(0, 30);
			loggerScenarioFormData.bottom = new FormAttachment(0, 50);
			loggerScenarioFormData.left = new FormAttachment(25, 0);
			loggerScenarioFormData.right = new FormAttachment(50, 0);	
			loggerScenarioHeader.setLayoutData(loggerScenarioFormData);
			
			final FormData loggerDiseaseFormData = new FormData();
			loggerDiseaseFormData.top = new FormAttachment(0, 30);
			loggerDiseaseFormData.bottom = new FormAttachment(0, 50);
			loggerDiseaseFormData.left = new FormAttachment(50, 0);
			loggerDiseaseFormData.right = new FormAttachment(90, 0);	
			loggerDiseaseHeader.setLayoutData(loggerDiseaseFormData);
		}
	    
        
	    
		return top;	 
		
	} // addAllActionButtons

	/**
	 * @see org.eclipse.jface.viewers.Viewer#getControl()
	 */
	@Override
	public Control getControl() {
		return composite;
	} // getControl

	/**
	 * @see org.eclipse.jface.viewers.Viewer#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		return selection;
	}

	/**
	 * @see org.eclipse.jface.viewers.Viewer#refresh()
	 */
	@Override
	public void refresh() {
		
		if (simulationManager != null) {
			// Yes	
			List allSimulations = null;
			updatePreferenceState(simulationManager.getActiveSimulations());
			if (simulationManager != null) {
					allSimulations = simulationManager.getActiveSimulations();
					addToDisplayedIdentifiableSet(allSimulations);
			}
				
			identifiablesToDisplayMap.clear();
			addAllIdentifiablesBySimulation(simulationManager.getActiveSimulations());
		} // if
			
	} // refresh

	/**
	 * Start logging
	 * 
	 * @param newSimulations New simulations added by the simulation manager
	 */
	public void enableLogging(ISimulation [] newSimulations) {
		synchronized(this) {		
			for (int i = 0; i < newSimulations.length; i++) {
				final ISimulation simulation = newSimulations[i];
				// Stefan new code:
				if(!simulationsToLog.contains(simulation)) {
					simulationsToLog.add(simulation);
					populateView(newSimulations);
				}
			}// for all simulations
		
			statusLabel.setText(MONITOR_ON_TEXT);
			statusLabel.setBackground(onColor);
			loggingOn = true;
			// and toggle the buttons
			loggerOnButton.setSelection(true);
			loggerOffButton.setSelection(false);
		}//synchronized() 

	} // enableLogging

	
	/**
	 * Stop logging
	 * 
	 */
	public void disableLogging() {
		simulationsToLog.clear();
		// remove all controls
		final Control[] allControls = composite.getChildren();
		for (final Control element : allControls) {
			if(element instanceof LoggerControl) {
				final LoggerControl loggerControl = (LoggerControl) element;
				loggerControl.remove();
			} else element.dispose();
		} // for each LoggerControl
	
		statusLabel.setText(MONITOR_OFF_TEXT);
		statusLabel.setBackground(offColor);
		loggingOn = false;
		// and toggle the buttons
		loggerOnButton.setSelection(false);
		loggerOffButton.setSelection(true);
	} // disableLogging

	/**
	 * @see org.eclipse.jface.viewers.Viewer#getInput()
	 */
	@Override
	public Object getInput() {
		return simulationManager;
	}

	/**
	 * @see org.eclipse.jface.viewers.Viewer#setInput(java.lang.Object)
	 */
	@Override
	public void setInput(final Object input) {
		final Object oldInput = simulationManager;
		simulationManager = (SimulationManager) input;
		inputChanged(input, oldInput);
	} // setInput

	/**
	 * @see org.eclipse.jface.viewers.Viewer#inputChanged(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected void inputChanged(final Object input, final Object oldInput) {
		// Is there already a simulation manager?
		if (oldInput != null) {
			// Yes
			((SimulationManager) oldInput).removeListenerSync(this);
		} // if

		// Register with the SimulationManager to listen for changes in the set
		// of active Simulations.
		// Got input?
		if (input != null) {
			// Yes
			((SimulationManager) input).addSimulationManagerListenerSync(this);
		} // if

		// Update the viewer with the contents of the new input source
		refresh();
	} // inputChanged

	/**
	 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection,
	 *      boolean)
	 */
	@Override
	public void setSelection(final ISelection selection,
			@SuppressWarnings("unused")
			final boolean reveal) {
		this.selection = selection;
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(final SelectionChangedEvent event) {

		// Did the event come from a LoggerControl?
		if (event.getSelectionProvider() instanceof LoggerControl) {
			// Yes
			// Just pass it along
			selection = event.getSelection();
			fireSelectionChanged(event);
		} // if
	} // selectionChanged

	/**
	 * @param event 
	 * @see org.eclipse.stem.jobs.simulation.ISimulationManagerListener#simulationsChanged(SimulationManagerEvent)
	 */
	public void simulationsChangedSync(final SimulationManagerEvent event) {

		// Init the preference
		updatePreferenceState(Arrays.asList(event.getSimulationsAdded()));
        List<ISimulation> newSimulations = Arrays.asList(event.getSimulationsAdded());
		
        addToDisplayedIdentifiableSet(newSimulations);

		removeFromDisplayedSimulationSet(Arrays.asList(event
				.getSimulationsRemoved()));
		
		// logging status
		if(loggingOn) {
			// The following will also call populate view.
			enableLogging(event.getSimulationsAdded());
		} else {
			disableLogging();
		}
	} // simulationsChanged

	/**
	 * @param simulations
	 *            the {@link Simulation}s to add to the set being displayed.
	 */
	private void addToDisplayedIdentifiableSet(
			final List<ISimulation> simulations) {
		
		// new simulation
		LogWriter.reset();
		// Any simulations to add?
		if (!simulations.isEmpty()) {
			
			for(int i = 0; i < simulations.size(); i ++) {
				ISimulation sim = simulations.get(i);
				Set<Identifiable> identifiablesToDisplay = getIdentifiableSet(sim);
				
				identifiablesToDisplay.addAll(getIdentifiablesInSimulation(sim));
				
				identifiablesToDisplayMap.put(sim,identifiablesToDisplay);
				
			}// for all simulations
			
			
			
		} // if any simulations
	} // addToDisplayedSimulationSet

	/**
	 * @param simulations
	 *            the {@link Simulation}s to remove from the set being
	 *            displayed.
	 */
	private void removeFromDisplayedSimulationSet(
			final List<ISimulation> simulations) {
		// Any simulations to remove?
		if (!simulations.isEmpty()) {
			
			for(int i = 0; i < simulations.size(); i ++) {
				ISimulation sim = simulations.get(i);
				
				Set<Identifiable> identifiablesToRemove = getIdentifiableSet(sim);
				cleanup(identifiablesToRemove,sim);
				identifiablesToRemove.clear();
				identifiablesToDisplayMap.remove(sim);
				
			}// for all simulations
			
		} // if
	} // removeFromDisplayedSimulationSet
	
	
	
	
	/**
	 * 
	 * @param simulations
	 * @return
	 */
	Set<Identifiable> getIdentifiablesInSimulation(
			final ISimulation simulation) {
		final Set retVal = new LinkedHashSet<ISimulation>();

		/*
		 * The default monitor locations always contains the works (URIsuffix =
		 * ZZZ, or MonitorPreferences.DEFAULT_LOCATION_ID However, if a scenario
		 * contains only one country then the ZZZ nodes does not exist and the
		 * top level node will be the country code. So here we check that the
		 * ZZZ node exists. If it does not exist we look for three letter
		 * country code(s) and add that (those - but there should be only one)
		 * to the list.
		 */
		final Graph graph = simulation.getScenario().getCanonicalGraph();
		/*
		 * this code was used to avoid a bug that should now be fixed
		 * 
		 * if (graph == null) { System.out.println("graph is null"); // try
		 * several times for (int ii = 0 ; ii < 50; ii ++) { try {
		 * Thread.sleep(100); } catch (Exception e) { // nothing } graph =
		 * simulation.getScenario().getCanonicalGraph(); if (graph != null)
		 * break; }// for 10 trys } //if graph null
		 */

		if (graph != null) {
			// final EMap allNodes = graph.getNodes();
			// final Set allGraphURIs = allNodes.keySet();
			// final URI defaultURI = MonitorPreferences.getDefaultURI();

			final Iterator iter = monitorSet.iterator();
			while ((iter != null) && (iter.hasNext())) {
				final String key = (String) iter.next();
				Identifiable node = null;
				URI locURI = null;
				try {
					locURI = URI.createURI(key);
					node = graph.getNode(locURI);
					if (node != null) {
						retVal.add(node);
					}
				} catch (final Exception e) {
					org.eclipse.stem.util.loggers.Activator.logError(
							"LoggerViewer.getIdentifiablesInSimulation() Error setting Identifiable to "
									+ key + " ", e);
				}
			}// while locations to monitor

		}// graph not null

		return retVal;
	}// getIdentifiablesInSimulation
	
	
	/**
	 * cleans up old displays
	 * 
	 * @param defunctIdentifiables
	 */
	private void cleanup(Set defunctIdentifiables, ISimulation removedSimulation) {
		if(defunctIdentifiables!=null) {
			
			Iterator iter = defunctIdentifiables.iterator();
			while((iter!=null)&&(iter.hasNext())) {
				Identifiable ident = (Identifiable)iter.next();
				if (noOtherSimulationContains(ident,removedSimulation)) monitorSet.remove(ident.getURI().toString());
			} // while
					
				/*final Control[] allControls = composite.getChildren();
				for (final Control element : allControls) {
					final LoggerControl loggerControl = (LoggerControl) element;
					final Identifiable testIdentifiable = loggerControl.getIdentifiable();
					if ((testIdentifiable==null)||(!defunctIdentifiables.contains(testIdentifiable))) {
						// dispose if we know it is the removed simulation
						if(loggerControl.simulation.getSequenceNumber()==removedSimulation.getSequenceNumber()) loggerControl.remove();
					} // if
				} // for each LoggerControl
				*/
		}// if set not null
		
	}// cleanup

	protected void removeIdentifiable(final Identifiable ident) {
		// Any simulations to remove?
		if (ident != null) {
			// Yes
			Iterator iter = identifiablesToDisplayMap.keySet().iterator();
			while ((iter != null) && (iter.hasNext())) {
				ISimulation sim = (ISimulation) iter.next();
				Set<Identifiable> identifiablesToDisplay = identifiablesToDisplayMap
						.get(sim);
				identifiablesToDisplay.remove(ident);
			}
			// preference state has changed
			savePreferenceState();
		} // if
	} // removeFromDisplayedSimulationSet

	
	protected boolean noOtherSimulationContains(final Identifiable ident, final ISimulation removedSim) {
		// Any simulations to remove?
		if (ident != null) {
			// Yes
			Iterator iter = identifiablesToDisplayMap.keySet().iterator();
			while ((iter != null) && (iter.hasNext())) {
				ISimulation sim = (ISimulation) iter.next();
				if (sim.getSequenceNumber()!= removedSim.getSequenceNumber()) {
					Set<Identifiable> identifiablesToDisplay = identifiablesToDisplayMap.get(sim);
				    if (identifiablesToDisplay.contains(ident)) return false;
				}
			}
		} // if
		return true;
	} // removeFromDisplayedSimulationSet

	
	/**
	 * Create and dispose of MapControls as necessary to display the selected
	 * Simulations.
	 */
	protected void populateView(ISimulation [] newSimulations) {

		try {
			// problem here when we start up
			// Are we done?
			if (composite.isDisposed()) {
				// Yes
				return;
			} // if

			selection = null;

			if ((newSimulations != null) && (newSimulations.length >= 1)) {

				synchronized (this) {
					for (int i = 0; i < newSimulations.length; i++) {
						ISimulation sim = newSimulations[i];
					
						String scenarioURL = sim.getScenario().getURI().toString();
						String dirname = Util.getLoggingFolder(scenarioURL);
							
						EList<Decorator> decorators = sim.getScenario().getCanonicalGraph().getDecorators();
						for(Decorator dec:decorators) {
							if(dec instanceof IntegrationDecorator && !(dec instanceof AggregatingSIDiseaseModel)) {
								IntegrationDecorator dm = (IntegrationDecorator)dec;
								//String diseaseName = dm.getDiseaseName();
								final LoggerControl loggerControl = lcf.create(composite, dirname, sim, dm);
								loggerControl.addSelectionChangedListener(this);
								loggerControl.createTopComposite(composite);
							} // DiseaseModel
						} // For each decorator
						
					} // for all simulations

				}// synchronized(this)

			}// if (simulations.size() >=1)

			composite.layout(true, true);
			composite.redraw();
		} catch (Exception e) {
			Activator.logError("Exception in PopulateView() ", e);
		}
	} // populateView

	/**
	 * Adds all identifiable to the map by the simulation they are in
	 * @param simulations
	 * 
	 */
	private void addAllIdentifiablesBySimulation(final List<ISimulation> simulationList) {
		
		for (int i = 0; i < simulationList.size(); i++) {
			final ISimulation simulation = simulationList.get(i);
			
			Set<Identifiable> identifiablesToDisplaySet =getIdentifiableSet(simulation);

			/*
			 * The default monitor locations always contains the works
			 * (URIsuffix = ZZZ, or MonitorPreferences.DEFAULT_LOCATION_ID
			 * However, if a scenario contains only one country then the ZZZ
			 * nodes does not exist and the top level node will be the country
			 * code. So here we check that the ZZZ node exists. If it does not
			 * exist we look for three letter country code(s) and add that
			 * (those - but there should be only one) to the list.
			 */
			final Graph graph = simulation.getScenario().getCanonicalGraph();
			/*
			 * this code was used to avoid a bug that should now be fixed
			 * 
			 * if (graph == null) { System.out.println("graph is null"); // try
			 * several times for (int ii = 0 ; ii < 50; ii ++) { try {
			 * Thread.sleep(100); } catch (Exception e) { // nothing } graph =
			 * simulation.getScenario().getCanonicalGraph(); if (graph != null)
			 * break; }// for 10 trys } //if graph null
			 */

			if (graph != null) {
			//	final EMap allNodes = graph.getNodes();
			//	final Set allGraphURIs = allNodes.keySet();
			//	final URI defaultURI = MonitorPreferences.getDefaultURI();
				

				final Iterator iter = monitorSet.iterator();
				while ((iter != null) && (iter.hasNext())) {
					final String key = (String) iter.next();
					Identifiable node = null;
					URI locURI = null;
					try {
						locURI = URI.createURI(key);
						node = graph.getNode(locURI);
						if (node != null) {
							identifiablesToDisplaySet.add(node);
						}
					} catch (final Exception e) {
						org.eclipse.stem.util.loggers.Activator.logError(
								"LoggerViewer.getIdentifiablesInSimulation() Error setting Identifiable to "
										+ key + " ", e);
					}
				}// while locations to monitor

			}// graph not null

		} // for all simulations

	}
	
	/**
	 * Find out which simulation is running this node
	 * TODO Check this. This may not be unique - we may be running the 
	 * same scenario twice!!
	 * @param simulations
	 * @return
	 */
	protected String getScenarioName(Identifiable ident) {
		String retVal = "NODE_NOT_FOUND";
		List<ISimulation> simulationList = simulationManager.getActiveSimulations();
		for (int i = 0; i < simulationList.size(); i++) {
			final ISimulation simulation = simulationList.get(i);
			
			final Graph graph = simulation.getScenario().getCanonicalGraph();
			
			if (graph != null) {
				// is this node in this simulation?
				final Identifiable node = graph.getNode(ident.getURI());
				if (node != null) {
				    // graph contains node
					return simulation.getScenario().toString();
				}// node exists
			}// graph not null
		} // for all simulations
		return retVal;
	}

	/**
	 * @param simulation
	 * @return
	 */
	/*private boolean isDisplayed(final Identifiable identifiable,
			ISimulation simulation) {
		boolean retValue = false;
		final Control[] allControls = composite.getChildren();
		for (final Control element : allControls) {
			final LoggerControl loggerControl = (LoggerControl) element;

			if (loggerControl.simulation.getSequenceNumber() == simulation
					.getSequenceNumber()) {

				final Identifiable testIdentifiable = loggerControl.getIdentifiable();
				if (testIdentifiable != null&&testIdentifiable.equals(identifiable)) {
					retValue = true;
					break;
				} // if

			} // if control for same simulation

		} // for each LoggerControl
		return retValue;
	} // isDisplayed
*/
	/**
	 * save the state of preferred locations to monitor
	 */
	private void savePreferenceState() {

		// we need to write preferences by active simulation
		List allSimulations = null;
		final Set<String> nodesInSimulation = new HashSet<String>();
		if (simulationManager != null) {
			allSimulations = simulationManager.getActiveSimulations();
		}
		if ((allSimulations != null) && (allSimulations.size() >= 1)) {
			for (int i = 0; i < allSimulations.size(); i++) {
				nodesInSimulation.clear();
				final ISimulation sim = (ISimulation) allSimulations.get(i);
				final String scenarioName = sim.getScenario().getURI()
						.toString();

				// recreate the subsection for this scenario using the locations
				// now being monitored
				final IDialogSettings section = new DialogSettings(scenarioName);

				final Graph graph = sim.getScenario().getCanonicalGraph();
				Set<Identifiable> identifiablesToDisplay = getIdentifiableSet(sim);
				final Iterator iter = identifiablesToDisplay.iterator();
				while ((iter != null) && (iter.hasNext())) {
					final Identifiable ident = (Identifiable) iter.next();
					if (ident != null) {
						// is this node in this simulation?
						final Identifiable node = graph.getNode(ident.getURI());
						if (node != null) {
							final String id = ident.getURI().toString();
							if (id != null) {
								nodesInSimulation.add(id);
							}
						} // if node in simulation
					}

				}// all currently displayed nodes

				final String[] newPrefs = new String[nodesInSimulation.size()];
				final Iterator iter2 = nodesInSimulation.iterator();
				int icount = 0;
				while ((iter2 != null) && (iter2.hasNext())) {
					newPrefs[icount] = (String) iter2.next();
					icount++;
				}

				section.put(LOCATION_PREFERENCE_KEY, newPrefs);
				if (masterSettings==null) masterSettings = new DialogSettings(ROOT_KEY);
				masterSettings.addSection(section);
				try {
					masterSettings.save(getPrefFileName());
				} catch (final IOException ioe) {
					org.eclipse.stem.util.loggers.Activator
							.logError("exception writing file ["
									+ ioe.getMessage() + "]", ioe);
				}

			} // for all simulations
		}// if not null

	}// savePreferenceState
	
	/**
	 * returns the Set<Identifiable> in the identifiablesToDisplayMap
	 * creates it if it does not exist.
	 * @param simulation
	 * @return
	 */
	Set<Identifiable> getIdentifiableSet(ISimulation simulation) {
		if(!identifiablesToDisplayMap.containsKey(simulation)) {
			Set<Identifiable> identifiablesToDisplaySet = new LinkedHashSet<Identifiable>();
			identifiablesToDisplayMap.put(simulation,identifiablesToDisplaySet);
		}
		return identifiablesToDisplayMap.get(simulation);
	}
	
	/**
	 * Removes whitespace, ',', '.', etc.
	 * @param s
	 * @return a filtered string
	 */
	public static String nameFilter (String s) {
		String s1 = s.trim();
		s1 = s1.replace('"',' ');
		s1 = s1.replaceAll(" ","");
		s1 = s1.replace(',','_');
		s1 = s1.replace('.','_');
		return s1;
	}

	/**
	 * This method uses Dialog settings to load and update 
	 * the monitorSet which contains (filters) the valid list 
	 * of preferred Identifiables to display from the 
	 * the state of the previously saved preference state.
	 * for simulations that are running
	 * 
	 * @param runningSimulations
	 */
	private void updatePreferenceState(List runningSimulations) {

		// what type of viewer? TimeSeries, PhaseSpace etc
		if (masterSettings==null) readMasterSettingsFromFile();
		
		
		
		if ((runningSimulations != null) && (runningSimulations.size() >= 1)) {
			for (int i = 0; i < runningSimulations.size(); i++) {
				final ISimulation sim = (ISimulation) runningSimulations.get(i);
				final String scenarioName = sim.getScenario().getURI()
						.toString();

				
				IDialogSettings section = masterSettings
						.getSection(scenarioName);
				if (section == null) {
					section = new DialogSettings(scenarioName);
					masterSettings.addSection(section);
				}
				// now add the preferences to the monitorSet
				final String[] allIDs = section
						.getArray(LOCATION_PREFERENCE_KEY);
				if (allIDs != null) {
					for (final String element : allIDs) {
						monitorSet.add(element);
					}// for allIDs

				}// if not null

			}// for all simulations
		}// if active simulations

	}// updatePreferenceState
	
	/**
	 * get the DialogSettings from the file
	 */
	public void readMasterSettingsFromFile() {
		masterSettings = new DialogSettings(ROOT_KEY);

	    String filename = getPrefFileName();
		final File f = new File(filename);
		if (f.exists()) {
			try {
				masterSettings.load(filename);
			} catch (final IOException ioe) {
				org.eclipse.stem.util.loggers.Activator.logError(
						"exception loading file [" + ioe.getMessage()
								+ "]", ioe);
			}
		} else {
			// else create it
			try {
				masterSettings.save(filename);
			} catch (final IOException ioe) {
				org.eclipse.stem.util.loggers.Activator.logError(
						"exception creating file [" + ioe.getMessage()
								+ "]", ioe);
			}
		} // elseif f !exists
	}// read master setttings
	
	/** 
	 * gets the preferences file name
	 * @return file name containing the users preferences
	 */
	public String getPrefFileName() {
		final String controlCategory = lcf.getControlType();
		// Get the right preference file
		String filename = PATH.append(controlCategory + "_" + REPORTVIEWPREFERENCES_FILENAME).toOSString();
		return filename;
	}



} // LoggerViewer

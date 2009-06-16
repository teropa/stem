// GeographicViewer.java
package org.eclipse.stem.ui.views.geographic;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationManagerListener;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationManagerEvent;
import org.eclipse.stem.ui.views.IContextMenuUpdatesListener;
import org.eclipse.stem.ui.views.geographic.map.MapRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This class presents "views" of the running simulations.
 */
public class GeographicViewer extends Viewer implements
		ISelectionChangedListener, ISimulationManagerListener {

	/**
	 * This is the collection of
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s that should be
	 * displayed.
	 */
	private final Set<ISimulation> simulationsToDisplay = new LinkedHashSet<ISimulation>();

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
	private SimulationManager simulationManager;

	/**
	 * The <code>Identifiable</code> that was most recently selected by a user
	 * clicking on one of the
	 * {@link org.eclipse.stem.ui.views.geographic.map.MapControl}s, or
	 * <code>null</code> if none has been selected.
	 */
	private ISelection selection = null;

	/**
	 * This is the top-level control of the viewer. It contains the
	 * {@link org.eclipse.stem.ui.views.geographic.map.MapControl}s that
	 * display the current state of the
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s.
	 */
	private Composite composite;

	/**
	 * This factory is used to create instances of {@link GeographicControl} in
	 * the method {@link #populateView()}
	 */
	private GeographicControlFactory gcf;

	/**
	 * This is a list of listeners to get notifications about newly generated
	 * context menus.
	 */
	private List<IContextMenuUpdatesListener> contextMenuUpdateListeners = new ArrayList<IContextMenuUpdatesListener>();

	/**
	 * @param parent
	 *            the SWT parent of the control that makes up the viewer
	 * @param gcf
	 *            the factory that creates instance of {@link GeographicControl}
	 */
	public GeographicViewer(Composite parent, GeographicControlFactory gcf) {
		composite = new Composite(parent, SWT.NONE);
		final FillLayout compositeLayout = new FillLayout(SWT.HORIZONTAL);
		composite.setLayout(compositeLayout);

		// Remember the factory that we'll use to create instances of
		// GeographicControl
		this.gcf = gcf;

		refresh();

		composite.pack();
	} // GeographicViewer

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
			simulationsToDisplay.clear();
			simulationsToDisplay.addAll(simulationManager
					.getActiveSimulations());
		} // if
		populateView();
	} // refresh

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
	public void setInput(Object input) {
		final Object oldInput = simulationManager;
		simulationManager = (SimulationManager) input;
		inputChanged(input, oldInput);
	} // setInput

	/**
	 * @see org.eclipse.jface.viewers.Viewer#inputChanged(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		// Is there already a simulation manager?
		if (oldInput != null) {
			// Yes
			((SimulationManager) oldInput).removeListener(this);
		} // if

		// Register with the SimulationManager to listen for changes in the set
		// of active Simulations.
		// Got input?
		if (input != null) {
			// Yes
			((SimulationManager) input).addSimulationManagerListener(this);
		} // if

		// Update the viewer with the contents of the new input source
		refresh();
	} // inputChanged

	/**
	 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection,
	 *      boolean)
	 */
	@Override
	public void setSelection(ISelection selection, @SuppressWarnings("unused")
	boolean reveal) {
		this.selection = selection;
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(final SelectionChangedEvent event) {
		// Did the event come from a GeographicControl?
		if (event.getSelectionProvider() instanceof GeographicControl) {
			// Yes
			// Just pass it along
			selection = event.getSelection();
			fireSelectionChanged(event);
		} // if
	} // selectionChanged

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationManagerListener#simulationsChanged(org.eclipse.stem.jobs.simulation.SimulationManagerEvent)
	 */
	public void simulationsChanged(final SimulationManagerEvent event) {
		addToDisplayedSimulationSet(Arrays.asList(event.getSimulationsAdded()));

		removeFromDisplayedSimulationSet(Arrays.asList(event
				.getSimulationsRemoved()));

		populateView();
	} // simulationsChanged

	/**
	 * @param simulations
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}s
	 *            to add to the set being displayed.
	 */
	private void addToDisplayedSimulationSet(final List<ISimulation> simulations) {
		// Any simulations to add?
		if (!simulations.isEmpty()) {
			// Yes
			simulationsToDisplay.addAll(simulations);
		} // if any simulations
	} // addToDisplayedSimulationSet

	/**
	 * @param simulations
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}s
	 *            to remove from the set being displayed.
	 */
	private void removeFromDisplayedSimulationSet(
			final List<ISimulation> simulations) {
		// Any simulations to remove?
		if (!simulations.isEmpty()) {
			// Yes
			simulationsToDisplay.removeAll(simulations);
		} // if
	} // removeFromDisplayedSimulationSet

	/**
	 * Create and dispose of MapControls as necessary to display the selected
	 * Simulations.
	 */
	private void populateView() {

		// Are we done?
		if (composite.isDisposed()) {
			// Yes
			return;
		} // if

		selection = null;

		// Find the Simulations that are not currently being displayed and put
		// them into the Set undisplayedSimulations.
		final Set<ISimulation> undisplayedSimulations = new HashSet<ISimulation>();
		for (final ISimulation simulation : simulationsToDisplay) {
			// Is this one associated with a GeographicControl already?
			if (!isDisplayed(simulation)) {
				// No
				undisplayedSimulations.add(simulation);
			} // if not displayed
		} // for each ISimulation

		// Go through the current set of Controls looking for ones that
		// we can reassign
		final Control[] controls = composite.getChildren();
		for (final Control element : controls) {
			// Does this GeographicControl have a simulation that is still valid
			// to display?
			final GeographicControl geoControl = (GeographicControl) element;
			if (!simulationsToDisplay.contains(geoControl.getSimulation())
					&& !undisplayedSimulations.isEmpty()) {
				// No
				// Reassign it to one that is valid
				final ISimulation simulation = (ISimulation) undisplayedSimulations
						.toArray()[0];
				geoControl.setSimulation(simulation);
				// Notify ViewPart that a new context menu has been generated
				notifyContextMenuUpdateListeners(geoControl);
				undisplayedSimulations.remove(simulation);
			} // if
		} // for each MapControl

		// At this point we still could have map controls with invalid
		// Simulations, let's get rid of them
		for (final Control element : controls) {
			final GeographicControl geoControl = (GeographicControl) element;
			// Does this MapControl have a simulation that is still valid to
			// display?
			ISimulation simulation = geoControl.getSimulation();
			if (simulation != null
					&& !simulationsToDisplay.contains(simulation)) {
				// No
				geoControl.removeSelectionChangedListener(this);								
				geoControl.dispose();
			}
		}// for each MapControl

		// If there're any Simulations not assigned to a GeographicControl,
		// let's take care of that now.
		for (final ISimulation simulation2 : undisplayedSimulations) {
			final GeographicControl geoControl = gcf.create(composite);
			// Notify ViewPart that a new context menu has been generated
			notifyContextMenuUpdateListeners(geoControl);
			geoControl.addSelectionChangedListener(this);
			geoControl.setSimulation(simulation2);
		} // for each ISimulation

		// If there are no simulations to display, we just put up a "blank"
		// GeographicControl
		if (composite.getChildren().length == 0) {
			// Yes
			final GeographicControl geoControl = gcf.create(composite);
			geoControl.addSelectionChangedListener(this);
		} // if
		composite.layout(true, true);
		composite.redraw();
	} // populateView

	/**
	 * @param simulation
	 * @return
	 */
	private boolean isDisplayed(final ISimulation simulation) {
		boolean retValue = false;
		final Control[] foo = composite.getChildren();
		for (final Control element : foo) {
			final GeographicControl geoControl = (GeographicControl) element;
			final ISimulation testSimulation = geoControl.getSimulation();
			if (testSimulation != null && testSimulation.equals(simulation)) {
				retValue = true;
				break;
			} // if
		} // for each MapControl
		return retValue;
	} // isDisplayed

	/**
	 * The method adds the specified listener to the list of listeners
	 * 
	 * @param newListener
	 *            A listener to be added
	 */
	public void addContextMenuUpdateListener(
			IContextMenuUpdatesListener newListener) {
		if (!contextMenuUpdateListeners.contains(newListener)) {
			contextMenuUpdateListeners.add(newListener);
		} // if
	} // addContextMenuUpdateListener
	
	/**
	 * The method removes the specified listener to the list of listeners
	 * 
	 * @param newListener
	 *            A listener to be added
	 */
	public void removeContextMenuUpdateListener(
			IContextMenuUpdatesListener newListener) {
		contextMenuUpdateListeners.remove(newListener);
	} // addContextMenuUpdateListener

	/**
	 * The method will send notification to all listeners about new menu that
	 * has been created.
	 * 
	 * @param geoControl
	 *            The <code>GeographicControl</code> that has the new
	 *            <code>MenuManager</code> as a field.
	 */
	private void notifyContextMenuUpdateListeners(GeographicControl geoControl) {
		GeographicRenderer geoRenderer = geoControl.getGeographicRenderer();
		if (geoRenderer instanceof MapRenderer) {
			MapRenderer mapRenderer = (MapRenderer) geoRenderer;
			notifyContextMenuUpdateListeners(mapRenderer.getMenuManager(),
					mapRenderer);
		} // if
	} // notifyContextMenuUpdateListeners

	/**
	 * The method will send notification to all listeners about new menu that
	 * has been created.
	 * 
	 * @param menuManager
	 *            The newly added <code>MenuManager</code>
	 * @param selectionProvider
	 *            A <code>ISelectionProvider</code> for the menu
	 */
	private void notifyContextMenuUpdateListeners(MenuManager menuManager,
			ISelectionProvider selectionProvider) {
		for (final IContextMenuUpdatesListener listener : contextMenuUpdateListeners) {
			listener.onContextMenuUpdate(menuManager, selectionProvider);
		} // for each IContextMenuUpdatesListener
	} // notifyContextMenuUpdateListeners
	
} // GeographicViewer

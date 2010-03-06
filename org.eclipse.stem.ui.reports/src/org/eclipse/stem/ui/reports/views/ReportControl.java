package org.eclipse.stem.ui.reports.views;

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

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryExtendedListener;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * ReportControl is a subclass of Canvas suitable for chart drawings.
 */
abstract public class ReportControl extends Composite implements
		RelativeValueHistoryExtendedListener, ISimulationListener,
		ISelectionProvider {

	protected RelativeValueHistoryProviderAdapter rvhp;

	protected static final String REMOVE_TEXT = "remove";
	
	protected static final String ADD_REFERENCE_TEXT = "Add Reference";

	protected Label simulationNameLabel;

	/**
	 * The {@link org.eclipse.stem.jobs.simulation.Simulation} associated
	 * with the values being plotted.
	 */
	protected ISimulation simulation = null;

	/**
	 * The {@link Identifiable} that we're plotting.
	 */
	protected Identifiable identifiable;
	protected Decorator selectedDecorator;
	protected DynamicLabel selectedDynamicLabel;
	protected Map<Decorator, List<DynamicLabel>> decoratorToLabelsMap;

	/**
	 * button to remove this controller and view
	 */
	protected Button removeButton = null;
	
	/**
	 * button to add a reference data set to this view
	 */
	protected Button addReferenceButton = null;
	
	/**
	 * button to add a reference data set to this view
	 */
	protected Label addReferenceLabel = null;

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

	protected Label identifiableTitle;

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
	public ReportControl(final Composite parent, final int style) {
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

	} // ReportControl

	/**
	 * @param parent
	 *            the parent SWT control that this composite will be a child of
	 * @return the SWT Composite to be displayed above the MapCanvas in the
	 *         control
	 */
	protected Composite createTopComposite(final Composite parent) {
		final Composite topComposite = new Composite(parent, SWT.NONE);

		final FillLayout topCompositeLayout = new FillLayout(SWT.VERTICAL);
		topComposite.setLayout(topCompositeLayout);

		simulationNameLabel = new Label(topComposite, SWT.CENTER);
		simulationNameLabel.setText("");

		return topComposite;
	} // createTopComposite

	protected void switchToRVHP(final RelativeValueHistoryProviderAdapter rvhp) {
		// Is there an existing RVHP to stop listening to?
		if (this.rvhp != null && this.rvhp != rvhp) {
			// Yes
			this.rvhp.removeExtensionListener(this);
		} // if

		// Should we start listening to the new one?
		if (this.rvhp != rvhp && rvhp != null) {
			// Yes
			rvhp.addExtensionListener(this);
		} // if

		this.rvhp = rvhp;
	} // switchToRVHP

	/**
	 * All controllers must implement this to remove the control e.g. by a
	 * remove button event
	 */
	public abstract void remove();

	/**
	 * 
	 * @param listener
	 */
	public void addIRemoveListener(final IRemoveListener listener) {
		removeListeners.add(listener);
	}

	/**
	 * 
	 * @param listener
	 */
	public void removeIRemoveListener(final IRemoveListener listener) {
		removeListeners.remove(listener);
	}

	/**
	 * 
	 * @param ident
	 */
	public void fireRemoveEvent(final Identifiable ident) {
		for (final IRemoveListener listener : removeListeners) {
			listener.identifiableRemoved(ident);
		} // for each ISelectionChangedListener
	}

	/**
	 * Setting the {@link org.eclipse.stem.jobs.simulation.Simulation} has
	 * the side-effect of causing the control to remove itself as a listener
	 * from any previously set
	 * {@link org.eclipse.stem.jobs.simulation.Simulation} and adding itself
	 * as a listener to the new one. It will also cause the image to be
	 * initialized from the contents of the new
	 * {@link org.eclipse.stem.jobs.simulation.Simulation} as appropriate.
	 * 
	 * @param simulation
	 *            the simulation whose Lat/Long data will be rendered.
	 */
	public void setSimulation(final ISimulation simulation) {
		// Any need to switch?
		if (this.simulation == simulation) {
			// No
			return;
		} // if no need to switch?

		// Should we remove ourselves as listeners from the current simulation?
		if (this.simulation != null) {
			// Yes
			this.simulation.removeSimulationListener(this);
		}

		this.simulation = simulation;
		selection = null;
		// Was there a new simulation to switch to?
		if (this.simulation != null) {
			// Yes
			this.simulation.addSimulationListener(this);
			initializeFromSimulation(this.simulation);
		} else {
			// No
			// Just display a blank screen
			initializeFromSimulation(null);
		}

		refresh2();
	} // setSimulation

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
	 */
	public abstract void setIdentifiable(Identifiable identifiable);

	/**
	 * Returns the Identifiable being displayed
	 * 
	 * @return The identifiable to be monitored
	 * 
	 */
	public abstract Identifiable getIdentifiable();

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
	 * One of two Control types. Controls are associated with either an individual
	 * Identifiable or a Simulation
	 * @return the control type
	 */
	public abstract String getControlType() ;

} // ReportControl

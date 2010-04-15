// RelativeValueHistoryPlotter.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryExtendedListener;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.stem.ui.widgets.DecoratorSelector;
import org.eclipse.stem.ui.widgets.DecoratorSelector.DecoratorSelectionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * This class is a SWT GUI component that uses BIRT to plot
 */
public class RelativeValueHistoryPlotter extends ReportControl implements
		RelativeValueHistoryExtendedListener, ISimulationListener {

	TimeSeriesCanvas timeSeriesCanvas;
	DecoratorSelector decoratorSelector;
	List<ItemPropertyDescriptor> selectedProperties;

	/**
	 * This interface is implemented by classes that select out the properties
	 * to be displayed.
	 */
	public interface PropertySieve {
		/**
		 * @param dynamicLabel
		 *            the label that contains the candidate properties to be
		 *            displayed.
		 * @return a <code>List</code> of the properties that should be
		 *         displayed in the order that they should be displayed.
		 */
		List<ItemPropertyDescriptor> sieve(final DynamicLabel dynamicLabel);
	} // PropertySieve

	/**
	 * This sieve selects all of those properties that have relative values.
	 */
	private final PropertySieve propertySieve = new PropertySieve() {
		/**
		 * @see org.eclipse.stem.ui.widgets.DecoratorSelector.PropertySieve#sieve(org.eclipse.stem.core.graph.DynamicLabel)
		 */
		public List<ItemPropertyDescriptor> sieve(
				final DynamicLabel dynamicLabel) {
			final List<ItemPropertyDescriptor> retValue = new ArrayList<ItemPropertyDescriptor>();
			final RelativeValueProviderAdapter rvp = (RelativeValueProviderAdapter) RelativeValueProviderAdapterFactory.INSTANCE
					.adapt(dynamicLabel, RelativeValueProvider.class);

			// Does the label have relative values?
			if (rvp != null) {
				// Yes
				rvp.setTarget(dynamicLabel);

				for (final Object element : rvp.getProperties()) {
					final ItemPropertyDescriptor property = (ItemPropertyDescriptor) element;
					retValue.add(property);
				} // for each property
			} // if the label has relative values
			return retValue;
		} // sieve
	};

	/**
	 * @param parent
	 */
	public RelativeValueHistoryPlotter(final Composite parent) {
		super(parent, SWT.None);
		createContents();
	} // RelativeValueHistoryPlotter

	/**
	 * Create the contents of the plotter
	 */
	private void createContents() {
		setLayout(new FormLayout());

		identifiableTitle = new Label(this, SWT.NONE);
		timeSeriesCanvas = new TimeSeriesCanvas(this);
		decoratorSelector = new DecoratorSelector(this, SWT.NONE, true);

		removeButton = new Button(this, SWT.NONE);
		removeButton.setText(REMOVE_TEXT);

		final FormData titleFormData = new FormData();
		identifiableTitle.setLayoutData(titleFormData);
		titleFormData.top = new FormAttachment(0, 0);
		titleFormData.left = new FormAttachment(0, 0);
		titleFormData.right = new FormAttachment(100, 0);

		final FormData chartFormData = new FormData();
		timeSeriesCanvas.setLayoutData(chartFormData);
		chartFormData.top = new FormAttachment(identifiableTitle, 0);
		chartFormData.bottom = new FormAttachment(decoratorSelector, 0);
		chartFormData.left = new FormAttachment(0, 0);
		chartFormData.right = new FormAttachment(100, 0);

		// Property Selector
		final FormData decoratorSelectorFormData = new FormData();
		// decoratorSelectorFormData.top = new FormAttachment(timeSeriesCanvas,
		// 0);
		decoratorSelectorFormData.bottom = new FormAttachment(100, 0);
		decoratorSelectorFormData.left = new FormAttachment(0, 0);
		decoratorSelectorFormData.right = new FormAttachment(30, 0);
		decoratorSelector.setLayoutData(decoratorSelectorFormData);

		// RemoveButton
		final FormData removeButtonFormData = new FormData();
		// decoratorSelectorFormDataX.top = new FormAttachment(decoratorSelectorY,
		// 0);
		removeButtonFormData.bottom = new FormAttachment(100, 0);
		removeButtonFormData.left = new FormAttachment(decoratorSelector, 0);
		removeButtonFormData.right = new FormAttachment(60, 0);
		removeButton.setLayoutData(removeButtonFormData);

		decoratorSelector
				.addDecoratorSelectionListener(new DecoratorSelector.DecoratorSelectionListener() {

					/**
					 * @see org.eclipse.stem.ui.widgets.DecoratorSelector.PropertySelectionListener#propertySelected(org.eclipse.stem.ui.widgets.DecoratorSelector.PropertySelectionEvent)
					 */
					public void decoratorSelected(
							final DecoratorSelectionEvent decoratorSelectionEvent) {
						selectedDecorator = decoratorSelectionEvent
								.getDecorator();
						if(selectedDecorator!=null) {
							selectedProperties = getPropertiesToDisplay(selectedDecorator);
							String selectedPopId = decoratorSelectionEvent.getId();
							List<DynamicLabel>allLabels = decoratorToLabelsMap.get(selectedDecorator);
							if(allLabels != null) 
								for(DynamicLabel lab:allLabels) {
								if(lab instanceof DiseaseModelLabel &&
										((DiseaseModelLabel)lab).getPopulationModelLabel().getPopulationIdentifier().equals(selectedPopId))
								{selectedDynamicLabel = lab;break;}
							}
							if(selectedDynamicLabel != null)
								switchToRVHP((RelativeValueHistoryProviderAdapter) RelativeValueHistoryProviderAdapterFactory.INSTANCE
									.adapt(selectedDynamicLabel,
											RelativeValueHistoryProvider.class));
							timeSeriesCanvas.setDataSourceAndRedraw(rvhp, selectedProperties);
						}// if decorator not null
					}
				});

		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(
					@SuppressWarnings("unused") final SelectionEvent e) {
				fireRemoveEvent(identifiable);
				remove();
			}
		});

	} // createContents

	/**
	 * to remove the control e.g. by a remove button event
	 */
	@Override
	@SuppressWarnings("cast")
	public void remove() {
		removeListeners.clear();
		switchToRVHP(null);
		relativeValueHistoryExtended(null);
		identifiableTitle.setText("");
		decoratorSelector
				.setDecorators((List<Decorator>) Collections.EMPTY_LIST);
		dispose();
	}

	/**
	 * @param identifiable
	 *            the {@link Identifiable} to be the source of the data to be
	 *            plotted.
	 */
	@Override
	public void setIdentifiable(final Identifiable identifiable) {

		// Same Identifiable?
		if (this.identifiable == identifiable) {
			// Yes
			return;
		} // if

		this.identifiable = identifiable;

		final List<Decorator> decorators = new ArrayList<Decorator>();
		decoratorToLabelsMap = new HashMap<Decorator, List<DynamicLabel>>();

		identifiableTitle.setText(identifiable.getDublinCore().getTitle());
		// Get the dynamic labels associated with this Identifiable
		// A node?
		if (identifiable instanceof Node) {
			// Yes
			final Node node = (Node) identifiable;
			for (final NodeLabel nodeLabel : node.getLabels()) {
				// Updated by a decorator?
				if (nodeLabel instanceof DynamicNodeLabel) {
					// Yes
					final DynamicNodeLabel dynamicNodeLabel = (DynamicNodeLabel) nodeLabel;
					// Can it provide relative values?
					final RelativeValueHistoryProviderAdapter rvhp = (RelativeValueHistoryProviderAdapter) RelativeValueHistoryProviderAdapterFactory.INSTANCE
							.adapt(nodeLabel,
									RelativeValueHistoryProvider.class);
					if (rvhp != null) {
						// Yes
						final Decorator decorator = dynamicNodeLabel
								.getDecorator();
						
						if(decorator != null) {
							if(decoratorToLabelsMap.get(decorator)!=null) {
								List<DynamicLabel>list = decoratorToLabelsMap.get(decorator);
								list.add(dynamicNodeLabel);
							} else {
								ArrayList<DynamicLabel>newList = new ArrayList<DynamicLabel>();
								newList.add(dynamicNodeLabel);
								decoratorToLabelsMap.put(decorator, newList);
							}
							decorators.add(decorator);
						}
					} // if
				} // if DynamicNodeLabel
			} // for each NodeLabel

			// Are there any Decorators that we'll plot?
			if (decorators.size() > 0) {
				// Yes
				// We need to listen to the life-cycle of the Simulation
				// associated with the Graph that contains the Identifable that
				// was passed in. When it disappears, we need to "un-hook"
				// ourselves from the RelativeValueHistoryProviderAdapter
				// instance so that the Graph that it is attached to can be
				// garbage collected and we need to reset ourselves so that we
				// don't display a plot for a Simulation that doesn't exist any
				// more.
				final ISimulation newSimulation = SimulationManager
						.getManager().mapGraphToSimulation(getGraph(node));

				// Stop listening to the old one?
				if (simulation != null) {
					// Yes
					simulation.removeSimulationListener(this);
				} // if
				simulation = newSimulation;

				// Listen to the new one?
				if (simulation != null) {
					// Yes
					simulation.addSimulationListener(this);
				} // if
			} // if any Decorators to plot

		} // if Node
		decoratorSelector.setDecorators(decorators);
	} // setIdentifiable

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryExtendedListener#relativeValueHistoryExtended(org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter)
	 */
	public void relativeValueHistoryExtended(
			final RelativeValueHistoryProviderAdapter rvhp) {
		// The event notification doesn't come from the UI thread so we need to
		// add a Runnable to the UI thread's execution queue to give the new
		// source to the chart
		final Display display = Display.getDefault();
		if (!display.isDisposed()) {
			// Yes
			try {
				display.asyncExec(new Runnable() {
					public void run() {
						if (!timeSeriesCanvas.isDisposed()) {
							timeSeriesCanvas.setDataSourceAndRedraw(rvhp,
									selectedProperties);
						}
					} // run
				}); // display.asyncExec
			} // try
			catch (final Exception e) {
				// Ignore there could be a race condition with the display being
				// disposed when the system is shut down with a running
				// simulation.
			} // catch Exception
		} // if
	} // relativeValueHistoryExtended

	/**
	 * Initialize the control from a
	 * {@link org.eclipse.stem.jobs.simulation.Simulation} instance.
	 * 
	 * @param simulation
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}
	 *            whose state will be visualized in the control.
	 */
	@Override
	protected void initializeFromSimulation(final ISimulation simulation) {
		simulationNameLabel.setText(simulation.getName());
		decoratorSelector.setSimulation(simulation);

	} // initializeFromSimulation

	/**
	 * 
	 */
	@Override
	public void refresh2() {
		// nothing
	} // refresh2

	/**
	 * @param decorator
	 *            a {@link Decorator} that modifies the state of the canonical
	 *            {@link Graph} in the
	 *            {@link org.eclipse.stem.jobs.simulation.Simulation}.
	 * @param simulation
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}
	 * @return a {@link List} of the properties of the {@link Decorator} that
	 *         can should be displayed.
	 */
	List<ItemPropertyDescriptor> getPropertiesToDisplay(
			final Decorator decorator) {
		final List<ItemPropertyDescriptor> retValue = new ArrayList<ItemPropertyDescriptor>();
		// Got Decorator?
		if (decorator != null) {
			// Yes
			// Are there any labels to update?
			if (!decorator.getLabelsToUpdate().isEmpty()) {
				// Yes
				// The first one is good enough
				retValue.addAll(propertySieve.sieve(decorator
						.getLabelsToUpdate().get(0)));
			} // if labels to update
		} // if got decorator
		return retValue;
	} // getPropertiesToDisplay

	private Graph getGraph(final Node node) {
		return (Graph) node.eContainer().eContainer();
	} // getGraph

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListener#simulationChanged(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	@SuppressWarnings("cast")
	public void simulationChanged(final SimulationEvent event) {
		if (event.getSimulationState() == SimulationState.RESET) {
			// Yes
			timeSeriesCanvas.resetData();
		} // if
		// Is the Simulation stopping (i.e. being deleted?)
		if (event.getSimulationState() == SimulationState.STOPPED) {
			// Yes
			simulation.removeSimulationListener(this);
			simulation = null;
			switchToRVHP(null);
			relativeValueHistoryExtended(null);
			identifiableTitle.setText("");
			decoratorSelector
					.setDecorators((List<Decorator>) Collections.EMPTY_LIST);
		} // if

	} // simulationChanged

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (this.rvhp != null) {
			// Yes
			rvhp.removeExtensionListener(this);
		} // if
		if (simulation != null) {
			// Yes
			simulation.removeSimulationListener(this);
		} // if
	} // dispose

	/**
	 * @see org.eclipse.stem.ui.reports.views.ReportControl#getIdentifiable()
	 */
	@Override
	public Identifiable getIdentifiable() {
		return identifiable;
	}
	
	/**
	 * This Control is associated with an Identifiable
	 * @see org.eclipse.stem.ui.reports.views.ReportControl#getControlType()
	 */
	public String getControlType() {
		return ReportControlFactory.IDENTIFABLE_TYPE;
	}

} // RelativeValueHistoryPlotter

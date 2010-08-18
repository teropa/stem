// DataHistoryLogger.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.adapters.time.TimeProvider;
import org.eclipse.stem.adapters.time.TimeProviderAdapterFactory;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListenerSync;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.widgets.PropertySelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * DataHistoryLogger
 */
public class DataHistoryLogger extends LoggerControl implements
		ISimulationListenerSync {

	//private static final String NODE_PREFIX_TEXT = "node/geo/region/";

	/**
	 * The location (node) name label
	 */
	Label loggerTypeLabel;

	/**
	 * The location (node) id label
	 */
	Label loggerDiseaseLabel;

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

	PropertySelector propertySelector;
	//List<ItemPropertyDescriptor> selectedProperties;

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
		 * @see org.eclipse.stem.ui.widgets.PropertySelector.PropertySieve#sieve(org.eclipse.stem.core.graph.DynamicLabel)
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
	 * 
	 * @param parent
	 * @param logWriter
	 * @param simulation 
	 * @param dm
	 */
	public DataHistoryLogger(final Composite parent, final LogWriter logWriter, ISimulation simulation, IntegrationDecorator dm) {
		super(parent, SWT.None);
		this.logWriter = logWriter;
		setSimulation(simulation);
		setDiseaseModel(dm);
		createContents();
	} // DataHistoryLogger

	/**
	 * Create the contents of the logger
	 */
	private void createContents() {
		final FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		setLayout(layout);

		final Composite inner = new Composite(this, SWT.NONE);
		final FormLayout innerLayout = new FormLayout();

		inner.setLayout(innerLayout);

		
		
		final Display display = this.getDisplay();
		
		final Color colorColumn1 = new Color(display, new RGB(180, 180, 200));
		final Color colorColumn2 = new Color(display, new RGB(190, 190, 220));
		final Color colorColumn3 = new Color(display, new RGB(180, 180, 200));
		
		final Color bgColor = new Color(display, new RGB(170, 170, 190));
		inner.setBackground(bgColor);

		propertySelector = new PropertySelector(inner, SWT.NONE, true);
		

		

		loggerTypeLabel = new Label(inner,  SWT.CENTER);
		loggerTypeLabel.setBackground(colorColumn1);
		loggerTypeLabel.setText("CSV Logger");
		loggerTypeLabel.setAlignment(SWT.CENTER);
		
		if(simulationNameLabel == null) {
			simulationNameLabel = new Label(inner,  SWT.CENTER);
			simulationNameLabel.setText(simulation.getName());
			simulationNameLabel.setBackground(colorColumn2);
			simulationNameLabel.setAlignment(SWT.CENTER);
		}
		
		loggerDiseaseLabel = new Label(inner,  SWT.CENTER);
		loggerDiseaseLabel.setBackground(colorColumn3);
		String idtext = null;
		if(this.diseaseModel instanceof DiseaseModel)
			idtext = ((DiseaseModel)this.diseaseModel).getDiseaseName();
		else if(this.diseaseModel instanceof PopulationModel)
			idtext = ((PopulationModel)this.diseaseModel).getName();
		
		loggerDiseaseLabel.setText(idtext);
		loggerDiseaseLabel.setAlignment(SWT.CENTER);

		// Logger Name Label
		final FormData loggerNameLabelFormData = new FormData();
		loggerNameLabelFormData.top = new FormAttachment(0, 0);
		loggerNameLabelFormData.left = new FormAttachment(0, 0);
		loggerNameLabelFormData.right = new FormAttachment(25, 0);
		loggerNameLabelFormData.bottom = new FormAttachment(0, 100);
		loggerTypeLabel.setLayoutData(loggerNameLabelFormData);
		
		// Simulation Name Label
		final FormData simulationNameLabelFormData = new FormData();
		simulationNameLabelFormData.top = new FormAttachment(0, 0);
		simulationNameLabelFormData.left = new FormAttachment(25, 0);
		simulationNameLabelFormData.right = new FormAttachment(50, 0);
		simulationNameLabelFormData.bottom = new FormAttachment(0, 100);
		simulationNameLabel.setLayoutData(simulationNameLabelFormData);

		// ID Label
		final FormData loggerIdLabelFormData = new FormData();
		loggerIdLabelFormData.top = new FormAttachment(0, 0);
		loggerIdLabelFormData.left = new FormAttachment(50, 0);
		loggerIdLabelFormData.right = new FormAttachment(90, 0);
		loggerIdLabelFormData.bottom = new FormAttachment(0, 100);
		loggerDiseaseLabel.setLayoutData(loggerIdLabelFormData);

		// Property Selector
		propertySelector.setSize(0, 0);
		final FormData propertySelectorFormData = new FormData();
		propertySelectorFormData.top = new FormAttachment(0, 0);
		propertySelectorFormData.left = new FormAttachment(100, 0);
		propertySelectorFormData.right = new FormAttachment(100, 0);
		propertySelector.setLayoutData(propertySelectorFormData);

		propertySelector.setVisible(false);

		
	} // createContents

	/**
	 * @param decorator
	 *            a {@link Decorator} that modifies the state of the canonical
	 *            {@link Graph} in the {@link Simulation}.
	 * @param simulation
	 *            the {@link Simulation}
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

	/**
	 * to remove the control e.g. by a remove button event
	 */
	@Override
	public void remove() {
		if (logWriter != null) {
			logWriter.flushLoggerData();
		}
		if (logWriter != null) {
			logWriter.closeLoggerData();
		}
		this.logWriter = null;
		removeListeners.clear();

		propertySelector.setDecorators(Collections.EMPTY_LIST);
		dispose();
	}

	/**
	 * Initialize the decorators and labels associated with the simulation
	 * 
	 */

	public void setIdentifiable() {
		//nothing
	} 
	
	/**
	 * Initialize the control from a {@link Simulation} instance.
	 * 
	 * @param simulation
	 *            the {@link Simulation} whose state will be visualized in the
	 *            control.
	 */
	@Override
	protected void initializeFromSimulation(final ISimulation simulation) {
		graph = simulation.getScenario().getCanonicalGraph();

		timeProvider = (TimeProvider) TimeProviderAdapterFactory.INSTANCE
				.adapt(graph, TimeProvider.class);
	} // initializeFromSimulation

	/**
	 * 
	 */
	@Override
	public void refresh2() {
		if (logWriter != null) {
			logWriter.flushLoggerData();
		}
	} // refresh2

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListenerSync#simulationChangedSync(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	public void simulationChangedSync(final SimulationEvent event) {
		// Data to log ?
		if (event.getSimulationState() == SimulationState.RUNNING) {
			if ((logWriter != null) && (logWriter.needsHeader)) {
				// This will write the headers and the first line of data before first cycle
				logWriter.logHeader(this.simulation, this.diseaseModel, this.nodeLevels, timeProvider);
				// Don't log here since the models have not completly been initialized yet
				// (sequencer has not rewinded values)
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
			// Yes
			if (logWriter != null) {
				logWriter.closeLoggerData();
			}
			dispose();
		} // if

	} // simulationChanged

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		if (logWriter != null) {
			logWriter.closeLoggerData();
		}
		this.logWriter = null;

		if (simulation != null) {
			// Yes
			simulation.removeSimulationListenerSync(this);
		} // if
		super.dispose();
	} // dispose

	/**
	 * @see org.eclipse.stem.util.loggers.views.LoggerControl#getIdentifiable()
	 */
	/*@Override
	public Identifiable getIdentifiable() {
		return identifiable;
	}
*/
} // DataHistoryLogger

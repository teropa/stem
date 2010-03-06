// PropertySelector.java
package org.eclipse.stem.ui.widgets;

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
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.definitions.adapters.population.PopulationEnumerator;
import org.eclipse.stem.definitions.adapters.population.PopulationEnumeratorAdapter;
import org.eclipse.stem.definitions.adapters.population.PopulationEnumeratorAdapterFactory;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.views.geographic.map.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class is a compound SWT widget that allows for the selection of a
 * property or properties of one or more {@link Decorator}s.
 */
public class DecoratorSelector extends Composite {

	private final List<DecoratorSelectionListener> propertySelectionListeners = new CopyOnWriteArrayList<DecoratorSelectionListener>();

	private ISimulation simulation = null;


	private final Label displayLabel;

	Combo decoratorsCombo;

	Combo populationIdCombo;

	List<Decorator> decorators;

	Decorator selectedDecorator;

	String selectedProperty;

	String [] popIds;
	
	private DecoratorFilter decoratorFilter = new DecoratorFilter() {
		/**
		 * @see org.eclipse.stem.ui.widgets.PropertySelector.DecoratorFilter#accept(org.eclipse.stem.core.model.Decorator)
		 */
		public boolean accept(@SuppressWarnings("unused")
		Decorator decorator) {
			return true;
		}
	};

	/**
	 * The default sieve selects those properties that have relative values.
	 */
	private PropertySieve propertySieve = new PropertySieve() {
		/**
		 * @see org.eclipse.stem.ui.widgets.PropertySelector.PropertySieve#sieve(org.eclipse.stem.core.graph.DynamicLabel)
		 */
		public List<ItemPropertyDescriptor> sieve(DynamicLabel dynamicLabel) {
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
	 * @param style
	 */
	public DecoratorSelector(final Composite parent, final int style, boolean allowDecoratorSelection) {
		super(parent, style);
		final FormLayout retValueLayout = new FormLayout();
		this.setLayout(retValueLayout);

		displayLabel = new Label(this, SWT.CENTER);
		displayLabel.setText(Messages.getString("IMView.MProp") + " :"); //$NON-NLS-1$ //$NON-NLS-2$

		// Combo Box of Decorators
		decoratorsCombo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY
				| SWT.CENTER);

		// Combo Box of the Decorator Properties
		populationIdCombo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY
				| SWT.CENTER);

		final FormData decoratorsComboFormData = new FormData();
		decoratorsComboFormData.top = new FormAttachment(displayLabel, 0);
		decoratorsComboFormData.left = new FormAttachment(0, 0);
		decoratorsComboFormData.right = new FormAttachment(100, 0);
		decoratorsCombo.setLayoutData(decoratorsComboFormData);

		final FormData populationIdComboData = new FormData();
		populationIdComboData.top = new FormAttachment(decoratorsCombo, 0);
		populationIdComboData.left = new FormAttachment(0, 0);
		populationIdComboData.right = new FormAttachment(100, 0);
		populationIdCombo.setLayoutData(populationIdComboData);

		this.pack();

		decoratorsCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			final SelectionEvent e) {
				// Any decorators?
				if (!decorators.isEmpty()) {
					// Yes
					final Decorator tempDecorator = decorators
							.get(decoratorsCombo.getSelectionIndex());
					// Was there a change in selected Decorators?
					if (selectedDecorator != tempDecorator) {
						// Yes
						selectedDecorator = tempDecorator;

						popIds = getPopulationIdsToDisplay(selectedDecorator);
						initializeCombo(populationIdCombo,
								popIds, 0);

						DecoratorSelector.this
								.notifyDecoratorSelection(selectedProperty);
					} // if Decorators changed

				} // if any decorators
			}
		} // SelectionAdapter
		);

		populationIdCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			final SelectionEvent e) {
				// Any Decorator properties?
				if (!(popIds == null)) {
					// Yes
					// Is it different?
					final String temp = popIds[populationIdCombo.getSelectionIndex()];
					if (!selectedProperty.equals(temp)) {
						// Yes
						selectedProperty = temp;
						DecoratorSelector.this
								.notifyDecoratorSelection(selectedProperty);
					} // if

				} // if
			} // widgetSelected

		} // SelectionAdapter
				);
		if(!allowDecoratorSelection)populationIdCombo.setEnabled(false);
		setSimulation(null);
	} // PropertySelector

	void notifyDecoratorSelection(final String selectedId) {
		// Is there a property?
		if (selectedProperty != null) {
			// Yes
			fireDecoratorSelectionEvent(new DecoratorSelectionEvent(
					selectedDecorator, selectedId, this));
		} // if
	} // notifyDecoratorSelection

	/**
	 * @return <code>true</code> if the control has been initialized.
	 */
	public boolean isInitialized() {
		return !(decorators == null || decorators.isEmpty());
	} // isInitialized

	/**
	 * @param decorators
	 */
	public void setDecorators(final List<Decorator> decorators) {
		this.decorators = decorators;
		selectedDecorator = decorators.isEmpty() ? null : decorators.get(0);
		popIds = getPopulationIdsToDisplay(selectedDecorator);
		if(popIds == null)popIds = new String[0];
		selectedProperty = (popIds.length==0)? "":popIds[0]; // pick the first one

		initializeCombo(decoratorsCombo, getDecoratorNames(decorators),
				getDecoratorIndex(selectedDecorator, decorators));

		initializeCombo(populationIdCombo, popIds,
				0);

		notifyDecoratorSelection(selectedProperty);
	} // setDecorators

	/**
	 * Initialize the control from a
	 * {@link org.eclipse.stem.jobs.simulation.Simulation} instance.
	 * 
	 * @param simulation
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}
	 */
	public void setSimulation(final ISimulation simulation) {
		this.simulation = simulation;
		setDecorators(getDecoratorsToDisplay(simulation));
	} // setSimulation

	/**
	 * @return the simulation
	 */
	public final ISimulation getSimulation() {
		return simulation;
	}

	/**
	 * @param decoratorFilter
	 *            the filter that determines which {@link Decorator}s will be
	 *            displayed.
	 */
	public void setDecoratorFilter(final DecoratorFilter decoratorFilter) {
		this.decoratorFilter = decoratorFilter;
	} // setDecoratorFilter


	/**
	 * @param simulation
	 *            the simulation that contains {@link Decorator}s
	 * @return a {@link List} of the {@link Decorator}s whose properties
	 */
	private List<Decorator> getDecoratorsToDisplay(final ISimulation simulation) {
		final List<Decorator> retValue = new ArrayList<Decorator>();

		// Got Simulation?
		if (simulation != null) {
			// Yes
			final Graph canonicalGraph = simulation.getScenario()
					.getCanonicalGraph();
			// Is the canonicalGraph initialized yet?
			if (canonicalGraph != null) {
				// Yes
				// Go through the Decorators keeping the ones that the filter
				// says are ok.
				for (final Object element : canonicalGraph.getDecorators()) {
					final Decorator decorator = (Decorator) element;
					// Acceptable?
					if (decoratorFilter.accept(decorator)) {
						retValue.add(decorator);
					} // if has a title
				} // for each decorator
			} // if got graph
		} // if got simulation
		return retValue;
	} // getDecoratorsToDisplay

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
	String [] getPopulationIdsToDisplay(
			final Decorator decorator) {
		if(decorator == null) return null;
		PopulationEnumeratorAdapter pea = (PopulationEnumeratorAdapter)PopulationEnumeratorAdapterFactory.INSTANCE.adapt(decorator, PopulationEnumerator.class);
		
		if(pea != null) 
			return pea.getPopulationIdentifiers();
		
		if(decorator instanceof DiseaseModel) {
			String [] res = new String[1];
			res[0]= ((DiseaseModel)decorator).getPopulationIdentifier();
			return res;
		}
		if(decorator instanceof PopulationModel) {
			String [] res = new String[1];
			res[0]= ((PopulationModel)decorator).getPopulationIdentifier();
			return res;
		}
		return null; // none found
	} // getPopulationIdsToDisplay

	// /**
	// * @param decorators
	// * the {@link Decorators} in the simulation that whose state
	// * values can be visualized.
	// * @return one of the {@link Decorators}
	// */
	// private Decorator selectCurrentDecorator(final List<Decorator>
	// decorators) {
	// return decorators.get(0);
	// } // selectCurrentDecorator


	/**
	 * @return the {@link Decorator} selected in the control, or
	 *         <code>null</code> if one is not currently selected.
	 */
	// public Decorator getSelectedDecorator() {
	// return selectedDecorator;
	// } // getSelectedDecorator
	//
	// /**
	// * @return the {@link ItemPropertyDescriptor} selected in the control, or
	// * <code>null</code> if one is not currently selected.
	// */
	// public ItemPropertyDescriptor getSelectedProperty() {
	// return selectedDecoratorProperty;
	// } // getSelectedProperty
	//
	// /**
	// * @return a display name of the selected property. This is the key to the
	// * selected relative Value
	// *
	// */
	// public String getSelectedPropertyString() {
	// String retVal = "no property selected";
	// if (selectedDecoratorProperty != null) {
	// retVal = selectedDecoratorProperty
	// .getDisplayName(selectedDecoratorProperty);
	// }
	// return retVal;
	// } // getSelectedProperty
	/**
	 * @param combo
	 * @param names
	 * @param selectionIndex
	 */
	void initializeCombo(final Combo combo, final String[] names,
			final int selectionIndex) {
		combo.setItems(names);
		combo.select(selectionIndex);
	} // initializeCombo

	/**
	 * @param decorators
	 *            a list of {@link Decorator}s
	 * @return an array of the names of the {@link Decorators}.
	 */
	private String[] getDecoratorNames(final List<Decorator> decorators) {
		final List<String> retValue = new ArrayList<String>();
		if (decorators != null) {
			// Yes
			for (final Decorator decorator : decorators) {
				retValue.add(decorator.getDublinCore().getTitle());
			} // for each decorator
		} // if
		return retValue.toArray(new String[] {});
	} // getDecoratorNames

	/**
	 * @param selectedDecorator
	 * @param decorators
	 *            a list of {@link Decorator}s.
	 * @return the position (0 origin) of the selectedDecorator in decorators,
	 *         or 0, if the decorators list is empty.
	 */
	private int getDecoratorIndex(final Decorator selectedDecorator,
			final List<Decorator> decorators) {
		if (selectedDecorator != null && decorators != null
				&& !decorators.isEmpty()) {
			// Yes
			return decorators.indexOf(selectedDecorator);
		} // if
		return 0;
	} // getDecoratorIndex

	/**
	 * @param selectedDecoratorProperty
	 * @param decoratorProperties
	 * @return the index of the selectedDecoratorProperty in the
	 *         decoratorProperites list, or 0 if selectedDecoratorProperty is
	 *         <code>null</code>
	 */
	int getPropertyIndex(
			final ItemPropertyDescriptor selectedDecoratorProperty,
			final List<ItemPropertyDescriptor> decoratorProperties) {
		if (selectedDecoratorProperty != null) {
			// Yes
			return decoratorProperties.indexOf(selectedDecoratorProperty);
		} // if
		return 0;
	} // getPropertyIndex

	
	/**
	 * @param listener
	 */
	public void addDecoratorSelectionListener(
			final DecoratorSelectionListener listener) {
		propertySelectionListeners.add(listener);
	}

	/**
	 * @param listener
	 */
	public void removeDecoratorSelectionListener(
			final DecoratorSelectionListener listener) {
		propertySelectionListeners.remove(listener);
	}

	private void fireDecoratorSelectionEvent(final DecoratorSelectionEvent pse) {
		for (final DecoratorSelectionListener listener : propertySelectionListeners) {
			listener.decoratorSelected(pse);
		} // for each DecoratorSelectionListener
	} // fireDecoratorSelectionEvent

	/**
	 * This interface is implemented by classes that determine if a
	 * {@link Decorator} meets some specified criteria.
	 */
	public interface DecoratorFilter {
		/**
		 * @param decorator
		 * @return <code>true</code> if the {@link Decorator} is acceptable.
		 */
		boolean accept(final Decorator decorator);
	} // DecoratorFilter

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
	 * This interface is implemented by classes that wish to be notified
	 * whenever a property is selected in this widget.
	 */
	public interface DecoratorSelectionListener {
		/**
		 * @param propertySelectionEvent
		 */
		void decoratorSelected(DecoratorSelectionEvent decoratorSelectionEvent);
	} // DecoratorSelectionListener

	/**
	 * This class represents the event of a property being selected in the
	 * widget.
	 */
	public static class DecoratorSelectionEvent extends EventObject {
		private static final long serialVersionUID = 1L;
		private transient final String id;
		private transient final Decorator decorator;

		/**
		 * @param decorator
		 *            the {@link Decorator}
		 * @param property
		 *            the property that was selected.
		 * @param source
		 */
		public DecoratorSelectionEvent(final Decorator decorator,
				final String id, final Object source) {
			super(source);
			this.decorator = decorator;
			this.id = id;
		}

		/**
		 * @return the decorator
		 */
		public final Decorator getDecorator() {
			return decorator;
		}

		/**
		 * @return the property
		 */
		public final String getId() {
			return id;
		}

		/**
		 * @see java.util.EventObject#toString()
		 */
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder(
					decorator == null ? "null," : decorator.getDublinCore()
							.getTitle());
			sb.append(id == null ? "null" : id);
			return sb.toString();
		}
	} // DecoratorSelectionEvent

	/**
	 * @return the display label
	 */
	public String getDisplayLabel() {
		return displayLabel.getText();
	}

	/**
	 * @param displayLabel
	 *            the label to display above the property selector
	 */
	public void setDisplayLabel(final String displayLabel) {
		this.displayLabel.setText(displayLabel);
	}

} // PropertySelector

// ColorProviderPropertiesComposite.java
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
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * This class is a compound SWT {@link org.eclipse.swt.widgets.Widget} that allows for the selection of
 * a properties of a {@link Decorator}.
 */
public class ColorProviderPropertiesComposite extends Composite {

	/**
	 * A list of {@link PropertySelectionListener}s to be notified about
	 * property selection events
	 */
	private final List<PropertySelectionListener> propertySelectionListeners = new CopyOnWriteArrayList<PropertySelectionListener>();
	/**
	 * The initial property name to be selected when the composite is being
	 * initialized
	 */
	private String initialPropertyName;
	/**
	 * The {@link Combo} of available properties
	 */
	Combo propertiesCombo;
	/**
	 * The properties
	 */
	List<ItemPropertyDescriptor> properties;
	/**
	 * The selected property
	 */
	ItemPropertyDescriptor selectedProperty;

	// /**
	// * The selected decorator
	// */
	// Decorator selectedDecorator;

	/**
	 * Constructor
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 * @param style
	 *            an SWT style
	 */
	public ColorProviderPropertiesComposite(final Composite parent,
			final int style) {
		super(parent, style);
		final FormLayout retValueLayout = new FormLayout();
		this.setLayout(retValueLayout);

		// Combo Box of the Decorator Properties
		propertiesCombo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY
				| SWT.CENTER);

		final FormData propertiesComboFormData = new FormData();
		propertiesComboFormData.top = new FormAttachment(0, 0);
		propertiesComboFormData.left = new FormAttachment(0, 0);
		propertiesComboFormData.right = new FormAttachment(100, 0);
		propertiesCombo.setLayoutData(propertiesComboFormData);
		propertiesCombo.setEnabled(false);

		this.pack();

		propertiesCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(
					@SuppressWarnings("unused") final SelectionEvent e) {
				// Any Decorator properties?
				if (!properties.isEmpty()) {
					// Yes
					// Is it different?
					final ItemPropertyDescriptor temp = properties
							.get(propertiesCombo.getSelectionIndex());
					if (selectedProperty != temp) {
						// Yes
						selectedProperty = temp;
						notifyPropertySelection(selectedProperty);
					} // if
				} // if
			} // widgetSelected
		} // SelectionAdapter
				);
	} // ColorProviderPropertiesComposite

	/**
	 * Notify listeners about a property that has been selected
	 * 
	 * @param selectedProperty
	 *            the selected property
	 */
	void notifyPropertySelection(final ItemPropertyDescriptor selectedProperty) {
		// Is there a property?
		if (selectedProperty != null) {
			// Yes
			firePropertySelectionEvent(new PropertySelectionEvent(
					selectedProperty, this));
		} // if
	} // notifyPropertySelection

	/**
	 * Return a list of {@link ItemPropertyDescriptor}s for the specific
	 * {@link Decorator}.
	 * 
	 * @param decorator
	 *            a {@link Decorator} that modifies the state of the canonical
	 *            {@link org.eclipse.stem.core.graph.Graph} in the
	 *            {@link org.eclipse.stem.jobs.simulation.Simulation}.
	 * @return a {@link List} of the properties of the {@link Decorator} that
	 *         can be displayed.
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
	 * Returns the default selected {@link ItemPropertyDescriptor}.
	 * 
	 * @return the property of the decorator that should be the one to be
	 *         displayed or <code>null</code> if decoratorProperties is empty
	 */
	public ItemPropertyDescriptor getDefaultSelectedProperty() {
		// Look for a property with a name that matches the one specified in
		// the preferences.
		for (final ItemPropertyDescriptor property : properties) {
			// name match?
			if (property.getDisplayName(property).equals(initialPropertyName)) {
				// Yes
				return property;
			} // if
		} // for each ItemPropertyDescriptor
		// Didn't find a match, just use the first one.
		// Any to use?
		if (!properties.isEmpty()) {
			// Yes
			return properties.get(0);
		} // if
		return null;
	} // selectCurrentDecoratorProperty

	/**
	 * Initializes the {@link Composite} with the specific {@link Decorator}.
	 * 
	 * @param decorator
	 *            the {@link Decorator} to initialize with
	 */
	public void initialize(final Decorator decorator) {
		properties = getPropertiesToDisplay(decorator);
		selectedProperty = getDefaultSelectedProperty();
		final boolean comboIsEnabled = (decorator != null ? true : false);
		initializeCombo(this.propertiesCombo, getPropertyNames(properties),
				getPropertyIndex(selectedProperty, properties), comboIsEnabled);

		// notifyPropertySelection(selectedProperty);
		ColorProviderPropertiesComposite.this
				.notifyPropertySelection(selectedProperty);
	} // initialize

	/**
	 * Initializes the properties {@link Combo} box
	 * 
	 * @param combo
	 *            the properties {@link Combo}
	 * @param names
	 *            the values to be added to the {@link Combo}
	 * @param selectionIndex
	 *            index of the selected item
	 * @param isEnabled
	 *            is the {@link Combo} enabled/disabled
	 */
	void initializeCombo(final Combo combo, final String[] names,
			final int selectionIndex, final boolean isEnabled) {
		combo.setItems(names);
		combo.select(selectionIndex);
		propertiesCombo.setEnabled(isEnabled);
	} // initializeCombo

	/**
	 * Get the properties names.
	 * 
	 * @param properties
	 *            a list of {@link Decorator} properties.
	 * @return the names of the properties.
	 */
	String[] getPropertyNames(final List<ItemPropertyDescriptor> properties) {
		final List<String> retValue = new ArrayList<String>();
		if (properties != null) {
			// Yes
			for (final ItemPropertyDescriptor property : properties) {
				retValue.add(property.getDisplayName(property));
			} // for each ItemPropertyDescriptor
		} // if
		return retValue.toArray(new String[] {});
	} // getPropertyNames

	/**
	 * Get the index of the selected property.
	 * 
	 * @param selectedDecoratorProperty
	 *            the selected property
	 * @param decoratorProperties
	 *            the list of all properties
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
	 * Add a {@link PropertySelectionListener} to the list of listeners.
	 * 
	 * @param listener
	 *            the {@link PropertySelectionListener} to be added
	 */
	public void addPropertySelectionListener(
			final PropertySelectionListener listener) {
		propertySelectionListeners.add(listener);
	} // addPropertySelectionListener

	/**
	 * Remove the {@link PropertySelectionListener} from the list of listeners.
	 * 
	 * @param listener
	 *            the {@link PropertySelectionListener} to be removed
	 */
	public void removePropertySelectionListener(
			final PropertySelectionListener listener) {
		propertySelectionListeners.remove(listener);
	} // removePropertySelectionListener

	/**
	 * Notify {@link PropertySelectionListener}s about a
	 * {@link PropertySelectionEvent}.
	 * 
	 * @param pse
	 *            the event to notify about
	 */
	private void firePropertySelectionEvent(final PropertySelectionEvent pse) {
		for (final PropertySelectionListener listener : propertySelectionListeners) {
			listener.propertySelected(pse);
		} // for each PropertySelectionListener
	} // firePropertySelectionEvent

	/**
	 * This interface is implemented by classes that wish to be notified
	 * whenever a property is selected in this widget.
	 */
	public interface PropertySelectionListener {
		/**
		 * @param propertySelectionEvent
		 */
		void propertySelected(PropertySelectionEvent propertySelectionEvent);
	} // PropertySelectionListener

	/**
	 * This class represents the event of a property being selected in the
	 * {@link Widget}.
	 */
	public static class PropertySelectionEvent extends EventObject {
		private static final long serialVersionUID = 1L;
		//$ANALYSIS-IGNORE
		private transient final ItemPropertyDescriptor property;

		/**
		 * @param property
		 *            the property that was selected.
		 * @param source
		 */
		public PropertySelectionEvent(final ItemPropertyDescriptor property,
				final Object source) {
			super(source);
			this.property = property;
		}

		/**
		 * @return the property
		 */
		public final ItemPropertyDescriptor getProperty() {
			return property;
		}

		/**
		 * @see java.util.EventObject#toString()
		 */
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			sb.append(property == null ? "null" : property
					.getDisplayName(property));
			return sb.toString();
		}
	} // PropertySelectionEvent

	// /**
	// * This method may be used to initialize a properties combo to display
	// * (select) a particular property
	// *
	// * @param preferredProperty
	// * the name of the property to display.
	// * @return <code>true</code> if the preferredProperty was found,
	// * <code>false</code> otherwise.
	// */
	// public boolean setDisplayedProperty(final String preferredProperty) {
	// final int index = propertiesCombo.indexOf(preferredProperty);
	// if (index >= 0) {
	// propertiesCombo.select(index);
	// initialPropertyName = preferredProperty;
	// properties = getPropertiesToDisplay(selectedDecorator);
	// for (final ItemPropertyDescriptor property : properties) {
	// // name match?
	// if (property.getDisplayName(property).equals(
	// initialPropertyName)) {
	// // Yes
	// selectedProperty = property;
	// break;
	// } // if
	// } // for each ItemPropertyDescriptor
	// firePropertySelectionEvent(new PropertySelectionEvent(selectedProperty,
	// propertiesCombo));
	// return true;
	// }// if selector has items
	// return false;
	// }// setDisplayedPropperty()
	//	
	// public void setSelectedDecorator(final Decorator decorator) {
	// this.selectedDecorator = decorator;
	// properties = getPropertiesToDisplay(selectedDecorator);
	// selectedProperty = selectCurrentDecoratorProperty(properties);
	//
	// initializeCombo(propertiesCombo,
	// getPropertyNames(properties), getPropertyIndex(
	// selectedProperty, properties), true);
	//
	// ColorProviderPropertiesComposite.this.notifyPropertySelection(selectedProperty);
	// }
	//	
	// /**
	// * This interface is implemented by classes that determine if a
	// * {@link Decorator} meets some specified criteria.
	// */
	// public interface DecoratorFilter {
	// /**
	// * @param decorator
	// * @return <code>true</code> if the {@link Decorator} is acceptable.
	// */
	// boolean accept(final Decorator decorator);
	// } // DecoratorFilter
	//
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
	 * @param propertySieve
	 *            the sieve that selects the properties of a {@link Decorator}
	 *            that should be displayed.
	 */
	public void setPropertySieve(final PropertySieve propertySieve) {
		this.propertySieve = propertySieve;
	} // setPropertySieve

	/**
	 * The default sieve selects those properties that have relative values.
	 */
	private PropertySieve propertySieve = new PropertySieve() {
		/**
		 * @see ColorProviderPropertiesComposite.PropertySieve#sieve(org.eclipse.stem.core.graph.DynamicLabel)
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
	 * The method returns the initial property to be selected
	 * @return the initialPropertyName
	 */
	public String getInitialPropertyName() {
		return initialPropertyName;
	} // getInitialPropertyName

	/**
	 * The method sets the initial property to be selected
	 * @param initialPropertyName the initialPropertyName to set
	 */
	public void setInitialPropertyName(String initialPropertyName) {
		this.initialPropertyName = initialPropertyName;
	} // setInitialPropertyName

	/**
	 * @return the selectedProperty
	 */
	public ItemPropertyDescriptor getSelectedProperty() {
		return selectedProperty;
	}

} // ColorProviderPropertiesComposite

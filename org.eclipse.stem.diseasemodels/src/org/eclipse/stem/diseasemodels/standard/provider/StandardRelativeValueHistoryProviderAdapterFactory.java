// StandardRelativeHistoryValueProviderAdapterFactory.java
package org.eclipse.stem.diseasemodels.standard.provider;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.adapters.history.HistoryProvider;
import org.eclipse.stem.adapters.history.HistoryProviderAdapter;
import org.eclipse.stem.adapters.history.HistoryProviderAdapterFactory;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory;

/**
 * This class is a factory for this model that creates
 * {@link RelativeValueHistoryProvider}'s for classes in the model.
 */
public class StandardRelativeValueHistoryProviderAdapterFactory extends
		StandardAdapterFactory implements
		RelativeValueHistoryProviderAdapterFactory {

	/**
	 * This keeps track of the root adapter factory that delegates to this
	 * adapter factory.
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement
	 * {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This factory is used to create item providers for the adapted classes.
	 * The item providers are used as property sources to get the properties
	 * that can have relative values.
	 */
	private static StandardItemProviderAdapterFactory itemProviderFactory;

	private HistoryProviderAdapter historyProviderAdapter = null;

	/**
	 * Default Constructor
	 */
	public StandardRelativeValueHistoryProviderAdapterFactory() {
		super();
		RelativeValueHistoryProviderAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	} // StandardRelativeHistoryValueProviderAdapterFactory

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory#createAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		Adapter retValue = null;

		// Before we create our adapter, we try to adapt the target to a
		// HistoryProvider. If we can't then we're done and return null to
		// indicate that this factory can't create the adapter. If not, then we
		// remember the history provider and let the super class's method do the
		// switch on the type.
		historyProviderAdapter = (HistoryProviderAdapter) HistoryProviderAdapterFactory.INSTANCE
				.adapt(target, HistoryProvider.class);

		// Did we succeed?
		if (historyProviderAdapter != null) {
			// Yes
			retValue = super.createAdapter(target);
		} // if

		return retValue;
	} // createAdapter

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory#createDiseaseModelLabelAdapter()
	 */
	@Override
	public Adapter createDiseaseModelLabelAdapter() {
		return new DiseaseModelLabelRelativeValueHistoryProvider(
				historyProviderAdapter);
	} // createDiseaseModelLabelAdapter

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#addListener(org.eclipse.emf.edit.provider.INotifyChangedListener)
	 */
	public void addListener(final INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	} // addListener

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#fireNotifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void fireNotifyChanged(final Notification notification) {
		changeNotifier.fireNotifyChanged(notification);
		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	} // fireNotifyChanged

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#removeListener(org.eclipse.emf.edit.provider.INotifyChangedListener)
	 */
	public void removeListener(
			final INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	} // removeListener

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#getRootAdapterFactory()
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	} // getRootAdapterFactory

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#setParentAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory)
	 */
	public void setParentAdapterFactory(
			final ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	} // setParentAdapterFactory

	/**
	 * @see org.eclipse.emf.common.notify.AdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == RelativeValueHistoryProvider.class
				|| super.isFactoryForType(type);
	}

	/**
	 * This disposes all of the item providers created by this factory.
	 * 
	 * @see org.eclipse.emf.edit.provider.IDisposable#dispose()
	 */
	public void dispose() {
		// Nothing
	} // dispose

	/**
	 * @return the instance of the Relative Value Provider Adapter Factory
	 */
	private static RelativeValueProviderAdapterFactory getRelativeValueProviderAdapterFactory() {
		return RelativeValueProviderAdapterFactory.INSTANCE;
	} // getRelativeValueProviderAdapterFactory

	/**
	 * This class is a Relative Value History Provider for DiseaseModelLabel
	 * instances. It provides a collection of the properties that can have
	 * relative values and will compute the value between 0.0 and 1.0 for any of
	 * those properties. It will also provide historic relative values.
	 * 
	 * @see DiseaseModelLabelValueRelativeValueHistoryProvider
	 */
	public static class DiseaseModelLabelRelativeValueHistoryProvider extends
			RelativeValueHistoryProviderAdapter implements
			RelativeValueHistoryProvider {

		private HistoryProviderAdapter historyProviderAdapter = null;

		/**
		 * @param historyProviderAdapter
		 */
		public DiseaseModelLabelRelativeValueHistoryProvider(
				final HistoryProviderAdapter historyProviderAdapter) {
			this.historyProviderAdapter = historyProviderAdapter;
			historyProviderAdapter.addExtensionListener(this);
		} // DiseaseModelLabelRelativeValueHistoryProvider

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter#getProperties()
		 */
		@Override
		public List<IItemPropertyDescriptor> getProperties() {
			final DiseaseModelLabel dml = (DiseaseModelLabel) getTarget();
			final RelativeValueProvider rvp = (RelativeValueProvider) getRelativeValueProviderAdapterFactory()
					.adapt(dml.getCurrentValue(), RelativeValueProvider.class);
			return rvp.getProperties();
		} // getProperties

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter#getRelativeValue(org.eclipse.emf.ecore.EStructuralFeature)
		 */
		@Override
		public double getRelativeValue(final EStructuralFeature feature) {
			final DiseaseModelLabel dml = (DiseaseModelLabel) getTarget();
			final RelativeValueProvider rvp = (RelativeValueProvider) getRelativeValueProviderAdapterFactory()
					.adapt(dml.getCurrentValue(), RelativeValueProvider.class);
			return rvp.getRelativeValue(feature);
		} // getRelativeValue

		/**
		 * This method returns the denominator or scale used to convert to relative
		 * values in the range 0-1. For example, in an Epidemic Compartment model
		 * the state values are normalized by population.
		 * It is required whenever we need to switch between relative and absolute values
		 * or can be used to create a label showing the maximum scale for any relative value.
		 * @return the denominator or scale used to normalize the relative value
		 */
		public double getDenominator() {
			final DiseaseModelLabel dml = (DiseaseModelLabel) getTarget();
			DiseaseModelLabelValue dmlv = (DiseaseModelLabelValue)dml.getCurrentValue();
			final double populationCount = dmlv.getPopulationCount();
			return dmlv.getPopulationCount();
		}
		
		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getRelativeValue(org.eclipse.emf.edit.provider.ItemPropertyDescriptor,
		 *      org.eclipse.stem.core.model.STEMTime)
		 */
		@Override
		public double getRelativeValue(final ItemPropertyDescriptor property,
				final STEMTime time) {
			return getRelativeValue((EStructuralFeature) property
					.getFeature(null), time);
		}

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter#getRelativeValue(org.eclipse.emf.ecore.EStructuralFeature,
		 *      org.eclipse.stem.core.model.STEMTime)
		 */
		@Override
		public double getRelativeValue(final EStructuralFeature feature,
				final STEMTime time) {
			historyProviderAdapter.setTarget(getTarget());
			final DiseaseModelLabel dml = (DiseaseModelLabel) historyProviderAdapter
					.getInstance(time);
			final RelativeValueProviderAdapter rvp = (RelativeValueProviderAdapter) RelativeValueProviderAdapterFactory.INSTANCE
					.adapt(dml, RelativeValueProvider.class);
			return rvp.getRelativeValue(feature);
		} // getRelativeValue

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getAllHistoricRelativeValues(org.eclipse.emf.edit.provider.ItemPropertyDescriptor)
		 */
		@Override
		public double[] getAllHistoricRelativeValues(
				final ItemPropertyDescriptor property) {
			return getAllHistoricRelativeValues((EStructuralFeature) property
					.getFeature(null));
		}

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter#getAllHistoricRelativeValues(org.eclipse.emf.ecore.EStructuralFeature)
		 */
		@Override
		public double[] getAllHistoricRelativeValues(
				final EStructuralFeature feature) {
			historyProviderAdapter.setTarget(getTarget());
			final Identifiable[] historicValues = historyProviderAdapter
					.getAllHistoricInstances();
			final double[] retValue = new double[historicValues.length];

			int i = 0;
			for (Identifiable identifiable : historicValues) {
				final DiseaseModelLabel dml = (DiseaseModelLabel) identifiable;
				final RelativeValueProviderAdapter rvp = (RelativeValueProviderAdapter) RelativeValueProviderAdapterFactory.INSTANCE
						.adapt(dml, RelativeValueProvider.class);
				retValue[i++] = rvp.getRelativeValue(feature);
			} // for each Identifiable

			return retValue;
		} // getAllHistoricRelativeValues
		

		/**
		 * 
		 * @param property
		 * @param timeRange
		 * @return
		 */
		public double[] getHistoricInstances(final ItemPropertyDescriptor property, STEMTime[] timeRange) {
			double[] allValues = getAllHistoricRelativeValues(property);
			double[] retVal = new double[timeRange.length];
			System.arraycopy(allValues, 0, retVal, 0, timeRange.length);
			return retVal;
		}

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter#getEarliestTimeValue()
		 */
		@Override
		public STEMTime getEarliestTimeValue() {
			historyProviderAdapter.setTarget(getTarget());
			return historyProviderAdapter.getEarliestTimeValue();
		} // getEarliestTimeValue

		/**
		 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter#getAllHistoricTimeValues()
		 */
		@Override
		public STEMTime[] getAllHistoricTimeValues() {
			historyProviderAdapter.setTarget(getTarget());
			return historyProviderAdapter.getAllHistoricTimeValues();
		} // getAllHistoricTimeValues

	} // DiseaseModelLabelRelativeValueHistoryProvider

} // StandardRelativeValueHistoryProviderAdapterFactory

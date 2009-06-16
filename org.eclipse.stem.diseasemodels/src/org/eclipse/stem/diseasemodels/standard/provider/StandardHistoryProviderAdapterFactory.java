// StandardHistoryProviderAdapterFactory.java
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

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.stem.adapters.history.HistoryProvider;
import org.eclipse.stem.adapters.history.HistoryProviderAdapter;
import org.eclipse.stem.adapters.history.HistoryProviderAdapterFactory;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory;

/**
 * This class represents
 */
public class StandardHistoryProviderAdapterFactory extends
		StandardAdapterFactory implements RelativeValueProviderAdapterFactory {

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
	 * Default Constructor
	 */
	public StandardHistoryProviderAdapterFactory() {
		super();
		HistoryProviderAdapterFactory.INSTANCE.addAdapterFactory(this);
	} // StandardHistoryProviderAdapterFactory

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory#createDiseaseModelLabelAdapter()
	 */
	@Override
	public Adapter createDiseaseModelLabelAdapter() {
		return new DiseaseModelLabelHistoryProvider();
	} // createDiseaseModelLabelAdapter

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#addListener(org.eclipse.emf.edit.provider.INotifyChangedListener)
	 */
	public void addListener(final INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#fireNotifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void fireNotifyChanged(final Notification notification) {
		changeNotifier.fireNotifyChanged(notification);
		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * @see org.eclipse.emf.edit.provider.IChangeNotifier#removeListener(org.eclipse.emf.edit.provider.INotifyChangedListener)
	 */
	public void removeListener(
			final INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#getRootAdapterFactory()
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory
				.getRootAdapterFactory();
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ComposeableAdapterFactory#setParentAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory)
	 */
	public void setParentAdapterFactory(
			final ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == HistoryProvider.class || super.isFactoryForType(type);
	} // isFactoryForType

	/**
	 * @see org.eclipse.emf.edit.provider.IDisposable#dispose()
	 */
	public void dispose() {
		// Nothing
	}

	/**
	 * This class is a History Provider for DiseaseModelLabel instances. It
	 * provides a collection of historic values of a DiseaseModelLabel
	 */
	private static class DiseaseModelLabelHistoryProvider extends
			HistoryProviderAdapter implements HistoryProvider {

		long cycle = 0L;
		final STEMTime startTime = ModelFactory.eINSTANCE.createSTEMTime();

		final Map<STEMTime, DiseaseModelLabel> history = Collections.synchronizedMap(new TreeMap<STEMTime, DiseaseModelLabel>());

		
		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(final Notification msg) {
			switch (msg.getEventType()) {
			case Notification.SET:
				// Is it setting the nextValue?
				switch (msg.getFeatureID(LabelValue.class)) {
				case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE:
					// If the next value null?
					
					if (msg.getNewValue() != null) {
						// No
						STEMTime timeKey = generateNextSTEMTime(cycle++);
						synchronized (history) {
							// Make of copy of the disease model label
							final DiseaseModelLabel dml = (DiseaseModelLabel) EcoreUtil
									.copy((DiseaseModelLabel) getTarget());
							// When you copy an EObject, the references are
							// copied as well this means that the Node that
							// referenced the original DiseaseModelLabel will
							// also reference the copy. This adds the copy to
							// the list of Labels maintained by the Node. We
							// need to remove it from the list so that we don't
							// get extraneous Labels hanging around.
							dml.getNode().getLabels().remove(dml);
							history.put(timeKey, dml);
						}// synchronized
						fireHistoryExtended();
					} // if not null
					break;

				default:
					break;
				} // switch LabelValue feature Id
				break;

			default:
				break;
			} // switch

		} // notifyChanged

		/**
		 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getAllHistoricTimeValues()
		 */
		@Override
		public STEMTime[] getAllHistoricTimeValues() {
			STEMTime[] time = null;
			synchronized(history) {
				time=history.keySet().toArray(new STEMTime[0]);
			}
			return time;
		}

		/**
		 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getAllHistoricInstances()
		 */
		@Override
		public Identifiable[] getAllHistoricInstances() {
			Identifiable[] allInstances = null;
			synchronized(history) {
				allInstances=history.values().toArray(new Identifiable[0]);
			}
			return allInstances;
		}

		

		/**
		 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getHistoricInstances()
		 */
		@Override
		public Identifiable[] getHistoricInstances(STEMTime[] timeRange) {
			Identifiable[] allValues = getAllHistoricInstances();
			Identifiable[] retVal = new Identifiable[timeRange.length];
			System.arraycopy(allValues, 0, retVal, 0, timeRange.length);
			return retVal;
		}
		
		/**
		 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getEarliestCycleNumber()
		 */
		@Override
		public int getEarliestCycleNumber() {
			long retValue = 0;
			synchronized(history) {
				try {
					retValue = history.keySet().toArray(new Long[0])[0].longValue();
				} catch (final RuntimeException e) {
					// Ignore, return 0
				}
			}
			return (int) retValue;
		} // getEarliestCycleNumber

		/**
		 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getEarliestTimeValue()
		 */
		@Override
		public STEMTime getEarliestTimeValue() {
			return generateHistoricSTEMTime(getEarliestCycleNumber());
		}

		/**
		 * @return
		 */
		private STEMTime generateHistoricSTEMTime(final int daysInPast) {
			final STEMTime retValue = ModelFactory.eINSTANCE.createSTEMTime();
			final long daysAgo = retValue.getTime().getTime() - daysInPast
					* STEMTime.Units.DAY.getMilliseconds();
			retValue.setTime(new Date(daysAgo));
			return retValue;
		} // generateHistoricSTEMTime
		

		/**
		 * @return
		 */
		private STEMTime generateNextSTEMTime(final long daysInFuture) {
			final STEMTime retValue = ModelFactory.eINSTANCE.createSTEMTime();
			final long day = startTime.getTime().getTime() + daysInFuture
					* STEMTime.Units.DAY.getMilliseconds();
			retValue.setTime(new Date(day));
			return retValue;
		} // generateHistoricSTEMTime
		
		

		/**
		 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#reset()
		 */
		@Override
		public void reset() {

			cycle = 0;
			synchronized(history) {
				history.clear();
			}
			
			// The super class will tell the listeners that the history has
			// changed.
			super.reset();
		}

	} // DiseaseModelLabelHistoryProvider

} // StandardHistoryProviderAdapterFactory

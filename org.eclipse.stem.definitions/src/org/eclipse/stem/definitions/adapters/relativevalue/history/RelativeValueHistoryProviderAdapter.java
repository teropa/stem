// RelatieValueHistoryProviderAdapter.java
package org.eclipse.stem.definitions.adapters.relativevalue.history;

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
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.adapters.history.HistoryExtendedListener;
import org.eclipse.stem.adapters.history.HistoryProviderAdapter;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;

/**
 * This class adapts <code>EObjects</code>'s to
 * <code>RelativeValueProvider</code>'s.
 */
public abstract class RelativeValueHistoryProviderAdapter extends
		RelativeValueProviderAdapter implements RelativeValueHistoryProvider,
		HistoryExtendedListener {

	private List<RelativeValueHistoryExtendedListener> extensionListeners = new CopyOnWriteArrayList<RelativeValueHistoryExtendedListener>();

	// This should be removed DAF
	private static final int earliestCycleNumber = 0;

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getRelativeValue(org.eclipse.emf.edit.provider.ItemPropertyDescriptor,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	public double getRelativeValue(final ItemPropertyDescriptor property,
			final STEMTime time) {
		return getRelativeValue((EStructuralFeature) property.getFeature(null),
				time);
	}

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getRelativeValue(org.eclipse.emf.ecore.EStructuralFeature,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	abstract public double getRelativeValue(EStructuralFeature feature,
			STEMTime time);

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getAllHistoricRelativeValues(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	abstract public double[] getAllHistoricRelativeValues(
			EStructuralFeature feature);

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getAllHistoricRelativeValues(org.eclipse.emf.edit.provider.ItemPropertyDescriptor)
	 */
	public double[] getAllHistoricRelativeValues(
			final ItemPropertyDescriptor property) {
		return getAllHistoricRelativeValues((EStructuralFeature) property
				.getFeature(null));
	}

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getAllHistoricTimeValues()
	 */
	abstract public STEMTime[] getAllHistoricTimeValues();

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getEarliestTimeValue()
	 */
	abstract public STEMTime getEarliestTimeValue();

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getEarliestCycleNumber()
	 */

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider#getEarliestCycleNumber()
	 */
	public int getEarliestCycleNumber() {
		return earliestCycleNumber;
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(final Object type) {
		return type == RelativeValueHistoryProvider.class;
	}

	/**
	 * @see org.eclipse.stem.adapters.history.HistoryExtendedListener#historyExtended(org.eclipse.stem.adapters.history.HistoryProviderAdapter)
	 */
	public void historyExtended(HistoryProviderAdapter historyProviderAdapter) {
		fireHistoryExtended();
	}

	public void addExtensionListener(
			RelativeValueHistoryExtendedListener listener) {
		extensionListeners.add(listener);
	}

	public void removeExtensionListener(
			RelativeValueHistoryExtendedListener listener) {
		extensionListeners.remove(listener);
	}

	protected void fireHistoryExtended() {
		for (RelativeValueHistoryExtendedListener listener : extensionListeners) {
			listener.relativeValueHistoryExtended(this);
		} // for each HistoryExtendedListener
	}

} // RelatieValueHistoryProviderAdapter

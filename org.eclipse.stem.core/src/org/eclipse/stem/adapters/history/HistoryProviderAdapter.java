// HistoryProviderAdapter.java
package org.eclipse.stem.adapters.history;

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

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.ResettableAdapter;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
//import org.eclipse.stem.core.model.impl.STEMTimeImpl;

/**
 * This class is a {@link HistoryProvider}.
 */
public class HistoryProviderAdapter extends AdapterImpl implements
		HistoryProvider, ResettableAdapter {

	private List<HistoryExtendedListener> extensionListeners = new CopyOnWriteArrayList<HistoryExtendedListener>();

	private int earliestCycleNumber = 0;

	/**
	 * @see org.eclipse.stem.adapters.history.HistoryProvider#getInstance(org.eclipse.stem.core.model.STEMTime)
	 */
	public Identifiable getInstance(STEMTime time) {
		return (Identifiable) getTarget();
	}

	/**
	 * @see org.eclipse.stem.definitions.adapters.history.HistoryProvider#getAllHistoricInstances()
	 */
	public Identifiable[] getAllHistoricInstances() {
		return new Identifiable[] {};
	}

	
	
	/**
	 * @see org.eclipse.stem.definitions.adapters.history.HistoryProvider#getHistoricInstances()
	 */
	public Identifiable[] getHistoricInstances(STEMTime[] timeRange) {
		return  new Identifiable[timeRange.length];
	}

	/**
	 * @see org.eclipse.stem.definitions.adapters.history.HistoryProvider#getAllHistoricTimeValues()
	 */
	public STEMTime[] getAllHistoricTimeValues() {
		return new STEMTime[] {};
	}

	/**
	 * @see org.eclipse.stem.definitions.adapters.history.HistoryProvider#getEarliestCycleNumber()
	 */
	public int getEarliestCycleNumber() {
		return earliestCycleNumber;
	}

	
	/**
	 * @see org.eclipse.stem.core.graph.ResettableAdapter#reset()
	 */
	public void reset() {
		fireHistoryExtended();
	} // reset

	/**
	 * @see org.eclipse.stem.definitions.adapters.history.HistoryProvider#getEarliestTimeValue()
	 */
	public STEMTime getEarliestTimeValue() {
		final STEMTime retValue = ModelFactory.eINSTANCE.createSTEMTime();
		retValue.setTime(new Date());
		return retValue;
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == HistoryProvider.class;
	}

	public void addExtensionListener(HistoryExtendedListener listener) {
		extensionListeners.add(listener);
	}

	public void removeExtensionListener(HistoryExtendedListener listener) {
		extensionListeners.remove(listener);
	}

	protected void fireHistoryExtended() {
		for (HistoryExtendedListener listener : extensionListeners) {
			listener.historyExtended(this);
		} // for each HistoryExtendedListener
	}

} // HistoryProviderAdapter

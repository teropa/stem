// HistoryProviderAdapterFactoryImplTest.java
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

import org.eclipse.stem.adapters.history.HistoryProviderAdapterFactory.HistoryProviderAdapterFactoryImpl;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This class is a JUnit test case for {@link HistoryProviderAdapterFactoryImpl}.
 */
@SuppressWarnings("all")
public class HistoryProviderAdapterFactoryImplTest extends
		HistoryProviderAdapterFactoryTest {

	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}

	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * @return the fixture for testing
	 */
	public HistoryProviderAdapterFactory createFixture() {
		return new HistoryProviderAdapterFactory.HistoryProviderAdapterFactoryImpl() {

			@Override
			public Object adapt(Object target, Object type) {
				return new HistoryProviderAdapter() {

					/**
					 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getAllHistoricTimeValues()
					 */
					@Override
					public STEMTime[] getAllHistoricTimeValues() {
						return super.getAllHistoricTimeValues();
					}

					/**
					 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getAllHistoricInstances()
					 */
					@Override
					public Identifiable[] getAllHistoricInstances() {
						return super.getAllHistoricInstances();
					}

					/**
					 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getEarliestCycleNumber()
					 */
					@Override
					public int getEarliestCycleNumber() {
						return super.getEarliestCycleNumber();
					}

					/**
					 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#getEarliestTimeValue()
					 */
					@Override
					public STEMTime getEarliestTimeValue() {
						return super.getEarliestTimeValue();
					}

					/**
					 * @see org.eclipse.stem.adapters.history.HistoryProviderAdapter#isAdapterForType(java.lang.Object)
					 */
					@Override
					public boolean isAdapterForType(Object type) {
						return super.isAdapterForType(type);
					}
				};
			} // adapt
		};
	} // createFixture

} // HistoryProviderAdapterFactoryImplTest

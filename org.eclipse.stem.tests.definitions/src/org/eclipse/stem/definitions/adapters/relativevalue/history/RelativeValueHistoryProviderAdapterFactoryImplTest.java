// RelativeValueHistoryProviderAdapterFactoryImplTest.java
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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This class represents
 */
@SuppressWarnings("all")
public class RelativeValueHistoryProviderAdapterFactoryImplTest extends
		RelativeValueHistoryProviderAdapterFactoryTest {

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
	public RelativeValueHistoryProviderAdapterFactory createFixture() {
		return new RelativeValueHistoryProviderAdapterFactory.RelativeValueHistoryProviderAdapterFactoryImpl() {

			@Override
			public Object adapt(Object target, Object type) {
				return new RelativeValueHistoryProviderAdapter() {
					@Override
					public List<IItemPropertyDescriptor> getProperties() {
						return null;
					}
					

					public double[] getHistoricInstances(
							ItemPropertyDescriptor property,
							STEMTime[] timeRange) {
						// TODO Auto-generated method stub
						return null;
					}


					@Override
					public double getRelativeValue(EStructuralFeature feature) {
						return 0;
					}

					@Override
					public double[] getAllHistoricRelativeValues(
							EStructuralFeature feature) {
						return new double[0];
					}

					@Override
					public STEMTime[] getAllHistoricTimeValues() {
						return new STEMTime[0];
					}

					@Override
					public STEMTime getEarliestTimeValue() {
						return null;
					}

					@Override
					public double getRelativeValue(EStructuralFeature feature,
							STEMTime time) {
						return 0;
					}
					
					@Override
					public double getDenominator() {
						return 0.0;
					}
					

					public int getEarliestCycleNumber() {
						return 0;
					}
				};
			} // adapt
		};
	} // createFixture

} // RelativeValueHistoryProviderAdapterFactoryImplTest

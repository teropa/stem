// RelativeValueProviderAdapterFactoryImplTest.java
package org.eclipse.stem.definitions.adapters.relativevalue;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
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


/**
 * This class is a JUnit test case for
 * {@link RelativeValueProviderAdapterFactoryImpl}.
 */
@SuppressWarnings("all")
final public class RelativeValueProviderAdapterFactoryImplTest extends
		RelativeValueProviderAdapterFactoryTest {

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
	public RelativeValueProviderAdapterFactory createFixture() {
		return new RelativeValueProviderAdapterFactory.RelativeValueProviderAdapterFactoryImpl() {

			@Override
			public Object adapt(Object target, Object type) {
				return new RelativeValueProviderAdapter() {
					@Override
					public List<IItemPropertyDescriptor> getProperties() {
						return null;
					}

					@Override
					public double getRelativeValue(EStructuralFeature feature) {
						return 0;
					}
					
					@Override
					public double getDenominator() {
						return 0.0;
					}
					
				};
			} // adapt
		};
	} // createFixture

} // RelativeValueProviderAdapterFactoryImplTest

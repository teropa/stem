// TimeProviderAdapterFactoryImplTest.java
package org.eclipse.stem.adapters.time;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.adapters.time.TimeProviderAdapterFactory.TimeProviderAdapterFactoryImpl;

/**
 * This class is a JUnit test case for {@link TimeProviderAdapterFactoryImpl}.
 */
@SuppressWarnings("all")
public class TimeProviderAdapterFactoryImplTest extends
		TimeProviderAdapterFactoryTest {

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
	public TimeProviderAdapterFactory createFixture() {
		return new TimeProviderAdapterFactory.TimeProviderAdapterFactoryImpl() {

			@Override
			public Object adapt(final Object target, final Object type) {
				return new TimeProviderAdapter() {

					/**
					 * @see org.eclipse.stem.adapters.history.
					 * 	TimeProviderAdapter#isAdapterForType(java.lang.Object)
					 */
					@Override
					public boolean isAdapterForType(final Object type) {
						return super.isAdapterForType(type);
					}
				};
			} // adapt
		};
	} // createFixture

} // TimeProviderAdapterFactoryImplTest
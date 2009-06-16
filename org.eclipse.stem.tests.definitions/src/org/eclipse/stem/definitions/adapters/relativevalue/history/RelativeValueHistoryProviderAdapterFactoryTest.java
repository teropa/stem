// RelativeValueHistoryProviderAdapterFactoryTest.java
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

import junit.framework.TestCase;

/**
 * This class is a JUnit test case for
 * RelativeValueHistoryProviderAdapterFactory
 */
abstract public class RelativeValueHistoryProviderAdapterFactoryTest extends TestCase {
	/**
	 * This is the factory under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected RelativeValueHistoryProviderAdapterFactory fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private RelativeValueHistoryProviderAdapterFactory getFixture() {
		return fixture;
	} // getFixture

	protected void setFixture(final RelativeValueHistoryProviderAdapterFactory fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapterFactory.RelativeValueProviderAdapterFactoryImpl#isFactoryForType(java.lang.Object)}.
	 */
	public void testIsFactoryForTypeObject() {
		final RelativeValueHistoryProviderAdapterFactory fixture = getFixture();
		assertTrue(fixture.isFactoryForType(RelativeValueHistoryProvider.class));
	} // testIsFactoryForTypeObject

} // RelativeValueHistoryProviderAdapterFactoryTest

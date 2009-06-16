// HistoryProviderAdapterFactoryTest.java
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

import junit.framework.TestCase;

/**
 * This class is a JUnit test case for {@link HistoryProviderAdapterFactory}.
 */
abstract public class HistoryProviderAdapterFactoryTest extends TestCase {

	/**
	 * This is the factory under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected HistoryProviderAdapterFactory fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private HistoryProviderAdapterFactory getFixture() {
		return fixture;
	} // SpatialProviderAdapterFactory

	protected void setFixture(final HistoryProviderAdapterFactory fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 */
	public void testIsFactoryForTypeObject() {
		final HistoryProviderAdapterFactory fixture = getFixture();
		assertTrue(fixture.isFactoryForType(HistoryProvider.class));
	} // testIsFactoryForTypeObject

} // HistoryProviderAdapterFactoryTest

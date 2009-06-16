// HistoryProviderAdapterTest.java
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
 * This class is a JUnit test case for <code>HistoryProviderAdapter</code>'s. 
 */
abstract public class HistoryProviderAdapterTest extends TestCase {
	/**
	 * This is the adapter under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected HistoryProviderAdapter fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private HistoryProviderAdapter getFixture() {
		return fixture;
	} // SpatialProviderAdapterFactory

	protected void setFixture(final HistoryProviderAdapter fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Test method for
	 * {@link HistoryProviderAdapter#isAdapterForType(Object)}
	 */
	public void testIsAdapterForType() {
		final HistoryProviderAdapter fixture = getFixture();
		assertTrue(fixture.isAdapterForType(HistoryProvider.class));
	} // testIsAdapterForType

} // HistoryProviderAdapterTest
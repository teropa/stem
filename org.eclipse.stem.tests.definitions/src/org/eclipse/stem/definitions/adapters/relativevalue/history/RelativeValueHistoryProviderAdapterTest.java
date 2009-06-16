// RelativeValueHistoryProviderAdapterTest.java
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
 * <code>RelativeValueHistoryProviderAdapter</code>'s.
 */
abstract public class RelativeValueHistoryProviderAdapterTest extends TestCase {
	/**
	 * This is the adapter under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected RelativeValueHistoryProviderAdapter fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private RelativeValueHistoryProviderAdapter getFixture() {
		return fixture;
	} // SpatialProviderAdapterFactory

	protected void setFixture(final RelativeValueHistoryProviderAdapter fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Test method for
	 * {@link RelativeValueHistoryProviderAdapter#isAdapterForType(Object)}
	 */
	public void testIsAdapterForType() {
		final RelativeValueHistoryProviderAdapter fixture = getFixture();
		assertTrue(fixture.isAdapterForType(RelativeValueHistoryProvider.class));
	} // testIsAdapterForType

} // RelativeValueHistoryProviderAdapterTest

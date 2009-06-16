// TimeProviderAdapterTest.java
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

import junit.framework.TestCase;

/**
 * This class is a JUnit test case for {@link TimeProviderAdapter}s.
 */
abstract public class TimeProviderAdapterTest extends TestCase {
	/**
	 * This is the adapter under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected TimeProviderAdapter fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private TimeProviderAdapter getFixture() {
		return fixture;
	} // SpatialProviderAdapterFactory

	protected void setFixture(final TimeProviderAdapter fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Test method for {@link TimeProviderAdapter#isAdapterForType(Object)}
	 */
	public void testIsAdapterForType() {
		final TimeProviderAdapter fixture = getFixture();
		assertTrue(fixture.isAdapterForType(TimeProvider.class));
	} // testIsAdapterForType

} // TimeProviderAdapterTest
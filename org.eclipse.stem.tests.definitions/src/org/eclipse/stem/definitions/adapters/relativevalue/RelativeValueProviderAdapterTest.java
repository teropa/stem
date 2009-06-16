// RelativeValueProviderAdapterTest.java
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

import junit.framework.TestCase;

/**
 * This class is a JUnit test case for <code>RelativeValueProviderAdapter</code>'s.
 */
abstract public class RelativeValueProviderAdapterTest extends TestCase {

	/**
	 * This is the adapter under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected RelativeValueProviderAdapter fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private RelativeValueProviderAdapter getFixture() {
		return fixture;
	} // getFixture

	protected void setFixture(final RelativeValueProviderAdapter fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Test method for
	 * {@link RelativeValueProviderAdapter#isAdapterForType(Object)}
	 */
	public void testIsAdapterForType() {
		final RelativeValueProviderAdapter fixture = getFixture();
		assertTrue(fixture.isAdapterForType(RelativeValueProvider.class));
	} // testIsAdapterForType

} // RelativeValueProviderAdapterTest

// TimeProviderAdapterFactoryTest.java
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
 * This class is a JUnit test case for {@link TimeProviderAdapterFactory}.
 */
abstract public class TimeProviderAdapterFactoryTest extends TestCase {

	/**
	 * This is the factory under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected TimeProviderAdapterFactory fixture = null;

	private TimeProviderAdapterFactory getFixture() {
		return fixture;
	} // getFixture

	protected void setFixture(final TimeProviderAdapterFactory fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 */
	public void testIsFactoryForTypeObject() {
		final TimeProviderAdapterFactory fixture = getFixture();
		assertTrue(fixture.isFactoryForType(TimeProvider.class));
	} // testIsFactoryForTypeObject

} // TimeProviderAdapterFactoryTest
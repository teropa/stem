// RelativeValueProviderAdapterFactoryTest.java
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
 * This class is a JUnit test case for RelativeValueProviderAdapterFactoryImpl
 */
abstract public class RelativeValueProviderAdapterFactoryTest extends TestCase {

	/**
	 * This is the factory under test. The value is set in the
	 * <code>setUp</code> method of a derived class.
	 */
	protected RelativeValueProviderAdapterFactory fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private RelativeValueProviderAdapterFactory getFixture() {
		return fixture;
	} // SpatialProviderAdapterFactory

	protected void setFixture(final RelativeValueProviderAdapterFactory fixture) {
		this.fixture = fixture;
	} // setFixture

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory.RelativeValueProviderAdapterFactoryImpl#isFactoryForType(java.lang.Object)}.
	 */
	public void testIsFactoryForTypeObject() {
		final RelativeValueProviderAdapterFactory fixture = getFixture();
		assertTrue(fixture.isFactoryForType(RelativeValueProvider.class));
	} // testIsFactoryForTypeObject

} // RelativeValueProviderAdapterFactoryTest

// SpatialProviderAdapterTest.java
package org.eclipse.stem.definitions.adapters.spatial;

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
 * This class is a JUnit test case for SpatialProviderAdapter.
 */
abstract public class SpatialProviderAdapterTest extends TestCase {

	protected SpatialProviderAdapter fixture = null;

	@SuppressWarnings("unqualified-field-access")
	private final SpatialProviderAdapter getFixture() {
		return fixture;
	}

	protected final void setFixture(SpatialProviderAdapter fixture) {
		this.fixture = fixture;
	}

	/**
	 * Test method for isAdapterForType(java.lang.Object)
	 */
	public void testIsAdapterForTypeObject() {
		final SpatialProviderAdapter fixture = getFixture();
		assertTrue(fixture.isAdapterForType(SpatialProvider.class));
	} // testIsAdapterForTypeObject

} // SpatialProviderAdapterTest

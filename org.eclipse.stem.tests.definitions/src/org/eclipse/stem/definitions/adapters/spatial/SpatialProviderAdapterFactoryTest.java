// SpatialProviderAdapterFactoryTest.java
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
 * This class is a JUnit test case for SpatialProviderAdapterFactory.
 */
abstract public class SpatialProviderAdapterFactoryTest extends TestCase {

	protected SpatialProviderAdapterFactory fixture;

	@SuppressWarnings({ "unqualified-field-access" })
	private SpatialProviderAdapterFactory getFixture() {
		return fixture;
	} // SpatialProviderAdapterFactory

	protected void setFixture(final SpatialProviderAdapterFactory fixture) {
		this.fixture = fixture;
	} // setFixture

} // SpatialProviderAdapterFactoryTest

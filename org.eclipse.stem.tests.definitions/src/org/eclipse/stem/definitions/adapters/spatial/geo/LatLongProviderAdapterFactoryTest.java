// LatLongProviderAdapterFactoryTest.java
package org.eclipse.stem.definitions.adapters.spatial.geo;

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

import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapterFactoryTest;

/**
 * This class is a JUnit test case for LatLongProviderAdapterFactory.
 */
@SuppressWarnings("all")
public class LatLongProviderAdapterFactoryTest extends
		SpatialProviderAdapterFactoryTest {

	private LatLongProviderAdapterFactory getFixture() {
		return (LatLongProviderAdapterFactory) fixture;
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		setFixture(new LatLongProviderAdapterFactory());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.LatLongProviderAdapterFactory#isFactoryForType(java.lang.Object)}.
	 */
	public void testIsFactoryForTypeObject() {
		final LatLongProviderAdapterFactory fixture = getFixture();
		assertTrue(fixture.isFactoryForType(LatLongProvider.class));
	} // testIsFactoryForTypeObject

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.LatLongProviderAdapterFactory#createAdapter(org.eclipse.emf.common.notify.Notifier)}.
	 */
	public void testCreateAdapterNotifier() {
		final Node node = GraphFactory.eINSTANCE.createNode();
		node.getDublinCore().setSpatial(
				LatLongProviderAdapterTest.SPATIAL_INLINE_TEST_URI_STRING);

		final LatLongProvider latLongProvider = (LatLongProvider) LatLongProviderAdapterFactory.INSTANCE
				.adapt(node, LatLongProvider.class);

		final LatLong result = latLongProvider.getLatLong();
		System.out.println("result = "+result);
		InlineLatLongDataProviderTest.verifyInlineLatLongResult(result);
	} // testCreateAdapterNotifier

} // LatLongProviderAdapterFactoryTest

// LatLongProviderAdapterTest.java
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
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapter;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapterTest;

/**
 * This class is a JUnit test case for LatLongProviderAdapter.
 */
@SuppressWarnings("all")
public class LatLongProviderAdapterTest extends SpatialProviderAdapterTest {

	public static final String SPATIAL_INLINE_TEST_URI_STRING = SpatialProviderAdapter.STEM_SPATIAL_SCHEME
			+ ":"
			+ InlineLatLongDataProviderTest.TEST_INLINE_LAT_LONG_URI_STRING1;

	private LatLongProviderAdapter getFixture() {
		return (LatLongProviderAdapter) fixture;
	} // LatLongProviderAdapter

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		final LatLongProviderAdapter temp = new LatLongProviderAdapter();
		final Node node = GraphFactory.eINSTANCE.createNode();
		node.getDublinCore().setSpatial(SPATIAL_INLINE_TEST_URI_STRING);
		temp.setTarget(node);
		setFixture(temp);
	} // setUp

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	public void testIsAdapterForType() {
		final LatLongProviderAdapter fixture = getFixture();
		assertTrue(fixture.isAdapterForType(LatLongProvider.class));
	} // testIsAdapterForType

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.LatLongProviderAdapter#getLatLong()}.
	 */
	public void testGetLatLong() {
		final LatLongProviderAdapter fixture = getFixture();
		final LatLong result = fixture.getLatLong();
		InlineLatLongDataProviderTest.verifyInlineLatLongResult(result);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.spatial.LatLongProviderAdapter#getCenterLatLong()}.
	 */
	public void testGetCenter() {
		final LatLongProviderAdapter fixture = getFixture();
		final double[] result = fixture.getCenter();
		assertNotNull(result);
	} // testGetCenter

} // LatLongProviderAdapterTest

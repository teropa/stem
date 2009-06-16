// GraphTimeProviderAdapterFactoryTest.java
package org.eclipse.stem.core.graph.tests;

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

import org.eclipse.stem.adapters.time.TimeProvider;
import org.eclipse.stem.adapters.time.TimeProviderAdapterFactory;
import org.eclipse.stem.adapters.time.TimeProviderAdapterFactoryImplTest;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.provider.GraphTimeProviderAdapterFactory;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

/**
 * This class is a JUnit test of the {@link GraphTimeProviderAdapterFactory}.
 */
public class GraphTimeProviderAdapterFactoryTest extends
		TimeProviderAdapterFactoryImplTest {

	private final STEMTime TEST_TIME = ModelFactory.eINSTANCE.createSTEMTime();
	
	/**
	 * @see
	 * 	org.eclipse.stem.adapters.time.TimeProviderAdapterFactoryImplTest
	 * 	#createFixture()
	 */
	@Override
	public TimeProviderAdapterFactory createFixture() {
		return new GraphTimeProviderAdapterFactory();
	}

	private GraphTimeProviderAdapterFactory getFixture() {
		return (GraphTimeProviderAdapterFactory) fixture;
	} // getFixture

	public void testAdaptGraph() {
		final GraphTimeProviderAdapterFactory fixture = getFixture();
		final Graph graph = GraphTest.createFixture();

		final TimeProvider tp = (TimeProvider) fixture.adapt(graph,
				TimeProvider.class);
		assertNotNull(tp);

		STEMTime graphTime = tp.getTime();
		assertNull(graphTime);
		
		graph.switchToNextValue(TEST_TIME);
		graphTime = tp.getTime();
		
		assertNotNull(graphTime);
		assertTrue(graphTime.equals(TEST_TIME));
	} // testAdaptGraph
} // GraphTimeProviderAdapterFactoryTest
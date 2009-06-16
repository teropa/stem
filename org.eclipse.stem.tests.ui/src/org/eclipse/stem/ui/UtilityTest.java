// UtilityTest.java
package org.eclipse.stem.ui;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.stem.core.graph.Label;

/**
 * This class is a JUnit test case for {@link Utility}.
 */
public class UtilityTest extends TestCase {

	@SuppressWarnings("unused")
	private static final URI ARUBA_AREA_0_URI = URI
			.createURI("stem://org.eclipse.stem/label/area/ABW/0/ABW");

	private static final URI POPULATION_URI = URI
			.createURI("stem://org.eclipse.stem/label/population/AFG/2/human/2006/AF-BDS-G010001");

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*",
				new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put(
				"platform", new XMIResourceFactoryImpl());
	} // setUp

	/**
	 * Test method for
	 * {@link org.eclipse.stem.ui.Utility#getLabel(org.eclipse.emf.common.util.URI)}
	 */
	public void testGetLabel() {
		final Label areaLabel = Utility.getLabel(POPULATION_URI);
		assertNotNull(areaLabel);
		assertTrue(true);
	} // testGetLabel

} // UtilityTest
// DiseaseModelLabelRelativeValueProviderTest.java
package org.eclipse.stem.tests.diseasemodels.standard.provider.tests;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterTest;
import org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory.DiseaseModelLabelRelativeValueProvider;

/**
 * This class is a JUnit test for
 * {@link DiseaseModelLabelRelativeValueProvider}
 */
@SuppressWarnings("all")
public class DiseaseModelLabelRelativeValueProviderTest extends
		RelativeValueProviderAdapterTest {

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}

	/**
	 * @return a <code>RelativeValueProviderAdapter</code> for testing
	 */
	public static DiseaseModelLabelRelativeValueProvider createFixture() {
		return new DiseaseModelLabelRelativeValueProvider();
	} // createFixture

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory.DiseaseModelLabelRelativeValueProvider#getProperties()}.
	 */
	public void testGetProperties() {
		// for someone to do
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory.DiseaseModelLabelRelativeValueProvider#getRelativeValue(org.eclipse.emf.ecore.EStructuralFeature)}.
	 */
	public void testGetRelativeValueEStructuralFeature() {
		// for someone to do
		assertTrue(true);
	} // testGetRelativeValueEStructuralFeature

} // DiseaseModelLabelRelativeValueProviderTest

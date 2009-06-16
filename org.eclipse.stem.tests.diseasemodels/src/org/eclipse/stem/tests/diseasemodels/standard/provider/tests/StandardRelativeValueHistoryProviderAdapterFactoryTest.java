// StandardRelativeValueHistoryProviderAdapterFactoryTest.java
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

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.provider.StandardHistoryProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueHistoryProviderAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory;

/**
 * This class is a JUnit test case for
 * {@link StandardRelativeValueHistoryProviderAdapterFactory}.
 */
@SuppressWarnings("all")
public class StandardRelativeValueHistoryProviderAdapterFactoryTest
		extends
		org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapterFactoryTest {

	static {
		// Add to RelativeValueProviderAdapterFactory.INSTANCE
		new StandardRelativeValueProviderAdapterFactory();

		// Add to HistoryProviderAdapterFactory.INSTANCE
		new StandardHistoryProviderAdapterFactory();
	} // static

	private StandardRelativeValueHistoryProviderAdapterFactory getFixture() {
		return (StandardRelativeValueHistoryProviderAdapterFactory) fixture;
	} // SpatialProviderAdapterFactory

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * @return a factory instance for testing purposes.
	 */
	protected StandardRelativeValueHistoryProviderAdapterFactory createFixture() {
		return new StandardRelativeValueHistoryProviderAdapterFactory();
	} // createFixture

	/**
	 * @see org.eclipse.stem.tests.diseasemodels.standard.provider.tests.StandardRelativeValueProviderAdapterFactoryTest#testProperAdapterFactoryComposition()
	 */
	public void testProperAdapterFactoryComposition() {
		final RelativeValueHistoryProviderAdapterFactory rvpaf = RelativeValueHistoryProviderAdapterFactory.INSTANCE;
		// Make the label value to be adapted
		final DiseaseModelLabel dml = getDiseaseModelLabelToTest();

		final RelativeValueHistoryProvider relativeValueHistoryProvider = (RelativeValueHistoryProvider) rvpaf
				.adapt(dml, RelativeValueHistoryProvider.class);

		assertNotNull(relativeValueHistoryProvider);
		assertTrue(relativeValueHistoryProvider instanceof StandardRelativeValueHistoryProviderAdapterFactory.DiseaseModelLabelRelativeValueHistoryProvider);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory.RelativeValueProviderAdapterFactoryImpl#isFactoryForType(java.lang.Object)}.
	 */
	@Override
	public void testIsFactoryForTypeObject() {
		final RelativeValueHistoryProviderAdapterFactory fixture = getFixture();
		assertTrue(fixture.isFactoryForType(RelativeValueHistoryProvider.class));
	} // testIsFactoryForTypeObject

	public void testGetRelativeValueByTime() {
		// TODO implement testGetRelativeValueByTime
		final RelativeValueHistoryProvider rVHP = getAdapterToTest();
		assertNotNull(rVHP);
		final ItemPropertyDescriptor property = (ItemPropertyDescriptor) rVHP
				.getProperties().get(0);
		final double rvTime1 = rVHP.getRelativeValue(property, rVHP
				.getEarliestTimeValue());
		assertTrue(valueWithinRange(rvTime1));

	} // testGetRelativeValueByTime

	public void testGetAllHistoricRelativeValues() {
		final RelativeValueHistoryProvider rVHP = getAdapterToTest();
		assertNotNull(rVHP);
		final ItemPropertyDescriptor property = (ItemPropertyDescriptor) rVHP
				.getProperties().get(0);
		final double[] allRelativeValues = rVHP
				.getAllHistoricRelativeValues(property);
//		assertTrue(allRelativeValues.length > 0);
		for (int i = 0; i < allRelativeValues.length; i++) {
			assertTrue(valueWithinRange(allRelativeValues[i]));
		} // for
	} // testGetAllHistoricRelativeValues

	public void testGetEarliestTimeValue() {
		// TODO implement testGetEarliestTimeValue
		final RelativeValueHistoryProvider rVHP = getAdapterToTest();
		assertNotNull(rVHP);
		final STEMTime earliestTime = rVHP.getEarliestTimeValue();
		assertTrue(earliestTime != null);
	} // testGetEarliestTimeValue

	/**
	 * @return
	 */
	private RelativeValueHistoryProvider getAdapterToTest() {
		final RelativeValueHistoryProviderAdapterFactory fixture = getFixture();
		final DiseaseModelLabel dml = getDiseaseModelLabelToTest();

		final RelativeValueHistoryProvider relativeValueHistoryProvider = (RelativeValueHistoryProvider) fixture
				.adapt(dml, RelativeValueHistoryProvider.class);
		return relativeValueHistoryProvider;
	}

	/**
	 * @return
	 */
	private DiseaseModelLabel getDiseaseModelLabelToTest() {
		return StandardRelativeValueProviderAdapterFactoryTest
				.createSEIRLabel();
	} // getDiseaseModelLabelToTest

	/**
	 * @param relativeValue
	 * @return <code>true</code> if the value is between 0.0 and 1.0,
	 *         inclusive.
	 */
	private boolean valueWithinRange(double relativeValue) {
		return relativeValue >= 0.0 && relativeValue <= 1.0;
	}

} // StandardRelativeValueHistoryProviderAdapterFactoryTest

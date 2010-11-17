// StandardRelativeValueProviderAdapterFactoryTest.java
package org.eclipse.stem.tests.diseasemodels.standard.provider.tests;

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

import java.util.List;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactoryTest;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory;

/**
 * This class is a JUnit test case for
 * {@link StandardRelativeValueProviderAdapterFactory}.
 */
@SuppressWarnings("all")
public class StandardRelativeValueProviderAdapterFactoryTest extends
		RelativeValueProviderAdapterFactoryTest {

	/**
	 * The number of properties in a disease model label value (Births, Deaths,
	 * Deaths from Disease are relative to total population)
	 */
	public static final int NUM_DISEASE_MODEL_LABEL_VALUE_PROPERTIES = 2;

	/**
	 * The number of properties in a SI disease model label value (I +
	 * DMLVP)
	 */
	public static final int NUM_SI_DISEASE_MODEL_LABEL_VALUE_PROPERTIES = 1 + NUM_DISEASE_MODEL_LABEL_VALUE_PROPERTIES;

	/**
	 * The number of properties in a SIR disease model label value (S, I, IR, IF, incidence +
	 * R + DMLVP)
	 */
	public static final int NUM_SIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES = NUM_SI_DISEASE_MODEL_LABEL_VALUE_PROPERTIES + 1;

	/**
	 * The number of properties in a SEIR disease model label value (S, E, I, IR,
	 * IF, incidence + R + DMLVP)
	 */
	public static final int NUM_SEIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES = NUM_SIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES + 1;

	/**
	 * The initial number of births for disease model label values.
	 */
	public static final double NUM_DISEASE_MODEL_LABEL_VALUE_BIRTHS = 100;

	/**
	 * The initial number of (total) deaths for disease model label values.
	 */
	public static final double NUM_DISEASE_MODEL_LABEL_VALUE_DEATHS = 10;

	/**
	 * The initial number of deaths from disease for disease model label values.
	 */
	public static final double NUM_DISEASE_MODEL_LABEL_VALUE_DISEASE_DEATHS = 1;

	protected static final double NUM_S_POPULATION = 64;

	protected static final double NUM_E_POPULATION = 32;

	protected static final double NUM_I_POPULATION = 16;

	protected static final double NUM_R_POPULATION = 8;

	protected static final double TOTAL_SI_POPULATION = NUM_S_POPULATION
			+ NUM_I_POPULATION;

	protected static final double TOTAL_SIR_POPULATION = TOTAL_SI_POPULATION
			+ NUM_R_POPULATION;

	protected static final double TOTAL_SEIR_POPULATION = TOTAL_SIR_POPULATION
			+ NUM_E_POPULATION;

	private StandardRelativeValueProviderAdapterFactory getFixture() {
		return (StandardRelativeValueProviderAdapterFactory) fixture;
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
	protected StandardRelativeValueProviderAdapterFactory createFixture() {
		return new StandardRelativeValueProviderAdapterFactory();
	} // createFixture

	/**
	 * @param label
	 */
	public static final void initializeDiseaseModelLabel(
			final StandardDiseaseModelLabel label) {
		initializeDiseaseModelLabelValues((DiseaseModelLabelValue)label
				.getCurrentValue());
		initializeDiseaseModelLabelValues((DiseaseModelLabelValue)label
				.getNextValue());
	} // initializeDiseaseModelLabel

	/**
	 * @param labelValue
	 */
	public static final void initializeDiseaseModelLabelValues(
			final DiseaseModelLabelValue dmlv) {
		dmlv.setDiseaseDeaths(NUM_DISEASE_MODEL_LABEL_VALUE_DISEASE_DEATHS);
	} // initializedDiseaseModelLabelValues

	/**
	 * @return
	 */
	public static final SEIRLabel createSEIRLabel() {
		final SEIRLabel seirLabel = StandardFactory.eINSTANCE.createSEIRLabel();
	
		initializeDiseaseModelLabel(seirLabel);
		seirLabel.getCurrentSEIRValue().setS(NUM_S_POPULATION);
		seirLabel.getCurrentSEIRValue().setE(NUM_E_POPULATION);
		seirLabel.getCurrentSEIRValue().setI(NUM_I_POPULATION);
		seirLabel.getCurrentSEIRValue().setR(NUM_R_POPULATION);
		return seirLabel;
	} // createSEIRLabel

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory#createSILabelAdapter()}.
	 */
	public void testCreateSILabelAdapter() {
		final StandardRelativeValueProviderAdapterFactory fixture = getFixture();
		final SILabel sILabel = StandardFactory.eINSTANCE.createSILabel();

		initializeDiseaseModelLabel(sILabel);
		sILabel.setS(NUM_S_POPULATION);
		sILabel.setI(NUM_I_POPULATION);

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) fixture
				.adapt(sILabel, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);

		final List<IItemPropertyDescriptor> properties = relativeValueProvider
				.getProperties();
		assertNotNull(properties);

		assertTrue(properties.size() == NUM_SI_DISEASE_MODEL_LABEL_VALUE_PROPERTIES);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getStandardDiseaseModelLabelValue_S()) == NUM_S_POPULATION
				/ TOTAL_SI_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE.getSILabelValue_I()) == NUM_I_POPULATION
				/ TOTAL_SI_POPULATION);

	} // testCreateSILabelAdapter

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory#createSIRLabelAdapter()}.
	 */
	public void testCreateSIRLabelAdapter() {
		final StandardRelativeValueProviderAdapterFactory fixture = getFixture();
		final SIRLabel sirLabel = StandardFactory.eINSTANCE.createSIRLabel();

		initializeDiseaseModelLabel(sirLabel);
		sirLabel.getCurrentSIRValue().setS(NUM_S_POPULATION);
		sirLabel.getCurrentSIRValue().setI(NUM_I_POPULATION);
		sirLabel.getCurrentSIRValue().setR(NUM_R_POPULATION);

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) fixture
				.adapt(sirLabel, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);

		final List<IItemPropertyDescriptor> properties = relativeValueProvider
				.getProperties();
		assertNotNull(properties);

		assertTrue(properties.size() == NUM_SIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getStandardDiseaseModelLabelValue_S()) == NUM_S_POPULATION
				/ TOTAL_SIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE.getSILabelValue_I()) == NUM_I_POPULATION
				/ TOTAL_SIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getSIRLabelValue_R()) == NUM_R_POPULATION
				/ TOTAL_SIR_POPULATION);
	} // testCreateSIRLabelAdapter

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory#createSEIRLabelAdapter()}.
	 */
	public void testCreateSEIRLabelAdapter() {
		final StandardRelativeValueProviderAdapterFactory fixture = getFixture();
		final SEIRLabel seirLabel = createSEIRLabel();

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) fixture
				.adapt(seirLabel, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);

		final List<IItemPropertyDescriptor> properties = relativeValueProvider
				.getProperties();
		assertNotNull(properties);
		assertTrue(properties.size() == NUM_SEIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getStandardDiseaseModelLabelValue_S()) == NUM_S_POPULATION
				/ TOTAL_SEIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getSEIRLabelValue_E()) == NUM_E_POPULATION
				/ TOTAL_SEIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE.getSILabelValue_I()) == NUM_I_POPULATION
				/ TOTAL_SEIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getSIRLabelValue_R()) == NUM_R_POPULATION
				/ TOTAL_SEIR_POPULATION);
	} // testCreateSEIRLabelAdapter

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory#createSILabelValueAdapter()}.
	 */
	public void testCreateSILabelValueAdapter() {
		final StandardRelativeValueProviderAdapterFactory fixture = getFixture();
		final SILabelValue sILabelValue = StandardFactory.eINSTANCE
				.createSILabelValue();

		initializeDiseaseModelLabelValues(sILabelValue);
		sILabelValue.setS(NUM_S_POPULATION);
		sILabelValue.setI(NUM_I_POPULATION);

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) fixture
				.adapt(sILabelValue, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);

		final List<IItemPropertyDescriptor> properties = relativeValueProvider
				.getProperties();
		assertNotNull(properties);

		assertTrue(properties.size() == NUM_SI_DISEASE_MODEL_LABEL_VALUE_PROPERTIES);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getStandardDiseaseModelLabelValue_S()) == NUM_S_POPULATION
				/ TOTAL_SI_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE.getSILabelValue_I()) == NUM_I_POPULATION
				/ TOTAL_SI_POPULATION);

	} // testCreateSILabelValueAdapter

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory#createSIRLabelValueAdapter()}.
	 */
	public void testCreateSIRLabelValueAdapter() {
		final StandardRelativeValueProviderAdapterFactory fixture = getFixture();
		final SIRLabelValue sIRLabelValue = StandardFactory.eINSTANCE
				.createSIRLabelValue();

		initializeDiseaseModelLabelValues(sIRLabelValue);
		sIRLabelValue.setS(NUM_S_POPULATION);
		sIRLabelValue.setI(NUM_I_POPULATION);
		sIRLabelValue.setR(NUM_R_POPULATION);

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) fixture
				.adapt(sIRLabelValue, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);

		final List<IItemPropertyDescriptor> properties = relativeValueProvider
				.getProperties();
		assertNotNull(properties);

		assertTrue(properties.size() == NUM_SIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getStandardDiseaseModelLabelValue_S()) == NUM_S_POPULATION
				/ TOTAL_SIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE.getSILabelValue_I()) == NUM_I_POPULATION
				/ TOTAL_SIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getSIRLabelValue_R()) == NUM_R_POPULATION
				/ TOTAL_SIR_POPULATION);
	} // testCreateSIRLabelValueAdapter

	/**
	 * Test method for
	 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory#createSEIRLabelValueAdapter()}.
	 */
	public void testCreateSEIRLabelValueAdapter() {
		final StandardRelativeValueProviderAdapterFactory fixture = getFixture();
		final SEIRLabelValue sEIRLabelValue = StandardFactory.eINSTANCE
				.createSEIRLabelValue();

		initializeDiseaseModelLabelValues(sEIRLabelValue);
		sEIRLabelValue.setS(NUM_S_POPULATION);
		sEIRLabelValue.setE(NUM_E_POPULATION);
		sEIRLabelValue.setI(NUM_I_POPULATION);
		sEIRLabelValue.setR(NUM_R_POPULATION);

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) fixture
				.adapt(sEIRLabelValue, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);

		final List<IItemPropertyDescriptor> properties = relativeValueProvider
				.getProperties();
		assertNotNull(properties);
		assertTrue(properties.size() == NUM_SEIR_DISEASE_MODEL_LABEL_VALUE_PROPERTIES);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getStandardDiseaseModelLabelValue_S()) == NUM_S_POPULATION
				/ TOTAL_SEIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getSEIRLabelValue_E()) == NUM_E_POPULATION
				/ TOTAL_SEIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE.getSILabelValue_I()) == NUM_I_POPULATION
				/ TOTAL_SEIR_POPULATION);

		assertTrue(relativeValueProvider
				.getRelativeValue(StandardPackage.eINSTANCE
						.getSIRLabelValue_R()) == NUM_R_POPULATION
				/ TOTAL_SEIR_POPULATION);
	} // testCreateSEIRLabelValueAdapter

	/**
	 * Test that this factory is properly added to the composed adaptor factory
	 * <code>RelativeValueProviderAdapterFactoryImpl</code> so that the
	 * classes in the Standard (Disease model) package will be properly adapted
	 * to {@link RelativeValueProvider}'s.
	 */
	public void testProperAdapterFactoryComposition() {
		final RelativeValueProviderAdapterFactory rvpaf = RelativeValueProviderAdapterFactory.INSTANCE;
		// Make the label value to be adapted
		final SEIRLabelValue sEIRLabelValue = StandardFactory.eINSTANCE
				.createSEIRLabelValue();
		initializeDiseaseModelLabelValues(sEIRLabelValue);
		sEIRLabelValue.setS(NUM_S_POPULATION);
		sEIRLabelValue.setE(NUM_E_POPULATION);
		sEIRLabelValue.setI(NUM_I_POPULATION);
		sEIRLabelValue.setR(NUM_R_POPULATION);

		final RelativeValueProvider relativeValueProvider = (RelativeValueProvider) rvpaf
				.adapt(sEIRLabelValue, RelativeValueProvider.class);

		assertNotNull(relativeValueProvider);
		assertTrue(relativeValueProvider instanceof StandardRelativeValueProviderAdapterFactory.DiseaseModelLabelValueRelativeValueProvider);
	} // testProperAdapterFactoryComposition

} // StandardRelativeValueProviderAdapterFactoryTest

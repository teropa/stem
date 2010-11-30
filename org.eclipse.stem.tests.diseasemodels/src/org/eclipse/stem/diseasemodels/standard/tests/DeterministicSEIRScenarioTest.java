// DeterministicSEIRScenarioTest.java
package org.eclipse.stem.diseasemodels.standard.tests;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;

/**
 * This class is a JUnit test case for a Deterministic SEIR disease model
 * scenario.
 * 
 * <ul>
 * <li>&mu; = {@link DiseaseModelTest#MORTALITY_RATE} = 0.01</li>
 * <li>&beta; = {@link SITest#TRANSMISSION_RATE} = 0.1</li>
 * <li>&sigma; = {@link SITest#RECOVERY_RATE} = 0.01</li>
 * <li>x = {@link SITest#INFECTIOUS_MORTALITY} = 0.1 </li>
 * <li>&mu;<sub>i</sub> = {@link SITest#INFECTIOUS_MORTAILY_RATE} = 0.1</li>
 * <li>&gamma; = {@link SIRTest#IMMUNITY_LOSS_RATE} = 0.1</li>
 * <li>&phi; = {@link SEIRTest#INCUBATION_RATE} = 0.1</li>
 * <li>Area<sub>l</sub> = 1.0</li>
 * <li>Area = 1.0</li>
 * <li>P = S + I = {@link DiseaseModelTestUtil#TEST_POPULATION_COUNT} = 100</li>
 * </ul>
 * <h2>1x1 Deterministic SEIR Scenario</h2>
 * 
 */
public class DeterministicSEIRScenarioTest extends SEIRDiseaseModelScenarioTest {

	private static final String DISEASE_URI_PREFIX = "DeterministicSEIR";

	private static Map<String, Integer> expectedNumberOfLabelsToUpdate = new HashMap<String, Integer>();

	private static Map<String, SEIRLabelValue[][][]> expectedDiseaseModelStates = new HashMap<String, SEIRLabelValue[][][]>();

	static {

		// 1x1
		expectedDiseaseModelStates.put(TEST_SCENARIO1x1_KEY,
				new SEIRLabelValue[][][] {
				// Step 0
						{ {
						// N[0,0]
						new SEIRLabelValueImpl(98.90, 0.10, 0.89, 0.01,	0.10) } },

						// Step 1
						{ {
						// N[0,0]
						new SEIRLabelValueImpl(98.81, 0.18, 0.80, 0.02, 0.19) } } } 
				// SEIRLabelValue

				); // put(TEST_SCENARIO1x1_KEY)

		// 1x2
		expectedDiseaseModelStates
				.put(TEST_SCENARIO1x2_KEY,
						new SEIRLabelValue[][][] {
						// Step 0
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0) } },

								// Step 1
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0) } },
								// Step 2
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0) } } } // new
				// SEIRLabelValue
				); // put(TEST_SCENARIO1x2_KEY)

		// 1x3
		expectedDiseaseModelStates
				.put(TEST_SCENARIO1x3_KEY,
						new SEIRLabelValue[][][] {
						// Step 0
								{ {

								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} },

								// Step 1
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} },

								// Step 2
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} } } // new SEIRLabelValue

				); // put(TEST_SCENARIO1x3_KEY)

		// 2x2
		expectedDiseaseModelStates.put(TEST_SCENARIO2x2_KEY,
				new SEIRLabelValue[][][] {
				// Step 0
						{
								{

								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} },

						// Step 1
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1z
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} },

						// Step 2
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} } } // new SEIRLabelValue

				); // put(TEST_SCENARIO2x2_KEY)

		// 3x3
		expectedDiseaseModelStates.put(TEST_SCENARIO3x3_KEY,
				new SEIRLabelValue[][][] {
				// Step 0
						{
								{

								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[2,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[2,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[2,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} },

						// Step 1
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[2,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[2,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[2,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} },

						// Step 2
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[1,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								},
								{

								// N[2,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[2,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0),
										// N[2,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0)

								} } } // new SEIRLabelValue

				); // put(TEST_SCENARIO3x3_KEY)

		// Fill out the map that specifies how many labels should be updated by
		// a disease model for each test.
		for (TestSpec testSpec : testSpecifications) {
			expectedNumberOfLabelsToUpdate
					.put(
							testSpec.scenarioDiseaseKey,
							new Integer(
									computeExpectedNumberOfLabels(expectedDiseaseModelStates
											.get(testSpec.scenarioDiseaseKey))));
		} // for each test specification

	} // static

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.tests.DiseaseModelScenarioTest#getDiseaseModelsToTest()
	 */
	@Override
	public List<NodeDecorator> getDiseaseModelsToTest() {
		final List<NodeDecorator> retValue = new ArrayList<NodeDecorator>();
		retValue.add(DeterministicSEIRDiseaseModelTest.createFixture());
		return retValue;
	} // getDiseaseModelsToTest

	@Override
	protected int getNumberOfSteps(final String diseaseScenarioKey) {
		SEIRLabelValue[][][] temp = expectedDiseaseModelStates
				.get(diseaseScenarioKey);
		return temp.length;
	} // getNumberOfSteps

	@Override
	protected int getExpectedNumberOfLabelsToUpdate(
			final String diseaseScenarioKey) {
		Integer temp = expectedNumberOfLabelsToUpdate.get(diseaseScenarioKey);
		return temp.intValue();
	} // getExpectedNumberOfLabelsToUpdate

	@Override
	protected LabelValue[][] getExpectedDiseaseModelState(
			final String diseaseScenarioKey, final int step) {
		final SEIRLabelValue[][][] seirLabelValue = expectedDiseaseModelStates
				.get(diseaseScenarioKey);
		return seirLabelValue[step];
	} // getExpectedDiseaseModelState

	protected String getDiseaseURIPrefix() {
		return DISEASE_URI_PREFIX;
	} // getDiseaseURIPrefix

	/**
	 * @param numRows
	 *            the number of rows in the lattice
	 * @param numColumns
	 *            the number of columns in the lattice
	 * @return a scenario with nodes in a lattice with a deterministic SEIR
	 *         disease model and one population member infected in Node [0][0]
	 */
	public static Scenario createScenario(final int numRows,
			final int numColumns) {
		final Collection<NodeDecorator> diseaseModels = new ArrayList<NodeDecorator>();

		diseaseModels.add(DeterministicSEIRDiseaseModelTest.createFixture());

		final Model model = DiseaseModelTestUtil.createLatticeModel(
				diseaseModels, numRows, numColumns,
				DiseaseModelTestUtil.TEST_POPULATION_COUNT,
				DiseaseModelTestUtil.TEST_AREA);

		final Scenario retValue = DiseaseModelTestUtil.createLatticeScenario(
				SIDiseaseModelScenarioTest.createInfectors(model), model);

		assert retValue.sane();

		return retValue;
	} // createFixture

} // DeterministicSEIRScenarioTest

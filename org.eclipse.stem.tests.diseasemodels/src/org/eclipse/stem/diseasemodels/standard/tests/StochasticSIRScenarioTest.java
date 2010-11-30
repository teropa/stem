// StochasticSIRScenarioTest.java
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SIRLabelValueImpl;

/**
 * This class is a JUnit test case for a Stochastic SIR disease model scenario
 */
public class StochasticSIRScenarioTest extends SIRDiseaseModelScenarioTest {

	private static final String DISEASE_URI_PREFIX = "StochasticSIR";

	private static Map<String, Integer> expectedNumberOfLabelsToUpdate = new HashMap<String, Integer>();

	private static Map<String, SIRLabelValue[][][]> expectedDiseaseModelStates = new HashMap<String, SIRLabelValue[][][]>();

	static {

		// These were copied from DeterministicSIRScenarioTest
		// for test purposes we are checking with noise = 0
		// 1x1
		expectedDiseaseModelStates.put(TEST_SCENARIO1x1_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {
						// N[0,0]
						new SIRLabelValueImpl(98.90, 0.99, 0.01, 0.10) } },

						// Step 1
						{ {
						// N[0,0]
						new SIRLabelValueImpl(98.80, 0.98, 0.02, 0.20) } } } 
				// SIRLabelValue

				); // put(TEST_SCENARIO1x1_KEY)

		// 1x2
		expectedDiseaseModelStates
				.put(TEST_SCENARIO1x2_KEY,
						new SIRLabelValue[][][] {
						// Step 0
								{ {
								// N[0,0]
										new SIRLabelValueImpl(100, 0, 0, 0, 0
												),
										// N[0,1]
										new SIRLabelValueImpl(100, 0, 0, 0, 0
												) } },

								// Step 1
								{ {
								// N[0,0]
										new SIRLabelValueImpl(100, 0, 0, 0, 0
												),
										// N[0,1]
										new SIRLabelValueImpl(100, 0, 0, 0, 0
												) } },
								// Step 2
								{ {
								// N[0,0]
										new SIRLabelValueImpl(100, 0, 0, 0, 0
												),
										// N[0,1]
										new SIRLabelValueImpl(100, 0, 0, 0, 0
												) } } } // new
				// SIRLabelValue
				); // put(TEST_SCENARIO1x2_KEY)

		// 1x3
		expectedDiseaseModelStates.put(TEST_SCENARIO1x3_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} } } // new SIRLabelValue

				); // put(TEST_SCENARIO1x3_KEY)

		// 2x2
		expectedDiseaseModelStates.put(TEST_SCENARIO2x2_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} } } // new SIRLabelValue

				); // put(TEST_SCENARIO2x2_KEY)

		// 3x3
		expectedDiseaseModelStates.put(TEST_SCENARIO3x3_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[2,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[2,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[2,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[2,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[1,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[2,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0),
								// N[2,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0)

						} } } // new SIRLabelValue

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
		retValue.add(StochasticSIRDiseaseModelTest.createFixture());
		return retValue;
	} // getDiseaseModelsToTest

	@Override
	protected int getNumberOfSteps(final String diseaseScenarioKey) {
		SIRLabelValue[][][] temp = expectedDiseaseModelStates
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
		final SIRLabelValue[][][] sirLabelValue = expectedDiseaseModelStates
				.get(diseaseScenarioKey);
		return sirLabelValue[step];
	} // getExpectedDiseaseModelState

	protected String getDiseaseURIPrefix() {
		return DISEASE_URI_PREFIX;
	} // getDiseaseURIPrefix
} // StochasticSIRScenarioTest

// StochasticSEIRScenarioTest.java
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
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SEIRLabelValueImpl;

/**
 * This class is a JUnit test case for a Stochastic SEIR disease model scenario
 */
public class StochasticSEIRScenarioTest extends SEIRDiseaseModelScenarioTest {

	private static final String DISEASE_URI_PREFIX = "StochasticSEIR";

	private static Map<String, Integer> expectedNumberOfLabelsToUpdate = new HashMap<String, Integer>();

	private static Map<String, SEIRLabelValue[][][]> expectedDiseaseModelStates = new HashMap<String, SEIRLabelValue[][][]>();

	static {

		// These were copied from DeterministicSEIRScenarioTest
		// 1x1
		expectedDiseaseModelStates.put(TEST_SCENARIO1x1_KEY,
				new SEIRLabelValue[][][] {
				// Step 0
						{ {
						// N[0,0]
						new SEIRLabelValueImpl(99.01, 0.0, 0.98, 0.0, 0.01,
								0) } },

						// Step 1
						{ {
						// N[0,0]
						new SEIRLabelValueImpl(99.02, 0.0,
								0.96, 0.00, 0.02, 0) } } } // new
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
		// this is a test with a gain of zero
		// if MUST return the same result as the deterministic model
		// because the noise mulitplier is 1.0 for a gain of 0.0
		retValue.add(StochasticSEIRDiseaseModelTest.createFixture(0.0));
		
		// NEW TEST Needed  https://bugs.eclipse.org/bugs/show_bug.cgi?id=186043
		//
		// we need to add a test at a higher gain. For a gain > the fuzzy compare (double equality tollerance)
		// 1. the results should DIFFER from the deterministic result (proves there is noise
		// 2. the stochastic test should agree with percomputed values
		// retValue.add(StochasticSEIRDiseaseModelTest.createFixture(0.02));
		
		
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
} // StochasticSEIRScenarioTest

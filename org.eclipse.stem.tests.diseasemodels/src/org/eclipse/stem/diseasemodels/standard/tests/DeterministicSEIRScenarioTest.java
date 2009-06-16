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
 * <h2>1x1 Deterministic SIR Scenario</h2>
 * <h3>Initial State</h3>
 * <p>
 * S= 99.0, I<sup>R</sup>=1.0, I<sup>F</sup>=0.0, R=0.0, B=0.0, D=0.0,
 * DD=0.0
 * </p>
 * <h3>SEIR 1x1 Step 0</h3>
 * 
 * <ul>
 * <li><em>TSF<sub>l</sub> = (1/P)*(Area/Area<sub>l</sub>)</em></li>
 * <li><em>TSF<sub>l</sub> = (1/100)*(1/1)</em></li>
 * <li><em>TSF<sub>l</sub> = 0.01</em></li>
 * </ul>
 * <ul>
 * <li><em>&beta;<sup>*</sup> = &beta; TSF<sub>l</sub></em></li>
 * <li><em>&beta;<sup>*</sup> = 0.1 * 0.01</em></li>
 * <li><em>&beta;<sup>*</sup> = 0.001</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;B = &mu; * (S + +E +I<sup>R</sup> + I<sup>F</sup> +R)</em></li>
 * <li><em>&Delta;B = 0.01 * (99+0+1+0) </em> </li>
 * <li><em>&Delta;B = 1.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;DD = &mu;<sub>i</sub> I<sup>F</sup>  </em> </li>
 * <li><em>&Delta;DD= 0.1 * 0</em> </li>
 * <li><em>&Delta;DD= 0.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;D = &mu;S + &mu;E +(&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu; I<sup>R</sup> + &mu;R </em>
 * </li>
 * <li><em>&Delta;D = 0.01 * 99 + 0.01 * 0 + (0.01 + 0.1 ) 0 + 0.01 * 1 + 0.01 * 0</em>
 * </li>
 * <li><em>&Delta;D= 1</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;S = &mu; (S + E +I + R) - &beta;<sup>*</sup> S I + &gamma;R - &mu; S</em></li>
 * <li><em>&Delta;S = 0.01 (99+(1+0+0)+0) - 0.001 * 99 * (1+0+0) + 0.01 * 0 - 0.01 * 99</em></li>
 * <li><em>&Delta;S = 1.0 - 0.099 + 0.01 - 0.99</em></li>
 * <li><em>&Delta;S = -0.089</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;E = &beta;<sup>*</sup>SI - &phi;E - &mu;E</sup></em></li>
 * <li><em>&Delta;E = 0.001 * 99 * 1 -  0.1 * 0 - 0.01 * 0</em></li>
 * <li><em>&Delta;E = 0.099</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>R</sup> = (1-x)&phi;E - &sigma; I<sup>R</sup> - &mu; I<sup>R</sup></em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.9 * 0  -  0.01 * 1 - 0.01 * 1</em></li>
 * <li><em>&Delta;I<sup>R</sup> = - 0.01 - 0.01</em></li>
 * <li><em>&Delta;I<sup>R</sup> = -0.02</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>F</sup> = x&phi;E  - (&mu; + &mu;<sub>i</sub>) I<sup>F</sup></em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.1 * 0  - (0.01 + 0.1) * 0</em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.0</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;R = &sigma; I<sup>R</sup>  - &gamma;R - &mu; R</em></li>
 * <li><em>&Delta;R = 0.01 * 1  - 0.01 * 0 - 0.01 * 0</em></li>
 * <li><em>&Delta;R = .01</em></li>
 * </ul>
 * <p>
 * S= 98.911, E=0.099 , I<sup>R</sup>=0.98, I<sup>F</sup>=0.0, R=0.01,
 * B=1.0, D=1.0, DD=0.0
 * </p>
 * 
 * <h3>SEIR 1x1 Step 1</h3>
 * 
 * <ul>
 * <li><em>TSF<sub>l</sub> = (1/P)*(Area/Area<sub>l</sub>)</em></li>
 * <li><em>TSF<sub>l</sub> = (1/100)*(1/1)</em></li>
 * <li><em>TSF<sub>l</sub> = 0.01</em></li>
 * </ul>
 * <ul>
 * <li><em>&beta;<sup>*</sup> = &beta; TSF<sub>l</sub></em></li>
 * <li><em>&beta;<sup>*</sup> = 0.1 * 0.01</em></li>
 * <li><em>&beta;<sup>*</sup> = 0.001</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;B = &mu; * (S + E + I<sup>R</sup> + I<sup>F</sup> +R)</em></li>
 * <li><em>&Delta;B = 0.01 * 100 </em> </li>
 * <li><em>&Delta;B = 1.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;DD = &mu;<sub>i</sub> I<sup>F</sup>  </em> </li>
 * <li><em>&Delta;DD= 0.1 * 0</em> </li>
 * <li><em>&Delta;DD= 0.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;D = &mu;S + &mu;E + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu; I<sup>R</sup> + &mu; R </em>
 * </li>
 * <li><em>&Delta;D = 0.01 * 98.911 + 0.01 * 0.099 + (0.01 + 0.1) * 0 + 0.01 * 0.98 + 0.01 * 0.01</em>
 * </li>
 * <li><em>&Delta;D= 1.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;S = &mu; (S + E +I + R) - &beta;<sup>*</sup> S I + &gamma;R - &mu; S</em></li>
 * <li><em>&Delta;S = 0.01 (99.911+ 0.988 (0.980+0)+0.01) - 0.001 * 98.911 * 0.98 + 0.1 * 0.01 - 0.01 * 98.911</em></li>
 * <li><em>&Delta;S = 1.0 - 0.09693278 + 0.001 - 0.98911</em></li>
 * <li><em>&Delta;S = -0.085704278</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;E = &beta;<sup>*</sup>SI - &phi;E - &mu;E</sup></em></li>
 * <li><em>&Delta;E = 0.001 * 98.911 * 0.98 -  0.1 * 0.099 - 0.01 * 0.099</em></li>
 * <li><em>&Delta;E = 0.09693278 -  0.0099 - 0.00099</em></li>
 * <li><em>&Delta;E = 0.08604278</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>R</sup> = (1-x)&phi;E - &sigma; I<sup>R</sup> - &mu; I<sup>R</sup></em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.9 * 0.0099  -  0.01 * 0.98 - 0.01 * 0.98</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.00891 - 0.0098 - 0.0098</em></li>
 * <li><em>&Delta;I<sup>R</sup> = -0.01069</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>F</sup> = x&phi;E  - (&mu; + &mu;<sub>i</sub>) I<sup>F</sup></em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.1 * 0.099  - (0.01 + 0.1) * 0.0</em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.0099</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;R = &sigma; I<sup>R</sup>  - &gamma;R - &mu; R</em></li>
 * <li><em>&Delta;R = 0.01 * 0.98  - 0.1 * 0.01 - 0.01 * 0.01</em></li>
 * <li><em>&Delta;R = .0087</em></li>
 * </ul>
 *  S= 98.911, E=0.099 , I<sup>R</sup>=0.98, I<sup>F</sup>=0.0, R=0.01,
 * B=1.0, D=1.0, DD=0.0
 * 
 * <p>
 * S= 98.82505722, E=0.18504278, I<sup>R</sup>=0.96931, I<sup>F</sup>=0.0099,
 * R=0.0187, B=2.0, D=2.0, DD=0.0
 * </p>
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
						new SEIRLabelValueImpl(99.01, 0.0, 0.98, 0, 0.01,
								1.0, 1.0, 0.0) } },

						// Step 1
						{ {
						// N[0,0]
						new SEIRLabelValueImpl(99.02, 0.0, 0.96, 0.0, 0.02, 2.0, 2.0, 0) } } } // new
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
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0) } },

								// Step 1
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0) } },
								// Step 2
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0) } } } // new
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
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								} },

								// Step 1
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								} },

								// Step 2
								{ {
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

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
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								} },

						// Step 1
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								} },

						// Step 2
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

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
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[2,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[2,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[2,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								} },

						// Step 1
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[2,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[2,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[2,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								} },

						// Step 2
						{
								{
								// N[0,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[0,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[1,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[1,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

								},
								{

								// N[2,0]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[2,1]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0),
										// N[2,2]
										new SEIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0, 0)

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

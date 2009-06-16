// DeterministicSIRScenarioTest.java
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
 * This class is a JUnit test case for a Deterministic SIR disease model
 * scenario. 
 * <ul>
 * <li>&mu; = {@link DiseaseModelTest#MORTALITY_RATE} = 0.01</li>
 * <li>&beta; = {@link SITest#TRANSMISSION_RATE} = 0.1</li>
 * <li>&sigma; = {@link SITest#RECOVERY_RATE} = 0.01</li>
 * <li>x = {@link SITest#INFECTIOUS_MORTALITY} = 0.1 </li>
 * <li>&mu;<sub>i</sub> = {@link SITest#INFECTIOUS_MORTAILY_RATE} = 0.1</li>
 * <li>&gamma; = {@link SIRTest#IMMUNITY_LOSS_RATE} = 0.1</li>
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
 * <h3>SIR 1x1 Step 0</h3>
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
 * <li><em>&Delta;B = &mu; * (S + I<sup>R</sup> + I<sup>F</sup> +R)</em></li>
 * <li><em>&Delta;B = 0.01 * (99+1+0) </em> </li>
 * <li><em>&Delta;B = 1.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;DD = &mu;<sub>i</sub> I<sup>F</sup>  </em> </li>
 * <li><em>&Delta;DD= 0.1 * 0</em> </li>
 * <li><em>&Delta;DD= 0.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;D = &mu; S + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu; I<sup>R</sup> + &mu; R </em>
 * </li>
 * <li><em>&Delta;D = 0.01 * 99 + (0.01 + 0.1 ) 0 + 0.01 * 1 + 0.01 * 0</em>
 * </li>
 * <li><em>&Delta;D= 1</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;S = &mu; (S + I + R) - &beta;<sup>*</sup> S I + &gamma;R - &mu; S</em></li>
 * <li><em>&Delta;S = 0.01 (99+(1+0)+0) - 0.001 * 99 * (1+0+0) + 0.01 * 0 - 0.01 * 99</em></li>
 * <li><em>&Delta;S = 1.0 - 0.099 + 0.01 - 0.99</em></li>
 * <li><em>&Delta;S = -0.089</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>R</sup> = (1-x)&beta;<sup>*</sup> S I - &sigma; I<sup>R</sup> - &mu; I<sup>R</sup></em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.9 * 0.001 * 99 * 1 -  0.01 * 1 - 0.01 * 1</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.0891 - .01 - .01</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.0691</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>F</sup> = x&beta;<sup>*</sup> S I  - (&mu; + &mu;<sub>i</sub>) I<sup>F</sup></em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.1 * 0.001 * 99 * 1  - (0.01 + 0.1) * 0</em></li>
 * <li><em>&Delta;I<sup>F</sup> = .0099</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;R = &sigma; I<sup>R</sup>  - &gamma;R - &mu; R</em></li>
 * <li><em>&Delta;R = 0.01 * 1  - 0.01 * 0 - 0.01 * 0</em></li>
 * <li><em>&Delta;R = .01</em></li>
 * </ul>
 * <p>
 * S= 98.911, I<sup>R</sup>=1.0691, I<sup>F</sup>=0.0099, R=0.01, B=1.0,
 * D=1.0, DD=0.0
 * </p>
 * 
 * <h3>SIR 1x1 Step 1</h3>
 * 
 * <ul>
 * <li><em>TSF<sub>l</sub> = (1/P)*(Area/Area<sub>l</sub>)</em></li>
 * <li><em>TSF<sub>l</sub> = (1/99.989)*(1/1)</em></li>
 * <li><em>TSF<sub>l</sub> = 0.0100011</em></li>
 * </ul>
 * <ul>
 * <li><em>&beta;<sup>*</sup> = &beta; TSF<sub>l</sub></em></li>
 * <li><em>&beta;<sup>*</sup> = 0.1 * 0.0100011</em></li>
 * <li><em>&beta;<sup>*</sup> = 0.00100011</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;B = &mu; * (S + I<sup>R</sup> + I<sup>F</sup> +R)</em></li>
 * <li><em>&Delta;B = 0.01 * 99.989 </em> </li>
 * <li><em>&Delta;B = 0.99989</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;DD = &mu;<sub>i</sub> I<sup>F</sup>  </em> </li>
 * <li><em>&Delta;DD= 0.1 * 0.0099</em> </li>
 * <li><em>&Delta;DD= 0.00099</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;D = &mu; S + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu; I<sup>R</sup> + &mu; R </em>
 * </li>
 * <li><em>&Delta;D = 0.01 * 98.911 + (0.01 + 0.1) 0.0099 + 0.01 * 1.0691 + 0.01 * 0.01</em>
 * </li>
 * <li><em>&Delta;D= 1.00099</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;S = &mu; (S + I + R) - &beta;<sup>*</sup> S I + &gamma;R - &mu; S</em></li>
 * <li><em>&Delta;S = 0.01 * 99.989 - 0.00100011 * 98.911 * (1.0691+0.0099) + 0.01 * 0.01 - 0.01 * 98.911</em></li>
 * <li><em>&Delta;S = 0.99989 - 0.106736709 + 0.0001 - 0.98911</em></li>
 * <li><em>&Delta;S = -0.095856709</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>R</sup> = (1-x)&beta;<sup>*</sup> S I - &sigma; I<sup>R</sup> - &mu; I<sup>R</sup></em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.9 * 0.00100011 * 98.911 * (1.0691+0.0099) -  0.01 * 1.0691 - 0.01 * 1.0691</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.096063038 - .010691 - .010691</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.074681038</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>F</sup> = x&beta;<sup>*</sup> S I  - (&mu; + &mu;<sub>i</sub>) I<sup>F</sup></em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.1 * 0.00100011 * 98.911 * (1.0691+0.0099)  - (0.01 + 0.1) * 0.0099</em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.010673671  - 0.001089</em></li>
 * <li><em>&Delta;I<sup>F</sup> = .009584671</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;R = &sigma; I<sup>R</sup>  - &gamma;R - &mu; R</em></li>
 * <li><em>&Delta;R = 0.01 * 1.0691  - 0.01 * 0.01 - 0.01 * 0.01</em></li>
 * <li><em>&Delta;R = .010491</em></li>
 * </ul>
 * <p>
 * S= 98.81514329, I<sup>R</sup>=1.143781038, I<sup>F</sup>=0.019484671,
 * R=0.020491, B=1.99989, D=2.00099, DD=0.00099
 * </p>
 * 
 */
public class DeterministicSIRScenarioTest extends SIRDiseaseModelScenarioTest {

	private static final String DISEASE_URI_PREFIX = "DeterministicSIR";

	private static Map<String, Integer> expectedNumberOfLabelsToUpdate = new HashMap<String, Integer>();

	private static Map<String, SIRLabelValue[][][]> expectedDiseaseModelStates = new HashMap<String, SIRLabelValue[][][]>();

	static {

		// 1x1
		expectedDiseaseModelStates.put(TEST_SCENARIO1x1_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {
						// N[0,0]
						new SIRLabelValueImpl(99.01, 0.98, 0.0, 0.01,
								1.0, 1.0, 0.0) } },

						// Step 1
						{ {
						// N[0,0]
						new SIRLabelValueImpl(99.02, 0.96, 0.0, 0.02, 2.0, 2.0,
								0.00) } } } // new
				// SIRLabelValue

				); // put(TEST_SCENARIO1x1_KEY)

		// 1x2
		expectedDiseaseModelStates
				.put(TEST_SCENARIO1x2_KEY,
						new SIRLabelValue[][][] {
						// Step 0
								{ {
								// N[0,0]
										new SIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0),
										// N[0,1]
										new SIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0) } },

								// Step 1
								{ {
								// N[0,0]
										new SIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0),
										// N[0,1]
										new SIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0) } },
								// Step 2
								{ {
								// N[0,0]
										new SIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0),
										// N[0,1]
										new SIRLabelValueImpl(100, 0, 0, 0, 0,
												0, 0) } } } // new
				// SIRLabelValue
				); // put(TEST_SCENARIO1x2_KEY)

		// 1x3
		expectedDiseaseModelStates.put(TEST_SCENARIO1x3_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} } } // new SIRLabelValue

				); // put(TEST_SCENARIO1x3_KEY)

		// 2x2
		expectedDiseaseModelStates.put(TEST_SCENARIO2x2_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} } } // new SIRLabelValue

				); // put(TEST_SCENARIO2x2_KEY)

		// 3x3
		expectedDiseaseModelStates.put(TEST_SCENARIO3x3_KEY,
				new SIRLabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[2,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[2,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[2,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[2,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[0,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[1,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[2,1]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0),
								// N[2,2]
								new SIRLabelValueImpl(100, 0, 0, 0, 0, 0, 0)

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
		retValue.add(DeterministicSIRDiseaseModelTest.createFixture());
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
} // DeterministicSIRScenarioTest

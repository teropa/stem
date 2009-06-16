// DeterministicSIScenarioTest.java
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
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl;

/**
 * This class is a JUnit test case for a Deterministic SI disease model
 * scenario.
 * 
 * <ul>
 * <li>S - The number of <code>Susceptible</code> population members. Members
 * enter this state by being born or by "recovering" from being
 * <code>Infectious</code>. They leave this state either by death or by
 * entering the <code>Infectious</code> state.
 * {@link SITest#TRANSMISSION_RATE} = 0.1, {@link SITest#RECOVERY_RATE} = 0.1
 * 
 * Initialized to {@link DiseaseModelTestUtil#TEST_POPULATION_COUNT} = 100 </li>
 * <li>I - The number of <code>Infectious</code> population members.
 * Initialized to {@link SIDiseaseModelScenarioTest#NUMBER_TO_INFECT} = 1 </li>
 * 
 * <li>B - The number of <code>Births</code> of new (Susceptible) population
 * members.
 * 
 * 
 * Computed as a function of the "background mortality rate"
 * {@link DiseaseModel#getBackgroundMortalityRate()}. We use the death rate
 * because we assume that the population was in equilibrium before the onset of
 * the disease (i.e., neither naturally growing or shrinking much over the time
 * period of the simulation). The value used for the test is . Initialized to 0.
 * </li>
 * 
 * 
 * <li>D - The total number of <code>Deaths</code> of all types of population
 * members. Just like the births, this is computed as a function of the
 * "background mortality rate" {@link DiseaseModel#getBackgroundMortalityRate()}.
 * The rate used for the test is {@link DiseaseModelTest#MORTALITY_RATE} = 0.01.
 * However, it also includes the additional deaths of <code>Infectious</code>
 * population members (i.e., DD below) due to the disease. Initialized to 0.</li>
 * <li>DD - The total number of <code>Disease Deaths</code> of
 * <code>Infectious</code> population members. It is a function of the which
 * is not a rate, but rather the fraction of <code>Infectious</code>
 * population members that eventually die from the disease (i.e., it's the
 * mortality of the disease, how many who get it die from it).
 * {@link SIImpl#computeInfectiousMortalityRate(double, double)}. Initialized
 * to 0. </li>
 * </ul>
 * <ul>
 * <li>&mu; = {@link DiseaseModelTest#MORTALITY_RATE} = 0.01</li>
 * <li>&beta; = {@link SITest#TRANSMISSION_RATE} = 0.1</li>
 * <li>&sigma; = {@link SITest#RECOVERY_RATE} = 0.01</li>
 * <li>x = {@link SITest#INFECTIOUS_MORTALITY} = 0.1 </li>
 * <li>&mu;<sub>i</sub> = {@link SITest#INFECTIOUS_MORTAILY_RATE} = 0.1</li>
 * <li>Area<sub>l</sub> = 1.0</li>
 * <li>Area = 1.0</li>
 * <li>P = S + I = {@link DiseaseModelTestUtil#TEST_POPULATION_COUNT} = 100</li>
 * </ul>
 * <h2>1x1 Deterministic SI Scenario</h2>
 * <h3>Initial State</h3>
 * <p>
 * S= 99.0, I<sup>R</sup>=1.0, I<sup>F</sup>=0.0, B=0.0, D=0.0, DD=0.0
 * </p>
 * <h3>SI 1x1 Step 0</h3>
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
 * <li><em>&Delta;B = &mu; * (S + I<sup>R</sup> + I<sup>F</sup>)</em></li>
 * <li><em>&Delta;B = 0.01 * (99+1+0) </em> </li>
 * <li><em>&Delta;B = 1.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;DD = &mu;<sub>i</sub> I<sup>F</sup>  </em> </li>
 * <li><em>&Delta;DD= 0.1 * 0</em> </li>
 * <li><em>&Delta;DD= 0.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;D = &mu; S + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu; I<sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;D = 0.01 * 99 + (0.01 + 0.1 ) 0 + 0.01 * 1 </em> </li>
 * <li><em>&Delta;D= 1</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;S = &mu; (S + I) - &beta;<sup>*</sup> S I + &sigma; I<sup>R</sup> - &mu; S</em></li>
 * <li><em>&Delta;S = 0.01 (99+(1+0)) - 0.001 * 99 * (1+0) + 0.01 * 1 - 0.01 * 99</em></li>
 * <li><em>&Delta;S = 1.0 - 0.099 + 0.01 - 0.99</em></li>
 * <li><em>&Delta;S = -0.079</em></li>
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
 * <p>
 * S= 98.921, I<sup>R</sup>=1.0691, I<sup>F</sup>=0.0099, B=1.0, D=1.0,
 * DD=0.0
 * </p>
 * 
 * <h3>SI 1x1 Step 1</h3>
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
 * <li><em>&Delta;B = &mu; * (S + I<sup>R</sup> + I<sup>F</sup>)</em></li>
 * <li><em>&Delta;B = 0.01 * (100) </em> </li>
 * <li><em>&Delta;B = 1.0</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;DD = &mu;<sub>i</sub> I<sup>F</sup>  </em> </li>
 * <li><em>&Delta;DD= 0.1 * 0.01</em> </li>
 * <li><em>&Delta;DD= 0.001</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;D = &mu; S + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu; I<sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;D = 0.01 * 98.921 + (0.01 + 0.1 )0.0099 + 0.01 * 1.0691 </em>
 * </li>
 * <li><em>&Delta;D= 1.00099</em> </li>
 * </ul>
 * <ul>
 * <li><em>&Delta;S = &mu; (S + I) - &beta;<sup>*</sup> S I + &sigma; I<sup>R</sup> - &mu; S</em></li>
 * <li><em>&Delta;S = 0.01 * 100 - 0.001 * 98.921 * (1.0691+0.0099) + 0.01 * 1.0691 - 0.01 * 98.921</em></li>
 * <li><em>&Delta;S = 1.0 - 0.10596859 + 0.010691 - 0.98921</em></li>
 * <li><em>&Delta;S = -0.08448759</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>R</sup> = (1-x)&beta;<sup>*</sup> S I - &sigma; I<sup>R</sup> - &mu; I<sup>R</sup></em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.9 * 0.001 * 98.921 * (1.0691+0.0099) -  0.01 * 1.0691 - 0.01 * 1.0691</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.095371731 - .010691 - .010691</em></li>
 * <li><em>&Delta;I<sup>R</sup> = 0.073989731</em></li>
 * </ul>
 * <ul>
 * <li><em>&Delta;I<sup>F</sup> = x&beta;<sup>*</sup> S I  - (&mu; + &mu;<sub>i</sub>) I<sup>F</sup></em></li>
 * <li><em>&Delta;I<sup>F</sup> = 0.1 * 0.001 * 98.921 * (1.0691+0.0099)  - (0.01 + 0.1) * 0.0099</em></li>
 * <li><em>&Delta;I<sup>F</sup> = .009507859</em></li>
 * </ul>
 * <p>
 * S= 98.83651241, I<sup>R</sup>=1.143089731, I<sup>F</sup>=0.019407859 ,
 * B=2.0, D=2.00099, DD=0.001
 * </p> <
 * 
 * @see DiseaseModelTestUtil#TEST_POPULATION_COUNT
 * @see SIDiseaseModelScenarioTest#NUMBER_TO_INFECT
 * @see DiseaseModelTestUtil#TEST_AREA
 * @see SITest#INFECTIOUS_MORTALITY
 * @see SITest#TRANSMISSION_RATE
 * @see SITest#NON_LINEARITY_COEFFICIENT
 * @see SITest#RECOVERY_RATE
 * @see SIImpl
 */
public class DeterministicSIScenarioTest extends SIDiseaseModelScenarioTest {

	private static final String DISEASE_URI_PREFIX = "DeterministicSI";

	private static Map<String, Integer> expectedNumberOfLabelsToUpdate = new HashMap<String, Integer>();

	private static Map<String, SILabelValue[][][]> expectedDiseaseModelStates = new HashMap<String, SILabelValue[][][]>();

	static {

		// 1x1
		expectedDiseaseModelStates.put(TEST_SCENARIO1x1_KEY,
				new SILabelValue[][][] {
				// Step 0
						{ {
						// N[0,0]
						new SILabelValueImpl(99.02, 0.98, 0.0, 1.0, 1.0,
								0.0) } },

						// Step 1
						{ {
						// N[0,0]
						new SILabelValueImpl(99.04, 0.96,
								0.0, 2.0, 2.0, 0.0) } } } // new
				// SILabelValue

				); // put(TEST_SCENARIO1x1_KEY)

		// 1x2
		expectedDiseaseModelStates.put(TEST_SCENARIO1x2_KEY,
				new SILabelValue[][][] {
				// Step 0
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0) } },

						// Step 1
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0) } },
						// Step 2
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0) } } } // new
				// SILabelValue
				); // put(TEST_SCENARIO1x2_KEY)

		// 1x3
		expectedDiseaseModelStates.put(TEST_SCENARIO1x3_KEY,
				new SILabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} } } // new SILabelValue

				); // put(TEST_SCENARIO1x3_KEY)

		// 2x2
		expectedDiseaseModelStates.put(TEST_SCENARIO2x2_KEY,
				new SILabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} } } // new SILabelValue

				); // put(TEST_SCENARIO2x2_KEY)

		// 3x3
		expectedDiseaseModelStates.put(TEST_SCENARIO3x3_KEY,
				new SILabelValue[][][] {
				// Step 0
						{ {

						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[2,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[2,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} },

						// Step 1
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[2,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[2,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} },

						// Step 2
						{ {
						// N[0,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[0,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[1,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[1,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						}, {

						// N[2,0]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[2,1]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0),
								// N[2,2]
								new SILabelValueImpl(100, 0, 0, 0, 0, 0)

						} } } // new SILabelValue

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
		retValue.add(DeterministicSIDiseaseModelTest.createFixture());
		return retValue;
	} // getDiseaseModelsToTest

	@Override
	protected int getNumberOfSteps(final String diseaseScenarioKey) {
		SILabelValue[][][] temp = expectedDiseaseModelStates
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
		final SILabelValue[][][] siLabelValue = expectedDiseaseModelStates
				.get(diseaseScenarioKey);
		return siLabelValue[step];
	} // getExpectedDiseaseModelState

	protected String getDiseaseURIPrefix() {
		return DISEASE_URI_PREFIX;
	} // getDiseaseURIPrefix
} // DeterministicSIScenarioTest

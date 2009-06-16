// DiseaseModelScenarioTest.java
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
import java.util.List;
import java.util.StringTokenizer;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.tests.ScenarioTest;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;

/**
 * This class is the top-level class for all test of disease models in a
 * particular scenario.
 */
public abstract class DiseaseModelScenarioTest extends TestCase {

	protected static final String DIRECTORY = "temp";

	/**
	 * The key for scenario 1x1
	 */
	public static final String TEST_SCENARIO1x1_KEY = "1x1";

	/**
	 * The key for scenario 1x2
	 */
	public static final String TEST_SCENARIO1x2_KEY = "1x2";

	/**
	 * The key for scenario 1x3
	 */
	public static final String TEST_SCENARIO1x3_KEY = "1x3";

	/**
	 * The key for scenario 2x2
	 */
	public static final String TEST_SCENARIO2x2_KEY = "2x2";

	/**
	 * The key for scenario 3x3
	 */
	public static final String TEST_SCENARIO3x3_KEY = "3x3";

	// TODO implement the disease model test scenarios

	// You need to un-comment the testSpecifications and then in each of the
	// test implementations you're going to need to figure out the valid disease
	// model label values. see StochasticSEIRScenarioTest.java etc.
	protected static TestSpec[] testSpecifications = new TestSpec[] { new TestSpec(
			1, 1, TEST_SCENARIO1x1_KEY)
	/*
	 * new TestSpec(1, 1, TEST_SCENARIO1x1_KEY), new TestSpec(1, 2,
	 * TEST_SCENARIO1x2_KEY), new TestSpec(1, 3, TEST_SCENARIO1x3_KEY), new
	 * TestSpec(2, 2, TEST_SCENARIO2x2_KEY), new TestSpec(3, 3,
	 * TEST_SCENARIO3x3_KEY)
	 */
	};

	/**
	 * @param expectedLabelValues
	 *            the expected label values for the test
	 * @return how many labels are expected to be updated by a disease model for
	 *         each test.
	 */
	protected static int computeExpectedNumberOfLabels(
			final LabelValue[][][] expectedLabelValues) {
		return expectedLabelValues[0].length * expectedLabelValues[0][0].length;
	} // computeExpectedNumberOfLabels

	/**
	 * @param numRows
	 *            the number of rows in the lattice
	 * @param numColumns
	 *            the number of columns in the lattice
	 * @return a scenario with nodes in a lattice with a disease model.
	 */
	public Scenario createFixture(final int numRows, final int numColumns) {
		final Collection<NodeDecorator> DISEASE_MODELS = new ArrayList<NodeDecorator>();
		DISEASE_MODELS.addAll(getDiseaseModelsToTest());

		final Model model = DiseaseModelTestUtil.createLatticeModel(
				DISEASE_MODELS, numRows, numColumns,
				DiseaseModelTestUtil.TEST_POPULATION_COUNT,
				DiseaseModelTestUtil.TEST_AREA);

		final Scenario retValue = DiseaseModelTestUtil.createLatticeScenario(
				getScenarioDecorators(model), model);

		assert retValue.sane();

		return retValue;
	} // createFixture

	/**
	 * Execute all of the tests specified in testSpecifications
	 */
	public void testDoAllTests() {
		for (final TestSpec testSpec : testSpecifications) {
			doTest(testSpec);
		}
	} // testDoAllTests

	/**
	 * Test serializing and de-serializing scenarios
	 */
	public void testSerializeDeserializeScenario() {

		final int[][] rowColumns = new int[][] { { 1, 1 }, { 1, 2 }, { 3, 3 } };

		for (final int[] rowColumn : rowColumns) {
			final Scenario fixture = createFixture(rowColumn[0], rowColumn[1]);

			final URI uri = createSerializationURI(fixture);
			ScenarioTest.serializeDeserializeScenario(fixture, uri);
		}
	} // testSerializeDeserializeScenario

	/**
	 * @param testSpec
	 *            a test specification
	 */
	private void doTest(final TestSpec testSpec) {
		doTest(createFixture(testSpec.numRows, testSpec.numColumns),
				testSpec.scenarioDiseaseKey);
	} // doTest

	/**
	 * @param scenario
	 *            the scenario to test
	 * @param scenarioDiseaseKey
	 *            the unique identifier of the scenario test
	 */
	private void doTest(final Scenario scenario, final String scenarioDiseaseKey) {

		final int numSteps = getNumberOfSteps(scenarioDiseaseKey);

		// Step through the disease computation by using the actual scenario
		// step method
		for (int step = 0; step < numSteps; step++) {
			// Make one step...
			scenario.step();
			// ... and make sure everything looks ok
			assertTrue(scenario.sane());

			// Now validate the computed values for each disease model in the
			// scenario...
			for (final DiseaseModel diseaseModel : getDiseaseModels(scenario)) {
				// Really only need to check this once...
				if (step == 0) {
					assertTrue(
							"Disease model \""
									+ diseaseModel.getDublinCore().getTitle()
									+ "\" \""
									+ scenario.getDublinCore().getTitle()
									+ "\" \"" + scenarioDiseaseKey,
							diseaseModel.getLabelsToUpdate().size() == getExpectedNumberOfLabelsToUpdate(scenarioDiseaseKey));
				} // if

				assertTrue(validateDiseaseModelState(scenario,
						scenarioDiseaseKey, step, diseaseModel,
						getExpectedDiseaseModelState(scenarioDiseaseKey, step)));

			} // for each disease model
		} // for each step

	} // doTest

	/**
	 * @param scenario
	 *            the scenario whose state is to be verified
	 * @param scenarioDiseaseKey
	 *            the unique identifier of the scenario test
	 * @param step
	 *            the step number in the test being verified
	 * @param expectedDiseaseModelState
	 *            the disease model label values that should be present
	 */
	private boolean validateDiseaseModelState(final Scenario scenario,
			final String scenarioDiseaseKey, final int step,
			final DiseaseModel diseaseModel,
			final LabelValue[][] expectedDiseaseModelState) {
		final boolean retValue = true;

		final Graph canonicalGraph = scenario.getCanonicalGraph();

		for (int row = 0; row < expectedDiseaseModelState.length; row++) {
			for (int column = 0; column < expectedDiseaseModelState[row].length; column++) {
				final Region region = DiseaseModelTestUtil.getRegion(
						canonicalGraph, row, column);
				final LabelValue labelValue = expectedDiseaseModelState[row][column];
				final LabelValue dmLabelValue = getCurrentDiseaseModelLabelValue(
						region, diseaseModel);
				assertTrue("Disease model \""
						+ diseaseModel.getDublinCore().getTitle() + "\" ("
						+ scenarioDiseaseKey + ") step: " + step + " [" + row
						+ ", " + column + "] Got \"" + dmLabelValue.toString()
						+ "\", expected \"" + labelValue.toString() + "\"",
						compareLabelValues(labelValue, dmLabelValue));
			} // for column
		} // for row

		return retValue;
	} // validateDiseaseModelState

	/**
	 * @param labelValue
	 * @param dmLabelValue
	 * @return <code>true</code> if the labels are "equal". We do a "fuzzy"
	 *         compare on the double values. We declare them "equal" if they
	 *         differ by less than a specified tolerance.
	 */
	protected boolean compareLabelValues(final LabelValue lableValue1,
			final LabelValue lableValue2) {
		boolean retValue = true;
		final DiseaseModelLabelValue dmLV1 = (DiseaseModelLabelValue) lableValue1;
		final DiseaseModelLabelValue dmLV2 = (DiseaseModelLabelValue) lableValue2;

		retValue = DiseaseModelTestUtil.closeEnough(dmLV1.getBirths(), dmLV2
				.getBirths());
		retValue = retValue
				&& DiseaseModelTestUtil.closeEnough(dmLV1.getDeaths(), dmLV2
						.getDeaths());
		retValue = retValue
				&& DiseaseModelTestUtil.closeEnough(dmLV1.getDiseaseDeaths(),
						dmLV2.getDiseaseDeaths());
		return retValue;
	} // compareLabelValues

	/**
	 * @param fixture
	 *            the scenario to test
	 * @return the URI to use to serialize and then de-serialize the scenario
	 *         under test
	 */
	private URI createSerializationURI(final Scenario fixture) {
		final URI uri = URI
				.createURI(DIRECTORY + "/" + getDiseaseURIPrefix()
						+ encodeTitle(fixture.getDublinCore().getTitle())
						+ ".scenario");
		return uri;
	} // createSerializationURI

	/**
	 * @param title
	 *            the title of a scenario
	 * @return the title with all whitespace removed
	 */
	private String encodeTitle(final String title) {
		final StringBuilder sb = new StringBuilder();
		final StringTokenizer st = new StringTokenizer(title, ",.[] ");
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
		} // while
		return sb.toString();
	} // encodeTitle

	/**
	 * @param region
	 *            the region node to search for a label updated by the disease
	 *            model
	 * @param diseaseModel
	 *            the disease model
	 * @return the current value of the label on the node updated by the disease
	 *         model
	 */
	private LabelValue getCurrentDiseaseModelLabelValue(final Region region,
			final DiseaseModel diseaseModel) {
		LabelValue retValue = null;
		for (final Object element : region.getLabels()) {
			final NodeLabel nodeLabel = (NodeLabel) element;
			if (nodeLabel instanceof DiseaseModelLabel) {
				final DiseaseModelLabel diseaseModelLabel = (DiseaseModelLabel) nodeLabel;
				// Is this label updated by the disease model?
				if (diseaseModel.getLabelsToUpdate()
						.contains(diseaseModelLabel)) {
					// Yes
					retValue = diseaseModelLabel.getCurrentValue();
					break;
				}
			} // if
		} // for each node label
		return retValue;
	} // getCurrentDiseaseModelLabelValue

	/**
	 * 
	 * @param scenario
	 *            a scenario
	 * @return all of the disease models in the scenario.
	 */
	protected List<DiseaseModel> getDiseaseModels(final Scenario scenario) {
		final List<DiseaseModel> retValue = new ArrayList<DiseaseModel>();

		for (final Object element : scenario.getCanonicalGraph()
				.getDecorators()) {
			final Decorator decorator = (Decorator) element;
			if (decorator instanceof DiseaseModel) {
				retValue.add((DiseaseModel) decorator);
			}
		} // for each decorator in the canonical graph
		return retValue;
	} // getDiseaseModel

	/**
	 * @param diseaseScenarioKey
	 *            the key identifying the test
	 * @return the number of disease model computations to execute for the test.
	 */
	protected abstract int getNumberOfSteps(final String diseaseScenarioKey);

	/**
	 * @param diseaseScenarioKey
	 *            the key identifying the test
	 * @return the expected number of labels a disease model will update
	 */
	protected abstract int getExpectedNumberOfLabelsToUpdate(
			final String diseaseScenarioKey);

	/**
	 * @param diseaseScenarioKey
	 *            identifier that uniquely identifies the combination of disease
	 *            and scenario.
	 * @param step
	 *            the simulation step that has been completed.
	 * @return an array of disease model label values that are the expected
	 *         values after the given step of the simulation.
	 */
	protected abstract LabelValue[][] getExpectedDiseaseModelState(
			final String diseaseScenarioKey, final int step);

	/**
	 * @return the disease models to be tested
	 */
	public abstract List<NodeDecorator> getDiseaseModelsToTest();

	/**
	 * @param model
	 *            the model to generate scenario decorators for
	 * @return the scenario decorators to include in a fixture
	 */
	public abstract Collection<Decorator> getScenarioDecorators(Model model);

	/**
	 * @return a string to be used in a URI to prefix the scenario files being
	 *         serialized for a particular disease under test.
	 */
	protected abstract String getDiseaseURIPrefix();

	/**
	 * This class represents the parameters for the specification of a test
	 */
	protected static final class TestSpec {
		/**
		 * The number of rows in the lattice graph
		 */
		public int numRows = 0;

		/**
		 * The number of columns in the lattice graph
		 */
		public int numColumns = 0;

		/**
		 * The scenario/disease key of the test.
		 */
		public String scenarioDiseaseKey = "";

		/**
		 * @param numRows
		 * @param numColumns
		 * @param scenarioDiseaseKey
		 */
		protected TestSpec(final int numRows, final int numColumns,
				final String scenarioDiseaseKey) {
			super();
			this.numRows = numRows;
			this.numColumns = numColumns;
			this.scenarioDiseaseKey = scenarioDiseaseKey;
		}
	} // TestSpec

} // DiseaseModelScenarioTest

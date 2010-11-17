package org.eclipse.stem.core.experiment.tests;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.List;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.core.experiment.ExperimentFactory;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.DoubleSequenceModifier;
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.IntegerSequenceModifier;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.RangeModifier;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;
import org.eclipse.stem.core.modifier.SequenceModifier;
import org.eclipse.stem.core.modifier.StringSequenceModifier;
import org.eclipse.stem.core.modifier.tests.DoubleRangeModifierTest;
import org.eclipse.stem.core.modifier.tests.IntegerRangeModifierTest;
import org.eclipse.stem.core.modifier.tests.STEMTimeRangeModifierTest;
import org.eclipse.stem.core.modifier.tests.StringSequenceModifierTest;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.tests.ScenarioTest;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Experiment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.experiment.Experiment#isComplete() <em>Complete</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.experiment.Experiment#updateScenario() <em>Update Scenario</em>}</li>
 *   <li>{@link org.eclipse.stem.core.experiment.Experiment#initScenario() <em>Init Scenario</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class ExperimentTest extends IdentifiableTest {

	public static final Boolean BSM_START_VALUE = Boolean.TRUE;
	public static final Boolean BSM_END_VALUE = Boolean.FALSE;
	protected static final int MAX_TEST_CYCLES = 11;

	static protected Scenario baseScenario;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExperimentTest.class);
	}

	/**
	 * Constructs a new Experiment test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExperimentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Experiment test case.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Experiment getFixture() {
		return (Experiment)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		baseScenario = createBaseScenario();
		setFixture(createFixture());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Test that the fixture is "sane"
	 * 
	 * @see SanityChecker
	 */
	public void testFixtureSanity() {
		final SanityChecker fixture = getFixture();
		assertTrue(fixture.sane());
	} // testFixtureSanity

	/**
	 * Tests the '{@link org.eclipse.stem.core.experiment.Experiment#getModificationSummary() <em>Modification Summary</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.experiment.Experiment#getModificationSummary()
	 * @generated NOT
	 */
	public void testGetModificationSummary() {
		final Experiment fixture = getFixture();
		List<String> summary = fixture.getModificationSummary();
		assertNotNull(summary);
		assertTrue(summary.size() > 0);
	} // testGetModificationSummary

	/**
	 * Tests the '{@link org.eclipse.stem.core.experiment.Experiment#isComplete() <em>Complete</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.experiment.Experiment#isComplete()
	 * @generated NOT
	 */
	public void testIsComplete() {
		// TODO testIsComplete
		final Experiment fixture = getFixture();
		assertFalse(fixture.isComplete());
	} // testIsComplete

	/**
	 * Tests the '{@link org.eclipse.stem.core.experiment.Experiment#updateScenario() <em>Update Scenario</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.experiment.Experiment#updateScenario()
	 * @generated NOT
	 */
	public void testUpdateScenario() {
		final Experiment fixture = getFixture();
		//while (!fixture.isComplete()) {
		for (int i = 0; i < MAX_TEST_CYCLES; i ++) {
		
			if  (!fixture.isComplete()) {
				final Scenario updatedScenario = fixture.updateScenario();
				assertTrue(updatedScenario.sane());
			}
			
		} // while !fixture.isComplete()
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.experiment.Experiment#initScenario() <em>Init Scenario</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.experiment.Experiment#initScenario()
	 * @generated NOT
	 */
	public void testInitScenario() {
		assertTrue(true);
	}

	/**
	 * @return an {@link Experiment} for testing.
	 */
	public static Experiment createFixture() {
		final Experiment retValue = ExperimentFactory.eINSTANCE
				.createExperiment();
		retValue.setScenario(createBaseScenario());
		retValue.getModifiers().add(createRangeModifier(retValue.getScenario()));
		// retValue.getModifiers().add(createSequenceModifier(baseScenario));
		retValue.getDublinCore().populate();

		return retValue;
	} // createFixture

	/**
	 * @param baseScenario
	 * @return a {@link Modifier} that contains {@link SequenceModifier}s.
	 */
	@SuppressWarnings({ "boxing", "unused" })
	private static Modifier createSequenceModifier(Scenario baseScenario) {
		final Modifier retValue = ModifierFactory.eINSTANCE.createModifier();

		// Descend into the Scenario looking for something with a double field
		final EList<Decorator> scenarioDecorators = baseScenario
				.getScenarioDecorators();

		for (Decorator decorator : scenarioDecorators) {
			// Look through the attributes in the decorator
			for (EAttribute attribute : decorator.eClass().getEAllAttributes()) {

				// Is this a double?
				if (attribute.getEAttributeType().equals(
						EcorePackage.Literals.EDOUBLE)) {
					// Yes
					final DoubleSequenceModifier dsm = ModifierFactory.eINSTANCE
							.createDoubleSequenceModifier();
					dsm.getSequence().add(
							DoubleRangeModifierTest.DRM_START_VALUE);
					dsm.getSequence()
							.add(DoubleRangeModifierTest.DRM_END_VALUE);
					dsm.setEStructuralFeature(attribute);
					retValue.setTargetURI(decorator.getURI());
					retValue.getFeatureModifiers().add(dsm);
				} // if double
				// Is this an integer?
				else if (attribute.getEAttributeType().equals(
						EcorePackage.Literals.EINT)) {
					// Yes
					final IntegerSequenceModifier ism = ModifierFactory.eINSTANCE
							.createIntegerSequenceModifier();
					ism.getSequence().add(
							IntegerRangeModifierTest.IRM_START_VALUE);
					ism.getSequence().add(
							IntegerRangeModifierTest.IRM_END_VALUE);
					ism.setEStructuralFeature(attribute);
					retValue.setTargetURI(decorator.getURI());
					retValue.getFeatureModifiers().add(ism);
				} // if integer
				// Is this a boolean?
				// else if (attribute.getEAttributeType().equals(
				// EcorePackage.Literals.EBOOLEAN)) {
				// // Yes
				// final SequenceModifier bsm = ModifierFactory.eINSTANCE
				// .createSequenceModifier();
				// bsm.getSequence().add(BSM_START_VALUE);
				// bsm.getSequence().add(BSM_END_VALUE);
				// bsm.setEStructuralFeature(attribute);
				// retValue.setTargetURI(decorator.getURI());
				// retValue.getFeatureModifiers().add(bsm);
				// } // if boolean
				// Is this a String?
				else if (attribute.getEAttributeType().equals(
						EcorePackage.Literals.ESTRING)) {
					// Yes
					final StringSequenceModifier ssm = ModifierFactory.eINSTANCE
							.createStringSequenceModifier();
					ssm.getSequence().add(
							StringSequenceModifierTest.STRING_START_VALUE);
					ssm.getSequence().add(
							StringSequenceModifierTest.STRING_END_VALUE);
					ssm.setEStructuralFeature(attribute);
					retValue.setTargetURI(decorator.getURI());
					retValue.getFeatureModifiers().add(ssm);
				} // if String
			} // for each EAttribute

			// Now look through the references
			for (EReference reference : decorator.eClass().getEAllReferences()) {
				if (retValue.getFeatureModifiers().size() > 0) {
					// Is this an STEMTime?
					if (reference.getEType().equals(
							ModelPackage.Literals.STEM_TIME)) {
						// Yes
						final STEMTimeRangeModifier strm = ModifierFactory.eINSTANCE
								.createSTEMTimeRangeModifier();
						strm
								.setStartValue(STEMTimeRangeModifierTest.STEM_TIME_START_VALUE);
						strm
								.setEndValue(STEMTimeRangeModifierTest.STEM_TIME_END_VALUE);
						strm
								.setIncrement(STEMTimeRangeModifierTest.STEM_TIME_INCREMENT_VALUE);
						strm.setEStructuralFeature(reference);
						retValue.getFeatureModifiers().add(strm);
					} // if STEMTime
				} // for each EReference
				// Did we find one?
				// Yes
				break;
			} // if
		} // for each Decorator

		return retValue;
	} // createSequenceModifier

	/**
	 * @param baseScenario
	 * @return a {@link Modifier} that contains {@link RangeModifier}s.
	 */
	private static Modifier createRangeModifier(final Scenario baseScenario) {
		final Modifier retValue = ModifierFactory.eINSTANCE.createModifier();

		// Descend into the Scenario looking for something with a double field
		final EList<Decorator> scenarioDecorators = baseScenario
				.getScenarioDecorators();

		for (Decorator decorator : scenarioDecorators) {
			// Look through the attributes in the decorator
			for (EAttribute attribute : decorator.eClass().getEAllAttributes()) {

				// Is this a double?
				if (attribute.getEAttributeType().equals(
						EcorePackage.Literals.EDOUBLE)) {
					// Yes
					final DoubleRangeModifier drm = ModifierFactory.eINSTANCE
							.createDoubleRangeModifier();
					drm.setStartValue(DoubleRangeModifierTest.DRM_START_VALUE);
					drm.setEndValue(DoubleRangeModifierTest.DRM_END_VALUE);
					drm
							.setIncrement(DoubleRangeModifierTest.DRM_INCREMENT_VALUE);
					drm.setEStructuralFeature(attribute);
					retValue.getFeatureModifiers().add(drm);
				} // if double
				// Is this an integer?
				else if (attribute.getEAttributeType().equals(
						EcorePackage.Literals.EINT)) {
					// Yes
					final IntegerRangeModifier irm = ModifierFactory.eINSTANCE
							.createIntegerRangeModifier();
					irm.setStartValue(IntegerRangeModifierTest.IRM_START_VALUE);
					irm.setEndValue(IntegerRangeModifierTest.IRM_END_VALUE);
					irm
							.setIncrement(IntegerRangeModifierTest.IRM_INCREMENT_VALUE);
					irm.setEStructuralFeature(attribute);
					retValue.getFeatureModifiers().add(irm);
				} // if integer

			} // for each EAttribute

//			// Now look through the references
//			for (EReference reference : decorator.eClass().getEAllReferences()) {
//				// Is this an STEMTime?
//				if (reference.getEType()
//						.equals(ModelPackage.Literals.STEM_TIME)) {
//					// Yes
//					final STEMTimeRangeModifier strm = ModifierFactory.eINSTANCE
//							.createSTEMTimeRangeModifier();
//					strm
//							.setStartValue(STEMTimeRangeModifierTest.STEM_TIME_START_VALUE);
//					strm
//							.setEndValue(STEMTimeRangeModifierTest.STEM_TIME_END_VALUE);
//					strm
//							.setIncrement(STEMTimeRangeModifierTest.STEM_TIME_INCREMENT_VALUE);
//					strm.setEStructuralFeature(reference);
//					retValue.getFeatureModifiers().add(strm);
//				} // if STEMTime
//			} // for each EReference
			
			// Anything?
			if (retValue.getFeatureModifiers().size() > 0) {
				// Yes
				retValue.setTargetURI(decorator.getURI());
				break;
			} // if 
		} // for each Decorator

		return retValue;
	} // createRangeModifier

	/**
	 * @return a base {@link Scenario} for testing
	 */
	static Scenario createBaseScenario() {
		return ScenarioTest.createFixture();
	}

} // ExperimentTest

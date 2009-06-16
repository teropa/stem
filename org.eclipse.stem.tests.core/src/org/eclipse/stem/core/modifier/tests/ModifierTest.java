package org.eclipse.stem.core.modifier.tests;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.textui.TestRunner;

import org.eclipse.stem.core.model.tests.DecoratorTest;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
//import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.experiment.tests.ExperimentTest;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.modifier.ModifierFactory;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.Modifier#isComplete() <em>Complete</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.Modifier#updateScenario(org.eclipse.stem.core.scenario.Scenario) <em>Update Scenario</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.Modifier#reset() <em>Reset</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
@SuppressWarnings("all")
public class ModifierTest extends DecoratorTest {

	public static final String TEST_PACKAGE_NAME = "testpackage";
	public static final String TEST_PACKAGE_NSPREFIX = "test";
	public static final String TEST_PACKAGE_NSURI = "http:///com.example.test";
	
	public static final String TEST_EOBJECT_CLASSNAME1 = "testobject1";
	public static final List<EClassifier> TEST_OBJECT_FEATURES1 = Arrays
			.asList(new EClassifier[] { EcorePackage.Literals.EINT,
					EcorePackage.Literals.EDOUBLE,
					ModelPackage.Literals.STEM_TIME });
	
	public static final String TEST_EOBJECT_CLASSNAME2 = "testobject2";
	public static final List<EClassifier> TEST_OBJECT_FEATURES2 = Arrays
			.asList(new EClassifier[] { EcorePackage.Literals.EINT,
					EcorePackage.Literals.EDOUBLE,
					ModelPackage.Literals.STEM_TIME,
					EcorePackage.Literals.ESTRING });
	
	/**
	 * This is the EPackage instance that defines {@link EClass}s to be used to
	 * create test object instances.
	 */
	public static final EPackage TEST_PACKAGE;
	
	static {
		final Map<String,List<EClassifier>> eClassNameTofeatureTypeMap = new HashMap<String, List<EClassifier>>();
		eClassNameTofeatureTypeMap.put(TEST_EOBJECT_CLASSNAME1, TEST_OBJECT_FEATURES1);
		eClassNameTofeatureTypeMap.put(TEST_EOBJECT_CLASSNAME2, TEST_OBJECT_FEATURES2);
		TEST_PACKAGE = createTestPackage(TEST_PACKAGE_NAME, TEST_PACKAGE_NSPREFIX, TEST_PACKAGE_NSURI,
				eClassNameTofeatureTypeMap);
	} // static
	
	/**
	 * Test object for modification
	 */
	protected EObject testObject1 = null;
	/**
	 * Test object for modification
	 */
//	protected EObject testObject2 = null;
	

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModifierTest.class);
	}

	/**
	 * Constructs a new Modifier test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Modifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Modifier getFixture() {
		return (Modifier)fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		testObject1 = TEST_PACKAGE.getEFactoryInstance().create(
				(EClass) TEST_PACKAGE.getEClassifier(TEST_EOBJECT_CLASSNAME1));
//		testObject2 = TEST_PACKAGE.getEFactoryInstance().create(
//				(EClass) TEST_PACKAGE.getEClassifier(TEST_EOBJECT_CLASSNAME2));
		setFixture(createFixture(testObject1));
	} // setUp

	/**
	 * @return a {@link Modifier} for testing
	 */
	static public  Modifier createFixture(final EObject testObject) {
		final Modifier retValue = ModifierFactory.eINSTANCE.createModifier();
		retValue.getFeatureModifiers().addAll(createFeatureModifiers(testObject));
		return retValue;
	} // createFixture

	/**
	 * @param testObject
	 *            the {@link EObject} to create the {@link FeatureModifier}s
	 *            for
	 * @return a {@link List} of {@link FeatureModifier}s for a specific
	 *         {@link EObject}
	 */
	private static List<FeatureModifier> createFeatureModifiers(
			final EObject testObject) {
		final List<FeatureModifier> retValue = new ArrayList<FeatureModifier>();
		for (EStructuralFeature eStruturalFeature : testObject.eClass()
				.getEStructuralFeatures()) {
			// EInt?
			if (eStruturalFeature.getEType() == EcorePackage.Literals.EINT) {
				// Yes
				final IntegerRangeModifier irm = ModifierFactory.eINSTANCE
						.createIntegerRangeModifier();
				irm.setEStructuralFeature(eStruturalFeature);
				irm.setStartValue(IntegerRangeModifierTest.IRM_START_VALUE);
				irm.setEndValue(IntegerRangeModifierTest.IRM_END_VALUE);
				irm.setIncrement(IntegerRangeModifierTest.IRM_INCREMENT_VALUE);
				retValue.add(irm);
			} // if EInt
			// EDouble
			else if (eStruturalFeature.getEType() == EcorePackage.Literals.EDOUBLE) {
				// Yes
				final DoubleRangeModifier drm = ModifierFactory.eINSTANCE
						.createDoubleRangeModifier();
				drm.setEStructuralFeature(eStruturalFeature);
				drm.setStartValue(DoubleRangeModifierTest.DRM_START_VALUE);
				drm.setEndValue(DoubleRangeModifierTest.DRM_END_VALUE);
				drm.setIncrement(DoubleRangeModifierTest.DRM_INCREMENT_VALUE);
				retValue.add(drm);
			} // if
		} // for each eStructuralFeature

		return retValue;
	} // createFeatureModifiers

	/**
	 * Create a single EMF {@link EObject} instance for testing.
	 * @param eClassName
	 *            the name of the {@link EClass} for the {@link EObject}
	 * @param featureTypes
	 *            a list of {@link EClassifier} instances of the types of the
	 *            attributes in the {@link EClass}
	 * @return an {@link EObject} to be modified
	 */
	static public EObject createTestObject(final String eClassName,
			List<EClassifier> featureTypes) {
		final Map<String, List<EClassifier>> eClassNameTofeatureTypeMap = new HashMap<String, List<EClassifier>>();
		eClassNameTofeatureTypeMap.put(eClassName, featureTypes);
		final EPackage ePackage = createTestPackage(TEST_PACKAGE_NAME,
				TEST_PACKAGE_NSPREFIX, TEST_PACKAGE_NSURI,
				eClassNameTofeatureTypeMap);
		return ePackage.getEFactoryInstance().create(
				(EClass) ePackage.getEClassifier(eClassName));
	} // createTestObject

	/**
	 * @param packageName
	 *            the name of the package
	 * @param nsPrefix
	 *            the prefix to use for the package's name space
	 * @param nsURI
	 *            the {@link URI} to use for the package's name space
	 * @param eClassNameTofeatureTypeMap
	 *            a {@link Map} between the name of a {@link EClass} that
	 *            defines an {@link EObject} to create and a list of
	 *            {@link EClassifier}s that define the type the {@link EObject}'s
	 *            {@link EStructuralFeature}s. The names of the
	 *            {@link EStructuralFeature}s will be created from the types of
	 *            the {@link EClassifier}s.
	 * @return an {@link EPackage}
	 */
	public static EPackage createTestPackage(final String packageName,
			final String nsPrefix, final String nsURI,
			final Map<String, List<EClassifier>> eClassNameTofeatureTypeMap) {
		// A little bit of dynamic EMF here...
		final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(packageName);
		ePackage.setNsPrefix(nsPrefix);
		ePackage.setNsURI(nsURI);

		for (String eClassName : eClassNameTofeatureTypeMap.keySet()) {

			final EClass testClass = EcoreFactory.eINSTANCE.createEClass();
			testClass.setName(eClassName);
			
			int attributeCount = 0;
			// Now create the structural features
			for (EClassifier eClassifier : eClassNameTofeatureTypeMap
					.get(eClassName)) {
				final EAttribute attribute = EcoreFactory.eINSTANCE
						.createEAttribute();
				attribute.setName(eClassifier.getName() + attributeCount++);
				attribute.setEType(eClassifier);
				attribute.setUnsettable(false);
				testClass.getEStructuralFeatures().add(attribute);
			} // for each EClassifier
			// Add the class to the package
			ePackage.getEClassifiers().add(testClass);
		} // for each EClass name
		return ePackage;
	} // createTestPackage
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	protected void tearDown() throws Exception {
		testObject1 = null;
//		testObject2 = null;
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.Modifier#getModificationSummary() <em>Modification Summary</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.modifier.Modifier#getModificationSummary()
	 * @generated NOT
	 */
	public void testGetModificationSummary() {
		final Modifier fixture = getFixture();
		assertTrue(fixture.getFeatureModifiers().size() > 0);
		final List<String> summary = fixture.getModificationSummary();
		assertNotNull(summary);
		assertTrue(summary.size() > 0);
	} // testGetModificationSummary

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.Modifier#isComplete() <em>Complete</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.modifier.Modifier#isComplete()
	 * @generated NOT
	 */
	public void testIsComplete() {
		final Modifier fixture = getFixture();
		assertTrue(fixture.getFeatureModifiers().size() > 0);
		assertFalse(fixture.isComplete());
	} // testIsComplete

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.Modifier#updateScenario(org.eclipse.stem.core.scenario.Scenario) <em>Update Scenario</em>}'
	 * operation. 
	 * 
	 * <!-- begin-user-doc --> 
	 * 
	 * This is being tested by {@link ExperimentTest#testModifyScenario__Scenario()}
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.core.modifier.Modifier#updateScenario(org.eclipse.stem.core.scenario.Scenario)
	 * @generated NOT
	 * 
	 */
	public void testUpdateScenario__Scenario() {
		assertTrue(true);
		// fail();
		// final Modifier fixture = getFixture();
		// final Scenario baseScenario = ExperimentTest.getBaseScenario();
		// fixture.updateScenario(baseScenario);
		// assertTrue(baseScenario.sane());
	} // testUpdateScenario__Scenario

	/**
	 * Tests the '{@link org.eclipse.stem.core.modifier.Modifier#reset() <em>Reset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.Modifier#reset()
	 * @generated NOT
	 */
	public void testReset() {
		// TODO: implement ModifierTest.testReset()
		assertTrue(true);
	}

} // ModifierTest

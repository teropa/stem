package org.eclipse.stem.core.scenario;

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

//import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.stem.core.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.core.scenario.ScenarioFactory
 * @model kind="package"
 * @generated
 */
public interface ScenarioPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scenario";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/scenario.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.scenario";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScenarioPackage eINSTANCE = org.eclipse.stem.core.scenario.impl.ScenarioPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.scenario.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.scenario.impl.ScenarioImpl
	 * @see org.eclipse.stem.core.scenario.impl.ScenarioPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__MODEL = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequencer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SEQUENCER = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scenario Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SCENARIO_DECORATORS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Canonical Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__CANONICAL_GRAPH = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__PROGRESS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Solver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SOLVER = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.scenario.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.scenario.Scenario#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario#getModel()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Model();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.scenario.Scenario#getSequencer <em>Sequencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequencer</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario#getSequencer()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Sequencer();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.scenario.Scenario#getScenarioDecorators <em>Scenario Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scenario Decorators</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario#getScenarioDecorators()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_ScenarioDecorators();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.scenario.Scenario#getCanonicalGraph <em>Canonical Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Canonical Graph</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario#getCanonicalGraph()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_CanonicalGraph();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.scenario.Scenario#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario#getProgress()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Progress();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.scenario.Scenario#getSolver <em>Solver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Solver</em>'.
	 * @see org.eclipse.stem.core.scenario.Scenario#getSolver()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Solver();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScenarioFactory getScenarioFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.scenario.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.scenario.impl.ScenarioImpl
		 * @see org.eclipse.stem.core.scenario.impl.ScenarioPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__MODEL = eINSTANCE.getScenario_Model();

		/**
		 * The meta object literal for the '<em><b>Sequencer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__SEQUENCER = eINSTANCE.getScenario_Sequencer();

		/**
		 * The meta object literal for the '<em><b>Scenario Decorators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__SCENARIO_DECORATORS = eINSTANCE.getScenario_ScenarioDecorators();

		/**
		 * The meta object literal for the '<em><b>Canonical Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__CANONICAL_GRAPH = eINSTANCE.getScenario_CanonicalGraph();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__PROGRESS = eINSTANCE.getScenario_Progress();

		/**
		 * The meta object literal for the '<em><b>Solver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__SOLVER = eINSTANCE.getScenario_Solver();

}

} //ScenarioPackage

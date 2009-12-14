package automaticexperiment;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

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
 * @see automaticexperiment.AutomaticexperimentFactory
 * @model kind="package"
 * @generated
 */
public interface AutomaticexperimentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "automaticexperiment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/automaticexperiment.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.analysis.automaticexperiment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AutomaticexperimentPackage eINSTANCE = automaticexperiment.impl.AutomaticexperimentPackageImpl.init();

	/**
	 * The meta object id for the '{@link automaticexperiment.impl.AutomaticExperimentImpl <em>Automatic Experiment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see automaticexperiment.impl.AutomaticExperimentImpl
	 * @see automaticexperiment.impl.AutomaticexperimentPackageImpl#getAutomaticExperiment()
	 * @generated
	 */
	int AUTOMATIC_EXPERIMENT = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Base Scenario</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__BASE_SCENARIO = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__PARAMETERS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Error Analysis Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Error Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__ERROR_FUNCTION = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__TOLERANCE = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referance Data Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Automatic Experiment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMATIC_EXPERIMENT_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link automaticexperiment.impl.ModifiableParameterImpl <em>Modifiable Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see automaticexperiment.impl.ModifiableParameterImpl
	 * @see automaticexperiment.impl.AutomaticexperimentPackageImpl#getModifiableParameter()
	 * @generated
	 */
	int MODIFIABLE_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__INITIAL_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__STEP = 2;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__FEATURE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__LOWER_BOUND = 4;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__UPPER_BOUND = 5;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER__TARGET_URI = 6;

	/**
	 * The number of structural features of the '<em>Modifiable Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_PARAMETER_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link automaticexperiment.AutomaticExperiment <em>Automatic Experiment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Automatic Experiment</em>'.
	 * @see automaticexperiment.AutomaticExperiment
	 * @generated
	 */
	EClass getAutomaticExperiment();

	/**
	 * Returns the meta object for the reference '{@link automaticexperiment.AutomaticExperiment#getBaseScenario <em>Base Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Scenario</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getBaseScenario()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EReference getAutomaticExperiment_BaseScenario();

	/**
	 * Returns the meta object for the reference list '{@link automaticexperiment.AutomaticExperiment#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getParameters()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EReference getAutomaticExperiment_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.AutomaticExperiment#getErrorAnalysisAlgorithm <em>Error Analysis Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Analysis Algorithm</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getErrorAnalysisAlgorithm()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EAttribute getAutomaticExperiment_ErrorAnalysisAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.AutomaticExperiment#getErrorFunction <em>Error Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Function</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getErrorFunction()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EAttribute getAutomaticExperiment_ErrorFunction();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.AutomaticExperiment#getTolerance <em>Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tolerance</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getTolerance()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EAttribute getAutomaticExperiment_Tolerance();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.AutomaticExperiment#getReferanceDataDir <em>Referance Data Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referance Data Dir</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getReferanceDataDir()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EAttribute getAutomaticExperiment_ReferanceDataDir();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.AutomaticExperiment#getMaximumNumberOfIterations <em>Maximum Number Of Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Iterations</em>'.
	 * @see automaticexperiment.AutomaticExperiment#getMaximumNumberOfIterations()
	 * @see #getAutomaticExperiment()
	 * @generated
	 */
	EAttribute getAutomaticExperiment_MaximumNumberOfIterations();

	/**
	 * Returns the meta object for class '{@link automaticexperiment.ModifiableParameter <em>Modifiable Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifiable Parameter</em>'.
	 * @see automaticexperiment.ModifiableParameter
	 * @generated
	 */
	EClass getModifiableParameter();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.ModifiableParameter#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Value</em>'.
	 * @see automaticexperiment.ModifiableParameter#getInitialValue()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EAttribute getModifiableParameter_InitialValue();

	/**
	 * Returns the meta object for the reference '{@link automaticexperiment.ModifiableParameter#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see automaticexperiment.ModifiableParameter#getFeature()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EReference getModifiableParameter_Feature();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.ModifiableParameter#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step</em>'.
	 * @see automaticexperiment.ModifiableParameter#getStep()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EAttribute getModifiableParameter_Step();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.ModifiableParameter#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see automaticexperiment.ModifiableParameter#getFeatureName()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EAttribute getModifiableParameter_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.ModifiableParameter#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see automaticexperiment.ModifiableParameter#getLowerBound()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EAttribute getModifiableParameter_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.ModifiableParameter#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see automaticexperiment.ModifiableParameter#getUpperBound()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EAttribute getModifiableParameter_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link automaticexperiment.ModifiableParameter#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see automaticexperiment.ModifiableParameter#getTargetURI()
	 * @see #getModifiableParameter()
	 * @generated
	 */
	EAttribute getModifiableParameter_TargetURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AutomaticexperimentFactory getAutomaticexperimentFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link automaticexperiment.impl.AutomaticExperimentImpl <em>Automatic Experiment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see automaticexperiment.impl.AutomaticExperimentImpl
		 * @see automaticexperiment.impl.AutomaticexperimentPackageImpl#getAutomaticExperiment()
		 * @generated
		 */
		EClass AUTOMATIC_EXPERIMENT = eINSTANCE.getAutomaticExperiment();

		/**
		 * The meta object literal for the '<em><b>Base Scenario</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATIC_EXPERIMENT__BASE_SCENARIO = eINSTANCE.getAutomaticExperiment_BaseScenario();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTOMATIC_EXPERIMENT__PARAMETERS = eINSTANCE.getAutomaticExperiment_Parameters();

		/**
		 * The meta object literal for the '<em><b>Error Analysis Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATIC_EXPERIMENT__ERROR_ANALYSIS_ALGORITHM = eINSTANCE.getAutomaticExperiment_ErrorAnalysisAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Error Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATIC_EXPERIMENT__ERROR_FUNCTION = eINSTANCE.getAutomaticExperiment_ErrorFunction();

		/**
		 * The meta object literal for the '<em><b>Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATIC_EXPERIMENT__TOLERANCE = eINSTANCE.getAutomaticExperiment_Tolerance();

		/**
		 * The meta object literal for the '<em><b>Referance Data Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATIC_EXPERIMENT__REFERANCE_DATA_DIR = eINSTANCE.getAutomaticExperiment_ReferanceDataDir();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMATIC_EXPERIMENT__MAXIMUM_NUMBER_OF_ITERATIONS = eINSTANCE.getAutomaticExperiment_MaximumNumberOfIterations();

		/**
		 * The meta object literal for the '{@link automaticexperiment.impl.ModifiableParameterImpl <em>Modifiable Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see automaticexperiment.impl.ModifiableParameterImpl
		 * @see automaticexperiment.impl.AutomaticexperimentPackageImpl#getModifiableParameter()
		 * @generated
		 */
		EClass MODIFIABLE_PARAMETER = eINSTANCE.getModifiableParameter();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIABLE_PARAMETER__INITIAL_VALUE = eINSTANCE.getModifiableParameter_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIABLE_PARAMETER__FEATURE = eINSTANCE.getModifiableParameter_Feature();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIABLE_PARAMETER__STEP = eINSTANCE.getModifiableParameter_Step();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIABLE_PARAMETER__FEATURE_NAME = eINSTANCE.getModifiableParameter_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIABLE_PARAMETER__LOWER_BOUND = eINSTANCE.getModifiableParameter_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIABLE_PARAMETER__UPPER_BOUND = eINSTANCE.getModifiableParameter_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIABLE_PARAMETER__TARGET_URI = eINSTANCE.getModifiableParameter_TargetURI();

	}

} //AutomaticexperimentPackage

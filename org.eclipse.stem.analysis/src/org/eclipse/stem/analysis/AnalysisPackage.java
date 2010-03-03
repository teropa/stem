package org.eclipse.stem.analysis;

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
 * @see org.eclipse.stem.analysis.AnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface AnalysisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "analysis";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/analysis.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.analysis";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalysisPackage eINSTANCE = org.eclipse.stem.analysis.impl.AnalysisPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.analysis.impl.ErrorFunctionImpl <em>Error Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.analysis.impl.ErrorFunctionImpl
	 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getErrorFunction()
	 * @generated
	 */
	int ERROR_FUNCTION = 0;

	/**
	 * The number of structural features of the '<em>Error Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FUNCTION_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.analysis.impl.ThresholdErrorFunctionImpl <em>Threshold Error Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.analysis.impl.ThresholdErrorFunctionImpl
	 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getThresholdErrorFunction()
	 * @generated
	 */
	int THRESHOLD_ERROR_FUNCTION = 1;

	/**
	 * The number of structural features of the '<em>Threshold Error Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THRESHOLD_ERROR_FUNCTION_FEATURE_COUNT = ERROR_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl <em>Reference Scenario Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl
	 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getReferenceScenarioDataMap()
	 * @generated
	 */
	int REFERENCE_SCENARIO_DATA_MAP = 2;

	/**
	 * The number of structural features of the '<em>Reference Scenario Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SCENARIO_DATA_MAP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.analysis.impl.SimpleErrorFunctionImpl <em>Simple Error Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.analysis.impl.SimpleErrorFunctionImpl
	 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getSimpleErrorFunction()
	 * @generated
	 */
	int SIMPLE_ERROR_FUNCTION = 3;

	/**
	 * The number of structural features of the '<em>Simple Error Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ERROR_FUNCTION_FEATURE_COUNT = ERROR_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.analysis.impl.ErrorResultImpl <em>Error Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.analysis.impl.ErrorResultImpl
	 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getErrorResult()
	 * @generated
	 */
	int ERROR_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Error By Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESULT__ERROR_BY_TIME_STEP = 0;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESULT__ERROR = 1;

	/**
	 * The feature id for the '<em><b>Reference By Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESULT__REFERENCE_BY_TIME = 2;

	/**
	 * The feature id for the '<em><b>Model By Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESULT__MODEL_BY_TIME = 3;

	/**
	 * The number of structural features of the '<em>Error Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_RESULT_FEATURE_COUNT = 4;

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.analysis.ErrorFunction <em>Error Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Function</em>'.
	 * @see org.eclipse.stem.analysis.ErrorFunction
	 * @generated
	 */
	EClass getErrorFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.analysis.ThresholdErrorFunction <em>Threshold Error Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threshold Error Function</em>'.
	 * @see org.eclipse.stem.analysis.ThresholdErrorFunction
	 * @generated
	 */
	EClass getThresholdErrorFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.analysis.ReferenceScenarioDataMap <em>Reference Scenario Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Scenario Data Map</em>'.
	 * @see org.eclipse.stem.analysis.ReferenceScenarioDataMap
	 * @generated
	 */
	EClass getReferenceScenarioDataMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.analysis.SimpleErrorFunction <em>Simple Error Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Error Function</em>'.
	 * @see org.eclipse.stem.analysis.SimpleErrorFunction
	 * @generated
	 */
	EClass getSimpleErrorFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.analysis.ErrorResult <em>Error Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Result</em>'.
	 * @see org.eclipse.stem.analysis.ErrorResult
	 * @generated
	 */
	EClass getErrorResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.analysis.ErrorResult#getErrorByTimeStep <em>Error By Time Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error By Time Step</em>'.
	 * @see org.eclipse.stem.analysis.ErrorResult#getErrorByTimeStep()
	 * @see #getErrorResult()
	 * @generated
	 */
	EAttribute getErrorResult_ErrorByTimeStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.analysis.ErrorResult#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error</em>'.
	 * @see org.eclipse.stem.analysis.ErrorResult#getError()
	 * @see #getErrorResult()
	 * @generated
	 */
	EAttribute getErrorResult_Error();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.analysis.ErrorResult#getReferenceByTime <em>Reference By Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference By Time</em>'.
	 * @see org.eclipse.stem.analysis.ErrorResult#getReferenceByTime()
	 * @see #getErrorResult()
	 * @generated
	 */
	EAttribute getErrorResult_ReferenceByTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.analysis.ErrorResult#getModelByTime <em>Model By Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model By Time</em>'.
	 * @see org.eclipse.stem.analysis.ErrorResult#getModelByTime()
	 * @see #getErrorResult()
	 * @generated
	 */
	EAttribute getErrorResult_ModelByTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnalysisFactory getAnalysisFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.analysis.impl.ErrorFunctionImpl <em>Error Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.analysis.impl.ErrorFunctionImpl
		 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getErrorFunction()
		 * @generated
		 */
		EClass ERROR_FUNCTION = eINSTANCE.getErrorFunction();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.analysis.impl.ThresholdErrorFunctionImpl <em>Threshold Error Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.analysis.impl.ThresholdErrorFunctionImpl
		 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getThresholdErrorFunction()
		 * @generated
		 */
		EClass THRESHOLD_ERROR_FUNCTION = eINSTANCE.getThresholdErrorFunction();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl <em>Reference Scenario Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl
		 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getReferenceScenarioDataMap()
		 * @generated
		 */
		EClass REFERENCE_SCENARIO_DATA_MAP = eINSTANCE.getReferenceScenarioDataMap();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.analysis.impl.SimpleErrorFunctionImpl <em>Simple Error Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.analysis.impl.SimpleErrorFunctionImpl
		 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getSimpleErrorFunction()
		 * @generated
		 */
		EClass SIMPLE_ERROR_FUNCTION = eINSTANCE.getSimpleErrorFunction();
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.analysis.impl.ErrorResultImpl <em>Error Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.analysis.impl.ErrorResultImpl
		 * @see org.eclipse.stem.analysis.impl.AnalysisPackageImpl#getErrorResult()
		 * @generated
		 */
		EClass ERROR_RESULT = eINSTANCE.getErrorResult();
		/**
		 * The meta object literal for the '<em><b>Error By Time Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESULT__ERROR_BY_TIME_STEP = eINSTANCE.getErrorResult_ErrorByTimeStep();
		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESULT__ERROR = eINSTANCE.getErrorResult_Error();
		/**
		 * The meta object literal for the '<em><b>Reference By Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESULT__REFERENCE_BY_TIME = eINSTANCE.getErrorResult_ReferenceByTime();
		/**
		 * The meta object literal for the '<em><b>Model By Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_RESULT__MODEL_BY_TIME = eINSTANCE.getErrorResult_ModelByTime();

	}

} //AnalysisPackage

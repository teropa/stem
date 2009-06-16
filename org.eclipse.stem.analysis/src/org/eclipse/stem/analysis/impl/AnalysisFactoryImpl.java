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

package org.eclipse.stem.analysis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.analysis.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisFactoryImpl extends EFactoryImpl implements AnalysisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnalysisFactory init() {
		try {
			AnalysisFactory theAnalysisFactory = (AnalysisFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/analysis.ecore"); 
			if (theAnalysisFactory != null) {
				return theAnalysisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnalysisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnalysisPackage.ERROR_FUNCTION: return createErrorFunction();
			case AnalysisPackage.THRESHOLD_ERROR_FUNCTION: return createThresholdErrorFunction();
			case AnalysisPackage.REFERENCE_SCENARIO_DATA_MAP: return createReferenceScenarioDataMap();
			case AnalysisPackage.SIMPLE_ERROR_FUNCTION: return createSimpleErrorFunction();
			case AnalysisPackage.ERROR_RESULT: return createErrorResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorFunction createErrorFunction() {
		ErrorFunctionImpl errorFunction = new ErrorFunctionImpl();
		return errorFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThresholdErrorFunction createThresholdErrorFunction() {
		ThresholdErrorFunctionImpl thresholdErrorFunction = new ThresholdErrorFunctionImpl();
		return thresholdErrorFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceScenarioDataMap createReferenceScenarioDataMap() {
		ReferenceScenarioDataMapImpl referenceScenarioDataMap = new ReferenceScenarioDataMapImpl();
		return referenceScenarioDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleErrorFunction createSimpleErrorFunction() {
		SimpleErrorFunctionImpl simpleErrorFunction = new SimpleErrorFunctionImpl();
		return simpleErrorFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorResult createErrorResult() {
		ErrorResultImpl errorResult = new ErrorResultImpl();
		return errorResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisPackage getAnalysisPackage() {
		return (AnalysisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnalysisPackage getPackage() {
		return AnalysisPackage.eINSTANCE;
	}

} //AnalysisFactoryImpl

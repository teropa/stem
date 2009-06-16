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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.analysis.AnalysisFactory;
import org.eclipse.stem.analysis.AnalysisPackage;
import org.eclipse.stem.analysis.ErrorFunction;
import org.eclipse.stem.analysis.ErrorResult;
import org.eclipse.stem.analysis.ReferenceScenarioDataMap;
import org.eclipse.stem.analysis.SimpleErrorFunction;
import org.eclipse.stem.analysis.ThresholdErrorFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisPackageImpl extends EPackageImpl implements AnalysisPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thresholdErrorFunctionEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceScenarioDataMapEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleErrorFunctionEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorResultEClass = null;
	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.stem.analysis.AnalysisPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnalysisPackageImpl() {
		super(eNS_URI, AnalysisFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnalysisPackage init() {
		if (isInited) return (AnalysisPackage)EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);

		// Obtain or create and register package
		AnalysisPackageImpl theAnalysisPackage = (AnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AnalysisPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAnalysisPackage.createPackageContents();

		// Initialize created meta-data
		theAnalysisPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnalysisPackage.freeze();

		return theAnalysisPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorFunction() {
		return errorFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThresholdErrorFunction() {
		return thresholdErrorFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceScenarioDataMap() {
		return referenceScenarioDataMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleErrorFunction() {
		return simpleErrorFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorResult() {
		return errorResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorResult_ErrorByTimeStep() {
		return (EAttribute)errorResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorResult_Error() {
		return (EAttribute)errorResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisFactory getAnalysisFactory() {
		return (AnalysisFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		errorFunctionEClass = createEClass(ERROR_FUNCTION);

		thresholdErrorFunctionEClass = createEClass(THRESHOLD_ERROR_FUNCTION);

		referenceScenarioDataMapEClass = createEClass(REFERENCE_SCENARIO_DATA_MAP);

		simpleErrorFunctionEClass = createEClass(SIMPLE_ERROR_FUNCTION);

		errorResultEClass = createEClass(ERROR_RESULT);
		createEAttribute(errorResultEClass, ERROR_RESULT__ERROR_BY_TIME_STEP);
		createEAttribute(errorResultEClass, ERROR_RESULT__ERROR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		thresholdErrorFunctionEClass.getESuperTypes().add(this.getErrorFunction());
		simpleErrorFunctionEClass.getESuperTypes().add(this.getErrorFunction());

		// Initialize classes and features; add operations and parameters
		initEClass(errorFunctionEClass, ErrorFunction.class, "ErrorFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(errorFunctionEClass, this.getErrorResult(), "calculateError", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getReferenceScenarioDataMap(), "reference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getReferenceScenarioDataMap(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(thresholdErrorFunctionEClass, ThresholdErrorFunction.class, "ThresholdErrorFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceScenarioDataMapEClass, ReferenceScenarioDataMap.class, "ReferenceScenarioDataMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleErrorFunctionEClass, SimpleErrorFunction.class, "SimpleErrorFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorResultEClass, ErrorResult.class, "ErrorResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(ecorePackage.getEDoubleObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getErrorResult_ErrorByTimeStep(), g1, "errorByTimeStep", null, 0, 1, ErrorResult.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorResult_Error(), ecorePackage.getEDouble(), "error", null, 0, 1, ErrorResult.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AnalysisPackageImpl

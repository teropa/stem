package org.eclipse.stem.diseasemodels.experimental.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.diseasemodels.experimental.ExperimentalFactory;
import org.eclipse.stem.diseasemodels.experimental.ExperimentalPackage;
import org.eclipse.stem.diseasemodels.experimental.PercolationDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentalPackageImpl extends EPackageImpl implements ExperimentalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass percolationDiseaseModelEClass = null;
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
	 * @see org.eclipse.stem.diseasemodels.experimental.ExperimentalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExperimentalPackageImpl() {
		super(eNS_URI, ExperimentalFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExperimentalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExperimentalPackage init() {
		if (isInited) return (ExperimentalPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI);

		// Obtain or create and register package
		ExperimentalPackageImpl theExperimentalPackage = (ExperimentalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExperimentalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExperimentalPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExperimentalPackage.createPackageContents();

		// Initialize created meta-data
		theExperimentalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExperimentalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExperimentalPackage.eNS_URI, theExperimentalPackage);
		return theExperimentalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPercolationDiseaseModel() {
		return percolationDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentalFactory getExperimentalFactory() {
		return (ExperimentalFactory)getEFactoryInstance();
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
		percolationDiseaseModelEClass = createEClass(PERCOLATION_DISEASE_MODEL);
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

		// Obtain other dependent packages
		StandardPackage theStandardPackage = (StandardPackage)EPackage.Registry.INSTANCE.getEPackage(StandardPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		percolationDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getStochasticSEIRDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(percolationDiseaseModelEClass, PercolationDiseaseModel.class, "PercolationDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExperimentalPackageImpl

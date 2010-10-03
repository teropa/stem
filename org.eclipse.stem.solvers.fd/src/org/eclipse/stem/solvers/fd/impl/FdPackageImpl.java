package org.eclipse.stem.solvers.fd.impl;

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

import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.core.solver.SolverPackage;

import org.eclipse.stem.solvers.fd.FdFactory;
import org.eclipse.stem.solvers.fd.FdPackage;
import org.eclipse.stem.solvers.fd.FiniteDifference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FdPackageImpl extends EPackageImpl implements FdPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finiteDifferenceEClass = null;

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
	 * @see org.eclipse.stem.solvers.fd.FdPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FdPackageImpl() {
		super(eNS_URI, FdFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FdPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FdPackage init() {
		if (isInited) return (FdPackage)EPackage.Registry.INSTANCE.getEPackage(FdPackage.eNS_URI);

		// Obtain or create and register package
		FdPackageImpl theFdPackage = (FdPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FdPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FdPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		ModifierPackage.eINSTANCE.eClass();
		ScenarioPackage.eINSTANCE.eClass();
		SequencerPackage.eINSTANCE.eClass();
		SolverPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFdPackage.createPackageContents();

		// Initialize created meta-data
		theFdPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFdPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FdPackage.eNS_URI, theFdPackage);
		return theFdPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFiniteDifference() {
		return finiteDifferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FdFactory getFdFactory() {
		return (FdFactory)getEFactoryInstance();
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
		finiteDifferenceEClass = createEClass(FINITE_DIFFERENCE);
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
		SolverPackage theSolverPackage = (SolverPackage)EPackage.Registry.INSTANCE.getEPackage(SolverPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		finiteDifferenceEClass.getESuperTypes().add(theSolverPackage.getSolver());

		// Initialize classes and features; add operations and parameters
		initEClass(finiteDifferenceEClass, FiniteDifference.class, "FiniteDifference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //FdPackageImpl

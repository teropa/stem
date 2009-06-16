// ExternalDataSourcePackageImpl
package org.eclipse.stem.diseasemodels.externaldatasource.impl;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceFactory;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourcePackage;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalDataSourcePackageImpl extends EPackageImpl implements ExternalDataSourcePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalDataSourceDiseaseModelEClass = null;

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
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExternalDataSourcePackageImpl() {
		super(eNS_URI, ExternalDataSourceFactory.eINSTANCE);
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
	public static ExternalDataSourcePackage init() {
		if (isInited) return (ExternalDataSourcePackage)EPackage.Registry.INSTANCE.getEPackage(ExternalDataSourcePackage.eNS_URI);

		// Obtain or create and register package
		ExternalDataSourcePackageImpl theExternalDataSourcePackage = (ExternalDataSourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExternalDataSourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExternalDataSourcePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		GraphPackage.eINSTANCE.eClass();
		LabelsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExternalDataSourcePackage.createPackageContents();

		// Initialize created meta-data
		theExternalDataSourcePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExternalDataSourcePackage.freeze();

		return theExternalDataSourcePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalDataSourceDiseaseModel() {
		return externalDataSourceDiseaseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalDataSourceDiseaseModel_DataPath() {
		return (EAttribute)externalDataSourceDiseaseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalDataSourceDiseaseModel_DiseaseType() {
		return (EAttribute)externalDataSourceDiseaseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalDataSourceFactory getExternalDataSourceFactory() {
		return (ExternalDataSourceFactory)getEFactoryInstance();
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
		externalDataSourceDiseaseModelEClass = createEClass(EXTERNAL_DATA_SOURCE_DISEASE_MODEL);
		createEAttribute(externalDataSourceDiseaseModelEClass, EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH);
		createEAttribute(externalDataSourceDiseaseModelEClass, EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DISEASE_TYPE);
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
		externalDataSourceDiseaseModelEClass.getESuperTypes().add(theStandardPackage.getDiseaseModel());

		// Initialize classes and features; add operations and parameters
		initEClass(externalDataSourceDiseaseModelEClass, ExternalDataSourceDiseaseModel.class, "ExternalDataSourceDiseaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalDataSourceDiseaseModel_DataPath(), ecorePackage.getEString(), "dataPath", null, 0, 1, ExternalDataSourceDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExternalDataSourceDiseaseModel_DiseaseType(), ecorePackage.getEString(), "diseaseType", null, 0, 1, ExternalDataSourceDiseaseModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExternalDataSourcePackageImpl

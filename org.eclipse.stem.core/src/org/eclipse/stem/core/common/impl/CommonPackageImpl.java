package org.eclipse.stem.core.common.impl;
/******************************************************************************* 
 * Copyright (c) 2006, 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

import java.lang.Comparable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;

import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.experiment.impl.ExperimentPackageImpl;
import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.graph.impl.GraphPackageImpl;

import org.eclipse.stem.core.model.ModelPackage;

import org.eclipse.stem.core.model.impl.ModelPackageImpl;

import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.impl.ModifierPackageImpl;
import org.eclipse.stem.core.predicate.PredicatePackage;
import org.eclipse.stem.core.predicate.impl.PredicatePackageImpl;
import org.eclipse.stem.core.scenario.ScenarioPackage;

import org.eclipse.stem.core.scenario.impl.ScenarioPackageImpl;

import org.eclipse.stem.core.sequencer.SequencerPackage;

import org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl;
import org.eclipse.stem.core.trigger.TriggerPackage;
import org.eclipse.stem.core.trigger.impl.TriggerPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dublinCoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.eclipse.stem.core.common.CommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommonPackageImpl() {
		super(eNS_URI, CommonFactory.eINSTANCE);
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
	public static CommonPackage init() {
		if (isInited) return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Obtain or create and register package
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CommonPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI) : ExperimentPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		PredicatePackageImpl thePredicatePackage = (PredicatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) instanceof PredicatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PredicatePackage.eNS_URI) : PredicatePackage.eINSTANCE);
		ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI) : ScenarioPackage.eINSTANCE);
		SequencerPackageImpl theSequencerPackage = (SequencerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) instanceof SequencerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SequencerPackage.eNS_URI) : SequencerPackage.eINSTANCE);
		TriggerPackageImpl theTriggerPackage = (TriggerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) instanceof TriggerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TriggerPackage.eNS_URI) : TriggerPackage.eINSTANCE);

		// Create package meta-data objects
		theCommonPackage.createPackageContents();
		theExperimentPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		thePredicatePackage.createPackageContents();
		theScenarioPackage.createPackageContents();
		theSequencerPackage.createPackageContents();
		theTriggerPackage.createPackageContents();

		// Initialize created meta-data
		theCommonPackage.initializePackageContents();
		theExperimentPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		thePredicatePackage.initializePackageContents();
		theScenarioPackage.initializePackageContents();
		theSequencerPackage.initializePackageContents();
		theTriggerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonPackage.freeze();

		return theCommonPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDublinCore() {
		return dublinCoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Title() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Identifier() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Description() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Creator() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Date() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Format() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Publisher() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Coverage() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Contributor() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Relation() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Rights() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Source() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Subject() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Type() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Language() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_BibliographicCitation() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Created() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_License() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Required() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Spatial() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Valid() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_URI() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_TypeURI() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifiable_DublinCore() {
		return (EReference)identifiableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComparable() {
		return comparableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactory getCommonFactory() {
		return (CommonFactory)getEFactoryInstance();
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
		dublinCoreEClass = createEClass(DUBLIN_CORE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__TITLE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__IDENTIFIER);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__DESCRIPTION);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CREATOR);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__DATE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__FORMAT);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__PUBLISHER);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__COVERAGE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CONTRIBUTOR);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__RELATION);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__RIGHTS);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__SOURCE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__SUBJECT);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__TYPE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__LANGUAGE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__BIBLIOGRAPHIC_CITATION);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CREATED);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__LICENSE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__REQUIRED);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__SPATIAL);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__VALID);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__URI);
		createEAttribute(identifiableEClass, IDENTIFIABLE__TYPE_URI);
		createEReference(identifiableEClass, IDENTIFIABLE__DUBLIN_CORE);

		comparableEClass = createEClass(COMPARABLE);

		// Create data types
		uriEDataType = createEDataType(URI);
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
		addETypeParameter(comparableEClass, "T"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getComparable());
		EGenericType g2 = createEGenericType(this.getIdentifiable());
		g1.getETypeArguments().add(g2);
		identifiableEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(dublinCoreEClass, DublinCore.class, "DublinCore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDublinCore_Title(), ecorePackage.getEString(), "title", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Description(), ecorePackage.getEString(), "description", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Creator(), ecorePackage.getEString(), "creator", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Date(), ecorePackage.getEString(), "date", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Format(), ecorePackage.getEString(), "format", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Publisher(), ecorePackage.getEString(), "publisher", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Coverage(), ecorePackage.getEString(), "coverage", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Contributor(), ecorePackage.getEString(), "contributor", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Relation(), ecorePackage.getEString(), "relation", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Rights(), ecorePackage.getEString(), "rights", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Source(), ecorePackage.getEString(), "source", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Subject(), ecorePackage.getEString(), "subject", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Type(), ecorePackage.getEString(), "type", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Language(), ecorePackage.getEString(), "language", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_BibliographicCitation(), ecorePackage.getEString(), "bibliographicCitation", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Created(), ecorePackage.getEString(), "created", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_License(), ecorePackage.getEString(), "license", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Required(), ecorePackage.getEString(), "required", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Spatial(), ecorePackage.getEString(), "spatial", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDublinCore_Valid(), ecorePackage.getEString(), "valid", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(dublinCoreEClass, this.getDublinCore(), "populate", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIdentifiable_URI(), this.getURI(), "uRI", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIdentifiable_TypeURI(), this.getURI(), "typeURI", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIdentifiable_DublinCore(), this.getDublinCore(), null, "dublinCore", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(identifiableEClass, ecorePackage.getEBoolean(), "sane", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(comparableEClass, Comparable.class, "Comparable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //CommonPackageImpl

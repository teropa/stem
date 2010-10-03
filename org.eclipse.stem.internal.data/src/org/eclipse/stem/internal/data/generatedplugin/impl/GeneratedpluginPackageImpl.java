package org.eclipse.stem.internal.data.generatedplugin.impl;

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

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.generatedplugin.StemCategory;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
@SuppressWarnings("all")
public class GeneratedpluginPackageImpl extends EPackageImpl implements
		GeneratedpluginPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dublinCoreEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stemCategoryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeneratedpluginPackageImpl() {
		super(eNS_URI, GeneratedpluginFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GeneratedpluginPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeneratedpluginPackage init() {
		if (isInited) return (GeneratedpluginPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratedpluginPackage.eNS_URI);

		// Obtain or create and register package
		GeneratedpluginPackageImpl theGeneratedpluginPackage = (GeneratedpluginPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GeneratedpluginPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GeneratedpluginPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGeneratedpluginPackage.createPackageContents();

		// Initialize created meta-data
		theGeneratedpluginPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeneratedpluginPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeneratedpluginPackage.eNS_URI, theGeneratedpluginPackage);
		return theGeneratedpluginPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDublinCore() {
		return dublinCoreEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_BibliographicCitation() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_CategoryId() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Contributor() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Coverage() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Created() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Creator() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Date() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Description() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Format() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Identifier() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Language() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_License() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Publisher() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Relation() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Requires() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Rights() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Source() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Spatial() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Subject() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Title() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Type() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDublinCore_Valid() {
		return (EAttribute)dublinCoreEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtension() {
		return extensionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_Categories() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_DublinCores() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtension_Point() {
		return (EAttribute)extensionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlugin() {
		return pluginEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlugin_Extensionelement() {
		return (EReference)pluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStemCategory() {
		return stemCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStemCategory_Id() {
		return (EAttribute)stemCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStemCategory_Name() {
		return (EAttribute)stemCategoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStemCategory_ParentId() {
		return (EAttribute)stemCategoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedpluginFactory getGeneratedpluginFactory() {
		return (GeneratedpluginFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__BIBLIOGRAPHIC_CITATION);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CATEGORY_ID);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CONTRIBUTOR);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__COVERAGE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CREATED);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__CREATOR);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__DATE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__DESCRIPTION);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__FORMAT);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__IDENTIFIER);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__LANGUAGE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__LICENSE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__PUBLISHER);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__RELATION);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__REQUIRES);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__RIGHTS);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__SOURCE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__SPATIAL);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__SUBJECT);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__TITLE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__TYPE);
		createEAttribute(dublinCoreEClass, DUBLIN_CORE__VALID);

		extensionEClass = createEClass(EXTENSION);
		createEReference(extensionEClass, EXTENSION__CATEGORIES);
		createEReference(extensionEClass, EXTENSION__DUBLIN_CORES);
		createEAttribute(extensionEClass, EXTENSION__POINT);

		pluginEClass = createEClass(PLUGIN);
		createEReference(pluginEClass, PLUGIN__EXTENSIONELEMENT);

		stemCategoryEClass = createEClass(STEM_CATEGORY);
		createEAttribute(stemCategoryEClass, STEM_CATEGORY__ID);
		createEAttribute(stemCategoryEClass, STEM_CATEGORY__NAME);
		createEAttribute(stemCategoryEClass, STEM_CATEGORY__PARENT_ID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(dublinCoreEClass, DublinCore.class, "DublinCore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDublinCore_BibliographicCitation(), theXMLTypePackage.getString(), "bibliographicCitation", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_CategoryId(), theXMLTypePackage.getString(), "categoryId", null, 1, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Contributor(), theXMLTypePackage.getString(), "contributor", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Coverage(), theXMLTypePackage.getString(), "coverage", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Created(), theXMLTypePackage.getString(), "created", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Creator(), theXMLTypePackage.getString(), "creator", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Date(), theXMLTypePackage.getString(), "date", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Format(), theXMLTypePackage.getString(), "format", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Identifier(), theXMLTypePackage.getString(), "identifier", null, 1, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Language(), theXMLTypePackage.getString(), "language", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_License(), theXMLTypePackage.getString(), "license", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Publisher(), theXMLTypePackage.getString(), "publisher", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Relation(), theXMLTypePackage.getString(), "relation", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Rights(), theXMLTypePackage.getString(), "rights", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Source(), theXMLTypePackage.getString(), "source", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Spatial(), theXMLTypePackage.getString(), "spatial", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Subject(), theXMLTypePackage.getString(), "subject", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Title(), theXMLTypePackage.getString(), "title", null, 1, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDublinCore_Valid(), theXMLTypePackage.getString(), "valid", null, 0, 1, DublinCore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionEClass, Extension.class, "Extension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtension_Categories(), this.getStemCategory(), null, "categories", null, 1, -1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtension_DublinCores(), this.getDublinCore(), null, "dublinCores", null, 0, -1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtension_Point(), theXMLTypePackage.getString(), "point", null, 1, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginEClass, Plugin.class, "Plugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlugin_Extensionelement(), this.getExtension(), null, "extensionelement", null, 0, -1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stemCategoryEClass, StemCategory.class, "StemCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStemCategory_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, StemCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStemCategory_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, StemCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStemCategory_ParentId(), theXMLTypePackage.getString(), "parentId", null, 1, 1, StemCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for
	 * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (dublinCoreEClass, 
		   source, 
		   new String[] {
			 "name", "dublin_core",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getDublinCore_BibliographicCitation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "bibliographicCitation"
		   });		
		addAnnotation
		  (getDublinCore_CategoryId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "category_id"
		   });		
		addAnnotation
		  (getDublinCore_Contributor(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "contributor"
		   });		
		addAnnotation
		  (getDublinCore_Coverage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "coverage"
		   });		
		addAnnotation
		  (getDublinCore_Created(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "created"
		   });		
		addAnnotation
		  (getDublinCore_Creator(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "creator"
		   });		
		addAnnotation
		  (getDublinCore_Date(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "date"
		   });		
		addAnnotation
		  (getDublinCore_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description"
		   });		
		addAnnotation
		  (getDublinCore_Format(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "format"
		   });		
		addAnnotation
		  (getDublinCore_Identifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "identifier"
		   });		
		addAnnotation
		  (getDublinCore_Language(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "language"
		   });		
		addAnnotation
		  (getDublinCore_License(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "license"
		   });		
		addAnnotation
		  (getDublinCore_Publisher(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "publisher"
		   });		
		addAnnotation
		  (getDublinCore_Relation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "relation"
		   });		
		addAnnotation
		  (getDublinCore_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "requires"
		   });		
		addAnnotation
		  (getDublinCore_Rights(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rights"
		   });		
		addAnnotation
		  (getDublinCore_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "source"
		   });		
		addAnnotation
		  (getDublinCore_Spatial(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "spatial"
		   });		
		addAnnotation
		  (getDublinCore_Subject(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "subject"
		   });		
		addAnnotation
		  (getDublinCore_Title(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "title"
		   });		
		addAnnotation
		  (getDublinCore_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (getDublinCore_Valid(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "valid"
		   });		
		addAnnotation
		  (extensionEClass, 
		   source, 
		   new String[] {
			 "name", "extension",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExtension_Categories(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "categories",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtension_DublinCores(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dublinCores",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtension_Point(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "point"
		   });		
		addAnnotation
		  (pluginEClass, 
		   source, 
		   new String[] {
			 "name", "plugin",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPlugin_Extensionelement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extensionelement",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (stemCategoryEClass, 
		   source, 
		   new String[] {
			 "name", "stem_category",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getStemCategory_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getStemCategory_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getStemCategory_ParentId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parent_id"
		   });
	}

} // GeneratedpluginPackageImpl

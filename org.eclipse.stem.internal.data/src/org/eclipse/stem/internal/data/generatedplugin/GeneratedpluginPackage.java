package org.eclipse.stem.internal.data.generatedplugin;

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

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory
 * @model kind="package"
 * @generated
 */
public interface GeneratedpluginPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "generatedplugin";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://data.internal.stem.eclipse.org/generatedplugin";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "generatedplugin";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	GeneratedpluginPackage eINSTANCE = org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl
	 * <em>Dublin Core</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getDublinCore()
	 * @generated
	 */
	int DUBLIN_CORE = 0;

	/**
	 * The feature id for the '<em><b>Bibliographic Citation</b></em>'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__BIBLIOGRAPHIC_CITATION = 0;

	/**
	 * The feature id for the '<em><b>Category Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CATEGORY_ID = 1;

	/**
	 * The feature id for the '<em><b>Contributor</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CONTRIBUTOR = 2;

	/**
	 * The feature id for the '<em><b>Coverage</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__COVERAGE = 3;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CREATED = 4;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CREATOR = 5;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__DATE = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__DESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__FORMAT = 8;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__IDENTIFIER = 9;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__LANGUAGE = 10;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__LICENSE = 11;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__PUBLISHER = 12;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__RELATION = 13;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__REQUIRES = 14;

	/**
	 * The feature id for the '<em><b>Rights</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__RIGHTS = 15;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__SOURCE = 16;

	/**
	 * The feature id for the '<em><b>Spatial</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__SPATIAL = 17;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__SUBJECT = 18;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__TITLE = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__TYPE = 20;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__VALID = 21;

	/**
	 * The number of structural features of the '<em>Dublin Core</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE_FEATURE_COUNT = 22;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl
	 * <em>Extension</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENSION__CATEGORIES = 0;

	/**
	 * The feature id for the '<em><b>Dublin Cores</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENSION__DUBLIN_CORES = 1;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENSION__POINT = 2;

	/**
	 * The number of structural features of the '<em>Extension</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.PluginImpl
	 * <em>Plugin</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.PluginImpl
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getPlugin()
	 * @generated
	 */
	int PLUGIN = 2;

	/**
	 * The feature id for the '<em><b>Extensionelement</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN__EXTENSIONELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl
	 * <em>Stem Category</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl
	 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getStemCategory()
	 * @generated
	 */
	int STEM_CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEM_CATEGORY__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEM_CATEGORY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Parent Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEM_CATEGORY__PARENT_ID = 2;

	/**
	 * The number of structural features of the '<em>Stem Category</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEM_CATEGORY_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore
	 * <em>Dublin Core</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Dublin Core</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore
	 * @generated
	 */
	EClass getDublinCore();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getBibliographicCitation
	 * <em>Bibliographic Citation</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the attribute '
	 *         <em>Bibliographic Citation</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getBibliographicCitation()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_BibliographicCitation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCategoryId
	 * <em>Category Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Category Id</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCategoryId()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_CategoryId();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getContributor
	 * <em>Contributor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Contributor</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getContributor()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Contributor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCoverage
	 * <em>Coverage</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Coverage</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCoverage()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Coverage();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreated
	 * <em>Created</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreated()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Created();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreator
	 * <em>Creator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Creator</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreator()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Creator();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDate
	 * <em>Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDate()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Date();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDescription()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Description();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getFormat
	 * <em>Format</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getFormat()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Format();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getIdentifier
	 * <em>Identifier</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getIdentifier()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Identifier();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLanguage
	 * <em>Language</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLanguage()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Language();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLicense
	 * <em>License</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLicense()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_License();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getPublisher
	 * <em>Publisher</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Publisher</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getPublisher()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Publisher();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRelation
	 * <em>Relation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRelation()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Relation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRequires
	 * <em>Requires</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRequires()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Requires();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRights
	 * <em>Rights</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Rights</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRights()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Rights();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSource
	 * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSource()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Source();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSpatial
	 * <em>Spatial</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Spatial</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSpatial()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Spatial();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSubject
	 * <em>Subject</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Subject</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSubject()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Subject();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getTitle
	 * <em>Title</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getTitle()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Title();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getType()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Type();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getValid
	 * <em>Valid</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.DublinCore#getValid()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Valid();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension
	 * <em>Extension</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.Extension
	 * @generated
	 */
	EClass getExtension();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getCategories
	 * <em>Categories</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Categories</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.Extension#getCategories()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_Categories();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getDublinCores
	 * <em>Dublin Cores</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Dublin Cores</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.Extension#getDublinCores()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_DublinCores();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Extension#getPoint
	 * <em>Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.Extension#getPoint()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Point();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Plugin
	 * <em>Plugin</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.Plugin
	 * @generated
	 */
	EClass getPlugin();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.Plugin#getExtensionelement
	 * <em>Extensionelement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Extensionelement</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.Plugin#getExtensionelement()
	 * @see #getPlugin()
	 * @generated
	 */
	EReference getPlugin_Extensionelement();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory
	 * <em>Stem Category</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Stem Category</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.StemCategory
	 * @generated
	 */
	EClass getStemCategory();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.StemCategory#getId()
	 * @see #getStemCategory()
	 * @generated
	 */
	EAttribute getStemCategory_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.StemCategory#getName()
	 * @see #getStemCategory()
	 * @generated
	 */
	EAttribute getStemCategory_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.StemCategory#getParentId
	 * <em>Parent Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Parent Id</em>'.
	 * @see org.eclipse.stem.internal.data.generatedplugin.StemCategory#getParentId()
	 * @see #getStemCategory()
	 * @generated
	 */
	EAttribute getStemCategory_ParentId();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratedpluginFactory getGeneratedpluginFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl
		 * <em>Dublin Core</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getDublinCore()
		 * @generated
		 */
		EClass DUBLIN_CORE = eINSTANCE.getDublinCore();

		/**
		 * The meta object literal for the '
		 * <em><b>Bibliographic Citation</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__BIBLIOGRAPHIC_CITATION = eINSTANCE
				.getDublinCore_BibliographicCitation();

		/**
		 * The meta object literal for the '<em><b>Category Id</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CATEGORY_ID = eINSTANCE
				.getDublinCore_CategoryId();

		/**
		 * The meta object literal for the '<em><b>Contributor</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CONTRIBUTOR = eINSTANCE
				.getDublinCore_Contributor();

		/**
		 * The meta object literal for the '<em><b>Coverage</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__COVERAGE = eINSTANCE.getDublinCore_Coverage();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CREATED = eINSTANCE.getDublinCore_Created();

		/**
		 * The meta object literal for the '<em><b>Creator</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CREATOR = eINSTANCE.getDublinCore_Creator();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__DATE = eINSTANCE.getDublinCore_Date();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__DESCRIPTION = eINSTANCE
				.getDublinCore_Description();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__FORMAT = eINSTANCE.getDublinCore_Format();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__IDENTIFIER = eINSTANCE
				.getDublinCore_Identifier();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__LANGUAGE = eINSTANCE.getDublinCore_Language();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__LICENSE = eINSTANCE.getDublinCore_License();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__PUBLISHER = eINSTANCE.getDublinCore_Publisher();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__RELATION = eINSTANCE.getDublinCore_Relation();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__REQUIRES = eINSTANCE.getDublinCore_Requires();

		/**
		 * The meta object literal for the '<em><b>Rights</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__RIGHTS = eINSTANCE.getDublinCore_Rights();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__SOURCE = eINSTANCE.getDublinCore_Source();

		/**
		 * The meta object literal for the '<em><b>Spatial</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__SPATIAL = eINSTANCE.getDublinCore_Spatial();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__SUBJECT = eINSTANCE.getDublinCore_Subject();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__TITLE = eINSTANCE.getDublinCore_Title();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__TYPE = eINSTANCE.getDublinCore_Type();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DUBLIN_CORE__VALID = eINSTANCE.getDublinCore_Valid();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl
		 * <em>Extension</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.ExtensionImpl
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getExtension()
		 * @generated
		 */
		EClass EXTENSION = eINSTANCE.getExtension();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTENSION__CATEGORIES = eINSTANCE.getExtension_Categories();

		/**
		 * The meta object literal for the '<em><b>Dublin Cores</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTENSION__DUBLIN_CORES = eINSTANCE
				.getExtension_DublinCores();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENSION__POINT = eINSTANCE.getExtension_Point();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.PluginImpl
		 * <em>Plugin</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.PluginImpl
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getPlugin()
		 * @generated
		 */
		EClass PLUGIN = eINSTANCE.getPlugin();

		/**
		 * The meta object literal for the '<em><b>Extensionelement</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PLUGIN__EXTENSIONELEMENT = eINSTANCE
				.getPlugin_Extensionelement();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl
		 * <em>Stem Category</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.StemCategoryImpl
		 * @see org.eclipse.stem.internal.data.generatedplugin.impl.GeneratedpluginPackageImpl#getStemCategory()
		 * @generated
		 */
		EClass STEM_CATEGORY = eINSTANCE.getStemCategory();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEM_CATEGORY__ID = eINSTANCE.getStemCategory_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEM_CATEGORY__NAME = eINSTANCE.getStemCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Parent Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEM_CATEGORY__PARENT_ID = eINSTANCE
				.getStemCategory_ParentId();

	}

} // GeneratedpluginPackage

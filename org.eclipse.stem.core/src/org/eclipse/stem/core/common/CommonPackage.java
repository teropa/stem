package org.eclipse.stem.core.common;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.stem.core.modifier.ModifierPackage;

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
 * @see org.eclipse.stem.core.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/common.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.common";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = org.eclipse.stem.core.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.DublinCoreImpl <em>Dublin Core</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.DublinCoreImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDublinCore()
	 * @generated
	 */
	int DUBLIN_CORE = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CREATOR = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__DATE = 4;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__FORMAT = 5;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__PUBLISHER = 6;

	/**
	 * The feature id for the '<em><b>Coverage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__COVERAGE = 7;

	/**
	 * The feature id for the '<em><b>Contributor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CONTRIBUTOR = 8;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__RELATION = 9;

	/**
	 * The feature id for the '<em><b>Rights</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__RIGHTS = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__SOURCE = 11;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__SUBJECT = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__TYPE = 13;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__LANGUAGE = 14;

	/**
	 * The feature id for the '<em><b>Bibliographic Citation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__BIBLIOGRAPHIC_CITATION = 15;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__CREATED = 16;

	/**
	 * The feature id for the '<em><b>License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__LICENSE = 17;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__REQUIRED = 18;

	/**
	 * The feature id for the '<em><b>Spatial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__SPATIAL = 19;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE__VALID = 20;

	/**
	 * The number of structural features of the '<em>Dublin Core</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUBLIN_CORE_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Comparable
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getComparable()
	 * @generated
	 */
	int COMPARABLE = 2;

	/**
	 * The number of structural features of the '<em>Comparable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.IdentifiableImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__URI = COMPARABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__TYPE_URI = COMPARABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__DUBLIN_CORE = COMPARABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = COMPARABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.IdentifiableFilterImpl <em>Identifiable Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.IdentifiableFilterImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getIdentifiableFilter()
	 * @generated
	 */
	int IDENTIFIABLE_FILTER = 3;

	/**
	 * The number of structural features of the '<em>Identifiable Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FILTER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.DoubleValueListImpl <em>Double Value List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.DoubleValueListImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDoubleValueList()
	 * @generated
	 */
	int DOUBLE_VALUE_LIST = 4;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE_LIST__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE_LIST__IDENTIFIER = 1;

	/**
	 * The number of structural features of the '<em>Double Value List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE_LIST_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.DoubleValueMatrixImpl <em>Double Value Matrix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.DoubleValueMatrixImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDoubleValueMatrix()
	 * @generated
	 */
	int DOUBLE_VALUE_MATRIX = 5;

	/**
	 * The feature id for the '<em><b>Value Lists</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE_MATRIX__VALUE_LISTS = 0;

	/**
	 * The number of structural features of the '<em>Double Value Matrix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE_MATRIX_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.DoubleValueImpl <em>Double Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.DoubleValueImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDoubleValue()
	 * @generated
	 */
	int DOUBLE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE__IDENTIFIER = ModifierPackage.MODIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE__VALUE = ModifierPackage.MODIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_VALUE_FEATURE_COUNT = ModifierPackage.MODIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.StringValueListImpl <em>String Value List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.StringValueListImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getStringValueList()
	 * @generated
	 */
	int STRING_VALUE_LIST = 7;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_LIST__VALUES = 0;

	/**
	 * The number of structural features of the '<em>String Value List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.common.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.common.impl.StringValueImpl
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = ModifierPackage.MODIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = ModifierPackage.MODIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getURI()
	 * @generated
	 */
	int URI = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.DublinCore <em>Dublin Core</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dublin Core</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore
	 * @generated
	 */
	EClass getDublinCore();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getTitle()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getIdentifier()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getDescription()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getCreator <em>Creator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creator</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getCreator()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Creator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getDate()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getFormat()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publisher</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getPublisher()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Publisher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getCoverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coverage</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getCoverage()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Coverage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getContributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contributor</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getContributor()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Contributor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getRelation()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Relation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getRights <em>Rights</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rights</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getRights()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Rights();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getSource()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subject</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getSubject()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Subject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getType()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getLanguage()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Language();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getBibliographicCitation <em>Bibliographic Citation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bibliographic Citation</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getBibliographicCitation()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_BibliographicCitation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getCreated()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Created();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getLicense <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>License</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getLicense()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_License();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getRequired()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Required();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getSpatial <em>Spatial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spatial</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getSpatial()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Spatial();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DublinCore#getValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see org.eclipse.stem.core.common.DublinCore#getValid()
	 * @see #getDublinCore()
	 * @generated
	 */
	EAttribute getDublinCore_Valid();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see org.eclipse.stem.core.common.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.Identifiable#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.eclipse.stem.core.common.Identifiable#getURI()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_URI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.Identifiable#getTypeURI <em>Type URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type URI</em>'.
	 * @see org.eclipse.stem.core.common.Identifiable#getTypeURI()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_TypeURI();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.common.Identifiable#getDublinCore <em>Dublin Core</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dublin Core</em>'.
	 * @see org.eclipse.stem.core.common.Identifiable#getDublinCore()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EReference getIdentifiable_DublinCore();

	/**
	 * Returns the meta object for class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparable</em>'.
	 * @see java.lang.Comparable
	 * @model instanceClass="java.lang.Comparable" typeParameters="T"
	 * @generated
	 */
	EClass getComparable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.IdentifiableFilter <em>Identifiable Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Filter</em>'.
	 * @see org.eclipse.stem.core.common.IdentifiableFilter
	 * @generated
	 */
	EClass getIdentifiableFilter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.DoubleValueList <em>Double Value List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Value List</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValueList
	 * @generated
	 */
	EClass getDoubleValueList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.common.DoubleValueList#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValueList#getValues()
	 * @see #getDoubleValueList()
	 * @generated
	 */
	EReference getDoubleValueList_Values();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DoubleValueList#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValueList#getIdentifier()
	 * @see #getDoubleValueList()
	 * @generated
	 */
	EAttribute getDoubleValueList_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.DoubleValueMatrix <em>Double Value Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Value Matrix</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValueMatrix
	 * @generated
	 */
	EClass getDoubleValueMatrix();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.common.DoubleValueMatrix#getValueLists <em>Value Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Lists</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValueMatrix#getValueLists()
	 * @see #getDoubleValueMatrix()
	 * @generated
	 */
	EReference getDoubleValueMatrix_ValueLists();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.DoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Value</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValue
	 * @generated
	 */
	EClass getDoubleValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DoubleValue#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValue#getIdentifier()
	 * @see #getDoubleValue()
	 * @generated
	 */
	EAttribute getDoubleValue_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.DoubleValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.stem.core.common.DoubleValue#getValue()
	 * @see #getDoubleValue()
	 * @generated
	 */
	EAttribute getDoubleValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.StringValueList <em>String Value List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value List</em>'.
	 * @see org.eclipse.stem.core.common.StringValueList
	 * @generated
	 */
	EClass getStringValueList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.common.StringValueList#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.stem.core.common.StringValueList#getValues()
	 * @see #getStringValueList()
	 * @generated
	 */
	EReference getStringValueList_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.common.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.eclipse.stem.core.common.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.common.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.stem.core.common.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.DublinCoreImpl <em>Dublin Core</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.DublinCoreImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDublinCore()
		 * @generated
		 */
		EClass DUBLIN_CORE = eINSTANCE.getDublinCore();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__TITLE = eINSTANCE.getDublinCore_Title();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__IDENTIFIER = eINSTANCE.getDublinCore_Identifier();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__DESCRIPTION = eINSTANCE.getDublinCore_Description();

		/**
		 * The meta object literal for the '<em><b>Creator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CREATOR = eINSTANCE.getDublinCore_Creator();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__DATE = eINSTANCE.getDublinCore_Date();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__FORMAT = eINSTANCE.getDublinCore_Format();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__PUBLISHER = eINSTANCE.getDublinCore_Publisher();

		/**
		 * The meta object literal for the '<em><b>Coverage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__COVERAGE = eINSTANCE.getDublinCore_Coverage();

		/**
		 * The meta object literal for the '<em><b>Contributor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CONTRIBUTOR = eINSTANCE.getDublinCore_Contributor();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__RELATION = eINSTANCE.getDublinCore_Relation();

		/**
		 * The meta object literal for the '<em><b>Rights</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__RIGHTS = eINSTANCE.getDublinCore_Rights();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__SOURCE = eINSTANCE.getDublinCore_Source();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__SUBJECT = eINSTANCE.getDublinCore_Subject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__TYPE = eINSTANCE.getDublinCore_Type();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__LANGUAGE = eINSTANCE.getDublinCore_Language();

		/**
		 * The meta object literal for the '<em><b>Bibliographic Citation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__BIBLIOGRAPHIC_CITATION = eINSTANCE.getDublinCore_BibliographicCitation();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__CREATED = eINSTANCE.getDublinCore_Created();

		/**
		 * The meta object literal for the '<em><b>License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__LICENSE = eINSTANCE.getDublinCore_License();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__REQUIRED = eINSTANCE.getDublinCore_Required();

		/**
		 * The meta object literal for the '<em><b>Spatial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__SPATIAL = eINSTANCE.getDublinCore_Spatial();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DUBLIN_CORE__VALID = eINSTANCE.getDublinCore_Valid();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.IdentifiableImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__URI = eINSTANCE.getIdentifiable_URI();

		/**
		 * The meta object literal for the '<em><b>Type URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__TYPE_URI = eINSTANCE.getIdentifiable_TypeURI();

		/**
		 * The meta object literal for the '<em><b>Dublin Core</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIABLE__DUBLIN_CORE = eINSTANCE.getIdentifiable_DublinCore();

		/**
		 * The meta object literal for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Comparable
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getComparable()
		 * @generated
		 */
		EClass COMPARABLE = eINSTANCE.getComparable();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.IdentifiableFilterImpl <em>Identifiable Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.IdentifiableFilterImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getIdentifiableFilter()
		 * @generated
		 */
		EClass IDENTIFIABLE_FILTER = eINSTANCE.getIdentifiableFilter();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.DoubleValueListImpl <em>Double Value List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.DoubleValueListImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDoubleValueList()
		 * @generated
		 */
		EClass DOUBLE_VALUE_LIST = eINSTANCE.getDoubleValueList();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLE_VALUE_LIST__VALUES = eINSTANCE.getDoubleValueList_Values();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_VALUE_LIST__IDENTIFIER = eINSTANCE.getDoubleValueList_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.DoubleValueMatrixImpl <em>Double Value Matrix</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.DoubleValueMatrixImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDoubleValueMatrix()
		 * @generated
		 */
		EClass DOUBLE_VALUE_MATRIX = eINSTANCE.getDoubleValueMatrix();

		/**
		 * The meta object literal for the '<em><b>Value Lists</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLE_VALUE_MATRIX__VALUE_LISTS = eINSTANCE.getDoubleValueMatrix_ValueLists();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.DoubleValueImpl <em>Double Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.DoubleValueImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getDoubleValue()
		 * @generated
		 */
		EClass DOUBLE_VALUE = eINSTANCE.getDoubleValue();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_VALUE__IDENTIFIER = eINSTANCE.getDoubleValue_Identifier();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_VALUE__VALUE = eINSTANCE.getDoubleValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.StringValueListImpl <em>String Value List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.StringValueListImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getStringValueList()
		 * @generated
		 */
		EClass STRING_VALUE_LIST = eINSTANCE.getStringValueList();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_VALUE_LIST__VALUES = eINSTANCE.getStringValueList_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.common.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.common.impl.StringValueImpl
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.stem.core.common.impl.CommonPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //CommonPackage

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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Dublin Core</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getBibliographicCitation <em>Bibliographic Citation</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCategoryId <em>Category Id</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCoverage <em>Coverage</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreated <em>Created</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreator <em>Creator</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRights <em>Rights</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSpatial <em>Spatial</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getValid <em>Valid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore()
 * @model extendedMetaData="name='dublin_core' kind='empty'"
 * @extends CDOObject
 * @generated
 */
public interface DublinCore extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Bibliographic Citation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bibliographic Citation</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bibliographic Citation</em>' attribute.
	 * @see #setBibliographicCitation(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_BibliographicCitation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='bibliographicCitation'"
	 * @generated
	 */
	String getBibliographicCitation();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getBibliographicCitation <em>Bibliographic Citation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Bibliographic Citation</em>' attribute.
	 * @see #getBibliographicCitation()
	 * @generated
	 */
	void setBibliographicCitation(String value);

	/**
	 * Returns the value of the '<em><b>Category Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Id</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Category Id</em>' attribute.
	 * @see #setCategoryId(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_CategoryId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='category_id'"
	 * @generated
	 */
	String getCategoryId();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCategoryId <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Category Id</em>' attribute.
	 * @see #getCategoryId()
	 * @generated
	 */
	void setCategoryId(String value);

	/**
	 * Returns the value of the '<em><b>Contributor</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributor</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contributor</em>' attribute.
	 * @see #setContributor(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Contributor()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='contributor'"
	 * @generated
	 */
	String getContributor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getContributor <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' attribute.
	 * @see #getContributor()
	 * @generated
	 */
	void setContributor(String value);

	/**
	 * Returns the value of the '<em><b>Coverage</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coverage</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Coverage</em>' attribute.
	 * @see #setCoverage(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Coverage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='coverage'"
	 * @generated
	 */
	String getCoverage();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCoverage
	 * <em>Coverage</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Coverage</em>' attribute.
	 * @see #getCoverage()
	 * @generated
	 */
	void setCoverage(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Created()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='created'"
	 * @generated
	 */
	String getCreated();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreated
	 * <em>Created</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(String value);

	/**
	 * Returns the value of the '<em><b>Creator</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creator</em>' attribute.
	 * @see #setCreator(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Creator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='creator'"
	 * @generated
	 */
	String getCreator();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getCreator
	 * <em>Creator</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Creator</em>' attribute.
	 * @see #getCreator()
	 * @generated
	 */
	void setCreator(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Date()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='date'"
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Format()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='format'"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getFormat
	 * <em>Format</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Identifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='identifier'"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Language()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='language'"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLanguage
	 * <em>Language</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>License</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>License</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>License</em>' attribute.
	 * @see #setLicense(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_License()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='license'"
	 * @generated
	 */
	String getLicense();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getLicense
	 * <em>License</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>License</em>' attribute.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(String value);

	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publisher</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Publisher</em>' attribute.
	 * @see #setPublisher(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Publisher()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='publisher'"
	 * @generated
	 */
	String getPublisher();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getPublisher
	 * <em>Publisher</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Publisher</em>' attribute.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(String value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Relation</em>' attribute.
	 * @see #setRelation(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Relation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='relation'"
	 * @generated
	 */
	String getRelation();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRelation
	 * <em>Relation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Relation</em>' attribute.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(String value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requires</em>' attribute.
	 * @see #setRequires(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Requires()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='requires'"
	 * @generated
	 */
	String getRequires();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRequires
	 * <em>Requires</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Requires</em>' attribute.
	 * @see #getRequires()
	 * @generated
	 */
	void setRequires(String value);

	/**
	 * Returns the value of the '<em><b>Rights</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rights</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rights</em>' attribute.
	 * @see #setRights(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Rights()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='rights'"
	 * @generated
	 */
	String getRights();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getRights
	 * <em>Rights</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Rights</em>' attribute.
	 * @see #getRights()
	 * @generated
	 */
	void setRights(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Source()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='source'"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSource
	 * <em>Source</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Spatial</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spatial</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Spatial</em>' attribute.
	 * @see #setSpatial(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Spatial()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='spatial'"
	 * @generated
	 */
	String getSpatial();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSpatial
	 * <em>Spatial</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Spatial</em>' attribute.
	 * @see #getSpatial()
	 * @generated
	 */
	void setSpatial(String value);

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subject</em>' attribute.
	 * @see #setSubject(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Subject()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subject'"
	 * @generated
	 */
	String getSubject();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getSubject
	 * <em>Subject</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Subject</em>' attribute.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Title()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='title'"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Valid</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Valid</em>' attribute.
	 * @see #setValid(String)
	 * @see org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage#getDublinCore_Valid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='valid'"
	 * @generated
	 */
	String getValid();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.internal.data.generatedplugin.DublinCore#getValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #getValid()
	 * @generated
	 */
	void setValid(String value);

} // DublinCore

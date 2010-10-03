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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Dublin Core</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getBibliographicCitation <em>Bibliographic Citation</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCategoryId <em>Category Id</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCoverage <em>Coverage</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCreator <em>Creator</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getRights <em>Rights</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getSpatial <em>Spatial</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getValid <em>Valid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("all")
public class DublinCoreImpl extends CDOObjectImpl implements DublinCore {
	/**
	 * The default value of the '{@link #getBibliographicCitation() <em>Bibliographic Citation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBibliographicCitation()
	 * @generated
	 * @ordered
	 */
	protected static final String BIBLIOGRAPHIC_CITATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCategoryId() <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getContributor() <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTRIBUTOR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCoverage() <em>Coverage</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final String COVERAGE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCreator() <em>Creator</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATOR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISHER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRequires() <em>Requires</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRES_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRights() <em>Rights</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHTS_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSpatial() <em>Spatial</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSpatial()
	 * @generated
	 * @ordered
	 */
	protected static final String SPATIAL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSubject() <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected static final String VALID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DublinCoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedpluginPackage.Literals.DUBLIN_CORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBibliographicCitation() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, GeneratedpluginPackage.Literals.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBibliographicCitation(String newBibliographicCitation) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, GeneratedpluginPackage.Literals.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, newBibliographicCitation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategoryId() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID, GeneratedpluginPackage.Literals.DUBLIN_CORE__CATEGORY_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategoryId(String newCategoryId) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID, GeneratedpluginPackage.Literals.DUBLIN_CORE__CATEGORY_ID, newCategoryId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContributor() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR, GeneratedpluginPackage.Literals.DUBLIN_CORE__CONTRIBUTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributor(String newContributor) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR, GeneratedpluginPackage.Literals.DUBLIN_CORE__CONTRIBUTOR, newContributor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoverage() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__COVERAGE, GeneratedpluginPackage.Literals.DUBLIN_CORE__COVERAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoverage(String newCoverage) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__COVERAGE, GeneratedpluginPackage.Literals.DUBLIN_CORE__COVERAGE, newCoverage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreated() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__CREATED, GeneratedpluginPackage.Literals.DUBLIN_CORE__CREATED, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(String newCreated) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__CREATED, GeneratedpluginPackage.Literals.DUBLIN_CORE__CREATED, newCreated);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreator() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__CREATOR, GeneratedpluginPackage.Literals.DUBLIN_CORE__CREATOR, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreator(String newCreator) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__CREATOR, GeneratedpluginPackage.Literals.DUBLIN_CORE__CREATOR, newCreator);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__DATE, GeneratedpluginPackage.Literals.DUBLIN_CORE__DATE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__DATE, GeneratedpluginPackage.Literals.DUBLIN_CORE__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION, GeneratedpluginPackage.Literals.DUBLIN_CORE__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION, GeneratedpluginPackage.Literals.DUBLIN_CORE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__FORMAT, GeneratedpluginPackage.Literals.DUBLIN_CORE__FORMAT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__FORMAT, GeneratedpluginPackage.Literals.DUBLIN_CORE__FORMAT, newFormat);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER, GeneratedpluginPackage.Literals.DUBLIN_CORE__IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER, GeneratedpluginPackage.Literals.DUBLIN_CORE__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE, GeneratedpluginPackage.Literals.DUBLIN_CORE__LANGUAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE, GeneratedpluginPackage.Literals.DUBLIN_CORE__LANGUAGE, newLanguage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicense() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__LICENSE, GeneratedpluginPackage.Literals.DUBLIN_CORE__LICENSE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__LICENSE, GeneratedpluginPackage.Literals.DUBLIN_CORE__LICENSE, newLicense);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublisher() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER, GeneratedpluginPackage.Literals.DUBLIN_CORE__PUBLISHER, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(String newPublisher) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER, GeneratedpluginPackage.Literals.DUBLIN_CORE__PUBLISHER, newPublisher);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelation() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__RELATION, GeneratedpluginPackage.Literals.DUBLIN_CORE__RELATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(String newRelation) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__RELATION, GeneratedpluginPackage.Literals.DUBLIN_CORE__RELATION, newRelation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequires() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__REQUIRES, GeneratedpluginPackage.Literals.DUBLIN_CORE__REQUIRES, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequires(String newRequires) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__REQUIRES, GeneratedpluginPackage.Literals.DUBLIN_CORE__REQUIRES, newRequires);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRights() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__RIGHTS, GeneratedpluginPackage.Literals.DUBLIN_CORE__RIGHTS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRights(String newRights) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__RIGHTS, GeneratedpluginPackage.Literals.DUBLIN_CORE__RIGHTS, newRights);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__SOURCE, GeneratedpluginPackage.Literals.DUBLIN_CORE__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__SOURCE, GeneratedpluginPackage.Literals.DUBLIN_CORE__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpatial() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__SPATIAL, GeneratedpluginPackage.Literals.DUBLIN_CORE__SPATIAL, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpatial(String newSpatial) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__SPATIAL, GeneratedpluginPackage.Literals.DUBLIN_CORE__SPATIAL, newSpatial);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubject() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__SUBJECT, GeneratedpluginPackage.Literals.DUBLIN_CORE__SUBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(String newSubject) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__SUBJECT, GeneratedpluginPackage.Literals.DUBLIN_CORE__SUBJECT, newSubject);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__TITLE, GeneratedpluginPackage.Literals.DUBLIN_CORE__TITLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__TITLE, GeneratedpluginPackage.Literals.DUBLIN_CORE__TITLE, newTitle);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__TYPE, GeneratedpluginPackage.Literals.DUBLIN_CORE__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__TYPE, GeneratedpluginPackage.Literals.DUBLIN_CORE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValid() {
		return (String)eDynamicGet(GeneratedpluginPackage.DUBLIN_CORE__VALID, GeneratedpluginPackage.Literals.DUBLIN_CORE__VALID, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(String newValid) {
		eDynamicSet(GeneratedpluginPackage.DUBLIN_CORE__VALID, GeneratedpluginPackage.Literals.DUBLIN_CORE__VALID, newValid);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				return getBibliographicCitation();
			case GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID:
				return getCategoryId();
			case GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR:
				return getContributor();
			case GeneratedpluginPackage.DUBLIN_CORE__COVERAGE:
				return getCoverage();
			case GeneratedpluginPackage.DUBLIN_CORE__CREATED:
				return getCreated();
			case GeneratedpluginPackage.DUBLIN_CORE__CREATOR:
				return getCreator();
			case GeneratedpluginPackage.DUBLIN_CORE__DATE:
				return getDate();
			case GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION:
				return getDescription();
			case GeneratedpluginPackage.DUBLIN_CORE__FORMAT:
				return getFormat();
			case GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER:
				return getIdentifier();
			case GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE:
				return getLanguage();
			case GeneratedpluginPackage.DUBLIN_CORE__LICENSE:
				return getLicense();
			case GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER:
				return getPublisher();
			case GeneratedpluginPackage.DUBLIN_CORE__RELATION:
				return getRelation();
			case GeneratedpluginPackage.DUBLIN_CORE__REQUIRES:
				return getRequires();
			case GeneratedpluginPackage.DUBLIN_CORE__RIGHTS:
				return getRights();
			case GeneratedpluginPackage.DUBLIN_CORE__SOURCE:
				return getSource();
			case GeneratedpluginPackage.DUBLIN_CORE__SPATIAL:
				return getSpatial();
			case GeneratedpluginPackage.DUBLIN_CORE__SUBJECT:
				return getSubject();
			case GeneratedpluginPackage.DUBLIN_CORE__TITLE:
				return getTitle();
			case GeneratedpluginPackage.DUBLIN_CORE__TYPE:
				return getType();
			case GeneratedpluginPackage.DUBLIN_CORE__VALID:
				return getValid();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				setBibliographicCitation((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID:
				setCategoryId((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR:
				setContributor((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__COVERAGE:
				setCoverage((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CREATED:
				setCreated((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CREATOR:
				setCreator((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__DATE:
				setDate((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__FORMAT:
				setFormat((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__LICENSE:
				setLicense((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER:
				setPublisher((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__RELATION:
				setRelation((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__REQUIRES:
				setRequires((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__RIGHTS:
				setRights((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__SOURCE:
				setSource((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__SPATIAL:
				setSpatial((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__SUBJECT:
				setSubject((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__TITLE:
				setTitle((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__TYPE:
				setType((String)newValue);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__VALID:
				setValid((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				setBibliographicCitation(BIBLIOGRAPHIC_CITATION_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID:
				setCategoryId(CATEGORY_ID_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR:
				setContributor(CONTRIBUTOR_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__COVERAGE:
				setCoverage(COVERAGE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__CREATOR:
				setCreator(CREATOR_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER:
				setPublisher(PUBLISHER_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__RELATION:
				setRelation(RELATION_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__REQUIRES:
				setRequires(REQUIRES_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__RIGHTS:
				setRights(RIGHTS_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__SPATIAL:
				setSpatial(SPATIAL_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__SUBJECT:
				setSubject(SUBJECT_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GeneratedpluginPackage.DUBLIN_CORE__VALID:
				setValid(VALID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				return BIBLIOGRAPHIC_CITATION_EDEFAULT == null ? getBibliographicCitation() != null : !BIBLIOGRAPHIC_CITATION_EDEFAULT.equals(getBibliographicCitation());
			case GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID:
				return CATEGORY_ID_EDEFAULT == null ? getCategoryId() != null : !CATEGORY_ID_EDEFAULT.equals(getCategoryId());
			case GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR:
				return CONTRIBUTOR_EDEFAULT == null ? getContributor() != null : !CONTRIBUTOR_EDEFAULT.equals(getContributor());
			case GeneratedpluginPackage.DUBLIN_CORE__COVERAGE:
				return COVERAGE_EDEFAULT == null ? getCoverage() != null : !COVERAGE_EDEFAULT.equals(getCoverage());
			case GeneratedpluginPackage.DUBLIN_CORE__CREATED:
				return CREATED_EDEFAULT == null ? getCreated() != null : !CREATED_EDEFAULT.equals(getCreated());
			case GeneratedpluginPackage.DUBLIN_CORE__CREATOR:
				return CREATOR_EDEFAULT == null ? getCreator() != null : !CREATOR_EDEFAULT.equals(getCreator());
			case GeneratedpluginPackage.DUBLIN_CORE__DATE:
				return DATE_EDEFAULT == null ? getDate() != null : !DATE_EDEFAULT.equals(getDate());
			case GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case GeneratedpluginPackage.DUBLIN_CORE__FORMAT:
				return FORMAT_EDEFAULT == null ? getFormat() != null : !FORMAT_EDEFAULT.equals(getFormat());
			case GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? getIdentifier() != null : !IDENTIFIER_EDEFAULT.equals(getIdentifier());
			case GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? getLanguage() != null : !LANGUAGE_EDEFAULT.equals(getLanguage());
			case GeneratedpluginPackage.DUBLIN_CORE__LICENSE:
				return LICENSE_EDEFAULT == null ? getLicense() != null : !LICENSE_EDEFAULT.equals(getLicense());
			case GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER:
				return PUBLISHER_EDEFAULT == null ? getPublisher() != null : !PUBLISHER_EDEFAULT.equals(getPublisher());
			case GeneratedpluginPackage.DUBLIN_CORE__RELATION:
				return RELATION_EDEFAULT == null ? getRelation() != null : !RELATION_EDEFAULT.equals(getRelation());
			case GeneratedpluginPackage.DUBLIN_CORE__REQUIRES:
				return REQUIRES_EDEFAULT == null ? getRequires() != null : !REQUIRES_EDEFAULT.equals(getRequires());
			case GeneratedpluginPackage.DUBLIN_CORE__RIGHTS:
				return RIGHTS_EDEFAULT == null ? getRights() != null : !RIGHTS_EDEFAULT.equals(getRights());
			case GeneratedpluginPackage.DUBLIN_CORE__SOURCE:
				return SOURCE_EDEFAULT == null ? getSource() != null : !SOURCE_EDEFAULT.equals(getSource());
			case GeneratedpluginPackage.DUBLIN_CORE__SPATIAL:
				return SPATIAL_EDEFAULT == null ? getSpatial() != null : !SPATIAL_EDEFAULT.equals(getSpatial());
			case GeneratedpluginPackage.DUBLIN_CORE__SUBJECT:
				return SUBJECT_EDEFAULT == null ? getSubject() != null : !SUBJECT_EDEFAULT.equals(getSubject());
			case GeneratedpluginPackage.DUBLIN_CORE__TITLE:
				return TITLE_EDEFAULT == null ? getTitle() != null : !TITLE_EDEFAULT.equals(getTitle());
			case GeneratedpluginPackage.DUBLIN_CORE__TYPE:
				return TYPE_EDEFAULT == null ? getType() != null : !TYPE_EDEFAULT.equals(getType());
			case GeneratedpluginPackage.DUBLIN_CORE__VALID:
				return VALID_EDEFAULT == null ? getValid() != null : !VALID_EDEFAULT.equals(getValid());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		final StringBuilder result = new StringBuilder();
		if (getIdentifier() != null && !getIdentifier().equals("")) {
			result.append("identifier=\"");
			result.append(getIdentifier().trim());
			result.append("\" ");
		}
		if (getType() != null && !getType().equals("")) {
			result.append("type=\"");
			result.append(getType().trim());
			result.append("\" ");
		}
		if (getTitle() != null && !getTitle().equals("")) {
			result.append("title=\"");
			result.append(getTitle().trim());
			result.append("\" ");
		}

		if (getCreator() != null && !getCreator().equals("")) {
			result.append("creator=\"");
			result.append(getCreator().trim());
			result.append("\" ");
		}
		if (getSubject() != null && !getSubject().equals("")) {
			result.append("subject=\"");
			result.append(getSubject().trim());
			result.append("\" ");
		}
		if (getDescription() != null && !getDescription().equals("")) {
			result.append("description=\"");
			result.append(getDescription().trim());
			result.append("\" ");
		}

		if (getPublisher() != null && !getPublisher().equals("")) {
			result.append("publisher=\"");
			result.append(getPublisher().trim());
			result.append("\" ");
		}
		if (getContributor() != null && !getContributor().equals("")) {
			result.append("contributor=\"");
			result.append(getContributor().trim());
			result.append("\" ");
		}
		if (getDate() != null && !getDate().equals("")) {
			result.append("date=\"");
			result.append(getDate().trim());
			result.append("\" ");
		}

		if (getFormat() != null && !getFormat().equals("")) {
			result.append("format=\"");
			result.append(getFormat().trim());
			result.append("\" ");
		}

		if (getSource() != null && !getSource().equals("")) {
			result.append("source=\"");
			result.append(getSource().trim());
			result.append("\" ");
		}
		if (getLanguage() != null && !getLanguage().equals("")) {
			result.append("language=\"");
			result.append(getLanguage().trim());
			result.append("\" ");
		}
		if (getRelation() != null && !getRelation().equals("")) {
			result.append("relation=\"");
			result.append(getRelation().trim());
			result.append("\" ");
		}
		if (getCoverage() != null && !getCoverage().equals("")) {
			result.append("coverage=\"");
			result.append(getCoverage().trim());
			result.append("\" ");
		}
		if (getRights() != null && !getRights().equals("")) {
			result.append("rights=\"");
			result.append(getRights().trim());
			result.append("\" ");
		}
		if (getBibliographicCitation() != null && !getBibliographicCitation().equals("")) {
			result.append("bibliographicCitation=\"");
			result.append(getBibliographicCitation().trim());
			result.append("\" ");
		}
		if (getCreated() != null && !getCreated().equals("")) {
			result.append("created=\"");
			result.append(getCreated().trim());
			result.append("\" ");
		}
		if (getLicense() != null && !getLicense().equals("")) {
			result.append("license=\"");
			result.append(getLicense().trim());
			result.append("\" ");
		}
		// if (required != null && !required.equals("")) {
		// result.append("required=\"");
		// result.append(required.trim());
		// result.append("\" ");
		// }
		if (getSpatial() != null && !getSpatial().equals("")) {
			result.append("spatial=\"");
			result.append(getSpatial().trim());
			result.append("\" ");
		}
		if (getValid() != null && !getValid().equals("")) {
			result.append("valid=\"");
			result.append(getValid().trim());
			result.append("\" ");
		}

		return result.toString();
	} // toString
} // DublinCoreImpl

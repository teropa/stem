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
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getBibliographicCitation
 * <em>Bibliographic Citation</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCategoryId
 * <em>Category Id</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getContributor
 * <em>Contributor</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCoverage
 * <em>Coverage</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCreated
 * <em>Created</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getCreator
 * <em>Creator</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getDate
 * <em>Date</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getDescription
 * <em>Description</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getFormat
 * <em>Format</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getIdentifier
 * <em>Identifier</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getLanguage
 * <em>Language</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getLicense
 * <em>License</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getPublisher
 * <em>Publisher</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getRelation
 * <em>Relation</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getRequires
 * <em>Requires</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getRights
 * <em>Rights</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getSource
 * <em>Source</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getSpatial
 * <em>Spatial</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getSubject
 * <em>Subject</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getTitle
 * <em>Title</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getType
 * <em>Type</em>}</li>
 * <li>
 * {@link org.eclipse.stem.internal.data.generatedplugin.impl.DublinCoreImpl#getValid
 * <em>Valid</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
@SuppressWarnings("all")
public class DublinCoreImpl extends EObjectImpl implements DublinCore {
	/**
	 * The default value of the '{@link #getBibliographicCitation()
	 * <em>Bibliographic Citation</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBibliographicCitation()
	 * @generated
	 * @ordered
	 */
	protected static final String BIBLIOGRAPHIC_CITATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBibliographicCitation()
	 * <em>Bibliographic Citation</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBibliographicCitation()
	 * @generated
	 * @ordered
	 */
	protected String bibliographicCitation = BIBLIOGRAPHIC_CITATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategoryId() <em>Category Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategoryId() <em>Category Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
	protected String categoryId = CATEGORY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getContributor() <em>Contributor</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTRIBUTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContributor() <em>Contributor</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected String contributor = CONTRIBUTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoverage() <em>Coverage</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final String COVERAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoverage() <em>Coverage</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected String coverage = COVERAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected String created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreator() <em>Creator</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreator() <em>Creator</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected String creator = CREATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublisher() <em>Publisher</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected String publisher = PUBLISHER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected String relation = RELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequires() <em>Requires</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected String requires = REQUIRES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRights() <em>Rights</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRights() <em>Rights</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected String rights = RIGHTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpatial() <em>Spatial</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSpatial()
	 * @generated
	 * @ordered
	 */
	protected static final String SPATIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpatial() <em>Spatial</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSpatial()
	 * @generated
	 * @ordered
	 */
	protected String spatial = SPATIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubject() <em>Subject</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected String subject = SUBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected static final String VALID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected String valid = VALID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DublinCoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedpluginPackage.Literals.DUBLIN_CORE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBibliographicCitation() {
		return bibliographicCitation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBibliographicCitation(String newBibliographicCitation) {
		String oldBibliographicCitation = bibliographicCitation;
		bibliographicCitation = newBibliographicCitation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION,
					oldBibliographicCitation, bibliographicCitation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCategoryId(String newCategoryId) {
		String oldCategoryId = categoryId;
		categoryId = newCategoryId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID,
					oldCategoryId, categoryId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getContributor() {
		return contributor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContributor(String newContributor) {
		String oldContributor = contributor;
		contributor = newContributor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR,
					oldContributor, contributor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCoverage() {
		return coverage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCoverage(String newCoverage) {
		String oldCoverage = coverage;
		coverage = newCoverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__COVERAGE, oldCoverage,
					coverage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreated(String newCreated) {
		String oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__CREATED, oldCreated,
					created));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreator(String newCreator) {
		String oldCreator = creator;
		creator = newCreator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__CREATOR, oldCreator,
					creator));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__FORMAT, oldFormat,
					format));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER,
					oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE, oldLanguage,
					language));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__LICENSE, oldLicense,
					license));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPublisher(String newPublisher) {
		String oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER,
					oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRelation(String newRelation) {
		String oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__RELATION, oldRelation,
					relation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getRequires() {
		return requires;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRequires(String newRequires) {
		String oldRequires = requires;
		requires = newRequires;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__REQUIRES, oldRequires,
					requires));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRights(String newRights) {
		String oldRights = rights;
		rights = newRights;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__RIGHTS, oldRights,
					rights));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__SOURCE, oldSource,
					source));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSpatial() {
		return spatial;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSpatial(String newSpatial) {
		String oldSpatial = spatial;
		spatial = newSpatial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__SPATIAL, oldSpatial,
					spatial));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSubject(String newSubject) {
		String oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__SUBJECT, oldSubject,
					subject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValid(String newValid) {
		String oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					GeneratedpluginPackage.DUBLIN_CORE__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
			setBibliographicCitation((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID:
			setCategoryId((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR:
			setContributor((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__COVERAGE:
			setCoverage((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__CREATED:
			setCreated((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__CREATOR:
			setCreator((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__DATE:
			setDate((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__FORMAT:
			setFormat((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER:
			setIdentifier((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE:
			setLanguage((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__LICENSE:
			setLicense((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER:
			setPublisher((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__RELATION:
			setRelation((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__REQUIRES:
			setRequires((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__RIGHTS:
			setRights((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__SOURCE:
			setSource((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__SPATIAL:
			setSpatial((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__SUBJECT:
			setSubject((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__TITLE:
			setTitle((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__TYPE:
			setType((String) newValue);
			return;
		case GeneratedpluginPackage.DUBLIN_CORE__VALID:
			setValid((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GeneratedpluginPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
			return BIBLIOGRAPHIC_CITATION_EDEFAULT == null ? bibliographicCitation != null
					: !BIBLIOGRAPHIC_CITATION_EDEFAULT
							.equals(bibliographicCitation);
		case GeneratedpluginPackage.DUBLIN_CORE__CATEGORY_ID:
			return CATEGORY_ID_EDEFAULT == null ? categoryId != null
					: !CATEGORY_ID_EDEFAULT.equals(categoryId);
		case GeneratedpluginPackage.DUBLIN_CORE__CONTRIBUTOR:
			return CONTRIBUTOR_EDEFAULT == null ? contributor != null
					: !CONTRIBUTOR_EDEFAULT.equals(contributor);
		case GeneratedpluginPackage.DUBLIN_CORE__COVERAGE:
			return COVERAGE_EDEFAULT == null ? coverage != null
					: !COVERAGE_EDEFAULT.equals(coverage);
		case GeneratedpluginPackage.DUBLIN_CORE__CREATED:
			return CREATED_EDEFAULT == null ? created != null
					: !CREATED_EDEFAULT.equals(created);
		case GeneratedpluginPackage.DUBLIN_CORE__CREATOR:
			return CREATOR_EDEFAULT == null ? creator != null
					: !CREATOR_EDEFAULT.equals(creator);
		case GeneratedpluginPackage.DUBLIN_CORE__DATE:
			return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT
					.equals(date);
		case GeneratedpluginPackage.DUBLIN_CORE__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case GeneratedpluginPackage.DUBLIN_CORE__FORMAT:
			return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT
					.equals(format);
		case GeneratedpluginPackage.DUBLIN_CORE__IDENTIFIER:
			return IDENTIFIER_EDEFAULT == null ? identifier != null
					: !IDENTIFIER_EDEFAULT.equals(identifier);
		case GeneratedpluginPackage.DUBLIN_CORE__LANGUAGE:
			return LANGUAGE_EDEFAULT == null ? language != null
					: !LANGUAGE_EDEFAULT.equals(language);
		case GeneratedpluginPackage.DUBLIN_CORE__LICENSE:
			return LICENSE_EDEFAULT == null ? license != null
					: !LICENSE_EDEFAULT.equals(license);
		case GeneratedpluginPackage.DUBLIN_CORE__PUBLISHER:
			return PUBLISHER_EDEFAULT == null ? publisher != null
					: !PUBLISHER_EDEFAULT.equals(publisher);
		case GeneratedpluginPackage.DUBLIN_CORE__RELATION:
			return RELATION_EDEFAULT == null ? relation != null
					: !RELATION_EDEFAULT.equals(relation);
		case GeneratedpluginPackage.DUBLIN_CORE__REQUIRES:
			return REQUIRES_EDEFAULT == null ? requires != null
					: !REQUIRES_EDEFAULT.equals(requires);
		case GeneratedpluginPackage.DUBLIN_CORE__RIGHTS:
			return RIGHTS_EDEFAULT == null ? rights != null : !RIGHTS_EDEFAULT
					.equals(rights);
		case GeneratedpluginPackage.DUBLIN_CORE__SOURCE:
			return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT
					.equals(source);
		case GeneratedpluginPackage.DUBLIN_CORE__SPATIAL:
			return SPATIAL_EDEFAULT == null ? spatial != null
					: !SPATIAL_EDEFAULT.equals(spatial);
		case GeneratedpluginPackage.DUBLIN_CORE__SUBJECT:
			return SUBJECT_EDEFAULT == null ? subject != null
					: !SUBJECT_EDEFAULT.equals(subject);
		case GeneratedpluginPackage.DUBLIN_CORE__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT
					.equals(title);
		case GeneratedpluginPackage.DUBLIN_CORE__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT
					.equals(type);
		case GeneratedpluginPackage.DUBLIN_CORE__VALID:
			return VALID_EDEFAULT == null ? valid != null : !VALID_EDEFAULT
					.equals(valid);
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

package org.eclipse.stem.core.common.impl;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DublinCore;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Dublin Core</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getCreator <em>Creator</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getCoverage <em>Coverage</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getRights <em>Rights</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getBibliographicCitation <em>Bibliographic Citation</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getSpatial <em>Spatial</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DublinCoreImpl#getValid <em>Valid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DublinCoreImpl extends EObjectImpl implements DublinCore {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreator() <em>Creator</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreator() <em>Creator</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected String creator = CREATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected String publisher = PUBLISHER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoverage() <em>Coverage</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final String COVERAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoverage() <em>Coverage</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected String coverage = COVERAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContributor() <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTRIBUTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContributor() <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected String contributor = CONTRIBUTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected String relation = RELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRights() <em>Rights</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRights() <em>Rights</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected String rights = RIGHTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubject() <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected String subject = SUBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBibliographicCitation() <em>Bibliographic Citation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBibliographicCitation()
	 * @generated
	 * @ordered
	 */
	protected static final String BIBLIOGRAPHIC_CITATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBibliographicCitation() <em>Bibliographic Citation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBibliographicCitation()
	 * @generated
	 * @ordered
	 */
	protected String bibliographicCitation = BIBLIOGRAPHIC_CITATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected String created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected String required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpatial() <em>Spatial</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSpatial()
	 * @generated
	 * @ordered
	 */
	protected static final String SPATIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpatial() <em>Spatial</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSpatial()
	 * @generated
	 * @ordered
	 */
	protected String spatial = SPATIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected static final String VALID_EDEFAULT = null;

	/**
	 * This is the string used in the {@link #valid} attribute to specify the
	 * starting date of the valid date range.
	 */
	public static final String START = "start=";

	/**
	 * This is the string used in the {@link #valid} attribute to specify the
	 * ending date of the valid date range.
	 */
	public static final String END = "end=";

	/**
	 * The cached value of the '{@link #getValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected String valid = VALID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DublinCoreImpl() {
		super();
	}

	/**
	 * This constructor is used to create and initialize a Dublin Core instance
	 * from an IConfigurationElement instance. The configuration element is
	 * extracted from the extension definition in the plugin.xml file of a
	 * plug-in that is providing an Identifiable. This is used by the class
	 * IdentifiableDelegate in the class
	 * org.eclipse.stem.ui.views.IdentifiablePluginView to create a "proxy"
	 * representation of the Dublin Core of the Identifiable from the
	 * configuration element so that the Identifiable itself does not have to be
	 * loaded.
	 * 
	 * @param configElement
	 *            the configuration element from the plugin.xml file
	 * 
	 * @generated NOT
	 */
	public DublinCoreImpl(IConfigurationElement configElement) {
		setTitle(configElement.getAttribute("title"));
		setCreator(configElement.getAttribute("creator"));
		setSubject(configElement.getAttribute("subject"));
		setDescription(configElement.getAttribute("description"));
		setPublisher(configElement.getAttribute("publisher"));
		setContributor(configElement.getAttribute("contributor"));
		setDate(configElement.getAttribute("date"));
		setType(configElement.getAttribute("type"));
		setFormat(configElement.getAttribute("format"));
		setIdentifier(configElement.getAttribute("identifier"));
		setSource(configElement.getAttribute("source"));
		setLanguage(configElement.getAttribute("language"));
		setRelation(configElement.getAttribute("relation"));
		setCoverage(configElement.getAttribute("coverage"));
		setBibliographicCitation(configElement.getAttribute("bibliographicCitation"));
		setCreated(configElement.getAttribute("created"));
		setLicense(configElement.getAttribute("license"));
		setRequired(configElement.getAttribute("required"));
		setSpatial(configElement.getAttribute("spatial"));
		setValid(configElement.getAttribute("valid"));
	} // DublinCoreImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.DUBLIN_CORE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreator(String newCreator) {
		String oldCreator = creator;
		creator = newCreator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__CREATOR, oldCreator, creator));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(String newSubject) {
		String oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__SUBJECT, oldSubject, subject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(String newPublisher) {
		String oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__PUBLISHER, oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContributor() {
		return contributor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributor(String newContributor) {
		String oldContributor = contributor;
		contributor = newContributor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__CONTRIBUTOR, oldContributor, contributor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__DATE, oldDate, date));
	}

	/**
	 * @see org.eclipse.stem.common.DublinCore#setDate(java.util.Date)
	 */
	public void setDate(Date date) {
		setDate(createISO8601DateString(date));
	} // setDate

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(String newRelation) {
		String oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoverage() {
		return coverage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoverage(String newCoverage) {
		String oldCoverage = coverage;
		coverage = newCoverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__COVERAGE, oldCoverage, coverage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRights(String newRights) {
		String oldRights = rights;
		rights = newRights;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__RIGHTS, oldRights, rights));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBibliographicCitation() {
		return bibliographicCitation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBibliographicCitation(String newBibliographicCitation) {
		String oldBibliographicCitation = bibliographicCitation;
		bibliographicCitation = newBibliographicCitation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, oldBibliographicCitation, bibliographicCitation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(String newCreated) {
		String oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__CREATED, oldCreated, created));
	}

	/**
	 * @see org.eclipse.stem.common.DublinCore#setCreated(java.util.Date)
	 */
	public void setCreated(Date date) {
		setCreated(createISO8601DateString(date));
	} // setCreated

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(String newRequired) {
		String oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpatial() {
		return spatial;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpatial(String newSpatial) {
		String oldSpatial = spatial;
		spatial = newSpatial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__SPATIAL, oldSpatial, spatial));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @see org.eclipse.stem.core.common.DublinCore#getValidEndDate()
	 */
	public Date getValidEndDate() {
		return getValidEndDate(getValid());
	} // getValidEndDate

	/**
	 * @see org.eclipse.stem.core.common.DublinCore#getValidEndDate()
	 */
	@SuppressWarnings("null")
	public static Date getValidEndDate(final String validValue) {
		Date retValue = null;
		// Is the valid value set?
		if (validValue != null) {
			// Yes
			final int dateIndex = validValue.indexOf(END);
			// Is the end date specified?
			if (dateIndex >= 0) {
				// Yes
				try {
					retValue = createDateFromISO8601DateString(validValue
							.substring(dateIndex + END.length()));
				} catch (ParseException e) {
					retValue = null;
				}
			} // if
		} // if
		return retValue;
	} // getValidEndDate

	/**
	 * @see org.eclipse.stem.core.common.DublinCore#isValidBefore(DublinCore)
	 */
	@SuppressWarnings("null")
	public boolean isValidBefore(DublinCore dublinCore) {
		final Date ourStartDate = getValidStartDate();
		final Date otherStartDate = dublinCore != null ? dublinCore
				.getValidStartDate() : null;

		boolean retValue = (dublinCore == null) || (otherStartDate == null);

		retValue = retValue
				|| (ourStartDate != null && otherStartDate.after(ourStartDate));

		return retValue;
	} // isValidBefore

	public Date[] computeValidDateRangeOverlap(DublinCore dublinCore) {
		Date[] retValue = null;
		
		final Date ourStartDate = getValidStartDate();
		final Date ourEndDate = getValidEndDate();
		final Date otherStartDate = dublinCore.getValidStartDate();
		final Date otherEndDate = dublinCore.getValidEndDate();

		Date newStartDate = ourStartDate;
		Date newEndDate = ourEndDate;

		// Figure out which start date is oldest
		// Do we have a start date?
		if (ourStartDate != null) {
			// Yes
			// How about the other start date?
			if (otherStartDate != null) {
				// Yes
				// Is the other start date after ours?
				if (otherStartDate.after(ourStartDate)) {
					// Yes
					newStartDate = otherStartDate;
				}
			} // if other start date?
		} // if start date?
		else {
			// No
			newStartDate = otherStartDate;
		}

		// Figure out which end data is youngest
		// Do we have an end date?
		if (ourEndDate != null) {
			// Yes
			// How about the other end date?
			if (otherEndDate != null) {
				// Yes
				// Is the other end date before ours?
				if (otherEndDate.before(ourEndDate)) {
					// Yes
					newEndDate = otherEndDate;
				}
			} // if the other end date?
		} // if we have an end date
		else {
			// No
			newEndDate = otherEndDate;
		}

		// At this point the newStartDate and newEndDate could be null. However,
		// if they are not null, we need to check to make sure that the start
		// comes before the end.

		// Do we have a new start date?
		if (newStartDate != null) {
			// Yes
			// How about the new end date?
			if (newEndDate != null) {
				// Yes
				// Does the new start date come before the new end date?
				if (newStartDate.before(newEndDate)) {
					// Yes
					retValue = new Date[] {newStartDate,newEndDate};
				} 
			}
		} // if new start date

		return retValue;
	} // computeValidDateRangeOverlap
	
	/**
	 * @param validValue
	 * @return <code>true</code> if the end date in the valid string does not
	 *         exist, or if it does, if it is properly formatted,
	 *         <code>false</code> otherwise.
	 */
	public static boolean isValidEndDateValid(final String validValue) {
		boolean retValue = true;
		// Is the valid value set?
		if (validValue != null) {
			// Yes
			try {
				final String endPart = validValue.substring(
						"start=yyyy-DD-mm;".length()).trim();
				final int dateIndex = endPart.indexOf(END);

				// Was there just white space?
				if (endPart.equals("")) {
					// Yes
					return true;
				}

				// Does it end with a ";"?
				if (!endPart.endsWith(";")) {
					// No
					return false;
				}
				
				// Is it the right length?
				if (endPart.length() != END.length() + "yyyy-dd-mm;".length()) {
					// No
					return false;
				}
				
				// Is the end date specified?
				if (dateIndex == 0) {
					// Yes
					// If we throw a parse exception we'll catch it below and return false 
					createDateFromISO8601DateString(endPart.substring( END.length()));
					retValue = true;

				} // if
				else {
					retValue = false;
				}
			} catch (ParseException e) {
				retValue = false;
			} catch (StringIndexOutOfBoundsException e) {
				retValue = false;
			}
		} // if
		return retValue;
	} // isValidEndDateValid

	/**
	 * @see org.eclipse.stem.core.common.DublinCore#getValidEndDate()
	 */
	public Date getValidStartDate() {
		return getValidStartDate(getValid());
	} // getValidStartDate

	/**
	 * @see org.eclipse.stem.core.common.DublinCore#getValidStartDate()
	 */
	@SuppressWarnings("null")
	public static Date getValidStartDate(final String validValue) {
		Date retValue = null;
		// Is the valid value set?
		if (validValue != null) {
			// Yes
			final int dateIndex = validValue.indexOf(START) + START.length();
			try {
				retValue = createDateFromISO8601DateString(validValue
						.substring(dateIndex));
			} catch (ParseException e) {
				retValue = null;
			}
		}
		return retValue;
	} // getValidStartDate

	/**
	 * @param validValue
	 * @return <code>true</code> if the start date in the valid string exists
	 *         and is properly formatted
	 */
	public static boolean isValidStartDateValid(final String validValue) {
		boolean retValue = false;
		// Is the valid value set?
		if (validValue != null) {
			// Yes
			try {
				final String trimedValidValue = validValue.trim();
				final int dateIndex = validValue.indexOf(START)
						+ START.length();
				final String extractedDate = trimedValidValue.substring(
						dateIndex, "start=YYYY-DD-MM;".length());
				// Is there a ";" on the end of the date?
				if (!extractedDate.endsWith(";")) {
					// No
					return false;
				}
				// If we throw a parse exception, we'll catch it below and return false
				createDateFromISO8601DateString(extractedDate);
				retValue = true;
			} catch (ParseException e) {
				retValue = false;
			} catch (StringIndexOutOfBoundsException e) {
				retValue = false;
			}
		}
		return retValue;
	} // isValidStartDateValid

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(String newValid) {
		String oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.DUBLIN_CORE__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public DublinCore populate() {
		setCreated(Calendar.getInstance().getTime());
		setCreator(System.getProperty("user.name"));
		return this;
	} // populate

	/**
	 * @see org.eclipse.stem.common.DublinCore#setValid(java.util.Date,
	 *      java.util.Date)
	 */
	public void setValid(final Date startDate, final Date endDate) {
		final StringBuilder sb = new StringBuilder(START);
		sb.append(createISO8601DateString(startDate));
		sb.append("; ");
		sb.append(END);
		sb.append(createISO8601DateString(endDate));
		sb.append(";");
		setValid(sb.toString());
	} // setValid

	/**
	 * @see org.eclipse.stem.common.DublinCore#setValid(java.util.Date)
	 */
	public void setValid(final Date startDate) {
		final StringBuilder sb = new StringBuilder(START);
		sb.append(createISO8601DateString(startDate));
		sb.append(";");
		setValid(sb.toString());
	} // setValid

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.DUBLIN_CORE__TITLE:
				return getTitle();
			case CommonPackage.DUBLIN_CORE__IDENTIFIER:
				return getIdentifier();
			case CommonPackage.DUBLIN_CORE__DESCRIPTION:
				return getDescription();
			case CommonPackage.DUBLIN_CORE__CREATOR:
				return getCreator();
			case CommonPackage.DUBLIN_CORE__DATE:
				return getDate();
			case CommonPackage.DUBLIN_CORE__FORMAT:
				return getFormat();
			case CommonPackage.DUBLIN_CORE__PUBLISHER:
				return getPublisher();
			case CommonPackage.DUBLIN_CORE__COVERAGE:
				return getCoverage();
			case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
				return getContributor();
			case CommonPackage.DUBLIN_CORE__RELATION:
				return getRelation();
			case CommonPackage.DUBLIN_CORE__RIGHTS:
				return getRights();
			case CommonPackage.DUBLIN_CORE__SOURCE:
				return getSource();
			case CommonPackage.DUBLIN_CORE__SUBJECT:
				return getSubject();
			case CommonPackage.DUBLIN_CORE__TYPE:
				return getType();
			case CommonPackage.DUBLIN_CORE__LANGUAGE:
				return getLanguage();
			case CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				return getBibliographicCitation();
			case CommonPackage.DUBLIN_CORE__CREATED:
				return getCreated();
			case CommonPackage.DUBLIN_CORE__LICENSE:
				return getLicense();
			case CommonPackage.DUBLIN_CORE__REQUIRED:
				return getRequired();
			case CommonPackage.DUBLIN_CORE__SPATIAL:
				return getSpatial();
			case CommonPackage.DUBLIN_CORE__VALID:
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
			case CommonPackage.DUBLIN_CORE__TITLE:
				setTitle((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__CREATOR:
				setCreator((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__DATE:
				setDate((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__FORMAT:
				setFormat((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__PUBLISHER:
				setPublisher((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__COVERAGE:
				setCoverage((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
				setContributor((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__RELATION:
				setRelation((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__RIGHTS:
				setRights((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__SOURCE:
				setSource((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__SUBJECT:
				setSubject((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__TYPE:
				setType((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				setBibliographicCitation((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__CREATED:
				setCreated((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__LICENSE:
				setLicense((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__REQUIRED:
				setRequired((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__SPATIAL:
				setSpatial((String)newValue);
				return;
			case CommonPackage.DUBLIN_CORE__VALID:
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
			case CommonPackage.DUBLIN_CORE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__CREATOR:
				setCreator(CREATOR_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__PUBLISHER:
				setPublisher(PUBLISHER_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__COVERAGE:
				setCoverage(COVERAGE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
				setContributor(CONTRIBUTOR_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__RELATION:
				setRelation(RELATION_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__RIGHTS:
				setRights(RIGHTS_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__SUBJECT:
				setSubject(SUBJECT_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				setBibliographicCitation(BIBLIOGRAPHIC_CITATION_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__SPATIAL:
				setSpatial(SPATIAL_EDEFAULT);
				return;
			case CommonPackage.DUBLIN_CORE__VALID:
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
			case CommonPackage.DUBLIN_CORE__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case CommonPackage.DUBLIN_CORE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case CommonPackage.DUBLIN_CORE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommonPackage.DUBLIN_CORE__CREATOR:
				return CREATOR_EDEFAULT == null ? creator != null : !CREATOR_EDEFAULT.equals(creator);
			case CommonPackage.DUBLIN_CORE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case CommonPackage.DUBLIN_CORE__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case CommonPackage.DUBLIN_CORE__PUBLISHER:
				return PUBLISHER_EDEFAULT == null ? publisher != null : !PUBLISHER_EDEFAULT.equals(publisher);
			case CommonPackage.DUBLIN_CORE__COVERAGE:
				return COVERAGE_EDEFAULT == null ? coverage != null : !COVERAGE_EDEFAULT.equals(coverage);
			case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
				return CONTRIBUTOR_EDEFAULT == null ? contributor != null : !CONTRIBUTOR_EDEFAULT.equals(contributor);
			case CommonPackage.DUBLIN_CORE__RELATION:
				return RELATION_EDEFAULT == null ? relation != null : !RELATION_EDEFAULT.equals(relation);
			case CommonPackage.DUBLIN_CORE__RIGHTS:
				return RIGHTS_EDEFAULT == null ? rights != null : !RIGHTS_EDEFAULT.equals(rights);
			case CommonPackage.DUBLIN_CORE__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case CommonPackage.DUBLIN_CORE__SUBJECT:
				return SUBJECT_EDEFAULT == null ? subject != null : !SUBJECT_EDEFAULT.equals(subject);
			case CommonPackage.DUBLIN_CORE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case CommonPackage.DUBLIN_CORE__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				return BIBLIOGRAPHIC_CITATION_EDEFAULT == null ? bibliographicCitation != null : !BIBLIOGRAPHIC_CITATION_EDEFAULT.equals(bibliographicCitation);
			case CommonPackage.DUBLIN_CORE__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case CommonPackage.DUBLIN_CORE__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
			case CommonPackage.DUBLIN_CORE__REQUIRED:
				return REQUIRED_EDEFAULT == null ? required != null : !REQUIRED_EDEFAULT.equals(required);
			case CommonPackage.DUBLIN_CORE__SPATIAL:
				return SPATIAL_EDEFAULT == null ? spatial != null : !SPATIAL_EDEFAULT.equals(spatial);
			case CommonPackage.DUBLIN_CORE__VALID:
				return VALID_EDEFAULT == null ? valid != null : !VALID_EDEFAULT.equals(valid);
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
		if (getRequired() != null && !getRequired().equals("")) {
			result.append("required=\"");
			result.append(getRequired().trim());
			result.append("\" ");
		}
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

	/**
	 * Create a date string that conforms to ISO&nbsp;8601 <a
	 * href="http://www.w3.org/TR/NOTE-datetime">
	 * http://www.w3.org/TR/NOTE-datetime</a>.
	 * <ul>
	 * <li>Example:</li>
	 * 2006-03-29
	 * </ul>
	 * 
	 * @see #getDate()
	 * @see #getCreated()
	 * @see #getValid()
	 */
	public static String createISO8601DateString(final Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	} // createISO8601DateString

	/**
	 * Create a Date from a string that conforms to ISO&nbsp;8601 <a
	 * href="http://www.w3.org/TR/NOTE-datetime">
	 * http://www.w3.org/TR/NOTE-datetime</a>.
	 * <ul>
	 * <li>Example:</li>
	 * 2006-03-29
	 * </ul>
	 * 
	 * @throws ParseException
	 *             if the date string is not of the format "yyyy-MM-dd"
	 * @see #getDate()
	 * @see #getCreated()
	 * @see #getValid()
	 */
	public static Date createDateFromISO8601DateString(
			final String iso8601DateString) throws ParseException {
		return (new SimpleDateFormat("yyyy-MM-dd")).parse(iso8601DateString);
	} // createDateFromISO8601DateString

} // DublinCoreImpl

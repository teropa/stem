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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
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
public class DublinCoreImpl extends CDOObjectImpl implements DublinCore {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

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
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISHER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCoverage() <em>Coverage</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final String COVERAGE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getContributor() <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTRIBUTOR_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_EDEFAULT = null;

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
	 * The default value of the '{@link #getSubject() <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBibliographicCitation() <em>Bibliographic Citation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBibliographicCitation()
	 * @generated
	 * @ordered
	 */
	protected static final String BIBLIOGRAPHIC_CITATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSpatial() <em>Spatial</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSpatial()
	 * @generated
	 * @ordered
	 */
	protected static final String SPATIAL_EDEFAULT = null;

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
		super();
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
		setBibliographicCitation(configElement
				.getAttribute("bibliographicCitation"));
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
	public String getTitle() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__TITLE, CommonPackage.Literals.DUBLIN_CORE__TITLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__TITLE, CommonPackage.Literals.DUBLIN_CORE__TITLE, newTitle);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreator() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__CREATOR, CommonPackage.Literals.DUBLIN_CORE__CREATOR, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreator(String newCreator) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__CREATOR, CommonPackage.Literals.DUBLIN_CORE__CREATOR, newCreator);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubject() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__SUBJECT, CommonPackage.Literals.DUBLIN_CORE__SUBJECT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(String newSubject) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__SUBJECT, CommonPackage.Literals.DUBLIN_CORE__SUBJECT, newSubject);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__DESCRIPTION, CommonPackage.Literals.DUBLIN_CORE__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__DESCRIPTION, CommonPackage.Literals.DUBLIN_CORE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublisher() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__PUBLISHER, CommonPackage.Literals.DUBLIN_CORE__PUBLISHER, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(String newPublisher) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__PUBLISHER, CommonPackage.Literals.DUBLIN_CORE__PUBLISHER, newPublisher);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContributor() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__CONTRIBUTOR, CommonPackage.Literals.DUBLIN_CORE__CONTRIBUTOR, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributor(String newContributor) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__CONTRIBUTOR, CommonPackage.Literals.DUBLIN_CORE__CONTRIBUTOR, newContributor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__DATE, CommonPackage.Literals.DUBLIN_CORE__DATE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__DATE, CommonPackage.Literals.DUBLIN_CORE__DATE, newDate);
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
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__TYPE, CommonPackage.Literals.DUBLIN_CORE__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__TYPE, CommonPackage.Literals.DUBLIN_CORE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__FORMAT, CommonPackage.Literals.DUBLIN_CORE__FORMAT, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__FORMAT, CommonPackage.Literals.DUBLIN_CORE__FORMAT, newFormat);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__IDENTIFIER, CommonPackage.Literals.DUBLIN_CORE__IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__IDENTIFIER, CommonPackage.Literals.DUBLIN_CORE__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__SOURCE, CommonPackage.Literals.DUBLIN_CORE__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__SOURCE, CommonPackage.Literals.DUBLIN_CORE__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__LANGUAGE, CommonPackage.Literals.DUBLIN_CORE__LANGUAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__LANGUAGE, CommonPackage.Literals.DUBLIN_CORE__LANGUAGE, newLanguage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelation() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__RELATION, CommonPackage.Literals.DUBLIN_CORE__RELATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(String newRelation) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__RELATION, CommonPackage.Literals.DUBLIN_CORE__RELATION, newRelation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoverage() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__COVERAGE, CommonPackage.Literals.DUBLIN_CORE__COVERAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoverage(String newCoverage) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__COVERAGE, CommonPackage.Literals.DUBLIN_CORE__COVERAGE, newCoverage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRights() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__RIGHTS, CommonPackage.Literals.DUBLIN_CORE__RIGHTS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRights(String newRights) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__RIGHTS, CommonPackage.Literals.DUBLIN_CORE__RIGHTS, newRights);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBibliographicCitation() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, CommonPackage.Literals.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBibliographicCitation(String newBibliographicCitation) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, CommonPackage.Literals.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION, newBibliographicCitation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreated() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__CREATED, CommonPackage.Literals.DUBLIN_CORE__CREATED, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(String newCreated) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__CREATED, CommonPackage.Literals.DUBLIN_CORE__CREATED, newCreated);
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
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__LICENSE, CommonPackage.Literals.DUBLIN_CORE__LICENSE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__LICENSE, CommonPackage.Literals.DUBLIN_CORE__LICENSE, newLicense);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequired() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__REQUIRED, CommonPackage.Literals.DUBLIN_CORE__REQUIRED, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(String newRequired) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__REQUIRED, CommonPackage.Literals.DUBLIN_CORE__REQUIRED, newRequired);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpatial() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__SPATIAL, CommonPackage.Literals.DUBLIN_CORE__SPATIAL, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpatial(String newSpatial) {
		eDynamicSet(CommonPackage.DUBLIN_CORE__SPATIAL, CommonPackage.Literals.DUBLIN_CORE__SPATIAL, newSpatial);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValid() {
		return (String)eDynamicGet(CommonPackage.DUBLIN_CORE__VALID, CommonPackage.Literals.DUBLIN_CORE__VALID, true, true);
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
		eDynamicSet(CommonPackage.DUBLIN_CORE__VALID, CommonPackage.Literals.DUBLIN_CORE__VALID, newValid);
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
				return TITLE_EDEFAULT == null ? getTitle() != null : !TITLE_EDEFAULT.equals(getTitle());
			case CommonPackage.DUBLIN_CORE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? getIdentifier() != null : !IDENTIFIER_EDEFAULT.equals(getIdentifier());
			case CommonPackage.DUBLIN_CORE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case CommonPackage.DUBLIN_CORE__CREATOR:
				return CREATOR_EDEFAULT == null ? getCreator() != null : !CREATOR_EDEFAULT.equals(getCreator());
			case CommonPackage.DUBLIN_CORE__DATE:
				return DATE_EDEFAULT == null ? getDate() != null : !DATE_EDEFAULT.equals(getDate());
			case CommonPackage.DUBLIN_CORE__FORMAT:
				return FORMAT_EDEFAULT == null ? getFormat() != null : !FORMAT_EDEFAULT.equals(getFormat());
			case CommonPackage.DUBLIN_CORE__PUBLISHER:
				return PUBLISHER_EDEFAULT == null ? getPublisher() != null : !PUBLISHER_EDEFAULT.equals(getPublisher());
			case CommonPackage.DUBLIN_CORE__COVERAGE:
				return COVERAGE_EDEFAULT == null ? getCoverage() != null : !COVERAGE_EDEFAULT.equals(getCoverage());
			case CommonPackage.DUBLIN_CORE__CONTRIBUTOR:
				return CONTRIBUTOR_EDEFAULT == null ? getContributor() != null : !CONTRIBUTOR_EDEFAULT.equals(getContributor());
			case CommonPackage.DUBLIN_CORE__RELATION:
				return RELATION_EDEFAULT == null ? getRelation() != null : !RELATION_EDEFAULT.equals(getRelation());
			case CommonPackage.DUBLIN_CORE__RIGHTS:
				return RIGHTS_EDEFAULT == null ? getRights() != null : !RIGHTS_EDEFAULT.equals(getRights());
			case CommonPackage.DUBLIN_CORE__SOURCE:
				return SOURCE_EDEFAULT == null ? getSource() != null : !SOURCE_EDEFAULT.equals(getSource());
			case CommonPackage.DUBLIN_CORE__SUBJECT:
				return SUBJECT_EDEFAULT == null ? getSubject() != null : !SUBJECT_EDEFAULT.equals(getSubject());
			case CommonPackage.DUBLIN_CORE__TYPE:
				return TYPE_EDEFAULT == null ? getType() != null : !TYPE_EDEFAULT.equals(getType());
			case CommonPackage.DUBLIN_CORE__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? getLanguage() != null : !LANGUAGE_EDEFAULT.equals(getLanguage());
			case CommonPackage.DUBLIN_CORE__BIBLIOGRAPHIC_CITATION:
				return BIBLIOGRAPHIC_CITATION_EDEFAULT == null ? getBibliographicCitation() != null : !BIBLIOGRAPHIC_CITATION_EDEFAULT.equals(getBibliographicCitation());
			case CommonPackage.DUBLIN_CORE__CREATED:
				return CREATED_EDEFAULT == null ? getCreated() != null : !CREATED_EDEFAULT.equals(getCreated());
			case CommonPackage.DUBLIN_CORE__LICENSE:
				return LICENSE_EDEFAULT == null ? getLicense() != null : !LICENSE_EDEFAULT.equals(getLicense());
			case CommonPackage.DUBLIN_CORE__REQUIRED:
				return REQUIRED_EDEFAULT == null ? getRequired() != null : !REQUIRED_EDEFAULT.equals(getRequired());
			case CommonPackage.DUBLIN_CORE__SPATIAL:
				return SPATIAL_EDEFAULT == null ? getSpatial() != null : !SPATIAL_EDEFAULT.equals(getSpatial());
			case CommonPackage.DUBLIN_CORE__VALID:
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

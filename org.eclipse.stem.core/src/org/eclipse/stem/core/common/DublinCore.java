// DublinCore.java
package org.eclipse.stem.core.common;

/******************************************************************************* 
 * Copyright (c) 2006, 2009 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * A <code>DublinCore</code> instance records a set of attributes that describe
 * a "resource" as defined in the "Dublin Core" metadata standard <a
 * href="http://www.dublincore.org/" >http://www.dublincore.org/</a>. These
 * attributes are used to specify the source and details of the various
 * components that are combined to create the canonical {@link Graph} that is
 * used in STEM as the representational framework for simulation state.
 * <p>
 * Note that not all of the dublin core attributes are required.
 * </p>
 * 
 * @model
 */
public interface DublinCore extends EObject {

	/**
	 * The XML attribute name for the "Format" of the resource.
	 * 
	 * @see #getFormat()
	 * @see #setFormat(String)
	 */
	String FORMAT = "format";

	/**
	 * The XML attribute name for the "Identifier" of the resource. In STEM this
	 * is the URI of the resource.
	 * 
	 * @see #getIdentifier()
	 * @see #setIdentifier(String)
	 */
	String IDENTIFIER = "identifier";

	/**
	 * The XML attribute name for the "Title" of the resource.
	 * 
	 * @see #getTitle()
	 * @see #setTitle(String)
	 */
	String TITLE = "title";

	/**
	 * <h1>Title</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "A name given to the resource"
	 * <li>Comment:</li>
	 * Usually the formal name of the resource.
	 * <li>Example:</li>
	 * "United States Administration Level 0"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/title">
	 * http://purl.org/dc/elements/1.1/title</a>
	 * </ul>
	 * 
	 * @return the title of the resource.
	 * @model required="false"
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * <h1>Identifier</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "An unambiguous reference to the resource within a given context."
	 * <li>Comment:</li>
	 * The URL of the resource.
	 * <li>Example:</li>
	 * "stem://org.eclipse.stem/stem/foo"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/identifier">
	 * http://purl.org/dc/elements/1.1/identifier</a>
	 * </ul>
	 * 
	 * @return the identifier of the resource.
	 * @model required="false"
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * <h1>Description</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "An account of the content of the resource."
	 * <li>Comment:</li>
	 * Typically a short abstract.
	 * <li>Example:</li>
	 * "All of the cattle farms in the U.K. as of 2006."
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/description">
	 * http://purl.org/dc/elements/1.1/description</a>
	 * </ul>
	 * 
	 * @return the description of the resource.
	 * @model required="false"
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * <h1>Creator</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "An entity primarily responsible for making the content of the resource."
	 * <li>Comment:</li>
	 * Typically the name of a person or organization.
	 * <li>Example:</li>
	 * "IBM"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/creator">
	 * http://purl.org/dc/elements/1.1/creator</a>
	 * </ul>
	 * 
	 * @return the creator of the resource.
	 * @model required="false"
	 */
	String getCreator();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getCreator
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
	 * <h1>Date</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "A date associated with an event in the life cycle of the resource."
	 * <li>Comment:</li>
	 * Typically YYYY-MM-DD. See: <a href="http://www.w3.org/TR/NOTE-datetime">
	 * http://www.w3.org/TR/NOTE-datetime</a>, also ISO&nbsp;8601.
	 * <li>Example:</li>
	 * "2006-03-14"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/date">
	 * http://purl.org/dc/elements/1.1/date</a>
	 * </ul>
	 * 
	 * @return the date of the resource.
	 * @model required="false"
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Set the date.
	 * 
	 * @param date
	 * 
	 * @see #setDate(String)
	 * @see #getDate()
	 * @see #setCreated(Date)
	 */
	void setDate(final Date date);

	/**
	 * <h1>Format</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "The physical or digital manifestation of the resource."
	 * <li>Comment:</li>
	 * A MIME type perhaps.
	 * <li>Example:</li> ?
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/format">
	 * http://purl.org/dc/elements/1.1/format</a>
	 * </ul>
	 * 
	 * @return the format of the resource.
	 * @model required="false"
	 */
	String getFormat();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getFormat
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
	 * <h1>Publisher</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "An entity responsible for making the resource available."
	 * <li>Comment:</li>
	 * Typically the name of a person, organization or service.
	 * <li>Example:</li>
	 * "IBM"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/publisher">
	 * http://purl.org/dc/elements/1.1/publisher</a>
	 * </ul>
	 * 
	 * @return the publisher of the resource.
	 * @model required="false"
	 */
	String getPublisher();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getPublisher
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
	 * <h1>Coverage</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "The extent or scope of the content of the resource."
	 * <li>Comment:</li>
	 * Could include spatial location, temporal period (date or date range),
	 * jurisdiction. See, the <a
	 * href="http://www.dublincore.org/documents/dcmi-point/"> DCMI Point </a>,
	 * <a href="http://www.getty.edu/research/tools/vocabulary/tgn/index.html">
	 * Thesaurus of Geographic Names</a>, <a
	 * href="http://www.dublincore.org/documents/dcmi-period/">DCMI Period</a>
	 * <li>Example:</li>
	 * "United States UN Administration level 2, 1900"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/coverage">
	 * http://purl.org/dc/elements/1.1/coverage</a>
	 * </ul>
	 * 
	 * @return the coverage of the resource.
	 * @model required="false"
	 */
	String getCoverage();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getCoverage
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
	 * <h1>Contributor</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "An entity responsible for making contributions to the resource"
	 * <li>Comment:</li>
	 * Typically the name of a person, organization or service.
	 * <li>Example:</li>
	 * "IBM"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/contributor">
	 * http://purl.org/dc/elements/1.1/contributor</a>
	 * </ul>
	 * 
	 * @return the contributor of the resource.
	 * @model required="false"
	 */
	String getContributor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getContributor <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' attribute.
	 * @see #getContributor()
	 * @generated
	 */
	void setContributor(String value);

	/**
	 * <h1>Relation</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "A reference to a related resource."
	 * <li>Comment:</li>
	 * Perhaps a URL?
	 * <li>Example:</li> ?
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/relation">
	 * http://purl.org/dc/elements/1.1/relation</a>
	 * </ul>
	 * 
	 * @return the relation of the resource.
	 * @model required="false"
	 */
	String getRelation();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getRelation
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
	 * <h1>Rights</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "Information about rights held in and over the resource."
	 * <li>Comment:</li>
	 * Typically, a rights management statement.
	 * <li>Example:</li>
	 * &#169;IBM 2006
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/rights">
	 * http://purl.org/dc/elements/1.1/rights</a>
	 * </ul>
	 * 
	 * @return the rights of the resource.
	 * @model required="false"
	 */
	String getRights();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getRights
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
	 * <h1>Source</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "A reference to a resource from which the present resource is derived."
	 * <li>Comment:</li>
	 * The original source of the contents of the resource.
	 * <li>Example:</li>
	 * "US Tiger files"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/source">
	 * http://purl.org/dc/elements/1.1/source</a>
	 * </ul>
	 * 
	 * @return the source of the resource.
	 * @model required="false"
	 */
	String getSource();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getSource
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
	 * <h1>Subject</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "The topic of the content of the resource"
	 * <li>Comment:</li>
	 * Typically keywords or classification codes.
	 * <li>Example:</li> ?
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/subject">
	 * http://purl.org/dc/elements/1.1/subject</a>
	 * </ul>
	 * 
	 * @return the subject of the resource.
	 * @model required="false"
	 */
	String getSubject();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getSubject
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
	 * <h1>Type</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "The nature or genre of the resource."
	 * <li>Comment:</li>
	 * See: <a
	 * href="http://dublincore.org/documents/dcmi-type-vocabulary/">http:
	 * //dublincore.org/documents/dcmi-type-vocabulary/</a>
	 * <li>Example:</li> ?
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/type">
	 * http://purl.org/dc/elements/1.1/type</a>
	 * </ul>
	 * 
	 * @return the type of the resource.
	 * @model required="false"
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * <h1>Language</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "A language of the intellectual content of the resource."
	 * <li>Comment:</li>
	 * Best practice <a href="http://www.ietf.org/rfc/rfc3066.txt"> RFC 3066</a>
	 * and <a href="http://www.loc.gov/standards/iso639-2/">ISO 639</a>
	 * <li>Example:</li>
	 * "en-GB"
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/elements/1.1/language">
	 * http://purl.org/dc/elements/1.1/language</a>
	 * </ul>
	 * 
	 * @return the language of the resource.
	 * @model required="false"
	 */
	String getLanguage();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getLanguage
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
	 * h1>Bibliographic Citation</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "A bibliographic reference for the resource."
	 * <li>Comment:</li>
	 * 
	 * <li>Example:</li>
	 * Ford, D.A., "STEM and the art of computer maintenance", Journal of
	 * Foobar, 2006.
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/terms/1.1/bibliographicCitation">
	 * http://purl.org/dc/terms/1.1/bibliographicCitation</a>
	 * </ul>
	 * 
	 * @return a bibliographic citation
	 * @model required="false"
	 */
	String getBibliographicCitation();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getBibliographicCitation <em>Bibliographic Citation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Bibliographic Citation</em>' attribute.
	 * @see #getBibliographicCitation()
	 * @generated
	 */
	void setBibliographicCitation(String value);

	/**
	 * h1>Created</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "The creation date of the resource."
	 * <li>Comment:</li>
	 * Basically, the format is: YYYY-MM-DD
	 * <li>Example:</li>
	 * 2006-03-29
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/terms/1.1/created">
	 * http://purl.org/dc/terms/1.1/created</a>
	 * </ul>
	 * 
	 * @return the date the resource was created.
	 * @model required="false"
	 */
	String getCreated();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getCreated
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
	 * Set the date the resource was created.
	 * 
	 * @param date
	 *            the creation date of the resource
	 * 
	 * @see #setCreated(String)
	 * @see #getCreated()
	 * @see #setDate(Date)
	 * @see
	 */
	void setCreated(final Date date);

	/**
	 * h1>License</h1>
	 * <ul>
	 * <li>Definition:</li>
	 *"A legal document giving official permission to do something with the
	 * resource."
	 * <li>Comment:</li>
	 * Best practice is to use a URI to the specific license.
	 * <li>Example:</li>
	 * http://creativecommons.org/license/
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/terms/1.1/license">
	 * http://purl.org/dc/terms/1.1/license</a>
	 * </ul>
	 * 
	 * @return the license associated with the resource
	 * @model required="false"
	 */
	String getLicense();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getLicense
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
	 * h1>Requires</h1>
	 * <ul>
	 * <li>Definition:</li>
	 *"The described resource requires the referenced resource to support its
	 * function, delivery, or coherence of content."
	 * <li>Comment:</li>
	 * In STEM this is the URI that is the identifier of the required resource.
	 * <li>Example:</li>
	 * stem:/graphs/sample/sample1.graph
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/terms/1.1/requires">
	 * http://purl.org/dc/terms/1.1/requires</a>
	 * </ul>
	 * 
	 * @return the identifier of a resource required by this resource
	 * @model required="false"
	 */
	String getRequired();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getRequired
	 * <em>Required</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Required</em>' attribute.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(String value);

	/**
	 * h1>Spatial</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "Spatial characteristics of the intellectual content of the resource."
	 * <li>Comment:</li>
	 * See <a href="http://www.dublincore.org/documents/dcmi-point/">
	 * http://www.dublincore.org/documents/dcmi-point/</a> However, this should
	 * probably be a URI to a file that contains the actual lat/long data that
	 * describes a polygon that defines the spatial outline of a place.
	 * <li>Example:</li> ?
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/terms/1.1/spatial">
	 * http://purl.org/dc/terms/1.1/spatial</a>
	 * </ul>
	 * 
	 * @return the identifier of a resource providing spatial data
	 * @model required="false"
	 */
	String getSpatial();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.stem.core.common.DublinCore#getSpatial
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
	 * <h1>Valid</h1>
	 * <ul>
	 * <li>Definition:</li>
	 * "Date (often a range) of validity of a resource."
	 * <li>Comment:</li>
	 * See encoded in ISO&nbsp;8601 <a
	 * href="http://www.w3.org/TR/NOTE-datetime">
	 * http://www.w3.org/TR/NOTE-datetime</a>.
	 * <li>Example:</li>
	 * start=2006-03-29; end=2006-03-30; or simply start=2006-03-29; if there is
	 * no end to the validity
	 * <li>URI:</li>
	 * <a href="http://purl.org/dc/terms/1.1/valid">
	 * http://purl.org/dc/terms/1.1/valid</a>
	 * </ul>
	 * 
	 * @return the date, or range that the resource is valid.
	 * @model required="false"
	 */
	String getValid();

	/**
	 * @return the starting {@link Date} of the valid date range, or
	 *         <code>null</code> if the valid value is not set or is not
	 *         correctly formatted as an ISO&nbsp;8601 date string <a
	 *         href="http://www.w3.org/TR/NOTE-datetime">
	 *         http://www.w3.org/TR/NOTE-datetime</a>.
	 */
	Date getValidStartDate();

	/**
	 * @return the ending {@link Date} of the valid date range, or
	 *         <code>null</code> if the valid value is not set or the end date
	 *         is not specified, or the value is not correctly formatted as an
	 *         ISO&nbsp;8601 date string <a
	 *         href="http://www.w3.org/TR/NOTE-datetime">
	 *         http://www.w3.org/TR/NOTE-datetime</a>.
	 */
	Date getValidEndDate();

	/**
	 * @param dublinCore
	 * @return <code>true</code> if the start date of the valid date range
	 *         attribute is before the start date of the passed
	 *         {@link DublinCore} instance's valid date range, or, if the passed
	 *         instance is <code>null</code>, <code>false</code> otherwise.
	 *         Also, <code>false</code> is returned if either instance does not
	 *         specify a valid date range.
	 * 
	 * @see DublinCore#getValid()
	 */
	boolean isValidBefore(DublinCore dublinCore);

	/**
	 * Compute the extent of the overlap of the valid date range of this
	 * instance with that of the passed instance. If only one instance has a
	 * valid data range specified that will be returned.
	 * 
	 * @param dublinCore
	 * @return 0-start date of new range, 1-end date of new range, or
	 *         <code>null</code> if there is no overlap.
	 */
	Date[] computeValidDateRangeOverlap(DublinCore dublinCore);
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.common.DublinCore#getValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #getValid()
	 * @generated
	 */
	void setValid(String value);

	/**
	 * Set the starting date that the resource is value. No end date will be
	 * set.
	 * 
	 * @param startDate
	 *            the starting date
	 * 
	 * @see #setValid(String)
	 * @see #setValid(Date, Date)
	 * @see #setDate(Date)
	 * @see #setCreated(Date)
	 */
	void setValid(final Date startDate);

	/**
	 * Set the starting and ending dates that the resource is valid.
	 * 
	 * @param startDate
	 *            the starting date
	 * @param endDate
	 *            the ending date
	 * 
	 * @see #setValid(String)
	 * @see #setValid(Date)
	 * @see #setDate(Date)
	 * @see #setCreated(Date)
	 */
	void setValid(final Date startDate, final Date endDate);

	/**
	 * Initialize some of the Dublin Core terms from information available from
	 * the run-time environment.
	 * <ul>
	 * <li><code>Created</code> is set to the current date (e.g., 2006-06-02)</li>
	 * <li><code>Creator</code> is set to the value returned by
	 * <code>System.getProperty("user.name")</code> (e.g., <code>daford</code>)
	 * </ul>
	 * 
	 * @return the instance
	 * 
	 * @see #setCreated(String)
	 * @see #setDate(String)
	 * @see #setValid(String)
	 * @see #setCreator(String)
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	DublinCore populate();
} // DublinCore

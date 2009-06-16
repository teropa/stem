// Record.java
package org.eclipse.stem.internal.data.specifications;

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

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.CommonFactory;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;

/**
 * This class represents the specification of an
 * {@link org.eclipse.stem.core.common.Identifiable} that can be used to
 * create an instance of one. The specification could come from a property file,
 * or could be generated programmatically.
 */
@SuppressWarnings("deprecation")
abstract public class IdentifiableSpecification {

	/**
	 * This is a static instance used when serializing instances.
	 */
	protected static final URIConverter converter = new URIConverterImpl();

	/**
	 * This is a static instance used when formatting the start and end dates.
	 * 
	 * @see #createValidDateRangeString(DateFormat, String)
	 * @see #SERIALIZATION_DATE_RANGE_FORMAT_2_DATES
	 */
	protected static final DateFormat SERIALIZATION_CONTENT_DESCRIPTOR_DATE_FORMATER = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * This is the format used to create date range strings used in file and
	 * folder names.
	 * 
	 */
	public static final String SERIALIZATION_DATE_RANGE_FORMAT_2_DATES = "{0}{1}";

	/**
	 * This is the format used to create date range strings used in file and
	 * folder names.
	 * 
	 */
	public static final String SERIALIZATION_DATE_RANGE_FORMAT_1_DATE = "{0}";

	/**
	 * This is the format used to create date range strings used in file and
	 * folder names.
	 * 
	 */
	public static final String SERIALIZATION_DATE_RANGE_FORMAT_1_DATE_YEAR = "{0}";

	/**
	 * The {@link Identifiable} that this instance specifies. This is created on
	 * demand when there is a call to {@link #getIdentifiable()}
	 * 
	 * @see #createIdentifiable()
	 */
	protected Identifiable identifiable = null;

	/**
	 * The {@link DublinCore} metadata for the {@link Identifiable}. The values
	 * for this are collected from the data properties files before the
	 * {@link Identifiable} is created.
	 * 
	 * @see #collectNonDataProperties(Properties)
	 */
	protected DublinCore dublinCore = null;

	/**
	 * Default constructor
	 */
	protected IdentifiableSpecification() {
		dublinCore = CommonFactory.eINSTANCE.createDublinCore();
		dublinCore.populate();
	} // IdentifiableSpecification

	/**
	 * @param startDate
	 *            the starting date that the IdentifiableSpecification's
	 *            contents are valid
	 */
	protected IdentifiableSpecification(final Date startDate) {
		this();
		setStartDate(startDate);
	} // IdentifiableSpecification

	/**
	 * @param startDate
	 *            the starting date that the IdentifiableSpecification's
	 *            contents are valid
	 * @param endDate
	 *            the ending date that the IdentifiableSpecification's contents
	 *            are valid
	 */
	protected IdentifiableSpecification(final Date startDate, final Date endDate) {
		this(startDate);
		setEndDate(endDate);
	} // IdentifiableSpecification

	/**
	 * @return the {@link Identifiable} that this instance specifies, creating
	 *         it if necessary.
	 */
	public final Identifiable getIdentifiable() {
		// Have we created the Identifiable yet?
		if (identifiable == null) {
			// No
			identifiable = createIdentifiable();

			// Is the Identifiable sane?
			if (!identifiable.sane()) {
				// No
				System.out.println(identifiable.getDublinCore().getTitle()
						+ " is not sane!!");
			} // if not sane

			// We set the title and description last because they might be
			// created out of some of the values we just populated.

			// Is the Dublin Core title set yet?
			if (identifiable.getDublinCore().getTitle() == null
					|| identifiable.getDublinCore().getTitle().equals("")) {
				// No
				identifiable.getDublinCore().setTitle(createDublinCoreTitle());
			}

			// Is the Dublin Core description set?
			if (identifiable.getDublinCore().getDescription() == null
					|| identifiable.getDublinCore().getDescription().equals("")) {
				// No
				identifiable.getDublinCore().setDescription(
						createDublinCoreDescription());
			}

			// We override the coverage, type and subject because some graphs
			// compute them for later consumption by the model generation
			// process
			identifiable.getDublinCore().setCoverage(createDubinCoreCoverage());
			identifiable.getDublinCore().setSubject(createDubinCoreSubject());
		} // if

		return identifiable;
	} // getIdentifiable

	/**
	 * @return a new {@link Identifiable} created from the specification.
	 * @see #createIdentifiableInstance()
	 */
	protected Identifiable createIdentifiable() {
		final Identifiable retValue = createIdentifiableInstance();
		retValue.setDublinCore(dublinCore);
		retValue.setURI(createPlatformURI());
		return retValue;
	} // createIdentifiable

	/**
	 * @return an uninitialized instance of {@link Identifiable}
	 */
	abstract protected Identifiable createIdentifiableInstance();

	/**
	 * @return the dublinCore
	 */
	public final DublinCore getDublinCore() {
		return dublinCore;
	}

	/**
	 * @param dublinCore
	 *            the new {@link DublinCore} value to use for the specified
	 *            {@link Identifiable}.
	 */
	public final void setDublinCore(final DublinCore dublinCore) {
		this.dublinCore = dublinCore;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public final void setEndDate(final Date endDate) {
		dublinCore.setValid(dublinCore.getValidStartDate(), endDate);
	} // setEndDate

	/**
	 * @return the endDate
	 */
	public final Date getEndDate() {
		return dublinCore.getValidEndDate();
	} // getEndDate

	/**
	 * @return the startDate
	 */
	public final Date getStartDate() {
		return dublinCore.getValidStartDate();
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public final void setStartDate(final Date startDate) {
		dublinCore.setValid(startDate);
	} // setStartDate

	/**
	 * @param startDate
	 *            the start date of the date range
	 * @param endDate
	 *            the end date of the date range
	 * @return <code>true</code> if the date range of this
	 *         IdentifiableSpecification overlaps the test range,
	 *         <code>false</code> otherwise.
	 */
	@SuppressWarnings("null")
	public boolean inDateRange(final Date startDate, final Date endDate) {

		final Date ourStartDate = getStartDate();
		final Date ourEndDate = getEndDate();
		boolean retValue = (ourStartDate == null || startDate == null)
				|| ((ourStartDate.equals(startDate) || ourStartDate
						.after(startDate)) && (endDate == null
						|| ourStartDate.equals(endDate) || ourStartDate
						.before(endDate)));

		retValue = retValue
				|| (ourStartDate.before(startDate) && (ourEndDate == null
						|| ourEndDate.equals(startDate) || ourEndDate
						.after(startDate)));

		return retValue;
	} // inDateRange

	/**
	 * @param identifiableSpecification
	 *            the <code>IdentifiableSpecification</code> to test against
	 * @return <code>true</code> if the start date of this specification's
	 *         {@link DublinCore} valid date range attribute is before the start
	 *         data of the passed <code>identifiableSpecification</code>'s
	 *         {@link DublinCore} valid date range, or, if
	 *         <code>identifiableSpecification</code> is <code>null</code>,
	 *         <code>false</code> otherwise.
	 */
	public boolean isValidBefore(
			final IdentifiableSpecification identifiableSpecification) {
		return getDublinCore().isValidBefore(
				identifiableSpecification.getDublinCore());
	} // isValidBefore

	/**
	 * Modify the date range to be the most narrow between this
	 * {@link Identifiable} and the one passed in. For example, if this range is
	 * from 2000 to 2010 and the other range is from 2005 to 2015, the new range
	 * would be from 2005 to 2010.
	 * 
	 * @param identifiableSpecification
	 *            the owner of the date range
	 */
	protected void updateDateRange(
			final IdentifiableSpecification identifiableSpecification) {

		final Date[] overLapingValidDateRange = getDublinCore()
				.computeValidDateRangeOverlap(
						identifiableSpecification.getDublinCore());
		// Is there an overlapping range?
		if (overLapingValidDateRange != null) {
			// Yes
			setStartDate(overLapingValidDateRange[0]);
			setEndDate(overLapingValidDateRange[1]);
		}
	} // updateDateRange

	// /**
	// * @return the number of {@link org.eclipse.stem.core.graph.Node}s in
	// * the {@link Identifiable}
	// */
	// public int getNumNodes() {
	// return 0;
	// }
	//
	// /**
	// * @return the number of {@link org.eclipse.stem.core.graph.Edge}s in
	// * the {@link Identifiable}
	// */
	// public int getNumEdges() {
	// return 0;
	// }
	//
	// /**
	// * @return the number of {@link org.eclipse.stem.core.graph.Label}s in
	// * the {@link Identifiable}
	// */
	// public int getNumLabels() {
	// return 0;
	// }
	//
	// /**
	// * @return the number of {@link Model}
	// * {@link org.eclipse.stem.core.model.Decorator}s in the
	// * {@link Identifiable}
	// */
	// public int getNumModelDecorators() {
	// return 0;
	// } // getNumDecorators
	//
	// /**
	// * @return the number of {@link Scenario}
	// * {@link org.eclipse.stem.core.model.Decorator}s in the
	// * {@link Identifiable}
	// */
	// public int getNumScenarioDecorators() {
	// return 0;
	// }

	/**
	 * @param pluginURI
	 * @return convert to a resource URI
	 */
	public static String convertToProjectURI(String pluginURI) {
		return pluginURI.replace("plugin", "resource"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * @param dc
	 * @return the project (resource) URI from the plugin URI
	 */
	public static URI getIdentifiableProjectURI(org.eclipse.stem.internal.data.generatedplugin.DublinCore dc) {
		return URI
				.createURI(convertToProjectURI(dc
						.getIdentifier()));
	} // getIdentifiableProjectURI
	
	/**
	 * @param directory
	 *            this is the root directory that the
	 *            <code>IdentifiableSpecification</code> should serialize the
	 *            {@link Identifiable} it creates. Typically, the file will be
	 *            in a sub-directory.
	 * @throws IOException
	 *             if there was a problem serializing.
	 */
	public void serialize(final String directory) throws IOException {
		Utility.serializeIdentifiable(getIdentifiable(), converter
				.normalize(URI.createFileURI(directory + File.separator
						+ getRelativeSerializationPathAndFileName())));
	} // serialize

	/**
	 * @return the relative path and file name of the serialization file for the
	 *         {@link Identifiable}. The path begins with a folder name or is
	 *         the name of the file (e.g., "country/USA/USA_0.graph")
	 */
	protected String getRelativeSerializationPathAndFileName() {
		final StringBuilder sb = new StringBuilder(
				getRelativeSerializationPath());
		sb.append(File.separator);
		sb.append(getSerializationFileNameRoot());
		sb.append(".");
		sb.append(getSerializationFileNameExtension());
		return sb.toString();
	} // getRelativeSerializationPathAndFileName

	/**
	 * @return the relative path to the folder that will contain the
	 *         serialization file (e.g., "country/USA")
	 */
	abstract protected String getRelativeSerializationPath();

	/**
	 * @return the name of the file with out the file name extension that is to
	 *         be used to serialize the {@link Identifiable}(e.g., "USA_0")
	 */
	abstract protected String getSerializationFileNameRoot();

	/**
	 * @return the file name extension to be used when the {@link Identifiable}
	 *         is serialized (e.g., "graph", "model")
	 * @see IdentifiableSpecification#getSerializationFileName()
	 */
	abstract protected String getSerializationFileNameExtension();

	/**
	 * @return a short {@link String} that is descriptive of the
	 *         {@link Identifiable}, suitable to be the title in the
	 *         {@link Identifiable}'s {@link DublinCore}.
	 * @see #createDublinCoreTitle()
	 */
	abstract protected String getTitleDescriptor();

	/**
	 * Examine the {@link #validValue} and create a string that summarizes it
	 * suitable for use in a folder name. The idea is that if the range is
	 * exactly for 1 year, say from January 1, 2006, to December 31, 2006, then
	 * it should return 2006. If not, then it should concatenate the values
	 * together to create a unique (more compact) string for the date range.
	 * 
	 * @param dateFormater
	 *            the formatter that creates the string representation of the
	 *            start and end dates of the data range
	 * 
	 * @return a String that abstracts the valid date range found in the
	 *         {@link org.eclipse.stem.core.common.DublinCore#getValid()}
	 *         date range specification.
	 * 
	 * @see #dublinCore
	 */
	protected String createValidDateRangeString(final DateFormat dateFormater,
			final String oneDateRangeFormat, final String twoDatesRangeFormat,
			final String justYearRangeFormat) {
		String retValue = "";

		final String validValue = dublinCore.getValid();
		final Date startDate = dublinCore.getValidStartDate();
		final Date endDate = dublinCore.getValidEndDate();
		// Is there a valid value?
		if (validValue != null) {
			// Yes
			// Is there a start date?
			if (startDate != null) {
				// Yes
				final Calendar startTime = Calendar.getInstance();
				startTime.setTime(startDate);
				// Is there an end date?
				if (endDate != null) {
					// Yes
					final Calendar endTime = Calendar.getInstance();
					endTime.setTime(endDate);
					// Do they have the same year?
					if (startTime.get(Calendar.YEAR) == endTime
							.get(Calendar.YEAR)) {
						// Yes
						// Is the start date January 1 and the end data December
						// 31?
						if ((startTime.get(Calendar.MONTH) == Calendar.JANUARY && startTime
								.get(Calendar.DAY_OF_MONTH) == 1)
								&& (endTime.get(Calendar.MONTH) == Calendar.DECEMBER && endTime
										.get(Calendar.DAY_OF_MONTH) == 31)) {
							// Yes
							// Just use the year as the value
							// sb.append(startTime.get(Calendar.YEAR));
							retValue = MessageFormat.format(
									justYearRangeFormat, new Object[] { Integer
											.toString(startTime
													.get(Calendar.YEAR)) });
						} // if Jan 1 to Dec 31
						else {
							// No
							// Not a full year
							retValue = MessageFormat.format(
									twoDatesRangeFormat, new Object[] {
											dateFormater.format(startDate),
											dateFormater.format(endDate) });

						} // else
					} // If same year
					else {
						// No
						// Not the same year
						retValue = MessageFormat.format(twoDatesRangeFormat,
								new Object[] { dateFormater.format(startDate),
										dateFormater.format(endDate) });
					} // else
				} // if end date exists
				else {
					// No
					// No end date
					retValue = MessageFormat.format(oneDateRangeFormat,
							new Object[] { dateFormater.format(startDate) });
				}
			} // if start date exists
			// else nothing

		} // if valid value
		return retValue;

	} // createValidDateRangeString

	/**
	 * @return the {@link URI} that uniquely identifies the {@link Identifiable}
	 *         on the platform.
	 */
	protected URI createPlatformURI() {
		final StringBuilder sb = new StringBuilder(getURIPrefix());
		sb.append("/");
		sb.append(getRelativeSerializationPathAndFileName().replace('\\', '/'));
		return URI.createURI(sb.toString());
	} // createGraphPlatformURI

	/**
	 * @return the plugin specific prefix for the {@link Identifiable}
	 */
	protected String getURIPrefix() {
		final StringBuilder sb = new StringBuilder("platform:/plugin/");
		sb.append(getTargetPluginId());
		sb.append("/resources/data");
		return sb.toString();
	} // getURIPrefix

	/**
	 * @return the id of the plugin that will contain the {@link Identifiable}
	 */
	abstract protected String getTargetPluginId();

	/**
	 * Create a title for the {@link Identifiable}
	 */
	protected String createDublinCoreTitle() {
		final String title = dublinCore.getTitle();
		final StringBuilder sb = new StringBuilder(title != null ? title
				: getTitleDescriptor());
		return sb.toString();
	} // createTitle

	/**
	 * Create a string that provides a short summary of the contents of the
	 * <code>Identifiable</code>. This string would be used if a value for the
	 * Dublin Core description attribute is not provided.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getDescription()
	 */
	protected String createDublinCoreDescription() {
		return getContentCountString();
	} // createDublinCoreDescription

	protected String createDubinCoreCoverage() {
		return "";
	} // createDubinCoreCoverage

	protected String createDubinCoreSubject() {
		return "";
	}

	/**
	 * @return a string that summarizes the number of nodes, edges and labels in
	 *         the {@link Identifiable}
	 */
	protected String getContentCountString() {
		final StringBuilder sb = new StringBuilder();
		// final int numAdminLevels = getNumAdminLevels();
		// final int numNodes = getNumNodes();
		// final int numLabels = getNumLabels();
		// final int numEdges = getNumEdges();
		// final int numModelDecorators = getNumModelDecorators();
		// final int numScenarioDecorators = getNumScenarioDecorators();
		//
		// final StringBuilder sb2 = new StringBuilder();

		// Any Admin levels?
		// if (numAdminLevels > 0) {
		// // Yes
		// sb2.append(numAdminLevels);
		// sb2.append(numAdminLevels == 1 ? " Level: " : " Levels: ");
		// sb2.append("&quot;");
		// // sb2.append(getAdminLevelsAsString(", "));
		// sb2.append("&quot;, ");
		// } // if admin levels

		// final StringBuilder sb3 = new StringBuilder();
		//
		// // Any Nodes?
		// if (numNodes > 0) {
		// // Yes
		// sb3.append(numNodes);
		// sb3.append(numNodes == 1 ? " Node" : " Nodes");
		// }
		//
		// // Any Labels?
		// if (numLabels > 0) {
		// // Yes
		// if (numNodes > 0) {
		// sb3.append(", ");
		// }
		// sb3.append(numLabels);
		// sb3.append(numLabels == 1 ? " Label" : " Labels");
		// }
		//
		// // Any Edges?
		// if (numEdges > 0) {
		// // Yes
		// if (numLabels > 0 || numNodes > 0) {
		// sb3.append(", ");
		// }
		// sb3.append(numEdges);
		// sb3.append(" Edges");
		// }
		//
		// // Any model Decorators?
		// if (numModelDecorators > 0) {
		// // Yes
		// if (numEdges > 0 || numLabels > 0 || numNodes > 0) {
		// sb3.append(", ");
		// }
		// sb3.append(numModelDecorators);
		// sb3.append(numModelDecorators == 1 ? " Model Decorator"
		// : " Model Decorators");
		// }
		//
		// // Any scenario Decorators?
		// if (numScenarioDecorators > 0) {
		// // Yes
		// if (numEdges > 0 || numLabels > 0 || numNodes > 0
		// || numModelDecorators > 0) {
		// sb3.append(", ");
		// }
		// sb3.append(numScenarioDecorators);
		// sb3.append(numScenarioDecorators == 1 ? " Scenario Decorator"
		// : " Scenario Decorators");
		// }
		//
		// final String adminString = sb2.toString();
		// final String countString = sb3.toString();
		//
		// sb.append(adminString);
		//
		// sb.append(countString);

		return sb.toString();
	} // getContentCountString

} // IdentifiableSpecification

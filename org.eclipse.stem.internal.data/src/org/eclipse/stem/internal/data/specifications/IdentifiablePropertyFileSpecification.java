// DataSetRecord.java
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.internal.data.propertydata.PropertyData;

/**
 * This class is an {@link IdentifiableSpecification} that is created from a
 * data set defined in a properties file.
 * <p>
 * Each properties file that defines an {@link Identifiable} can include
 * properties that specify the details of the {@link DublinCore} metadata
 * associated with the {@link Identifiable}. This super-class will extract the
 * values of those properties.
 * </p>
 * <p>
 * Sub-classes of this class are defined for each specific type of
 * {@link Identifiable} that can be specified by the contents of a properties
 * file. These sub-classes are responsible for interpreting the contents of
 * their specific type of properties file other than the {@link DublinCore}
 * metadata properties.
 * </p>
 * <p>
 * The fully qualified name of the (sub-) class responsible for processing each
 * properties file is specified as the value of the property RECORD_CLASSNAME
 * {@link #RECORD_CLASSNAME_PROPERTY}. This name is extracted and used to create
 * an instance of the appropriate class which is then given the task of
 * interpreting the property data {@link PropertyData}.
 * </p>
 */
abstract public class IdentifiablePropertyFileSpecification extends
		IdentifiableSpecification {

	/**
	 * This is the name of the property in the property files that specifies the
	 * name of the <code>IdentifiablePropertyFileSpecification</code> sub-class.
	 * That will process the rest of the properties in the properties file. It
	 * is used by
	 * {@link #createPropertyDataSetIdentifiableSpecification(java.io.File)} to
	 * create the correct {@link IdentifiablePropertyFileSpecification}
	 * instance.
	 */
	public static final String RECORD_CLASSNAME_PROPERTY = "RECORD_CLASSNAME";

	/**
	 * This is the key in a property file whose value specifies a citation for
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getBibliographicCitation()
	 */
	public static final String BIBLIOGRAPHIC_CITATION_PROPERTY = "BIBLIOGRAPHIC_CITATION";

	/**
	 * This is the key in a property file whose value specifies a contributor to
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getContributor()
	 */
	public static final String CONTRIBUTOR_PROPERTY = "CONTRIBUTOR";

	/**
	 * This is the key in a property file whose value specifies the coverage of
	 * the data. Typically, this is a comma separated list of administration
	 * levels. Automatically generated if not specified.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getCoverage()
	 */
	public static final String COVERAGE_PROPERTY = "COVERAGE";

	/**
	 * This is the key in a property file whose value specifies when the data
	 * was created. Automatically generated if not specified.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getCreated()
	 */
	public static final String CREATED_PROPERTY = "CREATED";

	/**
	 * This is the key in a property file whose value specifies who created the
	 * data. Automatically generated if not specified.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getCreator()
	 */
	public static final String CREATOR_PROPERTY = "CREATOR";

	/**
	 * This is the key in a property file whose value specifies a date of the
	 * data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getDate()
	 */
	public static final String DATE_PROPERTY = "DATE";

	/**
	 * This is the key in a property file whose value specifies a description of
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getDescription()
	 */
	public static final String DESCRIPTION_PROPERTY = "DESCRIPTION";

	/**
	 * This is the key in a property file whose value specifies the format of
	 * the the data. Automatically generated if not specified.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getFormat()
	 */
	public static final String FORMAT_PROPERTY = "FORMAT";

	/**
	 * This is the key in a property file whose value specifies the URI of the
	 * {@link Identifiable} the data. Automatically generated if not specified.
	 * Not typically used, nor recommended.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getIdentifier()
	 */
	public static final String IDENTIFIER_PROPERTY = "IDENTIFIER";

	/**
	 * This is the key in a property file whose value specifies the language of
	 * the data. Not typically used, nor recommended.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getLanguage()
	 */
	public static final String LANGUAGE_PROPERTY = "LANGUAGE";

	/**
	 * This is the key in a property file whose value specifies the license of
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getLicense()
	 */
	public static final String LICENSE_PROPERTY = "LICENSE";

	/**
	 * This is the key in a property file whose value specifies the publisher of
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getPublisher()
	 */
	public static final String PUBLISHER_PROPERTY = "PUBLISHER";

	/**
	 * This is the key in a property file whose value specifies any
	 * relationships of the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getRelation()
	 */
	public static final String RELATION_PROPERTY = "RELATION";

	/**
	 * This is the key in a property file whose value specifies any requirements
	 * of the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getRequired()
	 */
	public static final String REQUIRED_PROPERTY = "REQUIRED";

	/**
	 * This is the key in a property file whose value specifies any rights
	 * associated with the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getRights()
	 */
	public static final String RIGHTS_PROPERTY = "RIGHTS";

	/**
	 * This is the key in a property file whose value specifies the source of
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getSource()
	 */
	public static final String SOURCE_PROPERTY = "SOURCE";

	/**
	 * This is the property that specifies the file whose value contains the
	 * latitude/longitude data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getSpatial()
	 */
	public static final String SPATIAL_PROPERTY = "SPATIAL_URI";

	/**
	 * This is the key in a property file whose value specifies the subject of
	 * the data.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getSubject()
	 */
	public static final String SUBJECT_PROPERTY = "SUBJECT";

	/**
	 * This is the property in a relationship data file whose value specifies
	 * the title of the relationship data. Automatically generated if not
	 * specified.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getTitle()
	 */
	public static final String TITLE_PROPERTY = "TITLE";

	/**
	 * This is the key in a property file whose value specifies the type of the
	 * data. Automatically generated if not specified. Not typically used, nor
	 * recommended.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getType()
	 */
	public static final String TYPE_PROPERTY = "TYPE";

	/**
	 * This is the key in a property file whose value specifies the date range
	 * that the data is valid for.
	 * 
	 * @see org.eclipse.stem.core.common.DublinCore#getValid()
	 */
	public static final String VALID_PROPERTY = "VALID";

	/**
	 * This is the set of data elements read from a *.properties file that
	 * defines the {@link Identifiable}.
	 * 
	 */
	protected List<PropertyData> propertyDataSet = new ArrayList<PropertyData>();

	/**
	 * @param propertiesFile
	 *            a *.properties file that contains the properties that define a
	 *            {@link org.eclipse.stem.core.graph.Graph}
	 * @return a {@link IdentifiablePropertyFileSpecification} initialized from
	 *         the properties contained in the file.
	 */
	public static IdentifiablePropertyFileSpecification createPropertyDataSetIdentifiableSpecification(
			final File propertiesFile) {
		IdentifiablePropertyFileSpecification retValue = null;

		if (propertiesFile.isFile() && propertiesFile.canRead()) {
			// Yes
			final Properties dataSetProperties = new Properties();
			BufferedInputStream propertiesInputStream = null;
			try {
				propertiesInputStream = new BufferedInputStream(
						new FileInputStream(propertiesFile));
				dataSetProperties.load(propertiesInputStream);
				propertiesInputStream.close();

				// The properties file contains the name of the class that knows
				// how to process the rest of the properties to create a Graph.
				String recordClassName = (String) dataSetProperties
						.get(RECORD_CLASSNAME_PROPERTY);

				// Did we get the class name?
				if (recordClassName != null) {
					// Yes
					recordClassName = recordClassName.trim();
					try {
						retValue = (IdentifiablePropertyFileSpecification) Class
								.forName(recordClassName).newInstance();
						// Let the IdentifiablePropertyFileSpecification
						// figure out what to do with the rest of the
						// properties.
						retValue.collectPropertyDataSet(dataSetProperties);
					} catch (final Exception e) {
						System.err
								.println("Error while reading the properties file \""
										+ propertiesFile.getName()
										+ "\", creating an instance of the class \""
										+ recordClassName
										+ "\" caused the following error.");
						e.printStackTrace();
					} catch (final Error e) {
						System.err
								.println("Error while reading the properties file \""
										+ propertiesFile.getName()
										+ "\", creating an instance of the class \""
										+ recordClassName
										+ "\" caused the following error.");
						e.printStackTrace();
					} // catch NoClassDefFoundError
				} // if got class name
				else {
					// No
					System.err
							.println("The properties file \""
									+ propertiesFile.getName()
									+ "\" did not contain the property \""
									+ RECORD_CLASSNAME_PROPERTY
									+ "\" that defines the name of the class that processes the contents of the file.\"");
				}
			} catch (final FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (final IOException e) {
				System.err.println(e.getMessage());
			}
		} // if can read the properties file
		else {
			// No
			System.err.println("The file \"" + propertiesFile.getAbsolutePath()
					+ "\" is not a file or can't be read.");
		}

		return retValue;
	} // createPropertyDataSetIdentifiableSpecification

	/**
	 * @param properties
	 *            the set of properties that specify the {@link Identifiable}
	 */
	protected void collectPropertyDataSet(final Properties properties) {
		// This will set the properties in this instance and also remove the
		// non-data properties from the set such as the dublin core properties
		// and the RECORD_CLASSNAME_PROPERTY
		collectNonDataProperties(properties);

		// Now we process the data entries and create the data set
		for (final Entry<Object, Object> entry : properties.entrySet()) {
			final String dataPropertyKey = (String) entry.getKey();

			final PropertyData data = createPropertyDataInstanceFromProperty(
					dataPropertyKey, ((String) entry.getValue()).trim());
			// Did we get null because of some error?
			if (data != null) {
				// No
				propertyDataSet.add(data);
			}
		} // for each property
	} // collectPropertyDataSet

	/**
	 * Create an appropriate instance of a subclass of {@link PropertyData} from
	 * a property extracted from the file.
	 * 
	 * @param propertyKey
	 *            the key of a property extracted from a properties file
	 * @param propertyValue
	 *            the value of the key extracted from a properties file
	 * @return a {@link PropertyData} instance that was created from the
	 *         propertyValue string
	 * 
	 * @see #createPropertyDataSetIdentifiableSpecification(File)
	 */
	abstract protected PropertyData createPropertyDataInstanceFromProperty(
			String propertyKey, String propertyValue);

	/**
	 * This method removes the {@link #RECORD_CLASSNAME_PROPERTY} and the
	 * {@link DublinCore} properties.
	 * 
	 * @param properties
	 *            the set of properties that define an {@link Identifiable}.
	 */
	protected void collectNonDataProperties(final Properties properties) {
		// Remove the property that specified which class to process the rest of
		// the properties file (i.e., a subclass of this class).
		properties.remove(RECORD_CLASSNAME_PROPERTY);

		// Extract all of the potential dublin core properties that could be in
		// the file
		dublinCore.setBibliographicCitation(properties
				.getProperty(BIBLIOGRAPHIC_CITATION_PROPERTY));
		dublinCore.setContributor(properties.getProperty(CONTRIBUTOR_PROPERTY));
		dublinCore.setCoverage(properties.getProperty(COVERAGE_PROPERTY));
		dublinCore.setCreated(properties.getProperty(CREATED_PROPERTY));
		dublinCore.setCreator(properties.getProperty(CREATOR_PROPERTY));
		dublinCore.setDate(properties.getProperty(DATE_PROPERTY));
		dublinCore.setDescription(properties.getProperty(DESCRIPTION_PROPERTY));
		dublinCore.setFormat(properties.getProperty(FORMAT_PROPERTY));
		dublinCore.setIdentifier(properties.getProperty(IDENTIFIER_PROPERTY));
		dublinCore.setLanguage(properties.getProperty(LANGUAGE_PROPERTY));
		dublinCore.setLicense(properties.getProperty(LICENSE_PROPERTY));
		dublinCore.setPublisher(properties.getProperty(PUBLISHER_PROPERTY));
		dublinCore.setRelation(properties.getProperty(RELATION_PROPERTY));
		dublinCore.setRequired(properties.getProperty(REQUIRED_PROPERTY));
		dublinCore.setRights(properties.getProperty(RIGHTS_PROPERTY));
		dublinCore.setSource(properties.getProperty(SOURCE_PROPERTY));
		dublinCore.setSpatial(properties.getProperty(SPATIAL_PROPERTY));
		dublinCore.setSubject(properties.getProperty(SUBJECT_PROPERTY));
		dublinCore.setTitle(properties.getProperty(TITLE_PROPERTY));
		dublinCore.setType(properties.getProperty(TYPE_PROPERTY));
		dublinCore.setValid(properties.getProperty(VALID_PROPERTY));

		// And remove them from the set of properties
		properties.remove(BIBLIOGRAPHIC_CITATION_PROPERTY);
		properties.remove(CONTRIBUTOR_PROPERTY);
		properties.remove(COVERAGE_PROPERTY);
		properties.remove(CREATED_PROPERTY);
		properties.remove(CREATOR_PROPERTY);
		properties.remove(DATE_PROPERTY);
		properties.remove(DESCRIPTION_PROPERTY);
		properties.remove(FORMAT_PROPERTY);
		properties.remove(IDENTIFIER_PROPERTY);
		properties.remove(LANGUAGE_PROPERTY);
		properties.remove(LICENSE_PROPERTY);
		properties.remove(PUBLISHER_PROPERTY);
		properties.remove(RELATION_PROPERTY);
		properties.remove(REQUIRED_PROPERTY);
		properties.remove(RIGHTS_PROPERTY);
		properties.remove(SOURCE_PROPERTY);
		properties.remove(SPATIAL_PROPERTY);
		properties.remove(SUBJECT_PROPERTY);
		properties.remove(TITLE_PROPERTY);
		properties.remove(TYPE_PROPERTY);
		properties.remove(VALID_PROPERTY);

	} // collectNonDataProperties

	/**
	 * @return a new {@link Identifiable} created from the contents of
	 *         {@link #propertyDataSet}.
	 * 
	 */
	@Override
	protected Identifiable createIdentifiable() {
		final Identifiable retValue = super.createIdentifiable();

		// Set any fields etc. in the Identifiable such as Dublin Core
		initializeIdentifiableFromNonDataProperties(retValue);

		// Was there any data?
		if (propertyDataSet != null && propertyDataSet.size() > 0) {
			// Yes
			initializeIdentifiableFromPropertyDataSet(retValue, propertyDataSet);
			// The data set isn't needed any more so let's cut it lose and free
			// up the memory for the garbage collector.
			propertyDataSet = null;
		} // if any data

		return retValue;
	} // createIdentifiable

	/**
	 * Initialize the {@link Identifiable} with the non-data properties
	 * extracted from the properties file. The non-data properties are those
	 * that do not directly specify an {@link Identifiable}, but rather some
	 * metadata about an {@link Identifiable}. For instance, if a data set is
	 * specific to a particular population, then the identifier of the
	 * population would be considered a non-data property, while the actual
	 * population data would be data.
	 * 
	 * @see #collectNonDataProperties(Properties)
	 * @see #initializeIdentifiableFromPropertyDataSet(Identifiable, List)
	 * @param identifiable
	 *            the {@link Identifiable} to populated from the data set
	 */
	protected void initializeIdentifiableFromNonDataProperties(
			Identifiable identifiable) {
		// Nothing
	} // populateFromNonDataProperties

	/**
	 * Initialize the {@link Identifiable} from the property data set that was
	 * collected by {@link #collectPropertyDataSet(Properties)}.
	 * 
	 * @param identifiable
	 *            the {@link Identifiable} to populated from the data set
	 * @param propertyDataSet
	 *            the data set to use to populate the {@link Identifiable}
	 */
	abstract protected void initializeIdentifiableFromPropertyDataSet(
			Identifiable identifiable, List<PropertyData> propertyDataSet);

} // DataSetRecord

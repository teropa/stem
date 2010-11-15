// PlatformLatLongDataProvider.java
package org.eclipse.stem.definitions.adapters.spatial.geo;

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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.stem.definitions.Activator;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.SegmentBuilder;
import org.eclipse.stem.definitions.adapters.spatial.geo.preferences.PreferenceConstants;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * This class interprets a URI that specifies a file of (i.e., "platform")
 * lat/long data in some format (currently <a
 * href="http://www.opengis.net/gml/">GML</a>).
 * 
 * @see InlineLatLongDataProvider
 * @see LatLongProviderAdapter
 */
@SuppressWarnings("deprecation")
public class PlatformLatLongDataProvider implements LatLongDataProvider {
	/**
	 * The class name of the first SAX XML parser to attempt to create if the
	 * default cannot be found. Value:
	 * <code>org.apache.xerces.parsers.SAXParser</code>
	 */
	public static final String SAX_PARSER1 = "org.apache.xerces.parsers.SAXParser";

	/**
	 * The class name of the second SAX XML parser to attempt to create if the
	 * default cannot be found. Value:
	 * <code>org.apache.crimson.parser.XMLReaderImpl</code>
	 */
	public static final String SAX_PARSER2 = "org.apache.crimson.parser.XMLReaderImpl";

	/**
	 * This set of nested Maps implements a cache for latitude/longitude data
	 * read in. The key of the first map is the URI of the file containing the
	 * data. The key of the second map is the identifier that is the fragment of
	 * the original query URI. If the first map does not contain an entry for a
	 * specified file, then one is created and populated with the contents of
	 * the file.
	 */
	static Map<URI, Map<String, LatLong>> cache = new ConcurrentHashMap<URI, Map<String, LatLong>>();

	/**
	 * This is the scheme for a "platform" data URI that specifies a file that
	 * contains lat/long data.
	 */
	public static final String PLATFORM_SCHEME = "platform";

	/**
	 * This is the name of the folder that contains the normal resolution GML
	 * files.
	 */
	private static final CharSequence NORMAL_RES_FOLDER = "country";

	/**
	 * This is the name of the folder that contains the lower resolution GML
	 * files
	 */
	private static final CharSequence LOW_RES_FOLDER = "country_reduced";

	/**
	 * If <code>true</code> then the latitude/longitude points will be sampled
	 * and some will be discarded to reduce their number.
	 */
	public boolean isSampling = false;

	/**
	 * This is the frequency at which the latitude/longitude data points will be
	 * sampled. A value of "1" means every point will be included, a value of
	 * "2" means that every 2nd point will be included. The first and last data
	 * points are always included.
	 */
	public int sampleFrequency = 1;

	/**
	 * If <code>true</code> then I/O Exceptions are logged, otherwise they are
	 * ignored.
	 */
	public boolean reportIOExceptions = true;

	/**
	 * If <code>true</code> then the path to the GML file will be modified to
	 * point to a smaller GML file that has a lower resolution.
	 */
	public boolean useLowerResolutionLatLongData = false;

	/**
	 * Constructor
	 */
	public PlatformLatLongDataProvider() {
		super();
		setPreferences();

		Activator.getDefault().getPluginPreferences()
				.addPropertyChangeListener(new IPropertyChangeListener() {
					public void propertyChange(final PropertyChangeEvent event) {
						setPreferences();
						// Flush everything in the cache to force it to be read
						// again from the gml file and re-sampled
						cache = new ConcurrentHashMap<URI, Map<String, LatLong>>();
					} // propertyChange
				} // IPropertyChangeListener
				);

	} // PlatformLatLongDataProvider

	/**
	 * @param latlongFileURI
	 * @return the lat/long values
	 */
	public LatLong getLatLong(final URI latlongFileURI) {
		LatLong retValue = null;

		// The URI should have an ID as the fragment that specifies the
		// latitude/longitude data in the GML file.

		// Is there an entry for our key?
		retValue = getLatLongMap(latlongFileURI.trimFragment()).get(
				latlongFileURI.fragment());

		retValue = retValue != null ? retValue : new LatLong();
		return retValue;
	} // getLatLong

	/**
	 * This method is just like {@link #getLatLong(URI)} except that it will
	 * immediately return an "empty" LatLong instance if the data for the URI
	 * has not been retrieved. It will also start a separate job to retrieve
	 * that data and will return it when that job completes successfully.
	 * 
	 * @param latlongFileURI
	 * @return the lat/long values
	 */
	public LatLong getLatLongNoWait(final URI latlongFileURI) {
		LatLong retValue = null;

		// The URI should have an ID as the fragment that specifies the
		// latitude/longitude data in the GML file.

		// Is there an entry for our key?
		retValue = getLatLongMapNoWait(latlongFileURI.trimFragment()).get(
				latlongFileURI.fragment());

		retValue = retValue != null ? retValue : new LatLong();
		return retValue;
	} // getLatLong

	/**
	 * @param fileURI
	 *            the uri of a file of latitude/longitude data
	 * @return the identifiers of the latitude/longitude data in the file
	 */
	public Set<String> getIds(final URI fileURI) {
		return getLatLongMap(fileURI).keySet();
	} // getIds

	/**
	 * This method is just like {@link #getIds(URI)} except that it will return
	 * an empty set if the data referenced by the URI has not been read yet. It
	 * will then cause a separate job to start that will read that data. A
	 * subsequent call, after that job completes successfully, would return a
	 * set of ids.
	 * 
	 * @param fileURI
	 *            the uri of a file of latitude/longitude data
	 * @return the identifiers of the latitude/longitude data in the file
	 */
	public Set<String> getIdsNoWait(final URI fileURI) {
		return getLatLongMapNoWait(fileURI).keySet();
	} // getIds

	/**
	 * @param fileURI
	 *            the uri of a file of latitude/longitude data
	 * @return the map between id's and data values for that file.
	 */
	private Map<String, LatLong> getLatLongMap(final URI fileURI) {
		// Have we processed this file before?
		Map<String, LatLong> latLongMap = cache.get(fileURI);
		if (latLongMap == null) {
			// No
			// We need to read the contents of the file and populate the entry
			latLongMap = createLatLongMap(fileURI);
			cache.put(fileURI, latLongMap);
		}
		return latLongMap;
	} // getLatLongMap

	/**
	 * This method is the same as {@link #getLatLongMap(URI)}, except that it
	 * immediately returns an instance of the lat/long map. This map will be
	 * empty if this is the first time a request has been made for it. In that
	 * case a separate Job (i.e., thread) is scheduled to read and populate the
	 * map from a GML file. When that is finished, the empty map is replaced by
	 * the populated one so that the next call will return the populated map.
	 * 
	 * @param fileURI
	 *            the uri of a file of latitude/longitude data
	 * @return the map between id's and data values for that file.
	 */
	synchronized private Map<String, LatLong> getLatLongMapNoWait(
			final URI fileURI) {
		// Have we processed this file before?
		Map<String, LatLong> latLongMap = cache.get(fileURI);
		if (latLongMap == null) {
			// No
			// We need to put an empty map into the cache so that the next call
			// doesn't try to start up another job to read in the file.
			latLongMap = new ConcurrentHashMap<String, LatLong>();
			cache.put(fileURI, latLongMap);

			// Now down to business, we create a separate job to read in the
			// lat/long data from the GML file and populate the map.
			final Job readGMLJob = new Job(fileURI.toString()) {
				/**
				 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
				 */
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask(fileURI.toString(), 100);
					// We need to read the contents of the file and populate the
					// entry
					final Map<String, LatLong> latLongMap = createLatLongMap(fileURI);
					// Replace the empty map with this one.
					cache.put(fileURI, latLongMap);
					monitor.done();
					return new Status(IStatus.OK, Activator.PLUGIN_ID,
							IStatus.OK, "Done", null);
				} // run
			}; // readGMLJob
			readGMLJob.schedule();
		} // if no lat/long map

		return latLongMap;
	} // getLatLongMap

	Map<String, LatLong> createLatLongMap(final URI fileURI) {
		final Map<String, LatLong> latLongMap = new ConcurrentHashMap<String, LatLong>();
		final URIConverter converter = new URIConverterImpl();
		final GMLDecoder gMLDecoder = new GMLDecoder(latLongMap);
		try {
			final InputStream is = converter
					.createInputStream(adjustFilePath(fileURI));
			final BufferedReader in = new BufferedReader(new InputStreamReader(
					is));
			parseInputStream(in, gMLDecoder);
		} // try
		catch (final IOException e) {
			// It could be that we tried to get a low resolution version of the
			// file and it wasn't found. So let's try getting the regular
			// resolution
			// Are we getting low resolution files?
			if (useLowerResolutionLatLongData) {
				// Yes
				try {
					// Try again without adjusting the file path
					final InputStream is = converter.createInputStream(fileURI);
					final BufferedReader in = new BufferedReader(
							new InputStreamReader(is));
					parseInputStream(in, gMLDecoder);
				} catch (final FileNotFoundException fnfe) {
					// Should we report the missing file?
					if (reportIOExceptions) {
						// Yes
						Activator.logInformation(fnfe.getMessage(), fnfe);
					}
				} // catch FileNotFoundException
				catch (final IOException e2) {
					// Should we report the error?
					if (reportIOExceptions) {
						// Yes
						Activator.logError(e2.getMessage(), e2);
					}
				} // catch IOException
			} // if using low resolution
			// Should we report the error?
			else if (reportIOExceptions) {
				// Yes
				Activator.logError(e.getMessage(), e);
			}
		} // catch

		return latLongMap;
	} // createLatLongMap

	/**
	 * This method determines if it should modify the path to the GML file so
	 * that a different file is selected. Typically, this is to switch to a
	 * lower resolution GML file.
	 * 
	 * @param fileURI
	 *            the original URI
	 * @return the adjusted URI
	 */
	private URI adjustFilePath(final URI fileURI) {
		URI retValue = fileURI;

		// Should we use a lower resolution version of the file?
		if (useLowerResolutionLatLongData) {
			// Yes
			final String adjustedPath = fileURI.toString().replace(
					NORMAL_RES_FOLDER, LOW_RES_FOLDER);
			retValue = URI.createURI(adjustedPath);
		}

		return retValue;
	} // adjustFilePath

	/**
	 * Set the preferences.
	 * 
	 * @see #isSampling
	 * @see #sampleFrequency
	 */
	private void setPreferences() {
		final Preferences preferences = Activator.getDefault()
				.getPluginPreferences();
		if(preferences !=null) {
			isSampling = preferences.getBoolean(PreferenceConstants.DOWN_SAMPLE_LAT_LONG_DATA_BOOLEAN_PREFERENCE);
			sampleFrequency = preferences.getInt(PreferenceConstants.LAT_LONG_SAMPLE_FREQUENCY_INTEGER_PREFERENCE);
			reportIOExceptions = preferences.getBoolean(PreferenceConstants.REPORT_IO_EXCEPTIONS_BOOLEAN_PREFERENCE);
			useLowerResolutionLatLongData = preferences.getBoolean(PreferenceConstants.USE_LOWER_RESOLUTION_LAT_LONG_DATA_BOOLEAN_PREFERENCE);
		}
		
	} // setPerferences

	/**
	 * Try to create a SAX Parser. The method first attempts to create the
	 * default parser. The class name of this parser is assigned to the property
	 * "org.xml.sax.driver". This value is defined on the command line that
	 * starts the Java interpreter
	 * <code>java -Dorg.xml.sax.driver=org.apache.xerces.parsers.SAXParser</code>
	 * If it is not successful in finding this parser, it will attempt to create
	 * an instance of <code>org.apache.xerces.parsers.SAXParser</code>, if
	 * that fails, it will try the parser
	 * <code>"org.apache.crimson.parser.XMLReaderImpl</code>. If that fails,
	 * it will throw a <code>SimulationException</code> reporting the
	 * inability to create a SAX XML Parser.
	 * 
	 * @return a SAXParser
	 */
	public static XMLReader getSAXParser() {

		XMLReader retValue = null;
		try {
			// Try to make the default SAX Parser
			retValue = XMLReaderFactory.createXMLReader();

		} // try
		catch (final SAXException saxe) {
			// Try specific parsers
			try { // SAX_PARSER1
				retValue = XMLReaderFactory.createXMLReader(SAX_PARSER1);
			} // try SAX_PARSER1
			catch (final SAXException saxe1) {
				try { // try SAX_PARSER2
					retValue = XMLReaderFactory.createXMLReader(SAX_PARSER2);
				} // try SAX_PARSER2
				catch (final SAXException saxe2) {
					Activator.logError(saxe2.getMessage(), saxe2);
				} // catch SAX_PARSER2
			} // catch SAX_PARSER1
		} // catch default

		return retValue;
	} // getSAXParser()

	/**
	 * Parse the specified input character stream using the
	 * 
	 * specified Handler. Where the output is stored depends on the handler
	 * 
	 * @param in
	 *            BufferedReader to read the XML from.
	 * @param handler
	 *            The class that will handle the parsing
	 */
	public static void parseInputStream(final BufferedReader in,
			final DefaultHandler handler) {
		try {
			final XMLReader saxParser = getSAXParser();
			saxParser.setContentHandler(handler);
			saxParser.parse(new InputSource(in));
			in.close();
		} catch (final IOException e) {
			Activator.logError(e.getMessage(), e);
		} catch (final SAXException e) {
			Activator.logError(e.getMessage(), e);
		}
	} // parseInputStream

	/**
	 * This class is a SAX Handler used to process the contents of a GML file
	 * specifying latitude/longitude data.
	 */
	public class GMLDecoder extends DefaultHandler {

		// XML element name
		private static final String XML_MAP_ELEMENT_NAME = "Map";

		private static final String XML_TITLE_ELEMENT_NAME = "title";

		private static final String XML_SUBTITLE_ELEMENT_NAME = "subTitle";

		private static final String XML_UPDATED_ELEMENT_NAME = "updated";

		private static final String XML_ENTRY_ELEMENT_NAME = "entry";

		private static final String XML_WHERE_ELEMENT_NAME = "where";

		private static final String XML_OUTER_BOUNDARY_ELEMENT_NAME = "outerBoundaryIs";

		private static final String XML_LINEAR_RING_ELEMENT_NAME = "LinearRing";

		private static final String XML_POLYGON_ELEMENT_NAME = "Polygon";

		private static final String XML_POSLIST_ELEMENT_NAME = "posList";

		private static final String XML_ID_ATTR = "gml:id";

		/**
		 * This is the title parsed from the file
		 */
		private String title = "";

		/**
		 * This is the sub-title parsed from the file;
		 */
		// We're ignoring subtitles right now
		// private String subTitle = "";
		/**
		 * This is the date the file was updated as parsed from the file;
		 */
		// We're ignoring updated right now
		// private String updated = "";
		/**
		 * This is the identifier of the current polygon being parsed
		 */
		private String currentPolygonId = null;

		// Parse position in the document being parsed
		private Locator locator = null;

		/**
		 * The map that is constructed during the processing of the GML file.
		 */
		Map<String, LatLong> latLongMap = null;

		/**
		 * This is the collection of
		 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment}'s
		 * collected for a polygon.
		 */
		private LatLong polygonLatLong = null;

		/**
		 * This segment builder is used to collect together related
		 * latitude/longitude data pairs to create a
		 * {@link org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment}
		 */
		private LatLong.SegmentBuilder segmentBuilder = null;

		/**
		 * These are the characters that have been collected but are not yet
		 * complete.
		 */
		private StringBuilder characterStringBuilder = new StringBuilder();

		/**
		 * Constructor
		 */
		protected GMLDecoder(final Map<String, LatLong> latLongMap) {
			super();
			this.latLongMap = latLongMap;
		} // GMLDecoder

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
		 *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement(final String namespace, final String sName, final String qName,
				final Attributes attributes) throws SAXException {
			// The name of the element
			final String elementName = sName.equals("") ? qName : sName;

			// The "Map" root element?
			if (elementName.equalsIgnoreCase(XML_MAP_ELEMENT_NAME)) {
				// Yes
				assert latLongMap != null;
			} // else if Map

			// A title element?
			else if (elementName.equalsIgnoreCase(XML_TITLE_ELEMENT_NAME)) {
				// Yes
				characterStringBuilder = new StringBuilder();
			} // title

			// subTitle element?
			else if (elementName.equalsIgnoreCase(XML_SUBTITLE_ELEMENT_NAME)) {
				// Yes
				characterStringBuilder = new StringBuilder();
			} // subTitle

			// updated element?
			else if (elementName.equalsIgnoreCase(XML_UPDATED_ELEMENT_NAME)) {
				// Yes
				characterStringBuilder = new StringBuilder();
			} // updated

			// entry element?
			else if (elementName.equalsIgnoreCase(XML_ENTRY_ELEMENT_NAME)) {
				// Yes
			} // updated

			// where element?
			else if (elementName.equalsIgnoreCase(XML_WHERE_ELEMENT_NAME)) {
				// Yes
			} // where

			// outerBoundaryIs element?
			else if (elementName
					.equalsIgnoreCase(XML_OUTER_BOUNDARY_ELEMENT_NAME)) {
				// Yes
			} // outerBoundaryIs

			// linearRing element?
			else if (elementName.equalsIgnoreCase(XML_LINEAR_RING_ELEMENT_NAME)) {
				// Yes
			} // linearRing

			// polygon element?
			else if (elementName.equalsIgnoreCase(XML_POLYGON_ELEMENT_NAME)) {
				// Yes
				assert currentPolygonId == null;
				assert polygonLatLong == null;
				currentPolygonId = attributes.getValue(XML_ID_ATTR);
				polygonLatLong = new LatLong();
			} // polygon

			// posList element?
			else if (elementName.equalsIgnoreCase(XML_POSLIST_ELEMENT_NAME)) {
				// Yes
				assert segmentBuilder == null;
				segmentBuilder = new SegmentBuilder();
				characterStringBuilder = new StringBuilder();
			} // posList

			else {
				// No
				// We have no idea what this element is
				throw new SAXParseException("Invalid element name \""
						+ elementName + "\"", locator);
			} // else unrecognized element name
		} // startElement

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
		 *      java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(final String namespace, final String sName, final String qName)
				throws SAXException {
			// The name of the element
			final String elementName = sName.equals("") ? qName : sName;

			// The "Map" root element?
			if (elementName.equalsIgnoreCase(XML_MAP_ELEMENT_NAME)) {
				// Yes
				assert latLongMap != null;
			} // else if Map

			// A title element?
			else if (elementName.equalsIgnoreCase(XML_TITLE_ELEMENT_NAME)) {
				// Yes
				title = characterStringBuilder.toString();
				characterStringBuilder = new StringBuilder();
			} // title

			// subTitle element?
			else if (elementName.equalsIgnoreCase(XML_SUBTITLE_ELEMENT_NAME)) {
				// Yes
				// We're ignoring subtitles right now
				// subTitle = characterStringBuilder.toString();
				characterStringBuilder = new StringBuilder();
			} // subTitle

			// updated element?
			else if (elementName.equalsIgnoreCase(XML_UPDATED_ELEMENT_NAME)) {
				// Yes
				// updated = characterStringBuilder.toString();
				characterStringBuilder = new StringBuilder();
			} // updated

			// entry element?
			else if (elementName.equalsIgnoreCase(XML_ENTRY_ELEMENT_NAME)) {
				// Yes
			} // entry

			// where element?
			else if (elementName.equalsIgnoreCase(XML_WHERE_ELEMENT_NAME)) {
				// Yes
			} // where

			// outerBoundaryIs element?
			else if (elementName
					.equalsIgnoreCase(XML_OUTER_BOUNDARY_ELEMENT_NAME)) {
				// Yes
			} // outerBoundaryIs

			// linearRing element?
			else if (elementName.equalsIgnoreCase(XML_LINEAR_RING_ELEMENT_NAME)) {
				// Yes
			} // linearRing

			// polygon element?
			else if (elementName.equalsIgnoreCase(XML_POLYGON_ELEMENT_NAME)) {
				// Yes
				latLongMap.put(currentPolygonId, polygonLatLong);
				currentPolygonId = null;
				polygonLatLong = null;
			} // polygon

			// posList element?
			else if (elementName.equalsIgnoreCase(XML_POSLIST_ELEMENT_NAME)) {
				// Yes
				// Parse the current characters for the latitude/longitude data
				// pairs

				final StringTokenizer st = new StringTokenizer(
						characterStringBuilder.toString(), " \n");
				characterStringBuilder = new StringBuilder();

				while (st.hasMoreTokens()) {
					final String value1 = st.nextToken();
					// Is there a matching Longitude?
					if (st.hasMoreTokens()) {
						// Yes
						// Lat
						final String value2 = st.nextToken();
						segmentBuilder.add(value1, value2);
					} else {
						// No
						// lat/long mismatch
						Activator
								.logError(
										"Latitude/Longitude data titled \""
												+ title
												+ "\" is missing a longitude  match for the latitude value \""
												+ value1 + "\" at line: "
												+ locator.getLineNumber()
												+ ", column: "
												+ locator.getColumnNumber(),
										null);
						// discard whatever we've collected so far
						segmentBuilder.clear();
						break;
					} // else
				} // while more tokens

				// Anything in the segment?
				if (segmentBuilder.size() > 0) {
					// Yes
					try {
						polygonLatLong.add(isSampling ? segmentBuilder
								.toSegment(sampleFrequency) : segmentBuilder
								.toSegment());
					} catch (IllegalArgumentException iae) {
						Activator.logError(
								"Problem processing Latitude/Longitude data titled \""
										+ title + "\"", iae);
					}
				} // if
				segmentBuilder = null;
			} // posList
			else {
				// No
				// We have no idea what this element is
				throw new SAXParseException("Invalid element name \""
						+ elementName + "\"", locator);
			} // else unrecognized element name
		} // endElement

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
		 */
		@Override
		public void characters(final char[] ch, final int start,
				final int length) {
			characterStringBuilder.append(new String(ch, start, length));
		} // characters

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException)
		 */
		@Override
		public void warning(final SAXParseException spe) {
			Activator.logInformation(spe.getMessage(), spe);
		} // warning

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
		 */
		@Override
		public void error(final SAXParseException spe) {
			Activator.logError(spe.getMessage(), spe);
		} // error

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException)
		 */
		@Override
		public void fatalError(final SAXParseException spe) {
			Activator.logError(spe.getMessage(), spe);
		} // fatalError

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#setDocumentLocator(org.xml.sax.Locator)
		 */
		@Override
		public void setDocumentLocator(final Locator locator) {
			this.locator = locator;
		} // setDocumentLocator

	} // GMLDecoder

} // PlatformLatLongDataProvider

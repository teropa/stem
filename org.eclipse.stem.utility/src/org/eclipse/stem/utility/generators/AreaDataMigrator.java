package org.eclipse.stem.utility.generators;

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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * extract the population data from the STEM I data files as a simple text file.
 * The area data extracted is used during generation of STEM II properties
 * files.
 * 
 * Add the following values to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\migration\country_names.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\migratedData\
 * 
 */

public class AreaDataMigrator {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String isoFile = null;

	private String countriesFile = null;

	private String outputDir = null;

	/**
	 * A map containing tuples of the form (location,area)
	 */
	Map areaMap = null;

	Map nameMap = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List countriesList = null;

	List codeList = null;

	/**
	 * Constructor
	 * 
	 * @param isoFile
	 *            a file containing ISO3166-1 codes
	 * @param countriesFile
	 *            a file containing countries for which we will generate area
	 *            properties files
	 * @param outputDir
	 *            the output directory where we will write the new area files
	 */
	AreaDataMigrator(String isoFile, String countriesFile, String outputDir) {
		this.isoFile = isoFile;
		this.countriesFile = countriesFile;
		this.outputDir = outputDir;
		areaMap = new HashMap();
		nameMap = new HashMap();
	}

	/**
	 * This method sets up and runs this generator.
	 * 
	 */
	public void run() {
		// Read and keep in memory a list of the countries we want.
		countriesList = GenUtils.populateList(countriesFile);

		// Read and keep in memory a list of the ISO3166-1 ALPHA2, ALPHA3, and
		// numeric codes.
		codeList = GenUtils.populateList(isoFile);

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Method that loads an XML file with STEM I name and area data.
	 * 
	 * @param fileName
	 *            the XML test file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return the root element of the XML document
	 * 
	 * 
	 */
	protected Element loadXML(String fileName) {

		Document doc = null;
		DocumentBuilder docBuilder = null;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			// XML document builder
			docBuilder = factory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			// Load XML file
			File xmlFile = new File(fileName);
			String filePath = xmlFile.getAbsolutePath();
			System.out.println("File path = " + filePath); //$NON-NLS-1$
			doc = docBuilder.parse(filePath);
		} catch (ParserConfigurationException pce) {
			System.out
					.println("LoadXML():  Error configuring xml document builder " //$NON-NLS-1$
							+ pce.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Return the root of this XML document
		return doc.getDocumentElement();
	}

	/**
	 * Read all arguments in a dataset, one by one.
	 * 
	 * @param file
	 *            filename of XML file we want to load and extract data from.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return a map with tuples (Key=locationID,Value)
	 * 
	 */
	protected Map extractAreaData(String file) {

		Map<String, String> areaMap = new HashMap<String, String>();

		Element root = loadXML(file);
		// get all the elements
		NodeList nl = root.getElementsByTagName("*"); //$NON-NLS-1$
		for (int i = 0; i < nl.getLength(); i++) {
			Element el = (Element) nl.item(i);
			String location = el.getAttribute("locationId").toUpperCase(); //$NON-NLS-1$
			String area = el.getAttribute("value"); //$NON-NLS-1$
			// Store both values for later lookup. Use uppercase.
			areaMap.put(location, area);
		}

		// return areaList;
		return areaMap;
	}

	/**
	 * Read all arguments in a dataset, one by one.
	 * 
	 * @param the
	 *            filename
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return a map with tuples (Key=ID,Value=Name)
	 * 
	 */
	protected Map extractNameData(String file) {

		Map<String, String> nameMap = new HashMap<String, String>();

		Element root = loadXML(file);
		// get all the elements
		NodeList nl = root.getElementsByTagName("*"); //$NON-NLS-1$

		for (int i = 0; i < nl.getLength(); i++) {
			Element regions = (Element) nl.item(i);
			NodeList locations = regions.getElementsByTagName("location"); //$NON-NLS-1$
			for (int j = 0; j < locations.getLength(); j++) {
				Element el = (Element) locations.item(j);
				String id = el.getAttribute("id").toUpperCase(); //$NON-NLS-1$
				String name = el.getAttribute("name").toUpperCase(); //$NON-NLS-1$

				// Store both values for later lookup. Use uppercase.
				nameMap.put(id, name);
			}
		}

		return nameMap;
	}

	/**
	 * Find all matches between locations and form a new tuple with the location
	 * name and area value for each location.
	 * 
	 * @param m1
	 *            A map containing tuples of the form (location,area)
	 * @param m2
	 *            A map containing tuples of the form (location,name)
	 * @param level
	 *            The administrative level
	 * 
	 * s@return A tuple of the form (name:area)
	 */
	protected String match(Map m1, Map m2, int level) {

		String result = null;
		Set keys = m1.keySet();
		Iterator it1 = keys.iterator();

		while (it1.hasNext()) {

			String key = (String) it1.next();

			if (m2.containsKey(key)) { // To be more strict, change this to
				// m2.equals(key)
				if (result == null) {

					if (((String) m2.get(key)).startsWith(":")) { //$NON-NLS-1$
						System.out.println("Ignoring malformed entry : " //$NON-NLS-1$
								+ m2.get(key));
					}

					result = m2.get(key) + ":" + String.valueOf(level) + ":" //$NON-NLS-1$ //$NON-NLS-2$
							+ m1.get(key) + "\n"; //$NON-NLS-1$
				} else {
					result += m2.get(key) + ":" + String.valueOf(level) + ":" //$NON-NLS-1$ //$NON-NLS-2$
							+ m1.get(key) + "\n"; //$NON-NLS-1$
				}
			}
		}
		return result;
	}

	/**
	 * Process our global list of countries with cross-referencing.
	 * 
	 */
	public void process() {

		PrintWriter outputFile = null;

		// Admin levels for each country
		// TO DO : fix this hard coded value. Should be passed as a parameter.
		// Path should contain the location of the STEM's 1 maps : it should
		// take value from parameter instead.
		final String path = "C:\\EclipseProjects\\workspace2\\GreenScreen\\InstallTemplate\\Maps\\"; //$NON-NLS-1$

		final int LEVELS = 1;

		for (int i = 0; i < countriesList.size(); i++) {

			// Get the next country in the list.
			String country = ((String) countriesList.get(i)).trim();

			// Get the ISO3166-1 info for this country
			ISOCode1 isoCode = GenUtils.getISOCode(country, codeList);

			if (isoCode == null) {
				System.out.println("iso code is null for " + country); //$NON-NLS-1$
				continue;
			}

			System.out.println("Country is :  " + country + " code = " //$NON-NLS-1$ //$NON-NLS-2$
					+ isoCode.getName());

			// Open output file
			if (outputFile == null) {
				String fileName = outputDir;
				fileName += isoCode.getName() + "_AREA.txt"; //$NON-NLS-1$
				outputFile = GenUtils.openWriter(fileName);
			}

			for (int j = 0; j <= LEVELS; j++) {
				// Open the source data files for this country:

				// Open the area file
				String areaFile = path;
				areaFile += isoCode.getAlpha3() + "_Area_" + j + ".xml"; //$NON-NLS-1$ //$NON-NLS-2$
				BufferedReader areaReader = GenUtils.openReader(areaFile);
				if (areaReader == null) {
					System.out.println("File not found for : " + areaFile); //$NON-NLS-1$
					continue;
				}

				// Open the names file
				String nameFile = path;
				nameFile += isoCode.getAlpha3() + "_Names_" + j + ".xml"; //$NON-NLS-1$ //$NON-NLS-2$
				BufferedReader nameReader = GenUtils.openReader(nameFile);
				if (nameReader == null) {
					System.out.println("File not found for : " + nameFile); //$NON-NLS-1$
					continue;
				}

				// Load the XML area and names documents and extract the data we
				// need
				try {
					areaMap = extractAreaData(areaFile);
					nameMap = extractNameData(nameFile);
					// now do the matchings
					String tuple = match(areaMap, nameMap, j);
					// write match to output file.
					// A match is a tuple of the form (name:area)
					outputFile.write(tuple);
					// Close the resources
					areaReader.close();
					nameReader.close();
					areaReader = null;
					nameReader = null;
					areaFile = null;
					nameFile = null;
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
			} // for j

			if (outputFile != null) {
				outputFile.close();
				outputFile = null;
			}
		}
	}

	/**
	 * Main execution entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final int ISO_FILE = 0;
		final int COUNTRY_FILE = 1;
		final int OUTPUT_DIR = 2;
		final int PARAMS = 3;

		if (args.length < PARAMS) {
			System.out.println("--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\tTo run, please provide the following arguments : "); //$NON-NLS-1$
			System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
			System.out.println("\t\t Target countries file"); //$NON-NLS-1$			
			System.out.println("\t\t Output directory"); //$NON-NLS-1$
			return;
		}

		AreaDataMigrator migrator = new AreaDataMigrator(args[ISO_FILE],
				args[COUNTRY_FILE], args[OUTPUT_DIR]);
		migrator.run();
	}

}

package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

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

/**
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * generate the GML data files for the diva data set at admin levels 0, 1, and
 * 2.
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/GMLGenerator.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\GMLGenerator.config)
 * 
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 * 
 */

public class GMLGenerator {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String iso3166_1 = null;

	private String iso3166_2 = null;

	private String fixFile = null;

	private String targetFile = null;

	private String lexDir = null;

	private String outputDir = null;

	private String workspace = null;

	private String usaDescriptorFile = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	List codeList = null;

	List codefixList = null;

	List usaDescriptorList = null;

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param iso3166_2 -
	 *            data file with the ISO3166-2 codes.
	 * @param fixFile -
	 *            file containing missing ISO3166-2 codes
	 * @param targetFile
	 *            the list of countries for which we will generate GML files
	 * @param lexDir
	 *            folder containing lexicographically sorted files
	 * @param outputDir
	 *            the output directory for the GML files we generate
	 */
	// public GMLGenerator(String iso3166_1, String iso3166_2, String fixFile,
	// String targetFile, String lexDir, String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.lexDir = lexDir;
	// this.outputDir = outputDir;
	// // The next descriptor is used only when processing the USA
	// this.usaDescriptorFile = workspace
	// +
	// "\\org.eclipse.stem.utility\\parameters\\ISOFIX\\USA_FIPS.txt";//$NON-NLS-1$
	// targetList = null;
	//	}

	/**
	 * @param configFile
	 */
	public GMLGenerator(String configFile) {

		// Load all configuration variables
		HashMap<String, String> vars = GenUtils.loadConfigFile(configFile);

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();

			// Assign values to configuration variables :
			if (var.equals("WORKSPACE")) { //$NON-NLS-1$
				workspace = vars.get(var);
			} else if (var.equals("ISO3166_1")) { //$NON-NLS-1$
				iso3166_1 = vars.get(var);
			} else if (var.equals("ISO3166_2")) { //$NON-NLS-1$
				iso3166_2 = vars.get(var);
			} else if (var.equals("ISO_FIX")) { //$NON-NLS-1$
				fixFile = vars.get(var);
			} else if (var.equals("TARGET_LIST")) { //$NON-NLS-1$
				targetFile = vars.get(var);
			} else if (var.equals("LEX_DIR")) { //$NON-NLS-1$
				lexDir = vars.get(var);
			} else if (var.equals("PROPERTIES_OUTPUT")) { //$NON-NLS-1$
				outputDir = vars.get(var);
			}

		} // while

		// The workspace variable should end with a slash character
		if (workspace.endsWith("\\") == false) { //$NON-NLS-1$
			workspace += "\\"; //$NON-NLS-1$
		}

		String path = workspace + GenConstants.PARAMS_DIR;

		// Set remaining config vars using WORKSPACE (workspace relative)
		if (iso3166_1 == null) {
			iso3166_1 = path + GenConstants.ISO3166_1_FILE;
		}
		if (iso3166_2 == null) {
			iso3166_2 = path + GenConstants.ISO3166_2_FILE;
		}
		if (fixFile == null) {
			fixFile = path + GenConstants.ISOFIX_FILE;
		}
		if (targetFile == null) {
			targetFile = path + GenConstants.GROUPED_COUNTRIES;
		}
		if (lexDir == null) {
			lexDir = path + GenConstants.LEX_DIR;
		}
		if (outputDir == null) {
			outputDir = workspace + GenConstants.MAPS_OUTPUT_DIR;
		}

		targetList = null;

		// The next descriptor is used only when processing the USA
		this.usaDescriptorFile = path + GenConstants.USA_FIPS_FILE;

	}

	/**
	 * This method sets up and runs this generator.
	 * 
	 */
	public void run() {

		// Read and keep in memory a list of the countries we want.
		targetList = GenUtils.populateList(targetFile);

		// Read and keep in memory a list of the ISO3166-1 ALPHA2, ALPHA3, and
		// numeric codes.
		codeList = GenUtils.populateList(iso3166_1);

		// Read and keep in memory a list of the missing ISO3166-2 codes
		codefixList = GenUtils.populateList(fixFile);

		// Load the list of descriptors for the USA (special case)
		usaDescriptorList = GenUtils.populateList(usaDescriptorFile);

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Process our global list of target countries. For each country in list,
	 * generate its GML file.
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter gmlFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		// A list for ISO 3166-2 objects
		List iso2List = new ArrayList();

		// Filenames for lex1 and lex2 files for a given country.
		String lexAdmin1File = null;
		String lexAdmin2File = null;

		// Lists holding the lex1 and lex2 values.
		// NOTE: lex values are the lexicographically sorted values for
		// administration levels.
		List<String> lex1DataSet = null;
		List<String> lex2DataSet = null;

		// Lists for holding lex1 and lex2 objects for a given country.
		List<Lex1Obj> lex1List = null;
		List<Lex2Obj> lex2List = null;

		int size = targetList.size();

		int lineCounter = 0;

		// Iterate for every country and create its GML data file.
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// An index for unknwon or n.a. entries
			int unkCounter = 1;

			// We use this list to keep track of duplicated polygons.
			List<STEMPolygon> polygons = null;

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);
			System.out
					.println("\t\t<<<< GML GENERATOR -- Processing :" + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;
					// Describes level
					// of data we
					// are now processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;

					// Record the previous type.
					int oldlevel = level - 1;

					// Used to distinguish between a simple polygon and islands
					// of polygons. Initialize string to the blank character.
					String island = " "; //$NON-NLS-1$

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

						lineCounter++;

						// The data we want to write to the new GML file.
						String output = " "; //$NON-NLS-1$

						// Make sure that we mark all unknown data.
						buffer = buffer.replace(",,", ",UNKNOWN,"); //$NON-NLS-1$ //$NON-NLS-2$

						// We take a chunk of the data [BUFFER_MIN,BUFFER_MAX]
						// to make processsing more
						// efficient, we dont need all of it.
						int BUFFER_MIN = 0;
						int BUFFER_MAX = 125;

						String[] items = GenUtils
								.extract(buffer.length() < BUFFER_MAX ? buffer
										: buffer.substring(BUFFER_MIN,
												BUFFER_MAX));

						// Get the country name
						String country = items[ISOData.COUNTRY_NAME];

						// Get the ISO3166-1 info for this country
						if (isoCode == null) {
							isoCode = GenUtils.getISOCode(country, codeList);
						}

						// Get the type of the data we are processing.
						level = GenUtils.getLevel(items);

						if (level != 0 && iso2List != null) {
							// Load the ISO 3166-2 objects for this country
							iso2List = GenUtils.loadISO2(iso3166_2);
						}

						// This variable indicates a transition in our data
						// processing
						boolean transition = (level != oldlevel) ? true : false;

						// The current entity we are dealing with.
						// Based on its admin level it can be a country, a
						// county, etc;
						String current = null;

						// Descriptor for current entry.
						String descriptor = null;

						if (transition == true) {
							// Keep track of previous level in order to detect
							// transitions.
							oldlevel = level;

							// Reset counter of UNKNOWN and N.A. entries.
							unkCounter = 1;
							// Close the previous file
							if (gmlFile != null) {
								output = closePolygonIslandTags();
								output += getClosingTags();
								GenUtils.addData(gmlFile, output);
								gmlFile.close();
							}

							// Clear the list of unique polygons
							if (polygons != null) {
								polygons.clear();
							}

							// Get a new, empty polygon list
							polygons = new ArrayList<STEMPolygon>();

							// If the directory does not exist for this country,
							// create it using ISO alpha3 code.
							File countryDir = new File(outputDir
									+ isoCode.getAlpha3());

							if (countryDir != null
									&& countryDir.exists() == false) {
								// Directory does not exist. Create it.
								countryDir.mkdir();
							}

							// Create the file name for the new
							// GML file.
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ "_" + level + "_MAP.xml"; //$NON-NLS-1$ //$NON-NLS-2$

							// Reset the previous entity
							island = " "; //$NON-NLS-1$

							// Open the writer for the new GML file
							gmlFile = GenUtils.openWriter(fileName);

							// Add the header of the file
							output = getOpeningTags(isoCode, level);

							// Write data
							GenUtils.addData(gmlFile, output.trim());

						} // if( transition == true )

						switch (level) {

						case DataTypes.LEVEL_0:
							current = isoCode.getAlpha3();
							break;

						case DataTypes.LEVEL_1:
							current = items[ISOData.ADMIN1_NAME].toUpperCase()
									.trim();
							break;

						case DataTypes.LEVEL_2:
							current = items[ISOData.ADMIN2_NAME].toUpperCase()
									.trim();
							break;

						} // switch

						// Handle UNKNOWN and N.A. entries differently.
						if (current.equals("UNKNOWN") || current.equals("N.A.")) { //$NON-NLS-1$ //$NON-NLS-2$

							if (level == 1) {
								current = isoCode.getAlpha2() + "-UNK-" //$NON-NLS-1$
										+ String.valueOf(unkCounter++);

							} else {
								// Level 2 data.
								current = isoCode.getAlpha3() + ".L2." //$NON-NLS-1$
										+ String.valueOf(unkCounter++);
							}
						}

						// We get the descriptor for administration entities
						// differently based on its level.

						if (level == 2) {

							if (lex1DataSet == null && lex2DataSet == null) {

								// Compose the file names for the lex files for
								// this
								// country.
								lexAdmin1File = lexDir + isoCode.getAlpha3()
										+ "\\" + isoCode.getAlpha3(); //$NON-NLS-1$
								lexAdmin2File = lexAdmin1File;
								lexAdmin1File += "_ADMIN1_LEX.txt"; //$NON-NLS-1$
								lexAdmin2File += "_ADMIN2_LEX.txt"; //$NON-NLS-1$

								// Load the lex1 and lex2 files for this
								// country.
								lex1DataSet = GenUtils
										.populateList(lexAdmin1File);
								lex2DataSet = GenUtils
										.populateList(lexAdmin2File);

								// Create a method to search for an item on a
								// list of lex data objects.
								lex1List = GenUtils.createLex1List(lex1DataSet);
								lex2List = GenUtils.createLex2List(lex2DataSet);

							}

							// Compose the level2 descriptor using the lex data:

							// STEP 1: Do a look up in the lex 2 lists.

							// Get the lex 2 object for the current entry.
							Lex2Obj lex2Current = GenUtils.lex2Lookup(lex2List,
									items[ISOData.ADMIN1_NAME], current);

							// Get the lex 1 object to which lex2Current belongs
							// to.
							Lex1Obj lex1Current = GenUtils.lex1Lookup(lex1List,
									lex2Current.getAdmin1());

							if (lex1Current.getDescriptor().contains("US-")) { //$NON-NLS-1$
								// STEP 2: piece together the ID using the
								// proper lex objects : the USA is a special
								// case
								descriptor = GenUtils.getUSADescriptor(
										lex2Current.getAdmin2(), GenUtils
												.extractAlpha2(lex1Current
														.getDescriptor()),
										usaDescriptorList);

								if (descriptor.contains("Not Found")) { //$NON-NLS-1$
									System.out
											.println("\t\tDescriptor Not Found" //$NON-NLS-1$
													+ lex2Current.getAdmin2()
													+ "in" //$NON-NLS-1$
													+ lex1Current.getAdmin1());
								}

							} else {
								// STEP 2: piece together the ID using the
								// proper lex objects.
								descriptor = lex1Current.getDescriptor()
										+ "-G" //$NON-NLS-1$
										+ lex1Current.getFormattedIndex()
										+ lex2Current.getFormattedIndex();
							}

							if (current.contains(".L2.")) { //$NON-NLS-1$
								current = descriptor;
							}

						} else {
							// Compose descriptor for l 1 and l 0 data
							// Get the descriptor for this entity.
							descriptor = GenUtils.getISO2Descriptor(iso2List,
									current, isoCode.getAlpha2());

							// If we cant find the descriptor, then look in the
							// fix list.
							if (descriptor.equals(current) == true) {
								// Look for a descriptor in the fix file
								descriptor = GenUtils.getFixCode(codefixList,
										current, items[ISOData.COUNTRY_NAME]);
							}

						}

						// System.out.println("Descriptor is : " + descriptor
						// + " at level : " + level + " for " + current);

						// Create a STEM polygon with this polygon data
						STEMPolygon polygon = new STEMPolygon(buffer, level);

						// Check that this is indeed a STEM polygon
						if (isPolygon(polygon) != true) {
							// Not a polygon, ignore.
							continue;
						}

						// We know it is a polygon, but now check that its not
						// duplicated.
						if (isPolygonDuplicated(polygons.iterator(), polygon) == true) {
							// Yes, it is duplicated
							continue;
						}

						// Add this polygon to our list of unique polygons so
						// that we can check duplicates of this polygon later.
						polygons.add(polygon);

						// Check to see if this polygon is part of an island of
						// polygons or a simple polygon and handle it
						// accordingly.
						if (level == 0) {
							// If we are at admin level 0 and island is not
							// NULL, then we have an island.
							if (island.equals(" ")) { //$NON-NLS-1$
								output = openPolygonIslandTags(descriptor);
								island = "Admin Level 0"; //$NON-NLS-1$
							}
							output += addLinearRingTags(buffer, level);
						} else {

							if (island.equals(" ") == true) { //$NON-NLS-1$
								output = openPolygonIslandTags(descriptor);
								output += addLinearRingTags(buffer, level);

							} else {

								if (current.equals(island) == false) {
									output = closePolygonIslandTags();
									output += openPolygonIslandTags(descriptor);
									output += addLinearRingTags(buffer, level);
								} else {
									output = addLinearRingTags(buffer, level);
									GenUtils.addData(gmlFile, output.trim());
									continue;
								}
							}

							switch (level) {

							case DataTypes.LEVEL_1:
								island = items[ISOData.ADMIN1_NAME]
										.toUpperCase();
								break;

							case DataTypes.LEVEL_2:
								island = items[ISOData.ADMIN2_NAME]
										.toUpperCase();
								break;
							}

						}

						GenUtils.addData(gmlFile, output.trim());

					} // while loop

					// Reset all lex-related items
					if (lex1DataSet != null) {
						lex1DataSet.clear();
						lex1DataSet = null;
					}
					if (lex2DataSet != null) {
						lex2DataSet.clear();
						lex2DataSet = null;
					}
					if (lex1List != null) {
						lex1List.clear();
						lex1List = null;
					}
					if (lex2List != null) {
						lex2List.clear();
						lex2List = null;
					}
					lexAdmin1File = null;
					lexAdmin2File = null;

					// We dont need the ISO code object for this country
					// anymore, we are done processing it.
					isoCode = null;

					// Close all open resources.
					reader.close();

					if (gmlFile != null) {
						// Write formatted output
						GenUtils.addData(gmlFile, closePolygonIslandTags());
						GenUtils.addData(gmlFile, getClosingTags());
						gmlFile.close();
						gmlFile = null;
						System.out.println("\t\tGenerated : " + fileName); //$NON-NLS-1$
						fileName = null;
					}

					// Run garbage collection
					//System.gc();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Check to see if this is a real polygon (i.e. closed)
	 * 
	 * @param polygon
	 *            A STEM polygon
	 * 
	 * @return true if the parameter "polygon" is a STEM polygon
	 */
	protected boolean isPolygon(STEMPolygon polygon) {

		PointData init = polygon.getInit();
		PointData last = polygon.getLast();

		if (init.getLt() != last.getLt()) {
			// Not a polygon
			return false;
		} else if (init.getLg() != last.getLg()) {
			// Not a polygon
			return false;
		}

		// Yes, it is a polygon
		return true;
	}

	/**
	 * Check to see if this polygon is duplicated.
	 * 
	 * @param polygon
	 *            a STEM polygon
	 * @param it
	 *            an iterator on the polygon list
	 * 
	 * @return true if this polygon is already in the list of known polygons
	 */
	protected boolean isPolygonDuplicated(Iterator it, STEMPolygon polygon) {

		if (it.hasNext() != true) {
			return false;
		}

		while (it.hasNext()) {
			STEMPolygon current = (STEMPolygon) it.next();
			if (current.same(polygon) == true) {
				// Not unique, it is duplicated so condition is false.
				return true;
			}
		}
		return false;
	}

	/**
	 * This method creates the opening XML tags that deal with islands of
	 * polygon data.
	 * 
	 * @param id
	 *            the descriptor for the entity
	 * 
	 * @return a GML tag that opens a polygon island element.
	 */
	protected String openPolygonIslandTags(String id) {

		String tags = null;
		tags = "<gml:Polygon gml:id=\"" + id + "\">\n"; //$NON-NLS-1$ //$NON-NLS-2$
		tags += "<gml:outerBoundaryIs>\n"; //$NON-NLS-1$

		return tags;
	}

	/**
	 * This method creates the tags that describe a "polygon island" or linear
	 * ring and puts the polygon data inside of it.
	 * 
	 * @param buffer
	 *            the data buffer containing all the polygond data
	 * @param level
	 *            the admin level
	 * 
	 * @return a GML tag that open a linear ring element
	 */
	protected String addLinearRingTags(String buffer, int level) {

		int offset = 0;

		String polygonData = null;

		switch (level) {

		case DataTypes.LEVEL_0:
			offset = 2;
			break;

		case DataTypes.LEVEL_1:
			offset = 3;
			break;

		case DataTypes.LEVEL_2:
			offset = 4;
			break;
		}

		// Tokenize
		StringTokenizer tokens = new StringTokenizer(buffer, ","); //$NON-NLS-1$

		// Advance the first K-tokens.
		for (int i = 0; i < offset; i++) {
			if (tokens.hasMoreTokens()) {
				tokens.nextToken();
			}
		}

		while (tokens.hasMoreTokens()) {

			String token = tokens.nextToken();

			if (GenUtils.isNumeric(token) == false) {
				continue; // Ignore, this is not a valid coordinate.
			}

			// Convert token (polygon data) to an int.
			double coord = GenUtils.toDegrees(GenUtils.getDouble(token));

			// Format lt, lg values according to our convention
			if (polygonData == null) {
				polygonData = GenUtils.format(coord) + " "; //$NON-NLS-1$
			} else {
				polygonData += GenUtils.format(coord) + " "; //$NON-NLS-1$
			}
		}

		String tags = "<gml:LinearRing>\n"; //$NON-NLS-1$
		tags += "<gml:posList>\n"; //$NON-NLS-1$
		tags += polygonData + "\n"; //$NON-NLS-1$
		tags += "</gml:posList>\n"; //$NON-NLS-1$
		tags += "</gml:LinearRing>\n"; //$NON-NLS-1$

		return tags;
	}

	/**
	 * This method creates the closing XML tags that deal with islands of
	 * polygon data.
	 * 
	 * @return a GML tag that closes a polygon
	 */
	protected String closePolygonIslandTags() {

		String tags = null;
		tags = "</gml:outerBoundaryIs>\n"; //$NON-NLS-1$
		tags += "</gml:Polygon>\n"; //$NON-NLS-1$

		return tags;
	}

	/**
	 * This method creates the XML tags that deal with simple polygon data and
	 * includes the polygon data in it.
	 * 
	 * @param buffer
	 *            the data buffer containing all the polygon data
	 * @param level
	 *            the admin level
	 * 
	 * @return a GML tag that describes a polygon
	 */
	protected String createSimplePolygonTags(String id, String buffer, int level) {

		int offset = 0;

		String polygonData = null;

		switch (level) {

		case DataTypes.LEVEL_0:
			offset = 2;
			break;

		case DataTypes.LEVEL_1:
			offset = 3;
			break;

		case DataTypes.LEVEL_2:
			offset = 4;
			break;
		}

		// Tokenize
		StringTokenizer tokens = new StringTokenizer(buffer, ","); //$NON-NLS-1$

		// Advance the first K-tokens.
		for (int i = 0; i < offset; i++) {
			if (tokens.hasMoreTokens()) {
				tokens.nextToken();
			}
		}

		while (tokens.hasMoreTokens()) {

			String token = tokens.nextToken();

			if (GenUtils.isNumeric(token) == false) {
				continue; // Ignore, this is not a valid coordinate.
			}

			// Convert token (polygon data) to an int.
			double coord = GenUtils.toDegrees(GenUtils.getDouble(token));

			// Format lt, lg values according to our convention
			if (polygonData == null) {
				polygonData = GenUtils.format(coord) + " "; //$NON-NLS-1$
			} else {
				polygonData += GenUtils.format(coord) + " "; //$NON-NLS-1$
			}
		}

		String tags = null;

		if (polygonData == null) {
			tags = "<gml:Polygon gml:id=\"" + id + "\"/>\n"; //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			tags = "<gml:Polygon gml:id=\"" + id + "\">\n"; //$NON-NLS-1$ //$NON-NLS-2$
			tags += "<gml:outerBoundaryIs>\n"; //$NON-NLS-1$
			tags += "<gml:LinearRing>\n"; //$NON-NLS-1$
			tags += "<gml:posList>\n"; //$NON-NLS-1$
			tags += polygonData + "\n"; //$NON-NLS-1$
			tags += "</gml:posList>\n"; //$NON-NLS-1$
			tags += "</gml:LinearRing>\n"; //$NON-NLS-1$
			tags += "</gml:outerBoundaryIs>\n"; //$NON-NLS-1$
			tags += "</gml:Polygon>\n"; //$NON-NLS-1$
		}

		return tags;
	}

	/**
	 * Generate the opening tags for this GML file.
	 * 
	 * @param code
	 *            the ISO code
	 * @param level
	 *            the admin level
	 * 
	 * @return the opening tags for the GML file
	 */
	protected String getOpeningTags(ISOCode1 code, int level) {

		// Calendar date = Calendar.getInstance();

		String tags = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"; //$NON-NLS-1$
		tags += GenUtils.geGMLCopyright();
		tags += GenUtils.getGMLKeyFormatExplanation();
		// tags += GenUtils.getGMLUNPolicy();
		tags += "<Map xmlns:gml=\"http://www.opengis.net/gml\" xmlns:georss=\"http://www.georss.org/georss\">\n"; //$NON-NLS-1$
		tags += "<title>" + code.getAlpha3() + " Level " + level //$NON-NLS-1$ //$NON-NLS-2$
				+ " Map</title>\n"; //$NON-NLS-1$
		tags += "<subTitle>Administrative Boundaries</subTitle>\n"; //$NON-NLS-1$
		tags += "<updated>Tue Nov 07 16:57:55 PST 2006 </updated>\n"; //$NON-NLS-1$
		tags += "<entry>\n"; //$NON-NLS-1$
		tags += "<georss:where>\n"; //$NON-NLS-1$
		return tags;
	}

	/**
	 * Generate the closing tags for this GML file.
	 * 
	 * @return the closing tags of the GML file
	 */
	protected String getClosingTags() {
		String tags = "</georss:where>\n"; //$NON-NLS-1$
		tags += "</entry>\n"; //$NON-NLS-1$
		tags += "</Map>\n"; //$NON-NLS-1$
		return tags;
	}

	/**
	 * The execution entry point
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// final int ISO_3166_1 = 0;
		// final int ISO_3166_2 = 1;
		// final int FIX_FILE = 2;
		// final int TARGET_LIST = 3;
		// final int LEX_DIR = 4;
		// final int OUTPUT_DIR = 5;
		// final int PARAMS = 6;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// GMLGenerator gen = new GMLGenerator(args[ISO_3166_1],
		// args[ISO_3166_2],
		// args[FIX_FILE], args[TARGET_LIST], args[LEX_DIR],
		// args[OUTPUT_DIR]);
		// gen.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		GMLGenerator gen = new GMLGenerator(args[CONFIG_FILE]);

		gen.run();

	}

}

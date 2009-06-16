/**
 * 
 */
package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * STEM II Data Migration/Generation Utilities -- Instances of this class are
 * used to run a point-reduction algorithm on the Diva set.
 * 
 * NOTE : SINGLE PASS DOWN SAMPLER is to be used only for a single iteration or
 * as the first step of more than one iteration.
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/SinglePassDownSampler.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\SinglePassDownSampler.config)
 * 
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 */
public class SinglePassDownSampler {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String threshold = null;

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
	 * List to keep track of pairs (PointDava:Value)
	 */
	List<String> pointDataList = null;

	/**
	 * A flag that indicates whether we can delete a point.
	 */
	// No, it is not safe to remove this node.
	final String UNSAFE = "0"; //$NON-NLS-1$

	// Yes, it can be deleted.
	final String SAFE = "1"; //$NON-NLS-1$

	// Safety state not known yet -> initial value.
	final String UNKNOWN = "2"; // //$NON-NLS-1$

	/**
	 * Used for global stats.
	 */
	double totalPoints = 0;

	double totalRemoved = 0;

	double totalPolygons = 0;

	double globalMinPercent = Double.MAX_VALUE;

	double globalMaxPercent = 0.0;

	double globalPercent = 0.0;

	/**
	 * Lists to keep track of the occurences of values of the angles : 180 -
	 * ArcCos(teta)
	 * 
	 */
	HashMap<Double, Integer> angleValueMap = null;

	/**
	 * Constructor
	 * 
	 * @param threshold -
	 *            the threshold in degress
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
	// public SinglePassDownSampler(String threshold, String iso3166_1,
	// String iso3166_2, String fixFile, String targetFile, String lexDir,
	// String outputDir) {
	// // Set values of global variables.
	// this.threshold = threshold;
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.targetFile = targetFile;
	// this.lexDir = lexDir;
	// this.outputDir = outputDir;
	// targetList = null;
	// angleValueMap = new HashMap<Double, Integer>();
	// this.usaDescriptorFile = workspace
	// + "\\org.eclipse.stem.utility\\parameters\\ISOFIX\\USA_FIPS.txt";
	// //$NON-NLS-1$
	// }
	/**
	 * @param configFile
	 */
	public SinglePassDownSampler(String configFile) {

		// Load all configuration variables
		HashMap<String, String> vars = GenUtils.loadConfigFile(configFile);

		Set<String> keys = vars.keySet();
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			String var = (String) it.next();

			// Assign values to configuration variables :
			if (var.equals("WORKSPACE")) { //$NON-NLS-1$
				workspace = vars.get(var);
			} else if (var.equals("THRESHOLD")) { //$NON-NLS-1$
				threshold = vars.get(var);
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
			} else if (var.equals("MAP_OUTPUT") || var.equals("OUTPUT")) { //$NON-NLS-1$ //$NON-NLS-2$
				outputDir = vars.get(var);
			}

		} // while

		// The workspace variable should end with a slash character
		if (workspace.endsWith("\\") == false) { //$NON-NLS-1$
			workspace += "\\"; //$NON-NLS-1$
		}

		String path = workspace + GenConstants.PARAMS_DIR;

		// Set remaining config vars using WORKSPACE (workspace relative)
		if (threshold == null) {
			threshold = GenConstants.DEFAULT_THRESHOLD; // Defaults to 5 degrees
		}
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
			targetFile = path + GenConstants.COUNTRIES_LIST;
		}
		if (lexDir == null) {
			lexDir = path + GenConstants.LEX_DIR;
		}

		if (GenUtils.verifyOutputDirectory(vars) == false) {
			System.out
					.println("\t\tBad configuration file -- OUTPUT variable not found. Please specify output directory using format VAR = VALUE (i.e. OUTPUT = C:\\diva\\grouped\\ "); //$NON-NLS-1$
			System.exit(1);
		}

		targetList = null;
		angleValueMap = new HashMap<Double, Integer>();
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

		// Initialize the hash map
		initHashMap(angleValueMap);

		// Now, process each item in the target list.
		process();

	}

	/**
	 * Initialize the hash map
	 * 
	 * @param map -
	 *            the hash map
	 * 
	 */
	public void initHashMap(HashMap<Double, Integer> map) {
		// Add some keys/values to our hash map
		map.put(new Double(90.0), new Integer(0));
		map.put(new Double(45.0), new Integer(0));
		map.put(new Double(22.5), new Integer(0));
		map.put(new Double(11.25), new Integer(0));
		map.put(new Double(5.5125), new Integer(0));
		map.put(new Double(2.0), new Integer(0));
		map.put(new Double(1.5), new Integer(0));
		map.put(new Double(1.0), new Integer(0));
		map.put(new Double(0.75), new Integer(0));
		map.put(new Double(0.5), new Integer(0));
		map.put(new Double(0.25), new Integer(0));
		map.put(new Double(0.15), new Integer(0));
		map.put(new Double(0.05), new Integer(0));
	}

	/**
	 * Perform only the first iteration of down sampling.
	 * 
	 */
	protected void process() {

		// A writer for the new file we are creating.
		PrintWriter gmlFile = null;

		// A writer for the reduced data file.
		PrintWriter reducedFile = null;

		// Object holding ISO3166-1 related data.
		ISOCode1 isoCode = null;

		// Name of the new properties file.
		String fileName = null;

		// Name of the new reduced data file.

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
					.println("\t\t<<<< SINGLE PASS DOWN SAMPLER -- Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$

			System.out.println("\t\t<<<< Pass 1 >>>>"); //$NON-NLS-1$

			try {

				if (reader != null) {

					String buffer = null;
					// Describes level of data we
					// are now processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;

					// Record the previous type.
					int oldlevel = level - 1;

					// Used to distinguish between a simple polygon and islands
					// of polygons. Initialize string to the blank character.
					String island = " "; //$NON-NLS-1$

					while (GenUtils.EOF(buffer = reader.readLine()) != true) {

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
							// Use previous level to detect transitions.
							oldlevel = level;

							// Reset the previous entity
							island = " "; //$NON-NLS-1$

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

							// Open the writer for the reduced data file
							if (reducedFile == null) {
								// Name for the reduced data file.
								fileName = countryDir
										+ "\\" //$NON-NLS-1$
										+ isoCode.getAlpha3()
										+ "_REDUCED_1.txt"; //$NON-NLS-1$
								reducedFile = GenUtils.openWriter(fileName);
							}

							// Create the file name for the reduced GML file.
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ "_" + level + "_REDUCED_MAP_1.xml"; //$NON-NLS-1$ //$NON-NLS-2$

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
							current = items[ISOData.ADMIN1_NAME].toUpperCase();
							break;

						case DataTypes.LEVEL_2:
							current = items[ISOData.ADMIN2_NAME].toUpperCase();
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

							// Get the lex1Object to which lex2Current belongs
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

						// Compute a map of angle values.
						List<String> pointDataList = computeInverseCosines(polygon);

						// Now apply reduction : get rid of all points with
						// angles less than or equal to alpha degrees
						double alpha = Double.parseDouble(threshold);
						List<String> reducedPointDataList = reduce(alpha,
								pointDataList);

						// Update Global Stats with results/data from the
						// reduction.
						updateGlobalStats(pointDataList.size(),
								reducedPointDataList.size());

						// Show some of the stats after each reduction.
						// showStats(pointDataList, reducedPointDataList, 1);

						// Put all the remaining points into a new buffer
						String reducedPolygonDataBuffer = extractListIntoString(reducedPointDataList);

						// Reconstruct a buffer with the reduced point-data.

						// Extract all data from old buffer except the polygon
						// data :
						String nonPolygonDataBuffer = extractNonPolygonData(
								buffer.length() < BUFFER_MAX ? buffer : buffer
										.substring(BUFFER_MIN, BUFFER_MAX),
								level);

						// Now put together a new buffer which has been reduced
						String reducedBuffer = nonPolygonDataBuffer
								+ reducedPolygonDataBuffer + "\n"; //$NON-NLS-1$

						// Write reduced data buffer into the reduced data file
						GenUtils.addData(reducedFile, reducedBuffer);

						// Delete the old polygon
						polygon.clear();
						polygon = null;

						// Create a new, reduced STEM polygon with the new data
						// buffer
						polygon = new STEMPolygon(reducedBuffer, level);

						// Check that this is indeed a STEM polygon
						if (isPolygon(polygon) != true) {
							System.out.println("\t\tNot a polygon!"); //$NON-NLS-1$
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
						// polygons or a simple polygon
						if (level == 0) {
							// If we are at admin level 0 and island is not
							// NULL, then we have an island.
							if (island.equals(" ")) { //$NON-NLS-1$
								output = openPolygonIslandTags(descriptor);
								island = "Admin Level 0"; //$NON-NLS-1$
							}
							output += addLinearRingTags(reducedBuffer, level);
						} else {

							if (island.equals(" ") == true) { //$NON-NLS-1$
								output = openPolygonIslandTags(descriptor);
								output += addLinearRingTags(reducedBuffer,
										level);

							} else {

								if (current.equals(island) == false) {
									output = closePolygonIslandTags();
									output += openPolygonIslandTags(descriptor);
									output += addLinearRingTags(reducedBuffer,
											level);
								} else {
									output = addLinearRingTags(reducedBuffer,
											level);
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

					if (reducedFile != null) {
						reducedFile.close();
						reducedFile = null;
					}

					// Run garbage collection
					System.gc();
				}

				// Show global stats
				showGlobalStats();

				// Now clear the hash map
				initHashMap(angleValueMap);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Extract all non polygon data from the buffer. Amount of non - polygon
	 * data varies according to level.
	 * 
	 * @param buffer
	 *            a buffer of diva data.
	 * 
	 * @param level
	 *            administrative level
	 * 
	 * @return String all the non-polygon data.
	 */
	public String extractNonPolygonData(String buffer, int level) {

		int offset = 0;

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

		// first occurrence of the comma separator
		int beginIndex = buffer.indexOf(","); //$NON-NLS-1$
		int endIndex = beginIndex;

		int i = 1;

		while (i < offset) {
			endIndex = buffer.indexOf(",", beginIndex + 1); //$NON-NLS-1$
			beginIndex = endIndex;
			i++;
		}

		beginIndex = 0;

		// extract the sequence up to index
		return buffer.substring(beginIndex, endIndex + 1);

	}

	/**
	 * Find and show the differences between the normal point-data list and the
	 * reduced point-data list.
	 * 
	 * @param normalList -
	 *            a list with the original point data
	 * @param reducedList -
	 *            a list with the reduced point data
	 * 
	 * @param pass -
	 *            the current pass or iteration
	 * 
	 */
	public void showStats(List<String> normalList, List<String> reducedList,
			int pass) {

		// double normalSize = normalList.size();
		// double reducedSize = reducedList.size();
		// double dif = normalSize - reducedSize;
		// double ratio = dif / normalSize;
		// double percent = ratio * 100.0;

		System.out.println("\t\t************ DOWN SAMPLING STATS FOR " + pass //$NON-NLS-1$
				+ " ITERATION ************\n"); //$NON-NLS-1$

		// Create and print profile of the angle values
		System.out.println("\t\tProfiling results BEFORE reduction : \n\n"); //$NON-NLS-1$

		profile(normalList);
		showProfile();

		// System.out.println("Total points in original polygon : "
		// + normalList.size());
		// System.out.println("Total points in reduced polygon : "
		// + reducedList.size());
		// System.out.println("Total points marked for deletion : " + dif);
		//
		// System.out.println("Percentage of reduction : " + percent + "%");
		//
		System.out.println("\t\tProfiling results AFTER reduction : \n\n"); //$NON-NLS-1$

		profile(reducedList);
		showProfile();
		System.out.println("\n\n\n"); //$NON-NLS-1$

	}

	/**
	 * Update global stats.
	 * 
	 * @param normalSize -
	 *            the total number of points before reduction
	 * 
	 * @param reducedSize -
	 *            the total number of points after reduction
	 * 
	 */
	public void updateGlobalStats(double normalSize, double reducedSize) {

		double dif = normalSize - reducedSize;
		double ratio = dif / normalSize;
		double percent = ratio * 100.0;

		globalMinPercent = (globalMinPercent > percent) ? percent
				: globalMinPercent;

		globalMaxPercent = (globalMaxPercent < percent) ? percent
				: globalMaxPercent;

		globalPercent += percent;

		totalPoints += normalSize;

		totalRemoved += reducedSize;

		totalPolygons += 1;

	}

	/**
	 * Print the global stats
	 */
	public void showGlobalStats() {

		System.out.println("\t\t************** GLOBAL STATS **************"); //$NON-NLS-1$

		System.out.println("\t\tTotal polygons : " + totalPolygons); //$NON-NLS-1$

		System.out.println("\t\tTotal points : " + totalPoints); //$NON-NLS-1$

		System.out.println("\t\tAvg points per polygon : " + totalPoints //$NON-NLS-1$
				/ totalPolygons);

		System.out.println("\t\tGlobal reduction : " + globalPercent //$NON-NLS-1$
				/ totalPolygons + "%"); //$NON-NLS-1$

		System.out
				.println("\t\tGlobal MIN reduction  : " + globalMinPercent + "%"); //$NON-NLS-1$ //$NON-NLS-2$

		System.out
				.println("\t\tGlobal MAX reduction  : " + globalMaxPercent + "%"); //$NON-NLS-1$ //$NON-NLS-2$

	}

	/**
	 * Just print the profile for the polygon point-data
	 * 
	 */
	public void showProfile() {
		// Sort the keys
		Set<Double> keys = angleValueMap.keySet();
		List<Double> sortedKeys = new ArrayList<Double>(keys);
		Collections.sort(sortedKeys);

		System.out.println("\t\tFrequencies of angles :  "); //$NON-NLS-1$

		// Print the number of occurrences for each value
		Iterator keyIter = sortedKeys.iterator();
		while (keyIter.hasNext()) {

			// Get the key
			Double key = (Double) keyIter.next();

			// Get the value
			int val = (angleValueMap.get(key)).intValue();

			System.out.println("\t\t Angle >= " + key + " Frequency : " + val); //$NON-NLS-1$ //$NON-NLS-2$

		}

	}

	/**
	 * Algorithm for reducing the data by marking and then removing (nearly) all
	 * points with angle less than alpha. All points marked for deletion are
	 * called SAFE.
	 * 
	 * @param alpha -
	 *            the threshold
	 * @param list -
	 *            a list containing extended point data of the form :
	 *            INDEX:LT:LG:ANGLE:SAFETY
	 * 
	 * @return list - a reduced list of points that should not be deleted
	 *         because they dont meet the criteria (i.e. their angle is greater
	 *         than threshold or were marked as UNSAFE)
	 * 
	 */
	public List<String> reduce(double alpha, List<String> list) {

		/**
		 * Remove all points which are safe to remove.
		 * 
		 * To be safe, a point should satisfy two conditions :
		 * 
		 * 1) Have an angle with value less than alpha degress.
		 * 
		 * 2) We CANNOT mark SAFE for deletion two consecutive points.
		 * 
		 */

		// This list will contain only the elements that we should not remove
		List<String> reducedList = new ArrayList<String>();

		// Symbolic constants for controlling the sliding window algorithm
		final int START = 0;
		final int WINDOW_LENGTH = 2;

		// Multiplier to obtain minimum lenght at which makes sense to run this
		// algorithm:
		final int MULTIPLIER = 1;

		// MINIMUM LENGTH = MULTIPLIER * (WINDOW_LENGTH + 1)
		final int MINIMUM_LENGTH = MULTIPLIER * (WINDOW_LENGTH + 1);

		// Indexes into the string containing extended point data:
		// INDEX:LT:LG:ANGLE:SAFETY
		final int INDEX = 0;
		final int LT = 1;
		final int LG = 2;
		final int ANGLE = 3;
		final int SAFETY = 4;

		// Our sliding window covers exactly three nodes.
		String[] p1 = null;
		String[] p2 = null;
		String[] p3 = null;

		// Angle values for each of the three points in the sliding window.
		double a1 = 0.0;
		double a2 = 0.0;
		double a3 = 0.0;

		// State (SAFE or UNSAFE) of each of three points in the sliding window.
		String s1 = UNKNOWN;
		String s2 = UNKNOWN;
		String s3 = UNKNOWN;

		// A pointer to the beginning and the end of the sliding window.
		int left_border = 0;
		int right_border = left_border + WINDOW_LENGTH;

		// Our current position within the sliding window.
		int index = START;

		if (list.size() < MINIMUM_LENGTH) {
			// There is no point in running this algorithm if points
			// less than minimum value. No need to reduce.
			return list;
		}

		final int END = list.size() - 1;

		// System.out.println("List size is : " + end);

		while (right_border <= END) {

			// UNKNOWN == NOT YET PROCESSED -- Eventually it will be marked
			// either SAFE or UNSAFE

			boolean flag = false;

			// if (p1 == null) {
			// Get the three initial points covered by our sliding window.
			index = left_border;
			p1 = list.get(index++).split(":"); //$NON-NLS-1$
			p2 = list.get(index++).split(":"); //$NON-NLS-1$
			p3 = list.get(index).split(":"); //$NON-NLS-1$
			// }

			// Now get the angle value for each of the three points.
			a1 = Double.parseDouble(p1[ANGLE]);
			a2 = Double.parseDouble(p2[ANGLE]);
			a3 = Double.parseDouble(p3[ANGLE]);

			// Now get the state of each of the three points.
			s1 = p1[SAFETY];
			s2 = p2[SAFETY];
			s3 = p3[SAFETY];

			// Check to see if the initial, leftmost point is greater than
			// alpha or if it is UNSAFE. If so, then slide forward the window.
			if (a1 > alpha) {
				// Just slide forward the window one unit.
				left_border += 1;
				right_border += 1;
				continue;
			}

			if (s1.equals(UNSAFE)) {

				if (a2 < alpha && a2 <= a3) {
					// [ P1 = UNSAFE, P2 = SAFE, P3 = UNSAFE ]
					// Advance sliding window after P2
					s2 = SAFE;
					s3 = UNSAFE;
				} else if (a3 < alpha) {
					// [ P1 = UNSAFE, P2 = UNSAFE, P3 = SAFE ]
					// Advance sliding window after P2
					s3 = SAFE;
					s2 = UNSAFE;
				}

			} else if (a1 < alpha && a1 < a2) {
				// [ P1 = SAFE, P2 = UNSAFE, P3 = UNKNOWN ]
				// Advance sliding window after P2
				s1 = SAFE;
				s2 = UNSAFE;
				// Now check to see if is safe to mark P3 too.
				if (a3 < alpha) {
					// [ P1 = SAFE, P2 = UNSAFE, P3 = SAFE ]
					// Advance sliding window after P2
					s3 = SAFE;
				}
			} else if (a1 < alpha && a1 > a2) {
				// [ P1 = UNSAFE, P2 = SAFE, P3 = UNSAFE ]
				// SPECIAL CASE : Advance sliding window after P3
				s1 = UNSAFE;
				s2 = SAFE;
				s3 = UNSAFE;
				// Special case : set flag to advance sliding window after P3
				flag = true;

			} else if (a1 > alpha && a2 > alpha) {
				// [ P1 = UNSAFE, P2 = UNSAFE, P3 = UNKNOWN ]
				// Advance sliding window after P2
				s1 = UNSAFE;
				s2 = UNSAFE;
			}

			// Pack the modified point-data.
			String t1 = p1[INDEX] + ":" + p1[LT] + ":" + p1[LG] + ":" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ p1[ANGLE] + ":" + s1; //$NON-NLS-1$

			String t2 = p2[INDEX] + ":" + p2[LT] + ":" + p2[LG] + ":" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ p2[ANGLE] + ":" + s2; //$NON-NLS-1$

			String t3 = p3[INDEX] + ":" + p3[LT] + ":" + p3[LG] + ":" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ p3[ANGLE] + ":" + s3; //$NON-NLS-1$

			// Store the modified (marked) point-data.
			list.set(Integer.parseInt(p1[INDEX]), t1);
			list.set(Integer.parseInt(p2[INDEX]), t2);
			list.set(Integer.parseInt(p3[INDEX]), t3);

			if (flag == true) {
				// SPECIAL CASE : Advance sliding window after P3.
				left_border = right_border + 1;
				right_border = left_border + WINDOW_LENGTH;
				// Go to the next iteration.
				continue;
			}

			// DEFAULT : Advance sliding window after P2.
			left_border = right_border;
			right_border = left_border + WINDOW_LENGTH;

		} // while

		// Now remove the SAFE points and return the reduced list.
		Iterator it = list.listIterator();

		while (it.hasNext()) {

			String data = (String) it.next();

			String[] tokens = data.split(":"); //$NON-NLS-1$

			if (tokens[SAFETY].equals(SAFE)) {
				continue;
			}
			reducedList.add(data);

		}

		// System.out.println("Reduced list size is : " + reducedList.size());

		return reducedList;

	}

	/**
	 * Profile the angle data. Count how many times each value occurs
	 * 
	 * @param list -
	 *            a list of angles for each data point in the polygon
	 * 
	 */
	public void profile(List<String> list) {

		final int ANGLE = 3;

		if (list == null) {
			return;
		}

		// We want to iterate through all the points of the
		// polygon
		Iterator it = list.iterator();

		// Clear the hash map before start using it.
		initHashMap(angleValueMap);

		// Count the occurrences of the values of the 180 offset
		// minus the angle.
		// This count will be useful for finding a good threshold.
		while (it.hasNext()) {

			String p = (String) it.next();

			String[] elements = p.split(":"); //$NON-NLS-1$

			Double angle = new Double(elements[ANGLE]);

			double degrees = angle.doubleValue();

			count(degrees, angleValueMap);

		} // while

	}

	/**
	 * Based on the current value of the angle, keep track of it.
	 * 
	 * @param degrees -
	 *            The value of the last offset - Cos-1(angle) value.
	 * 
	 * @param map -
	 *            The map holding angles and their count
	 * 
	 */
	public void count(double degrees, HashMap<Double, Integer> map) {

		// Filter to find the appropriate bucket for the value

		if (degrees >= 90.0) {
			int count = (map.get(new Double(90.0))).intValue();
			map.put(new Double(90.0), new Integer(++count));

		} else if (degrees >= 45.0) {
			int count = (map.get(new Double(45.0))).intValue();
			map.put(new Double(45.0), new Integer(++count));

		} else if (degrees >= 22.5) {
			int count = (map.get(new Double(22.5))).intValue();
			map.put(new Double(22.5), new Integer(++count));

		} else if (degrees >= 11.25) {
			int count = (map.get(new Double(11.25))).intValue();
			map.put(new Double(11.25), new Integer(++count));

		} else if (degrees >= 5.5125) {
			int count = (map.get(new Double(5.5125))).intValue();
			map.put(new Double(5.5125), new Integer(++count));

		} else if (degrees >= 2.0) {
			int count = (map.get(new Double(2.0))).intValue();
			map.put(new Double(2.0), new Integer(++count));

		} else if (degrees >= 1.5) {
			int count = (map.get(new Double(1.5))).intValue();
			map.put(new Double(1.5), new Integer(++count));

		} else if (degrees >= 1.0) {
			int count = (map.get(new Double(1.0))).intValue();
			map.put(new Double(1.0), new Integer(++count));

		} else if (degrees >= 0.75) {
			int count = (map.get(new Double(0.75))).intValue();
			map.put(new Double(0.75), new Integer(++count));

		} else if (degrees >= 0.5) {
			int count = (map.get(new Double(0.5))).intValue();
			map.put(new Double(0.5), new Integer(++count));

		} else if (degrees >= 0.25) {
			int count = (map.get(new Double(0.25))).intValue();
			map.put(new Double(0.25), new Integer(++count));

		} else if (degrees >= 0.15) {
			int count = (map.get(new Double(0.15))).intValue();
			map.put(new Double(0.15), new Integer(++count));

		} else if (degrees >= 0.05) {
			int count = (map.get(new Double(0.05))).intValue();
			map.put(new Double(0.05), new Integer(++count));

		}

	}

	/**
	 * Simply extract the LT,LG values from the list.
	 * 
	 * @param list
	 *            a list with point-data of the form: INDEX:LT:LG:ANGLE:SAFETY
	 * 
	 * @return String a concatenation of all the LT,LG values.
	 */
	String extractListIntoString(List<String> list) {

		final int LT = 1;

		final int LG = 2;

		String buffer = null;

		Iterator it = list.iterator();

		while (it.hasNext()) {

			String p = (String) it.next();

			String[] elements = p.split(":"); //$NON-NLS-1$

			if (buffer == null) {

				buffer = elements[LT] + "," + elements[LG] + ","; //$NON-NLS-1$ //$NON-NLS-2$

			} else {

				buffer += elements[LT] + "," + elements[LG] + ","; //$NON-NLS-1$ //$NON-NLS-2$

			}

		}

		return buffer;
	}

	/**
	 * Compute the cosine inverse of an angle and subract that value from an
	 * offset of 180 degrees.
	 * 
	 * @param polygon
	 *            a STEM polygon
	 * 
	 * @return List a list of angle values for all points in the polygon
	 * 
	 */
	List<String> computeInverseCosines(STEMPolygon polygon) {

		final double INFINITY = 10000000;

		// List to keep track of tuples of the form : ( point, inverse
		// ANGLE angle )
		List<String> pointDataList = new ArrayList<String>();

		// First, get an iterator to the points in the polygon
		Iterator it = polygon.getIterator();

		double degrees = 0.0;

		// Get the first three points
		double inverseCosine = INFINITY;

		// String to store initial point. This will be used to set the value
		// of the last point. Since a polygon has to be closed, the first and
		// last points should be the same. It is better to store it than to
		// recompute it later.
		String initPointData = null;
		String lastPointData = null;

		PointData p1 = null;
		PointData p2 = null;
		PointData p3 = null;

		int index = 0;

		// Set the value of the first and last point.
		// We never delete the first or the last point, otherwise we will
		// turn this polygon into a non-polygon.
		// Set to UNSAFE and angle to Double.MAX_VALUE to make sure that neither
		// of these points ever be removed.

		if (initPointData == null) {

			PointData init = polygon.getInit();

			// Set angle to a
			initPointData = String.valueOf(0) + ":" + init.getLt() + ":" //$NON-NLS-1$ //$NON-NLS-2$
					+ init.getLg() + ":" + Double.MAX_VALUE + ":" + UNSAFE; //$NON-NLS-1$ //$NON-NLS-2$

			lastPointData = String.valueOf(polygon.points() - 1) + ":" //$NON-NLS-1$
					+ init.getLt() + ":" + init.getLg() + ":" //$NON-NLS-1$ //$NON-NLS-2$
					+ Double.MAX_VALUE + ":" + UNSAFE; //$NON-NLS-1$

		}

		while (it.hasNext()) {

			if (p1 == null) {
				p1 = (PointData) it.next();
				continue;
			}

			if (p2 == null) {
				p2 = (PointData) it.next();
				continue;
			}

			if (p3 == null) {
				p3 = (PointData) it.next();
			}

			if (index == 0) {
				// System.out.println("Adding (1) : " + initPointData);
				pointDataList.add(index++, initPointData);
			}

			// String used to represent extended point data. It has the form :
			// INDEX:LT:LG:ANGLE:SAFETY
			String tuple = null;

			// Now that we have three consecutive points, compute the inverse
			// ANGLE of the angle
			// for the triangle formed by these three consecutive points.
			final double cc = 100000000000.0;
			double lt1 = p1.getLt() * cc;
			double lt2 = p2.getLt() * cc;
			double lt3 = p3.getLt() * cc;
			double lg1 = p1.getLg() * cc;
			double lg2 = p2.getLg() * cc;
			double lg3 = p3.getLg() * cc;

			// compute: a^2 = (Xi- Xi-1)^2 + (Yi- Yi-1)^2
			double a = Math.pow((lg2 - lg1), 2) + Math.pow((lt2 - lt1), 2);

			// compute: b^2 = (Xi+1 -Xi)^2 + (Yi+1 -Yi)^2
			double b = Math.pow((lg3 - lg2), 2) + Math.pow((lt3 - lt2), 2);

			// compute: c^2 = (Xi+1 - Xi-1)^2 + (Yi+1 - Yi-1)^2
			double c = Math.pow((lg3 - lg1), 2) + Math.pow((lt3 - lt1), 2);

			// System.out.println(" A^2 = " + a);

			// System.out.println(" B^2 = " + b);

			// System.out.println(" C^2 = " + c);

			// Now compute: (a^2 + b^2 - c^2) / 2ab

			double ratio = ((a + b) - c) / (2 * Math.sqrt(a) * Math.sqrt(b));

			// System.out.println("Ratio is : " + ratio);

			// Now compute the arc ANGLE : cos-1( ratio )
			inverseCosine = Math.acos(ratio);

			degrees = Math.abs(180.0 - GenUtils.toDegrees(inverseCosine));

			tuple = String.valueOf(index) + ":" + p2.getLt() + ":" + p2.getLg() //$NON-NLS-1$ //$NON-NLS-2$
					+ ":" + new Double(degrees) + ":" + UNKNOWN; //$NON-NLS-1$ //$NON-NLS-2$

			// Store tuple in the map
			// System.out.println("Adding (1) : " + tuple);
			pointDataList.add(index++, tuple);

			// System.out.println("Inverse cosine is " + inverseANGLE);

			// Slide the points by one to do the new computation of the angle

			// Now set p1 <- p2
			p1 = p2;

			// Now set p2 <- p3
			p2 = p3;

			// Now set p3 = null
			p3 = null;

			// Check to see if this is the last iteration.
			if (it.hasNext() == false) {

				// If so, add the last point.
				// System.out.println("Adding (2) : " + lastPointData);
				pointDataList.add(index, lastPointData);
				break;
			}

		}

		return pointDataList;
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
	 * @return a GML tag that describes a polygon
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
	 * @return a GML tag for opening a linear ring.
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
	 * @return a GML tag for closing a polygon.
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
	 * @param id
	 *            the descriptor for the entity
	 * @param buffer
	 *            the data buffer containing all the polygon data
	 * @param level
	 *            the admin level
	 * 
	 * @return a GML tag to create simple polygon.
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
	 * @return the opening tags for the GML file
	 */
	protected String getOpeningTags(ISOCode1 code, int level) {

		// Calendar date = Calendar.getInstance();

		String tags = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"; //$NON-NLS-1$
		tags += GenUtils.geGMLCopyright();
		tags += GenUtils.getGMLKeyFormatExplanation();
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
		// final int THRESHOLD = 0;
		// final int ISO_3166_1 = 1;
		// final int ISO_3166_2 = 2;
		// final int FIX_FILE = 3;
		// final int TARGET_LIST = 4;
		// final int LEX_DIR = 5;
		// final int OUTPUT_DIR = 6;
		// final int PARAMS = 7;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t Threshold (in degrees)"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// SinglePassDownSampler sampler = new SinglePassDownSampler(
		// args[THRESHOLD], args[ISO_3166_1], args[ISO_3166_2],
		// args[FIX_FILE], args[TARGET_LIST], args[LEX_DIR],
		// args[OUTPUT_DIR]);
		// sampler.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		SinglePassDownSampler sampler = new SinglePassDownSampler(
				args[CONFIG_FILE]);

		sampler.run();

	}

}

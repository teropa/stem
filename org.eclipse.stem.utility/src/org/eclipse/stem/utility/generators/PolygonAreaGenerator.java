package org.eclipse.stem.utility.generators;

import java.awt.Polygon;
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
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * STEM II Data Migration/Generation Utilities -- This is a utility class that
 * computes the area of a polygon in polygon units. This is useful to compute
 * the approximate area of a location when we dont know the exact area value.
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/PolygonAreaGenerator.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\PolygonAreaGenerator.config)
 * 
 * Add the following values to the run configuration:
 * 
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-1\ISO3166_1_en.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISO3166-2\ISO3166_2_list.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\ISOFix\ISO_LEVEL1_FIX.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\AreaPopulationData\
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\properties\Countries.txt
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\sort\
 * C:\stemII\org.eclipse.stem.utility\dataMigration\input\PolygonAreas\
 * 
 * 
 * 
 */

public class PolygonAreaGenerator {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String iso3166_1 = null;

	private String iso3166_2 = null;

	private String fixFile = null;

	private String areaData = null;

	private String targetFile = null;

	private String lexDir = null;

	private String outputDir = null;

	private String workspace = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List targetList = null;

	List codeList = null;

	List codefixList = null;

	List areaList = null;

	/* Hash map to hold aggregate polygon area values */
	HashMap<String, String> areaValues = null;

	/**
	 * String used to indicate default value for unknown areas.
	 */
	String DEFAULT = "0"; //$NON-NLS-1$

	/**
	 * Constructor
	 * 
	 * @param iso3166_1 -
	 *            data file with the ISO3166-1 ALPHA_2 and ALPHA_3 codes.
	 * @param iso3166_2 -
	 *            data file with the ISO3166-2 codes.
	 * @param fixFile -
	 *            file containing missing ISO3166-2 codes
	 * @param areaData -
	 *            file containing area data in SQ KM
	 * @param targetFile
	 *            the list of countries for which we will generate GML files
	 * @param lexDir
	 *            folder containing lexicographically sorted files
	 * @param outputDir
	 *            the output directory for the GML files we generate
	 */
	// public PolygonAreaGenerator(String iso3166_1, String iso3166_2,
	// String fixFile, String areaData, String targetFile, String lexDir,
	// String outputDir) {
	// // Set values of global variables.
	// this.iso3166_1 = iso3166_1;
	// this.iso3166_2 = iso3166_2;
	// this.fixFile = fixFile;
	// this.areaData = areaData;
	// this.targetFile = targetFile;
	// this.lexDir = lexDir;
	// this.outputDir = outputDir;
	// targetList = null;
	// }
	/**
	 * @param configFile
	 */
	public PolygonAreaGenerator(String configFile) {

		// Load all configuration variables
		HashMap<String, String> vars = GenUtils.loadConfigFile(configFile);

		areaValues = new HashMap<String, String>();

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
			} else if (var.equals("AREA_POP")) { //$NON-NLS-1$
				areaData = vars.get(var);
			} else if (var.equals("TARGET_LIST")) { //$NON-NLS-1$
				targetFile = vars.get(var);
			} else if (var.equals("LEX_DIR")) { //$NON-NLS-1$
				lexDir = vars.get(var);
			} else if (var.equals("OUTPUT")) { //$NON-NLS-1$
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
			targetFile = path + GenConstants.COUNTRIES_LIST;
		}
		if (areaData == null) {
			areaData = path + GenConstants.AREA_POPULATION_DIR;
		}
		if (lexDir == null) {
			lexDir = path + GenConstants.LEX_DIR;
		}
		if (outputDir == null) {
			outputDir = path + GenConstants.POLYGON_AREAS_DIR;
		}

		targetList = null;
	}

	/**
	 * Convert the value of string to a double
	 * 
	 * @param str
	 *            a numeric string
	 * 
	 * @return double value of a numeric string
	 */
	protected double getDouble(String str) {
		Double holder = new Double(str);
		return holder.doubleValue();
	}

	/**
	 * Remove decimal point from value and return its string representation
	 * 
	 * @param degrees
	 *            an angle in degrees
	 * 
	 * @return formatted string a formatted angle in degress
	 */
	protected String format(double degrees) {
		String str = null;
		String subStr = null;

		str = Double.toString(degrees);
		int dot = str.indexOf("."); //$NON-NLS-1$
		subStr = str.substring(0, str.length() < dot + 7 ? str.length()
				: dot + 7);
		return subStr;

	} // formatData

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
		PrintWriter polygonAreaFile = null;

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

		// Sum of the areas at level 1
		// double areaSum = 0.0;

		int size = targetList.size();

		// Iterate for every country and create its GML data file.
		for (int i = 0; i < size; i++) {

			// Get the next country in the list.
			String file = ((String) targetList.get(i)).trim();

			// An index for unknwon or n.a. entries
			int unkCounter = 1;

			// We use this list to keep track of duplicated polygons.
			List<STEMPolygon> polygons = new ArrayList<STEMPolygon>();

			// Open the data source file for this country.
			BufferedReader reader = GenUtils.openReader(file);

			System.out
					.println("\t\t<<<< POLYGON AREA GENERATOR -- Processing country : " + file + " >>>>"); //$NON-NLS-1$ //$NON-NLS-2$
			try {

				if (reader != null) {

					String buffer = null;
					// Describes level
					// of data we
					// are now processing : LEVEL0, LEVEL1, or LEVEL2.
					int level = -1;

					// Record the previous type.
					int oldlevel = level - 1;

					// String used to ignore repeated entries.
					// String repeatedEntries = null;
					List<String> entryList = null;

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

						// Read and keep in memory a list of the area data
						// for this
						// country.
						if (areaList == null) {
							String name = areaData + isoCode.getName()
									+ "_AREA.txt"; //$NON-NLS-1$
							areaList = GenUtils.populateList(name);
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

							// if (oldlevel >= 0) {
							// System.out.println("Sum area for level "
							// + level + " is : " + areaSum);
							// areaSum = 0.0;
							// }

							// Write all keys in our hash map
							if (areaValues.isEmpty() == false) {
								Set<String> keys = areaValues.keySet();
								Iterator it = keys.iterator();
								while (it.hasNext()) {
									String key = (String) it.next();
									String value = areaValues.get(key);
									output = key + ":" + value + "\n"; //$NON-NLS-1$ //$NON-NLS-2$								
									GenUtils.addData(polygonAreaFile, output);
								}
								// Clear our hash map
								areaValues.clear();
							}

							// Keep track of previous level in order to detect
							// transitions.
							oldlevel = level;
							// Reset our repeated history
							if (entryList != null) {
								entryList.clear();
							}
							entryList = new ArrayList<String>();
							// Reset counter of UNKNOWN and N.A. entries.
							unkCounter = 1;
							// Close the previous file
							if (polygonAreaFile != null) {
								polygonAreaFile.close();
							}

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
							// polygon area file.
							fileName = countryDir + "\\" + isoCode.getAlpha3() //$NON-NLS-1$
									+ "_" + level + "_POLYAREA.txt"; //$NON-NLS-1$ //$NON-NLS-2$

							// Open the writer for the new polygon area file
							polygonAreaFile = GenUtils.openWriter(fileName);

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
								// this country
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

							// STEP 2: piece together the ID using the proper
							// lex objects.
							descriptor = lex1Current.getDescriptor()
									+ "-G" //$NON-NLS-1$
									+ lex1Current.getFormattedIndex()
									+ lex2Current.getFormattedIndex();

							if (current.contains(".L2.")) { //$NON-NLS-1$
								current = descriptor;
							}

						} else { // Compose descriptor for level 1 and level
							// 0 data.
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

						String area = null;

						// areaSum += getPolygonArea(polygon);
						area = format(getPolygonArea(polygon));

						// Format output data as follows:

						String container = null;

						switch (level) {

						case 0:
							container = current;
							break;
							
						case 1:
							container = items[ISOData.COUNTRY_NAME];
							break;

						case 2:
							container = items[ISOData.ADMIN1_NAME];
							break;

						}

						String key = container
								+ ":" + current + ":" + descriptor; //$NON-NLS-1$ //$NON-NLS-2$
						
						if (areaValues.containsKey(key) == false) {
							areaValues.put(key, area);
						} else {							
							String val = areaValues.get(key);
							Double aggregateArea = Double.parseDouble(val)
									+ Double.parseDouble(area);
							areaValues.put(key, aggregateArea.toString());
						}

						// output = container + ":" + current + ":" + descriptor
						// //$NON-NLS-1$ //$NON-NLS-2$
						// + ":" + area + "\n"; //$NON-NLS-1$ //$NON-NLS-2$

						// GenUtils.addData(polygonAreaFile, output);

					} // while loop

					Set<String> keys = areaValues.keySet();
					Iterator it = keys.iterator();
					while (it.hasNext()) {
						String key = (String) it.next();
						String value = areaValues.get(key);
						String output = key + ":" + value + "\n"; //$NON-NLS-1$ //$NON-NLS-2$						
						GenUtils.addData(polygonAreaFile, output);
					}
					// Clear our hash map
					areaValues.clear();

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

					// Clear the area list.
					if (areaList != null) {
						areaList.clear();
						areaList = null;
					}

					// Close all open resources.
					reader.close();

					if (polygonAreaFile != null) {
						// Write formatted output
						polygonAreaFile.close();
						polygonAreaFile = null;
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
	 * get the area in square km of a child polygon inside a parent of known
	 * area (sq km). e.g., the fractional area of a state occupied by a county.
	 * 
	 * @param child
	 *            a location.
	 * 
	 * @param parent
	 *            the container for the location (child).
	 * 
	 * @param parentAreaInSqKm
	 *            area for the container in square kilometers.
	 * 
	 * @return area of child in sq km
	 */
	public static double getChildAreaSqKm(STEMPolygon child,
			STEMPolygon parent, double parentAreaInSqKm) {
		double area2 = getPolygonArea(child);
		double area1 = getPolygonArea(parent);
		double result = area2 / area1;
		assert (result <= 1.0);
		result *= parentAreaInSqKm;
		return result;
	}

	/**
	 * get the area in square km of a child polygon inside a parent of known
	 * area (sq km). e.g., the fractional area of a state occupied by a county.
	 * 
	 * @param childSet
	 *            as set of polygon children (may be a group of islands)
	 * @param parentSet
	 *            a set of polygon parents (may be a group of islands)
	 * 
	 * @param parentAreaInSqKm
	 *            area of the container in square kilometers.
	 * 
	 * @return area of child in sq km
	 */
	public static double getChildAreaSqKm(Set childSet, Set parentSet,
			double parentAreaInSqKm) {
		double area2 = getPolygonArea(childSet);
		double area1 = getPolygonArea(parentSet);
		double result = area2 / area1;
		assert (result <= 1.0);
		result *= parentAreaInSqKm;
		return result;
	}

	/**
	 * get the area of any STEM polygon in polygon lt,lg units
	 * 
	 * @param p
	 *            a STEM polygon
	 * 
	 * @return the area in polygon units for the STEM polygon
	 */
	public static double getPolygonArea(STEMPolygon p) {

		double area = 0.0;
		Double[] ltPoints = p.getLtPoints();
		Double[] lgPoints = p.getLgPoints();
		int n = ltPoints.length;
		for (int i = 0; i < n - 1; i++) {
			// System.out.println("****************** ****************");
			// System.out.println(" ltPoints[" + i + "] = " +
			// ltPoints[i].doubleValue() );
			// System.out.println(" ltPoints[" + (i + 1) + "] = "
			// + ltPoints[i + 1].doubleValue() );
			// System.out.println(" lgPoints[" + i + "] = " +
			// lgPoints[i].doubleValue());
			// System.out.println(" lgPoints[" + (i + 1) + "] = "
			// + lgPoints[i + 1].doubleValue());
			// System.out.println("****************** ****************");
			area += (ltPoints[i].doubleValue() * lgPoints[i + 1].doubleValue())
					- (ltPoints[i + 1].doubleValue() * lgPoints[i]
							.doubleValue());
		} // next point
		// System.out.println("Area is : " + area);
		area /= 2.0;

		return Math.abs(area);
	}

	/**
	 * get the area of any polygon in polygon x,y units
	 * 
	 * @param polySet -
	 *            a set of java.awt.Polygon all representing one location this
	 *            might be a cluster of islands that together make up a place
	 * 
	 * @return the area in polygon x,y units
	 */
	public static double getPolygonArea(Set polySet) {
		double area = 0.0;
		Iterator iter = polySet.iterator();
		while (iter.hasNext()) {
			double inner = 0.0;
			Polygon p = (Polygon) iter.next();
			int[] x = p.xpoints;
			int[] y = p.ypoints;
			int n = x.length;
			for (int i = 0; i < n - 1; i++) {
				inner += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
			} // next point
			inner /= 2.0;
			area += Math.abs(inner);
		} // next polygon
		return area;
	}

	/**
	 * Find the population value for a given entity.
	 * 
	 * @param entity
	 *            the location for which we want to find the area
	 * 
	 * @param entityContainer
	 *            a container for the location (entity)
	 * 
	 * @param level
	 *            the administrative level
	 * 
	 * @return the area value
	 */
	protected String getArea(String entity, String entityContainer, int level) {

		final int ENTITY = 0;

		final int LEVEL = 1;

		final int AREA = 2;

		String[] areaData = null;

		Iterator it = areaList.iterator();

		String entityStr = entity.toUpperCase().trim();

		entityStr = entityStr.replace("\\t", ""); //$NON-NLS-1$ //$NON-NLS-2$

		String entityContainerStr = entityContainer.toUpperCase();

		while (it.hasNext()) {

			areaData = ((String) it.next()).split(":"); //$NON-NLS-1$

			String[] compare = null;

			// Get the entity name and remove blanks
			String location = areaData[ENTITY].toUpperCase().trim();

			location = location.toUpperCase().trim();

			// Handle Aliases -- complex stuff :$
			if (location.contains("[")) { //$NON-NLS-1$

				location = location.replace("]", ""); //$NON-NLS-1$ //$NON-NLS-2$

				// Tokenize
				StringTokenizer tokens = new StringTokenizer(location, "["); //$NON-NLS-1$

				// Get tokens -> order matters here!
				compare = new String[tokens.countTokens()];
				int i = 0;
				while (tokens.hasMoreTokens()) {
					compare[i++] = tokens.nextToken().toUpperCase().trim();
				}
			}

			if (compare != null) {
				for (int i = 0; i < compare.length; i++) {
					if (entityStr.replace("-", " ").equals( //$NON-NLS-1$ //$NON-NLS-2$
							compare[i].replace("-", " ")) //$NON-NLS-1$ //$NON-NLS-2$
							|| compare[i].equals(entityStr + "-1") //$NON-NLS-1$
							|| compare[i].equals(entityContainerStr)) {

						// Check both entities belong to same level
						if (String.valueOf(level)
								.equals(areaData[LEVEL].trim()) == false) {
							// Ignore : same name , but different level
							continue;
						}

						return areaData[AREA].trim();

					}

				}
			} else if (entityStr.equals(location)
					|| entityStr.replace("-", " ").equals(location) //$NON-NLS-1$ //$NON-NLS-2$
					|| location.equals(entityStr + "-1")) { //$NON-NLS-1$

				// Check both entities belong to same level
				if (String.valueOf(level).equals(areaData[LEVEL].trim()) == false) {
					// Ignore : same name , but different level
					continue;
				}
				return areaData[AREA].trim();
			}

		} // while

		return DEFAULT;
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
		// final int AREA_DATA = 3;
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
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Area data file"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//		
		// PolygonAreaGenerator gen = new PolygonAreaGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[AREA_DATA],
		// args[TARGET_LIST], args[LEX_DIR], args[OUTPUT_DIR]);
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

		PolygonAreaGenerator gen = new PolygonAreaGenerator(args[CONFIG_FILE]);

		gen.run();
	}

}

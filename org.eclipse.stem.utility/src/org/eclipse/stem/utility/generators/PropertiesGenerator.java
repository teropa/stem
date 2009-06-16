package org.eclipse.stem.utility.generators;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * STEM II Data Migration/Generation Utilities --This class generates all the
 * property files for each country. It does so by invoking the Name, Area,
 * Population, and Node Data generators.
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/PropertiesGenerator.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\PropertiesGenerator.config)
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 */

public class PropertiesGenerator {

	/**
	 * Execution entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// final int ISO_3166_1 = 0;
		// final int ISO_3166_2 = 1;
		// final int FIX_FILE = 2;
		// final int CIA_DATA = 3;
		// final int POPULATION_PROFILE = 4;
		// final int COUNTRY_LIST = 5;
		// final int POLYGON_AREAS = 6;
		// final int LEX_DIR = 7;
		// final int PROPERTIES_OUTPUT_DIR = 8;
		// final int GML_OUTPUT_DIR = 9;
		// final int PARAMS = 10;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t CIA data"); //$NON-NLS-1$
		// System.out.println("\t\t Population profile"); //$NON-NLS-1$
		// System.out.println("\t\t Target countries file"); //$NON-NLS-1$
		// System.out.println("\t\t Polygon areas"); //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$$
		// System.out.println("\t\t Output directory for properties files");
		// //$NON-NLS-1$
		// System.out.println("\t\t Output directory for GML maps");
		// //$NON-NLS-1$
		// return;
		// }

		// // Generate the names.properties files for each country.
		// NameGenerator nameGen = new NameGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[COUNTRY_LIST],
		// args[LEX_DIR], args[PROPERTIES_OUTPUT_DIR]);
		// nameGen.run();
		//
		// // Run garbage collection
		// System.gc();
		//
		// // Generate the population.properties files for each country.
		// PopulationGenerator popGen = new
		// PopulationGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[CIA_DATA],
		// args[POPULATION_PROFILE], args[COUNTRY_LIST], args[LEX_DIR],
		// args[PROPERTIES_OUTPUT_DIR]);
		// popGen.run();
		//
		// // Run garbage collection
		// System.gc();
		//
		// // Generate the area.properties files for each country.
		// AreaGenerator areaGen = new AreaGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[CIA_DATA],
		// args[COUNTRY_LIST], args[POLYGON_AREAS], args[LEX_DIR],
		// args[PROPERTIES_OUTPUT_DIR]);
		// areaGen.run();
		//
		// // Run garbage collection
		// System.gc();
		//
		// // Generate the node.properties files for each country.
		// NodeDataGenerator nodeDataGen = new
		// NodeDataGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[COUNTRY_LIST],
		// args[LEX_DIR], args[PROPERTIES_OUTPUT_DIR]);
		// nodeDataGen.run();
		//
		// // Run garbage collection
		// System.gc();
		//
		// // Generate the GML files for each country.
		// GMLGenerator gmlGen = new GMLGenerator(args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE], args[COUNTRY_LIST],
		// args[LEX_DIR], args[GML_OUTPUT_DIR]);
		// gmlGen.run();

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		// Generate the names.properties files for each country.
		NameGenerator nameGen = new NameGenerator(args[CONFIG_FILE]);
		nameGen.run();

		// Run garbage collection
		System.gc();

		// Generate the population.properties files for each country.
		PopulationGenerator popGen = new PopulationGenerator(args[CONFIG_FILE]);
		popGen.run();

		// Run garbage collection
		System.gc();

		// Generate the area.properties files for each country.
		AreaGenerator areaGen = new AreaGenerator(args[CONFIG_FILE]);
		areaGen.run();

		// Run garbage collection
		System.gc();

		// Generate the node.properties files for each country.
		NodeDataGenerator nodeDataGen = new NodeDataGenerator(args[CONFIG_FILE]);
		nodeDataGen.run();

		// Run garbage collection
		System.gc();

		// Generate the GML files for each country.
		GMLGenerator gmlGen = new GMLGenerator(args[CONFIG_FILE]);
		gmlGen.run();

	} // main
}

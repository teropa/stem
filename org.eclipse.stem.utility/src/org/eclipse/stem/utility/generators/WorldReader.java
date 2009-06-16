package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
 * STEM II Data Migration/Generation Utilities -- Instances of this utility class take as input
 * a file containing a list of all input data we want to read. The input should
 * be in ESRI format and the output is a plain text file.
 *
 *
 * NOTE: to run instances of this class, we need MapReader.java from STEM I.
 * Once we get MapReader, we need to uncomment lines 111-113 in this file.
 * 
 * Add the following values to the run configuration:
 * 
 * C:\EclipseProjects\workspace2\GreenScreen\dataMigration\input\world\NorthAmerica.txt
 * 
 */

/**
 * 
 * NOTE: This is just an example of a real configuration. Paths will change
 * according to the location in your machine of the ISO3166-1, ISO3166-2 data
 * files as well as the output directory and the directory where we find the
 * migrated (or extracted) area/population data from STEM I.
 * 
 * Add the following values to the run configuration:
 * 
 * 
 * 
 */

public class WorldReader {

	final int LOCATION = 0;

	final int FILE_NAME = 1;

	String[] locations = null;

	/**
	 * Constructor
	 * 
	 * @param locations
	 */
	public WorldReader(String[] locations) {

		// Set a reference to the input locations.
		this.locations = locations;

	}

	/**
	 * Process all input country files. For each country file, call MapReader on
	 * it to generate plain text file from ESRI file.
	 */
	public void processInput() {

		String input = null;

		if (locations == null) {
			System.out.println("Error: please specify an input location(s)"); //$NON-NLS-1$
			return;
		}

		int size = locations.length;

		for (int i = 0; i < size; i++) {

			try {
				// First, open the input file - process input files one at a
				// time.

				System.out.println("Location is : " + locations[i]); //$NON-NLS-1$
				BufferedReader in = new BufferedReader(new FileReader(
						locations[i]));
				while ((input = in.readLine()) != null) {
					if (input.length() > 0) {
						System.out.println("World Reader -- Input = " + input); //$NON-NLS-1$
						mapRead(input);
					}
				}
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Tokenize the input into a location and file name.
	 * 
	 * @param input
	 *            A string of the form: LOCATION;FILENAME
	 */
	public void mapRead(String input) {
		// Split input string to get the input folder and the output file name.
		String[] data = input.split(";"); //$NON-NLS-1$
		String location = data[LOCATION];
		String fileName = data[FILE_NAME];

		if (location == null || fileName == null) {
			return;
		}
		System.out.println("Location is : " + location); //$NON-NLS-1$
		System.out.println("File name is : " + fileName); //$NON-NLS-1$
		MapReader mr = new MapReader(fileName.trim());
		mr.readDirectory(location.trim());
		mr.closeFile();
	}

	/**
	 * Execution entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WorldReader wr = new WorldReader(args);
		wr.processInput();
	}

}

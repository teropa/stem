package org.eclipse.stem.utility.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * STEM II Data Migration/Generation Utilities -- Instances of this utility
 * class collect all the URLs and stores them in a single file.
 * 
 */

public class URLGenerator {

	/**
	 * Our source files for ISO 3166-1 codes and for the list of target
	 * countries.
	 */

	private String isoFile = null;

	private String urlFile = null;

	private String outputDir = null;

	/**
	 * List for ISO 3166-1 codes and target countries.
	 */

	List urls = null;

	List codeList = null;

	/**
	 * Constructor
	 * 
	 * @param isoFile
	 *            data file containing the ISO3166-1 codes
	 * @param urlFile -
	 *            the directory containing URLs for countries in out data set
	 * @param outputDir -
	 *            the output directory for the files generated.
	 * 
	 */
	public URLGenerator(String isoFile, String urlFile, String outputDir) {
		this.isoFile = isoFile;
		this.urlFile = urlFile;
		this.outputDir = outputDir;
	}

	/**
	 * This method sets up and runs this generator.
	 * 
	 */
	public void run() {
		// Read and keep in memory a list of the countries we want.
		urls = GenUtils.populateList(urlFile);

		// Read and keep in memory a list of the ISO3166-1 ALPHA2, ALPHA3, and
		// numeric codes.
		codeList = GenUtils.populateList(isoFile);

		// Now, process each item in the target list.
		process();
	}

	/**
	 * Process our global list of countries -- find and add a URL for each
	 * country.
	 * 
	 */
	public void process() {

		final int COUNTRY = 0;
		PrintWriter outputFile = null;

		// A URL location is a folder with URL files
		// for every URL location
		for (int i = 0; i < urls.size(); i++) {

			// Get the next URL location in the list.
			String urlLocation = ((String) urls.get(i)).trim();

			// If this line starts with "#", then ignore it.
			if (urlLocation.trim().startsWith("#")) { //$NON-NLS-1$
				continue;
			}

			System.out
					.println("URL is : " + urlLocation); //$NON-NLS-1$

			// Open the URL location (a folder that contains URL files)
			File dir = GenUtils.openDirectory(urlLocation);

			try {

				if (dir != null) {

					// Get a URL file
					File[] urlFiles = dir.listFiles();

					for (int j = 0; j < urlFiles.length; j++) {

						BufferedReader reader = GenUtils.openReader(urlFiles[j]
								.getAbsolutePath());

						String url = null;

						// Read a URL
						while (GenUtils.EOF(url = reader.readLine()) != true) {
							System.out.println(Messages
									.getString("URLGenerator.2") + url); //$NON-NLS-1$
							// If this line starts with "#", then ignore it.
							if (url.trim().startsWith("#")) { //$NON-NLS-1$
								break;
							}

							String[] tokens = urlFiles[j].getName()
									.split("\\."); //$NON-NLS-1$

							// Get the ISO3166-1 info for this country
							ISOCode1 isoCode = GenUtils.getISOCode(
									tokens[COUNTRY], codeList);
							if (isoCode == null) {
								System.out.println(Messages
										.getString("URLGenerator.5") //$NON-NLS-1$
										+ tokens[COUNTRY]);
								break;
							}

							// Open output file
							if (outputFile == null) {
								String fileName = outputDir;
								fileName += tokens[COUNTRY]
										+ Messages.getString("URLGenerator.6"); //$NON-NLS-1$
								outputFile = GenUtils.openWriter(fileName);
							}

							// Now write the URL to our file
							outputFile.write(isoCode.getName() + ":" //$NON-NLS-1$
									+ isoCode.getAlpha3() + ":" + url + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
							System.out.println(isoCode.getName() + ":" //$NON-NLS-1$
									+ isoCode.getAlpha3() + ":" + url + "\n"); //$NON-NLS-1$ //$NON-NLS-2$

						} // internal while

						reader.close();

						if (outputFile != null) {
							outputFile.close();
							outputFile = null;
						}

						// Run garbage collection
						System.gc();

					} // for j

				} // if (dir != null)s

			} catch (IOException e) {
				e.printStackTrace();
			}

		} // for i

	}

	/**
	 * Execution entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final int ISO_FILE = 0;
		final int URL_INDEX = 1;
		final int OUTPUT_DIR = 2;
		final int PARAMS = 3;

		if (args.length < PARAMS) {

			System.out.println("--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\tTo run, please provide the following arguments : "); //$NON-NLS-1$			
			System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
			System.out.println("\t\t URL index file"); //$NON-NLS-1$			
			System.out.println("\t\t Output directory"); //$NON-NLS-1$				
			return;
		}

		URLGenerator gen = new URLGenerator(args[ISO_FILE], args[URL_INDEX],
				args[OUTPUT_DIR]);
		gen.run();
	}

}

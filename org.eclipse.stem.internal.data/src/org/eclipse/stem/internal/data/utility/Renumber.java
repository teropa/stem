// Renumber.java
package org.eclipse.stem.internal.data.utility;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class holds a utility function for numbering the record entries of a
 * properties file.
 * 
 * It probably could be fixed up a bit to make it easier to use....
 */
public class Renumber {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final File inputFile = new File(
				"resources/data/relationship/relativephysical/ZZZ_-1_ZZZ_0.properties");
		final File outputFile = new File(
				"resources/data/relationship/relativephysical/ZZZ_-1_ZZZ_0.renumbered");
		renumber(inputFile, outputFile);
	} // main

	/**
	 * @param infile
	 *            the file to number
	 * @param outfile
	 *            the file to write the results to
	 */
	public static void renumber(final File infile, final File outfile) {
		try {
			final FileReader fileReader = new FileReader(infile);
			final FileWriter fileWriter = new FileWriter(outfile);

			final BufferedReader in = new BufferedReader(fileReader);
			final BufferedWriter out = new BufferedWriter(fileWriter);

			boolean startNumbering = false;
			int counter = 0;
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				// Should we start numbering lines?
				startNumbering = startNumbering
						|| inputLine.equalsIgnoreCase("# Start Here");
				// Number this line?
				if (startNumbering) {
					// Yes
					final StringBuilder sb = new StringBuilder(Integer
							.toString(counter++));
					sb.append(" = ");
					sb.append(inputLine);
					sb.append("\n");
					out.write(sb.toString());
				} else {
					// No
					out.write(inputLine + "\n");
				}
			} // while
			out.flush();

			in.close();
			out.close();
			System.out.println("Renumbered " + (counter - 1) + " lines");
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	} // renumber
} // Renumber

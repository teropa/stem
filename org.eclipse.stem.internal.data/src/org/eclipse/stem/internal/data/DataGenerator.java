package org.eclipse.stem.internal.data;

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

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.stem.internal.data.specifications.IdentfiableSpecificationFactory;
import org.eclipse.stem.internal.data.specifications.IdentifiablePropertyFileSpecification;

/**
 * This class is the Main entry point to the generation of
 * {@link org.eclipse.stem.core.graph.Graph}s from internal data sets.
 */
abstract public class DataGenerator {

	/**
	 * This is the path to the root directory of the property files that define
	 * the graphs.
	 */
	public static final String ROOT_PROPERTY_FILES = "resources"
			+ File.separator + "data";
	/**
	 * This is the path to the root directory of the serialized files
	 */
	public static final String ROOT_SERIALIZED_FILES = "temp" + File.separator
			+ "data";

	protected List<IdentifiablePropertyFileSpecification> processFiles(
			String[] args) {
		List<IdentifiablePropertyFileSpecification> retValue = new ArrayList<IdentifiablePropertyFileSpecification>();

		// Is the root directory specified?
		if (args.length == 0) {
			// Yes
			System.err
					.println("Missing specification of source directory as an argument");
		} // if
		else {
			final String sourceDir = args[0];

			final String propertyRootDir = sourceDir + File.separator
					+ ROOT_PROPERTY_FILES;
			final String serializationRootDir = sourceDir + File.separator
					+ ROOT_SERIALIZED_FILES;

			try {
				retValue = createIdentifiablePropertyFileSpecifications(propertyRootDir);

				// Now serialize the Identifiables
				for (IdentifiablePropertyFileSpecification identifiablePropertyFileSpecification : retValue) {
					identifiablePropertyFileSpecification
							.serialize(serializationRootDir);
				}
			} // try
			catch (IOException e) {
				e.printStackTrace();
			} // catch IOException
		} // else
		return retValue;
	} // processFiles

	/**
	 * Process all of the property files and create all of the
	 * {@link IdentifiablePropertyFileSpecification}s they define.
	 * 
	 * @param propertyFileRootDirectory
	 *            this is the path relative to the workspace that specifies the
	 *            directory that is the root of all of the property files that
	 *            contain data that specifies the contents of the
	 *            {@link IdentifiablePropertyFileSpecification}s.
	 * 
	 * @return a {@link List} of {@link IdentifiablePropertyFileSpecification}s
	 *         created from the property files
	 */
	protected List<IdentifiablePropertyFileSpecification> createIdentifiablePropertyFileSpecifications(
			final String propertyFileRootDirectory) {

		final List<IdentifiablePropertyFileSpecification> retValue = new ArrayList<IdentifiablePropertyFileSpecification>();

		// Recursively descend the directory structure rooted at
		// propertyFileRootDirectory and retrieve all of the property files we
		// find.
		final List<File> propertyFiles = getPropertyFiles(new File(
				propertyFileRootDirectory));

		// Each property file contains a property that names a class that can
		// parse/process its contents to create an instance of DataSetRecord.
		// The factory IdentfiableSpecificationFactory extracts that name and
		// creates an instance of the specified class. That instance then
		// processes the rest of the property file to create an instance of
		// DataSetData which it retains internally.

		// Process each property file to create the DataSetRecord it specifies.
		int skippedFiles = 0;
		for (final File propertyFile : propertyFiles) {

			final IdentifiablePropertyFileSpecification identifiableSpecification = IdentfiableSpecificationFactory.INSTANCE
					.createIdentifiablePropertyFileSpecification(propertyFile);
			// Did we create one?
			if (identifiableSpecification != null) {
				// Yes
				retValue.add(identifiableSpecification);
			} else {
				// No
				skippedFiles++;
			}
		} // for each property file

		if (skippedFiles > 0) {
			System.out.println("Skipped " + skippedFiles
					+ " incorrect property file"
					+ (skippedFiles == 1 ? "" : "s"));
		}

		System.out.println("Created " + retValue.size() + " GraphRecord"
				+ (retValue.size() == 1 ? "" : "s"));

		// System.out.println("Created " + retValue.getNumModelRecords()
		// + " ModelRecord"
		// + (retValue.getNumModelRecords() == 1 ? "" : "s"));

		return retValue;
	} // createIdentifiablePropertyFileSpecifications

	/**
	 * @param directory
	 *            the top-level directory containing property files and other
	 *            sub-directories that contain property files. The directory
	 *            will be recursively processed to find property files.
	 * @return a list of the property files that contain property definitions
	 */
	private List<File> getPropertyFiles(final File directory) {

		final List<File> retValue = new ArrayList<File>();

		// Does it exist and is it a directory?
		if (directory.exists() && directory.isDirectory()) {
			// Yes
			// Get all of the property files from the directory...
			final File[] propertyFiles = directory.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					final String name = pathname.getName();

					boolean valid = pathname.isFile()
							&& name.endsWith(".properties")
							&& !name.endsWith("names.properties")
							&& !name.endsWith("centers.properties");

					return valid;
				}
			});

			// ...and add them the list we're returning
			Collections.addAll(retValue, propertyFiles);

			// Now get the sub-directories...
			final File[] subDirectories = directory.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.isDirectory()
							&& !pathname.getName().equals(".svn")
							&& !pathname.getName().equals("CVS");
				}
			});

			// ...and process them recursively to get their properties files too
			for (final File subDirectory : subDirectories) {
				retValue.addAll(getPropertyFiles(subDirectory));
			}

		} // if directory
		else {
			System.err.println("The directory \"" + directory.getAbsolutePath()
					+ "\" doesn't exist or is not a directory");
		}
		return retValue;
	} // getGraphPropertyFiles
} // DataGenerator

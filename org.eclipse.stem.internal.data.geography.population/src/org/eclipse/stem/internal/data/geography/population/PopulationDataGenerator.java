package org.eclipse.stem.internal.data.geography.population;

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

import org.eclipse.stem.internal.data.DataGenerator;
import org.eclipse.stem.internal.data.geography.GeographyPluginFileGenerator;

/**
 * This class is the Main entry point to the generation of
 * {@link org.eclipse.stem.core.graph.Graph}s and
 * {@link org.eclipse.stem.core.model.Model}s that represent Geography.
 * 
 */
public class PopulationDataGenerator extends DataGenerator {
	/**
	 * @param args
	 *            the path to the root of the plugin where this class is
	 *            defined.
	 */
	public static void main(String[] args) {
		final PopulationDataGenerator dg = new PopulationDataGenerator();
		final GeographyPluginFileGenerator gpfg = new GeographyPluginFileGenerator();
		gpfg.generatePluginFiles(dg.processFiles(args),args[0] + File.separator +  ROOT_SERIALIZED_FILES, false);	} // main

} // Main

// TransportationDataGenerator.java
package org.eclipse.stem.internal.data.geography.infrastructure.transportation;

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
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.internal.data.ModelGenerator;
import org.eclipse.stem.internal.data.PluginFileGenerator;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.Extension;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginFactory;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.geography.GeographyDataGenerator;
import org.eclipse.stem.internal.data.geography.GeographyPluginFileGenerator;
import org.eclipse.stem.internal.data.geography.infrastructure.transportation.specifications.TransportationGeographicRelationshipPropertyFileSpecification;
import org.eclipse.stem.internal.data.specifications.IdentifiablePropertyFileSpecification;

/**
 * This class is the Main entry point to the generation of
 * {@link org.eclipse.stem.core.graph.Graph}s that represent Transportation.
 */
public class TransportationDataGenerator extends GeographyDataGenerator {
	/**
	 * @param args
	 *            the path to the root of the plugin where this class is
	 *            defined.
	 */
	public static void main(String[] args) {

		// Is the plugin file specified?
		if (args.length == 0) {
			// Yes
			System.err
					.println("Missing specification of the generated files path"); //$NON-NLS-1$
		} // if
		else {
			final String GENERATED_FILES_PATH = args[0];

			final TransportationDataGenerator tdg = new TransportationDataGenerator();

			final List<IdentifiablePropertyFileSpecification> specs = tdg
					.processFiles(new String[] { "." }); //$NON-NLS-1$

			// Create the instance of plugin.xml that we'll serialize later
			final Plugin pluginxml = GeneratedpluginFactory.eINSTANCE
					.createPlugin();
			final Extension extension = GeneratedpluginFactory.eINSTANCE
					.createExtension();

			// Add the "model" extension point
			extension.setPoint(Constants.ID_GRAPH_EXTENSION_POINT);

			pluginxml.getExtensionelement().add(extension);

			// // Now add the dublin core entries to the plugin.xml file for
			// // each of the graphs

			for (IdentifiablePropertyFileSpecification spec : specs) {

				TransportationGeographicRelationshipPropertyFileSpecification roadSpec = (TransportationGeographicRelationshipPropertyFileSpecification) spec;
				// final StemCategory countryCategory =
				// GeneratedpluginFactory.eINSTANCE
				// .createStemCategory();

				final ISOKey isoKey = roadSpec.getIsoKeyA();

				final String COUNTRY_CATAGORY_STRING = GeographyPluginFileGenerator.ID_GRAPH_GEOGRAPHY_POLITICAL_COUNTRIES_CATEGORY
						+ "." + isoKey.toString().toLowerCase(); //$NON-NLS-1$

				final DublinCore dc = GeneratedpluginFactory.eINSTANCE
						.createDublinCore();
				dc.setCategoryId(COUNTRY_CATAGORY_STRING);
				extension.getDublinCores().add(
						ModelGenerator.populateGeneratedDC(dc, roadSpec
								.getIdentifiable().getDublinCore()));
			} // for

			final URI TEMP_PLUGINXML_URI = URI
					.createFileURI(GENERATED_FILES_PATH + File.separator
							+ PluginFileGenerator.PLUGIN_XML_FILE_NAME);

			// Serialize the plugin.xml file.
			ModelGenerator.writePluginxml(pluginxml, TEMP_PLUGINXML_URI);
			//
			// // Create the plugin.properties file
			// createPluginPropertties(GENERATED_FILES_PATH);
		} // if
	} // main

} // TransportationDataGenerator
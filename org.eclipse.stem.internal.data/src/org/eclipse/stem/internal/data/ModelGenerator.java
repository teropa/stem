// ModelGenerator.java
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.generatedplugin.GeneratedpluginPackage;
import org.eclipse.stem.internal.data.generatedplugin.Plugin;
import org.eclipse.stem.internal.data.generatedplugin.util.GeneratedpluginResourceFactoryImpl;

/**
 * This class is the Main entry point to the generation of
 * {@link org.eclipse.stem.core.model.Model}s from internal data sets.
 */
abstract public class ModelGenerator {

	/**
	 * This is a kludge that basically just transfers the values from a "common"
	 * Dublin Core instance to a "GeneratedPlugin" Dublin Core instance. There's
	 * probably a better way or even a way to not have both.
	 * 
	 * @param dc
	 * @param dublinCore
	 * @return the dc instance populated from the values of the
	 *         {@link DublinCore} instance.
	 */
	public static DublinCore populateGeneratedDC(DublinCore dc, org.eclipse.stem.core.common.DublinCore dublinCore) {
	
		if (dublinCore.getIdentifier() != null
				&& !dublinCore.getIdentifier().equals("")) { //$NON-NLS-1$
			dc.setIdentifier(dublinCore.getIdentifier());
		}
		if (dublinCore.getType() != null && !dublinCore.getType().equals("")) { //$NON-NLS-1$
			dc.setType(dublinCore.getType());
		}
		if (dublinCore.getTitle() != null && !dublinCore.getTitle().equals("")) { //$NON-NLS-1$
			dc.setTitle(dublinCore.getTitle());
		}
	
		if (dublinCore.getCreator() != null
				&& !dublinCore.getCreator().equals("")) { //$NON-NLS-1$
			dc.setCreator(dublinCore.getCreator());
		}
		if (dublinCore.getSubject() != null
				&& !dublinCore.getSubject().equals("")) { //$NON-NLS-1$
			dc.setSubject(dublinCore.getSubject());
		}
		if (dublinCore.getDescription() != null
				&& !dublinCore.getDescription().equals("")) { //$NON-NLS-1$
			dc.setDescription(dublinCore.getDescription());
		}
	
		if (dublinCore.getPublisher() != null
				&& !dublinCore.getPublisher().equals("")) { //$NON-NLS-1$
			dc.setPublisher(dublinCore.getPublisher());
		}
		if (dublinCore.getContributor() != null
				&& !dublinCore.getContributor().equals("")) { //$NON-NLS-1$
			dc.setContributor(dublinCore.getContributor());
		}
		if (dublinCore.getDate() != null && !dublinCore.getDate().equals("")) { //$NON-NLS-1$
			dc.setDate(dublinCore.getDate());
		}
	
		if (dublinCore.getFormat() != null
				&& !dublinCore.getFormat().equals("")) { //$NON-NLS-1$
			dc.setFormat(dublinCore.getFormat());
		}
	
		if (dublinCore.getSource() != null
				&& !dublinCore.getSource().equals("")) { //$NON-NLS-1$
			dc.setSource(dublinCore.getSource());
		}
		if (dublinCore.getLanguage() != null
				&& !dublinCore.getLanguage().equals("")) { //$NON-NLS-1$
			dc.setLanguage(dublinCore.getLanguage());
		}
		if (dublinCore.getRelation() != null
				&& !dublinCore.getRelation().equals("")) { //$NON-NLS-1$
			dc.setRelation(dublinCore.getRelation());
		}
		if (dublinCore.getCoverage() != null
				&& !dublinCore.getCoverage().equals("")) { //$NON-NLS-1$
			dc.setCoverage(dublinCore.getCoverage());
		}
		if (dublinCore.getRights() != null
				&& !dublinCore.getRights().equals("")) { //$NON-NLS-1$
			dc.setRights(dublinCore.getRights());
		}
		if (dublinCore.getBibliographicCitation() != null
				&& !dublinCore.getBibliographicCitation().equals("")) { //$NON-NLS-1$
			dc.setBibliographicCitation(dublinCore.getBibliographicCitation());
		}
		if (dublinCore.getCreated() != null
				&& !dublinCore.getCreated().equals("")) { //$NON-NLS-1$
			dc.setCreated(dublinCore.getCreated());
		}
		if (dublinCore.getLicense() != null
				&& !dublinCore.getLicense().equals("")) { //$NON-NLS-1$
			dc.setLicense(dublinCore.getLicense());
		}
		// Seems to be missing from the generated DublinCore, no big deal.
		// if (dublinCore.getRequired() != null
		// && !dublinCore.getRequired().equals("")) {
		// dc.setRequired(dublinCore.getRequired());
		// }
		if (dublinCore.getSpatial() != null
				&& !dublinCore.getSpatial().equals("")) { //$NON-NLS-1$
			dc.setSpatial(dublinCore.getSpatial());
	
		}
		if (dublinCore.getValid() != null && !dublinCore.getValid().equals("")) { //$NON-NLS-1$
			dc.setValid(dublinCore.getValid());
		}
		return dc;
	} // populateGeneratedDC
	// Nothing

	protected Plugin getPluginxml(final URI uri) {
		Plugin retValue = null;
		try {
			final GeneratedpluginResourceFactoryImpl rfi = new GeneratedpluginResourceFactoryImpl();
	
			final XMLResource.XMLMap xmlMap = new XMLMapImpl();
			xmlMap.setNoNamespacePackage(GeneratedpluginPackage.eINSTANCE);
			final Map<String, XMLMap> options = new HashMap<String, XMLMap>();
			options.put(XMLResource.OPTION_XML_MAP, xmlMap);
	
			final Resource resource = rfi.createResource(uri);
			resource.load(options);
			retValue = (Plugin) resource.getContents().get(0);
		} catch (final Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return retValue;
	} // getPluginxml

	/**
	 * @param pluginxml
	 * @param uri
	 */
	public static void writePluginxml(final Plugin pluginxml, URI uri) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xml", //$NON-NLS-1$
				new GeneratedpluginResourceFactoryImpl());
	
		final ExtendedMetaData ext = new BasicExtendedMetaData(
				ExtendedMetaData.ANNOTATION_URI, EPackage.Registry.INSTANCE,
				new HashMap<EModelElement, EAnnotation>());
		ext.setQualified(GeneratedpluginPackage.eINSTANCE, false);
		ext.setName(GeneratedpluginPackage.Literals.EXTENSION__DUBLIN_CORES,
				"dublin_core"); //$NON-NLS-1$
		ext.setName(GeneratedpluginPackage.Literals.EXTENSION__CATEGORIES,
				"stem_category"); //$NON-NLS-1$
		ext.setName(GeneratedpluginPackage.Literals.PLUGIN__EXTENSIONELEMENT,
				"extension"); //$NON-NLS-1$
		ext.setName(GeneratedpluginPackage.Literals.STEM_CATEGORY__PARENT_ID,
				"parent_id"); //$NON-NLS-1$
		ext.setName(GeneratedpluginPackage.Literals.PLUGIN, "plugin"); //$NON-NLS-1$
		ext.setName(GeneratedpluginPackage.Literals.DUBLIN_CORE__CATEGORY_ID,
				"category_id"); //$NON-NLS-1$
		final Map<String, ExtendedMetaData> options = new HashMap<String, ExtendedMetaData>();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, ext);
	
		final ResourceSet resourceSet = new ResourceSetImpl();
	
		final Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(pluginxml);
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // writePluginxml
} // ModelGenerator
// Utility.java
package org.eclipse.stem.ui;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Label;

/**
 * This class contains common utility methods used in the STEM UI.
 */
public class Utility {

	// private static ResourceSet resourceSet = null;

	/**
	 * @return a List of the projects in the workspace that have STEM Project
	 *         "nature"
	 * 
	 * @see Constants#ID_STEM_PROJECT_NATURE
	 */
	public static List<IProject> getSTEMProjectsFromWorkspace() {
		return getSTEMProjectsFromWorkspace(ResourcesPlugin.getWorkspace());
	} // getSTEMProjectsFromWorkspace

	/**
	 * @param workspace
	 *            the workspace to search for STEM Projects
	 * @return a List of the projects in the workspace that have STEM Project
	 *         "nature"
	 * 
	 * @see Constants#ID_STEM_PROJECT_NATURE
	 */
	public static List<IProject> getSTEMProjectsFromWorkspace(
			final IWorkspace workspace) {
		final List<IProject> retValue = new ArrayList<IProject>();
		final IProject[] projects = workspace.getRoot().getProjects();
		for (final IProject project : projects) {
			// Is it a STEM project?
			if (isSTEMProject(project)) {
				// Yes
				retValue.add(project);
			}
		} // for each project
		return retValue;
	} // getSTEMProjectsFromWorkspace

	/**
	 * @param project
	 *            an Eclipse project
	 * @return <code>true</code> if the project has STEM project nature
	 * 
	 * @see Constants#ID_STEM_PROJECT_NATURE
	 */
	public static boolean isSTEMProject(final IProject project) {
		boolean retValue = false;
		try {
			for (final String nature : project.getDescription().getNatureIds()) {
				// STEM Nature?
				if (nature.equals(Constants.ID_STEM_PROJECT_NATURE)) {
					// Yes
					retValue = true;
					break;
				}
			} // for each nature
		} catch (final CoreException e) {
			// Not this project
			retValue = false;
		} // for each nature
		return retValue;
	} // isSTEMProject

	/**
	 * @param file
	 *            a file with an <code>Identifiable</code>
	 * @return the <code>Identifiable</code> de-serialized from the file, or
	 *         <code>null</code> if an error occurred.
	 */
	public static Identifiable getIdentifiable(final IFile file) {
		final URI fileURI = URI.createFileURI(file.getLocation().toString());
		return getIdentifiable(fileURI);
	} // getIdentifiable

	/**
	 * @param identifableURI
	 *            the {@link URI} of file with a serialized
	 *            <code>Identifiable</code>.
	 * @return the {@link Identifiable} de-serialized from the file, or
	 *         <code>null</code> if an error occurred.
	 */
	public static Identifiable getIdentifiable(final URI identifableURI) {
		Identifiable retValue = null;

		try {
			final ResourceSet resourceSet = new ResourceSetImpl();

			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put("*", new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
					.put("platform", new XMIResourceFactoryImpl());

			final Resource resource = resourceSet.getResource(identifableURI,
					true);
			retValue = (Identifiable) resource.getContents().get(0);
		} catch (final Exception e) {
			Activator.logError("The file \"" + identifableURI.toString()
					+ "\" was not found or was of the wrong format", e);
			retValue = null;
		}
		return retValue;
	} // getIdentifiable

	/**
	 * @param labelURI
	 *            the {@link URI} of a {@link Label}
	 * @return the {@link Label} instance, or null if not found
	 * 
	 * stem://org.eclipse.stem/label/population/AFG/2/human/2006/AF-BDS-G010001
	 *        
	 * 
	 */
	public static Label getLabel(final URI labelURI) {
		Label retValue = null;

		// Is it an area label?
		if (isAreaLabel(labelURI)) {
			// Yes
			final URI areaGraphURI = createAreaGraphURI(labelURI);
			final Graph areaGraph = (Graph) getIdentifiable(areaGraphURI);
			retValue = areaGraph.getNodeLabel(labelURI);
		} // if area
		// Is it a population label?
		else if (isPopulationLabel(labelURI)) {
			final URI populationGraphURI = createPopulationGraphURI(labelURI);
			final Graph populationGraph = (Graph) getIdentifiable(populationGraphURI);
			retValue = populationGraph.getNodeLabel(labelURI);
		} // if population

		return retValue;
	} // getLabel

	/**
	 * @param labelURI
	 * @return <code>true</code> if the {@link URI} is for an area label
	 */
	private static boolean isAreaLabel(final URI labelURI) {
		return extractLabelName(labelURI.toString()).equals("area");
	}

	/**
	 * @param labelURI
	 * @return <code>true</code> if the {@link URI} is for an population label
	 */
	private static boolean isPopulationLabel(final URI labelURI) {
		return extractLabelName(labelURI.toString()).equals("population");
	}

	/**
	 * @param labelURI
	 * @return the {@link URI} of the file that the graph containing the
	 *         {@link Label} with the labelURI would be serialized in
	 */
	private static URI createAreaGraphURI(final URI labelURI) {
		
		final String prefix = URI.createPlatformPluginURI(org.eclipse.stem.data.geography.Activator.PLUGIN_ID, false).toString();
		//final StringBuilder sb = new StringBuilder("platform:/plugin/" + org.eclipse.stem.data.geography.Activator.PLUGIN_ID + "/resources/data");
		final StringBuilder sb = new StringBuilder(prefix + "/resources/data");

		sb.append("/country/");
		// Extract the label name. Currently this only works for area
		final String uriString = labelURI.toString();
		final String labelName = extractLabelName(uriString);
		final String isoKey = extractISOKey(uriString, labelName);
		final String level = extractISOLevel(uriString, isoKey);
		sb.append(isoKey);
		sb.append("/");
		final String fileName = createAreaGraphFileName(isoKey, level, labelName);
		sb.append(fileName);
		return URI.createURI(sb.toString());
	} // createGraphURI

	private static URI createPopulationGraphURI(final URI labelURI) {
		
		final String prefix = URI.createPlatformPluginURI(org.eclipse.stem.data.geography.population.human.Activator.PLUGIN_ID, false).toString();
		//final StringBuilder sb = new StringBuilder("platform:/plugin/" + org.eclipse.stem.data.geography.population.human.Activator.PLUGIN_ID + "/resources/data");
		final StringBuilder sb = new StringBuilder(prefix + "/resources/data");

		sb.append("/country/");
		// Extract the label name. Currently this only works for area
		final String uriString = labelURI.toString();
		final String labelName = extractLabelName(uriString);
		final String isoKey = extractISOKey(uriString, labelName);
		final String level = extractISOLevel(uriString, isoKey);
		final String populationName = extractPopulationName(uriString, level);
		final String date = extractPopulationDate(uriString, populationName);
		sb.append(isoKey);
		sb.append("/");
		sb.append(createPopulationGraphFileName(isoKey, level, labelName,
				populationName, date));
		return URI.createURI(sb.toString());
	} // createPopulationGraphURI

	/**
	 * @param uriString
	 * @param populationName
	 * @return
	 */
	private static String extractPopulationDate(String uriString,
			String populationName) {
		final int index =uriString.indexOf(populationName);
		final String temp = uriString.substring(index+populationName.length()+1);
		final int index2 = temp.indexOf("/");
		return temp.substring(0, index2);
	} // extractPopulationDate

	private static String createPopulationGraphFileName(final String isoKey,
			final String level, @SuppressWarnings ("unused") final String labelName,
			final String populationName, final String date) {
		final StringBuilder sb = new StringBuilder(isoKey);
		sb.append("_");
		sb.append(level);
		sb.append("_");
		sb.append(populationName);
		sb.append("_");
		sb.append(date);
		sb.append("_");
		sb.append("population.graph");

		return sb.toString();
	} // createPopulationGraphFileName

	private static String extractPopulationName(final String uriString, String level) {
		final int index = uriString.indexOf(level);
		final String temp = uriString.substring(index+level.length()+1);
		final int index2 = temp.indexOf("/");
		return temp.substring(0,index2);
	} // extractPopulationName

	private static String extractISOLevel(final String uriString,
			final String isoKey) {
		final int index = uriString.indexOf(isoKey) + isoKey.length() + 1;
		return uriString.substring(index, index + 1);
	} // extractISOLevel

	private static String createAreaGraphFileName(final String isoKey,
			final String level, final String labelName) {
		final StringBuilder sb = new StringBuilder(isoKey);
		sb.append("_");
		sb.append(level);
		sb.append("_");
		sb.append(labelName);
		sb.append(".graph");
		return sb.toString();
	} // createFileName

	private static String extractISOKey(final String uriString,
			final String labelName) {
		final int startIndex = uriString.indexOf(labelName) + 1
				+ labelName.length();
		final int endIndex = startIndex + 3;

		return uriString.substring(startIndex, endIndex);
	} // extractISOKey

	private static String extractLabelName(final String uriString) {
		final String uriSuffix = uriString.substring(uriString
				.indexOf(Label.URI_TYPE_LABEL_SEGMENT)
				+ Label.URI_TYPE_LABEL_SEGMENT.length() + 1);
		return uriSuffix.substring(0, uriSuffix.indexOf("/"));
	} // extractLabelName

} // Utility

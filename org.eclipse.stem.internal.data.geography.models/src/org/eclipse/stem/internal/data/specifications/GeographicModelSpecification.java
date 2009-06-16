// GeographicModelSpecification.java
package org.eclipse.stem.internal.data.specifications;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.definitions.nodes.NodesPackage;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.internal.data.generatedplugin.DublinCore;
import org.eclipse.stem.internal.data.geography.specifications.AdminLevelSet;
import org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification;

/**
 * This class represents a {@link ModelSpecification} for a Geographic model.
 */
public class GeographicModelSpecification extends ModelSpecification implements
		Comparable<GeographicModelSpecification> {

	/**
	 * This is referenced to cause the {@link NodesPackage} to register itself
	 * as a package so that {@link Region}s in the {@link Graph}'s we're
	 * deserializing can be created. Without it, the package will not be found.
	 */
	@SuppressWarnings("unused")
	private final NodesPackage nodesPackage = NodesPackage.eINSTANCE;

	/**
	 * This is a map between the {@link ISOKey} of the countries in the
	 * specification and the administrative levels of the graphs included in the
	 * model. If the model is for a single country, there will be only one
	 * entry, with the ISOKey of the country as the key. If there are more than
	 * one, for instance in the case of a model that represents a continent,
	 * then there will be an entry for each country.
	 */
	private final Map<ISOKey, AdminLevelSet> countryLevelMap = new HashMap<ISOKey, AdminLevelSet>();

	private final List<DublinCore> nodeDublinCores = new ArrayList<DublinCore>();
	private final List<DublinCore> areaDublinCores = new ArrayList<DublinCore>();
	private final List<DublinCore> commonBorderEdgeDublinCores = new ArrayList<DublinCore>();
	private final List<DublinCore> containmentEdgeDublinCores = new ArrayList<DublinCore>();

	static {
		// This sets up the mapping between the "platform" URI's and the
		// projects in the file system.

		// CWD is the current working directory
		final String CWD = System.getProperty("user.dir"); //$NON-NLS-1$
		// WORKSPACE is the directory of the parent workspace
		final String WORKSPACE = CWD.substring(0, CWD
				.lastIndexOf(File.separator));

		// The path to the generated geography data project
		final String GEOGRAPHY_PROJECT_ROOT = WORKSPACE + File.separator
				+ org.eclipse.stem.data.geography.Activator.PLUGIN_ID
				+ File.separator;

		final Map<String, URI> platformResourceMap = EcorePlugin
				.getPlatformResourceMap();

		// Register the mapping between the project id and the absolute path to
		// the project in the file system. This will be found later when
		// deserializing when the platform URI is mapped.
		platformResourceMap.put(
				org.eclipse.stem.data.geography.Activator.PLUGIN_ID, URI
						.createFileURI(GEOGRAPHY_PROJECT_ROOT));
	} // static

	/**
	 * @param isoKey
	 *            the {@link ISOKey} for a single region
	 * @param levelSet
	 *            the {@link AdminLevelSet} covered
	 */
	public GeographicModelSpecification(ISOKey isoKey, AdminLevelSet levelSet) {
		countryLevelMap.put(isoKey, levelSet);
	} // GeographicModelSpecification

	/**
	 * @param nodeDCs
	 */
	public void addNodeDCs(List<DublinCore> nodeDCs) {
		nodeDublinCores.addAll(nodeDCs);
	}

	/**
	 * @param areaDCs
	 */
	public void addAreaDCs(List<DublinCore> areaDCs) {
		areaDublinCores.addAll(areaDCs);
	}

	/**
	 * @param commonBorderEdgeDCs
	 */
	public void addCommonBorderEdgeDCs(List<DublinCore> commonBorderEdgeDCs) {
		commonBorderEdgeDublinCores.addAll(commonBorderEdgeDCs);
	}

	/**
	 * @param containmentEdgeDCs
	 */
	public void addContainmentEdgeDCs(List<DublinCore> containmentEdgeDCs) {
		containmentEdgeDublinCores.addAll(containmentEdgeDCs);
	}

	/**
	 * @see org.eclipse.stem.internal.data.specifications.ModelSpecification#createIdentifiableInstance()
	 */
	@Override
	protected Model createIdentifiableInstance() {
		final Model retValue = super.createIdentifiableInstance();
		// The generated Graphs etc., all have dublin core that references
		// them as plugins. This is as it should be when STEM is running,
		// but right now we're running stand-alone and want to access the
		// plugins as projects (they aren't plugged into our running version
		// of Eclipse). Substitute "resource" for "plugin" in the URI's we
		// use and all will be well.

		for (DublinCore dc : nodeDublinCores) {
			retValue.getGraphs().add(
					(Graph) Utility
							.getIdentifiable(getIdentifiableProjectURI(dc)));
		} // for each node dc

		for (DublinCore dc : areaDublinCores) {
			retValue.getGraphs().add(
					(Graph) Utility
							.getIdentifiable(getIdentifiableProjectURI(dc)));
		} // for each area dc

		for (DublinCore dc : commonBorderEdgeDublinCores) {
			retValue.getGraphs().add(
					(Graph) Utility
							.getIdentifiable(getIdentifiableProjectURI(dc)));
		} // for each common border dc

		for (DublinCore dc : containmentEdgeDublinCores) {
			retValue.getGraphs().add(
					(Graph) Utility
							.getIdentifiable(getIdentifiableProjectURI(dc)));
		} // for each containment border dc

		return retValue;
	} // createIdentifiableInstance

	@Override
	protected String getRelativeSerializationPath() {
		final StringBuilder sb = new StringBuilder();
		sb.append(CountryGraphPropertyFileSpecification.COUNTRY_DIR);
		sb.append(File.separatorChar);
		sb.append(getISOKey().toString());
		return sb.toString();
	}

	@Override
	protected String getSerializationFileNameRoot() {
		final StringBuilder sb = new StringBuilder(getISOKey().toString());
		sb.append("_"); //$NON-NLS-1$
		sb.append(countryLevelMap.get(getISOKey()).toString());
		return sb.toString();
	}

	@Override
	protected String getTargetPluginId() {
		return org.eclipse.stem.data.geography.models.Activator.PLUGIN_ID;
	}

	@Override
	protected String getTitleDescriptor() {
		final StringBuilder sb = new StringBuilder(getISOKey().toString());
		sb.append(" Geography"); //$NON-NLS-1$

		final String levelString = countryLevelMap.get(getISOKey()).toString();
		final AdminLevelSet als = new AdminLevelSet(levelString);

		sb.append(als.getNumAdminLevels() > 1 ? " (Levels: " : " (Level: "); //$NON-NLS-1$ //$NON-NLS-2$
		sb.append(als.toString(",")); //$NON-NLS-1$
		sb.append(")"); //$NON-NLS-1$

		// Common Border Edges?
		if (commonBorderEdgeDublinCores.size() > 0) {
			sb.append(", Common Border("); //$NON-NLS-1$
			for (Iterator<DublinCore> dcIterator = commonBorderEdgeDublinCores
					.iterator(); dcIterator.hasNext();) {
				DublinCore dc = dcIterator.next();
				final Map<ISOKey, AdminLevelSet> coverageMap = CountryGraphPropertyFileSpecification
						.parseDublinCoreCoverageString(dc.getCoverage());

				for (Iterator<AdminLevelSet> alsIterator = coverageMap.values()
						.iterator(); alsIterator.hasNext();) {
					sb.append(alsIterator.next().toString("-")); //$NON-NLS-1$
					sb.append(dcIterator.hasNext() ? ", " : ""); //$NON-NLS-1$ //$NON-NLS-2$
				}
			} // foreach dc
			sb.append(")"); //$NON-NLS-1$
		} // if common border edges

		// Containment?
		if (containmentEdgeDublinCores.size() > 0) {
			sb.append(", Containment("); //$NON-NLS-1$
			for (Iterator<DublinCore> dcIterator = containmentEdgeDublinCores
					.iterator(); dcIterator.hasNext();) {
				DublinCore dc = dcIterator.next();

				final Map<ISOKey, AdminLevelSet> coverageMap = CountryGraphPropertyFileSpecification
						.parseDublinCoreCoverageString(dc.getCoverage());
				for (Iterator<AdminLevelSet> iterator = coverageMap.values()
						.iterator(); iterator.hasNext();) {
					sb.append(iterator.next().toString("->")); //$NON-NLS-1$
					sb.append(dcIterator.hasNext() ? ", " : ""); //$NON-NLS-1$ //$NON-NLS-2$
				}

			} // foreach dc
			sb.append(")"); //$NON-NLS-1$
		}

		return sb.toString();
	} // getTitleDescriptor

	/**
	 * @see org.eclipse.stem.internal.data.specifications.IdentifiableSpecification#createDubinCoreCoverage()
	 */
	@Override
	protected String createDubinCoreCoverage() {
		return CountryGraphPropertyFileSpecification
				.createDublinCoreCoverageString(countryLevelMap);
	}

	/**
	 * @see org.eclipse.stem.internal.data.specifications.IdentifiableSpecification#createDubinCoreSubject()
	 */
	@Override
	protected String createDubinCoreSubject() {
		return GraphPropertyFileSpecification.createDublinCoreSubjectString(
				ModelPackage.Literals.MODEL.getName(), "geography"); //$NON-NLS-1$
	}

	private ISOKey getISOKey() {
		final ISOKey isoKey = (ISOKey) countryLevelMap.keySet().toArray()[0];
		return isoKey;
	}

	public int compareTo(GeographicModelSpecification gms) {
		int retValue = 0;
		// Maps same size?
		if (countryLevelMap.size() == gms.countryLevelMap.size()) {
			// Yes
			// Just one?
			if (countryLevelMap.size() == 1) {
				// Yes
				final AdminLevelSet adminLevelSet0 = (AdminLevelSet) countryLevelMap
						.values().toArray()[0];
				final AdminLevelSet adminLevelSet1 = (AdminLevelSet) gms.countryLevelMap
						.values().toArray()[0];
				if (adminLevelSet0.getNumAdminLevels() == adminLevelSet1
						.getNumAdminLevels()) {
					retValue = adminLevelSet0.getMinAdminLevel().compareTo(
							adminLevelSet1.getMinAdminLevel());
				} else {
					// Different number of levels
					retValue = adminLevelSet0.getNumAdminLevels() > adminLevelSet1
							.getNumAdminLevels() ? 1 : -1;
				}
			} // if
			// else retValue = 0;
		} // if maps same size
		else {
			retValue = countryLevelMap.size() > gms.countryLevelMap.size() ? 1
					: -1;
		}
		return retValue;
	} // compareTo

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (ISOKey isoKey : countryLevelMap.keySet()) {
			sb.append(isoKey);
			sb.append(" : "); //$NON-NLS-1$
			sb.append(countryLevelMap.get(isoKey));
			sb.append("(" + nodeDublinCores.size() + "/" //$NON-NLS-1$//$NON-NLS-2$
					+ areaDublinCores.size() + "/" //$NON-NLS-1$
					+ commonBorderEdgeDublinCores.size() + "/" //$NON-NLS-1$
					+ containmentEdgeDublinCores.size() + ")"); //$NON-NLS-1$
		} // foreach isoKey
		return sb.toString();
	} // toString

} // GeographicModelSpecification
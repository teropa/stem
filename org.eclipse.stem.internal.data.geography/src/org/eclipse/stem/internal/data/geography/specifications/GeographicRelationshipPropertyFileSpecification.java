package org.eclipse.stem.internal.data.geography.specifications;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.internal.data.geography.propertydata.GeographicRelationshipPropertyData;
import org.eclipse.stem.internal.data.propertydata.RelationshipPropertyData;
import org.eclipse.stem.internal.data.specifications.RelationshipGraphPropertyFileSpecification;

/**
 * This class represents relationships between geographic entities.
 */
public abstract class GeographicRelationshipPropertyFileSpecification extends
		RelationshipGraphPropertyFileSpecification {

	/**
	 * This is the property in a data file that specifies the ISO KEY 0 value.
	 */
	public static final String ISOKEY_0_PROPERTY = "ISOKEY_0"; //$NON-NLS-1$

	/**
	 * This is the property in a data file that specifies the ISO KEY 1 value.
	 */
	public static final String ISOKEY_1_PROPERTY = "ISOKEY_1"; //$NON-NLS-1$

	/**
	 * This is the property in a data file that specifies the administration
	 * level for ISOKEY_0.
	 */
	public static final String ISOKEY_0_LEVEL_PROPERTY = "ISOKEY_0_LEVEL"; //$NON-NLS-1$

	/**
	 * This is the property in a data file that specifies the administration
	 * level for ISOKEY_1.
	 */
	public static final String ISOKEY_1_LEVEL_PROPERTY = "ISOKEY_1_LEVEL"; //$NON-NLS-1$

	/**
	 * The key of one {@link org.eclipse.stem.core.graph.Node} in the
	 * relationship. If the relationship is <em>directed</em>, then this is will
	 * be the <em>A</em> {@link org.eclipse.stem.core.graph.Node}.
	 */
	protected ISOKey isoKeyA = null;

	/**
	 * The key of one {@link org.eclipse.stem.core.graph.Node} in the
	 * relationship. If the relationship is <em>directed</em>, then this is will
	 * be the <em>B</em> {@link org.eclipse.stem.core.graph.Node}.
	 */
	protected ISOKey isoKeyB = null;

	/**
	 * The administration level of {@link #isoKeyA}.
	 */
	protected AdminLevel adminLevel0 = null;
	/**
	 * The administration level of {@link #isoKeyB}.
	 */
	protected AdminLevel adminLevel1 = null;

	@Override
	protected void collectNonDataProperties(Properties properties) {
		super.collectNonDataProperties(properties);
		isoKeyA = new ISOKey(properties.getProperty(ISOKEY_0_PROPERTY));
		isoKeyB = new ISOKey(properties.getProperty(ISOKEY_1_PROPERTY));
		adminLevel0 = new AdminLevel(properties
				.getProperty(ISOKEY_0_LEVEL_PROPERTY));
		adminLevel1 = new AdminLevel(properties
				.getProperty(ISOKEY_1_LEVEL_PROPERTY));

		properties.remove(ISOKEY_0_PROPERTY);
		properties.remove(ISOKEY_1_PROPERTY);
		properties.remove(ISOKEY_0_LEVEL_PROPERTY);
		properties.remove(ISOKEY_1_LEVEL_PROPERTY);
	} // collectNonDataProperties

	@Override
	public String getTitleDescriptor() {
		final StringBuilder sb = new StringBuilder();
		sb.append(isoKeyA.toString());
		sb.append(" "); //$NON-NLS-1$
		sb.append(getRelationshipName());
		sb.append(" "); //$NON-NLS-1$
		sb.append(isoKeyB.toString());
		return sb.toString();
	} // getTitleDescriptor

	/**
	 * Create the {@link URI} that specifies a
	 * {@link org.eclipse.stem.core.graph.Node} representing a geographical
	 * location.
	 * 
	 * @param isoKey
	 *            the ISO3166-1 alpha3 key of the country containing the region
	 *            represented by the
	 *            {@link org.eclipse.stem.core.graph.Node}
	 * @param nodeISOKey
	 *            the key of the {@link org.eclipse.stem.core.graph.Node}
	 * @return a {@link URI} that specifies a
	 *         {@link org.eclipse.stem.core.graph.Node} representing a
	 *         geographical location.
	 */
	protected URI createNodeURI(final ISOKey isoKey, final ISOKey nodeISOKey) {
		// We have a special case to handle here. The Earth is represented by
		// country ZZZ, we need to recognize when we're creating a URI using
		// that ISOKey. If the isoKey is "ZZZ" but the nodeISOKey is not "ZZZ",
		// then we need to use the nodeISOKey as the isoKey as well. This
		// handles the case when we have a relationship from the Earth (ZZZ) to
		// a country (e.g, USA). If we didn't do that then the URI for the
		// country would turn out as ".../ZZZ/0/USA" instead of ".../USA/0/USA"
		// which is the URI (suffix) for the country.

		URI retValue = null;

		// Do we have to correct for ZZZ?
		if (isoKey.equals(ISOKey.EARTH) && !nodeISOKey.equals(ISOKey.EARTH)) {
			// Yes
			// We've got a real country
			retValue = RegionImpl.createRegionNodeURI(nodeISOKey.toString());
		} else {
			retValue = RegionImpl.createRegionNodeURI(nodeISOKey.toString());
		}
		return retValue;
	} // createNodeURI

	@Override
	public URI createRelationshipURI(final String segment,
			final RelationshipPropertyData relationshipPropertyData) {
		final GeographicRelationshipPropertyData geoRelationshipPropertyData = (GeographicRelationshipPropertyData) relationshipPropertyData;
		final StringBuilder sb = new StringBuilder(segment);
		sb.append("/"); //$NON-NLS-1$
		sb.append("relationship"); //$NON-NLS-1$
		sb.append("/"); //$NON-NLS-1$
		sb.append(getRelationshipName());
		sb.append("/"); //$NON-NLS-1$
		sb.append(geoRelationshipPropertyData.getKeyA().toString());
		sb.append("_"); //$NON-NLS-1$
		sb.append(geoRelationshipPropertyData.getKeyB().toString());
		sb.append(getRelationshipSpecifier(relationshipPropertyData));

		return STEMURI.createURI(sb.toString());
	} // createRelationshipEdgeLabelURI

	/**
	 * @param spatialURI
	 *            the URI string that specifies the file with the Lat/Long data
	 *            that represents the {@link Edge} or <code>null</code> of there
	 *            is no such data.
	 * @return the URI string with an appended identifier that specifies the
	 *         exact data for the {@link Edge} for this relationship.
	 */
	protected String createEdgeSpecificSpatialURI(final String spatialURI) {
		// I don't think we're really using this as we compute the centers of a
		// region to display edges between them.
		return spatialURI;
	} // getSpatialURI

	@Override
	protected String getTargetPluginId() {
		return org.eclipse.stem.data.geography.Activator.PLUGIN_ID;
	}

	@Override
	protected String getSerializationFileNameRoot() {
		final StringBuilder sb = new StringBuilder(isoKeyA.toString());
		sb.append("_"); //$NON-NLS-1$
		sb.append(adminLevel0.toString());
		sb.append("_"); //$NON-NLS-1$
		sb.append(isoKeyB.toString());
		sb.append("_"); //$NON-NLS-1$
		sb.append(adminLevel1.toString());
		return sb.toString();
	}

	@Override
	protected String getRelativeSerializationPath() {
		final StringBuilder sb = new StringBuilder();
		sb.append(RELATIONSHIP_DIR);
		sb.append(File.separatorChar);
		sb.append(getRelationshipName());
		return sb.toString();
	}

	/**
	 * Create an {@link Edge} that represents the relationship.
	 * 
	 * @param geoRelationshipPropertyData
	 *            the data that defines the relationship represented by the
	 *            {@link Edge}
	 * @param spatialURI
	 *            the URI string that specifies the file with the Lat/Long data
	 *            that represents the {@link Edge} or <code>null</code> of there
	 *            is no such data.
	 * @return an {@link Edge} the represents the relationship
	 */
	@Override
	protected Edge createEdge(
			final RelationshipPropertyData relationshipPropertyData,
			final String spatialURI) {
		final Edge retValue = GraphFactory.eINSTANCE.createEdge();
		GeographicRelationshipPropertyData geoRelationshipPropertyData = (GeographicRelationshipPropertyData) relationshipPropertyData;
		retValue.setDirected(geoRelationshipPropertyData.isDirected());
		retValue.setURI(createRelationshipEdgeURI(geoRelationshipPropertyData));

		// Spatial data?
		if (spatialURI != null) {
			// Yes
			retValue.getDublinCore().setSpatial(
					createEdgeSpecificSpatialURI(spatialURI));
		}

		retValue.setNodeAURI(createNodeURI(geoRelationshipPropertyData
				.getKeyA(), geoRelationshipPropertyData.getKeyA()));
		retValue.setNodeBURI(createNodeURI(geoRelationshipPropertyData
				.getKeyB(), geoRelationshipPropertyData.getKeyB()));
		final EdgeLabel edgeLabel = createEdgeLabel(geoRelationshipPropertyData);
		retValue.setLabel(edgeLabel);

		return retValue;
	} // createEdge

	/**
	 * @see org.eclipse.stem.internal.data.specifications.IdentifiableSpecification#createDubinCoreCoverage()
	 */
	@Override
	protected String createDubinCoreCoverage() {
		
		final Map<ISOKey, AdminLevelSet> map = new HashMap<ISOKey, AdminLevelSet>();
		// Are the iso keys the same?
		if (isoKeyA.equals(isoKeyB)) {
			// Yes
			final AdminLevelSet adminLevelSet0 = new AdminLevelSet(adminLevel0);
			adminLevelSet0.addAdminLevel(adminLevel1);
			map.put(isoKeyA, adminLevelSet0);
		} // if keys same
		else {
			// No
			final AdminLevelSet adminLevelSet0 = new AdminLevelSet(adminLevel0);
			final AdminLevelSet adminLevelSet1 = new AdminLevelSet(adminLevel1);
			map.put(isoKeyA, adminLevelSet0);
			map.put(isoKeyB, adminLevelSet1);
		}
		
		return CountryGraphPropertyFileSpecification
				.createDublinCoreCoverageString(map);
	} // createDubinCoreCoverage

	/**
	 * @return the isoKeyA
	 */
	public final ISOKey getIsoKeyA() {
		return isoKeyA;
	}

	/**
	 * @return the isoKeyB
	 */
	public final ISOKey getIsoKeyB() {
		return isoKeyB;
	}

	/**
	 * @return the adminLevel0
	 */
	public final AdminLevel getAdminLevel0() {
		return adminLevel0;
	}

	/**
	 * @return the adminLevel1
	 */
	public final AdminLevel getAdminLevel1() {
		return adminLevel1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(getRelationshipName());
		sb.append(" "); //$NON-NLS-1$
		sb.append(isoKeyA);
		sb.append("("); //$NON-NLS-1$
		sb.append(adminLevel0);
		sb.append(")"); //$NON-NLS-1$
		sb.append(" -- "); //$NON-NLS-1$
		sb.append(isoKeyB);
		sb.append("("); //$NON-NLS-1$
		sb.append(adminLevel1);
		sb.append(")"); //$NON-NLS-1$

		return sb.toString();
	}

} // GeographicRelationshipPropertyFileSpecification

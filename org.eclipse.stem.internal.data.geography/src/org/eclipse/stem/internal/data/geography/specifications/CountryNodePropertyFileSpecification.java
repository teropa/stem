package org.eclipse.stem.internal.data.geography.specifications;

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

import java.util.List;

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.data.geography.ISOKey;
import org.eclipse.stem.definitions.adapters.spatial.SpatialProviderAdapter;
import org.eclipse.stem.definitions.nodes.NodesFactory;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.internal.data.geography.propertydata.RegionPropertyData;
import org.eclipse.stem.internal.data.propertydata.PropertyData;

/**
 * This class represents a {@link Graph} containing {@link Node}s of a specific
 * country.
 */
public class CountryNodePropertyFileSpecification extends
		CountryGraphPropertyFileSpecification {

	private static final String NODE_CONTENT_DESCRIPTOR = "node"; //$NON-NLS-1$

	/**
	 * Default Constructor
	 */
	public CountryNodePropertyFileSpecification() {
		super();
	} // CountryNodeGraphSpecification

	@Override
	protected PropertyData createPropertyDataInstanceFromProperty(
			String propertyKey, String propertyValue) {
		return new RegionPropertyData(new ISOKey(propertyKey), propertyValue);
	}

	/**
	 * @see org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification#initializeIdentifiableFromPropertyDataSet(Identifiable,
	 *      List)
	 */
	@Override
	protected void initializeIdentifiableFromPropertyDataSet(
			final Identifiable identifiable,
			final List<PropertyData> propertyDataSet) {
		final Graph graph = (Graph) identifiable;
		for (final PropertyData propertyData : propertyDataSet) {
			graph.putNode(createNode(dublinCore.getSpatial(),
					(RegionPropertyData) propertyData));
		} // for each node data
	} // populateFromDataSet

	/**
	 * @param spatialFileURI
	 *            a URI string that specifies the location that contains
	 *            Latitude and Longitude data for this {@link Node}. This will
	 *            become the value of the
	 *            {@link org.eclipse.stem.core.common.DublinCore#getSpatial()}
	 *            attribute. This can be <code>null</code> if no such data
	 *            exists.
	 * @param regionData
	 *            the data that specifies the contents of the {@link Node}
	 * @return a {@link Node} that represents a geographic place within the
	 *         context of a specified country at a specified administration
	 *         level
	 */
	private Node createNode(final String spatialFileURI,
			final RegionPropertyData regionData) {

		final String nodeKey = regionData.getISOKey().toString();

		final Region retValue = NodesFactory.eINSTANCE.createRegion();
		retValue.setURI(RegionImpl.createRegionNodeURI(nodeKey));
		retValue.getDublinCore().setTitle(regionData.getName() + " " + nodeKey); //$NON-NLS-1$

		final String dcSpatial = (spatialFileURI == null ? null
				: SpatialProviderAdapter.STEM_SPATIAL_SCHEME_PREFIX
						+ spatialFileURI + "#" + nodeKey); //$NON-NLS-1$

		retValue.getDublinCore().setSpatial(dcSpatial);

		return retValue;
	} // createNode

	@Override
	protected String getTitleDescriptor() {
		final StringBuilder sb = new StringBuilder(isoKey.toString());
		sb.append("("); //$NON-NLS-1$
		sb.append(adminLevel.toString());
		sb.append(") Nodes"); //$NON-NLS-1$
		return sb.toString();
	} // getTitleDescriptor

	/**
	 * @see org.eclipse.stem.internal.data.specifications.IdentifiableSpecification#createDubinCoreSubject()
	 */
	@Override
	protected String createDubinCoreSubject() {
		return createDublinCoreSubjectString(GraphPackage.Literals.NODE
				.getName(), Region.DUBLIN_CORE_SUBJECT);
	} // createDubinCoreSubject
	
	/**
	 * @see org.eclipse.stem.internal.data.geography.specifications.CountryGraphPropertyFileSpecification#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" "); //$NON-NLS-1$
		sb.append(NODE_CONTENT_DESCRIPTOR);
		return sb.toString();
	} // toString
} // CountryNodeGraphSpecification


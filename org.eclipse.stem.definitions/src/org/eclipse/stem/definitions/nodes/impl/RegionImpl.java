package org.eclipse.stem.definitions.nodes.impl;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.definitions.nodes.NodesPackage;
import org.eclipse.stem.definitions.nodes.Region;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RegionImpl extends GeographicFeatureImpl implements Region {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionImpl() {
		super();
	}

	/**
	 * @param nodeCode
	 *            the code for the region
	 * @return the URI for a specific region node
	 */
	public static URI createRegionNodeURI(String nodeCode) {
		final URI retValue = STEMURI.createURI(URI_TYPE_REGION_NODE_SEGMENT
				+ "/" + nodeCode);
		return retValue;
	} // createRegionNodeURI

//	/**
//	 * @param adminLevel
//	 *            the administration level of the region
//	 * @param countryCode
//	 *            the ISO-3166-1 code for the country containing the region
//	 * @param nodeCode
//	 *            the code for the region
//	 * @return the URI for a specific region node
//	 */
//	public static URI createRegionNodeURI(int adminLevel,
//			final String countryCode, String nodeCode) {
//		final URI retValue = STEMURI.createURI(URI_TYPE_REGION_NODE_SEGMENT
//				+ "/" + countryCode + "/" + adminLevel + "/" + nodeCode);
//		return retValue;
//	} // createRegionNodeURI

	
					/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NodesPackage.Literals.REGION;
	}

} // RegionImpl

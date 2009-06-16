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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.graph.impl.NodeImpl;
import org.eclipse.stem.definitions.nodes.GeographicFeature;
import org.eclipse.stem.definitions.nodes.NodesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geographic Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class GeographicFeatureImpl extends NodeImpl  implements GeographicFeature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeographicFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NodesPackage.Literals.GEOGRAPHIC_FEATURE;
	}

} //GeographicFeatureImpl
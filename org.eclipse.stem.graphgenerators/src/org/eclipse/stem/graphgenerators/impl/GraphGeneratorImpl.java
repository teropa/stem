/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.graphgenerators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class GraphGeneratorImpl extends IdentifiableImpl implements GraphGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.GRAPH_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //GraphGeneratorImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.common.impl.IdentifiableImpl;

import org.eclipse.stem.core.graphgenerator.GraphGenerator;
import org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage;

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
		return GraphgeneratorPackage.Literals.GRAPH_GENERATOR;
	}

} //GraphGeneratorImpl

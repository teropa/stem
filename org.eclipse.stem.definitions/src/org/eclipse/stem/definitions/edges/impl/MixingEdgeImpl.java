package org.eclipse.stem.definitions.edges.impl;

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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.impl.EdgeImpl;

import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.EdgesPackage;
import org.eclipse.stem.definitions.edges.MixingEdge;
import org.eclipse.stem.definitions.edges.MixingEdgeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixing Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MixingEdgeImpl extends PopulationEdgeImpl implements MixingEdge {

	/**
	 * This is used to generate unique URI's for each MixingEdge generated
	 */
	static int mixingEdgeCounter = 0;
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MixingEdgeImpl() {
		super();
				
		//set the URI
		setURI(STEMURI.createURI(URI_TYPE_MIXING_EDGE_SEGMENT + "/"
				+ Integer.toString(mixingEdgeCounter++)));
		
		//Make a label
		setLabel(EdgesFactory.eINSTANCE.createMixingEdgeLabel());				
				
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdgesPackage.Literals.MIXING_EDGE;
	}
	
	
	/***
	 * Override setter for setDirected so that it will blow up if anyone tries to make it directed (when assertions are on).
	 */
	@Override
	public void setDirected(boolean isDirected) {
		assert(isDirected==false);
		super.setDirected(isDirected);
	}
	
	/**Overrides methods from EdgeImpl correctly
	 * for correct return types*/
	@Override
	public MixingEdgeLabel getLabel() {
		return (MixingEdgeLabel)super.getLabel();
	}
	public void setLabel(MixingEdgeLabel lbl) {
		//just deal with making sure the URI labeling scheme is correct here.
		lbl.setURIOfIdentifiableToBeLabeled(this.getURI());
		super.setLabel(lbl);
	}

} //MixingEdgeImpl

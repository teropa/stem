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
import org.eclipse.stem.definitions.edges.MigrationEdge;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Migration Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MigrationEdgeImpl extends EdgeImpl implements MigrationEdge {
	
	/**
	 * This is used to generate unique URI's for each MigrationEdge generated
	 */
	static int migrationEdgeCounter = 0;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MigrationEdgeImpl() {
		super();
		
		//set the URI
		setURI(STEMURI.createURI(URI_TYPE_MIGRATION_EDGE_SEGMENT + "/"
				+ Integer.toString(migrationEdgeCounter++)));
		
		//Make a label
		setLabel(EdgesFactory.eINSTANCE.createMigrationEdgeLabel());				
		
		//this edge must be directed
		setDirected(true);
		
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdgesPackage.Literals.MIGRATION_EDGE;
	}
	
	/***
	 * Override setter for setDirected so that it will blow up if anyone tries to make it directed (when assertions are on).
	 */
	@Override
	public void setDirected(boolean isDirected) {
		assert(isDirected==true);
		super.setDirected(isDirected);
	}
	
	
	/**Override to make getEdge return the 
	 * correct type.*/
	@Override
	public MigrationEdgeLabel getLabel() {
		return (MigrationEdgeLabel)super.getLabel();	
	}

	public void setLabel(MigrationEdgeLabel lbl) {
		//just deal with making sure the URI labeling scheme is correct here.
		lbl.setURIOfIdentifiableToBeLabeled(this.getURI());
		
		super.setLabel(lbl);
	}
	
	
} //MigrationEdgeImpl

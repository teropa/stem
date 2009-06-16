package org.eclipse.stem.definitions.transport;

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

import org.eclipse.stem.definitions.edges.MigrationEdge;

/**
 * Represents an edge for the loading and unloading of a packet style transport 
 * network. 
 * 
 * @author jlessler
 * @model
 */
public interface LoadUnloadEdge extends MigrationEdge {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * migration edge URI.
	 */
	String URI_TYPE_LOADUNLOADEDGE_SEGMENT = URI_TYPE_MIGRATION_EDGE_SEGMENT + "/load-unload";
	
	
	/**
	 * @return <code>true</code> if this is a loading edge, <code>false</code>, otherwise.
	 * 
	 * @model default="false"
	 * */
	boolean isLoadingEdge();
	
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.transport.LoadUnloadEdge#isLoadingEdge <em>Loading Edge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loading Edge</em>' attribute.
	 * @see #isLoadingEdge()
	 * @generated
	 */
	void setLoadingEdge(boolean value);


	/**
	 * Get the label for this edge...must be a load/unload edge label
	 * 
	 * @return an edge label specifying connection times, etc.
	 * 
	 */
	LoadUnloadEdgeLabel getLabel();
	
	/**
	 * @param lbl
	 */
	void setLabel(LoadUnloadEdgeLabel lbl);
}

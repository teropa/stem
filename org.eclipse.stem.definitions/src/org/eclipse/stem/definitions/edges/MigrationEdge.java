package org.eclipse.stem.definitions.edges;

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

import org.eclipse.stem.core.graph.Edge;

/**
 * An edge representing migration between 
 * two areas. These edges have the following restrictions:
 * -getLabel() must return a migration edge label
 * -isDirected() must return true
 * 
 * @author jlessler
 *
 * @model
 */
public interface MigrationEdge extends Edge {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * migration edge URI.
	 */
	public String URI_TYPE_MIGRATION_EDGE_SEGMENT = URI_TYPE_EDGE_SEGMENT + "/migration";
	
	
	
	/**Overrides getLabel() to enforce the returning of a migration edge label
	 **/
	MigrationEdgeLabel getLabel();
	void setLabel(MigrationEdgeLabel lbl);
				
}

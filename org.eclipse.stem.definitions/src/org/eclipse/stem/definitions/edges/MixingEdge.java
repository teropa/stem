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
 * A mixing edge. A mixing edge must have the property that:
 *  - it is undirected
 *  - getLabel() returns a mixing edge label
 * @author jlessler
 *
 * @model
 */
public interface MixingEdge extends PopulationEdge {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * mixing edge URI.
	 */
	public String URI_TYPE_MIXING_EDGE_SEGMENT = URI_TYPE_EDGE_SEGMENT + "/mixing";
	
	
	/**Overrides getLabel() to enforce the returning of a mixing edge label	
	 */
	MixingEdgeLabel getLabel();
	void setLabel(MixingEdgeLabel lbl);
			
}

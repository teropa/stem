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

import org.eclipse.stem.core.graph.EdgeLabel;

/**
 * Defines a mixing edge. Mixing edges are undirected and defines some rate of 
 * contact between members of two populations in which the home population of
 * the individuals involved does not change.
 * 
 * @model
 * */
public interface MixingEdgeLabel extends EdgeLabel {
	
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * mixing relationship label type URI.
	 */
	String URI_TYPE_MIXING_RELATIONSHIP_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT
			+ "/mixing";
	
	/**Make the current  value stuff have to be MixingEdgeLabelValues
	 * */
	MixingEdgeLabelValue getCurrentValue();
	void setCurrentValue(MixingEdgeLabelValue val);

}

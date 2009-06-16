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
 * Defines a directed edge that represents migration between two nodes.
 * Migration denotes movement of the population between two nodes (i.e., the
 * home node of migrating population changes).
 * 
 * @author jlessler
 * @model
 */

public interface MigrationEdgeLabel extends EdgeLabel {
	
	
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * migration relationship label type URI.
	 */
	String URI_TYPE_MIGRATION_RELATIONSHIP_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT
			+ "/migration";
	
	
	/**Make the current  value stuff have to be MixingEdgeLabelValues
	 * */
	MigrationEdgeLabelValue getCurrentValue();
	void setCurrentValue(MigrationEdgeLabelValue val);
		
}

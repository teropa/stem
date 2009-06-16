// PhysicalRelationshipLabel.java
package org.eclipse.stem.definitions.labels;

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

import org.eclipse.stem.core.graph.StaticEdgeLabel;

/**
 * This interface is an EMF definition of a class that represents a label for an
 * Edge that represents a physical relationship between two nodes.
 * 
 * @model abstract="true"
 */
public interface PhysicalRelationshipLabel extends StaticEdgeLabel {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * relative physical relationship label type URI.
	 */
	String URI_TYPE_PHYSICAL_RELATIONSHIP_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT
			+ "/physical";

	// Nothing
} // PhysicalRelationshipLabel

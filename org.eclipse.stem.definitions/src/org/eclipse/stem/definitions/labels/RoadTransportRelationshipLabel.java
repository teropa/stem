// CommonBorderRelationshipLabel.java
package org.eclipse.stem.definitions.labels;

/******************************************************************************* 
 * Copyright (c) 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

/**
 * This interface is an EMF definition of a class that represents a label for an
 * Edge that represents a the relationship of two nodes connected by some type of road
 * 
 * @model
 */
public interface RoadTransportRelationshipLabel extends
		PhysicalRelationshipLabel {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * relative physical relationship label type URI.
	 */
	String URI_TYPE_ROAD_TRANSPORT_RELATIONSHIP_LABEL_SEGMENT = URI_TYPE_PHYSICAL_RELATIONSHIP_LABEL_SEGMENT
			+ "/road";

} // CommonBorderRelationshipLabel

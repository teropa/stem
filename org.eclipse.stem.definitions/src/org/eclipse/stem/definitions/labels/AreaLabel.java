// AreaLabel.java
package org.eclipse.stem.definitions.labels;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.StaticNodeLabel;

/**
 * This interface defines a class in an EMF model for AreaLabel.
 * 
 * @model
 */
public interface AreaLabel extends StaticNodeLabel {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * area label type URI.
	 */
	String URI_TYPE_AREA_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT + "/area";

	/**
	 * This is the type URI for area labels
	 */
	URI URI_TYPE_AREA_LABEL = STEMURI
			.createTypeURI(URI_TYPE_AREA_LABEL_SEGMENT);

	/**
	 * @return the current area value
	 * @model volatile="true" transient="true" changeable="false"
	 *        resolveProxies="false"
	 */
	AreaLabelValue getCurrentAreaValue();

} // AreaLabel

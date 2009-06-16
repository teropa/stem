// GeographicFeature.java
package org.eclipse.stem.definitions.nodes;

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

//import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.graph.Node;

/**
 * This interface defines a class in an EMF model for a Geographic Feature node.
 * 
 * @model abstract="true"
 */
public interface GeographicFeature extends Node {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * geographic feature node type URI.
	 */
	String URI_TYPE_GEOGRAPHIC_FEATURE_NODE_SEGMENT = URI_TYPE_NODE_SEGMENT
			+ "/geo";

} // GeographicFeature

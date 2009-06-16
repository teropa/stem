// Node.java
package org.eclipse.stem.core.graph;

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.Identifiable;

/**
 * A <code>Node</code> represents a real or abstract entity.
 * <p>
 * A <code>Node</code> can have "attributes". The attributes are represented
 * by zero or more {@link NodeLabel}s.
 * </p>
 * <p>
 * A <code>Node</code> can have zero or more "relationships" with one or more
 * other <code>Node</code>s. These relationships can be with the same
 * <code>Node</code> or with multiple different <code>Node</code>s. A
 * single relationship is represented by an {@link Edge}.
 * </p>
 * 
 * @see Edge
 * @see Label
 * @see NodeLabel
 * @see Graph
 * 
 * @model
 */
public interface Node extends Identifiable {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * node type URI.
	 */
	String URI_TYPE_NODE_SEGMENT = "node";

	// /**
	// * This is the type URI for area labels
	// */
	// URI URI_TYPE_GEOGRAPHIC_FEATURE_NODE = STEMURI
	// .createTypeURI(URI_TYPE_NODE_SEGMENT);

	/**
	 * @return the {@link Edge}s that represent the relationships of this
	 *         <code>Node</code>.
	 * @model type="Edge" containment="false"
	 */
	EList<Edge> getEdges();

	/**
	 * the {@link Label}s that represent attributes of this <code>Node</code>.
	 * 
	 * @model type="NodeLabel" containment="false" opposite="node"
	 */
	EList<NodeLabel> getLabels();

} // Node

// NodeLabel.java
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

/**
 * A <code>NodeLabel</code> is a {@link Label} that provides attributes to a
 * {@link Node}.
 * 
 * @model abstract="true"
 */
public interface NodeLabel extends Label {

	/**
	 * @return the {@link Node} that this <code>NodeLabel</code> labels. This
	 *         value can be null in a graph fragment.
	 * 
	 * @model containment="false"
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.NodeLabel#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

} // NodeLabel

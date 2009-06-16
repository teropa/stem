// EdgeLabel.java
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
 * An <code>EdgeLabel</code> is a {@link Label} that provides attributes to an
 * {@link Edge}.
 * 
 * @model abstract="true"
 */
public interface EdgeLabel extends Label {

	/**
	 * @return the {@link Edge} that this <code>EdgeLabel</code> labels.
	 * 
	 * @model containment="false"
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.EdgeLabel#getEdge <em>Edge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' container reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);

} // EdgeLabel

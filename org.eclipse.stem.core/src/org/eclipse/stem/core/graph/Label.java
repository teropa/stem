// Label.java
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.Identifiable;

/**
 * A <code>Label</code> represents attributes of either a {@link Node},
 * {@link Edge}, or {@link Graph}. The attributes are represented by a
 * {@link LabelValue}.
 * 
 * @see Node
 * @see Edge
 * @see Graph
 * @see NodeLabel
 * @see DynamicLabel
 * @see StaticNodeLabel
 * @see DynamicNodeLabel
 * 
 * 
 * @model abstract="true"
 */
public interface Label extends Identifiable {

	/**
	 * This is the top-level segment for all type URI's for labels.
	 */
	String URI_TYPE_LABEL_SEGMENT = "label";

	/**
	 * This is the type URI for a Label
	 */
	URI URI_TYPE_LABEL = STEMURI.createTypeURI(URI_TYPE_LABEL_SEGMENT);

	/**
	 * @return the {@link Identifiable} labeled by this <code>Label</code>
	 * @model volatile="true" transient="true"
	 */
	Identifiable getIdentifiable();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Label#getIdentifiable <em>Identifiable</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifiable</em>' reference.
	 * @see #getIdentifiable()
	 * @generated
	 */
	void setIdentifiable(Identifiable value);

	/**
	 * @return the {@link URI} of the {@link Identifiable} that this
	 *         <code>Label</code> labels. This value is typically used when
	 *         combining "graph fragments" to resolve the connection between the
	 *         <code>Label</code> and the {@link Identifiable} it labels.
	 * @see Graph#addGraph(Graph)
	 * @see UnresolvedIdentifiable
	 * @see #getIdentifiable()
	 * 
	 * @model
	 */
	URI getURIOfIdentifiableToBeLabeled();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Label#getURIOfIdentifiableToBeLabeled <em>URI Of Identifiable To Be Labeled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI Of Identifiable To Be Labeled</em>' attribute.
	 * @see #getURIOfIdentifiableToBeLabeled()
	 * @generated
	 */
	void setURIOfIdentifiableToBeLabeled(URI value);

	/**
	 * @model containment="true" required="true"
	 */
	LabelValue getCurrentValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Label#getCurrentValue <em>Current Value</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Value</em>' containment reference.
	 * @see #getCurrentValue()
	 * @generated
	 */
	void setCurrentValue(LabelValue value);

} // Label

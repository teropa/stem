// Edge.java
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
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.modifier.Modifiable;

/**
 * An <code>Edge</code> represents a relationship between two {@link Node}s.
 * The attributes of that relationship are defined by the <code>Edge</code>'s
 * {@link Label}.
 * <p>
 * An <code>Edge</code> can be <em>directed</em> or <em>undirected</em>.
 * If the <code>Edge</code> is directed then the relationship is "one-way"
 * from {@link Node} "<code>A</code>" to {@link Node} "<code>B</code>".
 * An example of such a relationship is "physically contains", where the entity
 * represented by {@link Node} "<code>B</code>" is physically contained in
 * the entity represented by {@link Node} "<code>A</code>" (e.g., Santa
 * Clara county is physically contained in the state of California). If the
 * <code>Edge</code> is undirected then the relationship is <em>symmetric</em>,
 * meaning that it holds both ways. An example of such a relationship is "shares
 * common border", where the entity represented by {@link Node} "<code>A</code>"
 * shares a common border with the entity represented by {@link Node} "<code>B</code>"
 * (e.g., Santa Clara county shares a common border with Santa Cruz county).
 * 
 * </p>
 * 
 * @see Graph
 * @see Node
 * 
 * @model
 */
public interface Edge extends Identifiable, Modifiable {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * edge URI.
	 */
	String URI_TYPE_EDGE_SEGMENT = "edge";

	/**
	 * @return the "A" {@link Node} of the edge. Directed edges go from
	 *         {@link Node} A to {@link Node} B. In a graph fragment this value
	 *         may not yet be set.
	 * @model containment="false"
	 */
	Node getA();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Edge#getA <em>A</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' reference.
	 * @see #getA()
	 * @generated
	 */
	void setA(Node value);

	/**
	 * @return the URI of {@link Node} A.
	 * @model
	 */
	URI getNodeAURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Edge#getNodeAURI <em>Node AURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node AURI</em>' attribute.
	 * @see #getNodeAURI()
	 * @generated
	 */
	void setNodeAURI(URI value);

	/**
	 * @return the "B" {@link Node} of the edge. Directed edges go from
	 *         {@link Node} A to {@link Node} B. In a graph fragment this value
	 *         may not yet be set.
	 * @model containment="false"
	 */
	Node getB();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Edge#getB <em>B</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' reference.
	 * @see #getB()
	 * @generated
	 */
	void setB(Node value);

	/**
	 * @return the URI of {@link Node} B.
	 * @model
	 */
	URI getNodeBURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Edge#getNodeBURI <em>Node BURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node BURI</em>' attribute.
	 * @see #getNodeBURI()
	 * @generated
	 */
	void setNodeBURI(URI value);

	/**
	 * @param node
	 *            one of the two {@link Node}s of the <code>Edge</code>
	 * @return {@link Node} A if {@link Node} B is passed in, otherwise return
	 *         {@link Node} B if {@link Node} A is passed in.
	 * @exception IllegalArgumentException
	 *                if the {@link Node} passed in is not either {@link Node} A
	 *                or {@link Node} B of this <code>Edge</code>.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	Node getOtherNode(final Node node) throws IllegalArgumentException;

	/**
	 * @return the {@link EdgeLabel} of the <code>Edge</code>, if it exists.
	 * @model containment="true" opposite="edge"
	 */
	EdgeLabel getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Edge#getLabel <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' containment reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(EdgeLabel value);

	/**
	 * @return <code>true</code> if the <code>Edge</code> is a directed
	 *         <code>Edge</code> (directed <code>Edge</code>s are always
	 *         from {@link Node} A to {@link Node} B).
	 * @model default="false"
	 */
	boolean isDirected();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Edge#isDirected <em>Directed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directed</em>' attribute.
	 * @see #isDirected()
	 * @generated
	 */
	void setDirected(boolean value);

	/**
	 * @param node
	 *            the {@link Node} under test
	 * @return <code>true</code> if the <code>Edge</code> is a directed
	 *         <code>Edge</code> and the {@link Node} under test is
	 *         {@link Node} B.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean isDirectedAt(final Node node);

} // Edge

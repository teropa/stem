// Graph.java
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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.IdentifiableFilter;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.STEMTime;

/**
 * A <code>Graph</code> serves two roles in the STEM system. The first is as
 * the canonical data structure that is the representational framework for all
 * STEM simulations. In this form, a <code>Graph</code>, with one exception,
 * matches the theoretical definition of a "graph" in that it has a set of
 * {@link Node}s, a set of {@link Edge}s between members of the {@link Node}
 * set, and a set of {@link Label}s that label either a member of the
 * {@link Node} set or a member of the {@link Edge} set. The one exception is
 * that an additional set of {@link Label}s designated as "graph labels"
 * exists. These {@link Label}s function as "global variables" and would
 * typically be used during a simulation to hold global state information (for
 * instance, parameters referenced by a
 * {@link org.eclipse.stem.core.model.Decorator} that control it's
 * computations on a graph-wide basis, an example might be a disease model that
 * can change the infectious rate it uses by referencing such a label).
 * <p>
 * The second role played by a <code>Graph</code> is as a unit of composition
 * in a {@link org.eclipse.stem.core.model.Model}. A
 * {@link org.eclipse.stem.core.model.Model} forms a tree of
 * <code>Graph</code>s and {@link Model}s. The <code>Graph</code>
 * instances are the leaves of the tree while the
 * {@link org.eclipse.stem.core.model.Model} instances are the root and
 * inner nodes of the tree. In this role, a <code>Graph</code> may not meet
 * the theoretical definition of a "graph". This means that it may only have a
 * set of {@link Label}s or a set of {@link Edge}s, and no {@link Node}s.
 * This "graph fragment" allows sets of {@link Label}s and {@link Edge}s to be
 * defined and then later combined with an existing <code>Graph</code> that
 * does have {@link Node}s. This combination is specified by adding the graph
 * fragment to a {@link org.eclipse.stem.core.model.Model} instance. When
 * the canonical <code>Graph</code> is created, the {@link Label}s and
 * {@link Edge}s are "resolved" by matching their target {@link URI}(s) with
 * those of the {@link Node}s in the canonical <code>Graph</code> under
 * construction. Any such {@link Label}s or {@link Edge}s that are unresolved
 * are recorded as {@link UnresolvedIdentifiable}s.
 * </p>
 * <p>
 * The <code>Graph</code> has <em>containment</em> relationships for
 * {@link Node}s, {@link Edge}s and the labels on nodes (i.e.,
 * {@link NodeLabel}s). These support the graph fragment role by allowing a
 * <code>Graph</code> to contain any of the three without the others. The
 * {@link Label}s on {@link Edge}s are contained by the {@link Edge} as it is
 * not possible to have such a {@link Label} without the {@link Edge}. Only one
 * such {@link Label} is allowed per {@link Edge}.
 * </p>
 * <p>
 * This interface definition is also an "Annotated Java Interface" that defines
 * one class in a <a href="http://www.uml.org/">UML</a> "model". The UML class
 * diagram for the model is in the <code>documentation</code> folder of the
 * project. This file and the other interfaces in this Java package are
 * processed by the Eclipse Modeling Framework (aka EMF <a
 * href="http://org.eclipse/emf">http://org.eclipse/emf</a>). to automatically
 * generate an implementation of the model. EMF is documented in the book <a
 * href="http://www.awprofessional.com/bookstore/product.asp?isbn=0131425420&rl=1">Eclipse
 * Modeling Framework </a> by Budinsky, et al.
 * </p>
 * 
 * @see Edge
 * @see Node
 * @see Label
 * @see org.eclipse.stem.core.model.Model
 * @see org.eclipse.stem.core.scenario.Scenario
 * 
 * @model
 */
public interface Graph extends Identifiable {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * graph URI.
	 */
	String URI_TYPE_GRAPH_SEGMENT = "graph";

	/**
	 * @return the time that the dynamic label values were last updated.
	 * @model containment="true" resolveProxies="false"
	 */
	STEMTime getTime();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.Graph#getTime <em>Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' containment reference.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(STEMTime value);

	/**
	 * @return the map between {@link URI} and an {@link Edge}
	 * @model keyType="URI" valueType="Edge" valueContainment="true"
	 */
	EMap<URI, Edge> getEdges();

	/**
	 * @return the map between {@link URI} and an {@link Node}
	 * @model keyType="URI" valueType="Node" valueContainment="true"
	 */
	EMap<URI, Node> getNodes();

	/**
	 * @return the map between {@link URI} and {@link Label} labeling the {@link Graph}
	 * @model keyType="URI" valueType="Label" valueContainment="true"
	 */
	EMap<URI, Label> getGraphLabels();

	/**
	 * @return the mapping between {@link URI} and {@link NodeLabel}s
	 * @model keyType="URI" valueType="NodeLabel" valueContainment="true"
	 */
	EMap<URI, NodeLabel> getNodeLabels();

	/**
	 * @param typeURI
	 *            the type {@link URI} of the desired {@link NodeLabel}
	 * @return a list of the {@link NodeLabel}s that match a specific type {@link URI}
	 * @model type="NodeLabel" volatile="true" transient="true"
	 *        changeable="false"
	 */
	EList<NodeLabel> getNodeLabelsByTypeURI(URI typeURI);

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * This collection of Labels contains references to ALL of the
	 * {@link DynamicLabel}s in the {@link Graph}. It is used by
	 * {@link #switchToNextValue()} to find each of the {@link DynamicLabel}s
	 * that need to switch values.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @model type="DynamicLabel" containment="false"
	 */
	EList<DynamicLabel> getDynamicLabels();

	/**
	 * @return the collection of {@link Decorator}s that decorate this {@link Graph}
	 * @model type="Decorator" containment="true" opposite="graph"
	 */
	EList<Decorator> getDecorators();
	
	/**
	 * Add the {@link Edge}s, {@link Node}s and {@link Label}s to this {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void addGraph(Graph graph, IdentifiableFilter filter);

	/**
	 * Put the {@link Edge} into the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void putEdge(Edge edge);

	/**
	 * Get the {@link Edge} from the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	Edge getEdge(URI uri);

	/**
	 * Put the {@link Node} into the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void putNode(Node node);

	/**
	 * Get the {@link Node} from the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	Node getNode(URI uri);

	/**
	 * Put the {@link NodeLabel} into the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void putNodeLabel(NodeLabel label);

	/**
	 * Get the {@link NodeLabel} from the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	NodeLabel getNodeLabel(URI uri);

	/**
	 * Put the Graph {@link Label} into the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void putGraphLabel(Label label);

	/**
	 * Get the Graph {@link Label} from the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	Label getGraphLabel(URI uri);

	/**
	 * Add the {@link DynamicLabel} into the {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void addDynamicLabel(DynamicLabel dynamiclabel);

	/**
	 * Return the number of {@link Edge}s in this {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getNumEdges();

	/**
	 * Return the number of {@link Node}s in this {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getNumNodes();

	/**
	 * Return the number of Graph {@link Label} in this {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getNumGraphLabels();

	/**
	 * Return the number of {@link NodeLabel}s in this {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getNumNodeLabels();

	/**
	 * Return the number of {@link DynamicLabel}s in this {@link Graph}.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	int getNumDynamicLabels();

	/**
	 * @return a collection that {@link UnresolvedIdentifiable} instances that specify
	 *         the {@link URI}'s in an {@link Identifiable} that could not be resolved.
	 * 
	 * @model type="UnresolvedIdentifiable" containment="true"
	 */
	EList<UnresolvedIdentifiable> getUnresolvedIdentifiables();

	/**
	 * Make all of the {@link DynamicLabel}s in the model switch to their "next" value.
	 * This has the effect of moving the state of the model to its aggregate
	 * value at the next time period.
	 * 
	 * @param currentTime
	 * 		the time value to associate with the new value.  
	 * @see #getTime()
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void switchToNextValue(final STEMTime currentTime);

} // Graph

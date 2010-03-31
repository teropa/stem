// Model.java
package org.eclipse.stem.core.model;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.IdentifiableFilter;
import org.eclipse.stem.core.graph.Graph;

/**
 * A <code>Model</code> contains all of the components necessary to create a
 * canonical {@link org.eclipse.stem.core.graph.Graph} suitable for
 * simulation. In particular it contains a collection of
 * {@link org.eclipse.stem.core.graph.Graph}'s and a collection of other
 * (sub) <code>Model</code>'s. This structure forms a "tree" with
 * <code>Model</code> instances as the tree's root and interior nodes, and
 * {@link org.eclipse.stem.core.graph.Graph} instances as the tree's leaves.
 * <p>
 * Each <code>Model</code> can also contain collection's of {@link Decorator}'s
 * which can modify the canonical {@link org.eclipse.stem.core.graph.Graph}
 * when it is first created from the model (see {@link #getCanonicalGraph(URI)}.
 * </p>
 * <p>
 * Each {@link org.eclipse.stem.core.scenario.Scenario} contains a single
 * reference to a <code>Model</code>. That model is the root of the tree the
 * defines the canonical {@link org.eclipse.stem.core.graph.Graph} that will
 * be used for simulation. A {@link org.eclipse.stem.core.scenario.Scenario}
 * obtains the canonical {@link org.eclipse.stem.core.graph.Graph} from the
 * model by calling the method {@link #getCanonicalGraph(URI)}. This method
 * recursively creates the canonical
 * {@link org.eclipse.stem.core.graph.Graph} by invoking itself on the
 * <code>Model</code> instances it contains. At each level of the recursion,
 * it combines the results of those calls with the
 * {@link org.eclipse.stem.core.graph.Graph}'s it contains (if any). The
 * {@link Decorator}s in the model are also then allowed to modify (decorate)
 * the {@link org.eclipse.stem.core.graph.Graph}. Then, the recursion
 * attempts to resolve any outstanding unresolved links between
 * {@link org.eclipse.stem.core.graph.Edge}s and
 * {@link org.eclipse.stem.core.graph.Label}s and the
 * {@link org.eclipse.stem.core.graph.Node}s in the canonical
 * {@link org.eclipse.stem.core.graph.Graph} under construction. This is
 * accomplished by matching up the "target" {@link URI}s of the unresolved
 * {@link org.eclipse.stem.core.graph.Edge}s or {@link Label}s with a
 * {@link URI} of a {@link Node}. Any which cannot be resolved are recorded
 * with a {@link org.eclipse.stem.core.graph.UnresolvedIdentifiable}
 * instance (see
 * {@link org.eclipse.stem.core.graph.Graph#getUnresolvedIdentifiables()})
 * for later reporting.
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
 * @see org.eclipse.stem.core.graph.Graph
 * @see org.eclipse.stem.core.scenario.Scenario
 * 
 * @model
 */
public interface Model extends Identifiable {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * model URI.
	 */
	String URI_TYPE_MODEL_SEGMENT = "model";
	
	/**
	 * @return this <code>Model</code>'s collection of (sub)
	 *         <code>Model</code>s
	 * 
	 * @model type="Model" containment="false"
	 */
	EList<Model> getModels();

	/**
	 * @return this <code>Model</code>'s collection of {@link org.eclipse.stem.core.graph.Graph}}s
	 * 
	 * @model type="Graph" containment="false"
	 */
	EList<Graph> getGraphs();

	/**
	 * @return the collection of {@link Decorator}s that decorate the canonical
	 *         {@link Graph} itself. These decorations are {@link Label}s that
	 *         act like "global variables" for the canonical {@link Graph}.
	 * 
	 * @model type="GraphDecorator" containment="false"
	 */
	EList<GraphDecorator> getGraphDecorators();

	/**
	 * @return the collection of {@link Decorator}s that decorate the
	 *         {@link Node}s in the canonical {@link Graph}.
	 * 
	 * @model type="NodeDecorator" containment="false"
	 */
	EList<NodeDecorator> getNodeDecorators();

	/**
	 * @return the collection of {@link Decorator}s that decorate the
	 *         {@link org.eclipse.stem.core.graph.Edge}s in the canonical {@link Graph}.
	 * 
	 * @model type="EdgeDecorator" containment="false"
	 */
	EList<EdgeDecorator> getEdgeDecorators();

	/**
	 *Recursively process any models this model contains to obtain their
	 * canonical {@link Graph}s. Combine these with any graphs this model
	 * contains to make one aggregate {@link Graph}. Then this
	 * <code>model</code>'s {@link Decorator}s decorate the graph.
	 * 
	 * @param uri
	 *            the {@link URI} of the newly created canonical graph
	 * @param parentFilter
	 * @param time
	 * @return the canonical graph of the model
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 *        resolveProxies="false"
	 *        
	 * @generated
	 */
	Graph getCanonicalGraph(URI uri, IdentifiableFilter filter, STEMTime time);


	/**
	 * Prepare the model if needed
	 * @model
	 * @generated
	 */
	void prepare(STEMTime time);

} // Model


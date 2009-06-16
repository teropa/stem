// STEMURI.java
package org.eclipse.stem.core;

/******************************************************************************* 
 * Copyright (c) 2006, 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.sequencer.Sequencer;

/**
 * This class contains standard {@link URI} constants for STEM.
 */
public class STEMURI {

	/**
	 * The type {@link URI} of a STEM {@link Scenario}. {@value}
	 */
	public static final URI SCENARIO_TYPE_URI = createTypeURI("Scenario");

	/**
	 * The type {@link URI} of a STEM {@link Model}. {@value}
	 */
	public static final URI MODEL_TYPE_URI = createTypeURI("Model");

	/**
	 * The type {@link URI} of a STEM {@link Graph}. {@value}
	 */
	public static final URI GRAPH_TYPE_URI = createTypeURI("Graph");

	/**
	 * The type {@link URI} of a STEM {@link Node}. {@value}
	 */
	public static final URI NODE_TYPE_URI = createTypeURI("Node");

	/**
	 * The type {@link URI} of a STEM {@link Edge}. {@value}
	 */
	public static final URI EDGE_TYPE_URI = createTypeURI("Edge");

	/**
	 * The type {@link URI} of a STEM {@link Sequencer}. {@value}
	 */
	public static final URI SEQUENCER_TYPE_URI = createTypeURI("Sequencer");

	/**
	 * The type {@link URI} of a STEM {@link Experiment}. {@value}
	 */
	public static final URI EXPERIMENT_TYPE_URI = createTypeURI("Experiment");

	/**
	 * The type {@link URI} of a STEM
	 * {@link org.eclipse.stem.core.modifier.Modifier}. {@value}
	 */
	public static final URI MODIFIER_TYPE_URI = createTypeURI("Modifier");

	/**
	 * The type {@link URI} of a STEM
	 * {@link org.eclipse.stem.core.trigger.Trigger}. {@value}
	 */
	public static final URI TRIGGER_TYPE_URI = createTypeURI("Trigger");

	/**
	 * The type {@link URI} of a STEM
	 * {@link org.eclipse.stem.core.trigger.Predicate}. {@value}
	 */
	public static final URI PREDICATE_TYPE_URI = createTypeURI("Predicate");
	
	/**
	 * Create a "Stem type" {@link URI}
	 * 
	 * @param segments
	 *            the segments of the {@link URI}
	 * @return a STEM "type" {@link URI}
	 */
	public static URI createTypeURI(final String segments) {
		return create(Constants.STEM_TYPE_SCHEME, segments);
	} // createTypeURI

	/**
	 * @param segments
	 *            the segments of the {@link URI}
	 * @return a STEM {@link URI}
	 */
	public static URI createURI(final String segments) {
		return create(Constants.STEM_SCHEME, segments);
	}

	/**
	 * @param scheme
	 *            the scheme of the {@link URI}
	 * @param segments
	 *            the segments of the URI
	 * @see Constants#STEM_URI_AUTHORITY
	 * @return a STEM {@link URI} with the built-in "STEM" Authority
	 */
	public static URI create(final String scheme, final String segments) {
		return create(scheme, Constants.STEM_URI_AUTHORITY, segments);
	} // create

	/**
	 * Create a STEM {@link URI}
	 * 
	 * @param scheme
	 *            the scheme of the {@link URI}
	 * @param authority
	 *            the "authority" of the {@link URI}
	 * @param segments
	 *            the segments of the {@link URI}
	 * @see Constants#STEM_URI_AUTHORITY
	 * @return a STEM {@link URI}
	 */
	public static URI create(final String scheme, final String authority,
			final String segments) {
		final StringBuilder sb = new StringBuilder(scheme);
		sb.append("://");
		sb.append(authority);
		sb.append("/");
		sb.append(segments);
		return URI.createURI(sb.toString());
	} // create
} // STEMURI

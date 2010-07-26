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

import java.util.Random;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
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

	private static Random rand = new Random(System.currentTimeMillis());
	
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
	 * The type {@link URI} of a STEM
	 * {@link org.eclipse.stem.core.solver.Solver}. {@value}
	 */
	public static final URI SOLVER_TYPE_URI = createTypeURI("Solver");

	/**
	 * The type {@link URI} of a STEM
	 * {@link org.eclipse.stem.core.common.Identifiable}. {@value}
	 */
	public static final URI IDENTIFIABLE_TYPE_URI = createTypeURI("Identifiable");
	
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
	
	/**
	 * generateUniquePart. Used to add a unique segment to any URI
	 * @return String Random 64 bit upper case HEX
	 */
	public static String generateUniquePart() {
		long l = rand.nextLong();
		long now = System.currentTimeMillis();
		long r= l+now;
		return Long.toHexString(r).toUpperCase();
	}
	
	/**
	 * Converts URI's of the form "file://..." to "platform://..."
	 * @param in URI to convert
	 * @return Converted URI, or the same as input if the URI is already normalized
	 */
	
	public static URI normalize(URI in) {
		if(in.scheme().equals("platform")) return in;
		if(in.scheme().equals("file")) {
			// Check if we can find the workspace path in the file URI.
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot root = workspace.getRoot();
			IPath location = root.getLocation();
			
			int ind = in.toString().indexOf(location.toString());
			if(ind >-1) {
				String rest = in.toString().substring(ind+location.toOSString().length());
				URI result = URI.createPlatformResourceURI(rest, false);
				return result;
			}
		}
		// Unable to convert file URI, this could be a URI to a STEM library object. We don't convert those
		return in;
	}
} // STEMURI

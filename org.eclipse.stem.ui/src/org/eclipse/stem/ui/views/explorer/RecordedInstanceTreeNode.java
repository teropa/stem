// RecordedInstanceTreeNode.java
package org.eclipse.stem.ui.views.explorer;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.jobs.simulation.Simulation;

/**
 * This class represents an instance of a recorded {@link Simulation}.
 */
public class RecordedInstanceTreeNode {

	private final RecordedTreeNode parent;
	private final String name;

	/**
	 * @param parent
	 * @param name
	 */
	public RecordedInstanceTreeNode(final RecordedTreeNode parent,
			final String name) {
		super();
		this.parent = parent;
		this.name = name;
	}

	/**
	 * @return the parent
	 */
	public Object getParent() {
		return parent;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}

} // RecordedInstanceTreeNode
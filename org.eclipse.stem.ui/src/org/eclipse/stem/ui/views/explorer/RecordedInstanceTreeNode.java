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

/**
 * This class represents an instance of a recorded
 * {@link org.eclipse.stem.jobs.simulation.Simulation}.
 */
public class RecordedInstanceTreeNode {

	private final RecordedTreeNode parent;
	private final RecordedInstanceTreeNode instanceParent;
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
		this.instanceParent = null;
	}

	/**
	 * @param parent
	 * @param name
	 */
	public RecordedInstanceTreeNode(final RecordedInstanceTreeNode parent,
			final String name) {
		super();
		this.parent = null;
		this.name = name;
		this.instanceParent = parent;
	}
	/**
	 * @return the parent
	 */
	public Object getParent() {
		return parent;
	}
	/**
	 * @return the instance parent
	 */
	public Object getInstanceParent() {
		return instanceParent;
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
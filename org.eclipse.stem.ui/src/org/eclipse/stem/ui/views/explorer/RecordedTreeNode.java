// RecordedTreeNode.java
package org.eclipse.stem.ui.views.explorer;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.core.resources.IProject;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is used in the {@link CommonNavigator} based STEM Project Explorer
 * view to represent a group recorded {@link Simulation} runs that belong to a
 * particular STEM Project instance.
 */
public class RecordedTreeNode {

	private final IProject project;

	/**
	 *@param project
	 * 		the {@link IProject} that is the parent of this {@link
	 * 		RecordedTreeNode}.
	 */
	public RecordedTreeNode(IProject project) {
		this.project = project;
	} // RecordedTreeNode

	/**
	 * @return the {@link IProject}.
	 */
	public IProject getProject() {
		return project;
	}
} // RecordedTreeNode
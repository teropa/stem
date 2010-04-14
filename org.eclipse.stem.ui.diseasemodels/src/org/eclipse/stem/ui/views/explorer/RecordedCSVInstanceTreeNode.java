// RecordedCSVInstanceTreeNode.java
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

import java.io.File;

import org.eclipse.core.resources.IResource;

/**
 * This class represents simulation runs serialized using comma separated values
 * (CSV).
 */
public class RecordedCSVInstanceTreeNode extends RecordedInstanceTreeNode {

	private final IResource file;

	/**
	 * @param parent
	 * @param file
	 */
	public RecordedCSVInstanceTreeNode(final RecordedTreeNode parent,
			final IResource file) {
		super(parent, file.getName());
		this.file = file;
	}

	/**
	 * @param parent
	 * @param file
	 */
	public RecordedCSVInstanceTreeNode(final RecordedInstanceTreeNode parent,
			final IResource file) {
		super(parent, file.getName());
		this.file = file;
	}
	/**
	 * @return the file
	 */
	public IResource getFile() {
		return file;
	}

} // RecordedCSVInstanceTreeNode
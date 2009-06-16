// IdentifiableInstanceTreeNode.java
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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class represents {@link Identifiable}s in the STEM Project Explorer view
 * that is implemented using the {@link CommonNavigator} framework. An instance
 * typically serves as a proxy for the file that serializes the {@link
 * Identifiable}.
 * 
 * @see IdentifiableInstanceTreeNodeContentProvider
 * @see IdentifiableInstanceTreeNodeLabelProvider
 */
public class IdentifiableInstanceTreeNode {

	private final IdentifiableTreeNode parent;
	private final String name;
	private final String extension;

	/**
	 * @param itn
	 * @param name
	 * @param extension
	 * 		the file name extension of the serialized file.
	 */
	public IdentifiableInstanceTreeNode(IdentifiableTreeNode itn, String name,
			String extension) {
		this.parent = itn;
		this.name = name;
		this.extension = extension;
	}

	/**
	 * @return the {@link IdentifiableTreeNode} that is the parent of this node.
	 */
	public final IdentifiableTreeNode getParent() {
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
		return name;
	}

	/**
	 * @return the extension
	 */
	public final String getExtension() {
		return extension;
	}

} // IdentifiableInstanceTreeNode
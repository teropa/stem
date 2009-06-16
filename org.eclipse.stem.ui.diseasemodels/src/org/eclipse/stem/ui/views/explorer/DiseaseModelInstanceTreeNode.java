// DiseaseModelInstanceTreeNode.java
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

import org.eclipse.stem.diseasemodels.standard.DiseaseModel;

/**
 * This class represents an instance of a serialized {@link DiseaseModel}.
 */
public class DiseaseModelInstanceTreeNode extends IdentifiableInstanceTreeNode {

	/**
	 * @param itn
	 * @param name
	 * @param extension
	 * 		the file name extension of the serialized file.
	 */
	public DiseaseModelInstanceTreeNode(final IdentifiableTreeNode itn,
			final String name, final String extension) {
		super(itn, name, extension);
	}

} // DiseaseModelInstanceTreeNode
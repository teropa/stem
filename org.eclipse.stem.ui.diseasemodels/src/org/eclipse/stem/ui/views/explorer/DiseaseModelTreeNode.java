// DiseaseModelTreeNode.java
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

import org.eclipse.core.resources.IProject;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.diseasemodels.ISharedImages;
import org.eclipse.stem.ui.wizards.NewSTEMProjectWizard;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is used in the {@link CommonNavigator} based STEM Project Explorer
 * view to represent a group of {@link DiseaseModel}s that belong to a
 * particular STEM Project instance.
 */
public class DiseaseModelTreeNode extends IdentifiableTreeNode {

	/**
	 * @param project
	 */
	public DiseaseModelTreeNode(final IProject project) {
		super(project, "Disease Models",
				NewSTEMProjectWizard.DECORATORS_FOLDER_NAME,
				ISharedImages.DISEASE_ICON);
	} // DiseaseModelTreeNode

} // DiseaseModelTreeNode
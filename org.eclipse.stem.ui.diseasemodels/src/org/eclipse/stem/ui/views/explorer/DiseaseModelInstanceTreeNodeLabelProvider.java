// DiseaseModelInstanceTreeNodeLabelProvider.java
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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.stem.diseasemodels.standard.presentation.DiseasemodelsEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is a {@link ILabelProvider} for {@link
 * DiseaseModelInstanceTreeNode}s which appear in the {@link CommonNavigator}
 * framework that is used to explore STEM Projects.
 * 
 * @see DiseaseModelInstanceTreeNodeContentProvider
 */
public class DiseaseModelInstanceTreeNodeLabelProvider extends
		IdentifiableInstanceTreeNodeLabelProvider {

	/**
	 * @see org.eclipse.stem.ui.views.explorer.
	 * 	IdentifiableInstanceTreeNodeLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		Image retValue = null;
		if (element instanceof IdentifiableInstanceTreeNode) {
			// Yes
			final IdentifiableInstanceTreeNode iitn = (IdentifiableInstanceTreeNode) element;

			retValue = DiseasemodelsEditorPlugin.getPlugin().getImageRegistry()
					.get(iitn.getParent().getImageKey());

		} // if IdentifiableInstanceTreeNode
		return retValue;
	}

} // DiseaseModelInstanceTreeNodeLabelProvider
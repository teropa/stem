// IdentifiableTreeNodeLabelProvider.java
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
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * This class is an {@link ILabelProvider} for the contributions to the
 * org.eclipse.ui,navigator.navigatorContents extension point that represent the
 * components of the STEM modeling framework. These contributions are instances
 * of {@link IdentifiableTreeNode} which are used to aggregate instances of a
 * single type of component in a STEM project. For instance, all of the
 * serialized {@link org.eclipse.stem.core.model.Decorator} instances, or all of
 * the {@link org.eclipse.stem.core.scenario.Scenario} instances.
 */
public class IdentifiableTreeNodeLabelProvider implements ILabelProvider {

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		Image retValue = null;
		if (element instanceof IdentifiableTreeNode) {
			// Yes
			final IdentifiableTreeNode ctn = (IdentifiableTreeNode) element;
			retValue = Activator.getDefault().getImageRegistry().get(
					ctn.getImageKey());
		} // if IdentifiableTreeNode
		return retValue;
	} // getImage

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		return ((IdentifiableTreeNode) element).getComponentName();
	}

	/**
	 * @see
	 * 	org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
	 * 	jface.viewers.ILabelProviderListener)
	 */
	public void addListener(
			@SuppressWarnings("unused") ILabelProviderListener listener) {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		// Nothing
	}

	/**
	 * @see
	 * 	org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang
	 * 	.Object, java.lang.String)
	 */
	public boolean isLabelProperty(@SuppressWarnings("unused") Object element,
			@SuppressWarnings("unused") String property) {
		return false;
	}

	/**
	 * @see
	 * 	org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
	 * 	.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(
			@SuppressWarnings("unused") ILabelProviderListener listener) {
		// Nothing
	}

} // IdentifiableTreeNodeLabelProvider
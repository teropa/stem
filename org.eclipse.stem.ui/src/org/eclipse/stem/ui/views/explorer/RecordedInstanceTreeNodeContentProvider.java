// RecordedInstanceTreeNodeContentProvider.java
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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is a {@link ITreeContentProvider} for {@link
 * RecordedInstanceTreeNode}s which appear in the {@link CommonNavigator}
 * framework that is used to explore STEM Projects.
 * 
 * @see RecordedInstanceTreeNodeLabelProvider
 */
@SuppressWarnings("unused")
public abstract class RecordedInstanceTreeNodeContentProvider implements
		ITreeContentProvider {

	/**
	 * @see
	 * 	org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * 	Object)
	 */
	abstract public Object[] getChildren(Object parentElement);

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.
	 * 	Object)
	 */
	public Object getParent(Object element) {
		Object retValue = null;
		if (element instanceof RecordedInstanceTreeNode) {
			retValue = ((RecordedInstanceTreeNode) element).getParent();
		} // if IdentifiableInstanceTreeNode
		return retValue;
	}

	/**
	 * @see
	 * 	org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * 	Object)
	 */
	abstract public boolean hasChildren(Object element);

	/**
	 * @see
	 * 	org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 * 	.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.
	 * 	jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing
	}

} // RecordedInstanceTreeNodeContentProvider
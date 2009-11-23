// IdentifiableTreeNodeContentProvider.java
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
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This class is a {@link IContentProvider} for the contributions to the
 * org.eclipse.ui,navigator.navigatorContents extension point that represent the
 * components of the STEM modeling framework. These contributions are instances
 * of {@link IdentifiableTreeNode} which are used to aggregate instances of a
 * single type of component in a STEM project. For instance, all of the
 * serialized {@link org.eclipse.stem.core.model.Decorator} instances, or all of
 * the {@link org.eclipse.stem.core.scenario.Scenario} instances.
 */
public class IdentifiableTreeNodeContentProvider implements
		ITreeContentProvider {

	protected Object input = null;

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 *      Object)
	 */
	public Object[] getChildren(Object parentElement) {
		Object[] retValue = null;
		if (parentElement instanceof IProject) {
			// Yes
			retValue = new Object[] {
					new IdentifiableTreeNode.ScenariosTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.ExperimentsTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.SequencersTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.ModelsTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.GraphsTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.DecoratorsTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.TriggersTreeNode(
							(IProject) parentElement),

					new IdentifiableTreeNode.PredicatesTreeNode(
							(IProject) parentElement),
							
					new IdentifiableTreeNode.ModifiersTreeNode(
									(IProject) parentElement)

			}; // new Object
		} // if IProject
		else if (parentElement instanceof IdentifiableTreeNode) {
			// Yes
			// final IdentifiableTreeNode ctn = (IdentifiableTreeNode)
			// parentElement;
			retValue = new Object[0]; // never null

		} // if IdentifiableTreeNode
		return retValue;
	} // getChildren

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.
	 *      Object)
	 */
	public Object getParent(Object element) {
		Object retValue = null;
		if (element instanceof IdentifiableTreeNode) {
			// Yes
			final IdentifiableTreeNode ctn = (IdentifiableTreeNode) element;
			retValue = ctn.getProject();
		} // if IdentifiableTreeNode

		return retValue;
	} // getParent

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 *      .lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 *      Object)
	 */
	public boolean hasChildren(@SuppressWarnings("unused") Object element) {
		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// Nothing
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.
	 *      jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(@SuppressWarnings("unused") Viewer viewer,
			@SuppressWarnings("unused") Object oldInput, Object newInput) {
		input = newInput;
	}

} // IdentifiableTreeNodeContentProvider
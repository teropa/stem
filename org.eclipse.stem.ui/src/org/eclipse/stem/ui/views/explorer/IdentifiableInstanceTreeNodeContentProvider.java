// IdentifiableInstanceTreeNodeContentProvider.java
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is a {@link ITreeContentProvider} for
 * {@link IdentifiableInstanceTreeNode}s which appear in the
 * {@link CommonNavigator} framework that is used to explore STEM Projects.
 */
@SuppressWarnings("unused")
public class IdentifiableInstanceTreeNodeContentProvider implements
		ITreeContentProvider, IResourceChangeListener, IResourceDeltaVisitor {

	Viewer viewer;

	/**
	 * Default Constructor
	 */
	public IdentifiableInstanceTreeNodeContentProvider() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
				IResourceChangeEvent.POST_CHANGE);
	} // IdentifiableInstanceTreeNodeContentProvider

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 *      Object)
	 */
	public Object[] getChildren(final Object parentElement) {
		Object[] retValue = null;
		// Right kind of parent?
		if (parentElement instanceof IdentifiableTreeNode) {
			// Yes
			final List<IdentifiableInstanceTreeNode> temp = new ArrayList<IdentifiableInstanceTreeNode>();
			
			final IdentifiableTreeNode itn = (IdentifiableTreeNode) parentElement;

			final IFolder folder = itn.getProject().getFolder(
					itn.getFolderName());
			
			// Does the folder exist?
			if (folder.exists()) {
				// Yes
				try {
					for (final IResource identifiableFile : folder.members()) {
						final String identifiableName = identifiableFile
								.getName();
						final String extension = identifiableFile
								.getFileExtension();
						final String nameWithoutExtension = identifiableName
								.substring(0, identifiableName
										.lastIndexOf(extension) - 1);
						temp.add(new IdentifiableInstanceTreeNode(itn,
								nameWithoutExtension, extension));
					}
				} catch (final CoreException e) {
					Activator.logError("", e);
				} // for each IResource folder.members()
			} // if folder exists
			
			retValue = temp.toArray();

		} // if IdentifiableTreeNode

		return retValue;
	} // getChildren

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.
	 *      Object)
	 */
	public Object getParent(final Object element) {
		Object retValue = null;
		if (element instanceof IdentifiableInstanceTreeNode) {
			retValue = ((IdentifiableInstanceTreeNode) element).getParent();
		} // if IdentifiableInstanceTreeNode
		return retValue;
	} // getParent

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 *      Object)
	 */
	public boolean hasChildren(final Object parentElement) {
		Object[] children = getChildren(parentElement);
		return children != null && children.length > 0;
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 *      .lang.Object)
	 */
	public Object[] getElements(final Object inputElement) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.
	 *      jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(final Viewer viewer, final Object oldInput,
			final Object newInput) {
		this.viewer = viewer;
	}

	/**
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org
	 *      .eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(final IResourceChangeEvent event) {
		try {
			event.getDelta().accept(this);
		} catch (final CoreException e) {
			Activator.logError("", e);
		}
	} // resourceChanged

	/**
	 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core
	 *      .resources.IResourceDelta)
	 */
	public boolean visit(final IResourceDelta delta) throws CoreException {
		final Display display = Display.getDefault();
		// Is the display valid?
		if (display != null) {
			// Yes
			display.asyncExec(new Runnable() {
				public void run() {
					viewer.refresh();
				}
			});
		} // if

		return true;
	} // visit

} // IdentifiableInstanceTreeNodeContentProvider
// RecordedCSVInstanceTreeNodeContentProvider.java
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
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.stem.diseasemodels.standard.presentation.DiseasemodelsEditorPlugin;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is a {@link RecordedInstanceTreeNodeContentProvider} for {@link
 * RecordedCSVInstanceTreeNode}s which appear in the {@link CommonNavigator}
 * framework that is used to explore STEM Projects.
 * 
 * @see RecordedCSVInstanceTreeNodeLabelProvider
 */
public class RecordedCSVInstanceTreeNodeContentProvider extends
		RecordedInstanceTreeNodeContentProvider {

	/**
	 * @see org.eclipse.stem.ui.views.explorer.
	 * 	RecordedInstanceTreeNodeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(final Object parentElement) {
		Object[] retValue = null;
		// Right parent?
		if (parentElement instanceof RecordedTreeNode) {
			// Yes
			final RecordedTreeNode parent = (RecordedTreeNode) parentElement;
			final File csvFolder = DiseasemodelsEditorPlugin.getPlugin()
					.getStateLocation().append("csv").toFile();

			// Is the csvFolder a readable directory?
			if (csvFolder.isDirectory() && csvFolder.canRead()) {
				// Yes
				final File[] csvSubFolders = csvFolder
						.listFiles(new FileFilter() {
							public boolean accept(File file) {
								return file.isDirectory();
							}
						});

				// Create the nodes that will represent the files in the common
				// navigator framework
				final List<Object> temp = new ArrayList<Object>();
				for (File file : csvSubFolders) {
					temp.add(new RecordedCSVInstanceTreeNode(parent, file));
				} // for each File
				retValue = temp.toArray();
			} // if readable directory
		} // if RecordedTreeNode

		return retValue;
	} // getChildren

	/**
	 * @see org.eclipse.stem.ui.views.explorer.
	 * 	RecordedInstanceTreeNodeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(final Object element) {
		return false;
	}

} // RecordedCSVInstanceTreeNodeContentProvider
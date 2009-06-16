// DiseaseModelInstanceTreeNodeContentProvider.java
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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.ui.Activator;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This class is a {@link IdentifiableInstanceTreeNodeContentProvider} for
 * {@link DiseaseModelInstanceTreeNode}s which appear in the {@link
 * CommonNavigator} framework that is used to explore STEM Projects.
 * 
 * @see DiseaseModelInstanceTreeNodeLabelProvider
 */
public class DiseaseModelInstanceTreeNodeContentProvider extends
		IdentifiableInstanceTreeNodeContentProvider {

	/**
	 * @see org.eclipse.stem.ui.views.explorer.
	 * 	IdentifiableInstanceTreeNodeContentProvider
	 * 	#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(final Object parentElement) {
		Object[] retValue = null;
		// Right kind of parent?
		if (parentElement instanceof IdentifiableTreeNode) {
			// Yes
			final IdentifiableTreeNode itn = (IdentifiableTreeNode) parentElement;

			final IFolder folder = itn.getProject().getFolder(
					itn.getFolderName());

			final List<IdentifiableInstanceTreeNode> temp = new ArrayList<IdentifiableInstanceTreeNode>();

			try {
				for (final IResource identifiableFile : folder.members()) {
					// A disease model?
					if (isDiseaseModel(identifiableFile)) {
						// Yes
						final String identifiableName = identifiableFile
								.getName();
						final String extension = identifiableFile
								.getFileExtension();
						final String nameWithoutExtension = identifiableName
								.substring(0, identifiableName
										.indexOf(extension) - 1);
						temp.add(new IdentifiableInstanceTreeNode(itn,
								nameWithoutExtension, extension));
					} // if disease model
				} // for
			} catch (final CoreException e) {
				Activator.logError("", e);
			} // for each IResource folder.members()

			retValue = temp.toArray();

		} // if IdentifiableTreeNode

		return retValue;
	} // getChildren

	/**
	 * @param identifiableFile
	 * 		a file holding a serialized {@link Identifiable}.
	 * @return <code>true</code> if the file holds a serialized {@link
	 * 	DiseaseModel}
	 */
	protected boolean isDiseaseModel(final IResource identifiableFile) {
		return identifiableFile.getFileExtension().endsWith(
				StandardPackage.eNAME);
	} // isDiseaseModel

} // DiseaseModelInstanceTreeNodeContentProvider
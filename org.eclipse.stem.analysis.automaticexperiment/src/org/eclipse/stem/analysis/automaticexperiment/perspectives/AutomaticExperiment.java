// Analysis.java
package org.eclipse.stem.analysis.automaticexperiment.perspectives;

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

import org.eclipse.stem.analysis.automaticexperiment.views.AutoExpView;
import org.eclipse.stem.core.Constants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


/**
 * This class implements the "Analysis" perspective of STEM. This perspective is
 * used to review and compare the results of different runs.
 */
public class AutomaticExperiment implements IPerspectiveFactory {

	/**
	 * The identifier of the Designer Perspective
	 */
	public static final String ID_STEM_AUTOMATIC_EXPERIMENT_PERSPECTIVE = Constants.ID_ROOT
			+ ".analysis.automaticexperiment.perspectives.AutomaticExperimentPerspective"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui
	 *      .IPageLayout)
	 */
	public void createInitialLayout(final IPageLayout layout) {
		final String editorArea = layout.getEditorArea();

		// We don't want to see the editor
		layout.setEditorAreaVisible(false);
		
		// Put the STEM Analysis Views on top
		final IFolderLayout top = layout.createFolder(
				"top", IPageLayout.TOP, //$NON-NLS-1$
				1.00f, editorArea);
		
		top.addView(AutoExpView.ID_AutoExp_VIEW);
		
		
		// 
		layout.addShowViewShortcut(AutoExpView.ID_AutoExp_VIEW);
		
		// We don't want to see the editor
		layout.setEditorAreaVisible(false);

		// Add the Analysis perspective to the "Open Perspective" menu
		layout.addPerspectiveShortcut(ID_STEM_AUTOMATIC_EXPERIMENT_PERSPECTIVE);

	} // createInitialLayout

} // Analysis
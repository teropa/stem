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
import org.eclipse.ui.navigator.resources.ProjectExplorer;


/**
 * This class implements the "Analysis" perspective of STEM. This perspective is
 * used to review and compare the results of different runs.
 */
public class AutomaticExperiment implements IPerspectiveFactory {

	/**
	 * The identifier of the Designer Perspective
	 */
	public static final String ID_STEM_AUTOMATIC_EXPERIMENT_PERSPECTIVE = Constants.ID_ROOT
			+ ".analysis.automaticexperiment.perspective"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui
	 *      .IPageLayout)
	 */
	public void createInitialLayout(final IPageLayout layout) {
		final String editorArea = layout.getEditorArea();

		// We don't want to see the editor
		layout.setEditorAreaVisible(false);
		// Put the STEM Analysis View by itself on the top
		layout.addStandaloneView(AutoExpView.ID_AutoExp_VIEW, true, IPageLayout.RIGHT,
				0.0f, editorArea);
		
		// Put the ProjectExplorer view on the left
		final IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.20f, AutoExpView.ID_AutoExp_VIEW);
		left.addView(ProjectExplorer.VIEW_ID);
		
		// Put the Error Log
		final IFolderLayout bottom = layout.createFolder("right", IPageLayout.BOTTOM, //$NON-NLS-1$
				0.60f, AutoExpView.ID_AutoExp_VIEW);
		// add Error Log view
		bottom.addView("org.eclipse.pde.runtime.LogView"); //$NON-NLS-1$
		
		// add the view to the "Show Views" menu
		layout.addShowViewShortcut(AutoExpView.ID_AutoExp_VIEW);
		
		// We don't want to see the editor
		layout.setEditorAreaVisible(false);

		// Add the Analysis perspective to the "Open Perspective" menu
		layout.addPerspectiveShortcut(ID_STEM_AUTOMATIC_EXPERIMENT_PERSPECTIVE);

		
	} // createInitialLayout

} // Analysis
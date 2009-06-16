// Analysis.java
package org.eclipse.stem.util.analysis.perspectives;

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

import org.eclipse.stem.core.Constants;
import org.eclipse.stem.util.analysis.views.EpidemicView;
import org.eclipse.stem.util.analysis.views.EstimatorView;
import org.eclipse.stem.util.analysis.views.LyapunovView;
import org.eclipse.stem.util.analysis.views.ProcessorView;
import org.eclipse.stem.util.analysis.views.ScenarioComparisonView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


/**
 * This class implements the "Analysis" perspective of STEM. This perspective is
 * used to review and compare the results of different runs.
 */
public class Analysis implements IPerspectiveFactory {

	/**
	 * The identifier of the Designer Perspective
	 */
	public static final String ID_STEM_ANALYSIS_PERSPECTIVE = Constants.ID_ROOT
			+ ".util.analysis.perspectives.STEMAnalysisPerspective"; //$NON-NLS-1$

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
		
		top.addView(ProcessorView.ID_Processor_VIEW);
		top.addView(EstimatorView.ID_Estimator_VIEW);
		top.addView(ScenarioComparisonView.ID_Comparison_VIEW);
		top.addView(LyapunovView.ID_Lyapunov_VIEW);
		top.addView(EpidemicView.ID_Aggregate_VIEW);
		
		// TODO fix hard coded ids
		layout.addShowViewShortcut(ProcessorView.ID_Processor_VIEW);
		layout.addShowViewShortcut(EstimatorView.ID_Estimator_VIEW);
		layout.addShowViewShortcut(ScenarioComparisonView.ID_Comparison_VIEW);
		layout.addShowViewShortcut(LyapunovView.ID_Lyapunov_VIEW);
		layout.addShowViewShortcut(EpidemicView.ID_Aggregate_VIEW);
		
		//top.addView(ProjectExplorer.VIEW_ID);

		// Put the Graphs View on the bottom with the Tasks View
		// @SuppressWarnings("unused")
		//		IFolderLayout bottom = layout.createFolder("bottom", //$NON-NLS-1$
		// IPageLayout.BOTTOM, 0.66f, editorArea);

		// We don't want to see the editor
		layout.setEditorAreaVisible(false);

		// Add the Analysis perspective to the "Open Perspective" menu
		layout.addPerspectiveShortcut(ID_STEM_ANALYSIS_PERSPECTIVE);

	} // createInitialLayout

} // Analysis
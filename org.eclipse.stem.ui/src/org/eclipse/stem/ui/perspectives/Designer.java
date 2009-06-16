// Designer.java
package org.eclipse.stem.ui.perspectives;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.Constants;
import org.eclipse.stem.ui.views.DecoratorsView;
import org.eclipse.stem.ui.views.GraphsView;
import org.eclipse.stem.ui.views.ModelsView;
import org.eclipse.stem.ui.views.PredicatesView;
import org.eclipse.stem.ui.views.ScenariosView;
import org.eclipse.stem.ui.views.SequencersView;
import org.eclipse.stem.ui.views.SimulationControlView;
import org.eclipse.stem.ui.views.TriggersView;
import org.eclipse.stem.ui.wizards.NewSTEMProjectWizard;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

/**
 * This class implements the "Designer" perspective of STEM. This Perspective is
 * used to create or "design" simulations.
 */
public class Designer implements IPerspectiveFactory {

	/**
	 * The identifier of the Designer Perspective
	 */
	public static final String ID_STEM_DESIGNER_PERSPECTIVE = Constants.ID_ROOT
			+ ".ui.STEMDesignerPerspective"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(final IPageLayout layout) {
		final String editorArea = layout.getEditorArea();

		// Put the STEM Project Explorer view on the left side
		final IFolderLayout left = layout.createFolder(
				"left", IPageLayout.LEFT, //$NON-NLS-1$
				0.25f, editorArea);
		left.addView(ProjectExplorer.VIEW_ID);

		// Put the Graphs View on the bottom with the Tasks View
		final IFolderLayout bottom = layout.createFolder("bottom", //$NON-NLS-1$
				IPageLayout.BOTTOM, 0.66f, editorArea);

		bottom.addView(ScenariosView.ID_SCENARIOS_VIEW);
		bottom.addView(ModelsView.ID_MODELS_VIEW);
		bottom.addView(GraphsView.ID_GRAPHS_VIEW);

		bottom.addView(TriggersView.ID_TRIGGERS_VIEW);
		bottom.addView(PredicatesView.ID_PREDICATES_VIEW);
		bottom.addView(SequencersView.ID_SEQUENCERS_VIEW);
		bottom.addView(DecoratorsView.ID_DECORATORS_VIEW);

		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(IPageLayout.ID_TASK_LIST);
		bottom.addPlaceholder(IPageLayout.ID_PROBLEM_VIEW);
		// add Error Log view
		bottom.addView("org.eclipse.pde.runtime.LogView"); //$NON-NLS-1$
		// Put the Outline view on the right
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, .75f,
				editorArea);

		// Add the Views to "Show View" menu
		layout
				.addShowViewShortcut(SimulationControlView.ID_SIMULATION_CONTROL_VIEW);
		layout.addShowViewShortcut(GraphsView.ID_GRAPHS_VIEW);
		layout.addShowViewShortcut(ModelsView.ID_MODELS_VIEW);
		layout.addShowViewShortcut(ScenariosView.ID_SCENARIOS_VIEW);
		layout.addShowViewShortcut(SequencersView.ID_SEQUENCERS_VIEW);
		layout.addShowViewShortcut(DecoratorsView.ID_DECORATORS_VIEW);
		layout.addShowViewShortcut(TriggersView.ID_TRIGGERS_VIEW);
		layout.addShowViewShortcut(PredicatesView.ID_PREDICATES_VIEW);
		layout.addShowViewShortcut(ProjectExplorer.VIEW_ID);

		// Add the Wizards to the "New..." menu
		layout
				.addNewWizardShortcut(NewSTEMProjectWizard.ID_STEM_PROJECT_WIZARD);

		// Add the Designer perspective to the "Open Perspective" menu
		layout.addPerspectiveShortcut(ID_STEM_DESIGNER_PERSPECTIVE);

	} // createInitialLayout

} // Designer

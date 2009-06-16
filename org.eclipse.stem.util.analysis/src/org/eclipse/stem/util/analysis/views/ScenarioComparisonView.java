// EstimatorView 
package org.eclipse.stem.util.analysis.views;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/


import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * This view provides for a Cross PhaseSynchronizer analysis, comparing two scenarios
 */

public class ScenarioComparisonView extends ViewPart {


	/**
	 * The identifier of the Comparison View {@value}
	 */
	public static final String ID_Comparison_VIEW = "org.eclipse.stem.util.analysis.views.comparison"; //$NON-NLS-1$



	private AnalysisViewer analysisViewer;

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(final Composite parent) {

		analysisViewer = new AnalysisViewer(parent, ScenarioComparisonFactory.INSTANCE);
		analysisViewer.setInput(SimulationManager.getManager());

		getSite().setSelectionProvider(analysisViewer);


	} // createPartControl

	

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	} // dispose

	/**
	 * This is required by the interface, but we're not using it.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// Nothing
	} // setFocus

} // EstimatorView

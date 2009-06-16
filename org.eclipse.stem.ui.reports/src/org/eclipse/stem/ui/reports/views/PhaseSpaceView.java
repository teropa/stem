package org.eclipse.stem.ui.reports.views;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.ui.views.geographic.map.SelectedReportsManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

/**
 * This view contains BIRT output that plots values of variables in STEM
 * simulations.
 */

public class PhaseSpaceView extends ViewPart implements ISelectionListener {

	/**
	 * The identifier of the Phase Space View
	 */
	public static final String ID_PHASE_SPACE_VIEW = "org.eclipse.stem.ui.reports.views.PhaseSpace"; //$NON-NLS-1$

	private List<Identifiable> selectedIdentifiables = null;

	/**
	 * This is the decorator that has been selected by the combo box.
	 */
	protected Decorator selectedDecorator;

	/**
	 * This is the combo box that displays the Decorators that can be selected
	 */
	protected Combo decoratorCombo;

	/**
	 * This is the combo box that displays the X axis properties of the selected
	 * Decorator
	 */
	protected Combo propertiesComboX;

	/**
	 * This is the combo box that displays the Y axis properties of the selected
	 * Decorator
	 */
	protected Combo propertiesComboY;

	private ReportViewer reportViewer;

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(final Composite parent) {

		// phaseSpaceHistoryPlotter = new PhaseSpaceHistoryPlotter(parent);

		reportViewer = new ReportViewer(parent, PhaseSpaceFactory.INSTANCE);
		reportViewer.setInput(SimulationManager.getManager());

		getSite().setSelectionProvider(reportViewer);

		// Register with the SelectionService
		getSite().getWorkbenchWindow().getSelectionService()
				.addSelectionListener(this);

	} // createPartControl

	/**
	 * This method is called whenever ANYTHING is selected in the Eclipse
	 * workbench. It's job is to filter out selections of ISimulation instances
	 * and update the chart in the TimeSeriesCanvas
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(final IWorkbenchPart part,
			final ISelection selection) {

		// Is this selection changed event coming from our view?
		if (part != PhaseSpaceView.this) {
			// No
			if (selectedIdentifiables == null) {
				// Yes
				selectedIdentifiables = new ArrayList<Identifiable>();
			} // if
			selectedIdentifiables.clear();

			// Is it a structured selection?
			if (selection instanceof IStructuredSelection) {
				// Yes
				final List list = ((IStructuredSelection) selection).toList();

				// Go through everything in the list of things that were
				// selected and pick out the ones that are ISimulations.
				for (final Iterator selectionIter = list.iterator(); selectionIter
						.hasNext();) {
					final Object obj = selectionIter.next();

					if (obj instanceof Identifiable) {
						// Make sure that the report is indeed enabled in the context menu						
						if (SelectedReportsManager.getInstance().isReportEnabled(PhaseSpaceFactory.PHASE_SPACE_TYPE)) {
							reportViewer.addMonitor((Identifiable)obj);
						}
					} // if
				} // for each selected item
			} // if structured selection

		} // if selection changed event coming from our view?
	} // selectionChanged

	
	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		getSite().getWorkbenchWindow().getSelectionService()
				.removeSelectionListener(this);
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

} // PhaseSpaceView

package org.eclipse.stem.ui.reports.views;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.ui.views.geographic.map.SelectedReportsManager;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

/**
 * The class is a delegation for the popup menu of the
 * <code>GeographicRenderer</code>. The purpose of this class is to handle
 * the activity in the reports context menu and keep the current state of all
 * enabled/disabled reports from that menu. The report's <code>ViewPart</code>
 * object will use this class for checking whether to generate a report or not.
 */
public class ReportsContextMenuAction 
	implements IViewActionDelegate {
	
	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(org.eclipse.jface.action.IAction action) {
		String reportId = action.getId();
		
		if (SelectedReportsManager.getInstance().isReportEnabled(reportId)) { // The report was previously enabled so disable it
			SelectedReportsManager.getInstance().disableReportForIdentifiable(reportId);
			action.setChecked(false);
		}
		else
		{
			SelectedReportsManager.getInstance().enableReportForIdentifiable(reportId);
			action.setChecked(true);
		}
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(@SuppressWarnings("unused")
	org.eclipse.jface.action.IAction action,
			@SuppressWarnings("unused")
			org.eclipse.jface.viewers.ISelection selection) {
		// Do Nothing
	}

	/**
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(@SuppressWarnings("unused")
	IViewPart arg0) {
		// Do Nothing
	}
}

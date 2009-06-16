package org.eclipse.stem.ui.views.geographic.map;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//$ANALYSIS-IGNORE
/**
 * The purpose of this <i>Singleton</i> class it to keep the current status of
 * all enabled/disabled reports for the specific MapControl. Each MapControl has
 * a context menu with a list of reports that can be generated once the user
 * left-clicks on an area in the map. The user can disable/enable some or all of
 * the reports using this context menu. This class keeps current status for each
 * one of these menus.
 */
public class SelectedReportsManager {
	/**
	 * The single instance of this class
	 */
	private static SelectedReportsManager instance;
	/**
	 * List of reports IDs that has been enabled for the specific MapCanvas
	 */
	private final Map<MapCanvas, List<String>> enabledReportsMap = new HashMap<MapCanvas, List<String>>();
	/**
	 * List of reports that has been clicked before. Init state is that all
	 * reports are enabled.
	 */
	private final Map<MapCanvas, List<String>> alreadySelectedReports = new HashMap<MapCanvas, List<String>>();
	/**
	 * The recent MapCanvas that the user clicked on with the mouse (any mouse
	 * button)
	 */
	private MapCanvas recentClickedMapCanvas = null;

	/**
	 * Private constructor as it is Singleton class
	 */
	private SelectedReportsManager() {
		// Do nothing
	}

	/**
	 * The method will return the single instance of this class
	 * 
	 * @return The single instance of this class
	 */
	public static SelectedReportsManager getInstance() {
		if (instance == null) {
			instance = new SelectedReportsManager();
		}
		return instance;
	}

	/**
	 * The method will mark the specific report as enabled.
	 * 
	 * @param reportID
	 *            The report ID to be enabled
	 */
	public void enableReportForIdentifiable(final String reportID) {
		List<String> enabledReports = null;
		if (enabledReportsMap.containsKey(recentClickedMapCanvas)) {
			enabledReports = enabledReportsMap.get(recentClickedMapCanvas);
			enabledReportsMap.remove(recentClickedMapCanvas);
		}
		if (null == enabledReports) {
			enabledReports = new ArrayList<String>();
		}
		enabledReports.add(reportID);
		enabledReportsMap.put(recentClickedMapCanvas, enabledReports);
	}

	/**
	 * The method will mark the specific report as disabled.
	 * 
	 * @param reportID
	 *            The report ID to be disabled
	 */
	public void disableReportForIdentifiable(final String reportID) {
		List<String> enabledReports = null;
		if (enabledReportsMap.containsKey(recentClickedMapCanvas)) {
			enabledReports = enabledReportsMap.get(recentClickedMapCanvas);
			enabledReportsMap.remove(recentClickedMapCanvas);
		}
		if (null != enabledReports) {
			enabledReports.remove(reportID);
		}
		List<String> initializedReports = alreadySelectedReports
				.get(recentClickedMapCanvas);
		if (initializedReports == null) {
			initializedReports = new ArrayList<String>();
		}
		initializedReports.add(reportID);
		if (alreadySelectedReports.containsKey(recentClickedMapCanvas)) {
			alreadySelectedReports.remove(recentClickedMapCanvas);
		}
		alreadySelectedReports.put(recentClickedMapCanvas, initializedReports);
	}

	/**
	 * The method will check whether the specific report is enabled or disabled
	 * for the current MapCanvas.
	 * 
	 * @param reportID
	 *            Report ID to be checked
	 * @return <code>true</code> if the report is enabled and
	 *         <code>false</code> if not
	 */
	public boolean isReportEnabled(final String reportID) {
		final List<String> initializedReports = alreadySelectedReports
				.get(recentClickedMapCanvas);
		if (initializedReports == null
				|| !initializedReports.contains(reportID)) {
			return true;
		}

		if (!enabledReportsMap.containsKey(recentClickedMapCanvas)) {
			return false;
		}
		final List<String> enabledReports = enabledReportsMap
				.get(recentClickedMapCanvas);
		if (enabledReports == null || !enabledReports.contains(reportID)) {
			return false;
		}
		return true;
	}

	/**
	 * Get the MapCanvas that the user clicked on
	 * 
	 * @return the MapCanvas that the user clicked on
	 */
	public MapCanvas getRecentClickedMapCanvas() {
		return recentClickedMapCanvas;
	}

	/**
	 * Set the MapCanvas that the user clicked on
	 * 
	 * @param recentClickedMapCanvas
	 *            the MapCanvas that the user clicked on
	 */
	public void setRecentClickedMapCanvas(final MapCanvas recentClickedMapCanvas) {
		this.recentClickedMapCanvas = recentClickedMapCanvas;
	}

	/**
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

// MapView.java
package org.eclipse.stem.ui.views.geographic.map;

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

import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.views.IContextMenuUpdatesListener;
import org.eclipse.stem.ui.views.geographic.GeographicViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * This class is a {@link ViewPart} that renders Lat/Long data for active
 * Simulations.
 */
public class MapView extends ViewPart implements IContextMenuUpdatesListener {

	/**
	 * The ID of the Map View.
	 */
	public static final String ID_MAP_VIEW = "org.eclipse.stem.ui.views.geographic.map";

	/**
	 * The viewer that displays the geographic state of the simulations.
	 */
	private GeographicViewer geographicViewer;

	/**
	 * Default Constructor
	 */
	public MapView() {
		super();
		// Set the values of various visualization preferences
		setPreferences();

		try {
			// Listen for changes to the preferences and change the value we
			// use if the user changes the value on the preference page.
			Activator.getDefault().getPluginPreferences()
					.addPropertyChangeListener(new IPropertyChangeListener() {
						public void propertyChange(@SuppressWarnings("unused")
						final PropertyChangeEvent event) {
							setPreferences();
						} // propertyChange
					} // IPropertyChangeListener
					);
		} catch (final Exception e) {
			// Ignore
		} // catch Exception

	} // MapView

	/**
	 * Set preferences
	 */
	void setPreferences() {
		// Nothing yet
	} // setPreferences

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(final Composite parent) {
		geographicViewer = new GeographicViewer(parent,
				MapControlFactory.INSTANCE);
		//Set this instance to be a listener for context menu updates
		geographicViewer.addContextMenuUpdateListener(this);
		geographicViewer.setInput(SimulationManager.getManager());
		getSite().setSelectionProvider(geographicViewer);
	} // createPartControl

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// Nothing
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		getSite().setSelectionProvider(null);
		geographicViewer.removeContextMenuUpdateListener(this);
		geographicViewer.setInput(null);		
	} // dispose

	/**
	 * @see org.eclipse.stem.ui.views.IContextMenuUpdatesListener#onContextMenuUpdate(org.eclipse.jface.action.MenuManager, org.eclipse.jface.viewers.ISelectionProvider)
	 */
	public void onContextMenuUpdate(MenuManager menuManager, ISelectionProvider selectionProvider) {
		getSite().registerContextMenu("org.eclipse.stem.ui.views.geographic.map.context", menuManager, selectionProvider);
	}

} // MapView

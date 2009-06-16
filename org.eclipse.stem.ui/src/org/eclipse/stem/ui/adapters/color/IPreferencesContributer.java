// IPreferencesContributer.java
package org.eclipse.stem.ui.adapters.color;

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

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.stem.ui.preferences.MapsColorsPreferencePage;

/**
 * This interface should be implemented by those entities that wish to contribute
 * preferences fields to the Maps Colors preferences page.
 */
public interface IPreferencesContributer {

	/**
	 * Sets the {@link MapsColorsPreferencePage}
	 * @param preferencePage the {@link MapsColorsPreferencePage}
	 */
	public void setPreferencePage(MapsColorsPreferencePage preferencePage);
	/**
	 * Creates the preferences fields and add them to the preferences page
	 */
	public void createFieldEditors();
	/**
	 * Initialize the preferences fields
	 */
	public void initialize();
	/**
	 * Being called whenever a property in the preferences page has been changed.
	 * @param event Event object about the changed property
	 */
	public void propertyChange(PropertyChangeEvent event);
	/**
	 * Loads the preferences fields with default values
	 */
	public void performDefaults();
	
} // IPreferencesContributer

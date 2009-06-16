package org.eclipse.stem.ui.ge.views;
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
import java.io.IOException;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.stem.ui.ge.Activator;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;


/**
 * Handle Advanced Preferences for the 
 * STEM - GoogleEarth interface.
 * 
 * This class was copied from GEPreferencePage.java
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 * 
 * This uses the jface Preferences API rather than
 *  the new SWT Preferences API  because it is simpler 
 *  to implement. 
 *  
 *  The static values used to access the preferences 
 *  and the methods used to access them are 
 *  found in GEPreferencePage so that we can move the 
 *  GUI interface from page to page without changing the 
 *  code that uses the preference. 
 *  For Example, the P_SHOW_BORDER variable and the 
 *  isShowBorder() method is found in GEPerformancePage 
 *  even though the code to set it is found in 
 *  GEAdvancedPerformancePage.
 */

public class GEAdvancedPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
    
	
	
	
	
	
	
	/**
	 * 
	 */
	public static final IPreferenceStore preferences = 
		Activator.getDefault().getPreferenceStore();
	    
	
	/**
	 * construct the Preference page for GoogleEarth interface.
	 * 
	 */
	public GEAdvancedPreferencePage() {
		super(GRID);
		setPreferenceStore(preferences);
		setDescription("Advanced Preferences for the STEM - GoogleEarth interface\n ");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		// Turn the debug option on or off
		addField(
				new BooleanFieldEditor(
					GEPreferencePage.P_DEBUG,
					"&Allow debug output on Console",
					getFieldEditorParent()));
		
		// enable feature to use bounding box to only 
		// generate polygons within the users view
		addField(
				new BooleanFieldEditor(
					GEPreferencePage.P_BBOX,
					"Use GoogleEarth Bounding Box to filter output", 
					getFieldEditorParent()));
        // See GEPerformancePage isShowBorder() method
		addField(
				new BooleanFieldEditor(
					GEPreferencePage.P_SHOW_BORDER,
					"Show Admin Area Borders",
					getFieldEditorParent()));
		

        // See GEPerformancePage isTest() method
		addField(
				new BooleanFieldEditor(
					GEPreferencePage.P_TEST,
					"Experimental Option",
					getFieldEditorParent()));
	}
    
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
	public boolean performOk() {
		try {
			if (preferences instanceof ScopedPreferenceStore) {
			    ScopedPreferenceStore p = (ScopedPreferenceStore)preferences;
			    p.save();
			}
		} catch (IOException e) {			
		    GELog.error("Failure saving Preferences",e);	
		}
		GELog.debug(this,"saved preferences");
		
		//GELog.debug(this,"P_TEST="+GEPreferencePage.isTest());
		
		
		return super.performOk();
	}
	
//public static boolean isTest() {
//		
//		if (preferences != null)
//			return preferences.getBoolean(GEPreferencePage.P_TEST);
//		else 
//			return true;
//	}
} // class
package org.eclipse.stem.tests.ui.ge;
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

import org.eclipse.core.runtime.Plugin;
import org.eclipse.stem.core.Constants;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle.
 * It subclasses AbstractUIPlugin which takes care of 
 * restoring and saving Preferences.
 * 
 * It is not clear if we need this class for the ge.tests 
 * plugin project.  So far it has not hurt!
 */
public class Activator extends Plugin {

	/**
	 * The plug-in ID
	 */ 
	public static final String PLUGIN_ID = Constants.ID_ROOT +".ge.tests"; //$NON-NLS-1$

	/** 
	 * The shared instance
	 * 
	 */
	static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	
	/**
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}


	/**
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		if (plugin == null) 
			plugin = new Activator();
		return plugin;
	}

	
}

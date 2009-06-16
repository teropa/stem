package org.eclipse.stem.geography;

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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.Model;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.stem.geography"; //$NON-NLS-1$

	/**
	 * This is the prefix of the platform {@link URI} for geography {@link Graph}s and {@link Model}s
	 */
	public static final String GEOGRAPHY_FILE_URI_PREFIX = "platform:/plugin/" //$NON-NLS-1$
			+ org.eclipse.stem.geography.Activator.PLUGIN_ID
			+ "/resources/data"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	/**
	 * @param context 
	 * @throws Exception 
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
		return plugin;
	}

	/**
	 * Log an error to the ILog for this plugin
	 * 
	 * @param message
	 *            the localized error message text
	 * @param exception
	 *            the associated exception, or null
	 */
	public static void logError(String message, Throwable exception) {
		plugin.getLog().log(
				new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(),
						0, message, exception));
	} // logError

	/**
	 * Log information to the ILog for this plugin
	 * 
	 * @param message
	 *            the localized information message text
	 * @param exception
	 *            the associated exception, or null
	 */
	public static void logInformation(String message, Throwable exception) {
		plugin.getLog().log(
				new Status(IStatus.INFO, plugin.getBundle().getSymbolicName(),
						0, message, exception));
	} // logInformation


} // Activator

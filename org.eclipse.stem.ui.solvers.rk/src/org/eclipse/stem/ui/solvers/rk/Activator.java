package org.eclipse.stem.ui.solvers.rk;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.stem.core.solver.SolverPropertyEditorAdapterFactory;
import org.eclipse.stem.solvers.rk.presentation.RkEditor;
import org.eclipse.stem.solvers.rk.presentation.RkSolverPropertyEditorAdapterFactory;
import org.eclipse.stem.solvers.rk.presentation.RkSolverPropertyStringProviderAdapterFactory;
import org.eclipse.stem.solvers.rk.provider.RkItemProviderAdapterFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/*******************************************************************************
 * Copyright (c) 2006 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/


/**
 * The main plugin class to be used in the desktop.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The symbolic identifier for this plug-in
	 */
	public static final String PLUGIN_ID = "org.eclipse.stem.ui.solver.rk"; //$NON-NLS-1$

	// The shared instance.
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
		super();
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 * 
	 * @param context
	 * @throws Exception
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		new RkSolverPropertyStringProviderAdapterFactory();
		new RkEditor();
	} // start

	/**
	 * This method is called when the plug-in is stopped
	 * 
	 * @param context
	 * @throws Exception
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance.
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

package org.eclipse.stem.populationmodels.standard.presentation;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.eclipse.stem.core.common.provider.CoreEditPlugin;
import org.eclipse.stem.definitions.edges.provider.DefinitionsEditPlugin;
import org.eclipse.stem.ui.populationmodels.adapters.StandardRelativeValueProviderAdapterFactory;
import org.eclipse.stem.ui.populationmodels.standard.wizards.StandardPopulationModelPropertyEditorAdapterFactory;
import org.eclipse.stem.ui.populationmodels.standard.wizards.StandardPropertyStringProviderAdapterFactory;

/**
 * This is the central singleton for the Standard editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class StandardEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final StandardEditorPlugin INSTANCE = new StandardEditorPlugin();
	
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardEditorPlugin() {
		super
			(new ResourceLocator [] {
				CoreEditPlugin.INSTANCE,
				DefinitionsEditPlugin.INSTANCE,
				EcoreEditPlugin.INSTANCE,
			});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		public Implementation() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
			new StandardPropertyStringProviderAdapterFactory();
			new StandardPopulationModelPropertyEditorAdapterFactory();
			new StandardEditor();
			// Add to RelativeValueProviderAdapterFactory.INSTANCE
			new StandardRelativeValueProviderAdapterFactory();
		}
	}

}

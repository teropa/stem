package org.eclipse.stem.diseasemodels.standard.presentation;

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

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
//import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.stem.core.common.provider.CoreEditPlugin;
import org.eclipse.stem.definitions.edges.provider.DefinitionsEditPlugin;
//import org.eclipse.stem.definitions.labels.provider.DefinitionsEditPlugin;
import org.eclipse.stem.ui.adapters.newmodifierpage.DiseaseNewModifierPageAdapterFactory;
import org.eclipse.stem.ui.diseasemodels.ISharedImages;
import org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditorAdapterFactory;
import org.eclipse.stem.ui.wizards.StandardPropertyStringProviderAdapterFactory;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Diseasemodels editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class DiseasemodelsEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DiseasemodelsEditorPlugin INSTANCE = new DiseasemodelsEditorPlugin();

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
	 * @generated NOT
	 */
	public DiseasemodelsEditorPlugin() {
		super
			(new ResourceLocator [] {
				CoreEditPlugin.INSTANCE,
				/*EcoreEditPlugin.INSTANCE,*/
				DefinitionsEditPlugin.INSTANCE,
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
		 * The symbolic identifier for this plug-in
		 */
		public static final String PLUGIN_ID = "org.eclipse.stem.ui.diseasemodels"; //$NON-NLS-1$
		
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
		}

		/**
		 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
		 */
		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			new StandardPropertyStringProviderAdapterFactory();
			new StandardDiseaseModelPropertyEditorAdapterFactory();
		}

		/**
		 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry)
		 */
		@Override
		protected void initializeImageRegistry(ImageRegistry registry) {
			super.initializeImageRegistry(registry);
			
			final String ICON_PATH_PREFIX = "icons/full/obj16/"; //$NON-NLS-1$
			final String CUSTOM_ICON_PATH_PREFIX = "icons/full/custom16/"; //$NON-NLS-1$C
			
			registry.put(ISharedImages.DISEASE_ICON, imageDescriptorFromPlugin(
					PLUGIN_ID, CUSTOM_ICON_PATH_PREFIX + "disease.gif")); //$NON-NLS-1$

			registry.put(ISharedImages.INFECTOR_ICON, imageDescriptorFromPlugin(
					PLUGIN_ID, CUSTOM_ICON_PATH_PREFIX + "infector.gif")); //$NON-NLS-1$

			registry.put(ISharedImages.RECORDED_CSV_ICON, imageDescriptorFromPlugin(
					PLUGIN_ID, CUSTOM_ICON_PATH_PREFIX + "recordedcsv.gif")); //$NON-NLS-1$

			
		} // initializeImageRegistry

	} // Implementation

} // DiseasemodelsEditorPlugin

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation.presentation;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.eclipse.stem.core.common.provider.CoreEditPlugin;

import org.eclipse.stem.definitions.edges.provider.DefinitionsEditPlugin;

import org.eclipse.stem.diseasemodels.standard.provider.DiseasemodelsEditPlugin;

import org.eclipse.stem.populationmodels.standard.provider.StandardEditPlugin;
import org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditorAdapterFactory;
import org.eclipse.stem.ui.wizards.StandardPropertyStringProviderAdapterFactory;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Multipopulation editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class MultipopulationEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MultipopulationEditorPlugin INSTANCE = new MultipopulationEditorPlugin();
	
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
	public MultipopulationEditorPlugin() {
		super
			(new ResourceLocator [] {
				DiseasemodelsEditPlugin.INSTANCE,
				CoreEditPlugin.INSTANCE,
				EcoreEditPlugin.INSTANCE,
				DefinitionsEditPlugin.INSTANCE,
				StandardEditPlugin.INSTANCE,
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
			new MultiPopulationDiseaseModelPropertyEditorAdapterFactory();
		}
	}

}

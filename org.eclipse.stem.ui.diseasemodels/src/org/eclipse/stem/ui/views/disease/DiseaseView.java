// DiseaseModelView.java
package org.eclipse.stem.ui.views.disease;

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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.stem.diseasemodels.Constants;
import org.eclipse.stem.ui.views.IdentifiableDelegate;
import org.eclipse.stem.ui.views.IdentifiablePluginView;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This class implements a view of the plugged in Diseases.
 */
public class DiseaseView extends IdentifiablePluginView {

	/**
	 * The identifier of the Sequencers View
	 */
	public static final String ID_DISEASE_MODEL_VIEW = "org.eclipse.stem.ui.views.diseases"; //$NON-NLS-1$

	/**
	 * Default Constructor
	 */
	public DiseaseView() {
		super();
	} // DiseaseView

	/**
	 * @see org.eclipse.stem.ui.views.ExecutablePluginView#getInput()
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return DiseaseViewModel.getModel();
	} // getInput

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new DiseaseViewTreeContentProvider();
	} // getIdentifiablePluginViewLabelContentProvider

	/**
	 * This class is the model of the plugged in <code>DiseaseModel</code>
	 */
	public static class DiseaseViewModel extends IdentifiableViewModel {

		private static DiseaseViewModel model = null;

		/**
		 * @param extensionPointID
		 */
		private DiseaseViewModel(String extensionPointID) {
			super(extensionPointID);
		} // DiseaseModelViewModel

		/**
		 * @return the singleton instance of the model
		 */
		public static DiseaseViewModel getModel() {
			// Do we need to make the model?
			if (model == null) {
				// Yes
				model = new DiseaseViewModel(
						Constants.ID_DISEASE_EXTENSION_POINT);
			}
			return model;
		} // getModel

	} // DiseaseViewModel

	/**
	 * This class is the content provider of the disease view.
	 */
	private static class DiseaseViewTreeContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent diseases in the disease view
		static ImageDescriptor diseaseIcon = null;

		// If true then we've never tried to get the icon
		static boolean diseaseIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		public Image getImage(Object element) {
			return (element instanceof IdentifiableDelegate) ? getDiseaseIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent diseases, or null if it
		 *         can't be loaded.
		 */
		private Image getDiseaseIcon() {
			// Should we try to load the icon?
			if (diseaseIconFirstTime && diseaseIcon == null) {
				// Yes
				diseaseIconFirstTime = false;
				diseaseIcon = 
				AbstractUIPlugin.imageDescriptorFromPlugin(
					"org.eclipse.stem.ui.diseasemodels"	, "icons/full/custom16/" + "disease.gif");
			} // if we should load the icon
			return diseaseIcon.createImage();
		} // getdiseaseIcon

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#dispose()
		 */
		@Override
		public void dispose() {
			super.dispose();
			// TODO dispose of the image
		}

	} // DiseaseModelViewTreeContentProvider
} // DiseaseView

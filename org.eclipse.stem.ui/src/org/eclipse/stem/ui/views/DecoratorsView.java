// DecoratorsView.java
package org.eclipse.stem.ui.views;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.swt.graphics.Image;

/**
 * This class represents the eclipse view of the {@link Decorator}s that have
 * been imported into eclipse as plug-ins.
 *
 * @see SequencersView
 */
public class DecoratorsView extends IdentifiablePluginView {

	/**
	 * The identifier of the Decorators View
	 */
	public static final String ID_DECORATORS_VIEW = "org.eclipse.stem.ui.views.decorators"; //$NON-NLS-1$

	/**
	 * Default Constructor
	 */
	public DecoratorsView() {
		super();
	} // DecoratorsView

	/**
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return DecoratorModel.getModel();
	} // getInput

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new DecoratorViewTreeContentProvider();
	} // getIdentifiablePluginViewLabelContentProvider

	/**
	 * This class represents the model of the {@link Decorator}s that extend a
	 * org.eclipse.stem.core.decorators extension point.
	 */
	protected static class DecoratorModel extends IdentifiableViewModel {

		// The singleton instance
		private static DecoratorModel decModel;

		/**
		 * Constructor
		 */
		private DecoratorModel(final String extensionPointID) {
			super(extensionPointID);
		} // DecoratorModel

		/**
		 * @return the singleton instance of the model
		 */
		public static DecoratorModel getModel() {
			// Do we need to make the model?
			if (decModel == null) {
				// Yes
				decModel = new DecoratorModel(
						Constants.ID_DECORATOR_EXTENSION_POINT);
			}
			return decModel;
		} // getModel
	} // DecoratorModel

	/**
	 * This class is the content provider of the decorators view.
	 */
	protected static class DecoratorViewTreeContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent decorators in the decorators view
		static ImageDescriptor diseaseIcon = null;

		// If true then we've never tried to get the icon
		static boolean diseaseIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(final Object element) {
			return (element instanceof IdentifiableDelegate) ? getDiseaseIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent decorators, or null if it
		 *         can't be loaded.
		 */
		private Image getDiseaseIcon() {
			return null;
			// // Should we try to load the icon?
			// if (diseaseIconFirstTime && diseaseIcon == null) {
			// // Yes
			// diseaseIconFirstTime = false;
			// diseaseIcon = AbstractUIPlugin.imageDescriptorFromPlugin(
			// "org.eclipse.stem.ui.diseasemodels",
			// "icons/full/custom16/" + "disease.gif");
			// } // if we should load the icon
			// return diseaseIcon.createImage();
		} // getdiseaseIcon
	} // DecoratorViewTreeContentProvider
} // DecoratorsView

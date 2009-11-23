// ExperimentsView.java
package org.eclipse.stem.ui.views;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.Constants;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.ISharedImages;
import org.eclipse.swt.graphics.Image;

/**
 * This class represents the eclipse view of the
 * {@link org.eclipse.stem.core.experiment.Experiment}s that have been imported
 * into eclipse as plug-ins.
 */
public class ExperimentsView extends IdentifiablePluginView {

	/**
	 * The identifier of the Experiments View {@value}
	 */
	public static final String ID_EXPERIMENTS_VIEW = Constants.ID_ROOT
			+ ".ui.views.experiments"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new ExperimentPluginViewLabelContentProvider();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getInput()
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return ExperimentsViewModel.getModel();
	}

	/**
	 * This class represents a singleton instance of a model of the STEM
	 * {@link Experiment}s that are plugged into the system.
	 */
	protected static class ExperimentsViewModel extends IdentifiableViewModel {
		// The singleton instance
		private static ExperimentsViewModel evModel;

		private ExperimentsViewModel() {
			super(Constants.ID_EXPERIMENT_EXTENSION_POINT);
		}

		/**
		 * @return the singleton instance of the ModelViewModel
		 */
		public static ExperimentsViewModel getModel() {
			if (evModel == null) {
				evModel = new ExperimentsViewModel();
			}
			return evModel;
		} // getModel
	} // ExperimentsViewModel

	protected static class ExperimentPluginViewLabelContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent experiments in the Experiments view
		static Image experimentIcon = null;

		// If true then we've never tried to get the icon
		static boolean experimentIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(Object element) {
			return (element instanceof IdentifiableDelegate) ? getExperimentIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent experiments, or null if it
		 *         can't be loaded.
		 */
		private Image getExperimentIcon() {
			// Should we try to load the icon?
			if (experimentIconFirstTime && experimentIcon == null) {
				// Yes
				experimentIconFirstTime = false;
				experimentIcon = Activator.getDefault().getImageRegistry().get(
						ISharedImages.EXPERIMENT_ICON);
			} // if we should load the icon
			return experimentIcon;
		} // getExperimentIcon

	} // ExperimentPluginViewLabelContentProvider
} // ExperimentsView
// PredicatesView.java
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
 * {@link org.eclipse.stem.core.predicate.Predicate}s that have been imported
 * into eclipse as plug-ins.
 */
public class PredicatesView extends IdentifiablePluginView {

	/**
	 * The identifier of the Predicates View {@value}
	 */
	public static final String ID_PREDICATES_VIEW = "org.eclipse.stem.ui.views.predicates"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public PredicatesView() {
		super();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new PredicatePluginViewLabelContentProvider();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getInput()
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return PredicateViewModel.getModel();
	} // getInput

	/**
	 * This class represents a singleton instance of a model of the STEM
	 * {@link Predicate}s that are plugged into the system.
	 */
	protected static class PredicateViewModel extends IdentifiableViewModel {
		// The singleton instance
		private static PredicateViewModel pvModel;

		private PredicateViewModel() {
			super(Constants.ID_PREDICATE_EXTENSION_POINT);
		}

		/**
		 * @return the singleton instance of the ModelViewModel
		 */
		public static PredicateViewModel getModel() {
			if (pvModel == null) {
				pvModel = new PredicateViewModel();
			}
			return pvModel;
		} // getModel
	} // PredicateViewModel

	protected static class PredicatePluginViewLabelContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent predicates in the predicate view
		static Image predicateIcon = null;

		// If true then we've never tried to get the icon
		static boolean predicateIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(Object element) {
			return (element instanceof IdentifiableDelegate) ? getPredicateIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent predicates, or null if it
		 *         can't be loaded.
		 */
		private Image getPredicateIcon() {
			// Should we try to load the icon?
			if (predicateIconFirstTime && predicateIcon == null) {
				// Yes
				predicateIconFirstTime = false;
				predicateIcon = Activator.getDefault().getImageRegistry().get(
						ISharedImages.PREDICATE_ICON);
			} // if we should load the icon
			return predicateIcon;
		} // getPredicateIcon

	} // PredicatePluginViewLabelContentProvider
} // PredicatesView
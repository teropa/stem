// TriggersView.java
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
 * {@link org.eclipse.stem.core.trigger.Trigger}s that have been imported into
 * eclipse as plug-ins.
 */
public class TriggersView extends IdentifiablePluginView {

	/**
	 * The identifier of the Triggers View {@value}
	 */
	public static final String ID_TRIGGERS_VIEW = "org.eclipse.stem.ui.views.triggers"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public TriggersView() {
		super();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new TriggerPluginViewLabelContentProvider();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getInput()
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return TriggerViewModel.getModel();
	} // getInput

	/**
	 * This class represents a singleton instance of a model of the STEM
	 * {@link Trigger}s that are plugged into the system.
	 */
	protected static class TriggerViewModel extends IdentifiableViewModel {
		// The singleton instance
		private static TriggerViewModel tvModel;

		private TriggerViewModel() {
			super(Constants.ID_TRIGGER_EXTENSION_POINT);
		}

		/**
		 * @return the singleton instance of the ModelViewModel
		 */
		public static TriggerViewModel getModel() {
			if (tvModel == null) {
				tvModel = new TriggerViewModel();
			}
			return tvModel;
		} // getModel
	} // TriggerViewModel

	protected static class TriggerPluginViewLabelContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent triggers in the trigger view
		static Image triggerIcon = null;

		// If true then we've never tried to get the icon
		static boolean triggerIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(Object element) {
			return (element instanceof IdentifiableDelegate) ? getTriggerIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent triggers, or null if it
		 *         can't be loaded.
		 */
		private Image getTriggerIcon() {
			// Should we try to load the icon?
			if (triggerIconFirstTime && triggerIcon == null) {
				// Yes
				triggerIconFirstTime = false;
				triggerIcon = Activator.getDefault().getImageRegistry().get(
						ISharedImages.TRIGGER_ICON);
			} // if we should load the icon
			return triggerIcon;
		} // getTriggerIcon

	} // TriggerPluginViewLabelContentProvider

} // TriggersView
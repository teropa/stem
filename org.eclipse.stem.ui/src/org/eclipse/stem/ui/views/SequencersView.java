// SequencersView.java
package org.eclipse.stem.ui.views;

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

import org.eclipse.stem.core.Constants;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.ISharedImages;
import org.eclipse.swt.graphics.Image;

/**
 * This class represents the eclipse view of the
 * {@link org.eclipse.stem.core.sequencer.Sequencer}s that have been
 * imported into eclipse as plug-ins.
 *
 */
public class SequencersView extends IdentifiablePluginView {
	/**
	 * The identifier of the Sequencers View
	 */
	public static final String ID_SEQUENCERS_VIEW = "org.eclipse.stem.ui.views.sequencers"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.stem.ui.views.ExecutablePluginView#getInput()
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return SequencerModel.getModel();
	} // ExecutableViewModel

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new SequencerViewTreeContentProvider();
	} // getIdentifiablePluginViewLabelContentProvider

	/**
	 * This class represents the model of the Sequencers that extend a
	 * org.eclipse.stem.core.sequencers extension point.
	 */
	private static class SequencerModel extends IdentifiableViewModel {

		// The singleton instance
		private static SequencerModel seqModel;

		/**
		 * Constructor
		 */
		public SequencerModel() {
			super(Constants.ID_SEQUENCER_EXTENSION_POINT);
		} // SequencerModel

		/**
		 * @return the singleton instance of the model
		 */
		public static SequencerModel getModel() {
			// Do we need to make the model?
			if (seqModel == null) {
				// Yes
				seqModel = new SequencerModel();
			}
			return seqModel;
		} // getModel
	} // SequencerModel

	/**
	 * This class is the content provider of the sequencers view.
	 */
	protected static class SequencerViewTreeContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent sequencers in the sequencers view
		static Image sequencerIcon = null;

		// If true then we've never tried to get the icon
		static boolean sequencerIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(final Object element) {
			return (element instanceof IdentifiableDelegate) ? getDiseaseIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent sequencers, or null if it
		 *         can't be loaded.
		 */
		private Image getDiseaseIcon() {
			// Should we try to load the icon?
			if (sequencerIconFirstTime && sequencerIcon == null) {
				// Yes
				sequencerIconFirstTime = false;

				sequencerIcon = Activator.getDefault().getImageRegistry().get(
						ISharedImages.SEQUENCER_ICON);
			} // if we should load the icon
			return sequencerIcon;
		} // getdiseaseIcon
	} // SequencerViewTreeContentProvider
} // SequencersView

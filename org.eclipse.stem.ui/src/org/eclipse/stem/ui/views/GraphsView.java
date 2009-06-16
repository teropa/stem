// GraphsView.java
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

import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.ISharedImages;
import org.eclipse.swt.graphics.Image;

/**
 * This class represents the eclipse view of the {@link Graph}s that have been
 * imported into eclipse as plug-ins.
 */
public class GraphsView extends IdentifiablePluginView {

	/**
	 * The identifier of the Graph View
	 */
	public static final String ID_GRAPHS_VIEW = "org.eclipse.stem.ui.views.graphs"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public GraphsView() {
		super();
	} // GraphsView

	/**
	 * @return the input model specific to this view
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return GraphViewModel.getModel();
	} // getInput

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new GraphPluginViewLabelContentProvider();
	} // getIdentifiablePluginViewLabelContentProvider

	/**
	 * This class represents a singleton instance of a model of the
	 * {@link Graph}s that are plugged-in to the system.
	 */
	protected static class GraphViewModel extends IdentifiableViewModel {
		// The singleton instance
		private static GraphViewModel gvModel;

		/**
		 * Constructor
		 */
		private GraphViewModel() {
			super(Constants.ID_GRAPH_EXTENSION_POINT);
		} // GraphViewModel

		/**
		 * @return the single instance of the GraphViewModel
		 */
		public static GraphViewModel getModel() {
			// Do we need to make the model?
			if (gvModel == null) {
				// Yes
				gvModel = new GraphViewModel();
			}
			return gvModel;
		} // getModel

	} // GraphViewModel

	protected static class GraphPluginViewLabelContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent graphs in the graph view
		static Image graphIcon = null;

		// If true then we've never tried to get the icon
		static boolean graphIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(final Object element) {
			return (element instanceof IdentifiableDelegate) ? getGraphIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent graphs, or null if it can't
		 *         be loaded.
		 */
		private Image getGraphIcon() {
			// Should we try to load the icon?
			if (graphIconFirstTime && graphIcon == null) {
				// Yes
				graphIconFirstTime = false;
				graphIcon = Activator.getDefault().getImageRegistry().get(
						ISharedImages.GRAPH_ICON);
			} // if we should load the icon
			return graphIcon;
		} // getGraphIcon

	} // GraphPluginViewLabelContentProvider
} // GraphsView

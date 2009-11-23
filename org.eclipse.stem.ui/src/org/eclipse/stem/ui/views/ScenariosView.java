// ScenariosView.java
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
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.ISharedImages;
import org.eclipse.swt.graphics.Image;

/**
 * This class represents the eclipse view of the
 * {@link org.eclipse.stem.core.scenario.Scenario}s that have been imported into
 * eclipse as plug-ins.
 */
public class ScenariosView extends IdentifiablePluginView {

	/**
	 * The identifier of the Scenarios View {@value}
	 */
	public static final String ID_SCENARIOS_VIEW = "org.eclipse.stem.ui.views.scenarios"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public ScenariosView() {
		super();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getIdentifiablePluginViewLabelContentProvider()
	 */
	@Override
	protected IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider() {
		return new ScenarioPluginViewLabelContentProvider();
	}

	/**
	 * @see org.eclipse.stem.ui.views.IdentifiablePluginView#getInput()
	 */
	@Override
	protected IdentifiableViewModel getInput() {
		return ScenarioViewModel.getModel();
	} // getInput

	/**
	 * This class represents a singleton instance of a model of the STEM
	 * {@link Scenario}s that are plugged into the system.
	 */
	protected static class ScenarioViewModel extends IdentifiableViewModel {
		// The singleton instance
		private static ScenarioViewModel svModel;

		private ScenarioViewModel() {
			super(Constants.ID_SCENARIO_EXTENSION_POINT);
		}

		/**
		 * @return the singleton instance of the ModelViewModel
		 */
		public static ScenarioViewModel getModel() {
			if (svModel == null) {
				svModel = new ScenarioViewModel();
			}
			return svModel;
		} // getModel
	} // ScenarioViewModel

	protected static class ScenarioPluginViewLabelContentProvider extends
			IdentifiablePluginViewLabelContentProvider {

		// This is the image used to represent scenarios in the scenario view
		static Image scenarioIcon = null;

		// If true then we've never tried to get the icon
		static boolean scenarioIconFirstTime = true;

		/**
		 * @see org.eclipse.stem.ui.views.IdentifiablePluginView.IdentifiablePluginViewLabelContentProvider#getImage(java.lang.Object)
		 */
		@Override
		public Image getImage(Object element) {
			return (element instanceof IdentifiableDelegate) ? getScenarioIcon()
					: super.getImage(element);
		} // getImage

		/**
		 * @return the icon to be used to represent scenarios, or null if it
		 *         can't be loaded.
		 */
		private Image getScenarioIcon() {
			// Should we try to load the icon?
			if (scenarioIconFirstTime && scenarioIcon == null) {
				// Yes
				scenarioIconFirstTime = false;
				scenarioIcon = Activator.getDefault().getImageRegistry().get(
						ISharedImages.SCENARIO_ICON);
			} // if we should load the icon
			return scenarioIcon;
		} // getScenarioIcon

	} // ScenarioPluginViewLabelContentProvider
}// ScenariosView

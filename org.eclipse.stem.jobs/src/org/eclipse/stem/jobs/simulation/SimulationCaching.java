package org.eclipse.stem.jobs.simulation;

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

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.jobs.Activator;
import org.eclipse.stem.jobs.preferences.PreferenceConstants;

/**
 * This class implements caching of {@link Scenario}s.
 * 
 * TODO Why isn't this called ScenarioCaching?
 */
public class SimulationCaching {

	/**
	 * Singleton instance of caching manager
	 */
	public final static SimulationCaching INSTANCE = new SimulationCaching();

	/**
	 * Caching uses a {@link WeakHashMap} object to store Scenarios. In the
	 * future this can be replaced with a smarter caching mechanism.
	 */
	private final Map<URI, Scenario> cachedScenarios = new WeakHashMap<URI, Scenario>();

	private boolean toUseCaching = false;

	/**
	 * Private constructor as this is a Singleton object.
	 */
	private SimulationCaching() {
		setPreferences();

		Activator.getDefault().getPluginPreferences()
				.addPropertyChangeListener(new IPropertyChangeListener() {
					public void propertyChange(
							@SuppressWarnings("unused") final PropertyChangeEvent event) {
						setPreferences();
					} // propertyChange
				} // IPropertyChangeListener
				);
	}

	/**
	 * @param scenarioURI
	 * @return <code>true</code> if the {@link Scenario} is in the cache
	 */
	public boolean isScenarioInCache(URI scenarioURI) {
		return cachedScenarios.containsKey(scenarioURI);
	}

	/**
	 * @param scenarioURI
	 * @return the {@link Scenario} identified by the {@link URI} from the
	 *         cache, or <code>null</code> if not found.
	 */
	public Scenario getCachedScenario(URI scenarioURI) {
		return cachedScenarios.get(scenarioURI);
	}

	/**
	 * @param scenario
	 */
	public void addScenarioToCache(Scenario scenario) {
		if (scenario.getURI() == null)
			return;
		cachedScenarios.put(scenario.getURI(), scenario);
	}

	/**
	 * @return <code>true</code> if caching is enabled.
	 */
	public boolean toUseCaching() {
		return toUseCaching;
	}

	protected void setPreferences() {
		final Preferences preferences = Activator.getDefault()
				.getPluginPreferences();
		toUseCaching = preferences
				.getBoolean(PreferenceConstants.USE_SCENARIOS_CACHING_BOOLEAN);
	} // setPerferences
}

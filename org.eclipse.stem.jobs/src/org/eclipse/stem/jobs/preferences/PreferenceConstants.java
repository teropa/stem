package org.eclipse.stem.jobs.preferences;

import org.eclipse.stem.core.scenario.Scenario;

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

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	/**
	 * The preference for pausing after each simulation cycle
	 */
	public static final String SIMULATION_SLEEP_BOOLEAN = "cyclePause"; //$NON-NLS-1$

	/**
	 * This is the preference that specifies the number of seconds to pause the
	 * simulation at the end of each cycle.
	 */
	public static final String SIMULATION_SLEEP_MILLISECONDS_INTEGER = "cyclePauseMilliSeconds"; //$NON-NLS-1$

	/**
	 * This is the preference that specifies that when the canonical graph is
	 * created at the beginning of a <code>Simulation</code> that each
	 * unresolved <code>Identifiable</code> should be reported in the error
	 * log.
	 */
	public static final String REPORT_EACH_UNRESOLVED_IDENTIFIABLE_BOOLEAN = "reportEachUnresolvedIdentifiable"; //$NON-NLS-1$

	/**
	 * This is the preference that specifies that when the canonical graph is
	 * created at the beginning of a <code>Simulation</code> that if there are
	 * unresolved <code>Identifiable</code>s then the number should be
	 * reported in the error log.
	 */
	public static final String REPORT_NUMBER_OF_UNRESOLVED_IDENTIFIABLES_BOOLEAN = "reportNumberOfUnresolvedIdentifiable"; //$NON-NLS-1$
	
	/**
	 * This is the preference enables or disables the use of caching in STEM.
	 * Caching system can cache initialized {@link Scenario}s to save the time
	 * it takes to initialize the {@link Scenario} when running the same scenario
	 * more than once. 
	 */
	public static final String USE_SCENARIOS_CACHING_BOOLEAN = "useScenariosCaching"; //$NON-NLS-1$
} // PreferenceConstants

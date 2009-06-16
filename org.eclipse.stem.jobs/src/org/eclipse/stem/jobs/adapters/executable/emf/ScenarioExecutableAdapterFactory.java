// ScenarioExecutableAdapterFactory.java
package org.eclipse.stem.jobs.adapters.executable.emf;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.util.ScenarioAdapterFactory;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.simulation.SimulationManager;

/**
 * This class is an {@link ExecutableAdapterFactory} that creates adapters that
 * adapt {@link Scenario}s to {@link IExecutable}s.
 */
public class ScenarioExecutableAdapterFactory extends ScenarioAdapterFactory
		implements ExecutableAdapterFactory {

	/**
	 * Default Constructor
	 */
	public ScenarioExecutableAdapterFactory() {
		super();
		ExecutableAdapterFactory.INSTANCE.addAdapterFactory(this);
	}

	/**
	 * @see org.eclipse.stem.core.scenario.util.ScenarioAdapterFactory#createScenarioAdapter()
	 */
	@Override
	public Adapter createScenarioAdapter() {
		return new ScenarioExecutableAdapter();
	} // createScenarioAdapter

	/**
	 * @see org.eclipse.stem.core.scenario.util.ScenarioAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == IExecutable.class || super.isFactoryForType(type);
	}

	/**
	 * This class adapts a {@link Scenario} to an {@link IExecutable}.
	 */
	protected static class ScenarioExecutableAdapter extends ExecutableAdapter {

		/**
		 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter#run()
		 */
		@Override
		public void run() {
			SimulationManager.getManager().createAndRunSimulation(
					(Scenario) getTarget());
		}

		/**
		 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter#step()
		 */
		@Override
		public void step() {
			SimulationManager.getManager().createAndStepSimulation(
					(Scenario) getTarget());
		}
	} // ScenarioExecutableAdapter

} // ScenarioExecutableAdapterFactory

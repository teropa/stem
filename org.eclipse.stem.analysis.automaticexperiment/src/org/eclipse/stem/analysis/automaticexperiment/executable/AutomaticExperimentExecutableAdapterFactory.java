package org.eclipse.stem.analysis.automaticexperiment.executable;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.stem.analysis.automaticexperiment.AutomaticExperimentManager;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithm;
import org.eclipse.stem.analysis.automaticexperiment.ErrorAnalysisAlgorithmFactory;
import org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter;
import org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapterFactory;
import org.eclipse.stem.jobs.execution.IExecutable;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.util.AutomaticexperimentAdapterFactory;

/**
 * This class is an {@link ExecutableAdapterFactory} that creates adapters that
 * adapt {@link AutomaticExperiment}s to {@link IExecutable}s.
 */
public class AutomaticExperimentExecutableAdapterFactory 
	extends	AutomaticexperimentAdapterFactory 
	implements ExecutableAdapterFactory 
{

	/**
	 * Default Constructor
	 */
	public AutomaticExperimentExecutableAdapterFactory() {
		super();
		ExecutableAdapterFactory.INSTANCE.addAdapterFactory(this);
	}
	
	/**
	 * @see automaticexperiment.util.AutomaticexperimentAdapterFactory#createAutomaticExperimentAdapter()
	 */
	@Override
	public Adapter createAutomaticExperimentAdapter() {
		return new AutomaticExperimentExecutableAdapter();
	}

	/**
	 * @see automaticexperiment.util.AutomaticexperimentAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == IExecutable.class || super.isFactoryForType(type);
	}
	
	/**
	 * This class adapts an {@link AutomaticExperiment} to an {@link IExecutable}.
	 */
	protected static class AutomaticExperimentExecutableAdapter extends
			ExecutableAdapter implements Adapter {

		/**
		 * @see org.eclipse.stem.jobs.adapters.executable.emf.ExecutableAdapter#run()
		 */
		@Override
		public void run() {
			AutomaticExperimentManager manager = AutomaticExperimentManager.getInstance();
			AutomaticExperiment exp = (AutomaticExperiment)getTarget();
			ErrorAnalysisAlgorithm algorithm = manager.createAlgorithm(exp.getErrorAnalysisAlgorithm());
			manager.executeAlgorithm(algorithm, exp);
		}
	}
}

package org.eclipse.stem.analysis.automaticexperiment;

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


import java.util.List;

import org.eclipse.stem.analysis.ErrorFunction;
import org.eclipse.stem.core.scenario.Scenario;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.ModifiableParameter;

public interface ErrorAnalysisAlgorithm {
	public void setErrorFunction(final ErrorFunction errorFunction);
	public void setParameters(final List<ModifiableParameter> parameters);
	public void setTolerance(final double tolerance);
	public void setBaseScenario(final Scenario baseScenario);
	public void setReferenceDataDirectory(final String referenceDataDir);
	public void setMaximumNumberOfIterations(final long maxNumOfIterations);
	public double[] getResultParameters();
	public double getResultValue();
	public void execute();
	public void init(AutomaticExperiment automaticExperiment, ErrorAnalysisAlgorithm alg);
	public void reinitStartParams(AutomaticExperiment exp, double [] vals);
	public void addListener(ErrorAnalysisAlgorithmListener listener);
	public void clearListeners();
	
}

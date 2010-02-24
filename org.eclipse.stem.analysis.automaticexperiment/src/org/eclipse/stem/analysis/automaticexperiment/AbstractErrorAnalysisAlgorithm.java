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


import java.util.ArrayList;
import java.util.List;

import org.eclipse.stem.analysis.AnalysisFactory;
import org.eclipse.stem.analysis.ErrorFunction;
import org.eclipse.stem.core.scenario.Scenario;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.ModifiableParameter;

public abstract class AbstractErrorAnalysisAlgorithm implements
		ErrorAnalysisAlgorithm {
	
	protected Scenario baseScenario = null;
	protected SimplexAlgorithm simplexAlgorithm = new NelderMeadAlgorithm();
	protected SimplexFunction simplexFnToMinimize = null;
	protected ErrorFunction errorFunction = null;
	protected double[] initialParamsValues = null;
	protected double[] paramsInitialSteps = null;
	protected double tolerance = -1;
	protected String referenceDataDirectory = null;
	protected long maxNumOfIterations = -1;
	protected List<ModifiableParameter> parameters = null;
	boolean repeat = false;
	private ArrayList<ErrorAnalysisAlgorithmListener> listeners = new ArrayList<ErrorAnalysisAlgorithmListener>();
	
	abstract public void execute();

	public void setBaseScenario(Scenario baseScenario) {
		this.baseScenario = baseScenario;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	public void setErrorFunction(ErrorFunction errorFunction) {
		this.errorFunction = errorFunction;
	}

	public void setReferenceDataDirectory(String referenceDataDir) {
		this.referenceDataDirectory = referenceDataDir;
	}

	public void init(AutomaticExperiment automaticExperiment) {
		setBaseScenario(automaticExperiment.getBaseScenario());
		setParameters(automaticExperiment.getParameters());
		
		double tolerance = automaticExperiment.getTolerance();
		setTolerance(tolerance);		
		long maxIterations = automaticExperiment.getMaximumNumberOfIterations();
		setMaximumNumberOfIterations(maxIterations);
		
		boolean repeatUntilNoImprovement = automaticExperiment.isReInit();
		setReInit(repeatUntilNoImprovement);
		
		ErrorFunction errorFunction = null;
		String errorFunctionName = automaticExperiment.getErrorFunction();
		if (errorFunctionName.equals("Threshold error function")) { //$NON-NLS-1$
			errorFunction = AnalysisFactory.eINSTANCE.createThresholdErrorFunction();
		}
		if (errorFunctionName.equals("Simple error function")) { //$NON-NLS-1$
			errorFunction = AnalysisFactory.eINSTANCE.createSimpleErrorFunction();
		}		
		setErrorFunction(errorFunction);
		
		String refDir = automaticExperiment.getReferanceDataDir();
		setReferenceDataDirectory(refDir);
	}

	public double[] getResultParameters() {
		return simplexAlgorithm.getMinimumParametersValues();
	}

	public double getResultValue() {
		return simplexAlgorithm.getMinimumFunctionValue();
	}

	public void setMaximumNumberOfIterations(long maxNumOfIterations) {
		this.maxNumOfIterations = maxNumOfIterations;
	}

	public void setReInit(boolean repeat) {
		this.repeat = repeat;
	}
	public void setParameters(List<ModifiableParameter> parameters) {
		this.parameters = parameters;
		paramsInitialSteps = new double[parameters.size()];
		initialParamsValues = new double[parameters.size()];
		int i=0;
		for (final ModifiableParameter param:parameters) {
			paramsInitialSteps[i] = param.getStep();
			initialParamsValues[i] = param.getInitialValue();
			i++;
		}
	}
	
	public void addListener(ErrorAnalysisAlgorithmListener l) {this.listeners.add(l);}
	
	protected void fireEvent(ErrorAnalysisAlgorithmEvent evt) {
		for(ErrorAnalysisAlgorithmListener l:listeners) l.eventReceived(evt);
	}
}

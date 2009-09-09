package org.eclipse.stem.analysis.automaticexperiment;


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
		
		ErrorFunction errorFunction = null;
		String errorFunctionName = automaticExperiment.getErrorFunction();
		if (errorFunctionName.equals("Threshold error function")) {
			errorFunction = AnalysisFactory.eINSTANCE.createThresholdErrorFunction();
		}
		if (errorFunctionName.equals("Simple error function")) {
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
}

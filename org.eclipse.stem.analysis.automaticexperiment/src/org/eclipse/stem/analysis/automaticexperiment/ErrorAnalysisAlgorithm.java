package org.eclipse.stem.analysis.automaticexperiment;


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
	public void init(AutomaticExperiment automaticExperiment);
}

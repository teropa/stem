package org.eclipse.stem.analysis.automaticexperiment;

import automaticexperiment.AutomaticExperiment;

public class AutomaticExperimentManagerEvent {

	public AutomaticExperiment experiment;
	public ErrorAnalysisAlgorithm algorithm;
	public MANAGER_STATUS status;
	
	public AutomaticExperimentManagerEvent(AutomaticExperiment automaticExperiment, ErrorAnalysisAlgorithm algorithm, MANAGER_STATUS stat) {
		this.experiment = automaticExperiment;
		this.algorithm = algorithm;
		this.status = stat;
	}
}

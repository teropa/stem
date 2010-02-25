package org.eclipse.stem.analysis.automaticexperiment;

import org.eclipse.stem.analysis.ErrorResult;

public class ErrorAnalysisAlgorithmEvent {
	public ErrorResult result;
	public ALGORITHM_STATUS status;
	public String [] parameterNames;
	public double [] parameterValues;
	
	public ErrorAnalysisAlgorithmEvent(ErrorResult res, ALGORITHM_STATUS status) {
		this.result = res;
		this.status = status;
	}
}

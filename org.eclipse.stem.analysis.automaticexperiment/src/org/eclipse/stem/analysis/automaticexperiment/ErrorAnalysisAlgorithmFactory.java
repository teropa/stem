package org.eclipse.stem.analysis.automaticexperiment;

public class ErrorAnalysisAlgorithmFactory {
	public final static ErrorAnalysisAlgorithmFactory INSTANCE = new ErrorAnalysisAlgorithmFactory();
	
	public ErrorAnalysisAlgorithm createErrorAnalysisAlgorithm(final String algorithmName)
	{
		ErrorAnalysisAlgorithm algorithm = null;
		if (algorithmName.equals("Nedler-Mead Algorithm")) { //$NON-NLS-1$ 
			algorithm = new SimplexAlgorithmExecuter();
		}
		return algorithm;
	}

}

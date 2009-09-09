package org.eclipse.stem.analysis.automaticexperiment;

public interface SimplexAlgorithm {
	public final static double NO_LIMIT = -1;
	
	public void execute(final SimplexFunction fn, final double[] startPoints, final double[] step, final double terminatingVariance);
	public double getMinimumFunctionValue();
	public double[] getMinimumParametersValues();
	public void setParameterLimits(final int parameterIndex, final double lowerBound, final double upperBound);
}

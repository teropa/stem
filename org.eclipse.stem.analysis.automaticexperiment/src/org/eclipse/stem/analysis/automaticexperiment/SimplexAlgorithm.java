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

public interface SimplexAlgorithm {
	public final static double NO_LIMIT = -1;
	
	public void execute(final SimplexFunction fn, final double[] startPoints, final double[] step, final double terminatingVariance);
	public double getMinimumFunctionValue();
	public double[] getMinimumParametersValues();
	public void setParameterLimits(final int parameterIndex, final double lowerBound, final double upperBound);
}

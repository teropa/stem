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

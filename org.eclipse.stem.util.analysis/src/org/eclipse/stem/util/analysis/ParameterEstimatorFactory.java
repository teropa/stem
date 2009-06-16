package org.eclipse.stem.util.analysis;

import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;



/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * Factory that creates ParameterEsimator instances
 */
public class ParameterEstimatorFactory {

	/**
	 * Create new ParameterEstimator
	 * 
	 * @param method Method used to estimate parameters
	 * @param data Estimator data
	 * @return ParameterEstimator
	 */
	public static ParameterEstimator createEstimator(
			ParameterEstimatorMethod method, 
			ReferenceScenarioDataInstance data) {
		ParameterEstimator result = null;
		
		switch(method) {
			case SEIR:
				result = new SEIRparameterEstimator(data);
				break;
			case SIR:
				 result = new SIRparameterEstimator(data);
				 break;
			case SI:
				 result = new SIparameterEstimator(data);
				 break;	
			case NONLINEARSEIR:
				 result = new NonLinearSEIRParameterEstimator(data);
				 break;	
			default:
				Activator.logError("Unknown method: "+method, null);
		}
		return result;
	}
}

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

package org.eclipse.stem.analysis.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.stem.analysis.AnalysisPackage;
import org.eclipse.stem.analysis.ErrorFunction;
import org.eclipse.stem.analysis.ErrorResult;
import org.eclipse.stem.analysis.ReferenceScenarioDataMap;
import org.eclipse.stem.analysis.States;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ErrorFunctionImpl extends EObjectImpl implements ErrorFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.ERROR_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorResult calculateError(ReferenceScenarioDataMap reference, ReferenceScenarioDataMap data) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * From the dataMap extract a list of infectious
	 * @param dataMap
	 * @return list of infectious people
	 */
	public List<Double> getInfectious(ReferenceScenarioDataInstance dataMap) {
		final String INFECTIOUS = States.statesToFit[States.INFECTIOUS];
		
		 
		// MUST exist
		List<String> infectiousList = dataMap.getData(INFECTIOUS);
		assert(infectiousList!=null);
		
		List<Double> infectious = new ArrayList<Double>();
		for (int i = 0; i < infectiousList.size(); i ++) {
			
			double inf = (new Double(infectiousList.get(i))).doubleValue();
			infectious.add(new Double(inf));
		}
		return infectious;
	}
	
	/**
	 * From the dataMap extract a list of population values
	 * @param dataMap
	 * @return list of infectious people
	 */
	public List<Double> getPopulation(ReferenceScenarioDataInstance dataMap) {
		final String POPULATION = States.statesToFit[States.POPULATION];
		
		 
		// MUST exist
		List<String> popList = dataMap.getData(POPULATION);
		// We should standardize on P for population count
		if(popList == null) popList =  dataMap.getData("Population Count");
		assert(popList!=null);
		
		List<Double> populations = new ArrayList<Double>();
		for (int i = 0; i < popList.size(); i ++) {
			
			double inf = (new Double(popList.get(i))).doubleValue();
			populations.add(new Double(inf));
		}
		return populations;
	}
	
} //ErrorFunctionImpl

// Constants.java
package org.eclipse.stem.populationmodels;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This interface contains constants that are significant to the STEM disease
 * model definitions.
 */
public interface Constants {

	/**
	 * This is the extension point id for the "population model" extension point. A
	 * {@link DiseaseModel} defines the underlying computational model for how a
	 * population changes
	 * {@value}
	 */
	String ID_POPULATION_MODEL_EXTENSION_POINT = org.eclipse.stem.core.Constants.ID_ROOT
	+ ".populationmodels.populationmodel"; //$NON-NLS-1$ 

	
	/**
	 * This is the identifier of the element in a
	 * <code>ConfigurationElement</code> that specifies the name and
	 * implementing class for STEM "population models".
	 * 
	 * @see org.eclipse.stem.core.Constants#EXECUTABLE_NAME_ATTRIBUTE
	 */
	String POPULATION_MODEL_ELEMENT = "classdef"; //$NON-NLS-1$ 

	
	/**
	 * This is the extension point id for the "population initializer" extension point.
	 */
	String ID_POPULATION_INITIALIZER_EXTENSION_POINT = org.eclipse.stem.core.Constants.ID_ROOT
	+ ".populationmodels.populationinitializer"; //$NON-NLS-1$ 

	/**
	 * This is the identifier of the element in a
	 * <code>ConfigurationElement</code> that specifies the name and
	 * implementing class for STEM "population initializer".
	 * 
	 * @see org.eclipse.stem.core.Constants#EXECUTABLE_NAME_ATTRIBUTE
	 */
	String POPULATION_INITIALIZER_ELEMENT = "classdef"; //$NON-NLS-1$ 

} // Constants

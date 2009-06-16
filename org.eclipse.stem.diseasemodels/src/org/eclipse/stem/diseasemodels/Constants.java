// Constants.java
package org.eclipse.stem.diseasemodels;

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
	 * This is the extension point id for the "disease model" extension point. A
	 * {@link DiseaseModel} defines the underlying computational model for how a
	 * disease propagates.
	 * {@value}
	 */
	String ID_DISEASE_MODEL_EXTENSION_POINT = org.eclipse.stem.core.Constants.ID_ROOT
	+ ".diseasemodels.diseasemodel";

	
	/**
	 * This is the extension point id for the "disease" extension point.
	 * {@value}
	 */
	String ID_DISEASE_EXTENSION_POINT = org.eclipse.stem.core.Constants.ID_ROOT
			+ ".diseasemodels.disease";

	/**
	 * This is the identifier of the element in a
	 * <code>ConfigurationElement</code> that specifies the name and
	 * implementing class for STEM "disease models".
	 * 
	 * @see org.eclipse.stem.core.Constants#EXECUTABLE_NAME_ATTRIBUTE
	 */
	String DISEASE_MODEL_ELEMENT = "classdef";

} // Constants

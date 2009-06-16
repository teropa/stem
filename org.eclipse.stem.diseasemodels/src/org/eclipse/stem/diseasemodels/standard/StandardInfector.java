// StandardInfector.java
package org.eclipse.stem.diseasemodels.standard;

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
 * This interface defines a class in an EMF model for the initialization of an
 * infectious population in a Standard disease model.
 * 
 * The infector removes population members from the <em>Susceptible</em> state
 * to the <em>Infectious</em> state.
 * 
 * @model abstract="true"
 */
public interface StandardInfector extends Infector {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard infector type URI.
	 */
	String URI_TYPE_STANDARD_INFECTOR_SEGMENT = URI_TYPE_INFECTOR_SEGMENT
			+ "/standard";
} // StandardInfector

package org.eclipse.stem.analysis;

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

import org.eclipse.emf.ecore.EObject;


/**
* The class stores scenario reference data for a scenario disease as well as additional meta-data. 
* 
* @model
* @generated NOT
*/
@SuppressWarnings("all")
public interface ReferenceScenarioDataMap extends EObject {		
	
	/**
	 * Is this map (and the model that created it) sane?
	 * @return
	 */
	public boolean sane();
	
	/**
	 * Is this map consistent with another map?
	 * This is like "equal" but allows for small differences when comparing double(s)
	 * @param other
	 * @return
	 */
	public boolean consistentWith(ReferenceScenarioDataMap other);
}

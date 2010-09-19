// LabelValue.java
package org.eclipse.stem.core.graph;

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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.stem.core.common.SanityChecker;

/**
 * A <code>LabelValue</code> stores the attributes of a {@link Label}.
 * 
 * @see Label
 * @see DynamicLabel
 * @see DynamicNodeLabel
 * 
 * @model abstract="true"
 */
public interface LabelValue extends CDOObject, SanityChecker {

	/**
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void reset();

} // LabelValue

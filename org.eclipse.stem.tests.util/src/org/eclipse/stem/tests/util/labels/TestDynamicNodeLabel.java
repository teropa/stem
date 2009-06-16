// TestDynamicNodeLabel.java
package org.eclipse.stem.tests.util.labels;

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

import org.eclipse.stem.core.graph.DynamicNodeLabel;

/**
 * This interface is for testing.
 * 
 * @model
 */
public interface TestDynamicNodeLabel extends DynamicNodeLabel {

	/**
	 * Make the next value be one more than the current value.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void increment();

} // TestDynamicNodeLabel

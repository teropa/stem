// TimeProvider.java
package org.eclipse.stem.adapters.time;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.model.STEMTime;

/**
 * This interface is implemented by classes that provide instances of {@link
 * STEMTime}.
 */
public interface TimeProvider {
	/**
	 * @return the time value associated with the instance.
	 */
	STEMTime getTime();
} // TimeProvider
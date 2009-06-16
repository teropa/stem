// ResettableAdapter.java
package org.eclipse.stem.core.graph;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This interface is implemented by classes that are <code>Adapter</code>s
 * that can be reset. This is typically needed when the adapter maintains some
 * kind of state information that needs to be reset when the value of the
 * {@link DynamicLabel} is reset. The method {@link DynamicLabel#reset()} scans
 * through all of the adapters attached to {@link DynamicLabel} and resets all
 * that implement this interface.
 */
public interface ResettableAdapter {
	void reset();
} // ResettableAdapter

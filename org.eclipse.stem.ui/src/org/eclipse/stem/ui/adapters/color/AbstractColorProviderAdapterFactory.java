// AbstractColorProviderAdapterFactory.java
package org.eclipse.stem.ui.adapters.color;

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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.stem.core.graph.util.GraphAdapterFactory;

/**
 * This is an abstract class that ColorProviderAdapterFactory should extend.
 * It holds the common information for all color providers and has few abstract methods
 * that the concrete class should override.
 */
public abstract class AbstractColorProviderAdapterFactory extends GraphAdapterFactory
	implements IColorProviderAdapterFactory, ComposeableAdapterFactory {
	
	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	public abstract boolean isFactoryForType(Object type);	
}

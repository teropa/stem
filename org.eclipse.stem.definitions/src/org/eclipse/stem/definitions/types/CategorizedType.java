// CategorizedType.java
package org.eclipse.stem.definitions.types;

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

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

/**
 * A <code>CatagorizedType</code> is a marker interface for the types of
 * properties specified for {@link Decorator}s. The intent is that particular
 * properties can be "marked" as having a "category" by the type of the
 * property. This will facilitate things like grouping properties in the same
 * category together in a user interface.
 * 
 * @model interface="true"
 */
public interface CategorizedType extends CDOObject {
	// Nothing
} // CategorizedType

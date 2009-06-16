// StringNOPModifier.java
package org.eclipse.stem.core.modifier;

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

/**
 * A <code>NOPModifier</code> does nothing. It is useful for the GUI
 * components that edit {@link FeatureModifier}s to have one that is available
 * for the case when no {@link FeatureModifier} is specified by the user.
 * 
 * @model
 */
public interface StringNOPModifier extends NOPModifier {
	// Nothing
} // StringNOPModifier

// RangeModifier.java
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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A <code>RangeModifier</code> modifies the value of a numeric
 * {@link EStructuralFeature} over a specific range of values. A
 * <code>RangeModifier</code> specifies a starting value, an ending value and an
 * increment. The increment is successively applied to the starting value until
 * the result exceeds the end value. If the increment is negative, the end value
 * must be less than the starting value.
 * 
 * @model abstract="true"
 */
public interface RangeModifier extends FeatureModifier {
	// Nothing
} // RangeModifier

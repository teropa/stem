// LongSequenceModifier.java
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

import org.eclipse.emf.common.util.EList;

/**
 * A {@link LongSequenceModifier} modifies a feature by setting it to a
 * sequence of "long" values.
 * 
 * @model
 */
public interface LongSequenceModifier extends SequenceModifier {
	/**
	 * @model
	 */
	EList<Long> getSequence();
} // LongSequenceModifier
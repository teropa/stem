// And.java
package org.eclipse.stem.core.predicate;

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
 * <code>And</code> is a {@link NaryBooleanOperator} whose value is
 * <code>true</code> only if the values of all of its operands are
 * <code>true</code>.
 * 
 * @see Or
 * @see Not
 * @model
 */
public interface And extends NaryBooleanOperator {
	// Nothing
} // And
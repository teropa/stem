// Not.java
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
 * <code>Not</code> is a {@link UnaryBooleanOperator} whose value is
 * <code>true</code> if the value of its operand is <code>false</code>,
 * otherwise it is <code>false</code>.
 * 
 * @see And
 * @see Or
 * @model
 */
public interface Not extends UnaryBooleanOperator {
	// Nothing
} // Not
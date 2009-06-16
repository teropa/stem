// BooleanOperator.java
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
 * A <code>BooleanOperator</code> is a {@link BooleanExpression} whose value is
 * the result of evaluating a boolean operator.
 * 
 * @see UnaryBooleanOperator
 * @see NaryBooleanOperator
 * @model abstract="true"
 */
public interface BooleanOperator extends BooleanExpression {
	// Nothing
} // BooleanOperator
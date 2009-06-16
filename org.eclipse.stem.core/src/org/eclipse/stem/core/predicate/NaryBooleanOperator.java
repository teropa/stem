// NaryBooleanOperator.java
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

import org.eclipse.emf.common.util.EList;

/**
 * A <code>NaryBooleanOperator</code> is a {@link BooleanOperator} whose value
 * is the result of evaluating a boolean operator that takes one or (usually)
 * more operands.
 * 
 * @see UnaryBooleanOperator
 * @model abstract="true"
 */
public interface NaryBooleanOperator extends BooleanOperator {
	/**
	 * @return the collection of operands to this operator
	 * @model type="Predicate" containment="true"
	 */
	EList<Predicate> getOperands();
} // NaryBooleanOperator
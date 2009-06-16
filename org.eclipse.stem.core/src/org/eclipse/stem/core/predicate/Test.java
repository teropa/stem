// Test.java
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
 * A <code>Test</code> is a {@link Predicate} whose value is the result of
 * executing underlying code rather than from the evaluation of some boolean
 * expression.
 * 
 * @see BooleanExpression
 * @see PredicateReference
 * @model abstract="true"
 */
public interface Test extends Predicate {
	// Nothing
} // Test
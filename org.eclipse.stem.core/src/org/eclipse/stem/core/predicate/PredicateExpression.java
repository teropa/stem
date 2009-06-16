// PredicateExpression.java
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
 * A <code>PredicateExpression</code> is a {@link BooleanExpression} whose value
 * is the result of evaluating a {@link Predicate}.
 * 
 * @model
 */
public interface PredicateExpression extends BooleanExpression {

	/**
	 * @return the {@link Predicate} that determines the value of this
	 *         expression.
	 * @model containment="true"
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.predicate.PredicateExpression#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);
} // PredicateExpression
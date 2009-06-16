// PredicateReference.java
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
 * An <code>PredicateReference</code> is a {@link Predicate} whose value is the
 * result of evaluating a referenced (i.e., non-containment) {@link Predicate}.
 * 
 * @see Test
 * @see BooleanExpression
 * @model
 */
public interface PredicateReference extends Predicate {
	/**
	 * @model containment="false"
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.predicate.PredicateReference#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);
} // PredicateReference
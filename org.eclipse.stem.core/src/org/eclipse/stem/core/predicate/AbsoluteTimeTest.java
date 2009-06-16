// AbsoluteTimeTest.java
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

import org.eclipse.stem.core.model.STEMTime;

/**
 * A <code>AbsoluteTimeTest</code> is a {@link TimeTest} that returns a boolean
 * value depending upon the comparison of the current time value passed to
 * {@link #evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator)}
 * and the value returned by {@link #getReferenceTime()}.
 * 
 * @model
 */
public interface AbsoluteTimeTest extends TimeTest {
	/**
	 * @return the time value used for comparison purposes.
	 * @model containment="true"
	 */
	STEMTime getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.predicate.AbsoluteTimeTest#getTime <em>Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' containment reference.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(STEMTime value);

	
} // AbsoluteTimeTest
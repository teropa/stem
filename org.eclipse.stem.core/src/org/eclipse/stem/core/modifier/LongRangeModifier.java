// LongRangeModifier.java
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

/**
 * A <code>LongRangeModifier</code> modifies an long valued feature from
 * a starting value to and end value (inclusive> by increments.
 * 
 * @model
 */
public interface LongRangeModifier extends RangeModifier {
	
	/**
	 * @model default="-99999999"
	 */
	long getOriginalValue();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getOriginalValue <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' attribute.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(long value);

	/**
	 * @model default="-99999999"
	 */
	long getStartValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getStartValue <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Value</em>' attribute.
	 * @see #getStartValue()
	 * @generated
	 */
	void setStartValue(long value);

	/**
	 * @model default="-99999999"
	 */
	long getEndValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getEndValue <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Value</em>' attribute.
	 * @see #getEndValue()
	 * @generated
	 */
	void setEndValue(long value);

	/**
	 * @model default="-99999999"
	 */
	long getIncrement();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getIncrement <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' attribute.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(long value);
	
	/**
	 * @return the next value of the feature
	 * @model default="-99999999" changeable="true"
	 */
	long getNextValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getNextValue <em>Next Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Value</em>' attribute.
	 * @see #getNextValue()
	 * @generated
	 */
	void setNextValue(long value);
} // LongRangeModifier
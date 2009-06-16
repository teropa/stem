// DoubleRangeModifier.java
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
 * A <code>DoubleRangeModifier</code> modifies a double valued feature from a
 * starting value to and end value (inclusive> by increments.
 * 
 * @model
 */
public interface DoubleRangeModifier extends RangeModifier {
	
	/**
	 * @model
	 */
	double getOriginalValue();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getOriginalValue <em>Original Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Value</em>' attribute.
	 * @see #getOriginalValue()
	 * @generated
	 */
	void setOriginalValue(double value);

	/**
	 * @model default="-99999999.0"
	 */
	double getStartValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getStartValue <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Value</em>' attribute.
	 * @see #getStartValue()
	 * @generated
	 */
	void setStartValue(double value);

	/**
	 * @model default="-99999999.0"
	 */
	double getEndValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getEndValue <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Value</em>' attribute.
	 * @see #getEndValue()
	 * @generated
	 */
	void setEndValue(double value);

	/**
	 * @model default="-99999999.0"
	 */
	double getIncrement();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getIncrement <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' attribute.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(double value);

	/**
	 * @return the next value of the feature
	 * @model default="0.0" changeable="true"
	 */
	double getNextValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getNextValue <em>Next Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Value</em>' attribute.
	 * @see #getNextValue()
	 * @generated
	 */
	void setNextValue(double value);

	
} // DoubleRangeModifier

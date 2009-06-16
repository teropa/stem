// TestIntegerLabelValue.java
package org.eclipse.stem.tests.util.labels;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.graph.LabelValue;

/**
 * /** This interface represents the model of an abstract class in an EMF model
 * that is an example of a LabelValue implementation used for test purposes.
 * 
 * @model
 */
public interface TestIntegerLabelValue extends LabelValue {

	/**
	 * The integer value used in test cases for the initial "current" value.
	 */
	int CURRENT_LABEL_INTEGER_VALUE = 10;
	
	/**
	 * The integer value used in test cases for the initial "next" value.
	 */
	int NEXT_LABEL_INTEGER_VALUE = 11;
	
	/**
	 * @return the value of the field <code>i</code>
	 * @model
	 */
	int getI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.labels.TestIntegerLabelValue#getI <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' attribute.
	 * @see #getI()
	 * @generated
	 */
	void setI(int value);

	/**
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void increment();
} // TestIntegerLabelValue

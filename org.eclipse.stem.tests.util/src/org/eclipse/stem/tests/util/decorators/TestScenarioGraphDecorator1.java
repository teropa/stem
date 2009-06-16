// TestScenarioGraphDecorator1.java
package org.eclipse.stem.tests.util.decorators;

/*******************************************************************************
 * Copyright (c) 2006,2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.GraphDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.scenario.Scenario;

/**
 * This class represents a {@link Graph} decorator that decorates the canonical
 * graph at {@link Scenario} initialization.
 * 
 * @model
 */
public interface TestScenarioGraphDecorator1 extends GraphDecorator {
	/**
	 * test label URI
	 */
	URI LABEL_URI = STEMURI.createURI("dynamiclabel/scenario");

	/**
	 * @model
	 */
	double getDoubleValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getDoubleValue <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Value</em>' attribute.
	 * @see #getDoubleValue()
	 * @generated
	 */
	void setDoubleValue(double value);

	/**
	 * @model
	 */
	int getIntValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getIntValue <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int Value</em>' attribute.
	 * @see #getIntValue()
	 * @generated
	 */
	void setIntValue(int value);

	/**
	 * @model
	 */
	String getStringValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getStringValue <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Value</em>' attribute.
	 * @see #getStringValue()
	 * @generated
	 */
	void setStringValue(String value);

	/**
	 * @model
	 */
	STEMTime getSTEMTimeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#getSTEMTimeValue <em>STEM Time Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STEM Time Value</em>' reference.
	 * @see #getSTEMTimeValue()
	 * @generated
	 */
	void setSTEMTimeValue(STEMTime value);

	/**
	 * @model
	 */
	boolean isBooleanValue();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1#isBooleanValue <em>Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Value</em>' attribute.
	 * @see #isBooleanValue()
	 * @generated
	 */
	void setBooleanValue(boolean value);
} // TestScenarioGraphDecorator1

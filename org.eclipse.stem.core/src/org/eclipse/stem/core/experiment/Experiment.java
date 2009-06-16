// Experiment.java
package org.eclipse.stem.core.experiment;

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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.scenario.Scenario;

/**
 * An {@link Experiment} is a specification of how to modify a "base"
 * {@link Scenario} to create one or more "derived" {@link Scenario}s. The
 * purpose of this is to allow for the definition of a related spectrum of
 * {@link Scenario}s that have slightly (or dramatically) different
 * configurations. The intent is to enable the exploration of the effect
 * different configurations have on the outcome of the {@link Scenario}.
 * <p>
 * An {@link Experiment} consists of a hierarchical organization of
 * {@link Modifier}s and other {@link Experiment}s.
 * 
 * @model
 */
public interface Experiment extends Identifiable {

	String URI_TYPE_EXPERIMENT_SEGMENT = "experiment";

	/**
	 * @return the {@link Scenario} that will be modified during the experiment.
	 * @model containment="false"
	 */
	Scenario getScenario();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.experiment.Experiment#getScenario <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario</em>' reference.
	 * @see #getScenario()
	 * @generated
	 */
	void setScenario(Scenario value);

	/**
	 * @return the {@link Modifier}s that specify the changes to the
	 *         {@link Scenario}.
	 * @model containment="false"
	 */
	EList<Modifier> getModifiers();

	/**
	 * @return the {@link Experiment}'s {@link Scenario} modified by the
	 *         {@link Experiment}'s collection of {@link Modifier}s
	 *         @see #isComplete()
	 * @model volatile="true" transient="true" changeable="false"
	 */
	Scenario updateScenario();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Scenario initScenario();

	/**
	 * @return a {@link List} of {@link String}s that summarize the
	 *         modifications made during the last call to
	 *         {@link #getNextScenario()}.
	 * model volatile="true" transient="true" changeable="false"
	 */
	List<String> getModificationSummary();
	
	/**
	 * @return a {@link List} of {@link String}s that summarize the values of
	 *         all of the parameters.
	 * model volatile="true" transient="true" changeable="false"
	 */
	List<String> getParameterSummary();

	/**
	 * @return <code>true</code> if the {@link Experiment} is complete,
	 *         <code>false</code>, otherwise.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean isComplete();
} // Experiment

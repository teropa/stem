// Modifier.java
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

import java.lang.String;
import java.util.List;

import javax.sql.rowset.Predicate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.trigger.Trigger;

/**
 * A <code>Modifier</code> specifies the changes to be made to the features of
 * an specific "target" {@link EObject}. It contains the {@link URI} of the
 * {@link Identifiable} and a collection of {@link FeatureModifier}s that
 * perform the actual feature modification. A <code>Modifier</code> can change
 * the value of a feature in a {@link LabelValue}, instances of which are not
 * {@link Identifiable}s. In such cases, the {@link URI} specifies the
 * {@link Label} instance which contains a reference to the {@link LabelValue}
 * instance that will be modified.
 * <p>
 * <code>Modifiers</code> are used by both {@link Experiment}s and
 * {@link Trigger}s to modify elements of a canonical {@link Graph} that
 * represents simulation state. In the former case, the <code>Modifier</code>
 * makes alterations to a {@link Scenario} instance before it is used to launch
 * a Simulation. In the later case, a <code>Modifier</code> is used as a
 * {@link Decorator} that is conditionally enabled by the value of the
 * {@link Predicate} referenced by a {@link Trigger}.
 * <p>
 * The {@link FeatureModifier}s perform the actual modifications to the
 * {@link EObject}s.
 * <p>
 * This interface definition is also an "Annotated Java Interface" that defines
 * one class in a <a href="http://www.uml.org/">UML</a> "model". The UML class
 * diagram for the model is in the <code>documentation</code> folder of the
 * project. This file and the other interfaces in this Java package are
 * processed by the Eclipse Modeling Framework (aka EMF <a
 * href="http://org.eclipse/emf">http://org.eclipse/emf</a>). to automatically
 * generate an implementation of the model. EMF is documented in the book <a
 * href="http://www.awprofessional.com/bookstore/product.asp?isbn=0131425420&rl=1">Eclipse
 * Modeling Framework </a> by Budinsky, et al.
 * </p>
 * @model
 */
public interface Modifier extends Decorator {

	String URI_TYPE_MODIFIER_SEGMENT = "modifier";
	
	/**
	 * @model
	 */
	URI getTargetURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.Modifier#getTargetURI <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target URI</em>' attribute.
	 * @see #getTargetURI()
	 * @generated
	 */
	void setTargetURI(URI value);

	/**
	 * @model containment="true"
	 */
	EList<FeatureModifier> getFeatureModifiers();

	/**
	 * @param baseScenario
	 *            the {@link Scenario} to be modified.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void updateScenario(final Scenario baseScenario);

	/**
	 * @return a {@link List} of {@link String}s that summarize the
	 *         modifications made to the last {@link Scenario} by the call to
	 *         {@link #updateScenario(Scenario)}.
	 * model volatile="true" transient="true" changeable="false"
	 */
	List<String> getModificationSummary();

	/**
	 * @return <code>true</code> if all of the modifications to the
	 *         {@link Identifiable} have been completed, <code>false</code>,
	 *         otherwise.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean isComplete();

	/**
	 * Restore the value of all of the features being modified to their original
	 * values.
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void reset();
} // Modifier

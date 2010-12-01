// Decorator.java
package org.eclipse.stem.core.model;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;

/**
 * A <code>Decorator</code> represents a computational component that can
 * modify or "decorate" a {@link org.eclipse.stem.core.graph.Graph}.
 * <p>
 * The method {@link #decorateGraph(org.eclipse.stem.core.graph.Graph)} is
 * called once for each <code>Decorator</code> instance during the creation of
 * the canonical {@link org.eclipse.stem.core.graph.Graph} (see
 * {@link Model#getCanonicalGraph(org.eclipse.emf.common.util.URI)}).
 * Typically, this method would add additional {@link DynamicLabel}s to the
 * {@link org.eclipse.stem.core.graph.Graph} under construction. For
 * example, a disease model would be implemented as a <code>Decorator</code>
 * and it would add {@link DynamicLabel}s to the
 * {@link org.eclipse.stem.core.graph.Node}s of the
 * {@link org.eclipse.stem.core.graph.Graph} that represent the state of the
 * disease at each {@link org.eclipse.stem.core.graph.Node}.
 * </p>
 * <p>
 * After the canonical {@link org.eclipse.stem.core.graph.Graph} is created,
 * the method
 * {@link #updateLabels(org.eclipse.stem.core.graph.Graph, STEMTime, long)}
 * will be called once every time the
 * {@link org.eclipse.stem.core.scenario.Scenario} is "stepped" (see
 * {@link org.eclipse.stem.core.scenario.Scenario#step()}). The
 * {@link DynamicLabel}s that it updates are those that were added to the
 * {@link org.eclipse.stem.core.graph.Graph} in the
 * {@link #decorateGraph(org.eclipse.stem.core.graph.Graph)} method call. A
 * reference to each of those {@link DynamicLabel}s is kept in a collection
 * (see {@link #getLabelsToUpdate()}) maintained by the <code>Decorator</code>.
 * The {@link #updateLabels(Graph, STEMTime, long)} method computes the "next"
 * value of all of the {@link DynamicLabel}s in that collection.
 * </p>
 * <p>
 * For maximum flexibility, the nature of that
 * {@link org.eclipse.stem.core.graph.LabelValue} and its computation are
 * not defined or restricted. For instance, the <code>Decorator</code> could
 * compute the {@link org.eclipse.stem.core.graph.LabelValue} from the
 * contents of the {@link org.eclipse.stem.core.graph.Graph}, read the
 * value from a file, obtain it from a real-time data source such as a weather
 * station or something accessible from a web site or a web service.
 * </p>
 * 
 * @model
 */
public interface Decorator extends Identifiable {

	/**
	 * A {@link Decorator} is enabled by default, but if it is the action of a
	 * {@link Trigger} then it will be disabled by the {@link Trigger} until the
	 * {@link Trigger}'s {@link Predicate} evaluates to <code>true</code>.
	 * <p>
	 * If the value is <code>false</code> then calls to {@link #decorateGraph()}
	 * and {@link #updateLabels(STEMTime, long)} will be ignored.
	 * 
	 * @return <code>true</code> if the {@link Decorator} is enabled.
	 * @model default="true"
	 */
	boolean isEnabled();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.model.Decorator#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);


	/**
	 * @return <code>true</code> if {@link #decorateGraph()} has been called and
	 *         it has completed decorating the {@link Graph}, <code>false</code>
	 *         otherwise.
	 * @model default="false"
	 */
	boolean isGraphDecorated();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.model.Decorator#isGraphDecorated <em>Graph Decorated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph Decorated</em>' attribute.
	 * @see #isGraphDecorated()
	 * @generated
	 */
	void setGraphDecorated(boolean value);
	
	/**
	 * Returns the value of the '<em><b>Progress</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Progress</em>' attribute.
	 * @see #setProgress(double)
	 * @see org.eclipse.stem.core.model.ModelPackage#getDecorator_Progress()
	 * @model default="0.0"
	 * @generated
	 */
	double getProgress();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.model.Decorator#getProgress <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Progress</em>' attribute.
	 * @see #getProgress()
	 * @generated
	 */
	void setProgress(double value);

	/**Augment the graph by adding components ({@link Edge}s,
	 * {@link org.eclipse.stem.core.graph.Node}s,
	 * {@link org.eclipse.stem.core.graph.Label}s). The added components,
	 * in particular {@link DynamicLabel}s, can be modified later during a call
	 * to {@link #updateLabels(Graph, STEMTime)}. A side effect of this call is
	 * that it adds the decorator to the collection maintained by the
	 * {@link Graph}.
	 * @param tiome
	 * @return boolean
	 * @generated
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean decorateGraph(STEMTime time);

	/**
	 * 
	 * @return the {@link Graph} that the <code>Decorator</code> decorates.
	 * @model opposite="decorators"
	 */
	Graph getGraph();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.model.Decorator#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc --> 
	 * 
	 * Sets the value of the '{@link org.eclipse.stem.core.model.Decorator#getGraph <em>Graph</em>}'
	 * container reference.
	 * 
	 * @param value
	 *            the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * 
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * @return the list of {@link DynamicLabel}s that this <code>Decorator</code>
	 * 	 is responsible for updating.
	 * @model type="DynamicLabel" containment="false" opposite="decorator"
	 */
	EList<DynamicLabel> getLabelsToUpdate();


	/**
	 * Process each of the {@link DynamicLabel}s that this
	 * <code>Decorator</code> is responsible for and determine their "next"
	 * value.
	 * 
	 * @param time
	 *            the time to be used when determining the changes to be made to
	 *            the Graph
	 * @param timePeriod
	 *            the number of milliseconds difference between the time and the
	 *            previous time value.
	 * @param cycle 
	 * 			  The next cycle number.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void updateLabels(final STEMTime time, final long timerPeriod, int cycle);

	/**
	 * Process each of the {@link DynamicLabels} that this
	 * <code>decorator</code> is responsible for and reset their "current"
	 * value to be the initial value assigned during the call to the method
	 * {@link #decorateGraph()}
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void resetLabels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<DynamicLabel> getLabelsToUpdate(int partition, int max);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void prepare(Model model, STEMTime time);

} // Decorator

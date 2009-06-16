// UnresolvedIdentifiable.java
package org.eclipse.stem.core.graph;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;

/**
 * An <code>UnresolvedIdentifiable</code> is created during the generation of
 * the canonical {@link Graph} (see
 * {@link org.eclipse.stem.core.model.Model#getCanonicalGraph(URI)) when an {{@link Edge}
 * or a {@link Label} cannot be matched with the {@link Node} or {@link Graph}
 * that its target {@link URI} specifies.
 * <p>
 * Instances of <code>UnresolvedIdentifiable</code> are used to report the
 * inability to resolve the {@link URI}.
 * </p>
 * 
 * @model
 */
public interface UnresolvedIdentifiable extends EObject {

	/**
	 * This is the {@link org.eclipse.stem.core.scenario.Scenario} that
	 * contains the {@link org.eclipse.stem.core.model.Model} that is
	 * creating the canonical {@link Graph}.
	 * 
	 * TODO shouldn't the return value be Scenario?
	 * 
	 * @model containment="false"
	 */
	Identifiable getScenario();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getScenario <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scenario</em>' reference.
	 * @see #getScenario()
	 * @generated
	 */
	void setScenario(Identifiable value);

	/**
	 * This is the {@link Model} that was creating the canonical {@link Graph}
	 * when the unresolved {@link URI} was encountered.
	 * 
	 * @model containment="false"
	 */
	Identifiable getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Identifiable value);

	/**
	 * This is the {@link Graph} that contains the {@link Edge} or {@link Label}
	 * that has the unresolved {@link URI}.
	 * 
	 * TODO BUG this value is always null.
	 * 
	 * @model containment="false"
	 */
	Identifiable getGraph();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getGraph <em>Graph</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Identifiable value);

	/**
	 * @return the {@link Edge} or {@link Label} that has the unresolved target
	 *         {@link URI}.
	 * @model containment="false"
	 */
	Identifiable getIdentifiable();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getIdentifiable <em>Identifiable</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifiable</em>' reference.
	 * @see #getIdentifiable()
	 * @generated
	 */
	void setIdentifiable(Identifiable value);

	/**
	 * @return the unresolved {@link URI}.
	 * 
	 * @model
	 */
	URI getUnresolvedURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getUnresolvedURI <em>Unresolved URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unresolved URI</em>' attribute.
	 * @see #getUnresolvedURI()
	 * @generated
	 */
	void setUnresolvedURI(URI value);

	/**
	 * @return either "NODE A" or "NODE B" for an {@link Edge}, or "NODE" for a
	 *         {@link Label}.
	 * @model
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graph.UnresolvedIdentifiable#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

} // UnresolvedIdentifiable

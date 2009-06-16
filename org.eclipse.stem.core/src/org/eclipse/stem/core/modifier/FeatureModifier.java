// FeatureModifier.java
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.SanityChecker;

/**
 * A {@link FeatureModifier} specifies how to change the value of
 * "feature" in an {@link Identifiable}.
 * 
 * @model abstract="true"
 * @implements SanityChecker
 */
public interface FeatureModifier extends EObject, SanityChecker {
	
	/**
	 * @return the {@link Identifiable} that will be modified.
	 * @model 
	 */
	EObject getTarget();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.FeatureModifier#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * @return the id of the feature being modified
	 * @model transient="true" resolveProxies="false"
	 */
	EStructuralFeature getEStructuralFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.FeatureModifier#getEStructuralFeature <em>EStructural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EStructural Feature</em>' reference.
	 * @see #getEStructuralFeature()
	 * @generated
	 */
	void setEStructuralFeature(EStructuralFeature value);

	/**
	 * @model
	 */
	String getFeatureName();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.FeatureModifier#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

	/**
	 * @return the featureID of the {@link EStructuralFeature} to be modified.
	 * @model
	 */
	int getFeatureId();
	
	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.modifier.FeatureModifier#getFeatureId <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Id</em>' attribute.
	 * @see #getFeatureId()
	 * @generated
	 */
	void setFeatureId(int value);

	/**
	 * @return the textual representation of the value that was used in the
	 *         last call to {@link #updateFeature()}
	 * @see #getNextValue()
	 * @model transient="true" changeable="false"
	 */
	String getCurrentValueText();
	
	/**
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void updateFeature();

	/**
	 * @return a {@link List} of {@link String}s that summarize the
	 *         modifications made to the last {@link EObject} by the call to
	 *         {@link #updateFeature()}.
	 * model volatile="true" transient="true" changeable="false"
	 */
	String getModificationSummary();

	/**
	 * @return <code>true</code> if all of the modifications to the feature
	 *         been completed, <code>false</code>, otherwise.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	boolean isComplete();
	
	/**
	 * Restore the value of the feature being modified to its original value
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void reset();

} // FeatureModifier

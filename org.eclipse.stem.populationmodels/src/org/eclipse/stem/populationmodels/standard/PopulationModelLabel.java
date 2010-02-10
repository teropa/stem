package org.eclipse.stem.populationmodels.standard;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
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
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population Model Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationLabel <em>Population Label</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationIdentifier <em>Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModelLabel()
 * @model
 * @generated
 */
public interface PopulationModelLabel extends DynamicNodeLabel {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * dynamic population label type URI.
	 */
	String URI_TYPE_DYNAMIC_POPULATION_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT
			+ "/dynpopulation";

	/**
	 * This is the type URI for dynamic population labels
	 */
	URI URI_TYPE_DYNAMIC_POPULATION_LABEL = STEMURI
			.createTypeURI(URI_TYPE_DYNAMIC_POPULATION_LABEL_SEGMENT);
	
	/**
	 * Returns the value of the '<em><b>Population Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Label</em>' reference.
	 * @see #setPopulationLabel(PopulationLabel)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModelLabel_PopulationLabel()
	 * @model
	 * @generated
	 */
	PopulationLabel getPopulationLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationLabel <em>Population Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Label</em>' reference.
	 * @see #getPopulationLabel()
	 * @generated
	 */
	void setPopulationLabel(PopulationLabel value);

	/**
	 * Returns the value of the '<em><b>Population Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Identifier</em>' attribute.
	 * @see #setPopulationIdentifier(String)
	 * @see org.eclipse.stem.populationmodels.standard.StandardPackage#getPopulationModelLabel_PopulationIdentifier()
	 * @model
	 * @generated
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.populationmodels.standard.PopulationModelLabel#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);
} // PopulationModelLabel

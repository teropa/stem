// Infector.java
package org.eclipse.stem.diseasemodels.standard;

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.modifier.Modifiable;

/**
 * This interface defines a class in an EMF model for the initialization of an
 * infectious population in a disease model.
 * 
 * @model abstract="true"
 */
public interface Infector extends NodeDecorator, Modifiable {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * infector type URI.
	 */
	String URI_TYPE_INFECTOR_SEGMENT = "infector";

	/**
	 * @return the name of the disease to be infected
	 * @model
	 */
	String getDiseaseName();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.Infector#getDiseaseName <em>Disease Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Name</em>' attribute.
	 * @see #getDiseaseName()
	 * @generated
	 */
	void setDiseaseName(String value);

	/**
	 * @return the ISO3166 based key for the {@link Region} to be infected.
	 * @model
	 */
	String getTargetISOKey();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.Infector#getTargetISOKey <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target ISO Key</em>' attribute.
	 * @see #getTargetISOKey()
	 * @generated
	 */
	void setTargetISOKey(String value);

	/**
	 * @return the identifier of the population that is to be infected
	 * @model
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.Infector#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Infect Percentage</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infect Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infect Percentage</em>' attribute.
	 * @see #setInfectPercentage(boolean)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getInfector_InfectPercentage()
	 * @model default="false"
	 * @generated
	 */
	boolean isInfectPercentage();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.Infector#isInfectPercentage <em>Infect Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infect Percentage</em>' attribute.
	 * @see #isInfectPercentage()
	 * @generated
	 */
	void setInfectPercentage(boolean value);

	/**
	 * @return the disease model that this infector initializes
	 * @model containment="false"
	 */
	StandardDiseaseModel getDiseaseModel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.Infector#getDiseaseModel <em>Disease Model</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Model</em>' reference.
	 * @see #getDiseaseModel()
	 * @generated
	 */
	void setDiseaseModel(StandardDiseaseModel value);

	/**
	 * @return the URI of the node that will receive the infectious population
	 * @model
	 */
	URI getTargetURI();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.Infector#getTargetURI <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target URI</em>' attribute.
	 * @see #getTargetURI()
	 * @generated
	 */
	void setTargetURI(URI value);

	/**
	 * @return the list of {@link DiseaseLabel}s that this <code>Infector</code>
	 * 	 is responsible for "infecting".
	 * @model type="DiseaseModelLabel" containment="false" 
	 */
	EList<DiseaseModelLabel> getLabelsToInfect();
} // Infector

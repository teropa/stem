// DiseaseModelLabel.java
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;

/**
 * This interface defines a class in an EMF model for an STEM Disease model
 * label. It is the top-level disease model, all other disease model labels
 * derive from this class.
 * 
 * @model abstract="true"
 */
public interface DiseaseModelLabel extends DynamicNodeLabel {

	/**
	 * This is the top-level segment for all type URI's for disease model
	 * labels.
	 */
	String URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT = URI_TYPE_DYNAMIC_LABEL_SEGMENT
			+ "/diseasemodel";

	/**
	 * This is the type URI for disease model labels
	 */
	URI URI_TYPE_SIR_LABEL = STEMURI
			.createTypeURI(URI_TYPE_DISEASE_MODEL_LABEL_SEGMENT);

	/**
	 * This is the Population being infected by a Disease. The values for this
	 * disease model label apply to the population represented by the population
	 * label.
	 * 
	 * @return the Population affected by the disease.
	 * 
	 * @model
	 */
	PopulationLabel getPopulationLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getPopulationLabel <em>Population Label</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Label</em>' reference.
	 * @see #getPopulationLabel()
	 * @generated
	 */
	void setPopulationLabel(PopulationLabel value);

	/**
	 * @return the disease model state associated with this label (if any).
	 * @model containment="true" opposite="label"
	 */
	DiseaseModelState getDiseaseModelState();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel#getDiseaseModelState <em>Disease Model State</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Model State</em>' containment reference.
	 * @see #getDiseaseModelState()
	 * @generated
	 */
	void setDiseaseModelState(DiseaseModelState value);
	
	/**
	 * @return the value of the number of population members who have died from
	 *         the disease.
	 */
	double getDiseaseDeaths();

	/**
	 * @param d the number of deaths
	 */
	void setDiseaseDeaths(final double d);
	
	/**
	 * @return the next value of the number of population members who have died
	 *         from the disease.
	 */
	double getNextDiseaseDeaths();

	/**
	 * @param d the number of deaths
	 */
	void setNextDiseaseDeaths(final double d);
	
} // DiseaseModelLabel

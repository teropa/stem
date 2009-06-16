// PopulationLabel.java
package org.eclipse.stem.definitions.labels;

/******************************************************************************* 
 * Copyright (c) 2007 IBM Corporation and others. 
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
import org.eclipse.stem.core.graph.StaticNodeLabel;

/**
 * This interface defines a class in an EMF model for PopulationLabel.
 * 
 * @model
 */
public interface PopulationLabel extends StaticNodeLabel {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * population label type URI.
	 */
	String URI_TYPE_POPULATION_LABEL_SEGMENT = URI_TYPE_LABEL_SEGMENT
			+ "/population";

	/**
	 * This is the type URI for population labels
	 */
	URI URI_TYPE_POPULATION_LABEL = STEMURI
			.createTypeURI(URI_TYPE_POPULATION_LABEL_SEGMENT);

	// These constants are identifiers of various "built-in" population types
	/**
	 * Generic human population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String HUMAN = "human";

	/**
	 * Human male population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String HUMAN_MALE = "human_male";

	/**
	 * Human adult male population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String HUMAN_MALE_ADULT = "human_male_adult";

	/**
	 * Human child male population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String HUMAN_MALE_CHILD = "human_male_child";

	/**
	 * Human adult female population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String HUMAN_FEMALE_ADULT = "human_female_adult";

	/**
	 * Human child female population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String HUMAN_FEMALE_CHILD = "human_female_child";

	/**
	 * Generic bird population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String BIRD = "bird";

	/**
	 * Duck population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String BIRD_DUCK = "bird_duck";

	/**
	 * Chicken population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String BIRD_CHICKEN = "bird_chicken";

	/**
	 * Generic swine (pig) population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String SWINE = "swine";

	/**
	 * Generic mosquito population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String MOSQUITO = "mosquito";

	/**
	 * Anopheles mosquito population.
	 * 
	 * @see #getPopulationIdentifier()
	 */
	String MOSQUITO_ANOPHELES = "mosquito_anopheles";

	/**
	 * @return a string that is a non-NLS'd identifier of the population. e.g.
	 *         "boys", "birds"
	 * @model
	 */
	String getPopulationIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.PopulationLabel#getPopulationIdentifier <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Identifier</em>' attribute.
	 * @see #getPopulationIdentifier()
	 * @generated
	 */
	void setPopulationIdentifier(String value);

	/**
	 * @return the NLS'd name of the population
	 * @model
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.PopulationLabel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * @return the current population value
	 * @model volatile="true" transient="true" changeable="false"
	 *        resolveProxies="false"
	 */
	PopulationLabelValue getCurrentPopulationValue();

	/**
	 * This value can be used to compute a more accurate population density for
	 * cases where the area of a node might be quite large while the actual
	 * distribution of population members is quite small. This would be the case
	 * for instance if a node represented a large empty area with a few cities
	 * and towns (e.g., The State of Wyoming in the United States). If this
	 * optional value value is set, then it represents the smaller area that is
	 * actually populated. Typically, this value would not be set and the
	 * population density would be computed by using the actual area of the
	 * region that this label labels.
	 * 
	 * @return the actual area that is populated (square kilometers).
	 * @model default="0"
	 */
	double getPopulatedArea();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.definitions.labels.PopulationLabel#getPopulatedArea <em>Populated Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Populated Area</em>' attribute.
	 * @see #getPopulatedArea()
	 * @generated
	 */
	void setPopulatedArea(double value);

} // PopulationLabel

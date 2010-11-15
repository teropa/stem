// StandardDiseaseModel.java
package org.eclipse.stem.diseasemodels.standard;

import org.eclipse.emf.common.util.EList;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.model.STEMTime;

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


/**
 * This interface defines a class in an EMF model for a Standard disease model.
 * 
 * @see SIR
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model abstract="true"
 */
public interface StandardDiseaseModel extends DiseaseModel, IntegrationDecorator {

	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard disease model type URI.
	 */
	String URI_TYPE_STANDARD_DISEASEMODEL_SEGMENT = URI_TYPE_DISEASEMODEL_SEGMENT
			+ "/standard";


	/**
	 * Add a number of population members to an accumulating value for the total
	 * number of population members (in all disease states) for all {@link Node}s
	 * for which this {@link StandardDiseseModel} computes
	 * {@link StandardDiseaseModelLabel} values.
	 * 
	 * @param populationCount
	 *            the number of population members to add to the total
	 * @see #getTotalPopulationCount()
	 * @see #setTotalPopulationCount(double)
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void addToTotalPopulationCount(final double populationCount);

	/**
	 * @return the total number of population members this disease model is
	 *         processing
	 * @see #setTotalPopulationCount(double)
	 * @see #addToTotalPopulationCount(double)
	 * @model default="0"
	 */
	double getTotalPopulationCount();
	
	/**
	 * 	/**
	 * The Transmission Coefficient (beta) must be scaled by
	 * the local population density divided by a reference
	 * population density (e.g. the particular location where beta is know or was measured)
	 * For example, in the US the avg pop density is 32.9 people per square km
	 * In China, 141.8 people per sq km,
	 * In Europe 69.7 people per sq km
     * The default value is 100 but this should be specified for any
     * disease along with the value beta. This method is called in
     * getTransmissionRateScaleFactor and used to computeTransions method for a diseaes model.
	 * @return the Reference Population 
	 * @see #SIImpl.getTransmissionRateScaleFactor()
	 * @see #setReferencePopulationDensity(double)
	 * @model default="100"
	 */
	double getReferencePopulationDensity();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getReferencePopulationDensity <em>Reference Population Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Population Density</em>' attribute.
	 * @see #getReferencePopulationDensity()
	 * @generated
	 */
	void setReferencePopulationDensity(double value);

	/**
	 * Returns the value of the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * The default value is <code>"0.01"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Road Network Infectious Proportion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Road Network Infectious Proportion</em>' attribute.
	 * @see #setRoadNetworkInfectiousProportion(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getStandardDiseaseModel_RoadNetworkInfectiousProportion()
	 * @model default="0.01"
	 * @generated
	 */
	double getRoadNetworkInfectiousProportion();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Network Infectious Proportion</em>' attribute.
	 * @see #getRoadNetworkInfectiousProportion()
	 * @generated
	 */
	void setRoadNetworkInfectiousProportion(double value);

	/**
	 * Returns the value of the '<em><b>Characteristic Mixing Distance</b></em>' attribute.
	 * The default value is <code>"2.25"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characteristic Mixing Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristic Mixing Distance</em>' attribute.
	 * @see #setCharacteristicMixingDistance(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getStandardDiseaseModel_CharacteristicMixingDistance()
	 * @model default="2.25"
	 * @generated
	 */
	double getCharacteristicMixingDistance();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getCharacteristicMixingDistance <em>Characteristic Mixing Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characteristic Mixing Distance</em>' attribute.
	 * @see #getCharacteristicMixingDistance()
	 * @generated
	 */
	void setCharacteristicMixingDistance(double value);

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalPopulationCount <em>Total Population Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Population Count</em>' attribute.
	 * @see #getTotalPopulationCount()
	 * @generated
	 */
	void setTotalPopulationCount(double value);

	/**
	 * Compute and store the reciprocal of the total population count. This
	 * value only needs to be computed once for each simulation cycle so we
	 * store the value so that we don't compute it more than once. This method
	 * is called once just before the first cycle, and then again at the end of
	 * every cycle when the current total population count has been determined.
	 * 
	 * @return 1/getTotalPopulationCount()
	 * @see #getTotalPopulationCountReciprocal()
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double computeTotalPopulationCountReciprocal();

	/**
	 * @return the reciprocal of the total population count.
	 * @see #computeTotalPopulationReciprocal()
	 * @model changeable="false"
	 */
	double getTotalPopulationCountReciprocal();

	/**
	 * Add the area value to the accumulating value for the total area of all
	 * {@link Node}s for which this {@link StandardDiseseModel} computes
	 * {@link StandardDiseaseModelLabel} values.
	 * 
	 * @param area
	 *            the area to add (km^2)
	 * @see #getTotalArea()
	 * @see #setTotalArea(double)
	 * @model volatile="true" transient="true" changeable="false"
	 */
	void addToTotalArea(final double area);

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model labelsMany="false"
	 * @generated
	 */
	void calculateDelta(STEMTime time, long timeDelta, EList<DynamicLabel> labels);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void doModelSpecificAdjustments(StandardDiseaseModelLabelValue label);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double getEffectiveInfectious(Node node, StandardDiseaseModelLabel diseaseLabel, double onsiteInfectious);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double getNormalizedEffectiveInfectious(Node node, StandardDiseaseModelLabel diseaseLabel, double onsiteInfectious);

	/**
	 * @return the total area (km^2) occupied by the population whose disease
	 *         state is processed by this <code>StandardDiseseModel</code>
	 * @see #addToTotalArea(double)
	 * @see #setTotalArea(double)
	 * @model default="0"
	 */
	double getTotalArea();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel#getTotalArea <em>Total Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Area</em>' attribute.
	 * @see #getTotalArea()
	 * @generated
	 */
	void setTotalArea(double value);

} // StandardDiseaseModel

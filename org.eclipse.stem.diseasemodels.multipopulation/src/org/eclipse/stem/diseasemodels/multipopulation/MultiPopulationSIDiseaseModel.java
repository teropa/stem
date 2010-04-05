package org.eclipse.stem.diseasemodels.multipopulation;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.DoubleValueMatrix;
import org.eclipse.stem.core.common.StringValueList;
import org.eclipse.emf.common.util.EList;
import java.math.BigDecimal;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Population SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPopulationGroups <em>Population Groups</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getTransmissionRate <em>Transmission Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRecoveryRate <em>Recovery Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getInfectiousMortalityRate <em>Infectious Mortality Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPhysicallyAdjacentInfectiousProportion <em>Physically Adjacent Infectious Proportion</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel()
 * @model
 * @generated
 */
public interface MultiPopulationSIDiseaseModel extends StandardDiseaseModel {

	/**
	 * Returns the value of the '<em><b>Transmission Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transmission Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transmission Rate</em>' containment reference.
	 * @see #setTransmissionRate(DoubleValueMatrix)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel_TransmissionRate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleValueMatrix getTransmissionRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getTransmissionRate <em>Transmission Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Rate</em>' containment reference.
	 * @see #getTransmissionRate()
	 * @generated
	 */
	void setTransmissionRate(DoubleValueMatrix value);

	/**
	 * Returns the value of the '<em><b>Recovery Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recovery Rate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery Rate</em>' containment reference.
	 * @see #setRecoveryRate(DoubleValueList)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel_RecoveryRate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleValueList getRecoveryRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRecoveryRate <em>Recovery Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery Rate</em>' containment reference.
	 * @see #getRecoveryRate()
	 * @generated
	 */
	void setRecoveryRate(DoubleValueList value);

	/**
	 * Returns the value of the '<em><b>Infectious Mortality Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infectious Mortality Rate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infectious Mortality Rate</em>' containment reference.
	 * @see #setInfectiousMortalityRate(DoubleValueList)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel_InfectiousMortalityRate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleValueList getInfectiousMortalityRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getInfectiousMortalityRate <em>Infectious Mortality Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infectious Mortality Rate</em>' containment reference.
	 * @see #getInfectiousMortalityRate()
	 * @generated
	 */
	void setInfectiousMortalityRate(DoubleValueList value);

	/**
	 * Returns the value of the '<em><b>Physically Adjacent Infectious Proportion</b></em>' attribute.
	 * The default value is <code>"0.01"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Physically Adjacent Infectious Proportion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Physically Adjacent Infectious Proportion</em>' attribute.
	 * @see #setPhysicallyAdjacentInfectiousProportion(double)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel_PhysicallyAdjacentInfectiousProportion()
	 * @model default="0.01"
	 * @generated
	 */
	double getPhysicallyAdjacentInfectiousProportion();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPhysicallyAdjacentInfectiousProportion <em>Physically Adjacent Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physically Adjacent Infectious Proportion</em>' attribute.
	 * @see #getPhysicallyAdjacentInfectiousProportion()
	 * @generated
	 */
	void setPhysicallyAdjacentInfectiousProportion(double value);

	/**
	 * Returns the value of the '<em><b>Road Network Infectious Proportion</b></em>' attribute.
	 * The default value is <code>"0.05"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Road Network Infectious Proportion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Road Network Infectious Proportion</em>' attribute.
	 * @see #setRoadNetworkInfectiousProportion(double)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel_RoadNetworkInfectiousProportion()
	 * @model default="0.05"
	 * @generated
	 */
	double getRoadNetworkInfectiousProportion();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Network Infectious Proportion</em>' attribute.
	 * @see #getRoadNetworkInfectiousProportion()
	 * @generated
	 */
	void setRoadNetworkInfectiousProportion(double value);

	/**
	 * Returns the value of the '<em><b>Population Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population Groups</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population Groups</em>' containment reference.
	 * @see #setPopulationGroups(StringValueList)
	 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage#getMultiPopulationSIDiseaseModel_PopulationGroups()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StringValueList getPopulationGroups();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel#getPopulationGroups <em>Population Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population Groups</em>' containment reference.
	 * @see #getPopulationGroups()
	 * @generated
	 */
	void setPopulationGroups(StringValueList value);
} // MultiPopulationSIDiseaseModel

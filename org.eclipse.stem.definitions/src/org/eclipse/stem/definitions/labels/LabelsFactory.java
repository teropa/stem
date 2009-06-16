package org.eclipse.stem.definitions.labels;

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.definitions.labels.LabelsPackage
 * @generated
 */
public interface LabelsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LabelsFactory eINSTANCE = org.eclipse.stem.definitions.labels.impl.LabelsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Area Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Label</em>'.
	 * @generated
	 */
	AreaLabel createAreaLabel();

	/**
	 * Returns a new object of class '<em>Area Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Label Value</em>'.
	 * @generated
	 */
	AreaLabelValue createAreaLabelValue();

	/**
	 * Returns a new object of class '<em>Common Border Relationship Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Common Border Relationship Label</em>'.
	 * @generated
	 */
	CommonBorderRelationshipLabel createCommonBorderRelationshipLabel();

	/**
	 * Returns a new object of class '<em>Common Border Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Common Border Relationship Label Value</em>'.
	 * @generated
	 */
	CommonBorderRelationshipLabelValue createCommonBorderRelationshipLabelValue();

	/**
	 * Returns a new object of class '<em>Population Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Label</em>'.
	 * @generated
	 */
	PopulationLabel createPopulationLabel();

	/**
	 * Returns a new object of class '<em>Population Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Population Label Value</em>'.
	 * @generated
	 */
	PopulationLabelValue createPopulationLabelValue();

	/**
	 * Returns a new object of class '<em>Relative Physical Relationship Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relative Physical Relationship Label</em>'.
	 * @generated
	 */
	RelativePhysicalRelationshipLabel createRelativePhysicalRelationshipLabel();

	/**
	 * Returns a new object of class '<em>Relative Physical Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relative Physical Relationship Label Value</em>'.
	 * @generated
	 */
	RelativePhysicalRelationshipLabelValue createRelativePhysicalRelationshipLabelValue();

	/**
	 * Returns a new object of class '<em>Transport Relationship Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transport Relationship Label</em>'.
	 * @generated
	 */
	TransportRelationshipLabel createTransportRelationshipLabel();

	/**
	 * Returns a new object of class '<em>Transport Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transport Relationship Label Value</em>'.
	 * @generated
	 */
	TransportRelationshipLabelValue createTransportRelationshipLabelValue();

	/**
	 * Returns a new object of class '<em>Physical Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Physical Relationship Label Value</em>'.
	 * @generated
	 */
	PhysicalRelationshipLabelValue createPhysicalRelationshipLabelValue();

	/**
	 * Returns a new object of class '<em>Road Transport Relationship Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Road Transport Relationship Label</em>'.
	 * @generated
	 */
	RoadTransportRelationshipLabel createRoadTransportRelationshipLabel();

	/**
	 * Returns a new object of class '<em>Road Transport Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Road Transport Relationship Label Value</em>'.
	 * @generated
	 */
	RoadTransportRelationshipLabelValue createRoadTransportRelationshipLabelValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LabelsPackage getLabelsPackage();

} //LabelsFactory

package org.eclipse.stem.definitions.labels.util;

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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.graph.DynamicEdgeLabel;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.StaticEdgeLabel;
import org.eclipse.stem.core.graph.StaticLabel;
import org.eclipse.stem.core.graph.StaticNodeLabel;
import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.definitions.labels.*;

import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.AreaLabelValue;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.PhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.stem.definitions.labels.LabelsPackage
 * @generated
 */
public class LabelsSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static LabelsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public LabelsSwitch() {
		if (modelPackage == null) {
			modelPackage = LabelsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * 
	 * @param theEObject
	 * 
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LabelsPackage.AREA_LABEL: {
				AreaLabel areaLabel = (AreaLabel)theEObject;
				T1 result = caseAreaLabel(areaLabel);
				if (result == null) result = caseStaticNodeLabel(areaLabel);
				if (result == null) result = caseNodeLabel(areaLabel);
				if (result == null) result = caseStaticLabel(areaLabel);
				if (result == null) result = caseLabel(areaLabel);
				if (result == null) result = caseModifiable(areaLabel);
				if (result == null) result = caseIdentifiable(areaLabel);
				if (result == null) result = caseComparable(areaLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.AREA_LABEL_VALUE: {
				AreaLabelValue areaLabelValue = (AreaLabelValue)theEObject;
				T1 result = caseAreaLabelValue(areaLabelValue);
				if (result == null) result = caseLabelValue(areaLabelValue);
				if (result == null) result = caseSanityChecker(areaLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL: {
				CommonBorderRelationshipLabel commonBorderRelationshipLabel = (CommonBorderRelationshipLabel)theEObject;
				T1 result = caseCommonBorderRelationshipLabel(commonBorderRelationshipLabel);
				if (result == null) result = casePhysicalRelationshipLabel(commonBorderRelationshipLabel);
				if (result == null) result = caseStaticEdgeLabel(commonBorderRelationshipLabel);
				if (result == null) result = caseEdgeLabel(commonBorderRelationshipLabel);
				if (result == null) result = caseStaticLabel(commonBorderRelationshipLabel);
				if (result == null) result = caseLabel(commonBorderRelationshipLabel);
				if (result == null) result = caseModifiable(commonBorderRelationshipLabel);
				if (result == null) result = caseIdentifiable(commonBorderRelationshipLabel);
				if (result == null) result = caseComparable(commonBorderRelationshipLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE: {
				CommonBorderRelationshipLabelValue commonBorderRelationshipLabelValue = (CommonBorderRelationshipLabelValue)theEObject;
				T1 result = caseCommonBorderRelationshipLabelValue(commonBorderRelationshipLabelValue);
				if (result == null) result = casePhysicalRelationshipLabelValue(commonBorderRelationshipLabelValue);
				if (result == null) result = caseLabelValue(commonBorderRelationshipLabelValue);
				if (result == null) result = caseSanityChecker(commonBorderRelationshipLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.PHYSICAL_RELATIONSHIP_LABEL: {
				PhysicalRelationshipLabel physicalRelationshipLabel = (PhysicalRelationshipLabel)theEObject;
				T1 result = casePhysicalRelationshipLabel(physicalRelationshipLabel);
				if (result == null) result = caseStaticEdgeLabel(physicalRelationshipLabel);
				if (result == null) result = caseEdgeLabel(physicalRelationshipLabel);
				if (result == null) result = caseStaticLabel(physicalRelationshipLabel);
				if (result == null) result = caseLabel(physicalRelationshipLabel);
				if (result == null) result = caseModifiable(physicalRelationshipLabel);
				if (result == null) result = caseIdentifiable(physicalRelationshipLabel);
				if (result == null) result = caseComparable(physicalRelationshipLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.POPULATION_LABEL: {
				PopulationLabel populationLabel = (PopulationLabel)theEObject;
				T1 result = casePopulationLabel(populationLabel);
				if (result == null) result = caseStaticNodeLabel(populationLabel);
				if (result == null) result = caseNodeLabel(populationLabel);
				if (result == null) result = caseStaticLabel(populationLabel);
				if (result == null) result = caseLabel(populationLabel);
				if (result == null) result = caseModifiable(populationLabel);
				if (result == null) result = caseIdentifiable(populationLabel);
				if (result == null) result = caseComparable(populationLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.POPULATION_LABEL_VALUE: {
				PopulationLabelValue populationLabelValue = (PopulationLabelValue)theEObject;
				T1 result = casePopulationLabelValue(populationLabelValue);
				if (result == null) result = caseLabelValue(populationLabelValue);
				if (result == null) result = caseSanityChecker(populationLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL: {
				RelativePhysicalRelationshipLabel relativePhysicalRelationshipLabel = (RelativePhysicalRelationshipLabel)theEObject;
				T1 result = caseRelativePhysicalRelationshipLabel(relativePhysicalRelationshipLabel);
				if (result == null) result = casePhysicalRelationshipLabel(relativePhysicalRelationshipLabel);
				if (result == null) result = caseStaticEdgeLabel(relativePhysicalRelationshipLabel);
				if (result == null) result = caseEdgeLabel(relativePhysicalRelationshipLabel);
				if (result == null) result = caseStaticLabel(relativePhysicalRelationshipLabel);
				if (result == null) result = caseLabel(relativePhysicalRelationshipLabel);
				if (result == null) result = caseModifiable(relativePhysicalRelationshipLabel);
				if (result == null) result = caseIdentifiable(relativePhysicalRelationshipLabel);
				if (result == null) result = caseComparable(relativePhysicalRelationshipLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE: {
				RelativePhysicalRelationshipLabelValue relativePhysicalRelationshipLabelValue = (RelativePhysicalRelationshipLabelValue)theEObject;
				T1 result = caseRelativePhysicalRelationshipLabelValue(relativePhysicalRelationshipLabelValue);
				if (result == null) result = caseLabelValue(relativePhysicalRelationshipLabelValue);
				if (result == null) result = caseSanityChecker(relativePhysicalRelationshipLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL: {
				TransportRelationshipLabel transportRelationshipLabel = (TransportRelationshipLabel)theEObject;
				T1 result = caseTransportRelationshipLabel(transportRelationshipLabel);
				if (result == null) result = caseDynamicEdgeLabel(transportRelationshipLabel);
				if (result == null) result = caseDynamicLabel(transportRelationshipLabel);
				if (result == null) result = caseEdgeLabel(transportRelationshipLabel);
				if (result == null) result = caseLabel(transportRelationshipLabel);
				if (result == null) result = caseIdentifiable(transportRelationshipLabel);
				if (result == null) result = caseComparable(transportRelationshipLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE: {
				TransportRelationshipLabelValue transportRelationshipLabelValue = (TransportRelationshipLabelValue)theEObject;
				T1 result = caseTransportRelationshipLabelValue(transportRelationshipLabelValue);
				if (result == null) result = caseLabelValue(transportRelationshipLabelValue);
				if (result == null) result = caseSanityChecker(transportRelationshipLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.PHYSICAL_RELATIONSHIP_LABEL_VALUE: {
				PhysicalRelationshipLabelValue physicalRelationshipLabelValue = (PhysicalRelationshipLabelValue)theEObject;
				T1 result = casePhysicalRelationshipLabelValue(physicalRelationshipLabelValue);
				if (result == null) result = caseLabelValue(physicalRelationshipLabelValue);
				if (result == null) result = caseSanityChecker(physicalRelationshipLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL: {
				RoadTransportRelationshipLabel roadTransportRelationshipLabel = (RoadTransportRelationshipLabel)theEObject;
				T1 result = caseRoadTransportRelationshipLabel(roadTransportRelationshipLabel);
				if (result == null) result = casePhysicalRelationshipLabel(roadTransportRelationshipLabel);
				if (result == null) result = caseStaticEdgeLabel(roadTransportRelationshipLabel);
				if (result == null) result = caseEdgeLabel(roadTransportRelationshipLabel);
				if (result == null) result = caseStaticLabel(roadTransportRelationshipLabel);
				if (result == null) result = caseLabel(roadTransportRelationshipLabel);
				if (result == null) result = caseModifiable(roadTransportRelationshipLabel);
				if (result == null) result = caseIdentifiable(roadTransportRelationshipLabel);
				if (result == null) result = caseComparable(roadTransportRelationshipLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE: {
				RoadTransportRelationshipLabelValue roadTransportRelationshipLabelValue = (RoadTransportRelationshipLabelValue)theEObject;
				T1 result = caseRoadTransportRelationshipLabelValue(roadTransportRelationshipLabelValue);
				if (result == null) result = casePhysicalRelationshipLabelValue(roadTransportRelationshipLabelValue);
				if (result == null) result = caseLabelValue(roadTransportRelationshipLabelValue);
				if (result == null) result = caseSanityChecker(roadTransportRelationshipLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.EARTH_SCIENCE_LABEL: {
				EarthScienceLabel earthScienceLabel = (EarthScienceLabel)theEObject;
				T1 result = caseEarthScienceLabel(earthScienceLabel);
				if (result == null) result = caseStaticNodeLabel(earthScienceLabel);
				if (result == null) result = caseNodeLabel(earthScienceLabel);
				if (result == null) result = caseStaticLabel(earthScienceLabel);
				if (result == null) result = caseLabel(earthScienceLabel);
				if (result == null) result = caseModifiable(earthScienceLabel);
				if (result == null) result = caseIdentifiable(earthScienceLabel);
				if (result == null) result = caseComparable(earthScienceLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LabelsPackage.EARTH_SCIENCE_LABEL_VALUE: {
				EarthScienceLabelValue earthScienceLabelValue = (EarthScienceLabelValue)theEObject;
				T1 result = caseEarthScienceLabelValue(earthScienceLabelValue);
				if (result == null) result = caseLabelValue(earthScienceLabelValue);
				if (result == null) result = caseSanityChecker(earthScienceLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationLabel(PopulationLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationLabelValue(PopulationLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAreaLabel(AreaLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAreaLabelValue(AreaLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Relationship Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Relationship Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePhysicalRelationshipLabel(PhysicalRelationshipLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relative Physical Relationship Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relative Physical Relationship Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRelativePhysicalRelationshipLabel(
			RelativePhysicalRelationshipLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relative Physical Relationship Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relative Physical Relationship Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRelativePhysicalRelationshipLabelValue(
			RelativePhysicalRelationshipLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Common Border Relationship Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Border Relationship Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCommonBorderRelationshipLabel(
			CommonBorderRelationshipLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Common Border Relationship Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Border Relationship Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCommonBorderRelationshipLabelValue(
			CommonBorderRelationshipLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transport Relationship Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transport Relationship Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTransportRelationshipLabel(TransportRelationshipLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transport Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transport Relationship Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTransportRelationshipLabelValue(TransportRelationshipLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Relationship Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePhysicalRelationshipLabelValue(PhysicalRelationshipLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Road Transport Relationship Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Road Transport Relationship Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRoadTransportRelationshipLabel(RoadTransportRelationshipLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Road Transport Relationship Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Road Transport Relationship Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRoadTransportRelationshipLabelValue(RoadTransportRelationshipLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Earth Science Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Earth Science Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEarthScienceLabel(EarthScienceLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Earth Science Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Earth Science Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEarthScienceLabelValue(EarthScienceLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNodeLabel(NodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticLabel(StaticLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModifiable(Modifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Node Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticNodeLabel(StaticNodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sanity Checker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sanity Checker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSanityChecker(SanityChecker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabelValue(LabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEdgeLabel(EdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStaticEdgeLabel(StaticEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicLabel(DynamicLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicEdgeLabel(DynamicEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T1 defaultCase(EObject object) {
		return null;
	}

} // LabelsSwitch

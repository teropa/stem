package org.eclipse.stem.definitions.labels.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.definitions.labels.*;

import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.AreaLabelValue;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabel;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationship;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.TransportMode;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LabelsFactoryImpl extends EFactoryImpl implements LabelsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LabelsFactory init() {
		try {
			LabelsFactory theLabelsFactory = (LabelsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/definitions/labels.ecore"); //$NON-NLS-1$ 
			if (theLabelsFactory != null) {
				return theLabelsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LabelsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LabelsPackage.AREA_LABEL: return createAreaLabel();
			case LabelsPackage.AREA_LABEL_VALUE: return createAreaLabelValue();
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL: return createCommonBorderRelationshipLabel();
			case LabelsPackage.COMMON_BORDER_RELATIONSHIP_LABEL_VALUE: return createCommonBorderRelationshipLabelValue();
			case LabelsPackage.POPULATION_LABEL: return createPopulationLabel();
			case LabelsPackage.POPULATION_LABEL_VALUE: return createPopulationLabelValue();
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL: return createRelativePhysicalRelationshipLabel();
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE: return createRelativePhysicalRelationshipLabelValue();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL: return createTransportRelationshipLabel();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL_VALUE: return createTransportRelationshipLabelValue();
			case LabelsPackage.PHYSICAL_RELATIONSHIP_LABEL_VALUE: return createPhysicalRelationshipLabelValue();
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL: return createRoadTransportRelationshipLabel();
			case LabelsPackage.ROAD_TRANSPORT_RELATIONSHIP_LABEL_VALUE: return createRoadTransportRelationshipLabelValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP:
				return createRelativePhysicalRelationshipFromString(eDataType, initialValue);
			case LabelsPackage.TRANSPORT_MODE:
				return createTransportModeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LabelsPackage.RELATIVE_PHYSICAL_RELATIONSHIP:
				return convertRelativePhysicalRelationshipToString(eDataType, instanceValue);
			case LabelsPackage.TRANSPORT_MODE:
				return convertTransportModeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLabel createAreaLabel() {
		AreaLabelImpl areaLabel = new AreaLabelImpl();
		return areaLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLabelValue createAreaLabelValue() {
		AreaLabelValueImpl areaLabelValue = new AreaLabelValueImpl();
		return areaLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonBorderRelationshipLabel createCommonBorderRelationshipLabel() {
		CommonBorderRelationshipLabelImpl commonBorderRelationshipLabel = new CommonBorderRelationshipLabelImpl();
		return commonBorderRelationshipLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonBorderRelationshipLabelValue createCommonBorderRelationshipLabelValue() {
		CommonBorderRelationshipLabelValueImpl commonBorderRelationshipLabelValue = new CommonBorderRelationshipLabelValueImpl();
		return commonBorderRelationshipLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabel createPopulationLabel() {
		PopulationLabelImpl populationLabel = new PopulationLabelImpl();
		return populationLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationLabelValue createPopulationLabelValue() {
		PopulationLabelValueImpl populationLabelValue = new PopulationLabelValueImpl();
		return populationLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelativePhysicalRelationshipLabel createRelativePhysicalRelationshipLabel() {
		RelativePhysicalRelationshipLabelImpl relativePhysicalRelationshipLabel = new RelativePhysicalRelationshipLabelImpl();
		return relativePhysicalRelationshipLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelativePhysicalRelationshipLabelValue createRelativePhysicalRelationshipLabelValue() {
		RelativePhysicalRelationshipLabelValueImpl relativePhysicalRelationshipLabelValue = new RelativePhysicalRelationshipLabelValueImpl();
		return relativePhysicalRelationshipLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRelationshipLabel createTransportRelationshipLabel() {
		TransportRelationshipLabelImpl transportRelationshipLabel = new TransportRelationshipLabelImpl();
		return transportRelationshipLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportRelationshipLabelValue createTransportRelationshipLabelValue() {
		TransportRelationshipLabelValueImpl transportRelationshipLabelValue = new TransportRelationshipLabelValueImpl();
		return transportRelationshipLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalRelationshipLabelValue createPhysicalRelationshipLabelValue() {
		PhysicalRelationshipLabelValueImpl physicalRelationshipLabelValue = new PhysicalRelationshipLabelValueImpl();
		return physicalRelationshipLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadTransportRelationshipLabel createRoadTransportRelationshipLabel() {
		RoadTransportRelationshipLabelImpl roadTransportRelationshipLabel = new RoadTransportRelationshipLabelImpl();
		return roadTransportRelationshipLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadTransportRelationshipLabelValue createRoadTransportRelationshipLabelValue() {
		RoadTransportRelationshipLabelValueImpl roadTransportRelationshipLabelValue = new RoadTransportRelationshipLabelValueImpl();
		return roadTransportRelationshipLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelativePhysicalRelationship createRelativePhysicalRelationshipFromString(EDataType eDataType, String initialValue) {
		RelativePhysicalRelationship result = RelativePhysicalRelationship.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelativePhysicalRelationshipToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportMode createTransportModeFromString(EDataType eDataType, String initialValue) {
		TransportMode result = TransportMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransportModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsPackage getLabelsPackage() {
		return (LabelsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LabelsPackage getPackage() {
		return LabelsPackage.eINSTANCE;
	}

} //LabelsFactoryImpl

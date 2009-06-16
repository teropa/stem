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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Population Label</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl#getCurrentPopulationValue <em>Current Population Value</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl#getPopulatedArea <em>Populated Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopulationLabelImpl extends StaticNodeLabelImpl implements
		PopulationLabel {
	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String populationIdentifier = POPULATION_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPopulatedArea() <em>Populated Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPopulatedArea()
	 * @generated
	 * @ordered
	 */
	protected static final double POPULATED_AREA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPopulatedArea() <em>Populated Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPopulatedArea()
	 * @generated
	 * @ordered
	 */
	protected double populatedArea = POPULATED_AREA_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected PopulationLabelImpl() {
		super();
		setTypeURI(PopulationLabel.URI_TYPE_POPULATION_LABEL);
		setPopulationIdentifier(PopulationLabel.HUMAN);
		setCurrentValue(LabelsFactory.eINSTANCE.createPopulationLabelValue());
	} // PopulationLabelImpl

	/**
	 * @param adminLevel
	 * @param countryCode
	 * @param populationIdentifier
	 * @param year
	 *            the year for which the population data is valid
	 * @param nodeCode
	 * @return the URI for a specific population label for a geographic region
	 */
	public static URI createPopulationLabelURI(final int adminLevel,
			final String countryCode, final String populationIdentifier,
			final String year, final String nodeCode) {
		final URI retValue = STEMURI
				.createURI(PopulationLabel.URI_TYPE_POPULATION_LABEL_SEGMENT
						+ "/" + countryCode + "/" + adminLevel + "/"
						+ populationIdentifier + "/" + year + "/" + nodeCode);
		return retValue;
	} // createPopulationLabelURI

	/**
	 * 
	 * @param populationIdentifier
	 *            the identifier of the population
	 * @param node
	 *            the node with the label
	 * @return the population label for the population on the node, or null if
	 *         there isn't one.
	 */
	public static PopulationLabel getPopulationLabel(
			final String populationIdentifier, final Node node) {
		PopulationLabel retValue = null;

		for (final Iterator<NodeLabel> nodeLabelIter = node.getLabels()
				.iterator(); nodeLabelIter.hasNext();) {
			final NodeLabel nodeLabel = nodeLabelIter.next();
			// Is this a PopulationLabel?
			if (nodeLabel instanceof PopulationLabel) {
				// Yes
				final PopulationLabel populationLabel = (PopulationLabel) nodeLabel;
				// The correct population?
				if (populationLabel.getPopulationIdentifier().equalsIgnoreCase(
						populationIdentifier)) {
					// Yes
					retValue = populationLabel;
					break;
				}
			}
		} // for
		return retValue;
	} // getPopulationLabel

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.POPULATION_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return populationIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newPopulationIdentifier
	 * 
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		String oldPopulationIdentifier = populationIdentifier;
		populationIdentifier = newPopulationIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.POPULATION_LABEL__POPULATION_IDENTIFIER, oldPopulationIdentifier, populationIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		// Is a name set?
		if (eIsSet(LabelsPackage.POPULATION_LABEL__NAME)) {
			return name;
		} else {
			return getPopulationIdentifier();
		}
	} // getName

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newName
	 * 
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.POPULATION_LABEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PopulationLabelValue getCurrentPopulationValue() {
		return (PopulationLabelValue) getCurrentValue();
	} // getCurrentPopulationValue

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getPopulatedArea() {
		return populatedArea;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulatedArea(double newPopulatedArea) {
		double oldPopulatedArea = populatedArea;
		populatedArea = newPopulatedArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.POPULATION_LABEL__POPULATED_AREA, oldPopulatedArea, populatedArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * @return <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.POPULATION_LABEL__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
			case LabelsPackage.POPULATION_LABEL__NAME:
				return getName();
			case LabelsPackage.POPULATION_LABEL__CURRENT_POPULATION_VALUE:
				return getCurrentPopulationValue();
			case LabelsPackage.POPULATION_LABEL__POPULATED_AREA:
				return new Double(getPopulatedArea());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param newValue
	 * 
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LabelsPackage.POPULATION_LABEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
				return;
			case LabelsPackage.POPULATION_LABEL__NAME:
				setName((String)newValue);
				return;
			case LabelsPackage.POPULATION_LABEL__POPULATED_AREA:
				setPopulatedArea(((Double)newValue).doubleValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 *            <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LabelsPackage.POPULATION_LABEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
				return;
			case LabelsPackage.POPULATION_LABEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LabelsPackage.POPULATION_LABEL__POPULATED_AREA:
				setPopulatedArea(POPULATED_AREA_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @return <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.POPULATION_LABEL__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? populationIdentifier != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(populationIdentifier);
			case LabelsPackage.POPULATION_LABEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LabelsPackage.POPULATION_LABEL__CURRENT_POPULATION_VALUE:
				return getCurrentPopulationValue() != null;
			case LabelsPackage.POPULATION_LABEL__POPULATED_AREA:
				return populatedArea != POPULATED_AREA_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(
				name == null ? populationIdentifier : name);
		result.append(" [");
		result.append(getCurrentPopulationValue().getCount());
		// Was an area extend specified?
		result
				.append(eIsSet(LabelsPackage.POPULATION_LABEL__POPULATED_AREA) ? "/"
						+ Double.toString(getPopulatedArea()) + "km^2"
						: "");
		result.append("]");
		return result.toString();
	} // toString
} // PopulationLabelImpl

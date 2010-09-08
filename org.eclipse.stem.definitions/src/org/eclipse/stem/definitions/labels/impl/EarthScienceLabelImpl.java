/*******************************************************************************
 * Copyright (c) 2009,2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.stem.definitions.labels.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl;

import org.eclipse.stem.definitions.labels.EarthScienceLabel;
import org.eclipse.stem.definitions.labels.EarthScienceLabelValue;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.LabelsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Earth Science Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.EarthScienceLabelImpl#getCurrentEarthScienceValue <em>Current Earth Science Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EarthScienceLabelImpl extends StaticNodeLabelImpl implements EarthScienceLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EarthScienceLabelImpl() {
		super();
		setCurrentValue(LabelsFactory.eINSTANCE.createEarthScienceLabelValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.EARTH_SCIENCE_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EarthScienceLabelValue getCurrentEarthScienceValue() {
		return (EarthScienceLabelValue)getCurrentValue();
	}

	/**
	 * @param adminLevel
	 * @param countryCode
	 * @param nodeCode
	 * @return the URI for a specific area label for a geographic region
	 */
	public static URI createEarthScienceLabelURI(final int adminLevel,
			final String countryCode, final String nodeCode, final String dataType) {
		final URI retValue = STEMURI.createURI(URI_TYPE_EARTH_SCIENCE_LABEL_SEGMENT
				+ "/" + countryCode + "/" + adminLevel + "/" + nodeCode+"/"+dataType);
		return retValue;
	} // createAreaLabelURI
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.EARTH_SCIENCE_LABEL__CURRENT_EARTH_SCIENCE_VALUE:
				return getCurrentEarthScienceValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.EARTH_SCIENCE_LABEL__CURRENT_EARTH_SCIENCE_VALUE:
				return getCurrentEarthScienceValue() != null;
		}
		return super.eIsSet(featureID);
	}

} //EarthScienceLabelImpl

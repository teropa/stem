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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.impl.StaticNodeLabelImpl;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.AreaLabelValue;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.LabelsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Area Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.AreaLabelImpl#getCurrentAreaValue <em>Current Area Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AreaLabelImpl extends StaticNodeLabelImpl implements AreaLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected AreaLabelImpl() {
		super();
		setCurrentValue(LabelsFactory.eINSTANCE.createAreaLabelValue());
	} // AreaLabelImpl

	/**
	 * @param adminLevel
	 * @param countryCode
	 * @param nodeCode
	 * @return the URI for a specific area label for a geographic region
	 */
	public static URI createAreaLabelURI(final int adminLevel,
			final String countryCode, final String nodeCode) {
		final URI retValue = STEMURI.createURI(URI_TYPE_AREA_LABEL_SEGMENT
				+ "/" + countryCode + "/" + adminLevel + "/" + nodeCode);
		return retValue;
	} // createAreaLabelURI

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.AREA_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AreaLabelValue getCurrentAreaValue() {
		return (AreaLabelValue) getCurrentValue();
	} // getCurrentAreaValue

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.AREA_LABEL__CURRENT_AREA_VALUE:
				return getCurrentAreaValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.AREA_LABEL__CURRENT_AREA_VALUE:
				return getCurrentAreaValue() != null;
		}
		return super.eIsSet(featureID);
	}

} // AreaLabelImpl

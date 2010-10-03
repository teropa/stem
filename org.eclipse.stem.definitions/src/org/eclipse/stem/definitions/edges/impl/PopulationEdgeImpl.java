/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.definitions.edges.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graph.impl.EdgeImpl;

import org.eclipse.stem.definitions.edges.EdgesPackage;
import org.eclipse.stem.definitions.edges.PopulationEdge;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.edges.impl.PopulationEdgeImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopulationEdgeImpl extends EdgeImpl implements PopulationEdge {
	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = "human"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdgesPackage.Literals.POPULATION_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return (String)eDynamicGet(EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER, EdgesPackage.Literals.POPULATION_EDGE__POPULATION_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		eDynamicSet(EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER, EdgesPackage.Literals.POPULATION_EDGE__POPULATION_IDENTIFIER, newPopulationIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EdgesPackage.POPULATION_EDGE__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? getPopulationIdentifier() != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(getPopulationIdentifier());
		}
		return super.eIsSet(featureID);
	}

} //PopulationEdgeImpl

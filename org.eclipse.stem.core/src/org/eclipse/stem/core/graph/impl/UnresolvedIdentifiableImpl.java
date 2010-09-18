package org.eclipse.stem.core.graph.impl;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.UnresolvedIdentifiable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unresolved Identifiable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl#getIdentifiable <em>Identifiable</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl#getUnresolvedURI <em>Unresolved URI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.UnresolvedIdentifiableImpl#getFieldName <em>Field Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnresolvedIdentifiableImpl extends EObjectImpl implements
		UnresolvedIdentifiable {
	/**
	 * The default value of the '{@link #getUnresolvedURI() <em>Unresolved URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUnresolvedURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI UNRESOLVED_URI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnresolvedIdentifiableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getScenario() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__SCENARIO, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetScenario() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__SCENARIO, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenario(Identifiable newScenario) {
		eDynamicSet(GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__SCENARIO, newScenario);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getModel() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__MODEL, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetModel() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__MODEL, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Identifiable newModel) {
		eDynamicSet(GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__MODEL, newModel);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getGraph() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__GRAPH, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetGraph() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__GRAPH, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Identifiable newGraph) {
		eDynamicSet(GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__GRAPH, newGraph);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getIdentifiable() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetIdentifiable() {
		return (Identifiable)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, false, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifiable(Identifiable newIdentifiable) {
		eDynamicSet(GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, newIdentifiable);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getUnresolvedURI() {
		return (URI)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnresolvedURI(URI newUnresolvedURI) {
		eDynamicSet(GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI, newUnresolvedURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return (String)eDynamicGet(GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__FIELD_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		eDynamicSet(GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME, GraphPackage.Literals.UNRESOLVED_IDENTIFIABLE__FIELD_NAME, newFieldName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO:
				if (resolve) return getScenario();
				return basicGetScenario();
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH:
				if (resolve) return getGraph();
				return basicGetGraph();
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE:
				if (resolve) return getIdentifiable();
				return basicGetIdentifiable();
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI:
				return getUnresolvedURI();
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME:
				return getFieldName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO:
				setScenario((Identifiable)newValue);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL:
				setModel((Identifiable)newValue);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH:
				setGraph((Identifiable)newValue);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE:
				setIdentifiable((Identifiable)newValue);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI:
				setUnresolvedURI((URI)newValue);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME:
				setFieldName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO:
				setScenario((Identifiable)null);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL:
				setModel((Identifiable)null);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH:
				setGraph((Identifiable)null);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE:
				setIdentifiable((Identifiable)null);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI:
				setUnresolvedURI(UNRESOLVED_URI_EDEFAULT);
				return;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO:
				return basicGetScenario() != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL:
				return basicGetModel() != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH:
				return basicGetGraph() != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE:
				return basicGetIdentifiable() != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI:
				return UNRESOLVED_URI_EDEFAULT == null ? getUnresolvedURI() != null : !UNRESOLVED_URI_EDEFAULT.equals(getUnresolvedURI());
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? getFieldName() != null : !FIELD_NAME_EDEFAULT.equals(getFieldName());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(getIdentifiable().toString());
		result.append(", unresolved URI: ");
		result.append(getUnresolvedURI());
		result.append(", fieldName: ");
		result.append(getFieldName());
		return result.toString();
	} // toString

} // UnresolvedIdentifiableImpl

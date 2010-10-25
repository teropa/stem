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
 
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected Identifiable scenario;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Identifiable model;

	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Identifiable graph;

	/**
	 * The cached value of the '{@link #getIdentifiable() <em>Identifiable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiable()
	 * @generated
	 * @ordered
	 */
	protected Identifiable identifiable;

	/**
	 * The default value of the '{@link #getUnresolvedURI() <em>Unresolved URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUnresolvedURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI UNRESOLVED_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnresolvedURI() <em>Unresolved URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedURI()
	 * @generated
	 * @ordered
	 */
	protected URI unresolvedURI = UNRESOLVED_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getScenario() {
		if (scenario != null && scenario.eIsProxy()) {
			InternalEObject oldScenario = (InternalEObject)scenario;
			scenario = (Identifiable)eResolveProxy(oldScenario);
			if (scenario != oldScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO, oldScenario, scenario));
			}
		}
		return scenario;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetScenario() {
		return scenario;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenario(Identifiable newScenario) {
		Identifiable oldScenario = scenario;
		scenario = newScenario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.UNRESOLVED_IDENTIFIABLE__SCENARIO, oldScenario, scenario));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (Identifiable)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Identifiable newModel) {
		Identifiable oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getGraph() {
		if (graph != null && graph.eIsProxy()) {
			InternalEObject oldGraph = (InternalEObject)graph;
			graph = (Identifiable)eResolveProxy(oldGraph);
			if (graph != oldGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH, oldGraph, graph));
			}
		}
		return graph;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Identifiable newGraph) {
		Identifiable oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH, oldGraph, graph));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable getIdentifiable() {
		if (identifiable != null && identifiable.eIsProxy()) {
			InternalEObject oldIdentifiable = (InternalEObject)identifiable;
			identifiable = (Identifiable)eResolveProxy(oldIdentifiable);
			if (identifiable != oldIdentifiable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, oldIdentifiable, identifiable));
			}
		}
		return identifiable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Identifiable basicGetIdentifiable() {
		return identifiable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifiable(Identifiable newIdentifiable) {
		Identifiable oldIdentifiable = identifiable;
		identifiable = newIdentifiable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE, oldIdentifiable, identifiable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getUnresolvedURI() {
		return unresolvedURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnresolvedURI(URI newUnresolvedURI) {
		URI oldUnresolvedURI = unresolvedURI;
		unresolvedURI = newUnresolvedURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI, oldUnresolvedURI, unresolvedURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME, oldFieldName, fieldName));
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
				return scenario != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__MODEL:
				return model != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__GRAPH:
				return graph != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__IDENTIFIABLE:
				return identifiable != null;
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__UNRESOLVED_URI:
				return UNRESOLVED_URI_EDEFAULT == null ? unresolvedURI != null : !UNRESOLVED_URI_EDEFAULT.equals(unresolvedURI);
			case GraphPackage.UNRESOLVED_IDENTIFIABLE__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
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

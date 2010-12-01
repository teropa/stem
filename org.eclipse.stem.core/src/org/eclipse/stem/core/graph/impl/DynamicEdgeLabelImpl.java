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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.DynamicEdgeLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.GraphPackage;

//import org.eclipse.stem.core.model.Decorator;
//import org.eclipse.stem.core.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.impl.DynamicEdgeLabelImpl#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DynamicEdgeLabelImpl extends DynamicLabelImpl implements DynamicEdgeLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicEdgeLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.DYNAMIC_EDGE_LABEL;
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#getIdentifiable()
	 */
	@Override
	public Identifiable getIdentifiable() {
		return getEdge();
	} // getIdentifiable

	
	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#setIdentifiable(org.eclipse.stem.core.common.Identifiable)
	 */
	@Override
	public void setIdentifiable(Identifiable newIdentifiable) {
		setEdge((Edge)newIdentifiable);
	} // setIdentifiable
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge() {
		if (eContainerFeatureID() != GraphPackage.DYNAMIC_EDGE_LABEL__EDGE) return null;
		return (Edge)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdge(Edge newEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEdge, GraphPackage.DYNAMIC_EDGE_LABEL__EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(Edge newEdge) {
		if (newEdge != eInternalContainer() || (eContainerFeatureID() != GraphPackage.DYNAMIC_EDGE_LABEL__EDGE && newEdge != null)) {
			if (EcoreUtil.isAncestor(this, newEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEdge != null)
				msgs = ((InternalEObject)newEdge).eInverseAdd(this, GraphPackage.EDGE__LABEL, Edge.class, msgs);
			msgs = basicSetEdge(newEdge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.DYNAMIC_EDGE_LABEL__EDGE, newEdge, newEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEdge((Edge)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				return basicSetEdge(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				return eInternalContainer().eInverseRemove(this, GraphPackage.EDGE__LABEL, Edge.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				return getEdge();
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
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				setEdge((Edge)newValue);
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
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				setEdge((Edge)null);
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
			case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE:
				return getEdge() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EdgeLabel.class) {
			switch (derivedFeatureID) {
				case GraphPackage.DYNAMIC_EDGE_LABEL__EDGE: return GraphPackage.EDGE_LABEL__EDGE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EdgeLabel.class) {
			switch (baseFeatureID) {
				case GraphPackage.EDGE_LABEL__EDGE: return GraphPackage.DYNAMIC_EDGE_LABEL__EDGE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //DynamicEdgeLabelImpl
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

//import org.eclipse.emf.common.notify.Notification;

//import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.StaticEdgeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class StaticEdgeLabelImpl extends EdgeLabelImpl implements StaticEdgeLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticEdgeLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.STATIC_EDGE_LABEL;
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

} //StaticEdgeLabelImpl
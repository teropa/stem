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
//import org.eclipse.emf.ecore.InternalEObject;
//import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Node;
//import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.StaticNodeLabel;
//import org.eclipse.stem.core.modifier.Modifiable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Node Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class StaticNodeLabelImpl extends NodeLabelImpl implements StaticNodeLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticNodeLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.STATIC_NODE_LABEL;
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#getIdentifiable()
	 */
	@Override
	public Identifiable getIdentifiable() {
		return getNode();
	} // getIdentifiable

	
	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#setIdentifiable(org.eclipse.stem.core.common.Identifiable)
	 */
	@Override
	public void setIdentifiable(Identifiable newIdentifiable) {
		super.setIdentifiable(newIdentifiable);
		setNode((Node)newIdentifiable);
	} // setIdentifiable

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		
		retValue = retValue && getNode() != null ? getURIOfIdentifiableToBeLabeled()
				.equals(getNode().getURI())
				: true;
		assert retValue;
			
		retValue = retValue && getNode() == getIdentifiable();
		assert retValue;
		
		return retValue;
	} // sane
	
} //StaticNodeLabelImpl
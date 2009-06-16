package org.eclipse.stem.definitions.transport.impl;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.graph.impl.NodeImpl;
import org.eclipse.stem.definitions.transport.TransportPackage;
import org.eclipse.stem.definitions.transport.TransportSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TransportSystemImpl extends NodeImpl implements TransportSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TransportSystemImpl() {
		super();				
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.TRANSPORT_SYSTEM;
	}
	
	/**
	 * Make sure that this transport system is sane(). That is that it has all of the properties that
	 * a transport system must have...namely some population label.
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		
//		// A Transportation System should have a population label
		// Not clear that this is true
//		retValue = false;
//		for (NodeLabel l:this.getLabels()) {
//			// Found a population label?
//			if (l instanceof PopulationLabel) {
//				// Yes
//				retValue = true;
//				break;
//			} // if PopulationLabel
//		}
//		assert retValue;
		return retValue;
	} // sane

} //TransportSystemImpl

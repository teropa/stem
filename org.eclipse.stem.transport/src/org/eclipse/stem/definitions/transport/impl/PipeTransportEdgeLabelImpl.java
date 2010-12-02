package org.eclipse.stem.definitions.transport.impl;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.graph.impl.EdgeLabelImpl;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipe Transport Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PipeTransportEdgeLabelImpl extends EdgeLabelImpl implements PipeTransportEdgeLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdgeLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PIPE_TRANSPORT_EDGE_LABEL;
	}

} //PipeTransportEdgeLabelImpl

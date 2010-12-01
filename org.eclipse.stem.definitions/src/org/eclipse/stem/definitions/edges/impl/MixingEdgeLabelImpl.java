package org.eclipse.stem.definitions.edges.impl;

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
import org.eclipse.stem.core.graph.impl.EdgeLabelImpl;
import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.EdgesPackage;
import org.eclipse.stem.definitions.edges.MixingEdgeLabel;
import org.eclipse.stem.definitions.edges.MixingEdgeLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixing Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MixingEdgeLabelImpl extends EdgeLabelImpl implements MixingEdgeLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MixingEdgeLabelImpl() {
		super();
		
		//set the MixingEdgeLabel
		setCurrentValue(EdgesFactory.eINSTANCE.createMixingEdgeLabelValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdgesPackage.Literals.MIXING_EDGE_LABEL;
	}
	
	/**
	 * Methods need to make this return edge labels properly
	 */
	@Override
	public MixingEdgeLabelValue getCurrentValue() {
		return (MixingEdgeLabelValue)super.getCurrentValue();
	}
	public void setCurrentValue(MixingEdgeLabelValue val) {
		super.setCurrentValue(val);
	}

} //MixingEdgeLabelImpl

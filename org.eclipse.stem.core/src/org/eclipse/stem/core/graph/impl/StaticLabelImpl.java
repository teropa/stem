package org.eclipse.stem.core.graph.impl;

/******************************************************************************* 
 * Copyright (c) 2008 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     IBM Corporation - initial API and implementation 
 *******************************************************************************/
 
import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.StaticLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class StaticLabelImpl extends LabelImpl implements StaticLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.STATIC_LABEL;
	}

} //StaticLabelImpl

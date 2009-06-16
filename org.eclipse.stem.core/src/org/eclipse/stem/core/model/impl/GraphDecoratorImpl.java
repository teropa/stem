package org.eclipse.stem.core.model.impl;

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
 
import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.model.GraphDecorator;
import org.eclipse.stem.core.model.ModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Graph Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GraphDecoratorImpl extends DecoratorImpl implements GraphDecorator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.GRAPH_DECORATOR;
	}

	/**
	 * @see org.eclipse.stem.model.impl.DecoratorImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		return retValue;
	} // sane
} // GraphDecoratorImpl

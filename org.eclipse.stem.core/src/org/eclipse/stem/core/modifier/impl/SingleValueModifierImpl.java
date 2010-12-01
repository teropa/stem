package org.eclipse.stem.core.modifier.impl;

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
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.SingleValueModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Value Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SingleValueModifierImpl extends FeatureModifierImpl implements SingleValueModifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleValueModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.SINGLE_VALUE_MODIFIER;
	}

} //SingleValueModifierImpl

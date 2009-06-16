package org.eclipse.stem.core.modifier.impl;

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
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.RangeModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class RangeModifierImpl extends FeatureModifierImpl implements RangeModifier {
	

	/**
	 * If <code>true</code> then the modifier has completed
	 * @see DoubleRangeModifierImpl#getNextValue()
	 */
	protected boolean complete = false;

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeModifierImpl() {
		super();
	}

	
	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#isComplete()
	 */
	@Override
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#reset()
	 */
	@Override
	public void reset() {
		complete = false;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.RANGE_MODIFIER;
	}

} //RangeModifierImpl

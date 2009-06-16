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
import org.eclipse.stem.core.modifier.NOPModifier;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>NOP Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NOPModifierImpl extends FeatureModifierImpl implements
		NOPModifier {
	
	/**
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#reset()
	 */
	public void reset() {
		// Nothing to do		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NOPModifierImpl() {
		super();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#isComplete()
	 */
	@Override
	public boolean isComplete() {
		return true;
	}

	/**
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#updateFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void updateFeature() {
		// do nothing
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.NOP_MODIFIER;
	}

} // NOPModifierImpl

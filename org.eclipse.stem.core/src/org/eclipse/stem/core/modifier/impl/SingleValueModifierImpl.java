/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.modifier.impl;

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

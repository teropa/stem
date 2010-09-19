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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#getEStructuralFeature <em>EStructural Feature</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#getFeatureId <em>Feature Id</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#getCurrentValueText <em>Current Value Text</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl#isComplete <em>Complete</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureModifierImpl extends CDOObjectImpl implements FeatureModifier {
	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureId()
	 * @generated
	 * @ordered
	 */
	protected static final int FEATURE_ID_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getCurrentValueText() <em>Current Value Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValueText()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_VALUE_TEXT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.FEATURE_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getModificationSummary() {
		try {
			final StringBuilder sb = new StringBuilder(getEStructuralFeature().getName());
			sb.append(" = ");
			sb.append(getCurrentValueText());
			return sb.toString();
		} catch (RuntimeException e) {
			return "foo";
		}
	} // getModificationSummary

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public boolean isComplete();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EStructuralFeature getEStructuralFeature() {
		// Is it set yet?
		if (!eDynamicIsSet(ModifierPackage.eINSTANCE.getFeatureModifier_EStructuralFeature())) {
			// No			
			eDynamicSet(ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, ModifierPackage.Literals.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, getTarget().eClass().getEStructuralFeature(getFeatureId()));
		} // if 
		
		return (EStructuralFeature)eDynamicGet(ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, ModifierPackage.Literals.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, true, true);
	} // getEStructuralFeature

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEStructuralFeature(EStructuralFeature newEStructuralFeature) {
		eDynamicSet(ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, ModifierPackage.Literals.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, newEStructuralFeature);
		// Is it null?
		if (newEStructuralFeature != null) {
			// Yes
			setFeatureId(newEStructuralFeature.getFeatureID());
			setFeatureName(newEStructuralFeature.getName());
		} // if 
		else {
			// No
			setFeatureId(FEATURE_ID_EDEFAULT);
		} // else 
	} // setEStructuralFeature

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFeatureId() {
		return (Integer)eDynamicGet(ModifierPackage.FEATURE_MODIFIER__FEATURE_ID, ModifierPackage.Literals.FEATURE_MODIFIER__FEATURE_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureId(int newFeatureId) {
		eDynamicSet(ModifierPackage.FEATURE_MODIFIER__FEATURE_ID, ModifierPackage.Literals.FEATURE_MODIFIER__FEATURE_ID, newFeatureId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eDynamicGet(ModifierPackage.FEATURE_MODIFIER__TARGET, ModifierPackage.Literals.FEATURE_MODIFIER__TARGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return (EObject)eDynamicGet(ModifierPackage.FEATURE_MODIFIER__TARGET, ModifierPackage.Literals.FEATURE_MODIFIER__TARGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eDynamicSet(ModifierPackage.FEATURE_MODIFIER__TARGET, ModifierPackage.Literals.FEATURE_MODIFIER__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return (String)eDynamicGet(ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME, ModifierPackage.Literals.FEATURE_MODIFIER__FEATURE_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		eDynamicSet(ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME, ModifierPackage.Literals.FEATURE_MODIFIER__FEATURE_NAME, newFeatureName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentValueText() {
		return (String)eDynamicGet(ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, ModifierPackage.Literals.FEATURE_MODIFIER__CURRENT_VALUE_TEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public void updateFeature();
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public void reset();

	/**
	 * @see org.eclipse.stem.core.common.SanityChecker#sane()
	 */
	public boolean sane() {
		return true;
	} // sane

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.FEATURE_MODIFIER__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE:
				return getEStructuralFeature();
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME:
				return getFeatureName();
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_ID:
				return getFeatureId();
			case ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT:
				return getCurrentValueText();
			case ModifierPackage.FEATURE_MODIFIER__COMPLETE:
				return isComplete();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifierPackage.FEATURE_MODIFIER__TARGET:
				setTarget((EObject)newValue);
				return;
			case ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE:
				setEStructuralFeature((EStructuralFeature)newValue);
				return;
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_ID:
				setFeatureId((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModifierPackage.FEATURE_MODIFIER__TARGET:
				setTarget((EObject)null);
				return;
			case ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE:
				setEStructuralFeature((EStructuralFeature)null);
				return;
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_ID:
				setFeatureId(FEATURE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModifierPackage.FEATURE_MODIFIER__TARGET:
				return basicGetTarget() != null;
			case ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE:
				return getEStructuralFeature() != null;
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? getFeatureName() != null : !FEATURE_NAME_EDEFAULT.equals(getFeatureName());
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_ID:
				return getFeatureId() != FEATURE_ID_EDEFAULT;
			case ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT:
				return CURRENT_VALUE_TEXT_EDEFAULT == null ? getCurrentValueText() != null : !CURRENT_VALUE_TEXT_EDEFAULT.equals(getCurrentValueText());
			case ModifierPackage.FEATURE_MODIFIER__COMPLETE:
				return isComplete() != COMPLETE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //FeatureModifierImpl

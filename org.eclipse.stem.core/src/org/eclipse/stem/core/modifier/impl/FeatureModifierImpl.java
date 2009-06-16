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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
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
public abstract class FeatureModifierImpl extends EObjectImpl implements FeatureModifier {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The cached value of the '{@link #getEStructuralFeature() <em>EStructural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEStructuralFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature eStructuralFeature;

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
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureId()
	 * @generated
	 * @ordered
	 */
	protected int featureId = FEATURE_ID_EDEFAULT;

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
	 * The cached value of the '{@link #getCurrentValueText() <em>Current Value Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValueText()
	 * @generated
	 * @ordered
	 */
	protected String currentValueText = CURRENT_VALUE_TEXT_EDEFAULT;

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
	 * @generated NOT
	 */
	public String getModificationSummary() {
		try {
			final StringBuilder sb = new StringBuilder(eStructuralFeature.getName());
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
		if (!eIsSet(ModifierPackage.eINSTANCE.getFeatureModifier_EStructuralFeature())) {
			// No
			eStructuralFeature = target.eClass().getEStructuralFeature(getFeatureId());
		} // if 
		
		return eStructuralFeature;
	} // getEStructuralFeature

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEStructuralFeature(EStructuralFeature newEStructuralFeature) {
		EStructuralFeature oldEStructuralFeature = eStructuralFeature;
		eStructuralFeature = newEStructuralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE, oldEStructuralFeature, eStructuralFeature));
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
		return featureId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureId(int newFeatureId) {
		int oldFeatureId = featureId;
		featureId = newFeatureId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.FEATURE_MODIFIER__FEATURE_ID, oldFeatureId, featureId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModifierPackage.FEATURE_MODIFIER__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.FEATURE_MODIFIER__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentValueText() {
		return currentValueText;
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
				return new Integer(getFeatureId());
			case ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT:
				return getCurrentValueText();
			case ModifierPackage.FEATURE_MODIFIER__COMPLETE:
				return isComplete() ? Boolean.TRUE : Boolean.FALSE;
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
				setFeatureId(((Integer)newValue).intValue());
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
				return target != null;
			case ModifierPackage.FEATURE_MODIFIER__ESTRUCTURAL_FEATURE:
				return eStructuralFeature != null;
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case ModifierPackage.FEATURE_MODIFIER__FEATURE_ID:
				return featureId != FEATURE_ID_EDEFAULT;
			case ModifierPackage.FEATURE_MODIFIER__CURRENT_VALUE_TEXT:
				return CURRENT_VALUE_TEXT_EDEFAULT == null ? currentValueText != null : !CURRENT_VALUE_TEXT_EDEFAULT.equals(currentValueText);
			case ModifierPackage.FEATURE_MODIFIER__COMPLETE:
				return isComplete() != COMPLETE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (featureName: "); //$NON-NLS-1$
		result.append(featureName);
		result.append(", featureId: "); //$NON-NLS-1$
		result.append(featureId);
		result.append(", currentValueText: "); //$NON-NLS-1$
		result.append(currentValueText);
		result.append(')');
		return result.toString();
	}

} //FeatureModifierImpl

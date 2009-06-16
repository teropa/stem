package org.eclipse.stem.core.predicate.impl;

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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.predicate.BooleanExpression;
import org.eclipse.stem.core.predicate.IdentifiablePredicateExpression;
import org.eclipse.stem.core.predicate.Predicate;
import org.eclipse.stem.core.predicate.PredicateExpression;
import org.eclipse.stem.core.predicate.PredicatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifiable Predicate Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.predicate.impl.IdentifiablePredicateExpressionImpl#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifiablePredicateExpressionImpl extends IdentifiablePredicateImpl implements IdentifiablePredicateExpression {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate predicate;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifiablePredicateExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatePackage.Literals.IDENTIFIABLE_PREDICATE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicate(Predicate newPredicate, NotificationChain msgs) {
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE, oldPredicate, newPredicate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(Predicate newPredicate) {
		if (newPredicate != predicate) {
			NotificationChain msgs = null;
			if (predicate != null)
				msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE, null, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE, null, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE, newPredicate, newPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE:
				return basicSetPredicate(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE:
				return getPredicate();
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
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE:
				setPredicate((Predicate)newValue);
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
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE:
				setPredicate((Predicate)null);
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
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE:
				return predicate != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BooleanExpression.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PredicateExpression.class) {
			switch (derivedFeatureID) {
				case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE: return PredicatePackage.PREDICATE_EXPRESSION__PREDICATE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BooleanExpression.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PredicateExpression.class) {
			switch (baseFeatureID) {
				case PredicatePackage.PREDICATE_EXPRESSION__PREDICATE: return PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @see Identifiable#compareTo(Identifiable)
	 */
	@Override
	public int compareTo(Identifiable o) {
		final ComposedAdapterFactory itemProviderFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IItemLabelProvider lp1 = (IItemLabelProvider) itemProviderFactory.adapt(
				this, IItemLabelProvider.class);
		final IItemLabelProvider lp2 = (IItemLabelProvider) itemProviderFactory.adapt(o,
				IItemLabelProvider.class);
		return lp1.getText(this).compareTo(lp2.getText(o));
	} // compareTo

	/**
	 * @see org.eclipse.stem.core.predicate.impl.IdentifiablePredicateImpl#evaluate(org.eclipse.stem.core.model.STEMTime, long, org.eclipse.stem.core.model.Decorator)
	 */
	@Override
	public boolean evaluate(STEMTime time, long timerPeriod, Decorator action) {
		boolean retValue = false;
		final Predicate predicate = getPredicate();
		// Was a predicate supplied?
		if (predicate != null) {
			// Yes
			retValue = predicate.evaluate(time, timerPeriod, action);
		}		
		return retValue;
	} // evaluate

} //IdentifiablePredicateExpressionImpl

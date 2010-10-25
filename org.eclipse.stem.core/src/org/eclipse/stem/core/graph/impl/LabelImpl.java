package org.eclipse.stem.core.graph.impl;

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
 
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
//import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.Identifiable;

import org.eclipse.stem.core.common.impl.IdentifiableImpl;
//import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.impl.LabelImpl#getURIOfIdentifiableToBeLabeled <em>URI Of Identifiable To Be Labeled</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.LabelImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.LabelImpl#getIdentifiable <em>Identifiable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LabelImpl extends IdentifiableImpl implements Label {

	/**
	 * The default value of the '{@link #getURIOfIdentifiableToBeLabeled() <em>URI Of Identifiable To Be Labeled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getURIOfIdentifiableToBeLabeled()
	 * @generated
	 * @ordered
	 */
	protected static final URI URI_OF_IDENTIFIABLE_TO_BE_LABELED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURIOfIdentifiableToBeLabeled() <em>URI Of Identifiable To Be Labeled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURIOfIdentifiableToBeLabeled()
	 * @generated
	 * @ordered
	 */
	protected URI uRIOfIdentifiableToBeLabeled = URI_OF_IDENTIFIABLE_TO_BE_LABELED_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCurrentValue() <em>Current Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected LabelValue currentValue;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected LabelImpl() {
		super();
		setURI(STEMURI.createURI(URI_TYPE_LABEL_SEGMENT + "/"
				+ STEMURI.generateUniquePart()));
		setTypeURI(Label.URI_TYPE_LABEL);
	} // LabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.LABEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LabelValue getCurrentValue() {
		return currentValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentValue(LabelValue newCurrentValue, NotificationChain msgs) {
		LabelValue oldCurrentValue = currentValue;
		currentValue = newCurrentValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__CURRENT_VALUE, oldCurrentValue, newCurrentValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(LabelValue newCurrentValue) {
		if (newCurrentValue != currentValue) {
			NotificationChain msgs = null;
			if (currentValue != null)
				msgs = ((InternalEObject)currentValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphPackage.LABEL__CURRENT_VALUE, null, msgs);
			if (newCurrentValue != null)
				msgs = ((InternalEObject)newCurrentValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphPackage.LABEL__CURRENT_VALUE, null, msgs);
			msgs = basicSetCurrentValue(newCurrentValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__CURRENT_VALUE, newCurrentValue, newCurrentValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public Identifiable getIdentifiable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Identifiable basicGetIdentifiable() {
		return getIdentifiable();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public void setIdentifiable(Identifiable newIdentifiable);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URI getURIOfIdentifiableToBeLabeled() {
		// Is it set?
		if (uRIOfIdentifiableToBeLabeled == null) {
			// No
			final Identifiable identifiable = getIdentifiable();
			// Do we have an Identifiable?
			if (identifiable != null) {
				// Yes
				return identifiable.getURI();
			}
		}
		return uRIOfIdentifiableToBeLabeled;
	} // getURIOfIdentifiableToBeLabeled

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setURIOfIdentifiableToBeLabeled(URI newURIOfIdentifiableToBeLabeled) {
		URI oldURIOfIdentifiableToBeLabeled = uRIOfIdentifiableToBeLabeled;
		uRIOfIdentifiableToBeLabeled = newURIOfIdentifiableToBeLabeled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED, oldURIOfIdentifiableToBeLabeled, uRIOfIdentifiableToBeLabeled));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.LABEL__CURRENT_VALUE:
				return basicSetCurrentValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED:
				return getURIOfIdentifiableToBeLabeled();
			case GraphPackage.LABEL__CURRENT_VALUE:
				return getCurrentValue();
			case GraphPackage.LABEL__IDENTIFIABLE:
				if (resolve) return getIdentifiable();
				return basicGetIdentifiable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED:
				setURIOfIdentifiableToBeLabeled((URI)newValue);
				return;
			case GraphPackage.LABEL__CURRENT_VALUE:
				setCurrentValue((LabelValue)newValue);
				return;
			case GraphPackage.LABEL__IDENTIFIABLE:
				setIdentifiable((Identifiable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED:
				setURIOfIdentifiableToBeLabeled(URI_OF_IDENTIFIABLE_TO_BE_LABELED_EDEFAULT);
				return;
			case GraphPackage.LABEL__CURRENT_VALUE:
				setCurrentValue((LabelValue)null);
				return;
			case GraphPackage.LABEL__IDENTIFIABLE:
				setIdentifiable((Identifiable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED:
				return URI_OF_IDENTIFIABLE_TO_BE_LABELED_EDEFAULT == null ? uRIOfIdentifiableToBeLabeled != null : !URI_OF_IDENTIFIABLE_TO_BE_LABELED_EDEFAULT.equals(uRIOfIdentifiableToBeLabeled);
			case GraphPackage.LABEL__CURRENT_VALUE:
				return currentValue != null;
			case GraphPackage.LABEL__IDENTIFIABLE:
				return basicGetIdentifiable() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();
		return getCurrentValue().toString();
	} // toString

	/**
	 * @see org.eclipse.stem.common.impl.IdentifiableImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		retValue = retValue && getCurrentValue() != null;
		assert retValue;

		retValue = retValue && getCurrentValue().sane();
		assert retValue : getURIOfIdentifiableToBeLabeled().toString();

		return retValue;
	} // sane

} // LabelImpl

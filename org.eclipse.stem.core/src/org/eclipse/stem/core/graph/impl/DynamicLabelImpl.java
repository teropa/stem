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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.ResettableAdapter;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.ModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Dynamic Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graph.impl.DynamicLabelImpl#isNextValueValid <em>Next Value Valid</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.DynamicLabelImpl#getNextValue <em>Next Value</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graph.impl.DynamicLabelImpl#getDecorator <em>Decorator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DynamicLabelImpl extends LabelImpl implements DynamicLabel {
	/**
	 * The default value of the '{@link #isNextValueValid() <em>Next Value Valid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isNextValueValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEXT_VALUE_VALID_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected DynamicLabelImpl() {
		super();
		setTypeURI(DynamicLabel.URI_TYPE_DYNAMIC_LABEL);
	} // DynamicLabelImpl

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.DYNAMIC_LABEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LabelValue getNextValue() {
		return (LabelValue)eDynamicGet(GraphPackage.DYNAMIC_LABEL__NEXT_VALUE, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextValue(LabelValue newNextValue, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newNextValue, GraphPackage.DYNAMIC_LABEL__NEXT_VALUE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValue(LabelValue newNextValue) {
		eDynamicSet(GraphPackage.DYNAMIC_LABEL__NEXT_VALUE, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE, newNextValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decorator getDecorator() {
		return (Decorator)eDynamicGet(GraphPackage.DYNAMIC_LABEL__DECORATOR, GraphPackage.Literals.DYNAMIC_LABEL__DECORATOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decorator basicGetDecorator() {
		return (Decorator)eDynamicGet(GraphPackage.DYNAMIC_LABEL__DECORATOR, GraphPackage.Literals.DYNAMIC_LABEL__DECORATOR, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDecorator(Decorator newDecorator, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newDecorator, GraphPackage.DYNAMIC_LABEL__DECORATOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecorator(Decorator newDecorator) {
		eDynamicSet(GraphPackage.DYNAMIC_LABEL__DECORATOR, GraphPackage.Literals.DYNAMIC_LABEL__DECORATOR, newDecorator);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNextValueValid() {
		return (Boolean)eDynamicGet(GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE_VALID, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValueValid(boolean newNextValueValid) {
		eDynamicSet(GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE_VALID, newNextValueValid);
	}

	/**
	 * <!-- begin-user-doc --> Set the next value valid flag to false. <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void reset() {
		getCurrentValue().reset();
		getNextValue().reset();
		setNextValueValid(false);
		// Reset any adapters that are attached to this instance
		for (Adapter adapter : eAdapters()) {
			// Is it resettable?
			if (adapter instanceof ResettableAdapter) {
				// Yes
				final ResettableAdapter resettableAdapter = (ResettableAdapter) adapter;
				resettableAdapter.reset();
			} // if ResettableAdapter
		} // for each Adapter
	} // reset

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Exchange the current value for the next value.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void switchToNextValue() {
		assert isNextValueValid();

		final LabelValue temp = getCurrentValue();
		setCurrentValue(getNextValue());
		setNextValue(temp);
		setNextValueValid(false);
	} // switchToNextValue

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.DYNAMIC_LABEL__DECORATOR:
				Decorator decorator = basicGetDecorator();
				if (decorator != null)
					msgs = ((InternalEObject)decorator).eInverseRemove(this, ModelPackage.DECORATOR__LABELS_TO_UPDATE, Decorator.class, msgs);
				return basicSetDecorator((Decorator)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE:
				return basicSetNextValue(null, msgs);
			case GraphPackage.DYNAMIC_LABEL__DECORATOR:
				return basicSetDecorator(null, msgs);
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
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID:
				return isNextValueValid();
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE:
				return getNextValue();
			case GraphPackage.DYNAMIC_LABEL__DECORATOR:
				if (resolve) return getDecorator();
				return basicGetDecorator();
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
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID:
				setNextValueValid((Boolean)newValue);
				return;
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE:
				setNextValue((LabelValue)newValue);
				return;
			case GraphPackage.DYNAMIC_LABEL__DECORATOR:
				setDecorator((Decorator)newValue);
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
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID:
				setNextValueValid(NEXT_VALUE_VALID_EDEFAULT);
				return;
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE:
				setNextValue((LabelValue)null);
				return;
			case GraphPackage.DYNAMIC_LABEL__DECORATOR:
				setDecorator((Decorator)null);
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
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID:
				return isNextValueValid() != NEXT_VALUE_VALID_EDEFAULT;
			case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE:
				return getNextValue() != null;
			case GraphPackage.DYNAMIC_LABEL__DECORATOR:
				return basicGetDecorator() != null;
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

		StringBuffer result = new StringBuffer(super.toString());

		result.append(" [");
		result.append(getNextValue().toString());
		result.append(" (");
		result.append(isNextValueValid() ? "valid" : "invalid");
		result.append(")");
		result.append("]");

		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.graph.impl.LabelImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		retValue = retValue && getNextValue() != null;
		assert retValue;

		retValue = retValue && (isNextValueValid() ? getNextValue().sane() : true);
		assert retValue;

		retValue = retValue && getDecorator() != null;
		assert retValue;
		
		return retValue;
	} // sane

} // DynamicLabelImpl

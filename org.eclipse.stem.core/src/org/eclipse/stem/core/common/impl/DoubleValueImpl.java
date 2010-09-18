package org.eclipse.stem.core.common.impl;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.DoubleValue;
import org.eclipse.stem.core.common.Identifiable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.common.impl.DoubleValueImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.core.common.impl.DoubleValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleValueImpl extends EObjectImpl implements DoubleValue {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final double VALUE_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.DOUBLE_VALUE;
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
	 * @generated
	 */
	public String getIdentifier() {
		return (String)eDynamicGet(CommonPackage.DOUBLE_VALUE__IDENTIFIER, CommonPackage.Literals.DOUBLE_VALUE__IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		eDynamicSet(CommonPackage.DOUBLE_VALUE__IDENTIFIER, CommonPackage.Literals.DOUBLE_VALUE__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValue() {
		return (Double)eDynamicGet(CommonPackage.DOUBLE_VALUE__VALUE, CommonPackage.Literals.DOUBLE_VALUE__VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(double newValue) {
		eDynamicSet(CommonPackage.DOUBLE_VALUE__VALUE, CommonPackage.Literals.DOUBLE_VALUE__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.DOUBLE_VALUE__IDENTIFIER:
				return getIdentifier();
			case CommonPackage.DOUBLE_VALUE__VALUE:
				return getValue();
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
			case CommonPackage.DOUBLE_VALUE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case CommonPackage.DOUBLE_VALUE__VALUE:
				setValue((Double)newValue);
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
			case CommonPackage.DOUBLE_VALUE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case CommonPackage.DOUBLE_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case CommonPackage.DOUBLE_VALUE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? getIdentifier() != null : !IDENTIFIER_EDEFAULT.equals(getIdentifier());
			case CommonPackage.DOUBLE_VALUE__VALUE:
				return getValue() != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	private Identifiable findIdentifiable(EObject o) {
		if(o instanceof Identifiable) return (Identifiable)o;
		if(o.eContainer() != null) return findIdentifiable(o.eContainer());
		return null;
	}
	/**
	 * Need to override to make sure modifiers can find
	 */
	@Override
	public int hashCode() {
		Identifiable id = findIdentifiable(this);
		
		
		if(id!=null) 
			return id.getURI().hashCode() ^
			this.eContainingFeature().getName().hashCode();
			
		return this.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof DoubleValueImpl)) return false;
		DoubleValueImpl dvi = (DoubleValueImpl)o;
		Identifiable id = findIdentifiable(dvi);
		Identifiable id2 = findIdentifiable(this);
		if(!id.getURI().equals(id2.getURI())) return false;
		
		// Need to make sure that the path from the identifiable
		// to here is the same
		//... todo
		return (super.equals(o));
	}
} //DoubleValueImpl

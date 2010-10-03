package automaticexperiment.impl;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import automaticexperiment.AutomaticexperimentPackage;
import automaticexperiment.ModifiableParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifiable Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getStep <em>Step</em>}</li>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link automaticexperiment.impl.ModifiableParameterImpl#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModifiableParameterImpl extends CDOObjectImpl implements ModifiableParameter {
	/**
	 * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIAL_VALUE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final double STEP_EDEFAULT = 0.0;

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
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final double LOWER_BOUND_EDEFAULT = -1.0;

	/**
	 * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final double UPPER_BOUND_EDEFAULT = -1.0;

	/**
	 * The default value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI TARGET_URI_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifiableParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER;
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
	public double getInitialValue() {
		return (Double)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__INITIAL_VALUE, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__INITIAL_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(double newInitialValue) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__INITIAL_VALUE, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__INITIAL_VALUE, newInitialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getFeature() {
		return (EStructuralFeature)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__FEATURE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeature() {
		return (EStructuralFeature)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__FEATURE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EStructuralFeature newFeature) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__FEATURE, newFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStep() {
		return (Double)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__STEP, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__STEP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStep(double newStep) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__STEP, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__STEP, newStep);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return (String)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE_NAME, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__FEATURE_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE_NAME, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__FEATURE_NAME, newFeatureName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLowerBound() {
		return (Double)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__LOWER_BOUND, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__LOWER_BOUND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(double newLowerBound) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__LOWER_BOUND, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__LOWER_BOUND, newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUpperBound() {
		return (Double)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__UPPER_BOUND, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__UPPER_BOUND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(double newUpperBound) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__UPPER_BOUND, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__UPPER_BOUND, newUpperBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTargetURI() {
		return (URI)eDynamicGet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__TARGET_URI, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__TARGET_URI, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetURI(URI newTargetURI) {
		eDynamicSet(AutomaticexperimentPackage.MODIFIABLE_PARAMETER__TARGET_URI, AutomaticexperimentPackage.Literals.MODIFIABLE_PARAMETER__TARGET_URI, newTargetURI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__INITIAL_VALUE:
				return getInitialValue();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__STEP:
				return getStep();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE_NAME:
				return getFeatureName();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__LOWER_BOUND:
				return getLowerBound();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__UPPER_BOUND:
				return getUpperBound();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__TARGET_URI:
				return getTargetURI();
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
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__INITIAL_VALUE:
				setInitialValue((Double)newValue);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__STEP:
				setStep((Double)newValue);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__LOWER_BOUND:
				setLowerBound((Double)newValue);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__UPPER_BOUND:
				setUpperBound((Double)newValue);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__TARGET_URI:
				setTargetURI((URI)newValue);
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
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__INITIAL_VALUE:
				setInitialValue(INITIAL_VALUE_EDEFAULT);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__STEP:
				setStep(STEP_EDEFAULT);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__TARGET_URI:
				setTargetURI(TARGET_URI_EDEFAULT);
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
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__INITIAL_VALUE:
				return getInitialValue() != INITIAL_VALUE_EDEFAULT;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE:
				return basicGetFeature() != null;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__STEP:
				return getStep() != STEP_EDEFAULT;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? getFeatureName() != null : !FEATURE_NAME_EDEFAULT.equals(getFeatureName());
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__LOWER_BOUND:
				return getLowerBound() != LOWER_BOUND_EDEFAULT;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__UPPER_BOUND:
				return getUpperBound() != UPPER_BOUND_EDEFAULT;
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? getTargetURI() != null : !TARGET_URI_EDEFAULT.equals(getTargetURI());
		}
		return super.eIsSet(featureID);
	}

} //ModifiableParameterImpl

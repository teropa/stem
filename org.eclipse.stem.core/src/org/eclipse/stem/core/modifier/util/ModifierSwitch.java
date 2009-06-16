package org.eclipse.stem.core.modifier.util;

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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.stem.core.common.Identifiable;

import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.modifier.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.core.modifier.ModifierPackage
 * @generated
 */
public class ModifierSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModifierPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierSwitch() {
		if (modelPackage == null) {
			modelPackage = ModifierPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModifierPackage.DOUBLE_NOP_MODIFIER: {
				DoubleNOPModifier doubleNOPModifier = (DoubleNOPModifier)theEObject;
				T1 result = caseDoubleNOPModifier(doubleNOPModifier);
				if (result == null) result = caseNOPModifier(doubleNOPModifier);
				if (result == null) result = caseFeatureModifier(doubleNOPModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.DOUBLE_RANGE_MODIFIER: {
				DoubleRangeModifier doubleRangeModifier = (DoubleRangeModifier)theEObject;
				T1 result = caseDoubleRangeModifier(doubleRangeModifier);
				if (result == null) result = caseRangeModifier(doubleRangeModifier);
				if (result == null) result = caseFeatureModifier(doubleRangeModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.DOUBLE_SEQUENCE_MODIFIER: {
				DoubleSequenceModifier doubleSequenceModifier = (DoubleSequenceModifier)theEObject;
				T1 result = caseDoubleSequenceModifier(doubleSequenceModifier);
				if (result == null) result = caseSequenceModifier(doubleSequenceModifier);
				if (result == null) result = caseFeatureModifier(doubleSequenceModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.FEATURE_MODIFIER: {
				FeatureModifier featureModifier = (FeatureModifier)theEObject;
				T1 result = caseFeatureModifier(featureModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.INTEGER_NOP_MODIFIER: {
				IntegerNOPModifier integerNOPModifier = (IntegerNOPModifier)theEObject;
				T1 result = caseIntegerNOPModifier(integerNOPModifier);
				if (result == null) result = caseNOPModifier(integerNOPModifier);
				if (result == null) result = caseFeatureModifier(integerNOPModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.INTEGER_RANGE_MODIFIER: {
				IntegerRangeModifier integerRangeModifier = (IntegerRangeModifier)theEObject;
				T1 result = caseIntegerRangeModifier(integerRangeModifier);
				if (result == null) result = caseRangeModifier(integerRangeModifier);
				if (result == null) result = caseFeatureModifier(integerRangeModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.INTEGER_SEQUENCE_MODIFIER: {
				IntegerSequenceModifier integerSequenceModifier = (IntegerSequenceModifier)theEObject;
				T1 result = caseIntegerSequenceModifier(integerSequenceModifier);
				if (result == null) result = caseSequenceModifier(integerSequenceModifier);
				if (result == null) result = caseFeatureModifier(integerSequenceModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.LONG_NOP_MODIFIER: {
				LongNOPModifier longNOPModifier = (LongNOPModifier)theEObject;
				T1 result = caseLongNOPModifier(longNOPModifier);
				if (result == null) result = caseNOPModifier(longNOPModifier);
				if (result == null) result = caseFeatureModifier(longNOPModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.LONG_RANGE_MODIFIER: {
				LongRangeModifier longRangeModifier = (LongRangeModifier)theEObject;
				T1 result = caseLongRangeModifier(longRangeModifier);
				if (result == null) result = caseRangeModifier(longRangeModifier);
				if (result == null) result = caseFeatureModifier(longRangeModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.LONG_SEQUENCE_MODIFIER: {
				LongSequenceModifier longSequenceModifier = (LongSequenceModifier)theEObject;
				T1 result = caseLongSequenceModifier(longSequenceModifier);
				if (result == null) result = caseSequenceModifier(longSequenceModifier);
				if (result == null) result = caseFeatureModifier(longSequenceModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.MODIFIER: {
				Modifier modifier = (Modifier)theEObject;
				T1 result = caseModifier(modifier);
				if (result == null) result = caseDecorator(modifier);
				if (result == null) result = caseIdentifiable(modifier);
				if (result == null) result = caseComparable(modifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.NOP_MODIFIER: {
				NOPModifier nopModifier = (NOPModifier)theEObject;
				T1 result = caseNOPModifier(nopModifier);
				if (result == null) result = caseFeatureModifier(nopModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.RANGE_MODIFIER: {
				RangeModifier rangeModifier = (RangeModifier)theEObject;
				T1 result = caseRangeModifier(rangeModifier);
				if (result == null) result = caseFeatureModifier(rangeModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STEM_TIME_NOP_MODIFIER: {
				STEMTimeNOPModifier stemTimeNOPModifier = (STEMTimeNOPModifier)theEObject;
				T1 result = caseSTEMTimeNOPModifier(stemTimeNOPModifier);
				if (result == null) result = caseNOPModifier(stemTimeNOPModifier);
				if (result == null) result = caseFeatureModifier(stemTimeNOPModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER: {
				STEMTimeRangeModifier stemTimeRangeModifier = (STEMTimeRangeModifier)theEObject;
				T1 result = caseSTEMTimeRangeModifier(stemTimeRangeModifier);
				if (result == null) result = caseRangeModifier(stemTimeRangeModifier);
				if (result == null) result = caseFeatureModifier(stemTimeRangeModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STEM_TIME_SEQUENCE_MODIFIER: {
				STEMTimeSequenceModifier stemTimeSequenceModifier = (STEMTimeSequenceModifier)theEObject;
				T1 result = caseSTEMTimeSequenceModifier(stemTimeSequenceModifier);
				if (result == null) result = caseSequenceModifier(stemTimeSequenceModifier);
				if (result == null) result = caseFeatureModifier(stemTimeSequenceModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.SEQUENCE_MODIFIER: {
				SequenceModifier sequenceModifier = (SequenceModifier)theEObject;
				T1 result = caseSequenceModifier(sequenceModifier);
				if (result == null) result = caseFeatureModifier(sequenceModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STRING_NOP_MODIFIER: {
				StringNOPModifier stringNOPModifier = (StringNOPModifier)theEObject;
				T1 result = caseStringNOPModifier(stringNOPModifier);
				if (result == null) result = caseNOPModifier(stringNOPModifier);
				if (result == null) result = caseFeatureModifier(stringNOPModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STRING_SEQUENCE_MODIFIER: {
				StringSequenceModifier stringSequenceModifier = (StringSequenceModifier)theEObject;
				T1 result = caseStringSequenceModifier(stringSequenceModifier);
				if (result == null) result = caseSequenceModifier(stringSequenceModifier);
				if (result == null) result = caseFeatureModifier(stringSequenceModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.MODIFIABLE: {
				Modifiable modifiable = (Modifiable)theEObject;
				T1 result = caseModifiable(modifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double NOP Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double NOP Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDoubleNOPModifier(DoubleNOPModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Range Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Range Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDoubleRangeModifier(DoubleRangeModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Sequence Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Sequence Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDoubleSequenceModifier(DoubleSequenceModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeatureModifier(FeatureModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer NOP Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer NOP Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegerNOPModifier(IntegerNOPModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Range Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Range Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegerRangeModifier(IntegerRangeModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Sequence Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Sequence Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegerSequenceModifier(IntegerSequenceModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long NOP Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long NOP Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLongNOPModifier(LongNOPModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Range Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Range Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLongRangeModifier(LongRangeModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Sequence Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Sequence Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLongSequenceModifier(LongSequenceModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModifier(Modifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NOP Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NOP Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNOPModifier(NOPModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRangeModifier(RangeModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STEM Time NOP Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STEM Time NOP Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSTEMTimeNOPModifier(STEMTimeNOPModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STEM Time Range Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STEM Time Range Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSTEMTimeRangeModifier(STEMTimeRangeModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STEM Time Sequence Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STEM Time Sequence Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSTEMTimeSequenceModifier(STEMTimeSequenceModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSequenceModifier(SequenceModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String NOP Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String NOP Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringNOPModifier(StringNOPModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Sequence Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Sequence Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringSequenceModifier(StringSequenceModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModifiable(Modifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDecorator(Decorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T1 defaultCase(EObject object) {
		return null;
	}

} //ModifierSwitch

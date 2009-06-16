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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
//import org.eclipse.stem.core.modifier.*;
import org.eclipse.stem.core.modifier.DoubleNOPModifier;
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.DoubleSequenceModifier;
import org.eclipse.stem.core.modifier.IntegerNOPModifier;
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.IntegerSequenceModifier;
import org.eclipse.stem.core.modifier.LongNOPModifier;
import org.eclipse.stem.core.modifier.LongRangeModifier;
import org.eclipse.stem.core.modifier.LongSequenceModifier;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.modifier.NOPModifier;
import org.eclipse.stem.core.modifier.STEMTimeNOPModifier;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;
import org.eclipse.stem.core.modifier.STEMTimeSequenceModifier;
import org.eclipse.stem.core.modifier.StringNOPModifier;
import org.eclipse.stem.core.modifier.StringSequenceModifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifierFactoryImpl extends EFactoryImpl implements ModifierFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifierFactory init() {
		try {
			ModifierFactory theModifierFactory = (ModifierFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/core/modifier.ecore"); //$NON-NLS-1$ 
			if (theModifierFactory != null) {
				return theModifierFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifierFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModifierPackage.DOUBLE_NOP_MODIFIER: return createDoubleNOPModifier();
			case ModifierPackage.DOUBLE_RANGE_MODIFIER: return createDoubleRangeModifier();
			case ModifierPackage.DOUBLE_SEQUENCE_MODIFIER: return createDoubleSequenceModifier();
			case ModifierPackage.INTEGER_NOP_MODIFIER: return createIntegerNOPModifier();
			case ModifierPackage.INTEGER_RANGE_MODIFIER: return createIntegerRangeModifier();
			case ModifierPackage.INTEGER_SEQUENCE_MODIFIER: return createIntegerSequenceModifier();
			case ModifierPackage.LONG_NOP_MODIFIER: return createLongNOPModifier();
			case ModifierPackage.LONG_RANGE_MODIFIER: return createLongRangeModifier();
			case ModifierPackage.LONG_SEQUENCE_MODIFIER: return createLongSequenceModifier();
			case ModifierPackage.MODIFIER: return createModifier();
			case ModifierPackage.NOP_MODIFIER: return createNOPModifier();
			case ModifierPackage.STEM_TIME_NOP_MODIFIER: return createSTEMTimeNOPModifier();
			case ModifierPackage.STEM_TIME_RANGE_MODIFIER: return createSTEMTimeRangeModifier();
			case ModifierPackage.STEM_TIME_SEQUENCE_MODIFIER: return createSTEMTimeSequenceModifier();
			case ModifierPackage.STRING_NOP_MODIFIER: return createStringNOPModifier();
			case ModifierPackage.STRING_SEQUENCE_MODIFIER: return createStringSequenceModifier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModifierPackage.URI:
				return createURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModifierPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleNOPModifier createDoubleNOPModifier() {
		DoubleNOPModifierImpl doubleNOPModifier = new DoubleNOPModifierImpl();
		return doubleNOPModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleRangeModifier createDoubleRangeModifier() {
		DoubleRangeModifierImpl doubleRangeModifier = new DoubleRangeModifierImpl();
		return doubleRangeModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleSequenceModifier createDoubleSequenceModifier() {
		DoubleSequenceModifierImpl doubleSequenceModifier = new DoubleSequenceModifierImpl();
		return doubleSequenceModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerNOPModifier createIntegerNOPModifier() {
		IntegerNOPModifierImpl integerNOPModifier = new IntegerNOPModifierImpl();
		return integerNOPModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerRangeModifier createIntegerRangeModifier() {
		IntegerRangeModifierImpl integerRangeModifier = new IntegerRangeModifierImpl();
		return integerRangeModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerSequenceModifier createIntegerSequenceModifier() {
		IntegerSequenceModifierImpl integerSequenceModifier = new IntegerSequenceModifierImpl();
		return integerSequenceModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongNOPModifier createLongNOPModifier() {
		LongNOPModifierImpl longNOPModifier = new LongNOPModifierImpl();
		return longNOPModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongRangeModifier createLongRangeModifier() {
		LongRangeModifierImpl longRangeModifier = new LongRangeModifierImpl();
		return longRangeModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongSequenceModifier createLongSequenceModifier() {
		LongSequenceModifierImpl longSequenceModifier = new LongSequenceModifierImpl();
		return longSequenceModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Modifier createModifier() {
		ModifierImpl modifier = new ModifierImpl();
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NOPModifier createNOPModifier() {
		NOPModifierImpl nopModifier = new NOPModifierImpl();
		return nopModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTimeNOPModifier createSTEMTimeNOPModifier() {
		STEMTimeNOPModifierImpl stemTimeNOPModifier = new STEMTimeNOPModifierImpl();
		return stemTimeNOPModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTimeRangeModifier createSTEMTimeRangeModifier() {
		STEMTimeRangeModifierImpl stemTimeRangeModifier = new STEMTimeRangeModifierImpl();
		return stemTimeRangeModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTimeSequenceModifier createSTEMTimeSequenceModifier() {
		STEMTimeSequenceModifierImpl stemTimeSequenceModifier = new STEMTimeSequenceModifierImpl();
		return stemTimeSequenceModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringNOPModifier createStringNOPModifier() {
		StringNOPModifierImpl stringNOPModifier = new StringNOPModifierImpl();
		return stringNOPModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSequenceModifier createStringSequenceModifier() {
		StringSequenceModifierImpl stringSequenceModifier = new StringSequenceModifierImpl();
		return stringSequenceModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return URI.createURI(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURIFromStringGen(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return instanceValue.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToStringGen(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierPackage getModifierPackage() {
		return (ModifierPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifierPackage getPackage() {
		return ModifierPackage.eINSTANCE;
	}

} //ModifierFactoryImpl

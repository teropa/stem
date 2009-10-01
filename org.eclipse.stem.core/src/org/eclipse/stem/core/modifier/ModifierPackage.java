package org.eclipse.stem.core.modifier;

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.stem.core.model.ModelPackage;
//import org.eclipse.stem.core.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.core.modifier.ModifierFactory
 * @model kind="package"
 * @generated
 */
public interface ModifierPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifier"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/modifier.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.modifier"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifierPackage eINSTANCE = org.eclipse.stem.core.modifier.impl.ModifierPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl <em>Feature Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getFeatureModifier()
	 * @generated
	 */
	int FEATURE_MODIFIER = 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER__TARGET = 0;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER__ESTRUCTURAL_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER__FEATURE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER__FEATURE_ID = 3;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER__CURRENT_VALUE_TEXT = 4;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER__COMPLETE = 5;

	/**
	 * The number of structural features of the '<em>Feature Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODIFIER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.NOPModifierImpl <em>NOP Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.NOPModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getNOPModifier()
	 * @generated
	 */
	int NOP_MODIFIER = 11;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER__TARGET = FEATURE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER__ESTRUCTURAL_FEATURE = FEATURE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER__FEATURE_NAME = FEATURE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER__FEATURE_ID = FEATURE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER__CURRENT_VALUE_TEXT = FEATURE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER__COMPLETE = FEATURE_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>NOP Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_MODIFIER_FEATURE_COUNT = FEATURE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.DoubleNOPModifierImpl <em>Double NOP Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.DoubleNOPModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleNOPModifier()
	 * @generated
	 */
	int DOUBLE_NOP_MODIFIER = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER__TARGET = NOP_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER__ESTRUCTURAL_FEATURE = NOP_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER__FEATURE_NAME = NOP_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER__FEATURE_ID = NOP_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER__CURRENT_VALUE_TEXT = NOP_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER__COMPLETE = NOP_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>Double NOP Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NOP_MODIFIER_FEATURE_COUNT = NOP_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.RangeModifierImpl <em>Range Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.RangeModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getRangeModifier()
	 * @generated
	 */
	int RANGE_MODIFIER = 12;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER__TARGET = FEATURE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER__ESTRUCTURAL_FEATURE = FEATURE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER__FEATURE_NAME = FEATURE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER__FEATURE_ID = FEATURE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER__CURRENT_VALUE_TEXT = FEATURE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER__COMPLETE = FEATURE_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>Range Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_MODIFIER_FEATURE_COUNT = FEATURE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.DoubleRangeModifierImpl <em>Double Range Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.DoubleRangeModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleRangeModifier()
	 * @generated
	 */
	int DOUBLE_RANGE_MODIFIER = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__TARGET = RANGE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__ESTRUCTURAL_FEATURE = RANGE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__FEATURE_NAME = RANGE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__FEATURE_ID = RANGE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__CURRENT_VALUE_TEXT = RANGE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__COMPLETE = RANGE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__START_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__END_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__INCREMENT = RANGE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__NEXT_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER__ORIGINAL_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Double Range Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_MODIFIER_FEATURE_COUNT = RANGE_MODIFIER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.SequenceModifierImpl <em>Sequence Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.SequenceModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSequenceModifier()
	 * @generated
	 */
	int SEQUENCE_MODIFIER = 16;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__TARGET = FEATURE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE = FEATURE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__FEATURE_NAME = FEATURE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__FEATURE_ID = FEATURE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT = FEATURE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__COMPLETE = FEATURE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Sequence Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__SEQUENCE_SIZE = FEATURE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Sequence Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = FEATURE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__NEXT_VALUE = FEATURE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER__ORIGINAL_VALUE = FEATURE_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sequence Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MODIFIER_FEATURE_COUNT = FEATURE_MODIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.DoubleSequenceModifierImpl <em>Double Sequence Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.DoubleSequenceModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleSequenceModifier()
	 * @generated
	 */
	int DOUBLE_SEQUENCE_MODIFIER = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__TARGET = SEQUENCE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE = SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__FEATURE_NAME = SEQUENCE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__FEATURE_ID = SEQUENCE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT = SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__COMPLETE = SEQUENCE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Sequence Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__SEQUENCE_SIZE = SEQUENCE_MODIFIER__SEQUENCE_SIZE;

	/**
	 * The feature id for the '<em><b>Current Sequence Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__NEXT_VALUE = SEQUENCE_MODIFIER__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__ORIGINAL_VALUE = SEQUENCE_MODIFIER__ORIGINAL_VALUE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER__SEQUENCE = SEQUENCE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Sequence Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SEQUENCE_MODIFIER_FEATURE_COUNT = SEQUENCE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.IntegerNOPModifierImpl <em>Integer NOP Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.IntegerNOPModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerNOPModifier()
	 * @generated
	 */
	int INTEGER_NOP_MODIFIER = 4;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER__TARGET = NOP_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER__ESTRUCTURAL_FEATURE = NOP_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER__FEATURE_NAME = NOP_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER__FEATURE_ID = NOP_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER__CURRENT_VALUE_TEXT = NOP_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER__COMPLETE = NOP_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>Integer NOP Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_NOP_MODIFIER_FEATURE_COUNT = NOP_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl <em>Integer Range Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerRangeModifier()
	 * @generated
	 */
	int INTEGER_RANGE_MODIFIER = 5;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__TARGET = RANGE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__ESTRUCTURAL_FEATURE = RANGE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__FEATURE_NAME = RANGE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__FEATURE_ID = RANGE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__CURRENT_VALUE_TEXT = RANGE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__COMPLETE = RANGE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__START_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__END_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__INCREMENT = RANGE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__NEXT_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Integer Range Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_MODIFIER_FEATURE_COUNT = RANGE_MODIFIER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.IntegerSequenceModifierImpl <em>Integer Sequence Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.IntegerSequenceModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerSequenceModifier()
	 * @generated
	 */
	int INTEGER_SEQUENCE_MODIFIER = 6;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__TARGET = SEQUENCE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE = SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__FEATURE_NAME = SEQUENCE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__FEATURE_ID = SEQUENCE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT = SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__COMPLETE = SEQUENCE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Sequence Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__SEQUENCE_SIZE = SEQUENCE_MODIFIER__SEQUENCE_SIZE;

	/**
	 * The feature id for the '<em><b>Current Sequence Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__NEXT_VALUE = SEQUENCE_MODIFIER__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__ORIGINAL_VALUE = SEQUENCE_MODIFIER__ORIGINAL_VALUE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER__SEQUENCE = SEQUENCE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Sequence Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SEQUENCE_MODIFIER_FEATURE_COUNT = SEQUENCE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.LongNOPModifierImpl <em>Long NOP Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.LongNOPModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongNOPModifier()
	 * @generated
	 */
	int LONG_NOP_MODIFIER = 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER__TARGET = NOP_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER__ESTRUCTURAL_FEATURE = NOP_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER__FEATURE_NAME = NOP_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER__FEATURE_ID = NOP_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER__CURRENT_VALUE_TEXT = NOP_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER__COMPLETE = NOP_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>Long NOP Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_NOP_MODIFIER_FEATURE_COUNT = NOP_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl <em>Long Range Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongRangeModifier()
	 * @generated
	 */
	int LONG_RANGE_MODIFIER = 8;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__TARGET = RANGE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__ESTRUCTURAL_FEATURE = RANGE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__FEATURE_NAME = RANGE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__FEATURE_ID = RANGE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__CURRENT_VALUE_TEXT = RANGE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__COMPLETE = RANGE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__START_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__END_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__INCREMENT = RANGE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__NEXT_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER__ORIGINAL_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Long Range Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_RANGE_MODIFIER_FEATURE_COUNT = RANGE_MODIFIER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.LongSequenceModifierImpl <em>Long Sequence Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.LongSequenceModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongSequenceModifier()
	 * @generated
	 */
	int LONG_SEQUENCE_MODIFIER = 9;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__TARGET = SEQUENCE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE = SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__FEATURE_NAME = SEQUENCE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__FEATURE_ID = SEQUENCE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT = SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__COMPLETE = SEQUENCE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Sequence Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__SEQUENCE_SIZE = SEQUENCE_MODIFIER__SEQUENCE_SIZE;

	/**
	 * The feature id for the '<em><b>Current Sequence Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__NEXT_VALUE = SEQUENCE_MODIFIER__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__ORIGINAL_VALUE = SEQUENCE_MODIFIER__ORIGINAL_VALUE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER__SEQUENCE = SEQUENCE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Sequence Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_SEQUENCE_MODIFIER_FEATURE_COUNT = SEQUENCE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.ModifierImpl <em>Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.ModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getModifier()
	 * @generated
	 */
	int MODIFIER = 10;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__URI = ModelPackage.DECORATOR__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__TYPE_URI = ModelPackage.DECORATOR__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__DUBLIN_CORE = ModelPackage.DECORATOR__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Labels To Update</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__LABELS_TO_UPDATE = ModelPackage.DECORATOR__LABELS_TO_UPDATE;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__GRAPH = ModelPackage.DECORATOR__GRAPH;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__ENABLED = ModelPackage.DECORATOR__ENABLED;

	/**
	 * The feature id for the '<em><b>Graph Decorated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__GRAPH_DECORATED = ModelPackage.DECORATOR__GRAPH_DECORATED;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__PROGRESS = ModelPackage.DECORATOR__PROGRESS;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__TARGET_URI = ModelPackage.DECORATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Modifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__FEATURE_MODIFIERS = ModelPackage.DECORATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER__COMPLETE = ModelPackage.DECORATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_FEATURE_COUNT = ModelPackage.DECORATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeNOPModifierImpl <em>STEM Time NOP Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.STEMTimeNOPModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeNOPModifier()
	 * @generated
	 */
	int STEM_TIME_NOP_MODIFIER = 13;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER__TARGET = NOP_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER__ESTRUCTURAL_FEATURE = NOP_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER__FEATURE_NAME = NOP_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER__FEATURE_ID = NOP_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER__CURRENT_VALUE_TEXT = NOP_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER__COMPLETE = NOP_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>STEM Time NOP Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_NOP_MODIFIER_FEATURE_COUNT = NOP_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl <em>STEM Time Range Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeRangeModifier()
	 * @generated
	 */
	int STEM_TIME_RANGE_MODIFIER = 14;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__TARGET = RANGE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__ESTRUCTURAL_FEATURE = RANGE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__FEATURE_NAME = RANGE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__FEATURE_ID = RANGE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__CURRENT_VALUE_TEXT = RANGE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__COMPLETE = RANGE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__START_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__END_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__INCREMENT = RANGE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__NEXT_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE = RANGE_MODIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>STEM Time Range Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_RANGE_MODIFIER_FEATURE_COUNT = RANGE_MODIFIER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeSequenceModifierImpl <em>STEM Time Sequence Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.STEMTimeSequenceModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeSequenceModifier()
	 * @generated
	 */
	int STEM_TIME_SEQUENCE_MODIFIER = 15;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__TARGET = SEQUENCE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE = SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__FEATURE_NAME = SEQUENCE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__FEATURE_ID = SEQUENCE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT = SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__COMPLETE = SEQUENCE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Sequence Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__SEQUENCE_SIZE = SEQUENCE_MODIFIER__SEQUENCE_SIZE;

	/**
	 * The feature id for the '<em><b>Current Sequence Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__NEXT_VALUE = SEQUENCE_MODIFIER__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__ORIGINAL_VALUE = SEQUENCE_MODIFIER__ORIGINAL_VALUE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER__SEQUENCE = SEQUENCE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>STEM Time Sequence Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_SEQUENCE_MODIFIER_FEATURE_COUNT = SEQUENCE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.StringNOPModifierImpl <em>String NOP Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.StringNOPModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getStringNOPModifier()
	 * @generated
	 */
	int STRING_NOP_MODIFIER = 17;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER__TARGET = NOP_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER__ESTRUCTURAL_FEATURE = NOP_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER__FEATURE_NAME = NOP_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER__FEATURE_ID = NOP_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER__CURRENT_VALUE_TEXT = NOP_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER__COMPLETE = NOP_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>String NOP Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOP_MODIFIER_FEATURE_COUNT = NOP_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.StringSequenceModifierImpl <em>String Sequence Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.StringSequenceModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getStringSequenceModifier()
	 * @generated
	 */
	int STRING_SEQUENCE_MODIFIER = 18;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__TARGET = SEQUENCE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE = SEQUENCE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__FEATURE_NAME = SEQUENCE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__FEATURE_ID = SEQUENCE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT = SEQUENCE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__COMPLETE = SEQUENCE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Sequence Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__SEQUENCE_SIZE = SEQUENCE_MODIFIER__SEQUENCE_SIZE;

	/**
	 * The feature id for the '<em><b>Current Sequence Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX;

	/**
	 * The feature id for the '<em><b>Next Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__NEXT_VALUE = SEQUENCE_MODIFIER__NEXT_VALUE;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__ORIGINAL_VALUE = SEQUENCE_MODIFIER__ORIGINAL_VALUE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER__SEQUENCE = SEQUENCE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Sequence Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SEQUENCE_MODIFIER_FEATURE_COUNT = SEQUENCE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.Modifiable <em>Modifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.Modifiable
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getModifiable()
	 * @generated
	 */
	int MODIFIABLE = 19;

	/**
	 * The number of structural features of the '<em>Modifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.SingleValueModifierImpl <em>Single Value Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.SingleValueModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSingleValueModifier()
	 * @generated
	 */
	int SINGLE_VALUE_MODIFIER = 20;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER__TARGET = FEATURE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER__ESTRUCTURAL_FEATURE = FEATURE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER__FEATURE_NAME = FEATURE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER__FEATURE_ID = FEATURE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER__CURRENT_VALUE_TEXT = FEATURE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER__COMPLETE = FEATURE_MODIFIER__COMPLETE;

	/**
	 * The number of structural features of the '<em>Single Value Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_MODIFIER_FEATURE_COUNT = FEATURE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.DoubleModifierImpl <em>Double Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.DoubleModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleModifier()
	 * @generated
	 */
	int DOUBLE_MODIFIER = 21;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__TARGET = SINGLE_VALUE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__ESTRUCTURAL_FEATURE = SINGLE_VALUE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__FEATURE_NAME = SINGLE_VALUE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__FEATURE_ID = SINGLE_VALUE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__CURRENT_VALUE_TEXT = SINGLE_VALUE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__COMPLETE = SINGLE_VALUE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER__ORIGINAL_VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_MODIFIER_FEATURE_COUNT = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.IntegerModifierImpl <em>Integer Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.IntegerModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerModifier()
	 * @generated
	 */
	int INTEGER_MODIFIER = 22;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__TARGET = SINGLE_VALUE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__ESTRUCTURAL_FEATURE = SINGLE_VALUE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__FEATURE_NAME = SINGLE_VALUE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__FEATURE_ID = SINGLE_VALUE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__CURRENT_VALUE_TEXT = SINGLE_VALUE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__COMPLETE = SINGLE_VALUE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER__ORIGINAL_VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_MODIFIER_FEATURE_COUNT = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.LongModifierImpl <em>Long Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.LongModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongModifier()
	 * @generated
	 */
	int LONG_MODIFIER = 23;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__TARGET = SINGLE_VALUE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__ESTRUCTURAL_FEATURE = SINGLE_VALUE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__FEATURE_NAME = SINGLE_VALUE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__FEATURE_ID = SINGLE_VALUE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__CURRENT_VALUE_TEXT = SINGLE_VALUE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__COMPLETE = SINGLE_VALUE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER__ORIGINAL_VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Long Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_MODIFIER_FEATURE_COUNT = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeModifierImpl <em>STEM Time Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.modifier.impl.STEMTimeModifierImpl
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeModifier()
	 * @generated
	 */
	int STEM_TIME_MODIFIER = 24;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__TARGET = SINGLE_VALUE_MODIFIER__TARGET;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__ESTRUCTURAL_FEATURE = SINGLE_VALUE_MODIFIER__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__FEATURE_NAME = SINGLE_VALUE_MODIFIER__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__FEATURE_ID = SINGLE_VALUE_MODIFIER__FEATURE_ID;

	/**
	 * The feature id for the '<em><b>Current Value Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__CURRENT_VALUE_TEXT = SINGLE_VALUE_MODIFIER__CURRENT_VALUE_TEXT;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__COMPLETE = SINGLE_VALUE_MODIFIER__COMPLETE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER__ORIGINAL_VALUE = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STEM Time Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEM_TIME_MODIFIER_FEATURE_COUNT = SINGLE_VALUE_MODIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getURI()
	 * @generated
	 */
	int URI = 25;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.DoubleNOPModifier <em>Double NOP Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double NOP Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleNOPModifier
	 * @generated
	 */
	EClass getDoubleNOPModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier <em>Double Range Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Range Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleRangeModifier
	 * @generated
	 */
	EClass getDoubleRangeModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleRangeModifier#getStartValue()
	 * @see #getDoubleRangeModifier()
	 * @generated
	 */
	EAttribute getDoubleRangeModifier_StartValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getEndValue <em>End Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Value</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleRangeModifier#getEndValue()
	 * @see #getDoubleRangeModifier()
	 * @generated
	 */
	EAttribute getDoubleRangeModifier_EndValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increment</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleRangeModifier#getIncrement()
	 * @see #getDoubleRangeModifier()
	 * @generated
	 */
	EAttribute getDoubleRangeModifier_Increment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getNextValue <em>Next Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Value</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleRangeModifier#getNextValue()
	 * @see #getDoubleRangeModifier()
	 * @generated
	 */
	EAttribute getDoubleRangeModifier_NextValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleRangeModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleRangeModifier#getOriginalValue()
	 * @see #getDoubleRangeModifier()
	 * @generated
	 */
	EAttribute getDoubleRangeModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.DoubleSequenceModifier <em>Double Sequence Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Sequence Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleSequenceModifier
	 * @generated
	 */
	EClass getDoubleSequenceModifier();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.stem.core.modifier.DoubleSequenceModifier#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sequence</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleSequenceModifier#getSequence()
	 * @see #getDoubleSequenceModifier()
	 * @generated
	 */
	EAttribute getDoubleSequenceModifier_Sequence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.FeatureModifier <em>Feature Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier
	 * @generated
	 */
	EClass getFeatureModifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.FeatureModifier#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#getTarget()
	 * @see #getFeatureModifier()
	 * @generated
	 */
	EReference getFeatureModifier_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.FeatureModifier#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#getEStructuralFeature()
	 * @see #getFeatureModifier()
	 * @generated
	 */
	EReference getFeatureModifier_EStructuralFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.FeatureModifier#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#getFeatureName()
	 * @see #getFeatureModifier()
	 * @generated
	 */
	EAttribute getFeatureModifier_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.FeatureModifier#getFeatureId <em>Feature Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Id</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#getFeatureId()
	 * @see #getFeatureModifier()
	 * @generated
	 */
	EAttribute getFeatureModifier_FeatureId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.FeatureModifier#getCurrentValueText <em>Current Value Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Value Text</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#getCurrentValueText()
	 * @see #getFeatureModifier()
	 * @generated
	 */
	EAttribute getFeatureModifier_CurrentValueText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.FeatureModifier#isComplete <em>Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see org.eclipse.stem.core.modifier.FeatureModifier#isComplete()
	 * @see #getFeatureModifier()
	 * @generated
	 */
	EAttribute getFeatureModifier_Complete();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.IntegerNOPModifier <em>Integer NOP Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer NOP Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerNOPModifier
	 * @generated
	 */
	EClass getIntegerNOPModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.IntegerRangeModifier <em>Integer Range Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Range Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerRangeModifier
	 * @generated
	 */
	EClass getIntegerRangeModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerRangeModifier#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerRangeModifier#getStartValue()
	 * @see #getIntegerRangeModifier()
	 * @generated
	 */
	EAttribute getIntegerRangeModifier_StartValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerRangeModifier#getEndValue <em>End Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Value</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerRangeModifier#getEndValue()
	 * @see #getIntegerRangeModifier()
	 * @generated
	 */
	EAttribute getIntegerRangeModifier_EndValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerRangeModifier#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increment</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerRangeModifier#getIncrement()
	 * @see #getIntegerRangeModifier()
	 * @generated
	 */
	EAttribute getIntegerRangeModifier_Increment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerRangeModifier#getNextValue <em>Next Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Value</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerRangeModifier#getNextValue()
	 * @see #getIntegerRangeModifier()
	 * @generated
	 */
	EAttribute getIntegerRangeModifier_NextValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerRangeModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerRangeModifier#getOriginalValue()
	 * @see #getIntegerRangeModifier()
	 * @generated
	 */
	EAttribute getIntegerRangeModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.IntegerSequenceModifier <em>Integer Sequence Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Sequence Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerSequenceModifier
	 * @generated
	 */
	EClass getIntegerSequenceModifier();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.stem.core.modifier.IntegerSequenceModifier#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sequence</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerSequenceModifier#getSequence()
	 * @see #getIntegerSequenceModifier()
	 * @generated
	 */
	EAttribute getIntegerSequenceModifier_Sequence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.LongNOPModifier <em>Long NOP Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long NOP Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.LongNOPModifier
	 * @generated
	 */
	EClass getLongNOPModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.LongRangeModifier <em>Long Range Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Range Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.LongRangeModifier
	 * @generated
	 */
	EClass getLongRangeModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see org.eclipse.stem.core.modifier.LongRangeModifier#getStartValue()
	 * @see #getLongRangeModifier()
	 * @generated
	 */
	EAttribute getLongRangeModifier_StartValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getEndValue <em>End Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Value</em>'.
	 * @see org.eclipse.stem.core.modifier.LongRangeModifier#getEndValue()
	 * @see #getLongRangeModifier()
	 * @generated
	 */
	EAttribute getLongRangeModifier_EndValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increment</em>'.
	 * @see org.eclipse.stem.core.modifier.LongRangeModifier#getIncrement()
	 * @see #getLongRangeModifier()
	 * @generated
	 */
	EAttribute getLongRangeModifier_Increment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getNextValue <em>Next Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Value</em>'.
	 * @see org.eclipse.stem.core.modifier.LongRangeModifier#getNextValue()
	 * @see #getLongRangeModifier()
	 * @generated
	 */
	EAttribute getLongRangeModifier_NextValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongRangeModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.LongRangeModifier#getOriginalValue()
	 * @see #getLongRangeModifier()
	 * @generated
	 */
	EAttribute getLongRangeModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.LongSequenceModifier <em>Long Sequence Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Sequence Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.LongSequenceModifier
	 * @generated
	 */
	EClass getLongSequenceModifier();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.stem.core.modifier.LongSequenceModifier#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sequence</em>'.
	 * @see org.eclipse.stem.core.modifier.LongSequenceModifier#getSequence()
	 * @see #getLongSequenceModifier()
	 * @generated
	 */
	EAttribute getLongSequenceModifier_Sequence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.Modifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.Modifier
	 * @generated
	 */
	EClass getModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.Modifier#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see org.eclipse.stem.core.modifier.Modifier#getTargetURI()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_TargetURI();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.modifier.Modifier#getFeatureModifiers <em>Feature Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Modifiers</em>'.
	 * @see org.eclipse.stem.core.modifier.Modifier#getFeatureModifiers()
	 * @see #getModifier()
	 * @generated
	 */
	EReference getModifier_FeatureModifiers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.Modifier#isComplete <em>Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see org.eclipse.stem.core.modifier.Modifier#isComplete()
	 * @see #getModifier()
	 * @generated
	 */
	EAttribute getModifier_Complete();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.NOPModifier <em>NOP Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NOP Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.NOPModifier
	 * @generated
	 */
	EClass getNOPModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.RangeModifier <em>Range Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.RangeModifier
	 * @generated
	 */
	EClass getRangeModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.STEMTimeNOPModifier <em>STEM Time NOP Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STEM Time NOP Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeNOPModifier
	 * @generated
	 */
	EClass getSTEMTimeNOPModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier <em>STEM Time Range Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STEM Time Range Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeRangeModifier
	 * @generated
	 */
	EClass getSTEMTimeRangeModifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Value</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getStartValue()
	 * @see #getSTEMTimeRangeModifier()
	 * @generated
	 */
	EReference getSTEMTimeRangeModifier_StartValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getEndValue <em>End Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Value</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getEndValue()
	 * @see #getSTEMTimeRangeModifier()
	 * @generated
	 */
	EReference getSTEMTimeRangeModifier_EndValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increment</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getIncrement()
	 * @see #getSTEMTimeRangeModifier()
	 * @generated
	 */
	EAttribute getSTEMTimeRangeModifier_Increment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getNextValue <em>Next Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Value</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getNextValue()
	 * @see #getSTEMTimeRangeModifier()
	 * @generated
	 */
	EReference getSTEMTimeRangeModifier_NextValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeRangeModifier#getOriginalValue()
	 * @see #getSTEMTimeRangeModifier()
	 * @generated
	 */
	EReference getSTEMTimeRangeModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.STEMTimeSequenceModifier <em>STEM Time Sequence Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STEM Time Sequence Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeSequenceModifier
	 * @generated
	 */
	EClass getSTEMTimeSequenceModifier();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.stem.core.modifier.STEMTimeSequenceModifier#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sequence</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeSequenceModifier#getSequence()
	 * @see #getSTEMTimeSequenceModifier()
	 * @generated
	 */
	EReference getSTEMTimeSequenceModifier_Sequence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.SequenceModifier <em>Sequence Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.SequenceModifier
	 * @generated
	 */
	EClass getSequenceModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.SequenceModifier#getSequenceSize <em>Sequence Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Size</em>'.
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#getSequenceSize()
	 * @see #getSequenceModifier()
	 * @generated
	 */
	EAttribute getSequenceModifier_SequenceSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.SequenceModifier#getCurrentSequenceIndex <em>Current Sequence Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Sequence Index</em>'.
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#getCurrentSequenceIndex()
	 * @see #getSequenceModifier()
	 * @generated
	 */
	EAttribute getSequenceModifier_CurrentSequenceIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.SequenceModifier#getNextValue <em>Next Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Value</em>'.
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#getNextValue()
	 * @see #getSequenceModifier()
	 * @generated
	 */
	EAttribute getSequenceModifier_NextValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.SequenceModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.SequenceModifier#getOriginalValue()
	 * @see #getSequenceModifier()
	 * @generated
	 */
	EAttribute getSequenceModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.StringNOPModifier <em>String NOP Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String NOP Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.StringNOPModifier
	 * @generated
	 */
	EClass getStringNOPModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.StringSequenceModifier <em>String Sequence Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Sequence Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.StringSequenceModifier
	 * @generated
	 */
	EClass getStringSequenceModifier();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.stem.core.modifier.StringSequenceModifier#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sequence</em>'.
	 * @see org.eclipse.stem.core.modifier.StringSequenceModifier#getSequence()
	 * @see #getStringSequenceModifier()
	 * @generated
	 */
	EAttribute getStringSequenceModifier_Sequence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.Modifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifiable</em>'.
	 * @see org.eclipse.stem.core.modifier.Modifiable
	 * @generated
	 */
	EClass getModifiable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.SingleValueModifier <em>Single Value Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Value Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.SingleValueModifier
	 * @generated
	 */
	EClass getSingleValueModifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.DoubleModifier <em>Double Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleModifier
	 * @generated
	 */
	EClass getDoubleModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleModifier#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleModifier#getValue()
	 * @see #getDoubleModifier()
	 * @generated
	 */
	EAttribute getDoubleModifier_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.DoubleModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.DoubleModifier#getOriginalValue()
	 * @see #getDoubleModifier()
	 * @generated
	 */
	EAttribute getDoubleModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.IntegerModifier <em>Integer Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerModifier
	 * @generated
	 */
	EClass getIntegerModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerModifier#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerModifier#getValue()
	 * @see #getIntegerModifier()
	 * @generated
	 */
	EAttribute getIntegerModifier_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.IntegerModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.IntegerModifier#getOriginalValue()
	 * @see #getIntegerModifier()
	 * @generated
	 */
	EAttribute getIntegerModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.LongModifier <em>Long Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.LongModifier
	 * @generated
	 */
	EClass getLongModifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongModifier#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.stem.core.modifier.LongModifier#getValue()
	 * @see #getLongModifier()
	 * @generated
	 */
	EAttribute getLongModifier_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.modifier.LongModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.LongModifier#getOriginalValue()
	 * @see #getLongModifier()
	 * @generated
	 */
	EAttribute getLongModifier_OriginalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.modifier.STEMTimeModifier <em>STEM Time Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STEM Time Modifier</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeModifier
	 * @generated
	 */
	EClass getSTEMTimeModifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.STEMTimeModifier#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeModifier#getValue()
	 * @see #getSTEMTimeModifier()
	 * @generated
	 */
	EReference getSTEMTimeModifier_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.modifier.STEMTimeModifier#getOriginalValue <em>Original Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Value</em>'.
	 * @see org.eclipse.stem.core.modifier.STEMTimeModifier#getOriginalValue()
	 * @see #getSTEMTimeModifier()
	 * @generated
	 */
	EReference getSTEMTimeModifier_OriginalValue();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifierFactory getModifierFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.DoubleNOPModifierImpl <em>Double NOP Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.DoubleNOPModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleNOPModifier()
		 * @generated
		 */
		EClass DOUBLE_NOP_MODIFIER = eINSTANCE.getDoubleNOPModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.DoubleRangeModifierImpl <em>Double Range Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.DoubleRangeModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleRangeModifier()
		 * @generated
		 */
		EClass DOUBLE_RANGE_MODIFIER = eINSTANCE.getDoubleRangeModifier();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_MODIFIER__START_VALUE = eINSTANCE.getDoubleRangeModifier_StartValue();

		/**
		 * The meta object literal for the '<em><b>End Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_MODIFIER__END_VALUE = eINSTANCE.getDoubleRangeModifier_EndValue();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_MODIFIER__INCREMENT = eINSTANCE.getDoubleRangeModifier_Increment();

		/**
		 * The meta object literal for the '<em><b>Next Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_MODIFIER__NEXT_VALUE = eINSTANCE.getDoubleRangeModifier_NextValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getDoubleRangeModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.DoubleSequenceModifierImpl <em>Double Sequence Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.DoubleSequenceModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleSequenceModifier()
		 * @generated
		 */
		EClass DOUBLE_SEQUENCE_MODIFIER = eINSTANCE.getDoubleSequenceModifier();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_SEQUENCE_MODIFIER__SEQUENCE = eINSTANCE.getDoubleSequenceModifier_Sequence();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.FeatureModifierImpl <em>Feature Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.FeatureModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getFeatureModifier()
		 * @generated
		 */
		EClass FEATURE_MODIFIER = eINSTANCE.getFeatureModifier();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODIFIER__TARGET = eINSTANCE.getFeatureModifier_Target();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODIFIER__ESTRUCTURAL_FEATURE = eINSTANCE.getFeatureModifier_EStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_MODIFIER__FEATURE_NAME = eINSTANCE.getFeatureModifier_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Feature Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_MODIFIER__FEATURE_ID = eINSTANCE.getFeatureModifier_FeatureId();

		/**
		 * The meta object literal for the '<em><b>Current Value Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_MODIFIER__CURRENT_VALUE_TEXT = eINSTANCE.getFeatureModifier_CurrentValueText();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_MODIFIER__COMPLETE = eINSTANCE.getFeatureModifier_Complete();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.IntegerNOPModifierImpl <em>Integer NOP Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.IntegerNOPModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerNOPModifier()
		 * @generated
		 */
		EClass INTEGER_NOP_MODIFIER = eINSTANCE.getIntegerNOPModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl <em>Integer Range Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.IntegerRangeModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerRangeModifier()
		 * @generated
		 */
		EClass INTEGER_RANGE_MODIFIER = eINSTANCE.getIntegerRangeModifier();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE_MODIFIER__START_VALUE = eINSTANCE.getIntegerRangeModifier_StartValue();

		/**
		 * The meta object literal for the '<em><b>End Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE_MODIFIER__END_VALUE = eINSTANCE.getIntegerRangeModifier_EndValue();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE_MODIFIER__INCREMENT = eINSTANCE.getIntegerRangeModifier_Increment();

		/**
		 * The meta object literal for the '<em><b>Next Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE_MODIFIER__NEXT_VALUE = eINSTANCE.getIntegerRangeModifier_NextValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getIntegerRangeModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.IntegerSequenceModifierImpl <em>Integer Sequence Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.IntegerSequenceModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerSequenceModifier()
		 * @generated
		 */
		EClass INTEGER_SEQUENCE_MODIFIER = eINSTANCE.getIntegerSequenceModifier();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_SEQUENCE_MODIFIER__SEQUENCE = eINSTANCE.getIntegerSequenceModifier_Sequence();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.LongNOPModifierImpl <em>Long NOP Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.LongNOPModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongNOPModifier()
		 * @generated
		 */
		EClass LONG_NOP_MODIFIER = eINSTANCE.getLongNOPModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl <em>Long Range Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.LongRangeModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongRangeModifier()
		 * @generated
		 */
		EClass LONG_RANGE_MODIFIER = eINSTANCE.getLongRangeModifier();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_RANGE_MODIFIER__START_VALUE = eINSTANCE.getLongRangeModifier_StartValue();

		/**
		 * The meta object literal for the '<em><b>End Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_RANGE_MODIFIER__END_VALUE = eINSTANCE.getLongRangeModifier_EndValue();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_RANGE_MODIFIER__INCREMENT = eINSTANCE.getLongRangeModifier_Increment();

		/**
		 * The meta object literal for the '<em><b>Next Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_RANGE_MODIFIER__NEXT_VALUE = eINSTANCE.getLongRangeModifier_NextValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_RANGE_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getLongRangeModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.LongSequenceModifierImpl <em>Long Sequence Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.LongSequenceModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongSequenceModifier()
		 * @generated
		 */
		EClass LONG_SEQUENCE_MODIFIER = eINSTANCE.getLongSequenceModifier();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_SEQUENCE_MODIFIER__SEQUENCE = eINSTANCE.getLongSequenceModifier_Sequence();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.ModifierImpl <em>Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.ModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getModifier()
		 * @generated
		 */
		EClass MODIFIER = eINSTANCE.getModifier();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__TARGET_URI = eINSTANCE.getModifier_TargetURI();

		/**
		 * The meta object literal for the '<em><b>Feature Modifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIER__FEATURE_MODIFIERS = eINSTANCE.getModifier_FeatureModifiers();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFIER__COMPLETE = eINSTANCE.getModifier_Complete();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.NOPModifierImpl <em>NOP Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.NOPModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getNOPModifier()
		 * @generated
		 */
		EClass NOP_MODIFIER = eINSTANCE.getNOPModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.RangeModifierImpl <em>Range Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.RangeModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getRangeModifier()
		 * @generated
		 */
		EClass RANGE_MODIFIER = eINSTANCE.getRangeModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeNOPModifierImpl <em>STEM Time NOP Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.STEMTimeNOPModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeNOPModifier()
		 * @generated
		 */
		EClass STEM_TIME_NOP_MODIFIER = eINSTANCE.getSTEMTimeNOPModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl <em>STEM Time Range Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.STEMTimeRangeModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeRangeModifier()
		 * @generated
		 */
		EClass STEM_TIME_RANGE_MODIFIER = eINSTANCE.getSTEMTimeRangeModifier();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_RANGE_MODIFIER__START_VALUE = eINSTANCE.getSTEMTimeRangeModifier_StartValue();

		/**
		 * The meta object literal for the '<em><b>End Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_RANGE_MODIFIER__END_VALUE = eINSTANCE.getSTEMTimeRangeModifier_EndValue();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEM_TIME_RANGE_MODIFIER__INCREMENT = eINSTANCE.getSTEMTimeRangeModifier_Increment();

		/**
		 * The meta object literal for the '<em><b>Next Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_RANGE_MODIFIER__NEXT_VALUE = eINSTANCE.getSTEMTimeRangeModifier_NextValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_RANGE_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getSTEMTimeRangeModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeSequenceModifierImpl <em>STEM Time Sequence Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.STEMTimeSequenceModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeSequenceModifier()
		 * @generated
		 */
		EClass STEM_TIME_SEQUENCE_MODIFIER = eINSTANCE.getSTEMTimeSequenceModifier();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_SEQUENCE_MODIFIER__SEQUENCE = eINSTANCE.getSTEMTimeSequenceModifier_Sequence();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.SequenceModifierImpl <em>Sequence Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.SequenceModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSequenceModifier()
		 * @generated
		 */
		EClass SEQUENCE_MODIFIER = eINSTANCE.getSequenceModifier();

		/**
		 * The meta object literal for the '<em><b>Sequence Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_MODIFIER__SEQUENCE_SIZE = eINSTANCE.getSequenceModifier_SequenceSize();

		/**
		 * The meta object literal for the '<em><b>Current Sequence Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_MODIFIER__CURRENT_SEQUENCE_INDEX = eINSTANCE.getSequenceModifier_CurrentSequenceIndex();

		/**
		 * The meta object literal for the '<em><b>Next Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_MODIFIER__NEXT_VALUE = eINSTANCE.getSequenceModifier_NextValue();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getSequenceModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.StringNOPModifierImpl <em>String NOP Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.StringNOPModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getStringNOPModifier()
		 * @generated
		 */
		EClass STRING_NOP_MODIFIER = eINSTANCE.getStringNOPModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.StringSequenceModifierImpl <em>String Sequence Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.StringSequenceModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getStringSequenceModifier()
		 * @generated
		 */
		EClass STRING_SEQUENCE_MODIFIER = eINSTANCE.getStringSequenceModifier();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SEQUENCE_MODIFIER__SEQUENCE = eINSTANCE.getStringSequenceModifier_Sequence();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.Modifiable <em>Modifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.Modifiable
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getModifiable()
		 * @generated
		 */
		EClass MODIFIABLE = eINSTANCE.getModifiable();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.SingleValueModifierImpl <em>Single Value Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.SingleValueModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSingleValueModifier()
		 * @generated
		 */
		EClass SINGLE_VALUE_MODIFIER = eINSTANCE.getSingleValueModifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.DoubleModifierImpl <em>Double Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.DoubleModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getDoubleModifier()
		 * @generated
		 */
		EClass DOUBLE_MODIFIER = eINSTANCE.getDoubleModifier();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_MODIFIER__VALUE = eINSTANCE.getDoubleModifier_Value();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getDoubleModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.IntegerModifierImpl <em>Integer Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.IntegerModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getIntegerModifier()
		 * @generated
		 */
		EClass INTEGER_MODIFIER = eINSTANCE.getIntegerModifier();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_MODIFIER__VALUE = eINSTANCE.getIntegerModifier_Value();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getIntegerModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.LongModifierImpl <em>Long Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.LongModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getLongModifier()
		 * @generated
		 */
		EClass LONG_MODIFIER = eINSTANCE.getLongModifier();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_MODIFIER__VALUE = eINSTANCE.getLongModifier_Value();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getLongModifier_OriginalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.modifier.impl.STEMTimeModifierImpl <em>STEM Time Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.modifier.impl.STEMTimeModifierImpl
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getSTEMTimeModifier()
		 * @generated
		 */
		EClass STEM_TIME_MODIFIER = eINSTANCE.getSTEMTimeModifier();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_MODIFIER__VALUE = eINSTANCE.getSTEMTimeModifier_Value();

		/**
		 * The meta object literal for the '<em><b>Original Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEM_TIME_MODIFIER__ORIGINAL_VALUE = eINSTANCE.getSTEMTimeModifier_OriginalValue();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.eclipse.stem.core.modifier.impl.ModifierPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //ModifierPackage

package org.eclipse.stem.core.predicate;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.stem.core.common.CommonPackage;

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
 * @see org.eclipse.stem.core.predicate.PredicateFactory
 * @model kind="package"
 * @generated
 */
public interface PredicatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "predicate"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/predicate.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.predicate"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PredicatePackage eINSTANCE = org.eclipse.stem.core.predicate.impl.PredicatePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.PredicateImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 7;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.BooleanExpressionImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.BooleanOperatorImpl <em>Boolean Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.BooleanOperatorImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getBooleanOperator()
	 * @generated
	 */
	int BOOLEAN_OPERATOR = 2;

	/**
	 * The number of structural features of the '<em>Boolean Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.NaryBooleanOperatorImpl <em>Nary Boolean Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.NaryBooleanOperatorImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getNaryBooleanOperator()
	 * @generated
	 */
	int NARY_BOOLEAN_OPERATOR = 4;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_BOOLEAN_OPERATOR__OPERANDS = BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nary Boolean Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_BOOLEAN_OPERATOR_FEATURE_COUNT = BOOLEAN_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.AndImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getAnd()
	 * @generated
	 */
	int AND = 0;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OPERANDS = NARY_BOOLEAN_OPERATOR__OPERANDS;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = NARY_BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.TestImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getTest()
	 * @generated
	 */
	int TEST = 9;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.FalseImpl <em>False</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.FalseImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getFalse()
	 * @generated
	 */
	int FALSE = 3;

	/**
	 * The number of structural features of the '<em>False</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_COUNT = TEST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.UnaryBooleanOperatorImpl <em>Unary Boolean Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.UnaryBooleanOperatorImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getUnaryBooleanOperator()
	 * @generated
	 */
	int UNARY_BOOLEAN_OPERATOR = 11;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_BOOLEAN_OPERATOR__OPERAND = BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Boolean Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_BOOLEAN_OPERATOR_FEATURE_COUNT = BOOLEAN_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.NotImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getNot()
	 * @generated
	 */
	int NOT = 5;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OPERAND = UNARY_BOOLEAN_OPERATOR__OPERAND;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.OrImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getOr()
	 * @generated
	 */
	int OR = 6;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OPERANDS = NARY_BOOLEAN_OPERATOR__OPERANDS;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = NARY_BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.PredicateReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.PredicateReferenceImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getPredicateReference()
	 * @generated
	 */
	int PREDICATE_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_REFERENCE__PREDICATE = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_REFERENCE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.TrueImpl <em>True</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.TrueImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getTrue()
	 * @generated
	 */
	int TRUE = 10;

	/**
	 * The number of structural features of the '<em>True</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_COUNT = TEST_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.PredicateExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.PredicateExpressionImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getPredicateExpression()
	 * @generated
	 */
	int PREDICATE_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EXPRESSION__PREDICATE = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.IdentifiablePredicateImpl <em>Identifiable Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.IdentifiablePredicateImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getIdentifiablePredicate()
	 * @generated
	 */
	int IDENTIFIABLE_PREDICATE = 13;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The number of structural features of the '<em>Identifiable Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.IdentifiablePredicateExpressionImpl <em>Identifiable Predicate Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.IdentifiablePredicateExpressionImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getIdentifiablePredicateExpression()
	 * @generated
	 */
	int IDENTIFIABLE_PREDICATE_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE_EXPRESSION__URI = IDENTIFIABLE_PREDICATE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE_EXPRESSION__TYPE_URI = IDENTIFIABLE_PREDICATE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE_EXPRESSION__DUBLIN_CORE = IDENTIFIABLE_PREDICATE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE_EXPRESSION__PREDICATE = IDENTIFIABLE_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifiable Predicate Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_PREDICATE_EXPRESSION_FEATURE_COUNT = IDENTIFIABLE_PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.IdentifiableTestImpl <em>Identifiable Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.IdentifiableTestImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getIdentifiableTest()
	 * @generated
	 */
	int IDENTIFIABLE_TEST = 15;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_TEST__URI = IDENTIFIABLE_PREDICATE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_TEST__TYPE_URI = IDENTIFIABLE_PREDICATE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_TEST__DUBLIN_CORE = IDENTIFIABLE_PREDICATE__DUBLIN_CORE;

	/**
	 * The number of structural features of the '<em>Identifiable Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_TEST_FEATURE_COUNT = IDENTIFIABLE_PREDICATE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.TimeTestImpl <em>Time Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.TimeTestImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getTimeTest()
	 * @generated
	 */
	int TIME_TEST = 16;

	/**
	 * The number of structural features of the '<em>Time Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TEST_FEATURE_COUNT = TEST_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.AbsoluteTimeTestImpl <em>Absolute Time Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.AbsoluteTimeTestImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getAbsoluteTimeTest()
	 * @generated
	 */
	int ABSOLUTE_TIME_TEST = 17;

	/**
	 * The feature id for the '<em><b>Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_TIME_TEST__TIME = TIME_TEST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Absolute Time Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_TIME_TEST_FEATURE_COUNT = TIME_TEST_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl <em>Elapsed Time Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl
	 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getElapsedTimeTest()
	 * @generated
	 */
	int ELAPSED_TIME_TEST = 18;

	/**
	 * The feature id for the '<em><b>Reference Time Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELAPSED_TIME_TEST__REFERENCE_TIME_VALID = TIME_TEST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elapsed Milliseconds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELAPSED_TIME_TEST__ELAPSED_MILLISECONDS = TIME_TEST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Numberof Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELAPSED_TIME_TEST__NUMBEROF_DAYS = TIME_TEST_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELAPSED_TIME_TEST__REFERENCE_TIME = TIME_TEST_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Elapsed Time Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELAPSED_TIME_TEST_FEATURE_COUNT = TIME_TEST_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see org.eclipse.stem.core.predicate.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see org.eclipse.stem.core.predicate.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.BooleanOperator <em>Boolean Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Operator</em>'.
	 * @see org.eclipse.stem.core.predicate.BooleanOperator
	 * @generated
	 */
	EClass getBooleanOperator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.False <em>False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False</em>'.
	 * @see org.eclipse.stem.core.predicate.False
	 * @generated
	 */
	EClass getFalse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.NaryBooleanOperator <em>Nary Boolean Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Boolean Operator</em>'.
	 * @see org.eclipse.stem.core.predicate.NaryBooleanOperator
	 * @generated
	 */
	EClass getNaryBooleanOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.stem.core.predicate.NaryBooleanOperator#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see org.eclipse.stem.core.predicate.NaryBooleanOperator#getOperands()
	 * @see #getNaryBooleanOperator()
	 * @generated
	 */
	EReference getNaryBooleanOperator_Operands();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see org.eclipse.stem.core.predicate.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see org.eclipse.stem.core.predicate.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see org.eclipse.stem.core.predicate.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.PredicateReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.eclipse.stem.core.predicate.PredicateReference
	 * @generated
	 */
	EClass getPredicateReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.predicate.PredicateReference#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see org.eclipse.stem.core.predicate.PredicateReference#getPredicate()
	 * @see #getPredicateReference()
	 * @generated
	 */
	EReference getPredicateReference_Predicate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see org.eclipse.stem.core.predicate.Test
	 * @generated
	 */
	EClass getTest();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.True <em>True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True</em>'.
	 * @see org.eclipse.stem.core.predicate.True
	 * @generated
	 */
	EClass getTrue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.UnaryBooleanOperator <em>Unary Boolean Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Boolean Operator</em>'.
	 * @see org.eclipse.stem.core.predicate.UnaryBooleanOperator
	 * @generated
	 */
	EClass getUnaryBooleanOperator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.predicate.UnaryBooleanOperator#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipse.stem.core.predicate.UnaryBooleanOperator#getOperand()
	 * @see #getUnaryBooleanOperator()
	 * @generated
	 */
	EReference getUnaryBooleanOperator_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.PredicateExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipse.stem.core.predicate.PredicateExpression
	 * @generated
	 */
	EClass getPredicateExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.predicate.PredicateExpression#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.eclipse.stem.core.predicate.PredicateExpression#getPredicate()
	 * @see #getPredicateExpression()
	 * @generated
	 */
	EReference getPredicateExpression_Predicate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.IdentifiablePredicate <em>Identifiable Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Predicate</em>'.
	 * @see org.eclipse.stem.core.predicate.IdentifiablePredicate
	 * @generated
	 */
	EClass getIdentifiablePredicate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.IdentifiablePredicateExpression <em>Identifiable Predicate Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Predicate Expression</em>'.
	 * @see org.eclipse.stem.core.predicate.IdentifiablePredicateExpression
	 * @generated
	 */
	EClass getIdentifiablePredicateExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.IdentifiableTest <em>Identifiable Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Test</em>'.
	 * @see org.eclipse.stem.core.predicate.IdentifiableTest
	 * @generated
	 */
	EClass getIdentifiableTest();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.TimeTest <em>Time Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Test</em>'.
	 * @see org.eclipse.stem.core.predicate.TimeTest
	 * @generated
	 */
	EClass getTimeTest();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.AbsoluteTimeTest <em>Absolute Time Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Absolute Time Test</em>'.
	 * @see org.eclipse.stem.core.predicate.AbsoluteTimeTest
	 * @generated
	 */
	EClass getAbsoluteTimeTest();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.predicate.AbsoluteTimeTest#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time</em>'.
	 * @see org.eclipse.stem.core.predicate.AbsoluteTimeTest#getTime()
	 * @see #getAbsoluteTimeTest()
	 * @generated
	 */
	EReference getAbsoluteTimeTest_Time();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.predicate.ElapsedTimeTest <em>Elapsed Time Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Elapsed Time Test</em>'.
	 * @see org.eclipse.stem.core.predicate.ElapsedTimeTest
	 * @generated
	 */
	EClass getElapsedTimeTest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.predicate.ElapsedTimeTest#isReferenceTimeValid <em>Reference Time Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Time Valid</em>'.
	 * @see org.eclipse.stem.core.predicate.ElapsedTimeTest#isReferenceTimeValid()
	 * @see #getElapsedTimeTest()
	 * @generated
	 */
	EAttribute getElapsedTimeTest_ReferenceTimeValid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.predicate.ElapsedTimeTest#getElapsedMilliseconds <em>Elapsed Milliseconds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Elapsed Milliseconds</em>'.
	 * @see org.eclipse.stem.core.predicate.ElapsedTimeTest#getElapsedMilliseconds()
	 * @see #getElapsedTimeTest()
	 * @generated
	 */
	EAttribute getElapsedTimeTest_ElapsedMilliseconds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.predicate.ElapsedTimeTest#getNumberofDays <em>Numberof Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numberof Days</em>'.
	 * @see org.eclipse.stem.core.predicate.ElapsedTimeTest#getNumberofDays()
	 * @see #getElapsedTimeTest()
	 * @generated
	 */
	EAttribute getElapsedTimeTest_NumberofDays();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.predicate.ElapsedTimeTest#getReferenceTime <em>Reference Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference Time</em>'.
	 * @see org.eclipse.stem.core.predicate.ElapsedTimeTest#getReferenceTime()
	 * @see #getElapsedTimeTest()
	 * @generated
	 */
	EReference getElapsedTimeTest_ReferenceTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PredicateFactory getPredicateFactory();

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
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.AndImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.BooleanExpressionImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.BooleanOperatorImpl <em>Boolean Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.BooleanOperatorImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getBooleanOperator()
		 * @generated
		 */
		EClass BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.FalseImpl <em>False</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.FalseImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getFalse()
		 * @generated
		 */
		EClass FALSE = eINSTANCE.getFalse();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.NaryBooleanOperatorImpl <em>Nary Boolean Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.NaryBooleanOperatorImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getNaryBooleanOperator()
		 * @generated
		 */
		EClass NARY_BOOLEAN_OPERATOR = eINSTANCE.getNaryBooleanOperator();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NARY_BOOLEAN_OPERATOR__OPERANDS = eINSTANCE.getNaryBooleanOperator_Operands();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.NotImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.OrImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.PredicateImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.PredicateReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.PredicateReferenceImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getPredicateReference()
		 * @generated
		 */
		EClass PREDICATE_REFERENCE = eINSTANCE.getPredicateReference();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_REFERENCE__PREDICATE = eINSTANCE.getPredicateReference_Predicate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.TestImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.TrueImpl <em>True</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.TrueImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getTrue()
		 * @generated
		 */
		EClass TRUE = eINSTANCE.getTrue();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.UnaryBooleanOperatorImpl <em>Unary Boolean Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.UnaryBooleanOperatorImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getUnaryBooleanOperator()
		 * @generated
		 */
		EClass UNARY_BOOLEAN_OPERATOR = eINSTANCE.getUnaryBooleanOperator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_BOOLEAN_OPERATOR__OPERAND = eINSTANCE.getUnaryBooleanOperator_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.PredicateExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.PredicateExpressionImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getPredicateExpression()
		 * @generated
		 */
		EClass PREDICATE_EXPRESSION = eINSTANCE.getPredicateExpression();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_EXPRESSION__PREDICATE = eINSTANCE.getPredicateExpression_Predicate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.IdentifiablePredicateImpl <em>Identifiable Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.IdentifiablePredicateImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getIdentifiablePredicate()
		 * @generated
		 */
		EClass IDENTIFIABLE_PREDICATE = eINSTANCE.getIdentifiablePredicate();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.IdentifiablePredicateExpressionImpl <em>Identifiable Predicate Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.IdentifiablePredicateExpressionImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getIdentifiablePredicateExpression()
		 * @generated
		 */
		EClass IDENTIFIABLE_PREDICATE_EXPRESSION = eINSTANCE.getIdentifiablePredicateExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.IdentifiableTestImpl <em>Identifiable Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.IdentifiableTestImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getIdentifiableTest()
		 * @generated
		 */
		EClass IDENTIFIABLE_TEST = eINSTANCE.getIdentifiableTest();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.TimeTestImpl <em>Time Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.TimeTestImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getTimeTest()
		 * @generated
		 */
		EClass TIME_TEST = eINSTANCE.getTimeTest();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.AbsoluteTimeTestImpl <em>Absolute Time Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.AbsoluteTimeTestImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getAbsoluteTimeTest()
		 * @generated
		 */
		EClass ABSOLUTE_TIME_TEST = eINSTANCE.getAbsoluteTimeTest();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSOLUTE_TIME_TEST__TIME = eINSTANCE.getAbsoluteTimeTest_Time();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl <em>Elapsed Time Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.predicate.impl.ElapsedTimeTestImpl
		 * @see org.eclipse.stem.core.predicate.impl.PredicatePackageImpl#getElapsedTimeTest()
		 * @generated
		 */
		EClass ELAPSED_TIME_TEST = eINSTANCE.getElapsedTimeTest();

		/**
		 * The meta object literal for the '<em><b>Reference Time Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELAPSED_TIME_TEST__REFERENCE_TIME_VALID = eINSTANCE.getElapsedTimeTest_ReferenceTimeValid();

		/**
		 * The meta object literal for the '<em><b>Elapsed Milliseconds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELAPSED_TIME_TEST__ELAPSED_MILLISECONDS = eINSTANCE.getElapsedTimeTest_ElapsedMilliseconds();

		/**
		 * The meta object literal for the '<em><b>Numberof Days</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELAPSED_TIME_TEST__NUMBEROF_DAYS = eINSTANCE.getElapsedTimeTest_NumberofDays();

		/**
		 * The meta object literal for the '<em><b>Reference Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELAPSED_TIME_TEST__REFERENCE_TIME = eINSTANCE.getElapsedTimeTest_ReferenceTime();

	}

} //PredicatePackage

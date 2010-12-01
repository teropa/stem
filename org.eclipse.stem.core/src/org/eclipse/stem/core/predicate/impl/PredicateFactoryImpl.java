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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.core.predicate.AbsoluteTimeTest;
import org.eclipse.stem.core.predicate.And;
import org.eclipse.stem.core.predicate.ElapsedTimeTest;
import org.eclipse.stem.core.predicate.False;
import org.eclipse.stem.core.predicate.IdentifiablePredicateExpression;
import org.eclipse.stem.core.predicate.Not;
import org.eclipse.stem.core.predicate.Or;
import org.eclipse.stem.core.predicate.PredicateExpression;
import org.eclipse.stem.core.predicate.PredicateFactory;
import org.eclipse.stem.core.predicate.PredicatePackage;
import org.eclipse.stem.core.predicate.PredicateReference;
import org.eclipse.stem.core.predicate.True;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PredicateFactoryImpl extends EFactoryImpl implements PredicateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PredicateFactory init() {
		try {
			PredicateFactory thePredicateFactory = (PredicateFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/core/predicate.ecore"); //$NON-NLS-1$ 
			if (thePredicateFactory != null) {
				return thePredicateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PredicateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateFactoryImpl() {
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
			case PredicatePackage.AND: return createAnd();
			case PredicatePackage.FALSE: return createFalse();
			case PredicatePackage.NOT: return createNot();
			case PredicatePackage.OR: return createOr();
			case PredicatePackage.PREDICATE_REFERENCE: return createPredicateReference();
			case PredicatePackage.TRUE: return createTrue();
			case PredicatePackage.PREDICATE_EXPRESSION: return createPredicateExpression();
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION: return createIdentifiablePredicateExpression();
			case PredicatePackage.ABSOLUTE_TIME_TEST: return createAbsoluteTimeTest();
			case PredicatePackage.ELAPSED_TIME_TEST: return createElapsedTimeTest();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public False createFalse() {
		FalseImpl false_ = new FalseImpl();
		return false_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateReference createPredicateReference() {
		PredicateReferenceImpl predicateReference = new PredicateReferenceImpl();
		return predicateReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public True createTrue() {
		TrueImpl true_ = new TrueImpl();
		return true_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateExpression createPredicateExpression() {
		PredicateExpressionImpl predicateExpression = new PredicateExpressionImpl();
		return predicateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiablePredicateExpression createIdentifiablePredicateExpression() {
		IdentifiablePredicateExpressionImpl identifiablePredicateExpression = new IdentifiablePredicateExpressionImpl();
		return identifiablePredicateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbsoluteTimeTest createAbsoluteTimeTest() {
		AbsoluteTimeTestImpl absoluteTimeTest = new AbsoluteTimeTestImpl();
		return absoluteTimeTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElapsedTimeTest createElapsedTimeTest() {
		ElapsedTimeTestImpl elapsedTimeTest = new ElapsedTimeTestImpl();
		return elapsedTimeTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicatePackage getPredicatePackage() {
		return (PredicatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PredicatePackage getPackage() {
		return PredicatePackage.eINSTANCE;
	}

} //PredicateFactoryImpl

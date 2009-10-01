package org.eclipse.stem.core.predicate.util;

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

import org.eclipse.stem.core.predicate.*;

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
 * @see org.eclipse.stem.core.predicate.PredicatePackage
 * @generated
 */
public class PredicateSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PredicatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateSwitch() {
		if (modelPackage == null) {
			modelPackage = PredicatePackage.eINSTANCE;
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
			case PredicatePackage.AND: {
				And and = (And)theEObject;
				T1 result = caseAnd(and);
				if (result == null) result = caseNaryBooleanOperator(and);
				if (result == null) result = caseBooleanOperator(and);
				if (result == null) result = caseBooleanExpression(and);
				if (result == null) result = casePredicate(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.BOOLEAN_EXPRESSION: {
				BooleanExpression booleanExpression = (BooleanExpression)theEObject;
				T1 result = caseBooleanExpression(booleanExpression);
				if (result == null) result = casePredicate(booleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.BOOLEAN_OPERATOR: {
				BooleanOperator booleanOperator = (BooleanOperator)theEObject;
				T1 result = caseBooleanOperator(booleanOperator);
				if (result == null) result = caseBooleanExpression(booleanOperator);
				if (result == null) result = casePredicate(booleanOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.FALSE: {
				False false_ = (False)theEObject;
				T1 result = caseFalse(false_);
				if (result == null) result = caseTest(false_);
				if (result == null) result = casePredicate(false_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.NARY_BOOLEAN_OPERATOR: {
				NaryBooleanOperator naryBooleanOperator = (NaryBooleanOperator)theEObject;
				T1 result = caseNaryBooleanOperator(naryBooleanOperator);
				if (result == null) result = caseBooleanOperator(naryBooleanOperator);
				if (result == null) result = caseBooleanExpression(naryBooleanOperator);
				if (result == null) result = casePredicate(naryBooleanOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.NOT: {
				Not not = (Not)theEObject;
				T1 result = caseNot(not);
				if (result == null) result = caseUnaryBooleanOperator(not);
				if (result == null) result = caseBooleanOperator(not);
				if (result == null) result = caseBooleanExpression(not);
				if (result == null) result = casePredicate(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.OR: {
				Or or = (Or)theEObject;
				T1 result = caseOr(or);
				if (result == null) result = caseNaryBooleanOperator(or);
				if (result == null) result = caseBooleanOperator(or);
				if (result == null) result = caseBooleanExpression(or);
				if (result == null) result = casePredicate(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.PREDICATE: {
				Predicate predicate = (Predicate)theEObject;
				T1 result = casePredicate(predicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.PREDICATE_REFERENCE: {
				PredicateReference predicateReference = (PredicateReference)theEObject;
				T1 result = casePredicateReference(predicateReference);
				if (result == null) result = casePredicate(predicateReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.TEST: {
				Test test = (Test)theEObject;
				T1 result = caseTest(test);
				if (result == null) result = casePredicate(test);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.TRUE: {
				True true_ = (True)theEObject;
				T1 result = caseTrue(true_);
				if (result == null) result = caseTest(true_);
				if (result == null) result = casePredicate(true_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.UNARY_BOOLEAN_OPERATOR: {
				UnaryBooleanOperator unaryBooleanOperator = (UnaryBooleanOperator)theEObject;
				T1 result = caseUnaryBooleanOperator(unaryBooleanOperator);
				if (result == null) result = caseBooleanOperator(unaryBooleanOperator);
				if (result == null) result = caseBooleanExpression(unaryBooleanOperator);
				if (result == null) result = casePredicate(unaryBooleanOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.PREDICATE_EXPRESSION: {
				PredicateExpression predicateExpression = (PredicateExpression)theEObject;
				T1 result = casePredicateExpression(predicateExpression);
				if (result == null) result = caseBooleanExpression(predicateExpression);
				if (result == null) result = casePredicate(predicateExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.IDENTIFIABLE_PREDICATE: {
				IdentifiablePredicate identifiablePredicate = (IdentifiablePredicate)theEObject;
				T1 result = caseIdentifiablePredicate(identifiablePredicate);
				if (result == null) result = caseIdentifiable(identifiablePredicate);
				if (result == null) result = casePredicate(identifiablePredicate);
				if (result == null) result = caseComparable(identifiablePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.IDENTIFIABLE_PREDICATE_EXPRESSION: {
				IdentifiablePredicateExpression identifiablePredicateExpression = (IdentifiablePredicateExpression)theEObject;
				T1 result = caseIdentifiablePredicateExpression(identifiablePredicateExpression);
				if (result == null) result = caseIdentifiablePredicate(identifiablePredicateExpression);
				if (result == null) result = casePredicateExpression(identifiablePredicateExpression);
				if (result == null) result = caseIdentifiable(identifiablePredicateExpression);
				if (result == null) result = caseBooleanExpression(identifiablePredicateExpression);
				if (result == null) result = caseComparable(identifiablePredicateExpression);
				if (result == null) result = casePredicate(identifiablePredicateExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.IDENTIFIABLE_TEST: {
				IdentifiableTest identifiableTest = (IdentifiableTest)theEObject;
				T1 result = caseIdentifiableTest(identifiableTest);
				if (result == null) result = caseIdentifiablePredicate(identifiableTest);
				if (result == null) result = caseTest(identifiableTest);
				if (result == null) result = caseIdentifiable(identifiableTest);
				if (result == null) result = casePredicate(identifiableTest);
				if (result == null) result = caseComparable(identifiableTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.TIME_TEST: {
				TimeTest timeTest = (TimeTest)theEObject;
				T1 result = caseTimeTest(timeTest);
				if (result == null) result = caseTest(timeTest);
				if (result == null) result = casePredicate(timeTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.ABSOLUTE_TIME_TEST: {
				AbsoluteTimeTest absoluteTimeTest = (AbsoluteTimeTest)theEObject;
				T1 result = caseAbsoluteTimeTest(absoluteTimeTest);
				if (result == null) result = caseTimeTest(absoluteTimeTest);
				if (result == null) result = caseTest(absoluteTimeTest);
				if (result == null) result = casePredicate(absoluteTimeTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PredicatePackage.ELAPSED_TIME_TEST: {
				ElapsedTimeTest elapsedTimeTest = (ElapsedTimeTest)theEObject;
				T1 result = caseElapsedTimeTest(elapsedTimeTest);
				if (result == null) result = caseTimeTest(elapsedTimeTest);
				if (result == null) result = caseTest(elapsedTimeTest);
				if (result == null) result = casePredicate(elapsedTimeTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanExpression(BooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBooleanOperator(BooleanOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFalse(False object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nary Boolean Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nary Boolean Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNaryBooleanOperator(NaryBooleanOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePredicate(Predicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePredicateReference(PredicateReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTest(Test object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTrue(True object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Boolean Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Boolean Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnaryBooleanOperator(UnaryBooleanOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePredicateExpression(PredicateExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiablePredicate(IdentifiablePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Predicate Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Predicate Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiablePredicateExpression(IdentifiablePredicateExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiableTest(IdentifiableTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTimeTest(TimeTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Absolute Time Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Absolute Time Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbsoluteTimeTest(AbsoluteTimeTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Elapsed Time Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Elapsed Time Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseElapsedTimeTest(ElapsedTimeTest object) {
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

} //PredicateSwitch

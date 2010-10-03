package org.eclipse.stem.tests.util.decorators.impl;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
//import org.eclipse.stem.tests.util.decorators.*;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1;
import org.eclipse.stem.tests.util.decorators.TestGraphDecorator1;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;
import org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DecoratorsFactoryImpl extends EFactoryImpl implements DecoratorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DecoratorsFactory init() {
		try {
			DecoratorsFactory theDecoratorsFactory = (DecoratorsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/tests/util/decorators.ecore"); //$NON-NLS-1$ 
			if (theDecoratorsFactory != null) {
				return theDecoratorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DecoratorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecoratorsFactoryImpl() {
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
			case DecoratorsPackage.TEST_EDGE_DECORATOR1: return (EObject)createTestEdgeDecorator1();
			case DecoratorsPackage.TEST_GRAPH_DECORATOR1: return (EObject)createTestGraphDecorator1();
			case DecoratorsPackage.TEST_NODE_DECORATOR1: return (EObject)createTestNodeDecorator1();
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1: return (EObject)createTestScenarioGraphDecorator1();
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
			case DecoratorsPackage.URI:
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
			case DecoratorsPackage.URI:
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
	public TestEdgeDecorator1 createTestEdgeDecorator1() {
		TestEdgeDecorator1Impl testEdgeDecorator1 = new TestEdgeDecorator1Impl();
		return testEdgeDecorator1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestGraphDecorator1 createTestGraphDecorator1() {
		TestGraphDecorator1Impl testGraphDecorator1 = new TestGraphDecorator1Impl();
		return testGraphDecorator1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestNodeDecorator1 createTestNodeDecorator1() {
		TestNodeDecorator1Impl testNodeDecorator1 = new TestNodeDecorator1Impl();
		return testNodeDecorator1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestScenarioGraphDecorator1 createTestScenarioGraphDecorator1() {
		TestScenarioGraphDecorator1Impl testScenarioGraphDecorator1 = new TestScenarioGraphDecorator1Impl();
		return testScenarioGraphDecorator1;
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
	public DecoratorsPackage getDecoratorsPackage() {
		return (DecoratorsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DecoratorsPackage getPackage() {
		return DecoratorsPackage.eINSTANCE;
	}

} //DecoratorsFactoryImpl

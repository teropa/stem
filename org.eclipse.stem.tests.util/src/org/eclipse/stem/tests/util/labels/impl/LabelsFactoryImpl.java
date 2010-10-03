package org.eclipse.stem.tests.util.labels.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
//import org.eclipse.stem.tests.util.labels.*;
import org.eclipse.stem.tests.util.labels.LabelsFactory;
import org.eclipse.stem.tests.util.labels.LabelsPackage;
import org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;
import org.eclipse.stem.tests.util.labels.TestLabel;
import org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestStaticNodeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LabelsFactoryImpl extends EFactoryImpl implements LabelsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LabelsFactory init() {
		try {
			LabelsFactory theLabelsFactory = (LabelsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/tests/util/labels.ecore"); //$NON-NLS-1$ 
			if (theLabelsFactory != null) {
				return theLabelsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LabelsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsFactoryImpl() {
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
			case LabelsPackage.TEST_DYNAMIC_EDGE_LABEL: return (EObject)createTestDynamicEdgeLabel();
			case LabelsPackage.TEST_DYNAMIC_LABEL1: return (EObject)createTestDynamicLabel1();
			case LabelsPackage.TEST_DYNAMIC_NODE_LABEL: return (EObject)createTestDynamicNodeLabel();
			case LabelsPackage.TEST_INTEGER_LABEL_VALUE: return (EObject)createTestIntegerLabelValue();
			case LabelsPackage.TEST_LABEL: return (EObject)createTestLabel();
			case LabelsPackage.TEST_STATIC_EDGE_LABEL: return (EObject)createTestStaticEdgeLabel();
			case LabelsPackage.TEST_STATIC_NODE_LABEL: return (EObject)createTestStaticNodeLabel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDynamicEdgeLabel createTestDynamicEdgeLabel() {
		TestDynamicEdgeLabelImpl testDynamicEdgeLabel = new TestDynamicEdgeLabelImpl();
		return testDynamicEdgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDynamicLabel1 createTestDynamicLabel1() {
		TestDynamicLabel1Impl testDynamicLabel1 = new TestDynamicLabel1Impl();
		return testDynamicLabel1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDynamicNodeLabel createTestDynamicNodeLabel() {
		TestDynamicNodeLabelImpl testDynamicNodeLabel = new TestDynamicNodeLabelImpl();
		return testDynamicNodeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestIntegerLabelValue createTestIntegerLabelValue() {
		TestIntegerLabelValueImpl testIntegerLabelValue = new TestIntegerLabelValueImpl();
		return testIntegerLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestLabel createTestLabel() {
		TestLabelImpl testLabel = new TestLabelImpl();
		return testLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStaticEdgeLabel createTestStaticEdgeLabel() {
		TestStaticEdgeLabelImpl testStaticEdgeLabel = new TestStaticEdgeLabelImpl();
		return testStaticEdgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStaticNodeLabel createTestStaticNodeLabel() {
		TestStaticNodeLabelImpl testStaticNodeLabel = new TestStaticNodeLabelImpl();
		return testStaticNodeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsPackage getLabelsPackage() {
		return (LabelsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LabelsPackage getPackage() {
		return LabelsPackage.eINSTANCE;
	}

} //LabelsFactoryImpl

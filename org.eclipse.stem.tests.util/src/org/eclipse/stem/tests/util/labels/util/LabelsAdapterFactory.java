package org.eclipse.stem.tests.util.labels.util;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.graph.DynamicEdgeLabel;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.StaticEdgeLabel;
import org.eclipse.stem.core.graph.StaticLabel;
import org.eclipse.stem.core.graph.StaticNodeLabel;
//import org.eclipse.stem.tests.util.labels.*;
import org.eclipse.stem.core.modifier.Modifiable;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.tests.util.labels.LabelsPackage
 * @generated
 */
public class LabelsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LabelsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LabelsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelsSwitch<Adapter> modelSwitch =
		new LabelsSwitch<Adapter>() {
			@Override
			public Adapter caseTestDynamicEdgeLabel(TestDynamicEdgeLabel object) {
				return createTestDynamicEdgeLabelAdapter();
			}
			@Override
			public Adapter caseTestDynamicLabel1(TestDynamicLabel1 object) {
				return createTestDynamicLabel1Adapter();
			}
			@Override
			public Adapter caseTestDynamicNodeLabel(TestDynamicNodeLabel object) {
				return createTestDynamicNodeLabelAdapter();
			}
			@Override
			public Adapter caseTestIntegerLabelValue(TestIntegerLabelValue object) {
				return createTestIntegerLabelValueAdapter();
			}
			@Override
			public Adapter caseTestLabel(TestLabel object) {
				return createTestLabelAdapter();
			}
			@Override
			public Adapter caseTestStaticEdgeLabel(TestStaticEdgeLabel object) {
				return createTestStaticEdgeLabelAdapter();
			}
			@Override
			public Adapter caseTestStaticNodeLabel(TestStaticNodeLabel object) {
				return createTestStaticNodeLabelAdapter();
			}
			@Override
			public <T> Adapter caseComparable(Comparable<T> object) {
				return createComparableAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseDynamicLabel(DynamicLabel object) {
				return createDynamicLabelAdapter();
			}
			@Override
			public Adapter caseEdgeLabel(EdgeLabel object) {
				return createEdgeLabelAdapter();
			}
			@Override
			public Adapter caseDynamicEdgeLabel(DynamicEdgeLabel object) {
				return createDynamicEdgeLabelAdapter();
			}
			@Override
			public Adapter caseNodeLabel(NodeLabel object) {
				return createNodeLabelAdapter();
			}
			@Override
			public Adapter caseDynamicNodeLabel(DynamicNodeLabel object) {
				return createDynamicNodeLabelAdapter();
			}
			@Override
			public Adapter caseSanityChecker(SanityChecker object) {
				return createSanityCheckerAdapter();
			}
			@Override
			public Adapter caseLabelValue(LabelValue object) {
				return createLabelValueAdapter();
			}
			@Override
			public Adapter caseModifiable(Modifiable object) {
				return createModifiableAdapter();
			}
			@Override
			public Adapter caseStaticLabel(StaticLabel object) {
				return createStaticLabelAdapter();
			}
			@Override
			public Adapter caseStaticEdgeLabel(StaticEdgeLabel object) {
				return createStaticEdgeLabelAdapter();
			}
			@Override
			public Adapter caseStaticNodeLabel(StaticNodeLabel object) {
				return createStaticNodeLabelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestDynamicLabel1 <em>Test Dynamic Label1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestDynamicLabel1
	 * @generated
	 */
	public Adapter createTestDynamicLabel1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestIntegerLabelValue <em>Test Integer Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestIntegerLabelValue
	 * @generated
	 */
	public Adapter createTestIntegerLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestLabel <em>Test Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestLabel
	 * @generated
	 */
	public Adapter createTestLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestStaticNodeLabel <em>Test Static Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestStaticNodeLabel
	 * @generated
	 */
	public Adapter createTestStaticNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.lang.Comparable
	 * @generated
	 */
	public Adapter createComparableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel <em>Test Dynamic Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel
	 * @generated
	 */
	public Adapter createTestDynamicEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel <em>Test Static Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestStaticEdgeLabel
	 * @generated
	 */
	public Adapter createTestStaticEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel <em>Test Dynamic Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel
	 * @generated
	 */
	public Adapter createTestDynamicNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.common.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.common.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.DynamicLabel <em>Dynamic Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.DynamicLabel
	 * @generated
	 */
	public Adapter createDynamicLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.LabelValue <em>Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.LabelValue
	 * @generated
	 */
	public Adapter createLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.StaticLabel <em>Static Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.StaticLabel
	 * @generated
	 */
	public Adapter createStaticLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.modifier.Modifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.modifier.Modifiable
	 * @generated
	 */
	public Adapter createModifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.NodeLabel <em>Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.NodeLabel
	 * @generated
	 */
	public Adapter createNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.StaticNodeLabel <em>Static Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.StaticNodeLabel
	 * @generated
	 */
	public Adapter createStaticNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.EdgeLabel <em>Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.EdgeLabel
	 * @generated
	 */
	public Adapter createEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.DynamicEdgeLabel <em>Dynamic Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.DynamicEdgeLabel
	 * @generated
	 */
	public Adapter createDynamicEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.StaticEdgeLabel <em>Static Edge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.StaticEdgeLabel
	 * @generated
	 */
	public Adapter createStaticEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.DynamicNodeLabel <em>Dynamic Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.DynamicNodeLabel
	 * @generated
	 */
	public Adapter createDynamicNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @generated
	 */
	public Adapter createSanityCheckerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LabelsAdapterFactory

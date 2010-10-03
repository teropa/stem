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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.LabelValue;
//import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.EdgeDecoratorImpl;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.TestEdgeDecorator1;
import org.eclipse.stem.tests.util.labels.TestDynamicEdgeLabel;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Edge Decorator1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl#getNodeAURI <em>Node AURI</em>}</li>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl#getNodeBURI <em>Node BURI</em>}</li>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestEdgeDecorator1Impl#getEdgeURI <em>Edge URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestEdgeDecorator1Impl extends EdgeDecoratorImpl implements
		TestEdgeDecorator1 {
	/**
	 * The default value of the '{@link #getNodeAURI() <em>Node AURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeAURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NODE_AURI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getNodeBURI() <em>Node BURI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeBURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI NODE_BURI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getEdgeURI() <em>Edge URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEdgeURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI EDGE_URI_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TestEdgeDecorator1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNodeAURI() {
		return (URI)eDynamicGet(DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_AURI, DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1__NODE_AURI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeAURI(URI newNodeAURI) {
		eDynamicSet(DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_AURI, DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1__NODE_AURI, newNodeAURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getNodeBURI() {
		return (URI)eDynamicGet(DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_BURI, DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1__NODE_BURI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeBURI(URI newNodeBURI) {
		eDynamicSet(DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_BURI, DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1__NODE_BURI, newNodeBURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getEdgeURI() {
		return (URI)eDynamicGet(DecoratorsPackage.TEST_EDGE_DECORATOR1__EDGE_URI, DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1__EDGE_URI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeURI(URI newEdgeURI) {
		eDynamicSet(DecoratorsPackage.TEST_EDGE_DECORATOR1__EDGE_URI, DecoratorsPackage.Literals.TEST_EDGE_DECORATOR1__EDGE_URI, newEdgeURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_AURI:
				return getNodeAURI();
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_BURI:
				return getNodeBURI();
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__EDGE_URI:
				return getEdgeURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_AURI:
				setNodeAURI((URI)newValue);
				return;
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_BURI:
				setNodeBURI((URI)newValue);
				return;
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__EDGE_URI:
				setEdgeURI((URI)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_AURI:
				setNodeAURI(NODE_AURI_EDEFAULT);
				return;
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_BURI:
				setNodeBURI(NODE_BURI_EDEFAULT);
				return;
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__EDGE_URI:
				setEdgeURI(EDGE_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_AURI:
				return NODE_AURI_EDEFAULT == null ? getNodeAURI() != null : !NODE_AURI_EDEFAULT.equals(getNodeAURI());
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__NODE_BURI:
				return NODE_BURI_EDEFAULT == null ? getNodeBURI() != null : !NODE_BURI_EDEFAULT.equals(getNodeBURI());
			case DecoratorsPackage.TEST_EDGE_DECORATOR1__EDGE_URI:
				return EDGE_URI_EDEFAULT == null ? getEdgeURI() != null : !EDGE_URI_EDEFAULT.equals(getEdgeURI());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 * @generated NOT
	 */
	@Override
	public boolean decorateGraph(STEMTime time) {
		final Node nodeA = getGraph().getNode(getNodeAURI());
		final Node nodeB = getGraph().getNode(getNodeBURI());

		final TestEdgeDecorator1 ted = DecoratorsFactory.eINSTANCE
		.createTestEdgeDecorator1();
		
		final Edge edge = TestUtil.createDynamicallyLabeledEdge(getNodeAURI(),
				getNodeBURI(),getEdgeURI(), ted);
		edge.setA(nodeA);
		edge.setB(nodeB);
		nodeA.getEdges().add(edge);
		nodeB.getEdges().add(edge);

		getLabelsToUpdate().add((DynamicLabel)edge.getLabel());

//		getGraph().addDynamicLabel((DynamicLabel) edge.getLabel());
		getGraph().putEdge(edge);

		assert edge.sane();
		return true;
	} // decorateGraph

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(Graph, STEMTime, long)
	 * @generated NOT
	 */
	@Override
	public void updateLabels(STEMTime time, final long timeDelta, int cycele) {
		for (final Iterator dynamicLabelIter = getLabelsToUpdate().iterator(); dynamicLabelIter
				.hasNext();) {
			final TestDynamicEdgeLabel testLabel = (TestDynamicEdgeLabel) dynamicLabelIter
					.next();
			testLabel.increment();
		} // for
	} // updateLabels

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#resetLabels(org.eclipse.stem.core.graph.Graph)
	 * @generated NOT
	 */
	@Override
	public void resetLabels() {
		final TestDynamicLabel1 TEST_LABEL = TestUtil
				.createDynamicLabel(TestUtil.createNextIdentifiableToLabelURI());
		final TestIntegerLabelValue RESET_VALUE = (TestIntegerLabelValue) TEST_LABEL
				.getCurrentValue();
		for (Iterator labelIter = getLabelsToUpdate().iterator(); labelIter
				.hasNext();) {
			final TestDynamicEdgeLabel dynamicLabel = (TestDynamicEdgeLabel) labelIter
					.next();
			dynamicLabel.setCurrentValue((LabelValue)EcoreUtil
					.copy(RESET_VALUE));
		}
	} // resetLabels

} // TestEdgeDecorator1Impl

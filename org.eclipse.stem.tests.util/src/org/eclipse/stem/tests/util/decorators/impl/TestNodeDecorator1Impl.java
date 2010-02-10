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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.LabelValue;
//import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.TestNodeDecorator1;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestDynamicNodeLabel;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Node Decorator1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TestNodeDecorator1Impl extends NodeDecoratorImpl implements
		TestNodeDecorator1 {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TestNodeDecorator1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DecoratorsPackage.Literals.TEST_NODE_DECORATOR1;
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 * @generated NOT
	 */
	@Override
	public boolean decorateGraph() {
		final TestNodeDecorator1 tnd = DecoratorsFactory.eINSTANCE
		.createTestNodeDecorator1();
		getGraph().getDecorators().add(tnd);
		for (final Iterator nodeIter = getGraph().getNodes().values().iterator(); nodeIter
				.hasNext();) {
			final Node node = (Node) nodeIter.next();
			final DynamicNodeLabel dynamicNodeLabel = TestUtil.createDynamicNodeLabel(node.getURI(), tnd);
			getGraph().putNodeLabel(dynamicNodeLabel);
			getLabelsToUpdate().add(dynamicNodeLabel);
			node.getLabels().add(dynamicNodeLabel);
		} // for
		return true;
	} // decorateGraph

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(Graph, STEMTime, long)
	 * @generated NOT
	 */
	@Override
	public void updateLabels(STEMTime time, final long timeDelta, int cycle) {
		for (final Iterator dynamicLabelIter = getLabelsToUpdate().iterator(); dynamicLabelIter
				.hasNext();) {
			final DynamicLabel testLabel = (DynamicLabel) dynamicLabelIter
					.next();
			if (testLabel instanceof TestDynamicLabel1) {
				TestDynamicLabel1 tdl1 = (TestDynamicLabel1) testLabel;
				tdl1.increment();
			}
			if (testLabel instanceof TestDynamicNodeLabel) {
				TestDynamicNodeLabel tdnl = (TestDynamicNodeLabel) testLabel;
				tdnl.increment();
			}
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
			final DynamicLabel dynamicLabel = (DynamicLabel) labelIter
					.next();
			dynamicLabel.setCurrentValue((LabelValue)EcoreUtil
					.copy(RESET_VALUE));
		}
	} // resetLabels

} // TestNodeDecorator1Impl

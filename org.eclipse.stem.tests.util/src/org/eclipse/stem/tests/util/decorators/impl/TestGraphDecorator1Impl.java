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
//import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.GraphDecoratorImpl;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.TestGraphDecorator1;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Graph Decorator1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TestGraphDecorator1Impl extends GraphDecoratorImpl implements
		TestGraphDecorator1 {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TestGraphDecorator1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DecoratorsPackage.Literals.TEST_GRAPH_DECORATOR1;
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 * @generated NOT
	 */
	@Override
	public void decorateGraph() {
		final DynamicLabel dynamicLabel = TestUtil.createDynamicLabel(getGraph().getURI());
		getLabelsToUpdate().add(dynamicLabel);
		getGraph().putGraphLabel(dynamicLabel);
	} // decorateGraph

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(Graph, STEMTime, long)
	 * @generated NOT
	 */
	@Override
	public void updateLabels(STEMTime time, final long timeDelta, int cycle) {
		for (final Iterator dynamicLabelIter = getLabelsToUpdate().iterator(); dynamicLabelIter
				.hasNext();) {
			final TestDynamicLabel1 testLabel = (TestDynamicLabel1) dynamicLabelIter
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
			final TestDynamicLabel1 dynamicLabel = (TestDynamicLabel1) labelIter
					.next();
			dynamicLabel.setCurrentValue((LabelValue) EcoreUtil
					.copy(RESET_VALUE));
		}
		assert this.sane();
	} // resetLabels
} // TestGraphDecorator1Impl

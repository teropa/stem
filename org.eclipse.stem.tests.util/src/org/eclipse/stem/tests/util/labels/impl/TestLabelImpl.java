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
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.impl.LabelImpl;
import org.eclipse.stem.tests.util.labels.LabelsFactory;
import org.eclipse.stem.tests.util.labels.LabelsPackage;
import org.eclipse.stem.tests.util.labels.TestLabel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TestLabelImpl extends LabelImpl implements TestLabel {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TestLabelImpl() {
		super();
		setCurrentValue(LabelsFactory.eINSTANCE.createTestIntegerLabelValue());
	} // TestLabelImpl

	@Override
	public Identifiable getIdentifiable() {
		return null;
	}

	@Override
	public void setIdentifiable(Identifiable newIdentifiable) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.TEST_LABEL;
	}

	/**
	 * @see org.eclipse.stem.core.graph.impl.LabelImpl#toString()
	 * @generated NOT
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(getCurrentValue().toString());
		return sb.toString();
	} // toString

	
} // TestLabelImpl

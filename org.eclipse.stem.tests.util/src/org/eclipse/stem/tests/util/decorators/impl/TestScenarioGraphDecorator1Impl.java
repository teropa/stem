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

import org.eclipse.emf.common.notify.Notification;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.LabelValue;
//import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.GraphDecoratorImpl;
import org.eclipse.stem.tests.util.TestUtil;
import org.eclipse.stem.tests.util.decorators.DecoratorsPackage;
import org.eclipse.stem.tests.util.decorators.TestScenarioGraphDecorator1;
import org.eclipse.stem.tests.util.labels.TestDynamicLabel1;
import org.eclipse.stem.tests.util.labels.TestIntegerLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Scenario Graph Decorator1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl#getDoubleValue <em>Double Value</em>}</li>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl#getStringValue <em>String Value</em>}</li>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl#getSTEMTimeValue <em>STEM Time Value</em>}</li>
 *   <li>{@link org.eclipse.stem.tests.util.decorators.impl.TestScenarioGraphDecorator1Impl#isBooleanValue <em>Boolean Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestScenarioGraphDecorator1Impl extends GraphDecoratorImpl
		implements TestScenarioGraphDecorator1 {
	/**
	 * The default value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected static final double DOUBLE_VALUE_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected double doubleValue = DOUBLE_VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntValue()
	 * @generated
	 * @ordered
	 */
	protected static final int INT_VALUE_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntValue()
	 * @generated
	 * @ordered
	 */
	protected int intValue = INT_VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringValue()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStringValue() <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringValue()
	 * @generated
	 * @ordered
	 */
	protected String stringValue = STRING_VALUE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSTEMTimeValue() <em>STEM Time Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTEMTimeValue()
	 * @generated
	 * @ordered
	 */
	protected STEMTime sTEMTimeValue;

	/**
	 * The default value of the '{@link #isBooleanValue() <em>Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_VALUE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isBooleanValue() <em>Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected boolean booleanValue = BOOLEAN_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TestScenarioGraphDecorator1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DecoratorsPackage.Literals.TEST_SCENARIO_GRAPH_DECORATOR1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoubleValue(double newDoubleValue) {
		double oldDoubleValue = doubleValue;
		doubleValue = newDoubleValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE, oldDoubleValue, doubleValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntValue(int newIntValue) {
		int oldIntValue = intValue;
		intValue = newIntValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE, oldIntValue, intValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringValue(String newStringValue) {
		String oldStringValue = stringValue;
		stringValue = newStringValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE, oldStringValue, stringValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getSTEMTimeValue() {
		if (sTEMTimeValue != null && sTEMTimeValue.eIsProxy()) {
			InternalEObject oldSTEMTimeValue = (InternalEObject)sTEMTimeValue;
			sTEMTimeValue = (STEMTime)eResolveProxy(oldSTEMTimeValue);
			if (sTEMTimeValue != oldSTEMTimeValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE, oldSTEMTimeValue, sTEMTimeValue));
			}
		}
		return sTEMTimeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetSTEMTimeValue() {
		return sTEMTimeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSTEMTimeValue(STEMTime newSTEMTimeValue) {
		STEMTime oldSTEMTimeValue = sTEMTimeValue;
		sTEMTimeValue = newSTEMTimeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE, oldSTEMTimeValue, sTEMTimeValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanValue(boolean newBooleanValue) {
		boolean oldBooleanValue = booleanValue;
		booleanValue = newBooleanValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE, oldBooleanValue, booleanValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE:
				return new Double(getDoubleValue());
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE:
				return new Integer(getIntValue());
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE:
				return getStringValue();
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE:
				if (resolve) return getSTEMTimeValue();
				return basicGetSTEMTimeValue();
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE:
				return isBooleanValue() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE:
				setDoubleValue(((Double)newValue).doubleValue());
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE:
				setIntValue(((Integer)newValue).intValue());
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE:
				setStringValue((String)newValue);
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE:
				setSTEMTimeValue((STEMTime)newValue);
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE:
				setBooleanValue(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE:
				setDoubleValue(DOUBLE_VALUE_EDEFAULT);
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE:
				setIntValue(INT_VALUE_EDEFAULT);
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE:
				setStringValue(STRING_VALUE_EDEFAULT);
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE:
				setSTEMTimeValue((STEMTime)null);
				return;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE:
				setBooleanValue(BOOLEAN_VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__DOUBLE_VALUE:
				return doubleValue != DOUBLE_VALUE_EDEFAULT;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__INT_VALUE:
				return intValue != INT_VALUE_EDEFAULT;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STRING_VALUE:
				return STRING_VALUE_EDEFAULT == null ? stringValue != null : !STRING_VALUE_EDEFAULT.equals(stringValue);
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__STEM_TIME_VALUE:
				return sTEMTimeValue != null;
			case DecoratorsPackage.TEST_SCENARIO_GRAPH_DECORATOR1__BOOLEAN_VALUE:
				return booleanValue != BOOLEAN_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (doubleValue: "); //$NON-NLS-1$
		result.append(doubleValue);
		result.append(", intValue: "); //$NON-NLS-1$
		result.append(intValue);
		result.append(", stringValue: "); //$NON-NLS-1$
		result.append(stringValue);
		result.append(", booleanValue: "); //$NON-NLS-1$
		result.append(booleanValue);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public boolean decorateGraph() {
		final DynamicLabel dynamicLabel = TestUtil.createDynamicLabel(getGraph()
				.getURI());
		dynamicLabel.setURI(LABEL_URI);
		getLabelsToUpdate().add(dynamicLabel);
		getGraph().putGraphLabel(dynamicLabel);
//		getGraph().addDynamicLabel(dynamicLabel);
		return true;
	} // decorateGraph

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(Graph, STEMTime, long)
	 *      org.eclipse.stem.core.model.STEMTime)
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
			dynamicLabel.setCurrentValue((LabelValue)EcoreUtil
					.copy(RESET_VALUE));
		}
	} // resetLabels

} // TestScenarioGraphDecorator1Impl

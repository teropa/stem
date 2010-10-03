package org.eclipse.stem.definitions.transport.impl;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.definitions.edges.EdgesFactory;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue;
import org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;

import org.eclipse.stem.definitions.transport.LoadUnloadEdge;
import org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystem;
import org.eclipse.stem.definitions.transport.PacketTransportLabel;
import org.eclipse.stem.definitions.transport.TransportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Unload Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeLabelImpl#isNextValueValid <em>Next Value Valid</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeLabelImpl#getNextValue <em>Next Value</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeLabelImpl#getDecorator <em>Decorator</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeLabelImpl#getActivationTime <em>Activation Time</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeLabelImpl#getDeactivationTime <em>Deactivation Time</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.transport.impl.LoadUnloadEdgeLabelImpl#getActivatedRate <em>Activated Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadUnloadEdgeLabelImpl extends MigrationEdgeLabelImpl implements LoadUnloadEdgeLabel {
	
	
	/**
	 * The default value of the '{@link #isNextValueValid() <em>Next Value Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNextValueValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEXT_VALUE_VALID_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getActivatedRate() <em>Activated Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivatedRate()
	 * @generated
	 * @ordered
	 */
	protected static final double ACTIVATED_RATE_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LoadUnloadEdgeLabelImpl() {
		super();
		
		//make sure the type URI is set
		this.setTypeURI(URI_TYPE_LOAD_UNLOAD_EDGE_LABEL);
		
		//give a value for the next value
		setNextValue(EdgesFactory.eINSTANCE.createMigrationEdgeLabelValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNextValueValid() {
		return (Boolean)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE_VALID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValueValid(boolean newNextValueValid) {
		eDynamicSet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE_VALID, newNextValueValid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelValue getNextValue() {
		return (LabelValue)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextValue(LabelValue newNextValue, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newNextValue, TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE, msgs);
		return msgs;
	}

	
	/**Migration edge version*/
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextValue(LabelValue newNextValue) {
		eDynamicSet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE, GraphPackage.Literals.DYNAMIC_LABEL__NEXT_VALUE, newNextValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decorator getDecorator() {
		return (Decorator)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR, GraphPackage.Literals.DYNAMIC_LABEL__DECORATOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decorator basicGetDecorator() {
		return (Decorator)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR, GraphPackage.Literals.DYNAMIC_LABEL__DECORATOR, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDecorator(Decorator newDecorator, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newDecorator, TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecorator(Decorator newDecorator) {
		eDynamicSet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR, GraphPackage.Literals.DYNAMIC_LABEL__DECORATOR, newDecorator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getActivationTime() {
		return (STEMTime)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetActivationTime() {
		return (STEMTime)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivationTime(STEMTime newActivationTime) {
		eDynamicSet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME, newActivationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime getDeactivationTime() {
		return (STEMTime)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STEMTime basicGetDeactivationTime() {
		return (STEMTime)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeactivationTime(STEMTime newDeactivationTime) {
		eDynamicSet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME, newDeactivationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getActivatedRate() {
		return (Double)eDynamicGet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivatedRate(double newActivatedRate) {
		eDynamicSet(TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE, TransportPackage.Literals.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE, newActivatedRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reset() {
		//set the migration rate to 0
		this.getCurrentValue().setMigrationRate(0.0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void switchToNextValue() {
		MigrationEdgeLabelValue tmp = this.getCurrentValue();
		setCurrentValue(this.getNextValue());
		setNextValue(tmp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR:
				Decorator decorator = basicGetDecorator();
				if (decorator != null)
					msgs = ((InternalEObject)decorator).eInverseRemove(this, ModelPackage.DECORATOR__LABELS_TO_UPDATE, Decorator.class, msgs);
				return basicSetDecorator((Decorator)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE:
				return basicSetNextValue(null, msgs);
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR:
				return basicSetDecorator(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID:
				return isNextValueValid();
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE:
				return getNextValue();
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR:
				if (resolve) return getDecorator();
				return basicGetDecorator();
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME:
				if (resolve) return getActivationTime();
				return basicGetActivationTime();
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME:
				if (resolve) return getDeactivationTime();
				return basicGetDeactivationTime();
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE:
				return getActivatedRate();
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
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID:
				setNextValueValid((Boolean)newValue);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE:
				setNextValue((LabelValue)newValue);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR:
				setDecorator((Decorator)newValue);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME:
				setActivationTime((STEMTime)newValue);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME:
				setDeactivationTime((STEMTime)newValue);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE:
				setActivatedRate((Double)newValue);
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
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID:
				setNextValueValid(NEXT_VALUE_VALID_EDEFAULT);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE:
				setNextValue((LabelValue)null);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR:
				setDecorator((Decorator)null);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME:
				setActivationTime((STEMTime)null);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME:
				setDeactivationTime((STEMTime)null);
				return;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE:
				setActivatedRate(ACTIVATED_RATE_EDEFAULT);
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
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID:
				return isNextValueValid() != NEXT_VALUE_VALID_EDEFAULT;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE:
				return getNextValue() != null;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR:
				return basicGetDecorator() != null;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATION_TIME:
				return basicGetActivationTime() != null;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DEACTIVATION_TIME:
				return basicGetDeactivationTime() != null;
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__ACTIVATED_RATE:
				return getActivatedRate() != ACTIVATED_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DynamicLabel.class) {
			switch (derivedFeatureID) {
				case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID: return GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID;
				case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE: return GraphPackage.DYNAMIC_LABEL__NEXT_VALUE;
				case TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR: return GraphPackage.DYNAMIC_LABEL__DECORATOR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DynamicLabel.class) {
			switch (baseFeatureID) {
				case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE_VALID: return TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE_VALID;
				case GraphPackage.DYNAMIC_LABEL__NEXT_VALUE: return TransportPackage.LOAD_UNLOAD_EDGE_LABEL__NEXT_VALUE;
				case GraphPackage.DYNAMIC_LABEL__DECORATOR: return TransportPackage.LOAD_UNLOAD_EDGE_LABEL__DECORATOR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**Do the stuff for testing if a load/unload edge label is "sane"*/
	@Override
	public boolean sane() {
		boolean rc = super.sane();
		
		//are activation and deactivation times set.
		rc = rc && (getActivationTime()!=null);
		assert(rc);
		
		rc = rc && (getDeactivationTime()!=null);
		assert(rc);
		
		//make sure the activation time is before the deactivation time.
		rc = rc && getActivationTime().getTime().before(getDeactivationTime().getTime());
		assert(rc);
		
		return rc;
	}

	
	public double getNormalizedActivatedRate() {
		LoadUnloadEdge labeledEdge = (LoadUnloadEdge)this.getEdge();
		
		Node source = labeledEdge.getA();
		PacketStyleTransportSystem transSystem = 
			(PacketStyleTransportSystem) ((labeledEdge.isLoadingEdge())?(labeledEdge.getB()):(labeledEdge.getA()));						
		
		Collection <NodeLabel> lbls=source.getLabels();
		double sourcePop = 0;
		
		//Get the population size of the source node
		for(Iterator<NodeLabel> it = lbls.iterator(); it.hasNext();) {
			NodeLabel lbl = it.next();
			if (lbl instanceof PopulationLabel) {
				sourcePop = ((PopulationLabelValue)((PopulationLabel)lbl).getCurrentValue()).getCount();
				break;
			}
		}
		assert sourcePop > 0;
		
		
		lbls=transSystem.getLabels();
		double transCapacity  = 0;
		
		
		//Get the capacity of the packet transport label
		for(Iterator<NodeLabel> it = lbls.iterator(); it.hasNext();) {
			NodeLabel lbl = it.next();
			if (lbl instanceof PacketTransportLabel) {
				transCapacity = ((PacketTransportLabel)lbl).getCurrentValue().getCapacity();
				break;
			}
		}

		return getActivatedRate()*transCapacity/sourcePop;
	}

} //LoadUnloadEdgeLabelImpl

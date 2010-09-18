package org.eclipse.stem.core.trigger.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.CorePlugin;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.DecoratorImpl;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.predicate.Predicate;
import org.eclipse.stem.core.trigger.Trigger;
import org.eclipse.stem.core.trigger.TriggerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.trigger.impl.TriggerImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipse.stem.core.trigger.impl.TriggerImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl extends DecoratorImpl implements Trigger {
	protected Decorator actionCopy;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TriggerPackage.Literals.TRIGGER;
	}

	
	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph()
	 */
	@Override
	public boolean decorateGraph(STEMTime time) {
		// Do we have an action?
		if (getAction() != null) {
			// Yes
			// Have we already made a copy of the action?
			if (actionCopy == null ) {
				// No
				actionCopy = (Decorator) EcoreUtil.copy(getAction());
				getGraph().getDecorators().add(actionCopy);
			} // if
			actionCopy.setEnabled(false);
		} // if we have an action
		else {
			// No
			CorePlugin.logInformation("No action specified for trigger \""+this.getDublinCore().getTitle()+ "\"", null);
		}
		return true;
	} // decorateGraph

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(org.eclipse.stem.core.model.STEMTime,
	 *      long)
	 */
	@Override
	public void updateLabels(STEMTime time, long timerPeriod, int cycle) {
		// Evaluate the predicate and if it returns true, then let the action
		// decorate the graph.
		// Do we have an action?
		if (actionCopy != null) {
			// Yes
			// Let the action do it's thing?
			if (getPredicate().evaluate(time, timerPeriod, actionCopy)) {
				// Yes
				actionCopy.setEnabled(true);

				// Has the action decorated the graph yet?
				if (!actionCopy.isGraphDecorated()) {
					// No
					actionCopy.decorateGraph(time);
					actionCopy.setGraphDecorated(true);
				} // if graph not decorated yet

				actionCopy.updateLabels(time, timerPeriod, cycle);
			} // if action time
			else {
				// No
				actionCopy.setEnabled(false);
			} // else
		} // if actionCopy != null
	} // updateLabels

	
	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#resetLabels()
	 */
	@Override
	public void resetLabels() {
		if (actionCopy != null) {
			// Yes
			actionCopy.setEnabled(false);
			actionCopy.setGraphDecorated(false);
			// The problem with reseting labels in a Trigger is that it implies
			// some kind of initialization of the labels by the action that in
			// fact should be conditional on the value of the Trigger's
			// predicate.
			// Is the action a Modifier?
			if (actionCopy instanceof Modifier) {
				// Yes
				// It's okay for a Modifier to reset its labels because this
				// restores them to their original values. This works for static
				// labels. A more general Decorator, like an Infector, might do
				// things it should not do unless it is triggered.
				Modifier modifier = (Modifier) actionCopy;
				modifier.resetLabels();
			}
		} // if
	} // resetLabels

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		
//		retValue = retValue && getPredicate() != null;
//		assert retValue;
		
		//retValue = retValue && getPredicate().sane();
		//assert retValue;
		
		retValue = retValue && (getAction() == null || getAction().sane());
		assert retValue;
		
		retValue = retValue && (actionCopy == null || actionCopy.sane());
		assert retValue;
		
		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getPredicate() {
		return (Predicate)eDynamicGet(TriggerPackage.TRIGGER__PREDICATE, TriggerPackage.Literals.TRIGGER__PREDICATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetPredicate() {
		return (Predicate)eDynamicGet(TriggerPackage.TRIGGER__PREDICATE, TriggerPackage.Literals.TRIGGER__PREDICATE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(Predicate newPredicate) {
		eDynamicSet(TriggerPackage.TRIGGER__PREDICATE, TriggerPackage.Literals.TRIGGER__PREDICATE, newPredicate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decorator getAction() {
		return (Decorator)eDynamicGet(TriggerPackage.TRIGGER__ACTION, TriggerPackage.Literals.TRIGGER__ACTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decorator basicGetAction() {
		return (Decorator)eDynamicGet(TriggerPackage.TRIGGER__ACTION, TriggerPackage.Literals.TRIGGER__ACTION, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Decorator newAction) {
		eDynamicSet(TriggerPackage.TRIGGER__ACTION, TriggerPackage.Literals.TRIGGER__ACTION, newAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TriggerPackage.TRIGGER__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case TriggerPackage.TRIGGER__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
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
			case TriggerPackage.TRIGGER__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case TriggerPackage.TRIGGER__ACTION:
				setAction((Decorator)newValue);
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
			case TriggerPackage.TRIGGER__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case TriggerPackage.TRIGGER__ACTION:
				setAction((Decorator)null);
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
			case TriggerPackage.TRIGGER__PREDICATE:
				return basicGetPredicate() != null;
			case TriggerPackage.TRIGGER__ACTION:
				return basicGetAction() != null;
		}
		return super.eIsSet(featureID);
	}

} //TriggerImpl

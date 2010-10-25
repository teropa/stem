package org.eclipse.stem.core.experiment.impl;

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

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.experiment.Experiment;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.scenario.Scenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.experiment.impl.ExperimentImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.stem.core.experiment.impl.ExperimentImpl#isComplete <em>Complete</em>}</li>
 *   <li>{@link org.eclipse.stem.core.experiment.impl.ExperimentImpl#getScenario <em>Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentImpl extends IdentifiableImpl implements Experiment {
	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Modifier> modifiers;
	/**
	 * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected Scenario scenario;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ExperimentImpl() {
		super();
		setURI(STEMURI.createURI(URI_TYPE_EXPERIMENT_SEGMENT + "/"
				+ STEMURI.generateUniquePart()));
		setTypeURI(STEMURI.EXPERIMENT_TYPE_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentPackage.Literals.EXPERIMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Modifier> getModifiers() {
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList<Modifier>(Modifier.class, this, ExperimentPackage.EXPERIMENT__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * @see {@link Experiment#getModificationSummary()}
	 */
	public List<String> getModificationSummary() {
		final List<String> retValue = new ArrayList<String>();
		for (Modifier modifier : getModifiers()) {
			retValue.addAll(modifier.getModificationSummary());
		} // for each Modifier
		return retValue;
	} // getModificationSummary

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isComplete() {
		boolean retValue = true;
		for (Modifier modifier : getModifiers()) {
			// Is this modifier complete?
			if (!modifier.isComplete()) {
				// No
				retValue = false;
				break;
			} // if 
		} // for each Modifier
		return retValue;
	} // isComplete

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario getScenario() {
		if (scenario != null && scenario.eIsProxy()) {
			InternalEObject oldScenario = (InternalEObject)scenario;
			scenario = (Scenario)eResolveProxy(oldScenario);
			if (scenario != oldScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentPackage.EXPERIMENT__SCENARIO, oldScenario, scenario));
			}
		}
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario basicGetScenario() {
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenario(Scenario newScenario) {
		Scenario oldScenario = scenario;
		scenario = newScenario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentPackage.EXPERIMENT__SCENARIO, oldScenario, scenario));
	}

	/**
	 * @see {@link Experiment#getParameterSummary()}
	 */
	public List<String> getParameterSummary() {
		// TODO implement ExperimentImpl.getParameterSummary
		return getModificationSummary();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Scenario updateScenario() {
		// Get the first modifier
		Modifier modifier = getModifiers().get(0);
		if(!modifier.isComplete()) {
			// If it's not complete, simply update the scenario
			modifier.updateScenario(getScenario());
		} else {
			// The first modifier is complete, get the next incomplete
			// modifier on the list and reset the "less significant" modifiers.
			// Think of it as binary counting switching bits on and off, but
			// the number of states is not 2 but depends on how many states
			// the modifier has. We assume at least one modifier is not complete
			// here, or this method wouldn't have been called.
			for(Modifier m : getModifiers()) {
				if(m.isComplete()) {
					m.reset();
					m.updateScenario(getScenario());
				} else {
					m.updateScenario(getScenario());
					break;
				}
			}
			
		}
		Scenario s =  getScenario();
		// We need to re-initialize since decorators might have been updated
		s.initialize();
		s.setProgress(0.0);
		return s;
	} // updateScenario

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Scenario initScenario() {
		// Skip the first modifier since it will update the
		// scenario in the first call to getNextSimulation()
		for(int i=1;i<getModifiers().size();++i) 
			getModifiers().get(i).updateScenario(getScenario());
		return getScenario();
	}

	/**
	 * @see org.eclipse.stem.core.common.impl.IdentifiableImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		assert retValue;

		retValue = getScenario() == null || getScenario().sane();
		assert retValue;
		
		for (Modifier modifier : getModifiers()) {
			retValue = modifier.sane();
			assert retValue;
		} // for each Modifier
		
		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExperimentPackage.EXPERIMENT__MODIFIERS:
				return getModifiers();
			case ExperimentPackage.EXPERIMENT__COMPLETE:
				return isComplete();
			case ExperimentPackage.EXPERIMENT__SCENARIO:
				if (resolve) return getScenario();
				return basicGetScenario();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExperimentPackage.EXPERIMENT__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends Modifier>)newValue);
				return;
			case ExperimentPackage.EXPERIMENT__SCENARIO:
				setScenario((Scenario)newValue);
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
			case ExperimentPackage.EXPERIMENT__MODIFIERS:
				getModifiers().clear();
				return;
			case ExperimentPackage.EXPERIMENT__SCENARIO:
				setScenario((Scenario)null);
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
			case ExperimentPackage.EXPERIMENT__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case ExperimentPackage.EXPERIMENT__COMPLETE:
				return isComplete() != COMPLETE_EDEFAULT;
			case ExperimentPackage.EXPERIMENT__SCENARIO:
				return scenario != null;
		}
		return super.eIsSet(featureID);
	}

	
} //ExperimentImpl

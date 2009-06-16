package org.eclipse.stem.diseasemodels.standard.impl;

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

import java.util.Random;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stochastic Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#getSeed <em>Seed</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticDiseaseModelImpl#getRandomGenerator <em>Random Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StochasticDiseaseModelImpl extends DiseaseModelImpl implements StochasticDiseaseModel {
	/**
	 * The default value of the '{@link #getSeed() <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed()
	 * @generated
	 * @ordered
	 */
	protected static final long SEED_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSeed() <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed()
	 * @generated
	 * @ordered
	 */
	protected long seed = SEED_EDEFAULT;
	
	/**
	 * This is an upper bound on the maximum amount of allowed noise. 
	 * In any stochastic model the noise should cause only a small purturbation
	 * of the deterministic model (perhaps of the order of the background death rate or about 1/50).
	 * The default value set here may be overridden by setter a setter method.
	 **/
	protected static double MAX_GAIN = 0.02;

	/**
	 * The default value of the '{@link #getRandomGenerator() <em>Random Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomGenerator()
	 * @generated
	 * @ordered
	 */
	protected static final Random RANDOM_GENERATOR_EDEFAULT = (Random)StandardFactory.eINSTANCE.createFromString(StandardPackage.eINSTANCE.getRandom(), "0");

	/**
	 * The cached value of the '{@link #getRandomGenerator() <em>Random Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomGenerator()
	 * @generated
	 * @ordered
	 */
	protected Random randomGenerator = RANDOM_GENERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StochasticDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STOCHASTIC_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSeed() {
		return seed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSeed(long newSeed) {
		long oldSeed = seed;
		seed = newSeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED, oldSeed, seed));
		randomGenerator.setSeed(newSeed);
	} // setSeed

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Random getRandomGenerator() {
		return randomGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED:
				return new Long(getSeed());
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR:
				return getRandomGenerator();
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
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED:
				setSeed(((Long)newValue).longValue());
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
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED:
				setSeed(SEED_EDEFAULT);
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
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED:
				return seed != SEED_EDEFAULT;
			case StandardPackage.STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR:
				return RANDOM_GENERATOR_EDEFAULT == null ? randomGenerator != null : !RANDOM_GENERATOR_EDEFAULT.equals(randomGenerator);
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
		result.append(" (seed: "); //$NON-NLS-1$
		result.append(seed);
		result.append(", randomGenerator: "); //$NON-NLS-1$
		result.append(randomGenerator);
		result.append(')');
		return result.toString();
	}

	public static double getMAX_GAIN() {
		return MAX_GAIN;
	}

	public static void setMAX_GAIN(double max_gain) {
		MAX_GAIN = max_gain;
	}

} //StochasticDiseaseModelImpl

package org.eclipse.stem.diseasemodels.standard.impl;

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
import java.util.Random;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
//import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
//import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Stochastic SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl#getSeed <em>Seed</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl#getRandomGenerator <em>Random Generator</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StochasticSIDiseaseModelImpl#getGain <em>Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StochasticSIDiseaseModelImpl extends SIImpl implements
		StochasticSIDiseaseModel {

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
	 * The default value of the '{@link #getGain() <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGain()
	 * @generated
	 * @ordered
	 */
	protected static final double GAIN_EDEFAULT = 0.01;
	/**
	 * The cached value of the '{@link #getGain() <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGain()
	 * @generated
	 * @ordered
	 */
	protected double gain = GAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * The constructor needs to be public so that the new disease wizard can
	 * create an instance of the class without using the factory.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public StochasticSIDiseaseModelImpl() {
		super();
	} // StochasticSIDiseaseModelImpl

	/**
	 * @param diseaseModelName
	 *            the name of the disease model
	 * @param backgroundMortalityRate
	 * @param infectiousMortality
	 * @param infectiousMortalityRate
	 *            the rate at which fatally infectious population members die
	 * @param transmissionRate
	 * @param recoveryRate rate at which goes back to susceptible
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 *            the time period for the rates (milliseconds)
	 * @param populationIdentifier
	 *            the identifier of the population affected by the disease
	 * @param gain 
	 * @return an initialized instance of DeterministicSIDiseaseModel
	 */
	public static final StochasticSIDiseaseModel createStochasticSIDiseaseModel(
			final String diseaseModelName,
			final double backgroundMortalityRate,
			final double infectiousMortalityRate,
			final double transmissionRate, 
			final double recoveryRate,
			final double nonLinearityCoefficient, final long timePeriod,
			final String populationIdentifier, double gain) {
		
		final StochasticSIDiseaseModel sirDiseaseModel = StandardFactory.eINSTANCE
				.createStochasticSIDiseaseModel();
		
		initializeSIDiseaseModel(sirDiseaseModel, diseaseModelName,
				backgroundMortalityRate,
				infectiousMortalityRate, transmissionRate, recoveryRate,
				nonLinearityCoefficient, timePeriod,
				populationIdentifier);
		
		sirDiseaseModel.setGain(gain);
		
		return sirDiseaseModel;
	} // createStochasticSIDiseaseModel

	/**
	 * ModelSpecificAdjustments for a Stochastic model adds noise to
	 * the I state. It will be propagated to other states automatically
	 * 
	 */
	
	public void doModelSpecificAdjustments(
			final LabelValue state) {
		final SILabelValue currentSI = (SILabelValue) state;
		double oldI = currentSI.getI();
		double incidence = currentSI.getIncidence();
		double newIncidence = incidence*computeNoise();
		double diff = newIncidence - incidence; 
		
		double newI = currentSI.getI() + diff;
		double newS = currentSI.getS() - diff;
		if(newI < 0.0) {
			double scale = (-newI) / currentSI.getI();
			if(Double.isInfinite(scale))
				scale = 0.0; // cancel noise if 0
			diff = diff * scale;
			newI = currentSI.getI() + diff; // 0
			newS = currentSI.getS() - diff;
		}
		if(newS < 0.0) {
			double scale = (-newS) / currentSI.getS();
			if(Double.isInfinite(scale))
				scale = 0.0; // cancel noise if 0
			diff = diff * scale;
			newI = currentSI.getI() + diff;
			newS = currentSI.getS() - diff; // 0
		}
		newIncidence = incidence + diff;
		currentSI.setS(newS);
		currentSI.setI(newI);
		currentSI.setIncidence(newIncidence); 
		return;
	} // doModelSpecificAdjustments
	
	@Override
	public boolean isDeterministic() {
		return true;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STOCHASTIC_SI_DISEASE_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED, oldSeed, seed));
		randomGenerator.setSeed(newSeed);
	}

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
	public double getGain() {
		return gain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGain(double newGain) {
		double oldGain = gain;
		gain = newGain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN, oldGain, gain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * By default this calls the static method StandardStochasticDiseaseModelImpl.computeNoise(gain, rand)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double computeNoise() {
		return StandardStochasticDiseaseModelImpl.computeNoise(gain, randomGenerator);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED:
				return getSeed();
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__RANDOM_GENERATOR:
				return getRandomGenerator();
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN:
				return getGain();
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
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED:
				setSeed((Long)newValue);
				return;
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN:
				setGain((Double)newValue);
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
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED:
				setSeed(SEED_EDEFAULT);
				return;
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN:
				setGain(GAIN_EDEFAULT);
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
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED:
				return seed != SEED_EDEFAULT;
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__RANDOM_GENERATOR:
				return RANDOM_GENERATOR_EDEFAULT == null ? randomGenerator != null : !RANDOM_GENERATOR_EDEFAULT.equals(randomGenerator);
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN:
				return gain != GAIN_EDEFAULT;
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
		if (baseClass == StochasticDiseaseModel.class) {
			switch (derivedFeatureID) {
				case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED: return StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED;
				case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__RANDOM_GENERATOR: return StandardPackage.STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR;
				default: return -1;
			}
		}
		if (baseClass == StandardStochasticDiseaseModel.class) {
			switch (derivedFeatureID) {
				case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN: return StandardPackage.STANDARD_STOCHASTIC_DISEASE_MODEL__GAIN;
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
		if (baseClass == StochasticDiseaseModel.class) {
			switch (baseFeatureID) {
				case StandardPackage.STOCHASTIC_DISEASE_MODEL__SEED: return StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__SEED;
				case StandardPackage.STOCHASTIC_DISEASE_MODEL__RANDOM_GENERATOR: return StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__RANDOM_GENERATOR;
				default: return -1;
			}
		}
		if (baseClass == StandardStochasticDiseaseModel.class) {
			switch (baseFeatureID) {
				case StandardPackage.STANDARD_STOCHASTIC_DISEASE_MODEL__GAIN: return StandardPackage.STOCHASTIC_SI_DISEASE_MODEL__GAIN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", gain: "); //$NON-NLS-1$
		result.append(gain);
		result.append(')');
		return result.toString();
	}

} // StochasticSIDiseaseModelImpl

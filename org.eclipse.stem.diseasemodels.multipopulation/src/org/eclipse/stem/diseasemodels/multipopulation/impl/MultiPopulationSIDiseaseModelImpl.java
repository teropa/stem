package org.eclipse.stem.diseasemodels.multipopulation.impl;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DoubleValue;
import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.DoubleValueMatrix;
import org.eclipse.stem.core.common.StringValue;
import org.eclipse.stem.core.common.StringValueList;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;
import org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.impl.CommonBorderRelationshipLabelImpl;
import org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelImpl;
import org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelValueImpl;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.impl.SIImpl;
import org.eclipse.stem.diseasemodels.standard.impl.SILabelValueImpl;
import org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.populationmodels.standard.impl.StandardFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Population SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getPopulationGroups <em>Population Groups</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getTransmissionRate <em>Transmission Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getRecoveryRate <em>Recovery Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getInfectiousMortalityRate <em>Infectious Mortality Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getPhysicallyAdjacentInfectiousProportion <em>Physically Adjacent Infectious Proportion</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.multipopulation.impl.MultiPopulationSIDiseaseModelImpl#getCharacteristicMixingDistance <em>Characteristic Mixing Distance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiPopulationSIDiseaseModelImpl extends StandardDiseaseModelImpl implements MultiPopulationSIDiseaseModel {
	/**
	 * The cached value of the '{@link #getPopulationGroups() <em>Population Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationGroups()
	 * @generated
	 * @ordered
	 */
	protected StringValueList populationGroups;
	

	/**
	 * The cached value of the '{@link #getTransmissionRate() <em>Transmission Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransmissionRate()
	 * @generated
	 * @ordered
	 */
	protected DoubleValueMatrix transmissionRate;

	/**
	 * The cached value of the '{@link #getRecoveryRate() <em>Recovery Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryRate()
	 * @generated
	 * @ordered
	 */
	protected DoubleValueList recoveryRate;

	/**
	 * The cached value of the '{@link #getInfectiousMortalityRate() <em>Infectious Mortality Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfectiousMortalityRate()
	 * @generated
	 * @ordered
	 */
	protected DoubleValueList infectiousMortalityRate;

	/**
	 * The default value of the '{@link #getPhysicallyAdjacentInfectiousProportion() <em>Physically Adjacent Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicallyAdjacentInfectiousProportion()
	 * @generated
	 * @ordered
	 */
	protected static final double PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION_EDEFAULT = 0.01;

	/**
	 * The cached value of the '{@link #getPhysicallyAdjacentInfectiousProportion() <em>Physically Adjacent Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicallyAdjacentInfectiousProportion()
	 * @generated
	 * @ordered
	 */
	protected double physicallyAdjacentInfectiousProportion = PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoadNetworkInfectiousProportion() <em>Road Network Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadNetworkInfectiousProportion()
	 * @generated
	 * @ordered
	 */
	protected static final double ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT = 0.05;

	/**
	 * The cached value of the '{@link #getRoadNetworkInfectiousProportion() <em>Road Network Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadNetworkInfectiousProportion()
	 * @generated
	 * @ordered
	 */
	protected double roadNetworkInfectiousProportion = ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT;
	/**
	 * The default value of the '{@link #getCharacteristicMixingDistance() <em>Characteristic Mixing Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristicMixingDistance()
	 * @generated
	 * @ordered
	 */
	protected static final double CHARACTERISTIC_MIXING_DISTANCE_EDEFAULT = 2.25;


	/**
	 * The cached value of the '{@link #getCharacteristicMixingDistance() <em>Characteristic Mixing Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristicMixingDistance()
	 * @generated
	 * @ordered
	 */
	protected double characteristicMixingDistance = CHARACTERISTIC_MIXING_DISTANCE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MultiPopulationSIDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueMatrix getTransmissionRate() {
		return transmissionRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransmissionRate(DoubleValueMatrix newTransmissionRate, NotificationChain msgs) {
		DoubleValueMatrix oldTransmissionRate = transmissionRate;
		transmissionRate = newTransmissionRate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE, oldTransmissionRate, newTransmissionRate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransmissionRate(DoubleValueMatrix newTransmissionRate) {
		if (newTransmissionRate != transmissionRate) {
			NotificationChain msgs = null;
			if (transmissionRate != null)
				msgs = ((InternalEObject)transmissionRate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE, null, msgs);
			if (newTransmissionRate != null)
				msgs = ((InternalEObject)newTransmissionRate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE, null, msgs);
			msgs = basicSetTransmissionRate(newTransmissionRate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE, newTransmissionRate, newTransmissionRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueList getRecoveryRate() {
		return recoveryRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecoveryRate(DoubleValueList newRecoveryRate, NotificationChain msgs) {
		DoubleValueList oldRecoveryRate = recoveryRate;
		recoveryRate = newRecoveryRate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE, oldRecoveryRate, newRecoveryRate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecoveryRate(DoubleValueList newRecoveryRate) {
		if (newRecoveryRate != recoveryRate) {
			NotificationChain msgs = null;
			if (recoveryRate != null)
				msgs = ((InternalEObject)recoveryRate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE, null, msgs);
			if (newRecoveryRate != null)
				msgs = ((InternalEObject)newRecoveryRate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE, null, msgs);
			msgs = basicSetRecoveryRate(newRecoveryRate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE, newRecoveryRate, newRecoveryRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleValueList getInfectiousMortalityRate() {
		return infectiousMortalityRate;
	}
	
	/**
	 * Get the particular infectious mortality rate for a specific population group by name
	 * @generated NOT
	 */
	public double getInfectiousMortality(String populationName) {
		// next get it's INDEX in the model
		// TODO we should encapsulate this code in a helper method
		int populationIndex = this.getPopulationIndex(populationName);
		if(getInfectiousMortalityRate() != null)
			return getInfectiousMortalityRate().getValues().get(populationIndex).getValue();
		else return 0.0; //default if not specified
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfectiousMortalityRate(DoubleValueList newInfectiousMortalityRate, NotificationChain msgs) {
		DoubleValueList oldInfectiousMortalityRate = infectiousMortalityRate;
		infectiousMortalityRate = newInfectiousMortalityRate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE, oldInfectiousMortalityRate, newInfectiousMortalityRate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfectiousMortalityRate(DoubleValueList newInfectiousMortalityRate) {
		if (newInfectiousMortalityRate != infectiousMortalityRate) {
			NotificationChain msgs = null;
			if (infectiousMortalityRate != null)
				msgs = ((InternalEObject)infectiousMortalityRate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE, null, msgs);
			if (newInfectiousMortalityRate != null)
				msgs = ((InternalEObject)newInfectiousMortalityRate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE, null, msgs);
			msgs = basicSetInfectiousMortalityRate(newInfectiousMortalityRate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE, newInfectiousMortalityRate, newInfectiousMortalityRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPhysicallyAdjacentInfectiousProportion() {
		return physicallyAdjacentInfectiousProportion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicallyAdjacentInfectiousProportion(double newPhysicallyAdjacentInfectiousProportion) {
		double oldPhysicallyAdjacentInfectiousProportion = physicallyAdjacentInfectiousProportion;
		physicallyAdjacentInfectiousProportion = newPhysicallyAdjacentInfectiousProportion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION, oldPhysicallyAdjacentInfectiousProportion, physicallyAdjacentInfectiousProportion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRoadNetworkInfectiousProportion() {
		return roadNetworkInfectiousProportion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadNetworkInfectiousProportion(double newRoadNetworkInfectiousProportion) {
		double oldRoadNetworkInfectiousProportion = roadNetworkInfectiousProportion;
		roadNetworkInfectiousProportion = newRoadNetworkInfectiousProportion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION, oldRoadNetworkInfectiousProportion, roadNetworkInfectiousProportion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCharacteristicMixingDistance() {
		return characteristicMixingDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacteristicMixingDistance(double newCharacteristicMixingDistance) {
		double oldCharacteristicMixingDistance = characteristicMixingDistance;
		characteristicMixingDistance = newCharacteristicMixingDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE, oldCharacteristicMixingDistance, characteristicMixingDistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValueList getPopulationGroups() {
		return populationGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPopulationGroups(StringValueList newPopulationGroups, NotificationChain msgs) {
		StringValueList oldPopulationGroups = populationGroups;
		populationGroups = newPopulationGroups;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS, oldPopulationGroups, newPopulationGroups);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationGroups(StringValueList newPopulationGroups) {
		if (newPopulationGroups != populationGroups) {
			NotificationChain msgs = null;
			if (populationGroups != null)
				msgs = ((InternalEObject)populationGroups).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS, null, msgs);
			if (newPopulationGroups != null)
				msgs = ((InternalEObject)newPopulationGroups).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS, null, msgs);
			msgs = basicSetPopulationGroups(newPopulationGroups, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS, newPopulationGroups, newPopulationGroups));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
				return basicSetPopulationGroups(null, msgs);
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
				return basicSetTransmissionRate(null, msgs);
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
				return basicSetRecoveryRate(null, msgs);
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE:
				return basicSetInfectiousMortalityRate(null, msgs);
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
				return getPopulationGroups();
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
				return getTransmissionRate();
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
				return getRecoveryRate();
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE:
				return getInfectiousMortalityRate();
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
				return getPhysicallyAdjacentInfectiousProportion();
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				return getRoadNetworkInfectiousProportion();
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				return getCharacteristicMixingDistance();
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
				setPopulationGroups((StringValueList)newValue);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
				setTransmissionRate((DoubleValueMatrix)newValue);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
				setRecoveryRate((DoubleValueList)newValue);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE:
				setInfectiousMortalityRate((DoubleValueList)newValue);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
				setPhysicallyAdjacentInfectiousProportion((Double)newValue);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				setRoadNetworkInfectiousProportion((Double)newValue);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				setCharacteristicMixingDistance((Double)newValue);
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
				setPopulationGroups((StringValueList)null);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
				setTransmissionRate((DoubleValueMatrix)null);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
				setRecoveryRate((DoubleValueList)null);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE:
				setInfectiousMortalityRate((DoubleValueList)null);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
				setPhysicallyAdjacentInfectiousProportion(PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION_EDEFAULT);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				setRoadNetworkInfectiousProportion(ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT);
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				setCharacteristicMixingDistance(CHARACTERISTIC_MIXING_DISTANCE_EDEFAULT);
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
				return populationGroups != null;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
				return transmissionRate != null;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
				return recoveryRate != null;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE:
				return infectiousMortalityRate != null;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
				return physicallyAdjacentInfectiousProportion != PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION_EDEFAULT;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				return roadNetworkInfectiousProportion != ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				return characteristicMixingDistance != CHARACTERISTIC_MIXING_DISTANCE_EDEFAULT;
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
		result.append(" (physicallyAdjacentInfectiousProportion: ");
		result.append(physicallyAdjacentInfectiousProportion);
		result.append(", roadNetworkInfectiousProportion: ");
		result.append(roadNetworkInfectiousProportion);
		result.append(", characteristicMixingDistance: ");
		result.append(characteristicMixingDistance);
		result.append(')');
		return result.toString();
	}

	@Override
	protected StandardDiseaseModelLabelValue computeDepartures(
			double fractionToDepart, StandardDiseaseModelLabelValue nextState) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#computeDeaths(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue,
	 *      long)
	 */
	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeathsDeltas(
			final STEMTime time, final StandardDiseaseModelLabel diseaseLabel, final StandardDiseaseModelLabelValue currentLabelValue, final long timeDelta, DiseaseModelLabelValue returnValue) {

		String thisPopulation = diseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
		final SILabelValue currentSI = (SILabelValue) currentLabelValue;
		
		final double adjustedInfectiousMortalityRate = getAdjustedInfectiousMortalityRate(timeDelta, thisPopulation);
		
		final double diseaseDeaths = adjustedInfectiousMortalityRate
				* currentSI.getI();

		SILabelValueImpl ret = (SILabelValueImpl)returnValue;
		ret.setS(0.0);
		ret.setI(-diseaseDeaths);
		ret.setIncidence(0.0);
		ret.setDiseaseDeaths(diseaseDeaths);
		
		return ret;
	} // computeBirthDeathsDeltas
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAdjustedInfectiousMortalityRate(long timeDelta, final String populationName) {
		// TODO this division can be eliminated if timeDelta==getTimePeriod
		return getInfectiousMortality(populationName)
		* ((double) timeDelta / (double) getTimePeriod());
	} // getAdjustedInfectiousMortalityRate



	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(STEMTime time,
			StandardDiseaseModelLabelValue currentState,
			StandardDiseaseModelLabel diseaseLabel, long timeDelta,
			DiseaseModelLabelValue returnValue) {
		
		// THIS method gets called multiple times, once for each population identifier
		// in the population model.
		// which population is "this"....
		final SILabelValue currentSI = (SILabelValue) currentState;
		String thisPopulation = diseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
				
		// next get it's INDEX in the model
		int populationIndex = getPopulationIndex(thisPopulation);
			
		// now we know the index of the current population being integrated.
		// Get the correct transmission rate list from the MATRIX
		EList<DoubleValue> transmissionVector = getTransmissionRate().getValueLists().get(populationIndex).getValues();
		
		// ALL the other disease parameters are also DoubleValueLists. We now iterate through all populations
		// get the specific rate parameters from EACH list based on this population index
		double thisRecoveryRate = 0.0;
		if(getRecoveryRate() != null) thisRecoveryRate = getRecoveryRate().getValues().get(populationIndex).getValue();
		
		
		//  NOW iterate over every population (including this one) to compute new infections
		//  this includes infections within a population group
		//  and all the cross terms
		double numberOfSusceptibleToInfected = 0.0;
		double numberSusceptible = currentSI.getS();
		Node thisNode = diseaseLabel.getNode();
		
		EList<StringValue> groupList = getPopulationGroups().getValues();
		
		for(int i = 0; i< transmissionVector.size(); i ++) {
			// We need to get the identifier of the ith population model
			String nextPop = groupList.get(i).getValue();
			
            //////////////////
			// 1. compute BETA for transmission from the ith population to this population
			 double specificTransmission = transmissionVector.get(i).getValue();
			 double adjustedTransmission = getAdjustedTransmissionRate(specificTransmission, timeDelta);
			 if(!this.isFrequencyDependent()) adjustedTransmission *= getTransmissionRateScaleFactor(diseaseLabel);
			 
			
			// we need to get the disease label for the ith population as well.
			// to get the on site number of infectios individuals of type i
			EList<NodeLabel> nodeLabels = thisNode.getLabels();
			for(int j = 0; j < nodeLabels.size(); j ++) {
				NodeLabel label = nodeLabels.get(j);
				if(label instanceof SILabel) {
					if (this == ((SILabel)label).getDecorator()) {
						StandardDiseaseModelLabel otherDiseaseLabel = (StandardDiseaseModelLabel) label;
						// now check the popualtion type
						String otherPopulation = otherDiseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
						if(otherPopulation.equals(nextPop)) {
							// Yes?
							// then we found the label for the correct next population
							
			
							// for this population we need to get the EFFECTIVE Infectious including
							// ALL neighboring nodes
							double onsiteInfectious = ((SILabel) otherDiseaseLabel).getTempValue().getI();
							final double effectiveInfectious = getNormalizedEffectiveInfectious(otherPopulation, thisNode, otherDiseaseLabel, onsiteInfectious);
							
						    // ADD up the new incidence
							numberOfSusceptibleToInfected += adjustedTransmission * numberSusceptible * effectiveInfectious;
						}
					}
				}// if it's an SI label
			}//for all labels in THIS node
		}// For all population in the model
		
		double numberOfInfectedToSusceptible = getAdjustedRecoveryRate(thisRecoveryRate, timeDelta) * currentSI.getI();
		
	
		// Determine delta S
		final double deltaS = - numberOfSusceptibleToInfected + numberOfInfectedToSusceptible;
		// Determine delta I
		final double deltaI = numberOfSusceptibleToInfected - numberOfInfectedToSusceptible;	
	
		SILabelValueImpl ret = (SILabelValueImpl)returnValue;
		ret.setS(deltaS);
		ret.setI(deltaI);
		ret.setIncidence(numberOfSusceptibleToInfected);
		ret.setDiseaseDeaths(0.0);
		return ret;
		
	}
	
	protected int getPopulationIndex(String thisPopulation) {
		// next get it's INDEX in the model
		// TODO we should encapsulate this code in a helper method
		int populationIndex = -1;
		EList<StringValue> groupList = getPopulationGroups().getValues();
		for(int i =0; i < groupList.size(); i ++) {
			String nextPop = groupList.get(i).getValue();
			if(nextPop.equalsIgnoreCase(thisPopulation)) {
			populationIndex = i;
			break;
			}	
		}
		if(populationIndex < 0) {
			// should never happen
			Activator.logError("MultiPopulationSIDiseaseModel.computeDiseaseDeltas() Error, Population named "+thisPopulation+" not found. check spelling !!", new Exception());
		}
		return populationIndex;
	}
	/**
	 * <!-- begin-user-doc -->
	 * Returns the time interval deltaT divided by the initial time period
	 * @param timeDelta
	 * @param specificTransmission
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double getAdjustedTransmissionRate(double specificTransmission, long timeDelta) {
		return (specificTransmission * ((double) timeDelta / (double) getTimePeriod()) );
	} // getAdjustedTransmissionRate
	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param timeDelta
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double getAdjustedRecoveryRate(double specificRecoveryRate, long timeDelta) {
		return (specificRecoveryRate * ((double) timeDelta / (double) getTimePeriod()) );
	} // getAdjustedRecoveryRate
	
	
	/**
	 * This method is used to scale the transmission rate.
 	 * it returns the local density divided by a "reference" density
	 * @param diseaseLabel the label being processed
	 * @return the transmission rate scale factor for the label being processed
	 */
	public double getTransmissionRateScaleFactor(
			StandardDiseaseModelLabel diseaseLabel) {
		
		double referenceDensity = getReferencePopulationDensity();
		// assert(referenceDensity > 0);
		// need editor check so ref density always >1. Default is 100.
		assert getArea(diseaseLabel.getPopulationLabel()) > 0.0;
		double localDensity = ((StandardDiseaseModelLabelValue)diseaseLabel.getTempValue()).getPopulationCount()/getArea(diseaseLabel.getPopulationLabel());
		return localDensity/referenceDensity;
	} // getTransmissionRateScaleFactor
	
	/**
	 * This method replaces the onsiteInfectious value 
	 * for a specific population type (by index)
	 * with an effectiveInfectious of a particular population group (by name)
	 * size based on mixing with neighboring sites. In this implementation the edges are bidirectional
	 * and have a fixed weight based on getPhysicallyAdjacentInfectiousProportion() (called in the helper method
	 * getInfectiousChangeFromMixing(). But the mixing is also weighted by the areas and populations of a site relative
	 * to the area and population of it's neighbors. Note that the value returned must be NORMALIZED by the total
	 * population because the product beta * S * Ieffective must have units of persons. Since S has units of persons
	 * the Ieffective must be dimensionless (normalized to the population). beta is the infection rate and has units
	 * of inverse time.
	 * @see org.eclipse.stem.diseasemodels.standard.SI.getNormalizedEffectiveInfectious
	 * @param targetPopulationName
	 * @param node
	 * @param diseaseLabel
	 * @param onsiteInfectious
	 * @generated NOT
	 * @return
	 */
	public double getNormalizedEffectiveInfectious(final String targetPopulationName, final Node node, final StandardDiseaseModelLabel diseaseLabel, final double onsiteInfectious) {
        // running tally of changes from mixing with other nodes
		double infectiousChangeFromMixing = 0.0;
		double borderDivisor = 0.0;
		double roadDivisor = 0.0;
		
		for (final Iterator<Edge> commonBorderEdgeIter = CommonBorderRelationshipLabelImpl
				.getCommonBorderEdgesFromNode(node).iterator(); commonBorderEdgeIter
				.hasNext();) {
			final Edge borderEdge = commonBorderEdgeIter.next();
			// If it exists, we're looking for the label this disease model
			// updates on the node at the other end of the border edge.
			final Node otherNode = borderEdge.getOtherNode(node);
			
			double characteristicMixingDistance = getCharacteristicMixingDistance();
			
			double mixingFactor = 0.0; 
			if (otherNode instanceof Region) {
				double otherAvgExtent = -1.0;
				for (final Iterator<NodeLabel> labelIter = otherNode.getLabels().iterator(); labelIter.hasNext();) {
					final NodeLabel nodeLabel = labelIter.next();
					// Is this an area label?
					if (nodeLabel instanceof AreaLabel) {
						// Yes
						final AreaLabel areaLabel = (AreaLabel) nodeLabel;
						otherAvgExtent = areaLabel.getCurrentAreaValue().getAverageExtent();
						break;
					}
				} // for
				// IF we have a valid area 
				if(otherAvgExtent >= 0.0) {
					mixingFactor = (characteristicMixingDistance/otherAvgExtent) ;
					if(mixingFactor > 1.0) mixingFactor = 1.0;
				}
			}
			
			
			// for EACH connected Node add up the infectious of the particular
			// population GROUPD
			infectiousChangeFromMixing += getInfectiousChangeFromMixing(this, otherNode, targetPopulationName, diseaseLabel, onsiteInfectious, mixingFactor);
		
			borderDivisor += mixingFactor*this.getLocalPopulation(this, otherNode, targetPopulationName);
		} // for each border edge
		
		for (final Iterator<Edge> roadEdgeIter = RoadTransportRelationshipLabelImpl.getRoadEdgesFromNode(node).iterator(); 	roadEdgeIter.hasNext();) {
			final Edge roadEdge = roadEdgeIter.next();
			
			// find the number of edges from the road edge - could be more than one
			// also, roads have differenct capacities
			final EdgeLabel edgeLabel = roadEdge.getLabel();
			// init the number of crossings or total road connections across the border
			double numCrossings = 1.0;
		
			if (edgeLabel instanceof RoadTransportRelationshipLabelImpl) {
				RoadTransportRelationshipLabelValueImpl roadLabelValue = (RoadTransportRelationshipLabelValueImpl)(edgeLabel.getCurrentValue());
				numCrossings = roadLabelValue.getNumberCrossings();
			}
			double infectiousProportion = getRoadNetworkInfectiousProportion() * numCrossings;
			
			// must never be greater than 1
			if(infectiousProportion > 1.0) infectiousProportion = 1.0;
			
			// If it exists, we're looking for the label this disease model
			// updates on the node at the other end of the border edge.
			final Node otherNode = roadEdge.getOtherNode(node);
		
			// sum up the changes from each connected node by population group (by name).
			// NOTE: some of these changes could be negative
			infectiousChangeFromMixing += getInfectiousChangeFromMixing(this, otherNode, targetPopulationName, diseaseLabel, onsiteInfectious, infectiousProportion);
			
			roadDivisor += infectiousProportion*this.getLocalPopulation(this, otherNode, targetPopulationName);
		} // for each road edge
		
	
		// return the sum normalized to the total population
		double denom = ((StandardDiseaseModelLabelValue)diseaseLabel.getTempValue()).getPopulationCount() + borderDivisor + roadDivisor;
		double retVal = 0.0;
		if (denom > 0.0) {
			retVal = ( onsiteInfectious + infectiousChangeFromMixing ) / denom;
		}
		
		
		return retVal;

	} // getNormalizedEffectiveInfectious
	
	
	
	/**
	 * This method correctly computes the mixing of the infectious population (onsite) with the infectious population
	 * at neighboring nodes
	 * @param diseaseModel
	 * @param the node
	 * @param diseaseLabel
	 * @param onsiteInfectious
	 * @param connectedInfectiousProportion (this is the weight given to the edge connection)
	 * @return the number of population members at a node infected by the disease modeled by diseaseModel
	 */
	protected double getInfectiousChangeFromMixing(final MultiPopulationSIDiseaseModel diseaseModel,
			final Node node, final String populationName, final StandardDiseaseModelLabel diseaseLabel, final double onsiteInfectious, double connectedInfectiousProportion) {
	
		// infectious from other sites mixing here at site 0
		double mixing = 0.0;
			
		for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter
				.hasNext();) {
			final NodeLabel nodeLabel = labelIter.next();
			// Is this a disease label?
			if (nodeLabel instanceof StandardDiseaseModelLabel) {
				final IntegrationLabel otherSILabel = (IntegrationLabel) nodeLabel;
				// Yes
				// Is it updated by this disease model?
				if (diseaseModel == otherSILabel.getDecorator()) {
					
					
					// CHECK THE POPULATION OF THE NEIGHBOR
					StandardDiseaseModelLabel checkLabel = (StandardDiseaseModelLabel)otherSILabel;
					String checkPopulation = checkLabel.getPopulationModelLabel().getPopulationIdentifier();
					if(checkPopulation.equals(populationName)) {
						if(this.isFrequencyDependent()) {
							double Iother = (((SILabelValue)otherSILabel.getTempValue())).getI();
							//double Iother = otherSILabel.getCurrentSIValue().getI();
							double mixingFactor = connectedInfectiousProportion;					
							mixing = Iother * mixingFactor;
						} 
					// break ? only one per population?
					}//if(checkPopulation.equals(populationName)) 
					
				} // if
			}
		} // for

		return mixing;
	} // getInfectiousChangeFromMixing
	
	
	
	

	/**
	 * Get the onsite total population for a particular population group by name
	 * @param diseaseModel
	 * @param node
	 * @return
	 */
    private double getLocalPopulation(final MultiPopulationSIDiseaseModel diseaseModel, Node node,  final String populationName) {
    	double totalPopulation = 0.0;
    	for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter.hasNext();) {
    		final NodeLabel nodeLabel = labelIter.next();
    		// Is this a disease label?
    		if (nodeLabel instanceof StandardDiseaseModelLabel) {
    			final IntegrationLabel otherSILabel = (IntegrationLabel) nodeLabel;
    			// Yes
    			// Is it updated by this disease model?
    			if (diseaseModel == otherSILabel.getDecorator()) {
    				

    				// CHECK THE POPULATION OF THE NEIGHBOR
					StandardDiseaseModelLabel checkLabel = (StandardDiseaseModelLabel)otherSILabel;
					String checkPopulation = checkLabel.getPopulationModelLabel().getPopulationIdentifier();
					if(checkPopulation.equals(populationName)) {
						totalPopulation = ((StandardDiseaseModelLabelValue)otherSILabel.getTempValue()).getPopulationCount();
						return totalPopulation;
					}//if(checkPopulation.equals(populationName)) 
    				
    				
    			}
    		     
    		}
    	}
    	return 0.0;
    }
	  

	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSILabel();
	}

	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSILabelValue();
	}

	@Override
	public DiseaseModelState createDiseaseModelState() {
		return StandardFactory.eINSTANCE.createSIDiseaseModelState();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#createInfector()
	 */
	@Override
	public Infector createInfector() {
		SIInfector retValue = StandardFactory.eINSTANCE.createSIInfector();
		retValue.setDiseaseName(this.getDiseaseName());
		retValue.setPopulationIdentifier(getPopulationIdentifier());
		return retValue;
	} // createInfector

	public void doModelSpecificAdjustments(LabelValue label) {
		// Nothing to do here...
	}
	
	

	/**
	 * We need to override this method to return all population model labels for the population groups
	 * 
	 * @param populationIdentifier
	 *            the population being labeled
	 * @param graph
	 *            the graph to search
	 * @return the PopulationLabel instances of the graph that match the
	 *         identifier.
	 */
	@Override
	protected Collection<PopulationModelLabel> getPopulationModelLabels(
			final String populationIdentifier, final Graph graph) {
		final List<PopulationModelLabel> retValue = new ArrayList<PopulationModelLabel>();

		// Iterate through all of the population labels in the graph
		EList<NodeLabel> labels = graph.getNodeLabelsByTypeURI(
				PopulationModelLabel.URI_TYPE_DYNAMIC_POPULATION_LABEL);
		for (NodeLabel pl:labels) {
			final PopulationModelLabel populationLabel = (PopulationModelLabel) pl;
			// Is this label for the population we're looking for?
			boolean keep = false;
//			if (populationLabel.getPopulationIdentifier().equals(
//					populationIdentifier)) keep = true;
//			else
				for(StringValue g:this.getPopulationGroups().getValues())
					if(g.getValue().equals(populationLabel.getPopulationIdentifier())) {keep=true;break;}
					
			if (keep) {
				// Yes
				// If there is a problem with the "node uri" of the population
				// label then it would not have been associated with a node
				// instance in the graph at this point. This is a problem for
				// disease models that are trying to label the node (there isn't
				// one!). So filter out those mistakes here.

				// Does the population label have an associated node?
				if (populationLabel.getNode() != null) {
					// Yes
					retValue.add(populationLabel);
				} // if the population label has a node
			} // if the population we're looking for
		} // for each population label

		return retValue;
	} // getPopulationLabels

	/**
	 * We need to override to check all population groups
	 */
	
	@Override
	public void prepare(Model model, STEMTime time) {

		for(StringValue sv:this.getPopulationGroups().getValues()) {
			boolean found = findPopulationModel(model, sv.getValue());
			
			if(!found) {
				// Create a new standard population model
				StandardPopulationModel spm = StandardFactoryImpl.eINSTANCE.createStandardPopulationModel();
				spm.setPopulationIdentifier(sv.getValue());
				String title = "Auto Generated "+sv.getValue()+" population model";
				String name = "auto_gen_"+sv.getValue()+"_population_model";
				spm.setURI(STEMURI.createURI(name+"/"+STEMURI.generateUniquePart()));
				spm.setName(name);
				spm.getDublinCore().setTitle(title);
				model.getNodeDecorators().add(0, spm);
			}
		}
	}
	
	@Override
	public boolean isDeterministic() {
		return true;
	}
	
} //MultiPopulationSIDiseaseModelImpl

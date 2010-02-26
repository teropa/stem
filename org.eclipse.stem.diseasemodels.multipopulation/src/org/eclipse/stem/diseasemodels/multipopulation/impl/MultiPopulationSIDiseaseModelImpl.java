/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation.impl;

import java.util.Collection;
import java.math.BigDecimal;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.common.DoubleValueList;
import org.eclipse.stem.core.common.DoubleValueMatrix;
import org.eclipse.stem.core.common.StringValueList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;

import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;

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
	protected static final double PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION_EDEFAULT = 0.0;

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
	protected static final double ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT = 0.0;

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
		result.append(')');
		return result.toString();
	}

	@Override
	protected StandardDiseaseModelLabelValue computeDepartures(
			double fractionToDepart, StandardDiseaseModelLabelValue nextState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeathsDeltas(
			STEMTime time, StandardDiseaseModelLabelValue currentLabelValue,
			long timeDelta, DiseaseModelLabelValue returnValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(STEMTime time,
			StandardDiseaseModelLabelValue currentState,
			StandardDiseaseModelLabel diseaseLabel, long timeDelta,
			DiseaseModelLabelValue returnValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected StandardDiseaseModelLabelValue getMigrationDeltas(
			StandardDiseaseModelLabel diseaseLabel, STEMTime time,
			DiseaseModelLabelValue returnValue) {
		// TODO Auto-generated method stub
		return null;
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

} //MultiPopulationSIDiseaseModelImpl

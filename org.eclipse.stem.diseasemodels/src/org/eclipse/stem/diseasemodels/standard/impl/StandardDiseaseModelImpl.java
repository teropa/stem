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

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.SimpleDataExchangeLabelValue;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.impl.CommonBorderRelationshipLabelImpl;
import org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelImpl;
import org.eclipse.stem.definitions.labels.impl.RoadTransportRelationshipLabelValueImpl;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getTotalPopulationCount <em>Total Population Count</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getTotalPopulationCountReciprocal <em>Total Population Count Reciprocal</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getTotalArea <em>Total Area</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getReferencePopulationDensity <em>Reference Population Density</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getRoadNetworkInfectiousProportion <em>Road Network Infectious Proportion</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getCharacteristicMixingDistance <em>Characteristic Mixing Distance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StandardDiseaseModelImpl extends DiseaseModelImpl
		implements StandardDiseaseModel {
	/**
	 * The default value of the '{@link #getTotalPopulationCount() <em>Total Population Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCount()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_POPULATION_COUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalPopulationCount() <em>Total Population Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCount()
	 * @generated
	 * @ordered
	 */
	protected double totalPopulationCount = TOTAL_POPULATION_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalPopulationCountReciprocal() <em>Total Population Count Reciprocal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCountReciprocal()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalPopulationCountReciprocal() <em>Total Population Count Reciprocal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCountReciprocal()
	 * @generated
	 * @ordered
	 */
	protected double totalPopulationCountReciprocal = TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalArea() <em>Total Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalArea()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_AREA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalArea() <em>Total Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalArea()
	 * @generated
	 * @ordered
	 */
	protected double totalArea = TOTAL_AREA_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferencePopulationDensity() <em>Reference Population Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencePopulationDensity()
	 * @generated
	 * @ordered
	 */
	protected static final double REFERENCE_POPULATION_DENSITY_EDEFAULT = 100.0;

	/**
	 * The cached value of the '{@link #getReferencePopulationDensity() <em>Reference Population Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencePopulationDensity()
	 * @generated
	 * @ordered
	 */
	protected double referencePopulationDensity = REFERENCE_POPULATION_DENSITY_EDEFAULT;

	
		
	/**
	 * The default value of the '{@link #getRoadNetworkInfectiousProportion() <em>Road Network Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadNetworkInfectiousProportion()
	 * @generated
	 * @ordered
	 */
	protected static final double ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT = 0.01;

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
	 * We only need one of these.
	 * 
	 * @see #updateLabels(STEMTime, long)
	 */
	protected StandardDiseaseModelLabelValue departures = (StandardDiseaseModelLabelValue) createDiseaseModelLabelValue();

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardDiseaseModelImpl() {
		super();
	}

	/**
	 * @param standardDiseaseModel
	 *            the StandardDiseaseModel disease model to be initialized
	 * @param diseaseModelName
	 * @param backgroundMortalityRate
	 * @param immunityLossRate
	 * @param incubationRate
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 * @param populationIdentifier
	 */
	protected static StandardDiseaseModel initializeStandardDiseaseModel(
			final StandardDiseaseModel standardDiseaseModel,
			final String diseaseModelName,
			final double backgroundMortalityRate, final long timePeriod,
			final String populationIdentifier) {
		DiseaseModelImpl.initializeDiseaseModel(standardDiseaseModel,
				diseaseModelName, backgroundMortalityRate, timePeriod,
				populationIdentifier);

		return standardDiseaseModel;
	} // initializeStandardDiseaseModel

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalPopulationCount() {
		return totalPopulationCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalPopulationCount(double newTotalPopulationCount) {
		double oldTotalPopulationCount = totalPopulationCount;
		totalPopulationCount = newTotalPopulationCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT, oldTotalPopulationCount, totalPopulationCount));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalPopulationCountReciprocal() {
		return totalPopulationCountReciprocal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalArea() {
		return totalArea;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalArea(double newTotalArea) {
		double oldTotalArea = totalArea;
		totalArea = newTotalArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA, oldTotalArea, totalArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReferencePopulationDensity() {
		return referencePopulationDensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencePopulationDensity(double newReferencePopulationDensity) {
		double oldReferencePopulationDensity = referencePopulationDensity;
		referencePopulationDensity = newReferencePopulationDensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY, oldReferencePopulationDensity, referencePopulationDensity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION, oldRoadNetworkInfectiousProportion, roadNetworkInfectiousProportion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE, oldCharacteristicMixingDistance, characteristicMixingDistance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addToTotalPopulationCount(double populationCount) {
		setTotalPopulationCount(getTotalPopulationCount() + populationCount);
	} // addToTotalPopulationCount

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double computeTotalPopulationCountReciprocal() {
		return totalPopulationCountReciprocal = 1.0 / getTotalPopulationCount();
	} // computeTotalPopulationCountReciprocal

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addToTotalArea(double area) {
		setTotalArea(getTotalArea() + area);
	} // addToTotalArea

	/**
	 * calculateDelta will use the current label values updated by 
	 * the disease model and upon return the delta label values
	 * are set with an estimate of the derivatives to advance to the
	 * next step  
	 * 
	 * @param time current time
	 * @param timeDelta delta time  step
	 * @param labels The labels to update
	 */

	public void calculateDelta(STEMTime time, long timeDelta, EList<DynamicLabel> labels) {
		// Iterate through each of the labels we need to update.		
		// Place holders to keep delta values. 
		
		DiseaseModelLabelValue birthDeathsDelta = this.createDiseaseModelLabelValue();
		DiseaseModelLabelValue diseaseDelta = this.createDiseaseModelLabelValue();
	
		for (final Iterator<DynamicLabel> currentStateLabelIter = labels
				.iterator(); currentStateLabelIter.hasNext();) {
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();

			
			assert diseaseLabel.getPopulationLabel().getPopulationIdentifier()
					.equals(getPopulationIdentifier());
			
			// This current state of the disease for this label probed for the 
			// next delta
			
			final StandardDiseaseModelLabelValue currentProbeState = (StandardDiseaseModelLabelValue)diseaseLabel
					.getProbeValue();


			// 1) Compute Birth and Deaths state delta changes
			final StandardDiseaseModelLabelValue diseaseDeathDeltas = computeDiseaseDeathsDeltas(time, diseaseLabel, currentProbeState, timeDelta, birthDeathsDelta);
				
				
			// 2) Compute the delta changes caused  by the Disease itself
			final StandardDiseaseModelLabelValue diseaseDeltas = computeDiseaseDeltas(time, currentProbeState, diseaseLabel, timeDelta, diseaseDelta);
			
			 //  Just capture the incidence that was passed on from computeTransistions
			final double incidence = diseaseDeltas.getIncidence();

			/*
			 * 5) Record the new state variable values.
			 * 
			 * These will become the current state variable values at the end of
			 * the current simulation cycle and before the next.
			 */

			// This is the delta disease label
			final StandardDiseaseModelLabelValue deltaState = (StandardDiseaseModelLabelValue)diseaseLabel
					.getDeltaValue();

			
			// Reset the state
			deltaState.reset();
			
			
			// 1) Add birth/death deltas and set the departures
			deltaState.add((IntegrationLabelValue)diseaseDeathDeltas);
			if(diseaseDeathDeltas.getDiseaseDeaths() > 0.0) 
				deltaState.getDepartures().put(diseaseLabel.getNode(), diseaseDeathDeltas.getDiseaseDeaths());
				
			// 2) Disease deltas
			deltaState.add((IntegrationLabelValue)diseaseDeltas);
		
			// and pass on the incidence
			deltaState.setIncidence(incidence);
			
			birthDeathsDelta.reset();
			diseaseDelta.reset();
				
		} // for
	}

	
	public void applyExternalDeltas(STEMTime time, long timeDelta, EList<DynamicLabel> labels) {
 		for (final Iterator<DynamicLabel> currentStateLabelIter = labels
				.iterator(); currentStateLabelIter.hasNext();) {
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
			
			StandardDiseaseModelLabelValue myDelta = (StandardDiseaseModelLabelValue)diseaseLabel.getDeltaValue();
			Node n = diseaseLabel.getNode();
			
			
			// Find other labels on the node that wants to exchange data
			
			EList<NodeLabel> labs = n.getLabels();
			for(NodeLabel l:labs) {
				if(l instanceof IntegrationLabel && !l.equals(diseaseLabel)
						&& ((IntegrationLabel)l).getIdentifier().equals(diseaseLabel.getIdentifier())) {
					SimpleDataExchangeLabelValue sdeLabelValue = (SimpleDataExchangeLabelValue)((IntegrationLabel)l).getDeltaValue();
					Map<Node, Double>arrivals = sdeLabelValue.getArrivals();
					Map<Node, Double>departures = sdeLabelValue.getDepartures();
					if(arrivals == null || departures == null) {
						Activator.logError("Error, null arrivals or departures for label "+l, new Exception());
						continue;
					}
					// Arrivals
					for (Entry<Node,Double> entry : arrivals.entrySet()) {
					//for(Node n2:arrivals.keySet()) {
						// Arrivals are births and goes into the S state if the node is the local node.
						if(entry.getKey().equals(n))
							myDelta.setS(myDelta.getS() + entry.getValue().doubleValue());
						else { // For other nodes, it's migration of population
							double inflow = entry.getValue().doubleValue();
							// Find the corresponding disease label on the other node
							for(NodeLabel nl:entry.getKey().getLabels())
								if(nl instanceof StandardDiseaseModelLabel && ((StandardDiseaseModelLabel)nl).getDecorator().equals(this)) {
									StandardDiseaseModelLabelValue value = (StandardDiseaseModelLabelValue)EcoreUtil.copy(((StandardDiseaseModelLabel)nl).getTempValue()); 
									
									if(value.getPopulationCount() > 0.0)
										value.scale(inflow/value.getPopulationCount());
									
									myDelta.add((IntegrationLabelValue)value);
								}
						}
					}
					
					// Departures
					for(Entry<Node,Double> entry : departures.entrySet()) {
						// Departures are either deaths or population moving to other nodes, hence we substract from the local node.
						
						StandardDiseaseModelLabelValue currentState = null;
						if(entry.getKey().equals(n)) 
							currentState = (StandardDiseaseModelLabelValue)EcoreUtil.copy((StandardDiseaseModelLabelValue)diseaseLabel.getProbeValue()); // Should be safe to use probe value for deaths
						else
							currentState = (StandardDiseaseModelLabelValue)EcoreUtil.copy((StandardDiseaseModelLabelValue)diseaseLabel.getTempValue()); // Need to use temp value for migration or an inbalance will occyr
					
						double populationCount = currentState.getPopulationCount();
						double outflow = entry.getValue().doubleValue();
						double factor = outflow/populationCount;
						if(Double.isNaN(factor) || Double.isInfinite(factor)) factor = 0.0; //safe					
						currentState.scale(factor);
							// Remember disease deaths since they will be overwritten by sub
						myDelta.sub((IntegrationLabelValue)currentState);
					}	
				}
			}

		}
 		
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				return getTotalPopulationCount();
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL:
				return getTotalPopulationCountReciprocal();
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				return getTotalArea();
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				return getReferencePopulationDensity();
			case StandardPackage.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				return getRoadNetworkInfectiousProportion();
			case StandardPackage.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				return getCharacteristicMixingDistance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				setTotalPopulationCount((Double)newValue);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				setTotalArea((Double)newValue);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				setReferencePopulationDensity((Double)newValue);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				setRoadNetworkInfectiousProportion((Double)newValue);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				setCharacteristicMixingDistance((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				setTotalPopulationCount(TOTAL_POPULATION_COUNT_EDEFAULT);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				setTotalArea(TOTAL_AREA_EDEFAULT);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				setReferencePopulationDensity(REFERENCE_POPULATION_DENSITY_EDEFAULT);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				setRoadNetworkInfectiousProportion(ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				setCharacteristicMixingDistance(CHARACTERISTIC_MIXING_DISTANCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				return totalPopulationCount != TOTAL_POPULATION_COUNT_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL:
				return totalPopulationCountReciprocal != TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				return totalArea != TOTAL_AREA_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				return referencePopulationDensity != REFERENCE_POPULATION_DENSITY_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				return roadNetworkInfectiousProportion != ROAD_NETWORK_INFECTIOUS_PROPORTION_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__CHARACTERISTIC_MIXING_DISTANCE:
				return characteristicMixingDistance != CHARACTERISTIC_MIXING_DISTANCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * Standard disease models do not update the labels, it's the
	 * task of the Solver to do that.
	 * 
	 * Standard Disease Models 
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(org.eclipse.stem.core.graph.Graph,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	@Override
	public void updateLabels(final STEMTime time, final long timeDelta, int cycle) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Populate the pipe system nodes initially
	 */
	
	
	
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#initializeDiseaseState(org.eclipse.stem.diseasemodels.standard.DiseaseModelState,
	 *      org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel)
	 */
	@Override
	public DiseaseModelState initializeDiseaseState(
			final DiseaseModelState diseaseModelState,
			final DiseaseModelLabel diseaseModelLabel) {

		final PopulationLabel populationLabel = diseaseModelLabel
				.getPopulationLabel();
		final double populationCount = populationLabel
				.getCurrentPopulationValue().getCount();

		// Accumulate the population count in the disease model
		addToTotalPopulationCount(populationCount);

		double area = getArea(populationLabel);
		// If we have a bad data set it could be that the area would be
		// unspecified or zero.
		// Do we have a bad area value?
		if (area <= 0.0) {
			// Yes
			reportBadAreaValue(populationLabel, area);
			area = 1.0;
		} // if bad area value

		// Accumulate the area in the disease model so we'll know the total when
		// we do our next pass and compute the area ratio
		addToTotalArea(area);
	
		return diseaseModelState;
	} // initializeDiseaseState

	/**
	 * Here we compute and set the ratio between the total area and the area
	 * used for this {@link DiseaseModelLabel}. This value is used to determine
	 * the <em>transmission scale factor</em>.
	 * 
	 * @see #computeTransitions(StandardDiseaseModelLabelValue,
	 *      StandardDiseaseModelLabel, long)
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#initializeDiseaseState(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel)
	 */
	@Override
	public void initializeDiseaseState(final DiseaseModelLabel diseaseModelLabel) {
		final StandardDiseaseModelState sdms = (StandardDiseaseModelState) diseaseModelLabel
				.getDiseaseModelState();
		// Is there a population ?
		if (getTotalPopulationCount() > 0.0) {
			// Yes
			double area = getArea(diseaseModelLabel.getPopulationLabel());
			// Do we have a bad area value?
			if (area <= 0.0) {
				// Yes
				reportBadAreaValue(diseaseModelLabel.getPopulationLabel(), area);
				area = 1.0;
			} // if bad area value

			final double ratio = getTotalArea() / area;
			sdms.setAreaRatio(ratio);
		}
	} // initializeDiseaseState

	
	/**
	 * This method replaces the onsiteInfectious value with an effectiveInfectious population
	 * size based on mixing with neighboring sites. In this implementation the edges are bidirectional
	 * and have a fixed weight based on getPhysicallyAdjacentInfectiousProportion() (called in the helper method
	 * getInfectiousChangeFromMixing(). But the mixing is also weighted by the areas and populations of a site relative
	 * to the area and population of it's neighbors. Note that the value returned must be NORMALIZED by the total
	 * population because the product beta * S * Ieffective must have units of persons. Since S has units of persons
	 * the Ieffective must be dimensionless (normalized to the population). beta is the infection rate and has units
	 * of inverse time.
	 * @see org.eclipse.stem.diseasemodels.standard.SI.getNormalizedEffectiveInfectious
	 * @param node the node we are currently looking at to compute the next disease state
	 * @param diseaseLabel the label for the current disease computation
	 * @param onsiteInfectious the number of infectious people on site (at the node above)
	 * @generated NOT
	 */
	public double getNormalizedEffectiveInfectious(final Node node, final StandardDiseaseModelLabel diseaseLabel, final double onsiteInfectious) {
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
			StandardDiseaseModelLabel neighborLabel = null;
			// sum up the changes from each connected node.
			// NOTE: some of these changes could be negative
			
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
			
			infectiousChangeFromMixing += getInfectiousChangeFromMixing(this, otherNode, diseaseLabel, onsiteInfectious, mixingFactor);
			borderDivisor += mixingFactor*this.getLocalPopulation(this, otherNode);
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
			StandardDiseaseModelLabel neighborLabel = null;
			// sum up the changes from each connected node.
			// NOTE: some of these changes could be negative
			infectiousChangeFromMixing += getInfectiousChangeFromMixing(this, otherNode, diseaseLabel, onsiteInfectious, infectiousProportion);
			
			roadDivisor += infectiousProportion*this.getLocalPopulation(this, otherNode);
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
	 * 
	 * @param diseaseModel
	 * @param node
	 * @return
	 */
    private double getLocalPopulation(final StandardDiseaseModel diseaseModel, Node node) {
    	for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter.hasNext();) {
    		final NodeLabel nodeLabel = labelIter.next();
    		// Is this a disease label?
    		if (nodeLabel instanceof StandardDiseaseModelLabel) {
    			final IntegrationLabel otherSILabel = (IntegrationLabel) nodeLabel;
    			// Yes
    			// Is it updated by this disease model?
    			if (diseaseModel == otherSILabel.getDecorator()) 
    		     return ((StandardDiseaseModelLabelValue)otherSILabel.getTempValue()).getPopulationCount();
    		}
    	}
    	return 0.0;
    }
    
    
    
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
	protected double getInfectiousChangeFromMixing(final StandardDiseaseModel diseaseModel,
			final Node node, final StandardDiseaseModelLabel diseaseLabel, final double onsiteInfectious, double connectedInfectiousProportion) {
		double retValue = 0.0;

		// the local area
		//double a0 = getArea(diseaseLabel.getPopulationLabel());
		// the local population

		//double p0 = ((StandardDiseaseModelLabelValue)diseaseLabel.getTempValue()).getPopulationCount();
		
		// infectious from other sites mixing here at site 0
		double mixing = 0.0;
			
		for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter
				.hasNext();) {
			final NodeLabel nodeLabel = labelIter.next();
			// Is this a disease label?
			if (nodeLabel instanceof StandardDiseaseModelLabel) {
				final StandardDiseaseModelLabel otherSILabel = (StandardDiseaseModelLabel) nodeLabel;
				// Yes
				// Is it updated by this disease model?
				if (diseaseModel == otherSILabel.getDecorator() && otherSILabel.getPopulationLabel().getPopulationIdentifier().equals(diseaseLabel.getPopulationLabel().getPopulationIdentifier())) {
					if(this.isFrequencyDependent()) {
						double Iother = (((SILabelValue)otherSILabel.getTempValue())).getI();
						//double Iother = otherSILabel.getCurrentSIValue().getI();
						double mixingFactor = connectedInfectiousProportion;					
						mixing = Iother * mixingFactor;
					} else {
//						double a1 = getArea(otherSILabel.getPopulationLabel());
//						double p1 = ((StandardDiseaseModelLabelValue)otherSILabel.getTempValue()).getPopulationCount();
//						double Iother = (otherSILabel.getTempValue()).getI();
//						double mixingFactor = (a0*p1 + a1*p0)* connectedInfectiousProportion /(a1* (p1+p0)) ;
					
//						mixing = Iother * mixingFactor;
					}
					
					break;
				} // if
			}
		} // for

		return mixing;
	} // getInfectiousChangeFromMixing
	
	/**
	 * @param populationLabel
	 *            the population label that labels the node
	 * @return the area of the node associated with the label
	 */
	public double getArea(final PopulationLabel populationLabel) {
		double retValue = 0.0;

		// The population label could have an area specified for the population
		// that we should use instead of the area of the region labeled by the
		// population label. This value would be specified if the population was
		// densely packed into a small area of the larger region, for instance
		// like a city in an otherwise large desert.

		retValue = populationLabel.getPopulatedArea();

		// Is there an area specified for the population?
		if (retValue == 0.0) {
			// No
			// Ok, go find the area label and return the area of the region
			for (final Iterator<NodeLabel> labelIter = populationLabel.getNode()
					.getLabels().iterator(); labelIter.hasNext();) {
				final NodeLabel nodeLabel = labelIter.next();
				// Is this an area label?
				if (nodeLabel instanceof AreaLabel) {
					// Yes
					final AreaLabel areaLabel = (AreaLabel) nodeLabel;
					retValue = areaLabel.getCurrentAreaValue().getArea();
					break;
				}
			} // for
		} // If no population area specified

		return retValue;
	} // getArea

	/**
	 * @param populationLabel
	 * @param area
	 */
	private void reportBadAreaValue(final PopulationLabel populationLabel,
			double area) {
		// The bad value could be specified for the node or be an override
		// value specified for the population.
		// Is the bad value from the node?
		if (populationLabel.getPopulatedArea() == 0.0) {
			// Yes
			Activator.logError("The area value of \"" + area
					+ "\" specified for \""
					+ populationLabel.getNode().toString()
					+ "\" is not greater than zero (0.0)", null);
		} // if bad value for node area
		else {
			Activator.logError("The area value of \"" + area
					+ "\" specified for the population \""
					+ populationLabel.getName() + "\" for the region \""
					+ populationLabel.getNode().toString()
					+ "\" is not greater than zero (0.0)", null);
		}
	} // reportBadAreaValue

	/**
	 * Perform disease model specific changes to the additions to each state and
	 * to the deaths from each state. This method is used to perform stochastic
	 * modifications to the next disease state.
	 * 
	 * @param currentState
	 *            the current disease state
	 */
	public void doModelSpecificAdjustments(
			final StandardDiseaseModelLabelValue currentState) {
		// Do nothing here. Sub-classes override this method to make changes
	} // doModelSpecificAdjustments

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEffectiveInfectious(Node node, StandardDiseaseModelLabel diseaseLabel, double onsiteInfectious) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeterministic() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * computeDiseaseDeltas. This method calculates the delta changes for each disease state depending 
	 * on disease parameters and mixing factors
	 * 
	 * @param time 
	 * 		  	  STEM time
	 * @param currentState
	 *            the current state of the population
	 * @param diseaseLabel
	 *            the disease label for which the state transitions are being
	 *            computed.
	 * @param timeDelta
	 *            the time period (milliseconds) over which the population
	 *            members transition to new states
	 * @param cycle
	 * 			  the simulation cycle we're in
	 * @return a disease state label value that contains the delta changes in
	 * 		   population members for each state.
	 */
	
	public abstract StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, 
			final long timeDelta, 
			DiseaseModelLabelValue returnValue);

	/**
	 * computeDiseaseDeathsDeltas Compute the delta vector resulting from disease deaths
	 * 
	 * @param time 
	 * 			  STEM time
	 * @param diseaseLabel
	 * @param currentLabelValue
	 *            the current label value of the disease model
	 * @param timeDelta
	 *            the time period over which the population members die
	 * @return the disease state label value that represents the number of
	 *         deaths in each state.
	 */
	
	public abstract StandardDiseaseModelLabelValue computeDiseaseDeathsDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabel diseaseLabel,
			final StandardDiseaseModelLabelValue currentLabelValue, 
			final long timeDelta, 
			DiseaseModelLabelValue returnValue);


	/**
	 * @param fractionToDepart
	 * @param nextState
	 * @return
	 */
	abstract protected StandardDiseaseModelLabelValue computeDepartures(
			double fractionToDepart, StandardDiseaseModelLabelValue nextState);

	
	@Override
	public void resetLabels() {
		super.resetLabels();

		
		
		
	} // resetLabels

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (totalPopulationCount: "); //$NON-NLS-1$
		result.append(totalPopulationCount);
		result.append(", totalPopulationCountReciprocal: "); //$NON-NLS-1$
		result.append(totalPopulationCountReciprocal);
		result.append(", totalArea: "); //$NON-NLS-1$
		result.append(totalArea);
		result.append(", referencePopulationDensity: "); //$NON-NLS-1$
		result.append(referencePopulationDensity);
		result.append(", roadNetworkInfectiousProportion: "); //$NON-NLS-1$
		result.append(roadNetworkInfectiousProportion);
		result.append(", characteristicMixingDistance: "); //$NON-NLS-1$
		result.append(characteristicMixingDistance);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue
				&& getTotalPopulationCount() >= TOTAL_POPULATION_COUNT_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(getTotalPopulationCount());
		assert retValue;
		
		retValue = retValue && !Double.isNaN(getTotalPopulationCount());
		assert retValue;
		
		retValue = retValue
				&& getTotalPopulationCountReciprocal() >= TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(getTotalPopulationCountReciprocal());
		assert retValue;
		
		retValue = retValue && !Double.isNaN(getTotalPopulationCountReciprocal());
		assert retValue;
		
		retValue = retValue && getTotalArea() >= TOTAL_AREA_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(getTotalArea());
		assert retValue;
		
		retValue = retValue && !Double.isNaN(getTotalArea());
		assert retValue;
		
		return retValue;
	} // sane

} // StandardDiseaseModelImpl

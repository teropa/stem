/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.EarthScienceLabel;
import org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mosquito Population Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.MosquitoPopulationModelImpl#getScalingFactor <em>Scaling Factor</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.MosquitoPopulationModelImpl#getTimePeriod <em>Time Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MosquitoPopulationModelImpl extends PopulationModelImpl implements MosquitoPopulationModel {
	/**
	 * The default value of the '{@link #getScalingFactor() <em>Scaling Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalingFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double SCALING_FACTOR_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getScalingFactor() <em>Scaling Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalingFactor()
	 * @generated
	 * @ordered
	 */
	protected double scalingFactor = SCALING_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimePeriod() <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_PERIOD_EDEFAULT = 86400000L;

	/**
	 * The cached value of the '{@link #getTimePeriod() <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected long timePeriod = TIME_PERIOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MosquitoPopulationModelImpl() {
		super();
	}

	
	@Override
	public PopulationModelLabel createPopulationLabel() {
		PopulationModelLabel retValue =  StandardFactory.eINSTANCE.createStandardPopulationModelLabel();
		retValue.setTypeURI(PopulationModelLabel.URI_TYPE_DYNAMIC_POPULATION_LABEL);
		return retValue;
	}
	
	@Override
	public PopulationModelLabelValue createPopulationLabelValue() {
		return StandardFactory.eINSTANCE.createStandardPopulationModelLabelValue();
	}
	
	
	/**
	 * Compute the changes in the mosquito population using earth science data
	 * 
	 * @param time
	 * @param timeDelta
	 * @param labels
	 */
	@SuppressWarnings("deprecation")
	public void calculateDelta(STEMTime time, long timeDelta,
			EList<DynamicLabel> labels) {
	
		for(DynamicLabel label:labels) {
			StandardPopulationModelLabelImpl slabel = (StandardPopulationModelLabelImpl)label;
			StandardPopulationModelLabelValueImpl delta = (StandardPopulationModelLabelValueImpl)slabel.getDeltaValue();
			StandardPopulationModelLabelValue current = slabel.getProbeValue();
			
			double currentPopulation = current.getCount();
			int month = time.getTime().getMonth(); // deprecated but still works
			// Get the elevation 
			 Node n = slabel.getNode();
			 double elevation = -1; // to avoid division by zero below
			 double temperature = 0;
			 double rainfall = 0;
			 
			 for(NodeLabel nl:n.getLabels()) {
				 if(nl instanceof EarthScienceLabel && ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getDataType().equals("elevation")) {
					 elevation = ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getData().get(0).doubleValue();
				 } else if(nl instanceof EarthScienceLabel && ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getDataType().equals("temperature")) {
					 temperature = ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getData().get(month*4).doubleValue();
				 } else if(nl instanceof EarthScienceLabel && ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getDataType().equals("rainfall")) {
					 rainfall = ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getData().get(month*8).doubleValue();
				 }
			 }
			 
			 // If the model does not contain the earth science data, the defaults above will be used
			 
			double newPopulation = scalingFactor * temperature * rainfall / elevation;
			double pdelta = newPopulation - currentPopulation;
			
			
			double births = 0;
			double deaths = 0;
			
			if(pdelta > 0) births = pdelta; else deaths = -pdelta;
			
			delta.setIncidence(0); // What is incidence???
			delta.setCount(pdelta);
			delta.setBirths(births);
			delta.setDeaths(deaths);
			
			if(delta.getArrivals() == null) delta.setArrivals(new HashMap<Node,Double>());
			if(delta.getDepartures() == null) delta.setDepartures(new HashMap<Node,Double>());
			
			delta.getArrivals().put((Node)label.getIdentifiable(), births);
			delta.getDepartures().put((Node)label.getIdentifiable(), deaths);
			
			handleMigration(slabel, delta.getArrivals(),delta.getDepartures(), this.getTimePeriod(), timeDelta, delta);
		}
	}// calculateDelta
	
	public boolean isDeterministic() {
		return true;
	}
	
	public void doModelSpecificAdjustments(LabelValue label) {
		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.MOSQUITO_POPULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getScalingFactor() {
		return scalingFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScalingFactor(double newScalingFactor) {
		double oldScalingFactor = scalingFactor;
		scalingFactor = newScalingFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR, oldScalingFactor, scalingFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimePeriod() {
		return timePeriod;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimePeriod(long newTimePeriod) {
		long oldTimePeriod = timePeriod;
		timePeriod = newTimePeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.MOSQUITO_POPULATION_MODEL__TIME_PERIOD, oldTimePeriod, timePeriod));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR:
				return getScalingFactor();
			case StandardPackage.MOSQUITO_POPULATION_MODEL__TIME_PERIOD:
				return getTimePeriod();
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
			case StandardPackage.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR:
				setScalingFactor((Double)newValue);
				return;
			case StandardPackage.MOSQUITO_POPULATION_MODEL__TIME_PERIOD:
				setTimePeriod((Long)newValue);
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
			case StandardPackage.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR:
				setScalingFactor(SCALING_FACTOR_EDEFAULT);
				return;
			case StandardPackage.MOSQUITO_POPULATION_MODEL__TIME_PERIOD:
				setTimePeriod(TIME_PERIOD_EDEFAULT);
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
			case StandardPackage.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR:
				return scalingFactor != SCALING_FACTOR_EDEFAULT;
			case StandardPackage.MOSQUITO_POPULATION_MODEL__TIME_PERIOD:
				return timePeriod != TIME_PERIOD_EDEFAULT;
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
		result.append(" (scalingFactor: ");
		result.append(scalingFactor);
		result.append(", timePeriod: ");
		result.append(timePeriod);
		result.append(')');
		return result.toString();
	}

} //MosquitoPopulationModelImpl

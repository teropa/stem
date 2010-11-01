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
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.data.geography.centers.GeographicCenters;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProviderAdapter;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProviderAdapterFactory;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.populationmodels.Activator;
import org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seasonal Population Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl#getModulationAmplitude <em>Modulation Amplitude</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.SeasonalPopulationModelImpl#isUseLatitude <em>Use Latitude</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeasonalPopulationModelImpl extends StandardPopulationModelImpl implements SeasonalPopulationModel {
	
	
	
	/**
	 * constant
	 */
	private static final double MILLIS_PER_DAY = 1000.0*60.0*60.0*24.0;
	
	/**
	 * todo model this in emf
	 */
	protected double seasonalModulationExponent = 2.0;
	
	/**
	 * the equator
	 */
	private static final double EQUATOR_LATITUDE = 0.0;
	
	/**
	 * TODO model this in EMF
	 */
	private static final boolean TROPICAL_ONLY = true;
	
	/**
	 * Latitude of the Tropic of Cancer in Degrees (Tropic of Capricorn is -ve of this).
	 */
	public static final double TROPIC_OF_CANCER_LATITUDE = 23.439444;


	/**
	 * TODO model this in EMF
	 */
	private static final double LATITUDE_SIGMOID_WIDTH = 4.5;
	
	
	/**
	 * The default value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected static final double PHASE_EDEFAULT = 0.0; // TODO The default value literal "" is not valid.

	/**
	 * The cached value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected double phase = PHASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModulationAmplitude() <em>Modulation Amplitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModulationAmplitude()
	 * @generated
	 * @ordered
	 */
	protected static final double MODULATION_AMPLITUDE_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getModulationAmplitude() <em>Modulation Amplitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModulationAmplitude()
	 * @generated
	 * @ordered
	 */
	protected double modulationAmplitude = MODULATION_AMPLITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final double PERIOD_EDEFAULT = 365.25;
	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected double period = PERIOD_EDEFAULT;
	/**
	 * The default value of the '{@link #isUseLatitude() <em>Use Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_LATITUDE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUseLatitude() <em>Use Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseLatitude()
	 * @generated
	 * @ordered
	 */
	protected boolean useLatitude = USE_LATITUDE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SeasonalPopulationModelImpl() {
		super();
	}
	
	
	/**
	 * Compute the changes in the population 
	 * The birth rate and death rates are modified in each time step by a seasonal modulation function
	 * The birth/death rates are NOT constant
	 * @param time
	 * @param timeDelta
	 * @param labels
	 * @generated NOT
	 */
	@Override
	public void calculateDelta(STEMTime time, long timeDelta,
			EList<DynamicLabel> labels) {
		// We simply calculate the change from the birth/death rate
		// adjusted for the time period used in the simulation
		
		
		final double adjustedBirthRate = adjustRate(this.getBirthRate(), this.getTimePeriod(), timeDelta);
		final double adjustedDeathRate = adjustRate(this.getDeathRate(), this.getTimePeriod(), timeDelta);
		double localPhase = getPhase();
		for(DynamicLabel label:labels) {
			
			StandardPopulationModelLabelImpl slabel = (StandardPopulationModelLabelImpl)label;
			StandardPopulationModelLabelValueImpl delta = (StandardPopulationModelLabelValueImpl)slabel.getDeltaValue();
			StandardPopulationModelLabelValue current = slabel.getProbeValue();
			double seasonalBirthFactor  = 0.0;
			double currentPopulation = current.getCount();
			// need to find the latitude of this node
			// default
			double latitude = EQUATOR_LATITUDE;
			double currentMillis = time.getTime().getTime();
			double latFactor = 1.0; // default = no dependence
			localPhase = getPhase();
			if(isUseLatitude()) {
				// center coords
				double[] lat_long = null;
				
				// Get THIS node
				Node node = slabel.getNode();
				if(node instanceof RegionImpl) {
					String nodeURI = node.getURI().lastSegment();
					lat_long = GeographicCenters.getCenter(nodeURI);
					// still null? Compute it
					if(lat_long==null) {
						// Get the lat/long of the center of the node
						final LatLongProviderAdapter latLongProviderB = (LatLongProviderAdapter) LatLongProviderAdapterFactory.INSTANCE
								.adapt(node, LatLongProvider.class);
						latLongProviderB.setTarget(node);
						lat_long = latLongProviderB.getCenter();
					}
					if (lat_long == null) {
						Activator.logError("Cannot find latitude for "+ nodeURI, null);
					}
				} else {
					lat_long = new double[2];
					lat_long[0] = EQUATOR_LATITUDE;
					lat_long[1] = EQUATOR_LATITUDE; // not used. sets it to 0,0
				}

				// get the latitude
				if(lat_long != null) {
					latitude = lat_long[0] ;
				} 
				// in a latitude dependent model, there is no modulation in the topics.
				// As we move away from the equator, the modulation amplitude increases to it's maximal value
				// and the constant floor decreases to it's minimum value
				// based on a logistic (sigmoidal) function
				latFactor  = 1.0/(1.0 + Math.exp((TROPIC_OF_CANCER_LATITUDE - Math.abs(latitude))/LATITUDE_SIGMOID_WIDTH) );
				// seasons reverse in the southern hemisphere
				if(latitude <= 0.0) localPhase = getPhase()+Math.PI;
			} //if useLatitude
			
			double modulation = getModulationAmplitude()*latFactor;
			double floor = (1.0-modulation);
				
			double modulationPeriod = getPeriod(); 
			double oscCos = Math.cos(localPhase + 2.0*Math.PI*currentMillis/(modulationPeriod*MILLIS_PER_DAY) ); // 1==>-1 cosine
			//  init default (phase 0)  seasonalBirthFactor  is 0.0 in winter. range is 0->1.0
			seasonalBirthFactor =  (1.0+(-1.0*oscCos))/2.0;
			// now scale it
			seasonalBirthFactor  *= modulation ;
			double oscBirthRate = adjustedBirthRate * Math.abs(seasonalBirthFactor);
			// add the base rates
			oscBirthRate += (floor*adjustedBirthRate);
			
			if(TROPICAL_ONLY) {
				oscBirthRate *= getTropicalEnvelope(latitude, (2*TROPIC_OF_CANCER_LATITUDE));
			}
			// only modulate the birth rate.
			double births = currentPopulation * oscBirthRate;
			// we don't modulate the death rate (insect life expectancy
			double deaths = currentPopulation * adjustedDeathRate;
			currentPopulation += births;
			currentPopulation -= deaths;
			
			delta.setIncidence(births-deaths);
			delta.setCount(births-deaths);
			delta.setBirths(births);
			delta.setDeaths(deaths);
			
			if(delta.getArrivals() == null) delta.setArrivals(new HashMap<Node,Double>());
			if(delta.getDepartures() == null) delta.setDepartures(new HashMap<Node,Double>());
			
			delta.getArrivals().put((Node)label.getIdentifiable(), births);
			delta.getDepartures().put((Node)label.getIdentifiable(), deaths);
			
			handleMigration(slabel, delta.getArrivals(),delta.getDepartures(), this.getTimePeriod(), timeDelta, delta);
			handlePipeTransport(slabel, delta.getArrivals(),delta.getDepartures(), timeDelta, delta);
		}
	}// calculateDelta
	
	/**
	 * Envelope function that bounds mosquito population to tropical band
	 * Function is ==1.0 at equator (centered about equator)
	 * @param lat
	 * @param sgima is the width
	 * @return
	 */
	private double getTropicalEnvelope(double lat, double sigma) {
		double exp = -((lat*lat)/(2.0*sigma*sigma));
		return Math.exp(exp);
	}
	
	/**
	 * Utility function
	 * @param x
	 * @param mu mean
	 * @param sigma width
	 * @return
	 */
	private double getGausianUnnormalize(double x, double mu, double sigma) {
		double exp = -(((x-mu)*(x-mu))/(2.0*sigma*sigma));
		return Math.exp(exp);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.SEASONAL_POPULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPhase() {
		return phase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhase(double newPhase) {
		double oldPhase = phase;
		phase = newPhase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEASONAL_POPULATION_MODEL__PHASE, oldPhase, phase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getModulationAmplitude() {
		return modulationAmplitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModulationAmplitude(double newModulationAmplitude) {
		double oldModulationAmplitude = modulationAmplitude;
		modulationAmplitude = newModulationAmplitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE, oldModulationAmplitude, modulationAmplitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPeriod() {
		return period;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseLatitude() {
		return useLatitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseLatitude(boolean newUseLatitude) {
		boolean oldUseLatitude = useLatitude;
		useLatitude = newUseLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.SEASONAL_POPULATION_MODEL__USE_LATITUDE, oldUseLatitude, useLatitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.SEASONAL_POPULATION_MODEL__PHASE:
				return getPhase();
			case StandardPackage.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE:
				return getModulationAmplitude();
			case StandardPackage.SEASONAL_POPULATION_MODEL__PERIOD:
				return getPeriod();
			case StandardPackage.SEASONAL_POPULATION_MODEL__USE_LATITUDE:
				return isUseLatitude();
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
			case StandardPackage.SEASONAL_POPULATION_MODEL__PHASE:
				setPhase((Double)newValue);
				return;
			case StandardPackage.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE:
				setModulationAmplitude((Double)newValue);
				return;
			case StandardPackage.SEASONAL_POPULATION_MODEL__USE_LATITUDE:
				setUseLatitude((Boolean)newValue);
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
			case StandardPackage.SEASONAL_POPULATION_MODEL__PHASE:
				setPhase(PHASE_EDEFAULT);
				return;
			case StandardPackage.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE:
				setModulationAmplitude(MODULATION_AMPLITUDE_EDEFAULT);
				return;
			case StandardPackage.SEASONAL_POPULATION_MODEL__USE_LATITUDE:
				setUseLatitude(USE_LATITUDE_EDEFAULT);
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
			case StandardPackage.SEASONAL_POPULATION_MODEL__PHASE:
				return phase != PHASE_EDEFAULT;
			case StandardPackage.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE:
				return modulationAmplitude != MODULATION_AMPLITUDE_EDEFAULT;
			case StandardPackage.SEASONAL_POPULATION_MODEL__PERIOD:
				return period != PERIOD_EDEFAULT;
			case StandardPackage.SEASONAL_POPULATION_MODEL__USE_LATITUDE:
				return useLatitude != USE_LATITUDE_EDEFAULT;
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
		result.append(" (phase: ");
		result.append(phase);
		result.append(", modulationAmplitude: ");
		result.append(modulationAmplitude);
		result.append(", period: ");
		result.append(period);
		result.append(", useLatitude: ");
		result.append(useLatitude);
		result.append(')');
		return result.toString();
	}

} //SeasonalPopulationModelImpl

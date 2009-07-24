/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Model Label Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl#getIncidence <em>Incidence</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl#getBirths <em>Births</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationModelLabelValueImpl#getDeaths <em>Deaths</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardPopulationModelLabelValueImpl extends PopulationModelLabelValueImpl implements StandardPopulationModelLabelValue {
	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final double COUNT_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected double count = COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncidence() <em>Incidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncidence()
	 * @generated
	 * @ordered
	 */
	protected static final double INCIDENCE_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getIncidence() <em>Incidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncidence()
	 * @generated
	 * @ordered
	 */
	protected double incidence = INCIDENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirths() <em>Births</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirths()
	 * @generated
	 * @ordered
	 */
	protected static final double BIRTHS_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getBirths() <em>Births</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirths()
	 * @generated
	 * @ordered
	 */
	protected double births = BIRTHS_EDEFAULT;
	/**
	 * The default value of the '{@link #getDeaths() <em>Deaths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeaths()
	 * @generated
	 * @ordered
	 */
	protected static final double DEATHS_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getDeaths() <em>Deaths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeaths()
	 * @generated
	 * @ordered
	 */
	protected double deaths = DEATHS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardPopulationModelLabelValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_POPULATION_MODEL_LABEL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(double newCount) {
		double oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIncidence() {
		return incidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncidence(double newIncidence) {
		double oldIncidence = incidence;
		incidence = newIncidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE, oldIncidence, incidence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBirths() {
		return births;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBirths(double newBirths) {
		double oldBirths = births;
		births = newBirths;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS, oldBirths, births));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDeaths() {
		return deaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeaths(double newDeaths) {
		double oldDeaths = deaths;
		deaths = newDeaths;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS, oldDeaths, deaths));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean adjustDelta(IntegrationLabelValue value) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAdditions() {
		return births; // Births are additions
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getSubstractions() {
		return deaths; // Deaths are substractions
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT:
				return new Double(getCount());
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE:
				return new Double(getIncidence());
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS:
				return new Double(getBirths());
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS:
				return new Double(getDeaths());
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
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT:
				setCount(((Double)newValue).doubleValue());
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE:
				setIncidence(((Double)newValue).doubleValue());
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS:
				setBirths(((Double)newValue).doubleValue());
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS:
				setDeaths(((Double)newValue).doubleValue());
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
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE:
				setIncidence(INCIDENCE_EDEFAULT);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS:
				setBirths(BIRTHS_EDEFAULT);
				return;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS:
				setDeaths(DEATHS_EDEFAULT);
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
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__COUNT:
				return count != COUNT_EDEFAULT;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__INCIDENCE:
				return incidence != INCIDENCE_EDEFAULT;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__BIRTHS:
				return births != BIRTHS_EDEFAULT;
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE__DEATHS:
				return deaths != DEATHS_EDEFAULT;
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
		result.append(" (count: ");
		result.append(count);
		result.append(", incidence: ");
		result.append(incidence);
		result.append(", births: ");
		result.append(births);
		result.append(", deaths: ");
		result.append(deaths);
		result.append(')');
		return result.toString();
	}

	@Override
	public IntegrationLabelValue abs() {
		this.count = Math.abs(this.count);
		this.births = Math.abs(this.births);
		this.deaths = Math.abs(this.deaths);
		return this;
	}

	@Override
	public IntegrationLabelValue add(IntegrationLabelValue value) {
		StandardPopulationModelLabelValue v = (StandardPopulationModelLabelValue)value;
		this.count += v.getCount();
		this.births += v.getBirths();
		this.deaths += v.getDeaths();
		
		return this;
	}

	@Override
	public IntegrationLabelValue add(double addition) {
		this.count += addition;
		this.births += addition;
		this.deaths += addition;
		return this;
	}

	@Override
	public IntegrationLabelValue scale(double scaleFactor) {
		this.count *= scaleFactor;
		this.births *= scaleFactor;
		this.deaths *= scaleFactor;
		return this;
	}

	@Override
	public IntegrationLabelValue set(IntegrationLabelValue value) {
		StandardPopulationModelLabelValue v = (StandardPopulationModelLabelValue)value;
		this.count = v.getCount();
		this.births = v.getBirths();
		this.deaths = v.getDeaths();
		return this;
	}

	@Override
	public IntegrationLabelValue sub(IntegrationLabelValue value) {
		StandardPopulationModelLabelValue v = (StandardPopulationModelLabelValue)value;
		this.count -= v.getCount();
		this.births -= v.getBirths();
		this.deaths -= v.getDeaths();
		return this;
	}

	@Override
	public IntegrationLabelValue divide(IntegrationLabelValue d) {
		StandardPopulationModelLabelValue v = (StandardPopulationModelLabelValue)d;
		this.count /= v.getCount();
		this.births /= v.getBirths();
		this.deaths /= v.getDeaths();
		return this;
	}
	
	@Override
	public double max() {
		if(count > deaths && count > births) return count;
		else if (deaths > births) return births;
		else return deaths;
	}
} //StandardPopulationModelLabelValueImpl

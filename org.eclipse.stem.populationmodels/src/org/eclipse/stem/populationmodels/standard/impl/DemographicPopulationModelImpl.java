/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.populationmodels.standard.DemographicPopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Demographic Population Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.DemographicPopulationModelImpl#getPopulationGroups <em>Population Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DemographicPopulationModelImpl extends StandardPopulationModelImpl implements DemographicPopulationModel {
	/**
	 * The cached value of the '{@link #getPopulationGroups() <em>Population Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<PopulationGroup> populationGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DemographicPopulationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.DEMOGRAPHIC_POPULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PopulationGroup> getPopulationGroups() {
		if (populationGroups == null) {
			populationGroups = new EObjectContainmentEList<PopulationGroup>(PopulationGroup.class, this, StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS);
		}
		return populationGroups;
	}

	
	/**
	 * Decorate the graph for a demographic population model
	 * 
	 */
	@Override
	public boolean decorateGraph() {
		super.decorateGraph();
		
		
		for (final Iterator<PopulationLabel> populationLabelIter = getPopulationLabels(
				getPopulationIdentifier(), getGraph()).iterator(); populationLabelIter
				.hasNext();) {
			final PopulationLabel populationLabel = populationLabelIter.next();

			if(this.getPopulationIdentifier().equals(populationLabel.getPopulationIdentifier())) {
				// Iterate the groups in the demographic model and divide the numbers
				for(PopulationGroup group:this.getPopulationGroups()) {
					final PopulationModelLabel pl = createPopulationLabel();
					
					pl.setPopulationLabel(populationLabel);
					getLabelsToUpdate().add(pl);
					populationLabel.getNode().getLabels().add(pl);
					pl.setNode(populationLabel.getNode());
					getGraph().putNodeLabel(pl);
					
					pl.setPopulationIdentifier(group.getIdentifier());
					StandardPopulationModelLabelValueImpl currentValue = (StandardPopulationModelLabelValueImpl)pl.getCurrentValue();
					currentValue.setCount(populationLabel.getCurrentPopulationValue().getCount() * group.getFraction());
				}
			}
		} // for each population label
		return true;
	} // decorateGraph
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS:
				return ((InternalEList<?>)getPopulationGroups()).basicRemove(otherEnd, msgs);
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
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS:
				return getPopulationGroups();
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
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS:
				getPopulationGroups().clear();
				getPopulationGroups().addAll((Collection<? extends PopulationGroup>)newValue);
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
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS:
				getPopulationGroups().clear();
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
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS:
				return populationGroups != null && !populationGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DemographicPopulationModelImpl

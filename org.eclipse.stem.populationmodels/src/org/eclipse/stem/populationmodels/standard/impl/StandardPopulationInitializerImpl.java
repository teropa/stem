package org.eclipse.stem.populationmodels.standard.impl;

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
import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
import org.eclipse.stem.populationmodels.Activator;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl#getIndividuals <em>Individuals</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl#isUseDensity <em>Use Density</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardPopulationInitializerImpl extends PopulationInitializerImpl implements StandardPopulationInitializer {
	/**
	 * The default value of the '{@link #getIndividuals() <em>Individuals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndividuals()
	 * @generated
	 * @ordered
	 */
	protected static final double INDIVIDUALS_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getIndividuals() <em>Individuals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndividuals()
	 * @generated
	 * @ordered
	 */
	protected double individuals = INDIVIDUALS_EDEFAULT;

	/**
	 * The default value of the '{@link #isUseDensity() <em>Use Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDensity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_DENSITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseDensity() <em>Use Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDensity()
	 * @generated
	 * @ordered
	 */
	protected boolean useDensity = USE_DENSITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StandardPopulationInitializerImpl() {
		super();
		// Populate the population labels
		
	}
	
	@Override 
	public void prepare(Model model, STEMTime time) {
		// Nothing to do
	}
	
	@Override
	protected void initializeLabel(PopulationLabel lab, STEMTime time, boolean zeroValue) {
		if(this.isUseDensity()) {
			Node n = lab.getNode();
			if(n == null) {
				Activator.logInformation("Cannot initialize population "+this.getPopulationIdentifier()+", no node found for"+lab, new Exception());
				return;
			}
			double area = 0.0;
			for(NodeLabel l:n.getLabels())
				if(l instanceof AreaLabel)
					area = ((AreaLabel)l).getCurrentAreaValue().getArea();
			if(area == 0.0) {
				 if(!n.getURI().toString().contains("/transport/pipe")) // No area for transport system nodes is expected.
						 Activator.logInformation("Warning, unable to find area information for node "+n+" when initializing population "+this.getPopulationIdentifier()+", density not being used!", new Exception());
				 PopulationLabelValue plv = lab.getCurrentPopulationValue();
				 if(!zeroValue) plv.setCount(this.getIndividuals());
				 else plv.setCount(0.0);
			} else {
				 PopulationLabelValue plv = lab.getCurrentPopulationValue();
				 if(!zeroValue) plv.setCount(this.getIndividuals()*area);
				 else plv.setCount(0.0);
			}
		} else {
			 PopulationLabelValue plv = lab.getCurrentPopulationValue();
			 if(!zeroValue) plv.setCount(this.getIndividuals());
			 else plv.setCount(0.0);
		}
		// Set the valid year to the start year of the sequencer
		
		lab.setValidYear(getYear(time));
	}
	
	
	@Override
	public boolean decorateGraph(STEMTime time) {
		if(this.isGraphDecorated()) return true;
		super.decorateGraph(time);
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_POPULATION_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIndividuals() {
		return individuals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndividuals(double newIndividuals) {
		double oldIndividuals = individuals;
		individuals = newIndividuals;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS, oldIndividuals, individuals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseDensity() {
		return useDensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseDensity(boolean newUseDensity) {
		boolean oldUseDensity = useDensity;
		useDensity = newUseDensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY, oldUseDensity, useDensity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				return getIndividuals();
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				return isUseDensity();
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
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				setIndividuals((Double)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				setUseDensity((Boolean)newValue);
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
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				setIndividuals(INDIVIDUALS_EDEFAULT);
				return;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				setUseDensity(USE_DENSITY_EDEFAULT);
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
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				return individuals != INDIVIDUALS_EDEFAULT;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				return useDensity != USE_DENSITY_EDEFAULT;
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
		result.append(" (individuals: ");
		result.append(individuals);
		result.append(", useDensity: ");
		result.append(useDensity);
		result.append(')');
		return result.toString();
	}

} //StandardPopulationInitializerImpl

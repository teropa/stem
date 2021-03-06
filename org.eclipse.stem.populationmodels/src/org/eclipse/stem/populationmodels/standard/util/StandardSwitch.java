package org.eclipse.stem.populationmodels.standard.util;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.SanityChecker;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.IntegrationLabel;
import org.eclipse.stem.core.graph.IntegrationLabelValue;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.populationmodels.standard.*;
import org.eclipse.stem.populationmodels.standard.DemographicPopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;
import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.StochasticStandardPopulationModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.populationmodels.standard.StandardPackage
 * @generated
 */
@SuppressWarnings("all")
public class StandardSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StandardPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardSwitch() {
		if (modelPackage == null) {
			modelPackage = StandardPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StandardPackage.POPULATION_MODEL: {
				PopulationModel populationModel = (PopulationModel)theEObject;
				T1 result = casePopulationModel(populationModel);
				if (result == null) result = caseNodeDecorator(populationModel);
				if (result == null) result = caseModifiable(populationModel);
				if (result == null) result = caseDecorator(populationModel);
				if (result == null) result = caseIdentifiable(populationModel);
				if (result == null) result = caseComparable(populationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_POPULATION_MODEL: {
				StandardPopulationModel standardPopulationModel = (StandardPopulationModel)theEObject;
				T1 result = caseStandardPopulationModel(standardPopulationModel);
				if (result == null) result = casePopulationModel(standardPopulationModel);
				if (result == null) result = caseIntegrationDecorator(standardPopulationModel);
				if (result == null) result = caseNodeDecorator(standardPopulationModel);
				if (result == null) result = caseModifiable(standardPopulationModel);
				if (result == null) result = caseDecorator(standardPopulationModel);
				if (result == null) result = caseIdentifiable(standardPopulationModel);
				if (result == null) result = caseComparable(standardPopulationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.POPULATION_MODEL_LABEL: {
				PopulationModelLabel populationModelLabel = (PopulationModelLabel)theEObject;
				T1 result = casePopulationModelLabel(populationModelLabel);
				if (result == null) result = caseDynamicNodeLabel(populationModelLabel);
				if (result == null) result = caseDynamicLabel(populationModelLabel);
				if (result == null) result = caseNodeLabel(populationModelLabel);
				if (result == null) result = caseLabel(populationModelLabel);
				if (result == null) result = caseIdentifiable(populationModelLabel);
				if (result == null) result = caseComparable(populationModelLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL: {
				StandardPopulationModelLabel standardPopulationModelLabel = (StandardPopulationModelLabel)theEObject;
				T1 result = caseStandardPopulationModelLabel(standardPopulationModelLabel);
				if (result == null) result = casePopulationModelLabel(standardPopulationModelLabel);
				if (result == null) result = caseIntegrationLabel(standardPopulationModelLabel);
				if (result == null) result = caseDynamicNodeLabel(standardPopulationModelLabel);
				if (result == null) result = caseDynamicLabel(standardPopulationModelLabel);
				if (result == null) result = caseNodeLabel(standardPopulationModelLabel);
				if (result == null) result = caseLabel(standardPopulationModelLabel);
				if (result == null) result = caseIdentifiable(standardPopulationModelLabel);
				if (result == null) result = caseComparable(standardPopulationModelLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.POPULATION_MODEL_LABEL_VALUE: {
				PopulationModelLabelValue populationModelLabelValue = (PopulationModelLabelValue)theEObject;
				T1 result = casePopulationModelLabelValue(populationModelLabelValue);
				if (result == null) result = caseLabelValue(populationModelLabelValue);
				if (result == null) result = caseSanityChecker(populationModelLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE: {
				StandardPopulationModelLabelValue standardPopulationModelLabelValue = (StandardPopulationModelLabelValue)theEObject;
				T1 result = caseStandardPopulationModelLabelValue(standardPopulationModelLabelValue);
				if (result == null) result = casePopulationModelLabelValue(standardPopulationModelLabelValue);
				if (result == null) result = caseIntegrationLabelValue(standardPopulationModelLabelValue);
				if (result == null) result = caseLabelValue(standardPopulationModelLabelValue);
				if (result == null) result = caseSanityChecker(standardPopulationModelLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STOCHASTIC_STANDARD_POPULATION_MODEL: {
				StochasticStandardPopulationModel stochasticStandardPopulationModel = (StochasticStandardPopulationModel)theEObject;
				T1 result = caseStochasticStandardPopulationModel(stochasticStandardPopulationModel);
				if (result == null) result = caseStandardPopulationModel(stochasticStandardPopulationModel);
				if (result == null) result = casePopulationModel(stochasticStandardPopulationModel);
				if (result == null) result = caseIntegrationDecorator(stochasticStandardPopulationModel);
				if (result == null) result = caseNodeDecorator(stochasticStandardPopulationModel);
				if (result == null) result = caseModifiable(stochasticStandardPopulationModel);
				if (result == null) result = caseDecorator(stochasticStandardPopulationModel);
				if (result == null) result = caseIdentifiable(stochasticStandardPopulationModel);
				if (result == null) result = caseComparable(stochasticStandardPopulationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DEMOGRAPHIC_POPULATION_MODEL: {
				DemographicPopulationModel demographicPopulationModel = (DemographicPopulationModel)theEObject;
				T1 result = caseDemographicPopulationModel(demographicPopulationModel);
				if (result == null) result = caseStandardPopulationModel(demographicPopulationModel);
				if (result == null) result = casePopulationModel(demographicPopulationModel);
				if (result == null) result = caseIntegrationDecorator(demographicPopulationModel);
				if (result == null) result = caseNodeDecorator(demographicPopulationModel);
				if (result == null) result = caseModifiable(demographicPopulationModel);
				if (result == null) result = caseDecorator(demographicPopulationModel);
				if (result == null) result = caseIdentifiable(demographicPopulationModel);
				if (result == null) result = caseComparable(demographicPopulationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.POPULATION_GROUP: {
				PopulationGroup populationGroup = (PopulationGroup)theEObject;
				T1 result = casePopulationGroup(populationGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.POPULATION_INITIALIZER: {
				PopulationInitializer populationInitializer = (PopulationInitializer)theEObject;
				T1 result = casePopulationInitializer(populationInitializer);
				if (result == null) result = caseNodeDecorator(populationInitializer);
				if (result == null) result = caseModifiable(populationInitializer);
				if (result == null) result = caseDecorator(populationInitializer);
				if (result == null) result = caseIdentifiable(populationInitializer);
				if (result == null) result = caseComparable(populationInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_POPULATION_INITIALIZER: {
				StandardPopulationInitializer standardPopulationInitializer = (StandardPopulationInitializer)theEObject;
				T1 result = caseStandardPopulationInitializer(standardPopulationInitializer);
				if (result == null) result = casePopulationInitializer(standardPopulationInitializer);
				if (result == null) result = caseNodeDecorator(standardPopulationInitializer);
				if (result == null) result = caseModifiable(standardPopulationInitializer);
				if (result == null) result = caseDecorator(standardPopulationInitializer);
				if (result == null) result = caseIdentifiable(standardPopulationInitializer);
				if (result == null) result = caseComparable(standardPopulationInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SEASONAL_POPULATION_MODEL: {
				SeasonalPopulationModel seasonalPopulationModel = (SeasonalPopulationModel)theEObject;
				T1 result = caseSeasonalPopulationModel(seasonalPopulationModel);
				if (result == null) result = caseStandardPopulationModel(seasonalPopulationModel);
				if (result == null) result = casePopulationModel(seasonalPopulationModel);
				if (result == null) result = caseIntegrationDecorator(seasonalPopulationModel);
				if (result == null) result = caseNodeDecorator(seasonalPopulationModel);
				if (result == null) result = caseModifiable(seasonalPopulationModel);
				if (result == null) result = caseDecorator(seasonalPopulationModel);
				if (result == null) result = caseIdentifiable(seasonalPopulationModel);
				if (result == null) result = caseComparable(seasonalPopulationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.EARTH_SCIENCE_POPULATION_INITIALIZER: {
				EarthSciencePopulationInitializer earthSciencePopulationInitializer = (EarthSciencePopulationInitializer)theEObject;
				T1 result = caseEarthSciencePopulationInitializer(earthSciencePopulationInitializer);
				if (result == null) result = casePopulationInitializer(earthSciencePopulationInitializer);
				if (result == null) result = caseNodeDecorator(earthSciencePopulationInitializer);
				if (result == null) result = caseModifiable(earthSciencePopulationInitializer);
				if (result == null) result = caseDecorator(earthSciencePopulationInitializer);
				if (result == null) result = caseIdentifiable(earthSciencePopulationInitializer);
				if (result == null) result = caseComparable(earthSciencePopulationInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.YETI_POPULATION_INITIALIZER: {
				YetiPopulationInitializer yetiPopulationInitializer = (YetiPopulationInitializer)theEObject;
				T1 result = caseYetiPopulationInitializer(yetiPopulationInitializer);
				if (result == null) result = caseEarthSciencePopulationInitializer(yetiPopulationInitializer);
				if (result == null) result = casePopulationInitializer(yetiPopulationInitializer);
				if (result == null) result = caseNodeDecorator(yetiPopulationInitializer);
				if (result == null) result = caseModifiable(yetiPopulationInitializer);
				if (result == null) result = caseDecorator(yetiPopulationInitializer);
				if (result == null) result = caseIdentifiable(yetiPopulationInitializer);
				if (result == null) result = caseComparable(yetiPopulationInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationModel(PopulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardPopulationModel(StandardPopulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Model Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Model Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationModelLabel(PopulationModelLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Model Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Model Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardPopulationModelLabel(StandardPopulationModelLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integration Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integration Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegrationLabel(IntegrationLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integration Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integration Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegrationLabelValue(IntegrationLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integration Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integration Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegrationDecorator(IntegrationDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Model Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Model Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationModelLabelValue(PopulationModelLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Model Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Model Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardPopulationModelLabelValue(StandardPopulationModelLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic Standard Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic Standard Population Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStochasticStandardPopulationModel(StochasticStandardPopulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Demographic Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Demographic Population Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDemographicPopulationModel(DemographicPopulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationGroup(PopulationGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePopulationInitializer(PopulationInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Population Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Population Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardPopulationInitializer(StandardPopulationInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Seasonal Population Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Seasonal Population Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSeasonalPopulationModel(SeasonalPopulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Earth Science Population Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Earth Science Population Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEarthSciencePopulationInitializer(EarthSciencePopulationInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Yeti Population Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Yeti Population Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseYetiPopulationInitializer(YetiPopulationInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDecorator(Decorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNodeDecorator(NodeDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModifiable(Modifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicLabel(DynamicLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNodeLabel(NodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Node Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Node Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDynamicNodeLabel(DynamicNodeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sanity Checker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sanity Checker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSanityChecker(SanityChecker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabelValue(LabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T1 defaultCase(EObject object) {
		return null;
	}

} //StandardSwitch

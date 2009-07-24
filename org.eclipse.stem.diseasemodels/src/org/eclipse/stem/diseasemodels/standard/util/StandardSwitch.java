package org.eclipse.stem.diseasemodels.standard.util;

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

import java.util.List;

//import java.util.Map;

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
import org.eclipse.stem.diseasemodels.standard.*;

import org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.SEIR;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIR;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.StandardInfector;
import org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage
 * @generated
 */
public class StandardSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static StandardPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * 
	 * @param theEObject
	 * 
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
			case StandardPackage.DETERMINISTIC_SEIR_DISEASE_MODEL: {
				DeterministicSEIRDiseaseModel deterministicSEIRDiseaseModel = (DeterministicSEIRDiseaseModel)theEObject;
				T1 result = caseDeterministicSEIRDiseaseModel(deterministicSEIRDiseaseModel);
				if (result == null) result = caseSEIR(deterministicSEIRDiseaseModel);
				if (result == null) result = caseSIR(deterministicSEIRDiseaseModel);
				if (result == null) result = caseSI(deterministicSEIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(deterministicSEIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(deterministicSEIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(deterministicSEIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(deterministicSEIRDiseaseModel);
				if (result == null) result = caseSanityChecker(deterministicSEIRDiseaseModel);
				if (result == null) result = caseModifiable(deterministicSEIRDiseaseModel);
				if (result == null) result = caseDecorator(deterministicSEIRDiseaseModel);
				if (result == null) result = caseIdentifiable(deterministicSEIRDiseaseModel);
				if (result == null) result = caseComparable(deterministicSEIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DETERMINISTIC_SI_DISEASE_MODEL: {
				DeterministicSIDiseaseModel deterministicSIDiseaseModel = (DeterministicSIDiseaseModel)theEObject;
				T1 result = caseDeterministicSIDiseaseModel(deterministicSIDiseaseModel);
				if (result == null) result = caseSI(deterministicSIDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(deterministicSIDiseaseModel);
				if (result == null) result = caseDiseaseModel(deterministicSIDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(deterministicSIDiseaseModel);
				if (result == null) result = caseNodeDecorator(deterministicSIDiseaseModel);
				if (result == null) result = caseSanityChecker(deterministicSIDiseaseModel);
				if (result == null) result = caseModifiable(deterministicSIDiseaseModel);
				if (result == null) result = caseDecorator(deterministicSIDiseaseModel);
				if (result == null) result = caseIdentifiable(deterministicSIDiseaseModel);
				if (result == null) result = caseComparable(deterministicSIDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DETERMINISTIC_SIR_DISEASE_MODEL: {
				DeterministicSIRDiseaseModel deterministicSIRDiseaseModel = (DeterministicSIRDiseaseModel)theEObject;
				T1 result = caseDeterministicSIRDiseaseModel(deterministicSIRDiseaseModel);
				if (result == null) result = caseSIR(deterministicSIRDiseaseModel);
				if (result == null) result = caseSI(deterministicSIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(deterministicSIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(deterministicSIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(deterministicSIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(deterministicSIRDiseaseModel);
				if (result == null) result = caseSanityChecker(deterministicSIRDiseaseModel);
				if (result == null) result = caseModifiable(deterministicSIRDiseaseModel);
				if (result == null) result = caseDecorator(deterministicSIRDiseaseModel);
				if (result == null) result = caseIdentifiable(deterministicSIRDiseaseModel);
				if (result == null) result = caseComparable(deterministicSIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DISEASE_MODEL: {
				DiseaseModel diseaseModel = (DiseaseModel)theEObject;
				T1 result = caseDiseaseModel(diseaseModel);
				if (result == null) result = caseNodeDecorator(diseaseModel);
				if (result == null) result = caseSanityChecker(diseaseModel);
				if (result == null) result = caseModifiable(diseaseModel);
				if (result == null) result = caseDecorator(diseaseModel);
				if (result == null) result = caseIdentifiable(diseaseModel);
				if (result == null) result = caseComparable(diseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DISEASE_MODEL_LABEL: {
				DiseaseModelLabel diseaseModelLabel = (DiseaseModelLabel)theEObject;
				T1 result = caseDiseaseModelLabel(diseaseModelLabel);
				if (result == null) result = caseDynamicNodeLabel(diseaseModelLabel);
				if (result == null) result = caseDynamicLabel(diseaseModelLabel);
				if (result == null) result = caseNodeLabel(diseaseModelLabel);
				if (result == null) result = caseLabel(diseaseModelLabel);
				if (result == null) result = caseIdentifiable(diseaseModelLabel);
				if (result == null) result = caseComparable(diseaseModelLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DISEASE_MODEL_LABEL_VALUE: {
				DiseaseModelLabelValue diseaseModelLabelValue = (DiseaseModelLabelValue)theEObject;
				T1 result = caseDiseaseModelLabelValue(diseaseModelLabelValue);
				if (result == null) result = caseLabelValue(diseaseModelLabelValue);
				if (result == null) result = caseIntegrationLabelValue(diseaseModelLabelValue);
				if (result == null) result = caseSanityChecker_1(diseaseModelLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.DISEASE_MODEL_STATE: {
				DiseaseModelState diseaseModelState = (DiseaseModelState)theEObject;
				T1 result = caseDiseaseModelState(diseaseModelState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.INFECTOR: {
				Infector infector = (Infector)theEObject;
				T1 result = caseInfector(infector);
				if (result == null) result = caseNodeDecorator(infector);
				if (result == null) result = caseDecorator(infector);
				if (result == null) result = caseIdentifiable(infector);
				if (result == null) result = caseComparable(infector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SEIR: {
				SEIR seir = (SEIR)theEObject;
				T1 result = caseSEIR(seir);
				if (result == null) result = caseSIR(seir);
				if (result == null) result = caseSI(seir);
				if (result == null) result = caseStandardDiseaseModel(seir);
				if (result == null) result = caseDiseaseModel(seir);
				if (result == null) result = caseIntegrationDecorator(seir);
				if (result == null) result = caseNodeDecorator(seir);
				if (result == null) result = caseSanityChecker(seir);
				if (result == null) result = caseModifiable(seir);
				if (result == null) result = caseDecorator(seir);
				if (result == null) result = caseIdentifiable(seir);
				if (result == null) result = caseComparable(seir);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SEIR_LABEL: {
				SEIRLabel seirLabel = (SEIRLabel)theEObject;
				T1 result = caseSEIRLabel(seirLabel);
				if (result == null) result = caseStandardDiseaseModelLabel(seirLabel);
				if (result == null) result = caseDiseaseModelLabel(seirLabel);
				if (result == null) result = caseIntegrationLabel(seirLabel);
				if (result == null) result = caseDynamicNodeLabel(seirLabel);
				if (result == null) result = caseDynamicLabel(seirLabel);
				if (result == null) result = caseNodeLabel(seirLabel);
				if (result == null) result = caseLabel(seirLabel);
				if (result == null) result = caseIdentifiable(seirLabel);
				if (result == null) result = caseComparable(seirLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SEIR_LABEL_VALUE: {
				SEIRLabelValue seirLabelValue = (SEIRLabelValue)theEObject;
				T1 result = caseSEIRLabelValue(seirLabelValue);
				if (result == null) result = caseSIRLabelValue(seirLabelValue);
				if (result == null) result = caseSILabelValue(seirLabelValue);
				if (result == null) result = caseStandardDiseaseModelLabelValue(seirLabelValue);
				if (result == null) result = caseDiseaseModelLabelValue(seirLabelValue);
				if (result == null) result = caseLabelValue(seirLabelValue);
				if (result == null) result = caseIntegrationLabelValue(seirLabelValue);
				if (result == null) result = caseSanityChecker_1(seirLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SI: {
				SI si = (SI)theEObject;
				T1 result = caseSI(si);
				if (result == null) result = caseStandardDiseaseModel(si);
				if (result == null) result = caseDiseaseModel(si);
				if (result == null) result = caseIntegrationDecorator(si);
				if (result == null) result = caseNodeDecorator(si);
				if (result == null) result = caseSanityChecker(si);
				if (result == null) result = caseModifiable(si);
				if (result == null) result = caseDecorator(si);
				if (result == null) result = caseIdentifiable(si);
				if (result == null) result = caseComparable(si);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SI_DISEASE_MODEL_STATE: {
				SIDiseaseModelState siDiseaseModelState = (SIDiseaseModelState)theEObject;
				T1 result = caseSIDiseaseModelState(siDiseaseModelState);
				if (result == null) result = caseStandardDiseaseModelState(siDiseaseModelState);
				if (result == null) result = caseDiseaseModelState(siDiseaseModelState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SI_INFECTOR: {
				SIInfector siInfector = (SIInfector)theEObject;
				T1 result = caseSIInfector(siInfector);
				if (result == null) result = caseStandardInfector(siInfector);
				if (result == null) result = caseInfector(siInfector);
				if (result == null) result = caseNodeDecorator(siInfector);
				if (result == null) result = caseDecorator(siInfector);
				if (result == null) result = caseIdentifiable(siInfector);
				if (result == null) result = caseComparable(siInfector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SI_LABEL: {
				SILabel siLabel = (SILabel)theEObject;
				T1 result = caseSILabel(siLabel);
				if (result == null) result = caseStandardDiseaseModelLabel(siLabel);
				if (result == null) result = caseDiseaseModelLabel(siLabel);
				if (result == null) result = caseIntegrationLabel(siLabel);
				if (result == null) result = caseDynamicNodeLabel(siLabel);
				if (result == null) result = caseDynamicLabel(siLabel);
				if (result == null) result = caseNodeLabel(siLabel);
				if (result == null) result = caseLabel(siLabel);
				if (result == null) result = caseIdentifiable(siLabel);
				if (result == null) result = caseComparable(siLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SI_LABEL_VALUE: {
				SILabelValue siLabelValue = (SILabelValue)theEObject;
				T1 result = caseSILabelValue(siLabelValue);
				if (result == null) result = caseStandardDiseaseModelLabelValue(siLabelValue);
				if (result == null) result = caseDiseaseModelLabelValue(siLabelValue);
				if (result == null) result = caseLabelValue(siLabelValue);
				if (result == null) result = caseIntegrationLabelValue(siLabelValue);
				if (result == null) result = caseSanityChecker_1(siLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SIR: {
				SIR sir = (SIR)theEObject;
				T1 result = caseSIR(sir);
				if (result == null) result = caseSI(sir);
				if (result == null) result = caseStandardDiseaseModel(sir);
				if (result == null) result = caseDiseaseModel(sir);
				if (result == null) result = caseIntegrationDecorator(sir);
				if (result == null) result = caseNodeDecorator(sir);
				if (result == null) result = caseSanityChecker(sir);
				if (result == null) result = caseModifiable(sir);
				if (result == null) result = caseDecorator(sir);
				if (result == null) result = caseIdentifiable(sir);
				if (result == null) result = caseComparable(sir);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SIR_LABEL: {
				SIRLabel sirLabel = (SIRLabel)theEObject;
				T1 result = caseSIRLabel(sirLabel);
				if (result == null) result = caseStandardDiseaseModelLabel(sirLabel);
				if (result == null) result = caseDiseaseModelLabel(sirLabel);
				if (result == null) result = caseIntegrationLabel(sirLabel);
				if (result == null) result = caseDynamicNodeLabel(sirLabel);
				if (result == null) result = caseDynamicLabel(sirLabel);
				if (result == null) result = caseNodeLabel(sirLabel);
				if (result == null) result = caseLabel(sirLabel);
				if (result == null) result = caseIdentifiable(sirLabel);
				if (result == null) result = caseComparable(sirLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SIR_LABEL_VALUE: {
				SIRLabelValue sirLabelValue = (SIRLabelValue)theEObject;
				T1 result = caseSIRLabelValue(sirLabelValue);
				if (result == null) result = caseSILabelValue(sirLabelValue);
				if (result == null) result = caseStandardDiseaseModelLabelValue(sirLabelValue);
				if (result == null) result = caseDiseaseModelLabelValue(sirLabelValue);
				if (result == null) result = caseLabelValue(sirLabelValue);
				if (result == null) result = caseIntegrationLabelValue(sirLabelValue);
				if (result == null) result = caseSanityChecker_1(sirLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_DISEASE_MODEL: {
				StandardDiseaseModel standardDiseaseModel = (StandardDiseaseModel)theEObject;
				T1 result = caseStandardDiseaseModel(standardDiseaseModel);
				if (result == null) result = caseDiseaseModel(standardDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(standardDiseaseModel);
				if (result == null) result = caseNodeDecorator(standardDiseaseModel);
				if (result == null) result = caseSanityChecker(standardDiseaseModel);
				if (result == null) result = caseModifiable(standardDiseaseModel);
				if (result == null) result = caseDecorator(standardDiseaseModel);
				if (result == null) result = caseIdentifiable(standardDiseaseModel);
				if (result == null) result = caseComparable(standardDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL: {
				StandardDiseaseModelLabel standardDiseaseModelLabel = (StandardDiseaseModelLabel)theEObject;
				T1 result = caseStandardDiseaseModelLabel(standardDiseaseModelLabel);
				if (result == null) result = caseDiseaseModelLabel(standardDiseaseModelLabel);
				if (result == null) result = caseIntegrationLabel(standardDiseaseModelLabel);
				if (result == null) result = caseDynamicNodeLabel(standardDiseaseModelLabel);
				if (result == null) result = caseDynamicLabel(standardDiseaseModelLabel);
				if (result == null) result = caseNodeLabel(standardDiseaseModelLabel);
				if (result == null) result = caseLabel(standardDiseaseModelLabel);
				if (result == null) result = caseIdentifiable(standardDiseaseModelLabel);
				if (result == null) result = caseComparable(standardDiseaseModelLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_DISEASE_MODEL_LABEL_VALUE: {
				StandardDiseaseModelLabelValue standardDiseaseModelLabelValue = (StandardDiseaseModelLabelValue)theEObject;
				T1 result = caseStandardDiseaseModelLabelValue(standardDiseaseModelLabelValue);
				if (result == null) result = caseDiseaseModelLabelValue(standardDiseaseModelLabelValue);
				if (result == null) result = caseLabelValue(standardDiseaseModelLabelValue);
				if (result == null) result = caseIntegrationLabelValue(standardDiseaseModelLabelValue);
				if (result == null) result = caseSanityChecker_1(standardDiseaseModelLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_DISEASE_MODEL_STATE: {
				StandardDiseaseModelState standardDiseaseModelState = (StandardDiseaseModelState)theEObject;
				T1 result = caseStandardDiseaseModelState(standardDiseaseModelState);
				if (result == null) result = caseDiseaseModelState(standardDiseaseModelState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_INFECTOR: {
				StandardInfector standardInfector = (StandardInfector)theEObject;
				T1 result = caseStandardInfector(standardInfector);
				if (result == null) result = caseInfector(standardInfector);
				if (result == null) result = caseNodeDecorator(standardInfector);
				if (result == null) result = caseDecorator(standardInfector);
				if (result == null) result = caseIdentifiable(standardInfector);
				if (result == null) result = caseComparable(standardInfector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL: {
				StochasticSEIRDiseaseModel stochasticSEIRDiseaseModel = (StochasticSEIRDiseaseModel)theEObject;
				T1 result = caseStochasticSEIRDiseaseModel(stochasticSEIRDiseaseModel);
				if (result == null) result = caseSEIR(stochasticSEIRDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(stochasticSEIRDiseaseModel);
				if (result == null) result = caseSIR(stochasticSEIRDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(stochasticSEIRDiseaseModel);
				if (result == null) result = caseSI(stochasticSEIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(stochasticSEIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(stochasticSEIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(stochasticSEIRDiseaseModel);
				if (result == null) result = caseSanityChecker(stochasticSEIRDiseaseModel);
				if (result == null) result = caseModifiable(stochasticSEIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(stochasticSEIRDiseaseModel);
				if (result == null) result = caseDecorator(stochasticSEIRDiseaseModel);
				if (result == null) result = caseIdentifiable(stochasticSEIRDiseaseModel);
				if (result == null) result = caseComparable(stochasticSEIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL: {
				StochasticSIDiseaseModel stochasticSIDiseaseModel = (StochasticSIDiseaseModel)theEObject;
				T1 result = caseStochasticSIDiseaseModel(stochasticSIDiseaseModel);
				if (result == null) result = caseSI(stochasticSIDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(stochasticSIDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(stochasticSIDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(stochasticSIDiseaseModel);
				if (result == null) result = caseDiseaseModel(stochasticSIDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(stochasticSIDiseaseModel);
				if (result == null) result = caseNodeDecorator(stochasticSIDiseaseModel);
				if (result == null) result = caseSanityChecker(stochasticSIDiseaseModel);
				if (result == null) result = caseModifiable(stochasticSIDiseaseModel);
				if (result == null) result = caseDecorator(stochasticSIDiseaseModel);
				if (result == null) result = caseIdentifiable(stochasticSIDiseaseModel);
				if (result == null) result = caseComparable(stochasticSIDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL: {
				StochasticSIRDiseaseModel stochasticSIRDiseaseModel = (StochasticSIRDiseaseModel)theEObject;
				T1 result = caseStochasticSIRDiseaseModel(stochasticSIRDiseaseModel);
				if (result == null) result = caseSIR(stochasticSIRDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(stochasticSIRDiseaseModel);
				if (result == null) result = caseSI(stochasticSIRDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(stochasticSIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(stochasticSIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(stochasticSIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(stochasticSIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(stochasticSIRDiseaseModel);
				if (result == null) result = caseSanityChecker(stochasticSIRDiseaseModel);
				if (result == null) result = caseModifiable(stochasticSIRDiseaseModel);
				if (result == null) result = caseDecorator(stochasticSIRDiseaseModel);
				if (result == null) result = caseIdentifiable(stochasticSIRDiseaseModel);
				if (result == null) result = caseComparable(stochasticSIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.AGGREGATING_SI_DISEASE_MODEL: {
				AggregatingSIDiseaseModel aggregatingSIDiseaseModel = (AggregatingSIDiseaseModel)theEObject;
				T1 result = caseAggregatingSIDiseaseModel(aggregatingSIDiseaseModel);
				if (result == null) result = caseSI(aggregatingSIDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(aggregatingSIDiseaseModel);
				if (result == null) result = caseDiseaseModel(aggregatingSIDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(aggregatingSIDiseaseModel);
				if (result == null) result = caseNodeDecorator(aggregatingSIDiseaseModel);
				if (result == null) result = caseSanityChecker(aggregatingSIDiseaseModel);
				if (result == null) result = caseModifiable(aggregatingSIDiseaseModel);
				if (result == null) result = caseDecorator(aggregatingSIDiseaseModel);
				if (result == null) result = caseIdentifiable(aggregatingSIDiseaseModel);
				if (result == null) result = caseComparable(aggregatingSIDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.AGGREGATING_DISEASE_MODEL_STATE: {
				AggregatingDiseaseModelState aggregatingDiseaseModelState = (AggregatingDiseaseModelState)theEObject;
				T1 result = caseAggregatingDiseaseModelState(aggregatingDiseaseModelState);
				if (result == null) result = caseDiseaseModelState(aggregatingDiseaseModelState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.AGGREGATING_SEIR_DISEASE_MODEL: {
				AggregatingSEIRDiseaseModel aggregatingSEIRDiseaseModel = (AggregatingSEIRDiseaseModel)theEObject;
				T1 result = caseAggregatingSEIRDiseaseModel(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseAggregatingSIRDiseaseModel(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseAggregatingSIDiseaseModel(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseSI(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseSanityChecker(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseModifiable(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseDecorator(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseIdentifiable(aggregatingSEIRDiseaseModel);
				if (result == null) result = caseComparable(aggregatingSEIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.AGGREGATING_SIR_DISEASE_MODEL: {
				AggregatingSIRDiseaseModel aggregatingSIRDiseaseModel = (AggregatingSIRDiseaseModel)theEObject;
				T1 result = caseAggregatingSIRDiseaseModel(aggregatingSIRDiseaseModel);
				if (result == null) result = caseAggregatingSIDiseaseModel(aggregatingSIRDiseaseModel);
				if (result == null) result = caseSI(aggregatingSIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(aggregatingSIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(aggregatingSIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(aggregatingSIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(aggregatingSIRDiseaseModel);
				if (result == null) result = caseSanityChecker(aggregatingSIRDiseaseModel);
				if (result == null) result = caseModifiable(aggregatingSIRDiseaseModel);
				if (result == null) result = caseDecorator(aggregatingSIRDiseaseModel);
				if (result == null) result = caseIdentifiable(aggregatingSIRDiseaseModel);
				if (result == null) result = caseComparable(aggregatingSIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STOCHASTIC_DISEASE_MODEL: {
				StochasticDiseaseModel stochasticDiseaseModel = (StochasticDiseaseModel)theEObject;
				T1 result = caseStochasticDiseaseModel(stochasticDiseaseModel);
				if (result == null) result = caseDiseaseModel(stochasticDiseaseModel);
				if (result == null) result = caseNodeDecorator(stochasticDiseaseModel);
				if (result == null) result = caseSanityChecker(stochasticDiseaseModel);
				if (result == null) result = caseModifiable(stochasticDiseaseModel);
				if (result == null) result = caseDecorator(stochasticDiseaseModel);
				if (result == null) result = caseIdentifiable(stochasticDiseaseModel);
				if (result == null) result = caseComparable(stochasticDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.STANDARD_STOCHASTIC_DISEASE_MODEL: {
				StandardStochasticDiseaseModel standardStochasticDiseaseModel = (StandardStochasticDiseaseModel)theEObject;
				T1 result = caseStandardStochasticDiseaseModel(standardStochasticDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(standardStochasticDiseaseModel);
				if (result == null) result = caseDiseaseModel(standardStochasticDiseaseModel);
				if (result == null) result = caseNodeDecorator(standardStochasticDiseaseModel);
				if (result == null) result = caseSanityChecker(standardStochasticDiseaseModel);
				if (result == null) result = caseModifiable(standardStochasticDiseaseModel);
				if (result == null) result = caseDecorator(standardStochasticDiseaseModel);
				if (result == null) result = caseIdentifiable(standardStochasticDiseaseModel);
				if (result == null) result = caseComparable(standardStochasticDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StandardPackage.SIR_INOCULATOR: {
				SIRInoculator sirInoculator = (SIRInoculator)theEObject;
				T1 result = caseSIRInoculator(sirInoculator);
				if (result == null) result = caseSIInfector(sirInoculator);
				if (result == null) result = caseStandardInfector(sirInoculator);
				if (result == null) result = caseInfector(sirInoculator);
				if (result == null) result = caseNodeDecorator(sirInoculator);
				if (result == null) result = caseDecorator(sirInoculator);
				if (result == null) result = caseIdentifiable(sirInoculator);
				if (result == null) result = caseComparable(sirInoculator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SEIR</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SEIR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSEIR(SEIR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SEIR Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SEIR Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSEIRLabel(SEIRLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SEIR Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SEIR Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSEIRLabelValue(SEIRLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIR</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIR(SIR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIR Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIR Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIRLabel(SIRLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIR Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIR Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIRLabelValue(SIRLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardDiseaseModel(StandardDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDiseaseModel(DiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDiseaseModelLabel(DiseaseModelLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic SEIR Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic SEIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStochasticSEIRDiseaseModel(
			StochasticSEIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infector</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardInfector(StandardInfector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deterministic SEIR Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deterministic SEIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDeterministicSEIRDiseaseModel(
			DeterministicSEIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDiseaseModelLabelValue(DiseaseModelLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardDiseaseModelLabelValue(
			StandardDiseaseModelLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardDiseaseModelLabel(StandardDiseaseModelLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SI</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSI(SI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SI Label</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSILabel(SILabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SI Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSILabelValue(SILabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infector</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInfector(Infector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SI Infector</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI Infector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIInfector(SIInfector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deterministic SIR Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deterministic SIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDeterministicSIRDiseaseModel(
			DeterministicSIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deterministic SI Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deterministic SI Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDeterministicSIDiseaseModel(
			DeterministicSIDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic SIR Disease Model</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic SIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStochasticSIRDiseaseModel(StochasticSIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic SI Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStochasticSIDiseaseModel(StochasticSIDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDiseaseModelState(DiseaseModelState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SI Disease Model State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI Disease Model State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIDiseaseModelState(SIDiseaseModelState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardDiseaseModelState(StandardDiseaseModelState object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Aggregating SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregating SI Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAggregatingSIDiseaseModel(AggregatingSIDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregating Disease Model State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregating Disease Model State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAggregatingDiseaseModelState(AggregatingDiseaseModelState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregating SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregating SEIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAggregatingSEIRDiseaseModel(AggregatingSEIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregating SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregating SIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAggregatingSIRDiseaseModel(AggregatingSIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStochasticDiseaseModel(StochasticDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardStochasticDiseaseModel(StandardStochasticDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIR Inoculator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIR Inoculator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIRInoculator(SIRInoculator object) {
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	public T1 caseSanityChecker_1(SanityChecker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a
	 * non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T1 defaultCase(EObject object) {
		return null;
	}

} // StandardSwitch

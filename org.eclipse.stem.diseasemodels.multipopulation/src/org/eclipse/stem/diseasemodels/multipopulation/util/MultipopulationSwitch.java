package org.eclipse.stem.diseasemodels.multipopulation.util;

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
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.SanityChecker;

import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.model.NodeDecorator;

import org.eclipse.stem.core.modifier.Modifiable;

import org.eclipse.stem.diseasemodels.multipopulation.*;

import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;

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
 * @see org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage
 * @generated
 */
public class MultipopulationSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MultipopulationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipopulationSwitch() {
		if (modelPackage == null) {
			modelPackage = MultipopulationPackage.eINSTANCE;
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
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL: {
				MultiPopulationSIDiseaseModel multiPopulationSIDiseaseModel = (MultiPopulationSIDiseaseModel)theEObject;
				T1 result = caseMultiPopulationSIDiseaseModel(multiPopulationSIDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(multiPopulationSIDiseaseModel);
				if (result == null) result = caseDiseaseModel(multiPopulationSIDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(multiPopulationSIDiseaseModel);
				if (result == null) result = caseNodeDecorator(multiPopulationSIDiseaseModel);
				if (result == null) result = caseSanityChecker(multiPopulationSIDiseaseModel);
				if (result == null) result = caseModifiable(multiPopulationSIDiseaseModel);
				if (result == null) result = caseDecorator(multiPopulationSIDiseaseModel);
				if (result == null) result = caseIdentifiable(multiPopulationSIDiseaseModel);
				if (result == null) result = caseComparable(multiPopulationSIDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultipopulationPackage.MULTI_POPULATION_SIR_DISEASE_MODEL: {
				MultiPopulationSIRDiseaseModel multiPopulationSIRDiseaseModel = (MultiPopulationSIRDiseaseModel)theEObject;
				T1 result = caseMultiPopulationSIRDiseaseModel(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseMultiPopulationSIDiseaseModel(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseSanityChecker(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseModifiable(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseDecorator(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseIdentifiable(multiPopulationSIRDiseaseModel);
				if (result == null) result = caseComparable(multiPopulationSIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultipopulationPackage.MULTI_POPULATION_SEIR_DISEASE_MODEL: {
				MultiPopulationSEIRDiseaseModel multiPopulationSEIRDiseaseModel = (MultiPopulationSEIRDiseaseModel)theEObject;
				T1 result = caseMultiPopulationSEIRDiseaseModel(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseMultiPopulationSIRDiseaseModel(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseMultiPopulationSIDiseaseModel(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseDiseaseModel(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseNodeDecorator(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseSanityChecker(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseModifiable(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseDecorator(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseIdentifiable(multiPopulationSEIRDiseaseModel);
				if (result == null) result = caseComparable(multiPopulationSEIRDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Population SI Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Population SI Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMultiPopulationSIDiseaseModel(MultiPopulationSIDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Population SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Population SIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMultiPopulationSIRDiseaseModel(MultiPopulationSIRDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Population SEIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Population SEIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMultiPopulationSEIRDiseaseModel(MultiPopulationSEIRDiseaseModel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDiseaseModel(DiseaseModel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStandardDiseaseModel(StandardDiseaseModel object) {
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

} //MultipopulationSwitch

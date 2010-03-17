package org.eclipse.stem.diseasemodels.forcing.util;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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
import org.eclipse.stem.diseasemodels.forcing.*;

import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.SIR;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;

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
 * @see org.eclipse.stem.diseasemodels.forcing.ForcingPackage
 * @generated
 */
@SuppressWarnings("all")
public class ForcingSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ForcingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcingSwitch() {
		if (modelPackage == null) {
			modelPackage = ForcingPackage.eINSTANCE;
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
			case ForcingPackage.FORCING_DISEASE_MODEL: {
				ForcingDiseaseModel forcingDiseaseModel = (ForcingDiseaseModel)theEObject;
				T1 result = caseForcingDiseaseModel(forcingDiseaseModel);
				if (result == null) result = caseStochasticSIRDiseaseModel(forcingDiseaseModel);
				if (result == null) result = caseSIR(forcingDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(forcingDiseaseModel);
				if (result == null) result = caseSI(forcingDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(forcingDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(forcingDiseaseModel);
				if (result == null) result = caseDiseaseModel(forcingDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(forcingDiseaseModel);
				if (result == null) result = caseNodeDecorator(forcingDiseaseModel);
				if (result == null) result = caseSanityChecker(forcingDiseaseModel);
				if (result == null) result = caseModifiable(forcingDiseaseModel);
				if (result == null) result = caseDecorator(forcingDiseaseModel);
				if (result == null) result = caseIdentifiable(forcingDiseaseModel);
				if (result == null) result = caseComparable(forcingDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ForcingPackage.GAUSSIAN_FORCING_DISEASE_MODEL: {
				GaussianForcingDiseaseModel gaussianForcingDiseaseModel = (GaussianForcingDiseaseModel)theEObject;
				T1 result = caseGaussianForcingDiseaseModel(gaussianForcingDiseaseModel);
				if (result == null) result = caseStochasticSIRDiseaseModel(gaussianForcingDiseaseModel);
				if (result == null) result = caseSIR(gaussianForcingDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(gaussianForcingDiseaseModel);
				if (result == null) result = caseSI(gaussianForcingDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(gaussianForcingDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(gaussianForcingDiseaseModel);
				if (result == null) result = caseDiseaseModel(gaussianForcingDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(gaussianForcingDiseaseModel);
				if (result == null) result = caseNodeDecorator(gaussianForcingDiseaseModel);
				if (result == null) result = caseSanityChecker(gaussianForcingDiseaseModel);
				if (result == null) result = caseModifiable(gaussianForcingDiseaseModel);
				if (result == null) result = caseDecorator(gaussianForcingDiseaseModel);
				if (result == null) result = caseIdentifiable(gaussianForcingDiseaseModel);
				if (result == null) result = caseComparable(gaussianForcingDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ForcingPackage.GAUSSIAN2_FORCING_DISEASE_MODEL: {
				Gaussian2ForcingDiseaseModel gaussian2ForcingDiseaseModel = (Gaussian2ForcingDiseaseModel)theEObject;
				T1 result = caseGaussian2ForcingDiseaseModel(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseStochasticSIRDiseaseModel(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseSIR(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseSI(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseDiseaseModel(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseNodeDecorator(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseSanityChecker(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseModifiable(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseDecorator(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseIdentifiable(gaussian2ForcingDiseaseModel);
				if (result == null) result = caseComparable(gaussian2ForcingDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ForcingPackage.GAUSSIAN3_FORCING_DISEASE_MODEL: {
				Gaussian3ForcingDiseaseModel gaussian3ForcingDiseaseModel = (Gaussian3ForcingDiseaseModel)theEObject;
				T1 result = caseGaussian3ForcingDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseGaussian2ForcingDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseStochasticSIRDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseSIR(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseStandardStochasticDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseSI(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseStochasticDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseStandardDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseDiseaseModel(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseIntegrationDecorator(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseNodeDecorator(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseSanityChecker(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseModifiable(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseDecorator(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseIdentifiable(gaussian3ForcingDiseaseModel);
				if (result == null) result = caseComparable(gaussian3ForcingDiseaseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	public T1 caseForcingDiseaseModel(ForcingDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gaussian Forcing Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gaussian Forcing Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGaussianForcingDiseaseModel(GaussianForcingDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gaussian2 Forcing Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gaussian2 Forcing Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGaussian2ForcingDiseaseModel(Gaussian2ForcingDiseaseModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gaussian3 Forcing Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gaussian3 Forcing Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGaussian3ForcingDiseaseModel(Gaussian3ForcingDiseaseModel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>SI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSI(SI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSIR(SIR object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Stochastic SIR Disease Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stochastic SIR Disease Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStochasticSIRDiseaseModel(StochasticSIRDiseaseModel object) {
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

} //ExampleSwitch

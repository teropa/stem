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

//import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It
 * provides an adapter <code>createXXX</code> method for each class of the
 * model. <!-- end-user-doc -->
 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage
 * @generated
 */
public class StandardAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static StandardPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public StandardAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StandardPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code>
	 * if the object is either the model's package or is an instance object of
	 * the model.
	 * 
	 * @param object
	 * 
	 * 
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StandardSwitch<Adapter> modelSwitch =
		new StandardSwitch<Adapter>() {
			@Override
			public Adapter caseDeterministicSEIRDiseaseModel(DeterministicSEIRDiseaseModel object) {
				return createDeterministicSEIRDiseaseModelAdapter();
			}
			@Override
			public Adapter caseDeterministicSIDiseaseModel(DeterministicSIDiseaseModel object) {
				return createDeterministicSIDiseaseModelAdapter();
			}
			@Override
			public Adapter caseDeterministicSIRDiseaseModel(DeterministicSIRDiseaseModel object) {
				return createDeterministicSIRDiseaseModelAdapter();
			}
			@Override
			public Adapter caseDiseaseModel(DiseaseModel object) {
				return createDiseaseModelAdapter();
			}
			@Override
			public Adapter caseDiseaseModelLabel(DiseaseModelLabel object) {
				return createDiseaseModelLabelAdapter();
			}
			@Override
			public Adapter caseDiseaseModelLabelValue(DiseaseModelLabelValue object) {
				return createDiseaseModelLabelValueAdapter();
			}
			@Override
			public Adapter caseDiseaseModelState(DiseaseModelState object) {
				return createDiseaseModelStateAdapter();
			}
			@Override
			public Adapter caseInfector(Infector object) {
				return createInfectorAdapter();
			}
			@Override
			public Adapter caseSEIR(SEIR object) {
				return createSEIRAdapter();
			}
			@Override
			public Adapter caseSEIRLabel(SEIRLabel object) {
				return createSEIRLabelAdapter();
			}
			@Override
			public Adapter caseSEIRLabelValue(SEIRLabelValue object) {
				return createSEIRLabelValueAdapter();
			}
			@Override
			public Adapter caseSI(SI object) {
				return createSIAdapter();
			}
			@Override
			public Adapter caseSIDiseaseModelState(SIDiseaseModelState object) {
				return createSIDiseaseModelStateAdapter();
			}
			@Override
			public Adapter caseSIInfector(SIInfector object) {
				return createSIInfectorAdapter();
			}
			@Override
			public Adapter caseSILabel(SILabel object) {
				return createSILabelAdapter();
			}
			@Override
			public Adapter caseSILabelValue(SILabelValue object) {
				return createSILabelValueAdapter();
			}
			@Override
			public Adapter caseSIR(SIR object) {
				return createSIRAdapter();
			}
			@Override
			public Adapter caseSIRLabel(SIRLabel object) {
				return createSIRLabelAdapter();
			}
			@Override
			public Adapter caseSIRLabelValue(SIRLabelValue object) {
				return createSIRLabelValueAdapter();
			}
			@Override
			public Adapter caseStandardDiseaseModel(StandardDiseaseModel object) {
				return createStandardDiseaseModelAdapter();
			}
			@Override
			public Adapter caseStandardDiseaseModelLabel(StandardDiseaseModelLabel object) {
				return createStandardDiseaseModelLabelAdapter();
			}
			@Override
			public Adapter caseStandardDiseaseModelLabelValue(StandardDiseaseModelLabelValue object) {
				return createStandardDiseaseModelLabelValueAdapter();
			}
			@Override
			public Adapter caseStandardDiseaseModelState(StandardDiseaseModelState object) {
				return createStandardDiseaseModelStateAdapter();
			}
			@Override
			public Adapter caseStandardInfector(StandardInfector object) {
				return createStandardInfectorAdapter();
			}
			@Override
			public Adapter caseStochasticSEIRDiseaseModel(StochasticSEIRDiseaseModel object) {
				return createStochasticSEIRDiseaseModelAdapter();
			}
			@Override
			public Adapter caseStochasticSIDiseaseModel(StochasticSIDiseaseModel object) {
				return createStochasticSIDiseaseModelAdapter();
			}
			@Override
			public Adapter caseStochasticSIRDiseaseModel(StochasticSIRDiseaseModel object) {
				return createStochasticSIRDiseaseModelAdapter();
			}
			@Override
			public Adapter caseSanityChecker(SanityChecker object) {
				return createSanityCheckerAdapter();
			}
			@Override
			public Adapter caseIntegrationLabel(IntegrationLabel object) {
				return createIntegrationLabelAdapter();
			}
			@Override
			public Adapter caseIntegrationLabelValue(IntegrationLabelValue object) {
				return createIntegrationLabelValueAdapter();
			}
			@Override
			public Adapter caseIntegrationDecorator(IntegrationDecorator object) {
				return createIntegrationDecoratorAdapter();
			}
			@Override
			public Adapter caseAggregatingSIDiseaseModel(AggregatingSIDiseaseModel object) {
				return createAggregatingSIDiseaseModelAdapter();
			}
			@Override
			public Adapter caseAggregatingDiseaseModelState(AggregatingDiseaseModelState object) {
				return createAggregatingDiseaseModelStateAdapter();
			}
			@Override
			public Adapter caseAggregatingSEIRDiseaseModel(AggregatingSEIRDiseaseModel object) {
				return createAggregatingSEIRDiseaseModelAdapter();
			}
			@Override
			public Adapter caseAggregatingSIRDiseaseModel(AggregatingSIRDiseaseModel object) {
				return createAggregatingSIRDiseaseModelAdapter();
			}
			@Override
			public Adapter caseStochasticDiseaseModel(StochasticDiseaseModel object) {
				return createStochasticDiseaseModelAdapter();
			}
			@Override
			public Adapter caseStandardStochasticDiseaseModel(StandardStochasticDiseaseModel object) {
				return createStandardStochasticDiseaseModelAdapter();
			}
			@Override
			public Adapter caseSIRInoculator(SIRInoculator object) {
				return createSIRInoculatorAdapter();
			}
			@Override
			public <T> Adapter caseComparable(Comparable<T> object) {
				return createComparableAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseDecorator(Decorator object) {
				return createDecoratorAdapter();
			}
			@Override
			public Adapter caseNodeDecorator(NodeDecorator object) {
				return createNodeDecoratorAdapter();
			}
			@Override
			public Adapter caseModifiable(Modifiable object) {
				return createModifiableAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseDynamicLabel(DynamicLabel object) {
				return createDynamicLabelAdapter();
			}
			@Override
			public Adapter caseNodeLabel(NodeLabel object) {
				return createNodeLabelAdapter();
			}
			@Override
			public Adapter caseDynamicNodeLabel(DynamicNodeLabel object) {
				return createDynamicNodeLabelAdapter();
			}
			@Override
			public Adapter caseSanityChecker_1(SanityChecker object) {
				return createSanityChecker_1Adapter();
			}
			@Override
			public Adapter caseLabelValue(LabelValue object) {
				return createLabelValueAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SEIR <em>SEIR</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIR
	 * @generated
	 */
	public Adapter createSEIRAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabel <em>SEIR Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabel
	 * @generated
	 */
	public Adapter createSEIRLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SEIRLabelValue <em>SEIR Label Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SEIRLabelValue
	 * @generated
	 */
	public Adapter createSEIRLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SIR <em>SIR</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SIR
	 * @generated
	 */
	public Adapter createSIRAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SIRLabel <em>SIR Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabel
	 * @generated
	 */
	public Adapter createSIRLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SIRLabelValue <em>SIR Label Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRLabelValue
	 * @generated
	 */
	public Adapter createSIRLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel
	 * @generated
	 */
	public Adapter createStandardDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModel <em>Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModel
	 * @generated
	 */
	public Adapter createDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel <em>Disease Model Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel
	 * @generated
	 */
	public Adapter createDiseaseModelLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel <em>Stochastic SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel
	 * @generated
	 */
	public Adapter createStochasticSEIRDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StandardInfector <em>Infector</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardInfector
	 * @generated
	 */
	public Adapter createStandardInfectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel <em>Deterministic SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel
	 * @generated
	 */
	public Adapter createDeterministicSEIRDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue <em>Disease Model Label Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue
	 * @generated
	 */
	public Adapter createDiseaseModelLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue <em>Disease Model Label Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue
	 * @generated
	 */
	public Adapter createStandardDiseaseModelLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel <em>Disease Model Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel
	 * @generated
	 */
	public Adapter createStandardDiseaseModelLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SI <em>SI</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SI
	 * @generated
	 */
	public Adapter createSIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SILabel <em>SI Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabel
	 * @generated
	 */
	public Adapter createSILabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SILabelValue <em>SI Label Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SILabelValue
	 * @generated
	 */
	public Adapter createSILabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.Infector <em>Infector</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.Infector
	 * @generated
	 */
	public Adapter createInfectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SIInfector <em>SI Infector</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SIInfector
	 * @generated
	 */
	public Adapter createSIInfectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel <em>Deterministic SIR Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel
	 * @generated
	 */
	public Adapter createDeterministicSIRDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel <em>Deterministic SI Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel
	 * @generated
	 */
	public Adapter createDeterministicSIDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel <em>Stochastic SIR Disease Model</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel
	 * @generated
	 */
	public Adapter createStochasticSIRDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel <em>Stochastic SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel
	 * @generated
	 */
	public Adapter createStochasticSIDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.DiseaseModelState <em>Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.DiseaseModelState
	 * @generated
	 */
	public Adapter createDiseaseModelStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState <em>SI Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState
	 * @generated
	 */
	public Adapter createSIDiseaseModelStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState <em>Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState
	 * @generated
	 */
	public Adapter createStandardDiseaseModelStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @generated
	 */
	public Adapter createSanityCheckerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.IntegrationLabel <em>Integration Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.IntegrationLabel
	 * @generated
	 */
	public Adapter createIntegrationLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.IntegrationLabelValue <em>Integration Label Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.IntegrationLabelValue
	 * @generated
	 */
	public Adapter createIntegrationLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.model.IntegrationDecorator <em>Integration Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.model.IntegrationDecorator
	 * @generated
	 */
	public Adapter createIntegrationDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel <em>Aggregating SI Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel
	 * @generated
	 */
	public Adapter createAggregatingSIDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState <em>Aggregating Disease Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState
	 * @generated
	 */
	public Adapter createAggregatingDiseaseModelStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingSEIRDiseaseModel <em>Aggregating SEIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingSEIRDiseaseModel
	 * @generated
	 */
	public Adapter createAggregatingSEIRDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.AggregatingSIRDiseaseModel <em>Aggregating SIR Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.AggregatingSIRDiseaseModel
	 * @generated
	 */
	public Adapter createAggregatingSIRDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel <em>Stochastic Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StochasticDiseaseModel
	 * @generated
	 */
	public Adapter createStochasticDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel <em>Stochastic Disease Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardStochasticDiseaseModel
	 * @generated
	 */
	public Adapter createStandardStochasticDiseaseModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.diseasemodels.standard.SIRInoculator <em>SIR Inoculator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.diseasemodels.standard.SIRInoculator
	 * @generated
	 */
	public Adapter createSIRInoculatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.lang.Comparable
	 * @generated
	 */
	public Adapter createComparableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.common.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.common.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.model.Decorator <em>Decorator</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.model.Decorator
	 * @generated
	 */
	public Adapter createDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.model.NodeDecorator <em>Node Decorator</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.model.NodeDecorator
	 * @generated
	 */
	public Adapter createNodeDecoratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.modifier.Modifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.modifier.Modifiable
	 * @generated
	 */
	public Adapter createModifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.Label <em>Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.DynamicLabel <em>Dynamic Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.DynamicLabel
	 * @generated
	 */
	public Adapter createDynamicLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.NodeLabel <em>Node Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.NodeLabel
	 * @generated
	 */
	public Adapter createNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.DynamicNodeLabel <em>Dynamic Node Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.DynamicNodeLabel
	 * @generated
	 */
	public Adapter createDynamicNodeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.common.SanityChecker <em>Sanity Checker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.common.SanityChecker
	 * @generated
	 */
	public Adapter createSanityChecker_1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.stem.core.graph.LabelValue <em>Label Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.stem.core.graph.LabelValue
	 * @generated
	 */
	public Adapter createLabelValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // StandardAdapterFactory

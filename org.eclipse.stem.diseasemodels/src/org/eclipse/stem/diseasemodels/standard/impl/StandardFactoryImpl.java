package org.eclipse.stem.diseasemodels.standard.impl;

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

import java.util.Random;
//import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.stem.diseasemodels.standard.*;

import org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DeterministicSIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SIDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.SIRLabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.StochasticSEIRDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StochasticSIRDiseaseModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardFactoryImpl extends EFactoryImpl implements StandardFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StandardFactory init() {
		try {
			StandardFactory theStandardFactory = (StandardFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/diseasemodels/standard.ecore"); //$NON-NLS-1$ 
			if (theStandardFactory != null) {
				return theStandardFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StandardFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StandardPackage.DETERMINISTIC_SEIR_DISEASE_MODEL: return (EObject)createDeterministicSEIRDiseaseModel();
			case StandardPackage.DETERMINISTIC_SI_DISEASE_MODEL: return (EObject)createDeterministicSIDiseaseModel();
			case StandardPackage.DETERMINISTIC_SIR_DISEASE_MODEL: return (EObject)createDeterministicSIRDiseaseModel();
			case StandardPackage.SEIR_LABEL: return (EObject)createSEIRLabel();
			case StandardPackage.SEIR_LABEL_VALUE: return (EObject)createSEIRLabelValue();
			case StandardPackage.SI_DISEASE_MODEL_STATE: return (EObject)createSIDiseaseModelState();
			case StandardPackage.SI_INFECTOR: return (EObject)createSIInfector();
			case StandardPackage.SI_LABEL: return (EObject)createSILabel();
			case StandardPackage.SI_LABEL_VALUE: return (EObject)createSILabelValue();
			case StandardPackage.SIR_LABEL: return (EObject)createSIRLabel();
			case StandardPackage.SIR_LABEL_VALUE: return (EObject)createSIRLabelValue();
			case StandardPackage.STOCHASTIC_SEIR_DISEASE_MODEL: return (EObject)createStochasticSEIRDiseaseModel();
			case StandardPackage.STOCHASTIC_SI_DISEASE_MODEL: return (EObject)createStochasticSIDiseaseModel();
			case StandardPackage.STOCHASTIC_SIR_DISEASE_MODEL: return (EObject)createStochasticSIRDiseaseModel();
			case StandardPackage.AGGREGATING_SI_DISEASE_MODEL: return (EObject)createAggregatingSIDiseaseModel();
			case StandardPackage.AGGREGATING_DISEASE_MODEL_STATE: return (EObject)createAggregatingDiseaseModelState();
			case StandardPackage.AGGREGATING_SEIR_DISEASE_MODEL: return (EObject)createAggregatingSEIRDiseaseModel();
			case StandardPackage.AGGREGATING_SIR_DISEASE_MODEL: return (EObject)createAggregatingSIRDiseaseModel();
			case StandardPackage.SIR_INOCULATOR: return (EObject)createSIRInoculator();
			case StandardPackage.STOCHASTIC_POISSON_SI_DISEASE_MODEL: return (EObject)createStochasticPoissonSIDiseaseModel();
			case StandardPackage.STOCHASTIC_POISSON_SIR_DISEASE_MODEL: return (EObject)createStochasticPoissonSIRDiseaseModel();
			case StandardPackage.STOCHASTIC_POISSON_SEIR_DISEASE_MODEL: return (EObject)createStochasticPoissonSEIRDiseaseModel();
			case StandardPackage.INFECTOR_INOCULATOR_COLLECTION: return (EObject)createInfectorInoculatorCollection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StandardPackage.URI:
				return createURIFromString(eDataType, initialValue);
			case StandardPackage.ELIST:
				return createEListFromString(eDataType, initialValue);
			case StandardPackage.RANDOM:
				return createRandomFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StandardPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			case StandardPackage.ELIST:
				return convertEListToString(eDataType, instanceValue);
			case StandardPackage.RANDOM:
				return convertRandomToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeterministicSEIRDiseaseModel createDeterministicSEIRDiseaseModel() {
		DeterministicSEIRDiseaseModelImpl deterministicSEIRDiseaseModel = new DeterministicSEIRDiseaseModelImpl();
		return deterministicSEIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeterministicSIDiseaseModel createDeterministicSIDiseaseModel() {
		DeterministicSIDiseaseModelImpl deterministicSIDiseaseModel = new DeterministicSIDiseaseModelImpl();
		return deterministicSIDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeterministicSIRDiseaseModel createDeterministicSIRDiseaseModel() {
		DeterministicSIRDiseaseModelImpl deterministicSIRDiseaseModel = new DeterministicSIRDiseaseModelImpl();
		return deterministicSIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabel createSEIRLabel() {
		SEIRLabelImpl seirLabel = new SEIRLabelImpl();
		return seirLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEIRLabelValue createSEIRLabelValue() {
		SEIRLabelValueImpl seirLabelValue = new SEIRLabelValueImpl();
		return seirLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIDiseaseModelState createSIDiseaseModelState() {
		SIDiseaseModelStateImpl siDiseaseModelState = new SIDiseaseModelStateImpl();
		return siDiseaseModelState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIInfector createSIInfector() {
		SIInfectorImpl siInfector = new SIInfectorImpl();
		return siInfector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabel createSILabel() {
		SILabelImpl siLabel = new SILabelImpl();
		return siLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SILabelValue createSILabelValue() {
		SILabelValueImpl siLabelValue = new SILabelValueImpl();
		return siLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabel createSIRLabel() {
		SIRLabelImpl sirLabel = new SIRLabelImpl();
		return sirLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRLabelValue createSIRLabelValue() {
		SIRLabelValueImpl sirLabelValue = new SIRLabelValueImpl();
		return sirLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticSEIRDiseaseModel createStochasticSEIRDiseaseModel() {
		StochasticSEIRDiseaseModelImpl stochasticSEIRDiseaseModel = new StochasticSEIRDiseaseModelImpl();
		return stochasticSEIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticSIDiseaseModel createStochasticSIDiseaseModel() {
		StochasticSIDiseaseModelImpl stochasticSIDiseaseModel = new StochasticSIDiseaseModelImpl();
		return stochasticSIDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticSIRDiseaseModel createStochasticSIRDiseaseModel() {
		StochasticSIRDiseaseModelImpl stochasticSIRDiseaseModel = new StochasticSIRDiseaseModelImpl();
		return stochasticSIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatingSIDiseaseModel createAggregatingSIDiseaseModel() {
		AggregatingSIDiseaseModelImpl aggregatingSIDiseaseModel = new AggregatingSIDiseaseModelImpl();
		return aggregatingSIDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatingDiseaseModelState createAggregatingDiseaseModelState() {
		AggregatingDiseaseModelStateImpl aggregatingDiseaseModelState = new AggregatingDiseaseModelStateImpl();
		return aggregatingDiseaseModelState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatingSEIRDiseaseModel createAggregatingSEIRDiseaseModel() {
		AggregatingSEIRDiseaseModelImpl aggregatingSEIRDiseaseModel = new AggregatingSEIRDiseaseModelImpl();
		return aggregatingSEIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatingSIRDiseaseModel createAggregatingSIRDiseaseModel() {
		AggregatingSIRDiseaseModelImpl aggregatingSIRDiseaseModel = new AggregatingSIRDiseaseModelImpl();
		return aggregatingSIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIRInoculator createSIRInoculator() {
		SIRInoculatorImpl sirInoculator = new SIRInoculatorImpl();
		return sirInoculator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticPoissonSIDiseaseModel createStochasticPoissonSIDiseaseModel() {
		StochasticPoissonSIDiseaseModelImpl stochasticPoissonSIDiseaseModel = new StochasticPoissonSIDiseaseModelImpl();
		return stochasticPoissonSIDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticPoissonSIRDiseaseModel createStochasticPoissonSIRDiseaseModel() {
		StochasticPoissonSIRDiseaseModelImpl stochasticPoissonSIRDiseaseModel = new StochasticPoissonSIRDiseaseModelImpl();
		return stochasticPoissonSIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticPoissonSEIRDiseaseModel createStochasticPoissonSEIRDiseaseModel() {
		StochasticPoissonSEIRDiseaseModelImpl stochasticPoissonSEIRDiseaseModel = new StochasticPoissonSEIRDiseaseModelImpl();
		return stochasticPoissonSEIRDiseaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfectorInoculatorCollection createInfectorInoculatorCollection() {
		InfectorInoculatorCollectionImpl infectorInoculatorCollection = new InfectorInoculatorCollectionImpl();
		return infectorInoculatorCollection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return URI.createURI(initialValue);
	} // createURIFromString

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return instanceValue.toString();
	} // convertURIToString

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList createEListFromString(EDataType eDataType, String initialValue) {
		return (EList)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Random createRandomFromString(EDataType eDataType, String initialValue) {
		return new Random(Long.parseLong(initialValue));
	} // createRandomFromString

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRandomToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPackage getStandardPackage() {
		return (StandardPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StandardPackage getPackage() {
		return StandardPackage.eINSTANCE;
	}

} //StandardFactoryImpl

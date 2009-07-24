/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.stem.populationmodels.standard.*;

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
			StandardFactory theStandardFactory = (StandardFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/populationmodels/standard"); 
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
			case StandardPackage.STANDARD_POPULATION_MODEL: return createStandardPopulationModel();
			case StandardPackage.POPULATION_MODEL_LABEL: return createPopulationModelLabel();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL: return createStandardPopulationModelLabel();
			case StandardPackage.POPULATION_MODEL_LABEL_VALUE: return createPopulationModelLabelValue();
			case StandardPackage.STANDARD_POPULATION_MODEL_LABEL_VALUE: return createStandardPopulationModelLabelValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModel createStandardPopulationModel() {
		StandardPopulationModelImpl standardPopulationModel = new StandardPopulationModelImpl();
		return standardPopulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabel createPopulationModelLabel() {
		PopulationModelLabelImpl populationModelLabel = new PopulationModelLabelImpl();
		return populationModelLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabel createStandardPopulationModelLabel() {
		StandardPopulationModelLabelImpl standardPopulationModelLabel = new StandardPopulationModelLabelImpl();
		return standardPopulationModelLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PopulationModelLabelValue createPopulationModelLabelValue() {
		PopulationModelLabelValueImpl populationModelLabelValue = new PopulationModelLabelValueImpl();
		return populationModelLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardPopulationModelLabelValue createStandardPopulationModelLabelValue() {
		StandardPopulationModelLabelValueImpl standardPopulationModelLabelValue = new StandardPopulationModelLabelValueImpl();
		return standardPopulationModelLabelValue;
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

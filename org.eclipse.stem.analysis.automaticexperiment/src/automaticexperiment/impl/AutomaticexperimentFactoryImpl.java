package automaticexperiment.impl;

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

import automaticexperiment.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.AutomaticexperimentFactory;
import automaticexperiment.AutomaticexperimentPackage;
import automaticexperiment.ModifiableParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AutomaticexperimentFactoryImpl extends EFactoryImpl implements AutomaticexperimentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AutomaticexperimentFactory init() {
		try {
			AutomaticexperimentFactory theAutomaticexperimentFactory = (AutomaticexperimentFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/eclipse/stem/core/automaticexperiment.ecore"); 
			if (theAutomaticexperimentFactory != null) {
				return theAutomaticexperimentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AutomaticexperimentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutomaticexperimentFactoryImpl() {
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
			case AutomaticexperimentPackage.AUTOMATIC_EXPERIMENT: return (EObject)createAutomaticExperiment();
			case AutomaticexperimentPackage.MODIFIABLE_PARAMETER: return (EObject)createModifiableParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutomaticExperiment createAutomaticExperiment() {
		AutomaticExperimentImpl automaticExperiment = new AutomaticExperimentImpl();
		return automaticExperiment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiableParameter createModifiableParameter() {
		ModifiableParameterImpl modifiableParameter = new ModifiableParameterImpl();
		return modifiableParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutomaticexperimentPackage getAutomaticexperimentPackage() {
		return (AutomaticexperimentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AutomaticexperimentPackage getPackage() {
		return AutomaticexperimentPackage.eINSTANCE;
	}

} //AutomaticexperimentFactoryImpl

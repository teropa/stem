package org.eclipse.stem.definitions.transport.impl;

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

//import org.eclipse.stem.core.common.CommonPackage;

import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.model.ModelPackage;

import org.eclipse.stem.definitions.edges.EdgesPackage;


import org.eclipse.stem.definitions.transport.PipeStyleTransportSystem;
import org.eclipse.stem.definitions.transport.PipeTransportEdge;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue;
import org.eclipse.stem.definitions.transport.TransportFactory;
import org.eclipse.stem.definitions.transport.TransportPackage;
import org.eclipse.stem.definitions.transport.TransportSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransportPackageImpl extends EPackageImpl implements TransportPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipeStyleTransportSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transportSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipeTransportEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipeTransportEdgeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipeTransportEdgeLabelValueEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.stem.definitions.transport.TransportPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TransportPackageImpl() {
		super(eNS_URI, TransportFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TransportPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TransportPackage init() {
		if (isInited) return (TransportPackage)EPackage.Registry.INSTANCE.getEPackage(TransportPackage.eNS_URI);

		// Obtain or create and register package
		TransportPackageImpl theTransportPackage = (TransportPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransportPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransportPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EdgesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTransportPackage.createPackageContents();

		// Initialize created meta-data
		theTransportPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTransportPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TransportPackage.eNS_URI, theTransportPackage);
		return theTransportPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipeStyleTransportSystem() {
		return pipeStyleTransportSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPipeStyleTransportSystem_InTransportEdges() {
		return (EReference)pipeStyleTransportSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPipeStyleTransportSystem_OutTransportEdges() {
		return (EReference)pipeStyleTransportSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipeStyleTransportSystem_MaxCapacity() {
		return (EAttribute)pipeStyleTransportSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransportSystem() {
		return transportSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipeTransportEdge() {
		return pipeTransportEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipeTransportEdgeLabel() {
		return pipeTransportEdgeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipeTransportEdgeLabelValue() {
		return pipeTransportEdgeLabelValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipeTransportEdgeLabelValue_MaxFlow() {
		return (EAttribute)pipeTransportEdgeLabelValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipeTransportEdgeLabelValue_TimePeriod() {
		return (EAttribute)pipeTransportEdgeLabelValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportFactory getTransportFactory() {
		return (TransportFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		pipeStyleTransportSystemEClass = createEClass(PIPE_STYLE_TRANSPORT_SYSTEM);
		createEReference(pipeStyleTransportSystemEClass, PIPE_STYLE_TRANSPORT_SYSTEM__IN_TRANSPORT_EDGES);
		createEReference(pipeStyleTransportSystemEClass, PIPE_STYLE_TRANSPORT_SYSTEM__OUT_TRANSPORT_EDGES);
		createEAttribute(pipeStyleTransportSystemEClass, PIPE_STYLE_TRANSPORT_SYSTEM__MAX_CAPACITY);

		transportSystemEClass = createEClass(TRANSPORT_SYSTEM);

		pipeTransportEdgeEClass = createEClass(PIPE_TRANSPORT_EDGE);

		pipeTransportEdgeLabelEClass = createEClass(PIPE_TRANSPORT_EDGE_LABEL);

		pipeTransportEdgeLabelValueEClass = createEClass(PIPE_TRANSPORT_EDGE_LABEL_VALUE);
		createEAttribute(pipeTransportEdgeLabelValueEClass, PIPE_TRANSPORT_EDGE_LABEL_VALUE__MAX_FLOW);
		createEAttribute(pipeTransportEdgeLabelValueEClass, PIPE_TRANSPORT_EDGE_LABEL_VALUE__TIME_PERIOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);
		EdgesPackage theEdgesPackage = (EdgesPackage)EPackage.Registry.INSTANCE.getEPackage(EdgesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pipeStyleTransportSystemEClass.getESuperTypes().add(this.getTransportSystem());
		transportSystemEClass.getESuperTypes().add(theGraphPackage.getNode());
		pipeTransportEdgeEClass.getESuperTypes().add(theEdgesPackage.getPopulationEdge());
		pipeTransportEdgeLabelEClass.getESuperTypes().add(theGraphPackage.getEdgeLabel());
		pipeTransportEdgeLabelValueEClass.getESuperTypes().add(theGraphPackage.getLabelValue());

		// Initialize classes and features; add operations and parameters
		initEClass(pipeStyleTransportSystemEClass, PipeStyleTransportSystem.class, "PipeStyleTransportSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipeStyleTransportSystem_InTransportEdges(), this.getPipeTransportEdge(), null, "inTransportEdges", null, 0, -1, PipeStyleTransportSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPipeStyleTransportSystem_OutTransportEdges(), this.getPipeTransportEdge(), null, "outTransportEdges", null, 0, -1, PipeStyleTransportSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipeStyleTransportSystem_MaxCapacity(), theEcorePackage.getEDouble(), "maxCapacity", null, 0, 1, PipeStyleTransportSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transportSystemEClass, TransportSystem.class, "TransportSystem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pipeTransportEdgeEClass, PipeTransportEdge.class, "PipeTransportEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pipeTransportEdgeLabelEClass, PipeTransportEdgeLabel.class, "PipeTransportEdgeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pipeTransportEdgeLabelValueEClass, PipeTransportEdgeLabelValue.class, "PipeTransportEdgeLabelValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPipeTransportEdgeLabelValue_MaxFlow(), theEcorePackage.getEDouble(), "maxFlow", null, 0, 1, PipeTransportEdgeLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipeTransportEdgeLabelValue_TimePeriod(), theEcorePackage.getELong(), "timePeriod", null, 0, 1, PipeTransportEdgeLabelValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TransportPackageImpl

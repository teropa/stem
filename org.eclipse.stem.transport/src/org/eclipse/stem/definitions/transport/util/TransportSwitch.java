package org.eclipse.stem.definitions.transport.util;

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
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;

import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.modifier.Modifiable;
import org.eclipse.stem.definitions.edges.MigrationEdge;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;

import org.eclipse.stem.definitions.transport.*;

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
 * @see org.eclipse.stem.definitions.transport.TransportPackage
 * @generated
 */
public class TransportSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TransportPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransportSwitch() {
		if (modelPackage == null) {
			modelPackage = TransportPackage.eINSTANCE;
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
			case TransportPackage.LOAD_UNLOAD_EDGE: {
				LoadUnloadEdge loadUnloadEdge = (LoadUnloadEdge)theEObject;
				T1 result = caseLoadUnloadEdge(loadUnloadEdge);
				if (result == null) result = caseMigrationEdge(loadUnloadEdge);
				if (result == null) result = caseEdge(loadUnloadEdge);
				if (result == null) result = caseIdentifiable(loadUnloadEdge);
				if (result == null) result = caseModifiable(loadUnloadEdge);
				if (result == null) result = caseComparable(loadUnloadEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.LOAD_UNLOAD_EDGE_LABEL: {
				LoadUnloadEdgeLabel loadUnloadEdgeLabel = (LoadUnloadEdgeLabel)theEObject;
				T1 result = caseLoadUnloadEdgeLabel(loadUnloadEdgeLabel);
				if (result == null) result = caseMigrationEdgeLabel(loadUnloadEdgeLabel);
				if (result == null) result = caseDynamicLabel(loadUnloadEdgeLabel);
				if (result == null) result = caseEdgeLabel(loadUnloadEdgeLabel);
				if (result == null) result = caseLabel(loadUnloadEdgeLabel);
				if (result == null) result = caseIdentifiable(loadUnloadEdgeLabel);
				if (result == null) result = caseComparable(loadUnloadEdgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM: {
				PacketStyleTransportSystem packetStyleTransportSystem = (PacketStyleTransportSystem)theEObject;
				T1 result = casePacketStyleTransportSystem(packetStyleTransportSystem);
				if (result == null) result = caseTransportSystem(packetStyleTransportSystem);
				if (result == null) result = caseNode(packetStyleTransportSystem);
				if (result == null) result = caseIdentifiable(packetStyleTransportSystem);
				if (result == null) result = caseComparable(packetStyleTransportSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PACKET_TRANSPORT_LABEL: {
				PacketTransportLabel packetTransportLabel = (PacketTransportLabel)theEObject;
				T1 result = casePacketTransportLabel(packetTransportLabel);
				if (result == null) result = caseNodeLabel(packetTransportLabel);
				if (result == null) result = caseLabel(packetTransportLabel);
				if (result == null) result = caseIdentifiable(packetTransportLabel);
				if (result == null) result = caseComparable(packetTransportLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PIPE_STYLE_TRANSPORT_SYSTEM: {
				PipeStyleTransportSystem pipeStyleTransportSystem = (PipeStyleTransportSystem)theEObject;
				T1 result = casePipeStyleTransportSystem(pipeStyleTransportSystem);
				if (result == null) result = caseTransportSystem(pipeStyleTransportSystem);
				if (result == null) result = caseNode(pipeStyleTransportSystem);
				if (result == null) result = caseIdentifiable(pipeStyleTransportSystem);
				if (result == null) result = caseComparable(pipeStyleTransportSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.TRANSPORT_SYSTEM: {
				TransportSystem transportSystem = (TransportSystem)theEObject;
				T1 result = caseTransportSystem(transportSystem);
				if (result == null) result = caseNode(transportSystem);
				if (result == null) result = caseIdentifiable(transportSystem);
				if (result == null) result = caseComparable(transportSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PACKET_TRANSPORT_LABEL_VALUE: {
				PacketTransportLabelValue packetTransportLabelValue = (PacketTransportLabelValue)theEObject;
				T1 result = casePacketTransportLabelValue(packetTransportLabelValue);
				if (result == null) result = caseLabelValue(packetTransportLabelValue);
				if (result == null) result = caseSanityChecker(packetTransportLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PACKET_STYLE_TRANSPORT_SYSTEM_DECORATOR: {
				PacketStyleTransportSystemDecorator packetStyleTransportSystemDecorator = (PacketStyleTransportSystemDecorator)theEObject;
				T1 result = casePacketStyleTransportSystemDecorator(packetStyleTransportSystemDecorator);
				if (result == null) result = caseEdgeDecorator(packetStyleTransportSystemDecorator);
				if (result == null) result = caseDecorator(packetStyleTransportSystemDecorator);
				if (result == null) result = caseIdentifiable(packetStyleTransportSystemDecorator);
				if (result == null) result = caseComparable(packetStyleTransportSystemDecorator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PIPE_TRANSPORT_EDGE: {
				PipeTransportEdge pipeTransportEdge = (PipeTransportEdge)theEObject;
				T1 result = casePipeTransportEdge(pipeTransportEdge);
				if (result == null) result = caseEdge(pipeTransportEdge);
				if (result == null) result = caseIdentifiable(pipeTransportEdge);
				if (result == null) result = caseModifiable(pipeTransportEdge);
				if (result == null) result = caseComparable(pipeTransportEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL: {
				PipeTransportEdgeLabel pipeTransportEdgeLabel = (PipeTransportEdgeLabel)theEObject;
				T1 result = casePipeTransportEdgeLabel(pipeTransportEdgeLabel);
				if (result == null) result = caseEdgeLabel(pipeTransportEdgeLabel);
				if (result == null) result = caseLabel(pipeTransportEdgeLabel);
				if (result == null) result = caseIdentifiable(pipeTransportEdgeLabel);
				if (result == null) result = caseComparable(pipeTransportEdgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TransportPackage.PIPE_TRANSPORT_EDGE_LABEL_VALUE: {
				PipeTransportEdgeLabelValue pipeTransportEdgeLabelValue = (PipeTransportEdgeLabelValue)theEObject;
				T1 result = casePipeTransportEdgeLabelValue(pipeTransportEdgeLabelValue);
				if (result == null) result = caseLabelValue(pipeTransportEdgeLabelValue);
				if (result == null) result = caseSanityChecker(pipeTransportEdgeLabelValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Unload Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Unload Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLoadUnloadEdge(LoadUnloadEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Unload Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Unload Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLoadUnloadEdgeLabel(LoadUnloadEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packet Style Transport System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packet Style Transport System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePacketStyleTransportSystem(PacketStyleTransportSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packet Transport Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packet Transport Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePacketTransportLabel(PacketTransportLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipe Style Transport System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipe Style Transport System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipeStyleTransportSystem(PipeStyleTransportSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTransportSystem(TransportSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packet Transport Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packet Transport Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePacketTransportLabelValue(PacketTransportLabelValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packet Style Transport System Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packet Style Transport System Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePacketStyleTransportSystemDecorator(PacketStyleTransportSystemDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipe Transport Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipe Transport Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipeTransportEdge(PipeTransportEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipe Transport Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipe Transport Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipeTransportEdgeLabel(PipeTransportEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipe Transport Edge Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipe Transport Edge Label Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePipeTransportEdgeLabelValue(PipeTransportEdgeLabelValue object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Migration Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Migration Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMigrationEdge(MigrationEdge object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEdgeLabel(EdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Migration Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Migration Edge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMigrationEdgeLabel(MigrationEdgeLabel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNode(Node object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Edge Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEdgeDecorator(EdgeDecorator object) {
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

} //TransportSwitch

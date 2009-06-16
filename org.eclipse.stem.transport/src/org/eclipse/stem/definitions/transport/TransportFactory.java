package org.eclipse.stem.definitions.transport;

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.definitions.transport.TransportPackage
 * @generated
 */
public interface TransportFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransportFactory eINSTANCE = org.eclipse.stem.definitions.transport.impl.TransportFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Load Unload Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Unload Edge</em>'.
	 * @generated
	 */
	LoadUnloadEdge createLoadUnloadEdge();

	/**
	 * Returns a new object of class '<em>Load Unload Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Unload Edge Label</em>'.
	 * @generated
	 */
	LoadUnloadEdgeLabel createLoadUnloadEdgeLabel();

	/**
	 * Returns a new object of class '<em>Packet Style Transport System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Packet Style Transport System</em>'.
	 * @generated
	 */
	PacketStyleTransportSystem createPacketStyleTransportSystem();

	/**
	 * Returns a new object of class '<em>Packet Transport Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Packet Transport Label</em>'.
	 * @generated
	 */
	PacketTransportLabel createPacketTransportLabel();

	/**
	 * Returns a new object of class '<em>Pipe Style Transport System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipe Style Transport System</em>'.
	 * @generated
	 */
	PipeStyleTransportSystem createPipeStyleTransportSystem();

	/**
	 * Returns a new object of class '<em>Packet Transport Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Packet Transport Label Value</em>'.
	 * @generated
	 */
	PacketTransportLabelValue createPacketTransportLabelValue();

	/**
	 * Returns a new object of class '<em>Packet Style Transport System Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Packet Style Transport System Decorator</em>'.
	 * @generated
	 */
	PacketStyleTransportSystemDecorator createPacketStyleTransportSystemDecorator();

	/**
	 * Returns a new object of class '<em>Pipe Transport Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipe Transport Edge</em>'.
	 * @generated
	 */
	PipeTransportEdge createPipeTransportEdge();

	/**
	 * Returns a new object of class '<em>Pipe Transport Edge Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipe Transport Edge Label</em>'.
	 * @generated
	 */
	PipeTransportEdgeLabel createPipeTransportEdgeLabel();

	/**
	 * Returns a new object of class '<em>Pipe Transport Edge Label Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipe Transport Edge Label Value</em>'.
	 * @generated
	 */
	PipeTransportEdgeLabelValue createPipeTransportEdgeLabelValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TransportPackage getTransportPackage();

} //TransportFactory

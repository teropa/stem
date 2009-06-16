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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.model.impl.EdgeDecoratorImpl;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.definitions.edges.MigrationEdgeLabelValue;
import org.eclipse.stem.definitions.transport.PacketStyleTransportSystemDecorator;
import org.eclipse.stem.definitions.transport.TransportPackage;
import org.eclipse.stem.definitions.transport.LoadUnloadEdgeLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packet Style Transport System Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PacketStyleTransportSystemDecoratorImpl extends EdgeDecoratorImpl implements PacketStyleTransportSystemDecorator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PacketStyleTransportSystemDecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransportPackage.Literals.PACKET_STYLE_TRANSPORT_SYSTEM_DECORATOR;
	}

	/**
	 * Utility method for getting all of the LoadUnloadEdgeLabels in the graph
	 * */
	protected Collection<LoadUnloadEdgeLabel> getLoadUnloadLabels (final Graph graph){
		//List we will return
		final List<LoadUnloadEdgeLabel> rc = new ArrayList<LoadUnloadEdgeLabel>();
	
		//get all of the LoadUnloadEdgeLabels
			for (Iterator<DynamicLabel> luLabelIterator = graph.getDynamicLabels().iterator();
		luLabelIterator.hasNext();) {			
			DynamicLabel tmp = luLabelIterator.next();
			if (tmp.getTypeURI().equals(LoadUnloadEdgeLabel.URI_TYPE_LOAD_UNLOAD_EDGE_LABEL)) {
				rc.add((LoadUnloadEdgeLabel)tmp);
			}
		}
	
		return rc;
	}
	
	/**
	 * Initialize the graph. Makes sure all of the rates for the edges are zeroed out.
	 */
	public void decorateGraph() {
		//There is nothing to do except reset the labels.		
		resetLabels();
	}
	
	/**
	 * Update labels. Make sure all of the labels for the graph are in the appropriate state for this tim
	 * interval.
	 */
	public void updateLabels(final STEMTime time, final long timerPeriod, int cycle) {
		for (Iterator<LoadUnloadEdgeLabel> it = getLoadUnloadLabels(getGraph()).iterator(); it.hasNext();) {			
			LoadUnloadEdgeLabel toUpdate = it.next();			
			
			if(time.getTime().after(toUpdate.getActivationTime().getTime()) &&
					time.getTime().before(toUpdate.getDeactivationTime().getTime())) {
				//Edge should be active...the rate of active edges needs to be normalized
				// to the population that is coming in				
				((MigrationEdgeLabelValue)toUpdate.getNextValue()).setMigrationRate(toUpdate.getNormalizedActivatedRate());				
			} else {
				//Edge should be inactive
				((MigrationEdgeLabelValue)toUpdate.getNextValue()).setMigrationRate(0.0);
			}
		}
	}
	
	/**
	 * reset the labels to their initial state in the graph
	 */
	public void resetLabels() {
		for (Iterator<LoadUnloadEdgeLabel> it = getLoadUnloadLabels(getGraph()).iterator(); it.hasNext();) {			
			LoadUnloadEdgeLabel toUpdate = it.next();
			toUpdate.reset();
		}
	}
	
} //PacketStyleTransportSystemDecoratorImpl

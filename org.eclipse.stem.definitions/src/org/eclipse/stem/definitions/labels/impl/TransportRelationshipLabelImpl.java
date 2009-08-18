package org.eclipse.stem.definitions.labels.impl;

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.impl.DynamicEdgeLabelImpl;
import org.eclipse.stem.core.model.EdgeDecorator;
import org.eclipse.stem.core.model.STEMTime;

import org.eclipse.stem.core.graph.impl.EdgeImpl;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.TransportMode;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabelValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Transport Relationship Label</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getTransportMode <em>Transport Mode</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getTransportIdentifier <em>Transport Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getCurrentTransportRelationshipLabelValue <em>Current Transport Relationship Label Value</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getRateTimePeriod <em>Rate Time Period</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getDepartureCapacity <em>Departure Capacity</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getMaximumDepartureCapacity <em>Maximum Departure Capacity</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getMaximumCapacity <em>Maximum Capacity</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getTransitTime <em>Transit Time</em>}</li>
 *   <li>{@link org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl#getStartUpDelay <em>Start Up Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransportRelationshipLabelImpl extends DynamicEdgeLabelImpl
		implements TransportRelationshipLabel {
	/**
	 * The default value of the '{@link #getTransportMode() <em>Transport Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTransportMode()
	 * @generated
	 * @ordered
	 */
	protected static final TransportMode TRANSPORT_MODE_EDEFAULT = TransportMode.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getTransportMode() <em>Transport Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTransportMode()
	 * @generated
	 * @ordered
	 */
	protected TransportMode transportMode = TRANSPORT_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String populationIdentifier = POPULATION_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportIdentifier() <em>Transport Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTransportIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSPORT_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransportIdentifier() <em>Transport Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTransportIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String transportIdentifier = TRANSPORT_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRateTimePeriod() <em>Rate Time Period</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRateTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected static final long RATE_TIME_PERIOD_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRateTimePeriod() <em>Rate Time Period</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRateTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected long rateTimePeriod = RATE_TIME_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepartureCapacity() <em>Departure Capacity</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDepartureCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int DEPARTURE_CAPACITY_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getMaximumDepartureCapacity() <em>Maximum Departure Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumDepartureCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_DEPARTURE_CAPACITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximumDepartureCapacity() <em>Maximum Departure Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumDepartureCapacity()
	 * @generated
	 * @ordered
	 */
	protected int maximumDepartureCapacity = MAXIMUM_DEPARTURE_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getMaximumCapacity() <em>Maximum Capacity</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMaximumCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_CAPACITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximumCapacity() <em>Maximum Capacity</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMaximumCapacity()
	 * @generated
	 * @ordered
	 */
	protected int maximumCapacity = MAXIMUM_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransitTime() <em>Transit Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTransitTime()
	 * @generated
	 * @ordered
	 */
	protected static final long TRANSIT_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTransitTime() <em>Transit Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTransitTime()
	 * @generated
	 * @ordered
	 */
	protected long transitTime = TRANSIT_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartUpDelay() <em>Start Up Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getStartUpDelay()
	 * @generated
	 * @ordered
	 */
	protected static final long START_UP_DELAY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartUpDelay() <em>Start Up Delay</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getStartUpDelay()
	 * @generated
	 * @ordered
	 */
	protected long startUpDelay = START_UP_DELAY_EDEFAULT;

	private EObject nodeBArrivals = null;

	private EObject nodeAArrivals = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected TransportRelationshipLabelImpl() {
		super();
		setCurrentValue(LabelsFactory.eINSTANCE
				.createTransportRelationshipLabelValue());
		setNextValue(LabelsFactory.eINSTANCE
				.createTransportRelationshipLabelValue());
	} // TransportRelationshipLabelImpl

	/**
	 * Create an edge the represents a reflexive transportation relationship
	 * between two nodes.
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param transportMode
	 *            the transportation mode
	 * @param transportIdentifier
	 *            the identifier of the transportation (e.g., road name)
	 * @param populationIdentifier
	 *            the population being transported
	 * @param edgeDecorator
	 * @return
	 */
	public static Edge createTransportRelationship(final Node nodeA,
			final Node nodeB, final TransportMode transportMode,
			final String transportIdentifier,
			final String populationIdentifier, final long rateTimePeriod,
			final int maximumCapacity, EdgeDecorator edgeDecorator) {
		return createTransportRelationship(nodeA, nodeB, transportMode,
				transportIdentifier, populationIdentifier, rateTimePeriod,
				maximumCapacity, false, edgeDecorator);
	} // createTransportRelationship

	/**
	 * Create an edge the represents a reflexive transportation relationship
	 * between two nodes.
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param transportMode
	 *            the transportation mode
	 * @param transportIdentifier
	 *            the identifier of the transportation (e.g., road name)
	 * @param populationIdentifier
	 *            the population being transported
	 * @param edgeDecorator
	 * @return
	 */
	public static Edge createTransportRelationship(final Node nodeA,
			final Node nodeB, final TransportMode transportMode,
			final String transportIdentifier,
			final String populationIdentifier, final long rateTimePeriod,
			final int maximumCapacity, final boolean directed,
			EdgeDecorator edgeDecorator) {
		return createTransportRelationship(nodeA, nodeB, transportMode,
				transportIdentifier, populationIdentifier, rateTimePeriod,
				maximumCapacity, maximumCapacity, 0, 0, directed, edgeDecorator);
	} // createTransportRelationship

	/**
	 * Create an edge the represents a reflexive transportation relationship
	 * between two nodes.
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param transportMode
	 *            the transportation mode
	 * @param transportIdentifier
	 *            the identifier of the transportation (e.g., road name)
	 * @param populationIdentifier
	 *            the population being transported
	 * @param edgeDecorator
	 * @return
	 */
	public static Edge createTransportRelationship(final Node nodeA,
			final Node nodeB, final TransportMode transportMode,
			final String transportIdentifier,
			final String populationIdentifier, final long rateTimePeriod,
			final int maximumDepartureCapacity, final int maximumCapacity,
			final long transitTime, final long startUpDelay,
			EdgeDecorator edgeDecorator) {
		return createTransportRelationship(nodeA, nodeB, transportMode,
				transportIdentifier, populationIdentifier, rateTimePeriod,
				maximumDepartureCapacity, maximumCapacity, transitTime,
				startUpDelay, false, edgeDecorator);
	} // createTransportRelationship

	/**
	 * Create an edge the represents a transportation relationship between two
	 * nodes.
	 * 
	 * @param nodeA
	 *            the first node
	 * @param nodeB
	 *            the second node
	 * @param transportMode
	 *            the transportation mode
	 * @param transportIdentifier
	 *            the identifier of the transportion (e.g., road name)
	 * @param populationIdentifier
	 *            the population being transported
	 * @param rateTimePeriod
	 *            the unit of time the population count is transported in
	 *            (milliseconds)
	 * @param directed
	 *            if true then the relationship is only from nodeA to nodeB, and
	 *            not the other way around. This means things move from nodeA to
	 *            nodeB, but not in the other direction.
	 * @param edgeDecorator
	 *            TODO
	 * @param populationCount
	 *            the number of population members
	 * @return
	 */
	public static Edge createTransportRelationship(final Node nodeA,
			final Node nodeB, final TransportMode transportMode,
			final String transportIdentifier,
			final String populationIdentifier, final long rateTimePeriod,
			final int maximumDepartureCapacity, final int maximumCapacity,
			final long transitTime, final long startUpDelay,
			final boolean directed, EdgeDecorator edgeDecorator) {

		final Edge retValue = EdgeImpl.createEdge(nodeA, nodeB, directed);

		final TransportRelationshipLabel label = LabelsFactory.eINSTANCE
				.createTransportRelationshipLabel();
		label.setURIOfIdentifiableToBeLabeled(retValue.getURI());
		label.setDecorator(edgeDecorator);
		label.setPopulationIdentifier(populationIdentifier);
		label.setTransportIdentifier(transportIdentifier);
		label.setRateTimePeriod(rateTimePeriod);
		label.setMaximumDepartureCapacity(maximumDepartureCapacity);
		label.setMaximumCapacity(maximumCapacity);
		label.setTransitTime(transitTime);
		label.setStartUpDelay(startUpDelay);
		label.setTransportMode(transportMode);

		final TransportRelationshipLabelValue trlv = label
				.getCurrentTransportRelationshipLabelValue();
		trlv.setAvailableDepartureCapacityProportion(1.0);

		retValue.setLabel(label);
		return retValue;
	} // createTransportRelationship

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.TRANSPORT_RELATIONSHIP_LABEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransportMode getTransportMode() {
		return transportMode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportMode(TransportMode newTransportMode) {
		TransportMode oldTransportMode = transportMode;
		transportMode = newTransportMode == null ? TRANSPORT_MODE_EDEFAULT : newTransportMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE, oldTransportMode, transportMode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return populationIdentifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		String oldPopulationIdentifier = populationIdentifier;
		populationIdentifier = newPopulationIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER, oldPopulationIdentifier, populationIdentifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransportIdentifier() {
		return transportIdentifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportIdentifier(String newTransportIdentifier) {
		String oldTransportIdentifier = transportIdentifier;
		transportIdentifier = newTransportIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER, oldTransportIdentifier, transportIdentifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public TransportRelationshipLabelValue getCurrentTransportRelationshipLabelValue() {
		return (TransportRelationshipLabelValue) getCurrentValue();
	} // getCurrentTransportRelationshipLabelValue

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getRateTimePeriod() {
		return rateTimePeriod;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateTimePeriod(long newRateTimePeriod) {
		long oldRateTimePeriod = rateTimePeriod;
		rateTimePeriod = newRateTimePeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD, oldRateTimePeriod, rateTimePeriod));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getDepartureCapacity() {
		// $ANALYSIS-IGNORE
		return (int) (getMaximumDepartureCapacity() * getCurrentTransportRelationshipLabelValue()
				.getAvailableDepartureCapacityProportion());
	} // getDepartureCapacity

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumDepartureCapacity() {
		return maximumDepartureCapacity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumDepartureCapacity(int newMaximumDepartureCapacity) {
		int oldMaximumDepartureCapacity = maximumDepartureCapacity;
		maximumDepartureCapacity = newMaximumDepartureCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY, oldMaximumDepartureCapacity, maximumDepartureCapacity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getCapacity() {
		// $ANALYSIS-IGNORE
		return (int) (getMaximumCapacity() * getCurrentTransportRelationshipLabelValue()
				.getAvailableDepartureCapacityProportion());
	} // getCapacity

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumCapacity() {
		return maximumCapacity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumCapacity(int newMaximumCapacity) {
		int oldMaximumCapacity = maximumCapacity;
		maximumCapacity = newMaximumCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY, oldMaximumCapacity, maximumCapacity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getTransitTime() {
		return transitTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitTime(long newTransitTime) {
		long oldTransitTime = transitTime;
		transitTime = newTransitTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME, oldTransitTime, transitTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartUpDelay() {
		return startUpDelay;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartUpDelay(long newStartUpDelay) {
		long oldStartUpDelay = startUpDelay;
		startUpDelay = newStartUpDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY, oldStartUpDelay, startUpDelay));
	}

	/**
	 * @see org.eclipse.stem.definitions.labels.TransportRelationshipLabel#send(org.eclipse.stem.core.graph.Node,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void send(Node here, EObject departees) {
		// Are we sending from Node A?
		if (getEdge().getA().equals(here)) {
			// Yes
			nodeBArrivals = departees;
		} else {
			// No
			// Must be Node B
			nodeAArrivals = departees;
		}
	} // send

	/**
	 * @see org.eclipse.stem.definitions.labels.TransportRelationshipLabel#receive(org.eclipse.stem.core.graph.Node,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	public EList<EObject> receive(Node here, STEMTime currentTime) {
		final EList<EObject> retValue = new BasicEList<EObject>();
		// Are we receiving at Node A?
		if (getEdge().getA().equals(here)) {
			// Yes
			// Anything to get?
			if (nodeAArrivals != null) {
				// Yes
				retValue.add(nodeAArrivals);
				nodeAArrivals = null;
			}
		} else {
			// No
			// Anything to get?
			if (nodeBArrivals != null) {
				// Yes
				retValue.add(nodeBArrivals);
				nodeBArrivals = null;
			}
		}
		return retValue;
	} // receive

	/**
	 * @param node
	 *            the node
	 * @param populationIdentifier
	 *            the population being transported
	 * @return the Edges that represent the transportation of population members
	 *         to the node.
	 */
	public static List<Edge> getTransportEdgesToNode(final Node node,
			final String populationIdentifier) {
		final List<Edge> retValue = new ArrayList<Edge>();

		for (Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter
				.hasNext();) {
			final Edge edge = edgeIter.next();
			// Is the edge directed away from us?
			if (!edge.isDirected() || edge.isDirectedAt(node)) {
				// No
				// It could be transporting population members to the node then
				final Label edgeLabel = edge.getLabel();
				// Is the label a transport label?
				if (edgeLabel instanceof TransportRelationshipLabel) {
					// Yes
					final TransportRelationshipLabel transportLabel = (TransportRelationshipLabel) edgeLabel;
					// Same population?
					if (transportLabel.getPopulationIdentifier()
							.equalsIgnoreCase(populationIdentifier)) {
						// Yes
						// It's a keeper
						retValue.add(edge);
					}
				}
			}
		} // for

		return retValue;
	} // getTransportEdgesToNode

	/**
	 * @param node
	 *            the node
	 * @param populationIdentifier
	 *            the population being transported
	 * @return the Edges that represent the transportation of population members
	 *         to the node.
	 */
	public static List<Edge> getTransportEdgesFromNode(final Node node,
			final String populationIdentifier) {
		final List<Edge> retValue = new ArrayList<Edge>();

		for (Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter
				.hasNext();) {
			final Edge edge = edgeIter.next();
			// Is the edge directed away from us?
			if (!edge.isDirected() || !edge.isDirectedAt(node)) {
				// Yes
				// It could be transporting population members from the node
				// then
				final Label edgeLabel = edge.getLabel();
				// Is the label a transport label?
				if (edgeLabel instanceof TransportRelationshipLabel) {
					// Yes
					final TransportRelationshipLabel transportLabel = (TransportRelationshipLabel) edgeLabel;
					// Same population?
					if (transportLabel.getPopulationIdentifier()
							.equalsIgnoreCase(populationIdentifier)) {
						// Yes
						// It's a keeper
						retValue.add(edge);
					}
				}
			}
		} // for

		return retValue;
	} // getTransportEdgesToNode

	@Override
	public void reset() {
		super.reset();
		nodeAArrivals = null;
		nodeBArrivals = null;
	} // reset

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE:
				return getTransportMode();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER:
				return getTransportIdentifier();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__CURRENT_TRANSPORT_RELATIONSHIP_LABEL_VALUE:
				return getCurrentTransportRelationshipLabelValue();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD:
				return getRateTimePeriod();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__DEPARTURE_CAPACITY:
				return getDepartureCapacity();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY:
				return getMaximumDepartureCapacity();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__CAPACITY:
				return getCapacity();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY:
				return getMaximumCapacity();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME:
				return getTransitTime();
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY:
				return getStartUpDelay();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE:
				setTransportMode((TransportMode)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER:
				setTransportIdentifier((String)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD:
				setRateTimePeriod((Long)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY:
				setMaximumDepartureCapacity((Integer)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY:
				setMaximumCapacity((Integer)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME:
				setTransitTime((Long)newValue);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY:
				setStartUpDelay((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE:
				setTransportMode(TRANSPORT_MODE_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER:
				setTransportIdentifier(TRANSPORT_IDENTIFIER_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD:
				setRateTimePeriod(RATE_TIME_PERIOD_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY:
				setMaximumDepartureCapacity(MAXIMUM_DEPARTURE_CAPACITY_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY:
				setMaximumCapacity(MAXIMUM_CAPACITY_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME:
				setTransitTime(TRANSIT_TIME_EDEFAULT);
				return;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY:
				setStartUpDelay(START_UP_DELAY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_MODE:
				return transportMode != TRANSPORT_MODE_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? populationIdentifier != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(populationIdentifier);
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSPORT_IDENTIFIER:
				return TRANSPORT_IDENTIFIER_EDEFAULT == null ? transportIdentifier != null : !TRANSPORT_IDENTIFIER_EDEFAULT.equals(transportIdentifier);
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__CURRENT_TRANSPORT_RELATIONSHIP_LABEL_VALUE:
				return getCurrentTransportRelationshipLabelValue() != null;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__RATE_TIME_PERIOD:
				return rateTimePeriod != RATE_TIME_PERIOD_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__DEPARTURE_CAPACITY:
				return getDepartureCapacity() != DEPARTURE_CAPACITY_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_DEPARTURE_CAPACITY:
				return maximumDepartureCapacity != MAXIMUM_DEPARTURE_CAPACITY_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__CAPACITY:
				return getCapacity() != CAPACITY_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__MAXIMUM_CAPACITY:
				return maximumCapacity != MAXIMUM_CAPACITY_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__TRANSIT_TIME:
				return transitTime != TRANSIT_TIME_EDEFAULT;
			case LabelsPackage.TRANSPORT_RELATIONSHIP_LABEL__START_UP_DELAY:
				return startUpDelay != START_UP_DELAY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer();
		result.append(transportMode);
		result.append(", ");
		result.append(populationIdentifier);
		result.append(", \"");
		result.append(transportIdentifier);
		result.append("\" ");
		result.append(getCurrentTransportRelationshipLabelValue().toString());
		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.core.graph.impl.DynamicLabelImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue && rateTimePeriod >= 0;
		assert retValue;

		retValue = retValue
				&& getCurrentTransportRelationshipLabelValue().sane();

		return retValue;
	}

} // TransportRelationshipLabelImpl

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.impl.URIToNodeMapEntryImpl;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationship;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.TransportMode;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.AggregatingDiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Aggregating SI Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AggregatingSIDiseaseModelImpl extends SIImpl implements
		AggregatingSIDiseaseModel {

	BasicEList reverseLabelsToUpdate = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatingSIDiseaseModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.AGGREGATING_SI_DISEASE_MODEL;
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#decorateGraph()
	 */
	@Override
	public boolean decorateGraph() {
		final Node rootNode = getRootNode(getGraph());
		// Did we find a root node?
		if (rootNode != null) {
			// Yes
			decorateGraph(rootNode);
		} // if
		else {
			// No
			Activator
					.logInformation(
							getDublinCore().getTitle()
									+ " didn't find a root node for the graph.  Missing containment relationship?",
							null);
		} // else
		return true;
	} // decorateGraph

	/**
	 * @return the root {@link Node} in the tree in the graph formed by the
	 *         containment edges.
	 */
	private Node getRootNode(final Graph graph) {

		Node parent = null;
		// Find a node that has a containment edge directed at it
		for (final Iterator<Node> nodeIter = graph.getNodes().values().iterator(); nodeIter
				.hasNext();) {
			final Node node = nodeIter.next();
			// Is this node "contained" by another?
			parent = getParentNode(node);
			if (parent != null) {
				// Yes
				break;
			}
		} // for each node

		// Did we find a parent?
		if (parent != null) {
			// Yes
			// Walk up the tree to the root
			Node newParent = parent;
			do {
				parent = newParent;
				newParent = getParentNode(parent);
			} while (newParent != null);
		} // if

		return parent;
	} // getRootNode

	/**
	 * @param node
	 * @return the {@link Node} that contains this one, or <code>null</code>
	 *         if there is no parent
	 */
	static public Node getParentNode(final Node node) {
		Node parent = null;
		if (node == null) {
			return null;
		}

		for (final Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter
				.hasNext();) {
			final Edge edge = edgeIter.next();
			// Directed at this node?
			if (edge.isDirectedAt(node)) {
				// Yes
				final Label label = edge.getLabel();
				// Containment?
				if (label instanceof RelativePhysicalRelationshipLabel) {
					final RelativePhysicalRelationshipLabel rprl = (RelativePhysicalRelationshipLabel) label;
					if (rprl.getCurrentRelationship().getRelationship() == RelativePhysicalRelationship.CONTAINS_LITERAL) {
						// Yes
						parent = edge.getOtherNode(node);
						break;
					}
				}
			}
		} // for each edge

		return parent;
	} // getParentNode

	/**
	 * Recursively descend the tree formed by the {@link Edge}s with
	 * {@link RelativePhysicalRelationshipLabel}s
	 * {@link RelativePhysicalRelationship#CONTAINS} values. For instance, from
	 * a country to its states.
	 * 
	 * @param node
	 *            the starting {@link Node}
	 * @return the {@link SILabel} instance that decorates the tree rooted at
	 *         <code>node</code>.
	 */
	protected SILabel decorateGraph(final Node node) {
		SILabel retValue = null;
		// Is there a node to decorate?
		if (node != null) {
			// Yes

			// Does this node already have a label for the right population and
			// disease model type?
			for (final DiseaseModelLabel diseaseModelLabel : getDiseaseLabels(node)) {
				// Is this one we're looking for?
				if (diseaseModelLabel instanceof SILabel) {
					// Is the population the same?
					if (diseaseModelLabel.getPopulationLabel().getName()
							.equals(getPopulationIdentifier())) {
						// Yes
						// This is the one we want then
						retValue = (SILabel) diseaseModelLabel;
						break;
					}
				}
			} // for each disease model label on this node

			// Did we find a label here already?
			if (retValue == null) {
				// No
				final EList childrensLabels = getChildrensLabels(node);

				final PopulationModelLabel populationLabel = getOrCreatePopulationLabel(
						node, getPopulationIdentifier());

				final DiseaseModelLabel dml = createDiseaseModelLabel();
				DiseaseModelLabelImpl.labelNode(dml, populationLabel, node);
				getLabelsToUpdate().add(dml);

				getGraph().putNodeLabel(dml);

				// Initialize the disease model state (if any). The state holds
				// values useful for the computation of the disease model
				final DiseaseModelState dms = createDiseaseModelState();
				final AggregatingDiseaseModelState adms = (AggregatingDiseaseModelState) dms;
				adms.getChildrensLabels().addAll(childrensLabels);
				dml.setDiseaseModelState(adms);

				retValue = (SILabel) dml;
			}
		} // if node to decorate

		return retValue;
	} // decorateGraph

	/**
	 * @param node
	 * @return a list of all of the {@link DiseaseModelLabel}s that label the
	 *         {@link Node}
	 */
	private List<DiseaseModelLabel> getDiseaseLabels(final Node node) {
		final List<DiseaseModelLabel> retValue = new ArrayList<DiseaseModelLabel>();
		try {
			for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter
					.hasNext();) {
				final Label label = labelIter.next();
				// Is this a disease model label?
				if (label instanceof DiseaseModelLabel) {
					final DiseaseModelLabel diseaseModelLabel = (DiseaseModelLabel) label;
					retValue.add(diseaseModelLabel);
				}
			}
		} // try
		catch (NullPointerException npe) {
			// We get a NPE if node is null
			Activator.logError("Internal error", npe);
		} // catch NullPointerException
		return retValue;
	} // getDiseaseLabels

	/**
	 * @param node
	 * @return a list of the {@link DiseaseModelLabel}s that label {@link Node}s
	 *         that are "children" of parameter <code>node</code>
	 */
	private EList getChildrensLabels(final Node node) {
		final EList retValue = new BasicEList();
		// Iterate through each of the children of this node recursively
		for (final Node childNode : getChildNodes(node)) {
			retValue.add(decorateGraph(childNode));
		}
		return retValue;
	} // getChildrensLabels

	/**
	 * @param node
	 * @return the {@link Node}s that are children of the parameter
	 *         <code>node</code>
	 */
	public static List<Node> getChildNodes(final Node node) {
		final List<Node> retValue = new ArrayList<Node>();

		for (final Iterator<Edge> edgeIter = node.getEdges().iterator(); edgeIter
				.hasNext();) {
			final Edge edge = edgeIter.next();
			// Is this a physical containment edge directed from us?
			final Label label = edge.getLabel();
			if (label instanceof RelativePhysicalRelationshipLabel) {
				final RelativePhysicalRelationshipLabel rprLabel = (RelativePhysicalRelationshipLabel) label;
				if (!edge.isDirectedAt(node)
						&& rprLabel.getCurrentRelationship().getRelationship() == RelativePhysicalRelationship.CONTAINS_LITERAL) {
					// Yes
					// Has the other node been resolved?
					final Node otherNode = edge.getOtherNode(node);
					if (otherNode != null) {
						// Yes
						retValue.add(otherNode);
					}
				}
			}
		} // for each edge

		return retValue;
	} // getChildNodes

	/**
	 * @param node
	 * @param populationIdentifier
	 * @return a {@link PopulationLabel} that labels the parameter
	 *         <code>node</node>, either by finding it labeling the {@link Node}, or by creating it.
	 */
	private PopulationModelLabel getOrCreatePopulationLabel(final Node node,
			final String populationIdentifier) {
		PopulationModelLabel retValue = null;

		// Try to find the population label if it exists
		for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter
				.hasNext();) {
			final Label label = labelIter.next();
			// Is it the population label we're looking for?
			if (label instanceof PopulationModelLabel) {
				final PopulationModelLabel populationLabel = (PopulationModelLabel) label;
				if (populationLabel.getPopulationIdentifier().equals(populationIdentifier)) {
					// Yes
					retValue = populationLabel;
					break;
				}
			}
		} // for each label

		// Did we find the population Label?
		if (retValue == null) {
			// No
			// Make one then.
			retValue = org.eclipse.stem.populationmodels.standard.StandardFactory.eINSTANCE.createPopulationModelLabel();
			retValue.setURIOfIdentifiableToBeLabeled(node.getURI());
			// We don't set the population value
			node.getLabels().add(retValue);
			URIToNodeMapEntryImpl entry = (URIToNodeMapEntryImpl) node
					.eContainer();
			Graph graph = (Graph) entry.eContainer();
			graph.putNodeLabel(retValue);
		}

		return retValue;
	} // getOrCreatePopulationLabel

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#updateLabels(org.eclipse.stem.core.model.STEMTime,
	 *      long)
	 */
	@Override
	public void updateLabels(final STEMTime time, final long timeDelta, int cycle) {
		// The "next" values of the disease model labels of the underlying child
		// nodes have been computed by the time this is called. And, the label
		// values for this decorator have been ordered so that the parent is
		// processed after its children, with the root label being last.

		// First we "reset" the labels so they all have zero values. We're going
		// to accumulate the values of their children's next values so we want
		// to start the sum off from zero.

		zeroOutPopulationCountsOnLabels();

		// Set the progress of this iterator to 0
		this.setProgress(0.0);
		// Now go through each label we update and update it from all of its
		// children
		double numLabels = getLabelsToUpdate().size();
		double n = 0.0;
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate().iterator(); labelIter
				.hasNext();) {
			final SILabel parentSILabel = (SILabel) labelIter.next();
			final AggregatingDiseaseModelState adms = (AggregatingDiseaseModelState) parentSILabel
					.getDiseaseModelState();
			for (final Iterator childDMLIter = adms.getChildrensLabels()
					.iterator(); childDMLIter.hasNext();) {
				final SILabel childSILabel = (SILabel) childDMLIter.next();
				updateFromChildLabel(parentSILabel, childSILabel);
			} // for
			parentSILabel.setNextValueValid(true);
			this.setProgress(n/numLabels);
			n+=1.0;
		} // for each disease model label to update

		// Now we forward the population members that are being transported
		forwardTransportation(time);
		// Done
		this.setProgress(1.0);
	} // updateLabels

	/**
	 * Accumulate the values from the child label in to the next value of the
	 * parent label
	 * 
	 * @param childLabel
	 */
	protected void updateFromChildLabel(final SILabel parentLabel,
			final SILabel childLabel) {
		final double nextDiseaseDeaths = parentLabel.getNextDiseaseDeaths();

		parentLabel.setNextDiseaseDeaths(nextDiseaseDeaths
				+ childLabel.getNextDiseaseDeaths());

		final double nextS = parentLabel.getNextS();
		final double nextI = parentLabel.getNextI();

		parentLabel.setNextS(nextS + childLabel.getNextS());
		parentLabel.setNextI(nextI + childLabel.getNextI());

	} // updateFromChildLabel

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#computeDepartures(double,
	 *      org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue)
	 */
	@Override
	protected StandardDiseaseModelLabelValue computeDepartures(
			final double fractionToDepart,
			final StandardDiseaseModelLabelValue nextState) {
		return super.computeDepartures(fractionToDepart, nextState);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#createDiseaseModelState()
	 */
	@Override
	public DiseaseModelState createDiseaseModelState() {
		return StandardFactory.eINSTANCE.createAggregatingDiseaseModelState();
	} // createDiseaseModelState

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getArrivals(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	@Override
	protected StandardDiseaseModelLabelValue getMigrationDeltas(
			final StandardDiseaseModelLabel diseaseLabel, final STEMTime time, DiseaseModelLabelValue returnValue) {
		return super.getMigrationDeltas(diseaseLabel, time, returnValue);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#initializeDiseaseState(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel)
	 */
	@Override
	public void initializeDiseaseState(final DiseaseModelLabel diseaseModelLabel) {
		// super.initializeDiseaseState(diseaseModelLabel);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#initializeDiseaseState(org.eclipse.stem.diseasemodels.standard.DiseaseModelState,
	 *      org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel)
	 */
	@Override
	public DiseaseModelState initializeDiseaseState(
			final DiseaseModelState diseaseModelState,
			final DiseaseModelLabel diseaseModelLabel) {

		return diseaseModelState;
	} // initializeDiseaseState

	

	/**
	 * One of the jobs of the aggregating disease model is to also forward
	 * population members along the transportation network.
	 * 
	 * @param time
	 */
	protected void forwardTransportation(final STEMTime time) {
		// Go through each label that needs to be updated and accumulate the
		// arrivals from their children, then pass those along to the node's
		// parent and peers (if any).
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate().iterator(); labelIter
				.hasNext();) {
			final SILabel siLabel = (SILabel) labelIter.next();
			final AggregatingDiseaseModelStateImpl adms = (AggregatingDiseaseModelStateImpl) siLabel
					.getDiseaseModelState();
			final Node node = siLabel.getNode();

			boolean isRootNode = !labelIter.hasNext();
			// Iterate through each of the transportation modes that
			// send/receive population members from the node.
			for (final TransportMode transportationMode : adms
					.getTransportModes()) {
				// Get all of the arrivals at this node from the kids for
				// the current transportation mode
				final SILabelValue kidArrivals = getArrivalsFromKids(node,
						adms, transportationMode, time);
				// Is this the root?
				if (!isRootNode) {
					// No
					// Now send what we got from the kids along to our parent
					// and our peers
					// Anything to send?
					if (kidArrivals.getPopulationCount() > 0.0) {
						// Yes
						sendDeparturesToParentAndPeers(kidArrivals, node, adms,
								transportationMode, time);
					} // if Anything to send?
				} // if root
				else {
					// Yes
					// This is the root, no parent, no peers, time to
					// redistribute what the kids have been sending out.
					// Send what we got from the kids, back to the kids
					// Anything to send?
					if (kidArrivals.getPopulationCount() > 0.0) {
						// Yes
						sendDeparturesToKids(kidArrivals, node, adms,
								transportationMode, time);
					} // if Anything to send?
				} // else root
			} // for each transport mode
		} // for each label to update

		// Now we want to work backwards through the list of labels to
		// update to propagate the population members down through the tree
		// to their ultimate destinations in the leaf Nodes.
		boolean firstOne = true;
		for (final Iterator reverseLabelsToUpdateIter = getReverseLabelsToUpdate()
				.iterator(); reverseLabelsToUpdateIter.hasNext();) {
			final SILabel reverseSILabel = (SILabel) reverseLabelsToUpdateIter
					.next();
			final AggregatingDiseaseModelStateImpl revadms = (AggregatingDiseaseModelStateImpl) reverseSILabel
					.getDiseaseModelState();
			final Node node = reverseSILabel.getNode();

			// Iterate through each of the transportation modes that
			// send/receive population members from the node.
			for (final TransportMode transportationMode : revadms
					.getTransportModes()) {
				// Is this the root?
				if (!firstOne) {
					// No
					final SILabelValue parentPeerArrivals = getArrivalsFromParentPeers(
							node, revadms, transportationMode, time);
					// Now send what we got from our parent or our peers
					// along to our children
					// Anything to send?
					if (parentPeerArrivals.getPopulationCount() > 0.0) {
						// Yes
						sendDeparturesToKids(parentPeerArrivals, node, revadms,
								transportationMode, time);
					} // if Anything to send?

				} else {
					// Yes
					// We skip over the root because we already processed it
					// at the end of the previous for loop.
					firstOne = false;
				} // else
			} // for each transport mode
		} // for each label to update in reverse order
	}// forwardTransportation

	/**
	 * @param node
	 * @param adms
	 * @param transportationMode
	 * @param time
	 * @return
	 */
	protected SILabelValue getArrivalsFromKids(final Node node,
			final AggregatingDiseaseModelStateImpl adms,
			final TransportMode transportationMode, final STEMTime time) {
		return receiveFromEdges(node, adms.getChildTransportEdges().get(
				transportationMode), time);
	} // getArrivalsFromKids

	/**
	 * @param parentPeerArrivals
	 * @param node
	 * @param adms
	 * @param transportationMode
	 * @param time
	 */
	protected void sendDeparturesToKids(final SILabelValue parentPeerArrivals,
			final Node node, final AggregatingDiseaseModelStateImpl adms,
			final TransportMode transportationMode, final STEMTime time) {
		sendToEdges(node, parentPeerArrivals, adms.getChildTransportEdges()
				.get(transportationMode), time);
	} // sendDeparturesToKids

	/**
	 * @param node
	 * @param revadms
	 * @param transportationMode
	 * @param time
	 * @return
	 */
	protected SILabelValue getArrivalsFromParentPeers(final Node node,
			final AggregatingDiseaseModelStateImpl adms,
			final TransportMode transportationMode, final STEMTime time) {
		return receiveFromEdges(node, adms.getParentPeerTransportEdges().get(
				transportationMode), time);
	} // getArrivalsFromParentPeers

	/**
	 * @param kidArrivals
	 * @param node
	 * @param adms
	 * @param transportationMode
	 * @param time
	 */
	protected void sendDeparturesToParentAndPeers(
			final SILabelValue kidArrivals, final Node node,
			final AggregatingDiseaseModelStateImpl adms,
			final TransportMode transportationMode, final STEMTime time) {
		sendToEdges(node, kidArrivals, adms.getParentPeerTransportEdges().get(
				transportationMode), time);
	} // sendDeparturesToParentAndPeers

	/**
	 * @param node
	 * @param transportEdges
	 * @param time
	 * @return
	 */
	private SILabelValue receiveFromEdges(final Node node,
			final List<Edge> transportEdges, final STEMTime time) {
		final SILabelValue retValue = (SILabelValue) createDiseaseModelLabelValue();

		// Any edges for this transportation mode?
		if (transportEdges != null) {
			// Yes
			for (final Edge edge : transportEdges) {
				final TransportRelationshipLabel trl = (TransportRelationshipLabel) edge
						.getLabel();
				final EList arrivals = trl.receive(node, time);
				for (final Iterator arrivalIter = arrivals.iterator(); arrivalIter
						.hasNext();) {
					final SILabelValue arrivalSILabelValue = (SILabelValue) arrivalIter
							.next();
					retValue.add(arrivalSILabelValue);
				} // for each arrival
			} // for each edge
		} // if transport edges

		return retValue;
	} // receiveFromEdges

	/**
	 * @param node
	 * @param arrivals
	 * @param transportEdges
	 * @param time
	 * @return
	 */
	private void sendToEdges(final Node node, final SILabelValue arrivals,
			final List<Edge> transportEdges, final STEMTime time) {
		// Any edges for this transportation mode?
		if (transportEdges != null) {
			// Yes
			// Sum up the total capacity. This can change if transportation
			// links are closed or opened during the simulation
			double totalCapacity = 0;
			for (final Edge edge : transportEdges) {
				final TransportRelationshipLabel trl = (TransportRelationshipLabel) edge
						.getLabel();
				totalCapacity += trl.getDepartureCapacity();
			} // for each edge

			// Was there any capacity?
			if (totalCapacity > 0.0) {
				// Yes
				// Now send the right proportion along each edge
				for (final Edge edge : transportEdges) {
					final TransportRelationshipLabel trl = (TransportRelationshipLabel) edge
							.getLabel();
					final double proportion = trl.getDepartureCapacity()
							/ totalCapacity;
					final SILabelValue departees = (SILabelValue) createDiseaseModelLabelValue();
					departees.add(arrivals).scale(proportion);
					trl.send(node, departees);
				} // for each edge
			} // capacity
		} // if transport edges
	} // sendToEdges

	/**
	 * @return the labels to update in reverse order
	 */
	private BasicEList getReverseLabelsToUpdate() {
		// Do we have the reverse list?
		if (reverseLabelsToUpdate == null) {
			// No
			// Reverse the list
			// There must be a utility to do this better.
			final EList<DynamicLabel> forwardList = getLabelsToUpdate();
			final int numLabels = forwardList.size();

			reverseLabelsToUpdate = new BasicEList();
			for (int i = numLabels - 1; i >= 0; i--) {
				reverseLabelsToUpdate.add(forwardList.get(i));
			} // for
		} // if we have the reverse list

		return reverseLabelsToUpdate;
	} // getReverseLabelsToUpdate

	/**
	 * Make all the population values be zero for all of the labels we update.
	 */
	private void zeroOutPopulationCountsOnLabels() {
		// The reset call above sets the susceptible population to the
		// population of the node being labeled. Make sure we zero that out too.
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate().iterator(); labelIter
				.hasNext();) {
			final SILabel siLabel = (SILabel) labelIter.next();
			((StandardDiseaseModelLabelValue) siLabel.getCurrentValue()).zeroOutPopulationCount();
			((StandardDiseaseModelLabelValue) siLabel.getNextValue()).zeroOutPopulationCount();
		} // for each population label
	} // zeroOutPopulationCountsOnLabels

	@Override
	public void resetLabels() {
		super.resetLabels();
		// The reset call above sets the susceptible population to the
		// population of the node being labeled. Make sure we zero that out too.
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate().iterator(); labelIter
				.hasNext();) {
			final SILabel siLabel = (SILabel) labelIter.next();
			siLabel.setS(0);
			siLabel.setNextS(0);
		} // for
	} // resetLabels

	public void doModelSpecificAdjustments(LabelValue label) {
		// Nothing
	}
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.SIImpl#sane()
	 */
	@Override
	public boolean sane() {
		return true;
	} // sane

	@Override
	public boolean isDeterministic() {
		return true;
	}
} // AggregatingSIDiseaseModelImpl

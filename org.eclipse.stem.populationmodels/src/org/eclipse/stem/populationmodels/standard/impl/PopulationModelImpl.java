package org.eclipse.stem.populationmodels.standard.impl;

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


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabelValue;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.core.Utility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationModelImpl#getTargetISOKey <em>Target ISO Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PopulationModelImpl extends NodeDecoratorImpl implements PopulationModel {
	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = "human";

	/**
	 * The cached value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String populationIdentifier = POPULATION_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "HumanPopulationModel";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetISOKey() <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetISOKey()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ISO_KEY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTargetISOKey() <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetISOKey()
	 * @generated
	 * @ordered
	 */
	protected String targetISOKey = TARGET_ISO_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PopulationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.POPULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return populationIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		String oldPopulationIdentifier = populationIdentifier;
		populationIdentifier = newPopulationIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_MODEL__POPULATION_IDENTIFIER, oldPopulationIdentifier, populationIdentifier));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetISOKey() {
		return targetISOKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetISOKey(String newTargetISOKey) {
		String oldTargetISOKey = targetISOKey;
		targetISOKey = newTargetISOKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_MODEL__TARGET_ISO_KEY, oldTargetISOKey, targetISOKey));
	}

	/**
	 * Decorate the graph for a standard population model
	 * 
	 */
	@Override
	public boolean decorateGraph() {
		for (final Iterator<PopulationLabel> populationLabelIter = getPopulationLabels(
				getPopulationIdentifier(), getGraph()).iterator(); populationLabelIter
				.hasNext();) {
			final PopulationLabel populationLabel = populationLabelIter.next();

			if(this.getPopulationIdentifier().equals(populationLabel.getPopulationIdentifier())) {
				// Make sure the node does not already have a population model label for this population
				// identifier. 
				boolean found = false;
				for(NodeLabel l:populationLabel.getNode().getLabels()) {
					if(l instanceof PopulationModelLabel && 
							((PopulationModelLabel)l).getPopulationIdentifier().equals(this.getPopulationIdentifier()))
						{found = true;break;}
				}
				if(found)continue;
				
				// Okay, another population model has not yet added population model labels
				// for the same population identifier, but it might do so in the future depending
				// upon the order decorateGraph() is called on the decorators. Check if there
				// is another population model with a higher iso level target node URI that the
				// node is contained within.
				
				found = false;
				for(Decorator d:this.getGraph().getDecorators()) {
					 if(!d.equals(this) &&  
							 d instanceof PopulationModel && 
							 ((PopulationModel)d).getPopulationIdentifier().equals(this.getPopulationIdentifier()) &&
							 Utility.keyLevel(((PopulationModel)d).getTargetISOKey()) > Utility.keyLevel(this.getTargetISOKey()) &&
							 isContained(populationLabel.getNode(), (((PopulationModel)d).getTargetISOKey())))
					 {found = true;break;}
				}
				if(found) continue;
				
				final PopulationModelLabel pl = createPopulationLabel();
				pl.setPopulationLabel(populationLabel); // Remember the static population label
				pl.setPopulationIdentifier(populationLabel.getPopulationIdentifier());
				getLabelsToUpdate().add(pl);
				populationLabel.getNode().getLabels().add(pl);
				pl.setNode(populationLabel.getNode());
				getGraph().putNodeLabel(pl);
			}
		} // for each population label

		
		resetLabels();
		return true;
	} // decorateGraph
	
	/**
	 * Search through the graph and find all of the population labels that have
	 * the same identifier.
	 * 
	 * @param populationIdentifier
	 *            the population being labeled
	 * @param graph
	 *            the graph to search
	 * @return the PopulationLabel instances of the graph that match the
	 *         identifier.
	 */
	protected Collection<PopulationLabel> getPopulationLabels(
			final String populationIdentifier, final Graph graph) {
		final List<PopulationLabel> retValue = new ArrayList<PopulationLabel>();

		// Iterate through all of the population labels in the graph
		EList<NodeLabel> labels = graph.getNodeLabelsByTypeURI(
				PopulationLabel.URI_TYPE_POPULATION_LABEL);
		for (NodeLabel pl:labels) {
			if(getTargetISOKey() != null && !getTargetISOKey().trim().equals("") && pl.getNode() != null && 
					!isContained(pl.getNode(), getTargetISOKey()) &&
					!pl.getNode().getURI().lastSegment().equals("ZZZ"))
				continue;
			
			final PopulationLabel populationLabel = (PopulationLabel) pl;
			// Is this label for the population we're looking for?
			if (populationLabel.getPopulationIdentifier().equals(
					populationIdentifier)) {
				// Yes
				// If there is a problem with the "node uri" of the population
				// label then it would not have been associated with a node
				// instance in the graph at this point. This is a problem for
				// disease models that are trying to label the node (there isn't
				// one!). So filter out those mistakes here.

				// Does the population label have an associated node?
				if (populationLabel.getNode() != null) {
					// Yes
					retValue.add(populationLabel);
				} // if the population label has a node
			} // if the population we're looking for
		} // for each population label

		return retValue;
	} // getPopulationLabels
	
	protected boolean isContained(Node node, String targetISOKey) {
		if(node.getURI().lastSegment().equals(targetISOKey)) 
			return true;
		// Check parents
		EList<Edge>edges = node.getEdges();
		
		for(Edge e:edges) {
			if(e.getLabel() instanceof RelativePhysicalRelationshipLabel ||
					e.getLabel() instanceof PipeTransportEdgeLabel) 
				if(e.getA().equals(node)) continue;
				else if(Utility.keyLevel(e.getA().getURI().lastSegment()) 
						> Utility.keyLevel(node.getURI().lastSegment())) continue; // skip air transport edges that goes "down"
				else return isContained(e.getA(), targetISOKey);
		}
		
		return false;
	}

	/**
	 * Search through the graph and find all of the population model labels (i.e. dynamic ones, not static) that have
	 * the same identifier.
	 * 
	 * @param populationIdentifier
	 *            the population being labeled
	 * @param graph
	 *            the graph to search
	 * @return the PopulationLabel instances of the graph that match the
	 *         identifier.
	 */
	protected Collection<PopulationModelLabel> getPopulationModelLabels(
			final String populationIdentifier, final Graph graph) {
		final List<PopulationModelLabel> retValue = new ArrayList<PopulationModelLabel>();

		// Iterate through all of the population labels in the graph
		EList<NodeLabel> labels = graph.getNodeLabelsByTypeURI(
				PopulationModelLabel.URI_TYPE_DYNAMIC_POPULATION_LABEL);
		for (NodeLabel pl:labels) {
			final PopulationModelLabel populationModelLabel = (PopulationModelLabel) pl;
			// Is this label for the population we're looking for?
			if (populationModelLabel.getPopulationIdentifier().equals(
					populationIdentifier)) {
			 	if (populationModelLabel.getNode() != null) {
					// Yes
					retValue.add(populationModelLabel);
				} // if the population label has a node
			} // if the population we're looking for
		} // for each population label

		return retValue;
	} // getPopulationLabels
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract PopulationModelLabel createPopulationLabel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract PopulationModelLabelValue createPopulationLabelValue();
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.POPULATION_MODEL__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
			case StandardPackage.POPULATION_MODEL__NAME:
				return getName();
			case StandardPackage.POPULATION_MODEL__TARGET_ISO_KEY:
				return getTargetISOKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardPackage.POPULATION_MODEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
				return;
			case StandardPackage.POPULATION_MODEL__NAME:
				setName((String)newValue);
				return;
			case StandardPackage.POPULATION_MODEL__TARGET_ISO_KEY:
				setTargetISOKey((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardPackage.POPULATION_MODEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
				return;
			case StandardPackage.POPULATION_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StandardPackage.POPULATION_MODEL__TARGET_ISO_KEY:
				setTargetISOKey(TARGET_ISO_KEY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.POPULATION_MODEL__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? populationIdentifier != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(populationIdentifier);
			case StandardPackage.POPULATION_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StandardPackage.POPULATION_MODEL__TARGET_ISO_KEY:
				return TARGET_ISO_KEY_EDEFAULT == null ? targetISOKey != null : !TARGET_ISO_KEY_EDEFAULT.equals(targetISOKey);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (populationIdentifier: ");
		result.append(populationIdentifier);
		result.append(", name: ");
		result.append(name);
		result.append(", targetISOKey: ");
		result.append(targetISOKey);
		result.append(')');
		return result.toString();
	}

} //PopulationModelImpl

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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue;
import org.eclipse.stem.definitions.nodes.impl.RegionImpl;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.PopulationModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Infector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#getDiseaseModel <em>Disease Model</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#getTargetURI <em>Target URI</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#getDiseaseName <em>Disease Name</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#getTargetISOKey <em>Target ISO Key</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#getLabelsToInfect <em>Labels To Infect</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.InfectorImpl#isInfectPercentage <em>Infect Percentage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InfectorImpl extends NodeDecoratorImpl implements
		Infector {
	/**
	 * The default value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI TARGET_URI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDiseaseName() <em>Disease Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDiseaseName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISEASE_NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTargetISOKey() <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetISOKey()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ISO_KEY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isInfectPercentage() <em>Infect Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInfectPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INFECT_PERCENTAGE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected InfectorImpl() {
		super();
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public boolean decorateGraph(STEMTime time) {
		if(this.isGraphDecorated()) return true;
		Graph graph = getGraph();
		if(graph == null && this.eContainer() instanceof InfectorInoculatorCollection) // Might be part of a collection
			graph = ((NodeDecorator)eContainer()).getGraph();
		
		// Do we need to look up the disease model from its name?
		if (getDiseaseModel() == null) {
			// Yes
			// There's a disease model out there with our name on it
			// (maybe)...let's find it
			for (Iterator<Decorator> decoratorIter = graph.getDecorators().iterator(); decoratorIter
					.hasNext();) {
				final Decorator decorator = decoratorIter.next();
				// Disease Model?
				if (decorator instanceof StandardDiseaseModel) {
					final StandardDiseaseModel diseaseModel = (StandardDiseaseModel) decorator;
					// Is this the one we're looking for?
					if (diseaseModel.getDiseaseName().equalsIgnoreCase(
							getDiseaseName())) {
						// Yes
						this.setDiseaseModel(diseaseModel);
						break;
					}
				}
			} // for each decorator
		} // if look up disease model

		// Did we find the disease model we're suppose to work for?
		if (getDiseaseModel() != null) {
			// Yes
			// Now try to find the node to be infected
			final Node parent = graph.getNode(getTargetURI());
			
			Set<Node> allNodes = null;
			
			if(this.isInfectPercentage()) {
				allNodes = getAllChildren(parent);	
				allNodes.add(parent);
			} else {
				allNodes = new HashSet<Node>();
				allNodes.add(parent);
			}			

			Iterator<Node> iter = allNodes.iterator();
			while(iter!=null && iter.hasNext()) {
					Node node = iter.next();
			
					// Did we find the Node?
					if (node != null) {
						// Yes
						for (final Iterator<NodeLabel> labelIter = node.getLabels().iterator(); labelIter
								.hasNext();) {
							final NodeLabel nodeLabel = labelIter.next();
							// Is this a disease label?
							if (nodeLabel instanceof DiseaseModelLabel) {
								final DiseaseModelLabel diseaseModelLabel = (DiseaseModelLabel) nodeLabel;
								// Yes
								// Is it updated by this disease model?
								if (diseaseModelLabel.getDecorator() == getDiseaseModel() && diseaseModelLabel.getPopulationModelLabel().getPopulationIdentifier().equals(this.getPopulationIdentifier())) {
									// Yes
									doInitialization(diseaseModelLabel);
									getLabelsToInfect().add(diseaseModelLabel);
									break;
								} // if
							}
						} // for
					} // if node to infect was found
				else {
					// No
					// The target URI was probably bad
					Activator.logError("The node to infect specified by the URI \""
							+ getTargetURI()
							+ "\" was not found.  The URI is likely incorrect.",
							null);
				} // else node not found
			} // for each node
		} // if disease model found
		else {
			// No
			// The disease name was probably wrong
			Activator.logError("The disease named \"" + getDiseaseName()
					+ "\" was not found.", null);
		} // else node not found

		this.setProgress(1.0); // we're done
		return true;
	} // decorateGraph

	/**
	 * this method confirms that specific URIs defined in an infector are actually 
	 * valid URIs within the graph. Issue a warning on startup if they are not.
	 */
	protected void checkInfectorURIs() {
		
		URI target = getTargetURI();
		
		if(target!=null) {
			Graph g = this.getGraph();
			EMap<URI,Node> nodeMap = g.getNodes();
			if(!nodeMap.keySet().contains(target)) {
				Utility.displayScenarioCompositionWarning(Utility.URI_WARNING);
			}
		}
	}// validate infectors
	
	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#resetLabels(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public void resetLabels() {
		for (final Iterator<DiseaseModelLabel> nodeIter = getLabelsToInfect().iterator(); nodeIter
				.hasNext();) {
			final DiseaseModelLabel diseaseModelLabel = nodeIter.next();
			doInitialization(diseaseModelLabel);
		} // for
	} // resetLabels

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(org.eclipse.stem.core.graph.Graph,
	 *      org.eclipse.stem.core.model.STEMTime, long)
	 */
	@Override
	public void updateLabels(STEMTime time, long timerPeriod, int cycle) {
		// Do nothing
	} // updateLabels

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.INFECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardDiseaseModel getDiseaseModel() {
		return (StandardDiseaseModel)eDynamicGet(StandardPackage.INFECTOR__DISEASE_MODEL, StandardPackage.Literals.INFECTOR__DISEASE_MODEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardDiseaseModel basicGetDiseaseModel() {
		return (StandardDiseaseModel)eDynamicGet(StandardPackage.INFECTOR__DISEASE_MODEL, StandardPackage.Literals.INFECTOR__DISEASE_MODEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newDiseaseModel
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDiseaseModel(StandardDiseaseModel newDiseaseModel) {
		eDynamicSet(StandardPackage.INFECTOR__DISEASE_MODEL, StandardPackage.Literals.INFECTOR__DISEASE_MODEL, newDiseaseModel);
		setDiseaseName(newDiseaseModel != null? newDiseaseModel.getDiseaseName():null);
	} // setDiseaseModel

	
	/**
	 * finds all the child nodes of a parent (direct children and children of children etc...)
	 * and returns them in a set. 
	 * Child is defined by a containment relationship
	 * @param parent
	 */
	public Set<Node> getAllChildren(Node parent) {
		Set<Node> allChildren = new HashSet<Node>();
		Set<Node> toDoSet = getChildSet(parent);
		toDoSet.remove(parent);
		Set<Node> directChildren  = new HashSet<Node>();
		
		while(toDoSet.size() >=1) {
			directChildren.addAll(toDoSet);
			Iterator<Node> iter = directChildren.iterator();
			while(iter!=null && iter.hasNext()) {
				Node next = iter.next();
				allChildren.add(next);
				Set<Node> nextSet = getChildSet(next);
				nextSet.removeAll(allChildren);
				toDoSet.addAll(nextSet);
			}
			toDoSet.removeAll(directChildren);
			directChildren.clear();
		}
		return allChildren;
	}
	
	
	/**
	 * finds all the direct child nodes of a parent and returns them in a set.
	 * Child is defined by a containment relationship
	 * @param parent
	 */
	public Set<Node> getChildSet(Node parent) {
		Set<Node> children = new HashSet<Node>();
		if(parent == null) return children;
		String parentID = getTargetURI().lastSegment();
		//RelativePhysicalRelationshipLabelValue
		EList<Edge> allEdges = parent.getEdges();
		for (int i = 0; i < allEdges.size(); i ++) {
			Edge e = allEdges.get(i);
			LabelValue lv = e.getLabel().getCurrentValue();
			if(lv instanceof RelativePhysicalRelationshipLabelValue) {
				RelativePhysicalRelationshipLabelValue containment = (RelativePhysicalRelationshipLabelValue)lv;
				Node neighborNode = e.getOtherNode(parent);
				String neighborID= neighborNode.getURI().lastSegment();
				// is it really a child
				if(neighborID.length() > parentID.length()) {
					//yes
					children.add(neighborNode);
				}// is child
			}// is containment relationship
		}// for all edges
		//just to be sure
		children.remove(parent);
		return children;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URI getTargetURI() {
		URI targetURI = (URI)eDynamicGet(StandardPackage.INFECTOR__TARGET_URI, StandardPackage.Literals.INFECTOR__TARGET_URI, true, true);
		// Is it set?
		if (targetURI == null) {
			// No
			targetURI = RegionImpl.createRegionNodeURI(getTargetISOKey());
			setTargetURI(targetURI);
		}
		return targetURI;
	} // getTargetURI

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newTargetURI
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetURI(URI newTargetURI) {
		eDynamicSet(StandardPackage.INFECTOR__TARGET_URI, StandardPackage.Literals.INFECTOR__TARGET_URI, newTargetURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiseaseName() {
		return (String)eDynamicGet(StandardPackage.INFECTOR__DISEASE_NAME, StandardPackage.Literals.INFECTOR__DISEASE_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiseaseName(String newDiseaseName) {
		eDynamicSet(StandardPackage.INFECTOR__DISEASE_NAME, StandardPackage.Literals.INFECTOR__DISEASE_NAME, newDiseaseName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetISOKey() {
		return (String)eDynamicGet(StandardPackage.INFECTOR__TARGET_ISO_KEY, StandardPackage.Literals.INFECTOR__TARGET_ISO_KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetURI()
	 * @generated NOT
	 */
	public void setTargetISOKey(String newTargetISOKey) {
		eDynamicSet(StandardPackage.INFECTOR__TARGET_ISO_KEY, StandardPackage.Literals.INFECTOR__TARGET_ISO_KEY, newTargetISOKey);
		// This will cause the URI to be recreated with the new ISO key
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DiseaseModelLabel> getLabelsToInfect() {
		return (EList<DiseaseModelLabel>)eDynamicGet(StandardPackage.INFECTOR__LABELS_TO_INFECT, StandardPackage.Literals.INFECTOR__LABELS_TO_INFECT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return (String)eDynamicGet(StandardPackage.INFECTOR__POPULATION_IDENTIFIER, StandardPackage.Literals.INFECTOR__POPULATION_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		eDynamicSet(StandardPackage.INFECTOR__POPULATION_IDENTIFIER, StandardPackage.Literals.INFECTOR__POPULATION_IDENTIFIER, newPopulationIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInfectPercentage() {
		return (Boolean)eDynamicGet(StandardPackage.INFECTOR__INFECT_PERCENTAGE, StandardPackage.Literals.INFECTOR__INFECT_PERCENTAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfectPercentage(boolean newInfectPercentage) {
		eDynamicSet(StandardPackage.INFECTOR__INFECT_PERCENTAGE, StandardPackage.Literals.INFECTOR__INFECT_PERCENTAGE, newInfectPercentage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.INFECTOR__DISEASE_MODEL:
				if (resolve) return getDiseaseModel();
				return basicGetDiseaseModel();
			case StandardPackage.INFECTOR__TARGET_URI:
				return getTargetURI();
			case StandardPackage.INFECTOR__DISEASE_NAME:
				return getDiseaseName();
			case StandardPackage.INFECTOR__TARGET_ISO_KEY:
				return getTargetISOKey();
			case StandardPackage.INFECTOR__LABELS_TO_INFECT:
				return getLabelsToInfect();
			case StandardPackage.INFECTOR__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
			case StandardPackage.INFECTOR__INFECT_PERCENTAGE:
				return isInfectPercentage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param newValue
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardPackage.INFECTOR__DISEASE_MODEL:
				setDiseaseModel((StandardDiseaseModel)newValue);
				return;
			case StandardPackage.INFECTOR__TARGET_URI:
				setTargetURI((URI)newValue);
				return;
			case StandardPackage.INFECTOR__DISEASE_NAME:
				setDiseaseName((String)newValue);
				return;
			case StandardPackage.INFECTOR__TARGET_ISO_KEY:
				setTargetISOKey((String)newValue);
				return;
			case StandardPackage.INFECTOR__LABELS_TO_INFECT:
				getLabelsToInfect().clear();
				getLabelsToInfect().addAll((Collection<? extends DiseaseModelLabel>)newValue);
				return;
			case StandardPackage.INFECTOR__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
				return;
			case StandardPackage.INFECTOR__INFECT_PERCENTAGE:
				setInfectPercentage((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardPackage.INFECTOR__DISEASE_MODEL:
				setDiseaseModel((StandardDiseaseModel)null);
				return;
			case StandardPackage.INFECTOR__TARGET_URI:
				setTargetURI(TARGET_URI_EDEFAULT);
				return;
			case StandardPackage.INFECTOR__DISEASE_NAME:
				setDiseaseName(DISEASE_NAME_EDEFAULT);
				return;
			case StandardPackage.INFECTOR__TARGET_ISO_KEY:
				setTargetISOKey(TARGET_ISO_KEY_EDEFAULT);
				return;
			case StandardPackage.INFECTOR__LABELS_TO_INFECT:
				getLabelsToInfect().clear();
				return;
			case StandardPackage.INFECTOR__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
				return;
			case StandardPackage.INFECTOR__INFECT_PERCENTAGE:
				setInfectPercentage(INFECT_PERCENTAGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.INFECTOR__DISEASE_MODEL:
				return basicGetDiseaseModel() != null;
			case StandardPackage.INFECTOR__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? getTargetURI() != null : !TARGET_URI_EDEFAULT.equals(getTargetURI());
			case StandardPackage.INFECTOR__DISEASE_NAME:
				return DISEASE_NAME_EDEFAULT == null ? getDiseaseName() != null : !DISEASE_NAME_EDEFAULT.equals(getDiseaseName());
			case StandardPackage.INFECTOR__TARGET_ISO_KEY:
				return TARGET_ISO_KEY_EDEFAULT == null ? getTargetISOKey() != null : !TARGET_ISO_KEY_EDEFAULT.equals(getTargetISOKey());
			case StandardPackage.INFECTOR__LABELS_TO_INFECT:
				return !getLabelsToInfect().isEmpty();
			case StandardPackage.INFECTOR__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? getPopulationIdentifier() != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(getPopulationIdentifier());
			case StandardPackage.INFECTOR__INFECT_PERCENTAGE:
				return isInfectPercentage() != INFECT_PERCENTAGE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(" (populationIdentifier: "); //$NON-NLS-1$
		result.append(getPopulationIdentifier() != null ? getPopulationIdentifier() : "\"\"");
		result.append(", targetURI: "); //$NON-NLS-1$
		result.append(getTargetURI() != null ? getTargetURI() : "\"\"");
		result.append(", diseaseName: "); //$NON-NLS-1$
		result.append(getDiseaseName() != null ? getDiseaseName() : "\"\"");
		result.append(", targetISOKey: "); //$NON-NLS-1$
		result.append(getTargetISOKey() != null ? getTargetISOKey() : "\"\"");
		result.append(')');
		return result.toString();
	} // toString

	
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		checkInfectorURIs();// issues warning if infector uri is not in the graph
		retValue = retValue && !(getTargetISOKey() == null && getTargetURI() == null);
		assert retValue;
		
		return retValue;
	} // sane
	

	/**
	 * Initialize the disease model label value
	 * 
	 * @param diseaseModelLabel
	 *            the disease model label to be initialized
	 */
	protected abstract void doInitialization(
			final DiseaseModelLabel diseaseModelLabel);

} // InfectorImpl

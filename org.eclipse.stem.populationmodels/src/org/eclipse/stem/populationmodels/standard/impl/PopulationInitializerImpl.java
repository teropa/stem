package org.eclipse.stem.populationmodels.standard.impl;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.impl.PopulationLabelImpl;
import org.eclipse.stem.populationmodels.Activator;
import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl#getTargetISOKey <em>Target ISO Key</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.PopulationInitializerImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PopulationInitializerImpl extends NodeDecoratorImpl implements PopulationInitializer {
	/**
	 * The default value of the '{@link #getTargetISOKey() <em>Target ISO Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetISOKey()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ISO_KEY_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PopulationInitializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.POPULATION_INITIALIZER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY, oldTargetISOKey, targetISOKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.POPULATION_INITIALIZER__POPULATION_IDENTIFIER, oldPopulationIdentifier, populationIdentifier));
	}

	@Override
	public boolean decorateGraph(STEMTime time) {
		if(this.isGraphDecorated()) return true;
		checkPopulationModels();
		ArrayList<Node>nodes = new ArrayList<Node>();
		ArrayList<Node>negativeNodes = new ArrayList<Node>();
		
		this.getNodes(this.getGraph(), this.getTargetISOKey(), nodes, negativeNodes);
		
		if(nodes.size() == 0)
			Activator.logError("Error in population initializer "+this.getURI()+", unable to find node "+this.getTargetISOKey(), new Exception());
	
		for(Node n:nodes) {
			// Check for existing label
			PopulationLabel existingLabel = null;
			for(NodeLabel lab:n.getLabels()) {
				if(lab instanceof PopulationLabel 
						&& ((PopulationLabel)lab).getPopulationIdentifier().equals(this.getPopulationIdentifier())) {
					existingLabel = (PopulationLabel)lab;
				}
			}
			if(existingLabel != null) {				
					// Initialize with new value
					initializeLabel((PopulationLabel)existingLabel, time, false);
			} else {
				// Create a new label
				PopulationLabel newLabel = LabelsFactory.eINSTANCE.createPopulationLabel();
				newLabel.setPopulationIdentifier(this.getPopulationIdentifier());
				newLabel.setURIOfIdentifiableToBeLabeled(n.getURI());
				newLabel.setNode(n);
				Graph g = this.getGraph();
				URI newURI = createPopulationLabelURI(n, time);
				g.getNodeLabels().put(newURI, newLabel);
				initializeLabel((PopulationLabel)newLabel, time, false);				
			}
		}
		
		// Now do the rest of the nodes in the graph
		
		for(Node n:negativeNodes) {
			// Check for existing label
			PopulationLabel existingLabel = null;
			for(NodeLabel lab:n.getLabels()) {
				if(lab instanceof PopulationLabel 
						&& ((PopulationLabel)lab).getPopulationIdentifier().equals(this.getPopulationIdentifier())) {
					existingLabel = (PopulationLabel)lab;
				}
			}
			if(existingLabel == null) {
				// Create a new label. We don't override the existing label
				PopulationLabel newLabel = LabelsFactory.eINSTANCE.createPopulationLabel();
				newLabel.setPopulationIdentifier(this.getPopulationIdentifier());
				newLabel.setURIOfIdentifiableToBeLabeled(n.getURI());
				newLabel.setNode(n);
				Graph g = this.getGraph();
				URI newURI = createPopulationLabelURI(n, time);
				g.getNodeLabels().put(newURI, newLabel);
				initializeLabel((PopulationLabel)newLabel, time, true);				
			}
		}
		return true;
	}
	
	protected abstract void initializeLabel(PopulationLabel lab, STEMTime time, boolean zeroValue);
	
	protected void checkPopulationModels() {
		// Let's validate to make sure there is no population model
		// at the same or lower level that already's been invoked 
		// and that's using the same population. If so, we should bring
		// up a warning and possibly a help link
		
		for(Decorator d:this.getGraph().getDecorators()) {
			if (d instanceof PopulationModel && ((PopulationModel)d).getPopulationIdentifier().equals(this.getPopulationIdentifier())) {
				if(((PopulationModel)d).isGraphDecorated())
					Utility.displayScenarioCompositionWarning(Utility.NESTING_WARNING);
			}
		}	
	}
	
	protected int getYear(STEMTime time) {
		Calendar cal = Calendar.getInstance();
		if(time != null)
			cal.setTime(time.getTime());
		else cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	
	
	protected void getNodes(Graph g, String key, ArrayList<Node>list, ArrayList<Node>negList) {

		// First find other population initializers in the graph that has the same
		// population identifier but a lower level key. Any node in the substree 
		// of that lower level key should not be touched.
		
		ArrayList<StandardPopulationInitializer>lowerLevelInitializers = new ArrayList<StandardPopulationInitializer>();
		
		for(Decorator d:g.getDecorators()) {
			if(d instanceof StandardPopulationInitializer &&
					((StandardPopulationInitializer)d).getPopulationIdentifier().equals(this.getPopulationIdentifier()) &&
					Utility.keyLevel(((StandardPopulationInitializer)d).getTargetISOKey()) > Utility.keyLevel(this.getTargetISOKey()))
				lowerLevelInitializers.add((StandardPopulationInitializer)d);
		}
		
		for(Node n:g.getNodes().values()) {
			boolean foundSubInitializer = false;
			for(StandardPopulationInitializer spi:lowerLevelInitializers) 
				if(isSelfOrHasParent(n, spi.getTargetISOKey())) 
					{foundSubInitializer = true;break;}
			if(foundSubInitializer) continue;
			
			if((key == null || key.trim().equals("")) && isLeaf(n)) list.add(n);
			else if(n.getURI().lastSegment().equals(key) && isLeaf(n)) list.add(n);
			// Check if any of the parents is the key
			else if(hasParent(n, key) && isLeaf(n)) list.add(n);
			else if(isLeaf(n)) negList.add(n);
		}
	}
	
	public boolean isLeaf(Node n) {
		for(Edge e:n.getEdges())
			if(e.getLabel() instanceof RelativePhysicalRelationshipLabel &&
					e.getA().equals(n)) 
				return false;
		return true;
	}
	
	public boolean hasParent(Node n, String key) {
		for(Edge e:n.getEdges()) {
			// Make sure it's a physical containment edge
			boolean phys = e.getLabel() instanceof RelativePhysicalRelationshipLabel;
			if(!phys) 
				continue;
			if(e.getA().getURI().lastSegment().equals(key)) return true;
			else if(Utility.keyLevel(e.getA().getURI().lastSegment()) < Utility.keyLevel(n.getURI().lastSegment()))
				return hasParent(e.getA(), key);
		}
		return false;
	}
	
	public boolean isSelfOrHasParent(Node n, String key) {
		if(n.getURI().lastSegment().equals(key)) return true;
		return hasParent(n, key);
	}
	
	protected URI createPopulationLabelURI(Node n, STEMTime time) {
		int adminLevel = Utility.keyLevel(n.getURI().lastSegment());
		String countryCode = this.getCountryCode(n);
		String population = this.getPopulationIdentifier();
		int year = new Date().getYear()+1900;
		if(time != null) year = getYear(time);
		String code = n.getURI().lastSegment();
		
		return PopulationLabelImpl.createPopulationLabelURI(adminLevel, countryCode, population, year+"", code);
	}
	
	protected String getCountryCode(Node n) {
		if(Utility.keyLevel(n.getURI().lastSegment()) == 0) return n.getURI().lastSegment();
		else for(Edge e:n.getEdges()) 
			if(Utility.keyLevel(e.getA().getURI().lastSegment()) < Utility.keyLevel(n.getURI().lastSegment()))
			return getCountryCode(e.getA());
		
		return "ZZZ"; // Not found, but ZZZ is the parent of everything
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				return getTargetISOKey();
			case StandardPackage.POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
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
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				setTargetISOKey((String)newValue);
				return;
			case StandardPackage.POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
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
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				setTargetISOKey(TARGET_ISO_KEY_EDEFAULT);
				return;
			case StandardPackage.POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
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
			case StandardPackage.POPULATION_INITIALIZER__TARGET_ISO_KEY:
				return TARGET_ISO_KEY_EDEFAULT == null ? targetISOKey != null : !TARGET_ISO_KEY_EDEFAULT.equals(targetISOKey);
			case StandardPackage.POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? populationIdentifier != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(populationIdentifier);
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
		result.append(" (targetISOKey: ");
		result.append(targetISOKey);
		result.append(", populationIdentifier: ");
		result.append(populationIdentifier);
		result.append(')');
		return result.toString();
	}

} //PopulationInitializerImpl

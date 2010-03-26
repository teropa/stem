/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.LabelsFactory;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.populationmodels.Activator;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl#getIndividuals <em>Individuals</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl#isUseDensity <em>Use Density</em>}</li>
 *   <li>{@link org.eclipse.stem.populationmodels.standard.impl.StandardPopulationInitializerImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardPopulationInitializerImpl extends PopulationInitializerImpl implements StandardPopulationInitializer {
	/**
	 * The default value of the '{@link #getIndividuals() <em>Individuals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndividuals()
	 * @generated
	 * @ordered
	 */
	protected static final double INDIVIDUALS_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getIndividuals() <em>Individuals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndividuals()
	 * @generated
	 * @ordered
	 */
	protected double individuals = INDIVIDUALS_EDEFAULT;

	/**
	 * The default value of the '{@link #isUseDensity() <em>Use Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDensity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_DENSITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseDensity() <em>Use Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDensity()
	 * @generated
	 * @ordered
	 */
	protected boolean useDensity = USE_DENSITY_EDEFAULT;

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
	 * @generated NOT
	 */
	public StandardPopulationInitializerImpl() {
		super();
		// Populate the population labels
		
	}
	
	@Override 
	public void prepare(Model model) {
		super.prepare(model);
				
		ArrayList<Node>nodes = new ArrayList<Node>();
		ArrayList<NodeLabel>labels = new ArrayList<NodeLabel>();
		
		this.getNodes(model, this.getTargetISOKey(), nodes);
		this.getLabels(model, nodes, labels);
		
		for(Node n:nodes) {
			// Check for existing label
			PopulationLabel existingLabel = null;
			for(NodeLabel lab:labels) {
				if(lab instanceof PopulationLabel 
						&& ((PopulationLabel)lab).getPopulationIdentifier().equals(this.getPopulationIdentifier())) {
					existingLabel = (PopulationLabel)lab;
				}
			}
			if(existingLabel != null) {				
					// Initialize with new value
					initializeLabel((PopulationLabel)existingLabel);
			} else {
				// Create a new label
				PopulationLabel newLabel = LabelsFactory.eINSTANCE.createPopulationLabel();
				newLabel.setPopulationIdentifier(this.getPopulationIdentifier());
				newLabel.setURIOfIdentifiableToBeLabeled(n.getURI());
				Graph g = (Graph)((EObject)n.eContainer()).eContainer();
				g.getNodeLabels().put(n.getURI(), newLabel);
				initializeLabel((PopulationLabel)newLabel);				
			}
		}
	}
	
	
	protected void getNodes(Model m, String key, ArrayList<Node>list) {
		
		for(Model _m:m.getModels()) getNodes(_m, key, list);
		
		for(Graph g:m.getGraphs()) {
			for(URI uri:g.getNodes().keySet()) {
				if(uri.lastSegment().equals(key))
					list.add(g.getNodes().get(uri));
			}
		}
	}

	protected void getLabels(Model m, ArrayList<Node>nodes, ArrayList<NodeLabel>list) {
		
		for(Model _m:m.getModels()) getLabels(_m, nodes, list);
		
		for(Graph g:m.getGraphs()) {
			for(NodeLabel nl:g.getNodeLabels().values()) 
				for(Node n:nodes)
					if(nl.getURIOfIdentifiableToBeLabeled().equals(n.getURI())) 
							list.add(nl);
		}
	}

	protected void initializeLabel(PopulationLabel lab) {
		if(this.isUseDensity()) {
			Node n = lab.getNode();
			double area = 0.0;
			for(NodeLabel l:n.getLabels())
				if(l instanceof AreaLabel)
					area = ((AreaLabel)lab).getCurrentAreaValue().getArea();
			if(area == 0.0) {
				Activator.logInformation("Warning, unable to find area information for node "+n+" when initializing population "+this.getPopulationIdentifier()+", density not being used!", new Exception());
				 PopulationLabelValue plv = lab.getCurrentPopulationValue();
				 plv.setCount(this.getIndividuals());
			} else {
				 PopulationLabelValue plv = lab.getCurrentPopulationValue();
				 plv.setCount(this.getIndividuals()*area);
			}
		} else {
			 PopulationLabelValue plv = lab.getCurrentPopulationValue();
			 plv.setCount(this.getIndividuals());
		}
	}
	
	
	@Override
	public boolean decorateGraph() {
		// Nothing to do here, all work is done in prepare for initializers
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_POPULATION_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIndividuals() {
		return individuals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndividuals(double newIndividuals) {
		double oldIndividuals = individuals;
		individuals = newIndividuals;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS, oldIndividuals, individuals));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseDensity() {
		return useDensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseDensity(boolean newUseDensity) {
		boolean oldUseDensity = useDensity;
		useDensity = newUseDensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY, oldUseDensity, useDensity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER, oldPopulationIdentifier, populationIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				return getIndividuals();
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				return isUseDensity();
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
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
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				setIndividuals((Double)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				setUseDensity((Boolean)newValue);
				return;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
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
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				setIndividuals(INDIVIDUALS_EDEFAULT);
				return;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				setUseDensity(USE_DENSITY_EDEFAULT);
				return;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
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
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				return individuals != INDIVIDUALS_EDEFAULT;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				return useDensity != USE_DENSITY_EDEFAULT;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
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
		result.append(" (individuals: ");
		result.append(individuals);
		result.append(", useDensity: ");
		result.append(useDensity);
		result.append(", populationIdentifier: ");
		result.append(populationIdentifier);
		result.append(')');
		return result.toString();
	}

} //StandardPopulationInitializerImpl

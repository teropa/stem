package org.eclipse.stem.core.modifier.impl;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
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
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.graph.StaticLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.DecoratorImpl;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.Modifier;
import org.eclipse.stem.core.modifier.ModifierPackage;
import org.eclipse.stem.core.scenario.Scenario;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Modifier</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.ModifierImpl#getTargetURI <em>Target URI</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.ModifierImpl#getFeatureModifiers <em>Feature Modifiers</em>}</li>
 *   <li>{@link org.eclipse.stem.core.modifier.impl.ModifierImpl#isComplete <em>Complete</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModifierImpl extends DecoratorImpl implements Modifier {
	/**
	 * The default value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI TARGET_URI_EDEFAULT = null;

	// set to true when there's an error
	private boolean complete = false;


	/**
	 * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ModifierImpl() {
		super();
		setURI(STEMURI.createURI(URI_TYPE_MODIFIER_SEGMENT + "/"
				+  STEMURI.generateUniquePart()));
		setTypeURI(STEMURI.MODIFIER_TYPE_URI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifierPackage.Literals.MODIFIER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URI getTargetURI() {
		return (URI)eDynamicGet(ModifierPackage.MODIFIER__TARGET_URI, ModifierPackage.Literals.MODIFIER__TARGET_URI, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetURI(URI newTargetURI) {
		eDynamicSet(ModifierPackage.MODIFIER__TARGET_URI, ModifierPackage.Literals.MODIFIER__TARGET_URI, newTargetURI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FeatureModifier> getFeatureModifiers() {
		return (EList<FeatureModifier>)eDynamicGet(ModifierPackage.MODIFIER__FEATURE_MODIFIERS, ModifierPackage.Literals.MODIFIER__FEATURE_MODIFIERS, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isComplete() {

		if (complete) {
			// Yes
			return true;
		} // if

		boolean retValue = true;

		for (FeatureModifier featureModifier : getFeatureModifiers()) {
			retValue = featureModifier.isComplete();
			// Found one that's false?
			if (!retValue) {
				// Yes
				break;
			} // if
		} // for each FeatureModifier
		return retValue;
	} // isComplete

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reset() {
		for (FeatureModifier featureModifier : getFeatureModifiers()) {
			featureModifier.reset();
		} // for each FeatureModifier
	} // reset

	
	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#resetLabels()
	 */
	@Override
	public void resetLabels() {
		reset();
	}

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph()
	 */
	@Override
	public boolean decorateGraph(STEMTime time) {
		// Nothing
		return true;
	} // decorateGraph

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(org.eclipse.stem.core.model.STEMTime,
	 *      long)
	 *      
	 *  Only invoked by triggers
	 */
	@Override
	public void updateLabels(STEMTime time, long timerPeriod, int cycle) {
		modifyTarget(getTarget(getGraph()));
	} // updateLabels

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void updateScenario(final Scenario scenario) {
		modifyTarget(getTarget(scenario));
	} // updateScenario

	private EObject getTarget(final Scenario scenario) {
		EObject retValue = null;
		// Sequencer?
		if (scenario.getSequencer().getURI().equals(getTargetURI())) {
			// Yes
			retValue = scenario.getSequencer();
		} // if
		else {
			// No
			// Scenario Decorators?
			/* Commented out 6/10/09 since a modifier for infectors needs to modify the infector in the graph
			for (Decorator scenarioDecorator : scenario.getScenarioDecorators()) {
				// Our target?
				if (scenarioDecorator.getURI().equals(targetURI)) {
					// Yes
					retValue = scenarioDecorator;
					break;
				} // if
			} // for each Scenario Decorator
			*/
			// Did we find a Scenario decorator?
			if (retValue == null) {
				// No
				// We've done the easy stuff
				retValue = getTarget(scenario.getModel());
			} // if no Scenario Decorator

		} // else not a Scenario decorator
		return retValue;
	} // getIdentifiable

	private EObject getTarget(final Model model) {
		EObject retValue = null;
		for (Decorator decorator : model.getNodeDecorators()) {
			// Our target?
			if (decorator.getURI().equals(getTargetURI())) {
				// Yes
				retValue = decorator;
				break;
			} // if
			
		} // for each Decorator

		if(retValue == null)
			for(Model m:model.getModels()) {
				retValue = getTarget(m);
				if(retValue != null) break;
			}
		
		// A Node label?
		if (retValue == null) {
			for(Graph g:model.getGraphs()) {
				retValue = findNodeLabel(g);
				if(retValue != null) break;
			}
		} // if retValue == null

		// An Edge Label?
		if (retValue == null) {
			for(Graph g:model.getGraphs()) {
				retValue = findEdgeLabel(g);
				if(retValue != null) break;
			}
		} // if retValue == null
		return retValue;
	} 
	
	private EObject getTarget(final Graph graph) {
		EObject retValue = null;
		for (Decorator decorator : graph.getDecorators()) {
			// Our target?
			if (decorator.getURI().equals(getTargetURI())) {
				// Yes
				retValue = decorator;
				break;
			} // if
			
		} // for each Decorator

		// A Node label?
		if(retValue == null) retValue = findNodeLabel(graph);
		if(retValue == null) retValue = findEdgeLabel(graph);
		
		return retValue;
	} // getIdentifiable


	private EObject findNodeLabel(Graph g) {
		for (NodeLabel nodeLabel : g.getNodeLabels().values()) {
			// Our target?
			if (nodeLabel.getURI().equals(getTargetURI())) {
				// Yes
				return  nodeLabel;
			} // if
		} // for each Node Label
		return null;
		
	}
	
	private EObject findEdgeLabel(Graph g) {
		for (Edge edge : g.getEdges().values()) {
			// Our target?
			if (edge.getLabel().getURI().equals(getTargetURI())) {
				// Yes
				return edge.getLabel();
			} // if
		} // for each Edge
		return null;
	}
	
	private void modifyTarget(EObject target) {
		// Yes
		for (FeatureModifier featureModifier : getFeatureModifiers()) {
				
			// If the Identifiable is a static label, then the feature we
			// are modifying could be in the current label value. If it is
			// we need to adjust the target of the feature modifier.
			// Static label?
			if (target instanceof StaticLabel) {
				// Yes
				final StaticLabel sl = (StaticLabel)target;
				target = sl.getCurrentValue();
			}
			featureModifier.setTarget(target);
			featureModifier.updateFeature();
		} // for each FeatureModifier
	} // modifyIdentifiable

	/**
	 * Look inside the decorators for the target. This is to find string values and
	 * double values. 
	 * @param eobj
	 * @param target
	 * @return EObject the target if found, otherwise null
	 */
	public EObject deepFindChildren(EObject eobj, EObject target) {
		if(eobj.equals(target)) return eobj;
		for(EObject eo:eobj.eContents()) {
			deepFindChildren(eo, target);
		}
		return null;
	}
	/**
	 * @see org.eclipse.stem.core.modifier.Modifier#getModificationSummary()
	 */
	public List<String> getModificationSummary() {
		final List<String> retValue = new ArrayList<String>();
		for (FeatureModifier featureModifier : getFeatureModifiers()) {
			retValue.add(featureModifier.getModificationSummary());
		} // for each FeatureModifier
		return retValue;
	} // getModificationSummary

	/**
	 * @see org.eclipse.stem.core.common.impl.IdentifiableImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		assert retValue;

		/*
		 * This is commented out because of the difficulty of dynamically
		 * creating a test object that is derived from Identifable. So the test
		 * object doesn't have a URI. See MonitorTest#createTestPackage()
		 */
		// retValue = retValue && targetURI != null;
		// assert retValue;
		for (FeatureModifier featureModifier : getFeatureModifiers()) {
			retValue = retValue && featureModifier.sane();
			assert retValue;
		} // for each FeatureModifier
		return retValue;
	} // sane

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifierPackage.MODIFIER__FEATURE_MODIFIERS:
				return ((InternalEList<?>)getFeatureModifiers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifierPackage.MODIFIER__TARGET_URI:
				return getTargetURI();
			case ModifierPackage.MODIFIER__FEATURE_MODIFIERS:
				return getFeatureModifiers();
			case ModifierPackage.MODIFIER__COMPLETE:
				return isComplete();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifierPackage.MODIFIER__TARGET_URI:
				setTargetURI((URI)newValue);
				return;
			case ModifierPackage.MODIFIER__FEATURE_MODIFIERS:
				getFeatureModifiers().clear();
				getFeatureModifiers().addAll((Collection<? extends FeatureModifier>)newValue);
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
			case ModifierPackage.MODIFIER__TARGET_URI:
				setTargetURI(TARGET_URI_EDEFAULT);
				return;
			case ModifierPackage.MODIFIER__FEATURE_MODIFIERS:
				getFeatureModifiers().clear();
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
			case ModifierPackage.MODIFIER__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? getTargetURI() != null : !TARGET_URI_EDEFAULT.equals(getTargetURI());
			case ModifierPackage.MODIFIER__FEATURE_MODIFIERS:
				return !getFeatureModifiers().isEmpty();
			case ModifierPackage.MODIFIER__COMPLETE:
				return isComplete() != COMPLETE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // ModifierImpl

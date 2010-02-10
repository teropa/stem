package org.eclipse.stem.core.model.impl;

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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
//import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.stem.core.CorePlugin;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphPackage;

import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.STEMTime;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Decorator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.model.impl.DecoratorImpl#getLabelsToUpdate <em>Labels To Update</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.impl.DecoratorImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.impl.DecoratorImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.impl.DecoratorImpl#isGraphDecorated <em>Graph Decorated</em>}</li>
 *   <li>{@link org.eclipse.stem.core.model.impl.DecoratorImpl#getProgress <em>Progress</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DecoratorImpl extends IdentifiableImpl implements Decorator {
	/**
	 * The cached value of the '{@link #getLabelsToUpdate() <em>Labels To Update</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabelsToUpdate()
	 * @generated
	 * @ordered
	 */
	protected EList<DynamicLabel> labelsToUpdate;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;
	/**
	 * The default value of the '{@link #isGraphDecorated() <em>Graph Decorated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGraphDecorated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GRAPH_DECORATED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isGraphDecorated() <em>Graph Decorated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGraphDecorated()
	 * @generated
	 * @ordered
	 */
	protected boolean graphDecorated = GRAPH_DECORATED_EDEFAULT;

	
	/**
	 * The default value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected static final double PROGRESS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected double progress = PROGRESS_EDEFAULT;

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DecoratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.DECORATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DynamicLabel> getLabelsToUpdate() {
		if (labelsToUpdate == null) {
			labelsToUpdate = new EObjectWithInverseResolvingEList<DynamicLabel>(DynamicLabel.class, this, ModelPackage.DECORATOR__LABELS_TO_UPDATE, GraphPackage.DYNAMIC_LABEL__DECORATOR);
		}
		return labelsToUpdate;
	}

	protected Map<Integer, EList<DynamicLabel>> labelPartitionMap;
	protected int numThreads = -1;
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param partition Which partition
	 * @param max Max partition
	 * @generated not
	 */
	@SuppressWarnings("boxing")
	public synchronized EList<DynamicLabel>  getLabelsToUpdate(int partition, int max) {
		if (labelsToUpdate == null) {
			labelsToUpdate = new EObjectWithInverseResolvingEList<DynamicLabel>(DynamicLabel.class, this, ModelPackage.DECORATOR__LABELS_TO_UPDATE, GraphPackage.DYNAMIC_LABEL__DECORATOR);
		}
		if(max != numThreads) labelPartitionMap = null; // clear when the number of threads changes
		numThreads = max;
		if(labelPartitionMap != null && labelPartitionMap.containsKey(partition))
			return labelPartitionMap.get(partition);
		
		EList<DynamicLabel> temp = new BasicEList<DynamicLabel>(); 
			
		int size = labelsToUpdate.size();
		int labelsPerPartition = size / max;
		int start =  partition*labelsPerPartition;
		int end;
		if(partition == max -1) end = size; // The last threads grabs all nodes until the last one
		else end = start + labelsPerPartition;
		for(int i=start;i<end;++i) temp.add(labelsToUpdate.get(i));
		
		if(labelPartitionMap == null) labelPartitionMap = new HashMap<Integer, EList<DynamicLabel>>();
		labelPartitionMap.put(partition, temp);
		return temp;
	}
	
	/**
	 * 
	 * Prepare the decorator. A subclass needs to override this method if
	 * pre-processing steps are necessary before the decorator is being used
	 * 
	 * @generated NOT
	 */
	  
	public void prepare(Model model) {
		// Nothing to do
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != ModelPackage.DECORATOR__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, ModelPackage.DECORATOR__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != ModelPackage.DECORATOR__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__DECORATORS, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DECORATOR__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DECORATOR__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGraphDecorated() {
		return graphDecorated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphDecorated(boolean newGraphDecorated) {
		boolean oldGraphDecorated = graphDecorated;
		graphDecorated = newGraphDecorated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DECORATOR__GRAPH_DECORATED, oldGraphDecorated, graphDecorated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProgress() {
		return progress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgress(double newProgress) {
		double oldProgress = progress;
		progress = newProgress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.DECORATOR__PROGRESS, oldProgress, progress));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean decorateGraph() {
		CorePlugin.logError("decorateGraph() not implemented in \""+
				getDublinCore().getTitle()
				+ "\" of type \"" + this.getClass().getCanonicalName()
				+ "\"", null);
		throw new UnsupportedOperationException();
	} // decorateGraph

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void updateLabels(STEMTime time, long timerPeriod, int cycle) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void resetLabels() {
		setEnabled(ENABLED_EDEFAULT);
		setGraphDecorated(GRAPH_DECORATED_EDEFAULT);
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate()
				.iterator(); labelIter.hasNext();) {
			final DynamicLabel dynamicLabel = labelIter.next();
			dynamicLabel.reset();
		}
	} // resetLabels

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DECORATOR__LABELS_TO_UPDATE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabelsToUpdate()).basicAdd(otherEnd, msgs);
			case ModelPackage.DECORATOR__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.DECORATOR__LABELS_TO_UPDATE:
				return ((InternalEList<?>)getLabelsToUpdate()).basicRemove(otherEnd, msgs);
			case ModelPackage.DECORATOR__GRAPH:
				return basicSetGraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.DECORATOR__GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__DECORATORS, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.DECORATOR__LABELS_TO_UPDATE:
				return getLabelsToUpdate();
			case ModelPackage.DECORATOR__GRAPH:
				return getGraph();
			case ModelPackage.DECORATOR__ENABLED:
				return isEnabled();
			case ModelPackage.DECORATOR__GRAPH_DECORATED:
				return isGraphDecorated();
			case ModelPackage.DECORATOR__PROGRESS:
				return getProgress();
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
			case ModelPackage.DECORATOR__LABELS_TO_UPDATE:
				getLabelsToUpdate().clear();
				getLabelsToUpdate().addAll((Collection<? extends DynamicLabel>)newValue);
				return;
			case ModelPackage.DECORATOR__GRAPH:
				setGraph((Graph)newValue);
				return;
			case ModelPackage.DECORATOR__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ModelPackage.DECORATOR__GRAPH_DECORATED:
				setGraphDecorated((Boolean)newValue);
				return;
			case ModelPackage.DECORATOR__PROGRESS:
				setProgress((Double)newValue);
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
			case ModelPackage.DECORATOR__LABELS_TO_UPDATE:
				getLabelsToUpdate().clear();
				return;
			case ModelPackage.DECORATOR__GRAPH:
				setGraph((Graph)null);
				return;
			case ModelPackage.DECORATOR__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ModelPackage.DECORATOR__GRAPH_DECORATED:
				setGraphDecorated(GRAPH_DECORATED_EDEFAULT);
				return;
			case ModelPackage.DECORATOR__PROGRESS:
				setProgress(PROGRESS_EDEFAULT);
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
			case ModelPackage.DECORATOR__LABELS_TO_UPDATE:
				return labelsToUpdate != null && !labelsToUpdate.isEmpty();
			case ModelPackage.DECORATOR__GRAPH:
				return getGraph() != null;
			case ModelPackage.DECORATOR__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ModelPackage.DECORATOR__GRAPH_DECORATED:
				return graphDecorated != GRAPH_DECORATED_EDEFAULT;
			case ModelPackage.DECORATOR__PROGRESS:
				return progress != PROGRESS_EDEFAULT;
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
		result.append(" (enabled: "); //$NON-NLS-1$
		result.append(enabled);
		result.append(", graphDecorated: "); //$NON-NLS-1$
		result.append(graphDecorated);
		result.append(", progress: "); //$NON-NLS-1$
		result.append(progress);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see org.eclipse.stem.common.impl.IdentifiableImpl#sane()
	 * @generated NOT
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate().iterator(); labelIter
				.hasNext()
				&& retValue;) {
			final Label label = labelIter.next();

			retValue = retValue && label.sane();
			assert retValue;
		}

		return retValue;
	} // sane
} // DecoratorImpl

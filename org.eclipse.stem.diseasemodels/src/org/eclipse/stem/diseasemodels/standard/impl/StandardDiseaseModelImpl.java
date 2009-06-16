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
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import javax.xml.transform.SourceLocator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.impl.DESCipherImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.adapters.spatial.geo.preferences.PreferenceConstants;
import org.eclipse.stem.definitions.edges.MigrationEdgeLabel;
import org.eclipse.stem.definitions.edges.impl.MigrationEdgeLabelImpl;
import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.definitions.labels.TransportRelationshipLabel;
import org.eclipse.stem.definitions.labels.impl.TransportRelationshipLabelImpl;
import org.eclipse.stem.definitions.transport.PipeTransportEdge;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel;
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue;
import org.eclipse.stem.definitions.transport.TransportFactory;
import org.eclipse.stem.definitions.transport.impl.PipeStyleTransportSystemImpl;
import org.eclipse.stem.definitions.transport.util.TransportAdapterFactory;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
//import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.SEIRLabel;
import org.eclipse.stem.diseasemodels.standard.SEIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SIRLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelState;
//import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getTotalPopulationCount <em>Total Population Count</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getTotalPopulationCountReciprocal <em>Total Population Count Reciprocal</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getTotalArea <em>Total Area</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getReferencePopulationDensity <em>Reference Population Density</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StandardDiseaseModelImpl extends DiseaseModelImpl
		implements StandardDiseaseModel {
	/**
	 * The default value of the '{@link #getTotalPopulationCount() <em>Total Population Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCount()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_POPULATION_COUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalPopulationCount() <em>Total Population Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCount()
	 * @generated
	 * @ordered
	 */
	protected double totalPopulationCount = TOTAL_POPULATION_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalPopulationCountReciprocal() <em>Total Population Count Reciprocal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCountReciprocal()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalPopulationCountReciprocal() <em>Total Population Count Reciprocal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalPopulationCountReciprocal()
	 * @generated
	 * @ordered
	 */
	protected double totalPopulationCountReciprocal = TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalArea() <em>Total Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalArea()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_AREA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalArea() <em>Total Area</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalArea()
	 * @generated
	 * @ordered
	 */
	protected double totalArea = TOTAL_AREA_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferencePopulationDensity() <em>Reference Population Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencePopulationDensity()
	 * @generated
	 * @ordered
	 */
	protected static final double REFERENCE_POPULATION_DENSITY_EDEFAULT = 100.0;

	/**
	 * The cached value of the '{@link #getReferencePopulationDensity() <em>Reference Population Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencePopulationDensity()
	 * @generated
	 * @ordered
	 */
	protected double referencePopulationDensity = REFERENCE_POPULATION_DENSITY_EDEFAULT;

	
	protected Map<Integer, List<PipeTransportEdge>> pipeTransportationUpEdgesMap;
	protected Map<Integer, List<PipeTransportEdge>> pipeTransportationDownEdgesMap;
	protected Map<Node, List<PipeTransportEdge>> pipeTransportationNodeEdgesMap;
	
	/**
	 * We only need one of these.
	 * 
	 * @see #updateLabels(STEMTime, long)
	 */
	protected StandardDiseaseModelLabelValue departures = (StandardDiseaseModelLabelValue) createDiseaseModelLabelValue();

	private final static int MAX_PROGRESS_REPORTS = 5;
	
	private int num_threads = 2; // Will be changed to preference value below
	
	private SimJob [] jobs;
	
	// Used to synchronize worker threads to agree on step size (Runge Kutta only)
	private CyclicBarrier stepSizeBarrier;
	
	// Used to synchronize worker threads to proceed after all threads have completed
	// using the same step size.
	private CyclicBarrier stepDoneBarrier;
	
	// Used to synchronize worker threads to proceed after all threads have 
	// updated the current temporary value to the new position
	private CyclicBarrier updateDoneBarrier;
	
	// Smallest step size required by any thread to advance one step
	
	private double smallestH;
	private double maximumError;
	
	// These are constants used in Runge Kutta Cash Karp 
	
	static double a2=0.2, a3=0.3, a4=0.6, a5=1.0, a6=0.875;
	static double b21 = 0.2, b31=3.0/40, b32=9.0/40.0, b41=0.3, b42=-0.9, b43=1.2;
	static double b51=-11.0/54.0, b52=2.5, b53=-70.0/27.0, b54=35.0/27.0, b61=1631.0/55296.0, b62=175.0/512.0, b63=575.0/13824.0, b64=44275.0/110592.0, b65=253.0/4096.0;
	static double c1 = 37.0/378.0, c3=250.0/621.0, c4=125.0/594.0, c6=512.0/1771.0;
	static double dc5 = -277.0/14336.0;
	static double dc1 = c1-2825.0/27648.0, dc3=c3-18575.0/48384.0, dc4=c4-13525.0/55296.0, dc6=c6-0.25;
	
	static double SAFETY=0.9, PGROW=-0.2, PSHRNK=-0.25, ERRCON=1.89E-4;
	static double TINY = 1E-30;
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardDiseaseModelImpl() {
		super();
	}

	/**
	 * @param standardDiseaseModel
	 *            the StandardDiseaseModel disease model to be initialized
	 * @param diseaseModelName
	 * @param backgroundMortalityRate
	 * @param immunityLossRate
	 * @param incubationRate
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 * @param populationIdentifier
	 */
	protected static StandardDiseaseModel initializeStandardDiseaseModel(
			final StandardDiseaseModel standardDiseaseModel,
			final String diseaseModelName,
			final double backgroundMortalityRate, final long timePeriod,
			final String populationIdentifier) {
		DiseaseModelImpl.initializeDiseaseModel(standardDiseaseModel,
				diseaseModelName, backgroundMortalityRate, timePeriod,
				populationIdentifier);

		return standardDiseaseModel;
	} // initializeStandardDiseaseModel

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.STANDARD_DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalPopulationCount() {
		return totalPopulationCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalPopulationCount(double newTotalPopulationCount) {
		double oldTotalPopulationCount = totalPopulationCount;
		totalPopulationCount = newTotalPopulationCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT, oldTotalPopulationCount, totalPopulationCount));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalPopulationCountReciprocal() {
		return totalPopulationCountReciprocal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalArea() {
		return totalArea;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalArea(double newTotalArea) {
		double oldTotalArea = totalArea;
		totalArea = newTotalArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA, oldTotalArea, totalArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReferencePopulationDensity() {
		return referencePopulationDensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencePopulationDensity(double newReferencePopulationDensity) {
		double oldReferencePopulationDensity = referencePopulationDensity;
		referencePopulationDensity = newReferencePopulationDensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY, oldReferencePopulationDensity, referencePopulationDensity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addToTotalPopulationCount(double populationCount) {
		setTotalPopulationCount(totalPopulationCount + populationCount);
	} // addToTotalPopulationCount

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double computeTotalPopulationCountReciprocal() {
		return totalPopulationCountReciprocal = 1.0 / totalPopulationCount;
	} // computeTotalPopulationCountReciprocal

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addToTotalArea(double area) {
		setTotalArea(totalArea + area);
	} // addToTotalArea

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				return new Double(getTotalPopulationCount());
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL:
				return new Double(getTotalPopulationCountReciprocal());
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				return new Double(getTotalArea());
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				return new Double(getReferencePopulationDensity());
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
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				setTotalPopulationCount(((Double)newValue).doubleValue());
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				setTotalArea(((Double)newValue).doubleValue());
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				setReferencePopulationDensity(((Double)newValue).doubleValue());
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
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				setTotalPopulationCount(TOTAL_POPULATION_COUNT_EDEFAULT);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				setTotalArea(TOTAL_AREA_EDEFAULT);
				return;
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				setReferencePopulationDensity(REFERENCE_POPULATION_DENSITY_EDEFAULT);
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
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT:
				return totalPopulationCount != TOTAL_POPULATION_COUNT_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_POPULATION_COUNT_RECIPROCAL:
				return totalPopulationCountReciprocal != TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__TOTAL_AREA:
				return totalArea != TOTAL_AREA_EDEFAULT;
			case StandardPackage.STANDARD_DISEASE_MODEL__REFERENCE_POPULATION_DENSITY:
				return referencePopulationDensity != REFERENCE_POPULATION_DENSITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * 
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#updateLabels(org.eclipse.stem.core.graph.Graph,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	@Override
	public void updateLabels(final STEMTime time, final long timeDelta, int cycle) {
		
		// This is the very start of the process of updating the labels for a
		// simulation cycle. At this point we want to compute the reciprocal of
		// the total population (once) as we use this value for each label
		// update.
		// We also want to reset our count of the total population to zero so
		// we can start accumulating the value for the next cycle.
		
		computeTotalPopulationCountReciprocal();
		setTotalPopulationCount(0);
		
		final Preferences preferences = Activator.getDefault().getPluginPreferences();
		num_threads = preferences.getInt(org.eclipse.stem.diseasemodels.preferences.PreferenceConstants.SIMULATION_THREADS);
			
		final StandardDiseaseModel self = this;
		final int c = cycle;
		
		// Initialize latches
		stepSizeBarrier = new CyclicBarrier(num_threads, new Runnable() {
            public void run() { 
            	// All threads successfully advanced time by some step h.
				// Find the smallest 			
				smallestH = Double.MAX_VALUE;
				maximumError = -Double.MAX_VALUE;
				for(int i=0;i<num_threads;++i)  {
					if(jobs[i].h <= smallestH) {
						if(jobs[i].h == smallestH && maximumError < jobs[i].maxerror) maximumError = jobs[i].maxerror;
						else if(jobs[i].h != smallestH) maximumError = jobs[i].maxerror;
						smallestH = jobs[i].h; 
					}
				}
              }
            });
		
		stepDoneBarrier = new CyclicBarrier(num_threads);
		updateDoneBarrier = new CyclicBarrier(num_threads);
		
		// First initialize the Y and temp label values from the current
		// label values. Both algorithms require this initialization
		EList<DynamicLabel>allLabels = getLabelsToUpdate();

		for (final Iterator<DynamicLabel> currentStateLabelIter = allLabels
				.iterator(); currentStateLabelIter.hasNext();) {
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
			diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(diseaseLabel.getCurrentDiseaseModelLabelValue());
			diseaseLabel.getCurrentDiseaseModelTempLabelValue().set(diseaseLabel.getCurrentDiseaseModelLabelValue());
		}
		
		if(jobs == null || jobs.length != num_threads) {
			// Initialize the jobs if not done yet or of the number of threads changes
			jobs = new SimJob[num_threads];
	
			for(int i=0;i<num_threads;++i) {
				final int threadnum = i;
				jobs[i] = new SimJob("Worker "+i, this, threadnum);
			} // For each job
		} // If not initialized

		// Initialize
		int thread = 0;
		for(SimJob j:jobs) {
			j.cycle = c;
			j.time = time;
			j.timeDelta = timeDelta;
		}
		// Schedule. Jobs can be rescheduled after finished
		for(SimJob j:jobs) 
			j.schedule();
		
		// Wait until all jobs completed
		for(SimJob j : jobs) {
			try {
				j.join();
			} catch(InterruptedException ie) {
				Activator.logError(ie.getMessage(), ie);
			}
		}
		
		// Set the common time and step size here and validate everything is right
		double minStep = Double.MAX_VALUE;
		double currentT = jobs[0].t;
		for(SimJob j : jobs) {
			// The jobs have calculated new step sizes after they finished. Pick the
			// smallest one for the next cycle
			if(j.h < minStep) minStep = j.h;
			if(j.t != currentT) Activator.logError("Error, one thread was in misstep with other threads, its time was "+j.t+" versus "+currentT, new Exception());
		}
		
		this.setCurrentX(currentT);
		this.setStepSize(minStep); // smallest one from above.
	}
	
	/**
	 * Populate the pipe system nodes initially
	 */
	
	@SuppressWarnings("boxing")
	private void populatePipeSystemNodes() {
		Graph graph = this.getGraph();
		
		if(pipeTransportationUpEdgesMap == null || pipeTransportationDownEdgesMap == null) {
			initPipeTransport(graph);
		}
		Map<Integer, List<PipeTransportEdge>> map = pipeTransportationUpEdgesMap;
		
		Integer [] levels = new Integer[map.keySet().size()];
		levels = map.keySet().toArray(levels);
		Arrays.sort(levels, 0, levels.length, 
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						if(o1 < o2) return 1;
					else if(o1 > o2) return -1;
						return 0;
					}
		});
		
		
		for(int level : levels) {
			List<PipeTransportEdge> edges = map.get(level);
			
			for(PipeTransportEdge ptedge:edges) {
				// Move people from source to destination using the flow of the pipe
				Node source = ptedge.getA();
				Node dest = ptedge.getB();
				if(source == null || dest == null) continue; // ok, the region or transport system is not part of the model
				
				PipeTransportEdgeLabelValue label = (PipeTransportEdgeLabelValue) ptedge.getLabel().getCurrentValue();
				double maxflow = label.getMaxFlow();
				
				DiseaseModelLabelValue nextsrclabelval=null, nextdestlabelval=null, currsrclabelval=null, currdestlabelval=null;
				PopulationLabelValue srcpoplabval = null, destpoplabval = null;
				for(NodeLabel nlabel:source.getLabels()) {
					if(nlabel instanceof DiseaseModelLabel) {
						currsrclabelval = ((DiseaseModelLabel)nlabel).getCurrentDiseaseModelLabelValue();
						nextsrclabelval = ((DiseaseModelLabel)nlabel).getNextDiseaseModelLabelValue();
					} else if(nlabel instanceof PopulationLabel) {
						srcpoplabval = ((PopulationLabel)nlabel).getCurrentPopulationValue();
					}
				}
				
				for(NodeLabel nlabel:dest.getLabels()) {
					if(nlabel instanceof DiseaseModelLabel) {
						currdestlabelval = ((DiseaseModelLabel)nlabel).getCurrentDiseaseModelLabelValue();
						nextdestlabelval  =  ((DiseaseModelLabel)nlabel).getNextDiseaseModelLabelValue();
					} else if(nlabel instanceof PopulationLabel) {
						destpoplabval = ((PopulationLabel)nlabel).getCurrentPopulationValue();
					}
				}
				
				if(currsrclabelval == null || currdestlabelval == null) {
					continue; // possible for transport pipes connected to regions above the lowest region part of the model
				}
				
				// Check, make sure we don't move more people than available
				
				double flow = maxflow;	
				if(currsrclabelval.getPopulationCount() < flow) flow = currsrclabelval.getPopulationCount(); // check
				
				double factor = flow / currsrclabelval.getPopulationCount();
				if(Double.isNaN(factor)) factor = 0.0;
				
				DiseaseModelLabelValue move = null;
				
				move = (DiseaseModelLabelValue)EcoreUtil.copy(currsrclabelval);
				
				move.scale(factor);
				// Don't touch birth/deaths
				move.setBirths(0.0);
				move.setDeaths(0.0);
				move.setDiseaseDeaths(0.0);
		
				currdestlabelval.add(move);
				
				destpoplabval.setCount(currdestlabelval.getPopulationCount());
			}
		}
	}
	/**
	 * initialize pipe transport maps organizing pipes by direction (up/down)
	 * and level
	 * @param graph
	 */
	@SuppressWarnings("boxing")
	private void initPipeTransport(Graph graph) {
		pipeTransportationUpEdgesMap = new HashMap<Integer, List<PipeTransportEdge>>();
		pipeTransportationDownEdgesMap = new HashMap<Integer, List<PipeTransportEdge>>();
		pipeTransportationNodeEdgesMap = new HashMap<Node, List<PipeTransportEdge>>();
		// Traverse all pipe transport edges and determine what
		// geographic level their source (A) node is at
		for(URI edgeURI : graph.getEdges().keySet()) {
			Edge edge = graph.getEdges().get(edgeURI);
			
			if(edge instanceof PipeTransportEdge) {
				PipeTransportEdge pedge = (PipeTransportEdge)edge;
				int beginLevel = Utility.keyLevel(edge.getNodeAURI().lastSegment());
				int endLevel = Utility.keyLevel(edge.getNodeBURI().lastSegment());
				
				Map<Integer, List<PipeTransportEdge>> map;
				if(beginLevel > endLevel) map = pipeTransportationUpEdgesMap;
				else map = pipeTransportationDownEdgesMap;
				
				if(map.containsKey(beginLevel)) {
					map.get(beginLevel).add(pedge);
				} else {
					ArrayList<PipeTransportEdge> list = new ArrayList<PipeTransportEdge>();
					list.add(pedge);
					map.put(beginLevel, list);
				}
				
				Node a = edge.getA();
				Node b = edge.getB();
				
				if(a != null)
					if(pipeTransportationNodeEdgesMap.containsKey(a))
						pipeTransportationNodeEdgesMap.get(a).add(pedge);
					else {
						ArrayList<PipeTransportEdge> newList = new ArrayList<PipeTransportEdge>();
						newList.add(pedge);
						pipeTransportationNodeEdgesMap.put(a, newList);
					}	
				
				if(b != null)
					if(pipeTransportationNodeEdgesMap.containsKey(b))
						pipeTransportationNodeEdgesMap.get(b).add(pedge);
					else {
						ArrayList<PipeTransportEdge> newList = new ArrayList<PipeTransportEdge>();
						newList.add(pedge);
						pipeTransportationNodeEdgesMap.put(b, newList);
					}	
			}
		}
	}
	/**
	 * Update graph labels using the simplified finite difference method
	 *
	 *
	 */
	
	protected void updateLabelsFiniteDifference(final STEMTime time, final long timeDelta, int cycle, int threadnum) {
			
		EList<DynamicLabel>myLabels = getLabelsToUpdate(threadnum, num_threads);

//		this.setProgress(0.0);
		
		
		// Get the delta values at the current state
		calculateDelta(time, timeDelta, threadnum);
		
		int numLabels = myLabels.size();
		int setProgressEveryNthNode = num_threads * numLabels/(MAX_PROGRESS_REPORTS);
		if(setProgressEveryNthNode == 0) setProgressEveryNthNode = 1;
		int n=0;
		// Initialize the next value from the current value and add the delta
		for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
				.iterator(); currentStateLabelIter.hasNext();) {
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
			DiseaseModelLabelValue nextState = diseaseLabel.getNextDiseaseModelLabelValue();
			// Set to current value
			nextState.set(
					diseaseLabel.getCurrentDiseaseModelLabelValue());
			// Add the delta
			nextState.add(
					diseaseLabel.getDeltaValue());

			// Set the incidence
			nextState.setIncidence(diseaseLabel.getDeltaValue().getIncidence());
			
			// The next value is valid now.
			diseaseLabel.setNextValueValid(true);
			// Now add in the population so we can compute the reciprocal
			// next cycle.
			addToTotalPopulationCount(nextState.getPopulationCount());
		
			double progress = (double)n/(double)numLabels;
			jobs[threadnum].setProgress(progress);
			if(n%setProgressEveryNthNode==0) {
				// Get the progress for all threads
				for(int i=0;i<num_threads;++i) if(i!=threadnum && jobs[i] != null) progress+=jobs[i].getProgress();
				progress /= num_threads;
				this.setProgress(progress);
			}
			++n;
			
		}
		// Done
//		this.setProgress(1.0);
	}
	
	/**
	 * Update graph labels using Runge Kutta Fehlberg adaptive stepsize method
	 *
	 */
	@SuppressWarnings("cast")
	protected void updateLabelsRungeKutta(final STEMTime time, final long timeDelta, int cycle, int threadnum) {
	
//		this.setProgress(0.0);
				
		EList<DynamicLabel>myLabels = getLabelsToUpdate(threadnum, num_threads);
		
		// First we get the step size, either the default step size
		// (initially 1.0) or the last step size used
		
		double h = this.getStepSize();
		
		// x is to keep track of how far we have advanced in the solution. It is essentially
		// a double cycle representation
		
		double x = this.getCurrentX();
		
		// Substantial performance can be gained here. Basically if the current cycle
		// is greater than the cycle requested by the simulation, we are done. This
		// means that the error tolerance between last step and this step is small
		// enough so we don't need to update the labels. The error tolerance is
		// specified in the disease model
		
		//*** OBSERVE: Since we limit h to max 1 below, this code is never invoked. It's kept
		//*** around in case we want to allow time to be calculated far out in the future if
		//*** the error is small enough
		
		if(x >= cycle) {
			// Just copy the next value the same as the current value for all labels
			int numLabels = myLabels.size();
			double n = 0.0;
			int setProgressEveryNthNode = num_threads * numLabels/(MAX_PROGRESS_REPORTS);
			if(setProgressEveryNthNode == 0) setProgressEveryNthNode = 1;
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				// The estimated disease value contains the value calculated at position x
				
				StandardDiseaseModelLabelValue nextValueAtX = (StandardDiseaseModelLabelValue)EcoreUtil.copy(diseaseLabel.getCurrentYStandardDiseaseModelLabelValue());
				StandardDiseaseModelLabelValue currentValueAtCycle = diseaseLabel.getCurrentStandardDiseaseModelLabelValue();
				StandardDiseaseModelLabelValue nextState = diseaseLabel.getNextStandardDiseaseModelLabelValue();
				adjustValuesToCycle(currentValueAtCycle, nextValueAtX, x, cycle);
				// NextValueAtX has been modified here to the correct value for this cycle.
				nextState.set(nextValueAtX);
				// The next value is valid now.
				diseaseLabel.setNextValueValid(true);
				// Now add in the population so we can compute the reciprocal
				// next cycle.
				addToTotalPopulationCount(nextState.getPopulationCount());
				double progress = (double)n/(double)numLabels;
				jobs[threadnum].setProgress(progress);
				if(n%setProgressEveryNthNode==0) {
					// Get the progress for all threads
					for(int i=0;i<num_threads;++i) if(i!=threadnum && jobs[i] != null) progress+=jobs[i].getProgress();
					progress /= num_threads;
					this.setProgress(progress);
				}
				n+=1.0;
			}
			// So that validation code above is happy
			jobs[threadnum].h = h;
			jobs[threadnum].t = x;
			
			return;
		}

		// Make sure we actually have labels to update
		if(myLabels.size() == 0) {
			// Nothing to do, just advance x and set h
			jobs[threadnum].h = h;
			jobs[threadnum].t = x;
			// Be nice and walk in step with others until done
			while(x < cycle) {
				try {
					// Set to a large number to make sure it's larger than any step size reported
					// by another thread
					jobs[threadnum].h = Double.MAX_VALUE;
					stepSizeBarrier.await();
					stepDoneBarrier.await();
					updateDoneBarrier.await();
				} catch(InterruptedException ie) {
					// Should never happen
					Activator.logError(ie.getMessage(), ie);
				} catch(BrokenBarrierException bbe) {
					// Should never happen
					Activator.logError(bbe.getMessage(), bbe);
				}
				// Set to the smallest value reported by another thread
				h = this.smallestH;
				x += h;
				jobs[threadnum].h = h;
				jobs[threadnum].t = x;
			}				
			return; 
		}
		
		// We use the Runge Kutta Fehlberg method to advance to the next
		// step in the simulation. Two estimates of the disease deltas
		// are calculated and compared to each other. If they differ
		// by more than a maximum error (determined by a parameter for
		// the disease model), we reduce the step size until an acceptable
		// error is reached. 
					
		// These are used during Runge Kutta Fehlberg calculations:
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k1map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k2map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k3map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k4map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k5map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k6map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		
		// Used below as temporary place holders
		StandardDiseaseModelLabelValue _k1, _k2, _k3, _k4, _k5, _k6;
		
		// The final estimates for label values are stored here
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> finalEstimate = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		
		// Delta is used to scale the step (h)
		double delta = 0.0;	
				
		Iterator<DynamicLabel> iter = myLabels
				.iterator();
		StandardDiseaseModelLabel firstLabel = (StandardDiseaseModelLabel)iter.next();
		// Initialize temporary place holders just by creating dups of the first label available
		_k1 = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		_k2 = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		_k3 = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		_k4 = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		_k5 = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		_k6 = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		
		double end = Math.floor(this.getCurrentX())+1.0;
		
		// Keep track if whether anyone want the decorator to stop
		// or pause updating labels
		boolean interrupt=false, pause = false;
		
		// We keep these around to determine when to call setProgress(...) on the decorator.
		// If we call too frequently we can too many callbacks which affects performance.
		double nextProgressReportStep = num_threads*(end-x)/MAX_PROGRESS_REPORTS;
		double nextProgressReport = x+nextProgressReportStep;
		// boolean to check if we're redoing a step because another thread reported a smaller
		// step size
		boolean redo = false;
		
//		HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> validate = new 
//			HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>(); 
		
		// This is the main loop we keep iterating over until we are done
		while(x < end) {
			k1map.clear();
			k2map.clear();
			k3map.clear();
			k4map.clear();
			k5map.clear();
			k6map.clear();
			finalEstimate.clear();
			
			// Validation code kept here if needed in the future
/*			if(!redo) 	
				for (final Iterator<DynamicLabel> currentStateLabelIter = getLabelsToUpdate()
					.iterator(); currentStateLabelIter.hasNext();) {
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
					final StandardDiseaseModelLabelValue val = (StandardDiseaseModelLabelValue)diseaseLabel.getCurrentDiseaseModelTempLabelValue();
					validate.put(diseaseLabel, val);
				}
			else {
				for (final Iterator<DynamicLabel> currentStateLabelIter = getLabelsToUpdate()
						.iterator(); currentStateLabelIter.hasNext();) {
						final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
						.next();
						final SEIRLabelValue val = (SEIRLabelValue)diseaseLabel.getCurrentDiseaseModelTempLabelValue();
						validate.put(diseaseLabel, val);
						final SEIRLabelValue oldVal = (SEIRLabelValue)validate.get(diseaseLabel);
						
						if(val.getI() != oldVal.getI() ||
								val.getS() != oldVal.getS() ||
								val.getR() != oldVal.getR() ||
								val.getE() != oldVal.getE() ||
								val.getBirths() != oldVal.getBirths() ||
								val.getDeaths() != oldVal.getDeaths() ||
								val.getDiseaseDeaths() != oldVal.getDiseaseDeaths() 
								)
							Activator.logError("Error, old and new value not the same", new Exception());
				}
			}
			*/
			// ToDo: We should check if a maximum number of iterations have been
			// exceeded here and throw an error. 
			
			// First, get the delta values at the current state
			calculateDelta(time, timeDelta, threadnum);
			
			// Set the scaling factor for disease parameters for each location
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				DiseaseModelLabelValue scale = diseaseLabel.getYScale();
				scale.set(diseaseLabel.getCurrentDiseaseModelTempLabelValue());
				
				DiseaseModelLabelValue dt = (DiseaseModelLabelValue)EcoreUtil.copy(diseaseLabel.getDeltaValue());
				dt.scale(h);
				dt.abs();
				dt.add(TINY);
				scale.abs();
				scale.add(dt);
			}
			
			// Step 1 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a first estimate of the next value
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
				k1map.put(diseaseLabel, (StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
				
				deltaLabel.scale(h);
				deltaLabel.scale(b21);
				diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(
						deltaLabel.add(
						diseaseLabel.
						getCurrentDiseaseModelTempLabelValue()));
							
			}
				
			// Now get the next delta values
			calculateDelta(time, timeDelta, threadnum);
			
			// Step 2 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a second estimate of the next value
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
				k2map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
				_k1.set(k1map.get(diseaseLabel));
				_k2.set(deltaLabel);
				
				StandardDiseaseModelLabelValue estDelta = 
					(StandardDiseaseModelLabelValue)_k1.scale(b31);
				_k2.scale(b32);
				estDelta.add(_k2);
				
				estDelta.scale(h);
				
				diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
						diseaseLabel.
						getCurrentDiseaseModelTempLabelValue()));
			}
			
			// Now get the next delta values
			calculateDelta(time, timeDelta, threadnum);
			
			// Step 3 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a third estimate of the next value
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
				k3map.put(diseaseLabel, (StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
				
				_k1.set(k1map.get(diseaseLabel));
				_k2.set(k2map.get(diseaseLabel));
				_k3.set(deltaLabel);
				
				_k1.scale(b41);
				_k2.scale(b42);
				_k3.scale(b43);
				StandardDiseaseModelLabelValue estDelta = _k1;
				estDelta.add(_k2);
				estDelta.add(_k3);
				
				estDelta.scale(h);
				
				diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
						diseaseLabel.
						getCurrentDiseaseModelTempLabelValue()));
			}	
			
			// Now get the next delta values
			calculateDelta(time, timeDelta, threadnum);
			
			// Step 4 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a fourth estimate of the next value
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
				k4map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
				
				_k1.set(k1map.get(diseaseLabel));
				_k2.set(k2map.get(diseaseLabel));
				_k3.set(k3map.get(diseaseLabel));
				_k4.set(deltaLabel);
				
				_k1.scale(b51);
				_k2.scale(b52);
				_k3.scale(b53);
				_k4.scale(b54);
				
				StandardDiseaseModelLabelValue estDelta = _k1;
				estDelta.add(_k2);
				estDelta.add(_k3);
				estDelta.add(_k4);
				
				estDelta.scale(h);
				diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
						diseaseLabel.
						getCurrentDiseaseModelTempLabelValue()));
			}		
		
			// Now get the next delta values
			calculateDelta(time, timeDelta, threadnum);
			
			// Step 5 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a fifth estimate of the next value
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
				k5map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
				
				_k1.set(k1map.get(diseaseLabel));
				_k2.set(k2map.get(diseaseLabel));
				_k3.set(k3map.get(diseaseLabel));
				_k4.set(k4map.get(diseaseLabel));
				_k5.set(deltaLabel);
				
				_k1.scale(b61);
				_k2.scale(b62);
				_k3.scale(b63);
				_k4.scale(b64);
				_k5.scale(b65);
				
				StandardDiseaseModelLabelValue estDelta = _k1;
				estDelta.add(_k2);
				estDelta.add(_k3);
				estDelta.add(_k4);
				estDelta.add(_k5);
				
				estDelta.scale(h);
				
				diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
						diseaseLabel.
						getCurrentDiseaseModelTempLabelValue()));
			}		
			
			// Now get the next delta values
			calculateDelta(time, timeDelta, threadnum);
			
			// Step 6 in Runge Kutta Fehlberg. 
			// Calculate k6
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
				
				StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
				k6map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
			}			
			
			// Step 7 in Runge Kutta Fehlberg
			// Calculate the two estimates from k1, .. k6 values
			// and determine the maximum difference (error) between them.
			
			boolean success = true; // Were we able to update all labels without a large enough error?
			double maxerror = 0.0;
			for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
				.next();
		
				DiseaseModelLabelValue currentValue = diseaseLabel.getCurrentDiseaseModelTempLabelValue();
				
				_k1.set(k1map.get(diseaseLabel));
				_k3.set(k3map.get(diseaseLabel));
				_k4.set(k4map.get(diseaseLabel));
				_k5.set(k5map.get(diseaseLabel));
				_k6.set(k6map.get(diseaseLabel));	
				
				_k1.scale(c1);
				_k3.scale(c3);
				_k4.scale(c4);
				_k6.scale(c6);
				
				// New Y
				StandardDiseaseModelLabelValue yout = (StandardDiseaseModelLabelValue)
					EcoreUtil.copy(_k1.add(_k3).add(_k4).add(_k6));
				
				yout.scale(h);
				// Need to handle incidence separately since incidence is the delta
				double incidence = yout.getIncidence();
				yout.add(currentValue);
				yout.setIncidence(incidence);
							
				
				// Get the error
				_k1.set(k1map.get(diseaseLabel));
				_k3.set(k3map.get(diseaseLabel));
				_k4.set(k4map.get(diseaseLabel));
				_k5.set(k5map.get(diseaseLabel));
				_k6.set(k6map.get(diseaseLabel));	
				
				_k1.scale(dc1);
				_k3.scale(dc3);
				_k4.scale(dc4);
				_k5.scale(dc5);
				_k6.scale(dc6);
				
				StandardDiseaseModelLabelValue yerror = (StandardDiseaseModelLabelValue) EcoreUtil.copy(_k1.add(_k3).add(_k4).add(_k5).add(_k6));
				yerror.scale(h);
				
				double error = yerror.scaledmax(diseaseLabel.getYScale());
				error /= relativeTolerance;
				
				if(error > maxerror) {
					maxerror = error;
				}
				if(error > 1.0) { 
            		success = false;
				} else
					finalEstimate.put(diseaseLabel, 
						(StandardDiseaseModelLabelValue)EcoreUtil.copy(yout));
			}
			
			// Are we done?
			if(success) {
				// Even if we succeeded, another thread
				// might need a smaller step size. Wait for
				// all threads to complete this step and
				// redo if another threads step size was
				// smaller
				
				
				jobs[threadnum].h = h;
				jobs[threadnum].maxerror = maxerror;
				try {
					if(!redo)stepSizeBarrier.await();
				} catch(InterruptedException ie) {
					// Should never happen
					Activator.logError(ie.getMessage(), ie);
				} catch(BrokenBarrierException bbe) {
					// Should never happen
					Activator.logError(bbe.getMessage(), bbe);
				}
				
				// Check to make sure
				if(this.smallestH > h)
					Activator.logError("Error, h was less than the smallest, perhaps barrier process failed to execute? redo was "+redo+" h:"+h+" vs "+this.smallestH, new Exception());
				
				if(this.smallestH < h) {
					// Check if we got a smaller error than the previously reported smallest errors
					// after a redo. If so, log an error
					if(redo) Activator.logError("Error, the step size after redo was smaller than before: "+h+" vs "+this.smallestH, new Exception());
					// Another thread had a smaller step size, redo using that step size
					h = this.smallestH;
					// Reset the estimated value back to the original, the step size
					// has been reduced to the smallest of the other threads.
					// Set the estimated value back to the current original value
	        		for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
	        				.iterator(); currentStateLabelIter.hasNext();) {
	        			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
	        			diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(diseaseLabel.getCurrentDiseaseModelTempLabelValue());
	        		}
	        		redo = true;
				} else {
					// Wait until all other threads have completed using the common step size.
					try {
						stepDoneBarrier.await();
					} catch(InterruptedException ie) {
						// Should never happen
						Activator.logError(ie.getMessage(), ie);
					} catch(BrokenBarrierException bbe) {
						// Should never happen
						Activator.logError(bbe.getMessage(), bbe);
					}

					// Yes, hurrah, advance x using the step size h
					x+=h;
					if(maximumError > ERRCON)
						h = SAFETY*h*Math.pow(maximumError, PGROW);
					else
						h = 5.0*h;

					
					// Limit to max 1
					if(h > 1.0)  h = 1.0;
				
//System.out.println("Thread "+Thread.currentThread().getId()+" h="+h+" maxErr:"+maximumError);

					// Make sure we don't overshoot
					if(x < end && x+h > end) h = (end-x);
					
					

					// Update the current value to the new position
					for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
							.iterator(); currentStateLabelIter.hasNext();) {
						final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
						diseaseLabel.getCurrentDiseaseModelTempLabelValue().set(finalEstimate.get(diseaseLabel));
						diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(finalEstimate.get(diseaseLabel));
	    
					}
					
					// Wait until all other threads have updated the current value 
					try {
						updateDoneBarrier.await();
					} catch(InterruptedException ie) {
						// Should never happen
						Activator.logError(ie.getMessage(), ie);
					} catch(BrokenBarrierException bbe) {
						// Should never happen
						Activator.logError(bbe.getMessage(), bbe);
					}
					
					double progress = (end-x < 0.0)? 1.0:1.0-(end-x);
					jobs[threadnum].setProgress(progress);
					if(x > nextProgressReport) {
						// Get the progress for all threads
						for(int i=0;i<num_threads;++i) if(i!=threadnum && jobs[i] != null) progress+=jobs[i].getProgress();
						progress /= num_threads;
						this.setProgress(progress);
						nextProgressReport += nextProgressReportStep;
					}
					redo = false;
				}
				
			} else {
				
				// Change the step size
				if(redo)
					Activator.logError("Redo was true, but an attempt to reduce the step size was needed. The graph state is most likely not consistent" , new Exception());

				// Problem, error too big, we need to reduce the step size
				delta = SAFETY*h*Math.pow(maxerror,PSHRNK);
        		if(h > 0.0)
        			h = (delta > 0.1*h)? delta:0.1*h;
        		else
        			h = (delta > 0.1*h)? 0.1*h:delta;

				// We didn't succeed. 
 
				//Reset the estimated value back to the original, the step size
				// has been reduced so we well try again.
				// Set the estimated value back to the current original value
        		for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
        				.iterator(); currentStateLabelIter.hasNext();) {
        			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
        			diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(diseaseLabel.getCurrentDiseaseModelTempLabelValue());
        		}
			}
			
		} // While x < end
		
		jobs[threadnum].t = x;
		jobs[threadnum].h = h;
		
		// We're done
		for (final Iterator<DynamicLabel> currentStateLabelIter = myLabels
				.iterator(); currentStateLabelIter.hasNext();) {
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
			.next();
	
			// This is the next state for the label
			StandardDiseaseModelLabelValue nextState = diseaseLabel.getNextStandardDiseaseModelLabelValue();
			// This is the original current state at the previous cycle
			DiseaseModelLabelValue originalState = diseaseLabel.getCurrentDiseaseModelLabelValue();
			// This is the final value calculated at position x.
			StandardDiseaseModelLabelValue newValue =  finalEstimate.get(diseaseLabel);
			// x could be larger than the requested cycle, so we do a linear interpolation
			// to fit it exactly to the requested cycle
			adjustValuesToCycle(originalState, newValue, x, cycle);
			// New value has been modified here to fit the requested cycle
			nextState.set(newValue);
			// Set the incidence
			nextState.setIncidence(newValue.getIncidence());
			// The next value is valid now.
			diseaseLabel.setNextValueValid(true);
			// Now add in the population so we can compute the reciprocal
			// next cycle.
			addToTotalPopulationCount(nextState.getPopulationCount());
			
//			if(diseaseLabel.getNode().getURI().toString().contains("36081") ||
//					diseaseLabel.getNode().getURI().toString().contains("MX-MEX"))
//				System.out.println("Node: "+diseaseLabel.getNode().getURI().toString()+ "Infectious count: "+((SEIRLabelValue)newValue).getI()+" at iteration "+cycle);
			}
	}

	/**
	 * Adjust the returned label so that it matches the exact value at the requested cycle
	 * instead of the value at x. We do this by using the difference between x and the current
	 * cycle to adjust the label. nextValueAtX is modified by this function
	 * 
	 * @param currentValue The current value
	 * @param nextValueAtX The next value at position x
	 * @param x Current position
	 * @param cycle Current cycle
	 */
	void adjustValuesToCycle(DiseaseModelLabelValue currentValue, DiseaseModelLabelValue nextValueAtX, double x, int cycle) {
		StandardDiseaseModelLabelValue result = (StandardDiseaseModelLabelValue)EcoreUtil.copy(currentValue);
		nextValueAtX.sub(currentValue); // difference between new value and old now in nextValueAtX
		nextValueAtX.scale(1.0/(x-cycle+1));
		nextValueAtX.set(result.add(nextValueAtX));
	}
	
	/**
	 * calculateDelta will use the current label values updated by 
	 * the disease model and upon return the delta label values
	 * are set with an estimate of the derivatives to advance to the
	 * next step  
	 * 
	 * @param time Which time
	 * @param 
	 */
	protected void calculateDelta(final STEMTime time, final long timeDelta, int threadnum) {
		// Iterate through each of the labels we need to update.		
		// Place holders to keep delta values. 
		
		DiseaseModelLabelValue migrationDelta = this.createDiseaseModelLabelValue();
		DiseaseModelLabelValue pipeDelta = this.createDiseaseModelLabelValue();
		DiseaseModelLabelValue birthDeathsDelta = this.createDiseaseModelLabelValue();
		DiseaseModelLabelValue diseaseDelta = this.createDiseaseModelLabelValue();
	
		for (final Iterator<DynamicLabel> currentStateLabelIter = getLabelsToUpdate(threadnum, num_threads)
				.iterator(); currentStateLabelIter.hasNext();) {
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();

			assert diseaseLabel.getPopulationLabel().getPopulationIdentifier()
					.equals(getPopulationIdentifier());

			// This is the estimated state of the disease for this label
			final StandardDiseaseModelLabelValue currentState = diseaseLabel
					.getCurrentYStandardDiseaseModelLabelValue();

			// 0) Get the migration in this region 
			final StandardDiseaseModelLabelValue migrationDeltas = getMigrationDeltas(diseaseLabel,time, migrationDelta);
	
			// 1) Get the pipe transportation deltas
			final StandardDiseaseModelLabelValue pipeTransportDeltas = getPipeTransportationDeltas(diseaseLabel, time, timeDelta, pipeDelta);

			// 2) Compute Birth and Deaths state delta changes
			final StandardDiseaseModelLabelValue birthDeathDeltas = computeBirthsDeathsDeltas(time, currentState, timeDelta, birthDeathsDelta);

			StandardDiseaseModelLabelValue diseaseState = currentState;
				
			// 3) Compute the delta changes caused  by the Disease itself
			final StandardDiseaseModelLabelValue diseaseDeltas = computeDiseaseDeltas(time, diseaseState, diseaseLabel, timeDelta, diseaseDelta);
			
			 //  Just capture the incidence that was passed on from computeTransistions
			final double incidence = diseaseDeltas.getIncidence();
			
			// 4) do any model specific adjustments to the additions and the
			// deaths. For instance, stochastic computations to modify state
			// values.
			//doModelSpecificAdjustments(currentState, diseaseDeltas,
			//		birthDeathDeltas);

			/*
			 * 5) Record the new state variable values.
			 * 
			 * These will become the current state variable values at the end of
			 * the current simulation cycle and before the next.
			 */

			// This is the delta disease label
			final StandardDiseaseModelLabelValue deltaState = diseaseLabel
					.getDeltaStandardDiseaseModelLabelValue();

			// Initialize the next state from the current state and then we'll
			// make the changes to that.
			//deltaState.set(currentState);
			
			// We need to add in the births and deaths on so they'll be counted
			// as well...

			//diseaseDeltas.setBirths(numberBornSusceptible);
			//diseaseDeltas.setDeaths(stateDeaths.getDeaths());
			//diseaseDeltas.setDiseaseDeaths(stateDeaths.getDiseaseDeaths());

			// Now apply the migration/death/disease/birth deltas one at a time
			
			// Reset the state
			deltaState.reset();
			
			// 1) Migration deltas
			deltaState.add(migrationDeltas);

			// 2) Pipe transport deltas
			deltaState.add(pipeTransportDeltas);
			
			// 3) Add birth/death deltas
			deltaState.add(birthDeathDeltas);
			
			// 4) Disease deltas
			deltaState.add(diseaseDeltas);
		
			// and pass on the incidence
			deltaState.setIncidence(incidence);
			
			// For the finite difference method, check and make sure we're not 
			// moving too many people away from a given state (going negative).
			// If so, adjust the delta value
			
			if(this.isFiniteDifference()) 
				deltaState.adjustDelta(currentState);
		
			// We're going to use the this state below to do subtractions from
			// the contributing states, so we don't want to process the births
			// and deaths again.
			//diseaseDeltas.setBirths(0);
			//diseaseDeltas.setDeaths(0);
			//diseaseDeltas.setDiseaseDeaths(0);

			// We've accounted for the total deaths above so don't include the
			// total again. We still need to subtract the individual state
			// deaths though.
			//stateDeaths.setDeaths(0);
			//stateDeaths.setDiseaseDeaths(0);

			// Apply the reductions
			//nextState.sub(stateDeaths);
			
			//assert deltaState.sane():"disease state is insane after subtracting deaths: "+nextState.toString();
			
			// Now we rotate the additions left which moves S->I->S, S->R->I->S,
			// or S->R->I->E->S, depending upon the disease model. This gives us
			// the number of population members to remove from their originating
			// states.

			// This might be a bug. If everyone in a particular stated died and
			// there were computed transitions these would be subtracted from
			// zero giving negative population values.
			// See bug 186255
			//nextState.sub(diseaseDeltas.convertToSourceStates());
			
			//assert deltaState.sane():"disease state is insane after subtracting transitions: "+nextState.toString();
			 
			// Finally add in the new population members (who were not involved
			// in any of the transitions so we've left them out of the
			// computations until now)
			//nextState.setS((nextState.getS() + numberBornSusceptible));

			// See you later.

		} // for

	} // updateLabels

	/**
	 * Compute the number of new population members that are born. We assume
	 * that the birth rate is the same as the base mortality rate. This assumes
	 * that the population was relatively stable before the disease. The number
	 * of births could be less than the number of deaths however when the
	 * infectious mortality rate is included when computing the number of
	 * deaths.
	 * 
	 * @deprecated
	 * @param currentLabel
	 *            the current disease model label
	 * @param timeDelta
	 *            the time period (milliseconds) over which the population
	 *            members are born
	 * @return the number of new population members that are created during the
	 *         time delta that enter the <em>Susceptible</em> state.
	 */
	public StandardDiseaseModelLabelValue computeBirthsDelta(final StandardDiseaseModelLabel currentLabel,
			final long timeDelta) {
	//	return currentLabel.getCurrentStandardDiseaseModelLabelValue()
	//			.getPopulationCount()
	//			* getAdjustedBackgroundMortalityRate(timeDelta);
		return null;
	} // computeBirths

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#initializeDiseaseState(org.eclipse.stem.diseasemodels.standard.DiseaseModelState,
	 *      org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel)
	 */
	@Override
	public DiseaseModelState initializeDiseaseState(
			final DiseaseModelState diseaseModelState,
			final DiseaseModelLabel diseaseModelLabel) {

		final PopulationLabel populationLabel = diseaseModelLabel
				.getPopulationLabel();
		final double populationCount = populationLabel
				.getCurrentPopulationValue().getCount();

		// Accumulate the population count in the disease model
		addToTotalPopulationCount(populationCount);

		double area = getArea(populationLabel);
		// If we have a bad data set it could be that the area would be
		// unspecified or zero.
		// Do we have a bad area value?
		if (area <= 0.0) {
			// Yes
			reportBadAreaValue(populationLabel, area);
			area = 1.0;
		} // if bad area value

		// Accumulate the area in the disease model so we'll know the total when
		// we do our next pass and compute the area ratio
		addToTotalArea(area);
	
		return diseaseModelState;
	} // initializeDiseaseState

	/**
	 * Here we compute and set the ratio between the total area and the area
	 * used for this {@link DiseaseModelLabel}. This value is used to determine
	 * the <em>transmission scale factor</em>.
	 * 
	 * @see #computeTransitions(StandardDiseaseModelLabelValue,
	 *      StandardDiseaseModelLabel, long)
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#initializeDiseaseState(org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel)
	 */
	@Override
	public void initializeDiseaseState(final DiseaseModelLabel diseaseModelLabel) {
		final StandardDiseaseModelState sdms = (StandardDiseaseModelState) diseaseModelLabel
				.getDiseaseModelState();
		// Is there a population ?
		if (totalPopulationCount > 0.0) {
			// Yes
			double area = getArea(diseaseModelLabel.getPopulationLabel());
			// Do we have a bad area value?
			if (area <= 0.0) {
				// Yes
				reportBadAreaValue(diseaseModelLabel.getPopulationLabel(), area);
				area = 1.0;
			} // if bad area value

			final double ratio = getTotalArea() / area;
			sdms.setAreaRatio(ratio);
		}
	} // initializeDiseaseState

	/**
	 * @param populationLabel
	 *            the population label that labels the node
	 * @return the area of the node associated with the label
	 */
	public double getArea(final PopulationLabel populationLabel) {
		double retValue = 0.0;

		// The population label could have an area specified for the population
		// that we should use instead of the area of the region labeled by the
		// population label. This value would be specified if the population was
		// densely packed into a small area of the larger region, for instance
		// like a city in an otherwise large desert.

		retValue = populationLabel.getPopulatedArea();

		// Is there an area specified for the population?
		if (retValue == 0.0) {
			// No
			// Ok, go find the area label and return the area of the region
			for (final Iterator<NodeLabel> labelIter = populationLabel.getNode()
					.getLabels().iterator(); labelIter.hasNext();) {
				final NodeLabel nodeLabel = labelIter.next();
				// Is this an area label?
				if (nodeLabel instanceof AreaLabel) {
					// Yes
					final AreaLabel areaLabel = (AreaLabel) nodeLabel;
					retValue = areaLabel.getCurrentAreaValue().getArea();
					break;
				}
			} // for
		} // If no population area specified

		return retValue;
	} // getArea

	/**
	 * @param populationLabel
	 * @param area
	 */
	private void reportBadAreaValue(final PopulationLabel populationLabel,
			double area) {
		// The bad value could be specified for the node or be an override
		// value specified for the population.
		// Is the bad value from the node?
		if (populationLabel.getPopulatedArea() == 0.0) {
			// Yes
			Activator.logError("The area value of \"" + area
					+ "\" specified for \""
					+ populationLabel.getNode().toString()
					+ "\" is not greater than zero (0.0)", null);
		} // if bad value for node area
		else {
			Activator.logError("The area value of \"" + area
					+ "\" specified for the population \""
					+ populationLabel.getName() + "\" for the region \""
					+ populationLabel.getNode().toString()
					+ "\" is not greater than zero (0.0)", null);
		}
	} // reportBadAreaValue

	/**
	 * Perform disease model specific changes to the additions to each state and
	 * to the deaths from each state. This method is used to perform stochastic
	 * modifications to the next disease state.
	 * 
	 * @param currentState
	 *            the current disease state
	 * @param stateAdditions
	 *            the computed additions to each state
	 * @param stateDeaths
	 *            the computed deaths from each state
	 */
	protected void doModelSpecificAdjustments(
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabelValue stateAdditions,
			final StandardDiseaseModelLabelValue stateDeaths) {
		// Do nothing here. Sub-classes override this method to make changes
	} // doModelSpecificAdjustments

	/**
	 * computeDiseaseDeltas. This method calculates the delta changes for each disease state depending 
	 * on disease parameters and mixing factors
	 * 
	 * @param time 
	 * 		  	  STEM time
	 * @param currentState
	 *            the current state of the population
	 * @param diseaseLabel
	 *            the disease label for which the state transitions are being
	 *            computed.
	 * @param timeDelta
	 *            the time period (milliseconds) over which the population
	 *            members transition to new states
	 * @param cycle
	 * 			  the simulation cycle we're in
	 * @return a disease state label value that contains the delta changes in
	 * 		   population members for each state.
	 */
	
	public abstract StandardDiseaseModelLabelValue computeDiseaseDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabelValue currentState,
			final StandardDiseaseModelLabel diseaseLabel, 
			final long timeDelta, 
			DiseaseModelLabelValue returnValue);

	/**
	 * computeBirthsDeathsDeltas Return delta label value containing state birth/deaths
	 * 
	 * @param time 
	 * 			  STEM time
	 * @param currentLabelValue
	 *            the current label value of the disease model
	 * @param timeDelta
	 *            the time period over which the population members die
	 * @return the disease state label value that represents the number of
	 *         deaths in each state.
	 */
	
	public abstract StandardDiseaseModelLabelValue computeBirthsDeathsDeltas(
			final STEMTime time,
			final StandardDiseaseModelLabelValue currentLabelValue, 
			final long timeDelta, 
			DiseaseModelLabelValue returnValue);


	/**
	 * @param fractionToDepart
	 * @param nextState
	 * @return
	 */
	abstract protected StandardDiseaseModelLabelValue computeDepartures(
			double fractionToDepart, StandardDiseaseModelLabelValue nextState);

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getMigrationDeltas(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	protected abstract StandardDiseaseModelLabelValue getMigrationDeltas(
			final StandardDiseaseModelLabel diseaseLabel, final STEMTime time, DiseaseModelLabelValue returnValue) ;
	

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl#getPipeTransportationDeltas(org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel,
	 *      org.eclipse.stem.core.model.STEMTime)
	 */
	protected StandardDiseaseModelLabelValue getPipeTransportationDeltas(final StandardDiseaseModelLabel diseaseLabel, final STEMTime time, final long timeDelta, DiseaseModelLabelValue returnValue) {
		StandardDiseaseModelLabelValue delta = null;
		
		// Get the pipe transport edges to/from the node
		Node node = diseaseLabel.getNode();
		List<PipeTransportEdge>pedges = pipeTransportationNodeEdgesMap.get(node);
		if(pedges == null) return (StandardDiseaseModelLabelValue)createDiseaseModelLabelValue(); // no delta
		
		for(PipeTransportEdge pedge:pedges) {			
			boolean incomming = pedge.getB().equals(node);
			if(incomming) {
				for(NodeLabel lab: pedge.getA().getLabels()) {
					if(lab instanceof StandardDiseaseModelLabel && ((StandardDiseaseModelLabel)lab).getDecorator() == this) {
						// Make sure the target node has a disease model decorator
						boolean found = false;
						for(NodeLabel otherLab:pedge.getB().getLabels()) {
							if(otherLab instanceof StandardDiseaseModelLabel &&
									((StandardDiseaseModelLabel)otherLab).getDecorator().equals(((StandardDiseaseModelLabel)lab).getDecorator()))
									{found=true;break;}
						}
						if(!found) continue; // skip edge
						StandardDiseaseModelLabel otherLabel = (StandardDiseaseModelLabel)lab;
						StandardDiseaseModelLabelValue otherValue = (StandardDiseaseModelLabelValue)otherLabel.getCurrentDiseaseModelTempLabelValue();
						StandardDiseaseModelLabelValue change = (StandardDiseaseModelLabelValue)EcoreUtil.copy(otherValue);
						PipeTransportEdgeLabelValue edgeLabelValue =  (PipeTransportEdgeLabelValue)pedge.getLabel().getCurrentValue();
						double maxFlow = edgeLabelValue.getMaxFlow();
						double flow = maxFlow;
						double popCount = otherLabel.getCurrentDiseaseModelTempLabelValue().getPopulationCount();
						if(flow > popCount) flow = popCount; // don't move more people than available.
						long timePeriod = edgeLabelValue.getTimePeriod();
						double factor = flow / popCount;
						
						factor = factor * timeDelta / timePeriod;
						if(Double.isNaN(factor) || Double.isInfinite(factor)) factor = 0.0;
						change.scale(factor);
						
						if(delta == null) delta = change; else delta.add(change);
					}
				}
			} else { // outgoing edge
				for(NodeLabel lab: pedge.getA().getLabels()) {
					if(lab instanceof StandardDiseaseModelLabel && ((StandardDiseaseModelLabel)lab).getDecorator() == this) {
						// Make sure the target node has a disease model decorator
						boolean found = false;
						for(NodeLabel otherLab:pedge.getB().getLabels()) {
							if(otherLab instanceof StandardDiseaseModelLabel &&
									((StandardDiseaseModelLabel)otherLab).getDecorator().equals(((StandardDiseaseModelLabel)lab).getDecorator()))
									{found=true;break;}
						}
						if(!found) continue; // skip edge
						StandardDiseaseModelLabel thisLabel = (StandardDiseaseModelLabel)lab;
						StandardDiseaseModelLabelValue thisValue = (StandardDiseaseModelLabelValue)thisLabel.getCurrentDiseaseModelTempLabelValue();
						StandardDiseaseModelLabelValue change = (StandardDiseaseModelLabelValue)EcoreUtil.copy(thisValue);
						PipeTransportEdgeLabelValue edgeLabelValue =  (PipeTransportEdgeLabelValue)pedge.getLabel().getCurrentValue();
						double maxFlow = edgeLabelValue.getMaxFlow();
						double popCount = thisLabel.getCurrentDiseaseModelTempLabelValue().getPopulationCount();
						double flow = maxFlow;
						if(flow > popCount) flow = popCount;
						long timePeriod = edgeLabelValue.getTimePeriod();
						double factor = flow / popCount;
						factor = factor * timeDelta / timePeriod;
						if(Double.isNaN(factor) || Double.isInfinite(factor)) factor = 0.0;
						change.scale(factor);
						
						if(delta == null) delta = (StandardDiseaseModelLabelValue)change.scale(-1); else delta.sub(change);
					}
				}
			}
		} // for each edge
		return delta;
		
	} // getPipeTransportationDeltas
	
	
	
	@Override
	public void resetLabels() {
		super.resetLabels();

		// Reset all the labels on the transport edges to the node that each
		// label labels
		for (final Iterator<DynamicLabel> labelIter = getLabelsToUpdate()
				.iterator(); labelIter.hasNext();) {
			final DynamicLabel dynamicLabel = labelIter.next();
			final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) dynamicLabel;

			final Node node = diseaseLabel.getNode();
			for (Iterator<Edge> transportationEdgeIter = TransportRelationshipLabelImpl
					.getTransportEdgesToNode(node, populationIdentifier)
					.iterator(); transportationEdgeIter.hasNext();) {
				final Edge transportEdge = transportationEdgeIter.next();
				final TransportRelationshipLabel transportLabel = (TransportRelationshipLabel) transportEdge
						.getLabel();
				transportLabel.reset();
			} // for each transport edge
			
		} // for each disease label
		
		// Populate the pipe transportation systems
		this.populatePipeSystemNodes();
		this.setStepSize(1.0);
		this.setCurrentX(0.0);
	} // resetLabels

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (totalPopulationCount: "); //$NON-NLS-1$
		result.append(totalPopulationCount);
		result.append(", totalPopulationCountReciprocal: "); //$NON-NLS-1$
		result.append(totalPopulationCountReciprocal);
		result.append(", totalArea: "); //$NON-NLS-1$
		result.append(totalArea);
		result.append(", referencePopulationDensity: "); //$NON-NLS-1$
		result.append(referencePopulationDensity);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue
				&& totalPopulationCount >= TOTAL_POPULATION_COUNT_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(totalPopulationCount);
		assert retValue;
		
		retValue = retValue && !Double.isNaN(totalPopulationCount);
		assert retValue;
		
		retValue = retValue
				&& totalPopulationCountReciprocal >= TOTAL_POPULATION_COUNT_RECIPROCAL_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(totalPopulationCountReciprocal);
		assert retValue;
		
		retValue = retValue && !Double.isNaN(totalPopulationCountReciprocal);
		assert retValue;
		
		retValue = retValue && totalArea >= TOTAL_AREA_EDEFAULT;
		assert retValue;

		retValue = retValue && !Double.isInfinite(totalArea);
		assert retValue;
		
		retValue = retValue && !Double.isNaN(totalArea);
		assert retValue;
		
		return retValue;
	} // sane

} // StandardDiseaseModelImpl

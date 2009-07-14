/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.solvers.rk.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.solver.impl.SolverImpl;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl;

import org.eclipse.stem.solvers.rk.RkPackage;
import org.eclipse.stem.solvers.rk.RungeKutta;
import org.eclipse.stem.ui.Activator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runge Kutta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.solvers.rk.impl.RungeKuttaImpl#getRelativeTolerance <em>Relative Tolerance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RungeKuttaImpl extends SolverImpl implements RungeKutta {
	
	// Number of threads
	private short num_threads = 2;// Preferences will override
	
	// Jobs
	private RkJob [] jobs;
	
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
	
	// The step size and the current position (x)
	private double stepSize = 1.0;
	private double currentX;
	
	// Constants used in Runge Kutta Cash Karp 
	
	static double a2=0.2, a3=0.3, a4=0.6, a5=1.0, a6=0.875;
	static double b21 = 0.2, b31=3.0/40, b32=9.0/40.0, b41=0.3, b42=-0.9, b43=1.2;
	static double b51=-11.0/54.0, b52=2.5, b53=-70.0/27.0, b54=35.0/27.0, b61=1631.0/55296.0, b62=175.0/512.0, b63=575.0/13824.0, b64=44275.0/110592.0, b65=253.0/4096.0;
	static double c1 = 37.0/378.0, c3=250.0/621.0, c4=125.0/594.0, c6=512.0/1771.0;
	static double dc5 = -277.0/14336.0;
	static double dc1 = c1-2825.0/27648.0, dc3=c3-18575.0/48384.0, dc4=c4-13525.0/55296.0, dc6=c6-0.25;
	
	static double SAFETY=0.9, PGROW=-0.2, PSHRNK=-0.25, ERRCON=1.89E-4;
	static double TINY = 1E-30;

	private static int MAX_PROGRESS_REPORTS = 5;
	
	/**
	 * The default value of the '{@link #getRelativeTolerance() <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double RELATIVE_TOLERANCE_EDEFAULT = 1.0E-9;

	/**
	 * The cached value of the '{@link #getRelativeTolerance() <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeTolerance()
	 * @generated
	 * @ordered
	 */
	protected double relativeTolerance = RELATIVE_TOLERANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RungeKuttaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void step(STEMTime time, long timeDelta, int cycle) {
		// This is the very start of the process of updating the labels for a
		// simulation cycle. At this point we want to compute the reciprocal of
		// the total population (once) as we use this value for each label
		// update.
		// We also want to reset our count of the total population to zero so
		// we can start accumulating the value for the next cycle.
		
//		computeTotalPopulationCountReciprocal();
//		setTotalPopulationCount(0);
		
		final Preferences preferences = Activator.getDefault().getPluginPreferences();
		num_threads = (short)preferences.getInt(org.eclipse.stem.ui.preferences.PreferenceConstants.SIMULATION_THREADS);
			
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
		
		for(Decorator decorator:this.getDecorators()) {
			EList<DynamicLabel>allLabels = decorator.getLabelsToUpdate();
			for (final Iterator<DynamicLabel> currentStateLabelIter = allLabels
					.iterator(); currentStateLabelIter.hasNext();) {
				if(decorator instanceof StandardDiseaseModel) {
					// It's a standard disease model with a standard disease model label
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
					diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(diseaseLabel.getCurrentDiseaseModelLabelValue());
					diseaseLabel.getCurrentDiseaseModelTempLabelValue().set(diseaseLabel.getCurrentDiseaseModelLabelValue());
				}
			}
		}
		
		if(jobs == null || jobs.length != num_threads) {
			// Initialize the jobs if not done yet or of the number of threads changes
			jobs = new RkJob[num_threads];
	
			for(short i=0;i<num_threads;++i) {
				final short threadnum = i;
				jobs[i] = new RkJob("Worker "+i, threadnum, this);
			} // For each job
		} // If not initialized

		// Initialize
		int thread = 0;
		for(RkJob j:jobs) {
			j.cycle = c;
			j.time = time;
			j.timeDelta = timeDelta;
		}
		// Schedule. Jobs can be rescheduled after finished
		for(RkJob j:jobs) 
			j.schedule();
		
		// Wait until all jobs completed
		for(RkJob j : jobs) {
			try {
				j.join();
			} catch(InterruptedException ie) {
				Activator.logError(ie.getMessage(), ie);
			}
		}
		
		// Set the common time and step size here and validate everything is right
		double minStep = Double.MAX_VALUE;
		double currentT = jobs[0].t;
		for(RkJob j : jobs) {
			// The jobs have calculated new step sizes after they finished. Pick the
			// smallest one for the next cycle
			if(j.h < minStep) minStep = j.h;
			if(j.t != currentT) Activator.logError("Error, one thread was in misstep with other threads, its time was "+j.t+" versus "+currentT, new Exception());
		}
		
		for(Decorator decorator:this.getDecorators()) {
			if(decorator instanceof StandardDiseaseModel) {
				StandardDiseaseModel sdm = (StandardDiseaseModel)decorator;
				sdm.setCurrentX(currentT);
				sdm.setStepSize(minStep); // smallest one from above.
			}
		}	
	}
	
	/**
	 * _step Do the step for a single thread
	 * 
	 * @param time
	 * @param timeDelta
	 * @param cycle
	 * @param threadnum
	 */
	protected void _step(STEMTime time, long timeDelta, int cycle, short threadnum) {
//		this.setProgress(0.0);
		
		// We only deal with standard disease model decorators
		
		ArrayList<StandardDiseaseModelImpl> diseaseModelDecorators = new ArrayList<StandardDiseaseModelImpl>();
		
		for(Decorator d:getDecorators()) {
			if(d instanceof StandardDiseaseModel)
				diseaseModelDecorators.add(((StandardDiseaseModelImpl)d));
		}
		
		
		// First we get the step size, either the default step size
		// (initially 1.0) or the last step size used. 
		
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
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				EList<DynamicLabel>myLabels = sdm.getLabelsToUpdate(threadnum, num_threads);
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
					double progress = (double)n/(double)numLabels;
					jobs[threadnum].setProgress(progress);
					if(n%setProgressEveryNthNode==0) {
						// Get the progress for all threads
						for(int i=0;i<num_threads;++i) if(i!=threadnum && jobs[i] != null) progress+=jobs[i].getProgress();
						progress /= num_threads;
						sdm.setProgress(progress);
					}
					n+=1.0;
				}
			} // For each decorator
			// So that validation code above is happy
			jobs[threadnum].h = h;
			jobs[threadnum].t = x;
			
			return;
		}

		
		// Make sure we actually have labels to update
		boolean workToDo=false;
		for(StandardDiseaseModelImpl sdm:diseaseModelDecorators)
			if(sdm.getLabelsToUpdate(threadnum, num_threads).size() > 0) {workToDo=true;break;}
		
		if(!workToDo) {
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
		
		// We use the Runge Kutta Kash Carp method to advance to the next
		// step in the simulation. Two estimates of the disease deltas
		// are calculated and compared to each other. If they differ
		// by more than a maximum error (determined by a parameter for
		// the disease model), we reduce the step size until an acceptable
		// error is reached. 
					
		// These are used during Runge Kutta calculations:
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k1map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k2map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k3map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k4map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k5map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> k6map = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		
		// Used below as temporary place holder, one for each decorator
		StandardDiseaseModelLabelValue _k1[], _k2[], _k3[], _k4[], _k5[], _k6[];
		int numDecorators = diseaseModelDecorators.size();
		_k1 = new StandardDiseaseModelLabelValue[numDecorators];
		_k2 = new StandardDiseaseModelLabelValue[numDecorators];
		_k3 = new StandardDiseaseModelLabelValue[numDecorators];
		_k4 = new StandardDiseaseModelLabelValue[numDecorators];
		_k5 = new StandardDiseaseModelLabelValue[numDecorators];
		_k6 = new StandardDiseaseModelLabelValue[numDecorators];
		
		// The final estimates for label values are stored here
		Map<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> finalEstimate = new HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>();
		
		// Delta is used to scale the step (h)
		double delta = 0.0;	
				
		int n=0;
		for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
			Iterator<DynamicLabel> iter = sdm.getLabelsToUpdate(threadnum, num_threads)
					.iterator();
			StandardDiseaseModelLabel firstLabel = (StandardDiseaseModelLabel)iter.next();
			// Initialize temporary place holders just by creating dups of the first label available
			_k1[n] = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
			_k2[n] = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
			_k3[n] = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
			_k4[n] = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
			_k5[n] = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
			_k6[n++] = (StandardDiseaseModelLabelValue)EcoreUtil.copy(firstLabel.getCurrentStandardDiseaseModelLabelValue());
		}
		double end = Math.floor(this.getCurrentX())+1.0;
		
		// Keep track if whether anyone want to stop
		// or pause updating labels
		boolean interrupt=false, pause = false;
		
		// We keep these around to determine when to call setProgress(...) on the decorators.
		// If we call too frequently we can too many callbacks which affects performance.
		double nextProgressReportStep = num_threads*(end-x)/MAX_PROGRESS_REPORTS;
		double nextProgressReport = x+nextProgressReportStep;
		// boolean to check if we're redoing a step because another thread reported a smaller
		// step size
		boolean redo = false;
		
//		HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue> validate = new 
//			HashMap<StandardDiseaseModelLabel, StandardDiseaseModelLabelValue>(); 
		
		// This is the main loop we keep iterating over until we are done with the step
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
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 
				sdm.calculateDelta(time, timeDelta, sdm.getLabelsToUpdate(threadnum, num_threads));
			
			// Set the scaling factor for disease parameters for each decorator and location
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
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
			}
			
			// Step 1 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a first estimate of the next value'
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
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
			}
			
			// Now get the next delta values
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 
				sdm.calculateDelta(time, timeDelta, sdm.getLabelsToUpdate(threadnum, num_threads));
		
			
			// Step 2 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a second estimate of the next value
			n = 0;
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
						.iterator(); currentStateLabelIter.hasNext();) {
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
					
					StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
					k2map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
					_k1[n].set(k1map.get(diseaseLabel));
					_k2[n].set(deltaLabel);
					
					StandardDiseaseModelLabelValue estDelta = 
						(StandardDiseaseModelLabelValue)_k1[n].scale(b31);
					_k2[n].scale(b32);
					estDelta.add(_k2[n]);
					
					estDelta.scale(h);
					
					diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
							diseaseLabel.
							getCurrentDiseaseModelTempLabelValue()));
				}
				++n;
			}
			
			// Now get the next delta values
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 
				sdm.calculateDelta(time, timeDelta, sdm.getLabelsToUpdate(threadnum, num_threads));
		
			
			// Step 3 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a third estimate of the next value
			n = 0;
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
						.iterator(); currentStateLabelIter.hasNext();) {
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
					
					StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
					k3map.put(diseaseLabel, (StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
					
					_k1[n].set(k1map.get(diseaseLabel));
					_k2[n].set(k2map.get(diseaseLabel));
					_k3[n].set(deltaLabel);
					
					_k1[n].scale(b41);
					_k2[n].scale(b42);
					_k3[n].scale(b43);
					StandardDiseaseModelLabelValue estDelta = _k1[n];
					estDelta.add(_k2[n]);
					estDelta.add(_k3[n]);
					
					estDelta.scale(h);
					
					diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
							diseaseLabel.
							getCurrentDiseaseModelTempLabelValue()));
				}	
				++n;
			}
			
			// Now get the next delta values
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 
				sdm.calculateDelta(time, timeDelta, sdm.getLabelsToUpdate(threadnum, num_threads));
		
			
			// Step 4 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a fourth estimate of the next value
			n = 0;
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
						.iterator(); currentStateLabelIter.hasNext();) {
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
					
					StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
					k4map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
					
					_k1[n].set(k1map.get(diseaseLabel));
					_k2[n].set(k2map.get(diseaseLabel));
					_k3[n].set(k3map.get(diseaseLabel));
					_k4[n].set(deltaLabel);
					
					_k1[n].scale(b51);
					_k2[n].scale(b52);
					_k3[n].scale(b53);
					_k4[n].scale(b54);
					
					StandardDiseaseModelLabelValue estDelta = _k1[n];
					estDelta.add(_k2[n]);
					estDelta.add(_k3[n]);
					estDelta.add(_k4[n]);
					
					estDelta.scale(h);
					diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
							diseaseLabel.
							getCurrentDiseaseModelTempLabelValue()));
				}
				++n;
			}
		
			// Now get the next delta values
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 
				sdm.calculateDelta(time, timeDelta, sdm.getLabelsToUpdate(threadnum, num_threads));
		
			
			// Step 5 in Runge Kutta Fehlberg. 
			// Get the delta values out of each node label and
			// build a fifth estimate of the next value
			n = 0;
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
						.iterator(); currentStateLabelIter.hasNext();) {
			
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
					
					StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
					k5map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
					
					_k1[n].set(k1map.get(diseaseLabel));
					_k2[n].set(k2map.get(diseaseLabel));
					_k3[n].set(k3map.get(diseaseLabel));
					_k4[n].set(k4map.get(diseaseLabel));
					_k5[n].set(deltaLabel);
					
					_k1[n].scale(b61);
					_k2[n].scale(b62);
					_k3[n].scale(b63);
					_k4[n].scale(b64);
					_k5[n].scale(b65);
					
					StandardDiseaseModelLabelValue estDelta = _k1[n];
					estDelta.add(_k2[n]);
					estDelta.add(_k3[n]);
					estDelta.add(_k4[n]);
					estDelta.add(_k5[n]);
					
					estDelta.scale(h);
					
					diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(estDelta.add(
							diseaseLabel.
							getCurrentDiseaseModelTempLabelValue()));
				}	
				++n;
			}
			
			// Now get the next delta values
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 
				sdm.calculateDelta(time, timeDelta, sdm.getLabelsToUpdate(threadnum, num_threads));
		
			
			// Step 6 in Runge Kutta Fehlberg. 
			// Calculate k6
			n = 0;
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
						.iterator(); currentStateLabelIter.hasNext();) {
			
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
					
					StandardDiseaseModelLabelValue deltaLabel = diseaseLabel.getDeltaStandardDiseaseModelLabelValue();
					k6map.put(diseaseLabel,(StandardDiseaseModelLabelValue)EcoreUtil.copy(deltaLabel));
				}
				++n;
			}
			
			// Step 7 in Runge Kutta Fehlberg
			// Calculate the two estimates from k1, .. k6 values
			// and determine the maximum difference (error) between them.
			
			boolean success = true; // Were we able to update all labels without a large enough error?
			double maxerror = 0.0;
			n = 0;
			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
						.iterator(); currentStateLabelIter.hasNext();) {
			
					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter
					.next();
			
					DiseaseModelLabelValue currentValue = diseaseLabel.getCurrentDiseaseModelTempLabelValue();
					
					_k1[n].set(k1map.get(diseaseLabel));
					_k3[n].set(k3map.get(diseaseLabel));
					_k4[n].set(k4map.get(diseaseLabel));
					_k5[n].set(k5map.get(diseaseLabel));
					_k6[n].set(k6map.get(diseaseLabel));	
					
					_k1[n].scale(c1);
					_k3[n].scale(c3);
					_k4[n].scale(c4);
					_k6[n].scale(c6);
					
					// New Y
					StandardDiseaseModelLabelValue yout = (StandardDiseaseModelLabelValue)
						EcoreUtil.copy(_k1[n].add(_k3[n]).add(_k4[n]).add(_k6[n]));
					
					yout.scale(h);
					// Need to handle incidence separately since incidence is the delta
					double incidence = yout.getIncidence();
					yout.add(currentValue);
					yout.setIncidence(incidence);
								
					
					// Get the error
					_k1[n].set(k1map.get(diseaseLabel));
					_k3[n].set(k3map.get(diseaseLabel));
					_k4[n].set(k4map.get(diseaseLabel));
					_k5[n].set(k5map.get(diseaseLabel));
					_k6[n].set(k6map.get(diseaseLabel));	
					
					_k1[n].scale(dc1);
					_k3[n].scale(dc3);
					_k4[n].scale(dc4);
					_k5[n].scale(dc5);
					_k6[n].scale(dc6);
					
					StandardDiseaseModelLabelValue yerror = (StandardDiseaseModelLabelValue) EcoreUtil.copy(_k1[n].add(_k3[n]).add(_k4[n]).add(_k5[n]).add(_k6[n]));
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
				++n;
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
					for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
						for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
								.iterator(); currentStateLabelIter.hasNext();) {
							final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
							diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(diseaseLabel.getCurrentDiseaseModelTempLabelValue());
						}
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
					for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
						for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
								.iterator(); currentStateLabelIter.hasNext();) {
							final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
							diseaseLabel.getCurrentDiseaseModelTempLabelValue().set(finalEstimate.get(diseaseLabel));
							diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(finalEstimate.get(diseaseLabel));
						}
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
						for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) 						
							sdm.setProgress(progress);
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
    			for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
    				for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
    						.iterator(); currentStateLabelIter.hasNext();) {
    					final StandardDiseaseModelLabel diseaseLabel = (StandardDiseaseModelLabel) currentStateLabelIter.next();
    					diseaseLabel.getCurrentYStandardDiseaseModelLabelValue().set(diseaseLabel.getCurrentDiseaseModelTempLabelValue());
    				}
    			}
			}
		} // While x < end
		
		jobs[threadnum].t = x;
		jobs[threadnum].h = h;
		
		// Remember the step size and position in the solver
		this.setStepSize(h);
		this.setCurrentX(x);
		
		// We're done
		for(StandardDiseaseModelImpl sdm:diseaseModelDecorators) {
			for (final Iterator<DynamicLabel> currentStateLabelIter = sdm.getLabelsToUpdate(threadnum, num_threads)
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
				// Do any model specific work for instance add noise
				sdm.doModelSpecificAdjustments((StandardDiseaseModelLabelValue)nextState);
				// The next value is valid now.
				diseaseLabel.setNextValueValid(true);
			}
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
	 * Reset the solver
	 * @generated NOT
	 */
	@Override
	public void reset() {
		this.setStepSize(1.0);
		this.setCurrentX(0.0);
	}
	
	protected double getStepSize() {
		return stepSize;
	}
	
	protected double getCurrentX() {
		return currentX;
	}
	
	protected void setStepSize(double d) {
		stepSize = d;
	}
	
	protected void setCurrentX(double d) {
		currentX = d;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RkPackage.Literals.RUNGE_KUTTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRelativeTolerance() {
		return relativeTolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativeTolerance(double newRelativeTolerance) {
		double oldRelativeTolerance = relativeTolerance;
		relativeTolerance = newRelativeTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RkPackage.RUNGE_KUTTA__RELATIVE_TOLERANCE, oldRelativeTolerance, relativeTolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RkPackage.RUNGE_KUTTA__RELATIVE_TOLERANCE:
				return new Double(getRelativeTolerance());
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
			case RkPackage.RUNGE_KUTTA__RELATIVE_TOLERANCE:
				setRelativeTolerance(((Double)newValue).doubleValue());
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
			case RkPackage.RUNGE_KUTTA__RELATIVE_TOLERANCE:
				setRelativeTolerance(RELATIVE_TOLERANCE_EDEFAULT);
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
			case RkPackage.RUNGE_KUTTA__RELATIVE_TOLERANCE:
				return relativeTolerance != RELATIVE_TOLERANCE_EDEFAULT;
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
		result.append(" (relativeTolerance: ");
		result.append(relativeTolerance);
		result.append(')');
		return result.toString();
	}

} //RungeKuttaImpl

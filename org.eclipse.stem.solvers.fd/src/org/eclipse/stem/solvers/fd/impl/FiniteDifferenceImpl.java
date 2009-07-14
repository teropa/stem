/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.solvers.fd.impl;

import java.util.Iterator;
import java.util.concurrent.CyclicBarrier;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.solver.impl.SolverImpl;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl;

import org.eclipse.stem.solvers.fd.FdPackage;
import org.eclipse.stem.solvers.fd.FiniteDifference;
import org.eclipse.stem.ui.Activator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Finite Difference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FiniteDifferenceImpl extends SolverImpl implements FiniteDifference {
	
	// The worker jobs
	private FdJob [] jobs;
	// Number of threads
	private short num_threads;
	
	private final static int MAX_PROGRESS_REPORTS = 5;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FiniteDifferenceImpl() {
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
		
		//computeTotalPopulationCountReciprocal();
		//setTotalPopulationCount(0);
		
		final Preferences preferences = org.eclipse.stem.ui.Activator.getDefault().getPluginPreferences();
		num_threads = (short)preferences.getInt(org.eclipse.stem.ui.preferences.PreferenceConstants.SIMULATION_THREADS);
		
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
			jobs = new FdJob[num_threads];
	
			for(int i=0;i<num_threads;++i) {
				final short threadnum = (short)i;
				jobs[i] = new FdJob("Finite Difference Worker "+i, threadnum, this);
			} // For each job
		} // If not initialized

		// Initialize
	
		for(FdJob j:jobs) {
			j.cycle = cycle;
			j.time = time;
			j.timeDelta = timeDelta;
		}
		
		// Schedule. Jobs can be rescheduled after finished
		for(FdJob j:jobs) 
			j.schedule();
		
		// Wait until all jobs completed
		for(FdJob j : jobs) {
			try {
				j.join();
			} catch(InterruptedException ie) {
				Activator.logError(ie.getMessage(), ie);
			}
		}
		
		// Set the common time and step size here and validate everything is right
		//double minStep = Double.MAX_VALUE;
		//double currentT = jobs[0].t;
		//for(SimJob j : jobs) {
			// The jobs have calculated new step sizes after they finished. Pick the
			// smallest one for the next cycle
		//	if(j.h < minStep) minStep = j.h;
		//	if(j.t != currentT) Activator.logError("Error, one thread was in misstep with other threads, its time was "+j.t+" versus "+currentT, new Exception());
		//}
		
		//this.setCurrentX(currentT);
		//this.setStepSize(minStep); // smallest one from above.
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
		// Now give each decorator a chance to update its dynamic
		// labels in the canonical graph, but only if it is enabled. A
		// Decorator might not be enabled if it is the action of a Trigger
		// and the Predicate of the trigger is false.
		
		
		for (final Iterator<Decorator> decoratorIter = this
				.getDecorators().iterator(); decoratorIter.hasNext();) {
			final Decorator decorator = decoratorIter.next();
			// Is the decorator enabled?
			if (decorator.isEnabled()) {	
				// Yes
				if(decorator instanceof StandardDiseaseModel) {
					// It's a standard disease model decorator
					updateStandardDiseaseModelLabels((StandardDiseaseModelImpl)decorator, time, timeDelta, cycle, threadnum);
				} else {
					// Don't know how to handle non-standard disease model decorators 
				}
			} // if
		} // for each decorator
	}
	
	
	protected void updateStandardDiseaseModelLabels(StandardDiseaseModelImpl model, STEMTime time, long timeDelta, int cycle, short threadnum) {
		
		EList<DynamicLabel> myLabels = model.getLabelsToUpdate(threadnum, num_threads);
		
		// Get the delta values at the current state
		model.calculateDelta(time, timeDelta, myLabels);
		
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
			DiseaseModelLabelValue delta = diseaseLabel.getDeltaValue();
			
			// For finite difference, we need to make sure we don't
			// move too many people from one state to another
			
			delta.adjustDelta(diseaseLabel.getCurrentDiseaseModelLabelValue());
			
			// Add the delta
			nextState.add(delta);

			// Set the incidence
			nextState.setIncidence(diseaseLabel.getDeltaValue().getIncidence());
		
			// Do any model specific work for instance add noise
			model.doModelSpecificAdjustments((StandardDiseaseModelLabelValue)nextState);
			
			// The next value is valid now.
			diseaseLabel.setNextValueValid(true);
			// Now add in the population so we can compute the reciprocal
			// next cycle.
//			addToTotalPopulationCount(nextState.getPopulationCount());
		
			double progress = (double)n/(double)numLabels;
			jobs[threadnum].setProgress(progress);
			if(n%setProgressEveryNthNode==0) {
				// Get the progress for all threads
				for(int i=0;i<num_threads;++i) if(i!=threadnum && jobs[i] != null) progress+=jobs[i].getProgress();
				progress /= num_threads;
				model.setProgress(progress);
			}
			++n;
			
		}
		// Done
//		this.setProgress(1.0);
	}
	
	/**
	 * Reset the solver
	 * @generated NOT
	 */
	@Override
	public void reset() {
		// Nothing needs to be reset here.
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FdPackage.Literals.FINITE_DIFFERENCE;
	}

} //FiniteDifferenceImpl

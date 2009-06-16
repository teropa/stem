package org.eclipse.stem.diseasemodels.standard.impl;

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


import java.util.concurrent.CountDownLatch;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;

/**
 * A simple eclipse Job that can pass back some additional information regarding 
 * the state of the job (in this case the step size and time)
 *
 */
public class SimJob extends Job {
	
	public SimJob(String n, StandardDiseaseModelImpl model, int thread) {
		super(n);
		this.model = model;
		this.threadnum = thread;
	}
	protected double progress;
	protected double h;
	protected double t;
	protected double maxerror;
	protected StandardDiseaseModelImpl model;
	
	protected STEMTime time;
	long timeDelta;
	int cycle;
	int threadnum;
	
	public double getProgress() {
		return this.progress;
	}
	public void setProgress(double p) {
		this.progress = p;
	}
	protected IStatus run(final IProgressMonitor monitor) {
		if(model.isFiniteDifference()) 
			 model.updateLabelsFiniteDifference(time, timeDelta, cycle, threadnum);
		else {
			model.updateLabelsRungeKutta(time, timeDelta, cycle, threadnum);
		}
		return Status.OK_STATUS;
	}
}

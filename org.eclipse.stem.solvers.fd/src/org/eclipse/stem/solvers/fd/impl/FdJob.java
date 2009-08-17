package org.eclipse.stem.solvers.fd.impl;

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



import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.stem.core.model.STEMTime;

/**
 * A job for the finite difference solver
 *
 */
public class FdJob extends Job {
	
	public FdJob(String n, short thread, FiniteDifferenceImpl s) {
		super(n);
		this.threadnum = thread;
		this.solver = s;
	}

	protected double progress;
	protected double t;
	protected FiniteDifferenceImpl solver;
	
	protected STEMTime time;
	long timeDelta;
	int cycle;
	short threadnum;
	
	public double getProgress() {
		return this.progress;
	}
	public void setProgress(double p) {
		this.progress = p;
	}
	protected IStatus run(final IProgressMonitor monitor) {
		solver._step(time,timeDelta,cycle,threadnum);
		
		return Status.OK_STATUS;
	}
}

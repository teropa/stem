package org.eclipse.stem.util.analysis;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * A fitted parameter
 */
public class Parameter {
	
	/*
	 * These are common parameters used for estimation.
	 * Observe that not all parameters are used in a given
	 * scenario
	 */
	
	/**
	 * beta is the disease transmission rate
	 */
	public static String REJECT = "rejected";
	
	/**
	 * beta is the disease transmission rate
	 */
	public static String BETA = "beta";
	
	/**
	 * beta2 is the second fitted disease transmission rate in method two
	 */
	public static String BETA2 = "beta2";
	
	/**
	 * lnBeta for nonlinear fit
	 */
	public static String LNBETA = "lnbeta";
	
	/**
	 * alpha is the immunity loss rate
	 */
	
	public static String ALPHA = "alpha";
	
	/**
	 * alpha2 is the second fitted immunity loss rate in method two
	 */
	public static String ALPHA2 = "alpha2";

	/**
	 * epsilon is the incubation rate
	 */
	public static String EPSILON = "epsilon";

	/**
	 * epsilon2 is the second fitted incubation rate found in method two
	 */
	public static String EPSILON2 = "epsilon2";
		
	/**
	 *gamma is the infectious recovery rate 
	 */
	public static String GAMMA = "gamma";
	
	/**
	 * gamma2 is the second fitted infectious recovery rate in method two
	 */
	public static String GAMMA2 = "gamma2";
	
	/**
	 * lambda is the infectious recovery rate 
	 */
	public static String LAMBDA = "lambda";
	
	/**
	 * RdR
	 */
	public static String RdR = "RdR";
	
	/**
	 * RdS
	 */
	public static String RdS = "RdS";
	
	/**
	 * RdI
	 */
	public static String RdI = "RdI";
	
	/**
	 * BETAVAR
	 */
	
	public static String BETAVAR = "BETAVAR";
	
	/**
	 * GAMMAVAR
	 */
	
	public static String GAMMAVAR = "GAMMAVAR";
	
	
	/** END PARAMETER DECLARATION */
	
	/**
	 * Parameter name (for map keys etc.)
	 */
	public String name;
	/**
	 * The parameter value
	 */
	public double value = 0.0;
	/**
	 * The parameter standard deviation
	 */
	public double stddev = 1.0;
	/**
	 * The parameter variance
	 */
	public double variance= 1.0;
	
	/**
	 * Private null constructor (force a name)
	 * 
	 */
	
	private Parameter() {
		// Nothing here
	}
	
	/**
	 * Constructor 1
	 * 
	 * @param name String
	 */
	
	public Parameter(String name) {
		this();
		this.name = name;
	}
	
	/**
	 * Constructor 2
	 * 
	 * @param name String
	 * @param value Set value
	 * @param dev Set standard deviation
	 * @param var Set variation
	 */
	
	public Parameter(String name, double value, double dev, double var) {
		this();
		this.name = name;
		this.stddev = dev;
		this.value = value;
		this.variance = var;
	}
	
	/**
	 * Constructor 3 Set only value
	 * 
	 * @param name String
	 * @param value Set value
	 */
	
	public Parameter(String name, double value) {
		this();
		this.name = name;
		this.value = value;
	}
}

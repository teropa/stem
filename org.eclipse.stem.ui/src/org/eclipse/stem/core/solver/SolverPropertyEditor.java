package org.eclipse.stem.core.solver;

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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

abstract public class SolverPropertyEditor extends Composite {

	/**
	 * @param feature
	 * @return <code>true</code> if the feature is a dublin core feature 
	 * that is specified by a user.
	 */
	public static boolean isUserSpecifiedSolverProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		final EClass containingClass = feature.getEContainingClass();
		// Is it a disease model property?
		if (containingClass.equals(SolverPackage.eINSTANCE.getSolver())
				|| containingClass.getEAllSuperTypes().contains(
						SolverPackage.eINSTANCE.getSolver())) {
			retValue = true;
		} // if a disease model property
		return retValue;
	} // isUserSpecifiedDiseaseModelProperty

	/**
	 * @param descriptor
	 * @return the string that represents the default value of the property
	 */
	protected String getPropertyDefaultValueString(final IItemPropertyDescriptor descriptor) {
		String retValue = ""; //$NON-NLS-1$
	
		final EStructuralFeature feature = (EStructuralFeature) descriptor
				.getFeature(null);
	
		switch (feature.getFeatureID()) {
		// Any special handling here...
			default:
				retValue = feature.getDefaultValueLiteral();
				retValue = retValue == null ? "" : retValue; //$NON-NLS-1$
				break;
		} // switch
	
		return retValue;
	} // getPropertyDefaultValueString
	
	protected final Map<EStructuralFeature, Text> map = new HashMap<EStructuralFeature, Text>();
	protected String errorMessage;

	public SolverPropertyEditor(Composite parent, int style) {
		super(parent,style);
	}

	public void populate(Solver solver) {
		// Nothing to do here since there are no common solver attributes right now
	}

	/**
	 * Create the solver instance from form data
	 * @return Solver
	 */
	public abstract Solver createAndPopulateSolver();
	
	
	public boolean validate() {
		boolean retValue = true;
		return retValue;
	} // validate

	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

	/**
	 * @return the error message that describes the problem with the contents
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
} // SolverPropertyEditor

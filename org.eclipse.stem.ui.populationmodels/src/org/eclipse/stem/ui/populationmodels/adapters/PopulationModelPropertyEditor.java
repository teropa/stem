package org.eclipse.stem.ui.populationmodels.adapters;

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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("all")
abstract public class PopulationModelPropertyEditor extends Composite {

	/**
	 * @param feature
	 * @return <code>true</code> if the feature is a dublin core feature that
	 *         is specified by a user.
	 */
	public static boolean isUserSpecifiedPopulationModelProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		if(feature.getFeatureID() == StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS)
			return false;
		final EClass containingClass = feature.getEContainingClass();
		// Is it a disease model property?
		if (containingClass.equals(StandardPackage.eINSTANCE.getPopulationModel())
				|| containingClass.getEAllSuperTypes().contains(
						StandardPackage.eINSTANCE.getPopulationModel())) {
			// Yes
			retValue = true;
		} // if a disease model property
		return retValue;
	} // isUserSpecifiedDiseaseModelProperty

	protected final Map<EStructuralFeature, Text> map = new HashMap<EStructuralFeature, Text>();
	protected String errorMessage;

	public PopulationModelPropertyEditor(Composite parent, int style) {
		super(parent,style);
	}

	public void populate(PopulationModel populationModel) {
		
	}

	public boolean validate() {
		
		
		return true;
	} // validate

	
	/**
	 * @param text
	 * @return
	 */
	protected boolean isValidPercentage(final String text) {
		boolean retValue = true;
		try {
			final double value = Double.parseDouble(text);
			retValue = value >= 0.0 && value <= 100.;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	}

	/**
	 * @param text
	 * @param minValue
	 * @return
	 */
	protected boolean isValidValue(final String text, final double minValue) {
		boolean retValue = true;
		try {
			final double value = Double.parseDouble(text);
			retValue = value >= minValue;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	} // isValidRate

	/**
	 * @param text
	 * @param minValue
	 * @return
	 */
	protected boolean isValidLong(final String text, final long minValue) {
		boolean retValue = true;
		try {
			final double value = Long.parseLong(text);
			retValue = value >= minValue;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	} // isValidLong
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

	/**
	 * @param descriptor
	 * @return the string that represents the default value of the property
	 */
	protected String getPropertyDefaultValueString(final IItemPropertyDescriptor descriptor) {
		String retValue = ""; //$NON-NLS-1$
	
		final EStructuralFeature feature = (EStructuralFeature) descriptor
				.getFeature(null);
	
		retValue = feature.getDefaultValueLiteral();
		retValue = retValue == null ? "" : retValue; //$NON-NLS-1$
	
		return retValue;
	} // getPropertyDefaultValueString

	/**
	 * @return the error message that describes the problem with the contents
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

} // PopulationModelPropertyEditor

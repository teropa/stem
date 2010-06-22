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

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.ui.editors.GenericPropertyEditor;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("all")
abstract public class PopulationModelPropertyEditor extends GenericPropertyEditor {

	/**
	 * @param feature
	 * @return <code>true</code> if the feature is a dublin core feature that
	 *         is specified by a user.
	 */
	@Override
	public boolean isUserSpecifiedProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		if(feature.getFeatureID() == StandardPackage.DEMOGRAPHIC_POPULATION_MODEL__POPULATION_GROUPS)
			return false;
		if(feature.getFeatureID() == StandardPackage.POPULATION_MODEL__TARGET_ISO_KEY)
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


	public PopulationModelPropertyEditor(Composite parent, int style, IProject project) {
		super(parent,style, project);
	}

	public PopulationModelPropertyEditor(final Composite parent, final int style,
			final PopulationModel populationModel,
			final ModifyListener projectValidator, IProject project) {
		super(parent, style, populationModel, projectValidator, project);

	}
		
	public void populate(PopulationModel populationModel) {
		
	}

	public boolean validate() {
		
		
		return true;
	} // validate

		
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

} // PopulationModelPropertyEditor

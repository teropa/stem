// DiseaseModelPropertyComposite.java
package org.eclipse.stem.ui.populationmodels.standard.wizards;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
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

import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditor;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditorAdapter;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditorAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class represents
 */
public class PopulationModelPropertyComposite extends Composite {

	private Map<PopulationModel, PopulationModelPropertyEditor> modelMap = new HashMap<PopulationModel, PopulationModelPropertyEditor>();

	private StackLayout stackLayout = null;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public PopulationModelPropertyComposite(final Composite parent,
			final int style, final PopulationModel[] populationModels,
			ModifyListener projectValidator) {
		super(parent, style);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		Label label;
		label = new Label(this, SWT.NONE);
		label.setText(PopulationModelWizardMessages.getString("DMPC1")); //$NON-NLS-1$
		PopulationModelPropertyEditor firstOne = null;
		// Any disease models?
		if (populationModels != null) {
			// Yes
			for (int i = 0; i < populationModels.length; i++) {

				PopulationModelPropertyEditorAdapter dmpea = (PopulationModelPropertyEditorAdapter) PopulationModelPropertyEditorAdapterFactory.INSTANCE
						.adapt(populationModels[i],
								PopulationModelPropertyEditorAdapter.class);

				final PopulationModelPropertyEditor dmpe = dmpea
						.createPopulationModelPropertyEditor(this, SWT.NONE,
								projectValidator);

				modelMap.put(populationModels[i], dmpe);
				if (firstOne == null) {
					// Yes
					firstOne = dmpe;
				} // if
			} // for i
		} // if any disease models?

		stackLayout.topControl = firstOne;
	} // DiseaseModelPropertyComposite

	void displayDiseaseModel(final PopulationModel diseaseModel) {
		final PopulationModelPropertyEditor dmpe = modelMap.get(diseaseModel);
		// Did we find it?
		if (dmpe != null) {
			// Yes
			stackLayout.topControl = dmpe;
			layout();
		} // if
		else {
			Activator.logError(PopulationModelWizardMessages.getString("DMPC2") //$NON-NLS-1$
					+ diseaseModel.getClass().getName() + "\"", null); //$NON-NLS-1$
		}
	} // displayDiseaseModel
	
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

	/**
	 * @return <code>true</code> if the contents of the composite are valid,
	 *         <code>false</code> otherwise.
	 */
	public boolean validate() {
		return ((PopulationModelPropertyEditor) (stackLayout.topControl))
				.validate();
	} // validate

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return ((PopulationModelPropertyEditor) (stackLayout.topControl))
				.getErrorMessage();
	}

	/**
	 * @param diseaseModel
	 */
	public void populatePopulationModel(PopulationModel populationModel) {
		((PopulationModelPropertyEditor) (stackLayout.topControl))
				.populate(populationModel);
	} // populatePopulationModel

} // PopulationModelPropertyComposite

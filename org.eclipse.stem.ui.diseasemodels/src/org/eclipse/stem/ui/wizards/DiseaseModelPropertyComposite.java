// DiseaseModelPropertyComposite.java
package org.eclipse.stem.ui.wizards;

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

import org.eclipse.core.resources.IProject;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapter;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditorAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class represents
 */
public class DiseaseModelPropertyComposite extends Composite {

	private Map<DiseaseModel, DiseaseModelPropertyEditor> modelMap = new HashMap<DiseaseModel, DiseaseModelPropertyEditor>();

	private StackLayout stackLayout = null;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public DiseaseModelPropertyComposite(final Composite parent,
			final int style, final DiseaseModel[] diseaseModels,
			ModifyListener projectValidator, IProject project) {
		super(parent, style);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		Label label;
		label = new Label(this, SWT.NONE);
		label.setText(DiseaseWizardMessages.getString("DMPC1")); //$NON-NLS-1$
		DiseaseModelPropertyEditor firstOne = null;
		// Any disease models?
		if (diseaseModels != null) {
			// Yes
			for (int i = 0; i < diseaseModels.length; i++) {

				DiseaseModelPropertyEditorAdapter dmpea = (DiseaseModelPropertyEditorAdapter) DiseaseModelPropertyEditorAdapterFactory.INSTANCE
						.adapt(diseaseModels[i],
								DiseaseModelPropertyEditorAdapter.class);

				final DiseaseModelPropertyEditor dmpe = dmpea
						.createDiseaseModelPropertyEditor(this, SWT.NONE,
								projectValidator, project);

				modelMap.put(diseaseModels[i], dmpe);
				if (firstOne == null) {
					// Yes
					firstOne = dmpe;
				} // if
			} // for i
		} // if any disease models?

		stackLayout.topControl = firstOne;
	} // DiseaseModelPropertyComposite

	void displayDiseaseModel(final DiseaseModel diseaseModel) {
		final DiseaseModelPropertyEditor dmpe = modelMap.get(diseaseModel);
		// Did we find it?
		if (dmpe != null) {
			// Yes
			stackLayout.topControl = dmpe;
			layout();
		} // if
		else {
			Activator.logError(DiseaseWizardMessages.getString("DMPC2") //$NON-NLS-1$
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
		return ((DiseaseModelPropertyEditor) (stackLayout.topControl))
				.validate();
	} // validate

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return ((DiseaseModelPropertyEditor) (stackLayout.topControl))
				.getErrorMessage();
	}

	/**
	 * @param diseaseModel
	 */
	public void populateDiseaseModel(DiseaseModel diseaseModel) {
		((DiseaseModelPropertyEditor) (stackLayout.topControl))
				.populate(diseaseModel);
	} // populateDiseaseModel

} // DiseaseModelPropertyComposite

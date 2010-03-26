package org.eclipse.stem.ui.populationmodels.standard.wizards;

/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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

import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditor;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditorAdapter;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditorAdapterFactory;
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
public class PopulationInitializerPropertyComposite extends Composite {

	private final Map<PopulationInitializer, PopulationInitializerPropertyEditor> initializerMap = new HashMap<PopulationInitializer, PopulationInitializerPropertyEditor>();

	private StackLayout stackLayout = null;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public PopulationInitializerPropertyComposite(final Composite parent,
			final int style, final PopulationInitializer[] populationInitializers,
			ModifyListener projectValidator) {
		super(parent, style);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		Label label;
		label = new Label(this, SWT.NONE);
		label.setText(PopulationModelWizardMessages.getString("DMPC3")); //$NON-NLS-1$
		PopulationInitializerPropertyEditor firstOne = null;
		// Any disease models?
		if (populationInitializers != null) {
			// Yes
			for (int i = 0; i < populationInitializers.length; i++) {

				PopulationInitializerPropertyEditorAdapter dmpea = (PopulationInitializerPropertyEditorAdapter) PopulationInitializerPropertyEditorAdapterFactory.INSTANCE
						.adapt(populationInitializers[i],
								PopulationInitializerPropertyEditorAdapter.class);

				final PopulationInitializerPropertyEditor dmpe = dmpea
						.createPopulationInitializerPropertyEditor(this, SWT.NONE,
								projectValidator);

				initializerMap.put(populationInitializers[i], dmpe);
				if (firstOne == null) {
					// Yes
					firstOne = dmpe;
				} // if
			} // for i
		} // if any disease models?

		stackLayout.topControl = firstOne;
	} // DiseaseModelPropertyComposite

	void displayPopulationInitializer(final PopulationInitializer initializer) {
		final PopulationInitializerPropertyEditor dmpe = initializerMap.get(initializer);
		// Did we find it?
		if (dmpe != null) {
			// Yes
			stackLayout.topControl = dmpe;
			layout();
		} // if
		else {
			Activator.logError(PopulationModelWizardMessages.getString("DMPC4") //$NON-NLS-1$
					+ initializer.getClass().getName() + "\"", null); //$NON-NLS-1$
		}
	} // displayDiseaseModel
	
	@Override
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
		return ((PopulationInitializerPropertyEditor) (stackLayout.topControl))
				.validate();
	} // validate

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return ((PopulationInitializerPropertyEditor) (stackLayout.topControl))
				.getErrorMessage();
	}

	/**
	 * @param diseaseModel
	 */
	public void populatePopulationInitializer(PopulationInitializer populationInitializer) {
		((PopulationInitializerPropertyEditor) (stackLayout.topControl))
				.populate(populationInitializer);
	} // populatePopulationInitializer

} 

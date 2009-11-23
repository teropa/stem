// DiseaseDefinitionControl.java
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.diseasemodels.Constants;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.wizards.DiseaseModelPropertyComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class represents the SWT control for defining a disease.
 */
public class DiseaseDefinitionControl extends Composite {

	private static DiseaseModel[] diseaseModels = null;

	private final Combo combo;

	private final DiseaseModelPropertyComposite diseaseModelPropertyComposite;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public DiseaseDefinitionControl(final Composite parent, final int style,
			ModifyListener projectValidator) {
		super(parent, style);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.numColumns = 2;
		setLayout(gridLayout);

		final Label diseaseModelLabel = new Label(this, SWT.NONE);
		final GridData gd_diseaseModelLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_diseaseModelLabel.widthHint = 100;
		diseaseModelLabel.setLayoutData(gd_diseaseModelLabel);
		diseaseModelLabel.setText(DiseaseWizardMessages.getString("DDC.0")); //$NON-NLS-1$

		combo = new Combo(this, SWT.READ_ONLY);
		combo.setTextLimit(30);
		final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_combo.widthHint = 303;
		combo.setLayoutData(gd_combo);

		combo.setToolTipText(DiseaseWizardMessages.getString("DDC.1")); //$NON-NLS-1$
		// Initialize the list of disease models available
		combo.setItems(getDiseaseModelNames(getDiseaseModels()));
		combo.select(0);
		combo.addModifyListener(projectValidator);

		
		diseaseModelPropertyComposite = new DiseaseModelPropertyComposite(this,
				SWT.NONE, getDiseaseModels(), projectValidator);
		final GridData gd_diseaseModelPropertyControl = new GridData(SWT.FILL,
				SWT.CENTER, true, false, 2, 1);
		diseaseModelPropertyComposite
				.setLayoutData(gd_diseaseModelPropertyControl);

		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				diseaseModelPropertyComposite
						.displayDiseaseModel(getDiseaseModels()[combo
								.getSelectionIndex()]);
				// layout();
			} // widgetSelected

		});
		final DiseaseDefinitionControl self = this;

	} // DiseaseDefinitionControl

	/**
	 * @return an array of the {@link DiseaseModels}s defined in the system.
	 */
	private DiseaseModel[] getDiseaseModels() {
		if (diseaseModels == null) {
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IConfigurationElement[] diseaseModelConfigElements = registry
					.getConfigurationElementsFor(org.eclipse.stem.diseasemodels.Constants.ID_DISEASE_MODEL_EXTENSION_POINT);

			final List<DiseaseModel> temp = new ArrayList<DiseaseModel>();

			diseaseModels = new DiseaseModel[diseaseModelConfigElements.length];

			for (int i = 0; i < diseaseModelConfigElements.length; i++) {
				final IConfigurationElement element = diseaseModelConfigElements[i];
				// Does the element specify the class of the disease model?
				if (element.getName().equals(Constants.DISEASE_MODEL_ELEMENT)) {
					// Yes
					try {
						temp.add((DiseaseModel) element
								.createExecutableExtension(DiseaseWizardMessages.getString("DDC.2"))); //$NON-NLS-1$
					} catch (final CoreException e) {
						Activator.logError(
								DiseaseWizardMessages.getString("DDC.3"), e); //$NON-NLS-1$
					}
				} // if
			} // for each configuration element

			diseaseModels = temp.toArray(new DiseaseModel[] {});
		} // if disesaeModels not created

		return diseaseModels;
	} // getDiseaseModels

	/**
	 * @return the names of the disease models
	 */
	private String[] getDiseaseModelNames(final DiseaseModel[] diseaseModels) {
		final String[] retValue = new String[diseaseModels.length];
		for (int i = 0; i < diseaseModels.length; i++) {
			String name = diseaseModels[i].getDublinCore().getTitle();
			// Was a name specified?
			if ((name == null) || name.equals("")) { //$NON-NLS-1$
				// No
				name = diseaseModels[i].getClass().getSimpleName();
			} // if

			retValue[i] = name;
		} // for i
		return retValue;
	} // getDiseaseModelNames

	
	DiseaseModel getSelectedDiseaseModel() {
		final DiseaseModel retValue = EcoreUtil
				.copy(getDiseaseModels()[combo.getSelectionIndex()]);
		diseaseModelPropertyComposite.populateDiseaseModel(retValue);
		return retValue;
	} // getSelectedDiseaseModel

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

	/**
	 * @return <code>true</code> if the contents of the control are valid,
	 *         <code>false</code> otherwise.
	 */
	public boolean validate() {
		return diseaseModelPropertyComposite.validate();
	} // validate

	/**
	 * @return the error message set by {@link #validate()}
	 */
	public String getErrorMessage() {
		return diseaseModelPropertyComposite.getErrorMessage();
	}

} // DiseaseDefinitionControl

// DiseaseDefinitionControl.java
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.widgets.LocationPickerDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class represents the SWT control for defining a disease.
 */
public class PopulationModelDefinitionControl extends Composite {

	private static PopulationModel[] populationModels = null;

	private final Combo combo;

	private final PopulationModelPropertyComposite populationModelPropertyComposite;

	private String isoKey="";

	private URI targetURI = null;
	
	
	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public PopulationModelDefinitionControl(final Composite parent, final int style,
			ModifyListener projectValidator, final IProject project) {
		super(parent, style);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.numColumns = 2;
		setLayout(gridLayout);

		final Label populationModelLabel = new Label(this, SWT.NONE);
		final GridData gd_populationModelLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_populationModelLabel.widthHint = 100;
		populationModelLabel.setLayoutData(gd_populationModelLabel);
		populationModelLabel.setText(PopulationModelWizardMessages.getString("DDC.0")); //$NON-NLS-1$

		combo = new Combo(this, SWT.READ_ONLY);
		combo.setTextLimit(30);
		final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_combo.widthHint = 303;
		combo.setLayoutData(gd_combo);

		combo.setToolTipText(PopulationModelWizardMessages.getString("DDC.1")); //$NON-NLS-1$
		// Initialize the list of disease models available
		combo.setItems(getPopulationModelNames(getPopulationModels()));
		combo.select(0);
		combo.addModifyListener(projectValidator);

		
		populationModelPropertyComposite = new PopulationModelPropertyComposite(this,
				SWT.NONE, getPopulationModels(), projectValidator);
		final GridData gd_populationModelPropertyControl = new GridData(SWT.FILL,
				SWT.CENTER, true, false, 2, 1);
		populationModelPropertyComposite
				.setLayoutData(gd_populationModelPropertyControl);

		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				populationModelPropertyComposite
						.displayDiseaseModel(getPopulationModels()[combo
								.getSelectionIndex()]);
				// layout();
			} // widgetSelected

		});
		final PopulationModelDefinitionControl self = this;

		// Location picker
		// ISO Key
		final Label isoKeyLabel = new Label(this, SWT.NONE);
		isoKeyLabel.setText(PopulationModelWizardMessages.getString("NPopWizISOK")); //$NON-NLS-1$
		final GridData gd_isoKeyLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isoKeyLabel.setLayoutData(gd_isoKeyLabel);
		
		final Label isokeyValueLabel = new Label(this, SWT.NONE);
		isokeyValueLabel.setText(isoKey);

		final GridData gd_isoKeyLabelValue = new GridData(SWT.FILL, SWT.CENTER, true, false);
		isokeyValueLabel.setLayoutData(gd_isoKeyLabelValue);
		
		final Button locationButton = new Button(this, SWT.NONE);
		locationButton.setText(PopulationModelWizardMessages.getString("NPopWizPickLoc"));
		final GridData lb_isoKeyLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		locationButton.setLayoutData(lb_isoKeyLabel);
		
		locationButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				LocationPickerDialog lpDialog = new LocationPickerDialog(PopulationModelDefinitionControl.this.getShell(), SWT.NONE, PopulationModelWizardMessages.getString("NPopWizPickLocTitle"), PopulationModelDefinitionControl.this.isoKey, project);
				
				Object [] ret  = lpDialog.open();
				if(ret != null) { 
					isokeyValueLabel.setText((String)ret[0]);
					isoKey = (String)ret[0];
					targetURI = (URI)ret[1];
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		

	} // DiseaseDefinitionControl

	/**
	 * @return an array of the {@link DiseaseModels}s defined in the system.
	 */
	private PopulationModel[] getPopulationModels() {
		if (populationModels == null) {
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IConfigurationElement[] populationModelConfigElements = registry
					.getConfigurationElementsFor(org.eclipse.stem.populationmodels.Constants.ID_POPULATION_MODEL_EXTENSION_POINT);

			final List<PopulationModel> temp = new ArrayList<PopulationModel>();

			populationModels = new PopulationModel[populationModelConfigElements.length];

			for (int i = 0; i < populationModelConfigElements.length; i++) {
				final IConfigurationElement element = populationModelConfigElements[i];
				// Does the element specify the class of the population model?
				if (element.getName().equals(org.eclipse.stem.populationmodels.Constants.POPULATION_MODEL_ELEMENT)) {
					// Yes
					try {
						temp.add((PopulationModel) element
								.createExecutableExtension(PopulationModelWizardMessages.getString("DDC.2"))); //$NON-NLS-1$
					} catch (final CoreException e) {
						Activator.logError(
								PopulationModelWizardMessages.getString("DDC.3"), e); //$NON-NLS-1$
					}
				} // if
			} // for each configuration element

			populationModels = temp.toArray(new PopulationModel[] {});
		} // if populationModels not created

		return populationModels;
	} // getPopulationModels

	/**
	 * @return the names of the disease models
	 */
	private String[] getPopulationModelNames(final PopulationModel[] populationModels) {
		final String[] retValue = new String[populationModels.length];
		for (int i = 0; i < populationModels.length; i++) {
			String name = populationModels[i].getDublinCore().getTitle();
			// Was a name specified?
			if ((name == null) || name.equals("")) { //$NON-NLS-1$
				// No
				name = populationModels[i].getClass().getSimpleName();
			} // if

			retValue[i] = name;
		} // for i
		return retValue;
	} // getPopulationModelNames

	
	PopulationModel getSelectedPopulationModel() {
		final PopulationModel retValue = (PopulationModel)EcoreUtil
				.copy(getPopulationModels()[combo.getSelectionIndex()]);
		populationModelPropertyComposite.populatePopulationModel(retValue);
		retValue.setTargetISOKey(this.getIsoKey());
		return retValue;
	} // getSelectedPopulationModel

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
		return populationModelPropertyComposite.validate();
	} // validate

	/**
	 * @return the error message set by {@link #validate()}
	 */
	public String getErrorMessage() {
		return populationModelPropertyComposite.getErrorMessage();
	}

	public String getIsoKey() {
		return isoKey;
	}
	
	public URI getTargetURI() {
		return targetURI;
	}
} // PopulationDefinitionControl

package org.eclipse.stem.diseasemodels.externaldatasource.presentation;
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

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel;
import org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourcePackage;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.ui.adapters.diseasemodelpropertyeditor.DiseaseModelPropertyEditor;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.wizards.DiseaseWizardMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 *
 */
public class ExternalDataSourceDiseaseModelPropertyEditor extends
		DiseaseModelPropertyEditor {
	
	/**
	 * @param parent
	 * @param style
	 * @param diseaseModel
	 * @param projectValidator
	 */
	public ExternalDataSourceDiseaseModelPropertyEditor(Composite parent,
			int style, DiseaseModel diseaseModel,
			ModifyListener projectValidator) {
		super(parent, style);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		setLayout(gridLayout);

		// Get the adapter that will provide NLS'd names for the
		// properties of the disease model
		final PropertyStringProviderAdapter pspa = (PropertyStringProviderAdapter) PropertyStringProviderAdapterFactory.INSTANCE
				.adapt(diseaseModel, PropertyStringProvider.class);

		final ComposedAdapterFactory itemProviderFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IItemPropertySource propertySource = (IItemPropertySource) itemProviderFactory
				.adapt(diseaseModel, IItemPropertySource.class);
		final List<IItemPropertyDescriptor> properties = propertySource
				.getPropertyDescriptors(diseaseModel);

		for (final IItemPropertyDescriptor descriptor : properties) {
			final EStructuralFeature feature = (EStructuralFeature) descriptor
					.getFeature(null);
			// Is this a disease model property that the user should specify?
			if (isUserSpecifiedDiseaseModelProperty(feature)) {
				// Yes
				final Label label = new Label(this, SWT.NONE);
				label.setText(pspa.getPropertyName(descriptor));

				final GridData labelGD = new GridData(GridData.BEGINNING);
				labelGD.grabExcessHorizontalSpace = true;
				labelGD.horizontalAlignment = SWT.FILL;
				labelGD.horizontalIndent = 0;
				label.setLayoutData(labelGD);

				// Get a string value for the default value of the feature

				final String defaultValueString = getPropertyDefaultValueString(descriptor);

				final Text text = new Text(this, SWT.BORDER | SWT.TRAIL);
				text.setText(defaultValueString);
				text.setToolTipText(pspa.getPropertyToolTip(descriptor));
				map.put(feature, text);

				final GridData textGD = new GridData(GridData.END);
				textGD.grabExcessHorizontalSpace = true;
				textGD.horizontalAlignment = SWT.FILL;
				text.setLayoutData(textGD);

				text.addModifyListener(projectValidator);

				boolean isDataPath = false;
				if (feature.getName().equals("dataPath")) { //$NON-NLS-1$
					isDataPath = true;
					final Composite buttons = new Composite(this, SWT.NONE);
					final RowLayout buttonsLayout = new RowLayout();
					buttonsLayout.marginTop = 0;
					buttonsLayout.marginBottom = 0;
					buttons.setLayout(buttonsLayout);
					final Shell shell = this.getShell();

					final Button dirChooserButton = new Button(buttons,
							SWT.NONE);
					dirChooserButton.setText(DiseaseWizardMessages
							.getString("dirChooserButtonText")); //$NON-NLS-1$
					dirChooserButton.setToolTipText(DiseaseWizardMessages
							.getString("dirChooserButtonTooltipText")); //$NON-NLS-1$
					dirChooserButton
							.addSelectionListener(new SelectionAdapter() {
								@Override
								public void widgetSelected(
										final SelectionEvent e) {
									final DirectoryDialog dd = new DirectoryDialog(
											shell, SWT.OPEN);
									dd
											.setText(DiseaseWizardMessages
													.getString("dirChooserDialogTitle")); //$NON-NLS-1$
									final String selected = dd.open();
									text.setText(selected);
								} // widgetSelected
							} // SelectionAdapter
							);

					final GridData fileBtnGD = new GridData(GridData.END);
					// fileChooserButton.setLayoutData(fileBtnGD);
					buttons.setLayoutData(fileBtnGD);
				}
				if (!isDataPath) {
					final Label unitLabel = new Label(this, SWT.NONE);
					unitLabel.setText(pspa.getPropertyUnits(descriptor));
					final GridData unitLabelGD = new GridData(GridData.END);
					unitLabelGD.verticalAlignment = GridData.CENTER;
					unitLabel.setLayoutData(unitLabelGD);
				}

			} // if user specified
		} // for each disease model property

		final Label pmtpDefLabel = new Label(this, SWT.NONE);
		pmtpDefLabel.setText(DiseaseWizardMessages.getString("PMTP_Def")); //$NON-NLS-1$
		final GridData pmtpDefGD = new GridData(GridData.END);
		pmtpDefGD.grabExcessHorizontalSpace = true;
		pmtpDefGD.horizontalSpan = 3;
		pmtpDefLabel.setLayoutData(pmtpDefGD);
	} // ExternalDataSourceDiseaseModelPropertyEditor

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#populate(org.eclipse.stem.diseasemodels.standard.DiseaseModel)
	 */
	@Override
	public void populate(DiseaseModel diseaseModel) {
		super.populate(diseaseModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			switch (entry.getKey().getFeatureID()) {
			case ExternalDataSourcePackage.EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH:
				((ExternalDataSourceDiseaseModel) diseaseModel)
						.setDataPath(entry
								.getValue().getText());
				break;
			case ExternalDataSourcePackage.EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DISEASE_TYPE:
				((ExternalDataSourceDiseaseModel) diseaseModel)
						.setDiseaseType(entry
								.getValue().getText());
				break;
			default:
				break;
			} // switch
		} // for each Map.entry
		
	}

	/**
	 * @see org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor#validate()
	 */
	@Override
	public boolean validate() {
		boolean retValue = super.validate();
		// Disease Data Directory or File
		if (retValue) {
			// Yes
			final Text text = map
					.get(ExternalDataSourcePackage.Literals.EXTERNAL_DATA_SOURCE_DISEASE_MODEL__DATA_PATH);
			File f = new File(text.getText());
			retValue = f.exists();
			// exists?
			if (!retValue) {
				// Yes
				errorMessage = DiseaseWizardMessages.getString("NDizWizErr20"); //$NON-NLS-1$
			} // if
		} // if
		
		return retValue;
	}
	
} // ExternalDataSourceDiseaseModelPropertyEditor

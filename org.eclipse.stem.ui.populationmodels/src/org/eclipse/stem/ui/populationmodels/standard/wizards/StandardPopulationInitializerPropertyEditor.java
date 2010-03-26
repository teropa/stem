// StandardDiseaseModelPropertyEditor.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.populationmodels.standard.PopulationInitializer;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationInitializer;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationInitializerPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a {@link Composite} that presents the properties of a
 * {@link PopulationInitializer} for editing.
 */
public class StandardPopulationInitializerPropertyEditor extends PopulationInitializerPropertyEditor {
	
	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public StandardPopulationInitializerPropertyEditor(final Composite parent, final int style,
			final PopulationInitializer populationInitializer,
			final ModifyListener projectValidator) {
		super(parent, style);

		
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		this.setLayout(gridLayout);
		
		
		// Get the adapter that will provide NLS'd names for the
		// properties of the disease model
		final PropertyStringProviderAdapter pspa = (PropertyStringProviderAdapter) PropertyStringProviderAdapterFactory.INSTANCE
				.adapt(populationInitializer, PropertyStringProvider.class);

		final ComposedAdapterFactory itemProviderFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IItemPropertySource propertySource = (IItemPropertySource) itemProviderFactory
				.adapt(populationInitializer, IItemPropertySource.class);
		
		final List<IItemPropertyDescriptor> properties = propertySource
				.getPropertyDescriptors(populationInitializer);

		for (final IItemPropertyDescriptor descriptor : properties) {
			final EStructuralFeature feature = (EStructuralFeature) descriptor
					.getFeature(null);
			// Is this a disease model property that the user should specify?
			if (isUserSpecifiedPopulationInitializerProperty(feature)) {
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

				EClassifier classifier = feature.getEType();
				if(classifier.getName().equals("EBoolean")) {
					Composite radioComposite = new Composite(this, SWT.BORDER);
				    FillLayout fillLayout = new FillLayout();
				    fillLayout.type = SWT.HORIZONTAL;
				    radioComposite.setLayout(fillLayout);
				    
				    final Button falseButton = new Button(radioComposite, SWT.RADIO);
				    falseButton.setSelection(true);
				    falseButton.setText(PopulationModelWizardMessages.getString("NO"));//$NON-NLS-1$
				    
				    Button trueButton = new Button(radioComposite, SWT.RADIO);
				    trueButton.setText(PopulationModelWizardMessages.getString("YES"));//$NON-NLS-1$
				    	    
				    Listener listener = new Listener() {
				        public void handleEvent(Event event) {
				          if (event.widget == falseButton) {
				        	booleanMap.put(feature, !falseButton.getSelection());
				          }
				        }
				      };
				      // these are radio buttons so we only need to add the listener to one of them.
				      falseButton.addListener(SWT.Selection, listener);
				      final GridData cGD = new GridData(GridData.END);
				      cGD.grabExcessHorizontalSpace = true;
					  cGD.horizontalAlignment = SWT.FILL;
					  radioComposite.setLayoutData(cGD);
					  
				} else {
					final Text text = new Text(this, SWT.BORDER | SWT.TRAIL);
					text.setText(defaultValueString);
					text.setToolTipText(pspa.getPropertyToolTip(descriptor));
					map.put(feature, text);
	
					final GridData textGD = new GridData(GridData.END);
					textGD.grabExcessHorizontalSpace = true;
					textGD.horizontalAlignment = SWT.FILL;
					text.setLayoutData(textGD);
	
					text.addModifyListener(projectValidator);
				}
				
				boolean isDataPath = false;
				if (feature.getName().equals("dataPath")) { //$NON-NLS-1$
					isDataPath = true;
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
		
	} // StandardPopulationInitializerPropertyEditor

	/**
	 * @param diseaseModel
	 *            the {@link DiseaseModel} instance to populate.
	 */
	@Override
	public void populate(final PopulationInitializer populationInitializer) {
		super.populate(populationInitializer);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			switch (entry.getKey().getFeatureID()) {
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER:
				((StandardPopulationInitializer)populationInitializer).setPopulationIdentifier(entry.getValue().getText());
				break;
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS:
				((StandardPopulationInitializer)populationInitializer)
						.setIndividuals((Double.parseDouble(entry.getValue().getText().trim())));
				break;
			default:
				break;
			} // switch
		} // for each Map.entry

		for (final Map.Entry<EStructuralFeature, Boolean> entry : booleanMap.entrySet()) {
			switch (entry.getKey().getFeatureID()) {
			case StandardPackage.STANDARD_POPULATION_INITIALIZER__USE_DENSITY:
				((StandardPopulationInitializer)populationInitializer).setUseDensity(entry.getValue());
				break;
			default:
				break;
			} // switch
		} // for each Map.entry

	} // populate

	/**
	 * @return <code>true</code> if the contents are valid, <code>false</code>
	 *         otherwise.
	 */
	@Override
	public boolean validate() {
		boolean retValue = super.validate();

		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.STANDARD_POPULATION_INITIALIZER__POPULATION_IDENTIFIER);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = PopulationModelWizardMessages.getString("NDizWizErr15"); //$NON-NLS-1$
			} // if
		} // if

		// 
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.STANDARD_POPULATION_INITIALIZER__INDIVIDUALS);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = PopulationModelWizardMessages.getString("NDizWizErr16"); //$NON-NLS-1$
			} // if
			else {
				// No
				// Is it a valid value > 0?
				retValue = isValidValue(text.getText(), 0.0);
				if (!retValue) {
					// No
					errorMessage = PopulationModelWizardMessages
							.getString("NDizWizErr17"); //$NON-NLS-1$
				} // if
			}
		} 
				
		return retValue;
	} // validate

} // StandardPropertyModelPropertyEditor

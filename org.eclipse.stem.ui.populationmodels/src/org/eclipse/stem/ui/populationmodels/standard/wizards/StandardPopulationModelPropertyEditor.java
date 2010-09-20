// StandardDiseaseModelPropertyEditor.java
package org.eclipse.stem.ui.populationmodels.standard.wizards;

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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.populationmodels.standard.DemographicPopulationModel;
import org.eclipse.stem.populationmodels.standard.MosquitoPopulationModel;
import org.eclipse.stem.populationmodels.standard.PopulationGroup;
import org.eclipse.stem.populationmodels.standard.PopulationModel;
import org.eclipse.stem.populationmodels.standard.SeasonalPopulationModel;
import org.eclipse.stem.populationmodels.standard.StandardFactory;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.populationmodels.adapters.PopulationModelPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a {@link Composite} that presents the properties of a
 * {@link DiseaseModel} for editing.
 */
public class StandardPopulationModelPropertyEditor extends PopulationModelPropertyEditor {

	private ArrayList<Composite>groupComposites = new ArrayList<Composite>();
	private ArrayList<Text>groupIDComposites = new ArrayList<Text>();
	private ArrayList<Text>groupFracComposites = new ArrayList<Text>();
	
	private static String DEFAULT_POPULATION_ID_PREFIX = "group";
	private static String DEFAULT_POPULATION_FRACTION = "1.0";
	
	Group allGroups;
	
	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public StandardPopulationModelPropertyEditor(final Composite parent, final int style,
			final PopulationModel populationModel,
			final ModifyListener projectValidator, IProject project) {
		super(parent, style, populationModel, projectValidator, project);
	
		if(populationModel instanceof DemographicPopulationModel) {
			allGroups = new Group(this, SWT.NONE);
			GridLayout singleColGridLayout = new GridLayout();
			singleColGridLayout.numColumns = 1;
			allGroups.setLayout(singleColGridLayout);
			GridData gd = new GridData(GridData.FILL, GridData.CENTER, true, false);
			gd.horizontalSpan = 3;
			allGroups.setLayoutData(gd);
			
			addPopulationGroupField(allGroups, projectValidator);
			
			final Button addButton = new Button(this, SWT.NONE);
			final GridData buttonGD = new GridData(GridData.BEGINNING);
			addButton.setText(PopulationModelWizardMessages.getString("addGroup"));
			addButton.setToolTipText(PopulationModelWizardMessages.getString("addGroupTT"));
			buttonGD.grabExcessHorizontalSpace = true;
			buttonGD.horizontalSpan = 3;
			addButton.setLayoutData(buttonGD);
			final StandardPopulationModelPropertyEditor self = this;
			addButton.addSelectionListener(new SelectionListener() {
				
				public void widgetSelected(SelectionEvent arg0) {
					addPopulationGroupField(allGroups, projectValidator);
					self.getParent().getParent().getParent().layout(true);
				}
				
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	} // StandardDiseaseModelPropertyEditor

	private void addPopulationGroupField(final Composite parent, final ModifyListener projectValidator) {
		
		Group groupInfo = new Group(parent, SWT.BORDER);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		groupInfo.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		gridData.horizontalSpan = 3;
		groupInfo.setLayoutData(gridData);
		
		groupComposites.add(groupInfo);
	
		final Button removeButton = new Button(groupInfo, SWT.NONE);
		removeButton.setText(PopulationModelWizardMessages.getString("removeGroup"));
		removeButton.setToolTipText(PopulationModelWizardMessages.getString("removeGroupTT"));
		
		removeButton.addSelectionListener(new SelectionListener() {
		
		
			
			public void widgetSelected(SelectionEvent arg0) {
				int ind = groupComposites.indexOf(removeButton.getParent());
				if(ind == -1) {
					Activator.logError("Error, group composite not found!", new Exception());
				}
				groupComposites.remove(ind);
				groupFracComposites.remove(ind);
				groupIDComposites.remove(ind);
				
				removeButton.getParent().dispose();
				parent.getParent().getParent().getParent().getParent().layout(true);
				if(groupIDComposites.size() > 0)
					groupIDComposites.get(0).setText(groupIDComposites.get(0).getText()); // force validation
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		removeButton.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false));
		
		Label label = new Label(groupInfo, SWT.NONE);
		label.setText(PopulationModelWizardMessages.getString("populationId"));
		GridData labelGD = new GridData(GridData.END);
		labelGD.grabExcessHorizontalSpace = true;
		labelGD.horizontalAlignment = GridData.END;
		labelGD.verticalAlignment = GridData.CENTER;
		labelGD.horizontalIndent = 0;
		label.setLayoutData(labelGD);
		
		Text text = new Text(groupInfo, SWT.BORDER|SWT.TRAIL);
		String id = DEFAULT_POPULATION_ID_PREFIX+(groupComposites.size());
		text.setText(id);
		GridData textGD = new GridData(GridData.FILL);
		textGD.grabExcessHorizontalSpace = true;
		textGD.horizontalAlignment = GridData.FILL;
		textGD.verticalAlignment = GridData.CENTER;
		text.setLayoutData(textGD);
		text.addModifyListener(projectValidator);
		groupIDComposites.add(text);
		
		label = new Label(groupInfo, SWT.NONE);
		label.setText(PopulationModelWizardMessages.getString("populationIdFraction"));
		labelGD = new GridData(GridData.END);
		labelGD.grabExcessHorizontalSpace = true;
		labelGD.horizontalAlignment = GridData.END;
		labelGD.verticalAlignment = GridData.CENTER;
		labelGD.horizontalIndent = 0;
		label.setLayoutData(labelGD);
		
		text = new Text(groupInfo, SWT.BORDER|SWT.TRAIL);
		
		double frac = Double.parseDouble(DEFAULT_POPULATION_FRACTION);
		double sum=0;for(Text t:groupFracComposites) {
			try {
			sum+=Double.parseDouble(t.getText());
			} catch(NumberFormatException pe) {
				// Ignore page will be invalidated
			}
		}
		if(frac+sum > 1.0)frac = 1.0-sum;
		if (frac <0)frac = 0.0;
		text.setText(frac+"");
		
		textGD = new GridData(GridData.FILL);
		textGD.grabExcessHorizontalSpace = true;
		textGD.horizontalAlignment = GridData.FILL;
		textGD.verticalAlignment = GridData.CENTER;
		text.setLayoutData(textGD);
		text.addModifyListener(projectValidator);
		groupFracComposites.add(text);
		groupInfo.pack();
		
//		this.removeAllGroups();
//		this.layoutAllGroups();
	}
	/**
	 * @param diseaseModel
	 *            the {@link DiseaseModel} instance to populate.
	 */
	@Override
	public void populate(final PopulationModel populationModel) {
		super.populate(populationModel);
		
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			if(populationModel instanceof StandardPopulationModel) {
				switch (entry.getKey().getFeatureID()) {
					case StandardPackage.STANDARD_POPULATION_MODEL__POPULATION_IDENTIFIER:
						((StandardPopulationModel)populationModel).setPopulationIdentifier(entry.getValue().getText());
						break;
					case StandardPackage.STANDARD_POPULATION_MODEL__NAME:
						((StandardPopulationModel)populationModel).setName(entry.getValue().getText());
						break;
					case StandardPackage.STANDARD_POPULATION_MODEL__BIRTH_RATE:
						((StandardPopulationModel)populationModel)
								.setBirthRate(Double.parseDouble(entry.getValue().getText().trim()));
						break;
					case StandardPackage.STANDARD_POPULATION_MODEL__DEATH_RATE:
						((StandardPopulationModel)populationModel)
						.setDeathRate(Double.parseDouble(entry.getValue().getText().trim()));
						break;
					case StandardPackage.STANDARD_POPULATION_MODEL__TIME_PERIOD:
						((StandardPopulationModel)populationModel)
						.setTimePeriod(Long.parseLong(entry.getValue().getText().trim()));
						break;
					default:
						break;
				}
			} else if (populationModel instanceof SeasonalPopulationModel) {
				switch (entry.getKey().getFeatureID()) {
					case StandardPackage.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE:
						((SeasonalPopulationModel)populationModel)
						.setModulationAmplitude(Double.parseDouble(entry.getValue().getText().trim()));
						break;
					case StandardPackage.SEASONAL_POPULATION_MODEL__PHASE:
						((SeasonalPopulationModel)populationModel)
						.setPhase(Double.parseDouble(entry.getValue().getText().trim()));
						break;
					default:
						break;	
				}
			} else if (populationModel instanceof MosquitoPopulationModel) {
				switch (entry.getKey().getFeatureID()) {
				case StandardPackage.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR:
					((MosquitoPopulationModel)populationModel)
					.setScalingFactor(Double.parseDouble(entry.getValue().getText().trim()));
					break;
				case StandardPackage.MOSQUITO_POPULATION_MODEL__TIME_PERIOD:
					((MosquitoPopulationModel)populationModel)
					.setTimePeriod((Long.parseLong(entry.getValue().getText().trim())));
					break;	
				default:
					break;
				}
			} // switch
		} // for each Map.entry
		
		if(populationModel instanceof DemographicPopulationModel) {
			DemographicPopulationModel dpm = (DemographicPopulationModel)populationModel;
			
			// Add groups	
			for(int i=0;i<groupIDComposites.size();++i) {
				PopulationGroup newGroup = StandardFactory.eINSTANCE.createPopulationGroup();
				String id = groupIDComposites.get(i).getText();
				double fr = Double.parseDouble(groupFracComposites.get(i).getText());
				newGroup.setIdentifier(id);
				newGroup.setFraction(fr);
				dpm.getPopulationGroups().add(newGroup);
			}
		}
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
					.get(StandardPackage.Literals.POPULATION_MODEL__POPULATION_IDENTIFIER);
			retValue = !text.getText().equals(""); //$NON-NLS-1$
			// nothing?
			if (!retValue) {
				// Yes
				errorMessage = PopulationModelWizardMessages.getString("NDizWizErr0"); //$NON-NLS-1$
			} // if
		} // if

		// 
		// Background mortality rate?
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.STANDARD_POPULATION_MODEL__DEATH_RATE);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr4"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value > 0?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = PopulationModelWizardMessages
								.getString("NDizWizErr5"); //$NON-NLS-1$
					} // if
				}
			}
		} // if Background mortality rate
		
		// 
		// birth rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.STANDARD_POPULATION_MODEL__BIRTH_RATE);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr6"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value > 0?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = PopulationModelWizardMessages
								.getString("NDizWizErr7"); //$NON-NLS-1$
					} // if
				}
			}
		} // if Background mortality rate

		// 
		// time period
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.STANDARD_POPULATION_MODEL__TIME_PERIOD);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr8"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value > 0?
					retValue = isValidLongValue(text.getText(), 0L);
					if (!retValue) {
						// No
						errorMessage = PopulationModelWizardMessages
								.getString("NDizWizErr9"); //$NON-NLS-1$
					} // if
				}
			}
		} // if  time period
		
		// birth rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.STOCHASTIC_STANDARD_POPULATION_MODEL__GAIN);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr10"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value > 0?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = PopulationModelWizardMessages
								.getString("NDizWizErr10"); //$NON-NLS-1$
					} // if
				}
			}
		} // if birth rate
		
		
		// modulation amplitude
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SEASONAL_POPULATION_MODEL__MODULATION_AMPLITUDE);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr18"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid double value between 0 and 1
					double testDouble = -1;
					try {
						testDouble = (new Double(text.getText())).doubleValue();
						if((testDouble < 0.0)||(testDouble >1.0)) {
							errorMessage = PopulationModelWizardMessages.getString("NDizWizErr18"); //$NON-NLS-1$
						}
					} catch(Exception e) {
						errorMessage = PopulationModelWizardMessages.getString("NDizWizErr18"); //$NON-NLS-1$
					}
				}
			}
		} // modulation amplitude
		
		// phase
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SEASONAL_POPULATION_MODEL__PHASE);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr19"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid double (any value is ok)
					@SuppressWarnings("unused")
					double testDouble = -1;
					try {
						testDouble = (new Double(text.getText())).doubleValue();
					} catch(Exception e) {
						errorMessage = PopulationModelWizardMessages.getString("NDizWizErr19"); //$NON-NLS-1$
					}
				}
			}
		} // phase
		
		
		//scaling factor
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.MOSQUITO_POPULATION_MODEL__SCALING_FACTOR);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr20"); //$NON-NLS-1$
				} // if
				else {
					try {
						double testDouble = (new Double(text.getText())).doubleValue();
					} catch(Exception e) {
						errorMessage = PopulationModelWizardMessages.getString("NDizWizErr20"); //$NON-NLS-1$
						retValue = false;
					}
				}
			}
		} // modulation amplitude
		
		//scaling factor
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.MOSQUITO_POPULATION_MODEL__TIME_PERIOD);
			if(text != null) {
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr21"); //$NON-NLS-1$
				} // if
				else {
					try {
						long testLong = (new Long(text.getText())).longValue();
					} catch(Exception e) {
						errorMessage = PopulationModelWizardMessages.getString("NDizWizErr21"); //$NON-NLS-1$
						retValue = false;
					}
				}
			}
		} // modulation amplitude
		
		// Check that the group fractions add up to < 1.0
		
		if(retValue) {
			double sum = 0;
			for(Text t:groupFracComposites) {
				if(!isValidValue(t.getText(), 0)) {
					retValue = false;
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr13"); //$NON-NLS-1$
					break;
				}
				sum+=Double.parseDouble(t.getText());
			}
			if(sum > 1.0) {
				retValue = false;
				errorMessage = PopulationModelWizardMessages.getString("NDizWizErr11"); //$NON-NLS-1$
			}
		}
		// Check group IDs
		
		if(retValue) {
			for(Text t:groupIDComposites) {
				if(t.getText().trim().equals("")) {
					retValue = false;
					errorMessage = PopulationModelWizardMessages.getString("NDizWizErr12"); //$NON-NLS-1$
					break;
				}
			}
		}
		
		return retValue;
	} // validate

} // StandardPropertyModelPropertyEditor

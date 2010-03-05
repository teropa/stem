// InfectorDefinitionControl.java
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

import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.data.geography.GeographicMapper;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * This class represents the SWT composite that provides the GUI for defining an
 * {@link org.eclipse.stem.diseasemodels.standard.Infector} in the
 * {@link NewInfectorWizard}.
 */
public class InfectorDefinitionComposite extends Composite {

	// private static final URI LEVEL_0_ISO_NAME_FILE_URI = URI
	// .createURI("platform:/plugin/org.eclipse.stem.geography/resources/data/country/ZZZ/level0ISONames.properties");

	private final ISOKeyPicker isoKeyPicker2;
	private final ISOKeyPicker isoKeyPicker1;
	private final ISOKeyPicker isoKeyPicker0;
	private final ISOKeyPicker isoKeyPicker3;
	private String isoKey = ""; //$NON-NLS-1$

	private String tempISOKey = null;

	private final Text numberOfInfectionsText;

	private final Text populationText;

	private final Text diseaseNameText;
	
	private Label numberOfInfectionsLabel;

	private String errorMessage;
	
	/**
	 * Radio buttons to specify if the wizard will create an infector
	 * or an inoculator.
	 */
	private Button[] infectorModeRadioButtons = new Button[2];
	
	private Button useAbsoluteNumberButton = null;
	private Button usePercentageButton = null;
	
	/** 
	 * keep track of the mode.
	 * infector by default
	 */
	private boolean infectorMode = true;
	
	/**
	 * keep track of percentage or absolute number
	 */
	private boolean percentage = false;


	/**
	 * @param parent
	 * @param style
	 */
	public InfectorDefinitionComposite(final Composite parent, final int style,
			final ModifyListener projectValidator) {
		super(parent, style);
		
		setLayout(new FormLayout());
		
		final int margin1 = 35;
		final int margin2 = 25;
		
		// radio buttons to set the mode
		Composite infectorModeComposite = createInfectorModeRadioButtonsComposite(this);
		final FormData fd_infectorMode = new FormData();
		fd_infectorMode.top = new FormAttachment(0, 0);
		fd_infectorMode.bottom = new FormAttachment(5, 0);
		fd_infectorMode.left = new FormAttachment(0, 0);
		fd_infectorMode.right = new FormAttachment(100, 0);
		infectorModeComposite.setLayoutData(fd_infectorMode);

		Composite percentModeComposite = createPercentModeRadioButtonsComposite(this);
		final FormData fd_percentMode = new FormData();
		fd_percentMode.top = new FormAttachment(infectorModeComposite, 5, SWT.BOTTOM);
		fd_percentMode.left = new FormAttachment(0, 0);
		fd_percentMode.right = new FormAttachment(100, 0);
		percentModeComposite.setLayoutData(fd_percentMode);

		// Disease Name
		final Label diseaseNameLabel = new Label(this, SWT.NONE);
		final FormData fd_diseaseNameLabel = new FormData();
		fd_diseaseNameLabel.left = new FormAttachment(0, 0);
		fd_diseaseNameLabel.right = new FormAttachment(margin1, 0);
		fd_diseaseNameLabel.top = new FormAttachment(percentModeComposite, 5, SWT.BOTTOM);
		diseaseNameLabel.setLayoutData(fd_diseaseNameLabel);
		diseaseNameLabel.setText(DiseaseWizardMessages.getString("NInfWizDN")); //$NON-NLS-1$

		diseaseNameText = new Text(this, SWT.BORDER);
		diseaseNameText.setToolTipText(DiseaseWizardMessages.getString("NInfWizDNTT")); //$NON-NLS-1$
		diseaseNameText.addModifyListener(projectValidator);
		
		final FormData fd_diseaseNameText = new FormData();
		fd_diseaseNameText.left = new FormAttachment(diseaseNameLabel, 0);
		fd_diseaseNameText.right = new FormAttachment(100, 0);
		fd_diseaseNameText.top = new FormAttachment(percentModeComposite, 5, SWT.BOTTOM);
		diseaseNameText.setLayoutData(fd_diseaseNameText);
		

		// Population
		final Label populationLabel = new Label(this, SWT.NONE);
		final FormData fd_populationLabel = new FormData();
		fd_populationLabel.left = new FormAttachment(0, 0);
		fd_populationLabel.right = new FormAttachment(margin1, 0);
		fd_populationLabel.top = new FormAttachment(diseaseNameLabel, 5, SWT.BOTTOM);
		populationLabel.setLayoutData(fd_populationLabel);
		populationLabel.setText(DiseaseWizardMessages.getString("NInfWizPOP")); //$NON-NLS-1$

		populationText = new Text(this, SWT.BORDER);
		populationText.setText(StandardPackage.Literals.DISEASE_MODEL__POPULATION_IDENTIFIER.getDefaultValueLiteral());
		populationText.setToolTipText(DiseaseWizardMessages.getString("NInfWizPOPTT")); //$NON-NLS-1$
		populationText.addModifyListener(projectValidator);
		
		final FormData fd_populationText = new FormData();
		fd_populationText.top = new FormAttachment(diseaseNameLabel, 5, SWT.BOTTOM);
		fd_populationText.left = new FormAttachment(populationLabel, 0);
		fd_populationText.right = new FormAttachment(100, 0);
		populationText.setLayoutData(fd_populationText);
		

		// Number of Infections
		numberOfInfectionsLabel = new Label(this, SWT.NONE);
		numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNI")); //$NON-NLS-1$

		final FormData fd_numberOfInfectionsLabel = new FormData();
		fd_numberOfInfectionsLabel.top = new FormAttachment(populationLabel,5, SWT.BOTTOM);
		fd_numberOfInfectionsLabel.left = new FormAttachment(0, 0);
		fd_numberOfInfectionsLabel.right = new FormAttachment(margin1, 0);
		numberOfInfectionsLabel.setLayoutData(fd_numberOfInfectionsLabel);
		
		numberOfInfectionsText = new Text(this, SWT.BORDER);
		numberOfInfectionsText.setText(StandardPackage.Literals.SI_INFECTOR__INFECTIOUS_COUNT.getDefaultValueLiteral());
		numberOfInfectionsText.setToolTipText(DiseaseWizardMessages.getString("NInfWizNITT")); //$NON-NLS-1$
		numberOfInfectionsText.addModifyListener(projectValidator);
		
		final FormData fd_numberOfInfectionsText = new FormData();
		fd_numberOfInfectionsText.left = new FormAttachment(numberOfInfectionsLabel, 0);
		fd_numberOfInfectionsText.right = new FormAttachment(100, 0);
		fd_numberOfInfectionsText.top = new FormAttachment(populationLabel, 5, SWT.BOTTOM);
		numberOfInfectionsText.setLayoutData(fd_numberOfInfectionsText);
		

		// ISO Key
		final Label isoKeyLabel = new Label(this, SWT.NONE);
		isoKeyLabel.setText(DiseaseWizardMessages.getString("NInfWizISOK")); //$NON-NLS-1$
		
		final FormData fd_isoKeyLabel = new FormData();
		fd_isoKeyLabel.top = new FormAttachment(numberOfInfectionsLabel, 5, SWT.BOTTOM);
		fd_isoKeyLabel.left = new FormAttachment(0, 0);
		fd_isoKeyLabel.right = new FormAttachment(margin2, 0);
		isoKeyLabel.setLayoutData(fd_isoKeyLabel);
		

		final Label isokeyValueLabel = new Label(this, SWT.NONE);
		isokeyValueLabel.setText(isoKey);

		final FormData fd_isokeyValueLabel = new FormData();
		fd_isokeyValueLabel.top = new FormAttachment(numberOfInfectionsLabel, 5, SWT.BOTTOM);
		fd_isokeyValueLabel.left = new FormAttachment(isoKeyLabel, 0);
		fd_isokeyValueLabel.right = new FormAttachment(100, 0);
		isokeyValueLabel.setLayoutData(fd_isokeyValueLabel);
		
		// ISOKeyPicker 0
		isoKeyPicker0 = new ISOKeyPicker(this, SWT.NONE, 0);
		isoKeyPicker0.setISOKeyLevel(0);
		isoKeyPicker0.setISOKeyLevelDescription(DiseaseWizardMessages.getString("NInfWizCNTRY"));
		isoKeyPicker0.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				final Object[] isoKeys = GeographicNames.getSubISOKeys(
						GeographicNames.getAlpha2(ikpe.getIsoKey()),
						isoKeyPicker1.getISOKeyLevel());
				isoKeyPicker1.setISOKeys(isoKeys);
				isoKeyPicker2.setISOKeys(new Object[] {});
				isoKeyPicker3.setISOKeys(new Object[] {});
				isoKey = ikpe.getIsoKey();
				tempISOKey = isoKey;
				isokeyValueLabel.setText(isoKey);
			}
		});
		
		// ISOKeyPicker 1
		isoKeyPicker1 = new ISOKeyPicker(this, SWT.NONE, 1);
		isoKeyPicker1.setISOKeyLevelDescription(DiseaseWizardMessages
				.getString("NInfWizL1"));
		isoKeyPicker1.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				final Object[] isoKeys = GeographicNames.getSubISOKeys(ikpe
						.getIsoKey(), isoKeyPicker2.getISOKeyLevel());
				isoKeyPicker2.setISOKeys(isoKeys);
				isoKey = ikpe.getIsoKey();
				tempISOKey = tempISOKey == null ? isoKey : tempISOKey;
				// Were there any ISO keys to set?
				if (isoKeys.length == 0) {
					// No
					isoKey = tempISOKey;
					isokeyValueLabel.setText(isoKey);
					tempISOKey = null;
				} // if
			}
		});
		
		// ISOKeyPicker 2
		isoKeyPicker2 = new ISOKeyPicker(this, SWT.NONE, 2);
		isoKeyPicker2.setISOKeyLevelDescription(DiseaseWizardMessages
				.getString("NInfWizL2"));
		isoKeyPicker2.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				final Object[] isoKeys = GeographicNames.getSubISOKeys(ikpe
						.getIsoKey(), isoKeyPicker3.getISOKeyLevel());
				isoKeyPicker3.setISOKeys(isoKeys);
				isoKey = ikpe.getIsoKey();
				tempISOKey = tempISOKey == null ? isoKey : tempISOKey;
				// Were there any ISO keys to set?
				if (isoKeys.length == 0) {
					// No
					isoKey = tempISOKey;
					isokeyValueLabel.setText(isoKey);
					tempISOKey = null;
				} // if
			}
		});
		
		// ISOKeyPicker 3
		isoKeyPicker3 = new ISOKeyPicker(this, SWT.NONE, 3);
		isoKeyPicker3.setISOKeyLevelDescription(DiseaseWizardMessages
				.getString("NInfWizL3"));
		isoKeyPicker3.addISOKeyPickedListener(new ISOKeyPickedEventListener() {
			public void isoKeyPicked(final ISOKeyPickedEvent ikpe) {
				isoKey = tempISOKey == null ? ikpe.getIsoKey() : tempISOKey;
				isokeyValueLabel.setText(isoKey);
				tempISOKey = null;
			}
		});
		
		
		//   FORM DATA   //
		
		// ISO Picker0
		final FormData fd_isoKeyPicker0 = new FormData();
		fd_isoKeyPicker0.top = new FormAttachment(isoKeyLabel, 5, SWT.BOTTOM);
		fd_isoKeyPicker0.right = new FormAttachment(100, 0);
		fd_isoKeyPicker0.left = new FormAttachment(0, 0);
		isoKeyPicker0.setLayoutData(fd_isoKeyPicker0);
		isoKeyPicker0.setISOKeys(GeographicNames.getSubISOKeys(
				GeographicMapper.EARTH_ALPHA3_ISO_KEY, -1));

		// ISOKeyPicker 1		
		final FormData fd_isoKeyPicker1 = new FormData();
		fd_isoKeyPicker1.top = new FormAttachment(isoKeyPicker0, 5, SWT.BOTTOM);
		fd_isoKeyPicker1.left = new FormAttachment(isoKeyPicker0, 0, SWT.LEFT);
		fd_isoKeyPicker1.right = new FormAttachment(isoKeyPicker0, 0, SWT.RIGHT);
		isoKeyPicker1.setLayoutData(fd_isoKeyPicker1);
		
		// ISOKeyPicker 2
		final FormData fd_isoKeyPicker2 = new FormData();
		fd_isoKeyPicker2.top = new FormAttachment(isoKeyPicker1, 5, SWT.BOTTOM);
		fd_isoKeyPicker2.left = new FormAttachment(isoKeyPicker0, 0, SWT.LEFT);
		fd_isoKeyPicker2.right = new FormAttachment(isoKeyPicker0, 0, SWT.RIGHT);
		isoKeyPicker2.setLayoutData(fd_isoKeyPicker2);
	
		// ISOKeyPicker 3
		final FormData fd_isoKeyPicker3 = new FormData();
		fd_isoKeyPicker3.top = new FormAttachment(isoKeyPicker2, 5, SWT.BOTTOM);
		fd_isoKeyPicker3.left = new FormAttachment(isoKeyPicker0, 0, SWT.LEFT);
		fd_isoKeyPicker3.right = new FormAttachment(isoKeyPicker0, 0, SWT.RIGHT);
		//fd_isoKeyPicker3.bottom = new FormAttachment(100, -5);
		isoKeyPicker3.setLayoutData(fd_isoKeyPicker3);
		// getShell().pack();
	}// InfectorDefinitionControl

	
	/**
	 * creates a set of radio buttons and their composite container for the user to specify
	 * the creation of an infector OR an inoculator
	 * @param parent
	 * @return the composite
	 */
	Composite createInfectorModeRadioButtonsComposite(final Composite parent) {
		Composite radioComposite = new Composite(parent, SWT.BORDER);
	    FillLayout fillLayout = new FillLayout();
	    fillLayout.type = SWT.VERTICAL;
	    radioComposite.setLayout(fillLayout);
	    
	    infectorModeRadioButtons[0] = new Button(radioComposite, SWT.RADIO);
	    infectorModeRadioButtons[0].setSelection(true);
	    infectorModeRadioButtons[0].setText(DiseaseWizardMessages.getString("NInfectorWiz.infect"));//$NON-NLS-1$
	    
	    infectorModeRadioButtons[1] = new Button(radioComposite, SWT.RADIO);
	    infectorModeRadioButtons[1].setText(DiseaseWizardMessages.getString("NInfectorWiz.inoculate"));//$NON-NLS-1$
	    	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	          if (event.widget == infectorModeRadioButtons[0]) {
	        	infectorMode = infectorModeRadioButtons[0].getSelection();
	          }
	        }
	      };
	      // these are radio buttons so we only need to add the listener to one of them.
	      infectorModeRadioButtons[0].addListener(SWT.Selection, listener);
	      
	    return radioComposite;
	}//getinfectorModeRadioButtonsComposite
	
	/**
	 * @param parent
	 * @return the composite
	 */
	Composite createPercentModeRadioButtonsComposite(final Composite parent) {
	    Composite radio2Composite = new Composite(parent, SWT.BORDER);
	    FillLayout fillLayout2 = new FillLayout();
	    fillLayout2.type = SWT.VERTICAL;
	    radio2Composite.setLayout(fillLayout2);
	    
	    
	    useAbsoluteNumberButton = new Button(radio2Composite, SWT.RADIO);
	    useAbsoluteNumberButton.setSelection(true);
	    useAbsoluteNumberButton.setText(DiseaseWizardMessages.getString("NInfWiz.absnumber"));
	    
	    usePercentageButton = new Button(radio2Composite, SWT.RADIO);
	    usePercentageButton.setText(DiseaseWizardMessages.getString("NInfWiz.percentage"));
	    
	    Listener listener = new Listener() {
	        public void handleEvent(Event event) {
	          if(event.widget == useAbsoluteNumberButton || event.widget == usePercentageButton) {
		          // toggle the wizard
	        	  percentage = usePercentageButton.getSelection();
		          if(!percentage) {
		        	  numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizNI")); //$NON-NLS-1$
		          } else {
		        	  numberOfInfectionsLabel.setText(DiseaseWizardMessages.getString("NInfWizPI")); //$NON-NLS-1$
		          }
		          // clear the text because we need to revalidate
		          numberOfInfectionsText.setText("");
	          }
	        }
	      };
	      // these are radio buttons so we only need to add the listener to one of them.
	      useAbsoluteNumberButton.addListener(SWT.Selection, listener);
	      
	    return radio2Composite;
	}//getinfectorModeRadioButtonsComposite


	/**
	 * @return <code>true</code> if the contents of the control are valid,
	 *         <code>false</code> otherwise.
	 */
	public boolean validate() {
		boolean retValue = true;
		// Disease Name?
		if (getDiseaseName() == null || getDiseaseName().equals("")) { //$NON-NLS-1$
			// Yes
			errorMessage = DiseaseWizardMessages.getString("NInfWizError.1"); //$NON-NLS-1$
			retValue = false;
		} // if

		// Population
		if (retValue) {
			// Yes
			if (getPopulation() == null || getPopulation().equals("")) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.2"); //$NON-NLS-1$
				retValue = false;
			} // if
		} // if

		// Number of infections
		if (retValue) {
			// Yes
			if (numberOfInfectionsText.getText() == null
					|| numberOfInfectionsText.getText().equals("")) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.3"); //$NON-NLS-1$
				retValue = false;
			} // if
			else {
				// No
				try {
					final double temp = Double
							.parseDouble(numberOfInfectionsText.getText());
					// > 0?
					if (temp <= 0.0) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NInfWizError.4"); //$NON-NLS-1$
						retValue = false;
					} // if
					
					// is this an innoculation wizard
					if(!isInfectorMode()) {
						// yes, then this must be a percentage
						if(temp > 100.0) {
							errorMessage = DiseaseWizardMessages.getString("NInfWizError.8"); //$NON-NLS-1$
							retValue = false;
						}
						
					}
				} catch (final NumberFormatException e) {
					errorMessage = DiseaseWizardMessages
							.getString("NInfWizError.5"); //$NON-NLS-1$
					retValue = false;
				} // catch NumberFormatException
			}
		} // if numberOfInfections

		// ISO Key
		if (retValue) {
			// Yes
			if (getIsoKey() == null || getIsoKey().equals("")) { //$NON-NLS-1$
				// Yes
				errorMessage = DiseaseWizardMessages
						.getString("NInfWizError.6"); //$NON-NLS-1$
				retValue = false;
			} // if
		} // if

		return retValue;
	} // validate

	/**
	 * @return the error message set by {@link #validate()}
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	// private String getName(String isoKey, int level) {
	// return GeographicNames.getName(isoKey, level);
	// } // getName

	

	/**
	 * access the infectorMode
	 * if true create and infector
	 * if false creates and inoculator
	 */
	public boolean isInfectorMode() {
		return infectorMode;
	}
	
	/**
	 * @return the isoKey that specifies the location to be infected.
	 */
	public final String getIsoKey() {
		return isoKey;
	}

	/**
	 * @return the NLS'd name of the location selected as the point of infection
	 */
	public final String getLocationName() {
		// TODO need to return the NLS string here.
		return getIsoKey();
	}

	/**
	 * @return the name of the disease
	 */
	public final String getDiseaseName() {
		return diseaseNameText.getText();
	}

	/**
	 * @return the name of the population being infected
	 */
	public final String getPopulation() {
		return populationText.getText();
	}

	/**
	 * @return the number of infections
	 */
	public double getNumber() {
		try {
			return Double.parseDouble(numberOfInfectionsText.getText());
		} catch (final NumberFormatException e) {
			Activator.logError(DiseaseWizardMessages
					.getString("NInfWizError.7"), e); //$NON-NLS-1$
			return 0.0;
		} // catch NumberFormatException
	}
	


	public boolean isPercentage() {
		return percentage;
	}

} // InfectorDefinitionComposite

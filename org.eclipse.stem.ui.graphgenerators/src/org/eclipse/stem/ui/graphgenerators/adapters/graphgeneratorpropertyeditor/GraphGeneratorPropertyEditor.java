package org.eclipse.stem.ui.graphgenerators.adapters.graphgeneratorpropertyeditor;

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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.LatticeGraphGenerator;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.stem.ui.graphgenerators.wizards.Messages;
import org.eclipse.stem.ui.widgets.MatrixEditorDialog;
import org.eclipse.stem.ui.widgets.MatrixEditorWidget.MatrixEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class GraphGeneratorPropertyEditor extends Composite {
	protected final Map<EStructuralFeature, Text> map = new HashMap<EStructuralFeature, Text>();
	protected final Map<EStructuralFeature, String[]> matrixMap = new HashMap<EStructuralFeature, String[]>();
	protected final Map<EStructuralFeature, Boolean> booleanMap = new HashMap<EStructuralFeature, Boolean>();

	protected String errorMessage;

	public GraphGeneratorPropertyEditor(Composite parent, int style) {
		super(parent,style);
	}

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public GraphGeneratorPropertyEditor(final Composite parent, final int style,
			final GraphGenerator graphGenerator,
			final ModifyListener projectValidator) {
		super(parent, style);

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		setLayout(gridLayout);

		// Get the adapter that will provide NLS'd names for the
		// properties of the disease model
		final PropertyStringProviderAdapter pspa = (PropertyStringProviderAdapter) PropertyStringProviderAdapterFactory.INSTANCE
				.adapt(graphGenerator, PropertyStringProvider.class);

		final ComposedAdapterFactory itemProviderFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IItemPropertySource propertySource = (IItemPropertySource) itemProviderFactory
				.adapt(graphGenerator, IItemPropertySource.class);
		final List<IItemPropertyDescriptor> properties = propertySource
				.getPropertyDescriptors(graphGenerator);

		for (final IItemPropertyDescriptor descriptor : properties) {
			final EStructuralFeature feature = (EStructuralFeature) descriptor
					.getFeature(null);
			// Is this a disease model property that the user should specify?
			boolean isDataPath = false;
			if (isUserSpecifiedGraphGeneratorProperty(feature)) {
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
				    falseButton.setText(Messages.getString("NO"));//$NON-NLS-1$
				    
				    Button trueButton = new Button(radioComposite, SWT.RADIO);
				    trueButton.setText(Messages.getString("YES"));//$NON-NLS-1$
				    	    
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

				
				
					Text text = null;
					
					if(isListOrMap(feature))
						handleListOrMap(feature);
					
					else {
						text = new Text(this, SWT.BORDER | SWT.TRAIL);
						text.setText(defaultValueString);
						text.setToolTipText(pspa.getPropertyToolTip(descriptor));
						map.put(feature, text);
		
						final GridData textGD = new GridData(GridData.END);
						textGD.grabExcessHorizontalSpace = true;
						textGD.horizontalAlignment = SWT.FILL;
						text.setLayoutData(textGD);
		
						text.addModifyListener(projectValidator);
					}
					
					if (feature.getName().equals("dataPath")) { //$NON-NLS-1$
						isDataPath = true;
						final Composite buttons = new Composite(this, SWT.NONE);
						final RowLayout buttonsLayout = new RowLayout();
						buttonsLayout.marginTop = 0;
						buttonsLayout.marginBottom = 0;
						buttons.setLayout(buttonsLayout);
						final Shell shell = this.getShell();
	
						final Button fileChooserButton = new Button(buttons,
								SWT.NONE);
						fileChooserButton.setText(Messages
								.getString("fileChooserButtonText")); //$NON-NLS-1$
						fileChooserButton.setToolTipText(Messages
								.getString("fileChooserButtonTooltipText")); //$NON-NLS-1$
						final Text _text=text;
						fileChooserButton
								.addSelectionListener(new SelectionAdapter() {
									@Override
									public void widgetSelected(
											final SelectionEvent e) {
										final FileDialog fd = new FileDialog(shell,
												SWT.OPEN | SWT.MULTI);
										fd
												.setText(Messages
														.getString("fileChooserDialogTitle")); //$NON-NLS-1$
										final String[] extensionsFilter = {
												"*.txt", "*.csv" };
										fd.setFilterExtensions(extensionsFilter);
	
										// String format for single selected file
										// will be:
										// "path/file_name"
										// For multi-files the format will be:
										// "path/file_name1" "file_name2"
										// "file_name3"...
	
										String selected = "\"" + fd.open() + "\"";
										final String[] selectedFiles = fd
												.getFileNames();
										if (selectedFiles.length > 1) { // if
											// multi-files
											// selected
											for (int i = 1; i < selectedFiles.length; i++) {
												selected += " \""
														+ selectedFiles[i] + "\"";
											}
										}
										_text.setText(selected);
									} // widgetSelected
								} // SelectionAdapter
								);
	
						final Button dirChooserButton = new Button(buttons,
								SWT.NONE);
						dirChooserButton.setText(Messages
								.getString("dirChooserButtonText")); //$NON-NLS-1$
						dirChooserButton.setToolTipText(Messages
								.getString("dirChooserButtonTooltipText")); //$NON-NLS-1$
						dirChooserButton
								.addSelectionListener(new SelectionAdapter() {
									@Override
									public void widgetSelected(
											final SelectionEvent e) {
										final DirectoryDialog dd = new DirectoryDialog(
												shell, SWT.OPEN);
										dd
												.setText(Messages
														.getString("dirChooserDialogTitle")); //$NON-NLS-1$
										final String selected = dd.open();
										_text.setText(selected);
									} // widgetSelected
								} // SelectionAdapter
								);
	
						final GridData fileBtnGD = new GridData(GridData.END);
						// fileChooserButton.setLayoutData(fileBtnGD);
						buttons.setLayoutData(fileBtnGD);
					}
				} // is not boolean
				if (!isDataPath) {
					final Label unitLabel = new Label(this, SWT.NONE);
					unitLabel.setText(pspa.getPropertyUnits(descriptor));
					final GridData unitLabelGD = new GridData(GridData.END);
					unitLabelGD.verticalAlignment = GridData.CENTER;
					unitLabel.setLayoutData(unitLabelGD);
				}

			} // if user specified
		} // for each disease model property

	} // GraphGeneratorPropertyEditor

	private void handleListOrMap(final EStructuralFeature feature) {
		Button button = new Button(this, SWT.NONE);
		Image image = null;
		final EClassifier type = feature.getEType();
		
		if (type.getClassifierID() == CommonPackage.DOUBLE_VALUE_LIST ||
		type.getClassifierID() == CommonPackage.STRING_VALUE_LIST)
			image = AbstractUIPlugin.imageDescriptorFromPlugin(
				"org.eclipse.stem.ui", "/icons/full/customobj16/List.gif").createImage();
		else
			image = AbstractUIPlugin.imageDescriptorFromPlugin(
					"org.eclipse.stem.ui", "/icons/full/customobj16/Matrix.gif").createImage();
		
		button.setImage(image);
		final GridData buttonGD = new GridData(GridData.END);
		//buttonGD.grabExcessHorizontalSpace = true;
		//buttonGD.horizontalAlignment = SWT.FILL;
		button.setLayoutData(buttonGD);
		
		button.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				String title=null;
				short cols=0;
				short rows=0;
				String [] rownames=null;
				String [] colnames=null;
				boolean fixedSize=false;
				MatrixEditorValidator validator = null;
				String [] existingVals=null;
				
				// Retrieve any already entered values
				if(matrixMap.get(feature)!=null) {
					existingVals = matrixMap.get(feature);
				}
				
				if(type.getClassifierID() == CommonPackage.DOUBLE_VALUE_LIST ||
						type.getClassifierID() == CommonPackage.STRING_VALUE_LIST) {
					fixedSize = getFixedSize(feature);
					title = feature.getName();
					cols = 1;
					rows = getRowCount(feature);
					if(!fixedSize && rows == 0)
						rows = (existingVals != null)? (short)existingVals.length:(short)1;
					
					rownames = getRowNames(feature);
					colnames = new String[1];colnames[0]=feature.getName();
					
				} else if(type.getClassifierID() == CommonPackage.DOUBLE_VALUE_MATRIX) {
					title = feature.getName();
					cols = getColCount(feature);
					rows = getRowCount(feature);
					rownames = getRowNames(feature);
					colnames = rownames;
					fixedSize = getFixedSize(feature);
				}
				
				validator = getValidator(feature);
				

				// Pre-populate with 0 (default from EMF not possible since it's a reference)
				if(existingVals == null && (type.getClassifierID() == CommonPackage.DOUBLE_VALUE_LIST || type.getClassifierID() == CommonPackage.DOUBLE_VALUE_MATRIX)) {
					existingVals = new String[cols*rows];
					for(int i=0;i<cols*rows;++i) existingVals[i]="0.0";
				}

				Shell shell = GraphGeneratorPropertyEditor.this.getShell();
				MatrixEditorDialog dialog = new MatrixEditorDialog(shell, SWT.NONE, title, rows, cols, rownames, colnames, existingVals,fixedSize,validator);
				
				String []res = dialog.open();
				
				if(res!=null) {
					matrixMap.put(feature, res);
				}
				
			}
			

			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * getValidator. These are generic validators for strings and doubles. Override in 
	 * subclass for more advanced validation (>0 etc.)
	 * @param feature
	 * @return
	 */
	public MatrixEditorValidator getValidator(EStructuralFeature feature) {
		EClassifier type = feature.getEType();
		MatrixEditorValidator validator=null;
		if(type.getClassifierID() == CommonPackage.DOUBLE_VALUE_LIST ||
				type.getClassifierID() == CommonPackage.DOUBLE_VALUE_MATRIX) 
			validator = new MatrixEditorValidator() {
				
				public boolean validateValue(String val) {
					if(val == null || val.trim().equals("")) return false;
					try {
						Double.parseDouble(val.trim());
					} catch(NumberFormatException nfe) {
						return false;
					}
					return true;
				}
		};			
		else if(type.getClassifierID() == CommonPackage.STRING_VALUE_LIST)
			validator = new MatrixEditorValidator() {
			
			public boolean validateValue(String val) {
				if(val == null || val.trim().equals("")) return false;
				return true;
			}
		};	
		return validator;
	}
	/**
	 * These are overriden by subclass
	 */
	public short getColCount(EStructuralFeature feature) {
		return 1;
	}

	public boolean getFixedSize(EStructuralFeature feature) {
		return false;
	}

	public String[] getRowNames(EStructuralFeature feature) {
		return null;
	}
	
	public String[] getColNames(EStructuralFeature feature) {
		return null;
	}
	
	public short getRowCount(EStructuralFeature feature) {
		return 1;
	}
	
	private boolean isListOrMap(EStructuralFeature feature) {
		EClassifier type = feature.getEType();
		if(type.getClassifierID() == CommonPackage.DOUBLE_VALUE_LIST ||
				type.getClassifierID() == CommonPackage.STRING_VALUE_LIST ||
				type.getClassifierID() == CommonPackage.DOUBLE_VALUE_MATRIX)
			return true;
		else
		return false;
	}

	/**
	 * @param graphGenerator
	 *            the {@link GraphGenerator} instance to populate.
	 */
	public Graph getGraph(final GraphGenerator graphGenerator) {
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			
			switch (entry.getKey().getFeatureID()) {
				case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__XSIZE:
					((LatticeGraphGenerator)graphGenerator).setXSize(Integer.parseInt(entry.getValue().getText()));
					break;
				case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__YSIZE:
					((LatticeGraphGenerator)graphGenerator).setYSize(Integer.parseInt(entry.getValue().getText()));
					break;
			}
			
		}
		
		for (final Map.Entry<EStructuralFeature, Boolean> entry : booleanMap.entrySet()) {
				
				switch (entry.getKey().getFeatureID()) {
					case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
						((LatticeGraphGenerator)graphGenerator).setUseNearestNeighbors(entry.getValue().booleanValue());
						break;
					case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
						((LatticeGraphGenerator)graphGenerator).setUseNextNearestNeighbors(entry.getValue().booleanValue());
						break;
					case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
						((LatticeGraphGenerator)graphGenerator).setPeriodicBoundaries(entry.getValue().booleanValue());
						break;
				}
		}
			
		// Do it!
		return graphGenerator.getGraph();
	} // populate

	/**
	 * @return <code>true</code> if the contents are valid, <code>false</code>
	 *         otherwise.
	 */
	public boolean validate() {
		boolean retValue = true;
		// Transmission Rate
		/*
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__TRANSMISSION_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr6"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr7"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // if Transmission Rate

		// Non-Linearity Coefficient
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__NON_LINEARITY_COEFFICIENT);
			if (text != null) {
				// Yes

				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr8"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr9"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // if Non-Linearity Coefficient

		// Infectious Recovery Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__RECOVERY_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr10"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr11"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Infectious Recovery Rate

		// Infectious Mortality Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SI__INFECTIOUS_MORTALITY_RATE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr12"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr13"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Infectious Mortality Rate

		// Immunity Loss Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SIR__IMMUNITY_LOSS_RATE);
			// specified?
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr16"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr17"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Immunity Loss Rate

		// Incubation Rate
		if (retValue) {
			// Yes
			final Text text = map
					.get(StandardPackage.Literals.SEIR__INCUBATION_RATE);
			if (text != null) {
				// Yes

				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = DiseaseWizardMessages
							.getString("NDizWizErr18"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0.0);
					if (!retValue) {
						// No
						errorMessage = DiseaseWizardMessages
								.getString("NDizWizErr19"); //$NON-NLS-1$
					} // if
				}
			} // if
		} // if Incubation Rate
*/
		return retValue;
	} // validate


	/**
	 * @param feature
	 * @return <code>true</code> if the feature is a dublin core feature that
	 *         is specified by a user.
	 */
	public static boolean isUserSpecifiedGraphGeneratorProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		final EClass containingClass = feature.getEContainingClass();
		// Is it a disease model property?
		if (containingClass.equals(GraphgeneratorsPackage.eINSTANCE.getGraphGenerator())
				|| containingClass.getEAllSuperTypes().contains(
						GraphgeneratorsPackage.eINSTANCE.getGraphGenerator())) {
			// Yes
			retValue = true;
		} // if a disease model property
		return retValue;
	} // isUserSpecifiedGraphGeneratorProperty




	/**
	 * @param text
	 * @param minValue
	 * @return
	 */
	private boolean isValidLongValue(final String text, final int minValue) {
		boolean retValue = true;
		try {
			final double value = Long.parseLong(text);
			retValue = value >= minValue;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	}

	/**
	 * @param text
	 * @return
	 */
	protected boolean isValidPercentage(final String text) {
		boolean retValue = true;
		try {
			final double value = Double.parseDouble(text);
			retValue = value >= 0.0 && value <= 100.;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	}

	/**
	 * @param text
	 * @param minValue
	 * @return
	 */
	protected boolean isValidValue(final String text, final double minValue) {
		boolean retValue = true;
		try {
			final double value = Double.parseDouble(text);
			retValue = value >= minValue;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	} // isValidRate

	/**
	 * @param text
	 * @param minValue
	 * @return
	 */
	protected boolean isValidRelativeTolerance(final String text, final double maxValue) {
		boolean retValue = true;
		try {
			final double value = Double.parseDouble(text);
			retValue = value <= maxValue && value > 0.0;
		} catch (final NumberFormatException nfe) {
			retValue = false;
		} // catch ParseException
		return retValue;
	} // isValidRate
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

	/**
	 * @param descriptor
	 * @return the string that represents the default value of the property
	 */
	protected String getPropertyDefaultValueString(final IItemPropertyDescriptor descriptor) {
		String retValue = ""; //$NON-NLS-1$
	
/*		final EStructuralFeature feature = (EStructuralFeature) descriptor
				.getFeature(null);
	
		switch (feature.getFeatureID()) {
		case StandardPackage.DISEASE_MODEL__TIME_PERIOD:
			feature.getDefaultValue();
			retValue = feature.getDefaultValueLiteral();
			break;
	
		default:
			retValue = feature.getDefaultValueLiteral();
			retValue = retValue == null ? "" : retValue; //$NON-NLS-1$
			break;
		} // switch
	*/
		return retValue;
	} // getPropertyDefaultValueString

	/**
	 * @return the error message that describes the problem with the contents
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

} // GraphGeneratorPropertyEditor

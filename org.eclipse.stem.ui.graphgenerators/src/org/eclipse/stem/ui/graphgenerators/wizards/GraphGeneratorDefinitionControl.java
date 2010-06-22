// DiseaseDefinitionControl.java
package org.eclipse.stem.ui.graphgenerators.wizards;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.graphgenerators.Constants;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

/**
 * This class represents the SWT control for defining a disease.
 */
public class GraphGeneratorDefinitionControl extends Composite {

	private static org.eclipse.stem.graphgenerators.GraphGenerator[] graphGenerators = null;

	private final Combo combo;

	private final GraphGeneratorPropertyComposite graphGeneratorPropertyComposite;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public GraphGeneratorDefinitionControl(final Composite parent, final int style,
			ModifyListener projectValidator, IProject project) {
		super(parent, style);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.numColumns = 2;
		setLayout(gridLayout);

		final Label graphGeneratorLabel = new Label(this, SWT.NONE);
		final GridData gd_graphGeneratorLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_graphGeneratorLabel.widthHint = 100;
		graphGeneratorLabel.setLayoutData(gd_graphGeneratorLabel);
		graphGeneratorLabel.setText(Messages.getString("GGDC.0")); //$NON-NLS-1$

		combo = new Combo(this, SWT.READ_ONLY);
		combo.setTextLimit(30);
		final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_combo.widthHint = 303;
		combo.setLayoutData(gd_combo);

		combo.setToolTipText(Messages.getString("GGDC.1")); //$NON-NLS-1$
		// Initialize the list of disease models available
		combo.setItems(getGraphGeneratorNames(getGraphGenerators()));
		combo.select(0);
		combo.addModifyListener(projectValidator);
		
		
		graphGeneratorPropertyComposite = new GraphGeneratorPropertyComposite(this,
				SWT.NONE, getGraphGenerators(), projectValidator, project);
		final GridData gd_graphGeneratorPropertyControl = new GridData(SWT.FILL,
				SWT.CENTER, true, false, 2, 1);
		graphGeneratorPropertyComposite
				.setLayoutData(gd_graphGeneratorPropertyControl);

		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				graphGeneratorPropertyComposite
						.displayGraphGenerator(getGraphGenerators()[combo
								.getSelectionIndex()]);
				// layout();
			} // widgetSelected

		});
		final GraphGeneratorDefinitionControl self = this;
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.stem.doc.newgraph_contextid");

	} // DiseaseDefinitionControl

	/**
	 * @return an array of the {@link GraphGenerators}s defined in the system.
	 */
	private GraphGenerator[] getGraphGenerators() {
		if (graphGenerators == null) {
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IConfigurationElement[] graphGeneratorConfigElements = registry
					.getConfigurationElementsFor(Constants.ID_GRAPH_GENERATOR_EXTENSION_POINT);

			final List<GraphGenerator> temp = new ArrayList<GraphGenerator>();

			graphGenerators = new GraphGenerator[graphGeneratorConfigElements.length];

			for (int i = 0; i < graphGeneratorConfigElements.length; i++) {
				final IConfigurationElement element = graphGeneratorConfigElements[i];
				// Does the element specify the class of the disease model?
				if (element.getName().equals(Constants.GRAPH_GENERATOR_ELEMENT)) {
					// Yes
					try {
						temp.add((GraphGenerator) element
								.createExecutableExtension(Messages.getString("GGDC.2"))); //$NON-NLS-1$
					} catch (final CoreException e) {
						Activator.logError(
								Messages.getString("GGDC.3"), e); //$NON-NLS-1$
					}
				} // if
			} // for each configuration element

			graphGenerators = temp.toArray(new GraphGenerator[] {});
		} // if disesaeModels not created

		return graphGenerators;
	} // getGraphGenerators

	/**
	 * @return the names of the disease models
	 */
	private String[] getGraphGeneratorNames(final GraphGenerator[] graphGenerators) {
		final String[] retValue = new String[graphGenerators.length];
		for (int i = 0; i < graphGenerators.length; i++) {
			String name = graphGenerators[i].getDublinCore().getTitle();
			// Was a name specified?
			if ((name == null) || name.equals("")) { //$NON-NLS-1$
				// No
				name = graphGenerators[i].getClass().getSimpleName();
			} // if

			retValue[i] = name;
		} // for i
		return retValue;
	} // getGraphGeneratorNames

	

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
		return graphGeneratorPropertyComposite.validate();
	} // validate

	/**
	 * @return the error message set by {@link #validate()}
	 */
	public String getErrorMessage() {
		return graphGeneratorPropertyComposite.getErrorMessage();
	}

	/**
	 * return the new graph
	 */
	public Graph getGraph() {
		final GraphGenerator gg = (GraphGenerator)EcoreUtil
			.copy(getGraphGenerators()[combo.getSelectionIndex()]);
		Graph retValue = graphGeneratorPropertyComposite.getGraph(gg);
		return retValue;
	}
} // GraphGeneratorDefinitionControl

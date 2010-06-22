// DiseaseModelPropertyComposite.java
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.graphgenerators.adapters.graphgeneratorpropertyeditor.GraphGeneratorPropertyEditor;
import org.eclipse.stem.ui.graphgenerators.adapters.graphgeneratorpropertyeditor.GraphGeneratorPropertyEditorAdapter;
import org.eclipse.stem.ui.graphgenerators.adapters.graphgeneratorpropertyeditor.GraphGeneratorPropertyEditorAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class represents
 */
public class GraphGeneratorPropertyComposite extends Composite {

	private Map<org.eclipse.stem.graphgenerators.GraphGenerator, GraphGeneratorPropertyEditor> modelMap = new HashMap<GraphGenerator, GraphGeneratorPropertyEditor>();

	private StackLayout stackLayout = null;

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public GraphGeneratorPropertyComposite(final Composite parent,
			final int style, final GraphGenerator[] graphGenerators,
			ModifyListener projectValidator, IProject project) {
		super(parent, style);
		stackLayout = new StackLayout();
		setLayout(stackLayout);

		Label label;
		label = new Label(this, SWT.NONE);
		label.setText(Messages.getString("GGPC1")); //$NON-NLS-1$
		GraphGeneratorPropertyEditor firstOne = null;
		// Any disease models?
		if (graphGenerators != null) {
			// Yes
			for (int i = 0; i < graphGenerators.length; i++) {

				GraphGeneratorPropertyEditorAdapter dmpea = (GraphGeneratorPropertyEditorAdapter) GraphGeneratorPropertyEditorAdapterFactory.INSTANCE
						.adapt(graphGenerators[i],
								GraphGeneratorPropertyEditorAdapter.class);

				final GraphGeneratorPropertyEditor dmpe = dmpea
						.createGraphGeneratorPropertyEditor(this, SWT.NONE,
								projectValidator, project);

				modelMap.put(graphGenerators[i], dmpe);
				if (firstOne == null) {
					// Yes
					firstOne = dmpe;
				} // if
			} // for i
		} // if any disease models?

		stackLayout.topControl = firstOne;
	} // GraphGeneratorPropertyComposite

	void displayGraphGenerator(final GraphGenerator graphGenerator) {
		final GraphGeneratorPropertyEditor dmpe = modelMap.get(graphGenerator);
		// Did we find it?
		if (dmpe != null) {
			// Yes
			stackLayout.topControl = dmpe;
			layout();
		} // if
		else {
			Activator.logError(Messages.getString("GGPC2") //$NON-NLS-1$
					+ graphGenerator.getClass().getName() + "\"", null); //$NON-NLS-1$
		}
	} // displayGraphGenerator
	
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
		return ((GraphGeneratorPropertyEditor) (stackLayout.topControl))
				.validate();
	} // validate

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return ((GraphGeneratorPropertyEditor) (stackLayout.topControl))
				.getErrorMessage();
	}

	/**
	 * @param graphGenerator
	 */
	public Graph getGraph(GraphGenerator gg) {
		return ((GraphGeneratorPropertyEditor) (stackLayout.topControl))
				.getGraph(gg);
	} // 

} // GraphGeneratorPropertyComposite

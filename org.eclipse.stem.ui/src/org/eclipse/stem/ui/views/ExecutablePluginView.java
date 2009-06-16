// ExecutablePluginView.java
package org.eclipse.stem.ui.views;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * This class represents an eclipse view of the executable plug-in resources of
 * a particular type that have been imported into eclipse as plug-ins.
 */
public abstract class ExecutablePluginView extends ViewPart {

	/**
	 * The List of things to be shown in the view.
	 */
	private ListViewer lv;

	/**
	 * @return the input model specific to this view
	 */
	protected abstract ExecutableViewModel getInput();

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		lv = new ListViewer(parent);
		lv.setContentProvider(new ExecutableContentProvider());
		lv.setLabelProvider(new ExecutableLabelProvider());
		lv.setInput(getInput());

		// Provide our selection
		getSite().setSelectionProvider(lv);
	} // createPartControl

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// Nothing
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		// TODO implement dispose see selection service doc
		// getSite().setSelectionProvider(null);
		super.dispose();
	}

	/**
	 * This class represents the model of the executable plug-ins that extend a
	 * STEM extension point.
	 */
	public abstract static class ExecutableViewModel {

		private List<IConfigurationElement> executables;

		/**
		 * Constructor
		 */
		protected ExecutableViewModel(final String extensionPointID,
				final String executableElementName) {
			executables = new ArrayList<IConfigurationElement>();
			// Get the configuration elements for this extension point
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IConfigurationElement[] configElements = registry
					.getConfigurationElementsFor(extensionPointID);

			// Iterate through the elements.
			for (int i = 0; i < configElements.length; i++) {
				final IConfigurationElement element = configElements[i];
				// Is this an Observer?
				if (executableElementName.equals(element.getName())) {
					// Yes
					executables.add(element);
				} else {
					Activator.logError(MessageFormat.format(Messages
							.getString("IPView.Unexpected_Element"), element //$NON-NLS-1$
							.getName(), extensionPointID), null);
				} // else
			} // for each configuration element

		} // ExecutableViewModel

		/**
		 * @return the executables
		 */
		protected final List<IConfigurationElement> getExecutables() {
			return executables;
		}

	} // ExecutableViewModel

	/**
	 * This class provides content for the list view of the executables that are
	 * available as parts of plug-ins.
	 */
	public static class ExecutableContentProvider implements
			IStructuredContentProvider {

		/**
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			return ((ExecutableViewModel) inputElement).getExecutables()
					.toArray();
		} // getElements

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// Nothing to do
		}

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(@SuppressWarnings("unused") //$NON-NLS-1$
		Viewer viewer, @SuppressWarnings("unused") //$NON-NLS-1$
		Object oldInput, @SuppressWarnings("unused") //$NON-NLS-1$
		Object newInput) {
			// Nothing to do
		}
	} // ExecutableContentProvider

	/**
	 * This class provides labels the describe the executables available as part
	 * of plug-ins.
	 */
	protected static class ExecutableLabelProvider implements ILabelProvider {

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(@SuppressWarnings("unused") //$NON-NLS-1$
		Object element) {
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object element) {
			IConfigurationElement configElement = (IConfigurationElement) element;
			String retValue = configElement
					.getAttribute(Constants.EXECUTABLE_NAME_ATTRIBUTE);
			return retValue;
		} // getText

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void addListener(@SuppressWarnings("unused") //$NON-NLS-1$
		ILabelProviderListener listener) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 */
		public void dispose() {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
		 *      java.lang.String)
		 */
		public boolean isLabelProperty(@SuppressWarnings("unused") //$NON-NLS-1$
		Object element, @SuppressWarnings("unused") //$NON-NLS-1$
		String property) {
			return false;
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void removeListener(@SuppressWarnings("unused") //$NON-NLS-1$
		ILabelProviderListener listener) {
			// Nothing
		}
	} // ExecutableLabelProvider

} // ExecutablePluginView

package org.eclipse.stem.ui.handlers;

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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.AbstractAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

/**
 * {@link Action} that opens the editor when an {@link Identifiable} is
 * double-clicked in the project explorer.
 */
@SuppressWarnings("unused")
public class EditorActionProvider extends CommonActionProvider {

	IAction openAction = null;

	/**
	 * Default Constructor
	 */
	public EditorActionProvider() {
		// Nothing
	}

	/**
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	@Override
	public void init(ICommonActionExtensionSite site) {
		ICommonViewerSite aSite = site.getViewSite();
		if (aSite instanceof ICommonViewerWorkbenchSite) {
			ICommonViewerWorkbenchSite cvws = (ICommonViewerWorkbenchSite) aSite;
			openAction = new OpenIdentifiableAction(cvws.getPage(), cvws
					.getSelectionProvider());
		} // if
	} // init

	/**
	 * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		if (openAction.isEnabled()) {
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
					openAction);
		}
	}

	/**
	 * The {@link Action} that opens an editor on the selected
	 * {@link Identifiable}.
	 */
	public static class OpenIdentifiableAction extends AbstractAction implements
			IAction {

		private final IWorkbenchPage page;
		private final ISelectionProvider selectionProvider;
		private Identifiable selectedIdentifiable;

		/**
		 * Constructor
		 * 
		 * @param page
		 * @param selectionProvider
		 */
		public OpenIdentifiableAction(IWorkbenchPage page,
				ISelectionProvider selectionProvider) {
			this.page = page;
			this.selectionProvider = selectionProvider;
		} // OpenIdentifiableAction

		/**
		 * @see org.eclipse.jface.action.IAction#run()
		 */
		public void run() {
			final IPath path = new Path(selectedIdentifiable.getURI()
					.toPlatformString(true));
			final IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(path);

			// Found the file?
			if (file != null) {
				// Yes
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
					Activator.logError("Problem opening editor", e);
				}
			} // if file found
			else {
				Activator.logError("Could not find file \"" + path.toString()
						+ "\"", null);
			}

		} // run

		/**
		 * @see org.eclipse.jface.action.IAction#isEnabled()
		 */
		public boolean isEnabled() {
			boolean retValue = false;
			ISelection selection = selectionProvider.getSelection();
			// Anything selected?
			if (!selection.isEmpty()) {
				IStructuredSelection sSelection = (IStructuredSelection) selection;
				if (sSelection.size() == 1
						&& sSelection.getFirstElement() instanceof Identifiable) {
					// Yes
					selectedIdentifiable = (Identifiable) sSelection
							.getFirstElement();
					retValue = true;
				}
			}
			return retValue;
		} // isEnabled

		/**
		 * @see org.eclipse.jface.action.IAction#getAccelerator()
		 */
		public int getAccelerator() {
			return 0;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getActionDefinitionId()
		 */
		public String getActionDefinitionId() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getDescription()
		 */
		public String getDescription() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getDisabledImageDescriptor()
		 */
		public ImageDescriptor getDisabledImageDescriptor() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getHelpListener()
		 */
		public HelpListener getHelpListener() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getHoverImageDescriptor()
		 */
		public ImageDescriptor getHoverImageDescriptor() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getId()
		 */
		public String getId() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getImageDescriptor()
		 */
		public ImageDescriptor getImageDescriptor() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getMenuCreator()
		 */
		public IMenuCreator getMenuCreator() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getStyle()
		 */
		public int getStyle() {
			return 0;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getText()
		 */
		public String getText() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#getToolTipText()
		 */
		public String getToolTipText() {
			return null;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#isChecked()
		 */
		public boolean isChecked() {
			return false;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#isHandled()
		 */
		public boolean isHandled() {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * @see org.eclipse.jface.action.IAction#runWithEvent(org.eclipse.swt.widgets.Event)
		 */
		public void runWithEvent(Event event) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setAccelerator(int)
		 */
		public void setAccelerator(int keycode) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setActionDefinitionId(java.lang.
		 *      String)
		 */
		public void setActionDefinitionId(String id) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setChecked(boolean)
		 */
		public void setChecked(boolean checked) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setDescription(java.lang.String)
		 */
		public void setDescription(String text) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setDisabledImageDescriptor(org.eclipse
		 *      .jface.resource.ImageDescriptor)
		 */
		public void setDisabledImageDescriptor(ImageDescriptor newImage) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setEnabled(boolean)
		 */
		public void setEnabled(boolean enabled) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setHelpListener(org.eclipse.swt.
		 *      events.HelpListener)
		 */
		public void setHelpListener(HelpListener listener) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setHoverImageDescriptor(org.eclipse.jface.resource.ImageDescriptor)
		 */
		public void setHoverImageDescriptor(ImageDescriptor newImage) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setId(java.lang.String)
		 */
		public void setId(String id) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setImageDescriptor(org.eclipse.jface.resource.ImageDescriptor)
		 */
		public void setImageDescriptor(ImageDescriptor newImage) {
			// Nothing
		}

		/**
		 * @param creator
		 * @see org.eclipse.jface.action.IAction#setMenuCreator(org.eclipse.jface.action.IMenuCreator)
		 */
		public void setMenuCreator(IMenuCreator creator) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setText(java.lang.String)
		 */
		public void setText(String text) {
			// Nothing
		}

		/**
		 * @see org.eclipse.jface.action.IAction#setToolTipText(java.lang.String)
		 */
		public void setToolTipText(String text) {
			// Nothing
		}

	} // OpenIdentifiableAction

} // EditorActionProvider

// IdentifiableEditor.java
package org.eclipse.stem.ui.editors;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.provider.CommonItemProviderAdapterFactory;
import org.eclipse.stem.core.experiment.provider.ExperimentItemProviderAdapterFactory;
import org.eclipse.stem.core.graph.provider.GraphItemProviderAdapterFactory;
import org.eclipse.stem.core.model.provider.ModelItemProviderAdapterFactory;
import org.eclipse.stem.core.scenario.provider.ScenarioItemProviderAdapterFactory;
import org.eclipse.stem.core.sequencer.provider.SequencerItemProviderAdapterFactory;
import org.eclipse.stem.data.geography.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.PropertySheet;

/**
 * This class is the super-class of all editors that edit {@link Identifiable}s.
 */
abstract public class IdentifiableEditor extends MultiPageEditorPart implements
		IMenuListener, ISelectionProvider, IEditingDomainProvider {

	/**
	 * This map holds the options for saving resources.
	 */
	final protected static Map<Object, Object> saveOptions = new HashMap<Object, Object>();
	static {
		// Only save things that have changed.
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
	} // static

	/**
	 * This is the editor's {@link EditingDomain} which is basically the
	 * combination of a {@link ResourceSet} and a {@link CommandStack}. It
	 * keeps track of what is being edited and the stack of {@link Command}s
	 * that made the changes.
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This adapter factory will be composed of the Identifiable item provider
	 * factories.
	 * 
	 * @see #createAdapterFactory()
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * The {@link Viewer} currently displayed
	 */
	protected Viewer currentViewer;

	/**
	 * This is the {@link WorkspaceModifyOperation} that saves the modified
	 * {@link Resource}s.
	 */
	final private WorkspaceModifyOperation saveOperation = new WorkspaceModifyOperation() {
		/**
		 * @param monitor
		 */
		@Override
		protected void execute(final IProgressMonitor monitor) {

			for (final Resource resource : editingDomain.getResourceSet()
					.getResources()) {
				// Should this Resource be saved?
				if (resource.getContents().isEmpty() == false
						&& editingDomain.isReadOnly(resource) == false) {
					// Yes
					try {
						resource.save(saveOptions);
					} // try
					catch (final Exception e) {
						Activator.logError("Problem saving", e);
					} // catch Exception
				} // if save resource
			} // for each Resource

		} // execute
	}; // saveOperation

	/**
	 * This listens for when the outline becomes active.
	 */
	@SuppressWarnings("unused")
	protected IPartListener partListener = new IPartListener() {

		public void partActivated(IWorkbenchPart part) {
			// Basically there are three ways the editor gets "activated",
			// either the Content Outline view or the Property Sheet views are
			// activated with "our" page being displayed, or the editor itself
			// is activated. We skim through the possibilities below, ignoring
			// any other possibilities.

			// Is the content outline view being activated?
			if (part instanceof ContentOutline) {
				// Yes
				// Is the current page in the Content Outline view our page?
				// if (((ContentOutline) part).getCurrentPage() ==
				// contentOutlinePage) {
				// // Yes
				// getActionBarContributor().setActiveEditor(
				// IdentifiableEditor.this);
				// setCurrentViewer(contentOutlineViewer);
				// } // if our outline page

			} // if content outline view activated
			// Is the current property sheet view being activated?
			else if (part instanceof PropertySheet) {
				// Yes
				// Is the current page in the property view our page?
				// if (((PropertySheet) part).getCurrentPage() ==
				// propertySheetPage) {
				// // Yes
				// getActionBarContributor().setActiveEditor(
				// IdentifableEditor.this);
				// handleActivate();
				// } // if our property page
			} // if property sheet view
			// Is this editor being activated?
			else if (part == IdentifiableEditor.this) {
				// Yes
				handleActivate();
			} // if

		} // partActivated

		public void partBroughtToTop(IWorkbenchPart part) {
			// Ignore
		}

		public void partClosed(IWorkbenchPart part) {
			// Ignore
		}

		public void partDeactivated(IWorkbenchPart part) {
			// Ignore
		}

		public void partOpened(IWorkbenchPart part) {
			// Ignore
		}
	}; // partListener

	/**
	 * This is the {@link ISelectionChangedListener} for the editor. It is
	 * always listening to the {@link Viewer} referenced by
	 * {@link #currentViewer}. The method {@link #setCurrentViewer(Viewer)}
	 * maintains the association.
	 */
	private final ISelectionChangedListener selectionChangedListener = new ISelectionChangedListener() {
		public void selectionChanged(SelectionChangedEvent event) {
			setSelection(event.getSelection());
		}
	}; // selectionChangedListener

	/**
	 * This keeps track of all the
	 * {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are
	 * listening to this editor.
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * The editor's current selection.
	 * 
	 * @se {@link #setSelection(ISelection)}
	 * @see #getSelection()
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * Default Constructor
	 */
	public IdentifiableEditor() {
		super();
		adapterFactory = createAdapterFactory();
		editingDomain = createEditingDomain(adapterFactory);
	} // IdentifiableEditor

	/**
	 * @return the {@link AdapterFactory} that will provide the
	 *         {@link ItemProvider}s needed to adapt the {@link Identifiable}s
	 *         for the editor.
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		final ComposedAdapterFactory retValue = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		retValue.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		retValue.addAdapterFactory(new CommonItemProviderAdapterFactory());
		retValue.addAdapterFactory(new ExperimentItemProviderAdapterFactory());
		retValue.addAdapterFactory(new GraphItemProviderAdapterFactory());
		retValue.addAdapterFactory(new ModelItemProviderAdapterFactory());
		retValue.addAdapterFactory(new ScenarioItemProviderAdapterFactory());
		retValue.addAdapterFactory(new SequencerItemProviderAdapterFactory());
		retValue.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		retValue.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		return retValue;
	} // createAdapterFactory

	/**
	 * @param adapterFactory
	 *            the {@link AdapterFactory} that will be used to create the
	 *            {@link EditingDomain}.
	 * @return an {@link EditingDomain}
	 */
	private AdapterFactoryEditingDomain createEditingDomain(
			final AdapterFactory adapterFactory) {

		// Create the command stack for the edit commands
		final BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to the command stack so we can track which objects are
		// changed by the command and then use them as the selection.

		commandStack.addCommandStackListener(new CommandStackListener() {
			@SuppressWarnings("synthetic-access")
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						// Tell any listeners that the editor is now "dirty"
						firePropertyChange(IEditorPart.PROP_DIRTY);

						final Command mostRecentCommand = ((CommandStack) event
								.getSource()).getMostRecentCommand();
						// Was there a command?
						if (mostRecentCommand != null) {
							// Yes
							setSelectionToViewer(mostRecentCommand
									.getAffectedObjects());
						} // if command

						// Refresh the property sheet
						// if (propertySheetPage != null) {
						// // Yes
						//							
						// } // if
					} // run

					private void setSelectionToViewer(
							final Collection<?> selection) {
						// Anything there?
						if (selection != null && selection.isEmpty() == false) {
							// Yes
							new Runnable() {
								public void run() {
									if (currentViewer != null) {
										// Yes
										currentViewer
												.setSelection(new StructuredSelection(
														selection));
									} // if
								} // run
							}.run();
						} // if
					} // setSelectionToViewer
				});
			}
		});

		return new AdapterFactoryEditingDomain(adapterFactory, commandStack,
				new HashMap<Resource, Boolean>()) {
					@Override
					public Command createCommand(
							Class<? extends Command> commandClass,
							CommandParameter commandParameter) {
						if (commandClass == DeleteCommand.class) {
							// Yes
//							IStructuredSelection ss= (IStructuredSelection) currentViewer.getSelection();
//							
//							ITreeSelection obj = (ITreeSelection)  editorSelection;
//							TreePath[] paths = obj.getPaths();
							return super.createCommand(commandClass, commandParameter);
						} // if 
						return super.createCommand(commandClass, commandParameter);
					}};
	} // createEditingDomain

	/**
	 * @see org.eclipse.ui.part.MultiPageEditorPart#init(org.eclipse.ui.IEditorSite,
	 *      org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		setSite(site);
		setInput(input);
		setPartName(input.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		// ResourcesPlugin.getWorkspace().addResourceChangeListener(
		// resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	} // init

	/**
	 * @see org.eclipse.ui.part.MultiPageEditorPart#createPages()
	 */
	@Override
	protected void createPages() {
		// Load the Identifiable to be edited
		loadIdentifiable();

		// Did anything actually get loaded?
		if (editingDomain.getResourceSet().getResources().isEmpty() == false
				&& editingDomain.getResourceSet().getResources().get(0)
						.getContents().isEmpty() == false) {
			// Yes
			// We create a page that is a tree view of the Identifiable
			final Tree tree = new Tree(getContainer(), SWT.MULTI);
			final TreeViewer treeViewer = new TreeViewer(tree);
			setCurrentViewer(treeViewer);

			treeViewer.setContentProvider(new AdapterFactoryContentProvider(
					adapterFactory));
			treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
					adapterFactory));
			treeViewer.setInput(editingDomain.getResourceSet().getResources()
					.get(0));
			// treeViewer.setSelection(selection);

			new AdapterFactoryTreeEditor(treeViewer.getTree(), adapterFactory);

			createContextMenu(treeViewer);

			// Support for dragging and dropping Identifiables
			addDragNDropSupport(treeViewer);
			
			final int pageIndex = addPage(tree);
			setPageText(pageIndex, "tree editor");

			// Ok now it's time to create and add any pages that are specific to
			// the Identifiable .
			createIdentifiableSpecificPages();

			// Switch to the active page.
			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				@SuppressWarnings("synthetic-access")
				public void run() {
					setActivePage(0);
				}
			});
		} // if
	} // createPages

	/**
	 * This method loads a resource into the editor's {@link EditingDomain}
	 * {@link ResourceSet}.
	 * <p>
	 * This is basically the same as method "createModel" the generated code
	 */
	private void loadIdentifiable() {
		final URI resourceURI = EditUIUtil.getURI(getEditorInput());
		@SuppressWarnings("unused")
		Exception exception = null;
		@SuppressWarnings("unused")
		Resource resource = null;

		try {
			// First we try to demand load the resource -> true
			resource = editingDomain.getResourceSet().getResource(resourceURI,
					true);
		} catch (final Exception e) {
			// Remember the exception
			exception = e;
			// That didn't work, so don't demand load the resource -> false
			resource = editingDomain.getResourceSet().getResource(resourceURI,
					false);
		} // catch Exception
		// Need code here to analyze the exception if there was one. see
		// createModel()
	} // loadIdentifiable

	/**
	 * This makes sure that one content {@link Viewer}, either the one for the
	 * current page in the editor, or the one in the outline view, if it has
	 * focus, is the current one. Basically, this code maintains which
	 * {@link Viewer} {@link #selectionChangedListener} is listening to.
	 * 
	 * @param newViewer
	 *            the new {@link Viewer}
	 */
	private void setCurrentViewer(Viewer newViewer) {
		// Is the new viewer different from the current one?
		if (newViewer != currentViewer) {
			// Yes
			// Is there a current (i.e. old) viewer?
			if (currentViewer != null) {
				// Yes
				// We're not listening to it any more
				currentViewer
						.removeSelectionChangedListener(selectionChangedListener);
			} // if

			// Is there a new viewer?
			if (newViewer != null) {
				// Yes
				// We're listening to it now
				newViewer.addSelectionChangedListener(selectionChangedListener);
			} // if

			currentViewer = newViewer;

			// Now we need to set the selection in the editor based on the new
			// viewer's current selection.
			setSelection(newViewer == null ? StructuredSelection.EMPTY
					: newViewer.getSelection());
		} // if different viewer
	} // setCurrentViewer

	private void createContextMenu(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));

		// I think this is clearing the menu in preparation for being recreated
		// just before it is displayed.
		contextMenu.setRemoveAllWhenShown(true);

		// Register to have our menuAboutToShow() method be called just before
		// the context menu is displayed.
		contextMenu.addMenuListener(this);

		final Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, viewer);


	} // createContextMenu

	private void addDragNDropSupport(StructuredViewer viewer) {
		final int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		final Transfer[] transfers = new Transfer[] {
				LocalTransfer.getInstance(), TextTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer.addDropSupport(dndOperations, transfers,

		new EditingDomainViewerDropAdapter(editingDomain, viewer) {
			@Override
			public void dragEnter(DropTargetEvent event) {
				// We make all operations a drop link
				event.detail = DND.DROP_LINK;
				super.dragEnter(event);
			}

			/**
			 * We override the super method because the IdentifiablePluginView
			 * provides a Collections of Identifiables, rather than an
			 * IStructureSelction of IdentifiableDelegates.
			 */
			@Override
			protected Collection<?> extractDragSource(Object object) {
				if (object instanceof Collection) {
					// Yes
					return (Collection<?>) object;
				} // if
				return super.extractDragSource(object);
			}
		});
	} // addDragNDropSupport

	/**
	 * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener) getEditorSite().getActionBarContributor())
				.menuAboutToShow(menuManager);
	} // menuAboutToShow

	protected EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor) getEditorSite()
				.getActionBarContributor();
	} // getActionBarContributor

	/**
	 * This handles the activation of the editor or it's associated content
	 * outline or property sheet view.
	 */
	protected void handleActivate() {
		// Recompute the read only state?
		if (editingDomain.getResourceToReadOnlyMap() != null) {
			// Yes
			editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled
			setSelection(getSelection());
		} // if

		// This is not finished yet, the removed and changed resources are not
		// initialized.
	} // handleActivate

	/**
	 * This method is overridden by extending classes so that they can provide a
	 * page to the editor that is specific to the type of {@link Identifiable}
	 * they are editing.
	 */
	protected void createIdentifiableSpecificPages() {
		// Nothing
	} // createIdentifiableSpecificPages

	
	/**
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(
			@SuppressWarnings("unused") final IProgressMonitor monitor) {
		try {
			// First "true" -> fork, second "false" -> cancelable
			new ProgressMonitorDialog(getSite().getShell()).run(true, false,
					saveOperation);
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (final Exception e) {
			Activator.logError("Problem saving", e);
		} // catch Exception
	} // doSave

	/**
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		final SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		final IPath path = saveAsDialog.getResult();
		// Did we get a path?
		if (path != null) {
			// Yes
			final IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(path);
			// Did we get a valid file?
			if (file != null) {
				// Yes
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true), new FileEditorInput(file));
			} // if
		} // if

	} // doSaveAs

	private void doSaveAs(final URI uri, final FileEditorInput fileEditorInput) {
		// The URI of the resource has changed, update
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		// Set the editor's input to the new FileEditorInput
		setInputWithNotify(fileEditorInput);
		setPartName(fileEditorInput.getName());

		final EditingDomainActionBarContributor edac = (EditingDomainActionBarContributor) getEditorSite()
				.getActionBarContributor();

		final IStatusLineManager islm = edac.getActionBars()
				.getStatusLineManager();

		// Get a progress bar for the save....
		final IProgressMonitor progressMonitor = islm != null ? islm
				.getProgressMonitor() : new NullProgressMonitor();

		// Now save...
		doSave(progressMonitor);
	} // doSaveAs

	/**
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	} // isSaveAsAllowed

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to
	 * return this editor's overall selection.
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	public ISelection getSelection() {
		return editorSelection;
	} // getSelection

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to
	 * set this editor's overall selection. Calling this result will notify the
	 * listeners.
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener
					.selectionChanged(new SelectionChangedEvent(this, selection));
		} // for each ISelectionChangedListener
		// setStatusLineManager(selection);
	} // setSelection

} // IdentifiableEditor

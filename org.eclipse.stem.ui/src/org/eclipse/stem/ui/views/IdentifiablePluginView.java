// IdentifiablePluginView.java
package org.eclipse.stem.ui.views;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.data.geography.GeographicNames;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.handlers.STEMExecutionCommandHandler;
import org.eclipse.stem.ui.perspectives.Simulation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * This class represents an eclipse view of the {@link Identifiable} resources
 * of a particular type that have been imported into eclipse as plug-ins.
 * 
 * @see Identifiable
 * @see GraphsView
 * @see ModelsView
 * @see ScenariosView
 */
public abstract class IdentifiablePluginView extends ViewPart {

	protected TreeViewer treeViewer;

	private DublinCoreToolTipHandler dcTTipHandler;

	/**
	 * This is the selection that is in effect at the start of a drag operation
	 */
	protected ISelection selection;

	/**
	 * This map keeps track of the {@link Identifiable} that we've deserialized
	 * so we don't need to do that more than once.
	 * 
	 * @see #getIdentifiable(URI)
	 */
	protected Map<URI, Identifiable> deserializedIdentifiablesMap = new HashMap<URI, Identifiable>();

	/**
	 * Constructor
	 */
	public IdentifiablePluginView() {
		super();
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(final Composite parent) {
		dcTTipHandler = new DublinCoreToolTipHandler(parent.getShell());

		treeViewer = new TreeViewer(parent);
		treeViewer
				.setContentProvider(new IdentifiablePluginViewTreeContentProvider());
		treeViewer
				.setLabelProvider(getIdentifiablePluginViewLabelContentProvider());
		treeViewer.setUseHashlookup(true);
		treeViewer.setInput(getInput());

		// Hook up the dublin core tool tip handler
		dcTTipHandler.addDCToolTipHelp(treeViewer.getTree());

		// We become a selection provider too
		getSite().setSelectionProvider(treeViewer);

		// Context Menu
		final MenuManager contextMenuManager = new MenuManager();
		// Place Holder for Menu Additions
		contextMenuManager.add(new Separator("execution"));

		// Set the context menu for the viewer
		treeViewer.getControl().setMenu(
				contextMenuManager.createContextMenu(treeViewer.getControl()));
		getSite().registerContextMenu(contextMenuManager, treeViewer);

		// Listen for double-clicks on Executables
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(final DoubleClickEvent event) {
				final IExecutable executable = (IExecutable) Platform.getAdapterManager().getAdapter(((StructuredSelection) event.getSelection()).toList().get(0), IExecutable.class);

				// Were we successful in adapting?
				if (executable != null) {
					// Yes
					executable.run();
					
					// Only switch to the Simulation Persepctive when the executable is a standard
					// run (scenario). For other executables we may want to stay in other special
					// perspectives
					if(executable instanceof Adapter) {
						Adapter a = (Adapter) executable;
						Object obj = a.getTarget();
						if( obj instanceof org.eclipse.stem.core.scenario.impl.ScenarioImpl ) {
							Activator.switchToPerspective(Simulation.ID_STEM_SIMULATION_PERSPECTIVE);
						}	
					} // if adapter (usually true)
					
				} // if
			} // doubleClick
		});

		// Set up drag support
		final int ops = DND.DROP_LINK | DND.DROP_COPY | DND.DROP_MOVE;
		final Transfer[] transfers = new Transfer[] {
				LocalSelectionTransfer.getTransfer(),
				LocalTransfer.getInstance() };
		treeViewer.addDragSupport(ops, transfers, new DragSourceListener() {

			/**
			 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
			 */
			public void dragStart(final DragSourceEvent event) {
				// We need to figure out when the drag can start here
				// Just say "yes" right now
				event.doit = true;
				selection = treeViewer.getSelection();
				// LocalSelectionTransfer.getTransfer().setSelection(selection);
			} // dragStart

			/**
			 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
			 */
			public void dragSetData(final DragSourceEvent event) {

				if (LocalSelectionTransfer.getTransfer().isSupportedType(
						event.dataType)) {
					// Yes
					event.data = extractURIStringsFromIdentifiableDelegates((IStructuredSelection) selection);
					LocalSelectionTransfer.getTransfer().setSelection(
							(IStructuredSelection) event.data);
				} // if
				else if (LocalTransfer.getInstance().isSupportedType(
						event.dataType)) {
					// Yes
					event.data = extractURIStringsFromIdentifiableDelegates((IStructuredSelection) selection);
				} // if

			} // dragSetData

			private IStructuredSelection extractURIStringsFromIdentifiableDelegates(
					final IStructuredSelection selectedDelegates) {
				final List<String> collection = new ArrayList<String>();
				for (final Iterator selectionIter = selectedDelegates
						.iterator(); selectionIter.hasNext();) {
					final Object element = selectionIter.next();
					// Was an Identifiable Delegate selected?
					if (element instanceof IdentifiableDelegate) {
						// Yes
						// It has a URI that specifies the serialized
						// representation of the Identifiable
						final String uriString = ((IdentifiableDelegate) element)
								.getDublinCore().getIdentifier();
						// Were we successful in getting the uri string?
						if (uriString != null) {
							// Yes
							collection.add(uriString);
						}
					} // if
				} // for each selection

				return new IStructuredSelection() {

					final List<String> list;
					{
						list = collection;
					}

					public Object getFirstElement() {
						return list.get(0);
					}

					public Iterator<String> iterator() {
						return list.iterator();
					}

					public int size() {
						return list.size();
					}

					public Object[] toArray() {
						return list.toArray();
					}

					public List<String> toList() {
						return list;
					}

					public boolean isEmpty() {
						return list.isEmpty();
					}
				};
			} // extractURIStrings

			/**
			 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
			 */
			public void dragFinished(
					@SuppressWarnings("unused") final DragSourceEvent event) {
				selection = null;
				LocalTransfer.getInstance().javaToNative(null, null);
			} // dragFinished

		});
	} // createPartControl

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// Nothing
	}

	/**
	 * @return the input model specific to this view
	 */
	protected abstract IdentifiableViewModel getInput();

	/**
	 * @return the {@link IdentifiablePluginViewLabelContentProvider}
	 *         appropriate for the model
	 */
	protected abstract IdentifiablePluginViewLabelContentProvider getIdentifiablePluginViewLabelContentProvider();

	/**
	 * This class represents the model of the {@link Identifiable}'s that extend
	 * a particular extension point.
	 */
	protected abstract static class IdentifiableViewModel {
		// The root of the tree of categories and identifiables
		private final Category root;

		// Mapping between a category id and a category
		private final Map<String, Category> categoryMap;

		/**
		 * @param extensionPointID
		 *            the identifier of the extension point that Identifiables
		 *            use to plug-in.
		 */
		public IdentifiableViewModel(final String extensionPointID) {
			root = new Category(Constants.IDENTIFIABLE_ROOT_CATEGORY_NAME,
					Constants.IDENTIFIABLE_ROOT_CATEGORY_ID, ""); //$NON-NLS-1$
			categoryMap = new HashMap<String, Category>();
			categoryMap.put(root.getCategoryId(), root);

			// Get the configuration elements for this extension point
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			final IConfigurationElement[] configElements = registry
					.getConfigurationElementsFor(extensionPointID);

			// Make a first pass through the elements looking for categories
			for (final IConfigurationElement element : configElements) {
				// Is this a Category?
				if (Constants.CATEGORY_ELEMENT.equals(element.getName())) {
					// Yes
					addCategory(element);
				}
			} // for each configuration element

			// Resolve the connections between parent and child categories
			resolveCategories();

			// Iterate through the elements. Processing the identifiables
			for (final IConfigurationElement element : configElements) {
				// Is this a Category?
				if (Constants.CATEGORY_ELEMENT.equals(element.getName())) {
					// Yes
					continue;
				}
				// Is this a dublin core element?
				else if (Constants.DUBLIN_CORE_ELEMENT
						.equals(element.getName())) {
					// Yes
					// Was a category id specified in the element?
					Category category = root;
					final String categoryId = element
							.getAttribute("category_id"); //$NON-NLS-1$
					if (categoryId != null) {
						// Yes
						category = categoryMap.get(categoryId);
						// Did we find the category?
						if (category == null) {
							// No
							Activator.logError(MessageFormat.format(Messages
									.getString("IPView.No_Category"), //$NON-NLS-1$
									categoryId), null);
							category = root;
						}

						category = category == null ? root : category;
					}
					addIdentifiableDelegate(category, element);
				} // if dublin core
				// Is it an element with a "name" attribute?
				else if (element.getAttribute("name") != null) {
					// Yes
					addIdentifiableDelegate(root, element);
				} // if
				else {
					Activator.logError(MessageFormat.format(Messages
							.getString("IPView.Unexpected_Element"), element
							.getName(), extensionPointID), null);
				} // else
			} // for each configuration element

		} // IdentifiableViewModel

		/**
		 * Add an {@link IdentifiableDelegate} to the model.
		 * 
		 * @param category
		 *            the {@link Category} to add the delegate to
		 * 
		 * @param element
		 *            the {@link DublinCore} element that defines the delegate
		 */
		private void addIdentifiableDelegate(final Category category,
				final IConfigurationElement element) {
			final IdentifiableDelegate identifiableDelegate = new IdentifiableDelegate(
					element);
			category.addIdentifiableDelegate(identifiableDelegate);
		} // addIdentifiableDelegate

		/**
		 * Add a {@link Category} to the model.
		 * 
		 * @param element
		 *            the category element that defines the category
		 */
		private Category addCategory(final IConfigurationElement element) {
			final Category category = new Category(element);
			// Does the category already exist?
			Category retValue = categoryMap.get(category.getCategoryId());

			if (retValue == null) {
				// No
				// It's new
				retValue = category;
				categoryMap.put(category.getCategoryId(), category);
			}

			return retValue;
		} // addCategory

		/**
		 * Hook up parent and child categories.
		 */
		private void resolveCategories() {
			// Go through each of the categories hooking up parent with child
			for (final Category category : categoryMap.values()) {
				// Is this the root category?
				if (category == root) {
					// Yes
					continue;
				}

				// Does it's parent exist?
				Category parentCategory = categoryMap.get(category
						.getParentId());
				if (parentCategory == null) {
					// No
					Activator
							.logInformation(
									"When organizing categories, the specified parent category \"" //$NON-NLS-1$
											+ category.getParentId()
											+ "\" for the category \"" //$NON-NLS-1$
											+ category.getCategoryId()
											+ "\" could not be found.  Using \"/\" instead.", //$NON-NLS-1$
									null);
					parentCategory = root;
				} // if parent exists

				category.setParent(parentCategory);
				parentCategory.addChildCategory(category);

			} // for each category
		} // resolveCategories

		/**
		 * @return the root
		 */
		protected final Category getRoot() {
			return root;
		}

	} // IdentifiableViewModel

	/**
	 * This class represents an element in the tree that is the model of the
	 * plugged in graphs.
	 */
	protected static class Category implements Comparable<Object> {
		Category parent;

		String parentId;

		String categoryId;

		String categoryName;

		List<Category> childCategories;

		List<IdentifiableDelegate> childIdentifiables;

		protected Category(final String categoryName, final String categoryId,
				final String parentId) {
			this.categoryName = categoryName;
			this.categoryId = categoryId;
			this.parentId = parentId;
			this.parent = null;
			this.childCategories = new ArrayList<Category>();
			this.childIdentifiables = new ArrayList<IdentifiableDelegate>();
		}

		protected Category(final IConfigurationElement element) {
			this(getNLSCatagoryName(element
					.getAttribute(Constants.CATEGORY_NAME_ATTRIBUTE)), element
					.getAttribute(Constants.CATEGORY_ID_ATTRIBUTE), element
					.getAttribute(Constants.PARENT_ID_ATTRIBUTE));
		}

		/**
		 * @param category
		 *            a child {@link Category} to add to this parent
		 */
		public void addChildCategory(final Category category) {
			childCategories.add(category);
		}

		/**
		 * @param identifiableDelegate
		 *            the {@link IdentifiableDelegate} to add to the category
		 */
		public void addIdentifiableDelegate(
				final IdentifiableDelegate identifiableDelegate) {
			childIdentifiables.add(identifiableDelegate);
		}

		/**
		 * @param attribute
		 *            the value of {@link Constants#CATEGORY_NAME_ATTRIBUTE}
		 * @return the NLS'd version of the category name
		 */
		private static String getNLSCatagoryName(final String attribute) {
			final String name = GeographicNames.getName(attribute);
			return name.startsWith("!") ? attribute : name;
		} // getNLSCatagoryName

		/**
		 * @return the categoryId of this {@link Category}
		 */
		protected final String getCategoryId() {
			return categoryId;
		}

		/**
		 * @return the parentId
		 */
		protected final String getParentId() {
			return parentId;
		}

		/**
		 * @return the parent
		 */
		protected final Category getParent() {
			return parent;
		}

		/**
		 * @param parent
		 *            the parent to set
		 */
		protected final void setParent(final Category parent) {
			this.parent = parent;
		}

		/**
		 * @return the children of the {@link Category}
		 */
		public Object[] getChildren() {
			final List<Object> kidList = new ArrayList<Object>();
			Collections.sort(childCategories);
			Collections.sort(childIdentifiables);
			kidList.addAll(childCategories);
			kidList.addAll(childIdentifiables);
			return kidList.toArray();
		} // getChildren

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final StringBuilder retValue = new StringBuilder(categoryName);
			retValue.append(", "); //$NON-NLS-1$
			retValue.append(categoryId);
			retValue.append(", "); //$NON-NLS-1$
			retValue.append(parentId);
			return retValue.toString();
		}

		/**
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result
					+ ((categoryId == null) ? 0 : categoryId.hashCode());
			return result;
		}

		/**
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Category other = (Category) obj;
			if (categoryId == null) {
				if (other.categoryId != null) {
					return false;
				}
			} else if (!categoryId.equals(other.categoryId)) {
				return false;
			}
			return true;
		}

		/**
		 * @param o
		 * @return the value of the compare
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(final Object o) {
			int retValue = 0;
			if (o instanceof Category) {
				// Yes
				final Category category = (Category) o;
				retValue = categoryName.compareTo(category.categoryName);
			} // if Category
			else if (o instanceof IdentifiableDelegate) {
				// Yes
				// In a tree listing that mixes categories and
				// IdentifiableDelegates we want the categories to appear first,
				// so we always return the same value.
				retValue = 1;
			} // if IdentifiableDelegate
			return retValue;
		} // compareTo

	} // Category

	/**
	 * This class provides content for the tree view of the {@link Identifiable}
	 * s that are available as parts of plug-ins.
	 */
	protected static class IdentifiablePluginViewTreeContentProvider implements
			ITreeContentProvider {

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(final Object parentElement) {
			Object[] retValue = null;
			if (parentElement instanceof Category) {
				final Category category = (Category) parentElement;
				final List<Object> kidList = new ArrayList<Object>();
				Collections.sort(category.childCategories);
				Collections.sort(category.childIdentifiables);
				kidList.addAll(category.childCategories);
				kidList.addAll(category.childIdentifiables);
				retValue = kidList.toArray();
			}
			return retValue;
		} // getChildren

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(final Object element) {
			Object retValue = null;
			if (element instanceof Category) {
				retValue = ((Category) element).parent;
			} else {
				retValue = ((IdentifiableDelegate) element).getParent();
			}
			return retValue;
		} // getParent

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(final Object element) {
			boolean retValue = false;
			if (element instanceof Category) {
				final Category cagatory = (Category) element;
				retValue = cagatory.childCategories.size() > 0
						|| cagatory.childIdentifiables.size() > 0;
			}
			return retValue;
		} // hasChildren

		/**
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(final Object inputElement) {
			final IdentifiableViewModel model = (IdentifiableViewModel) inputElement;
			// return new Object[] { model.getRoot() };
			Arrays.sort(model.getRoot().getChildren());
			return model.getRoot().getChildren();
		} // getElements

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// Nothing to dispose
		} // dispose

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(
				@SuppressWarnings("unused") final Viewer viewer,
				@SuppressWarnings("unused") final Object oldInput,
				@SuppressWarnings("unused") final Object newInput) {
			// Nothing to do right now
		} // inputChanged

	} // IdentifiablePluginViewTreeContentProvider

	/**
	 * This class provides labels the describe the {@link Identifiable}s
	 * available as part of plug-ins.
	 */
	protected static abstract class IdentifiablePluginViewLabelContentProvider
			implements ILabelProvider {

		private static Image categoryIcon = null;

		// If true then we've never tried to get the icon
		static boolean categoryIconFirstTime = true;

		private final List<ILabelProviderListener> listeners;

		/**
		 * Constructor
		 */
		public IdentifiablePluginViewLabelContentProvider() {
			listeners = new ArrayList<ILabelProviderListener>();
		} // IdentifiablePluginViewLabelContentProvider

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(final Object element) {
			Image retValue = null;
			if (element instanceof Category) {
				retValue = getCategoryIcon();
			}
			return retValue;
		} // getImage

		/**
		 * @return the icon to be used to represent {@link Category}s, or
		 *         <code>null</code> if it can't be loaded.
		 */
		protected Image getCategoryIcon() {
			// Should we try to load the icon?
			if (categoryIconFirstTime && categoryIcon == null) {
				// Yes
				categoryIconFirstTime = false;
				categoryIcon = PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_FOLDER);
			} // if we should load the icon
			return categoryIcon;
		} // getCategoryIcon

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		public String getText(final Object element) {
			String retValue = ""; //$NON-NLS-1$
			if (element instanceof Category) {
				final Category category = (Category) element;
				retValue = category.categoryName;
			} else if (element instanceof IdentifiableDelegate) {
				final IdentifiableDelegate identifiableDelegate = (IdentifiableDelegate) element;
				retValue = identifiableDelegate.toString();
			}
			return retValue;
		} // getText

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void addListener(final ILabelProviderListener listener) {
			listeners.add(listener);
		} // addListener

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 */
		public void dispose() {
			// Nothing to do. The images are disposed of elsewhere,
		} // dispose

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
		 *      java.lang.String)
		 */
		public boolean isLabelProperty(
				@SuppressWarnings("unused") final Object element,
				@SuppressWarnings("unused") final String property) {
			return false;
		} // isLabelProperty

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void removeListener(final ILabelProviderListener listener) {
			listeners.remove(listener);
		} // removeListener

	} // IdentifiablePluginViewLabelContentProvider

	/**
	 * This class displays the {@link DublinCore} metadata of
	 * {@link Identifiable}s when the mouse hovers over it.
	 */
	private static class DublinCoreToolTipHandler {
		// This is the number of pixels below the current mouse position at
		// which to position the dublin core
		protected static final int Y_OFFSET = 16;

		protected Shell dcTipShell;

		Label dcDescriptionText;

		Label dcCreatorText;

		Label dcValidText;

		Label dcSourceText;

		DublinCoreToolTipHandler(final Shell parent) {
			final Display display = parent.getDisplay();

			dcTipShell = new Shell(parent, SWT.ON_TOP | SWT.TOOL);
			final GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 1;
			dcTipShell.setLayout(gridLayout);

			final Color backgroundColor = display
					.getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			final Color foregroundColor = display
					.getSystemColor(SWT.COLOR_INFO_FOREGROUND);

			dcTipShell.setBackground(backgroundColor);

			dcDescriptionText = createDCAttributeLabel(dcTipShell,
					backgroundColor, foregroundColor);

			dcCreatorText = createDCAttributeLabel(dcTipShell, backgroundColor,
					foregroundColor);

			dcValidText = createDCAttributeLabel(dcTipShell, backgroundColor,
					foregroundColor);
			dcSourceText = createDCAttributeLabel(dcTipShell, backgroundColor,
					foregroundColor);

			dcTipShell.pack();
		} // DublinCoreToolTipHandler

		private Label createDCAttributeLabel(final Shell parent,
				final Color backgroundColor, final Color foregroundColor) {
			final Label retValue = new Label(parent, SWT.NONE);
			retValue.setBackground(backgroundColor);
			retValue.setForeground(foregroundColor);
			retValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.VERTICAL_ALIGN_CENTER));
			return retValue;
		} // createDCAttributeLabel

		/**
		 * Add the necessary listeners to the {@link Control} to catch the mouse
		 * events and pop the tool tip up.
		 * 
		 * @param control
		 */
		public void addDCToolTipHelp(final Control control) {
			// If the user clicks with the mouse we want to get rid of the
			// dublin core
			control.addMouseListener(new MouseAdapter() {

				/**
				 * @see org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.events.MouseEvent)
				 */
				@Override
				public void mouseDown(
						@SuppressWarnings("unused") final MouseEvent e) {
					// Is the dublin core visible?
					if (dcTipShell.isVisible()) {
						// Yes
						// Not any more
						dcTipShell.setVisible(false);
					} // if visible
				} // mouseDown

			});

			// If the mouse hovers we want to pop up the dublin core, but if it
			// exits we want to get right of it.
			control.addMouseTrackListener(new MouseTrackAdapter() {

				/**
				 * @see org.eclipse.swt.events.MouseTrackAdapter#mouseHover(org.eclipse.swt.events.MouseEvent)
				 */
				@Override
				public void mouseHover(final MouseEvent e) {
					final Point pt = new Point(e.x, e.y);
					// Is the event's Widget a Tree (it should be)?
					if (e.widget instanceof Tree) {
						// Yes
						final Tree tree = (Tree) e.widget;
						final TreeItem treeItem = tree.getItem(pt);
						// Are we over anything?
						if (treeItem != null) {
							// Yes
							final Object obj = treeItem.getData();

							// Does it have DC meta data?
							if (obj instanceof IdentifiableDelegate) {
								// Yes
								final IdentifiableDelegate id = (IdentifiableDelegate) obj;
								final DublinCore dc = id.getDublinCore();

								final String description = dc.getDescription();
								final String creator = dc.getCreator();
								final String valid = dc.getValid();
								final String source = dc.getSource();

								// Is there a description?
								if (description != null
										&& !description.equals("")) {
									// Yes
									dcDescriptionText.setText(description);
									dcDescriptionText.setVisible(true);
								} // if
								else {
									// No
									dcDescriptionText.setVisible(false);
								}

								// Is there a creator?
								if (creator != null && !creator.equals("")) {
									// Yes
									dcCreatorText.setText(creator);
									dcCreatorText.setVisible(true);
								} // if
								else {
									// No
									dcCreatorText.setVisible(false);
								}
								// Is there a valid range?
								if (valid != null && !valid.equals("")) {
									// Yes
									dcValidText.setText(valid);
									dcValidText.setVisible(true);
								} // if
								else {
									// No
									dcValidText.setVisible(false);
								}

								// Is there a source?
								if (source != null && !source.equals("")) {
									// Yes
									dcSourceText.setText(source);
									dcSourceText.setVisible(true);
								} // if
								else {
									// No
									dcSourceText.setVisible(false);
								}

								dcTipShell.pack();

								// Now we need to figure out where to position
								// the shell containing the dublin core tool tip
								// given the size of the tool tip and the bounds
								// of the Display.
								dcTipShell.setBounds(computeHoverLocation(
										dcTipShell, control.toDisplay(pt)));

								// Make the Dublin Core tool tip visible
								dcTipShell.setVisible(true);
							} // if IConfigurationElement

							else {
								// No
								dcTipShell.setVisible(false);
							}
						} // if display DC
						else {
							// No
							dcTipShell.setVisible(false);
						}

					} // if Tree

				} // mouseHover

				/**
				 * Figure out where to position the tool tip
				 * 
				 * @param dcTipShell
				 *            the {@link Shell} that contains the dublin core
				 * @param mousePosition
				 *            the current position of the Mouse relative to the
				 *            Display
				 */
				private Rectangle computeHoverLocation(final Shell dcTipShell,
						final Point mousePosition) {
					// Get the current bounds of the toolTip
					final Rectangle retValue = dcTipShell.getBounds();

					final Rectangle displayBounds = dcTipShell.getDisplay()
							.getBounds();
					// The x position is either the current mouse position if
					// the dublin core can be displayed entirely to the right of
					// that, or a value to the left of that that allows it to be
					// displayed, with 0 being the limit.
					retValue.x = Math.max(Math.min(mousePosition.x,
							displayBounds.width - retValue.width), 0);

					// The y position is Y_OFFSET pixels below the current mouse
					// position, or if the entire dublin core won't fit in the
					// window at that position, then the lowest position above
					// that where it can, with 0 (the top of the Display) being
					// the limit
					retValue.y = Math.max(Math.min(mousePosition.y + Y_OFFSET,
							displayBounds.height - retValue.height), 0);

					return retValue;
				} // computeHoverLocation

				/**
				 * @see org.eclipse.swt.events.MouseTrackAdapter#mouseExit(org.eclipse.swt.events.MouseEvent)
				 */
				@Override
				public void mouseExit(
						@SuppressWarnings("unused") final MouseEvent e) {
					// Is the dublin core visible?
					if (dcTipShell.isVisible()) {
						// Yes
						// Not any more
						dcTipShell.setVisible(false);
					} // if visible
				} // mouseExit
			});
		} // addDCToolTipHelp
	} // DublinCoreToolTipHandler
} // IdentifiablePluginView

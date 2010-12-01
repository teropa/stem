package org.eclipse.stem.core.graph.provider;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.provider.CoreEditPlugin;
import org.eclipse.stem.core.common.provider.IdentifiableItemProvider;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.Label;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;

//import org.eclipse.stem.core.model.Model;
//import org.eclipse.stem.core.model.ModelFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.core.graph.Graph} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class GraphItemProvider extends IdentifiableItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This is a collection of the {@link TransientGraphItemProvider}'s that
	 * are playing the role of children to the graph while in fact they are
	 * "Non-Modeled Intermediary View Objects". They provide the correct method
	 * implementations to play the role of an ItemProvider. See pages 369-378 of
	 * the EMF book (1st Edition).
	 */
	private List<GraphItemProvider.TransientGraphItemProvider> children;

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated 
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTimePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * @see org.eclipse.stem.common.provider.IdentifiableItemProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object object) {
		return super.getParent(object);
	} // getParent

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<?> getChildren(Object object) {
		final Graph graph = (Graph) object;
		children = new ArrayList<TransientGraphItemProvider>();
		// This is where we add the "fake" children of a Graph. If you implement
		// more then add them here.

		// Any Edges in the Graph?
		if (graph.getNumEdges() > 0) {
			// Yes
			children.add(new GraphItemProvider.EdgesItemProvider(
					adapterFactory, graph));
		} // if Edges

		// Any Nodes in the Graph?
		if (graph.getNumNodes() > 0) {
			// Yes
			children.add(new GraphItemProvider.NodesItemProvider(adapterFactory,
					graph));
		} // if Nodes
		
		// Any NodeLabels in the Graph?
		if (graph.getNumNodeLabels() > 0) {
			// Yes
			children.add(new GraphItemProvider.NodeLabelsItemProvider(adapterFactory,
					graph));
		} // if NodeLabels
		
		// Any GraphLabels in the Graph?
		if (graph.getNumGraphLabels() > 0) {
			// Yes
			children.add(new GraphItemProvider.GraphLabelsItemProvider(adapterFactory,
					graph));
		} // if GraphLabels

		final Collection otherChildren = super.getChildren(object);
		otherChildren.addAll(children);
		return otherChildren;
	} // getChildren

	/**
	 * This adds a property descriptor for the Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Graph_time_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Graph_time_feature", "_UI_Graph_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 GraphPackage.Literals.GRAPH__TIME,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GraphPackage.Literals.GRAPH__UNRESOLVED_IDENTIFIABLES);
			childrenFeatures.add(GraphPackage.Literals.GRAPH__DECORATORS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Graph.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/customobj16/Graph"));
	} // getImage

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	} // getText
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
//	@Override
	@Override
	public String getTextGen(Object object) {
		URI labelValue = ((Graph)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Graph_type") : //$NON-NLS-1$
			getString("_UI_Graph_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Graph.class)) {
		case GraphPackage.GRAPH__NUM_EDGES:
		case GraphPackage.GRAPH__NUM_NODES:
		case GraphPackage.GRAPH__NUM_GRAPH_LABELS:
		case GraphPackage.GRAPH__NUM_NODE_LABELS:
		case GraphPackage.GRAPH__NUM_DYNAMIC_LABELS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case GraphPackage.GRAPH__EDGES:
		case GraphPackage.GRAPH__NODES:
		case GraphPackage.GRAPH__GRAPH_LABELS:
		case GraphPackage.GRAPH__UNRESOLVED_IDENTIFIABLES:
		case GraphPackage.GRAPH__NODE_LABELS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Graph.class)) {
			case GraphPackage.GRAPH__EDGES:
			case GraphPackage.GRAPH__NODES:
			case GraphPackage.GRAPH__GRAPH_LABELS:
			case GraphPackage.GRAPH__NODE_LABELS:
			case GraphPackage.GRAPH__NUM_EDGES:
			case GraphPackage.GRAPH__NUM_NODES:
			case GraphPackage.GRAPH__NUM_GRAPH_LABELS:
			case GraphPackage.GRAPH__NUM_NODE_LABELS:
			case GraphPackage.GRAPH__NUM_DYNAMIC_LABELS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GraphPackage.GRAPH__UNRESOLVED_IDENTIFIABLES:
			case GraphPackage.GRAPH__DECORATORS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}
	
	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CoreEditPlugin.INSTANCE;
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (children != null) {
			for (Iterator<TransientGraphItemProvider> iter = children.iterator(); iter.hasNext();) {
				((IDisposable) iter.next()).dispose();
			}
		}
	}

	/**
	 * This class is extended by classes that are item providers for "Non-Model
	 * Intermediary View Objects". It follows the pattern described in the book
	 * "Eclipse Modeling Framework", pages 369-378.
	 * 
	 * This is NOT a generated class.
	 */
	public static abstract class TransientGraphItemProvider extends
			ItemProviderAdapter implements IEditingDomainItemProvider,
			IStructuredItemContentProvider, ITreeItemContentProvider,
			IItemLabelProvider, IItemPropertySource {

		/**
		 * @param adapterFactory
		 */
		public TransientGraphItemProvider(AdapterFactory adapterFactory,
				final Graph graph) {
			super(adapterFactory);
			graph.eAdapters().add(this);
		} // TransientGraphItemProvider

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildrenFeatures(java.lang.Object)
		 */
		@Override
		protected Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
			if (childrenFeatures == null) {
				super.getChildrenFeatures(object);
				childrenFeatures.add(getMapReference());
			}
			return childrenFeatures;
		} // getChildrenFeatures

		
		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getFeatureValue(org.eclipse.emf.ecore.EObject,
		 *      org.eclipse.emf.ecore.EStructuralFeature)
		 */
		@Override
		protected Object getFeatureValue(EObject object,
				EStructuralFeature feature) {
			if (object == null) {
				// Yes
				return ((Graph) target).eGet(feature);
			} // if
			else {
				return super.getFeatureValue(object, feature);
			}
		} // getFeatureValue

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getParent(java.lang.Object)
		 */
		@Override
		public Object getParent(Object object) {
			return target;
		} // getParent

		/**
		 * This assumes that all children are members of a map of {@link Identifiable}s
		 */
		@Override
		public Collection<Identifiable> getChildren(Object object) {
			final Graph graph = (Graph) target;
			final List<Identifiable> children = new ArrayList<Identifiable>();
			children.addAll(  (getIdentifiableMap(graph).values()));
// SED commented out 7/23/2010. It takes a long time to sort when there's lots of labels
//			Collections.sort(children);
			return children;
		} // getChildren

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object object) {
			final StringBuilder sb = new StringBuilder(getText());
			sb.append(" (");
			sb.append(Integer.toString(getIdentifiableMap((Graph) target)
					.size()));
			sb.append(")");
			return sb.toString();
		} // getText

		/**
		 */
		@Override
		protected String getFeatureText(Object feature) {
			return super.getFeatureText(target);
		} // getFeatureText

		/**
		 * This redirects the call to the "target" (i.e., the Graph), it then
		 * returns the child descriptors which would include the Transient Graph
		 * Item providers such as this one.
		 */
		@Override
		public Collection<?> getNewChildDescriptors(Object object,
				EditingDomain editingDomain, Object sibling) {
			return super.getNewChildDescriptors(target, editingDomain, sibling);
		} // getNewChildDescriptors

		/**
		 * Return the resource locator for this item provider's resources.
		 */
		@Override
		public ResourceLocator getResourceLocator() {
			return GraphEditPlugin.INSTANCE;
		}

		/**
		 * @return the name of the Transient Graph Item Provider. (e.g.,
		 *         "Edges")
		 */
		abstract protected String getText();

		/**
		 * @param graph
		 *            the graph that will have a child added to it.
		 * @return the map of <code>Identifiable</code>s that associated with this
		 *         item provider.
		 */
		abstract protected EMap<URI,? extends Identifiable> getIdentifiableMap(Graph graph);

		/**
		 * Create the appropriate map entry to add to the map.
		 * 
		 * @param key
		 *            the URI that uniquely identifies the
		 *            <code>Identifiable</code>
		 * @param value
		 *            the value of the map entry
		 * @return a MapEntry instance
		 */
		abstract protected EObject getMapEntry(final URI key,
				final Identifiable value);

		/**
		 * @return the StructuralFeature that represents the "value" of the MapEntry
		 */
		abstract  protected EStructuralFeature getMapEntryValueEReference();
		
		/**
		 * @return the meta-reference to the feature of the graph that is the
		 *         map
		 */
		abstract protected EReference getMapReference();

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain,
		 *      org.eclipse.emf.ecore.EObject,
		 *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection)
		 */
		@Override
		protected Command createRemoveCommand(EditingDomain domain,
				EObject owner, EStructuralFeature feature, Collection<?> collection) {
			return createWrappedCommand(super.createRemoveCommand(domain,
					owner, feature, collection), owner);
		} // createRemoveCommand

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain,
		 *      org.eclipse.emf.ecore.EObject,
		 *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection,
		 *      int)
		 */
		@Override
		protected Command createAddCommand(EditingDomain domain, EObject owner,
				EStructuralFeature feature, Collection<?> collection, int index) {
			return createWrappedCommand(super.createAddCommand(domain, owner,
					feature, collection, index), owner);
		} // createAddCommand

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createDragAndDropCommand(org.eclipse.emf.edit.domain.EditingDomain,
		 *      java.lang.Object, float, int, int, java.util.Collection)
		 */
		@Override
		protected Command createDragAndDropCommand(EditingDomain domain,
				Object owner, float location, int operations, int operation,
				Collection<?> collection) {
			Command retValue = null;
			if (new AddCommand(domain, (EObject) target, getMapReference(),
					collection).canExecute()) {
				retValue = super.createDragAndDropCommand(domain, target,
						location, operations, operation, collection);
			} else {
				retValue = UnexecutableCommand.INSTANCE;
			}
			return retValue;
		} // createDragAndDropCommand

		/**
		 * Create a CreateChildCommand. It will be used to determine if a child
		 * can be added. If "canExecute" is false, then the menu entry will be
		 * grayed out.
		 */
		@Override
		protected Command createCreateChildCommand(EditingDomain domain,
				EObject owner, EStructuralFeature feature, Object value,
				int index, Collection<?> collection) {

			Command retValue = null;

			// Is the child an Identifiable?
			if (!(value instanceof Identifiable)) {
				// No
				retValue = super.createCreateChildCommand(domain, owner,
						feature, value, index, collection);
			} else {
				// Yes
				retValue = new CreateChildCommand(domain, owner, feature,
						value, index, collection, this) {
					@Override
					protected Command createCommand() {

						Command result = null;

						Graph graph = (Graph) target;
						Identifiable newChildIdentifiable = (Identifiable) child;
						final URI uri = newChildIdentifiable.getURI();

						// Does the Edge Map already contain an entry for the
						// edge's URI?
						Identifiable existingIdentifiable = getIdentifiableMap(
								graph).get(uri);

						if (existingIdentifiable == null) {
							// No
							// There isn't an existing entry. Need to create a
							// map entry and initialize it.
							final EObject mapEntry = getMapEntry(uri,
									newChildIdentifiable);

							// Now, we need to put the entry we just created
							// into the map
							result = new AddCommand(domain, graph,
									getMapReference(), mapEntry);

						} // if no existing entry
						else {
							// Yes
							// Existing label with the same URI as the one to be
							// added. Create the command that will set the value
							// to the new label
							final EObject mapEntry = existingIdentifiable
									.eContainer();
							result = new SetCommand(
									domain,
									mapEntry, 
									getMapEntryValueEReference(),
									newChildIdentifiable);
						} // else
						
						return result;
					} // createCommand

					
				}; // CreateChildCommand

			} // else
			return retValue;

		} // createCreateChildCommand

		/**
		 * 
		 * @param command
		 *            the command to be wrapped
		 * @param owner
		 *            the owner
		 * @return
		 */
		protected Command createWrappedCommand(Command command,
				final EObject owner) {
			return new CommandWrapper(command) {
				@Override
				public Collection<?> getAffectedObjects() {
					Collection<?> affected = super.getAffectedObjects();
					if (affected.contains(owner)) {
						affected = Collections
								.singleton(TransientGraphItemProvider.this);
					}
					return affected;
				} // getAffectedObjects
			};
		} // createWrappedCommand

	} // TransientGraphItemProvider

	/**
	 * This class represents a "Non-Model Intermediary View Object". It
	 * represents the "Edges" of the graph.
	 */
	public static class EdgesItemProvider extends TransientGraphItemProvider {

		/**
		 * @param adapterFactory
		 * @param graph
		 *            the graph that the Edges belong to
		 */
		public EdgesItemProvider(AdapterFactory adapterFactory, Graph graph) {
			super(adapterFactory, graph);
		} // EdgesItemProvider

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.Object)
		 */
		@Override
		public Object getImage(Object object) {
			return overlayImage(object, getResourceLocator().getImage(
					"full/customobj16/Edge"));
		}

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Graph.class)) {
			case GraphPackage.GRAPH__EDGES:
				fireNotifyChanged(new NotificationWrapper(this, msg));
				return;
			} // switch
		} // notifyChanged

		/**
		 * This determines the contents of the list of "children" that can be
		 * added to the Edges. We modify
		 * {@link GraphItemProvider#collectNewChildDescriptors(Collection, Object)}
		 * so that it doesn't return "Edges" as an option to be created under
		 * Graph. Of those children, this is where we create "Edges".
		 * 
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#collectNewChildDescriptors(java.util.Collection,
		 *      java.lang.Object)
		 */
		@Override
		protected void collectNewChildDescriptors(
				Collection<Object> newChildDescriptors, Object object) {
			super.collectNewChildDescriptors(newChildDescriptors, object);
			newChildDescriptors.add(createChildParameter(GraphPackage.eINSTANCE
					.getGraph_Edges(), GraphFactory.eINSTANCE.createEdge()));
		} // collectNewChildDescriptors

		/**
		 * @see TransientGraphItemProvider#getText(java.lang.Object)
		 */
		@Override
		protected String getText() {
			// TODO NLS "Edges"
			return "Edges";
		} // getText

		/**
		 * @see org.eclipse.stem.graph.provider.TransientGraphItemProvider#getIdentifiableMap(org.eclipse.stem.graph.Graph)
		 */
		@Override
		protected EMap<URI,Edge> getIdentifiableMap(Graph graph) {
			return graph.getEdges();
		} // getIdentifiableMap

		@Override
		protected EObject getMapEntry(URI key, Identifiable value) {

			// Use reflection since
			// there is no generated API for map entries.
			final EObject retValue = GraphFactory.eINSTANCE
					.create(GraphPackage.Literals.URI_TO_EDGE_MAP_ENTRY);
			retValue
					.eSet(GraphPackage.Literals.URI_TO_EDGE_MAP_ENTRY__KEY, key);
			retValue.eSet(GraphPackage.Literals.URI_TO_EDGE_MAP_ENTRY__VALUE,
					value);
			return retValue;

		} // getMapEntry
		
		@Override
		protected EStructuralFeature getMapEntryValueEReference() {
			return GraphPackage.eINSTANCE.getURIToEdgeMapEntry_Value();
		} // getMapEntryValueEReference
		

		/**
		 * @see org.eclipse.stem.graph.provider.TransientGraphItemProvider#getMapReference()
		 */
		@Override
		protected EReference getMapReference() {
			return GraphPackage.Literals.GRAPH__EDGES;
		} // getMapReference

	} // EdgesItemProvider

	/**
	 * This class represents a "Non-Model Intermediary View Object". It
	 * represents the "Nodes" of the graph.
	 */
	protected static class NodesItemProvider extends TransientGraphItemProvider {

		/**
		 * @param adapterFactory
		 * @param graph
		 */
		public NodesItemProvider(AdapterFactory adapterFactory, Graph graph) {
			super(adapterFactory, graph);
		}

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.Object)
		 */
		@Override
		public Object getImage(Object object) {
			return overlayImage(object, getResourceLocator().getImage(
					"full/customobj16/Node"));
		}

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Graph.class)) {
			case GraphPackage.GRAPH__NODES:
				fireNotifyChanged(new NotificationWrapper(this, msg));
				return;
			} // switch
		} // notifyChanged

		/**
		 * This determines the contents of the list of "children" that can be
		 * added to the Nodes. We modify
		 * {@link GraphItemProvider#collectNewChildDescriptors(Collection, Object)}
		 * so that it doesn't return "Nodes" as an option to be created under
		 * Graph. Of those children, this is where we create "Nodes".
		 * 
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#collectNewChildDescriptors(java.util.Collection,
		 *      java.lang.Object)
		 */
		@Override
		protected void collectNewChildDescriptors(
				Collection<Object> newChildDescriptors, Object object) {
			super.collectNewChildDescriptors(newChildDescriptors, object);
			newChildDescriptors.add(createChildParameter(GraphPackage.eINSTANCE
					.getGraph_Nodes(), GraphFactory.eINSTANCE.createNode()));
		} // collectNewChildDescriptors

		/**
		 * @see TransientGraphItemProvider#getText(java.lang.Object)
		 */
		@Override
		protected String getText() {
			// TODO NLS "Nodes"
			return "Nodes";
		} // getText

		/**
		 * @see org.eclipse.stem.graph.provider.GraphItemProvider.TransientGraphItemProvider#getIdentifiableMap(org.eclipse.stem.graph.Graph)
		 */
		@Override
		protected EMap<URI,Node> getIdentifiableMap(Graph graph) {
			return graph.getNodes();
		}

		@Override
		protected EObject getMapEntry(URI key, Identifiable value) {

			// Use reflection since
			// there is no generated API for map entries.
			final EObject retValue = GraphFactory.eINSTANCE
					.create(GraphPackage.Literals.URI_TO_NODE_MAP_ENTRY);
			retValue
					.eSet(GraphPackage.Literals.URI_TO_NODE_MAP_ENTRY__KEY, key);
			retValue.eSet(GraphPackage.Literals.URI_TO_NODE_MAP_ENTRY__VALUE,
					value);
			return retValue;

		} // getMapEntry
		
		@Override
		protected EStructuralFeature getMapEntryValueEReference() {
			return GraphPackage.eINSTANCE.getURIToNodeMapEntry_Value();
		} // getMapEntryValueEReference
		
		/**
		 * @see org.eclipse.stem.graph.provider.GraphItemProvider.TransientGraphItemProvider#getMapReference()
		 */
		@Override
		protected EReference getMapReference() {
			return GraphPackage.Literals.GRAPH__NODES;
		}

	} // NodesItemProvider

	/**
	 * This class represents a "Non-Model Intermediary View Object". It
	 * represents the "Node Labels" of the graph.
	 */
	protected static class NodeLabelsItemProvider extends
			TransientGraphItemProvider {

		/**
		 * @param adapterFactory
		 * @param graph
		 */
		public NodeLabelsItemProvider(AdapterFactory adapterFactory, Graph graph) {
			super(adapterFactory, graph);
		}

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.Object)
		 */
		@Override
		public Object getImage(Object object) {
			return overlayImage(object, getResourceLocator().getImage(
					"full/customobj16/StaticLabel"));
		} // getImage

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Graph.class)) {
			case GraphPackage.GRAPH__NODE_LABELS:
				fireNotifyChanged(new NotificationWrapper(this, msg));
				return;
			} // switch
		} // notifyChanged

		/**
		 * This determines the contents of the list of "children" that can be
		 * added to the Node Labels. We modify
		 * {@link GraphItemProvider#collectNewChildDescriptors(Collection, Object)}
		 * so that it doesn't return "Node Labels" as an option to be created
		 * under Graph. Of those children, this is where we create "Node
		 * Labels".
		 * 
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#collectNewChildDescriptors(java.util.Collection,
		 *      java.lang.Object)
		 */
		@Override
		protected void collectNewChildDescriptors(
				Collection<Object> newChildDescriptors, Object object) {
			super.collectNewChildDescriptors(newChildDescriptors, object);
//			 TODO fix GraphItenProvider.collectNewChildDescriptors
//			newChildDescriptors.add(createChildParameter(GraphPackage.eINSTANCE
//					.getGraph_NodeLabels(), GraphFactory.eINSTANCE
//					.createLabel()));
		} // collectNewChildDescriptors

		/**
		 * @see TransientGraphItemProvider#getText(java.lang.Object)
		 */
		@Override
		protected String getText() {
			// TODO NLS "Node Labels"
			return "Node Labels";
		} // getText

		/**
		 * @see org.eclipse.stem.graph.provider.GraphItemProvider.TransientGraphItemProvider#getIdentifiableMap(org.eclipse.stem.graph.Graph)
		 */
		@Override
		protected EMap<URI,NodeLabel> getIdentifiableMap(Graph graph) {
			return graph.getNodeLabels();
		}

		@Override
		protected EObject getMapEntry(URI key, Identifiable value) {

			// Use reflection since
			// there is no generated API for map entries.
			final EObject retValue = GraphFactory.eINSTANCE
					.create(GraphPackage.Literals.URI_TO_NODE_LABEL_MAP_ENTRY);
			retValue
					.eSet(GraphPackage.Literals.URI_TO_NODE_LABEL_MAP_ENTRY__KEY, key);
			retValue.eSet(GraphPackage.Literals.URI_TO_NODE_LABEL_MAP_ENTRY__VALUE,
					value);
			return retValue;

		} // getMapEntry
		
		@Override
		protected EStructuralFeature getMapEntryValueEReference() {
			return GraphPackage.eINSTANCE.getURIToNodeLabelMapEntry_Value();
		} // getMapEntryValueEReference
		
		/**
		 * @see org.eclipse.stem.graph.provider.GraphItemProvider.TransientGraphItemProvider#getMapReference()
		 */
		@Override
		protected EReference getMapReference() {
			return GraphPackage.Literals.GRAPH__NODE_LABELS;
		}

	} // NodeLabelsItemProvider

	/**
	 * This class represents a "Non-Model Intermediary View Object". It
	 * represents the "Graph Labels" of the graph.
	 */
	protected static class GraphLabelsItemProvider extends
			TransientGraphItemProvider {

		/**
		 * @param adapterFactory
		 * @param graph
		 */
		public GraphLabelsItemProvider(AdapterFactory adapterFactory,
				Graph graph) {
			super(adapterFactory, graph);
		}

		/**
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.Object)
		 */
		@Override
		public Object getImage(Object object) {
			return overlayImage(object, getResourceLocator().getImage(
					"full/customobj16/StaticLabel"));
		} // getImage

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Graph.class)) {
			case GraphPackage.GRAPH__GRAPH_LABELS:
				fireNotifyChanged(new NotificationWrapper(this, msg));
				return;
			} // switch
		} // notifyChanged

		/**
		 * This determines the contents of the list of "children" that can be
		 * added to the Graph Labels. We modify
		 * {@link GraphItemProvider#collectNewChildDescriptors(Collection, Object)}
		 * so that it doesn't return "Graph Labels" as an option to be created
		 * under Graph. Of those children, this is where we create "Graph
		 * Labels".
		 * 
		 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#collectNewChildDescriptors(java.util.Collection,
		 *      java.lang.Object)
		 */
		@Override
		protected void collectNewChildDescriptors(
				Collection<Object> newChildDescriptors, Object object) {
			super.collectNewChildDescriptors(newChildDescriptors, object);
			
//			 TODO fix GraphLabelsItemProvider.collectNewChildDescriptors
//			newChildDescriptors.add(createChildParameter(GraphPackage.eINSTANCE
//					.getGraph_GraphLabels(), GraphFactory.eINSTANCE
//					.createLabel()));
		} // collectNewChildDescriptors

		/**
		 * @see TransientGraphItemProvider#getText(java.lang.Object)
		 */
		@Override
		protected String getText() {
			// TODO NLS "GraphLabels"
			return "Graph Labels";
		} // getText

		/**
		 * @see org.eclipse.stem.graph.provider.GraphItemProvider.TransientGraphItemProvider#getIdentifiableMap(org.eclipse.stem.graph.Graph)
		 */
		@Override
		protected EMap<URI,Label> getIdentifiableMap(Graph graph) {
			return graph.getGraphLabels();
		}

		@Override
		protected EObject getMapEntry(URI key, Identifiable value) {

			// Use reflection since
			// there is no generated API for map entries.
			final EObject retValue = GraphFactory.eINSTANCE
					.create(GraphPackage.Literals.URI_TO_LABEL_MAP_ENTRY);
			retValue
					.eSet(GraphPackage.Literals.URI_TO_LABEL_MAP_ENTRY__KEY, key);
			retValue.eSet(GraphPackage.Literals.URI_TO_LABEL_MAP_ENTRY__VALUE,
					value);
			return retValue;

		} // getMapEntry
		
		@Override
		protected EStructuralFeature getMapEntryValueEReference() {
			return GraphPackage.eINSTANCE.getURIToLabelMapEntry_Value();
		} // getMapEntryValueEReference
		
		/**
		 * @see org.eclipse.stem.graph.provider.GraphItemProvider.TransientGraphItemProvider#getMapReference()
		 */
		@Override
		protected EReference getMapReference() {
			return GraphPackage.Literals.GRAPH__GRAPH_LABELS;
		}

	} // GraphLabelsItemProvider

} // GraphItemProvider

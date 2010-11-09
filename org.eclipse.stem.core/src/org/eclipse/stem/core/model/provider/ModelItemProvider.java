package org.eclipse.stem.core.model.provider;

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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.provider.CoreEditPlugin;
import org.eclipse.stem.core.common.provider.IdentifiableItemProvider;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphFactory;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.swt.dnd.DND;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.core.model.Model} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelItemProvider
	extends IdentifiableItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.MODEL__MODELS);
			childrenFeatures.add(ModelPackage.Literals.MODEL__GRAPHS);
			childrenFeatures.add(ModelPackage.Literals.MODEL__GRAPH_DECORATORS);
			childrenFeatures.add(ModelPackage.Literals.MODEL__NODE_DECORATORS);
			childrenFeatures.add(ModelPackage.Literals.MODEL__EDGE_DECORATORS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.
		Object temp = child;
		if (child instanceof IFile) {
			// Yes
			final IFile iFile = (IFile) child;
			final URI uri = URI.createFileURI(iFile.getLocation().toString()); 
			final Identifiable identifable = Utility.getIdentifiable(uri);
			temp = identifable;
		} // if IFile
		
		else if (child instanceof String) {
			// Yes
			// These come from IdentifablePluginView
			final String uriString = (String) child;
			try {
				final URI uri = URI.createURI(uriString);
				final Identifiable identifable  = Utility.getIdentifiable(uri);
				temp = identifable;
			} catch (Exception e) {
				// Ignore it
			}
		} // if String

		if (temp instanceof Identifiable) {
			return super.getChildFeature(object, temp);
		} else
			return super.getChildFeature(object, child);

	} // getChildFeature

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeatureGen(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}
	
	/**
	 * This returns Model.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
//		return getImageGen(object);
		return overlayImage(object, getResourceLocator().getImage("full/customobj16/Model"));
	}
	
	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	} // getText

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	@Override
	@Override
	public String getTextGen(Object object) {
		URI labelValue = ((Model)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Model_type") : //$NON-NLS-1$
			getString("_UI_Model_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Model.class)) {
			case ModelPackage.MODEL__MODELS:
			case ModelPackage.MODEL__GRAPHS:
			case ModelPackage.MODEL__GRAPH_DECORATORS:
			case ModelPackage.MODEL__NODE_DECORATORS:
			case ModelPackage.MODEL__EDGE_DECORATORS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.MODEL__MODELS,
				 ModelFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.MODEL__GRAPHS,
				 GraphFactory.eINSTANCE.createGraph()));
	}

	
	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createDragAndDropCommand(org.eclipse.emf.edit.domain.EditingDomain, java.lang.Object, float, int, int, java.util.Collection)
	 */
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain,
			Object owner, float location, int operations, int operation,
			Collection<?> collection) {
		// We add DND.DROP_LINK as an allowed operation because all drops will
		// be links and some sources don't allow links, we convert to links anyway
		return super.createDragAndDropCommand(domain, owner, location, operations | DND.DROP_LINK,
				operation, collection);
	} // createDragAndDropCommand

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection, int index) {
		final Collection identifiableCollection = new ArrayList();
		for (Object value : collection) {

			Object temp = value;
			if (value instanceof IFile) {
				// Yes
				final IFile iFile = (IFile) value;
				final URI uri = URI.createFileURI(iFile.getLocation()
						.toString());
				final Identifiable identifable = Utility.getIdentifiable(uri);
				identifiableCollection.add(identifable);
				temp = identifable;
			} // if IFile

			else if (value instanceof String) {
				// Yes
				final String uriString = (String) value;
				try {
					final URI uri = URI.createURI(uriString);
					final Identifiable identifable = Utility
							.getIdentifiable(uri);
					temp = identifable;
				} catch (Exception e) {
					// Ignore it
				}
			} // if String

			if (temp instanceof Identifiable) {
				identifiableCollection.add(temp);
			}
		} // for each Object

		return super.createAddCommand(domain, owner, feature,
				identifiableCollection, index);
	} // createAddCommand

	@Override
	protected Command createCreateChildCommand(EditingDomain domain,
			EObject owner, EStructuralFeature feature, Object value, int index,
			Collection<?> collection) {
		
		return new CreateChildCommand(domain,owner,feature,value,index,collection,this) {
		
			@Override
			protected Command createCommand() {

				Command retValue = null;

				final Command createChildCommand = super.createCommand();

				final Resource parentResource = owner.eResource();
				// Are we creating a Model or a Graph?
				if (parentResource != null && (child instanceof Model || child instanceof Graph)) {
					// Yes
					final EObject temp = (EObject) child;
					// Does the child have a resource already?
					if (temp.eResource() == null) {
						// No
						final Command addCommand = new AddCommand(domain,
								parentResource.getContents(), temp);

						final CompoundCommand compoundCommand = new CompoundCommand(
								0, createChildCommand.getLabel(),
								createChildCommand.getDescription());
						compoundCommand.append(createChildCommand);
						compoundCommand.append(addCommand);
						retValue = compoundCommand;
					} // if Model does not have a resource
				} // if Model
				else {
					retValue = createChildCommand;
				}

				return retValue;
			} // createCommand
		
		}; // CreateChildCommand
		
	} // createCreateChildCommand

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#isWrappingNeeded(java.lang.Object)
	 */
	@Override
	protected boolean isWrappingNeeded(Object object) {
		// return super.isWrappingNeeded(object);
		// We return true so that non-containment references are wrapped. This
		// enables the delete command in the editor's context menu.
		return true;
	} // isWrappingNeeded
	
	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CoreEditPlugin.INSTANCE;
	}

}

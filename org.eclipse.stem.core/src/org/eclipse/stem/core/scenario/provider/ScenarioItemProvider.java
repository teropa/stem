package org.eclipse.stem.core.scenario.provider;

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
import java.util.Arrays;
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
//import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
//import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
//import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.provider.CoreEditPlugin;
import org.eclipse.stem.core.common.provider.IdentifiableItemProvider;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.swt.dnd.DND;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.stem.core.scenario.Scenario} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ScenarioItemProvider extends IdentifiableItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ScenarioItemProvider(AdapterFactory adapterFactory) {
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

			addSolverPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * This adds a property descriptor for the Solver feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSolverPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Scenario_solver_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Scenario_solver_feature", "_UI_Scenario_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ScenarioPackage.Literals.SCENARIO__SOLVER,
				 true,
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ScenarioPackage.Literals.SCENARIO__MODEL);
			childrenFeatures.add(ScenarioPackage.Literals.SCENARIO__SEQUENCER);
			childrenFeatures.add(ScenarioPackage.Literals.SCENARIO__SCENARIO_DECORATORS);
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
	 * This returns Scenario.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/customobj16/Scenario"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextGen(Object object) {
		URI labelValue = ((Scenario)object).getURI();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Scenario_type") : //$NON-NLS-1$
			getString("_UI_Scenario_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Scenario.class)) {
			case ScenarioPackage.SCENARIO__PROGRESS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ScenarioPackage.SCENARIO__MODEL:
			case ScenarioPackage.SCENARIO__SEQUENCER:
			case ScenarioPackage.SCENARIO__SCENARIO_DECORATORS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ScenarioPackage.Literals.SCENARIO__MODEL,
				 ModelFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(ScenarioPackage.Literals.SCENARIO__SEQUENCER,
				 SequencerFactory.eINSTANCE.createSequentialSequencer()));

		newChildDescriptors.add
			(createChildParameter
				(ScenarioPackage.Literals.SCENARIO__SEQUENCER,
				 SequencerFactory.eINSTANCE.createRealTimeSequencer()));
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
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

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object, int)
	 */
	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value, int index) {
		// Are we setting the model during a drag and drop?
		Object temp = value;

		if (value instanceof IFile) {
			// Yes
			final IFile iFile = (IFile) value;
			final URI uri = URI.createFileURI(iFile.getLocation().toString());
			final Identifiable identifable = Utility.getIdentifiable(uri);
			temp = identifable;
		} // if IFile

		else if (value instanceof String) {
			// Yes
			// These come from IdentifablePluginView
			final String uriString = (String) value;
			try {
				final URI uri = URI.createURI(uriString);
				final Identifiable identifable = Utility.getIdentifiable(uri);
				temp = identifable;
			} catch (Exception e) {
				// Ignore it
			}
		} // if String

		if (temp instanceof Model) {
			return super.createSetCommand(domain, owner,
					ScenarioPackage.eINSTANCE.getScenario_Model(), temp, index);
		} else if (temp instanceof Sequencer) {
			return super.createSetCommand(domain, owner,
					ScenarioPackage.eINSTANCE.getScenario_Sequencer(), temp,
					index);
		} // if
		else if (temp instanceof Decorator) {
			return super
					.createAddCommand(
							domain,
							owner,
							ScenarioPackage.eINSTANCE
									.getScenario()
									.getEStructuralFeature(
											ScenarioPackage.SCENARIO__SCENARIO_DECORATORS),
							Arrays.asList((new Object[] { temp })), index);
		} // if
		else {

			return super.createSetCommand(domain, owner, feature, value, index);
		}
	} // createSetCommand

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createDragAndDropCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, float, int, int, java.util.Collection)
	 */
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain,
			Object owner, float location, int operations, int operation,
			Collection<?> collection) {
		// We add DND.DROP_LINK as an allowed operation because all drops will
		// be links and some sources don't allow links, we convert to links
		// anyway
		return super.createDragAndDropCommand(domain, owner, location,
				operations | DND.DROP_LINK, operation, collection);
	} // createDragAndDropCommand

	@Override
	protected Command createCreateChildCommand(EditingDomain domain,
			EObject owner, EStructuralFeature feature, Object value, int index,
			Collection<?> collection) {

		return new CreateChildCommand(domain, owner, feature, value,
				collection, this) {
			/**
			 * @see org.eclipse.emf.edit.command.CreateChildCommand#createCommand()
			 */
			@Override
			protected Command createCommand() {

				Command retValue = null;

				final Command createChildCommand = super.createCommand();

				// Are we creating a Model?
				if (child instanceof Model) {
					// Yes
					final Model model = (Model) child;
					// Does the model have a resource already?
					if (model.eResource() == null) {
						// No
						final Resource parentResource = owner.eResource();
						final Command addCommand = new AddCommand(domain,
								parentResource.getContents(), model);

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
			}
		}; // CreateChildCommand

	}// createCreateChildCommand

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
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CoreEditPlugin.INSTANCE;
	}

} // ScenarioItemProvider

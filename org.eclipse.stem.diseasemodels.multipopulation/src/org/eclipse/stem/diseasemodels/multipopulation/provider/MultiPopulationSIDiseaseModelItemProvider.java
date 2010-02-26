/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.multipopulation.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.stem.core.common.CommonFactory;

import org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel;
import org.eclipse.stem.diseasemodels.multipopulation.MultipopulationPackage;

import org.eclipse.stem.diseasemodels.standard.provider.StandardDiseaseModelItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.stem.diseasemodels.multipopulation.MultiPopulationSIDiseaseModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiPopulationSIDiseaseModelItemProvider
	extends StandardDiseaseModelItemProvider
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
	public MultiPopulationSIDiseaseModelItemProvider(AdapterFactory adapterFactory) {
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

			addPopulationGroupsPropertyDescriptor(object);
			addTransmissionRatePropertyDescriptor(object);
			addRecoveryRatePropertyDescriptor(object);
			addInfectiousMortalityRatePropertyDescriptor(object);
			addPhysicallyAdjacentInfectiousProportionPropertyDescriptor(object);
			addRoadNetworkInfectiousProportionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Population Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPopulationGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiPopulationSIDiseaseModel_populationGroups_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiPopulationSIDiseaseModel_populationGroups_feature", "_UI_MultiPopulationSIDiseaseModel_type"),
				 MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transmission Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransmissionRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiPopulationSIDiseaseModel_transmissionRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiPopulationSIDiseaseModel_transmissionRate_feature", "_UI_MultiPopulationSIDiseaseModel_type"),
				 MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Recovery Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRecoveryRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiPopulationSIDiseaseModel_recoveryRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiPopulationSIDiseaseModel_recoveryRate_feature", "_UI_MultiPopulationSIDiseaseModel_type"),
				 MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Infectious Mortality Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInfectiousMortalityRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiPopulationSIDiseaseModel_infectiousMortalityRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiPopulationSIDiseaseModel_infectiousMortalityRate_feature", "_UI_MultiPopulationSIDiseaseModel_type"),
				 MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__INFECTIOUS_MORTALITY_RATE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Physically Adjacent Infectious Proportion feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhysicallyAdjacentInfectiousProportionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiPopulationSIDiseaseModel_physicallyAdjacentInfectiousProportion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiPopulationSIDiseaseModel_physicallyAdjacentInfectiousProportion_feature", "_UI_MultiPopulationSIDiseaseModel_type"),
				 MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Road Network Infectious Proportion feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoadNetworkInfectiousProportionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultiPopulationSIDiseaseModel_roadNetworkInfectiousProportion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultiPopulationSIDiseaseModel_roadNetworkInfectiousProportion_feature", "_UI_MultiPopulationSIDiseaseModel_type"),
				 MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS);
			childrenFeatures.add(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MultiPopulationSIDiseaseModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MultiPopulationSIDiseaseModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MultiPopulationSIDiseaseModel)object).getDiseaseName();
		return label == null || label.length() == 0 ?
			getString("_UI_MultiPopulationSIDiseaseModel_type") :
			getString("_UI_MultiPopulationSIDiseaseModel_type") + " " + label;
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

		switch (notification.getFeatureID(MultiPopulationSIDiseaseModel.class)) {
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__TRANSMISSION_RATE:
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__PHYSICALLY_ADJACENT_INFECTIOUS_PROPORTION:
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__ROAD_NETWORK_INFECTIOUS_PROPORTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS:
			case MultipopulationPackage.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE:
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
				(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__POPULATION_GROUPS,
				 CommonFactory.eINSTANCE.createStringValueList()));

		newChildDescriptors.add
			(createChildParameter
				(MultipopulationPackage.Literals.MULTI_POPULATION_SI_DISEASE_MODEL__RECOVERY_RATE,
				 CommonFactory.eINSTANCE.createDoubleValueList()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MultipopulationEditPlugin.INSTANCE;
	}

}

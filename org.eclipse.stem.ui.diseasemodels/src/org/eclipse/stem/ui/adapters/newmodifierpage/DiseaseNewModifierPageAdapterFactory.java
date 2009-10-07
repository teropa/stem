// DiseaseNewModifierPageAdapterFactory.java
package org.eclipse.stem.ui.adapters.newmodifierpage;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory;
import org.eclipse.stem.ui.wizards.StandardDiseaseModelPropertyEditor;
import org.eclipse.stem.ui.wizards.DiseaseWizardMessages;
import org.eclipse.stem.ui.wizards.NewModifierPage;
import org.eclipse.ui.IStartup;

/**
 * This class is an {@link NewModifierPageAdapterFactory} that adapts
 * {@link DiseaseModel}s to {@link NewModifierPage}s.
 */
public class DiseaseNewModifierPageAdapterFactory extends
		StandardAdapterFactory implements NewModifierPageAdapterFactory, IStartup {

	/**
	 * Default constructor.
	 */
	public DiseaseNewModifierPageAdapterFactory() {
		super();
		NewModifierPageAdapterFactory.INSTANCE.addAdapterFactory(this);
	}

	/**
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup() {
		// Nothing to do the constructor will do everything.		
	}

	/**
	 * @see org.eclipse.stem.core.scenario.util.ScenarioAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object type) {
		return type == NewModifierPageAdapter.class || super.isFactoryForType(type);
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory#createDiseaseModelAdapter()
	 */
	@Override
	public Adapter createDiseaseModelAdapter() {
		return new DiseaseNewModifierPageAdapter();
	}

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory#createDiseaseModelAdapter()
	 */
	@Override
	public Adapter createSIInfectorAdapter() {
		return new SIInfectorNewModifierPageAdapter();
	}

	/**
	 * This class adapts {@link DiseaseModel}s to {@link NewModifierPage}s
	 */
	private static class DiseaseNewModifierPageAdapter extends
			NewModifierPageAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapter#createNewModifierPage()
		 */
		@Override
		public NewModifierPage createNewModifierPage() {
			return new NewModifierPage((Identifiable) getTarget()) {
				@Override
				protected boolean isUserSpecifiedProperty(
						final EStructuralFeature feature) {
					return StandardDiseaseModelPropertyEditor
							.isUserSpecifiedDiseaseModelProperty(feature);
				} // isUserSpecifiedProperty

				@Override
				protected String getBottomText() {
					return DiseaseWizardMessages.getString("PMTP_Def");
				}

				@Override
				protected boolean isModifiableProperty(
						final EStructuralFeature feature) {
					boolean retValue = super.isModifiableProperty(feature);

					retValue = retValue
							&& !feature.equals(StandardPackage.eINSTANCE
									.getDiseaseModel_DiseaseName());
					retValue = retValue
							&& !feature.equals(StandardPackage.eINSTANCE
									.getDiseaseModel_PopulationIdentifier());

					return retValue;
				} // isModifiableProperty
			};
		} // createNewModifierPage

	} // DiseaseNewModifierPageAdapter

	/**
	 * This class adapts {@link SIInfector}s to {@link NewModifierPage}s
	 */
	private static class SIInfectorNewModifierPageAdapter extends
			NewModifierPageAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapter#createNewModifierPage()
		 */
		@Override
		public NewModifierPage createNewModifierPage() {
			return new NewModifierPage((Identifiable) getTarget()) {
				@Override
				protected boolean isUserSpecifiedProperty(
						final EStructuralFeature feature) {
					boolean retValue = super.isUserSpecifiedProperty(feature);
					
					retValue = retValue && !feature.equals(StandardPackage.eINSTANCE.getInfector_TargetURI());
					
					return retValue;
				} // isUserSpecifiedProperty

				@Override
				protected String getBottomText() {
					return "";
				}

				@Override
				protected boolean isModifiableProperty(
						final EStructuralFeature feature) {
					boolean retValue = super.isModifiableProperty(feature);

					retValue = retValue
							&& !feature.equals(StandardPackage.eINSTANCE.getInfector_PopulationIdentifier());

					return retValue;
				} // isModifiableProperty
			};
		} // createNewModifierPage

	} // DiseaseNewModifierPageAdapter
} // DiseaseNewModifierPageAdapterFactory

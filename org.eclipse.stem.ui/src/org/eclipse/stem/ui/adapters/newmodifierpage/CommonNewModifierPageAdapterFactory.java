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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.util.CommonAdapterFactory;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;
import org.eclipse.stem.diseasemodels.standard.util.StandardAdapterFactory;
import org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapter;
import org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapterFactory;
import org.eclipse.stem.ui.wizards.NewModifierPage;
import org.eclipse.ui.IStartup;

/**
 * This class is an {@link NewModifierPageAdapterFactory} that adapts
 * {@link DiseaseModel}s to {@link NewModifierPage}s.
 */
public class CommonNewModifierPageAdapterFactory extends
		CommonAdapterFactory implements NewModifierPageAdapterFactory, IStartup {

	/**
	 * Default constructor.
	 */
	public CommonNewModifierPageAdapterFactory() {
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


	@Override
	public Adapter createDoubleValueAdapter() {
		return new CommonNewModifierPageAdapter();
	}

	@Override
	public Adapter createStringValueAdapter() {
		return new CommonNewModifierPageAdapter();
	}
	
/**
	 * This class adapts {@link DiseaseModel}s to {@link NewModifierPage}s
	 */
	private static class CommonNewModifierPageAdapter extends
			NewModifierPageAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapter#createNewModifierPage()
		 */
		@Override
		public NewModifierPage createNewModifierPage() {
			return new NewModifierPage((EObject) getTarget()) {
				@Override
				protected boolean isUserSpecifiedProperty(
						final EStructuralFeature feature) {
					boolean retValue = false;
					final EClass containingClass = feature.getEContainingClass();
					// Is it a disease model property?
					if (containingClass.equals(CommonPackage.eINSTANCE.getDoubleValue())
							|| containingClass.getEAllSuperTypes().contains(
									CommonPackage.eINSTANCE.getDoubleValue()) || 
									containingClass.equals(CommonPackage.eINSTANCE.getStringValue())
									|| containingClass.getEAllSuperTypes().contains(
											CommonPackage.eINSTANCE.getStringValue())) {
									
						// Yes
						retValue = true;
					} // if a disease model property
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

					return retValue;
				} // isModifiableProperty
			};
		} // createNewModifierPage

	} // 

} // 

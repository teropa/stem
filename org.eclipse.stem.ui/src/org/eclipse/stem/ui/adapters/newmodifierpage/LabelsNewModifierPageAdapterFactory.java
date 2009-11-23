// LabelsNewModifierPageAdapterFactory.java
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
import org.eclipse.stem.definitions.labels.LabelsPackage;
import org.eclipse.stem.definitions.labels.util.LabelsAdapterFactory;
import org.eclipse.stem.ui.adapters.newmodifierpage.GraphNewModifierPageAdapterFactory.StaticLabelNewModifierPageAdapter;
import org.eclipse.stem.ui.wizards.NewModifierPage;

/**
 * This class is an {@link NewModifierPageAdapterFactory} that adapts members of
 * the Label model to {@link NewModifierPage}s.
 */
public class LabelsNewModifierPageAdapterFactory extends LabelsAdapterFactory
		implements NewModifierPageAdapterFactory {

	/**
	 * Default constructor
	 */
	public LabelsNewModifierPageAdapterFactory() {
		super();
		NewModifierPageAdapterFactory.INSTANCE.addAdapterFactory(this);
	}

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return type == NewModifierPageAdapter.class
				|| super.isFactoryForType(type);
	}

	/**
	 * @see org.eclipse.stem.definitions.labels.util.LabelsAdapterFactory#createPhysicalRelationshipLabelAdapter()
	 */
	@Override
	public Adapter createPhysicalRelationshipLabelAdapter() {
		return new PhysicalRelationshipLabelNewModifierPageAdapter();
	}

	/**
	 * This class is extended by classes that adapt
	 * {@link org.eclipse.stem.definitions.labels.PhysicalRelationshipLabel}s to {@link NewModifierPage}s.
	 */
	public class PhysicalRelationshipLabelNewModifierPageAdapter extends
			StaticLabelNewModifierPageAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.newmodifierpage.GraphNewModifierPageAdapterFactory.StaticLabelNewModifierPageAdapter#createNewModifierPage()
		 */
		@Override
		public NewModifierPage createNewModifierPage() {
			return new GraphNewModifierPageAdapterFactory.StaticLabelNewModifierPage(
					(Identifiable) getTarget()) {
				@Override
				protected boolean isUserSpecifiedProperty(
						EStructuralFeature feature) {
					boolean retValue = super.isUserSpecifiedProperty(feature);

					retValue = retValue
							&& !(feature
									.equals(LabelsPackage.Literals.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__ADJACENT));

					retValue = retValue
							&& !(feature
									.equals(LabelsPackage.Literals.RELATIVE_PHYSICAL_RELATIONSHIP_LABEL_VALUE__RELATIONSHIP));

					return retValue;
				} // isUserSpecifiedProperty
			};
		} // createNewModifierPage
		
	} // PhysicalRelationshipNewModifierPageAdapter
} // LabelsNewModifierPageAdapterFactory

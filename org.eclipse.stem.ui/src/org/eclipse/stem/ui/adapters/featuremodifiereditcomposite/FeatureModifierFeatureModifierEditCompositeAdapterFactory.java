// FeatureModifierFeatureModifierEditCompositeAdapterFactory.java
package org.eclipse.stem.ui.adapters.featuremodifiereditcomposite;

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

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * This class is an adapter factory that adapts {@link org.eclipse.stem.core.modifier.FeatureModifier}s to
 * {@link org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite}s.
 */
public interface FeatureModifierFeatureModifierEditCompositeAdapterFactory {

	/**
	 * Singleton instance of the adapter factory.
	 */
	FeatureModifierEditCompositeAdapterFactoryImpl INSTANCE = new FeatureModifierEditCompositeAdapterFactoryImpl();

	/**
	 * This class is the {@link ComposedAdapterFactory} that other
	 * {@link FeatureModifierFeatureModifierEditCompositeAdapterFactory}s add
	 * themselves to.
	 */
	class FeatureModifierEditCompositeAdapterFactoryImpl extends
			ComposedAdapterFactory implements
			FeatureModifierFeatureModifierEditCompositeAdapterFactory {

		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(final Object type) {
			return type == FeatureModifierEditCompositeAdapter.class;
		}
	} // FeatureModifierEditCompositeAdapterFactoryImpl

} // FeatureModifierFeatureModifierEditCompositeAdapterFactory

// NewModifierPageAdapterFactory.java
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

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.ui.wizards.NewModifierPage;

/**
 * This class is an adapter factory that adapts {@link Identifiable}s to
 * {@link NewModifierPage}s.
 */
public interface NewModifierPageAdapterFactory {

	/**
	 * Singleton instance of the adapter factory.
	 */
	NewModifierPageAdatperFactoryImpl INSTANCE = new NewModifierPageAdatperFactoryImpl();

	/**
	 * This class is the {@link ComposedAdapterFactory} that other
	 * {@link NewModifierPageAdapterFactory}s add themselves to.
	 */
	class NewModifierPageAdatperFactoryImpl extends ComposedAdapterFactory
			implements NewModifierPageAdapterFactory {

		/**
		 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#isFactoryForType(java.lang.Object)
		 */
		@Override
		public boolean isFactoryForType(Object type) {
			return type == NewModifierPageAdapter.class
					|| super.isFactoryForType(type);
		}

	} // IdentifiableNewModifierPageAdatperFactoryImpl

} // NewModifierPageAdapterFactory

// NewModifierPageAdapter.java
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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.stem.ui.wizards.NewModifierPage;

/**
 * This class is extended by classes that adapt {@link Object}s to
 * {@link NewModifierPage}s.
 */
abstract public class NewModifierPageAdapter extends AdapterImpl implements
		Adapter {

	/**
	 * @return a {@link NewModifierPage}
	 */
	abstract public NewModifierPage createNewModifierPage();

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == NewModifierPageAdapter.class;
	}

} // NewModifierPageAdapter

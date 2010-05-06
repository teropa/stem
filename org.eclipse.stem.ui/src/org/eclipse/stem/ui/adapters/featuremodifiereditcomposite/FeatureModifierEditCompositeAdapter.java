// FeatureModifierEditCompositeAdapter.java
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.ui.wizards.NewModifierPage;
import org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * This class adapts {@link FeatureModifier}s to
 * {@link FeatureModifierEditComposite}s.
 */
abstract public class FeatureModifierEditCompositeAdapter extends AdapterImpl
		implements Adapter {

	/**
	 * @param parent
	 *            the parent {@link Composite}
	 * @param identifiable
	 *            the {@link Identifiable}
	 * @param parentNewModifierPage
	 *            the parent {@link NewModifierPage}
	 * @return the {@link FeatureModifierEditComposite} appropriate for the
	 *         {@link FeatureModifier} be adapted.
	 */
	abstract public FeatureModifierEditComposite createEditComposite(
			Composite parent, EObject target,
			NewModifierPage parentNewModifierPage);

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(final Object type) {
		return type == FeatureModifierEditCompositeAdapter.class;
	}

	/**
	 * @return the {@link FeatureModifier}
	 */
	public FeatureModifier getFeatureModifier() {
		return (FeatureModifier) getTarget();
	} // getFeatureModifier

	/**
	 * This method selects the button that is appropriate for the
	 * {@link FeatureModifier} that is the target. and un-selects all the other
	 * buttons. Thus, if the {@link FeatureModifier} is an instance of
	 * {@link RangeModifier} the <code>rangeButton</code> will be selected. By
	 * default the <code>noneButton</code> is selected.
	 * 
	 * @param noneButton
	 * @param singleValueButton
	 * @param rangeButton
	 * @param sequenceButton
	 */
	public void setSelectedButton(final Button noneButton, final Button singleValueButton,
			final Button rangeButton, final Button sequenceButton) {
		noneButton.setSelection(true);
		singleValueButton.setSelection(false);
		rangeButton.setSelection(false);
		sequenceButton.setSelection(false);
	} // setSelectedButton

} // FeatureModifierEditCompositeAdapter

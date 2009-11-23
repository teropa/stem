// NOPFeatureModifierEditCompositeAdapter.java
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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.ui.wizards.NewModifierPage;
import org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * This class is a {@link FeatureModifierEditCompositeAdapter} for
 * {@link org.eclipse.stem.core.modifier.NOPModifier}s.
 */
public class NOPFeatureModifierEditCompositeAdapter extends
		FeatureModifierEditCompositeAdapter {

	/**
	 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.stem.core.common.Identifiable,
	 *      org.eclipse.stem.ui.wizards.NewModifierPage)
	 */
	@Override
	public FeatureModifierEditComposite createEditComposite(
			final Composite parent,
			@SuppressWarnings("unused") final Identifiable identifiable,
			final NewModifierPage parentNewModifierPage) {
		final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
				parent, parentNewModifierPage, (FeatureModifier) getTarget()) {
			@Override
			protected boolean validate() {
				return true;
			}
		};
		retValue.setLayout(new RowLayout());

		final Label label = new Label(retValue, SWT.NONE);
		label.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		label.setText(getFeatureModifier().getTarget().eGet(
				getFeatureModifier().getEStructuralFeature()).toString());

		return retValue;
	} // createEditComposite

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link org.eclipse.stem.core.modifier.STEMTimeNOPModifier}s.
	 * 
	 * @see ExperimentFeatureModifierEditCompositeFactory#createSTEMTimeNOPModifierAdapter()
	 */
	public static class STEMTimeNOPFeatureModifierEditCompositeAdapter extends
			NOPFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
		 *      org.eclipse.stem.core.common.Identifiable,
		 *      org.eclipse.stem.ui.wizards.NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				final Composite parent,
				@SuppressWarnings("unused") final Identifiable identifiable,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					return true;
				}
			};
			retValue.setLayout(new RowLayout());

			final Label label = new Label(retValue, SWT.NONE);
			label.setText(getFeatureModifier().getTarget().eGet(
					getFeatureModifier().getEStructuralFeature()).toString());

			return retValue;
		} // createEditComposite

	} // STEMTimeNOPFeatureModifierEditCompositeAdapter

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link org.eclipse.stem.core.modifier.NOPModifier}s that are numeric like
	 * {@link org.eclipse.stem.core.modifier.IntegerNOPModifier},
	 * {@link org.eclipse.stem.core.modifier.LongNOPModifier} and
	 * {@link org.eclipse.stem.core.modifier.DoubleNOPModifier}.
	 * 
	 * @see ExperimentFeatureModifierEditCompositeFactory#createIntegerNOPModifierAdapter()
	 * @see ExperimentFeatureModifierEditCompositeFactory#createLongNOPModifierAdapter()
	 * @see ExperimentFeatureModifierEditCompositeFactory#createDoubleNOPModifierAdapter()
	 */
	public static class NumericNOPFeatureModifierEditCompositeAdapter extends
			NOPFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
		 *      org.eclipse.stem.core.common.Identifiable,
		 *      org.eclipse.stem.ui.wizards.NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				final Composite parent,
				@SuppressWarnings("unused") final Identifiable identifiable,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					return true;
				}
			};
			retValue.setLayout(new RowLayout());

			final Label toLabel = new Label(retValue, SWT.NONE);
			toLabel.setText(getFeatureModifier().getTarget().eGet(
					getFeatureModifier().getEStructuralFeature()).toString());

			return retValue;
		} // createEditComposite

	} // NumericNOPFeatureModifierEditCompositeAdapter

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link org.eclipse.stem.core.modifier.STEMTimeNOPModifier}s.
	 * 
	 * @see ExperimentFeatureModifierEditCompositeFactory#createSTEMTimeNOPModifierAdapter()
	 */
	public static class StringNOPFeatureModifierEditCompositeAdapter extends
			NOPFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
		 *      org.eclipse.stem.core.common.Identifiable,
		 *      org.eclipse.stem.ui.wizards.NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				final Composite parent,
				@SuppressWarnings("unused") final Identifiable identifiable,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					return true;
				}
			};
			retValue.setLayout(new RowLayout());

			final Label label = new Label(retValue, SWT.NONE);
			label.setText(getFeatureModifier().getTarget().eGet(
					getFeatureModifier().getEStructuralFeature()).toString());

			return retValue;
		} // createEditComposite

	} // StringNOPFeatureModifierEditCompositeAdapter

} // NOPFeatureModifierEditCompositeAdapter

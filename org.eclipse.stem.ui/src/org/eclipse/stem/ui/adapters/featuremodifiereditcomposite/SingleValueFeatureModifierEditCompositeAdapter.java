// RangeFeatureModifierEditCompositeAdapter.java
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.DoubleModifier;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.IntegerModifier;
import org.eclipse.stem.core.modifier.LongModifier;
import org.eclipse.stem.core.modifier.STEMTimeModifier;
import org.eclipse.stem.ui.wizards.NewModifierPage;
import org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a {@link FeatureModifierEditCompositeAdapter} for
 * {@link SingleValueModifier}s.
 */
abstract public class SingleValueFeatureModifierEditCompositeAdapter extends
		FeatureModifierEditCompositeAdapter {

	/**
	 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#setSelectedButton(org.eclipse.swt.widgets.Button,
	 *      org.eclipse.swt.widgets.Button, org.eclipse.swt.widgets.Button)
	 */
	@Override
	public void setSelectedButton(final Button noneButton, final Button singleValueButton,
			final Button rangeButton, final Button sequenceButton) {
		noneButton.setSelection(false);
		singleValueButton.setSelection(true);
		rangeButton.setSelection(false);
		sequenceButton.setSelection(false);
	} // setSelectedButton

	// -------------------------------------------------------------------------

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link SingleValueModifier}s that have a range of numeric values.
	 */
	protected static abstract class NumericSingleValueFeatureModifierEditCompositeAdapter
			extends SingleValueFeatureModifierEditCompositeAdapter {

		private static final int TEXT_WIDTH = 60;

		protected Text valueText;
		
		abstract protected void initializeFeatureModifier(
				EObject target);

		abstract protected String getValueText();

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
		 *      Identifiable, NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				final Composite parent, final EObject target,
				final NewModifierPage parentNewModifierPage) {

			initializeFeatureModifier(target);

			final FeatureModifierEditComposite retValue = getFeatureModifierEditComposite(
					parent, parentNewModifierPage);

			final FormLayout layout = new FormLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			retValue.setLayout(layout);

			valueText = new Text(retValue, SWT.BORDER | SWT.TRAIL);
			valueText.setText(getValueText());
			valueText.setToolTipText("Value");
			valueText.addModifyListener(retValue.getModifyListener());
	
			org.eclipse.swt.layout.FormData formData = null;

			// start
			formData = new FormData();
			formData.width = TEXT_WIDTH;
			formData.left = new FormAttachment(0, 0);
			formData.bottom = new FormAttachment(100, 0);
			valueText.setLayoutData(formData);

			return retValue;
		} // createEditComposite

		/**
		 * @param parent
		 *            the parent composite
		 * @param parentNewModifierPage
		 *            the {@link NewModifierPage} that is the parent to parent
		 * @return a new {@link FeatureModifierEditComposite}
		 */
		protected abstract FeatureModifierEditComposite getFeatureModifierEditComposite(
				Composite parent, NewModifierPage parentNewModifierPage);

	} 

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link IntegerModifier}s.
	 */
	public static class IntegerFeatureModifierEditCompositeAdapter extends
			NumericSingleValueFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#initializeFeatureModifier(Identifiable)
		 */
		@Override
		protected void initializeFeatureModifier(
				@SuppressWarnings("unused") final EObject target) {
			final IntegerModifier modifier = (IntegerModifier) getFeatureModifier();
			modifier.setValue(((Integer) (getFeatureModifier()
					.getTarget().eGet(getFeatureModifier()
					.getEStructuralFeature()))).intValue());
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialEndText()
		 */
		@Override
		protected String getValueText() {
			return Integer
					.toString(((IntegerModifier) getFeatureModifier())
							.getValue());
		}


		/**
		 * 
		 */
		@Override
		protected FeatureModifierEditComposite getFeatureModifierEditComposite(
				final Composite parent,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {

				/**
				 * @see org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite#validate()
				 */
				@Override
				protected boolean validate() {
					boolean retValue = true;

					String message = null;

					int value = 0;
					// Start text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid start value?
							value = Integer.parseInt(valueText.getText());
							((IntegerModifier) featureModifier)
									.setValue(value);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Value not valid";
						} // catch NumberFormatException
					} // if

					// Any error message to report?
					if (message != null) {
						// Yes
						parentNewModifierPage.setErrorMessage(message);
					} // if

					// Everything Ok?
					if (retValue) {
						// Yes
						// Check out the parent then
						retValue = parentNewModifierPage.validatePage();
					} // if

					return retValue;
				} // validate
			};
			return retValue;
		} // getFeatureModifierEditComposite

	} //
	
	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link LongModifier}s.
	 */
	public static class LongFeatureModifierEditCompositeAdapter extends
			NumericSingleValueFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#initializeFeatureModifier(Identifiable)
		 */
		@Override
		protected void initializeFeatureModifier(
				@SuppressWarnings("unused") final EObject target) {
			final LongModifier modifier = (LongModifier) getFeatureModifier();
			modifier.setValue(((Long) (getFeatureModifier()
					.getTarget().eGet(getFeatureModifier()
					.getEStructuralFeature()))).intValue());
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialEndText()
		 */
		@Override
		protected String getValueText() {
			return Long
					.toString(((LongModifier) getFeatureModifier())
							.getValue());
		}


		/**
		 * 
		 */
		@Override
		protected FeatureModifierEditComposite getFeatureModifierEditComposite(
				final Composite parent,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {

				/**
				 * @see org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite#validate()
				 */
				@Override
				protected boolean validate() {
					boolean retValue = true;

					String message = null;

					long value = 0;
					// Start text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid start value?
							value = Long.parseLong(valueText.getText());
							((LongModifier) featureModifier)
									.setValue(value);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Value not valid";
						} // catch NumberFormatException
					} // if

					// Any error message to report?
					if (message != null) {
						// Yes
						parentNewModifierPage.setErrorMessage(message);
					} // if

					// Everything Ok?
					if (retValue) {
						// Yes
						// Check out the parent then
						retValue = parentNewModifierPage.validatePage();
					} // if

					return retValue;
				} // validate
			};
			return retValue;
		} // getFeatureModifierEditComposite

	}
	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link DoubleModifier}s.
	 */
	public static class DoubleFeatureModifierEditCompositeAdapter extends
			NumericSingleValueFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#initializeFeatureModifier(Identifiable)
		 */
		@Override
		protected void initializeFeatureModifier(
				@SuppressWarnings("unused") final EObject target) {
			final DoubleModifier modifier = (DoubleModifier) getFeatureModifier();
			modifier.setValue(((Double) (getFeatureModifier()
					.getTarget().eGet(getFeatureModifier()
					.getEStructuralFeature()))).intValue());
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialEndText()
		 */
		@Override
		protected String getValueText() {
			return Double
					.toString(((DoubleModifier) getFeatureModifier())
							.getValue());
		}


		/**
		 * 
		 */
		@Override
		protected FeatureModifierEditComposite getFeatureModifierEditComposite(
				final Composite parent,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {

				/**
				 * @see org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite#validate()
				 */
				@Override
				protected boolean validate() {
					boolean retValue = true;

					String message = null;

					double value = 0;
					// Start text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid start value?
							value = Double.parseDouble(valueText.getText());
							((DoubleModifier) featureModifier)
									.setValue(value);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Value not valid";
						} // catch NumberFormatException
					} // if

					// Any error message to report?
					if (message != null) {
						// Yes
						parentNewModifierPage.setErrorMessage(message);
					} // if

					// Everything Ok?
					if (retValue) {
						// Yes
						// Check out the parent then
						retValue = parentNewModifierPage.validatePage();
					} // if

					return retValue;
				} // validate
			};
			return retValue;
		} // getFeatureModifierEditComposite

	}

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link STEMTimeModifier}s.
	 */
	public static class STEMTimeFeatureModifierEditCompositeAdapter extends
			SingleValueFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
		 *      Identifiable, NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				final Composite parent,
				@SuppressWarnings("unused") final EObject target,
				final NewModifierPage parentNewModifierPage) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					final boolean retValue = parentNewModifierPage
							.validatePage();

					// String message = null;
					return retValue;
				} // validate
			};
			retValue.setLayout(new RowLayout());
			final Label label = new Label(retValue, SWT.NONE);

			final STEMTimeModifier modifier = (STEMTimeModifier) getFeatureModifier();
			modifier.setValue((STEMTime) getFeatureModifier()
					.getTarget().eGet(
							getFeatureModifier().getEStructuralFeature()));
	
			final StringBuilder sb = new StringBuilder(modifier
					.getValue().toString());

			label.setText(sb.toString());
			return retValue;
		} // createEditComposite

	} // STEMTimeFeatureModifierEditCompositeAdapter

} // SingleValueFeatureModifierEditCompositeAdapter

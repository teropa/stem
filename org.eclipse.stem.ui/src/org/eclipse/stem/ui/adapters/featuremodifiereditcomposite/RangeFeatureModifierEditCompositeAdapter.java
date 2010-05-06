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
import org.eclipse.stem.core.modifier.DoubleRangeModifier;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.IntegerRangeModifier;
import org.eclipse.stem.core.modifier.LongRangeModifier;
import org.eclipse.stem.core.modifier.STEMTimeRangeModifier;
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
 * {@link org.eclipse.stem.core.modifier.RangeModifier}s.
 */
abstract public class RangeFeatureModifierEditCompositeAdapter extends
		FeatureModifierEditCompositeAdapter {

	/**
	 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#setSelectedButton(org.eclipse.swt.widgets.Button,
	 *      org.eclipse.swt.widgets.Button, org.eclipse.swt.widgets.Button)
	 */
	@Override
	public void setSelectedButton(final Button noneButton, final Button singleValueButton,
			final Button rangeButton, final Button sequenceButton) {
		noneButton.setSelection(false);
		singleValueButton.setSelection(false);
		rangeButton.setSelection(true);
		sequenceButton.setSelection(false);
	} // setSelectedButton

	// -------------------------------------------------------------------------

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link RangeModifier}s that have a range of numeric values.
	 */
	protected static abstract class NumericRangeFeatureModifierEditCompositeAdapter
			extends RangeFeatureModifierEditCompositeAdapter {

		private static final int TEXT_WIDTH = 30;

		protected Text startText;
		protected Text endText;
		protected Text incText;

		abstract protected void initializeFeatureModifier(
				EObject target);

		abstract protected String getInitialStartText();

		abstract protected String getInitialEndText();

		abstract protected String getInitialIncrementText();

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

			startText = new Text(retValue, SWT.BORDER | SWT.TRAIL);
			startText.setText(getInitialStartText());
			startText.setToolTipText("Starting value");
			startText.addModifyListener(retValue.getModifyListener());
			final Label toLabel = new Label(retValue, SWT.NONE);
			toLabel.setText(" to ");

			endText = new Text(retValue, SWT.BORDER | SWT.TRAIL);
			endText.setText(getInitialEndText());
			endText.setToolTipText("Ending value");
			endText.addModifyListener(retValue.getModifyListener());

			final Label byLabel = new Label(retValue, SWT.NONE);
			byLabel.setText(" by ");

			incText = new Text(retValue, SWT.BORDER | SWT.TRAIL);
			incText.setText(getInitialIncrementText());
			incText.setToolTipText("Increment");
			incText.addModifyListener(retValue.getModifyListener());

			org.eclipse.swt.layout.FormData formData = null;

			// start
			formData = new FormData();
			formData.width = TEXT_WIDTH;
			formData.left = new FormAttachment(0, 0);
			formData.bottom = new FormAttachment(100, 0);
			startText.setLayoutData(formData);

			// "to"
			formData = new FormData();
			formData.left = new FormAttachment(startText, 0, SWT.RIGHT);
			formData.bottom = new FormAttachment(startText, 0, SWT.BOTTOM);
			toLabel.setLayoutData(formData);

			// end
			formData = new FormData();
			formData.width = TEXT_WIDTH;
			formData.left = new FormAttachment(toLabel, 0, SWT.RIGHT);
			formData.bottom = new FormAttachment(toLabel, 0, SWT.BOTTOM);
			endText.setLayoutData(formData);

			// "by"
			formData = new FormData();
			formData.left = new FormAttachment(endText, 0, SWT.RIGHT);
			formData.bottom = new FormAttachment(endText, 0, SWT.BOTTOM);
			byLabel.setLayoutData(formData);

			// inc
			formData = new FormData();
			formData.width = TEXT_WIDTH;
			formData.left = new FormAttachment(byLabel, 0, SWT.RIGHT);
			formData.right = new FormAttachment(100, 0);
			formData.bottom = new FormAttachment(byLabel, 0, SWT.BOTTOM);
			incText.setLayoutData(formData);

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

	} // NumericRangeFeatureModifierEditCompositeAdapter

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link IntegerRangeModifier}s.
	 */
	public static class IntegerRangeFeatureModifierEditCompositeAdapter extends
			NumericRangeFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#initializeFeatureModifier(Identifiable)
		 */
		@Override
		protected void initializeFeatureModifier(
				@SuppressWarnings("unused") final EObject target) {
			final IntegerRangeModifier rangeModifier = (IntegerRangeModifier) getFeatureModifier();
			rangeModifier.setStartValue(((Integer) (getFeatureModifier()
					.getTarget().eGet(getFeatureModifier()
					.getEStructuralFeature()))).intValue());
			rangeModifier.setEndValue(rangeModifier.getStartValue());
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialEndText()
		 */
		@Override
		protected String getInitialEndText() {
			return Integer
					.toString(((IntegerRangeModifier) getFeatureModifier())
							.getEndValue());
		}

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialIncrementText()
		 */
		@Override
		protected String getInitialIncrementText() {
			return Integer
					.toString(((IntegerRangeModifier) getFeatureModifier())
							.getIncrement());
		}

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialStartText()
		 */
		@Override
		protected String getInitialStartText() {
			return Integer
					.toString(((IntegerRangeModifier) getFeatureModifier())
							.getStartValue());
		} // getInitialStartText

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getFeatureModifierEditComposite(Composite,
		 *      NewModifierPage)
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

					int startValue = 0;
					int endValue = 0;
					int incValue = 0;

					// Start text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid start value?
							startValue = Integer.parseInt(startText.getText());
							((IntegerRangeModifier) featureModifier)
									.setStartValue(startValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Start value not valid";
						} // catch NumberFormatException
					} // if

					// End text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid end value?
							endValue = Integer.parseInt(endText.getText());
							((IntegerRangeModifier) featureModifier)
									.setEndValue(endValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "End value not valid";
						} // catch NumberFormatException
					} // if

					// Inc text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid inc value?
							incValue = Integer.parseInt(incText.getText());
							((IntegerRangeModifier) featureModifier)
									.setIncrement(incValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Increment value not valid";
						} // catch NumberFormatException
					} // if

					// Consistent
					// Still valid?
					if (retValue) {
						// Yes
						// Are the relative values consistent?
						// if (!(startValue <= endValue && incValue >= 0L)) {
						if (startValue <= endValue && incValue < 0L) {
							// No
							retValue = false;
							message = "If the start is <= the end, then the increment cannont be < 0.0";
						} // if
						else if (startValue > endValue && incValue >= 0L) {
							// No
							retValue = false;
							message = "If the start is > the end, then the increment cannont be >= 0.0";
						} // if
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

	} // IntegerRangeFeatureModifierEditCompositeAdapter

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link IntegerRangeModifier}s.
	 */
	public static class LongRangeFeatureModifierEditCompositeAdapter extends
			NumericRangeFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#initializeFeatureModifier(Identifiable)
		 */
		@Override
		protected void initializeFeatureModifier(
				@SuppressWarnings("unused") final EObject target) {
			final LongRangeModifier rangeModifier = (LongRangeModifier) getFeatureModifier();
			rangeModifier.setStartValue(((Long) (getFeatureModifier()
					.getTarget().eGet(getFeatureModifier()
					.getEStructuralFeature()))).longValue());
			rangeModifier.setEndValue(rangeModifier.getStartValue());
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialEndText()
		 */
		@Override
		protected String getInitialEndText() {
			return Long.toString(((LongRangeModifier) getFeatureModifier())
					.getEndValue());
		}

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialIncrementText()
		 */
		@Override
		protected String getInitialIncrementText() {
			return Long.toString(((LongRangeModifier) getFeatureModifier())
					.getIncrement());
		}

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialStartText()
		 */
		@Override
		protected String getInitialStartText() {
			return Long.toString(((LongRangeModifier) getFeatureModifier())
					.getStartValue());
		} // getInitialStartText

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getFeatureModifierEditComposite(org.eclipse.swt.widgets.Composite,
		 *      org.eclipse.stem.ui.wizards.NewModifierPage)
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

					long startValue = 0L;
					long endValue = 0L;
					long incValue = 0L;

					// Start text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid start value?
							startValue = Long.parseLong(startText.getText());
							((LongRangeModifier) featureModifier)
									.setStartValue(startValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Start value not valid";
						} // catch NumberFormatException
					} // if

					// End text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid end value?
							endValue = Long.parseLong(endText.getText());
							((LongRangeModifier) featureModifier)
									.setEndValue(endValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "End value not valid";
						} // catch NumberFormatException
					} // if

					// Inc text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid inc value?
							incValue = Long.parseLong(incText.getText());
							((LongRangeModifier) featureModifier)
									.setIncrement(incValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Increment value not valid";
						} // catch NumberFormatException
					} // if

					// Consistent
					// Still valid?
					if (retValue) {
						// Yes
						// Are the relative values consistent?
						// if (!(startValue <= endValue && incValue >= 0L)) {
						if (startValue <= endValue && incValue < 0L) {
							// No
							retValue = false;
							message = "If the start is <= the end, then the increment cannont be < 0.0";
						} // if
						else if (startValue > endValue && incValue >= 0L) {
							// No
							retValue = false;
							message = "If the start is > the end, then the increment cannont be >= 0.0";
						} // if
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

	} // LongRangeFeatureModifierEditCompositeAdapter

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link DoubleRangeModifier}s.
	 */
	public static class DoubleRangeFeatureModifierEditCompositeAdapter extends
			NumericRangeFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#initializeFeatureModifier(Identifiable)
		 */
		@Override
		protected void initializeFeatureModifier(
				@SuppressWarnings("unused") final EObject target) {
			final DoubleRangeModifier rangeModifier = (DoubleRangeModifier) getFeatureModifier();
			rangeModifier.setStartValue(((Double) (getFeatureModifier()
					.getTarget().eGet(getFeatureModifier()
					.getEStructuralFeature()))).doubleValue());
			rangeModifier.setEndValue(rangeModifier.getStartValue());
			// rangeModifier.setIncrement(new Double(0.0));
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialEndText()
		 */
		@Override
		protected String getInitialEndText() {
			return Double.toString(((DoubleRangeModifier) getFeatureModifier())
					.getEndValue());
		}

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialIncrementText()
		 */
		@Override
		protected String getInitialIncrementText() {
			return Double.toString(((DoubleRangeModifier) getFeatureModifier())
					.getIncrement());
		}

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getInitialStartText()
		 */
		@Override
		protected String getInitialStartText() {
			return Double.toString(((DoubleRangeModifier) getFeatureModifier())
					.getStartValue());
		} // getInitialStartText

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.NumericRangeFeatureModifierEditCompositeAdapter#getFeatureModifierEditComposite(Composite,
		 *      NewModifierPage)
		 */
		@Override
		protected FeatureModifierEditComposite getFeatureModifierEditComposite(
				final Composite parent,
				final NewModifierPage parentNewModifierPage) {

			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					boolean retValue = true;

					String message = null;
					double startValue = 0.0;
					double endValue = 0.0;
					double incValue = 0.0;

					// Start text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid start value?
							startValue = Double
									.parseDouble(startText.getText());
							((DoubleRangeModifier) featureModifier)
									.setStartValue(startValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Start value not valid";
						} // catch NumberFormatException
					} // if

					// End text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid end value?
							endValue = Double.parseDouble(endText.getText());
							((DoubleRangeModifier) featureModifier)
									.setEndValue(endValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "End value not valid";
						} // catch NumberFormatException
					} // if

					// Inc text
					// Still valid?
					if (retValue) {
						// Yes
						try {
							// Valid inc value?
							incValue = Double.parseDouble(incText.getText());
							((DoubleRangeModifier) featureModifier)
									.setIncrement(incValue);
						} catch (final NumberFormatException e) {
							retValue = false;
							message = "Increment value not valid";
						} // catch NumberFormatException
					} // if

					// Consistent
					// Still valid?
					if (retValue) {
						// Yes
						// Are the relative values consistent?
						// if (!(startValue <= endValue && incValue >= 0.0)) {
						if (startValue <= endValue && incValue < 0.0) {
							// No
							retValue = false;
							message = "If the start is <= the end, then the increment cannont be < 0.0";
						} // if
						else if (startValue > endValue && incValue >= 0.0) {
							// No
							retValue = false;
							message = "If the start is > the end, then the increment cannont be >= 0.0";
						} // if
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

	} // DoubleRangeFeatureModifierEditCompositeAdapter

	/**
	 * This class is a {@link FeatureModifierEditCompositeAdapter} for
	 * {@link STEMTimeRangeModifier}s.
	 */
	public static class STEMTimeRangeFeatureModifierEditCompositeAdapter extends
			RangeFeatureModifierEditCompositeAdapter {

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

			final STEMTimeRangeModifier rangeModifier = (STEMTimeRangeModifier) getFeatureModifier();
			rangeModifier.setStartValue((STEMTime) getFeatureModifier()
					.getTarget().eGet(
							getFeatureModifier().getEStructuralFeature()));
			rangeModifier.setEndValue(rangeModifier.getStartValue());
			final StringBuilder sb = new StringBuilder(rangeModifier
					.getStartValue().toString());
			sb.append(" to ");
			sb.append(rangeModifier.getEndValue().toString());
			sb.append(" by ");
			sb.append(rangeModifier.getIncrement());

			label.setText(sb.toString());
			return retValue;
		} // createEditComposite

	} // STEMTimeRangeFeatureModifierEditCompositeAdapter

} // RangeFeatureModifierEditCompositeAdapter

// SequenceFeatureModifierEditCompositeAdapter.java
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
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.modifier.DoubleSequenceModifier;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.IntegerSequenceModifier;
import org.eclipse.stem.core.modifier.LongSequenceModifier;
import org.eclipse.stem.core.modifier.STEMTimeSequenceModifier;
import org.eclipse.stem.core.modifier.SequenceModifier;
import org.eclipse.stem.ui.wizards.NewModifierPage;
import org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This class is a {@link FeatureModifierEditCompositeAdapter} for
 * {@link SequenceModifier}s.
 */
abstract public class SequenceFeatureModifierEditCompositeAdapter extends
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
		rangeButton.setSelection(false);
		sequenceButton.setSelection(true);
	} // setSelectedButton

	/**
	 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
	 *      Identifiable, NewModifierPage)
	 */
	@Override
	abstract public FeatureModifierEditComposite createEditComposite(
			final Composite parent, final Identifiable identifiable,
			final NewModifierPage parentNewModifierPage);

	abstract protected static class NumericSequenceFeatureModifierEditCompositeAdapter
			extends SequenceFeatureModifierEditCompositeAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.SequenceFeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite,
		 *      org.eclipse.stem.core.common.Identifiable,
		 *      org.eclipse.stem.ui.wizards.NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				Composite parent, Identifiable identifiable,
				NewModifierPage parentNewModifierPage) {
			initializeFeatureModifier(identifiable);

			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					// TODO createEditComposite.validate()
					return true;
				}
			};

			retValue.setLayout(new RowLayout());
			final Label label = new Label(retValue, SWT.BORDER);

			label.setText(getSequenceSummaryText());

			final Button editButton = new Button(retValue, SWT.PUSH);
			editButton.setText("Edit");
			editButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					// TODO implement widgetSelected
				}
			});
			return retValue;
		} // createEditComposite

		/**
		 * @param identifiable
		 */
		abstract protected void initializeFeatureModifier(
				Identifiable identifiable);

		/**
		 * @return
		 */
		abstract protected String getSequenceSummaryText();

	} // NumericSequenceFeatureModifierEditCompositeAdapter

	protected static class IntegerSequenceFeatureModifierEditCompositeAdapter
			extends NumericSequenceFeatureModifierEditCompositeAdapter {

		@Override
		protected void initializeFeatureModifier(Identifiable identifiable) {
			final IntegerSequenceModifier sequenceModifier = (IntegerSequenceModifier) getFeatureModifier();
			sequenceModifier.getSequence().add(
					((Integer) (identifiable.eGet(getFeatureModifier()
							.getEStructuralFeature()))));
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.SequenceFeatureModifierEditCompositeAdapter.NumericSequenceFeatureModifierEditCompositeAdapter#getSequenceSummaryText()
		 */
		@Override
		protected String getSequenceSummaryText() {
			final IntegerSequenceModifier sequenceModifier = (IntegerSequenceModifier) getFeatureModifier();
			final StringBuilder sb = new StringBuilder();
			int i = sequenceModifier.getSequenceSize();
			for (Integer integer : sequenceModifier.getSequence()) {
				sb.append(integer.toString());
				sb.append(--i > 0 ? ", " : "");
			} // for each
			return sb.toString();
		} // getSequenceSummaryText

	} // IntegerSequenceFeatureModifierEditCompositeAdapter

	protected static class DoubleSequenceFeatureModifierEditCompositeAdapter
			extends NumericSequenceFeatureModifierEditCompositeAdapter {

		@Override
		protected void initializeFeatureModifier(Identifiable identifiable) {
			final DoubleSequenceModifier sequenceModifier = (DoubleSequenceModifier) getFeatureModifier();
			sequenceModifier.getSequence().add(
					((Double) (identifiable.eGet(getFeatureModifier()
							.getEStructuralFeature()))));
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.SequenceFeatureModifierEditCompositeAdapter.NumericSequenceFeatureModifierEditCompositeAdapter#getSequenceSummaryText()
		 */
		@Override
		protected String getSequenceSummaryText() {
			final DoubleSequenceModifier sequenceModifier = (DoubleSequenceModifier) getFeatureModifier();
			final StringBuilder sb = new StringBuilder();
			int i = sequenceModifier.getSequenceSize();
			for (Double db : sequenceModifier.getSequence()) {
				sb.append(db.toString());
				sb.append(--i > 0 ? ", " : "");
			} // for each
			return sb.toString();
		} // getSequenceSummaryText

	} // DoubleSequenceFeatureModifierEditCompositeAdapter

	protected static class LongSequenceFeatureModifierEditCompositeAdapter
			extends NumericSequenceFeatureModifierEditCompositeAdapter {

		@Override
		protected void initializeFeatureModifier(Identifiable identifiable) {
			final LongSequenceModifier sequenceModifier = (LongSequenceModifier) getFeatureModifier();
			sequenceModifier.getSequence().add(
					((Long) (identifiable.eGet(getFeatureModifier()
							.getEStructuralFeature()))));
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.SequenceFeatureModifierEditCompositeAdapter.NumericSequenceFeatureModifierEditCompositeAdapter#getSequenceSummaryText()
		 */
		@Override
		protected String getSequenceSummaryText() {
			final LongSequenceModifier sequenceModifier = (LongSequenceModifier) getFeatureModifier();
			final StringBuilder sb = new StringBuilder();
			int i = sequenceModifier.getSequenceSize();
			for (Long lng : sequenceModifier.getSequence()) {
				sb.append(lng.toString());
				sb.append(--i > 0 ? ", " : "");
			} // for each
			return sb.toString();
		} // getSequenceSummaryText
	} // LongSequenceFeatureModifierEditCompositeAdapter

	protected static class STEMTimeSequenceFeatureModifierEditCompositeAdapter
			extends SequenceFeatureModifierEditCompositeAdapter {

		
		
		
		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.SequenceFeatureModifierEditCompositeAdapter#createEditComposite(org.eclipse.swt.widgets.Composite, org.eclipse.stem.core.common.Identifiable, org.eclipse.stem.ui.wizards.NewModifierPage)
		 */
		@Override
		public FeatureModifierEditComposite createEditComposite(
				Composite parent, Identifiable identifiable,
				NewModifierPage parentNewModifierPage) {
			initializeFeatureModifier(identifiable);

			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage,
					(FeatureModifier) getTarget()) {
				@Override
				protected boolean validate() {
					// TODO createEditComposite.validate()
					return true;
				}
			};

			retValue.setLayout(new RowLayout());
			final Label label = new Label(retValue, SWT.BORDER);

			label.setText(getSequenceSummaryText());

			final Button editButton = new Button(retValue, SWT.PUSH);
			editButton.setText("Edit");
			editButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(@SuppressWarnings("unused") SelectionEvent e) {
					// TODO implement widgetSelected
				}
			});
			return retValue;
		} // createEditComposite

		protected void initializeFeatureModifier(Identifiable identifiable) {
			final LongSequenceModifier sequenceModifier = (LongSequenceModifier) getFeatureModifier();
			sequenceModifier.getSequence().add(
					((Long) (identifiable.eGet(getFeatureModifier()
							.getEStructuralFeature()))));
		} // initializeFeatureModifier

		/**
		 * @see org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.SequenceFeatureModifierEditCompositeAdapter.NumericSequenceFeatureModifierEditCompositeAdapter#getSequenceSummaryText()
		 */
		protected String getSequenceSummaryText() {
			final STEMTimeSequenceModifier sequenceModifier = (STEMTimeSequenceModifier) getFeatureModifier();
			final StringBuilder sb = new StringBuilder();
			int i = sequenceModifier.getSequenceSize();
			for (STEMTime time : sequenceModifier.getSequence()) {
				sb.append(time.toString());
				sb.append(--i > 0 ? ", " : "");
			} // for each
			return sb.toString();
		} // getSequenceSummaryText
	} // STEMTimeSequenceFeatureModifierEditCompositeAdapter

} // SequenceFeatureModifierEditCompositeAdapter

// NewSequentialSequencerWizard.java
package org.eclipse.stem.ui.wizards;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.impl.DublinCoreImpl;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.sequencer.RealTimeSequencer;
import org.eclipse.stem.core.sequencer.SequencerFactory;
import org.eclipse.stem.core.sequencer.SequentialSequencer;
import org.eclipse.stem.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class is a Wizard for making new STEM {@link SequentialSequencer}s.
 */
abstract public class NewSequentialSequencerWizard extends NewSequencerWizard {

	abstract protected static class SequentialSequencerPage extends
			SequencerPage {
		
		/**
		 * This is the initial value of the cycle time text field.
		 */
		protected static final String DEFAULT_CYCLE_PERIOD_TIME_VALUE = "1";

		private static final STEMTime.Units DEFAULT_CYCLE_PERIOD_TIME_UNIT = STEMTime.Units.DAY;

		private static final String[] cyclePeriodTimeUnitStringsPlural = {
				Messages.getString("NSequencerWiz.milliseconds"),
				Messages.getString("NSequencerWiz.seconds"),
				Messages.getString("NSequencerWiz.minutes"),
				Messages.getString("NSequencerWiz.hours"),
				Messages.getString("NSequencerWiz.days") };

		private static final String[] cyclePeriodTimeUnitStringsSingular = {
				Messages.getString("NSequencerWiz.millisecond"),
				Messages.getString("NSequencerWiz.second"),
				Messages.getString("NSequencerWiz.minute"),
				Messages.getString("NSequencerWiz.hour"),
				Messages.getString("NSequencerWiz.day") };

		// This is the (simulated) time period between successive simulation
		// cycles.
		private Text cyclePeriodTimeValueField;

		private Combo cyclePeriodTimeComboBox;

		/**
		 * Constructor
		 */
		public SequentialSequencerPage() { 
			super(Messages.getString("NSeqSequencerWiz.page_title"));
			setTitle(Messages.getString("NSeqSequencerWiz.page_title")); //$NON-NLS-1$
			setDescription(Messages
					.getString("NSeqSequencerWiz.page_description")); //$NON-NLS-1$
		} // SequencerPage

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#createSpecificComposite(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Composite createSpecificComposite(final Composite parent) {

			final Composite composite = new Composite(parent, SWT.NONE);

			final GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			composite.setLayout(layout);

			final GridData compositeGridLayoutData = new GridData();
			compositeGridLayoutData.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(compositeGridLayoutData);

			// Cycle Period Time label
			final Label cycleTimeLabel = new Label(composite, SWT.NONE);
			cycleTimeLabel.setText(Messages
					.getString("NSequencerWiz.cycleTime") + ":"); //$NON-NLS-1$ //$NON-NLS-2$
			final GridData cycleTimeLabelLayoutData = new GridData();
			cycleTimeLabelLayoutData.horizontalSpan = 1;
			cycleTimeLabelLayoutData.horizontalAlignment = SWT.LEAD;
			cycleTimeLabel.setLayoutData(cycleTimeLabelLayoutData);

			cyclePeriodTimeValueField = new Text(composite, SWT.BORDER);
			cyclePeriodTimeValueField.setText(DEFAULT_CYCLE_PERIOD_TIME_VALUE);
			final GridData cycleTimeValueLayoutData = new GridData();
			cycleTimeValueLayoutData.horizontalAlignment = GridData.FILL;
			cycleTimeValueLayoutData.grabExcessHorizontalSpace = true;
			cycleTimeValueLayoutData.horizontalSpan = 1;
			cyclePeriodTimeValueField.setLayoutData(cycleTimeValueLayoutData);

			cyclePeriodTimeValueField.addModifyListener(projectValidator);

			cyclePeriodTimeComboBox = new Combo(composite, SWT.DROP_DOWN
					| SWT.READ_ONLY);
			cyclePeriodTimeComboBox.setItems(cyclePeriodTimeUnitStringsPlural);
			cyclePeriodTimeComboBox.select(DEFAULT_CYCLE_PERIOD_TIME_UNIT
					.ordinal());
			final GridData cycleTimeComboBoxLayoutData = new GridData();
			cycleTimeComboBoxLayoutData.horizontalAlignment = SWT.TRAIL;
			cycleTimeComboBoxLayoutData.horizontalSpan = 1;
			cyclePeriodTimeComboBox.setLayoutData(cycleTimeComboBoxLayoutData);

			final Composite sequencerSpecificControl = createSequentialSequencerSpecificComposite(composite);
			final GridData sequencerSpecificControlLayoutData = new GridData();
			sequencerSpecificControlLayoutData.horizontalAlignment = GridData.FILL;
			sequencerSpecificControlLayoutData.grabExcessHorizontalSpace = true;
			sequencerSpecificControlLayoutData.horizontalSpan = 2;
			sequencerSpecificControl
					.setLayoutData(sequencerSpecificControlLayoutData);
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.stem.doc.newsequentialsequencer_contextid");
			return composite;

		} // createSpecificComposite

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#validatePage()
		 */
		@Override
		protected boolean validatePage() {
			boolean retValue = super.validatePage();

			// Cycle value?
			if (retValue) {
				try {
					// Yes
					final int cycleTimeValue = Integer
							.parseInt(cyclePeriodTimeValueField.getText());
					// Is the cycle time non-zero and positive?
					if (cycleTimeValue < 1) {
						// No
						retValue = false;
						setErrorMessage(Messages
								.getString("NSeqSequencerWiz.cycleTimeErr"));
					} // if
				} catch (final NumberFormatException e) {
					retValue = false;
					setErrorMessage(Messages
							.getString("NSeqSequencerWiz.cycleTimeFormatErr"));
				} // catch NumberFormatException
			} // if

			return retValue;
		} // validatePage

		/**
		 * @return the duration in milliseconds of one cycle
		 */
		protected long getCycleDuration() {
			long retValue = 1;
			final String cyclePeriodTimeString = cyclePeriodTimeValueField
					.getText();

			final long cycleDuration = STEMTime.Units.values()[cyclePeriodTimeComboBox
					.getSelectionIndex()].getMilliseconds();

			try {
				final int cycleTimeValue = Integer
						.parseInt(cyclePeriodTimeString);
				retValue = cycleTimeValue * cycleDuration;
			} catch (final Exception e) {
				Activator.logError("NewRealTimeSequentialSequencer", e);
			}
			return retValue;
		} // getCycleDuration

		/**
		 * @return a locale specific string that describes the duration
		 */
		protected String getCycleDurationDescription() {
			final String cyclePeriodTimeString = cyclePeriodTimeValueField
					.getText();
			final StringBuilder sb = new StringBuilder(cyclePeriodTimeString);
			sb.append(" ");
			sb
					.append("1".equals(cyclePeriodTimeString) ? cyclePeriodTimeUnitStringsSingular[cyclePeriodTimeComboBox
							.getSelectionIndex()]
							: cyclePeriodTimeUnitStringsPlural[cyclePeriodTimeComboBox
									.getSelectionIndex()]);
			return sb.toString();
		} // getCycleDurationDescription

		/**
		 * @param parent
		 * @return TODO
		 */
		abstract protected Composite createSequentialSequencerSpecificComposite(
				Composite parent);

	} // SequentialSequencerPage

	/**
	 * This class is a {@link NewSequentialSequencerWizard} for creating
	 * {@link SequentialSequencer}s with fixed cycle times.
	 */
	public static class NewFixedSequentialSequencerWizard extends
			NewSequentialSequencerWizard {

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
		 */
		@Override
		protected String getWizardTitle() {
			return Messages.getString("NSeqSequencerWiz.wizard_title"); //$NON-NLS-1$
		} // getWizardTitle

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
		 */
		@Override
		protected NewIdentifiablePage createNewIdentifiablePage() {
			this.setHelpContextId("org.eclipse.stem.doc.newsequentialsequencer_contextid");
			return new FixedSequentialSequencerPage();
		} // createNewIdentifiablePage

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
		 */
		@Override
		protected Identifiable createIdentifiable() {
			final SequentialSequencer retValue = SequencerFactory.eINSTANCE
					.createSequentialSequencer();
			retValue.setDublinCore(newDublinCorePage.createDublinCore());

			final Date startDate = ((FixedSequentialSequencerPage) newIdentifiablePage)
					.getStartDate();
			
			final Date endDate = ((FixedSequentialSequencerPage) newIdentifiablePage)
					.getEndDate();

			try {
				retValue
						.setTimeIncrement(((FixedSequentialSequencerPage) newIdentifiablePage)
								.getCycleDuration());

				final STEMTime startTime = ModelFactory.eINSTANCE
						.createSTEMTime();
				startTime.setTime(startDate);
				
				retValue.setStartTime(startTime);

				// Was an end date specified?
				if (endDate != null) {
					// Yes
					final STEMTime endTime = ModelFactory.eINSTANCE
							.createSTEMTime();
					endTime.setTime(endDate);
					retValue.setEndTime(endTime);
				} // if end date
			} catch (final Exception e) {
				Activator.logError("NewSequentialSequencer", e);
			}
			return retValue;
		} // createSpecificIdentifiable

		/**
		 * This class represents a {@link SequentialSequencerPage} for fixed
		 * dates.
		 */
		protected static class FixedSequentialSequencerPage extends
				SequentialSequencerPage {

			private static final boolean END_DATE_INITIALLY_ENABLED = false;

			// This is the start date of the sequencer
			Button endDateEnabledButton;
			private DateTime startDate;
			DateTime endDate;

			/**
			 * @return the starting {@link Date}
			 */
			public Date getStartDate() {
				final Calendar startCalendar = Calendar.getInstance();
				// use a time of day set to noon so on daylight savings time
				//the actual date changes ok.
				startCalendar.set(startDate.getYear(), startDate.getMonth(),
						startDate.getDay(), 12, 0, 0);
				return startCalendar.getTime();
			} // getStartDate

			/**
			 * @return the ending {@link Date}, or <code>null</code> if no
			 *         end date was specified.
			 */
			public Date getEndDate() {
				Date retValue = null;
				// Is the end date enabled?
				if (endDateEnabledButton.getSelection()) {
					// Yes
					final Calendar endCalendar = Calendar.getInstance();
					// use a time of day set to noon so on daylight savings time
					//the actual date changes ok.
					endCalendar.set(endDate.getYear(), endDate.getMonth(),
							endDate.getDay(), 11, 59, 59);
					retValue = endCalendar.getTime();
				} // if
				return retValue;
			} // getEndDate

			/**
			 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#validatePage()
			 */
			@Override
			protected boolean validatePage() {
				boolean retValue = super.validatePage();

				// Does the super class have any problems?
				if (retValue) {
					// No
					// Is the end date enabled?
					if (endDateEnabledButton.getSelection()) {
						// Yes
						
						// end year before start?
						if (endDate.getYear() < startDate.getYear()) {
							retValue = false;
						} else
						// is same year but month before current month ?
						if ((endDate.getYear() == startDate.getYear()) && (endDate.getMonth() < startDate.getMonth())) {
							// yes - problem
							retValue = false;
						} else
						// is same year and same month bud day before current day ?
						if ((endDate.getYear() == startDate.getYear()) && (endDate.getMonth() == startDate.getMonth()) && (endDate.getDay() <= startDate.getDay())) {
							// yes - problem
							retValue = false;
						}
								
						if(!retValue) setErrorMessage(Messages.getString("NSeqSequencerWiz.endBeforeErr"));
							
					} // if end date
				} // if super page ok
				return retValue;
			} // validatePage

			/**
			 * @see org.eclipse.stem.ui.wizards.NewSequentialSequencerWizard.SequentialSequencerPage#createSequentialSequencerSpecificComposite(org.eclipse.swt.widgets.Composite)
			 */
			@Override
			protected Composite createSequentialSequencerSpecificComposite(
					final Composite parent) {
				final Composite composite = new Composite(parent, SWT.NONE);

				final GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.verticalSpacing = 12;
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				composite.setLayout(layout);

				final GridData compositeGridLayoutData = new GridData();
				compositeGridLayoutData.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(compositeGridLayoutData);

				new Label(composite, SWT.NONE);

				final Label startDateLabel = new Label(composite, SWT.CENTER);
				startDateLabel.setLayoutData(new GridData());
				startDateLabel.setText(Messages
						.getString("NSeqSequencerWiz.startTime")
						+ ":");
				new Label(composite, SWT.NONE);

				startDate = new DateTime(composite, SWT.CALENDAR);
				startDate.setLayoutData(new GridData());
				startDate.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(
							@SuppressWarnings("unused") final SelectionEvent e) {
						setPageComplete(validatePage());
					}
				});
				new Label(composite, SWT.NONE);

				endDateEnabledButton = new Button(composite, SWT.CHECK);
				endDateEnabledButton.setText(Messages
						.getString("NSeqSequencerWiz.endTime")
						+ ":");
				endDateEnabledButton.setLayoutData(new GridData());
				endDateEnabledButton
						.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(
									@SuppressWarnings("unused") final SelectionEvent e) {
								endDate.setEnabled(endDateEnabledButton
										.getSelection());
								setPageComplete(validatePage());
							}
						});
				new Label(composite, SWT.NONE);

				endDate = new DateTime(composite, SWT.CALENDAR);
				endDate.setEnabled(END_DATE_INITIALLY_ENABLED);
				endDate.setLayoutData(new GridData());
				endDate.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(
							@SuppressWarnings("unused") final SelectionEvent e) {
						setPageComplete(validatePage());
					}
				});
				return composite;
			} // createSequentialSequencerSpecificComposite

			/**
			 * @see org.eclipse.stem.ui.wizards.NewSequentialSequencerWizard.SequentialSequencerPage#getDCTitle()
			 */
			@Override
			protected String getDCTitle() {
				// Leave description/title blank
				return "";
/*				String retValue = null;
				final String startDateString = DublinCoreImpl
						.createISO8601DateString(getStartDate());
				final Date endDate = getEndDate();
				final String endDateString = endDate != null ? DublinCoreImpl
						.createISO8601DateString(endDate) : null;

				// Was an end date specified?
				if (endDateString != null && !endDateString.equals("")) {
					// Yes
					retValue = MessageFormat.format(Messages
							.getString("NSeqSequencerWiz.DC_TITLE1"),
							new Object[] { serializationFileNameField.getText() });
				} // if end date
				else {
					// No
					retValue = MessageFormat.format(Messages
							.getString("NSeqSequencerWiz.DC_TITLE2"),
							new Object[] { serializationFileNameField.getText()});
				} // else
				return retValue;
*/
			} // getDCTitle

			/**
			 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
			 */
			@Override
			protected String getDCDescription() {
				String retValue = null;
				final String startDateString = DublinCoreImpl
						.createISO8601DateString(getStartDate());
				final Date endDate = getEndDate();
				final String endDateString = endDate != null ? DublinCoreImpl
						.createISO8601DateString(endDate) : null;

				// Was an end date specified?
				if (endDateString != null && !endDateString.equals("")) {
					// Yes
					retValue = MessageFormat.format(Messages
							.getString("NSeqSequencerWiz.DC_DESCRIPTION1"),
							new Object[] { serializationFileNameField.getText(), startDateString, endDateString,
									getCycleDurationDescription() });
				} // if end date
				else {
					// No
					retValue = MessageFormat.format(Messages
							.getString("NSeqSequencerWiz.DC_DESCRIPTION2"),
							new Object[] { serializationFileNameField.getText(), startDateString,
									getCycleDurationDescription() });
				} // else

				return retValue;
			} // getDCDescription

			/**
			 * @return a string suitable for
			 *         {@link org.eclipse.stem.core.common.DublinCore#setValid(String)}
			 */
			@Override
			protected String getDCValidDateRange() {
				final StringBuilder sb = new StringBuilder("start=");

				sb.append(DublinCoreImpl
						.createISO8601DateString(getStartDate()));

				sb.append(";");

				// End date?
				final Date endDate = getEndDate();
				if (endDate != null) {
					// Yes
					sb.append(" end=");
					sb.append(DublinCoreImpl.createISO8601DateString(endDate));
					sb.append(";");
				} // if
				return sb.toString();
			} // getValidDateRange
		} // FixedSequentialSequencerPage

		/**
		 * This class is a {@link IHandler} for the command that creates a
		 * {@link NewSequentialSequencerWizard}
		 */
		public static class NewSequentialSequencerWizardCommandHandler extends
				AbstractHandler implements IHandler {

			/**
			 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
			 */
			public Object execute(final ExecutionEvent executionEvent)
					throws ExecutionException {
				final IWorkbenchWindow window = HandlerUtil
						.getActiveWorkbenchWindowChecked(executionEvent);
				final NewFixedSequentialSequencerWizard wizard = new NewFixedSequentialSequencerWizard();
				wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
				final WizardDialog wizardDialog = new STEMWizardDialog(window
						.getShell(), wizard);
				wizardDialog.open();
				return null;
			} // execute
		} // NewSequentialSequencerWizardCommandHandler
	} // NewFixedSequentialSequencerWizard

	/**
	 * This class is a Wizard for making new STEM {@link RealTimeSequencer}s.
	 */
	public static class NewRealTimeSequencerWizard extends
			NewSequentialSequencerWizard {

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#getWizardTitle()
		 */
		@Override
		protected String getWizardTitle() {
			return Messages.getString("NRTSequencerWiz.wizard_title"); //$NON-NLS-1$
		} // getWizardTitle

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createNewIdentifiablePage()
		 */
		@Override
		protected NewIdentifiablePage createNewIdentifiablePage() {
			this.setHelpContextId("org.eclipse.stem.doc.newrealtimesequencer_contextid");
			return new RealTimeSequentialSequencerPage();
		} // createNewIdentifiablePage

		/**
		 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard#createIdentifiable()
		 */
		@Override
		protected Identifiable createIdentifiable() {
			final RealTimeSequencer retValue = SequencerFactory.eINSTANCE
					.createRealTimeSequencer();
			retValue.setDublinCore(newDublinCorePage.createDublinCore());
			retValue
					.setTimeIncrement(((RealTimeSequentialSequencerPage) newIdentifiablePage)
							.getCycleDuration());
			return retValue;
		} // createSpecificIdentifiable

		/**
		 * This class represents a {@link SequentialSequencerPage} for a
		 * {@link RealTimeSequencer}s.
		 */
		protected static class RealTimeSequentialSequencerPage extends
				SequentialSequencerPage {

			/**
			 * @see org.eclipse.stem.ui.wizards.NewSequentialSequencerWizard.SequentialSequencerPage#createSequentialSequencerSpecificComposite(org.eclipse.swt.widgets.Composite)
			 */
			@Override
			protected Composite createSequentialSequencerSpecificComposite(
					final Composite parent) {
				final Composite composite = new Composite(parent, SWT.NONE);
				
				return composite;
			} // createSequentialSequencerSpecificComposite

			@Override
			protected Composite createSpecificComposite(final Composite parent) {
				Composite composite = super.createSpecificComposite(parent);
				PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.stem.doc.newrealtimesequencer_contextid");
				return composite;
			}
			/**
			 * @see org.eclipse.stem.ui.wizards.NewSequentialSequencerWizard.SequentialSequencerPage#getDCTitle()
			 */
			@Override
			protected String getDCTitle() {
				return MessageFormat.format(Messages
						.getString("NSRTSequencerWiz.DC_TITLE"),
						new Object[] { getCycleDurationDescription() });
			} // getDCTitle

			/**
			 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
			 */
			@Override
			protected String getDCDescription() {
				return MessageFormat.format(Messages
						.getString("NSRTSequencerWiz.DC_DESCRIPTION1"),
						new Object[] { getCycleDurationDescription() });
			} // getDCDescription

			/**
			 * @see org.eclipse.stem.ui.wizards.NewSequentialSequencerWizard.SequentialSequencerPage#getDCValidDateRange()
			 */
			@Override
			protected String getDCValidDateRange() {
				return "";
			} // getValidDateRange
			
		} // RealTimeSequentialSequencerPage

		/**
		 * This class is a {@link IHandler} for the command that creates a
		 * {@link NewSequentialSequencerWizard}
		 */
		public static class NewRealTimeSequencerWizardCommandHandler extends
				AbstractHandler implements IHandler {

			/**
			 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
			 */
			public Object execute(final ExecutionEvent executionEvent)
					throws ExecutionException {
				final IWorkbenchWindow window = HandlerUtil
						.getActiveWorkbenchWindowChecked(executionEvent);
				final NewRealTimeSequencerWizard wizard = new NewRealTimeSequencerWizard();
				wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
				final WizardDialog wizardDialog = new STEMWizardDialog(window
						.getShell(), wizard);
				wizardDialog.open();
				return null;
			} // execute
		} // NewRealTimeSequencerWizardCommandHandler
	} // NewRealTimeSequencerWizard
} // NewSequentialSequencerWizard

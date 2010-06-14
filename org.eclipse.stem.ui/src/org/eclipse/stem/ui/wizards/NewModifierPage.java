// NewModifierPage.java
package org.eclipse.stem.ui.wizards;

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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.stem.core.common.CommonPackage;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.StaticLabel;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.NOPModifier;
import org.eclipse.stem.core.modifier.RangeModifier;
import org.eclipse.stem.core.modifier.SequenceModifier;
import org.eclipse.stem.core.modifier.SingleValueModifier;
import org.eclipse.stem.ui.adapters.featuremodifier.EStructuralFeatureFeatureModifierAdapterFactory;
import org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierEditCompositeAdapter;
import org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.FeatureModifierFeatureModifierEditCompositeAdapterFactory;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProvider;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapter;
import org.eclipse.stem.ui.adapters.propertystrings.PropertyStringProviderAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;

/**
 * This class is a {@link NewIdentifiablePage} that is customized to contain a
 * list of the {@link EStructuralFeature}s of an {@link Identifiable} that can
 * be modified by a {@link FeatureModifier}. It is extended for each type of
 * {@link Identifiable} which can be modified. Instances of subclasses of this
 * class are created by an composable adapter factory. This approach allows new
 * types of {@link Identifiable}s to be added to the system and have the
 * {@link NewModifierWizard} be able to handle them, complete with NLS
 * translations, etc.
 */
abstract public class NewModifierPage extends NewIdentifiablePage {

	/**
	 * This is the {@link Identifiable} for which the page is creating a
	 * {@link org.eclipse.stem.core.modifier.Modifier}.
	 */
	protected EObject target;

	private final List<FeatureModifierComposite> featureModifierComposites = new ArrayList<FeatureModifierComposite>();

	/**
	 * Constructor
	 * 
	 * @param identifiable
	 *            the {@link Identifiable} for which the page is creating a
	 *            {@link org.eclipse.stem.core.modifier.Modifier}.
	 */
	protected NewModifierPage(final EObject target) {
		super(Messages.getString("NModifierWiz.page_title"));
		setTitle(Messages.getString("NModifierWiz.page_title")); //$NON-NLS-1$
		setDescription(Messages.getString("NModifierWiz.page_description")); //$NON-NLS-1$
		this.target = target;
	} // NewModifierPage

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#createSpecificComposite(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Composite createSpecificComposite(final Composite parent) {
		
		  //Display display = parent.getDisplay();
	      //Color blue = display.getSystemColor(SWT.COLOR_BLUE);
	      
	      final Composite outerComposite = new Composite(parent,SWT.BORDER);
	      outerComposite.setLayout(new FillLayout());
	      
	      // set the minimum width and height of the scrolled content - method 2
	      final ScrolledComposite scrolledComposite = new ScrolledComposite(outerComposite, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
	      scrolledComposite.setExpandHorizontal(true);
	      scrolledComposite.setExpandVertical(true);
	      final Composite innerComposite = new Composite(scrolledComposite, SWT.NONE);
	      scrolledComposite.setContent(innerComposite);
	      //innerComposite.setBackground(blue);
	      GridLayout layout = new GridLayout();
	      layout.numColumns = 2;
	      innerComposite.setLayout(layout);
	      
	      scrolledComposite.setMinSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	      innerComposite.setSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
          innerComposite.layout();
          Point innerSize = innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
          scrolledComposite.setSize(innerSize);
    	  outerComposite.setSize(innerSize);
    	  innerComposite.layout();
          outerComposite.layout();
          parent.layout();
          Label testLabel = new Label(innerComposite, SWT.BORDER);
          testLabel.setText("press to scroll");
	      Button add = new Button (innerComposite, SWT.PUSH);
	      add.setText("force scroll");
	      final int[] index = new int[]{0};
	      add.addListener(SWT.Selection, new Listener() {
	          public void handleEvent(@SuppressWarnings("unused") Event e) {
	              index[0]++;
	              Label emptyLabel = new Label(innerComposite, SWT.NONE);
	              emptyLabel.setText("bottom");
	              // reset size of content so children can be seen - method 1
	              innerComposite.setSize(innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	              innerComposite.layout();
	              
	              // reset the minimum width and height so children can be seen - method 2
	              Point innerSize = innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	              innerSize.y*=3;
	              innerSize.y/=2;
	              scrolledComposite.setMinSize(innerSize);
	              	
	          }
	      });

		// Get the adapter that will provide NLS'd names for the
		// properties of the Identifiable
		final PropertyStringProviderAdapter pspa = (PropertyStringProviderAdapter) PropertyStringProviderAdapterFactory.INSTANCE
				.adapt(target, PropertyStringProvider.class);

		final ComposedAdapterFactory itemProviderFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		final IItemPropertySource propertySource = (IItemPropertySource) itemProviderFactory
				.adapt(target, IItemPropertySource.class);
		final List<IItemPropertyDescriptor> properties = propertySource
				.getPropertyDescriptors(target);

		for (final IItemPropertyDescriptor descriptor : properties) {
			final EStructuralFeature feature = (EStructuralFeature) descriptor
					.getFeature(null);
			// Is this a property that the user specifies?
			if (isUserSpecifiedProperty(feature)) {
				// Yes
				// Label for the name of the property
				final Label label = new Label(innerComposite, SWT.NONE);
				label.setText(pspa.getPropertyName(descriptor));
				// label.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
				GridData gridData1 = new GridData(GridData.BEGINNING);
				gridData1.horizontalAlignment = SWT.BEGINNING;
				gridData1.horizontalIndent = 0;
				label.setLayoutData(gridData1);

				// Composite for the editor
				final FeatureModifierComposite featureModifierComposite = new FeatureModifierComposite(
						innerComposite, target, feature, pspa, descriptor,
						isModifiableProperty(feature), this);
				GridData gridData2 = new GridData(GridData.BEGINNING);
				gridData2.grabExcessHorizontalSpace = true;
				gridData2.horizontalAlignment = SWT.FILL;
				gridData2.horizontalIndent = 0;
				featureModifierComposite.setLayoutData(gridData2);

				featureModifierComposites.add(featureModifierComposite);

			} // if user specified
		} // for each property

		// Any text for the bottom?
		final String bottomText = getBottomText();
		if (bottomText != null) {
			// Yes
			final Label bottomTextLabel = new Label(innerComposite, SWT.NONE);
			bottomTextLabel.setText(bottomText);
			final GridData bottomTextGD = new GridData(GridData.END);
			bottomTextGD.grabExcessHorizontalSpace = true;
			bottomTextGD.horizontalSpan = 2;
			bottomTextLabel.setLayoutData(bottomTextGD);
		} // if
	
		
		// reset the minimum width and height so children can be seen - method 2
		// TODO why does the following not make the scrollbar show up at the start ??
        innerSize = innerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        innerComposite.setSize(innerSize);
        innerComposite.layout();
       // scrolledComposite.setSize(innerSize);
       // innerSize.y*=3;
       // innerSize.y/=2;
        scrolledComposite.setMinSize(innerSize);
        	            
       
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "org.eclipse.stem.doc.newmodifier_contextid");

		return outerComposite;
	} // createSpecificComposite

	/**
	 * @see org.eclipse.stem.ui.wizards.NewIdentifiableWizard.NewIdentifiablePage#getDCDescription()
	 */
	@Override
	protected String getDCDescription() {
		return MessageFormat.format(Messages
				.getString("NModifierWiz.DC_DESCRIPTION"),
				new Object[] { serializationFileNameField.getText() });
	} // getDCDescription

	/**
	 * @param feature
	 *            a {@link EStructuralFeature} of an {@link Identifiable}.
	 * @return <code>true</code> if the {@link EStructuralFeature} represents
	 *         a property that is specified by a user, <code>false</code>
	 *         otherwise.
	 */
	protected boolean isUserSpecifiedProperty(final EStructuralFeature feature) {
		boolean retValue = !feature.getEContainingClass().equals(
				CommonPackage.Literals.DUBLIN_CORE);
		retValue = retValue && !(feature instanceof EReference);
		return retValue;
	} // isUserSpecifiedProperty

	/**
	 * @return a line of text to appear below the properties, or
	 *         <code>null</code> if no text is to appear.
	 */
	protected String getBottomText() {
		return null;
	}

	/**
	 * @param feature
	 *            the {@link EStructuralFeature} to test for modifiability
	 * @return <code>true</code> (Default) if the feature represents a property
	 *         that the user should be able to modify for an
	 *         {@link org.eclipse.stem.core.experiment.Experiment} or a
	 *         {@link org.eclipse.stem.core.trigger.Trigger}.
	 */
	protected boolean isModifiableProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		retValue |= (feature.getEType().equals(EcorePackage.Literals.EINT));
		retValue |= (feature.getEType().equals(EcorePackage.Literals.ELONG));
		retValue |= (feature.getEType().equals(EcorePackage.Literals.EDOUBLE));
		return retValue;
	} // isModifiableProperty

	/**
	 * @return the {@link FeatureModifier}s on the page that the user has
	 *         specified.
	 */
	public final List<FeatureModifier> getFeatureModifiers() {
		final List<FeatureModifier> retValue = new ArrayList<FeatureModifier>();
		for (final FeatureModifierComposite featureModifierComposite : featureModifierComposites) {
			final FeatureModifier featureModifier = featureModifierComposite
					.getFeatureModifier();
			// Is this FeatureModifier something other than a NOP?
			if (!(featureModifier instanceof NOPModifier)) {
				// Yes
				featureModifier.setTarget(target);
				retValue.add(featureModifier);
			} // if
		} // for each FeatureModifierComposite
		return retValue;
	} // getFeatureModifiers

	/**
	 * see org.eclipse.stem.ui.wizards.NewIdentifiablePage#validatePage()
	 */
	@Override
	public boolean validatePage() {
		return super.validatePage();
	} // validatePage

	/**
	 * This class is a {@link Composite} that displays the details of a
	 * {@link FeatureModifier}.
	 */
	protected static class FeatureModifierComposite extends Composite {

		/**
		 * This is a place holder for the current
		 * {@link FeatureModifierEditComposite} to which a reference is
		 * maintained by {@link #editComposite}. When the user selects one of
		 * the radio buttons ({@link #noneButton}, {@link #rangeButton}, or
		 * {@link #sequenceButton}) the child of this {@link Composite} is
		 * changed by {@link #setEditComposite(Composite)}.
		 */
		final Composite editCompositeHolder;

		/**
		 * This is the current {@link FeatureModifierEditComposite} being
		 * displayed to the user and is the child of
		 * {@link #editCompositeHolder}.
		 */
		private FeatureModifierEditComposite editComposite;

		/**
		 * This is the {@link FeatureModifier}, if it exists, created by the
		 * user for the {@link EStructuralFeature} referenced by
		 * {@link #feature}.
		 */
		FeatureModifier featureModifier = null;

		/**
		 * These buttons are grouped together as "radio buttons" and allow the
		 * user to specify which type of {@link FeatureModifier} to create.
		 * Initially, {@link #noneButton} is selected and the
		 * {@link FeatureModifierEditComposite} returned by
		 * {@link #createDefaultEditComposite(Composite, NewModifierPage, Identifiable, EStructuralFeature)}
		 * is displayed, which simply shows the current value of the feature.
		 */
		Button noneButton = null;
		Button singleButton = null;
		Button rangeButton = null;
		Button sequenceButton = null;

		/**
		 * @param parent
		 *            the parent {@link Composite}
		 * @param target
		 *            the {@link EObject} that contains the
		 *            {@link EStructuralFeature}
		 * @param feature
		 *            the feature to be modified
		 * @param psp
		 *            the provider of NLS'd strings to label the properties of
		 *            the {@link Identifiable}
		 * @param descriptor
		 * @param modifiable
		 *            if <code>true</code> then the {@link EStructuralFeature}
		 *            can be modified.
		 * @param parentNewModifierPage
		 *            the {@link NewModifierPage} that contains the parent
		 *            {@link Composite}.
		 */
		public FeatureModifierComposite(final Composite parent,
				final EObject target,
				final EStructuralFeature feature,
				final PropertyStringProvider psp,
				final IItemPropertyDescriptor descriptor,
				final boolean modifiable,
				final NewModifierPage parentNewModifierPage) {
			super(parent, SWT.NONE);
			final FormLayout layout = new FormLayout();
			layout.spacing = 2;
			setLayout(layout);

			// Edit Composite Holder
			editCompositeHolder = new Composite(this, SWT.NONE);
			final FillLayout fillLayout = new FillLayout();
			fillLayout.marginHeight = 0;
			fillLayout.marginWidth = 0;
			editCompositeHolder.setLayout(fillLayout);
			editCompositeHolder.setToolTipText(psp
					.getPropertyToolTip(descriptor));

			// Units Label
			final Label unitLabel = new Label(this, SWT.NONE);
			unitLabel.setText(psp.getPropertyUnits(descriptor));
			
			// Radio button group
			final Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
			group.setText("Select Modifier Type");
			group.setLayout(new RowLayout(SWT.HORIZONTAL));
			group.setEnabled(modifiable);
			noneButton = new Button(group, SWT.RADIO);
			noneButton.setText("None");
			noneButton.setEnabled(modifiable);


			// range button
			singleButton = new Button(group, SWT.RADIO);
			singleButton.setText(Messages.getString("Single.type"));
			singleButton.setEnabled(modifiable);
			
			// range button
			rangeButton = new Button(group, SWT.RADIO);
			rangeButton.setText(Messages.getString("Range.type"));
			rangeButton.setEnabled(modifiable);
			
			// sequence button
			sequenceButton = new Button(group, SWT.RADIO);
			sequenceButton.setText(Messages.getString("Sequence.type"));
			sequenceButton.setEnabled(modifiable);

			final int offset = 10;

			// The left of the editCompositeHolder is attached to the left of
			// the parent composite
			FormData formData = new FormData();
			formData.left = new FormAttachment(0, 0);
			formData.top = new FormAttachment(0, offset);
			editCompositeHolder.setLayoutData(formData);

			// left->holder.right
			// right->group
			formData = new FormData();
			formData.left = new FormAttachment(editCompositeHolder, 0,
					SWT.RIGHT);
			formData.right = new FormAttachment(group, 0, SWT.LEFT);
			formData.bottom = new FormAttachment(editCompositeHolder, -3,
					SWT.BOTTOM);
			unitLabel.setLayoutData(formData);

			// The right of the radio button composite is attached to the right
			// of the parent composite.
			formData = new FormData();
			formData.right = new FormAttachment(100, 0);
			group.setLayoutData(formData);

			// This call takes the feature and adapts it to a modifier that does
			// nothing. When we call setFeatureModifier that modifier is adapted
			// to a FeatureModifierEditComposite (and assigned to
			// editComposite). That composite doesn't allow editing, but,
			// instead, displays a "default" representation of the feature's
			// value. For a String, it would just display the value of the
			// String, for a number it just displays a string representing the
			// value of the number
			setFeatureModifier(EStructuralFeatureFeatureModifierAdapterFactory.INSTANCE
					.adapt(feature, NOPModifier.class));
			switchToFeatureModifier(target, parentNewModifierPage);

			noneButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(
						@SuppressWarnings("unused") final SelectionEvent e) {
					// Put up the default?
					if (noneButton.getSelection()
							&& !(featureModifier instanceof NOPModifier)) {
						// Yes
						final FeatureModifier fm = EStructuralFeatureFeatureModifierAdapterFactory.INSTANCE
						.adapt(feature, NOPModifier.class);
						fm.setTarget(feature);
						setFeatureModifier(fm);
						switchToFeatureModifier(target,
								parentNewModifierPage);
					} // if
				}
			});
			
			singleButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(
						@SuppressWarnings("unused") final SelectionEvent e) {
					// Put up the single value modifier?
					if (singleButton.getSelection()
							&& !(featureModifier instanceof SingleValueModifier)) {
						// Yes
						setFeatureModifier(EStructuralFeatureFeatureModifierAdapterFactory.INSTANCE
								.adapt(feature, SingleValueModifier.class));
						switchToFeatureModifier(target,
								parentNewModifierPage);
						// selectRangeButton();
					} // if
				}
			});
			
			rangeButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(
						@SuppressWarnings("unused") final SelectionEvent e) {
					// Put up the range modifier?
					if (rangeButton.getSelection()
							&& !(featureModifier instanceof RangeModifier)) {
						// Yes
						setFeatureModifier(EStructuralFeatureFeatureModifierAdapterFactory.INSTANCE
								.adapt(feature, RangeModifier.class));
						switchToFeatureModifier(target,
								parentNewModifierPage);
						// selectRangeButton();
					} // if
				}
			});
			sequenceButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(
						@SuppressWarnings("unused") final SelectionEvent e) {
					// Put up the sequence modifier?
					if (sequenceButton.getSelection()
							&& !(featureModifier instanceof SequenceModifier)) {
						// Yes
						setFeatureModifier(EStructuralFeatureFeatureModifierAdapterFactory.INSTANCE
								.adapt(feature, SequenceModifier.class));
						switchToFeatureModifier(target,
								parentNewModifierPage);
						// selectSequenceButton();
					} // if
				}
			});
			
			// The Feature Modifier Composite must have 
			// fixed size to put these in a scroll pane
			setSize(500,150);

		} // FeatureModifierComposite

		void selectNoneButton() {
			noneButton.setSelection(true);
			singleButton.setSelection(false);
			rangeButton.setSelection(false);
			sequenceButton.setSelection(false);
		} // selectNoneButton

		FeatureModifierEditComposite createDefaultEditComposite(
				final Composite parent,
				final NewModifierPage parentNewModifierPage,
				final Identifiable identifiable,
				final EStructuralFeature feature) {
			final FeatureModifierEditComposite retValue = new FeatureModifierEditComposite(
					parent, parentNewModifierPage, null) {
				@Override
				protected boolean validate() {
					return true;
				}
			};
			retValue.setLayout(new GridLayout());
			final Label label = new Label(retValue, SWT.BORDER | SWT.TRAIL);
			label.setText(identifiable.eGet(feature).toString());
			final GridData gridData = new GridData();
			gridData.horizontalAlignment = SWT.END;
			label.setLayoutData(gridData);
			return retValue;
		} // createDefaultEditComposite

		void switchToFeatureModifier(final EObject target,
				final NewModifierPage parentNewModifierPage) {
			// The target of the featureModifier needs to be adjusted here. It
			// would typically be identifiable, but if identifiable is an
			// instance of a StaticNodeLabel or StaticEdgeLabel then the
			// features of the value of the current value feature of the
			// identifiable have been included as features. The problem is that
			// when that happens the target of the FeatureModifier needs to be
			// the label value and not the identifiable.
			// A static label?
			if (target instanceof StaticLabel
					&& (target.eClass() != featureModifier
							.getEStructuralFeature().getEContainingClass())) {
				// Yes
				final StaticLabel staticLabel = (StaticLabel) target;
				final LabelValue lv = (LabelValue) staticLabel
						.eGet(GraphPackage.Literals.LABEL__CURRENT_VALUE);
				featureModifier.setTarget(lv);
			} // if static label
			else {
				featureModifier.setTarget(target);
			}

			final FeatureModifierEditCompositeAdapter fmecAdapter = (FeatureModifierEditCompositeAdapter) FeatureModifierFeatureModifierEditCompositeAdapterFactory.INSTANCE
					.adapt(featureModifier,
							FeatureModifierEditCompositeAdapter.class);
			fmecAdapter.setTarget(featureModifier);
			setEditComposite(fmecAdapter.createEditComposite(
					editCompositeHolder, target, parentNewModifierPage));
			fmecAdapter.setSelectedButton(noneButton, singleButton, rangeButton,
					sequenceButton);
		} // switchToFeatureModifier

		void setEditComposite(final FeatureModifierEditComposite editComposite) {
			// Get rid of the old one?
			if (this.editComposite != null) {
				// Yes
				this.editComposite.dispose();
			} // if
			this.editComposite = editComposite;
			getShell().pack();
			// getShell().layout();
			getShell().layout(true, true);
		} // setEditComposite

		/**
		 * @return the {@link FeatureModifier}, possibly <code>null</code>
		 */
		public final FeatureModifier getFeatureModifier() {
			return featureModifier;
		}

		/**
		 * @param featureModifier
		 *            the {@link FeatureModifier} to set
		 */
		protected final void setFeatureModifier(
				final FeatureModifier featureModifier) {
			this.featureModifier = featureModifier;
		}
	} // FeatureModifierComposite

	/**
	 * This class is a {@link Composite} that allows a user to specify the
	 * details of a {@link FeatureModifier}.
	 */
	abstract public static class FeatureModifierEditComposite extends Composite {

		/**
		 * This is the {@link FeatureModifier} that this {@link Composite} is
		 * editing.
		 */
		protected FeatureModifier featureModifier = null;

		/**
		 * This is the {@link NewModifierPage} that is the ultimate parent of
		 * the parent {@link Composite}
		 */
		protected NewModifierPage parentNewModifierPage;

		protected ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(
					@SuppressWarnings("unused") final ModifyEvent e) {
				parentNewModifierPage.setPageComplete(validate());
			}
		};

		/**
		 * @param parent
		 *            the parent {@link Composite}
		 * @param parentNewModifierPage
		 *            the ultimate parent {@link NewModifierPage} of the parent
		 *            {@link Composite}
		 * @param featureModifier
		 *            the {@link FeatureModifier} being edited.
		 */
		public FeatureModifierEditComposite(final Composite parent,
				final NewModifierPage parentNewModifierPage,
				final FeatureModifier featureModifier) {
			super(parent, SWT.NONE);
			this.parentNewModifierPage = parentNewModifierPage;
			this.featureModifier = featureModifier;
		} // FeatureModifierEditComposite

		/**
		 * @return the {@link FeatureModifier}
		 */
		public final FeatureModifier getFeatureModifier() {
			return featureModifier;
		}

		/**
		 * @return the modifyListener
		 */
		public final ModifyListener getModifyListener() {
			return modifyListener;
		}

		/**
		 * As a side-effect this method sets the error message of the
		 * {@link #parentNewModifierPage} if it returns <code>false</code>.
		 * 
		 * @return <code>true</code> if the
		 *         {@link FeatureModifierEditComposite} is valid.
		 */
		abstract protected boolean validate();

	} // FeatureModifierEditComposite
} // NewModifierPage

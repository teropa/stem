// ExperimentFeatureModifierEditCompositeFactory.java
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
import org.eclipse.stem.core.modifier.util.ModifierAdapterFactory;
import org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.DoubleRangeFeatureModifierEditCompositeAdapter;
import org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.IntegerRangeFeatureModifierEditCompositeAdapter;
import org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.LongRangeFeatureModifierEditCompositeAdapter;
import org.eclipse.stem.ui.adapters.featuremodifiereditcomposite.RangeFeatureModifierEditCompositeAdapter.STEMTimeRangeFeatureModifierEditCompositeAdapter;

/**
 * This class is an {@link org.eclipse.emf.common.notify.AdapterFactory} that
 * adapts {@link org.eclipse.stem.core.modifier.FeatureModifier}s to
 * {@link org.eclipse.stem.ui.wizards.NewModifierPage.FeatureModifierEditComposite}
 * s.
 */
public class ExperimentFeatureModifierEditCompositeFactory extends
		ModifierAdapterFactory {

	/**
	 * Default Constructor.
	 * 
	 * It adds an instance of the this factory to
	 * {@link FeatureModifierFeatureModifierEditCompositeAdapterFactory#INSTANCE}.
	 */
	public ExperimentFeatureModifierEditCompositeFactory() {
		super();
		FeatureModifierFeatureModifierEditCompositeAdapterFactory.INSTANCE
				.addAdapterFactory(this);
	} // IntegerRangeFeatureModifierEditCompositeAdapter

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createNOPModifierAdapter()
	 */
	@Override
	public Adapter createNOPModifierAdapter() {
		return new NOPFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createDoubleNOPModifierAdapter()
	 */
	@Override
	public Adapter createDoubleNOPModifierAdapter() {
		return new NOPFeatureModifierEditCompositeAdapter.NumericNOPFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createDoubleRangeModifierAdapter()
	 */
	@Override
	public Adapter createDoubleRangeModifierAdapter() {
		return new DoubleRangeFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createIntegerNOPModifierAdapter()
	 */
	@Override
	public Adapter createIntegerNOPModifierAdapter() {
		return new NOPFeatureModifierEditCompositeAdapter.NumericNOPFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createIntegerRangeModifierAdapter()
	 */
	@Override
	public Adapter createIntegerRangeModifierAdapter() {
		return new IntegerRangeFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createLongNOPModifierAdapter()
	 */
	@Override
	public Adapter createLongNOPModifierAdapter() {
		return new NOPFeatureModifierEditCompositeAdapter.NumericNOPFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createLongRangeModifierAdapter()
	 */
	@Override
	public Adapter createLongRangeModifierAdapter() {
		return new LongRangeFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createStringNOPModifierAdapter()
	 */
	@Override
	public Adapter createStringNOPModifierAdapter() {
		return new NOPFeatureModifierEditCompositeAdapter.StringNOPFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createDoubleModifierAdapter()
	 */
	@Override
	public Adapter createDoubleModifierAdapter() {
		return new SingleValueFeatureModifierEditCompositeAdapter.DoubleFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createIntegerModifierAdapter()
	 */
	@Override
	public Adapter createIntegerModifierAdapter() {
		return new SingleValueFeatureModifierEditCompositeAdapter.IntegerFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createLongModifierAdapter()
	 */
	@Override
	public Adapter createLongModifierAdapter() {
		return new SingleValueFeatureModifierEditCompositeAdapter.LongFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createSTEMTimeModifierAdapter()
	 */
	@Override
	public Adapter createSTEMTimeModifierAdapter() {
		return new SingleValueFeatureModifierEditCompositeAdapter.STEMTimeFeatureModifierEditCompositeAdapter();
	}
	
	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createDoubleSequenceModifierAdapter()
	 */
	@Override
	public Adapter createDoubleSequenceModifierAdapter() {
		return new SequenceFeatureModifierEditCompositeAdapter.DoubleSequenceFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createIntegerSequenceModifierAdapter()
	 */
	@Override
	public Adapter createIntegerSequenceModifierAdapter() {
		return new SequenceFeatureModifierEditCompositeAdapter.IntegerSequenceFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createLongSequenceModifierAdapter()
	 */
	@Override
	public Adapter createLongSequenceModifierAdapter() {
		return new SequenceFeatureModifierEditCompositeAdapter.LongSequenceFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createSTEMTimeSequenceModifierAdapter()
	 */
	@Override
	public Adapter createSTEMTimeSequenceModifierAdapter() {
		return new SequenceFeatureModifierEditCompositeAdapter.STEMTimeSequenceFeatureModifierEditCompositeAdapter();
	}
	

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createStringSequenceModifierAdapter()
	 */
	@Override
	public Adapter createStringSequenceModifierAdapter() {
		// TODO Auto-generated method stub
		return super.createStringSequenceModifierAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createSTEMTimeNOPModifierAdapter()
	 */
	@Override
	public Adapter createSTEMTimeNOPModifierAdapter() {
		return new NOPFeatureModifierEditCompositeAdapter.STEMTimeNOPFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#createSTEMTimeRangeModifierAdapter()
	 */
	@Override
	public Adapter createSTEMTimeRangeModifierAdapter() {
		return new STEMTimeRangeFeatureModifierEditCompositeAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.modifier.util.ModifierAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(final Object object) {
		return object == FeatureModifierEditCompositeAdapter.class
				|| super.isFactoryForType(object);
	}

} // ExperimentFeatureModifierEditCompositeFactory
